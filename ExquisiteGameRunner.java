import javax.swing.*;
import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExquisiteGameRunner
{
    JFrame frame = new JFrame("Exquisite Game");
    JPanel parentPanel = new JPanel();
    JPanel game1Panel = new JPanel();
    JPanel game2Panel = new JPanel();
    JPanel game3Panel = new JPanel();
    CardLayout cardlayout = new CardLayout();
    private int good_big, bad_big;
    private Game1 game1;
    private GuessingGame guessinggame;

    public ExquisiteGameRunner(int good_int, int bad_int)
    {
        parentPanel.setLayout(cardlayout);

        game1 = new Game1();
        game1Panel.add(game1.get_panel());

        guessinggame = new GuessingGame();
        game2Panel.add(guessinggame.get_panel());

        //dragongame = new DragonGame();
        //game3Panel.add(dragongame.get_panel());
        

        parentPanel.add(game1Panel, "1");
        parentPanel.add(game2Panel, "2");
        parentPanel.add(game3Panel, "3");


        game1.start(good_int, bad_int);
        


        game1.done.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {    
                guessinggame.start(game1.get_good_integer(), game1.get_bad_integer());
                cardlayout.show(parentPanel, "2");
            }
        });

        frame.add(parentPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
       
    }

    public static void main(String[] args)
    {
        int good_int = Integer.parseInt(args[0]);
        int bad_int = Integer.parseInt(args[1]);
        ExquisiteGameRunner runner = new ExquisiteGameRunner(good_int, bad_int);      
    }


    // public ArrayList<Game> load_all_games()
    // {
    //     //Load games from directory '/Games'
    //     //return ArrayList of Game objects
    // }

}