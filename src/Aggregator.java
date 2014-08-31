import java.io.*;
import nu.xom.*;

public class Aggregator {
    public String[] title = new String[15];
    public String[] link = new String[15];
    public int count = 0;

    public Aggregator(String rssUrl) {
        try {
            // retrieve the XML document
            Builder builder = new Builder();
            Document doc = builder.build(rssUrl);
            // retrieve the document’s root element
            Element root = doc.getRootElement();
            // retrieve the root’s channel element
            Element channel = root.getFirstChildElement("channel");
            // retrieve the item elements in the channel
            if (channel != null) {
                Elements items = channel.getChildElements("item");
                for (int current = 0; current < items.size(); current++) {
                    if (count > 15) {
                        break;
                    }
                    // retrieve the current item
                    Element item = items.get(current);
                    Element titleElement = item.getFirstChildElement("title");
                    Element linkElement = item.getFirstChildElement("link");
                    title[current] = titleElement.getValue();
                    link[current] = linkElement.getValue();
                    count++;
                }
            }
        } catch (ParsingException exception) {
            System.out.println("XML error: " + exception.getMessage());
            exception.printStackTrace();
        } catch (IOException ioException) {
            System.out.println("IO error: " + ioException.getMessage());
            ioException.printStackTrace();
        }
    }

    public void listItems() {
        for (int i = 0; i < 15; i++) {
            if (title[i] != null) {
                System.out.println("\n" + title[i]);
                System.out.println(link[i]);
                i++;
            }
        }
    }

    public static void main(String[] arguments) {
        if (arguments.length > 0) {
            Aggregator aggie = new Aggregator(arguments[0]);
            aggie.listItems();
        } else {
            System.out.println("Usage: java Aggregator rssUrl");
        }
    }
}