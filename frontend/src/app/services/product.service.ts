import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../clases/product';


@Injectable({
  providedIn: 'root'
})
export class ProductService {
  endpoint = 'http://localhost:8080/products';
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };
  constructor(private httpClient: HttpClient) { }
  getProducts(): Observable<Product[]> {
    return this.httpClient.get<Product[]>(this.endpoint)
  }
}
