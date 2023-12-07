package edu.neu.csye6200.dao;

import java.util.List;
import java.util.Map;

import edu.neu.csye6200.model.Seat;

public interface SeatDao {
    List<Seat> getAllSeats();

    Map<Seat, Boolean> getSeatAvailabilityByScreen(int screenId);

    void addSeat(Seat seat);
    
    void updateSeat(Seat seat);
    
    void deleteSeat(int seatNumber, String seatRow);

}
