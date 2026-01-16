import { Component } from '@angular/core';
import { TasksService } from '../../services/tasks.service';
import { Task } from '../../models/task.model';
import { TasksApiService } from '../../services/tasks-api.service';

@Component({
  selector: 'app-tasks',
  standalone: true,
  templateUrl: './tasks.component.html',
  styleUrl: './tasks.component.css',
})
export class TasksComponent {
  tareas: Task[] = [];
  cargando = false;
  error: string | null = null;
  constructor(public api: TasksApiService) {}


  ngOnInit(): void {
    this.cargar();
  }
  cargar(): void {
    this.cargando = true;
    this.error = null;

    this.api.list().subscribe({
      next: (t) => {
        this.tareas = t;
        this.cargando = false;
      },
      error: () => {
        this.error = 'No se pudo cargar la lista de tareas';
        this.cargando = false;
      },
    });
  }
  crear(nueva: Task): void {
    this.api.create(nueva).subscribe({
      next: () => this.cargar(),
      error: () => (this.error = 'No se pudo crear la tarea'),
    });
  }

  toggle(t: Task): void {
    const actualizado: Task = { ...t, completada: !t.completada };
    this.api.update(actualizado).subscribe({
      next: () => this.cargar(),
      error: () => (this.error = 'No se pudo actualizar la tarea'),
    });
  }

  borrar(id: number): void {
    this.api.remove(id).subscribe({
      next: () => this.cargar(),
      error: () => (this.error = 'No se pudo borrar la tarea'),
    });
  }

  trackById(index: number, t: Task): number {
    return t.id;
  }
}