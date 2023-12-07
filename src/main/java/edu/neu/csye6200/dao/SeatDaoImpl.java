package edu.neu.csye6200.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import edu.neu.csye6200.model.Seat;
import edu.neu.csye6200.repository.DatabaseConnection;

public class SeatDaoImpl implements SeatDao {
	Connection connection = DatabaseConnection.getDbInstance();
	@Override
	public List<Seat> getAllSeats() {
		List<Seat> allSeats = new ArrayList<Seat>();
		Statement statement;
		ResultSet rs = null;
		try {
			statement = connection.createStatement();
			String sqlQuery = "select * from seat";
			rs = statement.executeQuery(sqlQuery);
			
			while(rs.next()) {
				int seatNumber = rs.getInt("seat_Number");
				String seatRow = rs.getString("seat_Row");
				String seatClass = rs.getString("seat_Class");
				int screenId = rs.getInt("screen_Number");		
				allSeats.add(new Seat(seatNumber, seatRow, seatClass, screenId));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return allSeats;
	}

	@Override
	public Map<Seat, Boolean> getSeatAvailabilityByScreen(int screenId) {
		Map<Seat, Boolean> response = new HashMap<Seat, Boolean>();
		ResultSet rs = null;
		try {
			String sqlQuery = "select * from seat where screen_Number = ?";
			PreparedStatement ps = connection.prepareStatement(sqlQuery);
			ps.setInt(1,screenId);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int seatNumber = rs.getInt("seat_Number");
				String seatRow = rs.getString("seat_Row");
				String seatClass = rs.getString("seat_Class");
				int screen_Id = rs.getInt("screen_Number");		
				response.put(new Seat(seatNumber, seatRow, seatClass, screen_Id), true);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return response;
	}

	@Override
	public void addSeat(Seat seat) {
		try {
			String sqlQuery = "INSERT INTO seat (seat_Number, seat_Row, seat_Class, screen_Number) VALUES (?,?,?,?)";
			PreparedStatement ps = connection.prepareStatement(sqlQuery);
			ps.setInt(1, seat.getSeatNumber());
			ps.setString(2, seat.getSeatRow());
			ps.setString(3, seat.getSeatClass());
			ps.setInt(4, seat.getScreenId());
			int seatAdded = ps.executeUpdate();

			System.out.println("execute boolean output = " + seatAdded + "\n");
			
			if (seatAdded > 0) {
				System.out.println("Added seat to database");
			} else {
				System.out.println("Error adding seat " + seat.getSeatNumber() + " " + seat.getSeatRow());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateSeat(Seat seat) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteSeat(int seatNumber, String seatRow) {
		try {
			String sqlQuery = "DELETE FROM SEAT WHERE SEAT_NUMBER = ? AND SEAT_ROW = ?";
			PreparedStatement ps = connection.prepareStatement(sqlQuery);
			ps.setInt(1, seatNumber);
			ps.setString(2, seatRow);
			
			int rowDeleted = ps.executeUpdate();
			
			if(rowDeleted > 0) {
				System.out.println("Seat deleted");
			}
			else {
				System.out.println("Error deleting seat with Id = " + seatNumber);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
