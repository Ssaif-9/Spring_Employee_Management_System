package unit16;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MouseDemo extends JPanel {
    private int currentColor = 0;
    private Map<String, Color> map;
    private String[] colors = { "Red", "Blue", "Green", "Yellow" };

    public MouseDemo() {
        prepareHashMap();
        configureGUI();
    }

    private void prepareHashMap() {
        map = new HashMap<String, Color>();
        map.put(colors[0], Color.RED);
        map.put(colors[1], Color.BLUE);
        map.put(colors[2], Color.GREEN);
        map.put(colors[3], Color.YELLOW);
    }

    private void configureGUI() {

        this.setLayout(new GridLayout(2, 2));
        final JPanel[] panels = new JPanel[4];

        for (int i = 0; i < panels.length; i++) {
            panels[i] = new JPanel();
        }

        for (JPanel panel : panels) {
            panel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent evt) {
                    currentColor++;
                    for (int i = 0; i < panels.length; i++) {
                        int nextIndex = (currentColor + i)
                                % colors.length;
                        Color nextColor = map.get(colors[nextIndex]);
                        panels[i].setBackground(nextColor);
                    }
                }
            });

            this.add(panel);
        }
    }

    public static void main(String[] arg) {
        MouseDemo md = new MouseDemo();
        JFrame theFrame = new JFrame("Mouse Demo");
        theFrame.add(md, BorderLayout.CENTER);
        theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        theFrame.setSize(300, 400);
        theFrame.setVisible(true);
    }
}
