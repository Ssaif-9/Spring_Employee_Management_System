package unit16;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MouseDemo2 extends JPanel {
    private int currentColor = 0;
    private Map<String, Color> map;
    private String[] colors = { "Red", "Blue", "Green", "Yellow",
            "White" };

    public MouseDemo2() {
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

        this.setLayout(new BorderLayout(10, 10));
        final JButton[] buttons = new JButton[5];

        buttons[0] = new JButton("North");
        buttons[1] = new JButton("South");
        buttons[2] = new JButton("East");
        buttons[3] = new JButton("West");
        buttons[4] = new JButton("Center");

        this.add(buttons[0], BorderLayout.NORTH);
        this.add(buttons[1], BorderLayout.SOUTH);
        this.add(buttons[2], BorderLayout.EAST);
        this.add(buttons[3], BorderLayout.WEST);
        this.add(buttons[4], BorderLayout.CENTER);

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
        MouseDemo2 md = new MouseDemo2();
        JFrame theFrame = new JFrame("Mouse Demo2");
        theFrame.add(md, BorderLayout.CENTER);
        theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        theFrame.setSize(300, 400);
        theFrame.setVisible(true);
    }
}
