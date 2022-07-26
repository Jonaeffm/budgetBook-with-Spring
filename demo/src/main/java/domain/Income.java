package domain;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

	public Income(Date d, String de, Double v) {
		setInserted(d);
		setDetail(de);
		setAmount(v);
	}

}
