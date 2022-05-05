package com.promineotech.beerEntity;

public class Beers {
  
  private int beer_id;
  private String brewery_name;
  private String beer_name;
  private String beer_style;
  
  public Beers(int beer_id, String brewery_name, String beer_name, String beer_style) {
    this.setBeer_id(beer_id);
    this.setBrewery_name(brewery_name);
    this.setBeer_name(beer_name);
    this.setBeer_style(beer_style);
    
  }

  public int getBeer_id() {
    return beer_id;
  }

  public void setBeer_id(int beer_id) {
    this.beer_id = beer_id;
  }

  public String getBrewery_name() {
    return brewery_name;
  }

  public void setBrewery_name(String brewery_name) {
    this.brewery_name = brewery_name;
  }

  public String getBeer_name() {
    return beer_name;
  }

  public void setBeer_name(String beer_name) {
    this.beer_name = beer_name;
  }

  public String getBeer_style() {
    return beer_style;
  }

  public void setBeer_style(String beer_style) {
    this.beer_style = beer_style;
  }

}
