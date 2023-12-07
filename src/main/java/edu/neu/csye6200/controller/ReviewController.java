package edu.neu.csye6200.controller;

import java.util.List;

import edu.neu.csye6200.dao.*;
import edu.neu.csye6200.model.*;

public class ReviewController {
	private ReviewDao reviewDao = new ReviewDaoImpl();
	private MovieDao movieDao = new MovieDaoImpl();
	
	public Review getReviewById(int id) {
    	Review review = reviewDao.getReviewById(id);
        return review;
    }
    public void addReview(Review review) {
    	// Add record to Review
    	reviewDao.addReview(review);	
    }
    
    public void updateReview(Review review) {
    	reviewDao.updateReview(review);
    }
    
    public void deleteReview(int id) {    	
    	// Delete Review record
    	reviewDao.deleteReview(id);
    }

}
