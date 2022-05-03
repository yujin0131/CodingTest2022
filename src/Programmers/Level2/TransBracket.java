package Programmers.Level2;

import java.util.Stack;

public class TransBracket {

	static String answer="";
	static int psize = 0;
	static String v = "";
	
	public static String solution(String p) {
		psize = p.length();
		solution2(p);

		return answer;
	}

	public static String solution2(String p) {
		answer = uCheck(p);

		if(answer.length()!=psize) {
			solution2(v);
		}

		return answer;

	}
	public static String uCheck(String p) {

		Stack<Object> stack = new Stack<>();
		int left = 0;
		int right = 0;
		int count = 0;
		
		boolean uBracket = false;
		char c = p.charAt(count++);
		
		//peek 에러 처리 위해 첫번째는 따로 넣어줌
		if(c=='(') left++;
		else right++;	
		
		stack.push(c);

		while(!uBracket && count < p.length()) { // 최소 균형이면 로직 나감
			c = p.charAt(count);
			if(c=='(') left++;
			else right++;
			
			if(stack.peek().equals(c)) stack.push(c);
			else stack.pop();

			count++;
			if(left==right) uBracket=true;
		}

		// u v 나눔
		String u = p.substring(0, count);
		v = p.substring(count);

		if(stack.size()==0 && p.charAt(0)=='(') { // u 올바른 문자열

			return v.equals("") ? u : u+uCheck(v); // v 있을 경우, v 를 p로써 처음부터 다시 로직 수행 후 u 뒤에 붙임
			
		}else { // 균형

			if(!v.equals("")) v = uCheck(v); // v 있을 경우, v 를 p로써 처음부터 다시 로직 수행
			
			u = u.substring(1,u.length()-1); //u 앞뒤 제거
			u = u.replaceAll("\\(", "1");
			u = u.replaceAll("\\)", "2");
			u = u.replaceAll("1", ")");
			u = u.replaceAll("2", "(");

			return "(" + v + ")" + u;

		}
	}

	public static void main(String[] args) {

		String p = "()))((()";
		String result = solution(p);

		System.out.println(result);

	}    
}
