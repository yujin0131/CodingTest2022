package Programmers.Level2;

// https://programmers.co.kr/learn/courses/30/lessons/84512

//String[] wordArr = {"A", "E", "I", "O", "U"}; 리스트 인덱스찾기와 switch 중 뭐가 효율적인지 찾기

public class VowelsDictionary {
	public static int solution(String word) {
		int answer = 0;
		int wordLeng = word.length();
		
		String aReplace = word.replaceAll("A", "");
		int aCheck = wordLeng - aReplace.length();
		if(aCheck == wordLeng) return wordLeng;
		
		for(int i = 0 ; i <wordLeng; i++) {
			int sum = 1;
			char now = word.charAt(i);
			int seq = 5;
			switch (now) {
				case 'A': 
					seq = 0;
					answer += 1;
					continue;
				
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
			
			for(int j = 0; j < 4-i; j++) {
				sum = 5 * sum + 1;
			}
			
			sum = sum * seq +1;
			answer += sum;
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		String word = "AAAAE";
		int result =solution(word);
		
		System.out.println(result);
		
	}
	
	
	/*	'A', 'E', 'I', 'O', 'U
	 * 	word	result
		"AAAAE"	6
		"AAAE"	10
		"I"	1563
		"EIO"	1189  782 + 313 + 94
	 */
	
	
}
