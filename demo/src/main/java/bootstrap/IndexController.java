package bootstrap;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import domain.IntDate;
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
		
		double total=0;
		List<Budget> b = BudgetService.findAll();
		for (int i= 0;i<b.size();i++)
		{
			total = total+b.get(i).getPrice();
		}
		
		 // get the total of your list
				  model.addAttribute("total", total);
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
            return "success"; 
        }
	 
	 @RequestMapping(value="/selectDate", method=RequestMethod.GET)
	    public String selectDate(Model model) {
	        model.addAttribute("budgets", new Budget());
	        //model.addAttribute("byDate", Comparator.comparing(Budget::getDate));
	        return "selectDate";
	    }
	 
	 @RequestMapping(value="/selectDate", method=RequestMethod.POST) 
     public String selectDate(Model model,@ModelAttribute("budgets") Budget 
     		budgetToAdd){
		
		 
		// BudgetService.addBudget(budgetToAdd);
          
		 model.addAttribute("budgets",BudgetService.findByDate(budgetToAdd.getDate()));
			model.addAttribute("byDate", Comparator.comparing(Budget::getDate));
			double total=0;
			List<Budget> b = BudgetService.findByDate(budgetToAdd.getDate());
			for (int i= 0;i<b.size();i++)
			{
				total = total+b.get(i).getPrice();
			}
			
			 // get the total of your list
					  model.addAttribute("total", total);
		 
		 
		 return "showBudgets";
		 
		// getBudgetsTest(model, budgetToAdd.getDate());
        
        
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
	
	   

		 @GetMapping("/budgetsTest")
		 public String getBudgetsTest(Model model,Date d)
		 {
			
				 model.addAttribute("budgets",BudgetService.findByDate(d));
				model.addAttribute("byDate", Comparator.comparing(Budget::getDate));
			
			 
			 
			 return "showBudgets";
		 }
		 
		 @RequestMapping(value="/selectMonth", method=RequestMethod.GET)
		    public String selectMonth(Model model) {
		        model.addAttribute("intdate", new IntDate());
		        //model.addAttribute("byDate", Comparator.comparing(Budget::getDate));
		        return "selectMonth";
		    }
		 
		 @RequestMapping(value="/selectMonth", method=RequestMethod.POST) 
		 public String selectMonth(Model model,@ModelAttribute("intdate") IntDate 
		     		dateToAdd){
				
				 
				// BudgetService.addBudget(budgetToAdd);
		          
				 model.addAttribute("budgets",BudgetService.findByMonth(dateToAdd.getDate()));
					model.addAttribute("byDate", Comparator.comparing(Budget::getDate));
					double total=0;
					List<Budget> b = BudgetService.findByMonth(dateToAdd.getDate());
					for (int i= 0;i<b.size();i++)
					{
						total = total+b.get(i).getPrice();
					}
					
					 // get the total of your list
							  model.addAttribute("total", total);
				 
				 
				 return "showBudgets";
				 
				// getBudgetsTest(model, budgetToAdd.getDate());
		        
		        
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
