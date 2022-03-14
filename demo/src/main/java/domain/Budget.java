package domain;

import java.sql.Date;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Budget {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private Date date;
	private String product;
	private Double price;
	
	public Budget(Date d,String p, Double pr)
	{
		setDate(d);
		setProduct(p);
		setPrice(pr);
	}
	
	
	
	public Budget()
	{
		
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	/*@Override
	public boolean equals(Object o)
	{
		if (this==o)return true;
		if(o==null||getClass() !=o.getClass())return false	;
		
		Budget budget = (Budget)o;
		
		return id != null ? id.equals(budget.id) : budget.id == null;
	}
	
	@Override
	public int hashCode()
	{
		return id != null ? id.hashCode() : 0;
	}
	*/
	
	@Override
	public String toString()
	{
		return "date: "+date+" product: +"+product+" price: "+price;
	}
}
