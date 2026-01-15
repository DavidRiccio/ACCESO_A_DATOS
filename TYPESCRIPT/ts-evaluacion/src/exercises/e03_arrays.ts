import { Task } from "../models";

/**
 * E03 – Arrays: filter/map/reduce/sort sin mutar original
 */

export function pendingTasks(tasks: Task[]): Task[] {
  // retorna nuevas tareas con completed=false
  return tasks.filter((task) => !task.completed);
}

export function titlesSorted(tasks: Task[]): string[] {
  // devuelve títulos ordenados alfabéticamente (localeCompare), sin mutar tasks
  return tasks.map((task) => task.title).sort((a, b) => a.localeCompare(b));
}

export function completionPercent(tasks: Task[]): number {
  // % completadas 0..100 redondeado; si vacío => 0
  if (tasks.length === 0) {
    return 0;
  }

  return Math.round(
    (tasks.filter((task) => task.completed).length / tasks.length) * 100
  );
}
