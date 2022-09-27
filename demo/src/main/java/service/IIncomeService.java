package service;

import java.sql.Date;
import java.util.List;

import domain.Budget;
import domain.Income;

public interface IIncomeService {

	List<Income> findAll();
	void addIncome(Income i);
	
	public void deleteById(long ID);
	public List<Income> findByDate(Date d);
	public List<Income> findByMonth(int month);
	public List<Income> findByDatePlusMonth(Date d);
	
}
