import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { RegisterComponent } from './register/register.component';
import { HomeViewComponent } from './home-view/home-view.component';
import { NavigationComponent } from './navigation/navigation.component';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import {MatSelectModule} from '@angular/material/select';
import { LoginComponent } from './login/login.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { AddRestaurantComponent } from './add-restaurant/add-restaurant.component';
import { AddCuisineComponent } from './add-cuisine/add-cuisine.component';
import { RestarauntListComponent } from './restaraunt-list/restaraunt-list.component';
import {MatCardModule} from '@angular/material/card';
import { CuisinesComponent } from './cuisines/cuisines.component';
import { SearchComponent } from './search/search.component';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import { CartComponent } from './cart/cart.component';
import { OrderComponent } from './order/order.component';

@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    HomeViewComponent,
    NavigationComponent,
    LoginComponent,
    HeaderComponent,
    FooterComponent,

    FooterComponent,
    AddRestaurantComponent,
    AddCuisineComponent,
    RestarauntListComponent,
    CuisinesComponent,
    SearchComponent,
    CartComponent,
    OrderComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatButtonModule,MatCardModule,
    MatSidenavModule,
    MatIconModule,MatSnackBarModule,
    MatListModule,HttpClientModule,ReactiveFormsModule,MatButtonModule,
    MatFormFieldModule,MatInputModule,FormsModule,MatSelectModule,
    ReactiveFormsModule.withConfig({warnOnNgModelWithFormControl: 'never'})
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
