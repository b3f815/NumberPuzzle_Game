import java.awt.*;

class CustomNumberPuzzleControl extends NumberPuzzleControl {
	public int getWidth() {
		return 200;
	}
	public int getHeight() {
		return 250;
	}
	public int getXPosition() {
		return 200;
	}
	public int getYPosition() {
		return 200;
	}
	public String getTitle(){
		return "Number Puzzle";
	}
	public int getShuffleButtonFontSize() {
		return 12;
	}
	public int getNumbersFontSize() {
		return 12;
	}
	public Color getEmptyButtonColor() {
		return Color.WHITE;
	}
	public String getWinnerMessage() {
		return "Congrats, you have won!";
	}

	// The following three methods have to be written by the participants...

	public int handleButtonClicked(NumberPuzzleGame game){
		int emptyCellId = game.getEmptyCellId();
		Button buttonClicked = game.getButtonClicked();
		Button[] buttons = game.getButtons();
		
		//Your logic here		
		
		return emptyCellId;

	}
	public int[] getRandomNumbersForGrid() {
		int arr[] = new int[15];
		int i;
		for (i  = 0;i < 15;i++) {
			arr[i] = -1; //flagging all location with -1
		}
		int flag;
		//Your logic here
		
		int a = getRandomNumber();
		for (i = 1;i <= 15;i++) {//i will be inserted in the array
			a = getRandomNumber();
			a = a%15;  //a is the random position to insert the i into
			flag = 1;
			while(flag == 0) { //while loop is exited only after a random,previously unfilled position is filled.
				if (arr[a] == -1) {//already filled spaces are not re- filled
					arr[a] = i;
					flag = 1;  
				}
				else {
					a = getRandomNumber();
					a = a%15;
				}
			}
		}
		
		
		return arr;
	}
	public boolean checkForWinner(Button[] buttons)
	{
		boolean winner = true;
		
		// Your Logic here
		getIntegerArrayOfButtonIds(buttons);

		return winner;
	}
}