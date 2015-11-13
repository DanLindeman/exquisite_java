import javax.swing.*;
import java.awt.*;

public class View extends JPanel
{
    private JPanel window;
    private JButton start_button;

    public View()
    {
        window = new JPanel();
        setPreferredSize(new Dimension(800, 800));
        setLayout(new BorderLayout());
        add(window, BorderLayout.CENTER);


        start_button = new JButton("Start");
        window.add(start_button);
    }

}