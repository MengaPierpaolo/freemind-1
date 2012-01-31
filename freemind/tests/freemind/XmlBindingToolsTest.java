package tests.freemind;

import java.lang.reflect.Field;

import javax.swing.JDialog;

import org.jibx.runtime.IMarshallingContext;
import org.jibx.runtime.JiBXException;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.lib.legacy.ClassImposteriser;

import freemind.common.XmlBindingTools;
import freemind.controller.Controller;
import freemind.controller.actions.generated.instance.WindowConfigurationStorage;
import freemind.main.FreeMindMain;
import freemind.main.Resources;

public class XmlBindingToolsTest extends FreeMindTestBase {

	private Mockery context = new Mockery() {{
        setImposteriser(ClassImposteriser.INSTANCE);
    }};
    
	private XmlBindingTools tools;
	private WindowConfigurationStorage mockStorage;
	private Controller mockController;
	
	public void testStoreDialogPositions() throws JiBXException {
		mockStorage = context.mock(WindowConfigurationStorage.class);
		mockController = context.mock(Controller.class);
		
		tools = XmlBindingTools.getInstance();
		
		context.checking(new Expectations() {{
			one(mockStorage).setX(with(any(int.class)));
			one(mockStorage).setY(with(any(int.class)));
			one(mockStorage).setWidth(with(any(int.class)));
			one(mockStorage).setHeight(with(any(int.class)));
			one(mockStorage).JiBX_getIndex();
			one(mockStorage).marshal(with(any(IMarshallingContext.class)));
			one(mockController).setProperty(with(any(String.class)), with(any(String.class)));
		}});
		
		tools.storeDialogPositions(mockController, new JDialog(), mockStorage, "");
		context.assertIsSatisfied();
	}
	
	public void testDecorateDialog() {
		tools = XmlBindingTools.getInstance();
		mockController = context.mock(Controller.class);
		
		context.checking(new Expectations() {{
			one(mockController).getProperty(with(any(String.class)));
		}});
		
		tools.decorateDialog(mockController, new JDialog(), "");
		context.assertIsSatisfied();
	}
	
	public void testWithResourcesOn() throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
		Field main = Resources.getInstance().getClass().getDeclaredField("main");
		main.setAccessible(true);
		FreeMindMain privateField = (FreeMindMain) main.get(Resources.getInstance());
		
		privateField.setProperty("place_dialogs_on_first_screen", "true");
		
		tools = XmlBindingTools.getInstance();
		mockController = context.mock(Controller.class);
		
		context.checking(new Expectations() {{
			one(mockController).getProperty(with(any(String.class)));
		}});
		
		tools.decorateDialog(mockController, new JDialog(), "");
		context.assertIsSatisfied();
	}
	
}
