package cf.mindaugas.sdasprintbootdemo2.controller;

import cf.mindaugas.sdasprintbootdemo2.model.BlogPost;
import cf.mindaugas.sdasprintbootdemo2.repository.BlogPostInMemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/v1")
public class BlogPostController {

	Map<String, List<String>> posts = new HashMap<String, List<String>>(){{
		put("1", Arrays.asList("Mindaugas", "Hello world blog post!"));
		put("2", Arrays.asList("Romas", "Karbauskio dienoraštis"));
		put("3", Arrays.asList("Bromas", "Valinsko dienoraštis"));
	}};

	// List<BlogPost> posts2 = new ArrayList<BlogPost>(){{
	// 	add(new BlogPost(1, "Mindaugas", "Post 1"));
	// 	add(new BlogPost(2, "Kazys", "Post 2"));
	// }};

	@Autowired
	BlogPostInMemRepository bpr;

	// // get all posts
	// @RequestMapping(method = RequestMethod.GET, path="/post")
	// public List<BlogPost> getAllPosts2() {
	// 	return posts2;
	// }

	// get all posts
	@RequestMapping(method = RequestMethod.GET, path="/post")
	public @ResponseBody List<BlogPost> getAllPosts() {
		return bpr.getAllPosts();
	}

	// // get all posts
	// @RequestMapping(method = RequestMethod.GET, path="/post")
	// public @ResponseBody Map getAllPosts() {
	// 	return posts;
	// }

	// get single post by id
	@RequestMapping(method = RequestMethod.GET, path="/post/{id}")
	public List<String> getPostById(@PathVariable String id) {
		System.err.println("getPost /post/{id} hit");
		return posts.get(id);
	}

	// get single post
	@RequestMapping(method = RequestMethod.GET, path="/single_post")
	public Map getPost(@RequestParam String id) {
		System.err.println("getPost /single_post hit");
		return new HashMap<String, List<String>>(){{
			put(id, posts.get(id)); }};
	}

	// // add post
	// @RequestMapping(method = RequestMethod.POST, path="/post",
	// 		consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	// public Map addPost(@RequestParam("id") String id,
	// 				   @RequestParam("author") String author,
	// 				   @RequestParam("post") String post) {
	// 	posts.put(id, Arrays.asList(author, post));
	// 	return posts;
	// }

	// add post
	@RequestMapping(method = RequestMethod.POST, path="/post",
			consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public @ResponseBody List<BlogPost> addPost(BlogPost post) {
		bpr.addPost(post);
		return bpr.getAllPosts();
	}

	// delete post
	@RequestMapping(method = RequestMethod.DELETE, path="/post/{id}")
	public Map deletePost(@PathVariable String id) {
		posts.remove(id);
		return posts;
	}
}
