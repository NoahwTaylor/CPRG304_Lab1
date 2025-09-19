package methods;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import appliances.*;


public class Methods 
{
	
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
		
		public static void checkoutAppliance(List<Appliance> appliances) 
		{
			Scanner scanner = new Scanner(System.in);
			
			System.out.println("\nEnter the item number of an appliance:");
			String checkoutItem = scanner.nextLine();
			
			boolean applianceFound = false;
			
			int i = 0;
			for(i = 0; i < appliances.size(); i++) 
			{
				if (appliances.get(i).getItemNumber().equals(checkoutItem)) 
				{
					applianceFound = true;
					appliances.get(i).setQuantity((appliances.get(i).getQuantity()) - 1);
					System.out.println("\nAppliance " + appliances.get(i).getItemNumber() + " has been checked out.");
				}
				
			}
			
			if (!applianceFound) 
			{
				System.out.println("\nThe appliance is not available to be checked out.");
				System.out.println(checkoutItem);
			}
		}
		
		public static void searchByBrand(List<Appliance> appliances)
		{
			Scanner scanner = new Scanner(System.in);
			
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
	
		public static void searchByType(List<Appliance> appliances) 
		{	
			Scanner scanner = new Scanner(System.in);
			
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
	
		public static void displayMenu() 
		{
			List<Appliance> appliance = createApplianceList();
			boolean isRunning = true;
			Scanner scanner = new Scanner(System.in);
			
			while(isRunning) 
			{
				System.out.println("\nWelcome to Modern Appliances! \nHow May We Assist You? \n1 - Check out appliance \n2 - Find appliances by brand \n3 - Display appliances by type \n4 - Produce random appliance list \n5 - Save & exit");
				int userChoice = scanner.nextInt();
				
				
				switch(userChoice) 
				{
				case 1:
					checkoutAppliance(appliance);
					break;
				case 2:
					searchByBrand(appliance);
					break;
				case 3:
					searchByType(appliance);
					break;
				case 4:
				case 5:
				default:
					isRunning = false;
				}
			}
			scanner.close();
				
		}
	}
}
