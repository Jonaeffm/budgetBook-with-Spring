package domain;

import org.hibernate.validator.constraints.NotEmpty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
 
@Entity
public class ProgramUser {
 
    @Id
    @GeneratedValue()
    private long id;
 
    @NotEmpty(message = "username is required")
    @Column(unique = true)
    private String username;
 
    @NotEmpty(message = "password is required")
    private String password;
 
    @OneToMany(targetEntity= Budget.class)
    @JoinColumn(name="user_budget",referencedColumnName = "id")
    private List<Budget> budgets;
    

    @OneToMany(targetEntity= Income.class)
    @JoinColumn(name="user_income",referencedColumnName = "id")
    private List<Income> incomes;
    
    protected ProgramUser() {}
 
    public ProgramUser(String userName, String password) {
        this.username = userName;
        this.password = password;
        
        List<Budget> budgetSet =new ArrayList<Budget>();
        this.setBudgets(budgetSet);
        List<Income> incomeSet = new ArrayList<Income>();
        this.setIncomes(incomeSet);
    }
 
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setBudgets(List<Budget> budgets)
    {
    this.budgets=budgets;	
    }
    
    public List<Budget> getBudgets()
    {
    	return this.budgets;
    }
    
    public void setIncomes(List<Income> incomes) {
    this.incomes=incomes;}
    
    public List<Income> getIncomes()

{return this.incomes;
    	}
}