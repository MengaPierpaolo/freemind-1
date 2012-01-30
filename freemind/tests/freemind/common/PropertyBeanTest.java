package tests.freemind.common;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit3.JUnit3Mockery;
import org.jmock.integration.junit3.MockObjectTestCase;

import freemind.common.PropertyBean;

/**
 * Test the abstract methods of a PropertyBean
 * @author Derek Erdmann
 */
public class PropertyBeanTest extends MockObjectTestCase {

	Mockery context = new JUnit3Mockery();
	ArrayList<PropertyChangeListener> listeners;
	private FakePropertyBean property;
	
	/**
	 * Concrete implementation of PropertyBean for testing
	 * @author Derek Erdmann
	 */
	class FakePropertyBean extends PropertyBean {

		@Override
		public String getLabel() { return "Label"; }

		@Override
		public void setValue(String value) {}

		@Override
		public String getValue() { return "Value"; }
		
		/**
		 * Accesses the protected property change event
		 */
		public void fireEvent(){
			firePropertyChangeEvent();
		}
		
	}
	
	
	/**
	 * Set up before tests
	 */
	protected void setUp() throws Exception {
		super.setUp();
		listeners = new ArrayList<PropertyChangeListener>();
		property = new FakePropertyBean();
		property.setValue("");
	}
	
	
	/**
	 * Tests that nothing blows up when there are no listeners
	 */
	public void testFirePropertyChangeEvent_NoListeners(){
		property.fireEvent();
	}
	
	
	/**
	 * Tests that a single listener can receive an event
	 */
	public void testFirePropertyChangeEvent_OneListeners(){
		
		final PropertyChangeListener listener = 
			context.mock( PropertyChangeListener.class );
		
		context.checking(new Expectations() {{
			oneOf( listener ).propertyChange( 
				with( any( PropertyChangeEvent.class ) )
			);
		}});
		
		property.addPropertyChangeListener( listener );
		property.fireEvent();
		
		context.assertIsSatisfied();
	}

	
	/**
	 * Tests that a listener that has been removed receives no event
	 */
	public void testRemovePropertyChangeListener(){
		
		final PropertyChangeListener listener = 
			context.mock( PropertyChangeListener.class );
		
		context.checking(new Expectations() {{
			never( listener ).propertyChange( 
				with( any( PropertyChangeEvent.class ) )
			);
		}});
		
		property.addPropertyChangeListener( listener );
		property.removePropertyChangeListener( listener );
		property.fireEvent();
		
		context.assertIsSatisfied();
	}
	
	

}
