import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OrderTest {

	Order r1,r2,r3,r4;
	@Before
	public void setUp() throws Exception {
		r1 = new Order (8, DAY.MONDAY, new Customer ("Mary", 22));
		r2 = new Order (12, DAY.SATURDAY, new Customer ("John", 45));
		r3 = new Order (10, DAY.SUNDAY, new Customer ("Kate", 21));
	}

	@After
	public void tearDown() throws Exception {
		r1=r2=r3=null;
	}
	
	@Test 
	public void testGetBeverage( )
	{
		Coffee cf = new Coffee("regular Coffee", SIZE.SMALL, false,false);
		Alcohol al = new Alcohol ("Mohito", SIZE.SMALL, false);
		Smoothie sm1 = new Smoothie("Detox", SIZE.MEDIUM,1,false);
		Smoothie sm2 = new Smoothie("Detox", SIZE.LARGE,1,false);
		
		r1.addNewBeverage("regular Coffee", SIZE.SMALL, false,false);
		r1.addNewBeverage("Mohito", SIZE.SMALL); 
		r1.addNewBeverage("Detox", SIZE.MEDIUM,1,false); 
		assertTrue(r1.getBeverage(0).equals(cf) );
		assertTrue(r1.getBeverage(1).equals(al) );
		assertTrue(r1.getBeverage(2).equals(sm1) );
		assertFalse(r1.getBeverage(2).equals(sm2) );
	}

	@Test
	public void testAddNewBeverage() throws NullPointerException   {
		
		assertTrue(r1.getTotalItems() == 0);
		r1.addNewBeverage("regular Coffee", SIZE.SMALL, false,false);
	 	assertTrue(r1.getBeverage(0).getType().equals(TYPE.COFFEE));
		r1.addNewBeverage("Mohito", SIZE.SMALL); 
		assertTrue(r1.getBeverage(1).getType().equals(TYPE.ALCOHOL));
		r1.addNewBeverage("Detox", SIZE.MEDIUM,1,false); 
		assertTrue(r1.getBeverage(2).getType().equals(TYPE.SMOOTHIE));
		assertTrue(r1.getTotalItems() == 3);
		
		r2.addNewBeverage("Detox", SIZE.MEDIUM,4,true); 
		assertTrue(r2.getBeverage(0).getType().equals(TYPE.SMOOTHIE));
		r2.addNewBeverage("Mohito", SIZE.SMALL); 
		assertTrue(r2.getBeverage(1).getType().equals(TYPE.ALCOHOL));
		r2.addNewBeverage("regular Coffee", SIZE.MEDIUM, true,false);
		assertTrue(r2.getBeverage(2).getType().equals(TYPE.COFFEE));
		assertTrue(r2.getTotalItems() == 3);
		 
	}
	 
	@Test
	public void testisWeekend()   {
		
		assertFalse(r1.isWeekend());
		assertTrue(r2.isWeekend());
		assertTrue(r3.isWeekend());
		 
	}
	
	@Test
	public void testCalcOrderTotal()   {
		r1.addNewBeverage("regular Coffee", SIZE.SMALL, false,false);
	 	r1.addNewBeverage("Mohito", SIZE.SMALL); 
		r1.addNewBeverage("Detox", SIZE.MEDIUM,1,false); 
	 
		assertEquals(7.5,r1.calcOrderTotal(),.01);
		
		r2.addNewBeverage("regular Coffee", SIZE.MEDIUM, true,false);
	 	r2.addNewBeverage("Mohito", SIZE.SMALL); 
		r2.addNewBeverage("Detox", SIZE.MEDIUM,4,true); 
		
		assertEquals(12.6,r2.calcOrderTotal(),.01);
		 
	}
	
	@Test
	public void testFindNumOfBeveType()
	{
		r1.addNewBeverage("regular Coffee", SIZE.SMALL, false,false);
	 	r1.addNewBeverage("Mohito", SIZE.SMALL); 
		r1.addNewBeverage("Detox", SIZE.MEDIUM,1,false); 
		r1.addNewBeverage("French Hazelnut", SIZE.LARGE, true,true);
		assertEquals(2, r1.findNumOfBeveType(TYPE.COFFEE));
		assertEquals(1, r1.findNumOfBeveType(TYPE.SMOOTHIE));
		assertEquals(1, r1.findNumOfBeveType(TYPE.ALCOHOL));
		
		r2.addNewBeverage("regular Coffee", SIZE.MEDIUM, true,false);
	 	r2.addNewBeverage("Mohito", SIZE.SMALL); 
	 	assertEquals(0, r2.findNumOfBeveType(TYPE.SMOOTHIE));
	}
	@Test
	public void testToString() {
		
		r1.addNewBeverage("regular Coffee", SIZE.SMALL, false,false);
	 	r1.addNewBeverage("Mohito", SIZE.LARGE); 
		 
		assertTrue(r1.toString().contains( String.valueOf(r1.getOrderNo()) ));
		assertTrue(r1.toString().contains( r1.getCustomer().getName()) );
		assertTrue(r1.toString().contains(r1.getBeverage(0).getSize().toString()) )  ;
		assertTrue(r1.toString().contains(r1.getBeverage(0).getBevName()) );
		
	 	 
		assertTrue(r1.toString().contains(r1.getBeverage(1).getSize().toString()) )  ;
		assertTrue(r1.toString().contains(r1.getBeverage(1).getBevName()) );
		assertTrue(r1.toString().contains( String.valueOf(r1.getBeverage(1).calcPrice()) ));
		
		assertTrue(r1.toString().contains( String.valueOf(r1.calcOrderTotal() )  ));
		 
	 
	 
	}

}