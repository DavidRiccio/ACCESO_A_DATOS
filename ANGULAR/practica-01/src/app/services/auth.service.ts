import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private baseUrl = 'http://localhost:8080/api/auth/';
  public token = "";
  constructor(private http: HttpClient) { }

  login(data: { username: string, password: string }): Observable<any> {
    return this.http.post(this.baseUrl + "login", data);
  }


  setToken(response: any) {
    const tokenString = response.token || response;

    if (typeof tokenString === 'string') {
      localStorage.setItem('auth_token', tokenString);
    } else {
      console.error('El token recibido no es un string:', response);
    }
  }

  getToken(): string | null {
    return localStorage.getItem('auth_token');
  }

  logout() {
    localStorage.removeItem('auth_token');
  }

}
