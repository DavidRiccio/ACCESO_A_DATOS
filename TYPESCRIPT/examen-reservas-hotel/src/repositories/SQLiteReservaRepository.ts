import sqlite3 from "sqlite3";
import { open, Database } from "sqlite";
import { EstadoReserva, Reserva } from "../domain/models";
import { ReservaRepository } from "./ReservaRepository";

export class SQLiteReservaRepository implements ReservaRepository {
  private db: Database<sqlite3.Database, sqlite3.Statement> | null = null;

  constructor(private readonly filename: string) { }

  async init(): Promise<void> {
    this.db = await open({ filename: this.filename, driver: sqlite3.Database });
    await this.db.exec(`
      PRAGMA foreign_keys = ON;
      CREATE TABLE IF NOT EXISTS reservas (
        id TEXT PRIMARY KEY,
        clienteId TEXT NOT NULL,
        habitacionId TEXT NOT NULL,
        fechaEntrada TEXT NOT NULL,
        fechaSalida TEXT NOT NULL,
        estado TEXT NOT NULL
      );
      CREATE INDEX IF NOT EXISTS idx_reservas_habitacion ON reservas(habitacionId);
    `);
  }

  private ensureDb(): Database<sqlite3.Database, sqlite3.Statement> {
    if (!this.db) throw new Error("DB no inicializada. Llama a init() primero.");
    return this.db;
  }


  async create(reserva: Reserva): Promise<void> {
    const db = this.ensureDb();
    await db.run(
      `INSERT INTO reservas (id, clienteId, habitacionId, fechaEntrada, fechaSalida, estado)
       VALUES (?, ?, ?, ?, ?, ?)`,
      reserva.id, reserva.clienteId, reserva.habitacionId, reserva.fechaEntrada, reserva.fechaSalida, reserva.estado
    );
  }

  async findAll(): Promise<Reserva[]> {
    const db = this.ensureDb();
    return await db.all<Reserva[]>("SELECT * FROM reservas");
  }

  async findById(id: string): Promise<Reserva | null> {
    const db = this.ensureDb();
    const row = await db.get<Reserva>("SELECT * FROM reservas WHERE id = ?", id);
    return row || null;
  }

  async cancel(id: string): Promise<boolean> {
    const db = this.ensureDb();
    const result = await db.run(
      "UPDATE reservas SET estado = ? WHERE id = ?",
      EstadoReserva.CANCELADA,
      id
    );
    return (result.changes ?? 0) > 0;
  }

  async upsertMany(reservas: Reserva[]): Promise<void> {
    const db = this.ensureDb();
    await db.run("BEGIN");
    try {
      for (const r of reservas) {
        await db.run(
          `INSERT INTO reservas (id, clienteId, habitacionId, fechaEntrada, fechaSalida, estado)
           VALUES (?, ?, ?, ?, ?, ?)
           ON CONFLICT(id) DO UPDATE SET
             clienteId=excluded.clienteId,
             habitacionId=excluded.habitacionId,
             fechaEntrada=excluded.fechaEntrada,
             fechaSalida=excluded.fechaSalida,
             estado=excluded.estado`,
          r.id, r.clienteId, r.habitacionId, r.fechaEntrada, r.fechaSalida, r.estado
        );
      }
      await db.run("COMMIT");
    } catch (e) {
      await db.run("ROLLBACK");
      throw e;
    }
  }
}

