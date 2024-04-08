/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package memorygamecontroller;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */




import MemoryGameModel.MemoryGameModel;
import MemoryGameView.MemoryGameView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class MemoryGameController {
    private MemoryGameModel model;
    private MemoryGameView view;
    private int firstTileIndex = -1;
    private int secondTileIndex = -1;

    public MemoryGameController(MemoryGameModel model, MemoryGameView view) {
        this.model = model;
        this.view = view;

        initializeButtons();
        addButtonListeners();
    }

    private void initializeButtons() {
        for (int i = 0; i < model.getNumTiles(); i++) {
            JButton button = new JButton();
            button.setName(Integer.toString(i));
            view.addTileButton(button);
        }
    }

    private void addButtonListeners() {
        view.addButtonActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton clickedButton = (JButton) e.getSource();
                int index = Integer.parseInt(clickedButton.getName());
                revealTile(index);
            }
        });
    }

private void revealTile(int index) {
    JButton clickedButton = view.getTileButton(index);
    clickedButton.setText(model.getTileValue(index));
    clickedButton.setEnabled(false);

    if (firstTileIndex == -1) {
        firstTileIndex = index;
    } else if (secondTileIndex == -1) {
        secondTileIndex = index;

        if (!model.getTileValue(firstTileIndex).equals(model.getTileValue(secondTileIndex))) {
            Timer timer;
            timer = new Timer(1000, new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JButton firstButton = view.getTileButton(firstTileIndex);
                    JButton secondButton = view.getTileButton(secondTileIndex);
                    firstButton.setText("");
                    secondButton.setText("");
                    firstButton.setEnabled(true);
                    secondButton.setEnabled(true);
                    firstTileIndex = -1;
                    secondTileIndex = -1;
                    ((Timer) e.getSource()).stop();
                }
            });
            timer.setRepeats(false);
            timer.start();
        } else {
            firstTileIndex = -1;
            secondTileIndex = -1;
        }
    }
}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MemoryGameModel model = new MemoryGameModel();
            MemoryGameView view = new MemoryGameView();
            new MemoryGameController(model, view);
        });
    }
}


