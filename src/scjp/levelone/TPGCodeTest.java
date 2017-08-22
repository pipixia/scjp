package scjp.levelone;

import java.io.*;
import java.util.*;
/**
 *
 * @author 
 */
public class TPGCodeTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        start();
    }
    public static void start(){
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.println("qustion number?(1 or 2 or 3) exit type e");
        System.out.println("1.reverse");
        System.out.println("2.shuffle");
        System.out.println("3.find median");
        String input;
        while(!(input = reader.nextLine()).equals("")){
	        if(input.equals("1")){
	            System.out.println("type the text you want to reverse");
	            String toReverse = reader.nextLine();
	            System.out.println(reverse(toReverse));
	        }else if (input.equals("2")) {
	            System.out.println("type the text you want to shuffle");
	            String toReverse = reader.nextLine();
	            System.out.println(shuffle(toReverse));
	        }else if (input.equals("3")) {
	            System.out.println("type the int array you want to find median example:0 1 2 3 4 5 6");
	            int inputInt=0;
	            int count=0;
	            int[] intArray;
	            String inputIntArr;
	            inputIntArr = reader.nextLine();
	            String[] splitInts = inputIntArr.split(" ");
	            findMedian(splitInts);
	        }
        }
    }
    public static String reverse(String inputStr){
    StringBuilder input = new StringBuilder(inputStr);
    String output = input.reverse().toString();
    return output;
    
    }
    public static String shuffle(String inputStr){
    List<String> letterList= Arrays.asList(inputStr.split(""));
    Collections.shuffle(letterList);
    String result = "";
    for(String letter: letterList) {
        result = result+letter;
    }
    return result;
    }
    public static void findMedian(String[] strArr){
        int[] arr = new int[strArr.length];
        int index=0;
        for(String strNo : strArr){
  
            arr[index] = Integer.parseInt(strNo);
            index++;
        }
    Arrays.sort(arr);
        System.out.println("the median value is:");
        if(arr.length%2==0){
            System.out.println(arr[arr.length/2]);
            System.out.println(arr[arr.length/2-1]);
        }else{
            System.out.println(arr[arr.length/2]);
        }
    }
    
}