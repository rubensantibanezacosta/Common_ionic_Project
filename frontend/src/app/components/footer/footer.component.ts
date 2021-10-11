import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.scss'],
})
export class FooterComponent implements OnInit {
  linkedinLogo='../../../assets/icon/linkedin-logo.png';
  instragramLogo='../../../assets/icon/instagram-logo.png';
  facebookLogo='../../../assets/icon/facebook-logo.png';
  whatsLogo='../../../assets/icon/whatsapp-logo-white.png';
  Logo='../../../assets/icon/Logo-white.png';
  constructor() { }

  ngOnInit() {}

}
