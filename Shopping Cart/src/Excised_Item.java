
public class Excised_Item extends Item {

	public Excised_Item(int id, String name, int quantity, double cost, Excise_Tax exciseRate) {
		super(id, name, quantity, cost*exciseRate.getTax()+cost);
		// TODO Auto-generated constructor stub
	}

}
