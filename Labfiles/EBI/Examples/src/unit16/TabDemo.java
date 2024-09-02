package unit16;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class TabDemo extends JFrame {

    public TabDemo() {
        super("Tab Demo");

        addComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    private void addComponents() {
        JPanel panel1 = new ActionDemo();
        JPanel panel2 = new ListSelectionDemo();
        JPanel panel3 = new MouseDemo();
        JPanel panel4 = new MouseDemo2();
        JPanel panel5 = new MouseDemo3();
        JPanel panel6 = new NoLayoutManager();
        JPanel panel7 = new BoxLayoutManager();

        JTabbedPane tabs = new JTabbedPane(JTabbedPane.TOP,
                JTabbedPane.SCROLL_TAB_LAYOUT);

        tabs.addTab("Action Events", panel1);
        tabs.addTab("List Selection Events", panel2);
        tabs.addTab("Mouse Events - Grid Layout", panel3);
        tabs.addTab("Mouse Events - Border Layout", panel4);
        tabs.addTab("Mouse Events - Flow Layout", panel5);
        tabs.addTab("Null Layout Manager", panel6);
        tabs.addTab("Box Layout Manager", panel7);

        JButton exitButton = new JButton("Exit");

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        JPanel exitPanel = new JPanel();
        exitPanel.add(exitButton);

        this.add(tabs, BorderLayout.CENTER);
        this.add(exitPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] arg) {
        new TabDemo();
    }
}
