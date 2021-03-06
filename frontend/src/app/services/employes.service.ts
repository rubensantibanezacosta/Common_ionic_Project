import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employees } from '../interfaces/employees';
 
@Injectable({
  providedIn: 'root'
})
export class EmployeesService {
  endpoint = 'http://localhost:8080/employees';
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };
  constructor(private httpClient: HttpClient) { }
  getEmployees(): Observable<Employees[]> {
    return this.httpClient.get<Employees[]>(this.endpoint)
      
  } 
}
