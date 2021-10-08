import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';
import { Employees } from '../interfaces/employees';
 
@Injectable({
  providedIn: 'root'
})
export class EmployeesService {
  endpoint = 'http://localhost:3000/employees';
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };
  constructor(private httpClient: HttpClient) { }
  getEmployees(): Observable<Employees[]> {
    return this.httpClient.get<Employees[]>(this.endpoint)
      .pipe(
        tap(Employes => console.log('Employees retrieved!')),
        catchError(this.handleError<Employees[]>('Get user', []))
      );
  }
  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);
      console.log(`${operation} failed: ${error.message}`);
      return of(result as T);
    };
  }  
}
