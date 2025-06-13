import java.util.*;
public class NutritionCalculator{
void main() {
	Scanner scan = new Scanner(System.in);
	System.out.print("Please enter your age (Years): ");
	int age = scan.nextInt();
	System.out.print("Please enter your weight (lbs): ");
	double weight = scan.nextDouble();
	System.out.print("Please enter your height (Inches): ");
	double height = scan.nextDouble();
	System.out.print("Please enter your gender(M or F): ");
	String gender = scan.next();
	System.out.println("\nPick your activity level please:");
	System.out.println("1 - Very little activity or no weekly exercise:");
	System.out.println("2 - Lightly active (1-3 days a week)");
	System.out.println("3 - Moderately active (3-5 times a week)");
	System.out.println("4 Active (5-7 days a week)");
	System.out.println("5 Very active (7 days a week, Intense exercise daily)");
	System.out.print("Enter number(1-5): ");
		int activityLvl = scan.nextInt();
	double Maintenance = calculateMaintenance(weight, height, age, gender);
	double actvMulti= switchActivityMultiplier(activityLvl);
	double maint = Maintenance * actvMulti;
		



	
	System.out.println("\nYour estimated maintenance calories: " +(int)maint);
}
private static double calculateMaintenance(double weightLbs, double heightInch, int age, String gender) {
	double weightKg = weightLbs / 2.205;
	double heightcm = heightInch * 2.54;
	if(gender.equalsIgnoreCase("M")) {
	return(10 *weightKg) + 	(6.25 * heightcm) - (5 * age) 	+ 5;

	} else if(gender.equalsIgnoreCase("F")){
		return (10 * weightKg) + (6.25 *heightcm) - (5 *age) - 161;
	}else{
		System.out.println("Invalid gender input. Going to switch to default (M).");
		return(10 *weightKg) + 	(6.25 * heightcm) - (5 * age) 	+ 5;
	}
}
private static double switchActivityMultiplier(int lvl){
	switch (lvl) {
		case 1: return 1.2;
		case 2: return 1.375;
		case 3: return 1.55;
		case 4:  return 1.725;
		case 5: return 1.9;
		default:
		System.out.println("Invalid activity level, reseting to no exercise.");
		return 1.2;
	}
}


}	
