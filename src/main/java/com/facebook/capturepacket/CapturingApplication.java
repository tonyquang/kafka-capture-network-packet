package com.facebook.capturepacket;

import com.facebook.capturepacket.configuration.Constant;
import com.facebook.capturepacket.controller.StartApp;

import javax.swing.JOptionPane;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CapturingApplication {

    public static void main(String[] args) {

    	if(checkDir(Constant.SystemDefault.CURRENT_DIR)){
			JOptionPane.showMessageDialog(null,
					"Current path must not be contain spacing",
					"Warning!!!",
					JOptionPane.WARNING_MESSAGE);
			System.exit(0);
		}

        StartApp starter = new StartApp();
        starter.startApp();
    }

    // Check dir path is have spacing
    // return true if it has spacing
    // return false for other case
    private static boolean checkDir(String dir) {
        Pattern pattern = Pattern.compile("\\s");
        Matcher matcher = pattern.matcher(dir);
        return matcher.find();
    }

}
