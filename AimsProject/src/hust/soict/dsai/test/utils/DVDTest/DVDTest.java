package hust.soict.dsai.test.utils.DVDTest;
import hust.soict.dsai.aims.media.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.utils.DVDUtils.DVDUtils;

public class DVDTest {
	public static void main(String[] args) {
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("AAAA", "aaaa", "aaaa", 1, 5.6f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("BBBB", "aaaa", "aaaa", 2, 5.3f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("CCCC", "aaaa", "aaaa", 3, 5f);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("DDDD", "aaaa", "aaaa", 4, 7.1f);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("EEEE", "aaaa", "aaaa", 5, 3.3f);

		System.out.println(DVDUtils.compareByCost(dvd1, dvd2));
		System.out.println(DVDUtils.compareByTitle(dvd1, dvd2));
		
		DigitalVideoDisc[] sorted = DVDUtils.sortByCost(new DigitalVideoDisc[] {dvd1, dvd2, dvd3, dvd4, dvd5});
		for (int i = 0; i < sorted.length; i++) {
			System.out.println(sorted[i].toString());
		}
		
		System.out.println();
		
		
		sorted = DVDUtils.sortByTitle(new DigitalVideoDisc[] {dvd1, dvd2, dvd3, dvd4, dvd5});
		for (int i = 0; i < sorted.length; i++) {
			System.out.println(sorted[i].toString());
		}
		
		
	}
}
