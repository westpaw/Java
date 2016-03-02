/**
 * This is a class that tests the Card class.
 */
public class CardTester {

	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		Card card1 = new Card("nine", "hearts", 9);
		Card card2 = new Card("queen", "clubs", 12);
		Card card3 = new Card("queen", "clubs", 12);
		
		System.out.println("In this pile of cards lies:");
		System.out.println(card1.toString());
		System.out.println(card2.toString());
		System.out.println(card3.toString());
		System.out.println();
		
		if(card1.matches(card2))
				System.out.println("You cheater!  You can't have more than one " + card1.toString());
		if(card1.matches(card3))
				System.out.println("You cheater!  You can't have more than one " + card1.toString());
		if(card2.matches(card3))
				System.out.println("You cheater!  You can't have more than one " + card2.toString());
	}
}
