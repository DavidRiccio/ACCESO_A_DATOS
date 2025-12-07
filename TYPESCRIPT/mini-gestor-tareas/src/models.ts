export interface Tarea {
    /**
     * Id de la tarea
     */
    id: number;
    /**
     * Tituo de la tarea
     */
    titulo: string;
    /**
     * Descripcion de la tarea
     */
    descripcion?: string;
    /**
     * Estado de la tarea
     */
    completada: boolean;
}

export type IdTarea = number;

export type FiltroTarea = "todas" | "pendientes" | "completadas";