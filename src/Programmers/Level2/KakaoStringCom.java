package Programmers.Level2;

import java.util.Arrays;
import java.util.Stack;

public class KakaoStringCom {

	public static int solution(String s) {
		int size = s.length();
		int[] arr = new int[size];
		int answer = size;
		
		for(int i = 0; i < size; i++) { // i : 몇개로 자를건지
			String str = "";
			int sum = size;
			int q = size / (i+1);
			int r = size % (i+1);
			int start = i+1;
			String first = s.substring(0,start);
		
			int count = 1;
			for(int k = 1; k < q; k++) { // k : 나눌 회차
			
				if(q == 1 || q == 0) {
					continue;
				}
				String now = s.substring(start*k, start*k+start);
				if(first.equals(now)) {
					count++;
					if(k+1==q) {
						str+=count+first;
						break;
					}
					continue;
				}
				str += count != 1 ? count + first : first;
				count = 1;
				first = now;
				if(k+1 == q) str += now;
			}
			sum = r == 0 ? str.length() : str.length() + r;
			answer = sum < answer ? sum : answer;
		}


	
		return answer;
	}

	public static void main(String[] args) {
		String s = "xababcdcdababcdcd";
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
