import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

public class Staff extends JFrame implements ActionListener {

    JFrame staffFrame = new JFrame("Student Grading System");
    private final DatabaseInfo dbInfo;
    private final DatabaseConnect dbConnect;
    private JTextArea displayArea;

    public Staff() {
        // remember to edit databasename at the end of the line below this one
        dbInfo = new DatabaseInfo("root", "", "jdbc:mysql://localhost:3306/grading_system");
        dbConnect = new DatabaseConnect(dbInfo);

        staffFrame.setIconImage(new ImageIcon("img/logo.png").getImage());
        staffFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        staffFrame.setPreferredSize(new Dimension(450, 500));

        // Panel
        JPanel staffPanel = new JPanel(new GridBagLayout());
        staffPanel.setBackground(new Color(11, 18, 21));
        GridBagConstraints staffConstraints = new GridBagConstraints();
        staffConstraints.insets = new Insets(5, 5, 5, 5);
        staffConstraints.fill = GridBagConstraints.HORIZONTAL;

        // title Label
        JLabel titleLabel = new JLabel("GRADE RECORDING SYSTEM", JLabel.CENTER);
        titleLabel.setFont(new Font("Google Sans", Font.BOLD, 35));
        titleLabel.setForeground(new Color(230, 230, 230));
        staffConstraints.gridx = 0;
        staffConstraints.gridy = 0;
        staffConstraints.gridwidth = 3;
        staffPanel.add(titleLabel, staffConstraints);

        // Sub-Text
        JLabel subLabel = new JLabel("Enter Information to Continue", JLabel.CENTER);
        subLabel.setForeground(new Color(230, 230, 230));
        subLabel.setFont(new Font("Google Sans", Font.PLAIN, 24));
        staffConstraints.gridy = 1;
        staffPanel.add(subLabel, staffConstraints);

        // Empty space
        staffConstraints.gridy = 2;
        staffPanel.add(new JLabel(" "), staffConstraints);

        // Display area
        displayArea = new JTextArea(20, 30);
        displayArea.setBackground(new Color(11, 18, 21));
        displayArea.setForeground(new Color(244, 244, 244));
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);
        staffConstraints.gridy = 3;
        staffPanel.add(scrollPane, staffConstraints);

        // Record Transactions container
        JPanel buttonPanel = new JPanel(new GridBagLayout());
        buttonPanel.setBorder(BorderFactory.createLineBorder(new Color(230, 230, 230)));
        buttonPanel.setBorder(BorderFactory.createTitledBorder("Record Functions"));
        TitledBorder border = BorderFactory.createTitledBorder("Record Functions");
        border.setTitleColor(new Color(230, 230, 230));
        buttonPanel.setBorder(border);
        buttonPanel.setBackground(new Color(11, 18, 21));
        buttonPanel.setBackground(new Color(11, 18, 21));
        GridBagConstraints buttonConstraints = new GridBagConstraints();
        buttonConstraints.insets = new Insets(5, 5, 5, 5);
        buttonConstraints.fill = GridBagConstraints.HORIZONTAL;

        // Action buttons
        JButton addButton = new JButton("Add User");
        addButton.addActionListener(this);
        addButton.setActionCommand("Add");
        addButton.setFocusable(false);
        addButton.setBackground(new Color(13, 20, 23));
        addButton.setForeground(new Color(230, 230, 230));
        buttonConstraints.gridx = 0;
        buttonConstraints.gridy = 0;
        buttonPanel.add(addButton, buttonConstraints);

        JButton showButton = new JButton("Show Records");
        showButton.addActionListener(this);
        showButton.setActionCommand("Show");
        showButton.setFocusable(false);
        showButton.setBackground(new Color(13, 20, 23));
        showButton.setForeground(new Color(230, 230, 230));
        buttonConstraints.gridx = 1;
        buttonConstraints.gridy = 0;
        buttonPanel.add(showButton, buttonConstraints);

        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(this);
        searchButton.setActionCommand("Search");
        searchButton.setFocusable(false);
        searchButton.setBackground(new Color(13, 20, 23));
        searchButton.setForeground(new Color(230, 230, 230));
        buttonConstraints.gridx = 0;
        buttonConstraints.gridy = 1;
        buttonPanel.add(searchButton, buttonConstraints);

        JButton editButton = new JButton("Edit");
        editButton.addActionListener(this);
        editButton.setActionCommand("Edit");
        editButton.setFocusable(false);
        editButton.setBackground(new Color(13, 20, 23));
        editButton.setForeground(new Color(230, 230, 230));
        buttonConstraints.gridx = 1;
        buttonConstraints.gridy = 1;
        buttonPanel.add(editButton, buttonConstraints);

        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(this);
        deleteButton.setActionCommand("Delete");
        deleteButton.setFocusable(false);
        deleteButton.setBackground(new Color(13, 20, 23));
        deleteButton.setForeground(new Color(230, 230, 230));
        buttonConstraints.gridx = 0;
        buttonConstraints.gridy = 2;
        buttonPanel.add(deleteButton, buttonConstraints);

        JButton exitButton = new JButton("Log Out");
        exitButton.addActionListener(this);
        exitButton.setActionCommand("Back");
        add(exitButton);
        pack();
        exitButton.setFocusable(false);
        exitButton.setBackground(new Color(13, 20, 23));
        exitButton.setForeground(new Color(230, 230, 230));
        buttonConstraints.gridx = 1;
        buttonConstraints.gridy = 2;
        buttonPanel.add(exitButton, buttonConstraints);

        // Button Resizer Code
        JButton[] buttons = { addButton, showButton, searchButton, editButton, deleteButton, exitButton };

        Dimension maxSize = new Dimension(0, 0);
        for (JButton button : buttons) {
            button.setFocusable(false);
            Dimension size = button.getPreferredSize();
            if (size.width > maxSize.width)
                maxSize.width = size.width;
            if (size.height > maxSize.height)
                maxSize.height = size.height;
        }

        for (JButton button : buttons) {
            button.setPreferredSize(maxSize);
        }
        // End of Button Resizer

        buttonConstraints.gridy = 6;
        buttonConstraints.gridwidth = 3;
        staffPanel.add(buttonPanel, staffConstraints);

        staffConstraints.gridy = 4;
        staffConstraints.gridwidth = 3;
        staffPanel.add(buttonPanel, staffConstraints);

        staffFrame.add(staffPanel);
        staffFrame.pack();
        staffFrame.setLocationRelativeTo(null);
        staffFrame.setVisible(true);
        staffFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        switch (cmd) {
            case "Back":
                UIManager.put("Panel.background", new Color(11, 18, 21));
                UIManager.put("OptionPane.background", new Color(11, 18, 21));
                UIManager.put("OptionPane.foreground", new Color(230,230,230));
                UIManager.put("OptionPane.messageForeground", new Color(230, 230, 230));
                UIManager.put("Button.background", new Color(13, 20, 23));
                UIManager.put("Button.foreground", new Color(230,230,230));
                UIManager.put("Button.focusable", false);
                UIManager.put("JTextField.background", new Color(13, 20, 23));
                UIManager.put("JTextField.foreground", new Color(230,230,230));
                UIManager.put("JLabel.foreground", new Color(230,230,230));
                UIManager.put("JLabel.background", new Color(13, 20, 23));
        
                 int choice = JOptionPane.showConfirmDialog(
                    staffFrame, "Do you want to logout?", "Logout",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);

                if (choice == JOptionPane.YES_OPTION) {
                    staffFrame.dispose();
                    LoginUI login = new LoginUI();
                    login.Login();
                }
                break;

            case "Add":
                try {
                    JTextField nameField = new JTextField();
                    nameField.setForeground(new Color(230,230,230));
                    nameField.setBackground(new Color(13,20,23));
                    
                    JTextField scienceField = new JTextField();
                    scienceField.setForeground(new Color(230,230,230));
                    scienceField.setBackground(new Color(13,20,23));

                    JTextField englishField = new JTextField();
                    englishField.setForeground(new Color(230,230,230));
                    englishField.setBackground(new Color(13,20,23));

                    JTextField mathField = new JTextField();
                    mathField.setForeground(new Color(230,230,230));
                    mathField.setBackground(new Color(13,20,23));

                    JTextField mapehField = new JTextField();
                    mapehField.setForeground(new Color(230,230,230));
                    mapehField.setBackground(new Color(13,20,23));

                    JTextField filipinoField = new JTextField();
                    filipinoField.setForeground(new Color(230,230,230));
                    filipinoField.setBackground(new Color(13,20,23));

                    JTextField espField = new JTextField();
                    espField.setForeground(new Color(230,230,230));
                    espField.setBackground(new Color(13,20,23));

                    JTextField apField = new JTextField();
                    apField.setForeground(new Color(230,230,230));
                    apField.setBackground(new Color(13,20,23));

                    JPanel panel = new JPanel(new java.awt.GridLayout(0, 2));
                    JLabel nameLabel = new JLabel("Student Name:");
                    nameLabel.setForeground(new Color(230,230,230));
                    panel.add(nameLabel);
                    panel.add(nameField);

                    JLabel scienceLabel = new JLabel("Science:");
                    scienceLabel.setForeground(new Color(230,230,230));
                    panel.add(scienceLabel);
                    panel.add(scienceField);

                    JLabel englishLabel = new JLabel("English:");
                    englishLabel.setForeground(new Color(230,230,230));
                    panel.add(englishLabel);
                    panel.add(englishField);

                    JLabel mathLabel = new JLabel("Math:");
                    mathLabel.setForeground(new Color(230,230,230));
                    panel.add(mathLabel);
                    panel.add(mathField);

                    JLabel mapehLabel = new JLabel("MAPEH:");
                    mapehLabel.setForeground(new Color(230,230,230));
                    panel.add(mapehLabel);
                    panel.add(mapehField);

                    JLabel filipinoLabel = new JLabel("Filipino:");
                    filipinoLabel.setForeground(new Color(230,230,230));
                    panel.add(filipinoLabel);
                    panel.add(filipinoField);

                    JLabel espLabel = new JLabel("ESP:");
                    espLabel.setForeground(new Color(230,230,230));
                    panel.add(espLabel);
                    panel.add(espField);

                    JLabel apLabel = new JLabel("AP:");
                    apLabel.setForeground(new Color(230,230,230));
                    panel.add(apLabel);
                    panel.add(apField);
                    panel.setBackground(new Color(11, 18, 21));
                    panel.setForeground(new Color(230, 230, 230));

                    // Change dialog colors
                    UIManager.put("Panel.background", new Color(11, 18, 21));
                    UIManager.put("OptionPane.background", new Color(11, 18, 21));
                    UIManager.put("OptionPane.foreground", new Color(230,230,230));
                    UIManager.put("OptionPane.messageForeground", new Color(230, 230, 230));
                    UIManager.put("Button.background", new Color(13, 20, 23));
                    UIManager.put("Button.foreground", new Color(230,230,230));
                    UIManager.put("Button.focusable", false);
                    UIManager.put("JTextField.background", new Color(13, 20, 23));
                    UIManager.put("JTextField.foreground", new Color(230,230,230));
                    UIManager.put("JLabel.foreground", new Color(230,230,230));
                    UIManager.put("JLabel.background", new Color(13, 20, 23));

                    int addResult = JOptionPane.showConfirmDialog(this, panel, "Enter Student Grades",
                            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                    if (addResult == JOptionPane.OK_OPTION) {
                        String name = nameField.getText().trim();
                        if (name.isEmpty()) {
                            JOptionPane.showMessageDialog(this, "Student name is required.");
                            break;
                        }

                        double[] grades = new double[7];
                        JTextField[] fields = { scienceField, englishField, mathField, mapehField, filipinoField,
                                espField, apField };
                        for (int i = 0; i < 7; i++) {
                            grades[i] = Double.parseDouble(fields[i].getText().trim());
                            if (grades[i] < 0 || grades[i] > 100) {
                                JOptionPane.showMessageDialog(this, "Grades must be between 0 and 100.");
                                return;
                            }
                        }

                        double average = 0;
                        for (double g : grades)
                            average += g;
                        average /= grades.length;

                        boolean success = dbConnect.addStudent(name, grades[0], grades[1], grades[2], grades[3],
                                grades[4], grades[5], grades[6], average);

                        if (success) {
                            JOptionPane.showMessageDialog(this,
                                    "Student added successfully! Average: " + String.format("%.2f", average));
                        } else {
                            JOptionPane.showMessageDialog(this, "Failed to add student.");
                        }
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Please enter numeric grades only.");
                }
                break;

            case "Show":
                ArrayList<String> records = dbConnect.getAllStudents();
                if (records.isEmpty()) {
                    displayArea.setText("No student records found.");
                } else {
                    displayArea.setText("");
                    for (String record : records) {
                        displayArea.append(record);
                    }
                }
                break;

            case "Search":

                UIManager.put("Panel.background", new Color(11, 18, 21));
                UIManager.put("OptionPane.background", new Color(11, 18, 21));
                UIManager.put("OptionPane.messageForeground", Color.WHITE);
                UIManager.put("TextField.background", new Color(13,20,23));
                UIManager.put("TextField.foreground", new Color(230,230,230));

                String searchName = JOptionPane.showInputDialog(this, "Enter the student's name to search:");
                if (searchName == null || searchName.isEmpty())
                    break;

                String result = dbConnect.searchStudentByName(searchName);
                displayArea.setText(result);
                
                break;

            case "Edit":

                UIManager.put("Panel.background", new Color(11, 18, 21));
                UIManager.put("OptionPane.background", new Color(11, 18, 21));
                UIManager.put("OptionPane.messageForeground", Color.WHITE);
                UIManager.put("TextField.background", new Color(13,20,23));
                UIManager.put("TextField.foreground", new Color(230,230,230));

                String editName = JOptionPane.showInputDialog(this, "Enter the student's name to edit:");
                if (editName == null || editName.isEmpty())
                    break;

                String currentRecord = dbConnect.searchStudentByName(editName);
                if (currentRecord.equals("Student not found.")) {
                    displayArea.setText(currentRecord);
                    break;
                }

                displayArea.setText(currentRecord);

                try {
                    JTextField nameField = new JTextField();
                    nameField.setForeground(new Color(230,230,230));
                    nameField.setBackground(new Color(13,20,23));
                    
                    JTextField scienceField = new JTextField();
                    scienceField.setForeground(new Color(230,230,230));
                    scienceField.setBackground(new Color(13,20,23));

                    JTextField englishField = new JTextField();
                    englishField.setForeground(new Color(230,230,230));
                    englishField.setBackground(new Color(13,20,23));

                    JTextField mathField = new JTextField();
                    mathField.setForeground(new Color(230,230,230));
                    mathField.setBackground(new Color(13,20,23));

                    JTextField mapehField = new JTextField();
                    mapehField.setForeground(new Color(230,230,230));
                    mapehField.setBackground(new Color(13,20,23));

                    JTextField filipinoField = new JTextField();
                    filipinoField.setForeground(new Color(230,230,230));
                    filipinoField.setBackground(new Color(13,20,23));

                    JTextField espField = new JTextField();
                    espField.setForeground(new Color(230,230,230));
                    espField.setBackground(new Color(13,20,23));

                    JTextField apField = new JTextField();
                    apField.setForeground(new Color(230,230,230));
                    apField.setBackground(new Color(13,20,23));

                    JPanel panel = new JPanel(new java.awt.GridLayout(0, 2));

                    JLabel scienceLabel = new JLabel("Science:");
                    scienceLabel.setForeground(Color.WHITE);
                    panel.add(scienceLabel);
                    panel.add(scienceField);

                    JLabel englishLabel = new JLabel("English:");
                    englishLabel.setForeground(Color.WHITE);
                    panel.add(englishLabel);
                    panel.add(englishField);

                    JLabel mathLabel = new JLabel("Math:");
                    mathLabel.setForeground(Color.WHITE);
                    panel.add(mathLabel);
                    panel.add(mathField);

                    JLabel mapehLabel = new JLabel("MAPEH:");
                    mapehLabel.setForeground(Color.WHITE);
                    panel.add(mapehLabel);
                    panel.add(mapehField);

                    JLabel filipinoLabel = new JLabel("Filipino:");
                    filipinoLabel.setForeground(Color.WHITE);
                    panel.add(filipinoLabel);
                    panel.add(filipinoField);

                    JLabel espLabel = new JLabel("ESP:");
                    espLabel.setForeground(Color.WHITE);
                    panel.add(espLabel);
                    panel.add(espField);

                    JLabel apLabel = new JLabel("AP:");
                    apLabel.setForeground(Color.WHITE);
                    panel.add(apLabel);
                    panel.add(apField);
                    panel.setBackground(new Color(11, 18, 21)); // Panel background

                    // Change dialog colors
                    UIManager.put("Panel.background", new Color(11, 18, 21));
                    UIManager.put("OptionPane.background", new Color(11, 18, 21));
                    UIManager.put("OptionPane.messageForeground", Color.WHITE); // Optional

                    int editResult = JOptionPane.showConfirmDialog(this, panel, "Enter New Grades",
                            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                    if (editResult == JOptionPane.OK_OPTION) {
                        double[] grades = new double[7];
                        JTextField[] fields = { scienceField, englishField, mathField, mapehField, filipinoField,
                                espField, apField };
                        for (int i = 0; i < 7; i++) {
                            grades[i] = Double.parseDouble(fields[i].getText().trim());
                            if (grades[i] < 0 || grades[i] > 100) {
                                JOptionPane.showMessageDialog(this, "Grades must be between 0 and 100.");
                                return;
                            }
                        }

                        double average = 0;
                        for (double g : grades)
                            average += g;
                        average /= grades.length;

                        boolean updated = dbConnect.updateStudentGrades(editName, grades[0], grades[1], grades[2],
                                grades[3], grades[4], grades[5], grades[6], average);

                        if (updated) {
                            displayArea.setText("Student's grades updated successfully.");
                        } else {
                            displayArea.setText("Failed to update grades.");
                        }
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Please enter valid numeric grades.");
                }
                break;

            case "Delete":

            UIManager.put("Panel.background", new Color(11, 18, 21));
            UIManager.put("OptionPane.background", new Color(11, 18, 21));
            UIManager.put("OptionPane.messageForeground", Color.WHITE);
            UIManager.put("TextField.background", new Color(13,20,23));
            UIManager.put("TextField.foreground", new Color(230,230,230));
            UIManager.put("Button.background", new Color(13, 20, 23));
            UIManager.put("Button.foreground", new Color(230,230,230));

                String deleteName = JOptionPane.showInputDialog(this, "Enter the student's name to delete:");
                if (deleteName == null || deleteName.isEmpty())
                    break;

                int confirmation = JOptionPane.showConfirmDialog(this,
                        "Are you sure you want to delete " + deleteName + "?", "Confirm Deletion",
                        JOptionPane.YES_NO_OPTION);
                        

                if (confirmation == JOptionPane.YES_OPTION) {
                    boolean deleted = dbConnect.deleteStudent(deleteName);
                    if (deleted) {
                        displayArea.setText("Student deleted successfully.");
                    } else {
                        displayArea.setText("Student not found.");
                    }
                }
                break;
        }
    }
}