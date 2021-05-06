import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AlcoholTest {
	Alcohol a1 , a2 ,a3,a4;

	@Before
	public void setUp() throws Exception {
		a1 = new  Alcohol ("A1Name", SIZE.SMALL, false );
		a2 = new  Alcohol ("A2NAme", SIZE.MEDIUM, true );
		a3 = new  Alcohol ("A3NAme", SIZE.LARGE, false );
		a4 = new  Alcohol ("A4NAme", SIZE.SMALL, true );
		
	}

	@After
	public void tearDown() throws Exception {
		a1=a2=a3=a4=null;
	}
	
	@Test
	public void testGetBasePrice()
	{
		assertEquals(2.0,a1.getBasePrice(), .01);
		assertEquals(2.0,a2.getBasePrice(), .01);
		assertEquals(2.0,a3.getBasePrice(), .01);
		assertEquals(2.0,a4.getBasePrice(), .01);
	}
 
	@Test
	public void testCalPrice() {
		
		assertEquals(2,a1.calcPrice(), .01 );
		assertEquals(3.6,a2.calcPrice(), .01 );
		assertEquals(4,a3.calcPrice(), .01 );
		assertEquals(2.6,a4.calcPrice(), .01 );
	}
	@Test
	public void testToString() {
		
		assertTrue(a1.toString().contains(a1.getBevName()));
		assertTrue(a1.toString().contains(String.valueOf(a1.calcPrice()) ));
		assertTrue(a1.toString().contains(a1.getSize().toString() ));
	 
	 
	}
	

}