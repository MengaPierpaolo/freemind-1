package tests.freemind;

import plugins.map.TileImage;

public class TileImageTest extends FreeMindTestBase {
	
	private TileImage sut;
	
	@Override
	public void setUp() {
		sut = new TileImage();
	}
	
	public void testIsLoaded() {
		assertFalse(sut.isLoaded());
	}
	
	public void testIsDrawingDone() {
		assertFalse(sut.isDrawingDone());
	}
	
	public void testIsImageCreated() {
		assertFalse(sut.isImageCreated());
	}
	
	public void testSaveRaisesException() {
		try {
			sut.save();
			fail();
		} catch (Exception e) {
			assertTrue(true);
		}
	}
	
	public void testHasErrors() {
		assertFalse(sut.hasErrors());
	}
	
}
