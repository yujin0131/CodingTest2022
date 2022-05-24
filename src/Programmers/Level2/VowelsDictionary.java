package Programmers.Level2;
// https://programmers.co.kr/learn/courses/30/lessons/84512

public class VowelsDictionary {
	public static int solution(String word) {
		int answer = 0;
		int wordLeng = word.length();
		String aReplace = word.replaceAll("A", "");
		int aCheck = wordLeng - aReplace.length();
		if(aCheck == wordLeng) return wordLeng;
		
		for(int i = 0 ; i <wordLeng; i++) {
			System.out.println(answer);
			if(wordLeng  < 5-i) {
				answer=1;
				answer *= 5 * (i+1) + 1;
				continue;
			}
			
			
			
			char now = word.charAt(wordLeng-i);
			int seq = 5;
			switch (now) {
				case 'A': 
					seq = 0;
					break;
				
				case 'E' :
					seq = 1;
					break;
					
				case 'I': 
					seq = 2;
					break;
				
				case 'O' :
					seq = 3;
					break;
					
				case 'U' :
					seq = 4;
					break;	
			}
			
			answer *= 6 * seq + 1;
			
		}
		return answer;
	}
	public static void main(String[] args) {
		String word = "AAAE";
		int result =solution(word);
		
		System.out.println(result);
		
	}
	// AAAAA 5가지
	//  5* 5* 5* 5
	
	/*	'A', 'E', 'I', 'O', 'U
	 * 	word	result
		"AAAAE"	6
		"AAAE"	10
		"I"	1563
		"EIO"	1189  782 + 313 + 94
	 */
	
	/*
	 * A X
	 *   A X
	 * 	   A X             -- 3
	 *       A X A E I O U -- 9
	 *       E X A E I O U -- 15
	 *       I X A E I O U -- 21
	 *       O X A E I O U -- 27
	 *       U X A E I O U -- 33 
	 *     E X			   -- 34
	 *       A X A E I O U -- 40
	 *       E X A E I O U
	 *       I X A E I O U
	 *       O X A E I O U
	 *       U X A E I O U -- 64
	 *     I X			   -- 65
	 *       A X A E I O U
	 *       E X A E I O U
	 *       I X A E I O U
	 *       O X A E I O U
	 *       U X A E I O U -- 95
	 *     O X			   -- 96
	 *       A X A E I O U
	 *       E X A E I O U
	 *       I X A E I O U
	 *       O X A E I O U
	 *       U X A E I O U -- 126
	 *     U X			   -- 127
	 *       A X A E I O U
	 *       E X A E I O U
	 *       I X A E I O U
	 *       O X A E I O U
	 *       U X A E I O U -- 157  150 + 5 + 1 + 1
	 *   E X               -- 158
	 *     A X             -- 159
	 *       A X A E I O U -- 165
	 *       E X A E I O U
	 *       I X A E I O U
	 *       O X A E I O U
	 *       U X A E I O U -- 189
	 *     E X             -- 190
	 *       A X A E I O U
	 *       E X A E I O U
	 *       I X A E I O U
	 *       O X A E I O U
	 *       U X A E I O U -- 220
	 *     I X             -- 221
	 *       A X A E I O U
	 *       E X A E I O U
	 *       I X A E I O U
	 *       O X A E I O U
	 *       U X A E I O U -- 251
	 *     O X
	 *       A X A E I O U
	 *       E X A E I O U
	 *       I X A E I O U
	 *       O X A E I O U
	 *       U X A E I O U
	 *     U X
	 *       A X A E I O U
	 *       E X A E I O U
	 *       I X A E I O U
	 *       O X A E I O U
	 *       U X A E I O U -- 313  150 + 150 + 5 + 5 + 1 + 1 + 1 
	 *   I X
	 * 	   A X             
	 *       A X A E I O U 
	 *       E X A E I O U 
	 *       I X A E I O U 
	 *       O X A E I O U 
	 *       U X A E I O U  
	 *     E X			   
	 *       A X A E I O U 
	 *       E X A E I O U
	 *       I X A E I O U
	 *       O X A E I O U
	 *       U X A E I O U 
	 *     I X			  
	 *       A X A E I O U
	 *       E X A E I O U
	 *       I X A E I O U
	 *       O X A E I O U
	 *       U X A E I O U
	 *     O X			  
	 *       A X A E I O U
	 *       E X A E I O U
	 *       I X A E I O U
	 *       O X A E I O U
	 *       U X A E I O U 
	 *     U X			   
	 *       A X A E I O U
	 *       E X A E I O U
	 *       I X A E I O U
	 *       O X A E I O U
	 *       U X A E I O U -- 313 + 150 + 5 + 1 = 469
	 *   O X               
	 *     A X            
	 *       A X A E I O U 
	 *       E X A E I O U
	 *       I X A E I O U
	 *       O X A E I O U
	 *       U X A E I O U 
	 *     E X            
	 *       A X A E I O U
	 *       E X A E I O U
	 *       I X A E I O U
	 *       O X A E I O U
	 *       U X A E I O U 
	 *     I X            
	 *       A X A E I O U
	 *       E X A E I O U
	 *       I X A E I O U
	 *       O X A E I O U
	 *       U X A E I O U 
	 *     O X
	 *       A X A E I O U
	 *       E X A E I O U
	 *       I X A E I O U
	 *       O X A E I O U
	 *       U X A E I O U
	 *     U X
	 *       A X A E I O U
	 *       E X A E I O U
	 *       I X A E I O U
	 *       O X A E I O U
	 *       U X A E I O U 
	 *   
	 *    
	 */
}
