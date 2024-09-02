package unit16;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ListSelectionDemo extends JPanel {
    private Map<String, Color> map;
    private String[] colors = { "Red", "Blue", "Green", "Yellow" };

    public ListSelectionDemo() {
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

        JList<String> listBox = new JList<>(colors);
        listBox.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(listBox);

        class ColorListener implements ListSelectionListener {
            public void valueChanged(ListSelectionEvent evt) {
                JList<String> list = (JList<String>) evt.getSource();
                String value = (String) list.getSelectedValue();

                Color color = map.get(value);
                setBackground(color);
            }
        }

        ListSelectionListener colorListener = new ColorListener();
        listBox.addListSelectionListener(colorListener);
        this.add(scrollPane);
    }

    public static void main(String[] arg) {
        ListSelectionDemo ld = new ListSelectionDemo();
        JFrame theFrame = new JFrame("List Selection Demo");
        theFrame.add(ld, BorderLayout.CENTER);
        theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        theFrame.setSize(300, 400);
        theFrame.setVisible(true);
    }
}
