
import utils.Download;
import utils.Parse;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        String link = " https://www.openstreetmap.org/api/0.6/map?bbox=153.3492%2C-27.9165%2C153.5022%2C-27.8459";
        File out = new File("C:\\Users\\Taras\\Desktop\\map.osm");
        Download download = new Download(link, out);
        Parse parse = new Parse(out);
        download.run();
        System.out.println("------------------------------");
        parse.run();
    }
}
