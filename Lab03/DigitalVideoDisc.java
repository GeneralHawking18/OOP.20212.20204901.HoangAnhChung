public class DigitalVideoDisc {
	private String title;
	private String category;
	private String director;
	private int length;
	private int cost;
	
	public DigitalVideoDisc(String title) {
		super(); //Actually it can be omitted in this block.
		this.title = title;
	}
	
	
	public DigitalVideoDisc(String title, String category, int cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
	}


	public DigitalVideoDisc(String title, String category, String director, int cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
	}

	
	public DigitalVideoDisc(String title, String category, String director, int length, int cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
	}


	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public int getCost() {
		return cost;
	}

	

}
