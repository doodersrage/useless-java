import java.io.*;
import java.util.*;

class Configurator {

    Configurator() {
        try {
            // load the properties file
            File configFile = new File("program.properties");
            FileInputStream inStream = new FileInputStream(configFile);
            Properties config = new Properties();
            config.load(inStream);
            // create a new property
            Date current = new Date();
            config.setProperty("runtime", current.toString());
            // save the properties file
            FileOutputStream outStream = new FileOutputStream(configFile);
            config.store(outStream, "Properties settings");
            inStream.close();
            config.list(System.out);
        } catch (IOException ioe) {
            System.out.println("IO error " + ioe.getMessage());
        }
    }

    public static void main(String[] arguments) {
        Configurator con = new Configurator();
    }
}