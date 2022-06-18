package domain;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Income {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
 private long id;
	private Date date;
	private String detail;
	private Double value;
	
	public Income(Date d,String de, Double v)
	{
		setDate(d);
		setDetail(de);
		setValue(v);
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
	
}
