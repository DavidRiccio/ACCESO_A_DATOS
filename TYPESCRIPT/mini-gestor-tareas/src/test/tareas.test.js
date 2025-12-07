"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const tareas_1 = require("../tareas");
describe("Funciones de tareas", () => {
    test("crearTarea crea una tarea no completada", () => {
        const tarea = (0, tareas_1.crearTarea)(1, "Probar función");
        expect(tarea.completada).toBe(false);
        expect(tarea.titulo).toBe("Probar función");
    });
    test("completarTarea marca la tarea como completada", () => {
        const tareas = [
            (0, tareas_1.crearTarea)(1, "A"),
            (0, tareas_1.crearTarea)(2, "B"),
        ];
        const resultado = (0, tareas_1.completarTarea)(tareas, 2);
        const tarea2 = resultado.find((t) => t.id === 2);
        expect(tarea2.completada).toBe(true);
    });
    test("filtrarTareas filtra por completadas", () => {
        const tareas = [
            { id: 1, titulo: "A", completada: false },
            { id: 2, titulo: "B", completada: true },
        ];
        const completadas = (0, tareas_1.filtrarTareas)(tareas, "completadas");
        expect(completadas).toHaveLength(1);
        expect(completadas[0].id).toBe(2);
    });
});
