package edu.neu.csye6200.dao;

import java.util.List;

import edu.neu.csye6200.model.Show;

public interface ShowDao {
    List<Show> getAllShowsByMovieId(int movieId);

    Show getShowById(int id);

    void addShow(Show show);
    
    void updateShow(Show show);
    
    void deleteShow(int id);
}
