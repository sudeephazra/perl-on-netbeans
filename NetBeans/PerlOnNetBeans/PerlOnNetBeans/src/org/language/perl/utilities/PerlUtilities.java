/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.language.perl.utilities;

import java.awt.Component;
import java.awt.Container;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;

/**
 *
 * @author Sudeep
 */
public class PerlUtilities {

    public static void disableUpFolderButton(Container c) {
        int len = c.getComponentCount();
        for (int i = 0; i < len; i++) {
            Component comp = c.getComponent(i);

            if (comp.getClass().getSimpleName().equals("MetalFileChooserUI$3")) {
                comp.setVisible(false);
            }

            //Disabling combobox
            if (comp instanceof JComboBox) {
                    comp.setVisible(false);
            }

            //Disabling the labels
            if (comp instanceof JLabel) {
                    comp.setVisible(false);
            }
            
            //Disabling all textfields
            if (comp instanceof JTextField) {
                    comp.setVisible(false);
            }
            
            
            //Disabling the Up folder icon
            if (comp instanceof JButton) {
                JButton b = (JButton) comp;
                Icon icon = b.getIcon();
                if (icon != null
                        && (icon == UIManager.getIcon("FileChooser.upFolderIcon") 
                        || icon == UIManager.getIcon("FileChooser.newFolderIcon")
                        || icon == UIManager.getIcon("FileView.computerIcon")
                        )) {
                    b.setVisible(false);
                }
                
                if ( (!"Open".equals(b.getText())) && (!"Cancel".equals(b.getText()))) {
                    b.setVisible(false);
                }
                
                
            } else if (comp instanceof Container) {
                disableUpFolderButton((Container) comp);
            }
        }

    }
}
