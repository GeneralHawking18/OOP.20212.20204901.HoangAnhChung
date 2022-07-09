package hust.soict.dsai.test.media;

import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.disc.CompactDisc;
import hust.soict.dsai.aims.media.disc.DigitalVideoDisc;

public class TestMediaToString {
	public static void main(String... args) {
		List<Media> mediae = new ArrayList<Media>();
		
		DigitalVideoDisc dvd = new DigitalVideoDisc("The Lion King", 
													"Animation", 
													"Roger Allers", 
													19.95f);


		Book book = new Book("Star Wars", 
							"Science Fiction",
							87);

		CompactDisc cd = new CompactDisc("Aladin", 
										"Animation", 
										"", 18.99f);
		mediae.add(cd);
		mediae.add(dvd);
		mediae.add(book);
		
		for (Media m: mediae) {
			System.out.println(m);
		}
		
	}
}
