import java.util.*;
import java.io.*;

public class Setup {
	final static ArrayList<Integer> wheel = new ArrayList<>();
	static ArrayList<String> billboard;
	static ArrayList<String> temp;
	static StringBuilder word;
	static int counter = 1;
	String[] vowels = { "A", "E", "I", "O", "U" };
	String[] consonants = { "B", "C", "D", "F", "G", "H", "J", "K", "L", "M", "N", "P", "Q", "R", "S", "T", "V", "W",
			"X", "Y", "Z" };
	static int playerturn = 0;
	public static ArrayList<player> listOfPlayers = new ArrayList<>();

	public static String topic() {
		int decider = new Random().nextInt(3);
		int decider1 = new Random().nextInt(3);
		String[] person = { "Marilyn Monroe", "Abraham Lincoln", "Martin Luther King" };
		String[] place = { "D ubai", "Har  lem", "Tok yo" };
		String[] thing = { "ir on", "sh oe", "eiffel tower" };
		String[][] categories = { person, place, thing };
		String topic = categories[decider][decider1];
		return topic.toUpperCase();
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

			} else {
				temp.add("*");
			}

		}
		for (int i = 0; i < temp.size(); i++) {
			String letter = temp.get(i);
			word.append(letter);
		}
		System.out.println(billboard.toString() + "this is being printed from the setup class");
		System.out.println(word + "same thing as above");

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