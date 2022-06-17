import java.util.Arrays;
import java.util.Scanner;
public class Section64 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the year: ");
		int year = sc.nextInt();
		System.out.println("Enter the month: ");
		int month = sc.nextInt();
		int days;
		if (Arrays.asList(1, 3, 5, 7, 8, 10, 12).contains(month)) {
			days = 31;
		} else {
			if (Arrays.asList(6, 9, 11).contains(month)) {
				days = 30;
			} else {
				if (month % 4 == 0 & month % 100 != 0) {
					days = 29;
				} else {
					days = 28;
				}
			}
		}
		
		System.out.printf("The days of that month is %d" , days);
	}

}
