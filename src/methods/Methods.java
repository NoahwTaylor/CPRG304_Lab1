package methods;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import appliances.*;


public class Methods 
{
	
	public static class ProgramMethods
	{
		// Parses through data file to create a list of appliance objects containing all objects in the appliances.txt file
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
					
					// Switches first number of itemNumber to create and append corresponding child appliance object
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
		
		// Allows user to checkout out an appliance if available, decrementing the capacity by 1
		public static void checkoutAppliance(List<Appliance> appliances, Scanner scanner) 
		{
			System.out.println("\nEnter the item number of an appliance:");
			String checkoutItem = scanner.nextLine();
			
			boolean applianceFound = false;
			
			int i = 0;
			for(i = 0; i < appliances.size(); i++) 
			{
				if (appliances.get(i).getItemNumber().equals(checkoutItem)) 
				{
					if (appliances.get(i).available()) 
					{
						applianceFound = true;
						appliances.get(i).setQuantity((appliances.get(i).getQuantity()) - 1);
						System.out.println("\nAppliance " + appliances.get(i).getItemNumber() + " has been checked out.");
					}
					
				}
				
			}
			
			if (!applianceFound) 
			{
				System.out.println("\nThe appliance is not available to be checked out.");
			}		
		}
		
		// Allows user to search through appliance list by brand name
		public static void searchByBrand(List<Appliance> appliances, Scanner scanner)
		{

			System.out.println("\nEnter brand to search for:\n");
			String brandSearch = scanner.nextLine();
			
			
			System.out.println("\nMatching Appliances:");
			int i = 0;
			for(i = 0; i < appliances.size(); i++) 
			{
				if(appliances.get(i).getBrand().toUpperCase().equals(brandSearch.toUpperCase())) 
				{
					System.out.println(appliances.get(i).toString());
				}
			}
	
		}
	
		// Allows user to search through appliance list by each specific appliance type
		public static void searchByType(List<Appliance> appliances, Scanner scanner) 
		{	
			System.out.println("\nAppliance Types: \n1 - Refrigerators \n2 - Vacuums \n3 - Microwaves \n4 - Dishwashers \nEnter type of appliance:\n");
			String applianceTypeSearch = scanner.nextLine();
						
			boolean validInput = false;
			int i = 0;
			
			switch(applianceTypeSearch) 
			{
				case "1":
					validInput = false;
					String numberOfDoors = "";
					
					while (!validInput) 
					{
						System.out.println("\nEnter number of doors: 2 (double door), 3 (three doors) or 4 (four doors):\n");
						numberOfDoors = scanner.nextLine();
						
						if(numberOfDoors.equals("2") || numberOfDoors.equals("3") || numberOfDoors.equals("4")) 
						{
							validInput = true;
							break;
						}
						System.out.println("Invalid Input");					
					}
					
					System.out.println("Matching Refrigerators:");
					for(i = 0; i < appliances.size(); i++) 
					{ 
						if(appliances.get(i) instanceof Refrigerator) 
						{
							Refrigerator r = (Refrigerator) appliances.get(i);
							if(String.valueOf(r.getNumberOfDoors()).equals(numberOfDoors)) 
							{
								
								System.out.println(r.toString());
							}
						}
						
					}
					break;
				case "2":
					validInput = false;	
					String voltage = "";
					
					while (!validInput) 
					{
						System.out.println("\nEnter battery voltage value 18 V (low) or 24 V (high):\n");
						voltage = scanner.nextLine();
						
						if(voltage.equals("18") || voltage.equals("24")) 
						{
							validInput = true;
							break;
						}
						System.out.println("Invalid Input");					
					}
					
					System.out.println("Matching Vacuums:");
					for(i = 0; i < appliances.size(); i++) 
					{ 
						if(appliances.get(i) instanceof Vacuum) 
						{
							Vacuum v = (Vacuum) appliances.get(i);
							if(String.valueOf(v.getVoltage()).equals(voltage)) 
							{
								System.out.println(v.toString());
							}
						}
						
					}
					break;
				case "3":
					
					validInput = false;	
					String roomType = "";
					
					while (!validInput) 
					{
						System.out.println("\nRoom where the microwave will be installed: K (Kitchen) or W (Worksite):\n");
						roomType = scanner.nextLine();
						
						if(roomType.toUpperCase().equals("W") || roomType.toUpperCase().equals("K")) 
						{
							validInput = true;
							break;
						}
						System.out.println("Invalid Input");					
					}
					
					System.out.println("Matching Microwaves:");
					for(i = 0; i < appliances.size(); i++) 
					{ 
						if(appliances.get(i) instanceof Microwave) 
						{
							Microwave m = (Microwave) appliances.get(i);
							if(m.getRoomType().toUpperCase().startsWith(roomType.toUpperCase())) 
							{
								System.out.println(m.toString());
							}
						}
						
					}
					break;
					
				case "4":
					
					validInput = false;
					String soundRating = "";
					
					while (!validInput) 
					{
						System.out.println("\nEnter the sound rating of the dishwasher: Qt (Quietest), Qr (Quieter), Qu(Quiet) or M (Moderate):\n");
						soundRating = scanner.nextLine();
						
						if(soundRating.toUpperCase().equals("QT") || soundRating.toUpperCase().equals("QR") || soundRating.toUpperCase().equals("QU") || soundRating.toUpperCase().equals("M")) 
						{
							validInput = true;
							break;
						}
						System.out.println("Invalid Input");					
					}
					
					System.out.println("Matching Dishwashers:");
					for(i = 0; i < appliances.size(); i++) 
					{ 
						if(appliances.get(i) instanceof Dishwasher) 
						{
							Dishwasher d = (Dishwasher) appliances.get(i);
							if(d.getSoundRating().toUpperCase().equals(soundRating.toUpperCase())) 
							{
								System.out.println(d.toString());
							}
						}
						
					}
					break;
				default:
					System.out.println("\nNo Appliances Found:");			
			}
		}
		
		// Generates a user defined number of appliances from the master list and displays their toString method
		public static void randomApplianceList(List<Appliance> appliances, Scanner scanner) 
		{			
			System.out.println("\nEnter number of appliances:\n");
			int randomCount = scanner.nextInt();
			
			List<Appliance> randomAppliances = new ArrayList<Appliance>();
			int currentCount;
			int randomNum;
			
			for(currentCount = 0; currentCount < (randomCount);) 
			{
				randomNum = (int)(Math.random() * appliances.size());
				if(!randomAppliances.contains(appliances.get(randomNum))) 
				{
					randomAppliances.add(appliances.get(randomNum));
					currentCount++;
				}
			}
			
			System.out.println("\nRandom Appliances:");
			int i;
			for(i = 0; i < randomAppliances.size(); i++) 
			{
				System.out.println(randomAppliances.get(i).toString());
			}			
		}
	
		// Formats data from each object in master list and re-writes it to data file
		public static void saveChanges(List<Appliance> appliances) 
		{
			String filePath = "src\\appliances.txt";
			try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));) 
			{	
				int i;
				for(i = 0; i < appliances.size(); i++) 
				{
					writer.write(appliances.get(i).toFile());
					writer.newLine();
				}
				System.out.println("\nAll Changes Saved!");
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		// Allows user to navigate through programs functionalities, will not close until program is terminated
		public static void displayMenu() 
		{
			List<Appliance> appliance = createApplianceList();
			boolean isRunning = true;
			Scanner scanner = new Scanner(System.in);
			
			while(isRunning) 
			{
				System.out.println("\nWelcome to Modern Appliances! \nHow May We Assist You? \n1 - Check out appliance \n2 - Find appliances by brand \n3 - Display appliances by type \n4 - Produce random appliance list \n5 - Save & exit");
				String userChoice = scanner.nextLine();
					
				switch(userChoice) 
				{
				case "1":
					checkoutAppliance(appliance, scanner);
					break;
				case "2":
					searchByBrand(appliance, scanner);
					break;
				case "3":
					searchByType(appliance, scanner);
					break;
				case "4":
					randomApplianceList(appliance, scanner);
					break;
				case "5":
					saveChanges(appliance);
					isRunning = false;
					break;
				default:
					System.out.println("Invalid Input");
				}
			}
			scanner.close();
				
		}
	}
}
