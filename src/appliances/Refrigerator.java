package appliances;

public class Refrigerator extends Appliance {
	
	// Additional Fields for subclass
	protected int numberOfDoors;
	protected int height;
	protected int width;

	// Constructor declares additional variables for subclass
	public Refrigerator(String itemNumber, String brand, int quantity, int wattage, String colour, float price, int numberOfDoors, int height, int width) 
	{
		super(itemNumber, brand, quantity, wattage, colour, price);
		
		this.numberOfDoors = numberOfDoors;
		this.height = height;
		this.width = width;	
	}
	
	@Override
	public String toString()
	{
		// Creates proper display message based on number of doors
		String doorsDisplay = "";
		
		switch(numberOfDoors) 
		{
			case 2:
				doorsDisplay = "Double Doors";
				break;
			case 3:
				doorsDisplay = "Three Doors";
				break;
			case 4:
				doorsDisplay = "Four Doors";
				break;		
		}
		
		return "\nItem Number: " + itemNumber + "\nBrand: " + brand + "\nQuantity: " + quantity + "\nWattage: " + wattage + "\nColour: " + colour + "\nPrice: " + price + "\nNumber of Doors: " + doorsDisplay + "\nHeight: " + height +" In\nWidth: " + width + " In";
	}
	
	// Formats string to be re-written to file
	public String toFile() 
	{
		return toFileBase() + numberOfDoors + ";" + height + ";" + width;
	}
	
	// Getters
	public int getNumberOfDoors() 
	{
		return this.numberOfDoors;
	}
	
	public int getHeight() 
	{
		return this.height;
	}
	
	public int getWidth() 
	{
		return this.width;
	}
	
	

}
