import { Component } from '@angular/core';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent {

  orders:any[]=[];

  email = localStorage.getItem('email');


  constructor(private userService: UserService){}

  
  ngOnInit():void{
    this.showOrder();
  }


    showOrder(){
      this.userService.viewOrder(this.email).subscribe((response=>{
        this.orders=response;
      }));
    }
}
