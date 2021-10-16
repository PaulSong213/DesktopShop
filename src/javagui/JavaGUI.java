/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javagui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



/**
 *
 * @author Songali A
 */
public class JavaGUI {

    /**
     * @param args the command line arguments
     */
    public static Color baseColor = new Color(102,88,239);
    Sidebar sidebar;
    Body body ;
    
    public static void main(String[] args) {
        // TODO code application logic here
        JavaGUI gui = new JavaGUI();
        gui.initApp();
    }
    
    public void initApp(){
        MainFrame frame = new MainFrame(baseColor);
        sidebar = new Sidebar();
        body = new Body();
        addActionNavButton(body.getTotalMainPanel());
        
        frame.add(sidebar,BorderLayout.WEST);
        frame.add(body,BorderLayout.CENTER);
        frame.setVisible(true);
    }
    
    void addActionNavButton(int buttonTotalCount){
        for(int i = 0; i < buttonTotalCount; i ++){
            int index = i;
            sidebar.sidebarBody.addActionNavButton(i, (ActionEvent e) -> {
                body.setMainPanel(index);
            });
        }
    }
    
}
