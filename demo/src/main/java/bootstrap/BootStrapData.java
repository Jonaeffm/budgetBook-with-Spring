package bootstrap;



import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

import org.apache.logging.log4j.Logger;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


import domain.Budget;
import repositories.budgetRepository;

@EnableAutoConfiguration
@Component
public class BootStrapData implements CommandLineRunner{


	@Autowired
	private budgetRepository bR2;
	
	

    
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		
		
		String str_date = "2009-12-31";
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date utilDate = formatter.parse(str_date);
		Date date = new Date(utilDate.getTime());

		
		Budget cigarettes = new Budget(date,"cigarettes",(double) 1000);
		bR2.save(cigarettes);
		
		
		System.out.print("Number of elements: "+bR2.count());


		
		
		
	
	}

}
