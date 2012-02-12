package tests.freemind;

import freemind.modes.MindIcon;

public class MindIconTest extends FreeMindTestBase {
	
	MindIcon icon;
	
	protected void setUp() throws Exception {
		super.setUp();
		
		icon = MindIcon.factory("iconName");
		
	}

	public void testToString() {
		assertEquals("Icon_name: iconName", icon.toString());
	}
	
	public void testGetName() {
		assertEquals("iconName", icon.getName());
		icon.setName(null);
		assertEquals("notfound", icon.getName());
	}
}
