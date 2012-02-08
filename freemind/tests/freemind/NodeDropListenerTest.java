package tests.freemind;

import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;

import freemind.controller.NodeDropListener;

public class NodeDropListenerTest extends FreeMindTestBase {
	
	private NodeDropListener listener;
	
	private boolean flag1 = false;
	private boolean flag2 = false;
	private boolean flag3 = false;
	private boolean flag4 = false;
	private boolean flag5 = false;
	
	private DropTargetListener listenerer = new DropTargetListener() {

		@Override
		public void dragEnter(DropTargetDragEvent dtde) {
			flag1 = true;
		}

		@Override
		public void dragExit(DropTargetEvent dte) {
			flag2 = true;
		}

		@Override
		public void dragOver(DropTargetDragEvent dtde) {
			flag3 = true;
		}

		@Override
		public void drop(DropTargetDropEvent dtde) {
			flag4 = true;
		}

		@Override
		public void dropActionChanged(DropTargetDragEvent dtde) {
			flag5 = true;
		}
		
	};
	
	protected void setUp() throws Exception {
		super.setUp();
		
		listener = new NodeDropListener(null);
	}
	
	public void testRegister() {
		listener.register(listenerer);
		listener.dragEnter(null);
		assertTrue(flag1);
	}
	
	public void testDeregister() {
		listener.register(listenerer);
		listener.deregister();
		listener.dragEnter(null);
		assertFalse(flag1);
	}
	
	public void testDragExit() {
		listener.register(listenerer);
		listener.dragExit(null);
		assertTrue(flag2);
	}
	
	public void testDragOver() {
		listener.register(listenerer);
		listener.dragOver(null);
		assertTrue(flag3);
	}
	
	public void testDrop() {
		listener.register(listenerer);
		listener.drop(null);
		assertTrue(flag4);
	}
	
	public void testDropActionChanged() {
		listener.register(listenerer);
		listener.dropActionChanged(null);
		assertTrue(flag5);
	}
	

}
