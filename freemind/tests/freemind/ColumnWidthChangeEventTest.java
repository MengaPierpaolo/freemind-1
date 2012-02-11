package tests.freemind;

import freemind.modes.attributes.ColumnWidthChangeEvent;

public class ColumnWidthChangeEventTest extends FreeMindTestBase {
	
	ColumnWidthChangeEvent event;
	
	protected void setUp() throws Exception {
		super.setUp();
	}
	
	public void testGetCol() {
		event = new ColumnWidthChangeEvent(new Object(), 1);
		assertEquals(event.getColumnNumber(), 1);
	}

}
