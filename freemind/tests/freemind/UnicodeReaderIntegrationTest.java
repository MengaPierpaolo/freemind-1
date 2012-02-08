package tests.freemind;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
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
	
	public void testReadingCorruptedStream() {
		try {
			sut = new UnicodeReader(new FileInputStream(new File("/path/to/broken/file")), "utf-8");
			fail();
		} catch (IOException e) {
			assertTrue(true);
		}
	}
	
}
