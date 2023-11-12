import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RegisterComponent } from './register/register.component';
import { HomeViewComponent } from './home-view/home-view.component';
import { LoginComponent } from './login/login.component';
import { AddRestaurantComponent } from './add-restaurant/add-restaurant.component';
import { CuisinesComponent } from './cuisines/cuisines.component';
import { AddCuisineComponent } from './add-cuisine/add-cuisine.component';
import { CartComponent } from './cart/cart.component';
import { OrderComponent } from './order/order.component';

const routes: Routes = [
  {path:"",redirectTo:"/home",pathMatch:"full"},
  {path:"register",component:RegisterComponent},
  {path:"home",component:HomeViewComponent},
  {path:"login",component:LoginComponent},
  {path:"addrestaurant", component:AddRestaurantComponent},
  {path:"cuisines/:id", component:CuisinesComponent},
  {path:"addCuisine", component:AddCuisineComponent},
  {path:"addCuisine/:id", component:AddCuisineComponent},
  {path: "cart", component: CartComponent },
  {path:"myOrders",component:OrderComponent},
  {path:"cart/:rId/:cId",component:CartComponent}
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
