package com.digilog.meerkat.model.dfsGenerator.semimaster;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"seq", "name", "alias" ,"variable_type","variable_group","optional","role","description"})
public class DFSItemModel {
	
	private int seq;
	private String name;
	private String alias;
	private String description;
	private String optional;
	private String variable_type;
	private String variable_group;
	private String role;
	
	@XmlAttribute(name="seq")
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	
	@XmlAttribute(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@XmlAttribute(name="alias")
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	
	@XmlAttribute(name="description")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@XmlAttribute(name="optional")
	public String getOptional() {
		return optional;
	}
	public void setOptional(String optional) {
		this.optional = optional;
	}
	
	@XmlAttribute(name="variable_type")
	public String getVariable_type() {
		return variable_type;
	}
	public void setVariable_type(String variable_type) {
		this.variable_type = variable_type;
	}
	
	@XmlAttribute(name="variable_group")
	public String getVariable_group() {
		return variable_group;
	}
	public void setVariable_group(String variable_group) {
		this.variable_group = variable_group;
	}
	
	@XmlAttribute(name="role")
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}
