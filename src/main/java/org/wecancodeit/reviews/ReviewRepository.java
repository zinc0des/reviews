package org.wecancodeit.reviews;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class ReviewRepository {

	private Map<Long, Review> listOfReviews = new HashMap<>();

	public ReviewRepository() {
		Review music = new Review(1L, "Beethoven was a gifted musician", "Classical Music", "Music",
				"This is no secret...", "images/beethoven.jpg");
		Review tennis = new Review(2L, "Serena Willams is awesome", "Tennis", "Sports", "I love watching Serena serve.",
				"images/serena-williams.jpg");
		Review burger = new Review(3L, "How to make a juicy veggie burger", "Food", "Cooking",
				"Ever had a vegan burger?", "images/veggie-burger.jpg");

		listOfReviews.put(music.getId(), music);
		listOfReviews.put(tennis.getId(), tennis);
		listOfReviews.put(burger.getId(), burger);
	}

	public ReviewRepository(Review... anyAmountOfReviews) {
		for (Review anyReview : anyAmountOfReviews) {
			listOfReviews.put(anyReview.getId(), anyReview);
		}
	}

	public Review findOneReview(long id) {
		return listOfReviews.get(id);
	}

	public Collection<Review> findAll() {
		return listOfReviews.values();
	}

}

