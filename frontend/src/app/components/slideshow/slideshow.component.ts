import { Component, OnInit } from '@angular/core';
import { Employees } from 'src/app/interfaces/employees';
import { EmployeesService } from 'src/app/services/employes.service';

@Component({
  selector: 'app-slideshow',
  templateUrl: './slideshow.component.html',
  styleUrls: ['./slideshow.component.scss'],
})
export class SlideshowComponent implements OnInit {


  public employees: Array<Employees>;
  constructor(private employeesService: EmployeesService) { }
  rightArrow = "../../../assets/icon/right-arrow.png";
  letfArrow = "../../../assets/icon/left-arrow.png";
  visualizedEmployee: number = 0;
  employeesQuantity: number;
  

  ngOnInit() {
    this.loadInfo();
    setTimeout(()=>{
    const divContainer:HTMLObjectElement=document.querySelector(".carousel-list");
    divContainer.style.transform="scale(1,1)";
    divContainer.style.transitionDelay="0.3s";
    divContainer.style.transition="0.8s"},500);
    

  }

  loadInfo() {
    if (!this.employeesQuantity) {
      this.employeesService.getEmployees().subscribe((response) => {
        this.employees = response;
        this.employeesQuantity = response.length - 1;
        
        
      })
    }
  }
  nextEmployee() {
    if (this.visualizedEmployee < this.employeesQuantity) {
      this.visualizedEmployee++;
    } else {
      this.visualizedEmployee = 0;

    }
  }
  previousEmployee() {
    if (this.visualizedEmployee > 0) {
      this.visualizedEmployee--;
      this.loadInfo();

    } else {
      this.visualizedEmployee = this.employeesQuantity;
      this.loadInfo();

    }
    
  }
  clikedArrow(arrowId:String) {
    const arrow:HTMLObjectElement=document.querySelector(`#${arrowId}`);
    arrow.style.transform="scale(0.8,0.8)";
    const divContainer:HTMLObjectElement=document.querySelector(".carousel-list");
    divContainer.style.opacity="0";
    divContainer.style.transition="0.2s";
    
  }
  unClikedArrow(arrowId:String) {
    const arrow:HTMLObjectElement=document.querySelector(`#${arrowId}`);
    arrow.style.transform="scale(1,1)";
    const divContainer:HTMLObjectElement=document.querySelector(".carousel-list");
    divContainer.style.opacity="1";
    divContainer.style.transition="0.6s";
  }
}



