import { Component, inject } from '@angular/core';
import { FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { TasksApiService } from '../../services/tasks-api.service'; 

@Component({
  selector: 'app-task-new',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './task-new.component.html',
  styleUrl: './task-new.component.css',
})
export class TaskNewComponent {
  private fb = inject(FormBuilder);
  private tasksApi = inject(TasksApiService); 
  private router = inject(Router);

  
  form = this.fb.nonNullable.group({
    title: ['', [Validators.required, Validators.minLength(3)]],
    description: [''],
    completada: [false],
  });

  enviar(): void {
    if (this.form.invalid) {
      this.form.markAllAsTouched();
      return;
    }

    
    const newTask = this.form.getRawValue();

    
    this.tasksApi.create(newTask).subscribe({
      next: () => {
        console.log('Tarea creada con éxito');
        this.router.navigateByUrl('/tareas'); 
      },
      error: (err) => {
        console.error('Error al crear la tarea', err);
        
      }
    });
  }

  cancel() {
    this.router.navigateByUrl('/home');
  }
}