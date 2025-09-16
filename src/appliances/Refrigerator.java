package appliances;

public class Refrigerator extends Appliance {
	
	protected int numberOfDoors;
	protected int height;
	protected int width;
	
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
		
		return "Item Number: " + itemNumber + "\nBrand: " + brand + "\nQuantity: " + quantity + "\nWattage: " + wattage + "\nColour: " + colour + "\nPrice: " + price + "\nNumber of Doors: " + doorsDisplay + "\nHeight: " + height +" In\nWidth: " + width + " In";
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
