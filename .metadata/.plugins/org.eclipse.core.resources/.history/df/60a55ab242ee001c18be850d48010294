package hust.soict.dsai.garbage;

import java.util.Random;

public class ConcatenationInLoops {
	public static void main(String[] args) {
		System.out.println("String concatenation running time");
		Random r = new Random(123);
		long start = System.currentTimeMillis();
		String s = "";  
		for (int i = 0; i < 65536; i++) 
			s += r.nextInt(2);
		System.out.println(System.currentTimeMillis() - start);
	
		System.out.println("StringBuilder appendation running time");
		r = new Random(123);
		start = System.currentTimeMillis();
		StringBuilder sBd = new StringBuilder();
		for (int i = 0; i < 65536; i++) 
			sBd.append(r.nextInt(2));
		s = sBd.toString();
		System.out.println(System.currentTimeMillis() - start);
		
		System.out.println("StringBuffer appendation running time");
		r = new Random(123);
		start = System.currentTimeMillis();
		StringBuffer sBf = new StringBuffer();
		for (int i = 0; i < 65536; i++) 
			sBf.append(r.nextInt(2));
		s = sBf.toString();
		System.out.println(System.currentTimeMillis() - start);
	}
	
}
