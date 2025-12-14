import { Tarea, IdTarea } from "../../model/Tarea";

// Tipo auxiliar para crear una tarea (excluye el ID, que lo genera la DB)
export type TareaCreacion = Omit<Tarea, "id">;

/**
 * Interfaz que define el contrato de operaciones de acceso a datos (CRUD)
 * para el repositorio de Tareas. Esta interfaz debe ser implementada
 * por TareasSqlite.repo.ts.
 */
export interface ITareasRepository {
    
    /**
     * Asegura que la tabla de tareas existe en la base de datos local.
     * Esto se ejecuta normalmente al inicio de la aplicación.
     */
    init(): Promise<void>;

    /**
     * Lista todas las tareas almacenadas localmente.
     * @returns Una promesa que resuelve con un array de Tareas.
     */
    findAll(): Promise<Tarea[]>;

    /**
     * Busca una tarea local por su identificador.
     * @param id El identificador de la tarea.
     * @returns Una promesa que resuelve con la Tarea o null si no se encuentra.
     */
    findById(id: IdTarea): Promise<Tarea | null>;

    /**
     * Inserta una nueva tarea en la base de datos local.
     * @param nuevaTarea Los datos de la tarea a crear (sin ID).
     * @returns Una promesa que resuelve con la Tarea creada (incluyendo el ID generado).
     */
    create(nuevaTarea: TareaCreacion): Promise<Tarea>;

    /**
     * Actualiza una tarea existente en la base de datos local.
     * @param tarea Los datos completos de la tarea a actualizar (incluyendo el ID).
     * @returns Una promesa que resuelve con la Tarea actualizada.
     */
    update(tarea: Tarea): Promise<Tarea>;

    /**
     * Borra una tarea local por su identificador.
     * @param id El identificador de la tarea a borrar.
     * @returns Una promesa que resuelve cuando la operación ha finalizado.
     */
    delete(id: IdTarea): Promise<void>;

    /**
     * Borra todas las tareas locales. Requerido para la estrategia de sincronización
     * simple (borrar todas las locales y reimportar las remotas).
     */
    deleteAll(): Promise<void>;
}