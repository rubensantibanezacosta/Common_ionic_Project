import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Contactinfo } from '../clases/contactinfo';

@Injectable({
  providedIn: 'root'
})
export class ContactService {
  endpoint = 'http://localhost:8080/contact';
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };
  constructor(private httpClient: HttpClient) { }
  send(contactInfo:Contactinfo): Observable<boolean> {
    return this.httpClient.post<boolean>(this.endpoint,JSON.stringify(contactInfo),this.httpOptions)
  } 
}
