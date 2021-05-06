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
public class Smoothie extends Beverage{
	int fruits; 
	boolean protein;
	public static final TYPE type = TYPE.SMOOTHIE;
	public Smoothie(String name, SIZE size, int numFruits, boolean protein) {
		super(name,type,size);
		this.protein = protein;
		this.fruits=numFruits;

	}
	public String toString() {
		String coffee  = super.toString();
		coffee+=" "+" Fruit count : "+ this.fruits+ " Has protein" + this.protein+ " Price: "+ this.calcPrice();
		return coffee;
	}
	public boolean equals(Smoothie beverage) {
		boolean equals  = false; 
		if(super.equals(beverage)) {
			if((this.fruits==beverage.getNumOfFruits())&&this.protein==beverage.protein) {
				equals = true;
			}
		}
		else
		{
			equals = false;
		}
		return equals;
	}
	public double getBasePrice() {
		return super.BASE_PRICE;
	}

	public double calcPrice() {
		double price = super.calcPrice();
		if(protein) {
			price = price + 1.50;
		}
		price+=(0.50)*(fruits);
		return price;
	}

	public String getBevName() {
		return this.getName();
	}

	public SIZE getSize() {
		return this.size;
	}

	public int getNumOfFruits() {
		return this.fruits;
	}
	public boolean getAddProtien() {

		return protein;
	}

}
