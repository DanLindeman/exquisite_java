import javax.swing.*;
import java.awt.*;

public class View extends JPanel
{
    private JPanel window;
    private JButton start_button;

    public View()
    {
        // Game current_game = new Game();
        window = new JPanel();
        setPreferredSize(new Dimension(800, 800));
        setLayout(new BorderLayout());
        add(window, BorderLayout.CENTER);
        // ArrayList<> gui_array = current_game.get_gui_elements();
    }

}