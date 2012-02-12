package tests.freemind;

import javax.swing.ImageIcon;

import freemind.modes.MindIcon;

public class MindIconTest extends FreeMindTestBase {
	
	MindIcon icon;
	ImageIcon image = new ImageIcon("images/icons/freemind_butterfly.png");
	
	protected void setUp() throws Exception {
		super.setUp();
		
		icon = MindIcon.factory("iconName", image);
		
	}

	public void testToString() {
		assertEquals("Icon_name: iconName", icon.toString());
	}
	
	public void testGetIconFileName() {
		assertEquals("images/icons/iconName.png", icon.getIconFileName());
	}

	public void testGetIconBaseFileName() {
		assertEquals("iconName.png", icon.getIconBaseFileName());
	}

	public void testGetIconsPath() {
		assertEquals("images/icons/", MindIcon.getIconsPath());
	}
	
	public void testGetIcon() {
		assertEquals(image, icon.getIcon());
	}
	
	public void testGetKeystrokeResourceName() {
		assertEquals("keystroke_icon_iconName", icon.getKeystrokeResourceName());
	}
	
	public void testGetKeystroke() {
		assertNull(icon.getKeyStroke());
	}
	
	public void testGetName() {
		assertEquals("iconName", icon.getName());
		icon.setName(null);
		assertEquals("notfound", icon.getName());
	}
	
	public void testSetName() {
		icon.setName("newName");
		assertEquals("newName", icon.getName());
	}
}
