public class CurrentCards
{
    int[] currentCards = new int[3];
    
    public CurrentCards(int[] a)
    {
        currentCards[0] = a[0];
        currentCards[1] = a[1];
    }
    
    public boolean isStronger (int[] b)
    {
        if (b[1] > currentCards[1])
        {
            currentCards[1] = b[1];
            return true;
        }
        else
        return false;
    }
    public boolean isSameType (int[] b)
    {
        if (currentCards[0] % b[0] == 0)
        {
            currentCards[0] = b[0];
            return true;
        }
        else
        return false;
    }
    
    public void resetCards()
    {
        currentCards[0] = 0;
        currentCards[1] = 0;
    }
}