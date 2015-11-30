import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game1 implements ExquisiteInterface
{
    private JPanel view, top, bottom;
    private int good_big, bad_big;
    private JButton ok_button;
    public JButton done;
    private JLabel bad_label, good_label;
    private boolean finished = false;


    public Game1()
    {
        // create_view();
    }

    private void create_view()
    {
        view = new JPanel();
        // view.setPreferredSize(new Dimension(800, 800));
        // view.setLayout(new BorderLayout());
        top = new JPanel();
        bottom = new JPanel();
        view.add(top, BorderLayout.CENTER);
        view.add(bottom, BorderLayout.SOUTH);

        ButtonHandler handler = new ButtonHandler();
        
        ok_button = new JButton("OK");
        top.add(ok_button);
        ok_button.addActionListener(handler);

        good_label = new JLabel(String.valueOf(good_big));
        top.add(good_label);
        bad_label = new JLabel(String.valueOf(bad_big));
        bottom.add(bad_label);
        done = new JButton("Done");
        bottom.add(done);
        done.setEnabled(false);
    }

    public void start(int good_big, int bad_big)
    {
        this.good_big = good_big;
        this.bad_big = bad_big;
        good_label.setText("" + good_big);
        bad_label.setText("" + bad_big);
        create_view();
    }

    public JPanel get_panel()
    {
        return view;
    }

    public Integer get_good_integer()
    {
        return good_big;
    }

    public Integer get_bad_integer()
    {
        return bad_big;
    }


    public boolean is_finished()
    {
        return finished;
    }

    public void set_finished()
    {
        finished = true;
    }

    private class ButtonHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            if (event.getSource() == ok_button)
            {
                System.out.println("OK button pressed!");
                done.setEnabled(true);
            
            }
        }
    }

}   