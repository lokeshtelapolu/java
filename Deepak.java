import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

class Deepak extends JFrame implements ActionListener {
    private JLabel nameLabel, sourceLabel, destLabel, dateLabel, numPassengersLabel, mobileLabel, ticketPreviewLabel, seatLabel, bookingDateLabel;
    private JTextField nameField, numPassengersField, mobileField, seatField;
    private JComboBox<String> sourceCombo, destCombo, dayCombo, monthCombo, yearCombo, bookingDayCombo, bookingMonthCombo, bookingYearCombo;
    private JButton submitButton, exitButton, okButton, resetButton;
    private JCheckBox returnCheckBox;
    private JTextArea ticketTextArea;

    private LinkedHashMap<String, Integer> sourceMap = new LinkedHashMap<>();
    private LinkedHashMap<String, Integer> destMap = new LinkedHashMap<>();

    private String[] days = new String[31];
    private String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    private String[] years = new String[50];

    private static final Set<String> MONTHS_WITH_31_DAYS = new HashSet<>(Arrays.asList("January", "March", "May", "July", "August", "October", "December"));

    public Deepak() {
        setTitle("Airline Ticket Reservation");
        setSize(1200, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        initializeLocationMaps();
        addTitleLabel();
        addTicketPreviewComponents();
        addInputFieldsAndLabels();

        setVisible(true);
    }

    private void initializeLocationMaps() {
        sourceMap.put("New Delhi", 1750);
        sourceMap.put("Mumbai", 1600);
        sourceMap.put("Chennai", 1800);
        sourceMap.put("Vijayawada", 1750);
        sourceMap.put("Bengaluru", 1450);
        sourceMap.put("Hyderabad", 1500);

        destMap.put("New Delhi", 1750);
        destMap.put("Mumbai", 1600);
        destMap.put("Chennai", 1800);
        destMap.put("Vijayawada", 1750);
        destMap.put("Bengaluru", 1450);
        destMap.put("Hyderabad", 1500);
    }

    private void addTitleLabel() {
        JLabel titleLabel = new JLabel("Airline Ticket Reservation");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 60));
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setBounds(100, 10, 800, 100);
        add(titleLabel);
    }

    private void addTicketPreviewComponents() {
        ticketPreviewLabel = new JLabel("Ticket Preview");
        ticketPreviewLabel.setFont(new Font("Serif", Font.BOLD, 36));
        ticketPreviewLabel.setBounds(850, 30, 300, 50);
        add(ticketPreviewLabel);

        ticketTextArea = new JTextArea();
        ticketTextArea.setEditable(false);
        ticketTextArea.setFont(new Font("Serif", Font.PLAIN, 20));
        JScrollPane scrollPane = new JScrollPane(ticketTextArea);
        scrollPane.setBounds(850, 100, 300, 400);
        add(scrollPane);
    }

    private void addInputFieldsAndLabels() {
        addLabelAndField("Passenger Name:", 120, nameField = new JTextField());
        addLabelAndComboBox("Source:", 170, sourceCombo = new JComboBox<>(sourceMap.keySet().toArray(new String[0])));
        addLabelAndComboBox("Destination:", 220, destCombo = new JComboBox<>(destMap.keySet().toArray(new String[0])));
        addLabelAndField("Mobile Number:", 270, mobileField = new JTextField());

        addLabelAndDateComboBoxes();
        addLabelAndBookingDateComboBoxes();

        addLabelAndField("Number of Passengers:", 370, numPassengersField = new JTextField());

        returnCheckBox = new JCheckBox("Return Journey");
        returnCheckBox.setFont(new Font("Serif", Font.PLAIN, 20));
        returnCheckBox.setBounds(20, 420, 300, 30);
        add(returnCheckBox);

        addLabelAndField("Seat Number:", 470, seatField = new JTextField());

        addButtons();
    }

    private void addLabelAndField(String labelText, int yPos, JTextField textField) {
        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Serif", Font.PLAIN, 20));
        label.setBounds(20, yPos, 200, 30);
        add(label);

        textField.setFont(new Font("Serif", Font.PLAIN, 20));
        textField.setBounds(250, yPos, 300, 30);
        add(textField);
    }

    private void addLabelAndComboBox(String labelText, int yPos, JComboBox<String> comboBox) {
        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Serif", Font.PLAIN, 20));
        label.setBounds(20, yPos, 200, 30);
        add(label);

        comboBox.setFont(new Font("Serif", Font.PLAIN, 20));
        comboBox.setBounds(250, yPos, 300, 30);
        add(comboBox);
    }

    private void addLabelAndDateComboBoxes() {
        dateLabel = new JLabel("Travel Date:");
        dateLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        dateLabel.setBounds(20, 320, 200, 30);
        add(dateLabel);

        for (int i = 0; i < 31; i++) {
            days[i] = Integer.toString(i + 1);
        }
        dayCombo = new JComboBox<>(days);
        dayCombo.setFont(new Font("Serif", Font.PLAIN, 20));
        dayCombo.setBounds(250, 320, 60, 30);
        add(dayCombo);

        monthCombo = new JComboBox<>(months);
        monthCombo.setFont(new Font("Serif", Font.PLAIN, 20));
        monthCombo.setBounds(320, 320, 120, 30);
        add(monthCombo);

        Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR);
        for (int i = 0; i < 50; i++) {
            years[i] = Integer.toString(year + i);
        }
        yearCombo = new JComboBox<>(years);
        yearCombo.setFont(new Font("Serif", Font.PLAIN, 20));
        yearCombo.setBounds(450, 320, 100, 30);
        add(yearCombo);
    }

    private void addLabelAndBookingDateComboBoxes() {
        bookingDateLabel = new JLabel("Booking Date:");
        bookingDateLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        bookingDateLabel.setBounds(20, 570, 200, 30);
        add(bookingDateLabel);

        for (int i = 0; i < 31; i++) {
            days[i] = Integer.toString(i + 1);
        }
        bookingDayCombo = new JComboBox<>(days);
        bookingDayCombo.setFont(new Font("Serif", Font.PLAIN, 20));
        bookingDayCombo.setBounds(250, 570, 60, 30);
        add(bookingDayCombo);

        monthCombo = new JComboBox<>(months);
        monthCombo.setFont(new Font("Serif", Font.PLAIN, 20));
        monthCombo.setBounds(320, 570, 120, 30);
        add(monthCombo);

        Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR);
        for (int i = 0; i < 50; i++) {
            years[i] = Integer.toString(year + i);
        }
        bookingYearCombo = new JComboBox<>(years);
        bookingYearCombo.setFont(new Font("Serif", Font.PLAIN, 20));
        bookingYearCombo.setBounds(450, 570, 100, 30);
        add(bookingYearCombo);
    }

    private void addButtons() {
        submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Serif", Font.PLAIN, 20));
        submitButton.setBounds(50, 620, 150, 40);
        submitButton.addActionListener(this);
        add(submitButton);

        exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Serif", Font.PLAIN, 20));
        exitButton.setBounds(250, 620, 150, 40);
        exitButton.addActionListener(this);
        add(exitButton);

        okButton = new JButton("OK");
        okButton.setFont(new Font("Serif", Font.PLAIN, 20));
        okButton.setBounds(850, 520, 100, 40);
        okButton.addActionListener(this);
        add(okButton);

        resetButton = new JButton("Reset");
        resetButton.setFont(new Font("Serif", Font.PLAIN, 20));
        resetButton.setBounds(1000, 520, 100, 40);
        resetButton.addActionListener(this);
        add(resetButton);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            String name = nameField.getText();
            String source = (String) sourceCombo.getSelectedItem();
            String dest = (String) destCombo.getSelectedItem();
            String travelDate = dayCombo.getSelectedItem() + " " + monthCombo.getSelectedItem() + " " + bookingYearCombo.getSelectedItem();
            String mobileNumber = mobileField.getText();
            int numSeats = Integer.parseInt(numPassengersField.getText());
            String seatNumber = seatField.getText();
            float cost = sourceMap.get(source);
            String bookingDate = bookingDayCombo.getSelectedItem() + " " + monthCombo.getSelectedItem() + " " + bookingYearCombo.getSelectedItem(); // Get booking date

            printTicket(name, source, dest, travelDate, mobileNumber, numSeats, seatNumber, cost, bookingDate); // Print ticket with booking date
        } else if (e.getSource() == exitButton) {
            System.exit(0);
        } else if (e.getSource() == okButton) {
            ticketTextArea.setText(""); // Clear ticket area
        } else if (e.getSource() == resetButton) {
            resetFields(); // Reset input fields
        }
    }

    private void printTicket(String name, String source, String dest, String travelDate, String mobileNumber, int numSeats, String seatNumber, float cost, String bookingDate) {
        String ticketDetails = "Passenger Name: " + name + "\n" +
                "Source: " + source + "\n" +
                "Destination: " + dest + "\n" +
                "Travel Date: " + travelDate + "\n" +
                "Mobile Number: " + mobileNumber + "\n" +
                "Number of Passengers: " + numSeats + "\n" +
                "Seat Number: " + seatNumber + "\n" +
                "Total Cost: Rs. " + cost + "\n" +
                "Booking Date: " + bookingDate; // Include booking date

        ticketTextArea.setText(ticketDetails);
    }

    private void resetFields() {
        nameField.setText("");
        mobileField.setText("");
        numPassengersField.setText("");
        seatField.setText("");
        sourceCombo.setSelectedIndex(0);
        destCombo.setSelectedIndex(0);
        dayCombo.setSelectedIndex(0);
        monthCombo.setSelectedIndex(0);
        yearCombo.setSelectedIndex(0);
        bookingDayCombo.setSelectedIndex(0);
        bookingMonthCombo.setSelectedIndex(0);
        bookingYearCombo.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        new Deepak(); // Start the application
    }
}
