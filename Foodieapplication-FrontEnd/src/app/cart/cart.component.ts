import { Component } from '@angular/core';
import { Cuisine } from '../models/cuisine';
import { Detail } from '../models/detail';
import { ActivatedRoute } from '@angular/router';
import { UserService } from '../services/user.service';
import { RestaurantServiceService } from '../services/restaurant-service.service';
import { RouteService } from '../services/route.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { FormBuilder,FormGroup,Validators } from '@angular/forms';
import { CuisineDetailsService } from '../services/cuisine-details.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent {
  item? : Cuisine;
  detail : Detail={} ;
  submitStatus:boolean=false;
  restaurantId:any;
  cuisineId:any;
 
  email = localStorage.getItem("email");
  userDetails : FormGroup;
  cuisine1:Cuisine={}

  constructor(private activatedRoute: ActivatedRoute,
  private userService : UserService,
  private restaurantService : RestaurantServiceService,
    private routeService:RouteService,
    private snackBar: MatSnackBar,private formB:FormBuilder , private cuisineDetails: CuisineDetailsService) { 
      this.userDetails = this.formB.group({
        orderId: ['', Validators.required],
      restaurantName : ['',Validators.required],
      itemName : ['',Validators.required],
      itemPrice : ['',Validators.required],
      quantity : ['',Validators.required],
      date : ["",Validators.required]
      })
    }


  
      get orderId(){ return this.userDetails.get("orderId")}
      get restaurantName(){ return this.userDetails.get("restaurantName")}
      get itemName(){ return this.userDetails.get("itemName")}
      get itemPrice(){ return this.userDetails.get("itemPrice")}
      get quantity(){ return this.userDetails.get("quantity")}
      get date(){ return this.userDetails.get("date")}


    ngOnInit(): void {
      this.activatedRoute.paramMap.subscribe(paramMap => {
        const id = paramMap.get('id');
        if (id) {
          this.restaurantService.getCuisinesByRestaurantId(parseInt(id, 10)).subscribe(data => {
            this.item = data;
          });
        }
      });
      this.activatedRoute.paramMap.subscribe(par1 =>{
        const id1 = par1.get("rId");
        const id2 = par1.get("cId");
        console.log(id1);
        console.log(id2);
        this.cuisineDetails.getCuisineDetails(id1,id2).subscribe(res=>{
          console.log(res);
          this.cuisine1 =res;
        })
      })
    }

    num = Math.floor(Math.random() * 1000);
    date1:any;


    onSubmit() {
    if (this.userDetails.valid) {
      this.userService.saveOrderRequest(this.userDetails.value,this.email).subscribe({
        next: data => {
          this.snackBar.open("Request Submitted", "", {
            duration: 3000
          });
          this.routeService.navigateToHomeView();
        },
        error: err => {
          alert(err);
        }
      })
    }
  }

}
