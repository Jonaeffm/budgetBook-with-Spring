package domain;

import org.hibernate.validator.constraints.NotEmpty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
 
    protected ProgramUser() {}
 
    public ProgramUser(String userName, String password) {
        this.username = userName;
        this.password = password;
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
}