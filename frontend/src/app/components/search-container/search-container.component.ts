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
  public product: Product;
  public word: string;
  public categories: Array<string> = [""];
  public subcategories: Array<string> = [""];
  public selectedCategory:string="";
  searchIcon = '../../../assets/icon/search-icon.png';
  constructor(private productService: ProductService) { }

  ngOnInit() {
    this.loadInfo();

  }

  loadInfo() {
    this.productService.getProducts()
    .subscribe((response) => {
      this.products = response;
      this.recognizeCategoriesFromProducts();
      
    })
   
      
        
    
  }
  recognizeCategoriesFromProducts() {
    
    for (let i = 0; i < this.products.length - 1; i++) {
      let categoria: string = this.products[i].categoria;
      let exists: boolean = false;
      
      for (let j = 0; j < this.categories.length - 1; j++) {
        if (categoria == this.categories[j]) {
          
          
          exists = true;
        }
      }
        if (exists != true) {
          this.categories.push(categoria);
    
          
        }
      }
    }
  
  recognizeSubCategoriesByCategory(category: string) {
    this.subcategories=[""];
    let filteredProductsByCategory: Array<Product> = this.products.filter((product) => {
      return product.categoria==category
    })
    
    for (let i = 0; i < filteredProductsByCategory.length - 1; i++) {
      let subcategoria: string = this.products[i].subcategoria;
      console.log(this.products[i]);
      let exists: boolean = false;
      for (let j = 0; j < this.subcategories.length; j++) {
        if (subcategoria === this.subcategories[j]) {
          exists = true;
        }
      }
        if (exists != true) {
          this.subcategories.push(subcategoria);
        }
      }
    }
  
}