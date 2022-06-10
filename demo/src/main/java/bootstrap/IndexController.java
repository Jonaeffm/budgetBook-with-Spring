package bootstrap;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import domain.Budget;
import repositories.budgetRepository;
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
	
	/*@GetMapping("/budgets")
	@ResponseBody
	public ModelAndView getBudget(Model model) {

        var Budgets = (List<Budget>) BudgetService.findAll();

        var params = new HashMap<String, Object>();
        params.put("budgets", Budgets);

        return new ModelAndView("showBudgets", params);
		//model.addAttribute( attributeName: "budgets",BudgetService.findAll());
    }*/
	 
	 @GetMapping("/budgets")
	 public String getBudgets(Model model)
	 {
		 model.addAttribute("budgets",BudgetService.findAll());
		model.addAttribute("byDate", Comparator.comparing(Budget::getDate));
		 return "showBudgets";
	 }

	  @RequestMapping(value="/addBudget", method=RequestMethod.GET)
	    public String showStudentInfo(Model model) {
	        model.addAttribute("budgets", new Budget());
	        //model.addAttribute("byDate", Comparator.comparing(Budget::getDate));
	        return "insert";
	    }
	 
	 @RequestMapping(value="/addBudget", method=RequestMethod.POST) 
        public String processStudentInfo(@ModelAttribute("budgets") Budget 
        		budgetToAdd){ 
            BudgetService.addBudget(budgetToAdd);
            return "insert"; 
        }
	 
	 @GetMapping("/delete/{id}")
	 public String deleteBudget(@PathVariable("id") long id, Model model) {
	     
	     BudgetService.deleteById(id);
	     return "redirect:/budgets";}

        /*    @RequestMapping(method = RequestMethod.GET, value = "/test2/")
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
