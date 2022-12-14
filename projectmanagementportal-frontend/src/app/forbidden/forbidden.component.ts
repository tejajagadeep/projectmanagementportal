import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-forbidden',
  templateUrl: './forbidden.component.html',
  styleUrls: ['./forbidden.component.css']
})
export class ForbiddenComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
    alert("You don't have access to this path. Redirect to home page.")
  }

}
