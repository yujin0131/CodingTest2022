package Programmers.Level2;

import java.util.Stack;

// https://programmers.co.kr/learn/courses/30/lessons/12909
public class RightBracket {
	public static boolean  solution(String s) {

		int length = s.length();
		int count = 0;
		
		for(int i = 0; i < length; i++) {
			char c= s.charAt(i);
			
			if(c==')') {
				if (count==0) return false;
			count--;
	
			}else 
				count++;
			
		}
		boolean answer = count == 0 ? true : false;
		return answer;
	}
	
//	public static boolean  solution(String s) {
//
//		int length = s.length();
//		Stack<Object> bracketCheck = new Stack<>();
//		for(int i = 0; i < length; i++) {
//			char c= s.charAt(i);
//			if(bracketCheck.size()==0 && c==')') return false;
//
//			if(bracketCheck.size() == 0 || bracketCheck.peek().equals(c)){
//				bracketCheck.push(c);	
//			}else {
//				bracketCheck.pop();
//			}
//			
//		}
//		
//		boolean answer = bracketCheck.size() == 0 ? true : false;
//		return answer;
//	}

	public static void main(String[] args) {

		String s = "(())()";
		boolean result = solution(s);
		System.out.println(result);
	}

	/*
	 *	 s	answer
		"()()"	true
		"(())()"	true
		")()("	false
		"(()("	false
	 */
}
