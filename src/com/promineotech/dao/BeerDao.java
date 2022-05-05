package com.promineotech.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.promineotech.beerEntity.Beers;

public class BeerDao {

  private static Connection connection;
  private final static String GET_ALL_BEERS_QUERY = "SELECT * FROM beers";
  private final static String CREATE_A_NEW_BEER_QUERY = "INSERT INTO beers (brewery_name, beer_name, beer_style) VALUES(?,?,?)";
  private final static String UPDATE_A_BEER_QUERY = "UPDATE beers SET beer_name = ?, beer_style= ? WHERE beer_id = ?";
  private final static String DELETE_A_BEER_QUERY = "DELETE FROM beers WHERE beer_id = ?";
  
  public BeerDao() {
    connection = BeerDBConnection.getConnection();
    
  }
  
  public static List<Beers> getBeers() throws SQLException{
    Statement statement = connection.createStatement();
    ResultSet rs = statement.executeQuery(GET_ALL_BEERS_QUERY);
    List<Beers> beers = new ArrayList<Beers>();
    
    while(rs.next()) {
      beers.add(populateBeers(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
      
    }
    return beers;
  }
  
  public void createABeer(String brewery_name, String beer_name, String beer_Style) throws SQLException {
    PreparedStatement ps = connection.prepareStatement(CREATE_A_NEW_BEER_QUERY);
    ps.setString(1, brewery_name);
    ps.setString(2, beer_name);
    ps.setString(3, beer_Style);
    ps.executeUpdate();
  
  }
  
  public void updateABeer(int beer_id , String beer_name, String beer_style) throws SQLException{
    PreparedStatement ps = connection.prepareStatement(UPDATE_A_BEER_QUERY);
    ps.setInt(3, beer_id);
    ps.setString(2, beer_style);
    ps.setString(1, beer_name);
    ps.executeUpdate(); 
    
  }
  
  
  public void deleteABeerById(int beer_id) throws SQLException {
    PreparedStatement ps =  connection.prepareStatement(DELETE_A_BEER_QUERY);
    ps.setInt(1, beer_id);
    ps.executeUpdate();
    
  }

  private static Beers populateBeers(int beer_id, String brewery_name, String beer_name, String beer_style) {
    
    return new Beers (beer_id, brewery_name, beer_name, beer_style);
  }
}
