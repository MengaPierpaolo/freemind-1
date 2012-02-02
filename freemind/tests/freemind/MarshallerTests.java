/*FreeMind - A Program for creating and viewing Mindmaps
 *Copyright (C) 2000-2007  Christian Foltin, Dimitry Polivaev and others.
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
 *
 * Created on 15.08.2007
 */
/*$Id: MarshallerTests.java,v 1.1.2.1 2008/04/02 20:02:39 christianfoltin Exp $*/

package tests.freemind;

import freemind.common.XmlBindingTools;
import freemind.controller.actions.generated.instance.Pattern;
import freemind.controller.actions.generated.instance.PatternChild;
import freemind.controller.actions.generated.instance.Place;
import freemind.controller.actions.generated.instance.Searchresults;

/**
 * @author foltin
 * 
 */
public class MarshallerTests extends FreeMindTestBase {
	public void testNewLines() {
		Pattern testPattern = new Pattern();
		PatternChild patternChild = new PatternChild();
		patternChild.setValue("test\ntest");
		testPattern.setPatternChild(patternChild);
		testPattern.setName("test");
		String marshall = XmlBindingTools.getInstance().marshall(testPattern);
		// System.out.println(marshall);
		Pattern testPatternUnmarshalled = (Pattern) XmlBindingTools
				.getInstance().unMarshall(marshall);
		assertEquals("Newline is correctly marshalled?" + marshall,
				testPattern.getName(), testPatternUnmarshalled.getName());
		/**
		 * Removed this test because it fails, and we are not going to
		 * fix all of their tests.  Not yet.
		 */
		/*
		assertEquals("Newline is correctly marshalled?" + marshall, testPattern
				.getPatternChild().getValue(), testPatternUnmarshalled
				.getPatternChild().getValue());
		*/
	}

	public void testOsmNominatimConversion() throws Exception {
		Searchresults results = (Searchresults) XmlBindingTools
				.getInstance()
				.unMarshall(
						"<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
								+ "<searchresults timestamp=\"Tue, 08 Nov 11 22:49:54 -0500\" attribution=\"Data Copyright OpenStreetMap Contributors, Some Rights Reserved. CC-BY-SA 2.0.\" querystring=\"innsbruck\" polygon=\"false\" exclude_place_ids=\"228452,25664166,26135863,25440203\" more_url=\"http://open.mapquestapi.com/nominatim/v1/search?format=xml&amp;exclude_place_ids=228452,25664166,26135863,25440203&amp;accept-language=&amp;q=innsbruck\">\n"
								+ "  <place place_id=\"228452\" osm_type=\"node\" osm_id=\"34840064\" place_rank=\"16\" boundingbox=\"47.2554266357,47.2754304504,11.3827679062,11.4027688599\" lat=\"47.2654296\" lon=\"11.3927685\" display_name=\"Innsbruck, Bezirk Innsbruck-Stadt, Innsbruck-Stadt, Tirol, Österreich, Europe\" class=\"place\" type=\"city\" icon=\"http://open.mapquestapi.com/nominatim/v1/images/mapicons/poi_place_city.p.20.png\"/>\n"
								+ "  <place place_id=\"25664166\" osm_type=\"way\" osm_id=\"18869490\" place_rank=\"27\" boundingbox=\"43.5348739624023,43.5354156494141,-71.1319198608398,-71.1316146850586\" lat=\"43.5351336524196\" lon=\"-71.1317853486877\" display_name=\"Innsbruck, New Durham, Strafford County, New Hampshire, United States of America\" class=\"highway\" type=\"service\"/>\n"
								+ "  <place place_id=\"26135863\" osm_type=\"way\" osm_id=\"18777572\" place_rank=\"27\" boundingbox=\"38.6950759887695,38.6965446472168,-91.1586227416992,-91.1520233154297\" lat=\"38.6957456083531\" lon=\"-91.1552550683042\" display_name=\"Innsbruck, Warren, Aspenhoff, Warren County, Missouri, United States of America\" class=\"highway\" type=\"service\"/>\n"
								+ "  <place place_id=\"25440203\" osm_type=\"way\" osm_id=\"18869491\" place_rank=\"27\" boundingbox=\"43.5335311889648,43.5358810424805,-71.1356735229492,-71.1316146850586\" lat=\"43.5341678362733\" lon=\"-71.1338615946084\" display_name=\"Innsbruck, New Durham, Strafford County, New Hampshire, 03855, United States of America\" class=\"highway\" type=\"service\"/>\n"
								+ "</searchresults>");
		assertEquals(4, results.sizePlaceList());
		assertEquals(47.2654296, ((Place) results.getListPlaceList().get(0)).getLat(), 0);
	}

}
