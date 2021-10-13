import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/clases/product';
import { ProductGeneralState } from 'src/app/clases/product-general-state';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-search-container',
  templateUrl: './search-container.component.html',
  styleUrls: ['./search-container.component.scss'],
})
export class SearchContainerComponent implements OnInit {
  public products: Array<Product>;
  public productsState: Array<Product>;
  public productsFilteredByCategories: Array<Product>;
  public product: Product;
  public word: string="";
  public categories: Array<string> = ["..."];
  public subcategories: Array<string> = ["..."];
  public selectedCategory: string = "";
  public selectedSubCategory: string = "";
  public categoryForMaintainState: string = "";
  public subCategoryForMaintainState: string="";
  public productGeneralStates: Array<ProductGeneralState> = [];
  public productGeneralState:ProductGeneralState=new ProductGeneralState();



  searchIcon = '../../../assets/icon/search-icon.png';
  constructor(private productService: ProductService) { }

  ngOnInit() {
    !this.products ? this.loadInfo() :
      null;
      
    


  }

  loadInfo() {
    this.productService.getProducts()
      .subscribe((response) => {
        this.products = response;
        this.recognizeCategoriesFromProducts()
        .then(()=>{this.productsState = this.products;})
        .then(()=>{this.buildGeneralState();});
        
      })
  }

  async recognizeCategoriesFromProducts() {
    this.categories = [...(new Set(this.products.map((product) => {
      return product.categoria;
    })))]
    this.categories.push("...");
  }
  recognizeSubCategoriesByCategory(category: string) {
    let filteredProductsByCategory: Array<Product> = this.products.filter((product) => {
      return product.categoria == category
    })
    this.subcategories = [...(new Set(filteredProductsByCategory.map((filteredProductsByCategory) => {
      return filteredProductsByCategory.subcategoria;
    })))]
    this.subcategories.push("...");
    this.filterStateByCategories(category);
    this.buildGeneralState();
    

  }
  async filterStateByCategories(category: string) {
    this.categoryForMaintainState = category;
    if (category != "..."&&category !="") {
      this.productsState = this.products;
      this.productsState = this.productsState.filter((product) => {
        return product.categoria == this.categoryForMaintainState
      })
      
      this.productsFilteredByCategories = this.productsState;

    }
    else {
      this.categoryForMaintainState = "";
      this.productsState = this.products;
      this.productsFilteredByCategories = this.productsState;
    }

  }
  filterStateBySubCategories(subCategory: string) {
    this.subCategoryForMaintainState = subCategory;
    if (subCategory != "..."&&subCategory !="") {
      this.productsState = this.productsFilteredByCategories;
      this.productsState = this.productsState.filter((product) => {
        return product.subcategoria == subCategory
      })
    } else {
      this.subCategoryForMaintainState = "";
      this.productsState=this.products;
      this.filterStateByCategories(this.categoryForMaintainState);
    }
    this.buildGeneralState();
  }
  buildGeneralState() {
    this.productGeneralStates=[];
    for (let i = 0; i < this.categories.length; i++) {
      
      let products: Array<Product> = this.filterByCategories(this.categories[i]);
      let state: ProductGeneralState=new ProductGeneralState();
      state.categoria = this.categories[i];
      state.products = products
      if(state.categoria!="..."){
        this.productGeneralStates.push(state) ;
        
      }
      
    }
  }


  filterByCategories(categoria: string): Product[] {
    return this.productsState.filter((product) => {
      return product.categoria == categoria
    })

  }

  searchProducts(searchValue:string){
    
    if (searchValue&&searchValue!=""){
      this.productsState=this.products;
      this.filterByCategories(this.categoryForMaintainState);
      this.filterStateBySubCategories(this.subCategoryForMaintainState);
      this.productsState=this.productsState.filter(
        (product)=>{
          return product.name.toLowerCase().normalize("NFD").replace(/[\u0300-\u036f]/g, "").includes(searchValue.toLowerCase().normalize("NFD").replace(/[\u0300-\u036f]/g, ""))
          ||product.description.toLowerCase().normalize("NFD").replace(/[\u0300-\u036f]/g, "").includes(searchValue.toLowerCase().normalize("NFD").replace(/[\u0300-\u036f]/g, ""))
          ||product.categoria.toLowerCase().normalize("NFD").replace(/[\u0300-\u036f]/g, "").includes(searchValue.toLowerCase().normalize("NFD").replace(/[\u0300-\u036f]/g, ""))
          ||product.subcategoria.toLowerCase().normalize("NFD").replace(/[\u0300-\u036f]/g, "").includes(searchValue.toLowerCase().normalize("NFD").replace(/[\u0300-\u036f]/g, ""));
        })
    }else{
      this.productsState=this.products;
      this.filterByCategories(this.categoryForMaintainState);
      this.filterStateBySubCategories(this.subCategoryForMaintainState);
    }
    this.buildGeneralState();
  }
}
