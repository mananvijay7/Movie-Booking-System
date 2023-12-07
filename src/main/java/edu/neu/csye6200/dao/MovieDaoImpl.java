package edu.neu.csye6200.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.neu.csye6200.model.*;
import edu.neu.csye6200.repository.DatabaseConnection;

public class MovieDaoImpl implements MovieDao {

	Connection connection = DatabaseConnection.getDbInstance();
	
	@Override
	public List<Movie> getAllMovies() {
		List<Movie> allMovies = new ArrayList<Movie>();
		Statement statement;
		ResultSet rs = null;
		try {
			statement = connection.createStatement();
			String sqlQuery = "select * from movie";
			rs = statement.executeQuery(sqlQuery);
			
			while(rs.next()) {
				int movie_id = rs.getInt("movie_id");
				String movie_title = rs.getString("movie_title");
				String movie_description = rs.getString("movie_description");
				String movie_genere = rs.getString("movie_genere");
				int duration = rs.getInt("duration");		
				allMovies.add(new Movie(movie_id, movie_title, movie_description, movie_genere, duration));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return allMovies;
	}

	@Override
	public Movie getMovieById(int movie_id) {
		ResultSet rs = null;
		try {
			String sqlQuery = "select * from movie where movie_id = ?";
			PreparedStatement ps = connection.prepareStatement(sqlQuery);
			ps.setInt(1,movie_id);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int movieId = rs.getInt("movie_id");
				String movieTitle = rs.getString("movie_title");
				String movieDescription = rs.getString("movie_description");
				String movieGenere = rs.getString("movie_genre");
				int duration = rs.getInt("movie_duration");	
//				byte[] movieImage = rs.getBytes("movie_display_Image");
//				OutputStream outputStream = new FileOutputStream("Images/" + movieTitle+".jpeg");
				return new Movie(movie_id, movieTitle, movieDescription, movieGenere, duration);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return null;
	}

	@Override
	public void addMovie(Movie movie) {
	
		String sqlQuery = 	"INSERT INTO MOVIE "
				+ 			"(MOVIE_TITLE,MOVIE_DESCRIPTION,MOVIE_GENRE,MOVIE_DURATION,movie_display_Image) "
				+ 			"VALUES (?,?,?,?)";
		
		try {
//			String  imageName = movie.getTitle().toLowerCase()+"_1.jpg";
//			String fileLocation = "Images/MovieImages/" + imageName;
//			File imageFile = new File(fileLocation);
//            InputStream movieName = new FileInputStream(imageFile);
            
			PreparedStatement ps = connection.prepareStatement(sqlQuery);
			ps.setString(1, movie.getTitle());
			ps.setString(2, movie.getDescription());
			ps.setString(3, movie.getGenre());
			ps.setInt(4, movie.getDuration());
//			ps.setBlob(5, movieName);
			boolean movieAdded = ps.execute();
			System.out.println("execute boolean output = " + movieAdded + "\n");
			if(movieAdded) {
				System.out.println("Movie added to database");
			}else {
				System.out.println("Error adding movie with " + movie.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	@Override
	public void updateMovie(Movie movie) {
		
	}
	
	@Override
	public void deleteMovie(int id) {
		try {
			String sqlQuery = "DELETE FROM MOVIE WHERE MOVIE_ID = ?";
			PreparedStatement ps = connection.prepareStatement(sqlQuery);
			ps.setInt(1,id);
			
			boolean rowDeleted = ps.execute();
			
			if(rowDeleted) {
				System.out.println("Review deleted");
			}
			else {
				System.out.println("Error deleting movie with Id = " + id);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
    // Implement the methods

}

