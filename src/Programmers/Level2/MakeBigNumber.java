package Programmers.Level2;

import java.util.LinkedList;

public class MakeBigNumber {
	public String solution(String number, int k) {
		String answer = number;
		LinkedList<Integer> queue = new LinkedList<>();
		int length = number.length();

		outer : for(int i = 0; i < length; i++) {
			int now = Integer.parseInt(number.substring(i,i+1));

			System.out.println("================ now :" + now);

			if(queue.isEmpty() || now == queue.peek()) {
				System.out.println("없 & 같");
				queue.add(now);
			}else  {
				System.out.println(now  + " " + queue.peek() + " " + queue.peekLast());

				if(queue.peekLast() < now) {
					System.out.println("answer : " + answer);

					System.out.println("작 안");
					answer = answer.replaceFirst(queue.removeLast().toString(), "");
					queue.add(now);
					k--;
					if(queue.size() != 1) {

						i--;
					}
				}else if(queue.peek() < now) {
					System.out.println("answer : " + answer);
					k--;
					System.out.println("크 안");
					answer = answer.replaceFirst(queue.remove().toString(), "");
					queue.add(now);
					if(queue.size() != 1) {
						i--;
					}
				}else {
					System.out.println("에드");
					queue.add(now);
					System.out.println(queue.size() + " dddddddd");
				}
				if( k == 0 ) break outer;
				System.out.println(answer);

			}

		}
		

		return answer;
	}

	public static void main(String[] args) {
		String number = "87654321";
		int k = 3;

		MakeBigNumber makeNumber = new MakeBigNumber();
		String result = makeNumber.solution(number, k);
		System.out.println(result.equals("3234") + " " + result);
	}
	/*
	어떤 숫자에서 k개의 수를 제거했을 때 얻을 수 있는 가장 큰 숫자를 구하려 합니다.

	예를 들어, 숫자 1924에서 수 두 개를 제거하면 [19, 12, 14, 92, 94, 24] 를 만들 수 있습니다. 이 중 가장 큰 숫자는 94 입니다.

	문자열 형식으로 숫자 number와 제거할 수의 개수 k가 solution 함수의 매개변수로 주어집니다. number에서 k 개의 수를 제거했을 때 만들 수 있는 수 중 가장 큰 숫자를 문자열 형태로 return 하도록 solution 함수를 완성하세요.

	제한 조건
	number는 2자리 이상, 1,000,000자리 이하인 숫자입니다.
	k는 1 이상 number의 자릿수 미만인 자연수입니다.
	입출력 예
	number	k	return
	"1924"	2	"94"
	"1231234"	3	"3234"
	"4177252841"	4	"775841"
	"432487" 
	94812
	 */
}
