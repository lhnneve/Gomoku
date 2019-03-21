package wuziqi;

import java.util.Scanner;

public class WuZiQiMethod {
	Scanner input = new Scanner(System.in);
	//显示棋盘
	public void showQiPan(char[][] qipan){
		for(int i=0; i<19; i++){
			for(int j=0; j<19; j++){
				System.out.print(qipan[i][j]+" ");
			}
			System.out.println();
		}
	}
	//判断所选位置是否允许落子
	public boolean isVital(char[][] qipan, int r,int c){
		if(r>=0 && r<19 && c>=0 && c<19){
			if(qipan[r][c]=='·'){
				return true;
			}
			else
				return false;
		}
		else{
			return false;
		}
	}
	//换手
	public int changePlayer(int playerNow){
		if(playerNow==1){
			return 2;
		}
		else{
			return 1;
		}
		
	}
	//判断是否有人胜出
	public boolean isWinner(char[][] qipan, int r,int c,int playerNow){
//		//横向五子连珠，不考虑边界，同时考虑黑子或者白子，有五种可能
//		//四个方向最外层和第二层循环相同都可以合并，待续
		char ch = playerNow==1?'●':'○';
//		for(int i=0; i<5; i++){
//			int countFive = 0;
//			for(int j=0; j<5; j++){
//				if(qipan[r][c-4+j+i]==ch)
//					countFive++;
//			}
//			if(countFive == 5){
//				return true;
//			}
//		}
//		//竖向...
//		for(int i=0; i<5; i++){
//			int countFive = 0;
//			for(int j=0; j<5; j++){
//				if(qipan[r-4+j+i][c]==ch)
//					countFive++;
//			}
//			if(countFive == 5){
//				return true;
//			}
//		}
//		//斜向左上或右下...
//		for(int i=0; i<5; i++){
//			int countFive = 0;
//			for(int j=0; j<5; j++){
//				if(qipan[r-4+j+i][c-4+j+i]==ch)
//					countFive++;
//			}
//			if(countFive == 5){
//				return true;
//			}
//		}
//		//斜向右上或坐下...
//		for(int i=0; i<5; i++){
//			int countFive = 0;
//			for(int j=0; j<5; j++){
//				if(qipan[r+4-j-i][c-4+j+i]==ch)
//					countFive++;
//			}
//			if(countFive == 5){
//				return true;
//			}
//		}

		//下面的方法将棋盘的大小考虑进去了
		int[] countFive = new int[4];
		for(int i=1; i<5; i++){
			if(c-i>=0 && qipan[r][c-i] == ch){
				countFive[0]++;
			}else{
				break;
			}
		}
		for(int i=1; i<5; i++){
			if(c+i<qipan.length && qipan[r][c+i] == ch){
				countFive[0]++;
			}else{
				break;
			}
		}
		for(int i=1; i<5; i++){
			if(r-i>=0 && qipan[r-i][c] == ch){
				countFive[1]++;
			}else{
				break;
			}
		}
		for(int i=1; i<5; i++){
			if(c+i<qipan.length && qipan[r+i][c] == ch){
				countFive[1]++;
			}else{
				break;
			}
		}
		for(int i=1; i<5; i++){
			if(r-i>=0 && c-i>=0 && qipan[r-i][c-i] == ch){
				countFive[2]++;
			}else{
				break;
			}
		}
		for(int i=1; i<5; i++){
			if(r+i<qipan.length && c+i<qipan.length && qipan[r+i][c+i] == ch){
				countFive[2]++;
			}else{
				break;
			}
		}
		for(int i=1; i<5; i++){
			if(r+i<qipan.length && c-i>=0 && qipan[r+i][c-i] == ch){
				countFive[3]++;
			}else{
				break;
			}
		}
		for(int i=1; i<5; i++){
			if(r-i>=0 && c+i<qipan.length && qipan[r-i][c+i] == ch){
				countFive[3]++;
			}else{
				break;
			}
		}
		for(int i=0; i<4; i++){
			if(countFive[i] >= 4){
				return true;
			}
		}
		return false;
	}
	//双方落子
	public void move(int fmplayer, char[][] qipan){
		int playerNow = changePlayer(fmplayer);
		while(true){
			System.out.println("Now turns to player "+changePlayer(playerNow));
			System.out.println("Please enter the row and column: ");
			int r = input.nextInt();
			int c = input.nextInt();
			if(isVital(qipan,r,c)){
				playerNow = changePlayer(playerNow);
				if(playerNow==1)
					qipan[r][c] = '●';
				else
					qipan[r][c] = '○';
			}
			else{
				System.out.println("Input illegle!Please reset!");
				changePlayer(playerNow);
				continue;
			}
			showQiPan(qipan);
			if(isWinner(qipan,r,c,playerNow)){
				System.out.println("The winner is player"+playerNow+"! Game Over!");
				break;
			}
		}
	}
}
