package tests.freemind;

import java.io.IOException;

import freemind.common.UnicodeReader;

public class UnicodeReaderIntegrationTest extends FreeMindTestBase {
	
	private UnicodeReader sut;
	
	@Override
	public void setUp() {
		sut = new UnicodeReader(null, "utf-8");
	}
	
	public void testDefaultEncoding() {
		assertEquals("utf-8", sut.getDefaultEncoding());
	}
	
	public void testGetEncodingIsNull() {
		assertNull(sut.getEncoding());
	}
	
	public void testCloseRaisesExceptionForNullStream() {
		try {
			sut.close();
			fail();
		} catch (IOException e) {
			assertTrue(true);
		}
	}
	
}
