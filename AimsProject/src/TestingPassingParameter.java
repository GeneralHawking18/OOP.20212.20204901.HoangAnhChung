import java.lang.reflect.Field;
import java.util.Arrays;


public class TestingPassingParameter {
	public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException, SecurityException {
		
		
		// TODO Auto-generated method stub
		DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle", "test", 2.5f);
		DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
		
		swap(jungleDVD, cinderellaDVD);
		System.out.println("jungle dvd title: " + jungleDVD.getTitle());
		System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());
		
		changeTitle(jungleDVD, cinderellaDVD.getTitle());
		System.out.println("jungle dvd title: " + jungleDVD.getTitle());

	}
	
	public static void swap(Object o1, Object o2) throws IllegalAccessException, NoSuchFieldException, SecurityException {
		/* A general swap method is usable for 2 object of which has the same data type in Java */
		Field[] attrs = o1.getClass().getDeclaredFields(); // "attrs" is the array of the attributes of Object class.
		Object temp = new Object();
		
		for (int i = 0; i < attrs.length; i++) {
			// Private attributes can be manipulated to be accessible over these methods.
			attrs[i].setAccessible(true);
			
			
			temp = attrs[i].get(o1);
			attrs[i].set(o1, attrs[i].get(o2));
			attrs[i].set(o2, temp);
			
		}
		
		
		
		/*for (Field field : attrs_o1) {
			field.setAccessible(true);
		};
		
		Arrays.stream(attrs_o1).forEach(c -> System.out.println(c.getName()));
		
		Object value = attrs_o1[0].get(o1);
		attrs_o1[0].set(o1, value);
		System.out.println("123");
		System.out.println(value.getClass()); */
		
		
		
		
	}

	public static void changeTitle(DigitalVideoDisc dvd, String title) {
		String oldTitle = dvd.getTitle();
		dvd.setTitle(title);
		dvd = new DigitalVideoDisc(oldTitle); 
	}

	
}
