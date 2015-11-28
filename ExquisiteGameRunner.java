import javax.swing.*;
import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExquisiteGameRunner
{
    public ExquisiteGameRunner()
    {

    }

    public static void main(String[] args)
    {
        int good_int = Integer.parseInt(args[0]);
        int bad_int = Integer.parseInt(args[1]);
        JFrame frame = new JFrame("Exquisite Game");
        Game1 game1 = new Game1(good_int, bad_int);

        ExquisiteGameRunner runner = new ExquisiteGameRunner();
        frame.getContentPane().add(game1.get_view());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        
    }


    // private nextGame(JPanel current, JPanel next)
    // {

    // }

    // public ArrayList<Game> load_all_games()
    // {
    //     //Load games from directory '/Games'
    //     //return ArrayList of Game objects
    // }

}