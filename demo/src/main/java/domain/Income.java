package domain;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Income {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private Date inserted;
	private String detail;
	private Double amount;
	private Boolean periodic;

	/*@ManyToOne
	private ProgramUser user;*/
	
	public Income(Date d, String de, Double v,Boolean periodic) {
		setInserted(d);
		setDetail(de);
		setAmount(v);
		setPeriodic(periodic);
		//setUser(null);
	}
	
	public Income(Date d, String de, Double v) {
		setInserted(d);
		setDetail(de);
		setAmount(v);
		setPeriodic(false);
		//setUser(null);
	}

}
