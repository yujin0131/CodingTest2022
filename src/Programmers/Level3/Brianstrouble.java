package Programmers.Level3;

// (규칙 1) 특정 단어를 선택하여 글자 사이마다 같은 기호를 넣는다. ex) HELLO -> HaEaLaLaO
// (규칙 2) 특정 단어를 선택하여 단어 앞뒤에 같은 기호를 넣는다. ex) WORLD -> bWORLDb

public class Brianstrouble {

	String sentence;
	String answer;
	int lastIndex = 0;
	int firstIndex = 0;
	public String solution(String sentence) {
		answer = "";
		this.sentence = sentence;

		lowerCheck(sentence);

		answer = answer.contains("invalid") ? "invalid" : answer;
		return answer;

	}

	public void lowerCheck(String sentence) {
		
		int length = sentence.length();
		for(int i = 0; i < length; i++) {
			char lower = sentence.charAt(i);
			
			System.out.println(">>>>>>>>>>>>>>>> i : " + i + " lower : " + lower);
			if(Character.isLowerCase(lower)) {
				int lastIndex = sentence.lastIndexOf(lower); 

				if(lastIndex == i) { // rule1
					System.out.println("오나");
					rule1(i-1, lastIndex+2, sentence, lower);
				}else {
					String anotherStr = sentence.substring(i+1, lastIndex);
					boolean anotherLower = anotherStr.contains(Character.toString(lower));
					if(lastIndex - i == 2 || !anotherLower) { //rule2
						
						rule2(i+1, lastIndex, sentence, lower);
						
					}else { // rule1
						rule1(i-1, lastIndex+2, sentence, lower);
					}
				}
			
				break;
			}
		}
	}
	
	public void rule1(int firstIndex, int lastIndex, String sentence, char lower) {
		String lowerStr = Character.toString(lower);
		String resentence = sentence.substring(firstIndex, lastIndex).replaceAll(lowerStr, "");
		answer += " " + resentence;
		System.out.println("rule1 : " + answer );
		resentence = sentence.substring(lastIndex);
		System.out.println("rule1 > resentence : " + resentence);
		if(resentence.length()!=0) {
			lowerCheck(resentence);
		}
		
	}
	
	public void rule2(int firstIndex, int lastIndex, String sentence, char lower) {
	
		String resentence = sentence.substring(firstIndex, lastIndex);
		String sentenceLower = resentence.toLowerCase();
		if(resentence.equals(sentenceLower)) {
			lowerCheck(resentence);
		}else {
			
			answer += " " + resentence;
			System.out.println("rule2 : " + answer );
			resentence = sentence.substring(lastIndex+1);
			System.out.println("rule2 > resentence : " + resentence);
			if(resentence.length()!=0) {
				lowerCheck(resentence);
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		String sentence = "AxAxAxAoBoBoB";
		//				   012345678901234567890123456789012345678901234567
		//					AAA B A BBBB C BBBB C BB GG G G G RRRRRR" 또는 
		//					AA ABA BBBB C BBBB C BB GG GGG RRRRRR"
		Brianstrouble brain = new Brianstrouble();
		String result = brain.solution(sentence);



		System.out.println(result);
	}

	/*
	 * 	sentence			answer
		"HaEaLaLaObWORLDb"	"HELLO WORLD"
		"SpIpGpOpNpGJqOqA"	"SIGONG JOA"
		"AxAxAxAoBoBoB"		"invalid"
		"AAAaBaAbBBBBbCcBdBdBdBcCeBfBeGgGGjGjGRvRvRvRvRvR" "AAA B A BBBB C BBBB C BB GG G G G RRRRRR" / "AA ABA BBBB C BBBB C BB GG GGG RRRRRR"
		
		
		
		
		
			public void lowerCheck(String sentence) {

		int length = sentence.length();
		//	int firstIndex = this.firstIndex;
		//	while(this.firstIndex < length) {
		for(int i = 0; i < length; i++) {
			
			char lower = sentence.charAt(i);
			System.out.println(">>>>>>>>>>>>>>>> i : " + i + " lower : " + lower);
			if(Character.isLowerCase(lower)) {
				int lastIndex = sentence.lastIndexOf(lower);
				System.out.println("firstIndex : " + firstIndex + " i-1 : " + (i-1));
				int lowerCount = length - sentence.replaceAll(Character.toString(lower), "").length();
				if(this.lastIndex < i - 1) {
					String resultStr = sentence.substring(i-1, lastIndex+1);
					String check = resultStr.replaceAll(Character.toString(lower), "");
					
					System.out.println("rule1 resStr : " + resultStr);
					
					if(lastIndex == i) {
						String str = sentence.substring(i-1, lastIndex+2);
						rule2(lower, str);
//						int last = nextLower(i+1);
//						String str = sentence.substring(this.lastIndex+1, last-1);
//						System.out.println(str);
//						str = str.replaceAll(Character.toString(lower), "");
//						System.out.println(">>>>>>>>> next : " + str);
//						answer += " " + str;
						i = lastIndex + 1;
						this.firstIndex = i+1;
						this.lastIndex = i;
						continue;
					}else if(resultStr.length() - check.length() > 2) {
						System.out.println("noLower2");
						//String str = sentence.substring(i-1, );
						noLower(i-1);
						this.lastIndex = i-1;

					}else {
						System.out.println("noLower");
						//String str = sentence.substring(i-1, );
						noLower(i);
						this.lastIndex = i;

					}

				}
				if(lowerCount == 2) { // 소문자 2개일 떄
					rule1(i, lastIndex); // 소문자 소문자
					i = lastIndex;
					this.lastIndex = i;
				}else {
					System.out.println("rule2");
					System.out.println(lastIndex);
					String str = sentence.substring(i-1, lastIndex+2);
					rule2(lower, str);
					i = this.firstIndex-1;
				}
			}
		}
	}
	
	
	public int nextLower(int firstIndex) {
		for(int i = firstIndex; i < sentence.length(); i++) {
			char lower = sentence.charAt(i);
			if(Character.isLowerCase(lower)) {
				System.out.println("next : " + lower + " i : " + i);

				return i;

			}
		}
		return sentence.length();
	}

	public void rule1(int firstIndex, int lastIndex) {
		String resultStr = sentence.substring(firstIndex+1, lastIndex);
		String LowerStrCheck = resultStr.toUpperCase();
		
		System.out.println("rule1 resStr : " + resultStr);
		if(resultStr.equals(LowerStrCheck)) {
			resultStr = " " + resultStr;
			answer += resultStr;	

		}else {
			for(int i = 0; i < resultStr.length(); i++) {
				char lower = resultStr.charAt(i);
				if(Character.isLowerCase(lower)) {
					rule2(lower, resultStr);   
					break;
				}
			}
		}
		System.out.println("rule1  answer : " + answer);
		this.firstIndex = lastIndex+1;
	}

	public void noLower(int firstIndex) {
		System.out.println("noLower this : " + this.firstIndex + " fir : " + firstIndex);
		answer += " " + sentence.substring(this.firstIndex, firstIndex);
		System.out.println("noLower " + answer);
		this.firstIndex = firstIndex + 1;

	}

	public void oneLower(String sentence) {
		System.out.println("noLower this : " + this.firstIndex + " fir : " + firstIndex);
		//String str = sentence.substring(fir, firstIndex);
		System.out.println("noLower " + answer);
		this.firstIndex = firstIndex + 1;

	}


	public void rule2(char lower, String sentence) {

		String resultStr = sentence.replaceAll(Character.toString(lower), "");
		System.out.println("resultStr : " + resultStr);
		answer += " " + resultStr;
		System.out.println(firstIndex);
		this.firstIndex = firstIndex + sentence.length();
		System.out.println("rule2 " + answer + " fir : " + this.firstIndex);
	}
	
	
	 */
}
