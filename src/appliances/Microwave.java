package appliances;

public class Microwave extends Appliance 
{
	protected float capacity;
	protected String roomType;

	public Microwave(String itemNumber, String brand, int quantity, int wattage, String colour, float price, float capacity, String roomType) 
	{
		super(itemNumber, brand, quantity, wattage, colour, price);
		
		this.capacity = capacity;
		this.roomType = roomType;
	}

	@Override
	public String toString() 
	{ 
		return "Item Number: " + itemNumber + "\nBrand: " + brand + "\nQuantity: " + quantity + "\nWattage: " + wattage + "\nColour: " + colour + "\nPrice: " + price + "\nCapacity: " + capacity + " cu ft" + "\nRoom Type: " + roomType;
 
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
