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

  login(data: {username:string,password:string }): Observable<any> {
    return this.http.post(this.baseUrl + "login",data);
  }

  getToken(){
    return this.token;
  }

  setToken(token:string){
     this.token= token;
  }

}
