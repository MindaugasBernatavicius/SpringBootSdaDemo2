package cf.mindaugas.sdasprintbootdemo2.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter @Setter @ToString
@NoArgsConstructor @RequiredArgsConstructor
public class BlogPost {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	private @NonNull String author;
	private @NonNull String post;
}


// import lombok.Getter;
// import lombok.NoArgsConstructor;
// import lombok.Setter;
//
// @Getter @Setter @NoArgsConstructor
// public class BlogPost {
// 	private int id;
// 	private String author;
// 	private String post;
//
// 	public BlogPost(int id, String author, String post) {
// 		this.id = id;
// 		this.author = author;
// 		this.post = post;
// 	}
// }


// public class BlogPost {
// 	private int id;
// 	private String author;
// 	private String post;
//
// 	public BlogPost() {}
//
// 	public BlogPost(int id, String author, String post) {
// 		this.id = id;
// 		this.author = author;
// 		this.post = post;
// 	}
//
// 	public int getId() {
// 		return id;
// 	}
//
// 	public void setId(int id) {
// 		this.id = id;
// 	}
//
// 	public String getAuthor() {
// 		return author;
// 	}
//
// 	public void setAuthor(String author) {
// 		this.author = author;
// 	}
//
// 	public String getPost() {
// 		return post;
// 	}
//
// 	public void setPost(String post) {
// 		this.post = post;
// 	}
// }

