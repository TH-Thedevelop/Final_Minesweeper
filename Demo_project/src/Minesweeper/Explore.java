package Minesweeper;

public class Explore {

	public static int checkMinesW() {
		if(GUI.mines[Box.BoxX()-1][Box.BoxY()] == 1 && GUI.revealed[Box.BoxX()-1][Box.BoxY()] == false)
			return 1;
		else if(GUI.mines[Box.BoxX()-1][Box.BoxY()] == 0)
			return 0;
		return -1;
	}
	public static int checkMinesN() {
		if(GUI.mines[Box.BoxX()][Box.BoxY()-1] == 1 && GUI.revealed[Box.BoxX()][Box.BoxY()-1] == false)
			return 1;
		else if(GUI.mines[Box.BoxX()][Box.BoxY()-1] == 0)
			return 0;
		return -1;
	}
	public static int checkMinesE() {
		if(GUI.mines[Box.BoxX()+1][Box.BoxY()] == 1 && GUI.revealed[Box.BoxX()+1][Box.BoxY()] == false)
			return 1;
		else if(GUI.mines[Box.BoxX()+1][Box.BoxY()]  == 0)
			return 0;
		return -1;
	}
	public static int checkMinesS() {
		if(GUI.mines[Box.BoxX()][Box.BoxY()+1] == 1 && GUI.revealed[Box.BoxX()][Box.BoxY()+1] == false)
			return 1;
		else if(GUI.mines[Box.BoxX()][Box.BoxY()+1]== 0 )
			return 0;
		return -1;
	}
	//
	public static int checkMinesNE() {
		if(GUI.mines[Box.BoxX()+1][Box.BoxY()-1] == 1 && GUI.revealed[Box.BoxX()+1][Box.BoxY()-1] == false)
			return 1;
		else if(GUI.mines[Box.BoxX()+1][Box.BoxY()-1] == 0)
			return 0;
		return -1;
	}
	public static int checkMinesNW() {
		if(GUI.mines[Box.BoxX()-1][Box.BoxY()-1] == 1 && GUI.revealed[Box.BoxX()-1][Box.BoxY()-1] == false)
			return 1;
		else if(GUI.mines[Box.BoxX()-1][Box.BoxY()-1] == 0)
			return 0;
		return -1;
	}
	public static int checkMinesSE() {
		if(GUI.mines[Box.BoxX()+1][Box.BoxY()+1] == 1 && GUI.revealed[Box.BoxX()+1][Box.BoxY()+1] == false)
			return 1;
		else if(GUI.mines[Box.BoxX()+1][Box.BoxY()+1] == 0)
			return 0;
		return -1;
	}
	public static int checkMinesSW() {
		if(GUI.mines[Box.BoxX()-1][Box.BoxY()+1] == 1 && GUI.revealed[Box.BoxX()-1][Box.BoxY()+1] == false)
			return 1;
		else if(GUI.mines[Box.BoxX()-1][Box.BoxY()+1] == 0)
			return 0;
		return -1;
	}
//////////////////////////////////////////////////////////////
	//Open cell East,West,North,South.
	public static boolean openW() {
		if(checkMinesW() == 1 ) {
			return false;
		}else
			return true;
	}
	
	public static boolean openN() {
		if(checkMinesN() == 1) {
			return false;
		}else
			return true;
	}
	
	public static boolean openE() {
		if(checkMinesE() == 1) {
			return false;
		}else
			return true;
	}
	
	public static boolean openS() {
		if(checkMinesS() == 1) {
			return false;
		}else
			return true;
	}
	
	public static boolean openNW() {
		if(checkMinesNW() == 1) {
			return false;
		}else
			return true;
	}
	public static boolean openNE() {
		if(checkMinesNE() == 1) {
			return false;
		}else
			return true;
	}
	public static boolean openSW() {
		if(checkMinesSW() == 1) {
			return false;
		}else
			return true;
	}
	public static boolean openSE() {
		if(checkMinesSE() == 1) {
			return false;
		}else
			return true;
	}
}
