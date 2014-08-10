import java.util.*;

public class StringLister {
    String[] names = { "Spanky", "Alfalfa", "Buckwheat", "Daria",
    "Stymie", "Marianne", "Scotty", "Tommy", "Chubby" };

    public StringLister(String[] moreNames) {
        Vector<String> list = new Vector<String>();
        for (int i = 0; i < names.length; i++) {
            list.add(names[i]);
        }
        for (int i = 0; i < moreNames.length; i++) {
            list.add(moreNames[i]);
        }
        Collections.sort(list);
        for (String name : list) {
            System.out.println(name);
        }
    }

    public static void main(String[] args) {
        StringLister lister = new StringLister(args);
    }

}