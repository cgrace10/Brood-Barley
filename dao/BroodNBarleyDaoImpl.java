package com.aca.broodnbarley.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.aca.broodnbarley.model.DrinkGenre;
import com.aca.broodnbarley.model.DrinkItem;
import com.aca.broodnbarley.model.FoodGenre;
import com.aca.broodnbarley.model.FoodItem;

public class BroodNBarleyDaoImpl implements BroodNBarleyDao {
	
	private static String selectAllFoodItems =
			"SELECT foodId, foodTitle, foodGenreId, foodPrice, foodDescriptions, updateDateTime, createDateTime "
			+ "FROM fooditems";
	
	private static String selectAllDrinkItems =
			"SELECT drinkId, drinkTitle, drinkGenreId, drinkPrice, drinkDescriptions, drinkAbv, updateDateTime, createDateTime "
			+ "FROM drinkItems";
	
	private static String selectFoodItemsByGenre =
			"SELECT foodId, foodTitle, foodGenreId, foodPrice, foodDescriptions, updateDateTime, createDateTime "
			+ "FROM fooditems "
			+ "WHERE foodGenreId = ? ";
	
	private static String selectDrinkItemsByGenre =
			"SELECT drinkId, drinkTitle, drinkGenreId, drinkPrice, drinkDescriptions, drinkAbv, updateDateTime, createDateTime\r\n"
			+ "FROM drinkitems\r\n"
			+ "WHERE drinkGenreId = ? ";
	
	private static String selectFoodItemsByTitle =
			"SELECT foodId, foodTitle, foodGenreId, foodPrice, foodDescriptions, updateDateTime, createDateTime "
			+ "FROM fooditems "
			+ "WHERE foodTitle LIKE ? ";
	
	private static String selectDrinkItemsByTitle =
			"SELECT drinkId, drinkTitle, drinkGenreId, drinkPrice, drinkDescriptions, drinkAbv, updateDateTime, createDateTime "
			+ "FROM drinkitems "
			+ "WHERE drinkTitle LIKE ? ";
	
	private static String selectFoodItemsById =
			"SELECT foodId, foodTitle, foodGenreId, foodPrice, foodDescriptions, updateDateTime, createDateTime "
			+ "FROM fooditems "
			+ "WHERE foodId = ? ";
	
	private static String selectDrinkItemsById = 
			"SELECT drinkId, drinkTitle, drinkGenreId, drinkPrice, drinkDescriptions, drinkAbv, updateDateTime, createDateTime "
			+ "FROM drinkitems "
			+ "WHERE drinkId = ? ";
	
	private static String deleteFoodItemsById =
			"DELETE FROM fooditems "
			+ "WHERE foodId = ? ";
	
	private static String deleteDrinkItemsById =
			"DELETE FROM drinkitems "
			+ "WHERE drinkId = ? ";
	
	private static String updateFoodItemsById =
			"UPDATE fooditems "
			+ "SET foodTitle = ?, "
			+ "	 foodGenreId = ?, "
			+ "	 foodPrice = ?, "
			+ "	 foodDescriptions = ? "
			+ "WHERE foodId = ? ";
	
	private static String updateDrinkItemsById =
			"UPDATE drinkitems "
			+ "SET drinkTitle = ?, "
			+ "	 drinkGenreId = ?, "
			+ "	 drinkPrice = ?, "
			+ "	 drinkDescriptions = ?, "
			+ "	 drinkAbv = ? "
			+ "WHERE drinkId = ? ";
	
	private static String createFoodItem =
			"INSERT INTO foodItems (foodTitle, foodGenreId, foodPrice, foodDescriptions) "
			+ "VALUES "
			+ "(?, ?, ?, ?) ";
	
	private static String selectNewFoodId = 
			"SELECT LAST_INSERT_ID() AS foodId";
	
	private static String createDrinkItem = 
			"INSERT INTO drinkItems (drinkTitle, drinkGenreId, drinkPrice, drinkDescriptions, drinkAbv) "
			+ "VALUES "
			+ "(?, ?, ?, ?, ?);";
	
	private static String selectNewDrinkId =
			"SELECT LAST_INSERT_ID() AS drinkId";

	@Override
	public List<FoodItem> getFoodItems() {
		List<FoodItem> myFoodMenu = new ArrayList<FoodItem>();
		ResultSet result = null;
		Statement statement = null;
		
		Connection conn = MariaDbUtil.getConnection();
		
		try {
			statement = conn.createStatement();
			result = statement.executeQuery(selectAllFoodItems);
			myFoodMenu = makeFoodItem(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return myFoodMenu;
	}

	private List<FoodItem> makeFoodItem(ResultSet result) throws SQLException {
		List<FoodItem> myFoodMenu = new ArrayList<FoodItem>();
		
		while(result.next()) {
			FoodItem foodItem = new FoodItem();
			foodItem.setFoodId(result.getInt("foodId"));
			foodItem.setFoodTitle(result.getString("foodTitle"));
			foodItem.setPrice(result.getInt("foodPrice"));
			foodItem.setDescriptions(result.getString("foodDescriptions"));
			
			String genreString = result.getString("foodGenreId");
			FoodGenre myFoodGenre = FoodGenre.convertStringToGenre(genreString);
			foodItem.setGenre(myFoodGenre);
			
			foodItem.setUpdateDateTime(result.getObject("updateDateTime", LocalDateTime.class));
			foodItem.setCreateDateTime(result.getObject("createDateTime", LocalDateTime.class));
			
			myFoodMenu.add(foodItem);
		}
		return myFoodMenu;
	}

	@Override
	public List<FoodItem> getFoodItemsById(Integer foodId) {
		List<FoodItem> myFoodMenu = new ArrayList<FoodItem>();
		ResultSet result = null;
		PreparedStatement ps = null;
		
		Connection conn = MariaDbUtil.getConnection();
		
		try {
			ps = conn.prepareStatement(selectFoodItemsById);
			ps.setInt(1, foodId);
			result = ps.executeQuery();
			myFoodMenu = makeFoodItem(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return myFoodMenu;
	}

	@Override
	public List<FoodItem> getFoodItemsByGenre(FoodGenre genre) {
		List<FoodItem> myFoodMenu = new ArrayList<FoodItem>();
		ResultSet result = null;
		PreparedStatement ps = null;
		
		Connection conn = MariaDbUtil.getConnection();
		
		try {
			ps = conn.prepareStatement(selectFoodItemsByGenre);
			ps.setString(1, genre.toString());
			result = ps.executeQuery();
			myFoodMenu = makeFoodItem(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return myFoodMenu;
	}

	@Override
	public List<FoodItem> getFoodItemsByTitle(String foodTitle) {
		List<FoodItem> myFoodMenu = new ArrayList<FoodItem>();
		ResultSet result = null;
		PreparedStatement ps = null;
		
		Connection conn = MariaDbUtil.getConnection();
		
		try {
			ps = conn.prepareStatement(selectFoodItemsByTitle);
			ps.setString(1, "%" + foodTitle + "%");
			result = ps.executeQuery();
			myFoodMenu = makeFoodItem(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return myFoodMenu;
	}

	@Override
	public FoodItem createFoodItem(FoodItem newFoodItem) {
		PreparedStatement ps = null;
		Connection conn = MariaDbUtil.getConnection();
			
		try {
			ps = conn.prepareStatement(createFoodItem);
			ps.setString(1, newFoodItem.getFoodTitle());
			ps.setString(2, newFoodItem.getGenre().toString());
			ps.setInt(3, newFoodItem.getPrice());
			ps.setString(4, newFoodItem.getDescriptions());
			int updateRowCount = ps.executeUpdate();
			System.out.println("rows inserted: " + updateRowCount);
			int foodId = getNewFoodId(conn);
			newFoodItem.setFoodId(foodId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return newFoodItem;
	}

	private int getNewFoodId(Connection conn) {
		ResultSet rs = null;
		Statement statement = null;
		int newFoodId = 0;
		
		try {
			statement = conn.createStatement();
			rs = statement.executeQuery(selectNewFoodId);
			while(rs.next()) {
				newFoodId = rs.getInt("foodId");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return newFoodId;
	}

	@Override
	public FoodItem updateFoodItem(FoodItem updateFoodItem) {
		List<FoodItem> myFoodMenu = getFoodItemsById(updateFoodItem.getFoodId());
		
		if(myFoodMenu.size() == 1) {
			PreparedStatement ps = null;
			Connection conn = MariaDbUtil.getConnection();
			
			try {
				ps = conn.prepareStatement(updateFoodItemsById);
				ps.setString(1, updateFoodItem.getFoodTitle());
				ps.setString(2, updateFoodItem.getGenre().toString());
				ps.setInt(3, updateFoodItem.getPrice());
				ps.setString(4, updateFoodItem.getDescriptions().toString());
				ps.setInt(5, updateFoodItem.getFoodId());
				int updateRowCount = ps.executeUpdate();
				System.out.println("rows update: " + updateRowCount);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return updateFoodItem;
	}

	@Override
	public FoodItem deleteFoodItemsById(Integer foodId) {
		List<FoodItem> myFoodMenu = getFoodItemsById(foodId);
		FoodItem foodItemToDelete = null;
		PreparedStatement ps = null;
		
		if(myFoodMenu.size() == 1) {
			foodItemToDelete = myFoodMenu.get(0);
		
			Connection conn = MariaDbUtil.getConnection();
			
			try {
				ps = conn.prepareStatement(deleteFoodItemsById);
				ps.setInt(1, foodId);
				int updateRowCount = ps.executeUpdate();
				System.out.println("rows deleted: " + updateRowCount);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return foodItemToDelete;
	}

	@Override
	public List<DrinkItem> getDrinkItems() {
		List<DrinkItem> myDrinkMenu = new ArrayList<DrinkItem>();
		ResultSet result = null;
		Statement statement = null;
		
		Connection conn = MariaDbUtil.getConnection();
		
		try {
			statement = conn.createStatement();
			result = statement.executeQuery(selectAllDrinkItems);
			myDrinkMenu = makeDrinkItem(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return myDrinkMenu;
	}

	private List<DrinkItem> makeDrinkItem(ResultSet result) throws SQLException {
		List<DrinkItem> myDrinkMenu = new ArrayList<DrinkItem>();
		
		while(result.next()) {
			DrinkItem drinkItem = new DrinkItem();
			drinkItem.setDrinkId(result.getInt("drinkId"));
			drinkItem.setDrinkTitle(result.getString("drinkTitle"));
			drinkItem.setPrice(result.getInt("drinkPrice"));
			drinkItem.setDescriptions(result.getString("drinkDescriptions"));
			drinkItem.setAbv(result.getDouble("drinkAbv"));
			String genreString = result.getString("drinkGenreId");
			DrinkGenre myDrinkGenre = DrinkGenre.convertStringToGenre(genreString);
			drinkItem.setGenre(myDrinkGenre);
			
			drinkItem.setUpdateDateTime(result.getObject("updateDateTime", LocalDateTime.class));
			drinkItem.setCreateDateTime(result.getObject("createDateTime", LocalDateTime.class));
			
			myDrinkMenu.add(drinkItem);
			
		}
		return myDrinkMenu;
	}

	@Override
	public List<DrinkItem> getDrinkItemsById(Integer drinkId) {
		List<DrinkItem> myDrinkMenu = new ArrayList<DrinkItem>();
		ResultSet result = null;
		PreparedStatement ps = null;
		
		Connection conn = MariaDbUtil.getConnection();
		
		try {
			ps = conn.prepareStatement(selectDrinkItemsById);
			ps.setInt(1, drinkId);
			result = ps.executeQuery();
			myDrinkMenu = makeDrinkItem(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return myDrinkMenu;
	}

	@Override
	public List<DrinkItem> getDrinkItemsByGenre(DrinkGenre genre) {
		List<DrinkItem> myDrinkMenu = new ArrayList<DrinkItem>();
		ResultSet result = null;
		PreparedStatement ps = null;
		
		Connection conn = MariaDbUtil.getConnection();
		
		try {
			ps = conn.prepareStatement(selectDrinkItemsByGenre);
			ps.setString(1, genre.toString());
			result = ps.executeQuery();
			myDrinkMenu = makeDrinkItem(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return myDrinkMenu;
	}

	@Override
	public List<DrinkItem> getDrinkItemsByTitle(String drinkTitle) {
		List<DrinkItem> myDrinkMenu = new ArrayList<DrinkItem>();
		ResultSet result = null;
		PreparedStatement ps = null;
		
		Connection conn = MariaDbUtil.getConnection();
		
		try {
			ps = conn.prepareStatement(selectDrinkItemsByTitle);
			ps.setString(1, "%" + drinkTitle + "%");
			result = ps.executeQuery();
			myDrinkMenu = makeDrinkItem(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return myDrinkMenu;
	}

	@Override
	public DrinkItem createDrinkItem(DrinkItem newDrinkItem) {
			PreparedStatement ps = null;
			Connection conn = MariaDbUtil.getConnection();
			
			try {
				ps = conn.prepareStatement(createDrinkItem);
				ps.setString(1, newDrinkItem.getDrinkTitle());
				ps.setString(2, newDrinkItem.getGenre().toString());
				ps.setInt(3, newDrinkItem.getPrice());
				ps.setString(4, newDrinkItem.getDescriptions());
				ps.setDouble(5, newDrinkItem.getAbv());
				int updateRowCount = ps.executeUpdate();
				System.out.println("rows inserted: " + updateRowCount);
				int drinkId = getNewDrinkId(conn);
				newDrinkItem.setDrinkId(drinkId);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		return newDrinkItem;
	}

	private int getNewDrinkId(Connection conn) {
		ResultSet rs = null;
		Statement statement = null;
		int newDrinkId = 0;
		
		try {
			statement = conn.createStatement();
			rs = statement.executeQuery(selectNewDrinkId);
			while(rs.next()) {
				newDrinkId = rs.getInt("drinkId");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return newDrinkId;
	}

	@Override
	public DrinkItem updateDrinkItem(DrinkItem updateDrinkItem) {
		List<DrinkItem> myDrinkMenu = getDrinkItemsById(updateDrinkItem.getDrinkId());
		
		if(myDrinkMenu.size() == 1) {
			PreparedStatement ps = null;
			Connection conn = MariaDbUtil.getConnection();
			
			try {
				ps = conn.prepareStatement(updateDrinkItemsById);
				ps.setString(1, updateDrinkItem.getDrinkTitle());
				ps.setString(2, updateDrinkItem.getGenre().toString());
				ps.setInt(3, updateDrinkItem.getPrice());
				ps.setString(4, updateDrinkItem.getDescriptions().toString());
				ps.setDouble(5, updateDrinkItem.getAbv());
				ps.setInt(6, updateDrinkItem.getDrinkId());
				int updateRowCount = ps.executeUpdate();
				System.out.println("rows updated: " + updateRowCount);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return updateDrinkItem;
	}

	@Override
	public DrinkItem deleteDrinkItemsById(Integer drinkId) {
		List<DrinkItem> myDrinkMenu = getDrinkItemsById(drinkId);
		DrinkItem drinkItemToDelete = null;
		PreparedStatement ps = null;
		
		if(myDrinkMenu.size() == 1) {
			drinkItemToDelete = myDrinkMenu.get(0);
		
			Connection conn = MariaDbUtil.getConnection();
			
			try {
				ps = conn.prepareStatement(deleteDrinkItemsById);
				ps.setInt(1, drinkId);
				int updateRowCount = ps.executeUpdate();
				System.out.println("rows deleted: " + updateRowCount);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return drinkItemToDelete;
	}
	
	

}
