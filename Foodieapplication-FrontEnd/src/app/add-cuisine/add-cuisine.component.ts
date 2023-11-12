import { Component } from '@angular/core';
import { RestaurantServiceService } from '../services/restaurant-service.service';
import { CuisineServiceService } from '../services/cuisine-service.service';
import { ActivatedRoute, Router } from '@angular/router';
import { FormBuilder, Validators } from '@angular/forms';
import { Cuisine } from '../models/cuisine';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-add-cuisine',
  templateUrl: './add-cuisine.component.html',
  styleUrls: ['./add-cuisine.component.css']
})
export class AddCuisineComponent {
  userLoggedIn?: string;
  item : Cuisine = new Cuisine();
  restaurantId:any;
  email=localStorage.getItem('email');

  constructor(private fb: FormBuilder, private restaurantService: RestaurantServiceService, private cuisineService: CuisineServiceService, private route: Router,
    private snackBar:MatSnackBar) {}

  addCuisine: any = this.fb.group({
    cuisineId: ['', Validators.required],
    cuisineType: ['', Validators.required],
    itemName: ['', Validators.required],
    itemPrice: ['', Validators.required],
    cuisineRating: ['', Validators.required],
    cuisineDescription: ['', Validators.required]
  });

  get cuisineId(){ return this.addCuisine.get("cuisineId")}
    get cuisineType(){ return this.addCuisine.get("cuisineType")}
    get itemName(){ return this.addCuisine.get("itemName")}
    get itemPrice(){ return this.addCuisine.get("itemPrice")}
    get cuisineRating(){ return this.addCuisine.get("cuisineRating")}
    get cuisineDescription(){ return this.addCuisine.get("cuisineDescription")}

    addItem(){
      this.cuisineService.addItem(this.item,this.restaurantId).subscribe(res=>{
        this.snackBar.open('Cuisine Added successfully', 'success', {
          duration: 3000,
          panelClass: ['mat-toolbar', 'mat-primary']
        });
      },error=>{
        this.snackBar.open('You dont have access to make changes to this restaurant', 'failure', {
          duration: 3000,
          panelClass: ['mat-toolbar', 'mat-primary']
        });
      });
    }
}