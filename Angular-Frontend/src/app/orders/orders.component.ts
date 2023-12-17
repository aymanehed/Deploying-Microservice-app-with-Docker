import {Component, OnInit} from '@angular/core';
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {CommonModule} from "@angular/common";

@Component({
  selector: 'app-orders',
  standalone: true,
  imports: [HttpClientModule,CommonModule],
  templateUrl: './orders.component.html',
  styleUrl: './orders.component.css'
})
export class OrdersComponent implements OnInit{
  orders: any;
  constructor(private http:HttpClient) { }

  ngOnInit() {
    this.http.get('http://localhost:8888/order-service/orders').subscribe({
     next: data  => {
       this.orders = data;
     },
     error: error => {
       console.log( error);
    }

    })
  }

}
