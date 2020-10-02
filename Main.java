import java.util.*;

public class Main
{
	public static void main(String[] args) {
	    
        Scanner scan = new Scanner(System.in);
        String winner = "";

		//Create Deck
		ArrayList<Card> Deck = new ArrayList<Card>();

		for (int i = 0; i < 4; i++)
		{
		    for (int j = 0; j < 13; j++)
		    {
		        Deck.add(new Card(j+1));
		    }
		}
		Deck.add(new Card(15));
		Deck.add(new Card(16));
		
		//Create players and deal cards
		System.out.println("Welcome to a modified version of the card game 争上游, played between 3 people. Please enter your names.");
		System.out.print("Player One: ");
		String name1 = scan.next();
		System.out.print("Player Two: ");
		String name2 = scan.next();
		System.out.print("Player Three: ");
		String name3 = scan.next();
		
		Player p1 = new Player(name1);
		Player p2 = new Player(name2);
		Player p3 = new Player(name3);

		int prandom;
		
		for (int i = 54; i > 0; i--)
		{
		    prandom = (int)(Math.random()*i);
		    p1.setCard(Deck.get(prandom).getRank());
		    Deck.remove(prandom);
		    i--;
		    prandom = (int)(Math.random()*i);
		    p2.setCard(Deck.get(prandom).getRank());
		    Deck.remove(prandom);
		    i--;
		    prandom = (int)(Math.random()*i);
		    p3.setCard(Deck.get(prandom).getRank());
		    Deck.remove(prandom);
		}
		
		System.out.println(p1.getName() + ", please enter the letters corresponding to the card you want to play. You do not need spaces, but this is case-sensitive.");
		System.out.println(p1.showHand());
		
        //Passes char to method, check for errors.
        String inputChar;
        inputChar = scan.next();
        while (inputChar.equals(""))
        {
            System.out.println("That is not a valid order. Please enter a valid order.");
            inputChar = scan.next();
        }
        
        p1.setGroup(inputChar);
        
        //Will be given a group array. Check if valid
        while (p1.getGroup()[0] == -1)
        {
            p1.clearCharToInt();
            System.out.println("That is not a valid combination. Please enter a valid combination.");
            inputChar = scan.next();
            p1.setGroup(inputChar);
        }
        
        //Create current cards
        CurrentCards current = new CurrentCards(p1.getGroup());
        System.out.println("\n\n" + "The current deck is:");
        System.out.println(p1.showTest());
        p1.removeCards();
        
        //Start loop
        ArrayList<Player> loop = new ArrayList<Player>();
        loop.add(p2);
        loop.add(p3);
        loop.add(p1);

        boolean isWinnerMain = false;
        int skipCount = 1;
        while (isWinnerMain == false)
        {
            for (int i = 0; i < loop.size(); i++)
            {
                System.out.println(loop.get(i).getName() + ", please enter the letters corresponding to the cards you want to play. Do not include spaces. Enter \" 0 \" to skip.");
                System.out.println(loop.get(i).showHand());
                inputChar = scan.next();
                
                if (inputChar.equals("0") == false)
                {
                    loop.get(i).clearCharToInt();
                    loop.get(i).setGroup(inputChar);
                
                    //Will be given a group array. Check if valid
                    while (loop.get(i).getGroup()[0] == -1)
                    {
                        loop.get(i).clearCharToInt();
                        System.out.println("That is not allowed. Please enter a valid combination.");
                        inputChar = scan.next();
                        loop.get(i).setGroup(inputChar);
                    }
                    while (current.isStronger(loop.get(i).getGroup()) == false)
                    {
                        loop.get(i).clearCharToInt();
                        System.out.println("That is not allowed. Please enter a stronger combination.");
                        inputChar = scan.next();
                        loop.get(i).setGroup(inputChar);
                    }
                    while (current.isSameType(loop.get(i).getGroup()) == false)
                    {
                        loop.get(i).clearCharToInt();
                        System.out.println("That is not a allowed. Please enter a valid combination.");
                        inputChar = scan.next();
                        loop.get(i).setGroup(inputChar);
                    }
                    skipCount = 1;
                    System.out.println("\n\n" + "The current deck is:");
                    System.out.println(loop.get(i).showTest());
                    loop.get(i).removeCards();
                    if (loop.get(i).isWinner() == true)
                    {
                        isWinnerMain = true;
                    }
                }
                else if (skipCount - loop.size() == -1)
                {
                    current.resetCards();
                    if (i == loop.size()-1)
                    {
                        System.out.println(loop.get(0).getName() + ", no one wants to beat your card. Choose whatever cards you want to play next.");
                        skipCount = 1;
                    }
                    else
                    {
                        System.out.println(loop.get(i+1).getName() + ", no one wants to beat your card. Choose whatever cards you want to play next.");
                        skipCount = 1;
                    }
                }
                else
                {
                    skipCount++;
                }
                if (loop.get(i).isWinner() == true)
                {
                    isWinnerMain = true;
                    winner = "Congradulations " + loop.get(i).getName()+  ", You Won!";
                }
            }
        }
		System.out.println(winner);
	}
}
