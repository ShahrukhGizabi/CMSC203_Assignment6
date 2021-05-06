/*
 * Class: CMSC203 
 * Instructor: Grigoriy Grinberg
 * Description: The BevShop offers 3 types of beverages: Coffee, Alcoholic and Smoothie. Beverages can be ordered in 3 different sizes: Small, medium and large. All the beverage types have a base price. In addition there are additional charges depending on the size and specific add-ons for each type of beverage.
 * Due: 5/2/2021
 * Platform/compiler: eclipse
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Shahrukh Gizabi
 */
public class Coffee extends Beverage{
	boolean extraShot; 
	boolean extraSyrup; 
	String name; 
	SIZE size;
	TYPE type = TYPE.COFFEE;

	public Coffee(String name, SIZE size, boolean extra_shot, boolean extra_syrup) {
		super(name, TYPE.COFFEE, size);
		this.extraShot = extra_shot;
		this.extraSyrup = extra_syrup; 
		this.name = name;
		this.size = size; 

	}
	
	
	public double getBasePrice() {
		return super.BASE_PRICE;
	}
	
	public String toString() {
		String extra =  "";
		if(extraShot) {
			extra +="Extra shot";
		}if(extraSyrup) {
			extra+="Extra syrup";
		}else {
			extra+="Nothing";
		}
		return "Name : " + this.name + " Size : " + this.size + " Contains : "+extra+" Price : " + this.calcPrice();
	}
	public double calcPrice(){
		double price = super.calcPrice();
		int count = 0; 
		if(extraSyrup) {
			count++; 
		}if(extraShot) {
			count++;
		}
		return price+((0.50)*count);
	}
	public String getBevName() {
		return this.name;
	}

	public SIZE getSize() {

		return this.size;
	}

	public TYPE getType() {

		return this.type;
	}


	public boolean getExtraShot() {


		return extraShot;
	}


	public boolean getExtraSyrup() {

		return extraSyrup;
	}



	

}
