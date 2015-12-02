import javax.swing.*;
import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CthuluBattlePanel extends JPanel
{
    private JPanel cthulu_field, actions_field;
    private JLabel cthulu_label;
    private JLabel cthulu_health_label;
    private JLabel player_health_label;
    private JButton punch, kick, cower;
    public JButton cthulu_battle_next_game;
    private CthuluBattleModel model;

    public CthuluBattlePanel(CthuluBattleModel aModel)
    {
        punch = new JButton("Punch");
        kick = new JButton("Kick");
        cower = new JButton("Cower");
        cthulu_battle_next_game = new JButton("Next Game");
        cthulu_battle_next_game.setEnabled(false);

        ImageIcon cthulu_icon = new ImageIcon("cthulu.jpg"); 
        cthulu_label = new JButton();
        cthulu_label.setIcon(cthulu_icon);
        // cthulu_label = new JLabel("ASDLKJSAD");

        cthulu_field = new JPanel();
        cthulu_field.add(cthulu_label);

        actions_field = new JPanel();
        actions_field.add(punch);
        actions_field.add(kick);
        actions_field.add(cower);
        actions_field.add(cthulu_battle_next_game);

        setLayout(new BorderLayout());
        add(cthulu_field, BorderLayout.CENTER);
        add(actions_field);
        model = aModel;


    }   
}
