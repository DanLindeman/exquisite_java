import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GuessingGamePanel extends JPanel
{
    private JButton guess;
    private JLabel inputLabel, outputLabel;
    private JTextField input;
    public JPanel north, south;
    private GuessingGameModel model;

    public JButton guessing_game_next_game;

    public GuessingGamePanel(GuessingGameModel aModel)
    {
        guess = new JButton("Guess");

        guessing_game_next_game = new JButton("Next Game!");
        guessing_game_next_game.setEnabled(false);

        inputLabel = new JLabel("Enter Your Guess: ");
        input = new JTextField("", 10);
        outputLabel = new JLabel("Enter your guess, then click Guess");

        north = new JPanel();
        north.add(inputLabel);
        north.add(input);

        south = new JPanel();
        south.add(guess);
        south.add(guessing_game_next_game);

        setLayout(new BorderLayout());
        add(outputLabel, BorderLayout.CENTER);
        add(north, BorderLayout.NORTH);
        add(south, BorderLayout.SOUTH);

        model = aModel;

        ButtonListener listener = new ButtonListener();
        guess.addActionListener(listener);

    }
    private class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
        
            String text = input.getText();
            int guessNum = Integer.parseInt(text);
            String result = model.verify(guessNum);
            outputLabel.setText(" " + result);
            Boolean winner = result.contains("win");
            Boolean loser = result.contains("lose");
            if (winner == true)
            {
                guess.setEnabled(false);
                guessing_game_next_game.setEnabled(true);
            }
            if (loser == true)
            {
                guess.setEnabled(false);
                guessing_game_next_game.setEnabled(true);
            }
            input.grabFocus();
            input.selectAll();
        }
    }

    public JButton get_next_button()
    {
        return guessing_game_next_game;
    }
}








