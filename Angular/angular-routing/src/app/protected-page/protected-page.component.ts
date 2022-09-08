import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-protected-page',
  templateUrl: './protected-page.component.html',
  styleUrls: ['./protected-page.component.css']
})
export class ProtectedPageComponent implements OnInit {

  constructor(private auth: AuthService, private router: Router) { }

  ngOnInit(): void {
  }

  logout(){
    this.auth.logout();
    this.router.navigate([""]);
  }

}
