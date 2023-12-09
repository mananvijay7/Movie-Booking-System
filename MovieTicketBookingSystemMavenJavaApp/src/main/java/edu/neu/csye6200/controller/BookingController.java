package edu.neu.csye6200.controller;
import java.util.List;

import edu.neu.csye6200.dao.BookingDao;
import edu.neu.csye6200.dao.BookingDaoImpl;
import edu.neu.csye6200.dao.SeatDao;
import edu.neu.csye6200.dao.SeatDaoImpl;
import edu.neu.csye6200.model.Booking;

public class BookingController {
	private BookingDao bookingDao = new BookingDaoImpl();
	private SeatDao seatDao = new SeatDaoImpl();
	
	public List<Booking> getAllCustomerBookings(int id) {
		List<Booking> booking = bookingDao.getAllBookingsByCustomerId(id);
        return booking;
    }
	
	public Booking getBookingById(int bookingId) {
		return bookingDao.getBookingById(bookingId);
	}
	
    public void addBooking(Booking booking) {
    	bookingDao.addBooking(booking);
    	seatDao.updateSeatAvailability(booking.getBookedSeats(), booking.getShowId());
    }
    
    public void updateBooking(Booking booking) {
    	bookingDao.updateBooking(booking);
    }
    
    public void deleteBooking(int id) {
    	bookingDao.deleteBooking(id);
    }
}
