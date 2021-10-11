import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.page.html',
  styleUrls: ['./contact.page.scss'],
})
export class ContactPage implements OnInit {
  phoneIcon='../../../assets/icon/phone-Icon.png';
  whatsIcon='../../../assets/icon/whatsapp-logo.png';
  constructor() { }

  ngOnInit() {
  }

}
