import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;

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
		this.bank += bank;
	}

	public void resetBank(int bank) {
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
		this.grandTotalBank += grandTotalBank;
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

	/* this method is to verify that the player chooses a vowel */

	public boolean chooseVowel(Scanner vowel) {
		String correct = "nope";
		boolean go = false;
		try {

			/*
			 * this boolean is so the else statement doesn't run everytime for the size of
			 * the vowels array. the vowels array is so the input can be compared to
			 * something
			 */
			if (listOfPlayers.get(playerturn).getBank() < 100) {
				System.out.println("not enough money");
				return go;
			} else {
				listOfPlayers.get(playerturn).bank -= 100;
			}

			System.out.print("Vowels: ");
			for (int i = 0; i < vowels.length; i++) {
				System.out.print(vowels[i] + " ");
			}
			System.out.println();
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

			}
			for (int i = 0; i < word.length(); i++) {
				if (correct.equals(billboard.get(i))) {
					go = true;
					billboard.set(i, " ");
				}
			}
			for (int i = 0; i < word.length(); i++) {
				if (billboard.get(i).equals(correct)) {
					word.replace(i, i + 1, correct);
				}
			}
			System.out.println(topic);
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
			int spinValue = spin();
			System.out.println(spinValue);
			if (spinValue == -1) {
				System.out.println("lose turn");
				return go;
			} else if (spinValue == 0) {
				listOfPlayers.get(playerturn).setBank(0);
				System.out.println("Bankrupt");
				return go;
			}
			System.out.print("Consonants: ");
			for (int i = 0; i < consonants.length; i++) {
				System.out.print(consonants[i] + " ");
			}
			System.out.println();
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
			for (int i = 0; i < word.length(); i++) {
				if (correct.equals(billboard.get(i))) {
					go = true;
					letterMultiplier++;
					billboard.set(i, " ");

				}

			}

			for (int i = 0; i < word.length(); i++) {
				if (correct.equals(billboard.get(i))) {
					word.replace(i, i + 1, correct);
				}
			}
			if (go == true) {
				int points = letterMultiplier * spinValue;

				listOfPlayers.get(playerturn).setBank(points);

			}
			System.out.println("Topic is " + topic);
			System.out.println("Our word is " + word);
			System.out.println(
					listOfPlayers.get(playerturn).getName() + " has " + listOfPlayers.get(playerturn).getBank());
		} catch (NullPointerException e) {
			// TODO: handle exception
			System.out.println("not a consonant. try again");
		} catch (StringIndexOutOfBoundsException e) {
			System.out.println("not an answer");
			consonant.nextLine();
		}

		return go;

	}

	/*
	 * this method is to verify that the phrase is solved. it takes the player input
	 * and puts it into an array. it compares the array to the array that the phrase
	 * is chosen from
	 */
	public boolean solve(Scanner phrase) {

		ArrayList<String> hello = new ArrayList<>();

		try {

			System.out.println("Solve the puzzle ");
			String finish = phrase.nextLine().toUpperCase();
			for (int i = 0; i < finish.length(); i++) {
				char t = finish.charAt(i);
				String insert = Character.toString(t);
				hello.add(insert);
			}
			for (int j = 0; j < word.length(); j++) {
				if (hello.get(j).equals(billboard.get(j))) {
					word.replace(j, j + 1, hello.get(j));

				}
			}
			ArrayList<Character> thumb = new ArrayList<>();
			for (int i = 0; i < word.length(); i++) {
				thumb.add(word.charAt(i));
			}

			if (thumb.toString().toUpperCase().equals(hello.toString().toUpperCase())) {
				finished = true;
			}

			System.out.println(word.toString());

		} catch (Exception e) {
			// TODO: handle exception
			// phrase.next();
		} // catch

		return finished;
	}

	public void isSolved() {

		listOfPlayers.get(playerturn).setGrandTotalBank(listOfPlayers.get(playerturn).bank);
		for (int i = 0; i < listOfPlayers.size(); i++) {
			listOfPlayers.get(i).resetBank(0);
		}
		for (int i = 0; i < vowelsPerm.length; i++) {
			vowels[i] = vowelsPerm[i];
		}
		for (int i = 0; i < consonants.length; i++) {
			consonants[i] = consonantsPerm[i];
		}

		finished = false;
	}

}
