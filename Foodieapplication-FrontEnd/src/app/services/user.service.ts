import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../models/user';
import { Detail } from '../models/detail';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  registerUrl = "http://localhost:8083/api/v1/user/register";
  orderUrl = "http://localhost:8083/api/v1/user"

  constructor(private http : HttpClient) { }

  addUser(user?: User): Observable<Object>{
    return this.http.post<Object>(`${this.registerUrl}`,user);
  }

  saveOrderRequest(detail? : Detail, email?:any) : Observable<any> {
    return this.http.post<any>(`${this.orderUrl}/addOrderToOrderList/${email}`, detail)
  }

  viewOrder(email?:any){
    return this.http.get<any>(`${this.orderUrl}/getOrderByEmail/${email}`);
  }

}
