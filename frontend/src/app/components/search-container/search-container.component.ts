import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/clases/product';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-search-container',
  templateUrl: './search-container.component.html',
  styleUrls: ['./search-container.component.scss'],
})
export class SearchContainerComponent implements OnInit {
  public products: Array<Product>;
  public product:Product;
  public word:string;
searchIcon= '../../../assets/icon/search-icon.png';
  constructor(private productService: ProductService) { }

  ngOnInit() {
    this.loadInfo();
  }


  loadInfo() {
    
      this.productService.getProducts().subscribe((response) => {
        this.products = response;
      })
    
  }
}
