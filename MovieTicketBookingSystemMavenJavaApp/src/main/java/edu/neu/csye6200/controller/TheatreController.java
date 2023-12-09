package edu.neu.csye6200.controller;

import java.util.List;
import edu.neu.csye6200.dao.*;
import edu.neu.csye6200.model.Theatre;

public class TheatreController {
	private TheatreDao theatreDao = new TheatreDaoImpl();
	
	public List<Theatre> getAllTheatres(){
		return theatreDao.getAllTheatres();
	}
	
    public Theatre getTheatreById(int id) {
        return theatreDao.getTheatreById(id);
    }
    
    public void addTheatre(Theatre theatre) {
    	theatreDao.addTheatre(theatre);
    }
    
    public void updateTheatre(Theatre theatre) {
    	theatreDao.updateTheatre(theatre);
    }
    
    public void deleteTheatre(int id) {
    	theatreDao.deleteTheatre(id);
    }
}
