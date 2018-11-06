import java.util.*;

import java.io.*;

public class Setup {
	/**
	 * @param prompt
	 */

	/**
	 * @param prompt
	 */

	final static ArrayList<Integer> wheel = new ArrayList<>();
	static ArrayList<String> billboard;
	static ArrayList<String> temp;
	static StringBuilder word;
	static String topic;
	static int counter = 1;
	static String[] vowelsPerm = { "A", "E", "I", "O", "U" };
	static String[] vowels = { "A", "E", "I", "O", "U" };
	static String[] consonants = { "B", "C", "D", "F", "G", "H", "J", "K", "L", "M", "N", "P", "Q", "R", "S", "T", "V",
			"W", "X", "Y", "Z" };
	static String[] consonantsPerm = { "B", "C", "D", "F", "G", "H", "J", "K", "L", "M", "N", "P", "Q", "R", "S", "T",
			"V", "W", "X", "Y", "Z" };
	static int playerturn = 0;
	public static ArrayList<player> listOfPlayers = new ArrayList<>();
	static boolean finished = false;

	public static String topic() {
		System.out.println("enter a topic:");
		// won't catch if the topic is empty, only if the phrase is empty
		topic = wheelOfFortune.key.nextLine().toUpperCase();
		System.out.println("enter a phrase:");

		String phrase = wheelOfFortune.key.nextLine().toUpperCase();

		if (phrase.length() > 30 || phrase.length() <= 1) {
			System.out.println("re-enter a topic and phrase");
			topic();
		}
		return phrase;
		// the topic and category are set up
	}

	public static void board(String topic) {
		billboard = new ArrayList<>(topic.length());
		temp = new ArrayList<>(topic.length());
		word = new StringBuilder();
		for (int i = 0; i < topic.length(); i++) {
			char t = topic.charAt(i);
			String insert = Character.toString(t);
			billboard.add(insert);
		}

		for (int i = 0; i < topic.length(); i++) {
			if (billboard.get(i).equals(" ")) {
				temp.add(" ");

			} else if (billboard.get(i).equals("'")) {
				temp.add("'");
			} else if (billboard.get(i).equals("&")) {
				temp.add("&");
			} else if (billboard.get(i).equals("!")) {
				temp.add("!");
			} else {
				temp.add("*");
			}

		}
		for (int i = 0; i < temp.size(); i++) {
			String letter = temp.get(i);
			word.append(letter);
		}

		System.out.println(word);

	}

	public static int spin() {

		int wheelTick = new Random().nextInt(24);
		int spin = wheelTick;
		int fin = 0;
		// figure out how make it pull up bankrupt,wildcard,and lose a turn
		if (spin == 0) {
			fin = -1;
		} else if (spin >= 1 || spin <= 17) {
			fin = wheel.get(spin);
		} else if (spin == 18) {
			fin = 2;
		} else if (spin == 19) {
			fin = wheel.get(spin);
		} else if (spin == 20) {
			fin = 0;
		} else if (spin >= 21) {
			fin = wheel.get(spin);
		}
		return fin;

	}

}