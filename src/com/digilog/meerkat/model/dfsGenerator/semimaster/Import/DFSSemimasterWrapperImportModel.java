package com.digilog.meerkat.model.dfsGenerator.semimaster.Import;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "eDataRealm" )
@XmlType(propOrder={"context", "attribute", "descriptor" ,"datatag"})

public class DFSSemimasterWrapperImportModel{	
		private String version;
		private DFSContextImportModel context;
		private DFSAttributeImportModel attribute;
		private DFSDescriptorImportModel descriptor;
		private ArrayList<DFSSemiDatatagImportModel> datatag;
		
		@XmlAttribute
		public String getVersion()	{
			return version;
		}
		
		public void setVersion(String version) {
			this.version=version;
		}
		
	    @XmlElement(name = "context")
		public DFSContextImportModel getContext() {
			return context;
		}
		
		public void setContext(DFSContextImportModel dfscontext) {
			this.context=dfscontext;
		}
		
	    @XmlElement(name = "attribute")
		public DFSAttributeImportModel getAttribute() {
			return attribute;
		}
		
		public void setAttribute(DFSAttributeImportModel dfsattribute) {
			this.attribute=dfsattribute;
		}
		
	    @XmlElement(name = "descriptor")
		public DFSDescriptorImportModel getDescriptor() {
			return descriptor;
		}
		
		public void setDescriptor(DFSDescriptorImportModel dfsdescriptor) {
			this.descriptor=dfsdescriptor;
		}
		
	    @XmlElement(name = "datatag")
		public ArrayList<DFSSemiDatatagImportModel> getDatatag() {
			return datatag;
		}
		
		public void setDatatag(ArrayList<DFSSemiDatatagImportModel> dfsdatatags) {
			this.datatag=dfsdatatags;
		}

}
