package com.digilog.meerkat.view.DFSGenerator.xml;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import com.digilog.meerkat.MeerkatMainApp;
import com.digilog.meerkat.DFSGeneratorController.XMLController.Import.DFSGeneratorXMLImportController;
import com.digilog.meerkat.DFSGeneratorController.semimaster.DFSSemiMasterDefineMasterInitDataController;
import com.digilog.meerkat.attribute.DefineAtrribute;
import com.digilog.meerkat.model.dfsGenerator.DFSDatabaseConnectionModel;
import com.digilog.meerkat.model.dfsGenerator.DFSDefineTableModel;
import com.digilog.meerkat.model.dfsGenerator.DFSGeneratorAndDatabaseListModel;
import com.digilog.meerkat.model.dfsGenerator.crawler.DFSPartitionModel;
import com.digilog.meerkat.model.dfsGenerator.crawler.DFSTableModel;
import com.digilog.meerkat.model.dfsGenerator.crawler.DFSVariableModel;
import com.digilog.meerkat.model.dfsGenerator.crawler.Import.DFSCrawlGathererWrapperImportModel;
import com.digilog.meerkat.model.dfsGenerator.crawler.Import.DFSDatatagImportModel;
import com.digilog.meerkat.model.dfsGenerator.crawler.Import.DFSGeneratorImportWholeInfo;
import com.digilog.meerkat.model.dfsGenerator.crawler.Import.DFSMethodImportModel;
import com.digilog.meerkat.model.dfsGenerator.crawler.Import.DFSVariableImportModel;
import com.digilog.meerkat.model.dfsGenerator.crawler.export.DFSCrawlGathererWrapperExportModel;
import com.digilog.meerkat.model.dfsGenerator.crawler.export.DFSDatatagExportModel;
import com.digilog.meerkat.model.dfsGenerator.crawler.export.DFSMethodExportModel;
import com.digilog.meerkat.model.dfsGenerator.crawler.export.DFSPartitionsExportModel;
import com.digilog.meerkat.model.dfsGenerator.crawler.export.DFSTablesExportModel;
import com.digilog.meerkat.model.dfsGenerator.crawler.export.DFSVariablesExportModel;
import com.digilog.meerkat.model.dfsGenerator.semimaster.DFSDefineDatatagInitItemModel;
import com.digilog.meerkat.model.dfsGenerator.semimaster.DFSDefineInitModel;
import com.digilog.meerkat.model.dfsGenerator.semimaster.DFSItemModel;
import com.digilog.meerkat.model.dfsGenerator.semimaster.DFSVariableItemModel;
import com.digilog.meerkat.model.dfsGenerator.semimaster.Import.DFSDefineDatatagImportListModel;
import com.digilog.meerkat.model.dfsGenerator.semimaster.Import.DFSSemiDatatagImportModel;
import com.digilog.meerkat.model.dfsGenerator.semimaster.Import.DFSSemimasterWrapperImportModel;
import com.digilog.meerkat.model.dfsGenerator.xml.DBInfoConfigModel;
import com.digilog.meerkat.model.dfsGenerator.xml.DFSGeneratorXMLAllInfoModel;
import com.digilog.meerkat.model.dfsGenerator.xml.DFSGeneratorXMLInfoModel;
import com.digilog.meerkat.model.dfsGenerator.xml.EDataRealmConfigModel;
import com.digilog.meerkat.model.dfsGenerator.xml.export.ExportCommonViewModel;
import com.digilog.meerkat.util.MessageDialog;
//import com.digilog.meerkat.view.generalConfiguration.GeneralConfigurationController;
import com.digilog.meerkat.view.RootGeneralConfigViewController;
import com.digilog.meerkat.view.DFSGenerator.DFSGeneratorMainViewController;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DFSGeneratorXMLImportViewController {
	
	private Stage dialogStage;

	private MessageDialog mDialog;
	private Alert messageLog;

	@FXML
	private TableView<ExportCommonViewModel> eDLConfigFileTableView;
	@FXML
	private TableColumn<ExportCommonViewModel, String> typeColumn;
	@FXML
	private TableColumn<ExportCommonViewModel, String> ConfigFileNameColumn;
	@FXML
	private TableColumn<ExportCommonViewModel, String> ConfigFilePathColumn;
	@FXML
	private TableColumn<ExportCommonViewModel, Boolean> existsColumn;
	@FXML
	private TableColumn<ExportCommonViewModel, Boolean> selectImportColumn;
	@FXML
	private ContextMenu tableViewMenu;
	@FXML
	private MenuItem selectAll;
	@FXML
	private MenuItem unselectAll;
	@FXML
	private MenuItem selectReverse;
	@FXML
	private MenuItem selectDFS;
	
	
	@FXML
	private TextField eDataRealmConfigPathTextField;

	@FXML
	private Button Browser_Button;
	@FXML
	private Button Import_Button;
	@FXML
	private Button Cancel_Button;
	
	static boolean importXMLFile;
	private DFSGeneratorXMLAllInfoModel dfsXMLALLInfo;
	private DFSGeneratorXMLImportController dfsImportCtl;
	private EDataRealmConfigModel realmConfig;	
	private ObservableList<ExportCommonViewModel> viewAllModels;
	private FileChooser fileChooser;
	private File file;
	
	private DFSGeneratorImportWholeInfo dfsImportAllInfo;
	private DFSSemimasterWrapperImportModel semimaster;
	private ObservableList<DFSDefineTableModel> DFSDefineTableAllData;
	private ObservableList<DFSDefineTableModel> DFSDefineTableData;
	private ObservableList<DFSDatatagExportModel> dfsdatatags;
	private ObservableList<DFSVariableItemModel> SemiMasterItemInitData;
	private ObservableList<DFSCrawlGathererWrapperExportModel> crawlerMergeModels;
	private DFSCrawlGathererWrapperExportModel allDFSdataTags;
	private ObservableList<DFSCrawlGathererWrapperImportModel> crawlerModels;
	private ObservableList<DFSCrawlGathererWrapperImportModel> gathererModels;
	private DFSDatabaseConnectionModel dfsDatabaseConnectionModel;
	private DFSDefineInitModel semiMasterInitData;
	private DFSSemiMasterDefineMasterInitDataController semiDataController;
	
	
	public DFSGeneratorXMLImportViewController() {
		mDialog = new MessageDialog();
		dfsXMLALLInfo = new DFSGeneratorXMLAllInfoModel();
		importXMLFile = false;
		dfsImportCtl = new DFSGeneratorXMLImportController();
		realmConfig = new EDataRealmConfigModel();
		viewAllModels = FXCollections.observableArrayList();
		fileChooser = new FileChooser();
		semiDataController = new DFSSemiMasterDefineMasterInitDataController();
	}
	
	@FXML
	private void initialize() {	
		typeColumn.setCellValueFactory(cellData -> cellData.getValue().modeProperty());
		typeColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		ConfigFileNameColumn.setCellValueFactory(cellData -> cellData.getValue().databaseSourceProperty());
		ConfigFileNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		ConfigFilePathColumn.setCellValueFactory(cellData -> cellData.getValue().propertyProperty());
		ConfigFilePathColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		existsColumn.setCellValueFactory(cellData -> cellData.getValue().checkProperty());
		existsColumn.setCellFactory(CheckBoxTableCell.forTableColumn(null,false));
		selectImportColumn.setCellValueFactory(cellData -> cellData.getValue().doneProperty());
		selectImportColumn.setCellFactory(CheckBoxTableCell.forTableColumn(null,false));
	}
	
	private void setInitDFSDataInstance() {
		semimaster = new DFSSemimasterWrapperImportModel();
		crawlerMergeModels = FXCollections.observableArrayList();
		crawlerModels = FXCollections.observableArrayList();
		gathererModels = FXCollections.observableArrayList();
		DFSDefineTableAllData = FXCollections.observableArrayList();
		SemiMasterItemInitData = FXCollections.observableArrayList();
		semiMasterInitData = new DFSDefineInitModel();
		dfsDatabaseConnectionModel = new DFSDatabaseConnectionModel();
	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}
	
	@FXML
	private void handle_setSelectAll() {
		if(viewAllModels.size()>0)
		for(ExportCommonViewModel tempModel : viewAllModels)
			tempModel.setDone(true);
	}
	
	@FXML
	private void handle_setUnselectAll() {
		if(viewAllModels.size()>0)
		for(ExportCommonViewModel tempModel : viewAllModels)
			tempModel.setDone(false);
	}
	
	@FXML
	private void handle_setSelectReverse() {
		if(viewAllModels.size()>0)
		for(ExportCommonViewModel tempModel : viewAllModels)
			if(tempModel.getDone())
				tempModel.setDone(false);
			else 
				tempModel.setDone(true);
	}
	
	@FXML
	private void handle_setSelectDFS() {
		if(viewAllModels.size()>0)
		for(ExportCommonViewModel tempModel : viewAllModels) {
			if("SEMI".equals(tempModel.getMode()) || "Crawler".equals(tempModel.getMode()) || "Gatherer".equals(tempModel.getMode())) {
				tempModel.setDone(true);
				continue;
			}
			else
				tempModel.setDone(false);
		}
	}
	
	@FXML
	private void setInitData(String filePath) {
		eDataRealmConfigPathTextField.setText(filePath);
		realmConfig = dfsImportCtl.eDataRealmConfigImport(filePath);
		if (realmConfig != null) {
			viewAllModels.add(new ExportCommonViewModel("Environment","eDataRealm Config",RootGeneralConfigViewController.eDataRealmConfigPath, true, true));
			for (EDataRealmConfigModel tempModel : realmConfig.getItem()) {
				if ("MASTER_CONFIGURATIONS".equals(tempModel.getName())) {
					file = new File(tempModel.getItem().get(0).getValue().replace("%appdata%", System.getenv("appdata")));
					if (file.exists()) {
						viewAllModels.add(new ExportCommonViewModel("SEMI","semimaster", file.getPath(), true, true));
					} else {
						viewAllModels.add(new ExportCommonViewModel("SEMI","semimaster", file.getPath(), false, false));
					}
					continue;
				}

				else if ("DFS".equals(tempModel.getName())) {
					for (EDataRealmConfigModel temp : tempModel.getItem()) {
						if ("DATA_CRAWLER".equals(temp.getName())) {
							if (temp.getItem().size() > 0)
								for (EDataRealmConfigModel crawler : temp.getItem()) {
									String name = crawler.getName();
									file = new File(crawler.getItem().get(0).getValue().replace("%appdata%",System.getenv("appdata")));
									if (file.exists()) {
										viewAllModels.add(new ExportCommonViewModel("Crawler", name, file.getPath(), true, true));
									} else {
										viewAllModels.add(new ExportCommonViewModel("Crawler",name, file.getPath(), false, false));
									}
								}
						} else if ("DATA_GATHERER".equals(temp.getName())) {
							if (temp.getItem().size() > 0)
								for (EDataRealmConfigModel gatherer : temp.getItem()) {
									String name = gatherer.getName();
									if(!name.equals("CSV") && !name.equals("KLARF") && !name.equals("STDF") && !name.equals("IM")
											&& !name.equals("YMA_1_0") && !name.equals("YMA_1_1")) {
										file = new File(gatherer.getItem().get(0).getValue().replace("%appdata%", System.getenv("appdata")));
										if (file.exists()) {
											viewAllModels.add(new ExportCommonViewModel("Gatherer", name, file.getPath(), true, true));
										} else {
											viewAllModels.add(new ExportCommonViewModel("Gatherer", name, file.getPath(), false, false));
										}
									}
								}
						}
					} 
					continue;
				} else if ("DBINFO".equals(tempModel.getName())) {
					if (tempModel.getItem().size() > 0)
					for (EDataRealmConfigModel dbInfo : tempModel.getItem()) {
						String name = dbInfo.getName();
						file = new File(dbInfo.getItem().get(0).getValue().replace("%appdata%", System.getenv("appdata")));
						if (file.exists()) {
							viewAllModels.add(new ExportCommonViewModel("DBInfo", name, file.getPath(), true, true));
						} else {
							viewAllModels.add(new ExportCommonViewModel("DBInfo", name, file.getPath(), false, false));
						}
					}
				}			
			}
			eDLConfigFileTableView.setItems(viewAllModels);
		}
	}
	
	@FXML
	private void handle_Cancel() {
		dialogStage.close();
	}


	@FXML
	private void handle_eDLConfig_browser() {
		fileChooser.setInitialDirectory(new File(new File(eDataRealmConfigPathTextField.getText()).getAbsoluteFile().getParent()));
		file = new File(fileChooser.showOpenDialog(null).getPath());	
		if(file.exists()) {
			viewAllModels.clear();
			setInitData(file.getPath());
		}
		
	}

//	private void setDFSImportAllInfoModel(DFSGeneratorImportWholeInfo dfsImportAllInfo) {
//		this.dfsImportAllInfo = dfsImportAllInfo;
//	}
	
	private DFSGeneratorImportWholeInfo getDFSImportAllInfoModel() {
		return dfsImportAllInfo;
	}
	
	@FXML
	private void handle_Import_execute() {
		dfsXMLALLInfo.setMarkInitData(false);
		dfsXMLALLInfo.setExitSaveFile(false);
		dfsXMLALLInfo.setAllDone(true);
		dfsXMLALLInfo.setCreateXMLFile(false);
		dfsXMLALLInfo.setCreateEDLConfig(false);
		dfsXMLALLInfo.setCreateMode(false);
		dfsXMLALLInfo.setEDataRealmFileName(eDataRealmConfigPathTextField.getText());
		dfsXMLALLInfo.setSEMIFileName(viewAllModels.get(1).getProperty());
		setInitDFSDataInstance();
		
		ObservableList<ExportCommonViewModel> viewAllModelsClone = FXCollections.observableArrayList();
		ObservableList<DFSDefineDatatagImportListModel> dataTagListModel = FXCollections.observableArrayList();
		ObservableList<DFSGeneratorAndDatabaseListModel> databaseSourceModelList = FXCollections.observableArrayList();
		
		for(ExportCommonViewModel tempModel : viewAllModels) {
			if(tempModel.getCheck() && tempModel.getDone())
				try {
					viewAllModelsClone.add(tempModel.clone());
				} catch (CloneNotSupportedException e) {
					e.printStackTrace();
				}
		}
		
		List<String> databaseSourceNameList = new ArrayList<>();
		
		for(ExportCommonViewModel tempModel : viewAllModelsClone) {
			if("Crawler".equals(tempModel.getMode())) {
				databaseSourceNameList.add(tempModel.getDatabaseSource());
				crawlerModels.add(dfsImportCtl.crawlGathererConfigImport(tempModel.getProperty()));
				continue;
			} else if("Gatherer".equals(tempModel.getMode())) {
				databaseSourceNameList.add(tempModel.getDatabaseSource());
				gathererModels.add(dfsImportCtl.crawlGathererConfigImport(tempModel.getProperty()));
				continue;
			}
		}
		
		crawlerMergeModels = convertDFSGDataModel(crawlerModels, gathererModels);
		semimaster = dfsImportCtl.semimasterImport(viewAllModelsClone.get(1).getProperty());
		ObservableList<String> sortList = semiDataController.createImportSemiMasterSortList(semimaster);
		SemiMasterItemInitData = semiDataController.createImportSemiMasterAttributeInitData(crawlerMergeModels);

		databaseSourceNameList = databaseSourceNameList.stream().distinct().collect(Collectors.toList());
				
		if(databaseSourceNameList.size()>0) {
			String table_format = DefineAtrribute.TABLE_FORMAT.get(1);
			String table_name = null;
			for(String dataSourceName : databaseSourceNameList) {
				for (int i=0; i<semimaster.getDatatag().size(); i++) {
					DFSSemiDatatagImportModel temp = semimaster.getDatatag().get(i);
					if (dataSourceName.equals(temp.getDatasource())) {
						for(DFSCrawlGathererWrapperExportModel tempMerge : crawlerMergeModels) {
							if(dataSourceName.equals(tempMerge.getName())){
								for(DFSDatatagExportModel tempDatatag : tempMerge.getdfsdatatags()) {
									if(temp.getName().equals(tempDatatag.getData_tag_name())) {
										//TODO
										for(DFSMethodExportModel methodModel : tempDatatag.getDFSMethod()) {
											for(DFSVariableModel variableModel : methodModel.getDFSVariables().getDFSVariableList()) {
												for(DFSItemModel tempItem : temp.getItems()) {
													if(tempItem.getName().equals(variableModel.getdfs_variable_name())) {
														variableModel.setContentBoolean(convertOptional(tempItem.getOptional()));
													}
												}
											}
										}								
										table_name = tempDatatag.getDFSMethod().get(2).getDFSTables().getDFSTableList().get(0).getName();
										
										int checkPivot = 0;
										ObservableList<DFSVariableModel> tempOptionModel = FXCollections.observableArrayList();
										for(DFSVariableModel tempVari : tempDatatag.getDFSMethod().get(2).getDFSVariables().getDFSVariableList()) {
											if("PARAMETER_NAME".equals(tempVari.getdfs_variable_name())) {
												tempOptionModel.add(tempVari);
												checkPivot++;
												continue;
											} else if ("VARIABLE_TYPE".equals(tempVari.getdfs_variable_name())) {
												tempOptionModel.add(tempVari);
												checkPivot++;
												continue;
											} else if ("PARAMETER_VALUE".equals(tempVari.getdfs_variable_name())) {
												tempOptionModel.add(tempVari);
												checkPivot++;
												break;
											}		
										}
										if(checkPivot==3) {
											for(DFSVariableModel checkOptionModel : tempOptionModel) 
												checkOptionModel.setContentBoolean(true);
											table_format = DefineAtrribute.TABLE_FORMAT.get(0);
										}
										break;
									}
								}
								break;
							}
						}
						DFSDefineTableAllData.add(new DFSDefineTableModel(table_format, temp.getDatasource(), temp.getName(),temp.getAlias()
								, table_name, temp.getType(), temp.getLevel(), null, null, null, null, true));
						dataTagListModel.add(new DFSDefineDatatagImportListModel(temp.getType(), temp.getLevel()));
						for(DFSItemModel tempLevel : temp.getItems()) {
							dataTagListModel.get(i).getVariableList().add(tempLevel.getName());
							for(DFSVariableItemModel semiTemp : SemiMasterItemInitData){
								if(semiTemp.getName().equals(tempLevel.getName())) {
									semiTemp.setNotOptional(convOptional(tempLevel.getOptional()));
									semiTemp.setAlias(tempLevel.getAlias());
									semiTemp.setDescription(tempLevel.getDescription());
								}	
							}
						}		
					}
				}		
			}
		}
		dataTagListModel = dataTagListModelDistinct(dataTagListModel);
		ObservableList<DFSDefineDatatagInitItemModel> DatatagListInitData = createImportSemiMasterDatatagListInitData(dataTagListModel);
		
		
		semiMasterInitData = new DFSDefineInitModel(sortList, SemiMasterItemInitData, DatatagListInitData);
		dfsdatatags = FXCollections.observableArrayList();
		
		for(String dataSourceName : databaseSourceNameList) {
			dfsdatatags = FXCollections.observableArrayList();
			DFSDefineTableData = FXCollections.observableArrayList();
			DFSGeneratorXMLInfoModel xmlInfoMedel = new DFSGeneratorXMLInfoModel();
			xmlInfoMedel.setDatabaseName(dataSourceName);
			for(ExportCommonViewModel tempModel : viewAllModelsClone) {
				if("Crawler".equals(tempModel.getMode()) && dataSourceName.equalsIgnoreCase(tempModel.getDatabaseSource())) {
					xmlInfoMedel.setCrawlerFileName(tempModel.getProperty());
					continue;
				} else if("Gatherer".equals(tempModel.getMode()) && dataSourceName.equalsIgnoreCase(tempModel.getDatabaseSource())) {
					xmlInfoMedel.setGathererFileName(tempModel.getProperty());
					continue;
				} 
			}
			
			for(ExportCommonViewModel tempModel : viewAllModelsClone) {
				if(dataSourceName.equals(tempModel.getDatabaseSource())&& "DBInfo".equals(tempModel.getMode())) {
					dfsDatabaseConnectionModel = getDBInfo(tempModel);
					xmlInfoMedel.setMode("import");
					xmlInfoMedel.setDatabaseInfoFileName(dfsDatabaseConnectionModel.getDBInfoPath());
					xmlInfoMedel.setEDLDatabaseType(dfsDatabaseConnectionModel.getDatabaseType());
					xmlInfoMedel.setUserID(dfsDatabaseConnectionModel.getUserID());
					xmlInfoMedel.setHostName(dfsDatabaseConnectionModel.getHostName());
					xmlInfoMedel.setPort(dfsDatabaseConnectionModel.getPort());
					xmlInfoMedel.setSid(dfsDatabaseConnectionModel.getDbi());
					break;
				}
			}
			for(DFSDefineTableModel tempModel : DFSDefineTableAllData) {
				if(dataSourceName.equals(tempModel.getDBsource()))
					DFSDefineTableData.add(tempModel);
			}
			for(DFSCrawlGathererWrapperExportModel tempModel : crawlerMergeModels){
				if(dataSourceName.equals(tempModel.getName())) {
					dfsdatatags = tempModel.getdfsdatatags();
					break;
				}
			}
			

			dfsXMLALLInfo.getDfsGeneratorXMLInfoModel().add(xmlInfoMedel);
			DFSGeneratorMainViewController dfsGeneratorMainController = new DFSGeneratorMainViewController();
			dfsGeneratorMainController.createDFSGeneratorMainView(dataSourceName, null, DFSDefineTableData, dfsdatatags);
			databaseSourceModelList.add(new DFSGeneratorAndDatabaseListModel(true,
					false, dfsDatabaseConnectionModel, dfsGeneratorMainController));
			
			
		}
		
		dfsImportAllInfo = new DFSGeneratorImportWholeInfo(dfsXMLALLInfo, semiMasterInitData, databaseSourceModelList);
		importXMLFile = true;
		dialogStage.close();
	}
	
	private boolean convertOptional(String checkValue) {
		boolean result = true;
			if(checkValue.equals("Y"))
				result = false;
		return result;
	}
	
	private ObservableList<DFSCrawlGathererWrapperExportModel> convertDFSGDataModel(ObservableList<DFSCrawlGathererWrapperImportModel> crawlerModels, ObservableList<DFSCrawlGathererWrapperImportModel> gathererModels) {

		DFSDatatagExportModel tagModel;
		DFSMethodExportModel methodModel;
		DFSTablesExportModel tableModel;
		DFSPartitionsExportModel partitionModel;
		DFSVariablesExportModel variableModel;
		DFSTableModel table;
		DFSPartitionModel parition;
		
		for (DFSCrawlGathererWrapperImportModel tempCrawler : crawlerModels) {
			allDFSdataTags = new DFSCrawlGathererWrapperExportModel();
			allDFSdataTags.setName(tempCrawler.getName());
			dfsdatatags = FXCollections.observableArrayList();
			try {
				for(DFSDatatagImportModel tempTag : tempCrawler.getDFSdatatags()) { //tag
					tagModel = new DFSDatatagExportModel();
					for(DFSMethodImportModel tempMethod : tempTag.getDFSMethod()) { // method
						methodModel = new DFSMethodExportModel();
						tableModel = new DFSTablesExportModel();
						tableModel.setName(tempMethod.getDFSTables().getName());
						for(DFSTableModel tempTable : tempMethod.getDFSTables().getDFSTableList()) {	
							table = tempTable.clone();
							tableModel.getDFSTableList().add(table);
						}
						partitionModel = new DFSPartitionsExportModel();
						partitionModel.setName(tempMethod.getDFSPartitions().getName());
						if(tempMethod.getDFSPartitions().getDFSPartitionList() != null) {
							for(DFSPartitionModel tempParition : tempMethod.getDFSPartitions().getDFSPartitionList()) {				
								parition = tempParition.clone();
								partitionModel.getDFSPartitionList().add(parition);
							}
						}
						variableModel = new DFSVariablesExportModel();
						variableModel.setName(tempMethod.getDFSVariables().getName());
						if(!"METADATA".equals(tempMethod.getName())) 
							for(DFSVariableImportModel tempVariable : tempMethod.getDFSVariables().getDFSVariableList()) {
								variableModel.getDFSVariableList().add(new DFSVariableModel(false
										, tempVariable.getDfs_variable_name(), tempVariable.getColumn_name()
										, tempVariable.getTable_name(), tempVariable.getVariable_type()
										, tempVariable.getVariable_group(), tempVariable.getRole()
										, tempVariable.getPivot(), tempVariable.getSummarization()
										, tempVariable.getGroupby(), tempVariable.getExclude_condition()
										, tempVariable.getTotime_javaformat(), tempVariable.getTotime()
										, tempVariable.getTimetochar(), tempVariable.getNumbertochar()));		
							}
						else 
							for(DFSCrawlGathererWrapperImportModel tempgatherer : gathererModels) {
								if(tempCrawler.getName().equals(tempgatherer.getName())) {
									for(DFSDatatagImportModel tempgathererTag : tempgatherer.getDFSdatatags()) {
										if(tempTag.getData_tag_name().equals(tempgathererTag.getData_tag_name())) {
											for(DFSVariableImportModel tempVariable : tempgathererTag.getDFSMethod().get(0).getDFSVariables().getDFSVariableList()) {
												variableModel.getDFSVariableList().add(new DFSVariableModel(false
														, tempVariable.getDfs_variable_name(), tempVariable.getColumn_name()
														, tempVariable.getTable_name(), tempVariable.getVariable_type()
														, tempVariable.getVariable_group(), tempVariable.getRole()
														, tempVariable.getPivot(), tempVariable.getSummarization()
														, tempVariable.getGroupby(), tempVariable.getExclude_condition()
														, tempVariable.getTotime_javaformat(), tempVariable.getTotime()
														, tempVariable.getTimetochar(), tempVariable.getNumbertochar()));					
											}
											break;
										}
									}
									break;
								}
							}
						for(DFSVariableModel temp : variableModel.getDFSVariableList())
						methodModel.setName(tempMethod.getName());
						methodModel.setHint(tempMethod.getHint());
						methodModel.setTemptable(tempMethod.getTemptable());
						methodModel.setTemptable_keycolumn(tempMethod.getTemptable_keycolumn());
						methodModel.setDFSTables(tableModel);
						methodModel.setDFSPartitions(partitionModel);
						methodModel.setDFSVariables(variableModel);	
						tagModel.getDFSMethod().add(methodModel);
					}
					tagModel.setData_tag_name(tempTag.getData_tag_name());
					dfsdatatags.add(tagModel);
				} 			
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
			allDFSdataTags.setDFSDatatags(dfsdatatags);
			crawlerMergeModels.add(allDFSdataTags);
		}
	
		return crawlerMergeModels;
	}
	
	private ObservableList<DFSDefineDatatagInitItemModel> createImportSemiMasterDatatagListInitData(ObservableList<DFSDefineDatatagImportListModel> dataTagListModel) {
		
		ObservableList<DFSDefineDatatagInitItemModel> DatatagListInitData = FXCollections.observableArrayList();
		for(DFSDefineDatatagImportListModel tempModel : dataTagListModel) 
			DatatagListInitData.add(new DFSDefineDatatagInitItemModel(tempModel.getType(),tempModel.getLevel(),createVariableSet(tempModel.getVariableList())));

		return DatatagListInitData;
	}
	
	private ObservableList<DFSVariableItemModel> createVariableSet(List<String> variableList) {	
		ObservableList<DFSVariableItemModel> l_variable = FXCollections.observableArrayList();
		Iterator<String> itr = variableList.iterator();	
		while(itr.hasNext()) {
			String variableName = itr.next().toString();
			for(int i=0 ; i<SemiMasterItemInitData.size(); i++) {
				if(SemiMasterItemInitData.get(i).getName().equals(variableName))
					try {
						l_variable.add(SemiMasterItemInitData.get(i).clone());
					} catch (CloneNotSupportedException e) {
						e.printStackTrace();
					}
			}
		}
		return l_variable;
	}
	
	
	private ObservableList<DFSDefineDatatagImportListModel> dataTagListModelDistinct(ObservableList<DFSDefineDatatagImportListModel> dataTagListModel) {
		
		int initSize=dataTagListModel.size();
		
		for(int i=0; i<initSize; i++) {
			for(int j=i+1; j<initSize; j++) {
				if((dataTagListModel.get(i).getType()+dataTagListModel.get(i).getLevel()).equals(dataTagListModel.get(j).getType()+dataTagListModel.get(j).getLevel())){
					for(String nameList : dataTagListModel.get(j).getVariableList()) {
						dataTagListModel.get(i).getVariableList().add(nameList);
					}
					dataTagListModel.get(i).setVariableList(dataTagListModel.get(i).getVariableList().stream().distinct().collect(Collectors.toList()));
					dataTagListModel.remove(j);
					initSize--;
					j--;
				}
			}
		}
		
		return dataTagListModel;
	}
	
	
	private Boolean convOptional(String opt) {
		boolean result;
		if("Y".equals(opt))
			result = false;
		else 
			result = true;
		return result;
	}
	
	private DFSDatabaseConnectionModel getDBInfo(ExportCommonViewModel tempModel) {
		file = new File(tempModel.getProperty().replace("%appdata%", System.getenv("appdata")));
		DFSGeneratorXMLImportController dbConfigController = new DFSGeneratorXMLImportController();
		DBInfoConfigModel dbConfig = dbConfigController.dbInfoConfigImport(file.getPath());
		DFSDatabaseConnectionModel tempDBConnectionModel = new DFSDatabaseConnectionModel();
		tempDBConnectionModel.setDatasourceName(tempModel.getDatabaseSource());
		String dbInfoString = null;
		for (DBInfoConfigModel info : dbConfig.getItem()) {
			if ("URL".equals(info.getName())) {
				tempDBConnectionModel.setDBInfoPath(file.getPath());
				dbInfoString = info.getValue();
				String dbInfo[] = dbInfoString.split(":");
				tempDBConnectionModel.setStatus("N");
				tempDBConnectionModel.setDatabaseType(dbInfo[1].substring(0, 1).toUpperCase() + dbInfo[1].substring(1).toLowerCase());
				tempDBConnectionModel.setHostName(dbInfo[3].replace("@", ""));
				tempDBConnectionModel.setPort(dbInfo[4]);
				tempDBConnectionModel.setDbi(dbInfo[5]);
			} else if ("USER_NAME".equals(info.getName())) {
				tempDBConnectionModel.setUserID(info.getValue());
				break;
			}
			
		}
		
		return tempDBConnectionModel;
	}

	public DFSGeneratorImportWholeInfo showImportXMLDialog() {
	
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MeerkatMainApp.class.getResource("view/DFSGenerator/xml/DFSGeneratorXMLImportView.fxml"));
			
			TitledPane page = (TitledPane) loader.load();

			Stage dialogStage = new Stage();
			dialogStage.setTitle("Import eDataLyzer Config XML File");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(MeerkatMainApp.primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			DFSGeneratorXMLImportViewController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setInitData(RootGeneralConfigViewController.eDataRealmConfigPath);
			dialogStage.showAndWait();		
			
			if (importXMLFile == true)
				return controller.getDFSImportAllInfoModel();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
}
