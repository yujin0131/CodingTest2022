package Programmers.Level1;

public class NewIDRecommend {

	static String answer = "";
	
	public static String solution(String new_id) {
		answer = new_id; 

		smallLater(); // 1단계 : 소문자 치환
		otherRemove(); // 2단계 : 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.) 제외하고 제거
		punctuation();// 3단계 : 2번 이상 연속 마침표(.)로 하나로 치환
		puncRemove(); // 4단계 : 처음이나 끝에 마침표(.)가 위치한다면 제거합니다.
		emptyToA(); // 5단계 : 빈 문자열 이라면 a 대입
		lengthRemove(); // 6단계 : 16자 이상 >  첫 15개 문자 / 마침표(.)가 new_id의 끝에 위치 > 제거합니다.
		lengthAdd(); //7단계 : 2자 이하 > 마지막 문자를3이 될 때까지 붙임

		return answer;
	}

	public static void smallLater() {
		answer = answer.toLowerCase();

	}

	public static void otherRemove() { 
		String check = "[^a-z0-9._-]";
		answer = answer.replaceAll(check, "");

	}
	
	public static void punctuation() {	
		String check = "[.]{2,}";
		answer = answer.replaceAll(check,".");

	}

	public static void puncRemove() {
		
		int start = answer.charAt(0) == '.' ? 1 : 0;
		int last = answer.length()-1;
		
		if(answer.length()==1 && start == 1) {
			answer = "";
			return;
		}
		
		if(answer.charAt(last) != '.') last++;
		
		answer = answer.substring(start, last);
		
//		String check = "^[.]|[.]$";  이런방법도 있다..

	}

	public static void emptyToA() {
		answer = answer.equals("") ? "a" : answer ;

	}
	
	public static void lengthRemove() {
		if(answer.length()<16) return;
		
		answer = answer.charAt(14)=='.' ? answer.substring(0,14) : answer.substring(0,15);

	}
	
	public static void lengthAdd() {
		int cnt = answer.length();
		String strAdd = String.valueOf(answer.charAt(answer.length()-1));
		
		while(cnt < 3) {
			answer += strAdd;
			cnt++;
		}

	}


	public static void main(String[] args) {
		String new_id = "=.=";
		String result = solution(new_id);
		System.out.println(result);
		System.out.println("abcdefghijklmn");
	}

	/*
	 *	no	new_id	result
		예1	"...!@BaT#*..y.abcdefghijklm"	"bat.y.abcdefghi"
		예2	"z-+.^."	"z--"
		예3	"=.="	"aaa"
		예4	"123_.def"	"123_.def"
		예5	"abcdefghijklmn.p"	"abcdefghijklmn"

	 */
}
