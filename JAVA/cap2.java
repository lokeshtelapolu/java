
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
class King extends JFrame implements ActionListener {
    private JLabel nameLabel, sourceLabel, destLabel, dateLabel, numPassengersLabel, mobileLabel, ticketPreviewLabel, seatLabel;
    private JTextField nameField, numPassengersField, mobileField, seatField;
    private JComboBox<String> sourceCombo, destCombo, dayCombo, monthCombo, yearCombo;
    private JButton submitButton, exitButton, okButton, resetButton;
    private JCheckBox returnCheckBox;
    private JTextArea ticketTextArea;
    private LinkedHashMap<String, Integer> sourceMap = new LinkedHashMap<>();
    private LinkedHashMap<String, Integer> destMap = new LinkedHashMap<>();
    private String[] days = new String[31];
    private String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    private String[] years = new String[50];
    private static final Set<String> MONTHS_WITH_31_DAYS = new HashSet<>(Arrays.asList("January", "March", "May", "July", "August", "October", "December"));

    public King() {
        setTitle("Bus Ticket Reservation");
        setSize(1200, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Populate source and destination maps
        initializeLocationMaps();

        // Title label
        addTitleLabel();

        // Ticket preview components
        addTicketPreviewComponents();

        // Input fields and labels
        addInputFieldsAndLabels();

        setVisible(true);
    }

    private void initializeLocationMaps() {
        sourceMap.put("New Delhi", 750);
        sourceMap.put("Mumbai", 600);
        sourceMap.put("Chennai", 350);
        sourceMap.put("Kolkata", 700);
        sourceMap.put("Bengaluru", 450);
        sourceMap.put("Pune", 550);

        destMap.put("New Delhi", 750);
        destMap.put("Mumbai", 600);
        destMap.put("Chennai", 350);
        destMap.put("Kolkata", 700);
        destMap.put("Bengaluru", 450);
        destMap.put("Pune", 550);
    }

    private void addTitleLabel() {
        JLabel titleLabel = new JLabel("Bus Ticket Reservation");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 60));
        titleLabel.setForeground(Color.BLUE);
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
        monthCombo.addActionListener(this);
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

    private void addButtons() {
        submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Serif", Font.PLAIN, 20));
        submitButton.setBounds(50, 530, 150, 40);
        submitButton.addActionListener(this);
        add(submitButton);

        exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Serif", Font.PLAIN, 20));
        exitButton.setBounds(250, 530, 150, 40);
        exitButton.addActionListener(this);
        add(exitButton);

        okButton = new JButton("OK");
        okButton.setFont(new Font("Serif", Font.PLAIN, 20));
        okButton.setBounds(850, 520, 100, 40);
        okButton.addActionListener(this);
        add(okButton);

        resetButton = new JButton("Reset");
        resetButton.setFont(new Font("Serif", Font.PLAIN, 20));
        resetButton.setBounds(970, 520, 100, 40);
        resetButton.addActionListener(this);
        add(resetButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            handleSubmit();
        } else if (e.getSource() == resetButton) {
            resetFields();
        } else if (e.getSource() == exitButton) {
            dispose();
        } else if (e.getSource() == okButton) {
            printTicketFromPreview();
        }
    }

    private void handleSubmit() {
        try {
            String name = nameField.getText();
            String source = (String) sourceCombo.getSelectedItem();
            String dest = (String) destCombo.getSelectedItem();
            String mobileNumber = mobileField.getText();
            String day = (String) dayCombo.getSelectedItem();
            String month = (String) monthCombo.getSelectedItem();
            String year = (String) yearCombo.getSelectedItem();
            int numPassengers = Integer.parseInt(numPassengersField.getText());
            String seatNumber = seatField.getText();

            validateInputs(name, source, dest, mobileNumber, day, month, year, numPassengers, seatNumber);

            String travelDate = day + " " + month + " " + year;
            int distance = Math.abs(sourceMap.get(source) - destMap.get(dest));
            float cost = calculateCost(distance, numPassengers);

            if (returnCheckBox.isSelected()) {
                cost *= 2; // Double the cost for return journey
            }

            printTicket(name, source, dest, travelDate, mobileNumber, numPassengers, seatNumber, cost);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numeric values for number of passengers.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void validateInputs(String name, String source, String dest, String mobileNumber, String day, String month, String year, int numPassengers, String seatNumber) throws Exception {
        if (name.isEmpty() || source.isEmpty() || dest.isEmpty() || mobileNumber.isEmpty() || day.isEmpty() || month.isEmpty() || year.isEmpty() || seatNumber.isEmpty()) {
            throw new Exception("All fields are mandatory.");
        }

        if (mobileNumber.length() < 10) {
            throw new Exception("Mobile number must be at least 10 digits.");
        }

        Calendar selectedDate = Calendar.getInstance();
        selectedDate.set(Integer.parseInt(year), Arrays.asList(months).indexOf(month), Integer.parseInt(day));
        if (selectedDate.before(Calendar.getInstance())) {
            throw new Exception("Travel date cannot be earlier than the current date.");
        }

        if (day.equals("31") && !MONTHS_WITH_31_DAYS.contains(month)) {
            throw new Exception("Invalid day selected for " + month + ".");
        }

        if (source.equals(dest)) {
            throw new Exception("Source and Destination cannot be the same.");
        }
    }

    private float calculateCost(int distance, int numPassengers) {
        float ratePerKm = 5.0f; // Assume a rate per kilometer
        return ratePerKm * distance * numPassengers;
    }

    private void printTicket(String name, String source, String dest, String travelDate, String mobileNumber, int numSeats, String seatNumber, float cost) {
        String ticketDetails = "Passenger Name: " + name + "\nSource: " + source + "\nDestination: " + dest +
                "\nTravel Date: " + travelDate + "\nMobile Number: " + mobileNumber + "\nNumber of Passengers: " + numSeats +
                "\nSeat Number: " + seatNumber + "\nTotal Cost: Rs. " + cost;

        ticketTextArea.setText(ticketDetails);
    }

    private void resetFields() {
        nameField.setText("");
        sourceCombo.setSelectedIndex(0);
        destCombo.setSelectedIndex(0);
        mobileField.setText("");
        dayCombo.setSelectedIndex(0);
        monthCombo.setSelectedIndex(0);
        yearCombo.setSelectedIndex(0);
        numPassengersField.setText("");
        returnCheckBox.setSelected(false);
        seatField.setText("");
        ticketTextArea.setText("");
    }

    private void printTicketFromPreview() {
        String ticketDetails = ticketTextArea.getText();
        if (!ticketDetails.isEmpty()) {
            JOptionPane.showMessageDialog(this, ticketDetails, "Print Ticket", JOptionPane.PLAIN_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "No ticket to print. Generate a ticket first.", "Print Ticket", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LoginFrame::new);
    }
}

class LoginFrame extends JFrame implements ActionListener {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginFrame() {
        setTitle("Login");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        addTitleLabel();
        addUsernameAndPasswordFields();
        addLoginButton();

        setVisible(true);
    }

    private void addTitleLabel() {
        JLabel titleLabel = new JLabel("Bus Reservation System Login");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
        titleLabel.setBounds(50, 20, 300, 30);
        add(titleLabel);
    }

    private void addUsernameAndPasswordFields() {
        addLabelAndField("Username:", 80, usernameField = new JTextField());
        addLabelAndField("Password:", 130, passwordField = new JPasswordField());
    }

    private void addLabelAndField(String labelText, int yPos, JTextField textField) {
        JLabel label = new JLabel(labelText);
        label.setBounds(50, yPos, 80, 30);
        add(label);

        textField.setBounds(140, yPos, 200, 30);
        add(textField);
    }

    private void addLoginButton() {
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(150, 200, 100, 40);
        loginButton.addActionListener(this);
        add(loginButton);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        // Check login credentials (for demonstration purposes)
        if (username.equals("sai") && password.equals("1234")) {
            JOptionPane.showMessageDialog(this, "Login successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
            new King();
            dispose(); // Close the login window
        } else {
            JOptionPane.showMessageDialog(this, "Invalid username or password.", "Login Failed", JOptionPane.ERROR_MESSAGE);
        }
    }
}
