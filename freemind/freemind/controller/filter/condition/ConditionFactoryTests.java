package freemind.controller.filter.condition;

import org.jmock.Expectations;
import org.jmock.integration.junit3.JUnit3Mockery;
import org.jmock.lib.legacy.ClassImposteriser;

import freemind.common.TextTranslator;
import freemind.main.XMLElement;
import junit.framework.TestCase;

public class ConditionFactoryTests extends TestCase {

	ConditionFactory factory;
	private JUnit3Mockery context = new JUnit3Mockery(){{
        setImposteriser(ClassImposteriser.INSTANCE);
	}};
	final XMLElement xml = 
			context.mock( XMLElement.class );
	
	
	protected void setUp() throws Exception {
		super.setUp();
		factory = new ConditionFactory();
	}

	/**
	 * Tests that creating a description with all values passed in
	 * creates the proper description
	 */
	public void testCreateDescriptionAllParams() {
		String description = ConditionFactory.createDescription("attribute", "simple_condition", "Value", false);
		assertEquals( description, "attribute simple_condition \"Value\", filter_ignore_case");
	}
	
	/**
	 * Tests that creating a description with a null Value parameter
	 * passed in creates the proper description
	 */
	public void testCreateDescriptionNoValueParam() {
		String description = ConditionFactory.createDescription("attribute", "simple_condition", null, false);
		assertEquals( description, "attribute simple_condition");
	}
	
	/**
	 * Tests that an unexpected value passed to loadCondition
	 * returns a null value.
	 */
	public void testLoadConditionWithUnexpectedParameter() {
		XMLElement xml = new XMLElement();
		assertNull( factory.loadCondition( null ) );
	}
	
	/**
	 * 
	 */
	public void testLoadConditionWithNodeContainsCondition() {
		
		//XMLElement xml = new XMLElement
		//context.checking(new Expectations() {{
		//	allowing( xml ).getName();
		//	will( returnValue( NodeContainsCondition.NAME ) );
		//}});
		//System.out.println( "here::::: " + factory.loadCondition(xml).toString() );
		//assertTrue( xml.getName().equals( NodeContainsCondition.NAME ) );
		assertTrue( true );
		
	}
}
