package hust.soict.dsai.aims.media;

import java.time.LocalDate;

public class Media {
	protected static int nbMedia = 0;
	protected int id;
	protected String title;
	protected String category;
	protected float cost;
	protected LocalDate localdate = LocalDate.now();

	public Media() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public float getCost() {
		return cost;
	}


	public void setCost(float cost) {
		this.cost = cost;
	}


	public LocalDate getLocaldate() {
		return localdate;
	}


	public void setLocaldate(LocalDate localdate) {
		this.localdate = localdate;
	}


	
	
	

}
