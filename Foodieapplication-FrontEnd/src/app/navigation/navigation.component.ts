import { Component, inject } from '@angular/core';
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { Observable } from 'rxjs';
import { map, shareReplay } from 'rxjs/operators';
import { Router } from '@angular/router';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css']
})
export class NavigationComponent {
  private breakpointObserver = inject(BreakpointObserver);

  constructor(private route:Router,private snackBar:MatSnackBar){}

  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
    .pipe(
      map(result => result.matches),
      shareReplay()
    );
    role = localStorage.getItem('role');
    email = localStorage.getItem('email');
    

    logout(){
      localStorage.clear();
      this.route.navigate(['/home'])
      this.snackBar.open('You Have been Successfully Logout','', {
        duration: 3000,
        panelClass: ['mat-toolbar', 'mat-primary']
      });
    }

    goToAdd(){
      if(this.role == "Vendor"){
          this.route.navigate(['/addrestaurant'])
      }
      else{
        this.snackBar.open('Sign Up as Vendor to add Restaurant', 'failure', {
          duration: 3000,
          panelClass: ['mat-toolbar', 'mat-primary']
        });
      }
    }

    showOrder(){
      if(this.email == null){
        this.snackBar.open('You have to Login First and Make Request', 'failure', {
          duration: 3000,
          panelClass: ['mat-toolbar', 'mat-primary']
        });
      }
      else{
        this.route.navigate(["/myOrders"])
      }
    }
}
