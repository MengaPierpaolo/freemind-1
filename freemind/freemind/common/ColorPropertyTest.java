package freemind.common;

import junit.framework.TestCase;

import org.jmock.Expectations;
import org.jmock.integration.junit3.JUnit3Mockery;
import org.jmock.lib.legacy.ClassImposteriser;

import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.FormLayout;

/**
 * Tests the StringProperty class
 * @author Derek Erdmann
 */
public class ColorPropertyTest extends TestCase {

	private ColorProperty property;
	private JUnit3Mockery context = new JUnit3Mockery(){{
        setImposteriser(ClassImposteriser.INSTANCE);
	}};
	
	final TextTranslator translator = 
			context.mock( TextTranslator.class );
	
	protected void setUp() throws Exception {
		super.setUp();
		
		context.checking(new Expectations() {{
			allowing( translator ).getText( with( any( String.class ) ) );
			will( returnValue( "translation" ) );
		}});
		
		property = new ColorProperty( "desc", "label", "#ffffff", translator );
	}
	
	protected void tearDown() throws Exception {
		context.assertIsSatisfied();
		super.tearDown();
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
	 * Tests that the textBox can be enabled
	 */
	public void testSetEnabled_True(){
		property.setEnabled( true );
		assertTrue( property.mButton.isEnabled() );
	}

	
	/**
	 * Tests that the textBox can be disabled
	 */
	public void testSetEnabled_False(){
		property.setEnabled( false );
		assertFalse( property.mButton.isEnabled() );
	}
	
	
	/**
	 * Tests that the value of the textbox can be retrieved
	 */
	public void testGetValue(){
		property.setValue( "#000000" );
		assertEquals( "#000000", property.getValue() );
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
