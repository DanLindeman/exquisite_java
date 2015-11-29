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
    CardLayout cardlayout = new CardLayout();

    //Remove this after figuring out two panels
    JButton go_to_first = new JButton("Go to First");
    JButton go_to_second = new JButton("Go to Second");

    public ExquisiteGameRunner(int good_int, int bad_int)
    {
        parentPanel.setLayout(cardlayout);

        Game1 game1 = new Game1(good_int, bad_int);

        game1Panel.add(game1.get_view());
        game1Panel.add(go_to_second);

        parentPanel.add(game1Panel, "1");

        //Remove after figuring out multipanel

        game2Panel.add(go_to_first);
        parentPanel.add(game2Panel, "2");
        // frame.getContentPane().add(game1.get_view());

        game1.done.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                cardlayout.show(parentPanel, "2");
            }
        });
        
        go_to_first.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                cardlayout.show(parentPanel, "1");
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