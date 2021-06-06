package Minesweeper;

public class Button {
	
	public static boolean inFlagger() {
		int dif = (int) Math.sqrt(Math.abs(GUI.mx-GUI.flaggerCenterX)*Math.abs(GUI.mx-GUI.flaggerCenterX)+Math.abs(GUI.my-GUI.flaggerCenterY)*Math.abs(GUI.my-GUI.flaggerCenterY));
		if(dif < 35) {
			return true;
		}
		else if(dif >= 35) {
			return false;
		}
		return false;
	}
	
	public static boolean inSmile() {
		int dif = (int) Math.sqrt(Math.abs(GUI.mx-GUI.smileCenter_X)*Math.abs(GUI.mx-GUI.smileCenter_X)+Math.abs(GUI.my-GUI.smileCenter_Y)*Math.abs(GUI.my-GUI.smileCenter_Y));
		if(dif < 35) {
			return true;
		}
		else if(dif >= 35) {
			return false;
		}
		return false;
	}
	
	
	
}
