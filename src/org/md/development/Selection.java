package org.md.development;

public class Selection {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Refiner refiner = new Refiner("I WAS A MONKEY", "YOU ARE A FISH", 1000, 10000);
		System.out.println(refiner.evolve());
		//for(int i=0; i < 26; i++)
		//System.out.print((char)('A'+i));
		


	}
}
