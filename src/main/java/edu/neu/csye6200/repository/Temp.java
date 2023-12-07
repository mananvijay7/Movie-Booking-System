package edu.neu.csye6200.repository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import edu.neu.csye6200.dao.*;
import edu.neu.csye6200.model.*;

public class Temp {
	public static void main(String[] args) {
		MovieDao movieDao = new MovieDaoImpl();
		ReviewDao reviewDao = new ReviewDaoImpl();
		 
//		movieDao.addMovie(new Movie("Animal", "Ranbir Kapoor Latest","Action",2));
		System.out.println(movieDao.getMovieById(4).toString());
		
//		//reviewDao.addReview(new Review(1, "Bollywood Hit Starrer Salman is an average movie"));
////		reviewDao.deleteReview(4);
//		System.out.println(reviewDao.getAllReviews().toString());
//		//movieDao.addMovie(new Movie("Tiger 3", "Salman Khan and Katrina Kaif", "Action", 2));
//		
//		TheatreDao theatreDao = new TheatreDaoImpl();
//		theatreDao.addTheatre(new Theatre(101, "PVR"));
//		theatreDao.addTheatre(new Theatre(102, "Inox"));
//		System.out.println(theatreDao.getAllTheatres().toString());
////		theatreDao.deleteTheatre(2);
//		List<Integer> screens = new ArrayList<Integer>();
//		screens.add(1);
//		
//		
// 		ScreenDao screenDao = new ScreenDaoImpl();
// 		System.out.println(screenDao.getAllScreens().toString());
//		screenDao.addScreen(new Screen(101, 60,1));
//		screenDao.addScreen(new Screen(102, 70,2));
//		System.out.println(screenDao.getAllScreens().toString());
////	    screenDao.deleteScreen(2);
//		System.out.println(screenDao.getAllScreens().toString());
//		
//		
//		theatreDao.addScreensToTheatre(new Theatre(4, "Cinepolis", screens));
//		System.out.println(theatreDao.getAllTheatres().toString());
////		System.out.println(theatreDao.getTheatreById(1).toString());
////		System.out.println(theatreDao.getTheatreById(3).toString());
//		
//
// 		
// 		SeatDao seatDao = new SeatDaoImpl();
// 		seatDao.addSeat(new Seat(9,"A","Economy", 5));
// 		seatDao.addSeat(new Seat(10,"A","Economy", 6));
// 		seatDao.addSeat(new Seat(11,"B","Economy", 7));
// 		seatDao.addSeat(new Seat(12,"B","Premium", 8));
// 		System.out.println(seatDao.getAllSeats().toString());
//// 		seatDao.deleteSeat(3, "A");
// 		System.out.println(seatDao.getAllSeats().toString()	);
// 		
// 		ShowDao showDao = new ShowDaoImpl();
// 		
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(Calendar.YEAR, 2023);
//        calendar.set(Calendar.MONTH, Calendar.NOVEMBER); // Remember, January is 0!
//        calendar.set(Calendar.DAY_OF_MONTH, 30);
//        calendar.set(Calendar.HOUR_OF_DAY, 10); // HOUR_OF_DAY for 24-hour format
//        calendar.set(Calendar.MINUTE, 05);
// 		showDao.addShow(new Show(calendar.getTime(), 2, 1));
// 		
//        calendar.set(Calendar.HOUR_OF_DAY, 3); // HOUR_OF_DAY for 24-hour format
//        calendar.set(Calendar.MINUTE, 25);
// 		showDao.addShow(new Show(calendar.getTime(), 3, 1));
// 		//System.out.println(showDao.getAllShowsByMovieId(3).toString());
	}
}

/*
 * Add Theatres
 * Add Screens
 * Add Screens To Theatres
 * Get Theatres / Screens
 */
	
