package org.wecancodeit.reviews;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;

import java.util.Collection;

import org.junit.Test;

public class ReviewRepositoryTest {

	ReviewRepository underTest;

	long reviewOneId = 1L;
	Review reviewOne = new Review(reviewOneId, "review one title", "review one description", "category one",
			"content one", "http://osu.com");

	long reviewTwoId = 2L;
	Review reviewTwo = new Review(reviewTwoId, "review two title", "review two description", "category one",
			"content two", "http://psu.com");

	@Test
	public void shouldFindAReview() {
		underTest = new ReviewRepository(reviewOne);
		Review foundReview = underTest.findOneReview(reviewOneId);
		assertThat(foundReview, is(reviewOne));
	}

	@Test
	public void shouldFindAnotherReview() {
		underTest = new ReviewRepository(reviewTwo);
		Review foundReview = underTest.findOneReview(reviewTwoId);
		assertThat(foundReview, is(reviewTwo));
	}

	@Test
	public void shouldFindAllReviews() {
		underTest = new ReviewRepository(reviewOne, reviewTwo);
		Collection<Review> foundReviews = underTest.findAll();
		assertThat(foundReviews, containsInAnyOrder(reviewOne, reviewTwo));
	}

	@Test
	public void shouldRenderReviewProperties() {
		String title = reviewOne.getTitle();
		String content = reviewOne.getContent();
		assertThat(title, is("review one title"));
		assertThat(content, is("content one"));
	}
}


