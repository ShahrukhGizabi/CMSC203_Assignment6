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

import java.util.ArrayList;
import java.util.Collections;

public class BevShop implements BevShopInterface{

	private ArrayList<Order> orders;

	private Order currentOrder;

	private static final int maxAlcohol = 3;

	private static final int minAge = 21;
	public BevShop() {
		orders = new ArrayList<Order>();
	}
	
	public boolean validTime(int time) {
		return (MIN_TIME <= time) && (MAX_TIME >= time);
	}

	
	public boolean eligibleForMore() {
		return getNumOfAlcoholDrink() < maxAlcohol;
	}

	
	public boolean validAge(int age) {
		return age > MIN_AGE_FOR_ALCOHOL;
	}

	@Override
	public void startNewOrder(int time, DAY day, String customerName, int customerAge) {
		currentOrder = new Order(time, day, new  Customer(customerName, customerAge));
		orders.add(currentOrder);	
	}
	@Override
	public void processCoffeeOrder(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) {
		this.currentOrder.addNewBeverage(bevName, size, extraShot, extraSyrup);
	}
	@Override
	public void processAlcoholOrder(String bevName, SIZE size) {
		this.currentOrder.addNewBeverage(bevName, size);		
	}
	@Override
	public void processSmoothieOrder(String bevName, SIZE size, int numOfFruits, boolean addProtien) {
		this.currentOrder.addNewBeverage(bevName, size, numOfFruits, addProtien);
	}
	@Override
	public int findOrder(int orderNo) {
		for(int i = 0; i < orders.size(); i++) {
			if(orders.get(i).getOrderNo() == orderNo) {
				return i; 
			}
		}
		
		return -1;
	}

	@Override
	public double totalOrderPrice(int orderNo) {
		return orders.get(findOrder(orderNo)).calcOrderTotal();
	}

	@Override
	public double totalMonthlySale() {
		double sum = 0;
		for(int i = 0; i < orders.size(); i++) {
			sum+=orders.get(i).calcOrderTotal();
		}
		return sum;
	}
	
	public void sortOrders() {
		for (int i = 0; i < orders.size()-1; i++) {
			int minOrder = i;
			for (int j = i+1; j < orders.size(); j++) {
				if (orders.get(j).getOrderNo() < orders.get(minOrder).getOrderNo()) {
					minOrder = j;
				}
			}

			Order temp = orders.get(minOrder);
			orders.set(minOrder, orders.get(i));
			orders.set(i, temp);
		}
	}
	
	public Order getOrderAtIndex(int index) {
		return orders.get(index);
	}
	
	public String toString() {
		String str = "BEV SHOP\nMONTHLY SALES:" + totalMonthlySale()  +"\n\n";
		for(int i = 0; i < orders.size(); i++) {
			str += "Order " + i + "\n";
			str += orders.get(i).toString();
		}
		return str;
	}

	public Order getCurrentOrder() {
		return this.currentOrder;
	}


	public void setCurrentOrder(Order currentOrder) {
		this.currentOrder = currentOrder;
	}


	public int getNumOfAlcoholDrink() {
		return currentOrder.findNumOfBeveType(TYPE.ALCOHOL);
	}


	public int totalNumOfMonthlyOrders() {
		return orders.size();
	}


	public boolean isMaxFruit(int i) {
		return i>MAX_FRUIT;
	}

	public int getMaxOrderForAlcohol() {
		return minAge;
	}

	public int getMinAgeForAlcohol() {
		return maxAlcohol;
	}
	
	
}