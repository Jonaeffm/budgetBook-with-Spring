package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableAutoConfiguration
@EnableJpaRepositories("repositories") 
@SpringBootApplication
@ComponentScan({"bootstrap","service"})
@EntityScan("domain")
public class DemoApplication /*implements CommandLineRunner*/{

	//@Autowired
	//   private budgetRepository bR;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	
	/*@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub


//budgetRepositoryImpl bRI=new budgetRepositoryImpl();

		String str_date = "2009-12-31";
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date utilDate = formatter.parse(str_date);
		Date date = new Date(utilDate.getTime());

		
		Budget cigarettes = new Budget(date,"cigarettes",(double) 1000);
		bR.save(cigarettes);
		
		
		System.out.print("Number of elements: "+bR.count());
	}*/
	
	
	
}
