package com.example.demo.contrroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Rating;
import com.example.demo.service.RatingService;

@RestController
@RequestMapping("/rating")
public class RatingController {
	
	@Autowired
	 RatingService ratingService;
	 
	@GetMapping
	public List<Rating> findRatingbyBookId(
			@RequestParam (required = false,defaultValue = "0")Long bookId){
		
		if (bookId.equals(0L)){
			return ratingService.findAllRating();
			
		}
		return ratingService.findRatingbyBookId(bookId);
	}

	@PostMapping
	public Rating createRating( @RequestBody Rating rating) {
		return ratingService.createRating(rating);
	}
	
	@DeleteMapping("/{ratingId}")
	public void deleteRating ( @PathVariable long ratingId) {
		 ratingService.deleteRating(ratingId);
	}
	
	@PutMapping("/{ratingId}/{stars}")
	public Rating updateRating ( @PathVariable long ratingId , @PathVariable int stars ) {
	return ratingService.updateRating(ratingId, stars);
	}
}
