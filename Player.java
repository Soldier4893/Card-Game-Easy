import java.util.*;

public class Player
{
    private String name;
    //List of all cards
    ArrayList<Integer> Hand = new ArrayList<Integer>();
    
    //List of all cards in group
    ArrayList<Integer> test = new ArrayList<Integer>();
    
    //List of indeces for cards
    ArrayList<Integer> charToInt = new ArrayList<Integer>();
    
    private int[] Group = {-1,0,0};
    
    //Group array contains integers T,S,L always in that order.
    public Player(String n)
    {
        name = n;
    }
    public void setCard(Integer a)
    {
        Hand.add(a);
    }
    public ArrayList<Integer> getHand()
    {
        return Hand;
    }
    public int getSize()
    {
        return Hand.size();
    }
    public String getName()
    {
        return name;
    }
    
    public String showHand()
    {
        String top = "";
        String mid = "";
        String bottom = "";
        String count = "";
        String out;
        String result;
        int rank;
        
        
        ArrayList<Integer> charToInt = new ArrayList<Integer>();
        Collections.sort(Hand, Collections.reverseOrder());
        
        for (int i = 0; i < Hand.size(); i++)
        {
            top = top +" ___  ";
            bottom = bottom + "|___| ";
            count = count + "  " + (char)(i+65) + "   ";
                
            result = "";
            rank = Hand.get(i);
            if(rank == 1)
                result += "A ";
            else if(rank == 10)
                result += "10";
            else if(rank == 11)
                result += "J ";
            else if(rank == 12)
                result += "Q ";
            else if(rank == 13)
                result += "K ";
            else if(rank == 15)
                result += "BJ";
            else if(rank == 16)
                result += "RJ";
            else
                result += rank + " ";
            mid = "| " + result + "| " + mid;
        }
        out = top + "\n" + mid + "\n" + bottom + "\n" + count;
        return out;
    }
    
    public String showTest()
    {
        String top = "";
        String mid = "";
        String bottom = "";
        String out;
        String result;
        int rank;
        
        Collections.sort(test, Collections.reverseOrder());
        
        for (int i = 0; i < test.size(); i++)
        {
            top = top +" ___  ";
            bottom = bottom + "|___| ";
                
            result = "";

            rank = test.get(i);
            if(rank == 1)
                result += "A ";
            else if(rank == 10)
                result += "10";
            else if(rank == 11)
                result += "J ";
            else if(rank == 12)
                result += "Q ";
            else if(rank == 13)
                result += "K ";
            else if(rank == 15)
                result += "BJ";
            else if(rank == 16)
                result += "RJ";
            else
                result += rank + " ";
            mid = "| " + result + "| " + mid;
        }
        out = top + "\n" + mid + "\n" + bottom + "\n\n";
        return out;
    }
    
    public void setGroup(String inputString)
    {
        //converting characters in string to integer ArrayList
        int check;
        test.clear();
        for (int i = 0; i < inputString.length(); i++)
        {
            charToInt.add(Character.getNumericValue(inputString.charAt(i))-10);
        }
        
        Collections.sort(Hand);
        
        for (int i = 0; i < charToInt.size(); i++)
        {
            test.add(Hand.get(charToInt.get(i)));
        }
        
        check = test.get(0);
        Collections.sort(test);
        
        boolean isSame = true;
        for (int i = 0; i < test.size(); i++)
        {
            if (test.get(i) != check)
            {
                isSame = false;
            }
        }

        if (isSame == true)
        {
            if (test.size() == 1)
            {
                Group[0]=2;
                Group[1]=check;
            }
            else if (test.size() == 2)
            {
                Group[0]=3;
                Group[1]=check;
            }
            else if (test.size() == 3)
            {
                Group[0]=5;
                Group[1]=check;
            }
            else
            {
                Group[0]=1;
                Group[1]=check + 15*(test.size()-4);
            }
        }
    }
    
    public int[] getGroup()
    {
        return Group;
    }
    public void removeCards()
    {
        for (int i = 0; i < charToInt.size(); i++)
        {
            int y = charToInt.get(i);
            Hand.remove(y);
        }
        test.clear();
    }
    public void clearCharToInt()
    {
        charToInt.clear();
    }
    public boolean isWinner()
    {
        boolean a = false;
        if (Hand.size() == 0)
        {
            a = true;
        }
        return a;
    }
}   












