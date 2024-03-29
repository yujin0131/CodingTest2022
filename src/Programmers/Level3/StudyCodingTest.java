package Programmers.Level3;

// https://school.programmers.co.kr/learn/courses/30/lessons/118668

public class StudyCodingTest {

}

/*
제한사항
초기의 알고력을 나타내는 alp와 초기의 코딩력을 나타내는 cop가 입력으로 주어집니다.
0 ≤ alp,cop ≤ 150
1 ≤ problems의 길이 ≤ 100
problems의 원소는 [alp_req, cop_req, alp_rwd, cop_rwd, cost]의 형태로 이루어져 있습니다.
alp_req는 문제를 푸는데 필요한 알고력입니다.
0 ≤ alp_req ≤ 150
cop_req는 문제를 푸는데 필요한 코딩력입니다.
0 ≤ cop_req ≤ 150
alp_rwd는 문제를 풀었을 때 증가하는 알고력입니다.
0 ≤ alp_rwd ≤ 30
cop_rwd는 문제를 풀었을 때 증가하는 코딩력입니다.
0 ≤ cop_rwd ≤ 30
cost는 문제를 푸는데 드는 시간입니다.
1 ≤ cost ≤ 100
정확성 테스트 케이스 제한사항

0 ≤ alp,cop ≤ 20
1 ≤ problems의 길이 ≤ 6
0 ≤ alp_req,cop_req ≤ 20
0 ≤ alp_rwd,cop_rwd ≤ 5
1 ≤ cost ≤ 10
효율성 테스트 케이스 제한사항

주어진 조건 외 추가 제한사항 없습니다.
입출력 예
alp	cop	problems	result
10	10	[[10,15,2,1,2],[20,20,3,3,4]]	15
0	0	[[0,0,2,1,2],[4,5,3,1,2],[4,11,4,0,2],[10,4,0,4,2]]	13
입출력 예 설명
입출력 예 #1

코딩력 5를 늘립니다. 알고력 10, 코딩력 15가 되며 시간이 5만큼 소요됩니다.
1번 문제를 5번 풉니다. 알고력 20, 코딩력 20이 되며 시간이 10만큼 소요됩니다. 15의 시간을 소요하여 모든 문제를 풀 수 있는 알고력과 코딩력을 가질 수 있습니다.
입출력 예 #2

1번 문제를 2번 풉니다. 알고력 4, 코딩력 2가 되며 시간이 4만큼 소요됩니다.
코딩력 3을 늘립니다. 알고력 4, 코딩력 5가 되며 시간이 3만큼 소요됩니다.
2번 문제를 2번 풉니다. 알고력 10, 코딩력 7이 되며 시간이 4만큼 소요됩니다.
4번 문제를 1번 풉니다. 알고력 10, 코딩력 11이 되며 시간이 2만큼 소요됩니다. 13의 시간을 소요하여 모든 문제를 풀 수 있는 알고력과 코딩력을 가질 수 있습니다.
 */
