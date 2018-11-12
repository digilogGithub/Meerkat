package com.digilog.meerkat.model.dfsGenerator.crawler.Import;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "crawler" )
public class DFSCrawlGathererWrapperImportModel {
	
	private String source_db;
	private ArrayList<DFSDatatagImportModel> dfsdatatags;
	
	@XmlAttribute
	public String getName(){
		return source_db;
	}
	
	public void setName(String source_db){
		 this.source_db=source_db;
	}

	 @XmlElement(name = "dfsdatatag")
	public ArrayList<DFSDatatagImportModel> getDFSdatatags() {
		return dfsdatatags;
	}

	public void setDFSdatatags(ArrayList<DFSDatatagImportModel> dfsdatatags) {
		this.dfsdatatags = dfsdatatags;
	}
}
