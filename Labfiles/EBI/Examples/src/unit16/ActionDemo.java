package unit16;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ActionDemo extends JPanel {
    private int currentColor = 0;
    private Map<String, Color> map;
    private String[] colors = { "Red", "Blue", "Green", "Yellow" };

    public ActionDemo() {
        prepareHashMap();
        configureGUI();
    }

    private void prepareHashMap() {
        map = new HashMap<>();
        map.put(colors[0], Color.RED);
        map.put(colors[1], Color.BLUE);
        map.put(colors[2], Color.GREEN);
        map.put(colors[3], Color.YELLOW);
    }

    private void configureGUI() {
        JButton toggleButton = new JButton(colors[currentColor]);

        class ColorListener implements ActionListener {
            public void actionPerformed(ActionEvent evt) {
                String buttonLabel = evt.getActionCommand();
                JButton button = (JButton) evt.getSource();

                Color color = map.get(buttonLabel);
                setBackground(color);

                int nextIndex = ++currentColor % colors.length;
                button.setText(colors[nextIndex]);
            }
        }

        ActionListener colorListener = new ColorListener();
        toggleButton.addActionListener(colorListener);
        this.add(toggleButton);
    }

    public static void main(String[] arg) {
        ActionDemo ad = new ActionDemo();
        JFrame theFrame = new JFrame("Action Demo");
        theFrame.add(ad, BorderLayout.CENTER);
        theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        theFrame.setSize(300, 400);
        theFrame.setVisible(true);
    }
}
