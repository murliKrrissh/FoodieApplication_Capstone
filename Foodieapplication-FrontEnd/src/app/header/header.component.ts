import { Component } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {
    title = "FOODIE  APP"

    email = localStorage.getItem('email');

    isLoggedIn(){
      return localStorage.getItem('email');
    }

}
