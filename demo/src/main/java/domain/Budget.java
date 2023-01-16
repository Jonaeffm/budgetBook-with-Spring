package domain;

import java.sql.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;


@Entity
public class Budget {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
 private long id;
	private Date date;
	private String product;
	private Double price;
	private Boolean periodic;
	
	/*@ManyToOne
	private ProgramUser user;*/
	

	public Budget(Date d,String p, Double pr, Boolean pe)
	{
		setDate(d);
		setProduct(p);
		setPrice(pr);
		setPeriodic(pe);
		
		//setUser(null);
	}
	
	public Budget(Date d,String p, Double pr)
	{
		setDate(d);
		setProduct(p);
		setPrice(pr);
		setPeriodic(false);
		//setUser(null);
		
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
/*
@Override
public int compare(Budget b1, Budget b2) {
		// TODO Auto-generated method stub
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		 String v1 = dateFormat.format(b1.getDate());
         String v2 =dateFormat.format(b2.getDate());

         if ((v1.compareTo(v2)) >0) return 1;
         else return 0;
	}
*/

	/*public ProgramUser getUser()
	{
		return user; 
	}
	
	public void setUser(ProgramUser user)
	{
		this.user = user;
	}*/
	
	public Boolean getPeriodic() {
		return periodic;
	}



	public void setPeriodic(Boolean periodic) {
		this.periodic = periodic;
	}

/*
@Override
public int compareTo(Budget o) {
	// TODO Auto-generated method stub
	DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
	 String v1 = dateFormat.format(o.getDate());
    String v2 =dateFormat.format(date);

    if ((v1.compareTo(v2)) >0) return 1;
    else return 0;
}*/
}
