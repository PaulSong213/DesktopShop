/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javagui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import static javagui.JavaGUI.baseColor;
import javagui.components.SidebarBody;
import javax.swing.JPanel;

/**
 *
 * @author Songali A
 */
public class Sidebar extends JPanel{
    int preferredWidth = 200;
    int preferredHeight = 100;
    SidebarBody sidebarBody = new SidebarBody(preferredWidth);
    
    public Sidebar() {
        this.setBackground(baseColor);
        this.setPreferredSize(new Dimension(this.preferredWidth, this.preferredHeight));
        this.setLayout(new BorderLayout(0, 5));
        this.add(titlePanel(),BorderLayout.NORTH);
        this.add(sidebarBody,BorderLayout.CENTER);
        this.add(footerPanel(),BorderLayout.SOUTH);
    }
    
    JPanel titlePanel(){
        JPanel panel = new JPanel();
        panel.setBackground(baseColor);
        panel.setPreferredSize(new Dimension(100, 100));
        return panel;
    }
    
    JPanel footerPanel(){
        JPanel panel = new JPanel();
        panel.setBackground(baseColor);
        panel.setPreferredSize(new Dimension(100, 100));
        return panel;
    }
    
}
