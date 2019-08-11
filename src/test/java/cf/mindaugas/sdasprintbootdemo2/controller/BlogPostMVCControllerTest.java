package cf.mindaugas.sdasprintbootdemo2.controller;

import cf.mindaugas.sdasprintbootdemo2.repository.BlogPostInMemRepository;
import cf.mindaugas.sdasprintbootdemo2.repository.BlogPostRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(BlogPostMVCController.class)
public class BlogPostMVCControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	// private BlogPostInMemRepository repo;
	private BlogPostRepository repo;

	@Test
	public void testListProducts() throws Exception {
		mockMvc.perform(get("/post"))
				.andExpect(status().isOk())
				.andExpect(content()
						.string(containsString("Blog!</title>")));
	}
}