package appliances;

public class Dishwasher extends Appliance {
	
	
	// Additional fields for subclass
	protected String feature;
	protected String soundRating;

	// Constructor declares additional variables for the subclass
	public Dishwasher(String itemNumber, String brand, int quantity, int wattage, String colour, float price, String feature, String soundRating) {
		super(itemNumber, brand, quantity, wattage, colour, price);

		this.feature = feature;
		this.soundRating = soundRating;
	}

	@Override
	public String toString() {
		
		String soundRatingDisplay = "";
		
		switch(soundRating) 
		{
			case "Qt":
				soundRatingDisplay = "Quietest";
				break;
			case "Qr":
				soundRatingDisplay = "Quieter";
				break;
			case "Qu":
				soundRatingDisplay = "Quiet";
			case "M":
				soundRatingDisplay = "Moderate";
		}
		
		return "\nItem Number: " + itemNumber + "\nBrand: " + brand + "\nQuantity: " + quantity + "\nWattage: " + wattage + "\nColour: " + colour + "\nPrice: " + price + "\nFeature: " + feature + "\nSound Rating: " + soundRatingDisplay;
	}
	
	
	// Format string to be re-written to file
	public String toFile() 
	{
		return toFileBase() + feature + ";" + soundRating;
	}
	
	// Getters
	public String getFeature() 
	{
		return this.feature;
	}
	
	public String getSoundRating() 
	{
		return this.soundRating;
	}

}
