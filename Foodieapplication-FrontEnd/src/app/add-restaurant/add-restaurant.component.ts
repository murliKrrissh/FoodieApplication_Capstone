import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { RestaurantServiceService } from '../services/restaurant-service.service';
import { Router } from '@angular/router';
import { Restaurant } from '../models/restaurant';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-add-restaurant',
  templateUrl: './add-restaurant.component.html',
  styleUrls: ['./add-restaurant.component.css']
})
export class AddRestaurantComponent {

  restaurant : Restaurant ={}
  role=localStorage.getItem("role");
  email1=localStorage.getItem("email");
  addform:FormGroup;
  

  constructor(private fb: FormBuilder, private service: RestaurantServiceService, private route: Router,
    private snackBar:MatSnackBar) {
      this.addform = this.fb.group({
        restaurantId: ['', Validators.required],
        email:['',Validators.required],
        restaurantName: ['', Validators.required],
        restaurantLocation: ['', Validators.required]
      })
     }

  get restaurantId() { return this.addform.get("restaurantId") }
  get email(){ return this.addform.get("email")}
  get restaurantName() { return this.addform.get("restaurantName") }
  get restaurantLocation() { return this.addform.get("restaurantLocation")  }

  
  addRestaurantTo(){
    if(this.role === "Vendor"){
    this.service.addRestaurantTo(this.addform.value).subscribe(res=>{
      this.snackBar.open('Restaurant Added', 'success', {
        duration: 3000,
        panelClass: ['mat-toolbar', 'mat-primary']
      });
    });
    }
    else{
      this.snackBar.open('Only Verdor can add restaurant', 'failure', {
        duration: 3000,
        panelClass: ['mat-toolbar', 'mat-primary']
      });
    }
  }

}