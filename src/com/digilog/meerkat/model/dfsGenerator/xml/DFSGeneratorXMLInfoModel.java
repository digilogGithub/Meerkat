package com.digilog.meerkat.model.dfsGenerator.xml;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

public class DFSGeneratorXMLInfoModel implements Cloneable {

	private SimpleBooleanProperty markInitData;
	private SimpleStringProperty mode;
	private SimpleStringProperty databaseName;
	private SimpleStringProperty crawlerFileName;
	private SimpleStringProperty gathererFileName;
	private SimpleStringProperty databaseInfoFileName;

	private SimpleStringProperty eDLDatabaseType;
	private SimpleStringProperty userID;
	private SimpleStringProperty password;
	private SimpleStringProperty hostName;
	private SimpleStringProperty port;
	private SimpleStringProperty sid;

	public DFSGeneratorXMLInfoModel() {
		markInitData = new SimpleBooleanProperty();
		mode = new SimpleStringProperty();
		databaseName = new SimpleStringProperty();
		crawlerFileName = new SimpleStringProperty();
		gathererFileName = new SimpleStringProperty();
		databaseInfoFileName = new SimpleStringProperty();
		eDLDatabaseType = new SimpleStringProperty();
		userID = new SimpleStringProperty();
		password = new SimpleStringProperty();
		hostName = new SimpleStringProperty();
		port = new SimpleStringProperty();
		sid = new SimpleStringProperty();

	}

	public DFSGeneratorXMLInfoModel(boolean markInitData) {
		this.markInitData = new SimpleBooleanProperty(markInitData);
	}

	public DFSGeneratorXMLInfoModel(boolean markInitData, String mode, String databaseName, String crawlerFileName,
			String gathererFileName, String eDLDatabaseType, String userID, String password, String hostName,
			String port, String sid, String databaseInfoFileName) {
		this.markInitData = new SimpleBooleanProperty(markInitData);
		this.mode = new SimpleStringProperty(mode);
		this.databaseName = new SimpleStringProperty(databaseName);
		this.crawlerFileName = new SimpleStringProperty(crawlerFileName);
		this.gathererFileName = new SimpleStringProperty(gathererFileName);
		this.eDLDatabaseType = new SimpleStringProperty(eDLDatabaseType);
		this.userID = new SimpleStringProperty(userID);
		this.password = new SimpleStringProperty(password);
		this.hostName = new SimpleStringProperty(hostName);
		this.port = new SimpleStringProperty(port);
		this.sid = new SimpleStringProperty(sid);
		this.databaseInfoFileName = new SimpleStringProperty(databaseInfoFileName);
	}

	public boolean getMarkInitData() {
		return markInitData.get();
	}

	public void setMarkInitData(Boolean markInitData) {
		this.markInitData.set(markInitData);
	}

	public SimpleBooleanProperty markInitDataProperty() {
		return markInitData;
	}
	
	public String getMode() {
		return mode.get();
	}

	public void setMode(String mode) {
		this.mode.set(mode);
	}
	
	public SimpleStringProperty modeProperty(){
		return mode;
	}

	public String getDatabaseName() {
		return databaseName.get();
	}

	public void setDatabaseName(String databaseName) {
		this.databaseName.set(databaseName);
	}

	public SimpleStringProperty databaseNameProperty() {
		return databaseName;
	}

	public String getEDLDatabaseType() {
		return eDLDatabaseType.get();
	}

	public void setEDLDatabaseType(String eDLDatabase) {
		this.eDLDatabaseType.set(eDLDatabase);
	}

	public SimpleStringProperty eDLDatabaseTypeProperty() {
		return eDLDatabaseType;
	}

	public String getUserID() {
		return userID.get();
	}

	public void setUserID(String userID) {
		this.userID.set(userID);
	}

	public SimpleStringProperty userIDProperty() {
		return userID;
	}

	public String getPassword() {
		return password.get();
	}

	public void setPassword(String password) {
		this.password.set(password);
	}

	public SimpleStringProperty passwordProperty() {
		return password;
	}

	public String getHostName() {
		return hostName.get();
	}

	public void setHostName(String hostName) {
		this.hostName.set(hostName);
	}

	public SimpleStringProperty hostNameProperty() {
		return hostName;
	}

	public String getPort() {
		return port.get();
	}

	public void setPort(String port) {
		this.port.set(port);
	}

	public SimpleStringProperty portProperty() {
		return port;
	}

	public String getSid() {
		return sid.get();
	}

	public void setSid(String sid) {
		this.sid.set(sid);
	}

	public SimpleStringProperty sidProperty() {
		return sid;
	}

	public String getCrawlerFileName() {
		return crawlerFileName.get();
	}

	public void setCrawlerFileName(String crawlerFileName) {
		this.crawlerFileName.set(crawlerFileName);
	}

	public SimpleStringProperty crawlerFileNameProperty() {
		return crawlerFileName;
	}

	public String getGathererFileName() {
		return gathererFileName.get();
	}

	public void setGathererFileName(String gathererFileName) {
		this.gathererFileName.set(gathererFileName);
	}

	public SimpleStringProperty gathererFileNameProperty() {
		return gathererFileName;
	}

	public String getDatabaseInfoFileName() {
		return databaseInfoFileName.get();
	}

	public void setDatabaseInfoFileName(String databaseInfoFileName) {
		this.databaseInfoFileName.set(databaseInfoFileName);
	}

	public SimpleStringProperty databaseInfoFileNameProperty() {
		return databaseInfoFileName;
	}

	public DFSGeneratorXMLInfoModel clone() throws CloneNotSupportedException {
		DFSGeneratorXMLInfoModel cloneModel = (DFSGeneratorXMLInfoModel) super.clone();
		return cloneModel;
	}
}
