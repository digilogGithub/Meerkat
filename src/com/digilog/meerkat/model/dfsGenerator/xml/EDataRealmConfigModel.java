package com.digilog.meerkat.model.dfsGenerator.xml;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"name","value","type","item"})
@XmlRootElement(name = "eDataRealm" )
public class EDataRealmConfigModel implements Cloneable{
	private String name;
	private String value;
	private String type;
	private ArrayList<EDataRealmConfigModel> item;
	
	public EDataRealmConfigModel() {
		
	}
	
	public EDataRealmConfigModel(String name, String value, String type) {
		this.name = name;
		this.value = value;
		this.type =type;
	}

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
	public ArrayList<EDataRealmConfigModel> getItem() {
		return item;
	}
	
	public void setItem(ArrayList<EDataRealmConfigModel> item) {
		this.item=item;
	}
	
	public EDataRealmConfigModel clone() throws CloneNotSupportedException {
		EDataRealmConfigModel cloneModel = (EDataRealmConfigModel) super.clone();
		ArrayList<EDataRealmConfigModel> deepClone = new ArrayList<EDataRealmConfigModel>();
		for(EDataRealmConfigModel tempModel : cloneModel.getItem())
			deepClone.add(tempModel.clone());
		cloneModel.item = deepClone;
		return cloneModel;
	}
}
