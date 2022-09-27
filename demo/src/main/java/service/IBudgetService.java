package service;

import java.sql.Date;
import java.util.List;
import domain.Budget;

public interface IBudgetService {

	List<Budget> findAll();
	void addBudget(Budget b);
	
	public void deleteById(long ID);
	public List<Budget> findByDate(Date d);
	public List<Budget> findByMonth(int month);
	public List<Budget> findByDatePlusMonth(Date d);
}
/*package com.zetcode.service;

import com.zetcode.model.Country;
import java.util.List;

public interface ICountryService {

    List<Country> findAll();
}*/