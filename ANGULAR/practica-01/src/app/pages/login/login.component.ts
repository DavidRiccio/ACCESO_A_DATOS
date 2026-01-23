import { Component, inject } from '@angular/core';
import { FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-task-new',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css',
})
export class LoginComponent {
  private fb = inject(FormBuilder);
  private auth = inject(AuthService); 
  private router = inject(Router);
  public token = "";

  
  
  form = this.fb.nonNullable.group({
    username: [''],
    password: [''],
  });

  enviar() :void {
    if (this.form.invalid) {
      this.form.markAllAsTouched();
      console.log("ENVIADO");
      return;
    }
     const data = this.form.getRawValue();

    
    this.auth.login(data).subscribe({
      next: resToken => {
        this.router.navigateByUrl('/tareas'); 
      },
      error: (err) => {
        console.error('Error al login', err);
      }
      

    });
  }

  cancel() {
    this.router.navigateByUrl('/home');
  }
}