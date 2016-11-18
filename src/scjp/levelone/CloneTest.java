package scjp.levelone;

import java.util.Arrays;

public class CloneTest {
	public static void main(String[] args){
		A a1=new A();  
		a1.name="a1";  
		a1.password = "AAA111";

		String[] h1 = new String[]{"Football","Basketball"};
		a1.habit = h1;
		
		A a2= (A) a1.clone(); 
		a2.name="a2";  
		//a2.password = "AAA222";
		a2.habit[0] = "Drinking";
		a2.habit[1] = "Sleeping";
		
		//Arrays.deepToString(array1) is to show all items in array with ','
		System.out.println("a1.name="+a1.name + ", a1.age="+a1.age + ", a1.habit=" + ", a1.password="+a1.password + ", a1.habit=" + a1.habit + " : " + Arrays.deepToString(a1.habit));  
		System.out.println("a2.name="+a2.name + ", a2.age="+a2.age + ", a2.habit=" + ", a2.password="+a2.password + ", a1.habit=" + a2.habit + " : " + Arrays.deepToString(a2.habit));  
		// a1.name=a1, a1.habit=[Ljava.lang.String;@15db9742 : [Drinking, Sleeping]
		// a2.name=a2, a2.habit=[Ljava.lang.String;@15db9742 : [Drinking, Sleeping]
		// We can see clone failed because a1.habit, a2.habt pointing to same object.
		// Transient field nothing to do with Clone, but it is related to Serialization
		
	}
}

class A implements Cloneable {  
    public String name; 
    public String[] habit;
    public final int age = 10;
    
    //Still can be Clone
    public transient String password;
  
    public Object clone() {  
        A o = null;  
        try {  
        	//Shallow Clone
            o = (A) super.clone(); 
 
            //Deep Clone. Extra steps to clone filed variables because only reference are copied if not primitive type or String 
            o.habit = this.habit.clone();
            
        } catch (CloneNotSupportedException e) {  
            e.printStackTrace();  
        }  
        return o;  
    }  
  
}  
