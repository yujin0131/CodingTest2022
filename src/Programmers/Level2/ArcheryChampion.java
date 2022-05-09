package Programmers.Level2;

public class ArcheryChampion {

	public static int[] solution(String[] info, String[] query) {
		int[] answer = new int[query.length];
		
		for(int i = 0;)
		return answer;
	}

	public static void main(String[] args) {
		String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
		String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
		int[] result = solution(info, query);

		for(int i=0; i <result.length; i++) {
			System.out.printf(result[i] + ",");
		}

		System.out.println("\n정답 : 1,1,1,1,2,4");
	}

// ========================== 2 ==============================
//	public static int[] solution(String[] info, String[] query) {
//		int infoSize = info.length;
//		int querySize = query.length;
//		int[] answer = new int[querySize];
//		//1. cpp, java, python
//		//2. backend, frontend
//		//3. junior, senior
//		//4. chicken, pizza
//		//5. score
//
//		for(int i = 0; i < querySize; i++) {
//			int count = 0;
//			query[i] = query[i].replaceAll(" and ", " ");
//			System.out.println("query: "+query[i] + " ========================");
//			if(query[i].contains("-")) {
//				query[i] = query[i].replaceAll("- ", "");
//				String[] query_str = query[i].split(" ");
//				outer : for(int j = 0; j <infoSize; j++) {
//					System.out.println("info : " + info[j]);
//					for(int k = 0; k < query_str.length-1; k++) {
//						System.out.println("k : " + k);
//						if(!info[j].contains(query_str[k])) continue outer;
//					}
//					System.out.println("q : " +query_str[query_str.length-1]);
//					System.out.println("i : " + info[j].substring(info[j].lastIndexOf(" ")+1));
//					if(Integer.parseInt(query_str[query_str.length-1])>Integer.parseInt(info[j].substring(info[j].lastIndexOf(" ")+1))) continue outer;
//					System.out.println("여기 증가");
//					count++;
//				}
//
//			}else {
//				int strQuery = query[i].lastIndexOf(" ");
//				for(int j = 0; j <infoSize; j++) {
//					int strInfo = info[j].lastIndexOf(" ");
//					System.out.println("info : " + info[j]);
//
//					if(!query[i].substring(0,strQuery).equals(info[j].substring(0, strInfo)) || Integer.parseInt(query[i].substring(strQuery+1))>Integer.parseInt(info[j].substring(strInfo+1)) ) {
//						continue;
//
//					}
//					count++;
//				}
//
//			}
//
//			answer[i]=count;
//
//		}
//
//
//
//		return answer;
//	}

// ========================== 1 ==============================
//	public int[] solution(String[] info, String[] query) {
//		int[] answer = new int[query.length];
//
//		for(int i = 0; i < info.length; i++) {
//			String[] info_str = info[i].split(" ");
//			mid : for(int j = 0; j < query.length; j++) {
//				String[] query_str = query[j].split(" ");
//				int num = 0;
//				for(int count = 0; count < info_str.length; count++) {
//					if(info_str[count].equals(query_str[num]) || query_str[num].equals("-") ||(num == 7 && Integer.parseInt(info_str[count]) > Integer.parseInt(query_str[num]))) {
//						num = num != 6 ? num+2 : num+1;
//					}else continue mid;
//
//				}
//				answer[j] += 1;
//			}
//		}
//
//		return answer;
//	}
}
