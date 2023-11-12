import { Injectable } from '@angular/core';
import { Cuisine } from '../models/cuisine';
import { Detail } from '../models/detail';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CuisineDetailsService {

  constructor(private http : HttpClient) { }
  cuisineDetails:Cuisine={};

  cuisineUrl = "http://localhost:8082/api/v1/restaurant/getCuisinesByRestaurantIdAndCuisineId"

   setDetails(cuisine:Cuisine){
    this.cuisineDetails=cuisine;
   }

   getDetails(){
    return this.cuisineDetails;
   }

   getCuisineDetails(restarauntId:any,cuisineId:any){
    return this.http.get(`${this.cuisineUrl}/${restarauntId}/${cuisineId}`);
   }
}
