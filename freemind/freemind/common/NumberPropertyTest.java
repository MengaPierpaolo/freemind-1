package freemind.common;

import junit.framework.TestCase;

import org.jmock.Expectations;
import org.jmock.integration.junit3.JUnit3Mockery;
import org.jmock.lib.legacy.ClassImposteriser;

import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.FormLayout;

/**
 * Tests the NumberProperty class
 * @author Derek Erdmann
 */
public class NumberPropertyTest extends TestCase {

	private NumberProperty property;
	private JUnit3Mockery context = new JUnit3Mockery(){{
        setImposteriser(ClassImposteriser.INSTANCE);
	}};
	
	private final int MIN = 0;
	private final int MAX = 10;
	private final int STEP = 1;
	
	protected void setUp() throws Exception {
		super.setUp();
		property = new NumberProperty( "desc", "label", MIN, MAX, STEP );
	}
	
	
	/**
	 * Tests that the description can be retrieved
	 */
	public void testGetDescription(){
		assertEquals( "desc", property.getDescription() );
	}

	
	/**
	 * Tests that the label can be retrieved
	 */
	public void testGetLabel(){
		assertEquals( "label", property.getLabel() );
	}
	
	
	/**
	 * Tests that the value can be set
	 */
	public void testSetValue(){
		property.setValue( "1" );
		assertEquals( "1", property.getValue() );
	}

	
	/**
	 * Tests that the value can be set
	 */
	public void testSetValue_Invalid(){
		property.setValue( "1" );
		assertEquals( "1", property.getValue() );
		property.setValue( "bad value" );
		assertEquals( "1", property.getValue() );
	}
	
	
	public void testSetValue_OutOfBounds(){
		property.setValue( "1000" );
		assertEquals( "" + MIN, property.getValue() );
	}
	
	
	/**
	 * Tests that the textBox can be enabled
	 */
	public void testSetEnabled_True(){
		property.setEnabled( true );
	}

	
	/**
	 * Tests that the textBox can be disabled
	 */
	public void testSetEnabled_False(){
		property.setEnabled( false );
	}
	
	
	/**
	 * Tests that a label can be added to the builder
	 */
	public void testLayout(){
		
		final DefaultFormBuilder builder = 
			new DefaultFormBuilder( 
			new FormLayout( "right:pref, 6dlu, 50dlu, 4dlu, default", "" ) );
		
		final TextTranslator translator = 
				context.mock( TextTranslator.class );
		
		context.checking(new Expectations() {{
			allowing( translator ).getText( with( any( String.class ) ) );
			will( returnValue( "translation" ) );
		}});
		
		property.layout( builder , translator );
		
		context.assertIsSatisfied();
		
	}
	
	
}
