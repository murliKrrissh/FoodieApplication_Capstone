import { Cuisine } from "./cuisine";

export type Restaurant = {
    restaurantId?:number;
    email?:String;
    restaurantName?:String;
    restaurantLocation?:String;
    cuisines?:Cuisine;
}