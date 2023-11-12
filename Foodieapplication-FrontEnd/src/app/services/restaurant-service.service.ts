import { HttpClient, HttpHeaders } from '@angular/common/http';
import { EventEmitter, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Restaurant } from '../models/restaurant';

@Injectable({
  providedIn: 'root'
})
export class RestaurantServiceService {

  constructor(private http: HttpClient) { }

  restaurantUrl: string = "http://localhost:8082/api/v1/restaurant";

  getAllRestaurant():Observable<any> {
    return this.http.get(this.restaurantUrl+"/AllRestaurant");
  }


  getRestaurantByLocation(location: any):Observable<Object> {
    return this.http.get<Object>(`${this.restaurantUrl}/getRestaurantByLocation/${location}`);
  }

  getRestaurantByCuisineType(cuisine:any):Observable<Object>{
    return this.http.get<Object>(`${this.restaurantUrl}/getRestaurantByCuisineType/${cuisine}`);
  }

  getCuisinesByRestaurantId(id:number){
    return this.http.get(`${this.restaurantUrl}/AllCuisinesById/${id}`);
  }

  addRestaurantTo(restaraunt:any):Observable<Object>{
    let httpHeader = new HttpHeaders({
        'Authorization':'Bearer ' +localStorage.getItem("token")
    });
    let requestOption = { headers: httpHeader };
    return this.http.post<Object>(`${this.restaurantUrl}/saveRestaurant`,restaraunt,requestOption);
  }
}