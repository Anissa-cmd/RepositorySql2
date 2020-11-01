package foods.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import foods.types.Food;

public class foodDao {
	public void createFood(String name) throws SQLException {
		String sql = "INSERT INTO foods(name) VALUE(?)";
		Connection conn = null;
		PreparedStatement statement = null;
		
		try {
			conn = DBConnection.getInstance().getConnection();
			statement = conn.prepareStatement(sql);
			statement.setString(1, name);
			
			statement.executeUpdate();
		} 
		finally{
			if(statement != null) {
			statement.close();
			}
			if(conn != null) {
			conn.close();
			}
		}
	}

public List<Food> getFoods() throws SQLException {
	String sql = "SELECT * FROM foods";
	Connection conn = null;
	PreparedStatement statement = null;
	ResultSet rs = null;
	List<Food> foods = new ArrayList<>();
	
	try {
		conn = DBConnection.getInstance().getConnection();
		statement = conn.prepareStatement(sql);
		rs = statement.executeQuery();
		
		while (rs.next()) {
			int foodId = rs.getInt("food_id");
			String name = rs.getString("name");
			Food seafood = new Food();
			foods.add(seafood);
		}
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	finally {
		
		if(rs != null) {
		rs.close();
		}
		if(statement != null) {
		    statement.close();
		}
		if(conn != null) {
			conn.close();
		}
	}
	
	return foods;
}


public void alterFood(int id, String name) throws SQLException {
	String sql = "UPDATE foods SET name = ? WHERE food_id = ?";
	Connection conn = null;
	PreparedStatement statement = null;
	
	try {
		conn = DBConnection.getInstance().getConnection();
		statement = conn.prepareStatement(sql);
		statement.setInt(2, id);
		statement.setString(1, name);
		
		statement.executeUpdate();
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	finally {
		if(statement != null) {
			statement.close();
		}
	    if(conn != null) {
			conn.close();
		}
	}
}

public void deleteFood(int foodId) throws SQLException {
	String sql = "DELETE FROM foods WHERE food_id = ?";
	Connection conn = null;
	PreparedStatement statement = null;
	
	try {
		conn = DBConnection.getInstance().getConnection();
		statement = conn.prepareStatement(sql);
		statement.setInt(1, foodId);
		
	} catch (SQLException e) {
		e.printStackTrace();
		
	}
	finally {
		if(statement != null) {
			statement.close();
		}
		if(conn != null) {
			conn.close();
		}
	}
}
}










