
public class State {
	private String name;
	private Sales_Tax salesTax;
	private Excise_Tax exciseTax;
	
	public State(String name, Sales_Tax salesTax, Excise_Tax exciseTax)
	{
		this.salesTax = salesTax;
		this.exciseTax = exciseTax;
		this.name = name;
	}
	
	public String name()
	{
		return this.name;
	}
	public Tax getExciseTax()
	{
		return this.exciseTax;
	}
	
	public Tax getSalesTax()
	{
		return this.salesTax;
	}

}
