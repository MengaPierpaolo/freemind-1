package tests.freemind;

import freemind.controller.BlindIcon;

public class BlindIconTest extends FreeMindTestBase {
	
	private BlindIcon icon;

	protected void setUp() throws Exception {
		super.setUp();
		
		///
		/// make the object
		///
		this.icon = new BlindIcon(1);
		
	}
	
	public void testGetIconHeight() {
		assertEquals(1, this.icon.getIconHeight());
	}
	
	public void testGetIconWidth() {
		assertEquals(1, this.icon.getIconWidth());
	}
	
	public void testPaintIcon() {
		this.icon.paintIcon(null, null, 0, 0);
		assertTrue(true);
	}
}
