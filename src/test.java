import methods.Methods.ProgramMethods;

import java.util.List;

import appliances.*;


public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Appliance> test = ProgramMethods.createApplianceList();
		System.out.println(test.get(3).toString());
	}

}
