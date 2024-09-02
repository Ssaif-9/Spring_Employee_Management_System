package unit16;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NoLayoutManager extends JPanel {

    public NoLayoutManager() {
        configureGUI();
    }

    private void configureGUI() {
        this.setLayout(null);
        // name
        JLabel fnameLabel = new JLabel("First Name:");
        JTextField fnameTextField = new JTextField();
        JLabel mnameLabel = new JLabel("Middle Initial:");
        JTextField mnameTextField = new JTextField();
        JLabel lnameLabel = new JLabel("Last Name:");
        JTextField lnameTextField = new JTextField();

        // phone number
        JLabel areaCodeLabel = new JLabel("Area Code:");
        JTextField areaCodeTextField = new JTextField();
        JLabel phoneLabel = new JLabel("Phone:");
        JTextField phoneTextField = new JTextField();

        // address
        JLabel streetLabel = new JLabel("Street:");
        JTextField streetTextField = new JTextField();
        JLabel cityLabel = new JLabel("City:");
        JTextField cityTextField = new JTextField();
        JLabel stateLabel = new JLabel("State:");
        JTextField stateTextField = new JTextField();
        JLabel zipLabel = new JLabel("Zip:");
        JTextField zipTextField = new JTextField();

        // submit button
        JButton submitButton = new JButton("Submit");

        // add and position each component
        add(fnameLabel);
        fnameLabel.setBounds(10, 10, 85, 20);
        add(fnameTextField);
        fnameTextField.setBounds(100, 10, 100, 20);
        add(mnameLabel);
        mnameLabel.setBounds(210, 10, 85, 20);
        add(mnameTextField);
        mnameTextField.setBounds(300, 10, 20, 20);
        add(lnameLabel);
        lnameLabel.setBounds(330, 10, 85, 20);
        add(lnameTextField);
        lnameTextField.setBounds(420, 10, 150, 20);

        add(areaCodeLabel);
        areaCodeLabel.setBounds(10, 40, 85, 20);
        add(areaCodeTextField);
        areaCodeTextField.setBounds(100, 40, 30, 20);
        add(phoneLabel);
        phoneLabel.setBounds(150, 40, 50, 20);
        add(phoneTextField);
        phoneTextField.setBounds(210, 40, 80, 20);

        add(streetLabel);
        streetLabel.setBounds(10, 70, 85, 20);
        add(streetTextField);
        streetTextField.setBounds(100, 70, 200, 20);
        add(cityLabel);
        cityLabel.setBounds(10, 100, 85, 20);
        add(cityTextField);
        cityTextField.setBounds(100, 100, 150, 20);
        add(stateLabel);
        stateLabel.setBounds(260, 100, 85, 20);
        add(stateTextField);
        stateTextField.setBounds(310, 100, 30, 20);
        add(zipLabel);
        zipLabel.setBounds(350, 100, 30, 20);
        add(zipTextField);
        zipTextField.setBounds(380, 100, 80, 20);

        add(submitButton);
        submitButton.setBounds(200, 140, 100, 30);
    }

    public static void main(String[] arg) {
        NoLayoutManager nlm = new NoLayoutManager();
        JFrame theFrame = new JFrame("No Layout Manager");
        theFrame.getContentPane().add(nlm, BorderLayout.CENTER);
        theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        theFrame.setSize(600, 200);
        theFrame.setVisible(true);
        // theFrame.setResizable(false);
    }
}
