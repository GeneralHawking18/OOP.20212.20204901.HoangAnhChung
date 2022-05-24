import java.util.Scanner;
public class InputFromKeyboard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("What is your name?");
		String strname = sc.nextLine();
		
		System.out.println("How old are you?");
		int iAge = sc.nextInt();
		
		System.out.println("How tall are you?");
		double dHeight = sc.nextDouble();
		
		System.out.printf(
				"Mrs/Ms + %s , %d years old. Your height is %.2f" , strname, iAge, dHeight);
		
	}

}
