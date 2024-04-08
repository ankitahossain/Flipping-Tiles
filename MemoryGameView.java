/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package memorygameview;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */





import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MemoryGameView extends JFrame {
    private ArrayList<JButton> buttons = new ArrayList<>();

    public MemoryGameView() {
        setTitle("Memory Game");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 4));
        setVisible(true);
    }
public JButton getTileButton(int index) {
    return buttons.get(index);
}
    public void addTileButton(JButton button) {
        buttons.add(button);
        add(button);
    }

    public void addButtonActionListener(ActionListener listener) {
        for (JButton button : buttons) {
            button.addActionListener(listener);
        }
        
    }
}

