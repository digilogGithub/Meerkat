package com.digilog.meerkat.model.dfsGenerator;

import java.sql.Connection;

import javafx.beans.property.SimpleStringProperty;

public class DFSDatabaseConnectionModel implements Cloneable {
	
	private Connection connection;
	private SimpleStringProperty status;
	private SimpleStringProperty datasourceName;
	private SimpleStringProperty databaseType;
	private SimpleStringProperty userID;
	private SimpleStringProperty password;
	private SimpleStringProperty hostName;
	private SimpleStringProperty port;
	private SimpleStringProperty dbi;
	private SimpleStringProperty dBInfoPath;

	public DFSDatabaseConnectionModel() {
		status = new SimpleStringProperty();
		datasourceName = new SimpleStringProperty();
		databaseType = new SimpleStringProperty();
		userID = new SimpleStringProperty();
		password = new SimpleStringProperty();
		hostName = new SimpleStringProperty();
		port = new SimpleStringProperty();
		dbi = new SimpleStringProperty();
		dBInfoPath = new SimpleStringProperty();
	}
	
	public DFSDatabaseConnectionModel(
			Connection connection,
			String status,  String datasourceName, String databaseType, String userID,  String password
			, String hostName, String port, String dbi, String dBInfoPath) {
		this.connection = connection;
		this.status = new SimpleStringProperty(status);
		this.datasourceName = new SimpleStringProperty(datasourceName);
		this.databaseType = new SimpleStringProperty(databaseType);
		this.userID = new SimpleStringProperty(userID);
		this.hostName = new SimpleStringProperty(hostName);
		this.password = new SimpleStringProperty(password);
		this.port = new SimpleStringProperty(port);
		this.dbi = new SimpleStringProperty(dbi);
		this.dBInfoPath = new SimpleStringProperty(dBInfoPath);
	}
	
//	public DFSDatabaseConnectionModel(
//			String datasourceName, String databaseType, String userID,  String password
//			, String hostName, String port, String dbi, String dBInfoPath) {
//		this.datasourceName = new SimpleStringProperty(datasourceName);
//		this.databaseType = new SimpleStringProperty(databaseType);
//		this.userID = new SimpleStringProperty(userID);
//		this.hostName = new SimpleStringProperty(hostName);
//		this.password = new SimpleStringProperty(password);
//		this.port = new SimpleStringProperty(port);
//		this.dbi = new SimpleStringProperty(dbi);
//		this.dBInfoPath = new SimpleStringProperty(dBInfoPath);
//	}

	public Connection getConnection() {
		return connection;
	}
	
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	public String getStatus() {
		return status.get();
	}

	public void setStatus(String status) {
		this.status.set(status);
	}

	public SimpleStringProperty statusProperty() {
		return status;
	}


	public String getDatasourceName() {
		return datasourceName.get();
	}

	public void setDatasourceName(String datasourceName) {
		this.datasourceName.set(datasourceName);
	}

	public SimpleStringProperty datasourceNameProperty() {
		return datasourceName;
	}


	public String getDatabaseType() {
		return databaseType.get();
	}

	public void setDatabaseType(String databaseType) {
		this.databaseType.set(databaseType);
	}

	public SimpleStringProperty databaseTypeProperty() {
		return databaseType;
	}

//
	public String getUserID() {
		return userID.get();
	}

	public void setUserID(String userID) {
		this.userID.set(userID);
	}

	public SimpleStringProperty userIDProperty() {
		return userID;
	}
//
	public String getPassword() {
		return password.get();
	}

	public void setPassword(String password) {
		this.password.set(password);
	}

	public SimpleStringProperty passwordProperty() {
		return password;
	}
//	
	public String getHostName() {
		return hostName.get();
	}

	public void setHostName(String hostName) {
		this.hostName.set(hostName);
	}

	public SimpleStringProperty hostNameProperty() {
		return hostName;
	}
//	

	public String getPort() {
		return port.get();
	}

	public void setPort(String port) {
		this.port.set(port);
	}

	public SimpleStringProperty portProperty() {
		return port;
	}
//
	public String getDbi() {
		return dbi.get();
	}

	public void setDbi(String dbi) {
		this.dbi.set(dbi);
	}
	
	public SimpleStringProperty dbiProperty() {
		return dbi;
	}
	
	public String getDBInfoPath() {
		return dBInfoPath.get();
	}

	public void setDBInfoPath(String dBInfoPath) {
		this.dBInfoPath.set(dBInfoPath);
	}
	
	public SimpleStringProperty dBInfoPathProperty() {
		return dBInfoPath;
	}


	public DFSDatabaseConnectionModel clone() throws CloneNotSupportedException {
		DFSDatabaseConnectionModel cloneModel = (DFSDatabaseConnectionModel) super.clone();
		return cloneModel;	
	}

}
