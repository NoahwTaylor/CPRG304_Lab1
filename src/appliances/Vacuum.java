package appliances;

public class Vacuum extends Appliance {
	
	protected String grade;
	protected int voltage;

	public Vacuum(String itemNumber, String brand, int quantity, int wattage, String colour, float price, String grade, int voltage) 
	{
		super(itemNumber, brand, quantity, wattage, colour, price);
		
		this.grade = grade;
		this.voltage = voltage;
	}

	@Override
	public String toString() 
	{
		String voltageDisplay = "";
		
		switch(voltage) 
		{
			case 18:
				voltageDisplay = "18V (Low)";
				break;
			case 24:
				voltageDisplay = "24V (Low)";
				break;
		}
		
		return "Item Number: " + itemNumber + "\nBrand: " + brand + "\nQuantity: " + quantity + "\nWattage: " + wattage + "\nColour: " + colour + "\nPrice: " + price + "\nGrade: " + grade + "\nVoltage: " + voltageDisplay;
	}
	
	// Getters
	
	public String getGrade() 
	{	
		return this.grade;
	}
	
	public int getVoltage() 
	{
		return this.voltage;
	}

}
