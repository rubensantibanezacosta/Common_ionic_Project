import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { IonicModule } from '@ionic/angular';
import { NavbarComponent } from './navbar/navbar.component';
import { RouterModule } from '@angular/router';
import { SlideshowComponent } from './slideshow/slideshow.component';
import { LoginFormComponent } from './login-form/login-form.component';
import { ButtonComponent } from './button/button.component';





@NgModule({
  declarations: [NavbarComponent,SlideshowComponent, LoginFormComponent, ButtonComponent],
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    RouterModule,
    
  ],
  exports:[NavbarComponent, SlideshowComponent, LoginFormComponent, ButtonComponent]
})
export class ComponentsModule { }
