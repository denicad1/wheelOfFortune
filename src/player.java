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
	public String chooseVowel(Scanner vowel) {
		String correct = "nope";
		try {
			boolean go = false;
			/*
			 * this boolean is so the else statement doesn't run everytime for the size of
			 * the vowels array. the vowels array is so the input can be compared to
			 * something
			 */
			String[] vowels = { "A", "E", "I", "O", "U" };
			System.out.println(spin());
			System.out.println("choose a vowel");

			/*
			 * vowelChoose is the player input for choosing a vowel. it will be changed to
			 * upper case so that it will be comparable to the vowels array. if the player's
			 * choice matches anything in the array then it will change the boolean to true
			 * which will stop the game from saying that a vowel wasn't chosen
			 */
			// PUT A TRY CATCH BLOCK IN THIS METHOD!!!!!!!!!!!!!!!
			String vowelChoose = vowel.next();
			char temp = vowelChoose.toUpperCase().charAt(0);
			String vowelCharAt = Character.toString(temp);

			for (int i = 0; i < vowels.length; i++) {
				if (vowelChoose.toUpperCase().equals(vowels[i]) || vowelCharAt.equals(vowels[i])) {
					go = true;
					correct = vowels[i];

				}

			}
			/*
			 * if no vowel is chosen, boolean stays false and will say that a vowel wasn't
			 * chosen
			 */
			if (!go) {
				System.out.println("not a vowel");

			}

		} catch (NullPointerException e) {

			// TODO: handle exception
			System.out.println("not a vowel. try again");
		}

		return correct;

	}

	/* this method is meant to make sure that the user chooses a consonant */
	public String chooseConsonant(Scanner consonant) {
		boolean go = false;
		String correct = "nope";
		try {

			String[] consonants = { "B", "C", "D", "F", "G", "H", "J", "K", "L", "M", "N", "P", "Q", "R", "S", "T", "V",
					"W", "X", "Y", "Z" };
			System.out.println(spin());
			System.out.println("choose a consonant");

			String consonantChoose = consonant.next();

			for (int i = 0; i < consonants.length; i++) {
				if (consonantChoose.toUpperCase().equals(consonants[i])) {
					go = true;
					correct = consonants[i];
				}

			}
			if (!go) {
				System.out.println("nope");

			}

		} catch (Exception e) {
			// TODO: handle exception
			consonant.nextLine();
		}

		return correct;

		/*
		 * fix choose consonant. also fix chooseVowel. choose vowel must return a
		 * string. chooseConsonant must return string. make it razzle dazzle these
		 * fucks. you got it
		 */

	}

	/* this method is to verify that the phrase is solved */
	public String solve(Scanner phrase) {
		String finished = "nope";
		boolean go = false;
		try {

			System.out.println(spin());
			System.out.println("spell the sentence ");
			String finish = phrase.nextLine().toUpperCase();

			for (int j = 0; j < billboard.size(); j++) {
				if (finish.equalsIgnoreCase(billboard.toString())) {
					go = true;
					finished = "thats it";

				} // if
			} // for
			System.out.println(finish);
		} catch (Exception e) {
			// TODO: handle exception
			phrase.next();
		} // catch
		System.out.println(finished);

		return finished;
	}

}
