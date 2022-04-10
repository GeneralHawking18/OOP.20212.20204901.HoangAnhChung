import java.util.Scanner;
import java.util.Arrays;
public class Section66 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the size of row m: ");
		int m = sc.nextInt();
		System.out.println("Enter the size of column n: ");
		int n = sc.nextInt();
		
		int[][] a = new int[m][n];
		int[][] b = new int[m][n];
		
		for (int i = 0; i <= m - 1; i++) {
			for (int j = 0; j <= n - 1; j++) {
				System.out.printf("Enter a[%d][%d]: ", i, j);
				a[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i <= m - 1; i++) {
			for (int j = 0; j <= n - 1; j++) {
				System.out.printf("Enter b[%d][%d]: ", i, j);
				b[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i <= m - 1; i++) {
			for (int j = 0; j <= n - 1; j++) {
				System.out.print((a[i][j] + b[i][j]) + " ");
			}
			
			System.out.println();
		}
	}

}
