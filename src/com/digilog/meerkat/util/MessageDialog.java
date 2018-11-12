package com.digilog.meerkat.util;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;

public class MessageDialog {

	public Alert alertInfo;
	public Alert alertWaring;
	public Alert alertError;
	public Alert alertConfirm;

	ButtonType ok = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
	ButtonType cancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
	
	public MessageDialog() {
		alertInfo = new Alert(AlertType.INFORMATION);
		alertWaring = new Alert(AlertType.WARNING);
		alertError = new Alert(AlertType.ERROR);
		alertConfirm = new Alert(AlertType.CONFIRMATION,"",ok,cancel); 
	}

	public Alert showMessageDialog(String type, String title, String headerText, String contentText) {
		
		if (type.equals("INFO")) {
			alertInfo.setTitle(title);
			alertInfo.setHeaderText(headerText);
			alertInfo.setContentText(contentText);
			return alertInfo;
		} else if (type.equals("ERROR")) {
			alertError.setTitle(title);
			alertError.setHeaderText(headerText);
			alertError.setContentText(contentText);
			return alertError;
		} else if (type.equals("WARNING")){
			alertWaring.setTitle(title);
			alertWaring.setHeaderText(headerText);
			alertWaring.setContentText(contentText);
			return alertWaring;
		} else {
			alertConfirm.setTitle(title);
			alertConfirm.setHeaderText(headerText);
			alertConfirm.setContentText(contentText);
			return alertConfirm;
			
	     /*
	      * Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK){
			    // ... user chose OK
			} else {
			    // ... user chose CANCEL or closed the dialog
			} */
		} 

	}

}
