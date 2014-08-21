import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Tool extends JFrame {
    public Tool() {
        super("Tool");
        setLookAndFeel();
        setSize(370, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // build toolbar buttons
        ImageIcon image1 = new ImageIcon("newfile.gif");
        JButton button1 = new JButton(image1);
        ImageIcon image2 = new ImageIcon("openfile.gif");
        JButton button2 = new JButton(image2);
        ImageIcon image3 = new ImageIcon("savefile.gif");
        JButton button3 = new JButton(image3);

        // build toolbar
        JToolBar bar = new JToolBar();
        bar.add(button1);
        bar.add(button2);
        bar.add(button3);

        // build text area
        JTextArea edit = new JTextArea(8, 40);
        JScrollPane scroll = new JScrollPane(edit);

        // create frame
        BorderLayout border = new BorderLayout();
        setLayout(border);
        add("North", bar);
        add("Center", scroll);
        setVisible(true);
    }

    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(
                "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"
            );
        } catch (Exception exc) {
            // ignore error
        }
    }

    public static void main(String[] arguments) {
        Tool frame = new Tool();
    }
}