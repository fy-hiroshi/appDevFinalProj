import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class LoginUI extends JFrame implements ActionListener {

    JFrame frame = new JFrame("Student Grading System");
    
    JPasswordField passField = new JPasswordField(20);
    JTextField userField = new JTextField(20);
    JButton loginButton = new JButton("Login");
    JButton exitButton = new JButton("Exit");

    public void Login() {

        // Frame
        frame.setIconImage(new ImageIcon("img/logo.png").getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(450, 650));

        // Panel
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(new Color(11, 18, 21));
        GridBagConstraints mainConstraints = new GridBagConstraints();
        mainConstraints.insets = new Insets(5, 5, 5, 5);
        mainConstraints.fill = GridBagConstraints.HORIZONTAL;

        //For Size
        Dimension buttonSize = new Dimension(150, 45);

        // Login Label
        JLabel titleLabel = new JLabel("Login To Start", JLabel.CENTER);
        titleLabel.setFont(new Font("Google Sans", Font.BOLD, 40));
        titleLabel.setForeground(new Color(230, 230, 230));
        mainConstraints.gridx = 0;
        mainConstraints.gridy = 0;
        mainConstraints.gridwidth = 2;
        mainPanel.add(titleLabel, mainConstraints);

        // Sub-Text
        JLabel subLabel = new JLabel("Enter provided credentials to continue", JLabel.CENTER);
        subLabel.setForeground(new Color(230, 230, 230));
        subLabel.setFont(new Font("Google Sans", Font.PLAIN, 24));
        mainConstraints.gridy = 1;
        mainPanel.add(subLabel, mainConstraints);

        // Empty space
        mainConstraints.gridy = 2;
        mainPanel.add(new JLabel(" "), mainConstraints);

        // Record container
        JPanel inputPanel = new JPanel(new GridBagLayout());
        inputPanel.setBorder(BorderFactory.createLineBorder(new Color(230, 230, 230)));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Input Credentials"));
        TitledBorder border = BorderFactory.createTitledBorder("Input Credentials");
        border.setTitleColor(new Color(230, 230, 230));
        inputPanel.setBorder(border);
        inputPanel.setBackground(new Color(11, 18, 21));
        GridBagConstraints inputConstraints = new GridBagConstraints();
        inputConstraints.insets = new Insets(5, 5, 5, 5);
        inputConstraints.fill = GridBagConstraints.HORIZONTAL;

        //User Label
        JLabel userLabel = new JLabel("User:");
        userLabel.setForeground(new Color(230, 230, 230));
        inputConstraints.gridx = 0;
        inputConstraints.gridy = 0;
        inputPanel.add(userLabel, inputConstraints);

        //User Field
        userField.setBackground(new Color(11, 18, 21));
        userField.setForeground(new Color(230, 230, 230));
        inputConstraints.gridx = 1;
        inputConstraints.gridy = 0;
        inputPanel.add(userField, inputConstraints);

        //Password Label
        JLabel passLabel = new JLabel("Password:");
        passLabel.setForeground(new Color(230, 230, 230));
        inputConstraints.gridx = 0;
        inputConstraints.gridy = 1;
        inputPanel.add(passLabel, inputConstraints);

        // Password Field
        passField.addActionListener(this);
        passField.setBackground(new Color(11, 18, 21));
        passField.setForeground(new Color(230, 230, 230));
        inputConstraints.gridx = 1;
        inputConstraints.gridy = 1;
        inputPanel.add(passField, inputConstraints);

        // Forgot Password
        JLabel forgotLabel = new JLabel("forgot password?", JLabel.RIGHT);
        
        //ActionListener for Clickable Forgot Password Label
        forgotLabel.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                Forgot forgot = new Forgot();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        //End of Forgot Password Action Listener

        forgotLabel.setForeground(new Color(230, 230, 230));
        forgotLabel.setFont(new Font("Google Sans", Font.PLAIN, 11));
        inputConstraints.gridy = 2;
        inputPanel.add(forgotLabel, inputConstraints);

        // Login Button
        
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);
        loginButton.setActionCommand("Login");
        add(loginButton);
        pack();

        loginButton.setBackground(new Color(13, 20, 23));
        loginButton.setForeground(new Color(230, 230, 230));
        inputConstraints.gridx = 0;
        inputConstraints.gridy = 3;
        inputConstraints.gridwidth = 2;
        inputConstraints.anchor = GridBagConstraints.CENTER;
        inputPanel.add(loginButton, inputConstraints);


        mainConstraints.gridy = 3;
        mainConstraints.gridwidth = 2;
        mainPanel.add(inputPanel, mainConstraints);

        // Separator
        JLabel separatorLabel = new JLabel("_______________________________", JLabel.CENTER);
        separatorLabel.setFont(new Font("Google Sans", Font.PLAIN, 25));
        separatorLabel.setForeground(new Color(230, 230, 230));
        mainConstraints.gridy = 4;
        mainPanel.add(separatorLabel, mainConstraints);

        // Empty space
        mainConstraints.gridy = 5;
        mainPanel.add(new JLabel(" "), mainConstraints);

        // Guest container
        JPanel guestPanel = new JPanel(new GridBagLayout());
        guestPanel.setBorder(BorderFactory.createLineBorder(new Color(230, 230, 230)));
        guestPanel.setBorder(BorderFactory.createTitledBorder("Student Login"));
        TitledBorder border2 = BorderFactory.createTitledBorder("Student Login");
        border2.setTitleColor(new Color(230, 230, 230));
        guestPanel.setBorder(border2);
        guestPanel.setBackground(new Color(11, 18, 21));
        GridBagConstraints guestConstraints = new GridBagConstraints();
        guestConstraints.insets = new Insets(5, 5, 5, 5);
        guestConstraints.fill = GridBagConstraints.HORIZONTAL;

        // Label
        JLabel guestLabel = new JLabel("Not a Teacher?", JLabel.CENTER);
        guestLabel.setFont(new Font("Google Sans", Font.BOLD, 25));
        guestLabel.setForeground(new Color(230, 230, 230));
        guestConstraints.gridy = 0;
        guestPanel.add(guestLabel, guestConstraints);

        // Label
        JLabel subLabel2 = new JLabel("Press The Button To See Your Records", JLabel.CENTER);
        subLabel2.setFont(new Font("Google Sans", Font.PLAIN, 14));
        subLabel2.setForeground(new Color(230, 230, 230));
        guestConstraints.gridy = 1;
        guestPanel.add(subLabel2, guestConstraints);

        // Empty space
        guestConstraints.gridy = 2;
        guestPanel.add(new JLabel(" "), guestConstraints);

        // BUTTON
        JButton guestButton = new JButton("Enter");
        guestButton.setFocusable(false);
        guestButton.addActionListener(this);
        guestButton.setActionCommand("Guest");
        add(guestButton);
        pack();

        guestButton.setBackground(new Color(13, 20, 23));
        guestButton.setForeground(new Color(230, 230, 230));
        guestButton.setPreferredSize(buttonSize);
        guestConstraints.gridx = 0;
        guestConstraints.gridy = 4;
        guestConstraints.gridwidth = 2;
        guestConstraints.anchor = GridBagConstraints.CENTER;
        guestPanel.add(guestButton, mainConstraints);

        // Empty space
        guestConstraints.gridy = 5;
        guestPanel.add(new JLabel(" "), guestConstraints);

        // Empty space
        guestConstraints.gridy = 6;
        guestPanel.add(new JLabel(" "), guestConstraints);

        mainConstraints.gridy = 6;
        mainConstraints.gridwidth = 2;
        mainPanel.add(guestPanel, mainConstraints);

        // Empty space
        mainConstraints.gridx = 0;
        mainConstraints.gridy = 7;
        mainPanel.add(new JLabel(" "),mainConstraints);

        //EXIT        
        exitButton.setFocusable(false);
        exitButton.addActionListener(this);
        exitButton.setActionCommand("Exit");
        add(exitButton);
        pack();

        exitButton.setBackground(new Color(13, 20, 23));
        exitButton.setForeground(new Color(230, 230, 230));
        mainConstraints.gridx = 1;
        mainConstraints.gridy = 7;
        mainConstraints.gridwidth = 1;
        mainConstraints.anchor = GridBagConstraints.LINE_END;

        mainPanel.add(exitButton, mainConstraints);

        frame.add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

    }

    @Override
public void actionPerformed(ActionEvent e) {
    String cmd = e.getActionCommand();

    if (cmd.equals("Guest")) {
        frame.dispose();
        Guest guest = new Guest();
    } 
    else if (cmd.equals("Exit")) {
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
        
        JOptionPane.showConfirmDialog(frame, "Do you want to exit the application ?", "Exit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        System.exit(0);
    }
    else if (userField.getText().equals("")) {
        setOptionPaneColors(); 
        JOptionPane.showMessageDialog(null, "Please Fill Out User", "INVALID", JOptionPane.ERROR_MESSAGE);
    } 
    else if (passField.getText().equals("")) {
        setOptionPaneColors();
        JOptionPane.showMessageDialog(null, "Please Fill Out Password", "INVALID", JOptionPane.ERROR_MESSAGE);
    } 
    else if (userField.getText().contains("admin") && passField.getText().contains("admin123")) {
        frame.dispose();
        Staff staff = new Staff();
    } 
    else {
        setOptionPaneColors();
        JOptionPane.showMessageDialog(null, "Wrong User or Password", "INVALID", JOptionPane.ERROR_MESSAGE);
    }
}

private void setOptionPaneColors() {
    UIManager.put("OptionPane.background", new Color(11, 18, 21));
    UIManager.put("Panel.background", new Color(11, 18, 21));
    UIManager.put("OptionPane.messageForeground", new Color(230, 230, 230));
    UIManager.put("Button.background", new Color(13, 20, 23));
    UIManager.put("Button.foreground", new Color(230,230,230));
    UIManager.put("Button.focusable", false);
}

public void keyPressed(KeyEvent e) {
    if (e.getKeyCode()==KeyEvent.VK_ENTER){
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);
        loginButton.setActionCommand("Login");
        add(loginButton);
        pack();
    }
}
    public static void main(String[] args) {
        Splash load = new Splash();
        load.init();
        
        LoginUI UI = new LoginUI();
        UI.Login();

    }
}
