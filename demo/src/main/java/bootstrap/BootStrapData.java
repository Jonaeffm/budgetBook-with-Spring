package bootstrap;



import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import domain.Budget;
import domain.Income;
import repositories.IncomeRepository;
import repositories.budgetRepository;

@EnableAutoConfiguration
@Component
public class BootStrapData implements CommandLineRunner{


	@Autowired
	private budgetRepository bR2;
	@Autowired
	private IncomeRepository iR;
	
	public ArrayList<Budget> periodic(Budget b){
		ArrayList<Budget> result = new ArrayList<Budget>();
		//result.add(b);

		Date d = b.getDate();
		LocalDate ld = d.toLocalDate();
		LocalDate monthLater = ld.plusMonths( 1 );
		java.sql.Date d2 = java.sql.Date.valueOf( monthLater );
		b.setDate(d2);
		result.add(b);
		return result;
		
	}
    
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		
		
		String str_date = "2009-12-31";
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date utilDate = formatter.parse(str_date);
		Date date = new Date(utilDate.getTime());

		
		Budget cigarettes = new Budget(date,"cigarettes",(double) 1000);
		bR2.save(cigarettes);
		Income money = new Income(date,"gift",(double) 10000);
		iR.save(money);
		System.out.print("Number of elements: "+bR2.count());
		System.out.print("Number of incomes"+iR.count());
		
		ArrayList<Budget> test = new ArrayList<Budget>();
		test = periodic(cigarettes);
		System.out.println("Datum 1:"+cigarettes.getDate());
		System.out.println("Datum 2:"+test.get(0).getDate());
		
		
		
		
	
	}

	

}
