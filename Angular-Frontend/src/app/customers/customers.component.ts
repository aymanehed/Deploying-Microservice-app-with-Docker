import {Component, OnInit} from '@angular/core';
import {HttpClient, HttpClientModule} from "@angular/common/http";

@Component({
  selector: 'app-customers',
  standalone: true,
  imports: [HttpClientModule],
  templateUrl: './customers.component.html',
  styleUrl: './customers.component.css'
})
export class CustomersComponent implements OnInit{
  customers: any;
  constructor(private http:HttpClient) { }

  ngOnInit() {
    this.http.get('http://localhost:8081/customers').subscribe({
     next: data  => {
       this.customers = data;
     },
     error: error => {
       console.log( error);
    }

    })
  }


}
