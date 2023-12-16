import {Component, OnInit} from '@angular/core';
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {CommonModule} from "@angular/common";

@Component({
  selector: 'app-customers',
  standalone: true,
  imports: [HttpClientModule,CommonModule],
  templateUrl: './customers.component.html',
  styleUrl: './customers.component.css'
})
export class CustomersComponent implements OnInit{
  customers: any;
  constructor(private http:HttpClient) { }

  ngOnInit() {
    this.http.get('http://localhost:8888/customer-service/customers').subscribe({
     next: data  => {
       this.customers = data;
     },
     error: error => {
       console.log( error);
    }

    })
  }


}
