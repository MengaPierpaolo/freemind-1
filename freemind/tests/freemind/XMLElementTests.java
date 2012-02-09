package tests.freemind;

import freemind.main.XMLElement;
import junit.framework.TestCase;

public class XMLElementTests extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}
	
	public void testAddChild() {
		XMLElement test = new XMLElement();
		XMLElement child1 = new XMLElement();
		
		test.addChild(child1);
		
		assertEquals( test.getChildren().size(), 1 );
	}
	
	public void testAddSeveralChildren() {
		XMLElement test = new XMLElement();
		
		assertEquals( test.getChildren().size(), 0 );
		
		for( int i = 0; i < 5; i++ ) {
			test.addChild( new XMLElement() );
		}
		
		assertEquals( test.getChildren().size(), 5 );
	}

	public void testNoChildren() {
		XMLElement test = new XMLElement();
		
		assertEquals( test.getChildren().size(), 0 );
	}
	
	public void testAddProperty() {
		XMLElement test = new XMLElement();
		Object obj = new Object();
		
		test.addProperty("prop1", obj);
		
		assertNotNull( test.getProperty( "prop1" ) );
	}
	
	public void testGetPropertyFail() {
		XMLElement test = new XMLElement();
		
		assertNull( test.getProperty("prop1") );
	}
	
	public void testGetPropertyWithMultipleProperties() {
		XMLElement test = new XMLElement();
		Object obj1 = new Object();
		Object obj2 = new Object();
		Object obj3 = new Object();
		
		test.addProperty("prop1", obj1);
		test.addProperty("prop2", obj2);
		test.addProperty("prop3", obj3);
		
		assertNotNull( test.getProperty("prop2") );
	}
	
	public void testSetIntPropertyNegative() {
		XMLElement test = new XMLElement();
		test.setIntAttribute("testInt", -45);
		
		assertEquals( test.getIntAttribute("testInt"), -45 );
	}
	
	public void testSetIntPropertyZero() {
		XMLElement test = new XMLElement();
		test.setIntAttribute("testInt", 0);
		
		assertEquals( test.getIntAttribute("testInt"), 0 );
	}
	
	public void testSetIntPropertyPositive() {
		XMLElement test = new XMLElement();
		test.setIntAttribute("testInt", 7000);
		
		assertEquals( test.getIntAttribute("testInt"), 7000 );
	}
	
	public void testCountChildren() {
		XMLElement test = new XMLElement();
		for( int i = 0; i < 100; i++ ) {
			test.addChild( new XMLElement() );
		}
		
		assertEquals( test.countChildren(), 100 );
	}
	
	public void testCountChildrenWithNone() {
		XMLElement test = new XMLElement();
		assertEquals( test.countChildren(), 0 );
	}
	
	public void testGetChildren() {
		XMLElement test = new XMLElement();
		XMLElement first = new XMLElement();
		XMLElement last = new XMLElement();
		
		test.addChild( first );
		for( int i = 0; i < 100; i++ ) {
			test.addChild( new XMLElement() );
		}
		test.addChild( last );
		
		assertEquals( test.getChildren().size(), 102 );
		assertTrue( test.getChildren().get(0) == first );
		assertTrue( test.getChildren().get(101) == last );
	}
	
}
