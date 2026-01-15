import { Task } from "../models";

/**
 * E06 – Intersection + Record
 */

export type AdminTask = Task & { adminOnly: true };

export function makeAdminTask(task: Task): AdminTask {
  // devuelve task + adminOnly=true (sin mutar task original)
  return { ...task, adminOnly: true };
}

export function buildAuthHeaders(token: string): Record<string, string> {
  // { Authorization: "Bearer <token>", "Content-Type": "application/json" } token trim no vacío
  const trimmedToken = token.trim();
  if (trimmedToken === "") {
    throw new Error("Invalid token");
  }

  return {
    Authorization: `Bearer ${trimmedToken}`,
    "Content-Type": "application/json",
  };
}

export function groupByCompleted(tasks: Task[]): Record<"done" | "pending", Task[]> {
  // retorna { done: [...], pending: [...] } (arrays nuevos)
  return tasks.reduce(
    (acc, task) => {
      if (task.completed) {
        acc.done.push(task);
      } else {
        acc.pending.push(task);
      }
      return acc;
    },
    { done: [], pending: [] } as Record<"done" | "pending", Task[]>
  );
}
