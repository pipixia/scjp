package scjp.levelone;

public class Arrays {
	public static void main(String[] args){
		
	}
	
	private void arrayDefine(){
		int[] arr = new int[5]; //Must put the size, otherwise compile error
		
		// Multidimensional arrays, remember, are simply arrays of arrays.
		// Pass without putting size to second bracket
		// 
		int[ ][ ] myArray = new int[3][ ];
		myArray[0] = new int[2];
		myArray[0][0] = 6;
		myArray[0][1] = 7;
		myArray[1] = new int[3];
		myArray[1][0] = 9;
		myArray[1][1] = 8;
		
		myArray[1][2] = 5;//No need to 
	
		int[] iniArray = {1,2,3,4,5};
		int[][] scores = {{5,2,4,7}, {9,2}, {3,4}};
	}
}
