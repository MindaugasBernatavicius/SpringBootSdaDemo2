package cf.mindaugas.sdasprintbootdemo2.repository;


import cf.mindaugas.sdasprintbootdemo2.model.BlogPost;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BlogPostInMemRepository {

	// we either need this
	static List<BlogPost> posts = new ArrayList<>();
	// List<BlogPost> posts = new ArrayList<BlogPost>(){{
	// 	add(new BlogPost(1, "Mindaugas", "Post 1"));
	// 	add(new BlogPost(2, "Kazys", "Post 2"));
	// 	BlogPost bp3 = new BlogPost();
	// 	bp3.setId(3);
	// 	bp3.setAuthor("Pranas");
	// 	bp3.setPost("Post3");
	// 	add(bp3);
	// }};

	// ... or we need this
	public void setPosts(List<BlogPost> posts){
		this.posts = posts;
	}

	// ... or we need this
	public void init(){
		this.posts = new ArrayList<>();
	}

	public List<BlogPost> getAllPosts(){
		return posts;
	}

	public void addPost(BlogPost post){
		// ... or we need this
		// if (this.posts == null) this.posts = new ArrayList<>();
		posts.add(post);
	}
}
