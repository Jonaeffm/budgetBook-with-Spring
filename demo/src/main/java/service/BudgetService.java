package service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
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
		for(int i=temp.size()-1;i>-1;i--)
		{
			if(temp.get(i).getDate().compareTo(d) != 0)
							temp.remove(i);
		}
		return temp;
	}
	
	public List<Budget> findByMonth(int month){
		List<Budget> temp = (List<Budget>) repository.findAll();
		for(int i=temp.size()-1;i>-1;i--)
		
		{
			
			
			Calendar calFromArray = Calendar.getInstance();
			calFromArray.setTime(temp.get(i).getDate());
			int month2 = calFromArray.get(Calendar.MONTH);
			
			
			if(month != month2)
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

	public List<Budget> findByDatePlusMonth(Date d){
		
		
		LocalDate localDateD = d.toLocalDate();
		
		
		
		List<Budget> temp = (List<Budget>) repository.findAll();
		for(int i=temp.size()-1;i>-1;i--)
		{
			LocalDate localDateTemp = temp.get(i).getDate().toLocalDate();
			
			if(!((((localDateTemp.getMonthValue()==localDateD.getMonthValue())&&(localDateTemp.getDayOfMonth()>=localDateD.getDayOfMonth())&&(localDateD.getYear()==localDateTemp.getYear()))||((localDateTemp.getMonthValue()==localDateD.getMonthValue()+1)&&(localDateTemp.getDayOfMonth()<localDateD.getDayOfMonth())&&(localDateD.getYear()==localDateTemp.getYear())))||((localDateD.getMonthValue()==12)&&(localDateTemp.getMonthValue()==1)&&(localDateTemp.getDayOfMonth()<localDateD.getDayOfMonth())&&(localDateD.getYear()+1==localDateTemp.getYear()))))
									temp.remove(i);
		}
		return temp;
	}
	public List<Budget> findByString(String s) {
		List<Budget> temp = (List<Budget>) repository.findAll();
		for(int i=temp.size()-1;i>-1;i--)
		
		{
			
			
			
			
			
			if(!temp.get(i).getProduct().contains(s))
							temp.remove(i);
		}
		return temp;
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