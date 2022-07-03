package Programmers.Level3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;
//https://programmers.co.kr/learn/courses/30/lessons/17678
public class ShuttleBus {

	String[] busTime;
	boolean nextCrew = false;
	SimpleDateFormat format;
	
	public String solution(int n, int t, int m, String[] timetable) {
		String answer = "";
		Arrays.sort(timetable);
		BusTime(n, t);
		CrewTime(m, timetable);
		

		return answer;
	}

	public void BusTime(int n, int t) {
		busTime = new String[n];
		format = new SimpleDateFormat("HH:mm");
		Calendar cal = Calendar.getInstance();
		Date first;

		try {
			first = format.parse("09:00");
			cal.setTime(first);
			for(int i = 0; i < n; i++) {
				busTime[i] = format.format(cal.getTime());
				System.out.println("busTime : "+ busTime[i]);
				cal.add(Calendar.MINUTE, t);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public void CrewTime(int m, String[] timetable) {
		Queue<String> time = new LinkedList<>();
		int busCnt = 0;

		for(int i = 0; i < timetable.length; i++) {
			try {
				Date bus = format.parse(busTime[busCnt]);
				Date crew = format.parse(timetable[i]);
				
				
				
				if(crew.before(bus)) {
					time.add(timetable[i]);
				}
				
				
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) {
		int n = 10;
		int t = 25;
		int m = 1;
		String[] timetable = {"09:00", "09:10" ,"09:20" ,"09:30" ,"09:40" ,"09:50",
				"10:00", "10:10" ,"10:20" ,"10:30" ,"10:40" ,"10:50"};

		ShuttleBus bus = new ShuttleBus();
		String result = bus.solution(n, t, m, timetable);
		System.out.println("result : " + result);
	}


	/*

		1	1	5	["08:00", "08:01", "08:02", "08:03"]			"09:00"
		2	10	2	["09:10", "09:09", "08:00"]						"09:09"
		2	1	2	["09:00", "09:00", "09:00", "09:00"]			"08:59"
		1	1	5	["00:01", "00:01", "00:01", "00:01", "00:01"]	"00:00"
		1	1	1	["23:59"]	"09:00"
		10	60	45	["23:59","23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"]	"18:00"
		10	25	1	["09:00", "09:10" ,"09:20" ,"09:30" ,"09:40" ,"09:50", "10:00", "10:10" ,"10:20" ,"10:30" ,"10:40" ,"10:50"] "10:29"



	String[] busTime;
	boolean nextCrew = false;
	SimpleDateFormat format;
	
	public String solution(int n, int t, int m, String[] timetable) {
		String answer = "";

		BusTime(n, t);
		Arrays.sort(timetable);

		answer = CrewBus(m, timetable);

		return answer;
	}

	public void BusTime(int n, int t) {
		busTime = new String[n];
		format = new SimpleDateFormat("HH:mm");
		Calendar cal = Calendar.getInstance();
		Date first;

		try {
			first = format.parse("09:00");
			cal.setTime(first);
			for(int i = 0; i < n; i++) {
				busTime[i] = format.format(cal.getTime());
				cal.add(Calendar.MINUTE, t);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public String CrewBus(int m, String[] timetable) {
		int busLength = busTime.length - 1;
		int crewLength = timetable.length - 1;
		Date busnow;
		Date crewnow;
		int crew = 0;
		int bus = 0;
		String answer = "";
		Calendar cal = Calendar.getInstance();
		
		while(crew <= crewLength && bus <= busLength) {

			try {

				busnow = format.parse(busTime[bus]);

				for(int busCnt = 0; busCnt < m; busCnt++) {
					crewnow = format.parse(timetable[crew]);
				
					if(bus==busLength && ( crew == crewLength || busCnt == m -1 )) {
						if(crewnow.after(busnow)) {
							answer = busTime[bus];
							break;
						}else if(crew == crewLength && busCnt == m - 1) {

							cal.setTime(crewnow);
							cal.add(Calendar.MINUTE, -1);
							answer = format.format(cal.getTime());
							break;
						}else {
							if(busCnt == m -1) {
								crewnow = format.parse(timetable[crew]);
								cal.setTime(crewnow);
								cal.add(Calendar.MINUTE, -1);
								answer = format.format(cal.getTime());
								break;
							}else {
								answer = busTime[bus];
								break;
							}
						}
					}
					
					if(crewnow.before(busnow) || crewnow.equals(busnow)) {
						crew++;
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			bus++;

		}
		return answer;
	}





	 */
}
