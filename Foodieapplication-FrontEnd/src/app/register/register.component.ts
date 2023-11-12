import { Component } from '@angular/core';
import { FormBuilder,Validators } from '@angular/forms';
import { User } from '../models/user';
import { UserService } from '../services/user.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {

  user : User = new User();

  constructor(private formB : FormBuilder,private userService:UserService,private snackBar:MatSnackBar,private route:Router){}

  userDetails = this.formB.group({
    email: ['', [Validators.required, Validators.email]],
    password : ['',Validators.required],
    name : ['',[Validators.required,Validators.minLength(2)]],
    role : ['',Validators.required],
    address : ['',Validators.required],
    phoneNo : ["",[Validators.required,Validators.pattern(/^[789]\d{9,9}$/)]]
    })

    get email(){ return this.userDetails.get("email")}
    get password(){ return this.userDetails.get("password")}
    get name(){ return this.userDetails.get("name")}
    get role(){ return this.userDetails.get("role")}
    get address(){ return this.userDetails.get("address")}
    get phoneNo(){ return this.userDetails.get("phoneNo")}

    addUser(){
      console.log(this.user);
      this.userService.addUser(this.user).subscribe(res=>{
        this.snackBar.open('Registered Successfully', 'success', {
          duration: 3000,
          panelClass: ['mat-toolbar', 'mat-primary']
        });
        this.route.navigate(["/home"]);
        window.location.reload();
      },error=>{
        this.snackBar.open('Something went Wrong', 'failure', {
          duration: 3000,
          panelClass: ['mat-toolbar', 'mat-primary']
        });
      });
    }
}
