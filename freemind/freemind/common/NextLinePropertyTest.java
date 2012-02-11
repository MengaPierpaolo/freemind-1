package freemind.common;

import org.jmock.integration.junit3.JUnit3Mockery;
import org.jmock.lib.legacy.ClassImposteriser;

import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.FormLayout;

import junit.framework.TestCase;

public class NextLinePropertyTest extends TestCase {
	
	NextLineProperty prop;
	
	private JUnit3Mockery context = new JUnit3Mockery(){{
        setImposteriser(ClassImposteriser.INSTANCE);
	}};
	
	protected void setUp() throws Exception {
		super.setUp();
		
		prop = new NextLineProperty();
	}
	
	public void testGetDescription() {
		assertNull(prop.getDescription());
	}
	
	public void testGetLabel() {
		assertNull(prop.getLabel());
	}
	
	public void testLayout() {
		
		final DefaultFormBuilder builder = 
				new DefaultFormBuilder( 
				new FormLayout( "right:pref, 6dlu, 50dlu, 4dlu, default", "" ) );
		
		final TextTranslator translator = 
				context.mock( TextTranslator.class );
		
		
		prop.layout(builder, translator);
		assertTrue(true);
	}
	
	public void testSetEnabled() {
		//don't do anything
		prop.setEnabled(true);
		prop.setEnabled(false);
		assertTrue(true);
		
	}

}
