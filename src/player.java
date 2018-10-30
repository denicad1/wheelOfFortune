import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/**
 * 
 */

/**
 * @author Anthony Denicolo
 *
 */
public class player extends Setup {
	int bank;
	int grandTotalBank;
	String name;
	/* created a wheelOfFortune object to use any methods from it that I have to */
	wheelOfFortune game = new wheelOfFortune();

	/**
	 * @param bank
	 * @param grandTotalBank
	 * @param name
	 */
	public player(int bank, int grandTotalBank, String name) {
		super();
		this.bank = bank;
		this.grandTotalBank = grandTotalBank;
		this.name = name;
	}

	/**
	 * @return the bank
	 */
	public int getBank() {
		return bank;
	}

	/**
	 * @param bank
	 *            the bank to set
	 */
	public void setBank(int bank) {
		this.bank = bank;
	}

	/**
	 * @return the grandTotalBank
	 */
	public int getGrandTotalBank() {
		return grandTotalBank;
	}

	/**
	 * @param grandTotalBank
	 *            the grandTotalBank to set
	 */
	public void setGrandTotalBank(int grandTotalBank) {
		this.grandTotalBank = grandTotalBank;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 * @return
	 */
	public void setName(String name) {
		this.name = name;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "player [bank=" + bank + ", grandTotalBank=" + grandTotalBank + ", name=" + name + "]";
	}

	/**
	 * ^^^ToString prints out player info. maybe get rid of the bank since it only
	 * pertains to the current round
	 **/

	public int increaseGrandBank(player x) {
		x.grandTotalBank += x.bank;
		return x.grandTotalBank;
	}// method to add the bank of the current round to the grand bank of the winner

	/* this method is to verify that the player chooses a vowel */
	public boolean chooseVowel(Scanner vowel) {
		String correct = "nope";
		boolean go = false;
		try {
			int letterMultiplier = 0;
			/*
			 * this boolean is so the else statement doesn't run everytime for the size of
			 * the vowels array. the vowels array is so the input can be compared to
			 * something
			 */

			System.out.println(spin());
			System.out.println("choose a vowel");

			/*
			 * vowelChoose is the player input for choosing a vowel. it will be changed to
			 * upper case so that it will be comparable to the vowels array. if the player's
			 * choice matches anything in the array then it will change the boolean to true
			 * which will stop the game from saying that a vowel wasn't chosen
			 */

			String vowelChoose = vowel.nextLine();

			char temp = vowelChoose.toUpperCase().charAt(0);
			String vowelCharAt = Character.toString(temp);

			for (int i = 0; i < vowels.length; i++) {
				if (vowelChoose.toUpperCase().equals(vowels[i]) || vowelCharAt.equals(vowels[i])) {
					go = true;
					correct = vowels[i];
					for (int y = 0; y < word.length(); y++) {

						if (billboard.get(y).equals(correct)) {
							word.replace(y, y + 1, correct);
						}

					}
					vowels[i] = " ";

				}

			}

			/*
			 * if no vowel is chosen, boolean stays false and will say that a vowel wasn't
			 * chosen
			 */
			if (!go) {
				System.out.println("not a vowel");
				// playerturn++;

			}
			for (int i = 0; i < word.length(); i++) {
				if (correct.equals(billboard.get(i))) {
					go = true;
					letterMultiplier++;
					billboard.set(i, " ");
				}

			}
			for (int i = 0; i < word.length(); i++) {

				if (billboard.get(i).equals(correct)) {
					word.replace(i, i + 1, correct);
				}

			}

			System.out.println(billboard.toString());
			System.out.println(word.toString());
		} catch (NullPointerException e) {

			// TODO: handle exception
			System.out.println("not a vowel. try again");
		}

		return go;

	}

	/* this method is meant to make sure that the user chooses a consonant */
	public boolean chooseConsonant(Scanner consonant) {
		boolean go = false;
		String correct = "nope";
		try {
			int letterMultiplier = 0;

			System.out.println(spin());
			System.out.println("choose a consonant");

			String consonantChoose = consonant.nextLine();
			char temp = consonantChoose.toUpperCase().charAt(0);
			String consonantCharAt = Character.toString(temp);
			for (int i = 0; i < consonants.length; i++) {
				if (consonantChoose.toUpperCase().equals(consonants[i]) || consonantCharAt.equals(consonants[i])) {

					correct = consonants[i];
					for (int y = 0; y < word.length(); y++) {
						if (correct.equals(billboard.get(y))) {
							word.replace(y, y + 1, correct);
						}
					}
					consonants[i] = " ";

				}

			}
			System.out.println(correct + "this is after replacing stuff in the array");
			// System.out.println(go + " this is before the if");
			if (!go) {
				System.out.println("not a consonant");
				// playerturn++;
				// System.out.println(go + " this is after");
			}
			for (int i = 0; i < word.length(); i++) {
				if (correct.equals(billboard.get(i))) {
					go = true;
					letterMultiplier++;
					billboard.set(i, " ");
					System.out.println("correct");
				}

			}

			for (int i = 0; i < word.length(); i++) {
				if (correct.equals(billboard.get(i))) {
					word.replace(i, i + 1, correct);
				}
			}

			System.out.println(billboard.toString() + "this is from the boardchanger method");
			System.out.println(word + "same as above");
		} catch (NullPointerException e) {
			// TODO: handle exception
			System.out.println("not a consonant. try again");
		}

		return go;

		/*
		 * fix choose consonant. also fix chooseVowel. choose vowel must return a
		 * string. chooseConsonant must return string. make it razzle dazzle these
		 * fucks. you got it
		 */

	}

	/*
	 * this method is to verify that the phrase is solved. it takes the player input
	 * and puts it into an array. it compares the array to the array that the phrase
	 * is chosen from
	 */
	public String solve(Scanner phrase) {
		String finished = "nope";
		ArrayList<String> hello = new ArrayList<>();

		try {

			System.out.println(spin());
			System.out.println("spell the sentence ");
			String finish = phrase.nextLine().toUpperCase();
			for (int i = 0; i < finish.length(); i++) {
				char t = finish.charAt(i);
				String insert = Character.toString(t);
				hello.add(insert);
				if (hello.get(i).equals(billboard.get(i))) {

					finished = hello.toString();

				} // if
			}
			for (int i = 0; i < billboard.size(); i++) {

				if (billboard.get(i).equals(finish)) {
					word.replace(i, i + 1, finish);
				} /*
					 * start working on the third method. need to make banking,user input for phrase
					 * and topic,and try to fix the switch problem where it only goes about 4 times
					 * and stops then pretty it all up. try to have it print out all the letters
					 * that have already been chosen. the arrays are there, just need to find a way
					 * to restore them each round.
					 */

			}
			System.out.println(word.toString());

		} catch (Exception e) {
			// TODO: handle exception
			// phrase.next();
		} // catch
		System.out.println(finished);

		return finished;
	}

}
