import java.util.Scanner;
public class Section225 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =  new Scanner(System.in);
		//int a = sc.nextInt(), b = sc.nextInt();
		double a = Double.parseDouble(sc.nextLine());
		double b = Double.parseDouble(sc.nextLine());
		
		System.out.printf("Sum of %f and %f is %f: \n" , a, b, (a + b));
		System.out.printf("Difference of %f and %f: %f\n", a, b, Math.abs(a - b));
		System.out.printf("Product of %f and %f: %f\n", a, b, a * b);
		System.out.printf("Quiotent of %f and %f: %f\n", a, b, a / b);
	}
}
