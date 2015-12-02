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
        return good_big;
    }

    public Integer get_bad_integer()
    {
        return bad_big;
    }

    public void start(int good_big, int bad_big)
    {
        model.start(good_big, bad_big);
    }
}