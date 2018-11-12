package com.digilog.meerkat.DFSGeneratorController.XMLController.Export;

import java.util.ArrayList;

import com.digilog.meerkat.DFSGeneratorController.XMLController.Import.DFSGeneratorXMLImportController;
import com.digilog.meerkat.attribute.DefineAtrribute;
import com.digilog.meerkat.model.dfsGenerator.xml.DFSGeneratorXMLAllInfoModel;
import com.digilog.meerkat.model.dfsGenerator.xml.DFSGeneratorXMLInfoModel;
import com.digilog.meerkat.model.dfsGenerator.xml.EDataRealmConfigModel;
import com.digilog.meerkat.view.RootGeneralConfigViewController;

public class DFSGeneratorXMLExporteDLWindowsConfigController {

	public EDataRealmConfigModel createEDLWindowsConfigFile(DFSGeneratorXMLAllInfoModel dfsXMLAllInfo) {

		DFSGeneratorXMLImportController xic = new DFSGeneratorXMLImportController();
		EDataRealmConfigModel currenteDLConfig = new EDataRealmConfigModel();

//		if (dfsXMLAllInfo.isCreateMode())
			currenteDLConfig = xic.eDataRealmConfigImport(DefineAtrribute.TEMPLATE_eDATAREALM_CONFIG_WINDOWS_XML_PATH);
//			currenteDLConfig = xic.eDataRealmConfigImport("file:templateXML/templateEDataRealmConfigForWindows.xml");
			
//		else
//			currenteDLConfig = xic.eDataRealmConfigImport(dfsXMLAllInfo.getEDataRealmFileName());
		for (EDataRealmConfigModel tempModel : currenteDLConfig.getItem()) {
			if ("REPOSITORY".equals(tempModel.getName())) {
				for (EDataRealmConfigModel psqlInfo : tempModel.getItem())
					if ("PG_DUMP".equals(psqlInfo.getName())) {
						psqlInfo.setValue(RootGeneralConfigViewController.pg_defaultPath + "\\pg_dump");
						continue;
					} else if ("PG_RESTORE".equals(psqlInfo.getName())) {
						psqlInfo.setValue(RootGeneralConfigViewController.pg_defaultPath + "\\pg_restore");
						break;
					}
				continue;
			}

			if ("MASTER_CONFIGURATIONS".equals(tempModel.getName())) {
				tempModel.getItem().get(0)
						.setValue(dfsXMLAllInfo.getSEMIFileName().replace(System.getenv("appdata"), "%appdata%"));
				continue;
			}

			if ("DFS".equals(tempModel.getName())) {
				for (EDataRealmConfigModel dfsInfo : tempModel.getItem()) {
					if ("DATA_CRAWLER".equals(dfsInfo.getName())) {
						String crawlerValue = dfsInfo.getValue();
						Boolean noDBInfo = false;
						if ("".equals(crawlerValue) || null == crawlerValue) {
							dfsInfo.setItem(new ArrayList<>());
							noDBInfo = true;
						}
						for (DFSGeneratorXMLInfoModel temp : dfsXMLAllInfo.getDfsGeneratorXMLInfoModel()) {
							String classValue = "com.bistel.edr.dfs.crawler." + temp.getEDLDatabaseType()
									+ "TempTableCrawler";
							EDataRealmConfigModel tempDBCrwaler = new EDataRealmConfigModel(temp.getDatabaseName(),
									classValue, "DB_DFS");
							tempDBCrwaler.setItem(new ArrayList<>());
							tempDBCrwaler.getItem().add(new EDataRealmConfigModel("CONFIG_FILE_PATH",
									temp.getCrawlerFileName().replace(System.getenv("appdata"), "%appdata%"), "FILE"));
							Boolean exists = false;
							for (int i = 0; i < dfsInfo.getItem().size(); i++)
								if (tempDBCrwaler.getName().equals(dfsInfo.getItem().get(i).getName())) {
									dfsInfo.getItem().set(i, tempDBCrwaler);
									exists = true;
									break;
								}
							if (!exists) {
								if (noDBInfo) {
									crawlerValue = temp.getDatabaseName();
									noDBInfo = false;
								} else
									crawlerValue = crawlerValue + "," + temp.getDatabaseName();
								dfsInfo.getItem().add(tempDBCrwaler);
							}
						}

						dfsInfo.setValue(crawlerValue);
						dfsInfo.setType("");
						continue;

					}

					if ("DATA_GATHERER".equals(dfsInfo.getName())) {
						String gathereValue = dfsInfo.getValue();
						Boolean noDBInfo = false;
						if ("".equals(gathereValue) || null == gathereValue) {
							dfsInfo.setItem(new ArrayList<>());
							noDBInfo = true;
						}
						for (DFSGeneratorXMLInfoModel temp : dfsXMLAllInfo.getDfsGeneratorXMLInfoModel()) {
							String classValue = "com.bistel.edr.dfs.gatherer." + temp.getEDLDatabaseType()
									+ "TempTableGatherer";
							EDataRealmConfigModel tempDBGatherer = new EDataRealmConfigModel(temp.getDatabaseName(),
									classValue, "DB_DFS");
							tempDBGatherer.setItem(new ArrayList<>());
							tempDBGatherer.getItem().add(new EDataRealmConfigModel("CONFIG_FILE_PATH",
									temp.getGathererFileName().replace(System.getenv("appdata"), "%appdata%"), "FILE"));
							Boolean exists = false;
							for (int i = 0; i < dfsInfo.getItem().size(); i++)
								if (tempDBGatherer.getName().equals(dfsInfo.getItem().get(i).getName())) {
									dfsInfo.getItem().set(i, tempDBGatherer);
									exists = true;
									break;
								}
							if (!exists) {
								if (noDBInfo) {
									gathereValue = temp.getDatabaseName();
									noDBInfo = false;
								} else
									gathereValue = gathereValue + "," + temp.getDatabaseName();
								dfsInfo.getItem().add(tempDBGatherer);
							}
						}

						dfsInfo.setValue(gathereValue);
						dfsInfo.setType("");
						continue;
					}
				}
				continue;
			}

			if ("DBINFO".equals(tempModel.getName())) {

				String dbInfoValue = tempModel.getValue();
				Boolean noDBInfo = false;

				if ("".equals(dbInfoValue) || null == dbInfoValue) {
					tempModel.setItem(new ArrayList<>());
					noDBInfo = true;
				}

				for (DFSGeneratorXMLInfoModel temp : dfsXMLAllInfo.getDfsGeneratorXMLInfoModel()) {
					EDataRealmConfigModel dbSource = new EDataRealmConfigModel(temp.getDatabaseName(), "", "");
					dbSource.setItem(new ArrayList<>());
					dbSource.getItem().add(new EDataRealmConfigModel("CONFIG_FILE_PATH",
							temp.getDatabaseInfoFileName().replace(System.getenv("appdata"), "%appdata%"), "FILE"));
					Boolean exists = false;
					for (int i = 0; i < tempModel.getItem().size(); i++)
						if (dbSource.getName().equals(tempModel.getItem().get(i).getName())) {
							tempModel.getItem().set(i, dbSource);
							exists = true;
							break;
						}
					if (!exists) {
						if (noDBInfo) {
							dbInfoValue = temp.getDatabaseName();
							noDBInfo = false;
						} else
							dbInfoValue = dbInfoValue + "," + temp.getDatabaseName();
						tempModel.getItem().add(dbSource);
					}
				}

				tempModel.setValue(dbInfoValue);
				tempModel.setType("");
				break;
			}
		}
		
		return currenteDLConfig;
	}	
}
