import java.util.ArrayList;

/**
 * 
 */
/**
 * @author Anthony Denicolo
 *
 */
public class wheelOfFortune extends Setup {

	static int rounds = 3;
	/* array of players */
	public static ArrayList<player> listOfPlayers = new ArrayList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Wheel of Fortune");
		/* these are the players */
		player player1 = new player(100, 0, Name());
		player player2 = new player(100, 0, Name());
		player player3 = new player(100, 0, Name());
		/* adding the player objects to the array listOfPlayers */
		listOfPlayers.add(player1);
		listOfPlayers.add(player2);
		listOfPlayers.add(player3);

		board(topic());

		choices();

	}

	/*
	 * the name method allows you to name each player
	 */
	public static String Name() {
		/*
		 * this counter is only for saying which player is getting named
		 */int counter = 1;
		System.out.println("input player" + counter + " name");
		counter++;
		String name = key.nextLine();
		return name;

	}

	/*
	 * the choices method allows you to choose between picking a vowel, consonant or
	 * attempting to solve the puzzle
	 */
	public static void choices() {
		/*
		 * this for loop is for choosing which player is getting to choose what they
		 * want to do
		 */
		for (int i = 0; i < listOfPlayers.size(); i++) {
			System.out.println("what would you like to do? Press 1 to buy a vowel, " + "press 2 to get a consonant "
					+ "press 3 to solve the puzzle ");
			int caseNumber = key.nextInt();
			System.out.println(spin());
			switch (caseNumber) {
			case 1: {
				listOfPlayers.get(i).chooseVowel();
				break;
			}
			case 2: {
				listOfPlayers.get(i).chooseConsonant();
				break;
			}
			case 3: {
				listOfPlayers.get(i).solve();
				break;
			}
			}

		}
	}

	public static void turn() {

	}
}
