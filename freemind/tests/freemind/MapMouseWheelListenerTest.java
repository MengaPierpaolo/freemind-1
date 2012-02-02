package tests.freemind;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import freemind.controller.MapMouseWheelListener;

public class MapMouseWheelListenerTest extends FreeMindTestBase {
	
	private MouseWheelListener listener;
	private boolean moved = false;
	
	
	protected void setUp() throws Exception {
		super.setUp();
		
		listener = new MouseWheelListener() {

			@Override
			public void mouseWheelMoved(MouseWheelEvent arg0) {
				moved = true;
				
			}
			
		};
	}
	
	public void testMouseWheelMoved() {
		MapMouseWheelListener listenerer = new MapMouseWheelListener(null);
		listenerer.mouseWheelMoved(null);
		assertFalse(moved);
		listenerer.register(listener);
		listenerer.mouseWheelMoved(null);
		assertTrue(moved);
		listenerer.deregister();
	}
	
	

}
