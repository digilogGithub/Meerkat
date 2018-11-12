package com.digilog.meerkat.DFSGeneratorController.XMLController.Export;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import com.digilog.meerkat.attribute.DefineAtrribute;
import com.digilog.meerkat.model.dfsGenerator.semimaster.export.DFSSemimasterWrapperExportModel;
import com.digilog.meerkat.util.FileBackup;
import com.digilog.meerkat.util.MessageDialog;
import com.digilog.meerkat.view.RootGeneralConfigViewController;

import javafx.scene.control.Alert;

public class DFSGeneratorXMLExportLog4j2Controller {
	
	private MessageDialog mDialog;
	private Alert messageLog;
	
	public void createLog4j2File() {
		mDialog = new MessageDialog();
		String tempLogLevel = RootGeneralConfigViewController.LogLevel;
		String tempLogFilePath = RootGeneralConfigViewController.logFileNamePath.replaceAll("\\\\", "\\\\\\\\");	
	 	FileBackup fb = new FileBackup();   
        
        
		try {
			Path templateFilePath = Paths.get(DefineAtrribute.TEMPLATE_LOG_XML_PATH);
			Path exportFilePath = Paths.get(RootGeneralConfigViewController.log4j2FileNamePath);
			fb.fileBackup(RootGeneralConfigViewController.log4j2FileNamePath.replaceAll("\\\\", "\\\\\\\\"));
			Charset charset = StandardCharsets.UTF_8;
			String content = null;
			
			content = new String(Files.readAllBytes(templateFilePath), charset);
			content = content.replaceAll("tempLogLevel", tempLogLevel);		
			content = content.replaceAll("tempLogFilePath", tempLogFilePath);
			Files.write(exportFilePath, content.getBytes(charset));
		} catch (IOException e) {
			messageLog = mDialog.showMessageDialog(DefineAtrribute.M_ERROR, "LOG4J2 Config XML FILE EXPORT ERROR",
					"log4j2 config xml file export error.", e.getMessage());
			messageLog.showAndWait();
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
