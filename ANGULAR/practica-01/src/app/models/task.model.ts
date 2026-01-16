export interface Task {
  id: number;
  title: string;
  description?: string;
  completada: boolean;
}

export type NewTask = Omit<Task, 'id'>;