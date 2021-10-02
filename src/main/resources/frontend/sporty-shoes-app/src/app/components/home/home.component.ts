import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { SportyShoesService } from 'src/app/services/sporty-shoes.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {


    isLoggedIn = false;

  constructor(private route: ActivatedRoute,
    private router: Router,
    private sportyShoesService: SportyShoesService) { }

  ngOnInit() {
    this.isLoggedIn = this.sportyShoesService.isUserLoggedIn();
    console.log('menu ->' + this.isLoggedIn);
  }

  handleLogout() {
    this.sportyShoesService.logout();
  }

}
