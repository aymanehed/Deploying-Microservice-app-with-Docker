import { Routes } from '@angular/router';
import {CustomersComponent} from "./customers/customers.component";
import {OrdersComponent} from "./orders/orders.component";
import {ProductsComponent} from "./products/products.component";
import {HomeComponent} from "./home/home.component";

export const routes: Routes = [
  {path:"customers",component:CustomersComponent},
  {path:"orders",component:OrdersComponent},
  {path:"products",component:ProductsComponent},
  {path:"home",component:HomeComponent}


];
