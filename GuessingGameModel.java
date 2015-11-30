import java.util.Random;

public class GuessingGameModel
{
    private int count, secretNum, good_big, bad_big;
    private Random rand;

    public GuessingGameModel()
    {
        rand = new Random();
    }

    public void start(int good_big, int bad_big)
    {
        //it is good to get many guesses
        count = good_big;

        //it is bad for the range to be large
        secretNum = rand.nextInt(bad_big) + 1;
    }    

    public String verify(int guess)
    {
        count--;
        if (count == 0)
        {
            good_big = rand.nextInt(100) + 1;
            bad_big = rand.nextInt(good_big) + 1;
            return "You lose, no more guesses. Click Next Game!";
        }
        else if (guess < secretNum)
            return "Your guess is too low! " + count + " guesses remain";
        else if (guess > secretNum)
            return "Your guess is too high! " + count + " guesses remain";
        else
            return "You win, with " + count + " guesses remaining!";

    }
}