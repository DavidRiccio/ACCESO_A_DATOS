"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const tareas_1 = require("../tareas");
describe("Funciones de tareas", () => {
    test("crearTarea crea una tarea no completada", () => {
        const tarea = (0, tareas_1.crearTarea)(1, "Probar función");
        expect(tarea.completada).toBe(false);
        expect(tarea.titulo).toBe("Probar función");
        expect(tarea.id).toBe(1);
    });
    test("completarTarea marca la tarea como completada", () => {
        var _a;
        const tareas = [
            (0, tareas_1.crearTarea)(1, "A"),
            (0, tareas_1.crearTarea)(2, "B"),
        ];
        const resultado = (0, tareas_1.completarTarea)(tareas, 2);
        const tarea2 = resultado.find((t) => t.id === 2);
        expect(tarea2.completada).toBe(true);
        // Verificamos que la otra tarea no se vio afectada
        expect((_a = resultado.find(t => t.id === 1)) === null || _a === void 0 ? void 0 : _a.completada).toBe(false);
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
    test("filtrarTareas filtra por pendientes", () => {
        const tareas = [
            { id: 1, titulo: "A", completada: false },
            { id: 2, titulo: "B", completada: true },
            { id: 3, titulo: "C", completada: false },
        ];
        const pendientes = (0, tareas_1.filtrarTareas)(tareas, "pendientes");
        expect(pendientes).toHaveLength(2);
        expect(pendientes.map(t => t.id)).toEqual([1, 3]);
    });
    test("filtrarTareas devuelve la lista original si el filtro es 'todas'", () => {
        const tareas = [
            { id: 1, titulo: "A", completada: false },
            { id: 2, titulo: "B", completada: true },
        ];
        const todas = (0, tareas_1.filtrarTareas)(tareas, "todas");
        expect(todas).toHaveLength(2);
        expect(todas).toEqual(tareas);
    });
});
