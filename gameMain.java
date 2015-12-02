// package fireslayer;

// file: gameMain.java


import javax.swing.*;

class gameMain {
	
	public static void main (String[] args) 
      {
		
            //input of two integers from game runner.
            int goodNum = 100;
            int badNum = 1000;
            
            //remove constructor arguments
            DragonGame game = new DragonGame();
            
            JFrame frame = new JFrame("Dragon Game");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            frame.getContentPane().add(game.panel);
            game.start(0, 10);
            frame.pack();
            frame.setVisible(true);
                
	}

}