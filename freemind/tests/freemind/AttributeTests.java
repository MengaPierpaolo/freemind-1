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

}
