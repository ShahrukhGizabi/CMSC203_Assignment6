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
public class Customer {
	String name;
	int age;
	
	
	public Customer(String name, int age) {
		this.name = name; 
		this.age = age;
	}
	
	public Customer(Customer c1) {
		this.setAge(c1.getAge());
		this.setName(c1.getName());
	}

	

	public void setName(String name) {
		this.name = name; 

	}

	public void setAge(int age) {
		this.age = age;

	}

	public String getName() {
		return this.name;
	}

	public int getAge() {
		return this.age;
	}

}
