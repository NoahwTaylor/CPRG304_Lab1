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
	
	// Constructor
	public Appliance(String itemNumber, String brand, int quantity, int wattage, String colour, float price) 
	{
		this.itemNumber = itemNumber;
		this.brand = brand;
		this.quantity = quantity;
		this.wattage = wattage;
		this.colour = colour;
		this.price = price;
	}

	@Override
	public abstract String toString();
	
	// Method to format string to be re-written to file in each subclass
	public abstract String toFile();
	
	public boolean available() 
	{
		if (quantity >= 1) 
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	// Base for each subclasses toFile method
	public String toFileBase() 
	{
		return itemNumber + ";" + brand + ";" + quantity + ";" + wattage + ";" + colour + ";" + price + ";";
	}
	
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
