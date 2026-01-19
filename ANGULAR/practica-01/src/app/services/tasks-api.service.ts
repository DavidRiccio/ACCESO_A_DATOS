import { inject, Inject, Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { NewTask, Task } from '../models/task.model';
import { LoginComponent } from '../pages/login/login.component';
import { AuthService } from './auth.service';
@Injectable({ providedIn: 'root' })
export class TasksApiService {
  private baseUrl = 'http://localhost:8080/api/v1/tasks';
  private auth = inject(AuthService);

  constructor(private http: HttpClient) { }

  list(): Observable<Task[]> {   
    let headers = new HttpHeaders();
  headers = headers.set('Content-Type', 'application/json; charset=utf-8');
  headers = headers.set('Authorization', this.auth.getToken());
 
    return this.http.get<Task[]>(this.baseUrl, {headers});
  }

  create(data: NewTask): Observable<Task> {
    return this.http.post<Task>(this.baseUrl, data);
  }

  remove(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${id}`);
  }
  update(t: Task): Observable<Task> {
    return this.http.put<Task>(`${this.baseUrl}/${t.id}`, t);
  }
}