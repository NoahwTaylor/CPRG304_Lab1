package appliances;

public abstract class Appliance 
{
	
	// Fields
	protected String itemNumber;
	protected String brand;
	protected int quantity;
	protected int wattage;
	protected String colour;
	protected float price;
	
	// Constructors
	public Appliance(String itemNumber, String brand, int quantity, int wattage, String colour, float price) 
	{
		this.itemNumber = itemNumber;
		this.brand = brand;
		this.quantity = quantity;
		this.wattage = wattage;
		this.colour = colour;
		this.price = price;
	}
		// TODO Auto-generated constructor stub

	@Override
	public abstract String toString();
	
	// Getters
	public String getItemNumber() 
	{
		return this.itemNumber;
	}
	
	public String getBrand() 
	{
		return this.brand;
	}
	
	public int getQuantity() 
	{
		return this.quantity;
	}
	
	// Quantity can be altered by checking out appliance
	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}
	
	public int getWattage()
	{
		return this.wattage;
	}
	
	public String getColour() 
	{
		return this.colour;
	}
	
	public float getPrice() 
	{
		return this.price;
	}
	
}
