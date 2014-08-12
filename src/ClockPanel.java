import javax.swing.*;
import java.awt.*;
import java.util.*;

public class ClockPanel extends JPanel {
    public ClockPanel() {
        super();
        String currentTime = getTime();
        JLabel time = new JLabel("Time: ");
        JLabel current = new JLabel(currentTime);
        add(time);
        add(current);
    }

    final String getTime() {
        String time;
        // get current time and date
        Calendar now = Calendar.getInstance();
        int hour = now.get(Calendar.HOUR_OF_DAY);
        int minute = now.get(Calendar.MINUTE);
        int month = now.get(Calendar.MONTH) + 1;
        int day = now.get(Calendar.DAY_OF_MONTH);
        int year = now.get(Calendar.YEAR);

        String monthName = "";
        switch (month) {
            case (1):
                monthName = "January";
            break;
            case (2):
                monthName = "February";
            break;
            case (3):
                monthName = "March";
            break;
            case (4):
                monthName = "April";
            break;
            case (5):
                monthName = "May";
            break;
            case (6):
                monthName = "June";
            break;
            case (7):
                monthName = "July";
            break;
            case (8):
                monthName = "August";
            break;
            case (9):
                monthName = "September";
            break;
            case (10):
                monthName = "October";
            break;
            case (11):
                monthName = "November";
            break;
            case (12):
                monthName = "December";
        }
        time = monthName + " " + day + ", " + year + " "
        + hour + ":" + minute;
        return time;
    }
}