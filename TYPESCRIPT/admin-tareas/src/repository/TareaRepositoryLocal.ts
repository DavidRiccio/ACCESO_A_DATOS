import { Tarea, IdTarea } from "../model/Tarea";
import { getDb } from "../db/db";

export class TareasSqliteRepository {
  private db = getDb();

  init(): void {
    this.db.exec(`
      CREATE TABLE IF NOT EXISTS tareas (
        id INTEGER PRIMARY KEY AUTOINCREMENT,
        titulo TEXT NOT NULL,
        descripcion TEXT,
        completada INTEGER NOT NULL DEFAULT 0
      )
    `);
  }

  findAll(): Tarea[] {
    const rows = this.db.prepare("SELECT * FROM tareas").all();
    return (rows as any[]).map(row => ({
      id: String(row.id),
      titulo: row.titulo,
      descripcion: row.descripcion || undefined,
      completada: row.completada === 1
    }));
  }

  findById(id: IdTarea): Tarea | null {
    const row = this.db.prepare("SELECT * FROM tareas WHERE id = ?").get(id);
    if (!row) return null;
    
    return {
      id: String((row as any).id),
      titulo: (row as any).titulo,
      descripcion: (row as any).descripcion || undefined,
      completada: (row as any).completada === 1
    };
  }

  create(tarea: Omit<Tarea, 'id'>): Tarea {
    const stmt = this.db.prepare(
      "INSERT INTO tareas (titulo, descripcion, completada) VALUES (?, ?, ?)"
    );
    const result = stmt.run(
      tarea.titulo,
      tarea.descripcion || null,
      tarea.completada ? 1 : 0
    );
    
    return {
      id: String(result.lastInsertRowid),
      ...tarea
    };
  }

  update(tarea: Tarea): void {
    this.db.prepare(
      "UPDATE tareas SET titulo = ?, descripcion = ?, completada = ? WHERE id = ?"
    ).run(tarea.titulo, tarea.descripcion || null, tarea.completada ? 1 : 0, tarea.id);
  }

  delete(id: IdTarea): void {
    this.db.prepare("DELETE FROM tareas WHERE id = ?").run(id);
  }

  deleteAll(): void {
    this.db.exec("DELETE FROM tareas");
  }
}
