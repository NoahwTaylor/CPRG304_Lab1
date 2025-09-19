package appliances;

public class Vacuum extends Appliance {
	
	// Additional fields for subclass
	protected String grade;
	protected int voltage;

	// Constructor declares addition variables for subclass
	public Vacuum(String itemNumber, String brand, int quantity, int wattage, String colour, float price, String grade, int voltage) 
	{
		super(itemNumber, brand, quantity, wattage, colour, price);
		
		this.grade = grade;
		this.voltage = voltage;
	}

	@Override
	public String toString() 
	{
		
		// Creates proper display message based on voltage value
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
		
		return "\nItem Number: " + itemNumber + "\nBrand: " + brand + "\nQuantity: " + quantity + "\nWattage: " + wattage + "\nColour: " + colour + "\nPrice: " + price + "\nGrade: " + grade + "\nVoltage: " + voltageDisplay;
	}
	
	// Formats string to be re-written to file
	public String toFile() 
	{
		return toFileBase() + grade + ";" + voltage;
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
