import javax.swing.*;
import java.awt.*;

public class ExquisiteGameRunner
{
    public ExquisiteGameRunner()
    {

    }

    public static void main(String[] args)
    {
        System.out.println("Hello!");
        View view = new View();
        JFrame frame = new JFrame("Exquisite Game");
        frame.getContentPane().add(view);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}