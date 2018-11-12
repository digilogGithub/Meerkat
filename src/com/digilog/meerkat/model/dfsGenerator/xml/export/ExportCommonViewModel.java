package com.digilog.meerkat.model.dfsGenerator.xml.export;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

public class ExportCommonViewModel implements Cloneable {
	
	SimpleStringProperty databaseSource;
	SimpleStringProperty mode;
	SimpleStringProperty property;
	SimpleBooleanProperty check;
	SimpleBooleanProperty done;
	
	public ExportCommonViewModel() {
		
	}

	public ExportCommonViewModel(String mode, String databaseSource, String property) {
		this.mode=new SimpleStringProperty(mode);
		this.databaseSource=new SimpleStringProperty(databaseSource);
		this.property= new SimpleStringProperty(property);
	}
	
	
	public ExportCommonViewModel(String databaseSource, String property, Boolean done) {
		this.databaseSource=new SimpleStringProperty(databaseSource);
		this.property= new SimpleStringProperty(property);
		this.done = new SimpleBooleanProperty(done);
	}
	
	public ExportCommonViewModel(String mode, String databaseSource, String property, Boolean check, Boolean done) {
		this.mode=new SimpleStringProperty(mode);
		this.databaseSource=new SimpleStringProperty(databaseSource);
		this.property= new SimpleStringProperty(property);
		this.check = new SimpleBooleanProperty(check);
		this.done = new SimpleBooleanProperty(done);
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
	
	public String getDatabaseSource() {
		return databaseSource.get();
	}

	public void setDatabaseSource(String databaseSource) {
		this.databaseSource.set(databaseSource);
	}
	
	public SimpleStringProperty databaseSourceProperty(){
		return databaseSource;
	}

	public String getProperty() {
		return property.get();
	}

	public void setProperty(String property) {
		this.property.set(property);
	}
	
	public SimpleStringProperty propertyProperty(){
		return property;
	}
	
	public Boolean getCheck() {
		return check.get();
	}

	public void setCheck(Boolean check) {
		this.check.set(check);
	}
	
	public SimpleBooleanProperty checkProperty(){
		return check;
	}
	
	public Boolean getDone() {
		return done.get();
	}

	public void setDone(Boolean done) {
		this.done.set(done);
	}
	
	public SimpleBooleanProperty doneProperty(){
		return done;
	}
	
	public ExportCommonViewModel clone() throws CloneNotSupportedException {
		ExportCommonViewModel cloneModel = (ExportCommonViewModel) super.clone();
		return cloneModel;	
	}
}
