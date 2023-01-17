package domain;






import org.hibernate.validator.constraints.NotEmpty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


 
@Entity
public class ProgramUser {
 
    @Id
    @GeneratedValue()
    @Column(name="USER_ID")
    private long id;
 
    @NotEmpty(message = "username is required")
    @Column(unique = true)
    private String username;
 
    @NotEmpty(message = "password is required")
    private String password;
 
    @OneToMany(targetEntity= Budget.class, cascade= CascadeType.ALL)
    @JoinColumn(name="user_budget",referencedColumnName = "USER_ID")
    private Collection<Budget> budgets;
    

    @OneToMany(targetEntity= Income.class,cascade= CascadeType.ALL)
    @JoinColumn(name="user_income",referencedColumnName = "USER_ID")
    private Collection<Income> incomes;
    
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
    
    public Collection<Budget> getBudgets()
    {
    	return this.budgets;
    }
    
    public void setIncomes(List<Income> incomes) {
    this.incomes=incomes;}
    
    public Collection<Income> getIncomes()

{return this.incomes;
    	}
}