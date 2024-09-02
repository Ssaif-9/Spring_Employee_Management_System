package unit16;

import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BoxLayoutManager extends JPanel {

    public BoxLayoutManager() {
        configureGUI();
    }

    private void configureGUI() {
        // name
        JLabel fnameLabel = new JLabel("First Name:");
        JTextField fnameTextField = new JTextField(10);
        JLabel mnameLabel = new JLabel("Middle Initial:");
        JTextField mnameTextField = new JTextField(2);
        JLabel lnameLabel = new JLabel("Last Name:");
        JTextField lnameTextField = new JTextField(15);

        // phone number
        JLabel areaCodeLabel = new JLabel("Area Code:");
        JTextField areaCodeTextField = new JTextField(3);
        JLabel phoneLabel = new JLabel("Phone:");
        JTextField phoneTextField = new JTextField(8);

        // address
        JLabel streetLabel = new JLabel("Street:");
        JTextField streetTextField = new JTextField(30);
        JLabel cityLabel = new JLabel("City:");
        JTextField cityTextField = new JTextField(20);
        JLabel stateLabel = new JLabel("State:");
        JTextField stateTextField = new JTextField(2);
        JLabel zipLabel = new JLabel("Zip:");
        JTextField zipTextField = new JTextField(5);

        // set each text fields maximum size to prevent
        // the text fields from stretching.
        fnameTextField
                .setMaximumSize(fnameTextField.getPreferredSize());
        mnameTextField
                .setMaximumSize(mnameTextField.getPreferredSize());
        lnameTextField
                .setMaximumSize(lnameTextField.getPreferredSize());
        areaCodeTextField.setMaximumSize(areaCodeTextField
                .getPreferredSize());
        phoneTextField
                .setMaximumSize(phoneTextField.getPreferredSize());
        streetTextField.setMaximumSize(streetTextField
                .getPreferredSize());
        cityTextField.setMaximumSize(cityTextField.getPreferredSize());
        stateTextField
                .setMaximumSize(stateTextField.getPreferredSize());
        zipTextField.setMaximumSize(zipTextField.getPreferredSize());

        // submit button
        JButton submitButton = new JButton("Submit");

        // place the components on screen
        Box nameBox = new Box(BoxLayout.X_AXIS);
        Box phoneBox = new Box(BoxLayout.X_AXIS);
        Box streetBox = new Box(BoxLayout.X_AXIS);
        Box addressBox = new Box(BoxLayout.X_AXIS);
        Box buttonBox = new Box(BoxLayout.X_AXIS);

        nameBox.add(Box.createHorizontalStrut(10));
        nameBox.add(fnameLabel);
        nameBox.add(Box.createHorizontalStrut(10));
        nameBox.add(fnameTextField);
        nameBox.add(Box.createHorizontalStrut(10));
        nameBox.add(mnameLabel);
        nameBox.add(Box.createHorizontalStrut(10));
        nameBox.add(mnameTextField);
        nameBox.add(Box.createHorizontalStrut(10));
        nameBox.add(lnameLabel);
        nameBox.add(Box.createHorizontalStrut(10));
        nameBox.add(lnameTextField);
        nameBox.add(Box.createHorizontalGlue()); // left align

        phoneBox.add(Box.createHorizontalStrut(10));
        phoneBox.add(areaCodeLabel);
        phoneBox.add(Box.createHorizontalStrut(10));
        phoneBox.add(areaCodeTextField);
        phoneBox.add(Box.createHorizontalStrut(10));
        phoneBox.add(phoneLabel);
        phoneBox.add(Box.createHorizontalStrut(10));
        phoneBox.add(phoneTextField);
        phoneBox.add(Box.createHorizontalGlue()); // left align

        streetBox.add(Box.createHorizontalStrut(10));
        streetBox.add(streetLabel);
        streetBox.add(Box.createHorizontalStrut(10));
        streetBox.add(streetTextField);
        streetBox.add(Box.createHorizontalGlue()); // left align

        addressBox.add(Box.createHorizontalStrut(10));
        addressBox.add(cityLabel);
        addressBox.add(Box.createHorizontalStrut(20));
        addressBox.add(cityTextField);
        addressBox.add(Box.createHorizontalStrut(10));
        addressBox.add(stateLabel);
        addressBox.add(Box.createHorizontalStrut(10));
        addressBox.add(stateTextField);
        addressBox.add(Box.createHorizontalStrut(10));
        addressBox.add(zipLabel);
        addressBox.add(Box.createHorizontalStrut(10));
        addressBox.add(zipTextField);
        addressBox.add(Box.createHorizontalGlue()); // left align

        buttonBox.add(submitButton);

        // add all of the boxes to the JPanel
        BoxLayout boxLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
        this.setLayout(boxLayout);
        this.add(Box.createVerticalStrut(10));
        this.add(nameBox);
        this.add(Box.createVerticalStrut(10));
        this.add(phoneBox);
        this.add(Box.createVerticalStrut(10));
        this.add(streetBox);
        this.add(Box.createVerticalStrut(10));
        this.add(addressBox);
        this.add(Box.createVerticalStrut(10));
        this.add(buttonBox);
        this.add(Box.createVerticalStrut(10));
    }

    public static void main(String[] arg) {
        BoxLayoutManager blm = new BoxLayoutManager();
        JFrame theFrame = new JFrame("Box Layout Manager");
        theFrame.add(blm, BorderLayout.CENTER);
        theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        theFrame.pack();
        theFrame.setVisible(true);
    }
}
