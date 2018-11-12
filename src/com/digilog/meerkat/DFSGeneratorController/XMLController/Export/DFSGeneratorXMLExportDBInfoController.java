package com.digilog.meerkat.DFSGeneratorController.XMLController.Export;

import java.io.File;

import com.digilog.meerkat.DFSGeneratorController.XMLController.Import.DFSGeneratorXMLImportController;
import com.digilog.meerkat.attribute.DefineAtrribute;
import com.digilog.meerkat.model.dfsGenerator.xml.DBInfoConfigModel;
import com.digilog.meerkat.model.dfsGenerator.xml.DFSGeneratorXMLInfoModel;
import com.digilog.meerkat.util.MessageDialog;

import javafx.scene.control.Alert;

public class DFSGeneratorXMLExportDBInfoController {
	
	private MessageDialog mDialog = new MessageDialog();;
	private Alert messageLog;
	

	public DBInfoConfigModel createDBInfoFile(DFSGeneratorXMLInfoModel dfsXMLInfo) {
		
		DBInfoConfigModel dbInfoModel = new DBInfoConfigModel();
		String databaseSourceName = dfsXMLInfo.getDatabaseName();
		String eDLDatabaseType = dfsXMLInfo.getEDLDatabaseType();
		String userID = dfsXMLInfo.getUserID();
//		String password = dfsXMLInfo.getPassword();
		String hostName = dfsXMLInfo.getHostName();
		String port = dfsXMLInfo.getPort();
		String sid = dfsXMLInfo.getSid();
		
		DFSGeneratorXMLImportController dbConfigController = new DFSGeneratorXMLImportController();
		File file = new File(DefineAtrribute.TEMPLATE_DBINFO_XML_PATH);
		
		if(file.exists()) {
			dbInfoModel = dbConfigController.dbInfoConfigImport(file.getPath());
			dbInfoModel.setName(databaseSourceName);
			for(DBInfoConfigModel info : dbInfoModel.getItem()) {
				if("DRIVER_CLASS_NAME".equals(info.getName())) {
					info.setValue(setJdbcDriver(eDLDatabaseType));
					continue;
				}
				if("URL".equals(info.getName())) {
					info.setValue(setJdbcURL(eDLDatabaseType, hostName, port, sid));
					continue;
				}
				if("USER_NAME".equals(info.getName())) {
					info.setValue(userID);
					break;
				}		
			}
		} else {
			messageLog = mDialog.showMessageDialog(DefineAtrribute.M_ERROR, "File ERROR",
					DefineAtrribute.TEMPLATE_DBINFO_XML_PATH + " does not exist.", "Check, template file.");
			messageLog.showAndWait();
		}
				
		return dbInfoModel;
	}
	
	public String setJdbcDriver(String eDLDatabaseType) {
		String driver = null;
		switch (eDLDatabaseType) {
		case "Oracle":
			driver = "oracle.jdbc.driver.OracleDriver";
			break;

		default:
			break;
		}
		
		return driver;
	}
	
	public String setJdbcURL(String eDLDatabaseType, String hostName, String port, String sid) {
		String url = null;
		switch (eDLDatabaseType) {
		case "Oracle":
			url = "jdbc:oracle:thin:@"+hostName+":"+port+":"+sid;
			break;

		default:
			break;
		}
		
		return url;
	}

}
