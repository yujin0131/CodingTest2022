package Programmers.Level2;

import java.util.ArrayList;
import java.util.Collections;

//https://school.programmers.co.kr/learn/courses/30/lessons/86052

public class LightPathCycle {

	boolean[][][] lightVisit;
	int rowLength;
	int colLength;
	ArrayList<Integer> answer;
	
	public int[] solution(String[] grid) {
		makeLight(grid);
		Collections.sort(answer);
		return answer.stream().mapToInt(i -> i).toArray();
	}

	public void makeLight(String[] grid) {
		rowLength = grid.length;
		colLength = grid[0].length();
		lightVisit = new boolean[rowLength][colLength][4];
		answer = new ArrayList<Integer>();
		
		for(int row = 0; row < rowLength; row++) {		
			for(int col = 0; col < colLength; col++) {
				for(int direct = 0; direct < 4; direct++) {
					if(!lightVisit[row][col][direct]) {
						answer.add(arrivalCheck(grid, row, col, direct));
			
					}
				}
			}
		}
	}
	
	public int arrivalCheck(String[] grid, int row, int col, int direct) {
		int[] dx = {1,0,-1,0};
 		int[] dy = {0,-1,0,1};
 		int firstDirect = direct;
 		int firstRow = row;
 		int firstCol = col;
 		int count = 0;
		while(!lightVisit[firstRow][firstCol][firstDirect]) {
			
			char nextWay = grid[row].charAt(col);
			switch (nextWay) {
			case 'L': {
				direct = left(direct);
				System.out.println("LEFT " + dx[direct] + " " + dy[direct]);
				break;
			}
			case 'R': {
				direct = right(direct);
				System.out.println("RIGHT "+ dx[direct] + " " + dy[direct]);
				break;
			}
			}
			count++;
			col+=dx[direct];
			row+=dy[direct];
			if(col==colLength || col < 0) {
				col = col < 0 ? colLength-1 : 0;
			}else if (row==rowLength || row < 0) {
				row = row < 0 ?  rowLength-1 : 0;
			}
			System.out.println("direct : " + direct + " " +row + " " + col );
			lightVisit[row][col][direct] = true;
		}
		return count;
	}

	public int left(int direct) {
		return direct = (direct + 3) % 4;
	}
	
	public int right(int direct) {
		return direct = (direct + 1) % 4;
	}
	

//	public int[] arrivalCheck() {
//		List<Integer> list = new ArrayList<>();
//		// → ↓ ← ↑ 
//		// 0 1 2 3
//		int[] firstdx = {1,0,-1,0};
//		int[] firstdy = {0,-1,0,1};
//		int dxyCheck = 0;
//		int trueCheck = rowLength * colLength * 4;
//		System.out.println(trueCheck);
//		while(true) {
//			
//			System.out.println("dddddddddddddddddddddddd");
//			int count = 0;
//			while(true) {
//
//				if(dx == 1) {
//					lightCheck[y][x][0] = true;
//					trueCheck--;
//				}
//				else if(dy == -1) {
//					lightCheck[y][x][1] = true;
//					trueCheck--;
//				}
//				else if(dx == -1) {
//					lightCheck[y][x][2] = true;
//					trueCheck--;
//				}
//				else if(dy == 1) {
//					lightCheck[y][x][3] = true;
//					trueCheck--;
//				}
//				System.out.println("===================================");
//
//				for(int i = 0; i < light.length; i ++) {
//					for(int j = 0; j < light[0].length; j++) {
//						for(int k = 0; k < 4; k++) {
//
//							System.out.print(lightCheck[i][j][k] + " ");
//						}
//						System.out.print(" / ");
//					}
//					System.out.println();
//				}
//				System.out.println("\n===================================");
//
//				System.out.println(x + " " + y +" " + dx + " " + dy + " " + light[y][x]);
//				String nextWay = light[y][x];
//				switch (nextWay) {
//				case "L": {
//					left();
//					System.out.println("LEFT " + dx + " " + dy);
//					break;
//				}
//				case "R": {
//					right();
//					System.out.println("RIGHT "+ dx + " " + dy);
//					break;
//				}
//				}
//				x += dx;
//				y += dy;
//				count++;
//				if(x==colLength || x < 0) {
//					x = x < 0 ? colLength-1 : 0;
//				}else if (y==rowLength || y < 0) {
//					y = y < 0 ?  rowLength-1 : 0;
//				}
//				if(0 == x && 0 ==y && firstdx[dxyCheck] == dx && firstdy[dxyCheck] == dy) break;
//			}
//
//			break;
//
//		}
//		int[] arr = list.stream().mapToInt(i->i).toArray();
//
//		return arr;
//	}
//
//	public void left() {
//		if(dx == 0) {
//			dx = dy == 1 ? -1 : 1;
//			dy = 0;
//		}else {
//			dy = dx == 1 ? 1 : -1;
//			dx = 0;
//		}
//	}
//
//	public void right() {
//		if(dx == 0) {
//			dx = dy == 1 ? 1 : -1;
//			dy = 0;
//		}else {
//			dy = dx == 1 ? -1 : 1;
//			dx = 0;
//		}
//	}

	public static void main(String[] args) {
		String[] grid = {"R" + "R"};
		LightPathCycle cycle = new LightPathCycle();
		int[] result = cycle.solution(grid);

		System.out.println();
		for(int i = 0; i < result.length; i++) {

			System.out.print(result[i] + " ");
		}
	}

}
