package Programmers.Level2;

import java.util.Stack;

public class KakaoStringCom {

	public static int solution(String s) {
		int answer = 0;
		int size = s.length();
		int[] arr = new int[size];

		for(int i = 0; i < size; i++) { // i : 몇개로 자를건지
			String str = "";
			
			int j = size / (i+1);
			int start = i+1;
			String first = s.substring(0,start);
		
			int count = 1;
			for(int k = 1; k < j; k++) { // k : 나눌 회차
			
				String now = s.substring(start*k, start*k+start);
				if(first.equals(now)) {
					count++;
					if(k+1==j) {
						str+=count+first;
						System.out.println("str : " + str);
						break;
					}
					continue;
				}
				str += count != 1 ? count + first : first;
				System.out.println("str : " + str);
				count = 1;
				first = now;
				System.out.println("first : " + first + " now : " + now);
			
//				if(now.equals(first)) {
//					int count = 1;
//
//					System.out.println("오나 : " +first);
//			
//					while(k< size && now.equals(first)) {
//						now = s.substring(start,(i+1)*(k+1));
//						count++;
//						k++;
//						start = k;
//						System.out.println("now : " + now + " k : " + k + " count : " + count + " start : " + start);
//						
//						
//					}
//					
//					str += count+first;
//					first = now;
//					System.out.println("if str : " + str);
//					if ( k+1 == size) break;
//					k--;
//					start = k;
//				}else {
//					str+=first;
//					first = now;
//					System.out.println("else str : " + str);
//				}
//
//				


			}
			System.out.println(" ============== " + i + " : " + str + " / " + str.length() + " =======================");
			arr[i] = str.length();
		}

	
		return 1;
	}

	public static void main(String[] args) {
		String s = "aabbaccc";
		int result = solution(s);

		System.out.println(result);
	}
	
	/*
	 *  "aabbaccc"	7
		"ababcdcdababcdcd"	9
		"abcabcdede"	8
		"abcabcabcabcdededededede"	14
		"xababcdcdababcdcd"	17
	 */
}
