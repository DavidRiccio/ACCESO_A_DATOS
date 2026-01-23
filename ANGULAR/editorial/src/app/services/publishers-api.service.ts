import { HttpClient, HttpHeaders } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthService } from './auth.service';
import { NewPublisher, Publisher } from '../models/publisher.model';

@Injectable({
  providedIn: 'root'
})
export class PublishersApiService {

  private baseUrl = 'http://localhost:8080/api/v2/publishers';
  private auth = inject(AuthService);
  private http = inject(HttpClient);

  constructor() { }

  private getAuthHeaders(): HttpHeaders {
    const token = this.auth.getToken();
    return new HttpHeaders({
      'Content-Type': 'application/json; charset=utf-8',
      'Authorization': `Bearer ${token}`
    });
  }

  list(): Observable<Publisher[]> {

    return this.http.get<Publisher[]>(this.baseUrl, { headers: this.getAuthHeaders() });
  }

  create(data: NewPublisher): Observable<Publisher> {
    return this.http.post<Publisher>(this.baseUrl, data, { headers: this.getAuthHeaders() });
  }

  remove(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${id}`, { headers: this.getAuthHeaders() });
  }

  update(t: Publisher): Observable<Publisher> {
    return this.http.put<Publisher>(`${this.baseUrl}/${t.id}`, t, { headers: this.getAuthHeaders() });
  }
}
