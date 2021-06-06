package Minesweeper;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class GUI extends JFrame {

	public static boolean resetter = false;
	
	public static boolean flagger = false;
	
	static Date startDate = new Date();
	static Date endDate;
	
	public static int  scaping = 2;
	
	static int neighs = 0;
	
	public static int mx = -100;
	public static int my = -100;
	
	
	String vicMess = "Win!!";
	
	public static int smileX = 605;
	public static int smileY = 5;
	
	public static int smileCenter_X = smileX + 35;
	public static int smileCenter_Y = smileY + 35;
	
	public static int flaggerX = 445;
	public static int flaggerY = 5;
	
	public static int flaggerCenterX = flaggerX + 35;
	public static int flaggerCenterY = flaggerY + 35;
	
	public static int timeC_X = 1130;
	public static int timeC_Y = 5;
	
	public static int vicMes_X = 800;
	public static int vicMes_Y = -50;
	
	public int sec = 0;
	
	public static boolean happy = true;
	
	public static boolean Win = false;
	
	public static boolean Lose = false;
	
	
	
	static Random rand = new Random();
	
	static int [][] mines = new int[16][9]; 
	static int [][] neighbours = new int[16][9];
	static boolean[][] revealed = new boolean[16][9];
	static boolean[][] flagged = new boolean[16][9];
	

	
	
	
	public GUI() {
		this.setTitle("MineSweeper");
		this.setSize(1299,900);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(true);
		
		
		
		
		//count mines, touch mine
		for(int i = 0; i < 16; i++) {
			for(int j = 0; j < 9; j ++) {
				revealed[i][j] = false;
				if(rand.nextInt(144) < 20) {
					mines[i][j] = 1;
				}else 
					mines[i][j] = 0;
					
					
				
				
			}
		}
//count neighbours where to explore number.
		for(int i = 0; i < 16; i++) {
			for(int j = 0; j < 9; j ++) {
				neighs = 0;
				for(int m = 0; m < 16; m++) {
					for(int n = 0; n < 9; n ++) {
						if(!(m == i && n == j)) {
							if(Box.isN(i,j,m,n) == true)
								neighs ++ ;
						}
					}
				}
				
				neighbours[i][j] = neighs;
			}
		}
		
		Board board = new Board();
		this.setContentPane(board);
		
		Move move = new Move();
		this.addMouseMotionListener(move);
		
		Click click = new Click();
		this.addMouseListener(click);
	}
	
	
	public class Board extends JPanel{
		
		public void paintComponent(Graphics g) {
			g.setColor(Color.DARK_GRAY);
			g.fillRect(0,0, 1280,800);
			
			//SmileIcon painting
			
			g.setColor(Color.yellow);
			g.fillOval(smileX, smileY, 70, 70);
			g.setColor(Color.black);
			g.fillOval(smileX+15, smileY+20, 10, 10);
			g.setColor(Color.black);
			g.fillOval(smileX+45, smileY+20, 10, 10);
			if(happy == true) {
				g.fillRect(smileX+20, smileY+50, 30, 5);
				g.fillRect(smileX+15, smileY+45, 5, 5);
				g.fillRect(smileX+50, smileY+45, 5, 5);
			} else if(happy != true) {
				g.fillRect(smileX+20, smileY+45, 30, 5);
				g.fillRect(smileX+15, smileY+50, 5, 5);
				g.fillRect(smileX+50, smileY+50, 5, 5);
			}
			
			//Flagger paint
			
			g.setColor(Color.orange);
			g.fillRect(flaggerX + 32, flaggerY + 10, 5, 50);
			g.fillRect(flaggerX + 20, flaggerY +50 ,30, 10);
			g.setColor(Color.green);
			g.fillRect(flaggerX + 12, flaggerY + 15, 25, 15);
			g.setColor(Color.black);
			
			if(flagger == true) {
				g.setColor(Color.red);
			}
			
			g.drawOval(flaggerX, flaggerY, 70, 70);
			g.drawOval(flaggerX+1, flaggerY+1, 68, 68);
			g.drawOval(flaggerX+2, flaggerY+2, 66, 66);

			
			
			
			//Time counter paint
			
			g.setColor(Color.CYAN);
			g.fillRect(timeC_X, timeC_Y,110, 70);
			if(Lose == false && Win == false) {
				sec = (int) ((new Date().getTime() - startDate.getTime()) / 1000);
			}
			if(sec > 999) {
				sec = 999;
			}
			g.setColor(Color.BLACK);
			if(Win == true)
				g.setColor(Color.green);
			else if(Lose == true){
				g.setColor(Color.red);
			}
			
			g.setFont(new Font("Tahoma", Font.PLAIN, 60));
			if(sec < 10) {
				g.drawString("00"+Integer.toString(sec), timeC_X, timeC_Y + 55);
			}else if(sec<100) {
				g.drawString("0"+Integer.toString(sec), timeC_X, timeC_Y + 55);}
			else {
			g.drawString(Integer.toString(sec), timeC_X, timeC_Y + 55);
			}
			
			//Victory message painting
			
			if(Win == true ) {
				g.setColor(Color.GREEN);
				vicMess = "YOU WIN!!";
			}
			
			else if(Lose == true) {
				g.setColor(Color.red);
				vicMess = "YOU LOSE!!";
			}
			
			
			
			if(Win == true || Lose == true) {
				vicMes_Y = -50 + (int) (new Date().getTime() - endDate.getTime()) / 10;
				if(vicMes_Y> 67 ) {
					vicMes_Y = 67;
				}
				g.setFont(new Font("Tahoma", Font.PLAIN, 50));
				g.drawString(vicMess, vicMes_X, vicMes_Y);
			}
		
			
			
			for(int i = 0; i < 16; i++) {
				for(int j = 0; j < 9; j ++) {
					g.setColor(Color.gray);
					//know mines where they are.
//					if(mines[i][j] == 1) {
//						
//						g.setColor(Color.yellow);
//					}
					
					if(revealed[i][j] == true) {
						g.setColor(Color.white);
						
						if(mines[i][j] == 1) {
							g.setColor(Color.red);
						}
						
						
					}
					
					
				
					if(mx >= scaping+i*80 && mx < scaping+i*80 + 80-2*scaping && my >= scaping+j*80+80+26 && my < scaping+j*80+26+80+80-2*scaping) {
						g.setColor(Color.lightGray);
					}
					g.fillRect(scaping+i*80, scaping+j*80+80, 80-2*scaping, 80-2*scaping);
					if(revealed[i][j] == true) {
						//display number 
						g.setColor(Color.black);
						if(mines[i][j] == 0 && neighbours[i][j] != 0) {
							
							if(neighbours[i][j] == 1) 
								g.setColor(Color.blue);
							else if(neighbours[i][j] == 2) 
								g.setColor(Color.green);
							else if(neighbours[i][j] == 3) 
								g.setColor(Color.red);
							else if(neighbours[i][j] == 4) 
								g.setColor(new Color(0,0,128));
							else if(neighbours[i][j] == 5) 
								g.setColor(new Color(178,34,34));
							else if(neighbours[i][j] == 6) 
								g.setColor(new Color(72,209,204));
							else if(neighbours[i][j] == 7) 
								g.setColor(new Color(0,0,128));
							else if(neighbours[i][j] == 8) 
								g.setColor(Color.DARK_GRAY);
							
							g.setFont(new Font("Tahoma", Font.BOLD, 40));
							g.drawString(Integer.toString(neighbours[i][j]),i*80+27,j*80+80+55);}
						else if(mines[i][j] == 1) {
						//display mine
						g.fillRect(i*80+30,j*80+80+20,20,40);
						g.fillRect(i*80+20,j*80+80+30,40,20);
						g.fillRect(i*80+5+20,j*80+80+25,30,30);
						g.fillRect(i*80+38, j*80+80+15, 4, 50);
						g.fillRect(i*80+15, j*80+80+38, 50, 4);
						}
					}
					//paint flagged in cell
					if(flagged[i][j] == true) {
						g.setColor(Color.orange);
						g.fillRect(i*80 + 32, j*80+80 + 10, 5, 50);
						g.fillRect(i*80 + 20, j*80+80 +50 ,30, 10);
						g.setColor(Color.green);
						g.fillRect(i*80 + 12, j*80+80 + 15, 25, 15);
						g.setColor(Color.black);
					}
				}
			}
			
			
			
		}
	}
//Class Move 
	public class Move implements MouseMotionListener {

		
		@Override
		public void mouseDragged(MouseEvent e) {
			
			
		}
		@Override
		public void mouseMoved(MouseEvent e) {
			
			mx = e.getX();
			my = e.getY();
			
		}
}
// Class Click

	public class Click implements MouseListener{

		
		@Override
		public void mouseClicked(MouseEvent e) {
			
			mx = e.getX();
			my = e.getY();
			
			if(Box.BoxX() != -1 && Box.BoxY() != -1) {
				
				
				if(revealed[Box.BoxX()][Box.BoxY()] == true) {
					
					revealed[Box.BoxX()-1][Box.BoxY()] = Explore.openW();
					revealed[Box.BoxX()][Box.BoxY()-1] = Explore.openN();
					revealed[Box.BoxX()+1][Box.BoxY()] = Explore.openE();
					revealed[Box.BoxX()][Box.BoxY()+1] = Explore.openS();
					
					revealed[Box.BoxX()-1][Box.BoxY()-1] = Explore.openNW();
					revealed[Box.BoxX()+1][Box.BoxY()-1] = Explore.openNE();
					revealed[Box.BoxX()-1][Box.BoxY()+1] = Explore.openSW();
					revealed[Box.BoxX()+1][Box.BoxY()+1] = Explore.openSE();
				}
				
			}
			
			
			
			if(Box.BoxX() != -1 && Box.BoxY() != -1) {
				if(flagger == true && revealed[Box.BoxX()][Box.BoxY()] == false) {
					if(flagged[Box.BoxX()][Box.BoxY()] == false) {
					flagged[Box.BoxX()][Box.BoxY()] = true;}
					else 
						flagged[Box.BoxX()][Box.BoxY()] = false;
				} 
				else {
					if(flagged[Box.BoxX()][Box.BoxY()] == false) {
					revealed[Box.BoxX()][Box.BoxY()] = true;}
					}
			}
			
		
			
			if(Button.inSmile() == true) {
				ResetAll.resetAll();}
			
			if(Button.inFlagger() == true) {
				if(flagger == false) {
					flagger = true;
					}
					else 
					flagger = false;
				}
			
        }
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	
}



