package com.digilog.meerkat.model.dfsGenerator.crawler;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"name","prefix","postfix","join","condition"})
public class DFSTableModel implements Cloneable {

	private String name;
	private String prefix;
	private String postfix;
	private String join;
	private String condition;
	
	@XmlAttribute
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	@XmlAttribute
	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	@XmlAttribute
	public String getPostfix() {
		return postfix;
	}


	public void setPostfix(String postfix) {
		this.postfix = postfix;
	}

	@XmlAttribute
	public String getJoin() {
		return join;
	}

	
	public void setJoin(String join) {
		this.join = join;
	}

	@XmlAttribute
	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public DFSTableModel clone() throws CloneNotSupportedException {
		DFSTableModel cloneModel = (DFSTableModel) super.clone();
		return cloneModel;
	}

}
