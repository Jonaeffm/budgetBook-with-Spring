package bootstrap;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import domain.Budget;
import domain.Income;
import domain.IntDate;
import domain.searchString;
import service.IBudgetService;
import service.IIncomeService;

@Controller
public class IndexController {

	/*
	 * IndexController(IBudgetService BudgetService){ this.BudgetService =
	 * BudgetService;
	 * 
	 * }
	 */

	@Autowired
	private IBudgetService BudgetService;

	@Autowired
	private IIncomeService IncomeService;

	/*
	 * @RequestMapping(method = RequestMethod.GET, value ="/test/") public
	 * ModelAndView Index() throws IOException { /*System.out.println("TEST");
	 * return "index.html";
	 */
	/*
	 * ModelAndView modelAndView = new ModelAndView();
	 * modelAndView.setViewName("index.html"); return modelAndView;
	 */
	/*
	 * ModelAndView modelAndView = new ModelAndView();
	 * modelAndView.setViewName("index.html"); return modelAndView;
	 * 
	 * }
	 */

	/*
	 * @GetMapping("/budgets")
	 * 
	 * @ResponseBody public ModelAndView getBudget(Model model) {
	 * 
	 * var Budgets = (List<Budget>) BudgetService.findAll();
	 * 
	 * var params = new HashMap<String, Object>(); params.put("budgets", Budgets);
	 * 
	 * return new ModelAndView("showBudgets", params); //model.addAttribute(
	 * attributeName: "budgets",BudgetService.findAll()); }
	 */

	public ArrayList<Income> periodic(Income b){
		ArrayList<Income> result = new ArrayList<Income>();
		result.add(b);

		Date d = b.getInserted();
		
//		LocalDate ld = d.toLocalDate();
//		LocalDate monthLater = ld.plusMonths( 1 );
//		java.sql.Date d2 = java.sql.Date.valueOf( monthLater );
		
//		Calendar c = Calendar.getInstance(); 
//		c.setTime(d); 
//		c.add(Calendar.MONTH, 1);
//		d= new java.sql.Date(c.getTimeInMillis());
		for (int i=1;i<12;i++)
		{
			Date d2=Date.valueOf(d.toLocalDate().plusMonths(i));
			Income b2 = new Income(d2,b.getDetail(),b.getAmount());
		
			result.add(b2);
		}
		return result;
		
	}
	
	public ArrayList<Budget> periodic(Budget b){
		ArrayList<Budget> result = new ArrayList<Budget>();
		result.add(b);

		Date d = b.getDate();
		
//		LocalDate ld = d.toLocalDate();
//		LocalDate monthLater = ld.plusMonths( 1 );
//		java.sql.Date d2 = java.sql.Date.valueOf( monthLater );
		
//		Calendar c = Calendar.getInstance(); 
//		c.setTime(d); 
//		c.add(Calendar.MONTH, 1);
//		d= new java.sql.Date(c.getTimeInMillis());
		for (int i=1;i<12;i++)
		{
			Date d2=Date.valueOf(d.toLocalDate().plusMonths(i));
			Budget b2 = new Budget(d2,b.getProduct(),b.getPrice());
		
			result.add(b2);
		}
		return result;
		
	}
	
	@RequestMapping("/login")
    public String login(Model model) {
        return "login";
    }
	
	@GetMapping({"/budgets","/"})
	public String getBudgets(Model model) {
		model.addAttribute("incomes", IncomeService.findAll());
		model.addAttribute("budgets", BudgetService.findAll());
		model.addAttribute("byDate", Comparator.comparing(Budget::getDate));
		model.addAttribute("byIncomeDate", Comparator.comparing(Income::getInserted));

		double total = 0;
		List<Budget> b = BudgetService.findAll();
		List<Income> ic = IncomeService.findAll();
		for (int i = 0; i < b.size(); i++) {

			total = total - b.get(i).getPrice();
		}
		for (int i = 0; i < ic.size(); i++) {
			total = total + ic.get(i).getAmount();
		}
		// get the total of your list
		model.addAttribute("total", total);
		return "showBudgets";
	}

	@RequestMapping(value = "/addBudget", method = RequestMethod.GET)
	public String showStudentInfo(Model model) {
		model.addAttribute("budgets", new Budget());
		// model.addAttribute("byDate", Comparator.comparing(Budget::getDate));
		return "insert";
	}

	@RequestMapping(value = "/addBudget", method = RequestMethod.POST)
	public String processStudentInfo(@ModelAttribute("budgets") Budget budgetToAdd) {
		if(budgetToAdd.getPeriodic())
				{
					ArrayList<Budget> toAdd = periodic(budgetToAdd);
					for(int i=0;i<toAdd.size();i++)
						BudgetService.addBudget(toAdd.get(i));
				}
		else
			BudgetService.addBudget(budgetToAdd);
		return "success";
	}

	@RequestMapping(value = "/selectDate", method = RequestMethod.GET)
	public String selectDate(Model model) {
		model.addAttribute("budgets", new Budget());
		// model.addAttribute("byDate", Comparator.comparing(Budget::getDate));
		return "selectDate";
	}

	@RequestMapping(value = "/selectDate", method = RequestMethod.POST)
	public String selectDate(Model model, @ModelAttribute("budgets") Budget budgetToAdd) {

		// BudgetService.addBudget(budgetToAdd);
		model.addAttribute("incomes", IncomeService.findByDate(budgetToAdd.getDate()));
		model.addAttribute("budgets", BudgetService.findByDate(budgetToAdd.getDate()));
		model.addAttribute("byDate", Comparator.comparing(Budget::getDate));
		model.addAttribute("byIncomeDate", Comparator.comparing(Income::getInserted));

		double total = 0;
		List<Budget> b = BudgetService.findByDate(budgetToAdd.getDate());
		List<Income> ic = IncomeService.findByDate(budgetToAdd.getDate());
		for (int i = 0; i < b.size(); i++) {

			total = total - b.get(i).getPrice();
		}
		for (int i = 0; i < ic.size(); i++) {
			total = total + ic.get(i).getAmount();
		}
		// get the total of your list
		model.addAttribute("total", total);

		return "showBudgets";

		// getBudgetsTest(model, budgetToAdd.getDate());

	}

	@GetMapping("/deleteIncome/{id}")
	public String deleteIncome(@PathVariable("id") long id, Model model) {

		IncomeService.deleteById(id);
		return "redirect:/budgets";
	}

	@GetMapping("/delete/{id}")
	public String deleteBudget(@PathVariable("id") long id, Model model) {

		BudgetService.deleteById(id);
		return "redirect:/budgets";
	}

	/*
	 * @RequestMapping(method = RequestMethod.GET, value = "/test2/") public
	 * ModelAndView welcome() { ModelAndView modelAndView = new ModelAndView();
	 * modelAndView.setViewName("index.html"); return modelAndView; }
	 */

	@GetMapping(value = "/show")
	public ModelAndView show() {

		var mav = new ModelAndView();

		mav.setViewName("index");

		return mav;
	}

	@GetMapping("/budgetsTest")
	public String getBudgetsTest(Model model, Date d) {

		model.addAttribute("budgets", BudgetService.findByDate(d));
		model.addAttribute("byDate", Comparator.comparing(Budget::getDate));
		model.addAttribute("byIncomeDate", Comparator.comparing(Income::getInserted));

		return "showBudgets";
	}

	@RequestMapping(value = "/selectMonth", method = RequestMethod.GET)
	public String selectMonth(Model model) {
		model.addAttribute("intdate", new IntDate());
		// model.addAttribute("byDate", Comparator.comparing(Budget::getDate));
		return "selectMonth";
	}

	@RequestMapping(value = "/selectMonth", method = RequestMethod.POST)
	public String selectMonth(Model model, @ModelAttribute("intdate") IntDate dateToAdd) {

		// BudgetService.addBudget(budgetToAdd);
		model.addAttribute("incomes", IncomeService.findByMonth(dateToAdd.getDate()));
		model.addAttribute("budgets", BudgetService.findByMonth(dateToAdd.getDate()));
		model.addAttribute("byDate", Comparator.comparing(Budget::getDate));
		model.addAttribute("byIncomeDate", Comparator.comparing(Income::getInserted));

		double total = 0;
		List<Budget> b = BudgetService.findByMonth(dateToAdd.getDate());
		List<Income> ic = IncomeService.findByMonth(dateToAdd.getDate());
		for (int i = 0; i < b.size(); i++) {

			total = total - b.get(i).getPrice();
		}
		for (int i = 0; i < ic.size(); i++) {
			total = total + ic.get(i).getAmount();
		}

		// get the total of your list
		model.addAttribute("total", total);

		return "showBudgets";

		// getBudgetsTest(model, budgetToAdd.getDate());

	}

	// _____________________________________
	@RequestMapping(value = "/selectDatePlusMonth", method = RequestMethod.GET)
	public String selectDatePlusMonth(Model model) {
		model.addAttribute("budgets", new Budget());
		// model.addAttribute("byDate", Comparator.comparing(Budget::getDate));
		return "selectDate";
	}

	@RequestMapping(value = "/selectDatePlusMonth", method = RequestMethod.POST)
	public String selectDatePlusMonth(Model model, @ModelAttribute("budgets") Budget budgetToAdd) {

		// BudgetService.addBudget(budgetToAdd);
		model.addAttribute("incomes", IncomeService.findByDatePlusMonth(budgetToAdd.getDate()));
		model.addAttribute("budgets", BudgetService.findByDatePlusMonth(budgetToAdd.getDate()));
		model.addAttribute("byDate", Comparator.comparing(Budget::getDate));
		model.addAttribute("byIncomeDate", Comparator.comparing(Income::getInserted));

		double total = 0;
		List<Budget> b = BudgetService.findByDatePlusMonth(budgetToAdd.getDate());
		List<Income> ic = IncomeService.findByDatePlusMonth(budgetToAdd.getDate());
		for (int i = 0; i < b.size(); i++) {

			total = total - b.get(i).getPrice();
		}
		for (int i = 0; i < ic.size(); i++) {
			total = total + ic.get(i).getAmount();
		}

		// get the total of your list
		model.addAttribute("total", total);

		return "showBudgets";

		// getBudgetsTest(model, budgetToAdd.getDate());

	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search(Model model) {
		model.addAttribute("searchString", new searchString());
		// model.addAttribute("byDate", Comparator.comparing(Budget::getDate));
		return "search";
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String search(Model model, @ModelAttribute("searchString") searchString result) {

		// BudgetService.addBudget(budgetToAdd);
		model.addAttribute("incomes", IncomeService.findByString(result.getSearchString()));
		model.addAttribute("budgets", BudgetService.findByString(result.getSearchString()));
		model.addAttribute("byDate", Comparator.comparing(Budget::getDate));
		model.addAttribute("byIncomeDate", Comparator.comparing(Income::getInserted));

		double total = 0;
		List<Budget> b = BudgetService.findByString(result.getSearchString());
		List<Income> ic = IncomeService.findByString(result.getSearchString());
		for (int i = 0; i < b.size(); i++) {

			total = total - b.get(i).getPrice();
		}
		for (int i = 0; i < ic.size(); i++) {
			total = total + ic.get(i).getAmount();
		}

		// get the total of your list
		model.addAttribute("total", total);

		return "showBudgets";

		// getBudgetsTest(model, budgetToAdd.getDate());

	}
	
	@RequestMapping(value = "/addIncome", method = RequestMethod.GET)
	public String showIncomeInfo(Model model) {
		model.addAttribute("incomes", new Income());
		// model.addAttribute("byDate", Comparator.comparing(Budget::getDate));
		return "insertIncome";
	}

	@RequestMapping(value = "/addIncome", method = RequestMethod.POST)
	public String processIncomeInfo(@ModelAttribute("incomes") Income incomeToAdd) {
		
		if(incomeToAdd.getPeriodic())
		{
			ArrayList<Income> toAdd = periodic(incomeToAdd);
			for(int i=0;i<toAdd.size();i++)
				IncomeService.addIncome(toAdd.get(i));
		}
else
	IncomeService.addIncome(incomeToAdd);
		
		
		return "success";
	}

}

/*
 * 
 *
 * @Controller public class MyController {
 * 
 * @Autowired private ICountryService countryService;
 * 
 * @GetMapping("/countries") public ModelAndView getCountries() {
 * 
 * var countries = (List<Country>) countryService.findAll();
 * 
 * var params = new HashMap<String, Object>(); params.put("countries",
 * countries);
 * 
 * return new ModelAndView("showCountries", params); } }
 *
 *
 *
 */
