package scjp.designpattern.decorator;

public class DecoratorPatternDemo {
	   public static void main(String[] args) {

	      Shape circle = new CircleShape();
	      circle.draw();
	      System.out.println();

	      Shape redCircle = new RedBorderShapeDecorator(new CircleShape());
	      redCircle.draw();
	      System.out.println();
	      
	      Shape redRectangle = new RedBorderShapeDecorator(new RectangleShape());
	      redRectangle.draw();
	   }
	}