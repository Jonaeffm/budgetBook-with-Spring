package service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Budget;
import repositories.budgetRepository;

@Service
public class BudgetService implements IBudgetService{

	@Autowired
	private budgetRepository repository;

	@Override
	public List<Budget> findAll(){
		return (List<Budget>) repository.findAll();
	}
	
	
	public void deleteById(long ID){
		 repository.deleteById(ID);
	}
	
	public void addBudget(Budget b) {
        repository.save(b);
	}
}	
	
	
/*

@Service
public class CountryService implements ICountryService {

    @Autowired
    private CountryRepository repository;

    @Override
    public List<Country> findAll() {

        return (List<Country>) repository.findAll();
    }
}
*/