package hust.soict.dsai.aims.media.track;

public class Track{
	private String title;
	private int length;
	
	public Track(String title, int length) {
		this.title = title;
		this.length = length;
	}
	
	public String getTitle() {
		return title;
	}
	
	public int getLength() {
		return length;
	}
	
	public String play() {
		String playedThing = "Playing track: " + this.getTitle() + "\n"
							+ "Track length: " + this.getLength();
		System.out.println(playedThing);
		return playedThing;
	}
	

	
	@Override 
	public boolean equals(Object o) {
		if (!(o instanceof Track)) {
			return false;
		}
		else {
			Track trackObj = (Track) o;
			return (trackObj.getTitle() == this.getTitle()) && trackObj.getLength() == this.getLength();
		}
	}
}
