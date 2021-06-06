package Minesweeper;

import java.util.Date;

public class ResetAll {
	


	public static void resetAll() {
		
		GUI.resetter = true;
		
		GUI.flagger = false;
		
		GUI.startDate = new Date();
		
		GUI.vicMes_Y = -50;
		
		String vicMess = "Win!!";
		
		GUI.happy = true;
		GUI.Win = false;
		GUI.Lose = false;
		
		//Mines
		for(int i = 0; i < 16; i++) {
			for(int j = 0; j < 9; j ++) {
				if(GUI.rand.nextInt(144) < 20) {
					GUI.mines[i][j] = 1;
				}else {
					GUI.mines[i][j] = 0;
				}
				GUI.revealed[i][j] = false;
				GUI.flagged[i][j] = false;
			}
		}
		//count neighbours where to explore number.
		for(int i = 0; i < 16; i++) {
			for(int j = 0; j < 9; j ++) {
				GUI.neighs = 0;
				for(int m = 0; m < 16; m++) {
					for(int n = 0; n < 9; n ++) {
						if(!(m == i && n == j)) {
							if(Box.isN(i,j,m,n) == true)
								GUI.neighs ++;
						}
					}
				}
				
				GUI.neighbours[i][j] = GUI.neighs;
			}
		}
		
		GUI.resetter = false;
	}
}
