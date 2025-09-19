package appliances;

public class Microwave extends Appliance 
{
	// Additional fields for subclass
	protected float capacity;
	protected String roomType;

	// Constructor declares additional variables for subclass
	public Microwave(String itemNumber, String brand, int quantity, int wattage, String colour, float price, float capacity, String roomType) 
	{
		super(itemNumber, brand, quantity, wattage, colour, price);
		
		this.capacity = capacity;
		this.roomType = roomType;
	}

	@Override
	public String toString() 
	{ 
		return "\nItem Number: " + itemNumber + "\nBrand: " + brand + "\nQuantity: " + quantity + "\nWattage: " + wattage + "\nColour: " + colour + "\nPrice: " + price + "\nCapacity: " + capacity + " cu ft" + "\nRoom Type: " + roomType;
	}
	
	
	// Format string to be re-written to file
	public String toFile() 
	{
		return toFileBase() + capacity + ";" + roomType;
	}

	// Getters
	public float getCapacity() 
	{
		return this.capacity;
	}
	
	public String getRoomType() 
	{
		return this.roomType;
	}
}
