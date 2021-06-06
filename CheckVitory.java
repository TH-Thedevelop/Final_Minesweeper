package Minesweeper;

import java.util.Date;

public class CheckVitory {

	//Check condition of win or lose	
		public static void checkWinStatus() {
			if(GUI.Lose == false ) {
				for(int i = 0; i < 16; i++) {
					for(int j = 0; j < 9; j ++) {
						
						if(GUI.revealed[i][j] == true && GUI.mines[i][j] == 1) {
							GUI.Lose = true;
							GUI.happy = false;
							
							GUI.endDate = new Date();
							
							for(int k = 0; k < 16; k++) {
								for(int l = 0; l < 9; l ++) {
									if(GUI.flagged[k][l] == false) {
										GUI.revealed[k][l] = true;}
									}
								}
							
						}
						
					}
				}
				
			}	
				if ((totalBoxRevealed()) >= 144 - totalMines() && GUI.Win == false && GUI.Lose == false) {
					GUI.Win = true;
					GUI.endDate = new Date();
				}
			}
	//Total of mines	
		public static int totalMines() {
			int total = 0;
			for(int i = 0; i < 16; i++) {
				for(int j = 0; j < 9; j ++) {
					if(GUI.mines[i][j] == 1) {
						total ++;
					}
				}
			}
			return total;
		}
	//total Box revealed	
		public static int totalBoxRevealed() {
			int total = 0;
			for(int i = 0; i < 16; i++) {
				for(int j = 0; j < 9; j ++) {
					if(GUI.revealed[i][j] == true) {
						total++;
					}
				}
			}
			return total;
		}
}
