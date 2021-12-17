import java.util.ArrayList;

public class Stockpile {
	private ArrayList<Item> items;
	private ArrayList<Discount> discounts;
	
	public Stockpile()
	{
		this.items = new ArrayList<Item>();
		this.discounts = new ArrayList<Discount>();
	}
	
	public boolean isValidItem(Item item)
	{
		for(int i = 0; i < items.size(); i++)
		{
			if(item.getName().equals(items.get(i).getName()))
			{
				return true;
			}
		}
		return false;
	}
	
	public boolean isValidDiscount(Discount discount)
	{
		for(int i = 0; i < discounts.size(); i++)
		{
			Discount myDiscount = discounts.get(i);
			if(discount.getId() == myDiscount.getId())
			{
				return true;
			}
		}
		return false;
	}
	
	public boolean isItemInStock(Item item)
	{
		if(this.isValidItem(item))
		{
			if(item.getQuantity() > 0)
			{
				return true;
			}
		}
		System.out.println("Item no longer available");
		return false;
		
	}
	
	public void removeDiscount(Discount discount)
	{
		for(int i = 0; i < this.discounts.size(); i++)
		{
			Discount myDiscount = this.discounts.get(i);
			if(myDiscount.equals(discount))
			{
				this.discounts.remove(i);
				return;
			}
		}
	}
	
	public void addDiscount(Discount discount)
	{
		this.discounts.add(discount);
	}
	
	public void addItem(Item item)
	{
		this.items.add(item);
	}

}
