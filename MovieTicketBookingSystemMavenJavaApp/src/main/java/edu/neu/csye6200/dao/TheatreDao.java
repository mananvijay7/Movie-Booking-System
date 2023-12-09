package edu.neu.csye6200.dao;

import java.util.List;

import edu.neu.csye6200.model.Theatre;

public interface TheatreDao {
    List<Theatre> getAllTheatres();

    Theatre getTheatreById(int id);

    void addTheatre(Theatre theatre);
    
    void updateTheatre(Theatre theatre);
    
    void deleteTheatre(int id);
}
