import { Component } from '@angular/core';
import { Publisher } from '../../models/publisher.model';
import { PublishersApiService } from '../../services/publishers-api.service';

@Component({
  selector: 'app-publishers',
  imports: [],
  templateUrl: './publishers.component.html',
  styleUrl: './publishers.component.css'
})
export class PublishersComponent {
 publishers: Publisher[] = [];
  cargando = false;
  error: string | null = null;
  constructor(public api: PublishersApiService) {}
    ngOnInit(): void {
    this.cargar();
  }

   cargar(): void {
    this.cargando = true;
    this.error = null;

    this.api.list().subscribe({
      next: (t) => {
        this.publishers = t;
        this.cargando = false;
      },
      error: () => {
        this.error = 'No se pudo cargar la lista de publicistas';
        this.cargando = false;
      },
    });
  }

  borrar(id: number): void {
    this.api.remove(id).subscribe({
      next: () => this.cargar(),
      error: () => (this.error = 'No se pudo borrar el publicista'),
    });
  }
}
