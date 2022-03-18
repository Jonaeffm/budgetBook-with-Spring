/*package bootstrap;



import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

import org.apache.logging.log4j.Logger;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import domain.Budget;
import repositories.budgetRepository;

@Component
public class BootStrapData implements CommandLineRunner{

	private final budgetRepository bR;
	
	public BootStrapData(budgetRepository bR) {
		this.bR=bR;
		
	}
	

    
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub




		String str_date = "11-June-07";
		DateFormat formatter = new SimpleDateFormat("dd-MMM-yy");
		Date date = (Date) formatter.parse(str_date);


		
		Budget cigarettes = new Budget(date,"cigarettes",(double) 1000);
		bR.save(cigarettes);
		
		
		System.out.print("Number of elements: "+bR.count());
	}

}*/
