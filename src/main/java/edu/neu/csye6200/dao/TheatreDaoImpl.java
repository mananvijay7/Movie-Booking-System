package edu.neu.csye6200.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import edu.neu.csye6200.model.Theatre;
import edu.neu.csye6200.repository.DatabaseConnection;

public class TheatreDaoImpl implements TheatreDao {
	Connection connection = DatabaseConnection.getDbInstance();
	
	@Override
	public List<Theatre> getAllTheatres() {
		List<Theatre> theatres = new ArrayList<Theatre>();
		Statement statement;
		ResultSet rs = null;
		try {
			statement = connection.createStatement();
			String sqlQuery = "select * from theatre";
			rs = statement.executeQuery(sqlQuery);
			while(rs.next()) {
				int theatre_id = rs.getInt("theatre_Id");
				String theatre_name= rs.getString("theatre_name");
				List<Integer> screens = getScreensOfTheatre(theatre_id);
				theatres.add(new Theatre(theatre_id, theatre_name, screens));
			}

		} catch (SQLException exp) {
			System.out.println(exp);
		}
		return theatres;
	}
	
	private List<Integer> getScreensOfTheatre(int theatre_id) {
		List<Integer> screens = new ArrayList<Integer>();
		ResultSet rs = null;
		try {
			
			String sqlQuery = "SELECT screen_Number FROM theatre_screen_mapping WHERE theatre_id = ?";
			PreparedStatement ps = connection.prepareStatement(sqlQuery);
			ps.setInt(1, theatre_id);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				int screenId = rs.getInt("screen_Number");
				screens.add(screenId);
			}
		} catch (SQLException exp) {
			exp.printStackTrace();
		}
		return screens;
	}

	@Override
	public Theatre getTheatreById(int id) {
		ResultSet rs = null;
		
		try {
			String sqlQuery = "select * from theatre where theatre_id = ?";
			PreparedStatement ps = connection.prepareStatement(sqlQuery);
			ps.setInt(1,id);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int theatreId = rs.getInt("theatre_Id");
				String theatreName = rs.getString("theatre_name");
				List<Integer> screens = getScreensOfTheatre(theatreId);
				return new Theatre(theatreId, theatreName, screens);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return null;
	}

	@Override
	public void addTheatre(Theatre theatre) {
		
		String sqlQuery = 	"INSERT INTO THEATRE "
				+ 			"(theatre_name) "
				+ 			"VALUES (?)";
		
		try {			
				PreparedStatement ps = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, theatre.getName());
				ps.executeUpdate();
				ResultSet generatedKeys = ps.getGeneratedKeys();
				if (generatedKeys.next()) {
				    int theatreId = generatedKeys.getInt(1);
				    addScreensToTheatre(theatreId, theatre.getScreens());
				}
				System.out.println("Theatre added to database" + "\n");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void addScreensToTheatre(int theatreId, List<Integer> screens) {		
		String sqlQuery = 	"INSERT INTO theatre_screen_mapping "
				+ 			"(theatre_id, screen_Number) "
				+ 			"VALUES (?,?)";
		
		try {
			int theatreAdded = 0;
			PreparedStatement ps = connection.prepareStatement(sqlQuery);
			ps.setInt(1, theatreId);
			for (int screenId: screens) {
				ps.setInt(2,  screenId);
				theatreAdded = ps.executeUpdate();				
			}
			if(theatreAdded > 0) {
				System.out.println("Mapping added to database");
			} else {
				System.out.println("Error adding theatre to screen mapping " + theatreId);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateTheatre(Theatre theatre) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteTheatre(int id) {
		try {
			String sqlQuery = "DELETE FROM theatre WHERE theatre_Id = ?";
			PreparedStatement ps = connection.prepareStatement(sqlQuery);
			ps.setInt(1,id);
			
			int rowDeleted = ps.executeUpdate();
			
			if(rowDeleted > 0) {
				System.out.println("Theatre deleted");
			}
			else {
				System.out.println("Error deleting theatre with Id = " + id);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
