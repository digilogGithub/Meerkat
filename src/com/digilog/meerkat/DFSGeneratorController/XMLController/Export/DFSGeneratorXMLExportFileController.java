package com.digilog.meerkat.DFSGeneratorController.XMLController.Export;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.digilog.meerkat.model.dfsGenerator.crawler.export.DFSCrawlGathererWrapperExportModel;
import com.digilog.meerkat.model.dfsGenerator.semimaster.export.DFSSemimasterWrapperExportModel;
import com.digilog.meerkat.model.dfsGenerator.xml.DBInfoConfigModel;
import com.digilog.meerkat.model.dfsGenerator.xml.EDataRealmConfigModel;
import com.digilog.meerkat.util.FileBackup;

public class DFSGeneratorXMLExportFileController {
	
	
//	public void commonExport(String fileName, T exportClass) {
//	    try {
//	    	FileBackup fb = new FileBackup();
//            JAXBContext context = JAXBContext.newInstance(T.class);
//            Marshaller m = context.createMarshaller();
//            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
//            
//            fileName = fileName.replace("%appdata%", System.getenv("appdata"));
//            
//            fb.fileBackup(fileName);
//
//            // Write to File
//            m.marshal(exportClass, new File(fileName));
//        } catch (JAXBException e) {
//            e.printStackTrace();
//        }
//	}
	
	public void eDLConfigExport(String fileName, EDataRealmConfigModel model) {
	    try {
	    	FileBackup fb = new FileBackup();
            JAXBContext context = JAXBContext.newInstance(EDataRealmConfigModel.class);
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
	
	public void semimasterExport(String fileName, DFSSemimasterWrapperExportModel semimaster) {
	    try {
	    	FileBackup fb = new FileBackup();
            JAXBContext context = JAXBContext.newInstance(DFSSemimasterWrapperExportModel.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            
            fileName = fileName.replace("%appdata%", System.getenv("appdata"));
            
            fb.fileBackup(fileName);

            // Write to File
            m.marshal(semimaster, new File(fileName));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
	}
	
	
	public void crawlGathererExport(String fileName, DFSCrawlGathererWrapperExportModel model) {
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
	
	public void dbInfoExport(String fileName, DBInfoConfigModel dbInfo) {
	    try {
	    	FileBackup fb = new FileBackup();
            JAXBContext context = JAXBContext.newInstance(DBInfoConfigModel.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            
            fileName = fileName.replace("%appdata%", System.getenv("appdata"));
            
            fb.fileBackup(fileName);

            // Write to File
            m.marshal(dbInfo, new File(fileName));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
	}
	
	

}
