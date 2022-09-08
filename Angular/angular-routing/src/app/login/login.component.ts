import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  email: string = "";
  password: string = "";

  constructor(private auth: AuthService, private router: Router) { }

  ngOnInit(): void {
  }

  login() {
    if(this.auth.login(this.email, this.password)) {
      this.router.navigate(["protected-page"]);
      return;
    }
    alert("Invalid Login");
    this.email = "";
    this.password = "";
  }

}
