import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { UserService } from '../services/user.service';
import { Login } from '../models/login';
import { LoginService } from '../services/login.service';
import { Router } from '@angular/router';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  responseData:any;
  Token:any;

  
  constructor(private formB : FormBuilder,private userService:UserService,private loginService : LoginService,
              private route:Router,private snackBar:MatSnackBar){}

  userLogin = this.formB.group({
    email: ['', [Validators.required, Validators.email]],
    password : ['',Validators.required],
    })

    get email(){ return this.userLogin.get("email")}
    get password(){ return this.userLogin.get("password")}

    onSubmit(){
      this.loginService.generateToken(this.userLogin.value).subscribe({
        next:data=>{
          this.responseData = data;
          console.log("Token is Generated");
          localStorage.setItem('token',this.responseData.token);
          console.log(localStorage.getItem('token'));
          localStorage.setItem('role',this.responseData.role);
          localStorage.setItem('email',this.responseData.email);
          this.route.navigate(["/home"]);
          if(localStorage.getItem('role')=="Vendor"){
            this.snackBar.open('Vendor Logged In successfully', 'success', {
              duration: 3000,
              panelClass: ['mat-toolbar', 'mat-primary']
            });
            
          }
          else{
            this.snackBar.open('User Logged In successfully', 'success', {
              duration: 3000,
              panelClass: ['mat-toolbar', 'mat-primary']
            });
          }
        },
        error:err=>{
          this.snackBar.open('Invalid Credentials', 'failure', {
            duration: 3000,
            panelClass: ['mat-toolbar', 'mat-primary']
          });
        }
      })
      }
     
}
