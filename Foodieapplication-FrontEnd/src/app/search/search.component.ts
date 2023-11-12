import { Component, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent {

  searchedLocation:string = "";
  searchedCuisineType:string= "";

  @Output() searchforLocation : EventEmitter<string> = new EventEmitter<string>();
  @Output() searchforCuisineType : EventEmitter<string> = new EventEmitter<string>();
  

  searchRestaurantByLocation(){
    this.searchforLocation.emit(this.searchedLocation);
  }

  searchRestaurantByCuisineType(){
    this.searchforCuisineType.emit(this.searchedCuisineType);
  }
  

}
