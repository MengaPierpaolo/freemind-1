package tests.freemind;

import java.awt.Container;
import java.io.File;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

import freemind.controller.Controller;
import freemind.controller.MenuBar;
import freemind.main.FreeMindMain;
import freemind.main.Resources;
import freemind.view.mindmapview.MapView;

public class ResourcesTest extends FreeMindTestBase {

	private Resources sut;
	
	@Override
	public void setUp() {
		Resources.createInstance(new FreeMindMain() {
			
			@Override
			public void setWaitingCursor(boolean waiting) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setView(MapView view) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setTitle(String title) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setProperty(String key, String value) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setDefaultProperty(String key, String value) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void saveProperties(boolean pIsShutdown) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void repaint() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void removeSplitPane() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void registerStartupDoneListener(
					StartupDoneListener pStartupDoneListener) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void out(String msg) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void openDocument(URL location) throws Exception {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean isApplet() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public JSplitPane insertComponentIntoSplitPane(JComponent pMindMapComponent) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public int getWinY() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public int getWinX() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public int getWinWidth() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public int getWinState() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public int getWinHeight() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public MapView getView() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public JScrollPane getScrollPane() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public ResourceBundle getResources() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String getResourceString(String key, String defaultResource) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String getResourceString(String key) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public URL getResource(String name) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String getProperty(String key) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Properties getProperties() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public File getPatternsFile() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Logger getLogger(String forClass) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public JLayeredPane getLayeredPane() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public JFrame getJFrame() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public int getIntProperty(String key, int defaultValue) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public VersionInformation getFreemindVersion() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String getFreemindDirectory() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String getFreemindBaseDir() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public MenuBar getFreeMindMenuBar() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public ClassLoader getFreeMindClassLoader() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Controller getController() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Container getContentPane() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public JComponent getContentComponent() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String getAdjustableProperty(String label) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void err(String msg) {
				// TODO Auto-generated method stub
				
			}
		});
		sut = Resources.getInstance();
	}
	
	public void testCountryMap() {
		assertNotNull(sut.getCountryMap());
	}
	
	public void testGetProperty() {
		assertNull(sut.getProperty("not found"));
	}
	
	public void testAssertHasNoPropertiesAtFirst() {
		assertNull(sut.getProperties());
	}
	
	public void testBoolPropertyNotFound() {
		assertFalse(sut.getBoolProperty("not found"));
	}
	
	public void testVersionNotNull() {
		assertNotNull(sut.getFreemindVersion());
	}
	
}
