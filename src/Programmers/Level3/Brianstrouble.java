package Programmers.Level3;

import java.util.HashMap;
import java.util.Map;

// (규칙 1) 특정 단어를 선택하여 글자 사이마다 같은 기호를 넣는다. ex) HELLO -> HaEaLaLaO
// (규칙 2) 특정 단어를 선택하여 단어 앞뒤에 같은 기호를 넣는다. ex) WORLD -> bWORLDb

public class Brianstrouble {

	String answer;
	boolean checkRule1 = true;
	boolean checkRule2 = true;
	Map<Character, String> lowerMap;
	
	public String solution(String sentence) {
		answer = "";
		lowerMap = new HashMap<>();

		if(sentence.contains(" ")) invalid(); // 변형된 문자열은 공백 X야함. 근데 있을 경우 invalid
		else lowerCheck(sentence);

		answer = answer.contains("invalid") ? "invalid" : answer.trim(); // 재귀때문에 다른 문자 있을 수 있음

		return answer;
	}

	public void lowerCheck(String sentence) { 	// 소문자 있는지 체크 
		int length = sentence.length();
		
		for(int i = 0; i < length; i++) {
			char lower = sentence.charAt(i);
			if(Character.isLowerCase(lower)) {	 // 소문자 있을 때 로직
				if(lowerMap.containsKey(lower)) {	 // 이미 사용한 소문자일 경우 탈락
					invalid();
					return;
				}
				lowerMap.put(lower, "");	 // 사용한 소문자 map 저장
				
				int lastIndex = sentence.lastIndexOf(lower); 	// 발견된 소문자의 마지막 위치 체크

				if(lastIndex == i || (!checkRule2 && lastIndex - i == 2 )) { // 소문자 한 개 || rule2 적용 후 소문자 개수 2개  -> rule1
																			//rule2 적용 후 소문자 개수 2개 ? ex) aBcBcBa 의 경우 rule2 규칙을 2번 할 순 없지만, aa : rule2 cc: rule1 적용 가능하게 하려고
																			// 내 규칙은 소문자가 2개면 무조건 rule2로 가게 했기 때문에 위의경우를 넣어줘야함. 
					rule1(i-1, lastIndex+2, sentence, lower);
					if(!checkRule2) checkRule2 = true; 		// rule2 다녀왔다면 이제 다시 해제 why? rule1을 끝냈다는건 그 후에 소문자가 없단 뜻. 따라서 이제 뒷 단어 체크해야함.
					
				}else {
					
					String anotherStr = sentence.substring(i+1, lastIndex); 	// 소문자가 2개인지 체크 > 2개면 무조건 rule2로 가게하기 위함
					boolean anotherLower = anotherStr.contains(Character.toString(lower));
					
					if(!anotherLower) { 	// 소문자 2개 -> rule2		
						if(i != 0) {	 // 소문자 앞에 문자가 있다면 아무것도 해당 안되는 단어이므로 noLower() 해준후 rule2 수행
							noLower(sentence, i);   
						}
						
						rule2(i+1, lastIndex, sentence, lower);

					}else {		// 나머지 경우 -> rule1
						rule1(i-1, lastIndex+2, sentence, lower);
						if(!checkRule2) checkRule2 = true; 	// rule2 다녀왔다면 이제 다시 해제 why? rule1을 끝냈다는건 그 후에 소문자가 없단 뜻. 따라서 이제 뒷 단어 체크해야함.
					}
				}
				break;
				
			}else if(i + 1 == length){ 	// 소문자 끝까지 없을 때
				noLower(sentence, i+1);
			}
		}
	}

	public void invalid() {
		answer = "invalid";
	}
	
	public void answer(String sentence) {
		answer += " " + sentence;
	}

	public void noLower(String sentence, int lastIndex) { 
		if(!checkRule2) return; // 문자 중복 붙임 방지
		sentence = sentence.substring(0, lastIndex);
		answer(sentence);
	}

	public void rule1(int firstIndex, int lastIndex, String sentence, char lower) {
		
		if(!checkRule1 || sentence.charAt(0) == lower || sentence.charAt(sentence.length()-1) == lower) { // rule1 두번째 || 첫단어 / 막단어 > 소문자 경우 invalid()
			invalid();
			return;
		}
		
		if(firstIndex != 0) { // 소문자 앞단어가 0 이 아닐 때 > AAaAaAaA 의 경우 -> A AAAA 여야 하기 때문
//			if(!checkRule2) { // rule2를 거쳤는데 그 안에 두단어이상 일 경우 > aAAbAbAbAa > A AAAA 이 되는데 모든 규칙은 한 단어에만 적용!! 
//				invalid();		// >> 이건 안해도 테스트는 통과된다. 단, oGOaOaGaLaEo > invalid 여야하는데 OOGLE로 통과됨. > G OOGLE 아닌 이유 : nolower 에서 rule2 체크함 but, 그냥 return이라 안됨.
//				return;
//			}
			noLower(sentence, firstIndex);
		}

		String lowerStr = Character.toString(lower);
		String resentence = sentence.substring(firstIndex, lastIndex);
		String removeLower = resentence.replaceAll(lowerStr, "");
		if(removeLower.length() * 2 - resentence.length()  != 1) { // AaAAAaAaAaAAAAaA 이런경우 방지 > rule1 만족하려면, 소문자 x 문장길이 * 2 - 원본문자 = 1 만족해야함.
			invalid();
			return;
		}
		
		checkRule1 = false;	//rule1 두번 이상 방지 체크
		checkRule2 = false;
		lowerCheck(removeLower);
		
		checkRule1 = true; 
		checkRule2 = true;
		answer(removeLower);
		
		resentence = sentence.substring(lastIndex); // 남은 뒷단어 체크
		if(resentence.length()!=0) {
			lowerCheck(resentence);

		}
	}

	public void rule2(int firstIndex, int lastIndex, String sentence, char lower) {
		if(!checkRule2 || firstIndex == lastIndex ) { // rule2 두번째 || 대문자 없는 것 방지 > aa 
			invalid();
			return;
		}
		
		String resentence = sentence.substring(firstIndex, lastIndex); // 다른 소문자 있는지 체크
		String sentenceLower = resentence.toUpperCase();
		if(!resentence.equals(sentenceLower)) { // 다른 소문자 있는경우, rule2 수행 한 문장으로 lowerCheck() 
			checkRule2 = false;
			lowerCheck(resentence);
		}else {
			answer(resentence); 
		}
		
		resentence = sentence.substring(lastIndex+1); // 남은 문자열 수행
		lowerCheck(resentence);
	}
	
	public static void main(String[] args) {

		String[][] sentence = {
				{"HaEaLaLaObWORLDb",    "HELLO WORLD"},
				{"SpIpGpOpNpGJqOqA",    "SIGONG J O A"},
				{"AxAxAxAoBoBoB",   "invalid"},
				{"oAxAxAxAoBbB",        "AAAA BB"},
				{"HEaLLOaWORLD",        "HE LLO WORLD"},
				{"HELaLaOWORLD",        "HEL L OWORLD"},
				{"HELLaLaOaWORLD",  "HEL LLOW ORLD"},
				{"aIaAM",           "I AM"},
				{"baHELLOabWORLD",  "invalid"},
				{"aHbEbLbLbOacWdOdRdLdDc",  "HELLO WORLD"},
				{"bAaOb",   "AO"},
				{"aHELLOa bWORLDb", "invalid"},
				{"HaEaLaLObWORLDb", "HELL O WORLD"},
				{"aHELLOWORLDa",        "HELLOWORLD"},
				{"HaEaLaLaOWaOaRaLaD",  "invalid"},
				{"abHELLObaWORLD",      "invalid"},
				{"aAbBbCa",             "ABC"},
				{"aAbBcCa",             "invalid"},
				{"abABCba",             "invalid"},
				{"Aa",                  "invalid"},
				{"aAAaAbA",             "AA AA"},
				{"aGgGaGbGbGG", "GG G G GG"},
				{"tB", "invalid"}
		};
		
		for(int i = 0; i < sentence.length; i++) {
			Brianstrouble brain = new Brianstrouble();
			String result = brain.solution(sentence[i][0]);
			System.out.println(result.equals(sentence[i][1]) + " " + result);
		}
	}
}
