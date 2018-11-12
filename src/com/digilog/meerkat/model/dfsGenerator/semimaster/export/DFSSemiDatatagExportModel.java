package com.digilog.meerkat.model.dfsGenerator.semimaster.export;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.digilog.meerkat.model.dfsGenerator.semimaster.DFSItemModel;

import javafx.collections.ObservableList;

@XmlType(propOrder={"enabled", "name", "alias" ,"type","level","datasource","dfs_query_by","sort_by_attributekey","desc","items"})
public class DFSSemiDatatagExportModel {
	
//	private SimpleStringProperty table_format;
//	private SimpleStringProperty data_tag_name;
//	private SimpleStringProperty alias_name;
//	private SimpleStringProperty table_Name;
//	private SimpleStringProperty type;
//	private SimpleStringProperty level;
//	private SimpleStringProperty totime_javaformat;
//	private SimpleStringProperty totime;
//	private SimpleStringProperty timetochar;
//	private SimpleStringProperty numbertochar;
//	private SimpleBooleanProperty contentBoolean;
	
	private String enabled;
	private String name;
	private String alias;
	private String type;
	private String level;
	private String datasource;
	private String dfs_query_by;
	private String sort_by_attributekey;
	private String desc;
	
	private ObservableList<DFSItemModel> items;

	public DFSSemiDatatagExportModel() {

	}
	
	@XmlAttribute (name="enabled")
	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled=enabled;
	}
	
	@XmlAttribute (name="name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name=name;
	}
	
	@XmlAttribute (name="alias")
	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias=alias;
	}
	

	@XmlAttribute (name="type")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	
	@XmlAttribute (name="level")
	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	
	@XmlAttribute (name="datasource")
	public String getDatasource() {
		return datasource;
	}

	public void setDatasource(String datasource) {
		this.datasource = datasource;
	}

	
	@XmlAttribute (name="dfs_query_by")
	public String getDfs_query_by() {
		return dfs_query_by;
	}

	public void setDfs_query_by(String dfs_query_by) {
		this.dfs_query_by = dfs_query_by;
	}

	
	@XmlAttribute (name="sort_by_attributekey")
	public String getSort_by_attributekey() {
		return sort_by_attributekey;
	}

	public void setSort_by_attributekey(String sort_by_attributekey) {
		this.sort_by_attributekey = sort_by_attributekey;
	}

	
	@XmlAttribute (name="desc")
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	
	@XmlElement(name = "item")
	public ObservableList<DFSItemModel> getItems() {
		return items;
	}

	public void setItems(ObservableList<DFSItemModel> items) {
		this.items = items;
	}
}
