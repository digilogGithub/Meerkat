package com.digilog.meerkat.DFSGeneratorController.XMLController.Export;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.digilog.meerkat.model.dfsGenerator.crawler.export.DFSCrawlGathererWrapperExportModel;
import com.digilog.meerkat.util.FileBackup;

public class DFSGeneratorXMLCrawlGathererExportController {
	
	public DFSGeneratorXMLCrawlGathererExportController() {
		
	}
	 
	public void CrawlGathererExport(String fileName, DFSCrawlGathererWrapperExportModel model) {
	    try {
	    	FileBackup fb = new FileBackup();
            JAXBContext context = JAXBContext.newInstance(DFSCrawlGathererWrapperExportModel.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);        
            fileName = fileName.replace("%appdata%", System.getenv("appdata"));
            
            fb.fileBackup(fileName);

            // Write to File
            m.marshal(model, new File(fileName));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
	}
}
