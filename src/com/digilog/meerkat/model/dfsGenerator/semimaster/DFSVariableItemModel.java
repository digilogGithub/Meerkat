package com.digilog.meerkat.model.dfsGenerator.semimaster;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

//@XmlType(propOrder={"seq", "name", "alias" ,"variable_type"})
public class DFSVariableItemModel implements Cloneable {
	
	private SimpleStringProperty seq;
	private SimpleBooleanProperty notOptional;
	private SimpleStringProperty name;
//	
	private SimpleStringProperty column_name;
	private SimpleStringProperty table_Name;
//	
	private SimpleStringProperty alias;
	private SimpleStringProperty variable_type;
	private SimpleStringProperty variable_group;
	private SimpleStringProperty role;
	private SimpleStringProperty pivot;
	private SimpleStringProperty description;	
//
	private SimpleStringProperty summarization;
	private SimpleStringProperty groupby; 
	private SimpleStringProperty exclude_condition; 
	private SimpleStringProperty totime_javaformat;
	private SimpleStringProperty totime;
	private SimpleStringProperty timetochar;
	private SimpleStringProperty numbertochar;


//	@XmlElement(name = "seq")
	public DFSVariableItemModel() {
		
	}
	
	public DFSVariableItemModel(String seq, String name, String alias, String variable_group
			, boolean notOptional, String role, String pivot, String description) {
		this.seq = new SimpleStringProperty(seq);
		this.notOptional = new SimpleBooleanProperty(notOptional);
		this.name = new SimpleStringProperty(name);
		this.alias = new SimpleStringProperty(alias);
		this.variable_group = new SimpleStringProperty(variable_group);
		this.role = new SimpleStringProperty(role);
		this.pivot = new SimpleStringProperty(pivot);
		this.description = new SimpleStringProperty(description);
	}
	
	public DFSVariableItemModel(String seq, boolean notOptional, String name
			, String column_name, String table_Name
			, String alias, String variable_type, String variable_group, String role, String pivot, String description
			, String summarization, String groupby, String exclude_condition, String totime_javaformat
			, String totime, String timetochar, String numbertochar) {
		this.seq = new SimpleStringProperty(seq);
		this.notOptional = new SimpleBooleanProperty(notOptional);
		this.name = new SimpleStringProperty(name);
		
		this.column_name = new SimpleStringProperty(column_name);
		this.table_Name = new SimpleStringProperty(table_Name);
		
		this.alias = new SimpleStringProperty(alias);
		this.variable_type= new SimpleStringProperty(variable_type);
		this.variable_group = new SimpleStringProperty(variable_group);
		this.role = new SimpleStringProperty(role);
		this.pivot = new SimpleStringProperty(pivot);
		this.description = new SimpleStringProperty(description);
		
		this.summarization = new SimpleStringProperty(summarization);
		this.groupby = new SimpleStringProperty(groupby);
		this.exclude_condition = new SimpleStringProperty(exclude_condition);
		this.totime_javaformat = new SimpleStringProperty(totime_javaformat);
		this.totime = new SimpleStringProperty(totime);
		this.totime = new SimpleStringProperty(totime);
		this.timetochar = new SimpleStringProperty(timetochar);
		this.numbertochar = new SimpleStringProperty(numbertochar);
	}
	
	public String getSeq() {
		return seq.get();
	}
	public void setSeq(String seq) {
		this.seq.set(seq);
	}
	public SimpleStringProperty seqProperty() {
		return seq;
	}
	
	public boolean getNotOptional() {
		return notOptional.get();
	}
	public void setNotOptional(boolean optional) {
		this.notOptional.set(optional);
	}
	public SimpleBooleanProperty notOptionalProperty() {
		return notOptional;
	}
	
	public String getName() {
		return name.get();
	}
	public void setName(String name) {
		this.name.set(name);
	}
	public SimpleStringProperty nameProperty() {
		return name;
	}
	

	public String getColumn_name() {
		return column_name.get();
	}

	public void setColumn_name(String column_name) {
		this.column_name.set(column_name);
	}
	
	public SimpleStringProperty column_nameProperty() {
		return column_name;
	}

	public String getTable_Name() {
		return table_Name.get();
	}

	public void setTable_Name(String table_Name) {
		this.table_Name.set(table_Name);
	}
	
	public SimpleStringProperty table_NameProperty() {
		return table_Name;
	}
	
//
	public String getAlias() {
		return alias.get();
	}
	public void setAlias(String alias) {
		this.alias.set(alias);
	}
	public SimpleStringProperty aliasProperty() {
		return alias;
	}
	
	public String getVariable_type() {
		return variable_type.get();
	}
	public void setVariable_type(String variable_type) {
		this.variable_type.set(variable_type);
	}
	public SimpleStringProperty variable_typeProperty() {
		return variable_type;
	}
//
	public String getVariable_group() {
		return variable_group.get();
	}
	public void setVariable_group(String variable_group) {
		this.variable_group.set(variable_group);
	}
	public SimpleStringProperty variable_groupProperty() {
		return variable_group;
	}
	
//
	public String getRole() {
		return role.get();
	}
	public void setRole(String role) {
		this.role.set(role);
	}
	public SimpleStringProperty roleProperty() {
		return role;
	}
//
	public String getPivot() {
		return pivot.get();
	}
	public void setPivot(String pivot) {
		this.pivot.set(pivot);
	}
	public SimpleStringProperty pivotProperty() {
		return pivot;
	}
//	
	public String getDescription() {
		return description.get();
	}
	public void setDescription(String description) {
		this.description.set(description);
	}
	public SimpleStringProperty descriptionProperty() {
		return description;
	}

	//
	
//	@XmlAttribute
	public String getSummarization() {
		return summarization.get();
	}

	public void setSummarization(String summarization) {
		this.summarization.set(summarization);
	}
	
	public SimpleStringProperty summarizationProperty() {
		return summarization;
	}

//	@XmlAttribute
	public String getGroupby() {
		return groupby.get();
	}

	public void setGroupby(String groupby) {
		this.groupby.set(groupby);
	}
	
	public SimpleStringProperty groupbyProperty() {
		return groupby;
	}

//	@XmlAttribute(name="exclude_condition")
	public String getExclude_condition() {
		return exclude_condition.get();
	}

	public void setExclude_condition(String exclude_condition) {
		this.exclude_condition.set(exclude_condition);
	}
	
	public SimpleStringProperty exclude_conditionProperty() {
		return exclude_condition;
	}

//	@XmlAttribute(name="totime_javaformat")
	public String getTotime_javaformat() {
		return totime_javaformat.get();
	}

	public void setTotime_javaformat(String totime_javaformat) {
		this.totime_javaformat.set(totime_javaformat);
	}
	
	public SimpleStringProperty totime_javaformatProperty() {
		return totime_javaformat;
	}

//	@XmlAttribute
	public String getTotime() {
		return totime.get();
	}

	public void setTotime(String totime) {
		this.totime.set(totime);
	}
	
	public SimpleStringProperty totimeProperty() {
		return totime;
	}

//	@XmlAttribute
	public String getTimetochar() {
		return timetochar.get();
	}

	public void setTimetochar(String timetochar) {
		this.timetochar.set(timetochar);
	}
	
	public SimpleStringProperty timetocharProperty() {
		return timetochar;
	}

//	@XmlAttribute
	public String getNumbertochar() {
		return numbertochar.get();
	}

	public void setNumbertochar(String numbertochar) {
		this.numbertochar.set(numbertochar);
	}
	
	public SimpleStringProperty numbertocharProperty() {
		return numbertochar;
	}

	public DFSVariableItemModel clone() throws CloneNotSupportedException {
		DFSVariableItemModel initData = (DFSVariableItemModel) super.clone();	
		return initData;	
	}
}
