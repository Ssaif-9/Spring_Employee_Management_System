package unit16;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MouseDemo3 extends JPanel {
    private int currentColor = 0;
    private Map<String, Color> map;
    private String[] colors = { "Red", "Blue", "Green", "Yellow",
            "White" };

    public MouseDemo3() {
        prepareHashMap();
        configureGUI();
    }

    private void prepareHashMap() {
        map = new HashMap<String, Color>();
        map.put(colors[0], Color.RED);
        map.put(colors[1], Color.BLUE);
        map.put(colors[2], Color.GREEN);
        map.put(colors[3], Color.YELLOW);
        map.put(colors[4], Color.WHITE);
    }

    private void configureGUI() {

        this.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        final JButton[] buttons = new JButton[5];

        buttons[0] = new JButton("One");
        buttons[1] = new JButton("Two");
        buttons[2] = new JButton("Three");
        buttons[3] = new JButton("Four");
        buttons[4] = new JButton("Five");

        this.add(buttons[0]);
        this.add(buttons[1]);
        this.add(buttons[2]);
        this.add(buttons[3]);
        this.add(buttons[4]);

        for (JButton button : buttons) {
            button.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent evt) {
                    currentColor++;
                    for (int i = 0; i < buttons.length; i++) {
                        int nextIndex = (currentColor + i)
                                % colors.length;
                        Color nextColor = map.get(colors[nextIndex]);
                        buttons[i].setBackground(nextColor);
                    }
                }
            });
        }
    }

    public static void main(String[] arg) {
        MouseDemo3 md = new MouseDemo3();
        JFrame theFrame = new JFrame("Mouse Demo3");
        theFrame.add(md, BorderLayout.CENTER);
        theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        theFrame.setSize(300, 400);
        theFrame.setVisible(true);
    }
}
