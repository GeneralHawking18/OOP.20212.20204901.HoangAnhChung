package hust.soict.dsai.aims.DiskTest;
import hust.soict.dsai.aims.disc.DigitalVideoDisc.DigitalVideoDisc;



public class DiskTest {
	public static void main(String[] args) {
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("Hello 123 13 2323 2323");
		System.out.print(dvd1.isMatch("123 2324"));
	}
}
