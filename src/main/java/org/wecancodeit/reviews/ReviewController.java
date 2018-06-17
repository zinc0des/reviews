package org.wecancodeit.reviews;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReviewController {
	
	@Resource
	ReviewRepository reviewRepo;
	
	@RequestMapping("/show-reviews")
	public String findAllReviews(Model model) {
		model.addAttribute("reviewsModel", reviewRepo.findAll());
		return "reviewsTemplate";
	}
	
	@RequestMapping("/show-single-review")
	public String findOneReview(@RequestParam(value = "id") long id, Model model) {
		model.addAttribute("reviewsModel", reviewRepo.findOneReview(id));
		return "reviewTemplate";
	}
}
