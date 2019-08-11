package cf.mindaugas.sdasprintbootdemo2;

import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.spring5.SpringTemplateEngine;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

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

	Map<String, String> people = new LinkedHashMap<String, String>(){{
		put("Mindaugas", "Bernatavičius");
		put("Jonas", "Kraveckas");
	}};

	@GetMapping(path = "/see-map")
	public String seeMap(Model model){
		model.addAttribute("map", people);
		return "map";
	}

	@PostMapping(path="/add-to-map", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public String addToMap(Model model, @RequestParam("name") String name, @RequestParam("surname") String surname) {
		people.put(name, surname);
		return "redirect:/see-map";
	}

	public static void main(String[] args) {
		SpringTemplateEngine engine = new SpringTemplateEngine();
		engine.addDialect(new LayoutDialect());
		SpringApplication.run(Sdasprintbootdemo2Application.class, args);
	}
}
