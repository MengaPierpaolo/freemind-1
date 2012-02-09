/*
 * Testing done by Michael Caputo
 */

package tests.freemind;

import freemind.controller.filter.condition.Condition;
import freemind.controller.filter.condition.NoFilteringCondition;
import junit.framework.TestCase;

public class NoFilteringConditionTests extends TestCase {

	Condition nfc;
	
	protected void setUp() throws Exception {
		super.setUp();
		nfc = NoFilteringCondition.createCondition();
	}
	
	/**
	 * Tests to ensure that the toString method
	 * properly sets a value to the description
	 */
	public void testToString() {
		assertNotNull( nfc.toString() );
	}
	
	/**
	 * Tests to make sure that the getListCellRendererComponent
	 * returns a valid renderer.
	 */
	public void testGetListCellRendererComponent() {
		assertNotNull( nfc.getListCellRendererComponent() );
	}
	
	/**
	 * Checks to ensure that checkNode returns the proper
	 * response. Relatively useless test since checkNode
	 * always returns true....
	 */
	public void testCheckNode() {
		assertTrue( nfc.checkNode(null,null) );
	}
	
	
}
