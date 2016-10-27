package org.md.development;

import java.util.Random;

public class Refiner {

	int generations, numberOfChildren;
	String initialString, targetString;
	String[] Kindergarten;

	public Refiner(String targetString, String initialString,
			int numberOfChildren, int generations) {

		this.numberOfChildren = numberOfChildren;
		this.generations = generations;
		this.initialString = initialString;
		this.targetString = targetString;

	}

	public String evolve() {

		for (int i = 0; i < generations; i++) {

			buildKindergarten(numberOfChildren);
			initialString = chooseSuccessor();

		}

		return chooseSuccessor();
	}

	private String chooseSuccessor() {

		int closestID = 0;
		int tempMatchCounter = 0;

		for (int i = 0; i < Kindergarten.length; i++) {
			if (measureCloseness(Kindergarten[i]) > tempMatchCounter) {
				closestID = i;
				tempMatchCounter = measureCloseness(Kindergarten[i]);

			}
		}

		return Kindergarten[closestID];

	}

	private String mutateString(String stringToMutate) {

		Random r = new Random();
		int randomPositionInArray = r.nextInt(stringToMutate.length());
		char[] arrayOfStringToMutate = stringToMutate.toCharArray();

		arrayOfStringToMutate[randomPositionInArray] = (char)('A'+( r
				.nextInt(26)));
		String mutatedString = new String(arrayOfStringToMutate);

		return mutatedString;
	}

	private void buildKindergarten(int numberOfChildren) {

		Kindergarten = new String[numberOfChildren];

		for (int i = 0; i < numberOfChildren; i++)
			Kindergarten[i] = mutateString(initialString);

	}

	private int measureCloseness(String testString) {

		char[] arrayOfTestString = testString.toCharArray();
		char[] arrayOfTargetString = targetString.toCharArray();
		int matchCounter = 0;

		for (int i = 0; i < testString.length(); i++) {
			if (arrayOfTestString[i] == arrayOfTargetString[i])
				matchCounter++;
		}

		return matchCounter;
	}

}
