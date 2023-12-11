package edu.neu.csye6200.dao;

import edu.neu.csye6200.model.*;

import java.util.List;

public interface MovieDao {
    List<Movie> getAllMovies();

    Movie getMovieById(int id);

    void addMovie(Movie movie);
    
    void updateMovie(Movie movie);
    
    void deleteMovie(int id);

    public Movie getMovieByName(String movieName);
}
