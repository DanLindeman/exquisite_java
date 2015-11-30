/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fireslayer;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Ryan Solnik
 */
public class DragonGame implements ExquisiteInterface {

    int goodNum, badNum;
    forestFire panel;

    public DragonGame() {
        panel = new forestFire();
    }

    public void start(int good_big, int bad_big) {

        System.out.println(good_big);
        System.out.println(bad_big);

        goodNum = good_big;
        badNum = bad_big;

        if (badNum > 10) {
            badNum = (panel.size * panel.size) / 2;
        } else if (badNum < 10) {
            badNum = (panel.size * panel.size) / 4;
        }

        setFires(badNum, panel.tiles);
    }

    public JPanel get_Panel() {
        return panel;
    }

    public Integer get_good_integer() {
        return panel.goodNum;
    }

    public Integer get_bad_integer() {
        return panel.badNum;
    }

    private void setFires(int fires, JButton[][] tiles) {

        int numButtons = tiles.length;
        int maxFires = fires;

        for (int i = 0; i <= maxFires; i++) {
            double randRow = Math.floor(Math.random() * numButtons);
            double randCol = Math.floor(Math.random() * numButtons);

            if (tiles[(int) randRow][(int) randCol].getIcon().equals(panel.knight)) {

            } else if (tiles[(int) randRow][(int) randCol].getIcon().equals(panel.dagron)) {

            } else {
                tiles[(int) randRow][(int) randCol].setIcon(panel.fire);
            }
        }

    }
    
    
}
