import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { MessageResponse, UserDataService } from '../service/data/user-data.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  username!: string
  message!: string
  errorMessageResponse=""
  helloWorldMessage!: MessageResponse

  constructor(
    private router : Router, 
    private route: ActivatedRoute, 
  ) { }

  ngOnInit(): void {
    this.username = this.route.snapshot.params['userName'];
    console.log(this.username)
    console.log('home.component.ts')
    // this.helloWorld();
  }

   
}
