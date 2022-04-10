import java.util.Scanner;
import java.util.Arrays;
public class Section65 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i <= n - 1; i++) {
			a[i] = sc.nextInt();
		}
		Arrays.sort(a);
		for (int i = 0; i <= n - 1; i++) {
			System.out.print(a[i] + " ");
		}
	}

}
