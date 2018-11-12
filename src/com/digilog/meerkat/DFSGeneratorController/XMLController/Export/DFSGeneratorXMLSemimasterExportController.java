package com.digilog.meerkat.DFSGeneratorController.XMLController.Export;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.digilog.meerkat.model.dfsGenerator.semimaster.export.DFSSemimasterWrapperExportModel;
import com.digilog.meerkat.util.FileBackup;

public class DFSGeneratorXMLSemimasterExportController {
		
	public DFSGeneratorXMLSemimasterExportController() {
		
	}
	 
	public void SemimasterExport(String semiConfigFileName, DFSSemimasterWrapperExportModel semimaster) {
	    try {
	    	FileBackup fb = new FileBackup();
            JAXBContext context = JAXBContext.newInstance(DFSSemimasterWrapperExportModel.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            
            semiConfigFileName = semiConfigFileName.replace("%appdata%", System.getenv("appdata"));
            
            fb.fileBackup(semiConfigFileName);

            // Write to File
            m.marshal(semimaster, new File(semiConfigFileName));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
	}

}
