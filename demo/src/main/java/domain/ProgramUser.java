package domain;

import org.hibernate.validator.constraints.NotEmpty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.HashSet;
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
    private Set<Budget> budgets;
    

    @OneToMany(targetEntity= Income.class)
    @JoinColumn(name="user_income",referencedColumnName = "id")
    private Set<Income> incomes;
    
    protected ProgramUser() {}
 
    public ProgramUser(String userName, String password) {
        this.username = userName;
        this.password = password;
        
        Set<Budget> budgetSet =new HashSet<Budget>();
        this.setBudgets(budgetSet);
        Set<Income> incomeSet = new HashSet<Income>();
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
    
    public void setBudgets(Set<Budget> budgets)
    {
    this.budgets=budgets;	
    }
    
    public Set<Budget> getBudgets()
    {
    	return this.budgets;
    }
    
    public void setIncomes(Set<Income> incomes) {
    this.incomes=incomes;}
    
    public Set<Income> getIncomes()

{return this.incomes;
    	}
}