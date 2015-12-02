import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CthuluBattlePanel extends JPanel
{
    public JPanel cthulu_field, actions_field;
    private JButton cthulu_button;
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

        ImageIcon cthulu = new ImageIcon("cthulu.jpg"); 
        cthulu_button = new JButton();
        cthulu_button.setIcon(cthulu);

        cthulu_health_label = new JLabel("Cthulu's Health: ");
        player_health_label = new JLabel("Player Health: ");

        cthulu_field = new JPanel();
        cthulu_field.add(cthulu_health_label);
        cthulu_field.add(cthulu_button);


        actions_field = new JPanel();
        actions_field.add(player_health_label);
        actions_field.add(punch);
        actions_field.add(kick);
        actions_field.add(cower);
        actions_field.add(cthulu_battle_next_game);

        setLayout(new BorderLayout());
        add(cthulu_field, BorderLayout.NORTH);
        add(actions_field, BorderLayout.SOUTH);
        model = aModel;

        ButtonListener listener = new ButtonListener();
        punch.addActionListener(listener);
        kick.addActionListener(listener);
        cower.addActionListener(listener);
    }

    private class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            if (event.getSource() == punch)
            {
                model.punch();
                cthulu_button.setBackground(Color.RED);
                cthulu_button.setOpaque(true);
                update();
            }
            if (event.getSource() == kick)
            {
                model.kick();
                cthulu_button.setBackground(Color.RED);
                cthulu_button.setOpaque(true);
                update();
            }
            if (event.getSource() == cower)
            {
                model.cower();
                cthulu_button.setBackground(Color.GREEN);
                cthulu_button.setOpaque(true);
                update();
            }
        }
    }

    public void update()
    {
        int player_health = model.get_player_health();
        int cthulu_health = model.get_cthulu_health();
        player_health_label.setText("Player Health: " + player_health);
        cthulu_health_label.setText("Cthulu's Health: " + cthulu_health);
        if (cthulu_health < 0)
        {
            cthulu_health_label.setText("Cthulu's Health: DEAD");
            cthulu_battle_next_game.setEnabled(true);
            punch.setEnabled(false);
            kick.setEnabled(false);
            cower.setEnabled(false);
        }
        if (player_health < 0)
        {
            player_health_label.setText("Player Health: DEAD");
            cthulu_battle_next_game.setEnabled(true);
            punch.setEnabled(false);
            kick.setEnabled(false);
            cower.setEnabled(false);  
        }
    }
}









