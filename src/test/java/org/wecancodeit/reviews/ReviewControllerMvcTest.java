package org.wecancodeit.reviews;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.util.Arrays;
import java.util.Collection;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(ReviewController.class)
public class ReviewControllerMvcTest {
	@Resource
	private MockMvc mvc;
	
	@MockBean
	private ReviewRepository reviewRepo;
	
	@Mock
	private Review reviewOne;
	
	@Mock Review reviewTwo;
	
	@Test
	public void shouldBeOKForAllReviews() throws Exception {
		mvc.perform(get("/show-reviews")).andExpect(status().isOk());
	}
	
	@Test
	public void shouldGenerateViewForAllReviews() throws Exception {
		mvc.perform(get("/show-reviews")).andExpect(view().name("reviewsTemplate"));
	}

	@Test
	public void shouldShowAllReviewsInModel() throws Exception {
		Collection<Review> allReviewsInModel = Arrays.asList(reviewOne, reviewTwo);
		when(reviewRepo.findAll()).thenReturn(allReviewsInModel);
		mvc.perform(get("/show-reviews")).andExpect(model().attribute("reviewsModel", allReviewsInModel));
	}
	
	@Test
	public void shouldBeOkForAReview() throws Exception {
		mvc.perform(get("/show-single-review?id=1")).andExpect(status().isOk());
	}

	@Test
	public void shouldGenerateViewForACourse() throws Exception {
		mvc.perform(get("/show-single-review?id=1")).andExpect(view().name("reviewTemplate"));
	}
	
	@Test
	public void shouldShowARevieInModel() throws Exception {
		Long reviewOneId = 1L;
		when(reviewRepo.findOneReview(reviewOneId)).thenReturn(reviewOne);
		mvc.perform(get("/show-single-review?id=1")).andExpect(model().attribute("reviewsModel", reviewOne));
	}

}
