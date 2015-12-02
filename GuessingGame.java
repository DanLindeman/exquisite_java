import javax.swing.*;

public class GuessingGame implements ExquisiteInterface
{
    private int good_big, bad_big;
    public GuessingGamePanel panel;
    private GuessingGameModel model;

    public GuessingGame()
    {
        model = new GuessingGameModel();
        panel = new GuessingGamePanel(model);
    }

    public JPanel get_panel()
    {
        return panel;
    }

    public Integer get_good_integer()
    {
        return model.get_good_integer();
    }

    public Integer get_bad_integer()
    {
        return model.get_bad_integer();
    }

    public void start(int good_big, int bad_big)
    {
        JOptionPane.showMessageDialog(null, "Guess the secret number! 1-" + bad_big);
        model.start(good_big, bad_big);
    }
}