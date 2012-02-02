package freemind.controller;

import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import tests.freemind.FreeMindTestBase;

public class FreeMindPopupMenuTest extends FreeMindTestBase {
	
	private FreeMindPopupMenu menu;
	
	private MenuListener listener;
	
	private boolean canceled = false;
	private boolean deselected = false;
	protected boolean selected = false;
	
	protected void setUp() throws Exception {
		super.setUp();
		
		///
		/// make the object
		///
		
		this.menu = new FreeMindPopupMenu();
		this.listener = new MenuListener() {

			///
			/// All arguments passed in are null, so these should be null
			///
			@Override
			public void menuCanceled(MenuEvent arg0) {
				assertNull(arg0);
				canceled = true;
			}

			@Override
			public void menuDeselected(MenuEvent arg0) {
				assertNull(arg0);
				deselected = true;
			}

			@Override
			public void menuSelected(MenuEvent arg0) {
				assertNull(arg0);
				selected = true;
			}
			
		};
	}
	
	public void testLogger(){
		assertNotNull(this.menu.logger);
	}
	
	public void testFirePopupMenuWillBecomeVisible() {
		this.menu.firePopupMenuWillBecomeVisible();
		assertTrue(true);
	}
	
	public void testFirePopupMenuWillBecomeInvisible() {
		this.menu.firePopupMenuWillBecomeInvisible();
	}
	
	public void testMenuListeners() {
		this.menu.addMenuListener(listener);
		this.menu.firePopupMenuWillBecomeVisible();
		assertTrue(selected);
		this.menu.firePopupMenuCanceled();
		assertTrue(canceled);
		this.menu.firePopupMenuWillBecomeInvisible();
		assertTrue(deselected);
		this.menu.removeMenuListener(listener);
	}
	

	
	

}
