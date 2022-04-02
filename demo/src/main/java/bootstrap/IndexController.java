package bootstrap;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@EnableAutoConfiguration
@Controller
public class IndexController {

	@RequestMapping("/")
	public String Index()
	{
		return "index";
		
	}
}
