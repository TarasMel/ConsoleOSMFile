package utils;

import info.pavie.basicosmparser.controller.OSMParser;
import info.pavie.basicosmparser.model.Element;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class Parse implements Runnable {

    private File fileToParse;

    public Parse(File fileToParse) {
        this.fileToParse = fileToParse;
    }

    @Override
    public void run() {
        OSMParser p = new OSMParser();
        try {
            Map<String, Element> result = p.parse(fileToParse);
            System.out.println(result.get("N4454508029"));
            result.get("N4454508029").getUser();
            result.get("N4454508029").getId();
            result.get("N4454508029").getUid();
            System.out.println(result.get("N4454508029").getId());
            System.out.println(result.get("N4454508029").getUser());
            System.out.println(result.get("N4454508029").getUid());
            System.out.println(result);
        }
        catch (IOException | org.xml.sax.SAXException e) {
            e.printStackTrace();
        }
    }
}
