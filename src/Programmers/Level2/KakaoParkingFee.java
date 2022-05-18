package Programmers.Level2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.TreeMap;
//https://programmers.co.kr/learn/courses/30/lessons/92341

public class KakaoParkingFee {
	
	static TreeMap<String, String[]> map;
	static HashMap<String, Integer> mapCheck;
	
    public static int[] solution(int[] fees, String[] records) {
    	
    	map = new TreeMap<>();
    	mapCheck = new HashMap<>();
    	
    	recordSpilt(records);
    	
    	if (mapCheck.size() > 0 ) noOut();

        return ParkingFee(fees);
    }
    
    public static void recordSpilt(String[] records) { // 문제 분할
    	
    	int size = records.length;
    	
    	for(int i = 0; i < size; i++) {
    		String[] spilt = records[i].split(" ");
    		String timeIO = spilt[0];
    		String carNumber = spilt[1];
    		String checkIO = spilt[2];
    		
    		if(checkIO.equals("IN")) 
    			carIn(timeIO, carNumber);
    		else {
    			carOut(timeIO, carNumber);
    			mapCheck.remove(carNumber); // carOut 에서 remove시 mapCheck.keySet() 에서 연속성 오류. 여기서 remove 한다.
    		}
    	}
    	
    }

    public static void carIn(String timeIO, String carNumber) { // 차 들어올 때
    	
    	mapCheck.put(carNumber, 1);
    	String[] timeList = new String[2];
    	
    	if(map.containsKey(carNumber)) { // 들어온 적 있을 떄
    		timeList[0] = timeIO;
    		timeList[1] = map.get(carNumber)[1];
    		map.put(carNumber, timeList);
    		
    	}else { // 처음 들어올 때
    		timeList[0] = timeIO;
    		timeList[1] = "0";
    		map.put(carNumber, timeList);
  
    	}
    }
    
    public static void carOut(String timeIO, String carNumber) { // 차 나갈 때
    	
    	String[] timeList = new String[2];    	
    	int timeSum = Integer.parseInt(map.get(carNumber)[1]);
    	SimpleDateFormat f = new SimpleDateFormat("HH:mm");
    	
		try {
			Date timeIn = f.parse(map.get(carNumber)[0]);
			Date timeOut = f.parse(timeIO);
			long diffMin = (timeOut.getTime() - timeIn.getTime()) / 60000;
			
			timeSum += diffMin;
			timeList[1] = Integer.toString(timeSum);
			map.put(carNumber, timeList);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
    }
    
    public static void noOut() { // 나간 시간 없을 때
    	
    	for (String key : mapCheck.keySet())
    		carOut("23:59", key);

    }
    
    public static int[] ParkingFee(int[] fees) { // 요금 계산
    	int[] result = new int[map.size()];
    	
        int baseTime = fees[0];
        int baseFee = fees[1];
        int addTime = fees[2];
        int addFee = fees[3];
        
        int cnt = 0;
    	for (String key : map.keySet()) {
    		
    		int sumTime = Integer.parseInt(map.get(key)[1]);
    		int ceil = (sumTime - baseTime) % addTime !=0 ? 1 : 0; // 반올림 계산
    		int sumFee = sumTime - baseTime  <= 0 ? baseFee : baseFee +( (sumTime - baseTime) / addTime + ceil ) * addFee ;

    		result[cnt++] = sumFee;
    		}
    	
    	return result; 	
    }

    public static void main(String[] args) {
		
    	int[] fees = {180, 5000, 10, 600};
    	String[] records = {"05:34 5961 IN", "06:34 5961 OUT", "07:34 5961 IN", "08:34 5961 OUT", "09:34 5961 IN", "10:34 5961 OUT", "11:34 5961 IN", "12:34 5961 OUT"};
    	int[] result = solution(fees, records);
    	
    	for(int i = 0; i < result.length; i++) {
    		System.out.print(result[i] + " ");
    	}
	}

}
