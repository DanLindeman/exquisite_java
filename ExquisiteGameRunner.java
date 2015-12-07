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

    private CthuluBattle cthulubattle;
    private GuessingGame guessinggame;
    private DragonGame dragongame;

    public ExquisiteGameRunner(int good_int, int bad_int)
    {
        parentPanel.setLayout(cardlayout);

        guessinggame = new GuessingGame();
        game1Panel.add(guessinggame.get_panel());

        dragongame = new DragonGame();
        game2Panel.add(dragongame.get_panel());

        cthulubattle = new CthuluBattle();
        game3Panel.add(cthulubattle.get_panel());

        parentPanel.add(game1Panel, "1");
        parentPanel.add(game2Panel, "2");
        parentPanel.add(game3Panel, "3");

        guessinggame.start(good_int, bad_int);
        cardlayout.show(parentPanel, "1");

        guessinggame.panel.guessing_game_next_game.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                dragongame.start(guessinggame.get_good_integer(), guessinggame.get_bad_integer());
                cardlayout.show(parentPanel, "2");
            }
        });

        dragongame.panel.next_game.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {;
                cthulubattle.start(dragongame.get_good_integer(), dragongame.get_bad_integer());
                cardlayout.show(parentPanel, "3");
            }
        });

        cthulubattle.panel.cthulu_battle_next_game.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.out.println(dragongame.get_good_integer());
                System.out.println(dragongame.get_bad_integer());
                System.exit(0);
            }
        });

        frame.setPreferredSize(new Dimension(600, 600));
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
}