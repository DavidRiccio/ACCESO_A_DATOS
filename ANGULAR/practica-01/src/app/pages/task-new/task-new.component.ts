import { Component, EventEmitter, inject, Output } from '@angular/core';
import { FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { TasksService } from '../../services/tasks.service';
import { NewTask } from '../../models/task.model';

@Component({
  selector: 'app-task-new',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './task-new.component.html',
  styleUrl: './task-new.component.css',
})
export class TaskNewComponent {
  private fb = inject(FormBuilder);
  private tasks = inject(TasksService);
  private router = inject(Router);

  form = this.fb.nonNullable.group({
    title: this.fb.nonNullable.control('', [Validators.required, Validators.minLength(3)]),
    description: this.fb.nonNullable.control(''),
    completada: this.fb.nonNullable.control(false),
  });

  @Output() crear = new EventEmitter<NewTask>();

  title: string = '';
  description: string = '';
  error: string | null = null;

  enviar(): void {
    const t = this.title.trim();
    if (!t) {
      this.error = 'El título es obligatorio';
      return;
    }
    this.error = null;

    this.crear.emit({
      title: t,
      description: this.description.trim() || undefined,
      completada: false,
    });

    this.title = '';
    this.description = '';
  }

  cancel() {
    this.router.navigateByUrl('/home');
  }
}