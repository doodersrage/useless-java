import java.io.*;
import nu.xom.*;

public class WeatherStation {
    int[] highTemp = new int[6];
    int[] lowTemp = new int[6];
    String[] conditions = new String[6];

    public WeatherStation() throws ParsingException, IOException {
        // get the XML document
        Builder builder = new Builder();
        Document doc = builder.build("http://tinyurl.com/rd4r72");
        // get the root element, <forecast>
        Element root = doc.getRootElement();
        // get the <simpleforecast> element
        Element simple = root.getFirstChildElement("simpleforecast");
        // get the <forecastday> elements
        Elements days = simple.getChildElements("forecastday");
        for (int current = 0; current < days.size(); current++) {
            // get current <forecastday>
            Element day = days.get(current);
            // get current <high>
            Element high = day.getFirstChildElement("high");
            Element highF = high.getFirstChildElement("fahrenheit");
            // get current <low>
            Element low = day.getFirstChildElement("low");
            Element lowF = low.getFirstChildElement("fahrenheit");
            // get current <icon>
            Element icon = day.getFirstChildElement("icon");
            // store values in object variables
            lowTemp[current] = -1;
            highTemp[current] = -1;
            try {
                lowTemp[current] = Integer.parseInt(lowF.getValue());
                highTemp[current] = Integer.parseInt(highF.getValue());
            } catch (NumberFormatException nfe) {
                // do nothing
            }
            conditions[current] = icon.getValue();
        }
    }

    public void display() {
        for (int i = 0; i < conditions.length; i++) {
            System.out.println("Period " + i);
            System.out.println("\tConditions: " + conditions[i]);
            System.out.println("\tHigh: " + highTemp[i]);
            System.out.println("\tLow: " + lowTemp[i]);
        }
    }

    public static void main(String[] arguments) {
        try {
            WeatherStation station = new WeatherStation();
            station.display();
        } catch (Exception exception) {
            System.out.println("Error: " + exception.getMessage());
        }
    }
}