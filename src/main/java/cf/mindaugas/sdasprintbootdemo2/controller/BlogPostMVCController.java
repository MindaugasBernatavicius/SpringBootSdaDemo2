package cf.mindaugas.sdasprintbootdemo2.controller;

import cf.mindaugas.sdasprintbootdemo2.repository.BlogPostInMemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogPostMVCController {
	@Autowired
	private BlogPostInMemRepository bpr;

	// get all posts
	@GetMapping("/post")
	public String getAllPosts(Model model) {
		model.addAttribute("posts", bpr.getAllPosts());
		return "posts.html"; //view
	}
}