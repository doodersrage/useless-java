import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class ColorSliders extends JFrame implements ChangeListener {
    ColorPanel canvas;
    JSlider red;
    JSlider green;
    JSlider blue;

    public ColorSliders() {
        super("Color Slide");
        setLookAndFeel();
        setSize(270, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        canvas = new ColorPanel();
        red = new JSlider(0, 255, 255);
        green = new JSlider(0, 255, 0);
        blue = new JSlider(0, 255, 0);

        red.setMajorTickSpacing(50);
        red.setMinorTickSpacing(10);
        red.setPaintTicks(true);
        red.setPaintLabels(true);
        red.addChangeListener(this);

        green.setMajorTickSpacing(50);
        green.setMinorTickSpacing(10);
        green.setPaintTicks(true);
        green.setPaintLabels(true);
        green.addChangeListener(this);

        blue.setMajorTickSpacing(50);
        blue.setMinorTickSpacing(10);
        blue.setPaintTicks(true);
        blue.setPaintLabels(true);
        blue.addChangeListener(this);

        JLabel redLabel = new JLabel("Red: ");
        JLabel greenLabel = new JLabel("Green: ");
        JLabel blueLabel = new JLabel("Blue: ");
        GridLayout grid = new GridLayout(4, 1);
        FlowLayout right = new FlowLayout(FlowLayout.RIGHT);
        setLayout(grid);

        JPanel redPanel = new JPanel();
        redPanel.setLayout(right);
        redPanel.add(redLabel);
        redPanel.add(red);
        add(redPanel);

        JPanel greenPanel = new JPanel();
        greenPanel.setLayout(right);
        greenPanel.add(greenLabel);
        greenPanel.add(green);
        add(greenPanel);

        JPanel bluePanel = new JPanel();
        bluePanel.setLayout(right);
        bluePanel.add(blueLabel);
        bluePanel.add(blue);
        add(bluePanel);
        add(canvas);

        setVisible(true);
    }

    public void stateChanged(ChangeEvent event) {
        JSlider source = (JSlider) event.getSource();
        if (source.getValueIsAdjusting() != true) {
            Color current = new Color(red.getValue(),green.getValue(),
            blue.getValue());
            canvas.changeColor(current);
            canvas.repaint();
        }
    }

    public Insets getInsets() {
        Insets border = new Insets(45, 10, 10, 10);
        return border;
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
        ColorSliders cs = new ColorSliders();
    }
}

class ColorPanel extends JPanel {
    Color background;

    ColorPanel() {
        background = Color.red;
    }

    public void paintComponent(Graphics comp) {
        Graphics2D comp2D = (Graphics2D) comp;
        comp2D.setColor(background);
        comp2D.fillRect(0, 0, getSize().width, getSize().height);
    }

    void changeColor(Color newBackground) {
        background = newBackground;
    }
}