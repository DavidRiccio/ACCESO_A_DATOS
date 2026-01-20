import { inject, Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { NewTask, Task } from '../models/task.model';
import { AuthService } from './auth.service';

@Injectable({ providedIn: 'root' })
export class TasksApiService {
  private baseUrl = 'http://localhost:8080/api/v1/tasks';
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

  list(): Observable<Task[]> {
    return this.http.get<Task[]>(this.baseUrl, { headers: this.getAuthHeaders() });
  }

  create(data: NewTask): Observable<Task> {
    
    return this.http.post<Task>(this.baseUrl, data, { headers: this.getAuthHeaders() });
  }

  remove(id: number): Observable<void> {
    
    return this.http.delete<void>(`${this.baseUrl}/${id}`, { headers: this.getAuthHeaders() });
  }

  update(t: Task): Observable<Task> {
    return this.http.put<Task>(`${this.baseUrl}/${t.id}`, t, { headers: this.getAuthHeaders() });
  }
}