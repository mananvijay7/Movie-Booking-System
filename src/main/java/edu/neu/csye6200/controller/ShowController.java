package edu.neu.csye6200.controller;

import java.util.List;
import edu.neu.csye6200.dao.ShowDao;
import edu.neu.csye6200.dao.ShowDaoImpl;
import edu.neu.csye6200.model.Show;

public class ShowController {
	ShowDao showDao = new ShowDaoImpl();
	public List<Show> getShowsOfMovie(int movieId){
		return showDao.getAllShowsByMovieId(movieId);
	}
	
    public Show getShowById(int id) {
        return showDao.getShowById(id);
    }
    
    public List<Integer> getShowsOnScreen(int screenId) {
    	return showDao.getShowsByScreenId(screenId);
    }
    
    public void addShow(Show show) {
    	showDao.addShow(show);
    }
    
    public void updateShow(Show show) {
    	showDao.updateShow(show);
    }
    
    public void deleteShow(int id) {
    	showDao.deleteShow(id);
    }
}
