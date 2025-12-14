// src/repositorioTareasSqlite.ts
import { getDb } from "./db";
import { Tarea, IdTarea } from "./models";

export class RepositorioTareasSqlite {

    private db = getDb();

    obtenerTodas(): Tarea[] {
        const tareasQuery = this.db.prepare("SELECT * FROM tareas")
        const tarea = tareasQuery.all();
        const tareas: Tarea[] = tarea.map((raw: { id: number; titulo: any; descripcion: any; completada: number; }) => ({
            id: raw.id as IdTarea,
            titulo: raw.titulo,
            descripcion: raw.descripcion,
            completada: raw.completada === 1,
        }));
        return tareas;
    }

    obtenerPorId(id: IdTarea): Tarea | undefined {
        const tareasQuery = this.db.prepare(
            "SELECT id, titulo, descripcion, completada FROM tareas WHERE id = ?"
        );

        const tareaRaw = tareasQuery.get(id);

        if (!tareaRaw) {
            return undefined;
        }

        const tarea: Tarea = {
            id: tareaRaw.id as IdTarea,
            titulo: tareaRaw.titulo,
            descripcion: tareaRaw.descripcion,
            completada: tareaRaw.completada === 1,
        };

        return tarea;
    }


    crear(titulo: string, descripcion?: string): Tarea {
        const tareaQuery = this.db.prepare("INSERT INTO tareas (titulo, descripcion, completada) VALUES (?,?,0)")
        // 1. INSERT INTO tareas (titulo, descripcion, completada) VALUES (?, ?, 0)
        // 2. Recuperar el id generado (stmt.run().lastInsertRowid)
        // 3. Devolver la tarea completa
        throw new Error("No implementado");
    }

    actualizar(tarea: Tarea): Tarea | undefined {
        // TODO:
        // 1. UPDATE tareas SET titulo = ?, descripcion = ?, completada = ? WHERE id = ?
        // 2. Comprobar cambios (stmt.changes)
        // 3. Si no se actualiza ninguna fila, devolver undefined
        // 4. Si se actualiza, devolver la tarea
        throw new Error("No implementado");
    }

    borrar(id: IdTarea): boolean {
        // TODO:
        // 1. DELETE FROM tareas WHERE id = ?
        // 2. Devolver true si se ha borrado 1 registro, false en otro caso
        throw new Error("No implementado");
    }
}