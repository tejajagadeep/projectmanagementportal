import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  message = ''

  constructor(private route: ActivatedRoute) { }

  ngOnInit(): void {
    console.log(this.message)
    this.message = this.route.snapshot.params['userId']

  }

}
