package com.digilog.meerkat.model.dfsGenerator.crawler.export;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import javafx.collections.ObservableList;



@XmlRootElement(name = "crawler" )
public class DFSCrawlGathererWrapperExportModel {
	
	private ObservableList<DFSDatatagExportModel> dfsdatatags;
	private String source_db;
	
	@XmlAttribute
	public String getName(){
		return source_db;
	}
	
	public void setName(String source_db){
		 this.source_db=source_db;
	}
	
    @XmlElement(name = "dfsdatatag")
	public ObservableList<DFSDatatagExportModel> getdfsdatatags() {
		return dfsdatatags;
	}
	
	public void setDFSDatatags(ObservableList<DFSDatatagExportModel> dfsdatatags) {
		this.dfsdatatags=dfsdatatags;
	}
}
