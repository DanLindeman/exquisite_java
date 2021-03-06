// package fireslayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class forestFire extends JPanel {

    int row, col, size;
    int fires = 0;
    public int goodNum = 0;
    public int badNum = 0;
    
    JButton[][] tiles;
    JButton reset;
    public JButton next_game;
    JButton KnightStart, DragonStart;
    private JPanel center, buttons;

    ImageIcon knight, forest, dagron, fire;

    public forestFire() {

        size = 7;

        this.row = size;
        this.col = size;

        center = new JPanel();
        buttons = new JPanel();

        setLayout(new BorderLayout());
        add(center, BorderLayout.NORTH);
        add(buttons, BorderLayout.SOUTH);

        ButtonListener listener = new ButtonListener();

        center.setLayout(new GridLayout(row, col));
        buttons.setLayout(new GridLayout(1, 4));

        //creates the tiles array
        tiles = new JButton[row][col];

        //initializes icons
        knight = new ImageIcon("shovelKnight.jpg");
        forest = new ImageIcon("forest.jpg");
        dagron = new ImageIcon("dagron.jpg");
        fire = new ImageIcon("fire.jpg");

        //populate the buttons in the tiles
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[0].length; j++) {
                tiles[i][j] = new JButton("", forest);
                tiles[i][j].setEnabled(false);
                tiles[i][j].setPreferredSize(new Dimension(100, 100));
                center.add(tiles[i][j]);
                tiles[i][j].addActionListener(listener);
            }

        }

        //Knight start
        KnightStart = tiles[row / 2][0];
        KnightStart.setIcon(knight);

        //Dragon Start
        DragonStart = tiles[row / 2][col - 1];
        DragonStart.setIcon(dagron);

        //enables new steps
        enableSpaces(tiles, knight);

        //add player controls
        reset = new JButton("Reset");
        reset.addActionListener(listener);
        next_game = new JButton("Next Game");
        buttons.add(reset);
        buttons.add(next_game);
        next_game.setEnabled(false);
    }

    //turns squares to fire based on input
    private void setFires(int fires) {
        int numButtons = tiles.length;
        int maxFires = fires;

        for (int i = 0; i <= maxFires; i++) {
            double randRow = Math.floor(Math.random() * numButtons);
            double randCol = Math.floor(Math.random() * numButtons);

            tiles[(int) randRow][(int) randCol].setIcon(fire);
        }

    }

    private void getFires() {
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles.length; j++) {

                if (tiles[i][j].getIcon().equals(fire)) {
                    fires++;
                }

            }
        }
    }

    private void enableSpaces(JButton[][] grid, ImageIcon icon) {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j].getIcon().equals(icon)) {

                    grid[i][j].setEnabled(true);

                    if (i - 1 >= 0) {
                        grid[i - 1][j].setEnabled(true);
                    }
                    if (j - 1 >= 0) {
                        grid[i][j - 1].setEnabled(true);
                    }

                    if (j + 1 < grid.length) {
                        grid[i][j + 1].setEnabled(true);
                    }

                    if (i + 1 < grid.length) {
                        grid[i + 1][j].setEnabled(true);
                    }

                    if ((i - 1) >= 0 && (j + 1) < grid.length) {
                        grid[i - 1][j + 1].setEnabled(true);
                    }

                    if ((i - 1) >= 0 && (j - 1) >= 0) {
                        grid[i - 1][j - 1].setEnabled(true);
                    }

                    if ((i + 1) < grid.length && (j - 1) >= 0) {
                        grid[i + 1][j - 1].setEnabled(true);
                    }
                    if ((i + 1) < grid.length && (j + 1) < grid.length) {
                        grid[i + 1][j + 1].setEnabled(true);
                    }
                }

            }

        }
    }

    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {

            //reset tour
            if (event.getSource() == reset) {
                getFires();
                for (int i = 0; i < tiles.length; i++) {
                    for (int j = 0; j < tiles.length; j++) {
                        tiles[i][j].setIcon(forest);
                        tiles[i][j].setEnabled(false);

                    }
                }
                //resets fire cells
                setFires(fires);
                fires = 0;
                //sets knight and dragon
                tiles[row / 2][0].setIcon(knight);
                tiles[row / 2][col - 1].setIcon(dagron);

                enableSpaces(tiles, knight);
                goodNum = 0;

                //disables end
                next_game.setEnabled(false);

            } 

            //handles clicks
            else {

                if (event.getSource() == DragonStart) {

                    String victory = "You Win! \n" + "Steps Taken:" + goodNum;
                    JOptionPane.showMessageDialog(null, victory);
                    for (int i = 0; i < tiles.length; i++) {
                        for (int j = 0; j < tiles.length; j++) {

                            if (tiles[i][j].getIcon() == fire) {
                                badNum++;
                            }

                        }
                    }
                    next_game.setEnabled(true);
                } 
                
                else {
                    for (int i = 0; i < tiles.length; i++) 
                    {
                        for (int j = 0; j < tiles.length; j++) 
                        {

                            if (tiles[i][j].getIcon().equals(knight)) 
                            {
                                tiles[i][j].setIcon(fire);
                            }

                            if (tiles[i][j] == event.getSource()) 
                            {

                                if (tiles[i][j].getIcon().equals(fire)) 
                                {
                                    JOptionPane.showMessageDialog(null, "Ouch! Thats Hot!");
                                    goodNum = goodNum + 5;
                                }
                                tiles[i][j].setIcon(knight);
                                KnightStart = (JButton) event.getSource();
                                enableSpaces(tiles, knight);
                                goodNum++;
                            }
                        }
                    }
                }
            }
        }
    }
}
