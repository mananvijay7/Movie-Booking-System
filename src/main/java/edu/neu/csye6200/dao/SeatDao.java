package edu.neu.csye6200.dao;

import java.util.List;
import java.util.Map;

import edu.neu.csye6200.model.Seat;

public interface SeatDao {
    List<Seat> getAllSeats();

    Map<Seat, Boolean> getSeatAvailabilityByScreen(int screenId);

    List<Seat> getAllSeatsByScreen(int screenId);
    
    List<Integer> getSeatAvailabilityByShow(int showId);
    
    int addSeat(Seat seat);
    
    void addSeatAvailability(int seatId, List<Integer> shows);
    
    void updateSeat(Seat seat);
    
    void deleteSeat(int seatNumber, String seatRow);
    
    List<Integer> getAvailableSeatsByShow(int showId);
    
    int getAvailableSeatCount(int showId);
    
    void updateSeatAvailability(List<Integer> seats, int showId);

}
