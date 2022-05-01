package Programmers.Level2;

import java.util.Stack;

public class TransBracket {

	static String answer="";
    static int psize = 0;
    static int hh = 0;
    static String v = "";
        
	public static String solution(String p) {
		psize = p.length();
		solution2(p);
	    
	    return answer;
	}
	
	public static String solution2(String p) {
		System.out.println("============solution2 p " + p);
		String str = uCheck(p);
		if(hh!=2) answer += str;
		else answer += str;
		
		System.out.println("solution2 answer " + answer + " str : " + str);
		if(answer.length()!=psize) solution2(v);
		
		return answer;
		
	}
	public static String uCheck(String p) {
	  
		System.out.println("============================= p : " + p);
	  	Stack<Object> stack = new Stack<>();
	  	int left = 0;
	  	int right = 0;
	  	int count = 0;
	  	boolean uBracket = false;
	      
	  	char c = p.charAt(count++);
			if(c=='(') {
				left++;
			}else right++;
			stack.push(c);
			
	  	while(!uBracket && count < p.length()) {
	  		c = p.charAt(count);
	  		if(c=='(') {
	  			left++;
	  		}else right++;
	  		if(stack.peek().equals(c)) stack.push(c);
	  		else stack.pop();
	  		
	  		count++;
	  		if(left==right) uBracket=true;
	  		System.out.println("count : " + count + " " +uBracket);
	  	}
	  	
	  	// u v 확인
	  	String u = p.substring(0, count);
	  	v = p.substring(count);
	  	System.out.println("u : " + u + " v : " + v);
	  	
	  	if(stack.size()==0 && p.charAt(0)=='(') { // u 올바른 문자열'
	  		System.out.println("u 올바른 : " + u);
	  		return u;
	
	  	}else {
	  		hh = 2;

	  			u = u.substring(1,u.length()-1);
	  			if(v!="") v = uCheck(v);
	  			
	  			u = u.replaceAll("\\(", "1");// 그냥 ( 처리하려면 java.util.regex.PatternSyntaxException: Unclosed group near index 1 에러발생.
	  			u = u.replaceAll("\\)", "2");
	  			u = u.replaceAll("1", ")");
	  			u = u.replaceAll("2", "(");
	  			System.out.println("222 : " + answer);
	  			System.out.println("vvv " + v + " uuu " + u);
	  		
	  			return "(" + v + ")" + u;

	  	}


	  }
    
    
    
    /*
     *	[1] u = )( , v= )()()( >>>> "(" + function(v) + ")"

		[2] u = )( , v = )()( >>>> "(" + function(v) + ")"
		
		[3] u = )( , v = )( >>>> "(" + function(v) + ")"
		
		[4] u = )( , v = "" >>>> "(" + function(v) + ")"
		
		( ※ u는 앞뒤 자르면 사라짐)
		
		[4]의 결과값 "()"은 [3]에서 function(v)에 들어감
		
		[3]의 결과값 "(())"은 [2]에서 function(v)에 들어감
		
		[2]의 결과값 "((()))"은 [1]에서 function(v)에 들어감

[1]의 결과값 >> "(((())))"
     */
    
    
    
   
    
    
    public static void main(String[] args) {
	
		String p = ")()()()(";
		String result = solution(p);
		
	System.out.println("결과 : " + result);
		
	}
    /*
     * 	"(()())()"	"(()())()"
		")("	"()"
		"()))((()"	"()(())()"
     */
	
    
//  ================================= 3 =========================================        
// public static String solution(String p) {
//    	
//        pCheck(p);
//        
//        return answer;
//    }
//    
//    public static void pCheck(String p) {
//    	
//    	System.out.println("============================= p : " + p);
//    	Stack<Object> stack = new Stack<>();
//    	int left = 0;
//    	int right = 0;
//    	int count = 0;
//    	boolean uBracket = false;
//        
//    	char c = p.charAt(count++);
//		if(c=='(') {
//			left++;
//		}else right++;
//		stack.push(c);
//		
//    	while(!uBracket && count < p.length()) {
//    		c = p.charAt(count);
//    		if(c=='(') {
//    			left++;
//    		}else right++;
//    		if(stack.peek().equals(c)) stack.push(c);
//    		else stack.pop();
//    		
//    		count++;
//    		if(left==right) uBracket=true;
//    	}
//    	String u = p.substring(0, count);
//    	String v = p.substring(count);
//    	answer = uCheck(p, u, v, stack.size());
//    	
//    }
//    
//    public static String uCheck(String p, String u, String v, int size) {
//    	System.out.println("==================== uCheck");
//    	System.out.println("u : " + u + " v : " + v);
//    	
//    	if(size==0 && p.charAt(0)=='(') { // u 올바른 문자열
//
//    		return u;
//    		pCheck(v);
//
//    	}else {
//    		if(u.length()<3) answer += "("+v+")";
//    		else {
//    			
//    			u = u.substring(1,u.length()-1);
//    			pCheck(v);
//    			
//    			u = u.replaceAll("\\(", "1");// 그냥 ( 처리하려면 java.util.regex.PatternSyntaxException: Unclosed group near index 1 에러발생.
//    			u = u.replaceAll("\\)", "2");
//    			u = u.replaceAll("1", ")");
//    			u = u.replaceAll("2", "(");
//    			System.out.println("222 : " + answer);
//    			System.out.println("vvv" + v);
//    			return answer += "("+v+")"+u;
//    		}
//    	}
//    	System.out.println("fin : last : " + last + "  answer :    " + answer);
//    	return last+answer;
//    }
    
    
//  ================================= 2 =========================================    
//    public static String uCheck(String p) {
//    	  
//      	System.out.println("============================= p : " + p);
//        	Stack<Object> stack = new Stack<>();
//        	int left = 0;
//        	int right = 0;
//        	int count = 0;
//        	boolean uBracket = false;
//            
//        	char c = p.charAt(count++);
//    		if(c=='(') {
//    			left++;
//    		}else right++;
//    		stack.push(c);
//    		
//        	while(!uBracket && count < p.length()) {
//        		c = p.charAt(count);
//        		if(c=='(') {
//        			left++;
//        		}else right++;
//        		if(stack.peek().equals(c)) stack.push(c);
//        		else stack.pop();
//        		
//        		count++;
//        		if(left==right) uBracket=true;
//        	}
//        	
//        	// u v 확인
//        	String u = p.substring(0, count);
//        	String v = p.substring(count);
//        	System.out.println("u : " + u + " v : " + v);
//        	
//        	if(stack.size()==0 && p.charAt(0)=='(') { // u 올바른 문자열
//        		if(v.equals("")) { //끝
//        			System.out.println( "끝 : " + answer + u);
//        			System.out.println("num : " + num); 
//        			return u;
//        		}
//        		
//        		if(num==1) last+=u;
//        		System.out.println("answer : "+ answer);
//        		num++;
//        		answer = uCheck(v);
//
//        	}else {
//        		if(u.length()<3) answer += "("+v+")";
//        		else {
//        			
//        			u = u.substring(1,u.length()-1);
//        			v = uCheck(v);
//        			
//        			u = u.replaceAll("\\(", "1");// 그냥 ( 처리하려면 java.util.regex.PatternSyntaxException: Unclosed group near index 1 에러발생.
//        			u = u.replaceAll("\\)", "2");
//        			u = u.replaceAll("1", ")");
//        			u = u.replaceAll("2", "(");
//        			System.out.println("222 : " + answer);
//        			System.out.println("vvv" + v);
//        			return answer += "("+v+")"+u;
//        		}
//        	}
//        	System.out.println("fin : last : " + last + "  answer :    " + answer);
//        	return last+answer;
//        }
    
    
//   ================================= 1 =========================================
//	static String answer="";
//	static String last = "";
//	static int num = 1;
//    public static String solution(String p) {
//        //String answer = "";
//        
//        String left = p.replaceAll("\\(", ""); 
//        String right = p.replaceAll("\\)", "");
//        
//        answer = uCheck(p);
//        
//        return answer;
//    }
//    
//    public static String uCheck(String p) {
//
//    	System.out.println("============================= p : " + p);
//    	Stack<Object> stack = new Stack<>();
//    	int left = 0;
//    	int right = 0;
//    	int count = 0;
//    	boolean uBracket = false;
//    	
//    	char c = p.charAt(count++);
//		if(c=='(') {
//			left++;
//		}else right++;
//		stack.push(c);
//		
//    	while(!uBracket && count < p.length()) {
//    		c = p.charAt(count);
//    		if(c=='(') {
//    			left++;
//    		}else right++;
//    		if(stack.peek().equals(c)) stack.push(c);
//    		else stack.pop();
//    		
//    		count++;
//    		if(left==right) uBracket=true;
//    	}
//    	
//    	
//    	System.out.println(count + " " +uBracket + " size :" + stack.size());
//    	String u = p.substring(0, count);
//    	String v = p.substring(count);
//    	
//    	if(stack.size()==0 && p.charAt(0)=='(') { // u 올바른 문자열
//    		System.out.println("올바른 u :" + u);
//    		//answer+=u;
//    		System.out.println("올바른 answer : " + answer);
//    		System.out.println("u : " + u + " v : " + v);
//    		if(v.equals("")) { //끝
//    			System.out.println("끝");
//    			return u;
//    		}
//
//    		answer += u;
//    		System.out.println("answer : " + answer + " u : " + u);
//    		if(num==1) {
//    			num = 2;
//    			last = u;
//    			System.out.println("uuuu : " + u);
//    			
//    		}
//    		uCheck(v);
//   
//    		System.out.println("answer : " + answer + " u : " + u);
//    		
//    		
//    	}else {
//    		if(u.length()<3) answer += "("+v+")";
//    		else {
//    			
//    			System.out.println("아예아님       u : " + u + " v : " + v);
//    			u = u.substring(1,u.length()-1);
//    			v = uCheck(v);
//    			
//    			u = u.replaceAll("\\(", "1");
//    			u = u.replaceAll("\\)", "2");
//    			u = u.replaceAll("1", ")");
//    			u = u.replaceAll("2", "(");
//    			
//    			return answer += "("+v+")"+u;
//    		}
//    	}
//    	System.out.println("last : " + last);
//    	return last != null ? answer + last : answer;
//    }
    

   
}
