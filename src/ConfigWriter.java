import java.io.*;

class ConfigWriter {
    String newline = System.getProperty("line.separator");

    ConfigWriter() {
        try {
            File file = new File("program.properties");
            FileOutputStream fileStream = new FileOutputStream(file);
            write(fileStream, "username=max");
            write(fileStream, "score=12550");
            write(fileStream, "level=5");
        } catch (IOException ioe) {
            System.out.println("Could not write file");
        }
    }

    void write(FileOutputStream stream, String output)
        throws IOException {
            output = output + newline;
        byte[] data = output.getBytes();
        stream.write(data, 0, data.length);
    }

    public static void main(String[] arguments) {
        ConfigWriter cw = new ConfigWriter();
    }
}
