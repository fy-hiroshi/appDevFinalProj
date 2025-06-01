import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Splash {

    JFrame frmSplash;
    JPanel pnlSplash;
    ImageIcon imgLogo;
    JLabel lblLogo, lblCopyright, lblApps1, lblApps2, lblVersion;

    public void init() {

        // Frame

        frmSplash = new JFrame();
        frmSplash.setIconImage(new ImageIcon("img/logo.png").getImage());
        frmSplash.setUndecorated(true);
        frmSplash.setSize(350, 200);
        frmSplash.setLocationRelativeTo(null);

        // Panel
        pnlSplash = new JPanel();
        pnlSplash.setLayout(null);
        pnlSplash.setBackground(new Color(11, 18, 21));
        frmSplash.setContentPane(pnlSplash);

        // Logo
        imgLogo = new ImageIcon(new ImageIcon("img\\logo.png").getImage().getScaledInstance(100, 80,
                Image.SCALE_SMOOTH));
        lblLogo = new JLabel();
        lblLogo.setIcon(imgLogo);
        lblLogo.setSize(100, 80);
        lblLogo.setLocation(25, 50);
        lblLogo.setBackground(new Color(2, 13, 25));
        pnlSplash.add(lblLogo);

        // Subtext
        lblCopyright = new JLabel("Version 1.02.2025");
        lblCopyright.setFont(new Font("Arial", Font.PLAIN, 8));
        lblCopyright.setForeground(new Color(230, 230, 230));
        lblCopyright.setSize(100, 20);
        lblCopyright.setLocation(280, 5);
        pnlSplash.add(lblCopyright);

        lblApps1 = new JLabel("Student Grade");
        lblApps1.setFont(new Font("Google Sans", Font.BOLD, 22));
        lblApps1.setForeground(new Color(230, 230, 230));
        lblApps1.setSize(200, 60);
        lblApps1.setLocation(130, 50);
        pnlSplash.add(lblApps1);

        lblApps2 = new JLabel("Recording System");
        lblApps2.setFont(new Font("Google Sans", Font.BOLD, 22));
        lblApps2.setForeground(new Color(230, 230, 230));
        lblApps2.setSize(200, 60);
        lblApps2.setLocation(130, 80);
        pnlSplash.add(lblApps2);

        lblVersion = new JLabel("Made by Group AppDevMondayers || Acosta, Bantilo, Jalique, Pergis, Walo");
        lblVersion.setFont(new Font("Google Sans", Font.PLAIN, 8));
        lblVersion.setForeground(new Color(230, 230, 230));
        lblVersion.setSize(300, 30);
        lblVersion.setLocation(85, 170);

        pnlSplash.add(lblVersion);
        frmSplash.setVisible(true);
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frmSplash, "Error: " + e.getMessage());
        } finally {
            frmSplash.dispose();
        }
    }
}
