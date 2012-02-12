package tests.freemind;

import freemind.common.StringProperty;
import freemind.modes.attributes.Attribute;
import junit.framework.TestCase;

public class AttributeTests extends TestCase {

	Attribute att = new Attribute("testName", "testValue");
	
	protected void setUp() throws Exception {
		super.setUp();
	}
	
	public void testGetName() {
		assertEquals( "testName", att.getName() );
	}
	
	public void testGetValue() {
		assertEquals( "testValue", att.getValue() );
	}
	
	public void testSetName() {
		att.setName("derp");
		assertEquals("derp", att.getName());
	}
	
	public void testSetValue() {
		att.setValue("derp");
		assertEquals("derp", att.getValue());
	}
	
	public void testConstructor() {
		Attribute att2 = new Attribute("foo");
		assertEquals("foo", att2.getName());
		assertEquals("", att2.getValue());
	}
	
	public void testToString() {
		assertEquals("[testName, testValue]", att.toString());
	}

}
