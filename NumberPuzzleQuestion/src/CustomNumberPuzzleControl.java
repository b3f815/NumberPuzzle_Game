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
		
		switch(emptyCellId) {
		case 0:if(buttonClicked == buttons[emptyCellId + 1]) {
			swapButton(buttons[emptyCellId],buttonClicked);
			emptyCellId = emptyCellId + 1;
			break;
		}
		if(buttonClicked == buttons[emptyCellId + 4]) {
			swapButton(buttons[emptyCellId],buttonClicked);
			emptyCellId = emptyCellId + 4;
			break;
		}
		case 1:
		case 2:if(buttonClicked == buttons[emptyCellId + 1]) {
			swapButton(buttons[emptyCellId],buttonClicked);
			emptyCellId = emptyCellId + 1;
			break;
		}if(buttonClicked == buttons[emptyCellId - 1]) {
			swapButton(buttons[emptyCellId],buttonClicked);
			emptyCellId = emptyCellId - 1;
			break;
		}if(buttonClicked == buttons[emptyCellId + 4]) {
			swapButton(buttons[emptyCellId],buttonClicked);
			emptyCellId = emptyCellId + 4;
			break;
		}
		
		case 3:if(buttonClicked == buttons[emptyCellId - 1]) {
			swapButton(buttons[emptyCellId],buttonClicked);
			emptyCellId = emptyCellId - 1;
			break;
		}if(buttonClicked == buttons[emptyCellId + 4]) {
			swapButton(buttons[emptyCellId],buttonClicked);
			emptyCellId = emptyCellId + 4;
			break;
		}
		case 4:
		case 8:if(buttonClicked == buttons[emptyCellId + 1]) {
			swapButton(buttons[emptyCellId],buttonClicked);
			emptyCellId = emptyCellId + 1;
			break;}
			if(buttonClicked == buttons[emptyCellId + 4]) {
				swapButton(buttons[emptyCellId],buttonClicked);
				emptyCellId = emptyCellId + 4;
				break;
			}
			if(buttonClicked == buttons[emptyCellId - 1]) {
				swapButton(buttons[emptyCellId],buttonClicked);
				emptyCellId = emptyCellId - 1;
				break;}
		case 5:
		case 6:
		case 9:
		case 10:if(buttonClicked == buttons[emptyCellId + 1]) {
			swapButton(buttons[emptyCellId],buttonClicked);
			emptyCellId = emptyCellId + 1;
			break;}
			if(buttonClicked == buttons[emptyCellId + 4]) {
				swapButton(buttons[emptyCellId],buttonClicked);
				emptyCellId = emptyCellId + 4;
				break;
			}
			if(buttonClicked == buttons[emptyCellId - 1]) {
				swapButton(buttons[emptyCellId],buttonClicked);
				emptyCellId = emptyCellId - 1;
				break;}
			if(buttonClicked == buttons[emptyCellId - 4]) {
					swapButton(buttons[emptyCellId],buttonClicked);
					emptyCellId = emptyCellId - 4;
					break;
				}
		
		case 7:
		case 11:
			if(buttonClicked == buttons[emptyCellId + 4]) {
				swapButton(buttons[emptyCellId],buttonClicked);
				emptyCellId = emptyCellId + 4;
				break;
			}
			if(buttonClicked == buttons[emptyCellId - 1]) {
				swapButton(buttons[emptyCellId],buttonClicked);
				emptyCellId = emptyCellId - 1;
				break;}
			if(buttonClicked == buttons[emptyCellId - 4]) {
					swapButton(buttons[emptyCellId],buttonClicked);
					emptyCellId = emptyCellId - 4;
					break;
				}
		
		
		
		
		case 12:if(buttonClicked == buttons[emptyCellId + 1]) {
			swapButton(buttons[emptyCellId],buttonClicked);
			emptyCellId = emptyCellId + 1;
			break;
		}
			
			if(buttonClicked == buttons[emptyCellId - 4]) {
					swapButton(buttons[emptyCellId],buttonClicked);
					emptyCellId = emptyCellId - 4;
					break;
				}
		case 13: 
		case 14:if(buttonClicked == buttons[emptyCellId + 1]) {
			swapButton(buttons[emptyCellId],buttonClicked);
			emptyCellId = emptyCellId + 1;
			break;}
			if(buttonClicked == buttons[emptyCellId - 1]) {
				swapButton(buttons[emptyCellId],buttonClicked);
				emptyCellId = emptyCellId - 1;
				break;}
			if(buttonClicked == buttons[emptyCellId - 4]) {
				swapButton(buttons[emptyCellId],buttonClicked);
				emptyCellId = emptyCellId - 4;
				break;}
		case 15:
			
			if(buttonClicked == buttons[emptyCellId - 1]) {
				swapButton(buttons[emptyCellId],buttonClicked);
				emptyCellId = emptyCellId - 1;
				break;}
			if(buttonClicked == buttons[emptyCellId - 4]) {
					swapButton(buttons[emptyCellId],buttonClicked);
					emptyCellId = emptyCellId - 4;
					break;
				}
		}
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
		int[] arr = getIntegerArrayOfButtonIds(buttons);
		
		for(int i =1;i <=15;i++) {
			if(arr[i] != i) {
				return false;
			}
		}

		return winner;
	}
}