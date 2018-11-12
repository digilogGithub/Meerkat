package com.digilog.meerkat.model.dfsGenerator.crawler.export;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"name","hint","temptable","temptable_keycolumn","DFSTables","DFSPartitions","DFSVariables"})
public class DFSMethodExportModel implements Cloneable {
	private String name;
	private String hint;
	private String temptable;
	private String temptable_keycolumn;
	
	private DFSTablesExportModel dfsTables;
	private DFSPartitionsExportModel dfspartitions;
	private DFSVariablesExportModel dfsvariables;
	
	public DFSMethodExportModel() {
		dfsTables = new DFSTablesExportModel();
		dfspartitions = new DFSPartitionsExportModel();
		dfsvariables = new DFSVariablesExportModel();
	}
	

	@XmlAttribute
	public String getName()	{
		return name;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	@XmlAttribute
	public String getHint(){
		return hint;
	}
	
	public void setHint(String hint){
		 this.hint=hint;
	}
	
	@XmlAttribute
	public String getTemptable(){
		return temptable;
	}
	
	public void setTemptable(String temptable){
		this.temptable=temptable;
	}
	
	
	@XmlAttribute(name="temptable_keycolumn")
	public String getTemptable_keycolumn(){
		return temptable_keycolumn;
	}
	
	public void setTemptable_keycolumn(String temptable_keycolumn){
		 this.temptable_keycolumn=temptable_keycolumn;
	}
	
	@XmlElement(name = "dfstables")
	public DFSTablesExportModel getDFSTables() {
		return dfsTables;
	}
	
	public void setDFSTables(DFSTablesExportModel dfsTablesParent) {
		this.dfsTables=dfsTablesParent;
	}
	
	@XmlElement(name = "dfspartitions")
	public DFSPartitionsExportModel getDFSPartitions() {
		return dfspartitions;
	}
	
	public void setDFSPartitions(DFSPartitionsExportModel dfspartitions) {
		this.dfspartitions=dfspartitions;
	}
	
	@XmlElement(name = "dfsvariables")
	public DFSVariablesExportModel getDFSVariables() {
		return dfsvariables;
	}
	
	public void setDFSVariables(DFSVariablesExportModel dfsvariables) {
		this.dfsvariables=dfsvariables;
	}

	public DFSMethodExportModel clone() throws CloneNotSupportedException {
		DFSMethodExportModel dfsMethodModel = (DFSMethodExportModel) super.clone();
		dfsMethodModel.dfsTables = (DFSTablesExportModel) dfsTables.clone();
		dfsMethodModel.dfspartitions = (DFSPartitionsExportModel) dfspartitions.clone();
		dfsMethodModel.dfsvariables = (DFSVariablesExportModel) dfsvariables.clone();	
		return dfsMethodModel;	
	}
}
