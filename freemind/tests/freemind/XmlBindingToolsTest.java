package tests.freemind;

import javax.swing.JDialog;

import org.jibx.runtime.IMarshallingContext;
import org.jibx.runtime.JiBXException;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.lib.legacy.ClassImposteriser;

import freemind.common.XmlBindingTools;
import freemind.controller.Controller;
import freemind.controller.actions.generated.instance.WindowConfigurationStorage;

public class XmlBindingToolsTest extends FreeMindTestBase {

	private Mockery context = new Mockery() {{
        setImposteriser(ClassImposteriser.INSTANCE);
    }};
    
	private XmlBindingTools tools;
	private WindowConfigurationStorage mockStorage;
	private Controller mockController;
	
	public void testIt() throws JiBXException {
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
	
}
