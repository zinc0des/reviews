package org.wecancodeit.reviews;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ReviewRepository {

	Map<Long, Review> listOfReviews = new HashMap<>();

	public ReviewRepository() {
		Review music = new Review(1L, "Beethoven was a gifted musician", "Classical Music", "Music",
				"This is no secret...", "http://www.music.edu");
		Review tennis = new Review(1L, "Serena Willams is awesome", "Tennis", "Sports", "I love watching Serena serve.",
				"http://www.wimbledon.com");
		Review burger = new Review(1L, "How to make a juicy vegan burger", "Food", "Cooking",
				"Ever had a vegan burger?", "http://www.cooking.org");

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

