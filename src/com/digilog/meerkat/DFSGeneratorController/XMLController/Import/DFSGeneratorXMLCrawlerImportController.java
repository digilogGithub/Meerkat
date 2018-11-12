package com.digilog.meerkat.DFSGeneratorController.XMLController.Import;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.digilog.meerkat.model.dfsGenerator.crawler.Import.DFSCrawlGathererWrapperImportModel;

public class DFSGeneratorXMLCrawlerImportController {

	public DFSCrawlGathererWrapperImportModel crawlerImport(String crawlerConfigFileName) {
	    try {
	    	
	    	DFSCrawlGathererWrapperImportModel crawler = new DFSCrawlGathererWrapperImportModel();
            JAXBContext context = JAXBContext.newInstance(DFSCrawlGathererWrapperImportModel.class);
            Unmarshaller u = context.createUnmarshaller();
            System.out.println(crawlerConfigFileName);
//            semiConfigFileName = semiConfigFileName.replaceAll("\\\\", "\\\\\\\\");
           
            crawler =(DFSCrawlGathererWrapperImportModel) u.unmarshal(new File(crawlerConfigFileName));
            return crawler;
            
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
	    
	}


}
