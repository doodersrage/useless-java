import javax.swing.*;
import java.awt.*;

public class MailWriter extends JFrame {

    public MailWriter() {
        super("Write an E-Mail");
        setLookAndFeel();
        setSize(370, 270);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FlowLayout flow = new FlowLayout(FlowLayout.RIGHT);
        setLayout(flow);

        JPanel row1 = new JPanel();
        JLabel toLabel = new JLabel("To:");
        row1.add(toLabel);
        JTextField to = new JTextField(24);
        row1.add(to);
        add(row1);

        JPanel row2 = new JPanel();
        JLabel subjectLabel = new JLabel("Subject:");
        row2.add(subjectLabel);
        JTextField subject = new JTextField(24);
        row2.add(subject);
        add(row2);

        JPanel row3 = new JPanel();
        JLabel messageLabel = new JLabel("Message:");
        row3.add(messageLabel);
        JTextArea message = new JTextArea(4, 22);
        message.setLineWrap(true);
        message.setWrapStyleWord(true);
        JScrollPane scroll = new JScrollPane(message,
        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
        JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        row3.add(scroll);
        add(row3);

        JPanel row4 = new JPanel();
        JButton send = new JButton("Send");
        row4.add(send);
        add(row4);

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
        MailWriter mail = new MailWriter();
    }
}