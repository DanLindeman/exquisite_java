import javax.swing.*;
import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class ExquisiteGameRunner
{
    private int good_int, bad_int;

    public ExquisiteGameRunner()
    {
        this.good_int = ThreadLocalRandom.current().nextInt(1, 100);
        this.bad_int = ThreadLocalRandom.current().nextInt(1, 100);
    }

    public static void main(String[] args)
    {

        // load games from some directory
        // ArrayList<Game> games = load_all_games();
        // for (Game current_game : games)
        // View view = new View();
        Game game1 = new Game1();
        JFrame frame = new JFrame("Exquisite Game");
        frame.getContentPane().add(game1.get_view());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    // public ArrayList<Game> load_all_games()
    // {
    //     //Load games from directory '/Games'
    //     //return ArrayList of Game objects
    // }

}