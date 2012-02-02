package tests.freemind;

import freemind.common.NamedObject;

public class NamedObjectTest extends FreeMindTestBase {
	
	protected void setUp() throws Exception {
		super.setUp();
		
	}
	
	public void testConstructor() {
		Object testing = new Object();
		NamedObject obj = new NamedObject(testing, "Hey");
		assertEquals(testing, obj.getObject());
		assertEquals("Hey", obj.toString());
	}
	
	public void testLiteral() {
		NamedObject object = NamedObject.literal("Sup");
		assertEquals(object.getObject(), "Sup");
		assertEquals(object.toString(), "Sup");
	}
	
	public void testEqual() {
		Object testing = new Object();
		NamedObject obj = new NamedObject(testing, "Hi");
		assertTrue(obj.equals(obj));
		assertTrue(obj.equals(testing));
		assertFalse(obj.equals("..."));
	}
	
	
}
