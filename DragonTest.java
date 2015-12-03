/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.JButton;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import junit.framework.TestCase;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 *
 * @author Destoyer
 */
public class DragonTest {
    
    public DragonTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    //knight is in correct position
    @Test
    public void KnightSetUpCorrectly(){
        
        DragonGame test = new DragonGame();
        assertEquals("Knight starts at [3][0]", test.panel.knight ,test.panel.KnightStart.getIcon());
        
    }
    
    
    //dragon is in correct position
    @Test
    public void DragonSetUpCorrectly(){
        
        DragonGame test = new DragonGame();
        assertEquals("Knight starts at [3][0]", test.panel.dagron ,test.panel.DragonStart.getIcon());
        
        
    }
    
    //size of board is set correctly
    
    @Test
    public void GameSize(){
        DragonGame test = new DragonGame();
        
        int numSquares = 49;
        int totalSquares = test.panel.size * test.panel.size;
        assertEquals("size of board is 7 x 7" , numSquares,totalSquares);
        
    }
    
    
    //fails if a vertical wall of fire tiles is found
    @Test
    public void fireWallTest(){
        DragonGame test = new DragonGame();
        test.setFires(40, test.panel.tiles);
        
        Integer fires = 0;
        Integer fireWall = test.panel.size;
        JButton[][] tile = test.panel.tiles;
        
        
        
            for(int j = 0; j < tile.length; j++){
                
            
                for(int k = 0; k < tile.length; k++){
                    
                    if(test.panel.tiles[k][j].getIcon().equals(test.panel.fire)){
                        fires++;
                    }
                
                }
                               
                assertFalse("there is a wall of fires",fireWall.equals(fires));
                fires =0;
            }
        
        
    }
    
    
    //makes sure that fire tiles are set
    @Test
    public void firesSet(){
        DragonGame test = new DragonGame();
        test.setFires(10, test.panel.tiles);
        
        JButton[][] tile = test.panel.tiles;
        Integer fire = 0;
         for(int j = 0; j < tile.length; j++){
                
            for(int k = 0; k < tile.length; k++){
                    
                    if(tile[j][k].getIcon().equals(test.panel.fire)){
                        fire++;
                    }
                    
                }
         }
         boolean fireCheck  = fire >= 0;
         
         assertTrue("There ain't no fires", fireCheck);
    
    }
    
    @Test
    public void setEnable(){
        DragonGame test = new DragonGame();
        forestFire panel = test.panel;
        
        panel.enableSpaces(panel.tiles, panel.knight);
        
        
        assertTrue("the Space isn't enabled", panel.KnightStart.isEnabled());
        
        
    }
    
}
