package service;

import java.util.List;

import domain.Budget;

public interface IBudgetService {

	List<Budget> findAll();
	void addBudget(Budget b);
}
/*package com.zetcode.service;

import com.zetcode.model.Country;
import java.util.List;

public interface ICountryService {

    List<Country> findAll();
}*/