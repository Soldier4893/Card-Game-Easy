public class Card
{
    private int suite;
    private int rank;
    public Card(int r) {
        rank = r;
    }
    public int getRank() {
        return rank;
    }
    public String displayCard()
    {
        String result = "";

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
        return (" ___" + "\n" + "| " + result + "|" + "\n" + "|___|");
    }
}