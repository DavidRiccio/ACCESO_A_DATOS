import type BetterSqlite3 from "better-sqlite3";
import { ReservaHotel, NuevaReserva, ActualizacionReserva, IdReserva } from "../models";
import { getDb, initDb } from "./db";

export class RepositorioReservasHotelSqlite {
  private db: BetterSqlite3.Database;

  constructor(db?: BetterSqlite3.Database) {
    this.db = db ?? getDb();
    initDb(this.db);
  }
  obtenerTodas(): ReservaHotel[] {
    const rows = this.db.prepare("SELECT * FROM reservas").all();
    return rows.map((r: any) => ({
      ...r,
      confirmada: r.confirmada === 1
    }));
  }

  obtenerPorId(id: IdReserva): ReservaHotel | undefined {
    const row: any = this.db.prepare("SELECT * FROM reservas WHERE id = ?").get(id);
    if (!row) return undefined;
    return {
      ...row,
      confirmada: row.confirmada === 1
    };
  }

  crear(nueva: NuevaReserva): ReservaHotel {
    const stmt = this.db.prepare(`
      INSERT INTO reservas (habitacion, cliente, fechaEntrada, fechaSalida, confirmada, observaciones)
      VALUES (@habitacion, @cliente, @fechaEntrada, @fechaSalida, @confirmada, @observaciones)
    `);

    const resultado = stmt.run({
      ...nueva,
      confirmada: nueva.confirmada ? 1 : 0,
      observaciones: nueva.observaciones ?? null
    });

    return {
      ...nueva,
      id: resultado.lastInsertRowid as number
    };
  }

  actualizar(id: IdReserva, patch: ActualizacionReserva): ReservaHotel | undefined {
    const actual = this.obtenerPorId(id);
    if (!actual) return undefined;

    const stmt = this.db.prepare(`
      UPDATE reservas 
      SET habitacion = COALESCE(@habitacion, habitacion),
          cliente = COALESCE(@cliente, cliente),
          fechaEntrada = COALESCE(@fechaEntrada, fechaEntrada),
          fechaSalida = COALESCE(@fechaSalida, fechaSalida),
          confirmada = COALESCE(@confirmada, confirmada),
          observaciones = COALESCE(@observaciones, observaciones)
      WHERE id = @id
    `);

    stmt.run({
      ...patch,
      id,
      confirmada: patch.confirmada === undefined ? null : (patch.confirmada ? 1 : 0)
    });

    return this.obtenerPorId(id);
  }

  borrar(id: IdReserva): boolean {
    const stmt = this.db.prepare("DELETE FROM reservas WHERE id = ?");
    const resultado = stmt.run(id);
    return resultado.changes > 0;
  }

  borrarTodas(): void {
    this.db.prepare("DELETE FROM reservas").run();
  }
}