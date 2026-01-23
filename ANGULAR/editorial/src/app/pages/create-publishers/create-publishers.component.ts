import { Component, inject } from '@angular/core';
import { FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { PublishersApiService } from '../../services/publishers-api.service';
import { NewPublisher } from '../../models/publisher.model';
@Component({
  selector: 'app-create-publishers',
  imports: [ReactiveFormsModule],
  templateUrl: './create-publishers.component.html',
  styleUrl: './create-publishers.component.css'
})
export class CreatePublishersComponent {
  private fb = inject(FormBuilder);
  private publishersApi = inject(PublishersApiService);
  private router = inject(Router);


  form = this.fb.nonNullable.group({
    name: ['', [Validators.required, Validators.minLength(3)]],
    city: ['', [Validators.required, Validators.minLength(3)]],
  });

  enviar(): void {
    if (this.form.invalid) {
      this.form.markAllAsTouched();
      return;
    }


    const newPublisher = this.form.getRawValue();


    this.publishersApi.create(newPublisher).subscribe({
      next: () => {
        console.log('Publisher añadido con éxito');
        this.router.navigateByUrl('/publishers');
      },
      error: (err) => {
        console.error('Error al crear el publisher', err);

      }
    });
  }
  cancel() {
    this.router.navigateByUrl('/home');
  }
}
