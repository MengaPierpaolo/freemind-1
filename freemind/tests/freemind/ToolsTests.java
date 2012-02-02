/*FreeMind - A Program for creating and viewing Mindmaps
 *Copyright (C) 2000-2011 Joerg Mueller, Daniel Polansky, Christian Foltin, Dimitri Polivaev and others.
 *
 *See COPYING for Details
 *
 *This program is free software; you can redistribute it and/or
 *modify it under the terms of the GNU General Public License
 *as published by the Free Software Foundation; either version 2
 *of the License, or (at your option) any later version.
 *
 *This program is distributed in the hope that it will be useful,
 *but WITHOUT ANY WARRANTY; without even the implied warranty of
 *MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *GNU General Public License for more details.
 *
 *You should have received a copy of the GNU General Public License
 *along with this program; if not, write to the Free Software
 *Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */

package tests.freemind;

import java.awt.Color;
import java.awt.Point;
import java.io.Reader;
import java.io.StringReader;
import java.net.URL;
import java.util.Iterator;
import java.util.Vector;

import freemind.main.HtmlTools;
import freemind.main.Tools;
import freemind.modes.mindmapmode.MindMapMapModel;

/**
 * @author foltin
 * @date 30.06.2011
 */
public class ToolsTests extends FreeMindTestBase {

	/*
	 * (non-Javadoc)
	 * 
	 * @see tests.freemind.FreeMindTestBase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testArgsToUrlConversion() throws Exception {
		String[] args = new String[] { "/home/bla", "--quiet", "c:\\test.mm" };
		String arrayToUrls = Tools.arrayToUrls(args);
		Vector urlVector = Tools.urlStringToUrls(arrayToUrls);
		assertEquals(args.length, urlVector.size());
		for (Iterator it = urlVector.iterator(); it.hasNext();) {
			URL urli = (URL) it.next();
			System.out.println(urli);
		}
	}

	public void testRichContentConversion() throws Exception {
		String input = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><map version=\"0.9.0\">\n" +
				"<!-- To view this file, download free mind mapping software FreeMind from http://freemind.sourceforge.net -->\n" +
				"<node CREATED=\"1320424144875\" ID=\"ID_984089046\" MODIFIED=\"1320424283250\" TEXT=\"GREEK LETTERS&#x391;&#x392;&#x393;&#x394;&#x395;&#x396;&#x397;&#x398;&#x399;&#x39a;&#x39b;&#x39c;&#x39d;&#x39e;&#x39f;&#x3a0;&#x3a1;&#x3a3;&#x3a4;&#x3a5;&#x3a6;&#x3a7;&#x3a8;&#x3a9; &#x3b1;&#x3b2;&#x3b3;&#x3b4;&#x3b5;&#x3b6;&#x3b7;&#x3b8;&#x3b9;&#x3ba;&#x3bb;&#x3bc;&#x3bd;&#x3be;&#x3bf;&#x3c0;&#x3c1;&#x3c3;&#x3c4;&#x3c5;&#x3c6;&#x3c7;&#x3c8;&#x3c9; &#x3ac;&#x3ad;&#x3ae;&#x3af;&#x3cc;&#x3cd;&#x3ce;\">\n" +
				"<node CREATED=\"1320424155937\" ID=\"ID_1884129484\" MODIFIED=\"1320424262562\" POSITION=\"right\">\n" +
				"<richcontent TYPE=\"NODE\"><html>\n" +
				"  <head>\n" +
				"    \n" +
				"  </head>\n" +
				"  <body>\n" +
				"    <p>\n" +
				"      &#x391;&#x392;&#x393;&#x394;&#x395;&#x396;&#x397;&#x398;&#x399;&#x39a;&#x39b;&#x39c;&#x39d;&#x39e;&#x39f;&#x3a0;&#x3a1;&#x3a3;&#x3a4;&#x3a5;&#x3a6;&#x3a7;&#x3a8;&#x3a9;\n" +
				"    </p>\n" +
				"    <p>\n" +
				"      &#x3b1;&#x3b2;&#x3b3;&#x3b4;&#x3b5;&#x3b6;&#x3b7;&#x3b8;&#x3b9;&#x3ba;&#x3bb;&#x3bc;&#x3bd;&#x3be;&#x3bf;&#x3c0;&#x3c1;&#x3c3;&#x3c4;&#x3c5;&#x3c6;&#x3c7;&#x3c8;&#x3c9; &#x3ac;&#x3ad;&#x3ae;&#x3af;&#x3cc;&#x3cd;&#x3ce;\n" +
				"    </p>\n" +
				"  </body>\n" +
				"</html>\n" +
				"</richcontent>\n" +
				"</node>\n" +
				"</node>\n" +
				"</map>\n";
		Reader updateReader = Tools.getUpdateReader(new StringReader(input),
				MindMapMapModel.FREEMIND_VERSION_UPDATER_XSLT, mFreeMindMain);
		String result = Tools.getFile(updateReader);
		result = HtmlTools.unicodeToHTMLUnicodeEntity(result, true);
		System.out.println(result);
		assertEquals("Correct conversion", input, result);
	}
	
	public void testColorToXml() {
		assertNull(Tools.colorToXml(null));
		assertNotNull(Tools.colorToXml(Color.green));
		assertNotNull(Tools.colorToXml(Color.BLACK));
	}
	
	public void testExecutableByExtension() {
		assertTrue(Tools.executableByExtension("file.exe"));
		assertFalse(Tools.executableByExtension("file.no"));
	}
	
	public void testxmlToColor() {
		assertNull(Tools.xmlToColor(null));
		assertNotNull(Tools.xmlToColor("#000000"));
		assertEquals(Color.BLACK, Tools.xmlToColor("#000000"));
		try {
			assertNull(Tools.xmlToColor("#1"));
		} catch (Exception e) { }
	}
	
	public void testPointToXml() {
		assertNull(Tools.PointToXml(null));
		assertNotNull(Tools.PointToXml(new Point(0,0)));
		assertEquals( "0;0;", Tools.PointToXml(new Point(0,0)) );
		assertEquals( "1;2;", Tools.PointToXml(new Point(1,2)) );
	}
	
	public void testxmlToPoint() {
		assertNull(Tools.xmlToPoint(null));
	}
	
}


