package tests.freemind;

import freemind.controller.filter.util.SortedMapListModel;
import freemind.main.XMLElement;
import junit.framework.TestCase;

public class SortedMapListModelTests extends TestCase {

	SortedMapListModel model;
	
	protected void setUp() throws Exception {
		super.setUp();
		model = new SortedMapListModel();
	}

	public void testAddElement() {
		model.add( new String("test1") );
		assertEquals(model.getSize(), 1);
	}
	
	public void testAddTwoElements() {
		model.add( new String( "test1" ) );
		model.add( new String( "test2" ) );
		assertEquals( model.getSize(), 2 );
	}
	
	public void testAddThreeElements() {
		model.add( new String( "test1" ) );
		model.add( new String( "test2" ) );
		model.add( new String( "test3" ) );
		assertEquals( model.getSize(), 3 );
	}
	
	public void testContains() {
		String obj = new String( "test" );
		model.add( obj );
		assertTrue( model.contains( obj ) );
	}
	
	public void testContainsFalse() {
		String obj = new String( "test" );
		String obj2 = new String( "test2" );
		model.add(obj);
		assertFalse( model.contains(obj2) );
	}
	
	public void testGetElementAt() {
		String obj1 = new String( "test1" );
		String obj2 = new String( "test2" );
		String obj3 = new String( "test3" );
		String obj4 = new String( "test4" );
		String obj5 = new String( "test5" );
		
		model.add( obj5 );
		model.add( obj3 );
		model.add( obj2 );
		model.add( obj1 );
		model.add( obj4 );
		
		assertTrue( model.getElementAt(2).toString().equals( "test3" ) );
	}
	
/*	
 *    Just throws and exception(?). Fix later.
 
   public void testGetElementAtEmpty() {
		System.out.println( "Test: " + model.getElementAt(10) );
		assertNull( model.getElementAt(10) );
	}
*/
	
	public void testAddAll() {
		String obj1 = new String( "test1" );
		String obj2 = new String( "test2" );
		String obj3 = new String( "test3" );
		String obj4 = new String( "test4" );
		String obj5 = new String( "test5" );
		
		String[] list = { obj1, obj2, obj3, obj4, obj5 };
		model.addAll(list);
		assertEquals(model.getSize(),5);
	}
	
	public void testAddAllEmpty() {
		Object[] list = { };
		model.addAll(list);
		assertEquals(model.getSize(), 0);
	}
	
	public void testClear() {
		model.add(new String( "one" ) );
		model.add(new String( "two" ) );
		model.add( new String( "three" ) );
		model.clear();
		assertEquals(model.getSize(), 0);
	}
	
	public void testFirstElement() {
		String obj1 = new String( "test1" );
		String obj2 = new String( "test2" );
		String obj3 = new String( "test3" );
		String obj4 = new String( "test4" );
		String obj5 = new String( "test5" );
		
		model.add( obj5 );
		model.add( obj3 );
		model.add( obj2 );
		model.add( obj1 );
		model.add( obj4 );
		
		assertTrue(model.firstElement().toString().equals( "test1" ));
	}
	
	public void testLastElement() {
		String obj1 = new String( "test1" );
		String obj2 = new String( "test2" );
		String obj3 = new String( "test3" );
		String obj4 = new String( "test4" );
		String obj5 = new String( "test5" );
		
		model.add( obj5 );
		model.add( obj3 );
		model.add( obj2 );
		model.add( obj1 );
		model.add( obj4 );
		
		assertTrue(model.lastElement().toString().equals( "test5" ));
	}
	
	public void testGetIndexOfMiddle() {
		String obj1 = new String( "test1" );
		String obj2 = new String( "test2" );
		String obj3 = new String( "test3" );
		String obj4 = new String( "test4" );
		String obj5 = new String( "test5" );
		
		model.add( obj5 );
		model.add( obj3 );
		model.add( obj2 );
		model.add( obj1 );
		model.add( obj4 );
		
		assertEquals( model.getIndexOf( obj3 ), 2 );
	}
	
	public void testGetIndexOfFirst() {
		String obj1 = new String( "test1" );
		String obj2 = new String( "test2" );
		String obj3 = new String( "test3" );
		String obj4 = new String( "test4" );
		String obj5 = new String( "test5" );
		
		model.add( obj5 );
		model.add( obj3 );
		model.add( obj2 );
		model.add( obj1 );
		model.add( obj4 );
		
		assertEquals( model.getIndexOf( obj1 ), 0 );
	}
	
	public void testGetIndexOfLast() {
		String obj1 = new String( "test1" );
		String obj2 = new String( "test2" );
		String obj3 = new String( "test3" );
		String obj4 = new String( "test4" );
		String obj5 = new String( "test5" );
		
		model.add( obj5 );
		model.add( obj3 );
		model.add( obj2 );
		model.add( obj1 );
		model.add( obj4 );
		
		assertEquals( model.getIndexOf( obj5 ), 4 );
	}
}
