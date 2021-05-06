
public interface OrderInterface  {

	
	/**
	 * 
	 * @param day the day of the week
	 * @return true if the day is a weekend day (Saturday or Sunday)
	 */
	 public boolean isWeekend();

	/**
	 * returns the beverage listed in the itemNo of the order, for example if
	 * itemNo is 0 this method will return the first beverage in the order
	 * Note: this method returns the shallow copy of the Beverage
	 * 
	 * @return the beverage listed in the itemNo of the order or null if there
	 *         is no item in the order
	 * 
	 */
	 public Beverage getBeverage(int itemNo);
	/**
	 * adds coffee order to this order
	 * @param bevName beverage name
	 * @param size beverage size of type SIZE
	 * @param extraShot true if the coffee beverage has extra shot , false otherwise
	 * @param extraSyrup true if the coffee beverage has extra syrup , false otherwise
	 */
	public void  addNewBeverage(
				String bevName,
				SIZE size,
				boolean extraShot,
				boolean extraSyrup);
	
	/**
	 * adds alcohol order to this order
	 * @param bevName beverage name
	 * @param size beverage size
	 */ 
	public void  addNewBeverage( String bevName,
								SIZE size);
	
	/**
	 * Adds the Smoothie beverage to this order
	 * @param bevName beverage name
	 * @param size beverage size
	 * @param numOfFruits number of fruits added 
	 * @param addPRotien true if protein is added, false otherwise
	 */
	public void  addNewBeverage( String bevName,
				SIZE size,
				int numOfFruits,
				boolean addPRotien);
	
	/**
	 * Calculates and returns the total amount for this order
	 * @return total amount for this order
	 */
	public double calcOrderTotal();
	/**
	 * returns the number of beverages of same type in an order
	 * @param type the type of the beverage
	 * @return number of beverages of type type in this order
	 */
	public int findNumOfBeveType(TYPE type);
}