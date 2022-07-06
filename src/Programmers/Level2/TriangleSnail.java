package Programmers.Level2;

public class TriangleSnail {
	public static int[] solution(int n) {
		int[] answer = new int[n*(n+1)/2];
		int count = 0;
		int[][] arr = new int[n][n];

		int x = 0;
		int y = 0;
		int num = 0;
		int check = n;
		for(int i = 1; i <= n; i++) {
			switch (i%3) {
			case 0: { // 대각선 올라갈 때
				count = 0;
				while(count < check) {
					arr[y--][x--] = ++num;
					count++;
				}
				check--;
				y+=2;
				x++;
				break;
			}
			case 1: { // 내려올때
				count = 0;
				while(count < check) {
					arr[y++][x] = ++num;
					count++;
				}
				check--;
				x++;
				break;
			}
			case 2: { // 오른쪽으로 갈 때
				count = 0;
				y--;
				while(count < check) {
					arr[y][x++] = ++num;
					count++;
				}
				check--;
				y--;
				x-=2;
				break;
			}
			}
		}

		num = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j <= i ; j++) {
				answer[num++] = arr[i][j];
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		int n = 6;
		int[] result = solution(n);
		for(int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}


	/*
	 * n	result
		4	[1,2,9,3,10,8,4,5,6,7]
		5	[1,2,12,3,13,11,4,14,15,10,5,6,7,8,9]
		6	[1,2,15,3,16,14,4,17,21,13,5,18,19,20,12,6,7,8,9,10,11]

		1
	  	2 9
	 	3 10 8
	 	4 5 6 7
	 */





	//	public static int[] solution(int n) {
	//		String[] snail = new String[n];
	//		int last = n*(n+1)/2;
	//		int num = 1;
	//		int count = 0;
	//		int index=0;
	//		System.out.println(last);
	//		outer : while ( num <= last) {
	//			for(int i = count; i < n; i++) {
	//				System.out.println("count : " + count); 
	//				if(num>last) break outer;
	//				if(snail[i]==null) {
	//					snail[i] =  num+",";
	//				}else {
	//					index = snail[i].indexOf(",", index);
	//					snail[i] = snail[i].substring(0,index+1)+ "," +num + "," + snail[i].substring(index) + ",";
	//					System.out.println("index : " + index);
	//					//snail[i] = snail[i]==null ? num+"," : snail[i].substring(0,count-1)+ "," +num + "," + snail[i].substring(count-1) + ",";
	//				}
	//				num++;
	//				System.out.println(snail[i] + " num : " + num);
	//				System.out.println("여기여기 :" + i );
	//				if(count==0 && i+1 == n ){
	//					System.out.println("들어옴");
	//					for(int j = 0; j < n-count-1; j++) {
	//						System.out.println("dd1 :" + num);
	//						if(num>last) break outer;
	//						snail[i]+=num+ ",";
	//						System.out.println(snail[i] + " num : " + num);
	//						num++;
	//					}
	//					System.out.println("나감");
	//				}else if(count!=0 && i+1 == n-count+1) {
	//					int start = count;
	//					for(int j = 0; j < n-count-1; j++) {
	//						System.out.println("dd2 :" + num);
	//						if(num>last) break outer;
	//						index = snail[i].indexOf(",", index);
	//						System.out.println("index : " + index);
	//						snail[i] = snail[i].substring(0,index+1)+ "," +num + "," + snail[i].substring(index) + ",";
	//						//snail[i] = snail[i].substring(0,start-1)+ "," +num + "," + snail[i].substring(start-1) + ",";
	//						System.out.println(snail[i] + " num : " + num);
	//						
	//						num++;
	//					}
	//					System.out.println("나감");
	//				}
	//
	//			}
	//			count++;
	//			for(int i = (n-count-1); i > count-1; i--) {
	//				if(num>last) break outer;
	//				snail[i] += num + ",";
	//				num++;
	//				System.out.println(snail[i] + " num : " + num);
	//			}
	//			count++;
	//		}
	//
	//		int[] answer = new int[num - 1];
	//		count = 0;
	//		for(int i = 0; i < n; i++) {
	//			snail[i]=snail[i].replace(",,", ",");
	//
	//			String[] res = snail[i].split(",");
	//
	//			for(int j = 0; j < res.length; j++) {
	//
	//				answer[count] = Integer.parseInt(res[j]);
	//
	//			}
	//
	//		}
	//		return answer;
	//	}

}
