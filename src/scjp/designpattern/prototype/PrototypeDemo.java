package scjp.designpattern.prototype;

import java.util.ArrayList;

/*
 * 原型模式的优点及适用场景

使用原型模式创建对象比直接new一个对象在性能上要好的多，因为Object类的clone方法是一个本地方法，它直接操作内存中的二进制流，
特别是复制大对象时，性能的差别非常明显。

使用原型模式的另一个好处是简化对象的创建，使得创建对象就像我们在编辑文档时的复制粘贴一样简单。

因为以上优点，所以在需要重复地创建相似对象时可以考虑使用原型模式。比如需要在一个循环体内创建对象，假如对象创建过程比较复杂
或者循环次数很多的话，使用原型模式不但可以简化创建过程，而且可以使系统的整体性能提高很多。

原型模式的注意事项

    - 使用原型模式复制对象不会调用类的构造方法。因为对象的复制是通过调用Object类的clone方法来完成的，
    	它直接在内存中复制数据，因此不会调用到类的构造方法。不但构造方法中的代码不会执行，甚至连访问权限都对原型模式无效。
    	还记得单例模式吗？单例模式中，只要将构造方法的访问权限设置为private型，就可以实现单例。但是clone方法直接无视
    	构造方法的权限，所以，单例模式与原型模式是冲突的，在使用时要特别注意。
    	
    - 深拷贝与浅拷贝。Object类的clone方法只会拷贝对象中的基本的数据类型，对于数组、容器对象、引用对象等都不会拷贝，
    	这就是浅拷贝。如果要实现深拷贝，必须将原型模式中的数组、容器对象、引用对象等另行拷贝。PS：深拷贝与浅拷贝问题中，
    	会发生深拷贝的有java中的8中基本类型以及他们的封装类型，另外还有String类型。其余的都是浅拷贝。


 * 
 */
public class PrototypeDemo{
	 public static void main(String[] args){
	        ConcretePrototype cp = new ConcretePrototype();
	        for(int i=0; i< 10; i++){
	            ConcretePrototype clonecp = (ConcretePrototype)cp.clone();
	            clonecp.show();
	            clonecp.show2();
	        }
	    }
}

class Prototype implements Cloneable {
	private ArrayList list = new ArrayList();
	
	public void show2(){
        System.out.println("Prototype Show Case");
    }
	
    public Prototype clone(){
        Prototype prototype = null;
        try{
            prototype = (Prototype)super.clone(); //SUPER.CLONE, Shallow Clone
            prototype.list = (ArrayList) this.list.clone(); // Deep Clone
        }catch(CloneNotSupportedException e){
            e.printStackTrace();
        }
        return prototype;
    }
}

class ConcretePrototype extends Prototype{
    public void show(){
        System.out.println("Concrete Prototype Show Case");
    }
}
