import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Login } from '../models/login';
import { Token } from '@angular/compiler';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private HTTP:HttpClient) { }

  loginUrl="http://localhost:8081/api/v1/auth/login"


  generateToken(userLoginDetails:any){
    console.log(userLoginDetails);
    return this.HTTP.post(`${this.loginUrl}`,userLoginDetails);
  }
}

