import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Cuisine } from '../models/cuisine';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CuisineServiceService {

  url1 = 'http://localhost:8082/api/v1/restaurant';

  constructor(private http: HttpClient) { 
  }


  addItem(item?:Cuisine,id?:number):Observable<any>{
    let httpHeader = new HttpHeaders({
      'Authorization':'Bearer ' +localStorage.getItem("token")
  });
  let requestOption = { headers: httpHeader };
    return this.http.post<any>(`${this.url1}/addCuisine/${id}/`,item,requestOption);
  }
}