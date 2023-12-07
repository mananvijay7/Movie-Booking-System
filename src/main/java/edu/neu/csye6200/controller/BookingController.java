package edu.neu.csye6200.controller;
import java.util.List;

import edu.neu.csye6200.dao.*;
import edu.neu.csye6200.model.*;

public class BookingController {
	private MovieDao movieDao = new MovieDaoImpl();
	private BookingDao bookingDao = new BookingDaoImpl();
	
	public Booking getBookingById(int id) {
    	Booking booking = bookingDao.getBookingById(id);
        return booking;
    }
	
    public void addBooking(Booking booking) {
    	// Add record to Booking
    	bookingDao.addBooking(booking);	
    }
}
