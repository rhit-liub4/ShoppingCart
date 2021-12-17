import java.util.ArrayList;

import org.junit.Test;

import static org.junit.Assert.*;



public class Testing {
	
	
	//Discounts
	@Test
	public void testDiscountMethods()
	{
		Discount discount = new Discount(374);
		assertEquals(374, discount.getId());
	}
	
	//Tax Methods
	@Test
	public void testTaxMethods()
	{
		Excise_Tax exciseRate = new Excise_Tax(0.04);
		Sales_Tax salesRate = new Sales_Tax(0.02);
		
		assertTrue(0.04 == exciseRate.getTax());
		assertTrue(0.02 == salesRate.getTax());
	}
	
	//State Methods
	@Test
	public void testStateMethods()
	{
		Excise_Tax exciseRate = new Excise_Tax(0.04);
		Sales_Tax salesRate = new Sales_Tax(0.02);
		State myState = new State("My State", salesRate, exciseRate);
		
		//Getting Rates
		assertEquals(exciseRate, myState.getExciseTax());
		assertEquals(salesRate, myState.getSalesTax());
		assertEquals("My State", myState.name());
	}
	
	//Items
	@Test
	public void testItemMethods()
	{
		Discount discount = new Discount(374);
		assertEquals(374, discount.getId());
		Excise_Tax exciseRate = new Excise_Tax(0.04);
		Item item1 = new Excised_Item(0, "Mountain Dew", 1, 3.00,exciseRate);
		Item item2 = new Regular_Item(1, "Water", 1, 1.00);
		//AddingAmount
		assertEquals(1, item1.getQuantity());
		assertEquals(1, item2.getQuantity());
		item1.addAmount(1);
		item2.addAmount(2);
		assertEquals(2, item1.getQuantity());
		assertEquals(3, item2.getQuantity());
		
		//RemovingAmount
		item1.removeAmount(1);
		item2.removeAmount(2);
		assertEquals(1, item1.getQuantity());
		assertEquals(1, item2.getQuantity());
	}
	
	//StockpileMethods
	@Test
	public void TestStockPileMethods()
	{
		Stockpile stockpile = new Stockpile();
		Discount discount1 = new Discount(374);
		Discount discount2 = new Discount(371);
		Excise_Tax exciseRate = new Excise_Tax(0.04);
		Item item1 = new Excised_Item(0, "Mountain Dew", 1, 3.00,exciseRate);
		Item item2 = new Regular_Item(1, "Water", 1, 1.00);
		
		stockpile.addDiscount(discount1);
		stockpile.addItem(item1);
		
		//isValidItem
		assertEquals(true, stockpile.isValidItem(item1));
		assertEquals(false, stockpile.isValidItem(item2));
		
		//isValidDiscount
		assertEquals(true, stockpile.isValidDiscount(discount1));
		assertEquals(false, stockpile.isValidDiscount(discount2));
		
		//isItemInStock
		assertEquals(true, stockpile.isItemInStock(item1));
		assertEquals(false, stockpile.isItemInStock(item2));
		

		}
	
	//ShoppingCartMethods
	@Test
	public void TestShoppingCartMethods()
	{
		Stockpile stockpile = new Stockpile();
		Discount discount1 = new Discount(374);
		
		Excise_Tax exciseRate = new Excise_Tax(0.04);
		Sales_Tax salesRate = new Sales_Tax(0.02);
		
		Item item1 = new Excised_Item(0, "Mountain Dew", 1, 300,exciseRate);
		Item item2 = new Regular_Item(1, "Water", 1, 100);
		
		State myState = new State("My State", salesRate, exciseRate);
		
		stockpile.addDiscount(discount1);
		stockpile.addItem(item1);
		stockpile.addItem(item2);
		
		ShoppingCart cart = new ShoppingCart();
		cart.setStockPile(stockpile);
		cart.setState(myState);
		
		
		cart.addItem(item1);
		cart.addItem(item2);
		
		//calculate Total
		double result = cart.getTotal();
		double expected = 0;
		assertTrue(result == expected);
		
		result = cart.calculateTotal();
		expected = 318.24;
		assertTrue(result == expected);
		
		
		//apply discount
		result = cart.applyDiscount(discount1);
		expected = 313.24;
		assertTrue(result == expected);
	}

	public static void test()
	{
		System.out.println("hi");
	}

}
