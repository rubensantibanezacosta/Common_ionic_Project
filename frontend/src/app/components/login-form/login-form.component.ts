import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';
import { User } from '../../clases/user';


@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.scss'],
})
export class LoginFormComponent implements OnInit {
  public user=new User();
  public contenido:string="Entrar";
  public loginIcon="../../../assets/icon/log-in.png"; 

  constructor(private loginService: LoginService,
    private router: Router) { }

  ngOnInit() { }
  public submit(): void {
    this.loginService.login(this.user).subscribe(
      (data: number) => {
        localStorage.setItem('userName', this.user.name);
        localStorage.setItem('personalToken', `${data}`);
        this.router.navigate(['/products']);


      },
      () => {
        console.error("Error al realizar el acceso- login");
      }
    )
  }
}
