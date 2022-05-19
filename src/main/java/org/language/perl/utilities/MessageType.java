/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.language.perl.utilities;

import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import org.openide.NotifyDescriptor;

/**
 *
 * @author Sudeep
 */
public enum MessageType {

    PLAIN(NotifyDescriptor.PLAIN_MESSAGE, null),
    INFO(NotifyDescriptor.INFORMATION_MESSAGE, "information.png"),
    QUESTION(NotifyDescriptor.QUESTION_MESSAGE, "question.png"),
    ERROR(NotifyDescriptor.ERROR_MESSAGE, "error.png"),
    WARNING(NotifyDescriptor.WARNING_MESSAGE, "warning.png");

    private final int notifyDescriptorType;

    private final Icon icon;

    private MessageType(int notifyDescriptorType, String resourceName) {
        this.notifyDescriptorType = notifyDescriptorType;
        if (resourceName == null) {
            icon = new ImageIcon();
        } else {
            icon = loadIcon(resourceName);
        }
    }

    private static Icon loadIcon(String resourceName) {
        URL resource = MessageType.class.getResource(resourceName);
        if (resource == null) {
      //Log log = Log.getLog(MessageType.class);
            //log.warn("Failed to load NotifyUtil icon resource: " + resourceName + ". Using blank image.");
            return new ImageIcon();
        }
        return new ImageIcon(resource);
    }

    int getNotifyDescriptorType() {
        return notifyDescriptorType;
    }

    Icon getIcon() {
        return icon;
    }
}
