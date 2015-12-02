import javax.swing.*;

public class CthuluBattle implements ExquisiteInterface
{
    private int good_big, bad_big;
    public CthuluBattlePanel panel;
    private CthuluBattleModel model;

    public CthuluBattle()
    {
        model = new CthuluBattleModel();
        panel = new CthuluBattlePanel(model);

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
        JOptionPane.showMessageDialog(null, "Kill Cthulu! (or cower for your life!)");

        model.start(good_big, bad_big);
        panel.update();
    }
}