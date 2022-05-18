package Programmers.Level2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.TreeMap;

public class KakaoParkingFee {
	
	static TreeMap<String, String[]> map;
	static HashMap<String, Integer> mapCheck;
	
    public static int[] solution(int[] fees, String[] records) {
    	
    	int fee = fees[0];
    	map = new TreeMap<>();
    	mapCheck = new HashMap<>();
    	recordSpilt(records);
    	if (mapCheck.size() > 0 ) noOut();

    	

        
        
        return ParkingFee(fees);
    }
    
    public static int[] ParkingFee(int[] fees) {
    	int[] result = new int[map.size()];
    	
        //180, 5000, 10, 600
        int baseTime = fees[0];
        int baseFee = fees[1];
        int addTime = fees[2];
        int addFee = fees[3];
        
        int cnt = 0;
    	for (String key : map.keySet()) {
    		System.out.println("key " + key + " value " + map.get(key)[1]);
    		int sumTime = Integer.parseInt(map.get(key)[1]);
    		
    		System.out.println("sumTime : " + sumTime); 
    		System.out.println((sumTime - baseTime) / addTime);
    		int ceil = (sumTime - baseTime) % addTime !=0 ? 1 : 0;
    		System.out.println("ddddddddddddddddddd:" + ((sumTime - baseTime) / addTime + ceil));
    		int sumFee = sumTime - baseTime  <= 0 ? baseFee : baseFee +( (sumTime - baseTime) / addTime + ceil )* addFee ;
    		System.out.println("sumFee : " +sumFee);
    		result[cnt++] = sumFee;
    		}
    	
    	return result; 	
    }
    public static void noOut() {
    	System.out.println("mapCheck size : "  + mapCheck.size());
    	for (String key : mapCheck.keySet()) {
    		carOut("23:59", key);
    		}

    }
    
    public static void recordSpilt(String[] records) {
    	
    	
    	int size = records.length;
    	
    	for(int i = 0; i < size; i++) {
    		String[] spilt = records[i].split(" ");
    		String timeIO = spilt[0];
    		String carNumber = spilt[1];
    		String checkIO = spilt[2];
    		System.out.println("carNumber : " + carNumber + " timeIO : " + timeIO);
    		if(checkIO.equals("IN")) carIn(timeIO, carNumber);
    		else {
    			carOut(timeIO, carNumber);
    			mapCheck.remove(carNumber);
    		}
    	}
    	
    	
    }
    
    public static void carIn(String timeIO, String carNumber) {
    	System.out.println("carIn");
    	mapCheck.put(carNumber, 1);
    	String[] timeList = new String[2];
    	if(map.containsKey(carNumber)) {
    		timeList[0] = timeIO;
    		timeList[1] = map.get(carNumber)[1];
    		map.put(carNumber, timeList);
    		System.out.println("catIn yes :" + timeList[0] + " " + timeList[1]);
    		System.out.println("map.get[1] : " + map.get(carNumber)[1]);
    		System.out.println(carNumber + " num : " + map.get(carNumber)[0]);
    	}else {
    		timeList[0] = timeIO;
    		timeList[1] = "0";
    		System.out.println("catIn no :" + timeList[0] + " " + timeList[1]);
    		map.put(carNumber, timeList);
    		System.out.println(carNumber + " num : " + map.get(carNumber)[0]);
    		System.out.println("????????????????????????" +  map.get("5961")[0] + " " + carNumber );
    	}
    }
    
    public static void carOut(String timeIO, String carNumber) {
    	
    	String[] timeList = new String[2];
    	System.out.println("carOut     : 	" + map.get("5961")[0] );
    	
    	int timeSum = Integer.parseInt(map.get(carNumber)[1]);
    	SimpleDateFormat f = new SimpleDateFormat("HH:mm");
		try {
			System.out.println(carNumber + " num : " + map.get(carNumber)[0]);
			Date timeIn = f.parse(map.get(carNumber)[0]);
			Date timeOut = f.parse(timeIO);
			System.out.println("out " + timeOut + " in " + timeIn);
			System.out.println("out " + timeOut.getTime() + " in " + timeIn.getTime());
			System.out.println((timeOut.getTime() - timeIn.getTime()) / 60000);
			long diffMin = (timeOut.getTime() - timeIn.getTime()) / 60000;
			System.out.println("diffMin : " + diffMin);
			
			timeSum += diffMin;
			timeList[1] = Integer.toString(timeSum);
			System.out.println("carout no :" + timeList[0] + " " + timeList[1]);
			map.put(carNumber, timeList);
		} catch (ParseException e) {
			e.printStackTrace();
		}
    }
    //https://programmers.co.kr/learn/courses/30/lessons/92341
    public static void main(String[] args) {
		
    	int[] fees = {180, 5000, 10, 600};
    	String[] records = {"05:34 5961 IN", "06:34 5961 OUT", "07:34 5961 IN", "08:34 5961 OUT", "09:34 5961 IN", "10:34 5961 OUT", "11:34 5961 IN", "12:34 5961 OUT"};
    	int[] result = solution(fees, records);
    	
    	for(int i = 0; i < result.length; i++) {
    		System.out.print(result[i] + " ");
    	}
	}
    
    /*
     *	 fees	records	result
		[180, 5000, 10, 600]	["05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"]	[14600, 34400, 5000]
		[120, 0, 60, 591]	["16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"]	[0, 591]
		[1, 461, 1, 10]	["00:00 1234 IN"]	[14841]
     */
}
