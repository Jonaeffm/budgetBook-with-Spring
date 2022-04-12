package bootstrap;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import domain.Budget;
import service.BudgetService;
import service.IBudgetService;


@Controller
@EnableAutoConfiguration
@RequestMapping("/")
public class IndexController {

	/*IndexController(IBudgetService BudgetService){
		this.BudgetService = BudgetService;
		
	}*/
	
	 @Autowired
	 private IBudgetService BudgetService;
	
	@GetMapping(value = "/")
	public String Index()
	{
		return "index";
		
	}
	
	@GetMapping(value="/budgets")
	public ModelAndView getBudget() {

        var Budgets = (List<Budget>) BudgetService.findAll();

        var params = new HashMap<String, Object>();
        params.put("budgets", Budgets);

        return new ModelAndView("showBudgets", params);
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
