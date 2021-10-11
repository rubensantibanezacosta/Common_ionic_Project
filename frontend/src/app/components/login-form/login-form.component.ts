import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';
import { User } from '../../clases/user';
import Swal from 'sweetalert2';


@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.scss'],
})
export class LoginFormComponent implements OnInit {
  public user = new User();
  public contenido: string = "Entrar";
  public loginIcon = "../../../assets/icon/log-in.png";

  constructor(private loginService: LoginService,
    private router: Router) { }

  ngOnInit() { }
  public submit(): void {
    this.loginService.login(this.user).subscribe(
      (data: String) => {
        Swal.fire({
          title: 'Iniciando Sesión!',
          timer: 1000,
          timerProgressBar: true,
          didOpen: () => {
            Swal.showLoading()

          }
        }).then(() => {
          console.log(data);
          if (data != null) {
            localStorage.setItem('userName', this.user.email);
            localStorage.setItem('personalToken', `${data}`);
            this.router.navigate(['/products']);
            Swal.fire({
              title: 'Sesion iniciada con exito!',
              icon: 'success',
              timer:1000
            })
              .then(() => {
                window.location.reload()
              })
          } 
          else 
          {
            Swal.fire({
              title: 'Error al iniciar sesión!',
              text: 'El usuario o contraseña no existen',
              timer: 5000,
              icon: 'error',
            })
              .then(() => {
                this.router.navigate(["/login"]);
              })
          }
        })
      },
      () => {
        console.error("Error al realizar el acceso- login");
      }
    )
  }
}
