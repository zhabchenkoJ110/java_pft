package ru.stqa.pft.soap;

import com.lavasoft.GeoIPService;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class GeoIpServiceTests {

    @Test
    public void testMyIp(){
        String geoIP = new GeoIPService().getGeoIPServiceSoap12().getIpLocation("109.252.95.177");
        assertEquals(geoIP,"<GeoIP><Country>RU</Country><State>48</State></GeoIP>");
    }
}
