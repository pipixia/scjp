package scjp.levelone;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializationTest {
	
	public static void main(String[] args){
		Outer o1 = new Outer();
		o1.staticField = "Static Outer 1";
		o1.inner = new Inner("Inter 1", "ABC");
		Outer o2 = o1.myclone();
		
		System.out.println("Inner Name - " +  o2.inner.name);//Inner 1
		System.out.println("Inner Password - " + o2.inner.password);//Null, Password not set due to transient

		System.out.println("Static Field - " + o2.staticField);//All instances share the same staic filed
	}
}

class Outer implements Serializable{
	  private static final long serialVersionUID = 369285298572941L;
	  public Inner inner;
	  public static String staticField;

	  public Outer myclone() {
	      Outer outer = null;
	      try {
	          ByteArrayOutputStream baos = new ByteArrayOutputStream();
	          ObjectOutputStream oos = new ObjectOutputStream(baos);
	          oos.writeObject(this);

	          ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
	          ObjectInputStream ois = new ObjectInputStream(bais);
	          outer = (Outer) ois.readObject();
	      } catch (IOException e) {
	          e.printStackTrace();
	      } catch (ClassNotFoundException e) {
	          e.printStackTrace();
	      }
	      return outer;
	  }
	}

class Inner implements Serializable{
	  private static final long serialVersionUID = 872390113109L;
	  public String name = "";
	  public transient String password;//Password is transient, value will no be serialized

	  public Inner(String name, String password) {
	      this.name = name;
	      this.password = password;
	  }

	  @Override
	  public String toString() {
	      return "Inner Name - " + name;
	  }
	}