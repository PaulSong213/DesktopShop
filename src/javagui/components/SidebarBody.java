/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javagui.components;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import static javagui.JavaGUI.baseColor;
import javax.swing.AbstractButton;
import javax.swing.Action;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicButtonUI;

/**
 *
 * @author Songali A
 */
public class SidebarBody extends JPanel{
    
    int parentWidth;
    Map<Integer, JButton> buttons = new HashMap<Integer, JButton>() {{
        put(0,navButton("Home", "home.png"));
        put(1,navButton("Best Seller", "bestSeller.png"));
        put(2,navButton("About Us", "about.png"));
    }};
    
    JPanel btnPanel;
    
    public SidebarBody(int parentWidth) {
        this.parentWidth = parentWidth;
        this.setBackground(baseColor);
        setBtnPanel();
        
        
    }
    
    void setBtnPanel(){
        this.btnPanel = new JPanel();
        this.btnPanel.setBackground(baseColor);
        this.btnPanel.setLayout(new GridLayout(buttons.size(),1,0,5));
        
        for(int i = 0; i < buttons.size();i++){
            
            this.btnPanel.add(buttons.get(i));
        }
        this.btnPanel.setPreferredSize(new Dimension(parentWidth,50 * buttons.size()));
        this.add(this.btnPanel);
    }
    
    JButton navButton(String value,String icon){
        JButton b = new JButton(value);  
        String iconPath = "images/sidebar/" + icon;
        b.setHorizontalAlignment(SwingConstants.LEFT);
        b.setToolTipText("Navigate to " + value);
        b.setForeground(Color.DARK_GRAY);
        b.setBackground(Color.WHITE);
        b.setBorder(new EmptyBorder(0,10,0,0));
        b.setUI(new BasicButtonUI() {
            @Override
            public void update(Graphics g, JComponent c) {
                if (c.isOpaque()) {
                    Color fillColor = c.getBackground();
                    AbstractButton button = (AbstractButton) c;
                    ButtonModel model = button.getModel();

                    if (model.isPressed()) {
                        fillColor = fillColor.darker();
                    } else if (model.isRollover()) {
                        fillColor = fillColor.brighter();
                    }

                    g.setColor(fillColor);
                    g.fillRoundRect(0, 0, c.getWidth(),c.getHeight(), 30, 30);
                }
                paint(g, c);
            }
        });
        
        b.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override   
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b.setBackground(Color.CYAN.darker());
                b.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b.setBackground(Color.WHITE);
            }
        });
        
        ImageIcon imageIcon = new ImageIcon(iconPath);
        Image image = imageIcon.getImage(); // transform it 
        Image newimg = image.getScaledInstance(15, 15,  java.awt.Image.SCALE_SMOOTH);
        b.setIcon(new ImageIcon(newimg));
        return b;
    }
    
    public void addActionNavButton(int index,ActionListener action){
        this.buttons.get(index).addActionListener(action);
        this.buttons.get(index).addActionListener((ActionEvent e) -> {
            this.btnPanel.repaint();
        });
    }
    
    
    
    
}


