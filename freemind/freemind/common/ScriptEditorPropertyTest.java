package freemind.common;

import org.jmock.Expectations;
import org.jmock.integration.junit3.JUnit3Mockery;
import org.jmock.lib.legacy.ClassImposteriser;

import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.FormLayout;

import freemind.modes.Mode;
import freemind.modes.mindmapmode.MindMapController;
import freemind.modes.mindmapmode.MindMapMode;
import junit.framework.TestCase;

public class ScriptEditorPropertyTest extends TestCase {
	
	private MindMapMode mode;
	private MindMapController controller;
	private ScriptEditorProperty property;
	
	private JUnit3Mockery context = new JUnit3Mockery(){{
        setImposteriser(ClassImposteriser.INSTANCE);
	}};

	//This won't work until the editor can be decoupled from the Controller
	protected void setUp() throws Exception {
		super.setUp();
		mode = new MindMapMode();
		controller = new MindMapController(mode);
		property = new ScriptEditorProperty("description","label",controller);
	}

	public void testGetLabel() {
		assertEquals("label", property.getLabel());
	}

	public void testSetValue() {
		property.setValue("testscript");
		assertEquals("testscript", property.getValue());
	}

	public void testGetValue() {
		property.setValue("testscript");
		assertEquals("testscript", property.getValue());
	}

	public void testGetDescription() {
		assertEquals("description", property.getDescription());
	}

	public void testLayout() {
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

	public void testActionPerformed() {
		fail("Not yet implemented");
	}

	public void testSetEnabled() {
		property.setEnabled(true);
		assertTrue(property.mButton.isEnabled());
	}

}
