//package interview;
///*
//Recently I applied for meesho for the position of SDE. Overall interview experience was good
//1 First round was machine coding round where the interviewer asked to design a soltuion for restaurant
// rating system something like a restaurant can have multiple branches and a restaurant can serve only
// one food item at all their branches. the customers can add a new restaurant or can search for available
// restuarant branches based on some pincodes. now the customer can also rate a food only for branches that
//  matches his location at a restaurant. we have to show the overall average rating of a food,
//  list all the ratings as well as list rating for an area.
// */
//
//import lombok.Data;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Meesho {
//
//    //create  a restaurant
//    Restaurant restaurant = new Restaurant(1,444203);
//
//}
//
//
//class Restaurant {
//    int id;
//    int pincode;
//    Menu menu;
//
//
//    public Restaurant(int id , int pincode){
//        this.id = id;
//        this.pincode = pincode;
//        menu = initailaizeMenu();
//    }
//
//    private Menu initailaizeMenu() {
//
//        Menu menu = new Menu();
//        menu.setListOfFoodItem( new ArrayList<FoodItem>());
//        return menu;
//    }
//
//
//}
//@Data
//class Menu{
//    List<FoodItem> listOfFoodItem;
//}
//@Data
//class FoodItem{
//    String name;
//    String type;
//    String metadata;
//    String urlPhoto;
//}