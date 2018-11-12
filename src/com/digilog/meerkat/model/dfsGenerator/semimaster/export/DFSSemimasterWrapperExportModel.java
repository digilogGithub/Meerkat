package com.digilog.meerkat.model.dfsGenerator.semimaster.export;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import javafx.collections.ObservableList;

@XmlRootElement(name = "eDataRealm" )
@XmlType(propOrder={"context", "attribute", "descriptor" ,"datatag"})
public class DFSSemimasterWrapperExportModel {
	private String version;
	private DFSContextModel context;
	private DFSAttributeModel attribute;
	private DFSDescriptorExportModel descriptor;
	private ObservableList<DFSSemiDatatagExportModel> datatag;
	
	@XmlAttribute
	public String getVersion()	{
		return version;
	}
	
	public void setVersion(String version) {
		this.version=version;
	}
	
    @XmlElement(name = "context")
	public DFSContextModel getContext() {
		return context;
	}
	
	public void setContext(DFSContextModel dfscontext) {
		this.context=dfscontext;
	}
	
    @XmlElement(name = "attribute")
	public DFSAttributeModel getAttribute() {
		return attribute;
	}
	
	public void setAttribute(DFSAttributeModel dfsattribute) {
		this.attribute=dfsattribute;
	}
	
    @XmlElement(name = "descriptor")
	public DFSDescriptorExportModel getDescriptor() {
		return descriptor;
	}
	
	public void setDescriptor(DFSDescriptorExportModel dfsdescriptor) {
		this.descriptor=dfsdescriptor;
	}
	
    @XmlElement(name = "datatag")
	public ObservableList<DFSSemiDatatagExportModel> getDatatag() {
		return datatag;
	}
	
	public void setDatatag(ObservableList<DFSSemiDatatagExportModel> dfsdatatags) {
		this.datatag=dfsdatatags;
	}
}

