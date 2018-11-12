package com.digilog.meerkat.DFSGeneratorController.XMLController.Import;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.digilog.meerkat.model.dfsGenerator.crawler.Import.DFSCrawlGathererWrapperImportModel;
import com.digilog.meerkat.model.dfsGenerator.semimaster.Import.DFSSemimasterWrapperImportModel;

public class DFSGeneratorXMLGathererImportController {

	public DFSCrawlGathererWrapperImportModel crawlerImport(String gathererConfigFileName) {
	    try {
	    	
	    	DFSCrawlGathererWrapperImportModel gatherer = new DFSCrawlGathererWrapperImportModel();
            JAXBContext context = JAXBContext.newInstance(DFSSemimasterWrapperImportModel.class);
            Unmarshaller u = context.createUnmarshaller();
            
//            semiConfigFileName = semiConfigFileName.replaceAll("\\\\", "\\\\\\\\");
//            File tFile = new File(gathererConfigFileName);
           
            gatherer =(DFSCrawlGathererWrapperImportModel) u.unmarshal(new File(gathererConfigFileName));
            return gatherer;
            
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
	    
	}


}
