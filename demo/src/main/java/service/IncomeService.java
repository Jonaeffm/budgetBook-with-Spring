package service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import domain.Budget;
import domain.Income;
import domain.ProgramUser;
import repositories.IncomeRepository;
import repositories.ProgramUserRepository;

@Service
public class IncomeService implements IIncomeService{

	@Autowired
	private IncomeRepository repository;
	
	
	@Autowired
	private ProgramUserRepository userRepository;
	
	@Override
	public List<Income> findAll(){
	List<Income> IncList = (List<Income>) repository.findAll();
	
	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	
	
	ProgramUser aut = userRepository.findByUsername(authentication.getName());
	
	for (int i=0;i<IncList.size();i++)
	{
		if(IncList.get(i).getUser() != aut)
		{
			IncList.remove(i);
		}
	}

	return IncList;}
	@Override
	public void addIncome(Income i) {
		// TODO Auto-generated method stub
		repository.save(i);
	}

	@Override
	public void deleteById(long ID) {
		// TODO Auto-generated method stub
		 repository.deleteById(ID);
	}

	@Override
	public List<Income> findByDate(Date d) {
		List<Income> temp = (List<Income>) repository.findAll();
		for(int i=temp.size()-1;i>-1;i--)
		{
			if(temp.get(i).getInserted().compareTo(d) != 0)
							temp.remove(i);
		}

Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		
		ProgramUser aut = userRepository.findByUsername(authentication.getName());
		for (int i=0;i<temp.size();i++)
		{
			if(temp.get(i).getUser() != aut)
			{
				temp.remove(i);
			}
		}
		
		return temp;
	}

	@Override
	public List<Income> findByMonth(int month) {
		List<Income> temp = (List<Income>) repository.findAll();
		for(int i=temp.size()-1;i>-1;i--)
		
		{
			
			
			Calendar calFromArray = Calendar.getInstance();
			calFromArray.setTime(temp.get(i).getInserted());
			int month2 = calFromArray.get(Calendar.MONTH);
			
			
			if(month != month2)
							temp.remove(i);
		}
Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		
		ProgramUser aut = userRepository.findByUsername(authentication.getName());
		for (int i=0;i<temp.size();i++)
		{
			if(temp.get(i).getUser() != aut)
			{
				temp.remove(i);
			}
		}
		return temp;
	}

	@Override
	public List<Income> findByDatePlusMonth(Date d) {
LocalDate localDateD = d.toLocalDate();
		
		
		
		List<Income> temp = (List<Income>) repository.findAll();
		for(int i=temp.size()-1;i>-1;i--)
		{
			LocalDate localDateTemp = temp.get(i).getInserted().toLocalDate();
			
			if(!((((localDateTemp.getMonthValue()==localDateD.getMonthValue())&&(localDateTemp.getDayOfMonth()>=localDateD.getDayOfMonth())&&(localDateD.getYear()==localDateTemp.getYear()))||((localDateTemp.getMonthValue()==localDateD.getMonthValue()+1)&&(localDateTemp.getDayOfMonth()<localDateD.getDayOfMonth())&&(localDateD.getYear()==localDateTemp.getYear())))||((localDateD.getMonthValue()==12)&&(localDateTemp.getMonthValue()==1)&&(localDateTemp.getDayOfMonth()<localDateD.getDayOfMonth())&&(localDateD.getYear()+1==localDateTemp.getYear()))))
									temp.remove(i);
		}
Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		
		ProgramUser aut = userRepository.findByUsername(authentication.getName());
		for (int i=0;i<temp.size();i++)
		{
			if(temp.get(i).getUser() != aut)
			{
				temp.remove(i);
			}
		}
		return temp;
	}

	public List<Income> findByString(String s) {
		List<Income> temp = (List<Income>) repository.findAll();
		for(int i=temp.size()-1;i>-1;i--)
		
		{
			
			
			
			
			
			if(!temp.get(i).getDetail().contains(s))
							temp.remove(i);
		}
Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		
		ProgramUser aut = userRepository.findByUsername(authentication.getName());
		for (int i=0;i<temp.size();i++)
		{
			if(temp.get(i).getUser() != aut)
			{
				temp.remove(i);
			}
		}
		return temp;
	}
	
	
}
