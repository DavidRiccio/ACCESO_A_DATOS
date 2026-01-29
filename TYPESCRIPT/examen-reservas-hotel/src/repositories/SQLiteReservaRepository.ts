import sqlite3 from "sqlite3";
import { open, Database } from "sqlite";
import { EstadoReserva, Reserva } from "../domain/models";
import { ReservaRepository } from "./ReservaRepository";

export class SQLiteReservaRepository implements ReservaRepository {
  private db: Database<sqlite3.Database, sqlite3.Statement> | null = null;

  constructor(private readonly filename: string) {}

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
    throw new Error("TODO");
  }

  async findAll(): Promise<Reserva[]> {
    throw new Error("TODO");
  }

  async findById(id: string): Promise<Reserva | null> {
   throw new Error("TODO");
  }

  async cancel(id: string): Promise<boolean> {
    throw new Error("TODO");
  }

  async upsertMany(reservas: Reserva[]): Promise<void> {
throw new Error("TODO");
  }
}
