package unit15;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class PlafExample extends JFrame {

    public PlafExample() {
        super("Pluggable Look and Feel");
        addComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    private void addComponents() {
        JPanel panel = new JPanel();

        UIManager.LookAndFeelInfo[] laf = UIManager
                .getInstalledLookAndFeels();

        for (UIManager.LookAndFeelInfo info : laf) {
            String name = info.getName();
            final String className = info.getClassName();

            JButton button = new JButton(name);

            class LookAndFeelListener implements ActionListener {
                public void actionPerformed(ActionEvent e) {
                    try {
                        UIManager.setLookAndFeel(className);
                        SwingUtilities.updateComponentTreeUI(
                                getContentPane());
                        pack();
                    }
                    catch (Exception ex) {
                        System.err.println(ex);
                    }
                }
            }
            button.addActionListener(new LookAndFeelListener());
            panel.add(button);
        }

        this.add(panel, BorderLayout.CENTER);
    }

    // to see the default metal look and feel that was used
    // prior to Java 1.5, run the application as follows:
    // java -Dswing.metalTheme=steel PlafExample
    public static void main(String[] args) {
        new PlafExample();
    }
}