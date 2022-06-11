package service;

import java.sql.Date;
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
	
	public List<Budget> findByDate(Date d){
		List<Budget> temp = (List<Budget>) repository.findAll();
		for(int i=0;i<temp.size();i++)
		{
			if(temp.get(i).getDate().compareTo(d) != 0)
							temp.remove(i);
		}
		return temp;
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