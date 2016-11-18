package scjp.levelone;

public class Variables {
	private int fieldInt1; //field variable can has default value, int is 0
	private int fieldInt2;
	public void add(int y){
		int justLocalVariable = 5; //local variable MUST be initialized, NO defulat value 
		System.out.println(y);
	}
	public static void main(String[] args){
		Variables v = new Variables();
		
		System.out.println("FieldInt = "  + v.fieldInt1++ + ", " + (++ v.fieldInt2)); //FieldInt = 0, 1
		
		int m = 1;
		int x = m++; // equals to x = m, m=m+1;
		
		v.add(x++); v.add(++x);//1 3
		
		m = 1;
		x = ++m; // equals to m=m+1, x=m;
		v.add(x++); v.add(++x);//2 4
	}
}
