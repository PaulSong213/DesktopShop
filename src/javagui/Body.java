/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javagui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.util.HashMap;
import java.util.Map;
import static javagui.JavaGUI.baseColor;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Songali A
 */
public class Body extends JPanel{
    CardLayout card;
    int cardVisibleIndex = 0;
    Map<Integer, JPanel> mainPanels = new HashMap<Integer, JPanel>() {{
        put(0,homePanel());
        put(1,bestSellerPanel());
        put(2,aboutPanel());
    }};
    public Body() {
        this.setBackground(baseColor);
        this.setBorder(new EmptyBorder(10,30,10,10));
        this.setLayout(new GridLayout(0,1));
        this.add(mainPanel());
    }
    
    JPanel mainPanel(){
        JPanel p = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
               super.paintComponent(g);
               Dimension arcs = new Dimension(50,50);
               int width = getWidth();
               int height = getHeight();
               Graphics2D graphics = (Graphics2D) g;
               graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
               //Draws the rounded panel with borders.
               graphics.setColor(Color.WHITE);
               graphics.fillRoundRect(0, 0, width-1, height, arcs.width, arcs.height);//paint background
               graphics.setColor(Color.WHITE);
               
               graphics.drawRoundRect(0, 0, width-1, height, arcs.width, arcs.height);//paint border
            }
        };
        p.setBackground(baseColor);
        p.setBorder(new EmptyBorder(0,0,0,0));
        this.card = new CardLayout(); 
        p.setLayout(this.card);
        for(int i = 0; i < this.mainPanels.size();i++){
            p.add(String.valueOf(i),this.mainPanels.get(i));
        }
        card.first(p);
        return p;
    }
    
    JPanel homePanel(){
        JPanel p = new JPanel();
        p.setBackground(Color.lightGray);
        p.setBorder(new EmptyBorder(0,0,0,0));
        return p;
    }
    
    JPanel bestSellerPanel(){
        JPanel p = new JPanel();
        p.setBackground(Color.GREEN);
        p.setBorder(new EmptyBorder(0,0,0,0));
 
        return p;
    }
    
    JPanel aboutPanel(){
        JPanel p = new JPanel();
        p.setBackground(Color.CYAN);
        p.setBorder(new EmptyBorder(0,0,0,0));
        return p;
    }
    
    void setMainPanel(int index){
        this.mainPanels.get(this.cardVisibleIndex).setVisible(false); //hide previous visble component
        this.cardVisibleIndex = index;
        this.mainPanels.get(index).setVisible(true); //show new visble component
    }
    int getTotalMainPanel(){
        return this.mainPanels.size();
    }
    
}
