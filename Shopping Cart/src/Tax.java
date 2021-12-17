
public abstract class Tax {
	private double rate;
	
	public Tax(double rate)
	{
		this.rate = rate;
	}
	
	public double getTax()
	{
		return this.rate;
	}

}
