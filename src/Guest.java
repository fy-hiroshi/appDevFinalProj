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
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

public class Guest extends JFrame implements ActionListener {

    JFrame guestFrame = new JFrame("Student Grading System");
    private final DatabaseInfo dbInfo;
    private final DatabaseConnect dbConnect;
    private JTextArea displayArea;

    public Guest() {
        // remember to edit databasename at the end of the line below this one
        dbInfo = new DatabaseInfo("root", "", "jdbc:mysql://localhost:3306/grading_system");
        dbConnect = new DatabaseConnect(dbInfo);

        guestFrame.setIconImage(new ImageIcon("img/logo.png").getImage());
        guestFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guestFrame.setPreferredSize(new Dimension(450, 500));

        // Panel
        JPanel guestPanel = new JPanel(new GridBagLayout());
        guestPanel.setBackground(new Color(11, 18, 21));
        GridBagConstraints guestConstraints = new GridBagConstraints();
        guestConstraints.insets = new Insets(5, 5, 5, 5);
        guestConstraints.fill = GridBagConstraints.HORIZONTAL;

        // title Label
        JLabel titleLabel = new JLabel("GRADE RECORDING SYSTEM", JLabel.CENTER);
        titleLabel.setFont(new Font("Google Sans", Font.BOLD, 35));
        titleLabel.setForeground(new Color(230, 230, 230));
        guestConstraints.gridx = 0;
        guestConstraints.gridy = 0;
        guestConstraints.gridwidth = 3;
        guestPanel.add(titleLabel, guestConstraints);

        // Sub-Text
        JLabel subLabel = new JLabel("See The Records of You and Your Classmates", JLabel.CENTER);
        subLabel.setForeground(new Color(230, 230, 230));
        subLabel.setFont(new Font("Google Sans", Font.PLAIN, 24));
        guestConstraints.gridy = 1;
        guestPanel.add(subLabel, guestConstraints);

        // Empty space
        guestConstraints.gridy = 2;
        guestPanel.add(new JLabel(" "), guestConstraints);

        // Display area
        displayArea = new JTextArea(20, 30);
        displayArea.setBackground(new Color(11, 18, 21));
        displayArea.setForeground(new Color(244, 244, 244));
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);
        guestConstraints.gridy = 3;
        guestPanel.add(scrollPane, guestConstraints);

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

        // For size
        Dimension thisSize = new Dimension(300, 25);

        // Action buttons
        JButton showButton = new JButton("Show Records");
        showButton.addActionListener(this);
        showButton.setActionCommand("Show");
        showButton.setFocusable(false);
        showButton.setBackground(new Color(13, 20, 23));
        showButton.setForeground(new Color(230, 230, 230));
        showButton.setPreferredSize(thisSize);
        buttonConstraints.gridx = 0;
        buttonConstraints.gridy = 0;
        buttonPanel.add(showButton, buttonConstraints);

        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(this);
        searchButton.setActionCommand("Search");
        searchButton.setFocusable(false);
        searchButton.setBackground(new Color(13, 20, 23));
        searchButton.setForeground(new Color(230, 230, 230));
        searchButton.setPreferredSize(thisSize);
        buttonConstraints.gridy = 1;
        buttonPanel.add(searchButton, buttonConstraints);

        JButton exitButton = new JButton("Log Out");
        exitButton.addActionListener(this);
        exitButton.setActionCommand("Back");
        add(exitButton);
        pack();
        exitButton.setFocusable(false);
        exitButton.setBackground(new Color(13, 20, 23));
        exitButton.setForeground(new Color(230, 230, 230));
        exitButton.setPreferredSize(thisSize);
        buttonConstraints.gridy = 2;
        buttonPanel.add(exitButton, buttonConstraints);

        buttonConstraints.gridy = 6;
        buttonConstraints.gridwidth = 3;
        guestPanel.add(buttonPanel, guestConstraints);

        guestConstraints.gridy = 4;
        guestConstraints.gridwidth = 3;
        guestPanel.add(buttonPanel, guestConstraints);

        guestFrame.add(guestPanel);
        guestFrame.pack();
        guestFrame.setLocationRelativeTo(null);
        guestFrame.setVisible(true);
        guestFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
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
                    guestFrame, "Do you want to logout?", "Logout",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);

                if (choice == JOptionPane.YES_OPTION) {
                    guestFrame.dispose();
                    LoginUI login = new LoginUI();
                    login.Login();
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
                UIManager.put("Button.background", new Color(13, 20, 23));
                UIManager.put("Button.foreground", new Color(230,230,230));

                String searchName = JOptionPane.showInputDialog(this, "Enter the student's name to search:");
                if (searchName == null || searchName.isEmpty())
                    break;

                String result = dbConnect.searchStudentByName(searchName);
                displayArea.setText(result);
                break;
        }
    }
}