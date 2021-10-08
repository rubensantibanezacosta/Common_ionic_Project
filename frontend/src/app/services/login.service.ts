import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { User } from '../interfaces/user';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor() { }

  login(user: User): Observable<number> {
    return of(Math.random() * (1000 - 0));
  }
}
