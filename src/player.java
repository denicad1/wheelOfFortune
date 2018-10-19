import java.util.ArrayList;
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

	public int decreaseGrandBank(player x) {
		x.grandTotalBank -= x.bank;
		return x.grandTotalBank;
	}// does wheel of fortune decrease the grand bank?
	/* method to choose and check the vowel */

	public String chooseVowel() {
		boolean go = false;
		/*
		 * this boolean is so the else statement doesn't run everytime for the size of
		 * the vowels array. the vowels array is so the input can be compared to
		 * something
		 */
		String[] vowels = { "A", "E", "I", "O", "U" };
		System.out.println("choose a vowel");
		/*
		 * vowelChoose is the player input for choosing a vowel. it will be changed to
		 * upper case so that it will be comparable to the vowels array. if the player's
		 * choice matches anything in the array then it will change the boolean to true
		 * which will stop the game from saying that a vowel wasn't chosen
		 */

		String vowelChoose = key.next();
		char temp = vowelChoose.toUpperCase().charAt(0);
		String vowelCharAt = Character.toString(temp);

		for (int i = 0; i < vowels.length; i++) {
			if (vowelChoose.toUpperCase().equals(vowels[i]) || vowelCharAt.equals(vowels[i])) {
				go = true;
				return vowels[i];

			}

		}
		/*
		 * if no vowel is chosen, boolean stays false and will say that a vowel wasn't
		 * chosen
		 */
		if (!go) {
			System.out.println("not a vowel");

		}
		// this stays outside of second if statement

		return null;

	}

	public String chooseConsonant() {
		boolean go = false;
		String[] consonants = { "B", "C", "D", "F", "G", "H", "J", "K", "L", "M", "N", "P", "Q", "R", "S", "T", "V",
				"W", "X", "Y", "Z" };
		System.out.println("choose a consonant");
		/*
		 * fill chooseVowel with an actual Vowel. not just an input. this method should
		 * verify the vowel input. figure out later the consonants method. inplement
		 * that in the wheelOfFortune main method
		 */
		String consonantChoose = key.next();
		for (int i = 0; i < consonants.length; i++) {
			if (consonantChoose.toUpperCase().equals(consonants[i])) {
				go = true;
				return consonants[i];
			}
		}
		if (!go) {
			System.out.println("not a consonant");
		}

		return null;

		/*
		 * fix choose consonant. also fix chooseVowel. choose vowel must return a
		 * string. chooseConsonant must return string. make it razzle dazzle these
		 * fucks. you got it
		 */

	}

	public void solve() {
		System.out.println("spell the sentence ");
		String finish = key.next().toUpperCase();
		ArrayList<String> finishTemp = new ArrayList<>();
		for (int i = 0; i < finish.length(); i++) {
			char t = finish.charAt(i);
			String insert = Character.toString(t);
			finishTemp.add(insert);
			for (int j = 0; j < billboard.size(); j++) {
				if (finishTemp.get(j).equals(billboard.get(j))) {
					System.out.println("congrats");
					break;

				} else {
					System.out.println("no that is not the correct answer");
					game.turn();

				}
			}
		}
	}
}
