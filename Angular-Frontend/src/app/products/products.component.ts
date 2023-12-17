import {Component, OnInit} from '@angular/core';
import {CommonModule, NgForOf, NgIf} from "@angular/common";
import {HttpClient, HttpClientModule} from "@angular/common/http";

@Component({
  selector: 'app-products',
  standalone: true,
  imports: [CommonModule,HttpClientModule],
  templateUrl: './products.component.html',
  styleUrl: './products.component.css'
})
export class ProductsComponent implements OnInit {
  products: any;
  constructor(private http:HttpClient) { }

  ngOnInit() {
    this.http.get('http://localhost:8888/inventory-service/products').subscribe({
     next: data  => {
       this.products = data;
     },
     error: error => {
       console.log( error);
    }

    })
  }

}
