package com.digilog.meerkat.model.dfsGenerator.crawler;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

@XmlType(propOrder={"dfs_variable_name"
		,"column_name"
		,"table_name"
		,"variable_type"
		,"variable_group"
		,"role"
		,"pivot"
		,"summarization"
		,"groupby"
		,"exclude_condition"
		,"totime_javaformat"
		,"totime"
		,"timetochar"
		,"numbertochar"})

public class DFSVariableModel implements Cloneable {
	private SimpleStringProperty dfs_variable_name;
	private SimpleStringProperty column_name;
	private SimpleStringProperty table_name;
	private SimpleStringProperty variable_type;
	private SimpleStringProperty variable_group;
	private SimpleStringProperty role;
	private SimpleStringProperty pivot;
	private SimpleStringProperty summarization;
	private SimpleStringProperty groupby; 
	private SimpleStringProperty exclude_condition; 
	private SimpleStringProperty totime_javaformat;
	private SimpleStringProperty totime;
	private SimpleStringProperty timetochar;
	private SimpleStringProperty numbertochar;
	private SimpleBooleanProperty contentBoolean;
	
	
	public DFSVariableModel() {
		
	}
	
	
	public DFSVariableModel(boolean contentBoolean, String dfs_variable_name, String column_name,  String table_name,
			String variable_type, String variable_group, String role, String pivot, String summarization,
			String groupby, String exclude_condition, String totime_javaformat, String totime, String timetochar
			, String numbertochar) {
		this.contentBoolean = new SimpleBooleanProperty(contentBoolean);
		this.dfs_variable_name = new SimpleStringProperty(dfs_variable_name);
		this.column_name = new SimpleStringProperty(column_name);
		this.table_name = new SimpleStringProperty(table_name);
		this.variable_type = new SimpleStringProperty(variable_type);
		this.variable_group = new SimpleStringProperty(variable_group);
		this.role = new SimpleStringProperty(role);
		this.pivot = new SimpleStringProperty(pivot);
		this.summarization = new SimpleStringProperty(summarization);
		this.groupby = new SimpleStringProperty(groupby);
		this.exclude_condition = new SimpleStringProperty(exclude_condition);
		this.totime_javaformat = new SimpleStringProperty(totime_javaformat);
		this.totime = new SimpleStringProperty(totime);
		this.timetochar = new SimpleStringProperty(timetochar);
		this.numbertochar = new SimpleStringProperty(numbertochar);	
	}
			
	@XmlAttribute(name="name")
	public String getdfs_variable_name(){
		return dfs_variable_name.get();
	}
	
	public void setdfs_variable_name(String dfs_variable_name){
		this.dfs_variable_name.set(dfs_variable_name);
	}
	
	public SimpleStringProperty dfs_variable_nameProperty() {
		return dfs_variable_name;
	}

	@XmlAttribute(name="column")
	public String getColumn_name() {
		return column_name.get();
	}

	public void setColumn_name(String column_name) {
		this.column_name.set(column_name);
	}
	
	public SimpleStringProperty column_nameProperty() {
		return column_name;
	}

	@XmlAttribute(name="table")
	public String getTable_name() {
		return table_name.get();
	}

	public void setTable_name(String table_name) {
		this.table_name.set(table_name);
	}
	
	public SimpleStringProperty table_nameProperty() {
		return table_name;
	}

	@XmlAttribute(name="variable_type")
	public String getVariable_type() {
		return variable_type.get();
	}

	public void setVariable_type(String variable_type) {
		this.variable_type.set(variable_type);
	}
	
	public SimpleStringProperty variable_typeProperty() {
		return variable_type;
	}

	@XmlAttribute(name="variable_group")
	public String getVariable_group() {
		return variable_group.get();
	}

	public void setVariable_group(String variable_group) {
		this.variable_group.set(variable_group);
	}
	
	public SimpleStringProperty variable_groupProperty() {
		return variable_group;
	}

	@XmlAttribute
	public String getRole() {
		return role.get();
	}

	public void setRole(String role) {
		this.role.set(role);
	}
	
	public SimpleStringProperty roleProperty() {
		return role;
	}

	@XmlAttribute
	public String getPivot() {
		return pivot.get();
	}

	public void setPivot(String pivot) {
		this.pivot.set(pivot);
	}
	
	public SimpleStringProperty pivotProperty() {
		return pivot;
	}

	@XmlAttribute
	public String getSummarization() {
		return summarization.get();
	}

	public void setSummarization(String summarization) {
		this.summarization.set(summarization);
	}
	
	public SimpleStringProperty summarizationProperty() {
		return summarization;
	}

	@XmlAttribute
	public String getGroupby() {
		return groupby.get();
	}

	public void setGroupby(String groupby) {
		this.groupby.set(groupby);
	}
	
	public SimpleStringProperty groupbyProperty() {
		return groupby;
	}

	@XmlAttribute(name="exclude_condition")
	public String getExclude_condition() {
		return exclude_condition.get();
	}

	public void setExclude_condition(String exclude_condition) {
		this.exclude_condition.set(exclude_condition);
	}
	
	public SimpleStringProperty exclude_conditionProperty() {
		return exclude_condition;
	}

	@XmlAttribute(name="totime_javaformat")
	public String getTotime_javaformat() {
		return totime_javaformat.get();
	}

	public void setTotime_javaformat(String totime_javaformat) {
		this.totime_javaformat.set(totime_javaformat);
	}
	
	public SimpleStringProperty totime_javaformatProperty() {
		return totime_javaformat;
	}

	@XmlAttribute
	public String getTotime() {
		return totime.get();
	}

	public void setTotime(String totime) {
		this.totime.set(totime);
	}
	
	public SimpleStringProperty totimeProperty() {
		return totime;
	}

	@XmlAttribute
	public String getTimetochar() {
		return timetochar.get();
	}

	public void setTimetochar(String timetochar) {
		this.timetochar.set(timetochar);
	}
	
	public SimpleStringProperty timetocharProperty() {
		return timetochar;
	}

	@XmlAttribute
	public String getNumbertochar() {
		return numbertochar.get();
	}

	public void setNumbertochar(String numbertochar) {
		this.numbertochar.set(numbertochar);
	}
	
	public SimpleStringProperty numbertocharProperty() {
		return numbertochar;
	}
	
	// contentBoolean getter and setter
	@XmlTransient
	public boolean getContentBoolean() {
		return contentBoolean.get();
	}

	public void setContentBoolean(boolean contentBoolean) {
		this.contentBoolean.set(contentBoolean);
	}

	public SimpleBooleanProperty contentBooleanProperty() {
		return contentBoolean;
	}
	
	public DFSVariableModel clone() throws CloneNotSupportedException {
		DFSVariableModel cloneModel = (DFSVariableModel) super.clone();
		return cloneModel;	
	}
}
