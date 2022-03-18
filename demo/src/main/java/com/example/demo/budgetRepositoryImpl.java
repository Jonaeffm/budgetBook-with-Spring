package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;

import repositories.budgetRepository;

public class budgetRepositoryImpl {
	 @Autowired
	   private budgetRepository bR;

	public budgetRepository getbR() {
		return bR;
	}

	public void setbR(budgetRepository bR) {
		this.bR = bR;
	}
}
