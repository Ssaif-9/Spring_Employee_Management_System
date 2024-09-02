package unit15;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Notepad3 extends JFrame {
    private JButton closeButton;

    public Notepad3() {
        super("Notepad");
        addComponents();
        addEventHandlers();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
        setVisible(true);
    }

    private void addComponents() {
        closeButton = new JButton("Close");
        this.add(closeButton);
    }

    private void addEventHandlers() {
        class CloseListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        }
        ActionListener closeListener = new CloseListener();
        closeButton.addActionListener(closeListener);

        /*
        // anonymous inner class
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        */
    }

    public static void main(String[] arg) {
        new Notepad3();
    }
}
