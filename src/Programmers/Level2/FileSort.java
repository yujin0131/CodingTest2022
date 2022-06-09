package Programmers.Level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class FileSort {
	static TreeMap<Integer, String> mapInteger;
	static TreeMap<String, TreeMap> map;

	public static String[] solution(String[] files) {
        String[] answer = {};
        int size = files.length;
        //fileList = new ArrayList<>();
        
        map = new TreeMap<>();
        for(int i = 0; i < size; i++) {
        	split(files[i]);
        	

        }
        
//        Collections.sort(fileList);
//        for(int i = 0; i < fileList.size(); i++) {
//			System.out.print(" fileList : " + fileList.get(i) );
//		}
//        System.out.println();
        return answer;
    }
	
	public static void split(String file) {
		String[] split = file.split("[0-9]+");
		
		boolean tailCheck = split.length == 2 ? true : false;
		String HEAD = split[0].toLowerCase();
		String NUMBER = tailCheck ? file.substring(HEAD.length(), file.indexOf(split[1])) : file.substring(HEAD.length());
		
		//NUMBER = String.valueOf(Integer.parseInt(NUMBER));
		//String add =  HEAD + NUMBER;
		//fileList.add(add);
		//System.out.println("HEAD : " + HEAD);
		//System.out.println("HEAD : " + HEAD + " NUMBER : " + NUMBER );
		//System.out.println();

	}
	public static void main(String[] args) {
		String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
		
		String[] result = solution(files);
		
		for(int i = 0; i < result.length; i++) {
			System.out.print(" result : " + result[i] );
		}
		System.out.println();
		System.out.println(" img1.png IMG01.GIF img02.png img2.JPG img10.png img12.png"  );
	}

/*
 * 	파일명	HEAD	NUMBER	TAIL
	foo9.txt	foo	9	.txt
	foo010bar020.zip	foo	010	bar020.zip
	F-15	F-	15	(빈 문자열
	
	
	입력: ["img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"]
	출력: ["img1.png", "IMG01.GIF", "img02.png", "img2.JPG", "img10.png", "img12.png"]
	
	입력: ["F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"]
	출력: ["A-10 Thunderbolt II", "B-50 Superfortress", "F-5 Freedom Fighter", "F-14 Tomcat"]	
 */
}
