package ttdRegistration;

import static org.junit.Assert.assertTrue;
import java.util.Scanner;

import org.junit.Test;

public class registration
{
	public static void main(String[] args)
	{
		// Scanner for user input
		Scanner input = new Scanner(System.in);
		
		// Initializing variables
		String renterName = "NA";
		double days;
		double totalCost;

		// Takes user name
		System.out.print("Enter name: ");
		renterName = input.nextLine();
		
		// Takes days and calculates cost
		System.out.print("Enter days planned: ");
		days = input.nextDouble();
		totalCost = CalculateCost(days);
		
		// Prints results
		System.out.println(renterName + " owes $" + totalCost);
		
		input.close();
	}
	
	private static Double CalculateCost(Double days)
	{
		double cost;
		// 10% discount if longer than a week, shorter than a month
		if (days >= 7 && days <= 28)
		{
			cost = (0.9 * (days * 45));
			return cost;
		}
		// 20% discount if longer than a month
		else if (days > 28)
		{
			cost = (0.8 * (days * 45));
			return cost;
		}
		// Base cost is $45 a day
		else
		{
			cost = (days * 45);
			return cost;
		}
	}
	
	// Calculation method tester
	@Test
	public void testCalculation()
	{
		double days = 15;
		double expectedCost = 607.5;
		assertTrue(CalculateCost(days) == expectedCost);
	}
}