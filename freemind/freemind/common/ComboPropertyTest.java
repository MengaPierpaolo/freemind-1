package freemind.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jmock.Expectations;
import org.jmock.integration.junit3.JUnit3Mockery;
import org.jmock.integration.junit3.MockObjectTestCase;


/**
 * Tests freemind.common.ComboProperty
 * @author Derek Erdmann
 */
public class ComboPropertyTest extends MockObjectTestCase {

	private ComboProperty property;
	private JUnit3Mockery context = new JUnit3Mockery();
	
	
	protected void setUp() throws Exception {
		super.setUp();
		
		String[] possibles = { "one", "two", "three" };
		
		List<String> translations = new ArrayList<String>();
		translations.add( "translate one" );
		translations.add( "translate two" );
		translations.add( "translate three" );
		
		property = new ComboProperty( "desc", "label", possibles, translations );
	}
	
	
	/**
	 * Tests that the ComboProperty can be properly constructed when given a 
	 * TextTranslator
	 */
	public void testConstructor_TextTranslator(){
		
		final TextTranslator translator = 
				context.mock( TextTranslator.class );
		
		context.checking(new Expectations() {{
			allowing( translator ).getText( with( any( String.class ) ) );
			will( returnValue( "translation" ) );
		}});
	
		String[] possibles = { "one", "two", "three" };
		
		property = new ComboProperty( "desc", "label", possibles, translator );
		
		assertEquals( "desc", property.getDescription() );
		assertEquals( "label", property.getLabel() );
		
		context.assertIsSatisfied();
	}
	
	
	/**
	 * Tests that the ComboProperty can be properly constructed when given a 
	 * list of existing translations. The object has already been created in 
	 * the setUp method
	 */
	public void testConstructor_ExistingTranslations(){
		assertEquals( "desc", property.getDescription() );
		assertEquals( "label", property.getLabel() );
	}
	
	
	/**
	 * Tests that the ComboProperty can be properly constructed when given a 
	 * list of possible strings
	 */
	public void testConstructor_ListPossibles(){
		
		String[] possibleArray = { "one", "two", "three" };
		List<String> possibles = Arrays.asList( possibleArray );
		
		List<String> translations = new ArrayList<String>();
		translations.add( "translate one" );
		translations.add( "translate two" );
		translations.add( "translate three" );
		
		property = new ComboProperty( "desc", "label", possibles, translations );
		
		assertEquals( "desc", property.getDescription() );
		assertEquals( "label", property.getLabel() );
		
	}
	
	
	/**
	 * Tests that the comboBox can be enabled
	 */
	public void testSetEnabled_True(){
		property.setEnabled( true );
		assertTrue( property.mComboBox.isEnabled() );
	}

	
	/**
	 * Tests that the comboBox can be disabled
	 */
	public void testSetEnabled_False(){
		property.setEnabled( false );
		assertFalse( property.mComboBox.isEnabled() );
	}
	
	
	/**
	 * Tests that the value can be retrieved from the combo box
	 */
	public void testGetValue_FirstIndex(){
		property.mComboBox.setSelectedIndex( 0 );
		assertEquals( "one", property.getValue() );
	}
	
	
	/**
	 * Tests that the a string in the combo box can be selected 
	 */
	public void testSetValue(){
		property.setValue( "two" );
		assertEquals( "translate two", property.mComboBox.getSelectedItem() );
		assertEquals( 1, property.mComboBox.getSelectedIndex() );
	}
	
	
	/**
	 * Tests that a value that is not in the combo box results in setting the 
	 * index to 0
	 */
	public void testSetValue_NotInCombo(){
		property.mComboBox.setSelectedIndex( 1 );
		property.setValue( "bad value" );
		assertEquals( "translate one", property.mComboBox.getSelectedItem() );
		assertEquals( 0, property.mComboBox.getSelectedIndex() );
		
	}


}
