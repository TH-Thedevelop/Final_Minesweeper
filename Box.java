package Minesweeper;

public class Box {

	
	public static int BoxX() {
		for(int i = 0; i < 16; i++) {
			for(int j = 0; j < 9; j ++) {
				
				if(GUI.mx >= GUI.scaping +i*80 && GUI.mx < GUI.scaping+i*80 + 80-2* GUI.scaping && GUI.my 
						>= GUI.scaping+j*80+80+26 && GUI.my < GUI.scaping+j*80+26+80+80-2*GUI.scaping) {
					return i;
				}
				
			}
		}
		return -1;
	}
	
	public static int BoxY() {
		for(int i = 0; i < 16; i++) {
			for(int j = 0; j < 9; j ++) {
				
				if(GUI.mx >= GUI.scaping+i*80 && GUI.mx < GUI.scaping+i*80 + 80-2*GUI.scaping && GUI.my 
						>= GUI.scaping+j*80+80+26 && GUI.my < GUI.scaping+j*80+26+80+80-2*GUI.scaping) {
					return j;
				}
				
			}
		}
		return -1;
	}
	
	public static boolean isN(int mX, int mY, int cX, int cY){
		if(mX - cX <2 && mX - cX > -2 && mY - cY <2 && mY - cY > -2 && GUI.mines[cX][cY] == 1) {
			return true;
		}
		return false;
	}

}
