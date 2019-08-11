package cf.mindaugas.sdasprintbootdemo2.repository;

import cf.mindaugas.sdasprintbootdemo2.model.BlogPost;
import org.springframework.data.repository.CrudRepository;

public interface BlogPostRepository extends CrudRepository<BlogPost, Long> { }