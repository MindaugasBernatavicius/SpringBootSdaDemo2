package cf.mindaugas.sdasprintbootdemo2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
public class Sdasprintbootdemo2Application extends SpringBootServletInitializer {

	@RequestMapping("/")
	public @ResponseBody String root() {
		return "Hello world!";
	}

	// Returns the hello.html, not a string.
	// This is the difference between @RestContoller and @Controller
	@RequestMapping("/hello")
	public String greeting(Model model,
		@RequestParam(value = "name", required=false) final String name
		//@RequestParam(value = "name", defaultValue = "anonymous") final String name
	){
		model.addAttribute("name_in_view", name);
		return "hello";
	}

	public static void main(String[] args) {
		SpringApplication.run(Sdasprintbootdemo2Application.class, args);
	}
}
