import java.awt.*;
import javax.swing.*;

public class ClockFrame extends JFrame {
    public ClockFrame() {
        super("Clock");
        setLookAndFeel();
        setSize(225, 125);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FlowLayout flo = new FlowLayout();
        setLayout(flo);
        ClockPanel time = new ClockPanel();
        add(time);
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
        ClockFrame clock = new ClockFrame();
    }
}