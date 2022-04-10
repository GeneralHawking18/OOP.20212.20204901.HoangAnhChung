import java.util.Scanner;
public class JavaBasics225 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =  new Scanner(System.in);
		int a = sc.nextInt(), b = sc.nextInt();
		System.out.printf("Sum of %d and %d is %d: \n" , a, b, (a + b));
		System.out.printf("Difference of %d and %d: %d\n", a, b, Math.abs(a - b));
		System.out.printf("Product of %d and %d: %d\n", a, b, a * b);
		System.out.printf("Quiotent of %d and %d: %d\n", a, b, a / b);
	}

}
