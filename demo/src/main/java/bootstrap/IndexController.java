package bootstrap;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import domain.Budget;
import service.BudgetService;
import service.IBudgetService;


@Controller
public class IndexController {

	/*IndexController(IBudgetService BudgetService){
		this.BudgetService = BudgetService;
		
	}*/
	
	 @Autowired
	 private IBudgetService BudgetService;
	/*
	@RequestMapping(method = RequestMethod.GET, value ="/test/")
	public ModelAndView Index() throws IOException
	{
		/*System.out.println("TEST");
		return "index.html";*/
		/*ModelAndView modelAndView = new ModelAndView();
	    modelAndView.setViewName("index.html");
	    return modelAndView;*/
	/*
		    ModelAndView modelAndView = new ModelAndView();
		    modelAndView.setViewName("index.html");
		    return modelAndView;
		
	}*/
	/*
	@GetMapping("/budgets")
	@ResponseBody
	public ModelAndView getBudget() {

        var Budgets = (List<Budget>) BudgetService.findAll();

        var params = new HashMap<String, Object>();
        params.put("budgets", Budgets);

        return new ModelAndView("showBudgets", params);
    }*/
/*

	    @RequestMapping(method = RequestMethod.GET, value = "/test2/")
	    public ModelAndView welcome() {
	        ModelAndView modelAndView = new ModelAndView();
	        modelAndView.setViewName("index.html");
	        return modelAndView;
	    }
	*/
	 
	   @GetMapping(value = "/show")
	    public ModelAndView show() {

	        var mav = new ModelAndView();

	       
	        mav.setViewName("index");

	        return mav;
	    }
	
}

/*
 * 
 *
 *@Controller
public class MyController {

    @Autowired
    private ICountryService countryService;

    @GetMapping("/countries")
    public ModelAndView getCountries() {

        var countries = (List<Country>) countryService.findAll();

        var params = new HashMap<String, Object>();
        params.put("countries", countries);

        return new ModelAndView("showCountries", params);
    }
}
 *
 *
 *
 */
