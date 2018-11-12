package com.digilog.meerkat.model.dfsGenerator.crawler.Import;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

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

public class DFSVariableImportModel implements Cloneable {

	private String dfs_variable_name;
	private String column_name;
	private String table_name;
	private String variable_type;
	private String variable_group;
	private String role;
	private String pivot;
	private String summarization;
	private String groupby; 
	private String exclude_condition; 
	private String totime_javaformat;
	private String totime;
	private String timetochar;
	private String numbertochar;
	private Boolean contentBoolean;
	
	@XmlAttribute(name="name")
	public String getDfs_variable_name() {
		return dfs_variable_name;
	}
	
	@XmlAttribute(name="column")
	public String getColumn_name() {
		return column_name;
	}
	
	@XmlAttribute(name="table")
	public String getTable_name() {
		return table_name;
	}
	
	@XmlAttribute(name="variable_type")
	public String getVariable_type() {
		return variable_type;
	}
	
	@XmlAttribute(name="variable_group")
	public String getVariable_group() {
		return variable_group;
	}
	
	@XmlAttribute(name="role")
	public String getRole() {
		return role;
	}
	
	public void setDfs_variable_name(String dfs_variable_name) {
		this.dfs_variable_name = dfs_variable_name;
	}

	public void setColumn_name(String column_name) {
		this.column_name = column_name;
	}

	public void setTable_name(String table_name) {
		this.table_name = table_name;
	}

	public void setVariable_type(String variable_type) {
		this.variable_type = variable_type;
	}

	public void setVariable_group(String variable_group) {
		this.variable_group = variable_group;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setPivot(String pivot) {
		this.pivot = pivot;
	}

	public void setSummarization(String summarization) {
		this.summarization = summarization;
	}

	public void setGroupby(String groupby) {
		this.groupby = groupby;
	}

	public void setExclude_condition(String exclude_condition) {
		this.exclude_condition = exclude_condition;
	}

	public void setTotime_javaformat(String totime_javaformat) {
		this.totime_javaformat = totime_javaformat;
	}

	public void setTotime(String totime) {
		this.totime = totime;
	}

	public void setTimetochar(String timetochar) {
		this.timetochar = timetochar;
	}

	public void setNumbertochar(String numbertochar) {
		this.numbertochar = numbertochar;
	}

	public void setContentBoolean(Boolean contentBoolean) {
		this.contentBoolean = contentBoolean;
	}

	@XmlAttribute(name="pivot")
	public String getPivot() {
		return pivot;
	}
	
	@XmlAttribute(name="summarization")
	public String getSummarization() {
		return summarization;
	}
	
	@XmlAttribute(name="groupby")
	public String getGroupby() {
		return groupby;
	}
	
	@XmlAttribute(name="exclude_condition")
	public String getExclude_condition() {
		return exclude_condition;
	}
	
	@XmlAttribute(name="totime_javaformat")
	public String getTotime_javaformat() {
		return totime_javaformat;
	}
	
	@XmlAttribute(name="totime")
	public String getTotime() {
		return totime;
	}
	
	@XmlAttribute(name="timetochar")
	public String getTimetochar() {
		return timetochar;
	}
	
	@XmlAttribute(name="numbertochar")
	public String getNumbertochar() {
		return numbertochar;
	}
	
	@XmlTransient
	public Boolean getContentBoolean() {
		return contentBoolean;
	}
	
	public DFSVariableImportModel clone() throws CloneNotSupportedException {
		DFSVariableImportModel cloneModel = (DFSVariableImportModel) super.clone();
		return cloneModel;	
	}
}
