import java.util.ArrayList;

public class ShoppingCart {
	private ArrayList<Item> items;
	private Stockpile stockpile;
	private double total;
	private State state;
	
	public ShoppingCart()
	{
		this.items = new ArrayList<Item>();
		this.stockpile = new Stockpile();
		this.total = 0;
	}
	
	public double applyDiscount(Discount discount)
	{
		if(this.stockpile.isValidDiscount(discount) && total > 5)
		{
			this.total -= 5;
			this.stockpile.removeDiscount(discount);
		}
		return this.total;
	}
	
	public void addItem(Item item)
	{
		if(this.stockpile.isValidItem(item) && this.stockpile.isItemInStock(item))
		{
			items.add(item);
		}
		else if(!(this.stockpile.isValidItem(item)))
		{
			System.out.println("Item is not Valid!");
		}
		else
		{
			System.out.println("Item is not in stock!");
		}
	}
	
	public double calculateTotal()
	{
		
		for(int i = 0; i < items.size()-1; i++)
		{
			Item item = items.get(i);
			for(int j = 0; j < item.getQuantity(); j++)
			{
				this.total += item.getCost();
			}
		}
		this.total = this.total * this.state.getSalesTax().getTax() + this.total;
		return this.total;
	}
	
	public double getTotal()
	{
		return this.total;
		
	}
	
	public void setStockPile(Stockpile stockPile)
	{
		this.stockpile = stockPile;
	}
	public void setState(State state)
	{
		this.state = state;
	}
	
	public void saveStateToCsv()
	{
		//I would upload the info and contents of the cart and customer to a csv file to prevent it from losing its state if power goes out
	}
	
	
	

}
