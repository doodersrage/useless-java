import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class PieFrame extends JFrame {
    Color uneasyBeingGreen = new Color(0xCC, 0xCC, 0x99);
    Color zuzusPetals = new Color(0xCC, 0x66, 0xFF);
    Color zootSuit = new Color(0x66, 0x66, 0x99);
    Color sweetHomeAvocado = new Color(0x66, 0x99, 0x66);
    Color shrinkingViolet = new Color(0x66, 0x66, 0x99);
    Color miamiNice = new Color(0x33, 0xFF, 0xFF);
    Color inBetweenGreen = new Color(0x00, 0x99, 0x66);
    Color norwegianBlue = new Color(0x33, 0xCC, 0xCC);
    Color purpleRain = new Color(0x66, 0x33, 0x99);
    Color freckle = new Color(0x99, 0x66, 0x33);

    public PieFrame() {
        super("Pie Graph");
        setLookAndFeel();
        setSize(320, 290);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        PiePanel pie = new PiePanel(10);
        pie.addSlice(uneasyBeingGreen, 1337);
        pie.addSlice(zuzusPetals, 1189);
        pie.addSlice(zootSuit, 311);
        pie.addSlice(sweetHomeAvocado, 246);
        pie.addSlice(shrinkingViolet, 203);
        pie.addSlice(miamiNice, 187);
        pie.addSlice(inBetweenGreen, 166);
        pie.addSlice(norwegianBlue, 159);
        pie.addSlice(purpleRain, 139);
        pie.addSlice(freckle, 127);
        add(pie);
    }

    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception exc) {
            // ignore error
        }
    }

    public static void main(String[] arguments) {
        PieFrame pf = new PieFrame();
    }
}