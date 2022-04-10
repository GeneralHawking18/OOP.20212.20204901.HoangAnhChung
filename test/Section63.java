import java.util.Scanner;
public class JavaBasic63 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = n; i >= 1; i--) {
			for (int LeftSpace = 1; LeftSpace <= i - 1; LeftSpace++) {
				System.out.print(" ");
			}
			for (int chr = 1; chr <= 2* (n - i) + 1; chr++) {
				System.out.print("*");
			}
			System.out.print("\n");
			
		}

	}

}
