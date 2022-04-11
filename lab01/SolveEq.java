import java.util.Scanner;
public class SolveEq {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("How many equations?");
		int NumEq =  sc.nextInt();
		int deg = 1;
		
		if (NumEq == 1) {
			System.out.println("How many degrees?");
			deg = sc.nextInt();
		}
		
		if (NumEq == 1 && deg == 1) {
			System.out.println("Enter a: ");
			int a = sc.nextInt();
			System.out.println("Enter b: ");
			int b = sc.nextInt();
			if (a == 0) {
			} else {
				System.out.println("Only one olution is " + (- b/a));
			}
			
		} else {
			if (NumEq == 2 && deg == 1) {
				System.out.println("Enter a1: ");
				int a1 = sc.nextInt();
				System.out.println("Enter b1: ");
				int b1 = sc.nextInt();
				System.out.println("Enter c1: ");
				int c1 = sc.nextInt();
				
				System.out.println("Enter a2: ");
				int a2 = sc.nextInt();
				System.out.println("Enter b2: ");
				int b2 = sc.nextInt();
				System.out.println("Enter c2: ");
				int c2 = sc.nextInt();
				
				int det = a1*b2 - a2*b1;
				int det1 = b1*c2 - b2*c1;
				int det2 = c1*a2 - c2*a1;
				
				if (det != 0) {
					double x = det1/det;
					double y = det2/det;
					System.out.printf("The only solution is x = %f and y = %f ", x, y);
					
				} else {
					if (det1 == 0) {
						System.out.printf("The infinite solution");
					} else {
						System.out.printf("No solution");
					}
				}
			} else {
				System.out.println("Enter a: ");
				int a = sc.nextInt();
				System.out.println("Enter b: ");
				int b = sc.nextInt();
				System.out.println("Enter c: ");
				int c = sc.nextInt();
				
				int delta = b*b - 4*a*c;
				if (delta > 0) {
					System.out.printf("2 solution is x1 = %f and x2 = %f ", 
							((-b - Math.sqrt(delta))/ (2*a)), ((-b + Math.sqrt(delta))/ (2*a)));
				}
				else {
					if (delta == 0) {
						double res = -b/ (2*a);
						System.out.printf("The duplicated solution is x = %f ", res);
					} 
					else {
						System.out.printf("No solution!");
					}
				}
				
			}
		}
		
		
	}

}
