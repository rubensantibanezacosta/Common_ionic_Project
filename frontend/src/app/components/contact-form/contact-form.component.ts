import { Component, OnInit } from '@angular/core';
import { Contactinfo } from 'src/app/clases/contactinfo';
import { ContactService } from 'src/app/services/contact.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-contact-form',
  templateUrl: './contact-form.component.html',
  styleUrls: ['./contact-form.component.scss'],
})
export class ContactFormComponent implements OnInit {
  contactInfo:Contactinfo=new Contactinfo();
  mailIcon='../../../assets/icon/mail-send-Icon.png';
 
  constructor(public contactService:ContactService) { }

  ngOnInit() {}
public submit(){
  this.contactService.send(this.contactInfo).subscribe((response)=>{
    Swal.fire({
      title: 'Enviando...',
      timer: 1000,
      timerProgressBar: true,
      didOpen: () => {
        Swal.showLoading()
      }
    }).then(() => {
      console.log(response);
      if (response == true) {
        Swal.fire({
          title: 'Email enviado!',
          icon: 'success',
          timer:1500
        })
          .then(() => {
            window.location.reload();
          })
      } 
      else 
      {
        Swal.fire({
          title: 'Error al enviar!',
          timer: 5000,
          icon: 'error',
        })
          .then(() => {
            window.location.reload();
          })
      }
    });
  });
}
}
