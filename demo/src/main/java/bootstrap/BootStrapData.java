package bootstrap;



import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import domain.Budget;
import domain.Income;
import domain.ProgramUser;
import repositories.IncomeRepository;
import repositories.ProgramUserRepository;

import repositories.budgetRepository;

@EnableAutoConfiguration
@Component
public class BootStrapData implements CommandLineRunner{


	@Autowired
	private budgetRepository bR2;
	@Autowired
	private IncomeRepository iR;
	@Autowired
	private ProgramUserRepository uR;
	
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
    
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		
		
		String str_date = "2009-12-31";
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date utilDate = formatter.parse(str_date);
		Date date = new Date(utilDate.getTime());

		
		
		
		Budget cigarettes = new Budget(date,"cigarettes",(double) 1000);
	
		Income money = new Income(date,"gift",(double) 10000);
		
		System.out.print("Number of elements: "+bR2.count());
		System.out.print("Number of incomes"+iR.count());
		
		
		
		ArrayList<Budget> test ;
		test = periodic(cigarettes);
		System.out.println("Datum 1:"+cigarettes.getDate());
		for(int i=1;i<12;i++)
		{
			System.out.println("Datum "+i+":"+test.get(i).getDate());
		}
		ArrayList<Income> test2;
		test2=periodic(money);
		System.out.println("Datum 1 Einkommen:"+money.getInserted());
		for(int i=1;i<12;i++)
		{
			System.out.println("Datum "+i+":"+test2.get(i).getInserted());
		}
		ProgramUser a = new ProgramUser("a","a");
		
		cigarettes.setUser(a);
		
		money.setUser(a);
		
		a.getBudgets().add(cigarettes);		
		a.getIncomes().add(money);
		
		uR.save(a);
		iR.save(money);
		bR2.save(cigarettes);

	
	}

	

}
