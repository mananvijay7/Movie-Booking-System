package edu.neu.csye6200.controller;

import java.util.List;

import edu.neu.csye6200.dao.*;
import edu.neu.csye6200.model.Theatre;

public class TheatreController {
	private TheatreDao theatreDao = new TheatreDaoImpl();
	private MovieDao movieDao = new MovieDaoImpl();
	private ShowDao showDao = new ShowDaoImpl();
	
	public int getTheatreByName(String theatreName) {
		return theatreDao.getTheatreByName(theatreName);
	}
    
    public void addTheatre(Theatre theatre) {
    	theatreDao.addTheatre(theatre);
    }
    
    public void deleteTheatre(int id) {
    	theatreDao.deleteTheatre(id);
    }
    
    public List<String> getTheatresForMovie(String movieName) {
    	int movieId = movieDao.getMovieByMovieName(movieName);
    	List<Integer> screens = showDao.getScreensByMovieId(movieId);
    	List<String> theatres = theatreDao.getTheatresByScreen(screens);
    	//Collections.sort(theatres, Comparator.comparing(Theatre::getName));
    	return theatres;
    }
}
