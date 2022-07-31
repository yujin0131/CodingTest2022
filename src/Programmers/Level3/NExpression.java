package Programmers.Level3;


public class NExpression {

	public static int solution(int N, int number) {
		int answer = 0;
		
		int num = 1;
		Operation(N, num);
		return answer;
	}

	public static int Operation(int N, int num) {
		
		if(num == 1) return num;
//		for(int i = 0; i < oper.length; i++) {
//			su * 10 + num
//			su * num
//			su / num
//			su + num
//			su - num
//		}
		return 0;
	}
	public static void main(String[] args) {
		int N = 5;
		int number = 12;
		int result = solution(N, number);

		System.out.println(result);
	}


}
