
public class DVDTest {
	public static void main(String[] args) {
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("AAAA", "aaaa", "aaaa", 1, 5.6f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("BAAA", "aaaa", "aaaa", 1, 6.2f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("AAAA", "aaaa", "aaaa", 1, 12.3f);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("AAAA", "aaaa", "aaaa", 1, 4.6f);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("AAAA", "aaaa", "aaaa", 1, 3.6f);
		DigitalVideoDisc dvd6 = new DigitalVideoDisc("AAAA", "aaaa", "aaaa", 1, 2.34f);
		
		System.out.println(DVDUtils.compareByTitle(dvd1, dvd2));
		
		DigitalVideoDisc[] sorted = DVDUtils.sortByCost(new DigitalVideoDisc[] {dvd1, dvd2, dvd3, dvd4, dvd5, dvd6});
		for (int i = 0; i < sorted.length; i++) {
			System.out.println(sorted[i].getCost());
		}
		for (int i = 0; i < sorted.length; i++) {
			System.out.println(sorted[i].getCost());
		}
		
		
	}
}
