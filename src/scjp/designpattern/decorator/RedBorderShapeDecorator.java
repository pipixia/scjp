package scjp.designpattern.decorator;

public class RedBorderShapeDecorator extends AbstractShapeDecorator {
	   //protected Shape decoratedShape; Here shouldn't have this line, otherwise null pointer exception when call draw

	   public RedBorderShapeDecorator(Shape decoratedShape){
	      super(decoratedShape);
	   }

	   public void draw(){
	      decoratedShape.draw();
	      setRedBorder();
	   }	
	   
	   //Extra decoration behavior
	   public void setRedBorder(){
		   System.out.println(" with a red border");
	   }
	}
