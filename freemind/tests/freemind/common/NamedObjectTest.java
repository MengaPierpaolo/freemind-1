package tests.freemind.common;

import freemind.common.NamedObject;
import junit.framework.TestCase;

public class NamedObjectTest extends TestCase {

	NamedObject named;
	Object obj;
	String name;
	
	protected void setUp() throws Exception {
		super.setUp();
		obj = new Object();
		name = "Named";
		named = new NamedObject( obj, name );
	}

	
	/**
	 * Tests the string output
	 */
	public void testToString(){
		assertEquals( name, named.toString() );
	}
	
	
	/**
	 * Tests that the object can be retrieved
	 */
	public void testGetObject(){
		assertSame( obj, named.getObject() );
	}
	
	
	/**
	 * Tests that a literal object can be created
	 */
	public void testLiteral(){
		NamedObject named = NamedObject.literal( "value" );
		assertEquals( "value", named.toString() );
		assertEquals( "value", named.getObject() );
	}
	
	
	/**
	 * Tests equality
	 */
	public void testEquals_SameObject(){
		assertTrue( named.equals( named ) );
	}
	
	
	/**
	 * Tests equality
	 */
	public void testEquals_SameData(){
		assertTrue( named.equals( new NamedObject( obj, name) ) );
	}

	
	/**
	 * Tests equality
	 */
	public void testEquals_DifferentData(){
		assertFalse( named.equals( new NamedObject( new Object(), "other" ) ) );
	}

	
	/**
	 * Tests equality
	 */
	public void testEquals_DifferentObject(){
		assertFalse( named.equals( new Object() ) );
	}
	
	
}
