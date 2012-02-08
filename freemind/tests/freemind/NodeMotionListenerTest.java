package tests.freemind;

import java.awt.event.MouseEvent;

import freemind.controller.NodeMotionListener;
import freemind.controller.NodeMotionListener.NodeMotionAdapter;

public class NodeMotionListenerTest extends FreeMindTestBase {
	
	private NodeMotionListener listener;
	private NodeMotionAdapter adapter;
	private boolean flag;
	
	
	protected void setUp() throws Exception {
		super.setUp();
		
		listener = new NodeMotionListener(null);
		flag = false;
		adapter = new NodeMotionAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				flag = true;
			}
			
			public void mouseDragged(MouseEvent e) {
				flag = true;
			}
			
			public void mouseEntered(MouseEvent e) {
				flag = true;
			}
			
			public void mouseExited(MouseEvent e) {
				flag = true;
			}
			
			public void mouseMoved(MouseEvent e) {
				flag = true;
			}
			
			public void mousePressed(MouseEvent e) {
				flag = true;
			}
			
			public void mouseReleased(MouseEvent e) {
				flag = true;
			}
		};
		
	}
	
	public void testRegister() {
		listener.register(adapter);
		listener.mouseClicked(null);
		assertTrue(flag);
	}
	
	public void testDeregister() {
		listener.register(adapter);
		listener.deregister();
		listener.mouseClicked(null);
		assertFalse(flag);
	}
	
	public void testSouseDragged() {
		listener.register(adapter);
		listener.mouseDragged(null);
		assertTrue(flag);
	}
	
	public void testMouseEntered() {
		listener.register(adapter);
		listener.mouseEntered(null);
		assertTrue(flag);
	}
	
	public void testMouseExited() {
		listener.register(adapter);
		listener.mouseExited(null);
		assertTrue(flag);
	}
	
	public void testMouseMoved() {
		listener.register(adapter);
		listener.mouseMoved(null);
		assertTrue(flag);
	}
	
	public void testMousePressed() {
		listener.register(adapter);
		listener.mousePressed(null);
		assertTrue(flag);
	}
	
	public void testMouseReleased() {
		listener.register(adapter);
		listener.mouseReleased(null);
		assertTrue(flag);
	}

}
