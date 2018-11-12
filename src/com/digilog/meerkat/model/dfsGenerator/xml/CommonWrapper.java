package com.digilog.meerkat.model.dfsGenerator.xml;

import java.util.Map;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.digilog.meerkat.model.dfsGenerator.DFSAttributeMappingStorgeModel;


@XmlRootElement(name = "crawler" )
public class CommonWrapper {
	private Map<String, DFSAttributeMappingStorgeModel> dfsdatatags;
	private String source_db;
	
	@XmlAttribute
	public String getName(){
		return source_db;
	}
	
	public void setName(String source_db){
		 this.source_db=source_db;
	}
	
    @XmlElement(name = "dfsdatatag")
	public Map<String, DFSAttributeMappingStorgeModel> getdfsdatatags() {
		return dfsdatatags;
	}
	
	public void setDFSDatatags(Map<String, DFSAttributeMappingStorgeModel> dfsdatatags) {
		this.dfsdatatags=dfsdatatags;
	}
}
