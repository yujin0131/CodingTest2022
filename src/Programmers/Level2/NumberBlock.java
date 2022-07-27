package Programmers.Level2;

import java.util.Arrays;

//https://school.programmers.co.kr/learn/courses/30/lessons/12923

public class NumberBlock {
	int[] answer;
	int length;
    public int[] solution(long begin, long end) {
    	length = Long.valueOf(end - begin + 1).intValue();
    	answer = new int[length];
        
    	Arrays.fill(answer, 1);
    	if(begin == 1) answer[0] = 0; 
        insert(begin, end);
		for(int i = 0; i < length; i ++) {
			System.out.print(answer[i] + " ");
		}
		System.out.println();
		insert2(begin, end);
        return answer;
    }
    
    public void insert2(long begin, long end) {
    	long sqrt = (long)Math.sqrt(end); //3
    	int last = (int) (end / sqrt); // 5
    	System.out.println("sqrt : " + sqrt + " last : " + last);
    	while(sqrt > 1) {
    		int count = (int) (end / sqrt -1);
    		while(count > 0) {
    			//answer[last] = 
    			break;
    		}
    		sqrt--;
    		break;
    	}
    }
    
    
    public void insert(long begin, long end) {
    	long mod = end / 2;
    	if(mod > 10000000) mod = 10000000;
    	int check = length;
    	while(mod > 1 && check > 0) {
    		long count = 1;
    		int now = (int) (length -end % mod  -1);

    		while(count < end / mod) {
    			if(now < 0) break;
    			if(answer[now] == 1) {
    				answer[now] = (int)mod;		
    				check--;
    			}
    			count++;
    			now -= mod;
    		}
    		mod--;
    		System.out.println(mod);
    	}
    }
    
    public static void main(String[] args) {
		NumberBlock block = new NumberBlock();
		long begin = 90000000;
		long end = 100000000;
		
		int[] result = block.solution(begin, end);
		for(int i = 0; i < result.length; i ++) {
			System.out.print(result[i] + " ");
		}
	}
    
    /*
    그렙시에는 0으로 된 도로에 숫자 블록을 설치하기로 하였습니다. 숫자 블록의 규칙은 다음과 같습니다.

	블록의 번호가 n 일 때, 가장 처음 블록은 n * 2번째 위치에 설치합니다. 그다음은 n * 3, 그다음은 n * 4, ...로 진행합니다.만약 기존에 블록이 깔려있는 자리라면 그 블록을빼고 새로운 블록으로 집어넣습니다.
	
	예를 들어 1번 블록은 2,3,4,5, ... 인 위치에 우선 설치합니다. 그다음 2번 블록은 4,6,8,10, ... 인 위치에 설치하고, 3번 블록은 6,9,12... 인 위치에 설치합니다.
	
	이렇게 3번 블록까지 설치하고 나면 첫 10개의 블록은 0, 1, 1, 2, 1, 3, 1, 2, 3, 2이됩니다.
	
	그렙시는 길이가 1,000,000,000인 도로에 1번 블록부터 시작하여 10,000,000번 블록까지 위의 규칙으로 모두 놓았습니다.
	
	그렙시의 시장님은 특정 구간의 어떤 블록이 깔려 있는지 알고 싶습니다.
	
	구간을 나타내는 두 수 begin, end 가 매개변수로 주어 질 때, 그 구간에 깔려 있는 블록의 숫자 배열(리스트)을 return하는 solution 함수를 완성해 주세요.
	
	제한 사항
	begin, end 는 1 이상 1,000,000,000이하의 자연수 이고, begin는 항상 end보다 작습니다.
	end - begin 의 값은 항상 10,000을 넘지 않습니다.
	입출력 예
	begin	end	result
	1	10	[0, 1, 1, 2, 1, 3, 1, 4, 3, 5]
	입출력 예 설명
	입출력 예 #1
	다음과 같이 블럭이 깔리게 됩니다.
	Imgur
	
     */
}
