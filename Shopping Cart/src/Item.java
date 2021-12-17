
public abstract class Item {
	private int id;
	private String name;
	private int quantity;
	private double cost;
	
	public Item(int id, String name, int quantity, double cost)
	{
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		if(this.quantity < 0)
		{
			System.out.println("Auto setting quantity to 0 because input was below 0!");
			this.quantity = 0;
		}
		this.cost = cost;
	}
	
	public void addAmount(int amount)
	{
		this.quantity += amount;
	}
	
	public void removeAmount(int amount)
	{
		this.quantity -= amount;
	}
	
	public int getId()
	{
		return this.id;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public int getQuantity()
	{
		return this.quantity;
	}
	
	public double getCost()
	{
		return this.cost;
	}

}
