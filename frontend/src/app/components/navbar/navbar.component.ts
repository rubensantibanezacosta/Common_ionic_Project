import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';



@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss'],
})
export class NavbarComponent implements OnInit {
  public miToken: number;
  public userName: string | null;
  public cartImage = "/assets/icon/cart_icon.png";
  public logo = "/assets/icon/Logo.png";
  public loginIcon = "../../../assets/icon/log-in.png";
  public logOutIcon = "../../../assets/icon/log-out.png";
  constructor(private router: Router) {

    this.miToken = 0;
    this.userName = "";
  }

  ngOnInit(): void {
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

    let timerInterval;
    Swal.fire({
      title: '¿Estás seguro?',
      text: 'Cerrar sesión',
      icon: 'question',
      confirmButtonText: ' Confirmar',
      showCancelButton: true,
      showCloseButton: true,
    }).then(result => {
      if (result.isConfirmed) {
        if (localStorage.getItem('personalToken')) {
          this.Refresh()
            .then(() => localStorage.removeItem('personalToken'))
            .then(() => this.router.navigate(['/login']))
            .catch((err) => {  Swal.fire(`${err}`) })
            .then(() => {
              Swal.fire({
                title: 'cerrando sesion!',
                timer: 1000,
                timerProgressBar: true,
                didOpen: () => {
                  Swal.showLoading()
                }
              }).then(()=>{
                window.location.reload()
              })
            })
            
        }
      } else if (result.dismiss === Swal.DismissReason.cancel) {
        window.history.back();
      }
    })
  }
}
