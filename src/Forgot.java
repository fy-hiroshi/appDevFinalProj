import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Forgot extends JFrame implements ActionListener {

    JFrame forgotFrame = new JFrame("Student Grading System");

    public Forgot()
    {
        forgotFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        forgotFrame.setPreferredSize(new Dimension(450, 220));

        // Panel
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(new Color(11, 18, 21));
        GridBagConstraints mainConstraints = new GridBagConstraints();
        mainConstraints.insets = new Insets(5, 5, 5, 5);
        mainConstraints.fill = GridBagConstraints.HORIZONTAL;

        // Title Label
        JLabel titleLabel = new JLabel("Oops!", JLabel.CENTER);
        titleLabel.setFont(new Font("Google Sans", Font.BOLD, 35));
        titleLabel.setForeground(new Color(230, 230, 230));
        mainConstraints.gridx = 0;
        mainConstraints.gridy = 0;
        mainConstraints.gridwidth = 2;
        mainPanel.add(titleLabel, mainConstraints);

        // Sub-Text
        JLabel subLabel = new JLabel("Please reach out to our IT Team for the credentials", JLabel.CENTER);
        subLabel.setForeground(new Color(230, 230, 230));
        subLabel.setFont(new Font("Google Sans", Font.PLAIN, 14));
        mainConstraints.gridy = 1;
        mainPanel.add(subLabel, mainConstraints);

        // Empty space
        mainConstraints.gridy = 3;
        mainPanel.add(new JLabel(" "), mainConstraints);
        
        //Button
        JButton backButton = new JButton("Okay");
        backButton.setFocusable(false);
        backButton.addActionListener(this);
        backButton.setActionCommand("Back");
        add(backButton);
        pack();

        backButton.setBackground(new Color(13, 20, 23));
        backButton.setForeground(new Color(230, 230, 230));
        mainConstraints.gridx = 0;
        mainConstraints.gridy = 4;
        mainConstraints.gridwidth = 2;
        mainConstraints.gridheight = 2;
        mainConstraints.anchor = GridBagConstraints.CENTER;
        mainPanel.add(backButton, mainConstraints);

        
        forgotFrame.add(mainPanel);
        forgotFrame.pack();
        forgotFrame.setLocationRelativeTo(null);
        forgotFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

    if (cmd.equals("Back")) {

        forgotFrame.dispose();
        LoginUI login = new LoginUI();
        login.Login();

        }
    }
}