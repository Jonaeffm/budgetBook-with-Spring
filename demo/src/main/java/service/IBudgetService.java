package service;

import java.util.List;
import java.util.Optional;

import domain.Budget;

public interface IBudgetService {

	List<Budget> findAll();
	void addBudget(Budget b);
	
	public void deleteById(long ID);

}
/*package com.zetcode.service;

import com.zetcode.model.Country;
import java.util.List;

public interface ICountryService {

    List<Country> findAll();
}*/