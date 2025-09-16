package methods;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import appliances.*;


public class Methods {
	
	public static class ProgramMethods
	{
		public static List<Appliance> createApplianceList()
		{
			List<Appliance> allAppliances = new ArrayList<Appliance>();
			String filePath = "src\\appliances.txt";
			// Read a line of the txt file
			try (BufferedReader reader = new BufferedReader(new FileReader(filePath)))
			{
				
				String line;
				while ((line = reader.readLine()) != null) 
				{
					String[] applianceInfo = line.split(";");
					
					switch(applianceInfo[0].charAt(0)) 
					{
						case '1':
							Refrigerator fridge = new Refrigerator(applianceInfo[0], applianceInfo[1], Integer.parseInt(applianceInfo[2]) , Integer.parseInt(applianceInfo[3]), applianceInfo[4], Float.parseFloat(applianceInfo[5]), Integer.parseInt(applianceInfo[6]), Integer.parseInt(applianceInfo[7]), Integer.parseInt(applianceInfo[8]));
							allAppliances.add(fridge);
							break;
						case '2':
							Vacuum vacuum = new Vacuum(applianceInfo[0], applianceInfo[1], Integer.parseInt(applianceInfo[2]) , Integer.parseInt(applianceInfo[3]), applianceInfo[4], Float.parseFloat(applianceInfo[5]), applianceInfo[6], Integer.parseInt(applianceInfo[7]));
							allAppliances.add(vacuum);
							break;
						case '3':
							Microwave microwave = new Microwave(applianceInfo[0], applianceInfo[1], Integer.parseInt(applianceInfo[2]) , Integer.parseInt(applianceInfo[3]), applianceInfo[4], Float.parseFloat(applianceInfo[5]), Float.parseFloat(applianceInfo[6]), applianceInfo[7]);
							allAppliances.add(microwave);
							break;
						case '4':
						case '5':
							Dishwasher dishwasher = new Dishwasher(applianceInfo[0], applianceInfo[1], Integer.parseInt(applianceInfo[2]) , Integer.parseInt(applianceInfo[3]), applianceInfo[4], Float.parseFloat(applianceInfo[5]), applianceInfo[6], applianceInfo[7]);
							allAppliances.add(dishwasher);
							break;
					
					}
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			return allAppliances;
		};
	}
}
