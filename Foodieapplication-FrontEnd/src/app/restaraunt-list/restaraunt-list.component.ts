import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { RestaurantServiceService } from '../services/restaurant-service.service';
import { Route, Router } from '@angular/router';

@Component({
  selector: 'app-restaraunt-list',
  templateUrl: './restaraunt-list.component.html',
  styleUrls: ['./restaraunt-list.component.css']
})
export class RestarauntListComponent {

  restaurants:any[] = [];

    constructor(private restaurantService:RestaurantServiceService, private route:Router){}

    ngOnInit():void{
      this.loadRestaurants();
    }

    loadRestaurants(){
      this.restaurantService.getAllRestaurant().subscribe(
        (response:any)=>{
          this.restaurants=response;
         }
      )    
    }

    navigateToParticularRestaurant(restaurantId:number){
      console.log(restaurantId);
      this.route.navigate(["/cuisines/",restaurantId])
    }

    SearchLocation(location:string){
      this.restaurantService.getRestaurantByLocation(location).subscribe((res:any)=>{
        this.restaurants=res;
      })
    }

    SearchCuisineType(cuisine:string){
      this.restaurantService.getRestaurantByCuisineType(cuisine).subscribe((res:any)=>{
        this.restaurants=res;
      })
    }
}
