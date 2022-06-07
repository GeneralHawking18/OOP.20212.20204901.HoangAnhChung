package hust.soict.dsai.aims.media;
import java.util.ArrayList;
import java.util.List;

public class Book extends Media{
	private List<String> authors = new ArrayList<String>();
	
	public Book(String title) {
		super(title);
	}
	
	public Book(String title, String category, float cost) {
		super(title, category, cost);
	}
	
	public void addAuthor(String authorName) {
		if (authors.contains(authorName) == false) {
			authors.add(authorName);
		}
	}
	
	public void removeAuthor(String authorName) {
		if (authors.contains(authorName) == true) {
			authors.remove(authorName);
		}
	}
	
	@Override 
	public String toString() {
		return String.format("Book - %s - %s - %s - %f", super.getTitle(), super.getCategory(), authors, super.getCost());
	}
	
	
	
	
	

}
