import java.util.*;
import java.io.*;

public class Setup {
	final static ArrayList<Integer> wheel = new ArrayList<>();
	static ArrayList<String> billboard;
	static ArrayList<String> temp;
	static StringBuilder word;

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

	public static ArrayList<Integer> wheel() {

		wheel.add(-1);// lose a turn
		wheel.add(800);
		wheel.add(350);
		wheel.add(450);
		wheel.add(700);
		wheel.add(300);
		wheel.add(600);
		wheel.add(5000);
		wheel.add(300);
		wheel.add(600);
		wheel.add(300);
		wheel.add(500);
		wheel.add(800);
		wheel.add(550);
		wheel.add(400);
		wheel.add(300);
		wheel.add(900);
		wheel.add(500);
		wheel.add(2);// wildcard
		wheel.add(900);
		wheel.add(0);// bankrupt
		wheel.add(600);
		wheel.add(400);
		wheel.add(300);
		return wheel;
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
		wheel();
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