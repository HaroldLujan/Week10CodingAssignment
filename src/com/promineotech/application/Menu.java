package com.promineotech.application;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import com.promineotech.beerEntity.Beers;
import com.promineotech.dao.BeerDao;

public class Menu {
  private BeerDao beerDao = new BeerDao();
  private Scanner userInput = new Scanner (System.in);
  private List<String> choices = Arrays.asList("Create A Beer",
                                               "Display All Beers", 
                                               "Update A Beer",
                                               "Delete A Beer", 
                                               "To Exit Press 0");
  
  public void start(){
    String userSelection = "";
    
    do { 
      printBeerMenuOptions();
      userSelection = userInput.nextLine();
      try {
        if (userSelection.equals("1")){
          createABeer();
        }else if (userSelection.equals("2")) {
          displayAllBeers();
          
        }else if (userSelection.equals("3")) {
         updateABeer();
          
        }else if (userSelection.equals("4")) {
         deleteABeer();
      }
      
      }catch (SQLException e) {
        e.printStackTrace();
      }
      
      System.out.println("****** Press Enter To Continue ******");
      userInput.nextLine();
      
    }while (!userSelection.equals("0"));
  }
  
  private void printBeerMenuOptions() {
    System.out.println("****** Your Guide To Beer ****** \n" + "\n Select An Option Below \n");
    for(int i =0; i< choices.size(); i++) {
      System.out.println(i + 1 +") " + choices.get(i));
    }
  }
  private void displayAllBeers() throws SQLException {
    List<Beers> allBeers = BeerDao.getBeers();
    for(Beers beer: allBeers) {
      System.out.println("Beer Id: " + beer.getBeer_id() +"\n"
                          + "Brewery Name:" + beer.getBrewery_name() +"\n"
                          + "Beer Name:" + beer.getBeer_name()+"\n"
                          + "Beer Style:" + beer.getBeer_style());
    }
    
    
  }
  private void createABeer() throws SQLException{
    System.out.println("Enter Brewery Name");
    String brewery_name = userInput.nextLine();
    
    System.out.println("Enter Beer Name");
    String beer_name = userInput.nextLine();
    
    System.out.println("Enter Beer Style");
    String beer_style = userInput.nextLine();
    
    beerDao.createABeer(brewery_name, beer_name, beer_style);
    
    
  }
  
  private void updateABeer()throws SQLException {
  
    System.out.print("Enter Beer ID To Update");
    int beer_id = Integer.parseInt(userInput.nextLine());
  
    System.out.print("Enter New Beer Name "); 
    String beer_name = userInput.nextLine();
    
    System.out.print("Enter New Beer Style "); 
    String beer_style = userInput.nextLine();
    
    
    beerDao.updateABeer(beer_id, beer_name, beer_style);
    
    

  }
  
  private void deleteABeer()throws SQLException {
    System.out.print("Enter Beer Id To Delete");
    int beer_id = Integer.parseInt(userInput.nextLine());
    
    beerDao.deleteABeerById(beer_id);
    
  }
}
