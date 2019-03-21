package wuziqi;

import java.util.Scanner;

public class WuZiQi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		char[][] QiPan = new char[19][19];
		WuZiQiMethod wzq = new WuZiQiMethod();
		for(int i=0; i<19; i++){
			for(int j=0; j<19; j++){
				QiPan[i][j] = '·';
			}
		}
		System.out.println("Please choose the player who moves first(1:●,2:○): ");
		int firstMovePlayer = input.nextInt();
		
		wzq.showQiPan(QiPan);
		wzq.move(firstMovePlayer, QiPan);

	}

}
