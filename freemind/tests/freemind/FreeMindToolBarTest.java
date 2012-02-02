package tests.freemind;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JToolBar;

import freemind.controller.FreeMindToolBar;

public class FreeMindToolBarTest extends FreeMindTestBase {
	
	private ArrayList<FreeMindToolBar> bars = new ArrayList<FreeMindToolBar>();
	private FreeMindToolBar bar;
	
	protected void setUp() throws Exception {
		super.setUp();
		bar = new FreeMindToolBar();
	}
	
	public void testConstructors() {
		bars.add(new FreeMindToolBar());
		bars.add(new FreeMindToolBar(""));
		bars.add(new FreeMindToolBar(JToolBar.HORIZONTAL));
		bars.add(new FreeMindToolBar("", JToolBar.HORIZONTAL));
		
		for (FreeMindToolBar firstBar : bars ) {
			for (FreeMindToolBar secondBar : bars ) {
				assertEquals(firstBar.getName(), secondBar.getName());
				assertEquals(firstBar.getOrientation(), secondBar.getOrientation());
			}
		}	
	}
	
	public void testAdd() {
		Action anAction = new Action() {
			
			HashMap<String, Object> map = new HashMap<String, Object>();

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void addPropertyChangeListener(
					PropertyChangeListener listener) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public Object getValue(String key) {
				return map.get(key);
			}

			@Override
			public boolean isEnabled() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public void putValue(String key, Object value) {
				map.put(key, value);
				
			}

			@Override
			public void removePropertyChangeListener(
					PropertyChangeListener listener) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void setEnabled(boolean b) {
				// TODO Auto-generated method stub
				
			}
			
		};
		
		anAction.putValue(Action.NAME, "Epic");
		
		JButton returnValue = bar.add(anAction);
		assertEquals(returnValue.getName(), "Epic");
	}
	

}
