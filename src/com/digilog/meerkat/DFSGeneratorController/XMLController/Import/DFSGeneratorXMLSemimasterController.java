package com.digilog.meerkat.DFSGeneratorController.XMLController.Import;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.digilog.meerkat.model.dfsGenerator.semimaster.Import.DFSSemimasterWrapperImportModel;


public class DFSGeneratorXMLSemimasterController {
	
	 
	public DFSSemimasterWrapperImportModel SemimasterImport(String semiConfigFileName) {
	    try {
	    	
	    	DFSSemimasterWrapperImportModel semimaster = new DFSSemimasterWrapperImportModel();
            JAXBContext context = JAXBContext.newInstance(DFSSemimasterWrapperImportModel.class);
            Unmarshaller u = context.createUnmarshaller();
            
            semiConfigFileName = semiConfigFileName.replace("%appdata%", System.getenv("appdata"));
            
            semimaster =(DFSSemimasterWrapperImportModel) u.unmarshal(new File(semiConfigFileName));
            return semimaster;
            
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
	    
	}

}
