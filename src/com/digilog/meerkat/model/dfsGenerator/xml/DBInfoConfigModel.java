package com.digilog.meerkat.model.dfsGenerator.xml;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"name","value","type","item"})
@XmlRootElement(name = "database" )
public class DBInfoConfigModel {
	private String name;
	private String value;
	private String type;
	private ArrayList<DBInfoConfigModel> item;

	@XmlAttribute(name="name")
	public String getName()	{
		return name;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	@XmlAttribute(name="value")
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@XmlAttribute(name="type")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@XmlElement(name = "item")
	public ArrayList<DBInfoConfigModel> getItem() {
		return item;
	}
	
	public void setItem(ArrayList<DBInfoConfigModel> item) {
		this.item=item;
	}
	
	public DBInfoConfigModel clone() throws CloneNotSupportedException {
		DBInfoConfigModel cloneModel = (DBInfoConfigModel) super.clone();
		ArrayList<DBInfoConfigModel> deepClone = new ArrayList<DBInfoConfigModel>();
		for(DBInfoConfigModel tempModel : cloneModel.getItem())
			deepClone.add(tempModel.clone());
		cloneModel.item = deepClone;
		return cloneModel;
	}
}
