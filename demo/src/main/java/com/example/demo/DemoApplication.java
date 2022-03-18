package com.example.demo;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

import domain.Budget;
import repositories.budgetRepository;


@SpringBootApplication
@EntityScan("domain")
public class DemoApplication implements CommandLineRunner{

	@Autowired
	   private budgetRepository bR;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	
	@Override
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
	}
	
	
	
}
