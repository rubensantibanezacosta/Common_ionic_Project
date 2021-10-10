import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { User } from '../clases/user';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  endpoint = 'http://localhost:8080/login';
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };
  constructor(private httpClient: HttpClient) { }

  login(user:User): Observable<String> {
    
    return this.httpClient.post<String>(this.endpoint,JSON.stringify(user),this.httpOptions)
  } 
  
}
