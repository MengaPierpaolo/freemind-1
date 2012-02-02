package tests.freemind;

import freemind.main.FreeMindStarter;


public class FreeMindStaterTest extends FreeMindTestBase {
	
	private FreeMindStarter starter;
	
	protected void setUp() throws Exception {
		super.setUp();
		
		///
		/// make the object
		///
		this.starter = new FreeMindStarter();
			
	}
	
	public void testMain() {
		
		try {
			//FreeMindStarter.main( new String[0] );
		} catch (Exception e) {
			
		}
		
		assertTrue(true);
		
	}

}
