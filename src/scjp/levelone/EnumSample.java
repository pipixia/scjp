package scjp.levelone;

//Enum organized with interface
interface Food {
    enum Coffee implements Food {
        BLACK_COFFEE, DECAF_COFFEE, LATTE, CAPPUCCINO
    }

    enum Dessert implements Food {
        FRUIT, CAKE, GELATO
    }
    
    enum Rice{
    	
    	DAMI("dami",1),	
    	XIAOMI("xiaomi",2),
    	XIMI("ximi",3);
    	
    	private String name;
    	private int price;
    	
    	Rice(String name, int price){
    		this.name= name;
    		this.price = price;
    	}
    	
    	public String getNameNPrice(){
    		return name + ":" + price;
    	}
    }
}



public class EnumSample{
	public static void main(String[] args){
		System.out.println(Food.Coffee.BLACK_COFFEE);
		
		System.out.println(Food.Rice.DAMI.getNameNPrice());
	}
}