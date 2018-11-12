package com.digilog.meerkat.model.dfsGenerator.crawler.Import;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.digilog.meerkat.model.dfsGenerator.crawler.Import.DFSPartitionsImportModel;
import com.digilog.meerkat.model.dfsGenerator.crawler.Import.DFSTablesImportModel;
import com.digilog.meerkat.model.dfsGenerator.crawler.Import.DFSVariablesImportModel;

@XmlType(propOrder={"name","hint","temptable","temptable_keycolumn","DFSTables","DFSPartitions","DFSVariables"})
public class DFSMethodImportModel implements Cloneable {
	
	private String name;
	private String hint;
	private String temptable;
	private String temptable_keycolumn;
	
	private DFSTablesImportModel dfsTables;
	private DFSPartitionsImportModel dfspartitions;
	private DFSVariablesImportModel dfsvariables;
	

	@XmlAttribute (name="name")
	public String getName()	{
		return name;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	@XmlAttribute (name="hint")
	public String getHint(){
		return hint;
	}
	
	public void setHint(String hint){
		 this.hint=hint;
	}
	
	@XmlAttribute (name="temptable")
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
	public DFSTablesImportModel getDFSTables() {
		return dfsTables;
	}
	
	public void setDFSTables(DFSTablesImportModel dfsTablesParent) {
		this.dfsTables=dfsTablesParent;
	}
	
	@XmlElement(name = "dfspartitions")
	public DFSPartitionsImportModel getDFSPartitions() {
		return dfspartitions;
	}
	
	public void setDFSPartitions(DFSPartitionsImportModel dfspartitions) {
		this.dfspartitions=dfspartitions;
	}
	
	@XmlElement(name = "dfsvariables")
	public DFSVariablesImportModel getDFSVariables() {
		return dfsvariables;
	}
	
	public void setDFSVariables(DFSVariablesImportModel dfsvariables) {
		this.dfsvariables=dfsvariables;
	}

	public DFSMethodImportModel clone() throws CloneNotSupportedException {
		DFSMethodImportModel dfsMethodModel = (DFSMethodImportModel) super.clone();
		dfsMethodModel.dfsTables = (DFSTablesImportModel) dfsTables.clone();
		dfsMethodModel.dfspartitions = (DFSPartitionsImportModel) dfspartitions.clone();
		dfsMethodModel.dfsvariables = (DFSVariablesImportModel) dfsvariables.clone();	
		return dfsMethodModel;	
	}

}
