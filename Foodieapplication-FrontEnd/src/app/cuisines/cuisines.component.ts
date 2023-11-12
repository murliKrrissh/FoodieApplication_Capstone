import { Component, Input } from '@angular/core';
import { RestaurantServiceService } from '../services/restaurant-service.service';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-cuisines',
  templateUrl: './cuisines.component.html',
  styleUrls: ['./cuisines.component.css']
})
export class CuisinesComponent {

  constructor(private restaurantService:RestaurantServiceService,private activated:ActivatedRoute,private route:Router,private snackBar:MatSnackBar){
    this.activated.params.subscribe((result:any)=>{
      this.restaurantId = result.id;
    })
  }

    cuisines:any[] = []; 
    email = localStorage.getItem('email')

    
    restaurantId:number=0;
    role = localStorage.getItem('role');

    ngOnInit():void{
      this.loadCuisines();
    }

    loadCuisines(){
      this.restaurantService.getCuisinesByRestaurantId(this.restaurantId).subscribe(
        (response:any)=>{
          this.cuisines=response;
         }
      )    
    }
    navigateToCart(cuisineId:any){
      if(this.email == null){
        this.snackBar.open('Login To make the Request', 'failure', {
          duration: 3000,
          panelClass: ['mat-toolbar', 'mat-primary']
        });
      }
      else{
        this.route.navigate(["/cart/",this.restaurantId,cuisineId])
      }
    }
    navigateToAddCuisine(){
      if(this.role == "Vendor"){
        this.route.navigate(['/addCuisine'])
    }
    else{
      this.snackBar.open('You are not the Vendor', 'failure', {
        duration: 3000,
        panelClass: ['mat-toolbar', 'mat-primary']
      });
    }
    }
}
