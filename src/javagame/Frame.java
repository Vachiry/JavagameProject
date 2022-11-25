

package javagame;

import javax.swing.*;
public class Frame extends JFrame {
    public Frame(){
        this.setSize(1100, 620);
        GamePanel panel = new GamePanel();
        panel.setLocation(0,0);
        panel.setSize(this.getSize());
        panel.setVisible(true);
        this.add(panel);
        addKeyListener(new KeyChecker(panel));
    }
}


