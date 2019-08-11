package cf.mindaugas.sdasprintbootdemo2.controller;

import cf.mindaugas.sdasprintbootdemo2.model.BlogPost;
import cf.mindaugas.sdasprintbootdemo2.repository.BlogPostInMemRepository;
import cf.mindaugas.sdasprintbootdemo2.repository.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BlogPostMVCController {
	@Autowired
	// private BlogPostInMemRepository bpr;
	private BlogPostRepository bpr;

	// // get all posts
	// @GetMapping("/post")
	// public String getAllPosts(Model model) {
	// 	model.addAttribute("posts", bpr.getAllPosts());
	// 	return "posts.html"; //view
	// }

	// // add post
	// @PostMapping(path="/post", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	// public String addPost(@RequestParam("author") String author, @RequestParam("post") String post) {
	// 	bpr.addPost(new BlogPost(bpr.getAllPosts().size() + 1, author, post));
	// 	return "redirect:/post"; //view
	// }

	// get all posts
	@GetMapping("/post")
	public String getAllPosts(Model model) {
		// model.addAttribute("posts", bpr.getAllPosts());
		model.addAttribute("posts", bpr.findAll());
		return "posts.html"; //view
	}

	// add post
	@PostMapping(path="/post", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public String addPost(@RequestParam String author, @RequestParam String post) {
		// bpr.addPost(new BlogPost(bpr.getAllPosts().size() + 1, author, post));
		bpr.save(new BlogPost(author, post));
		return "redirect:/post"; //view
	}
}