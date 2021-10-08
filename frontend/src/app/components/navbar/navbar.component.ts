import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss'],
})
export class NavbarComponent implements OnInit {
  public miToken: number;
  public userName: string | null;
  public cartImage="/assets/icon/cart_icon.png";
  public logo="/assets/icon/Logo.png";
  public loginIcon="../../../assets/icon/log-in.png"; 
  public logOutIcon="../../../assets/icon/log-out.png"; 
  constructor(private router:Router) {
    
    this.miToken = 0;
    this.userName = "";
  }

  ngOnInit(): void{
    if (localStorage.getItem('personalToken')) {
      this.miToken = +localStorage.getItem('personalToken')!;
    }
    if (localStorage.getItem('userName')) {
      this.userName = localStorage.getItem('userName');
    }
  }
  async Refresh() {
  }
  public logout(): void {
    if (localStorage.getItem('personalToken')) {
      this.Refresh()
        .then(() => localStorage.removeItem('personalToken'))
        .then(() => this.router.navigate(['/login']))
        .catch((err) => { console.log(err) })
    }
  }
}
