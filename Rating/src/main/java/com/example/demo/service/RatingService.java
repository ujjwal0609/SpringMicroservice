package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dao.RatingDAO;
import com.example.demo.entity.Rating;

public class RatingService {
	
	@Autowired
	RatingDAO ratingDAO;
	
	public List<Rating> findRatingbyBookId(long bookId){
	
		List<Rating> li = new ArrayList<Rating>();
			li.add(ratingDAO.findByBookId(bookId))		;
			return li;
	}
	
	public List<Rating> findAllRating(){
		return ratingDAO.findAll();
	}
	
	public Rating createRating(Rating rating) {
		return  ratingDAO.save(rating);
	}
	
	public void deleteRating (long ratingId) {
	    ratingDAO.deleteById(ratingId);
	
	}
	
	
	public Rating updateRating (long ratingId , int stars ) {
		Rating rating = ratingDAO.findById(ratingId).get();
		rating.setStars(stars);
		ratingDAO.saveAndFlush(rating);
		return rating;
		
	}
}
