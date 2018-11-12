package com.digilog.meerkat.DFSGeneratorController.semimaster;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.LinkedHashMap;

import com.digilog.meerkat.DFSGeneratorController.XMLController.Import.DFSGeneratorXMLImportController;
import com.digilog.meerkat.DFSGeneratorController.XMLController.Import.DFSGeneratorXMLSemimasterController;
import com.digilog.meerkat.attribute.DefineAtrribute;
import com.digilog.meerkat.model.dfsGenerator.DFSDefineTableModel;
import com.digilog.meerkat.model.dfsGenerator.crawler.DFSVariableModel;
import com.digilog.meerkat.model.dfsGenerator.crawler.export.DFSDatatagExportModel;
import com.digilog.meerkat.model.dfsGenerator.semimaster.DFSItemModel;
import com.digilog.meerkat.model.dfsGenerator.semimaster.DFSVariableItemModel;
import com.digilog.meerkat.model.dfsGenerator.semimaster.Import.DFSSemimasterWrapperImportModel;
import com.digilog.meerkat.model.dfsGenerator.semimaster.export.DFSAttributeModel;
import com.digilog.meerkat.model.dfsGenerator.semimaster.export.DFSContextModel;
import com.digilog.meerkat.model.dfsGenerator.semimaster.export.DFSDescriptorExportModel;
import com.digilog.meerkat.model.dfsGenerator.semimaster.export.DFSSemiDatatagExportModel;
import com.digilog.meerkat.model.dfsGenerator.semimaster.export.DFSSemimasterWrapperExportModel;
import com.digilog.meerkat.model.dfsGenerator.xml.DFSGeneratorXMLAllInfoModel;
import com.digilog.meerkat.util.ArrayListToObservableList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DFSSemimasterController {
	private DFSSemimasterWrapperExportModel eDataRealm;
	private DFSContextModel context;
	private DFSAttributeModel attribute; 
	private DFSDescriptorExportModel descriptor;
	private ObservableList<DFSSemimasterWrapperExportModel>  mergeSemimasterModels;
	private ObservableList<DFSDefineTableModel> DFSDefineTableData;
	private ObservableList<DFSSemiDatatagExportModel> dfsSemiDatatags;
	private ObservableList<DFSVariableItemModel> SemiMappingInitData;
	
//	private DFSGeneratorXMLSemimasterController dfsGeneratorSemimasterImportController;
	private DFSGeneratorXMLImportController dfsGeneratorXMLImportController;
	private ArrayListToObservableList ato;
	
	public DFSSemimasterController(){
//		dfsGeneratorSemimasterImportController = new DFSGeneratorXMLSemimasterController();
		dfsGeneratorXMLImportController = new DFSGeneratorXMLImportController();
//		eDataRealm = new DFSSemimasterWrapperExportModel();
		ato = new ArrayListToObservableList();
		SemiMappingInitData = FXCollections.observableArrayList();
		context = new DFSContextModel();
		attribute = new DFSAttributeModel();
		descriptor = new DFSDescriptorExportModel();
		DFSDefineTableData = FXCollections.observableArrayList();
		dfsSemiDatatags = FXCollections.observableArrayList();
		
	}
	
	public DFSSemimasterWrapperExportModel createXMLMergeSemimaster(DFSGeneratorXMLAllInfoModel dfsCreateXMLAllInfo, ObservableList<DFSSemimasterWrapperExportModel> semiModels) {
		
		eDataRealm = new DFSSemimasterWrapperExportModel();
		String currentSemiConfigFileName = dfsCreateXMLAllInfo.getSEMIFileName();
		DFSSemimasterWrapperImportModel semimasterCurrenttVer = dfsGeneratorXMLImportController.semimasterImport(currentSemiConfigFileName);	
		
		if(semimasterCurrenttVer != null) {
//			if(!dfsCreateXMLAllInfo.isCreateMode()) {		
//				mergeSemimasterModels = FXCollections.observableArrayList();
//				DFSSemimasterWrapperExportModel tempSemimaster = new DFSSemimasterWrapperExportModel();
//				tempSemimaster = ato.semiConverter(semimasterCurrenttVer);
//				mergeSemimasterModels.add(tempSemimaster);
//				if(semiModels != null)
//					for(DFSSemimasterWrapperExportModel tempModel : semiModels)
//						mergeSemimasterModels.add(tempModel);				
//				semiModels = mergeSemimasterModels;
//			}
				
			BigDecimal currentgVer = new BigDecimal(semimasterCurrenttVer.getVersion());
			BigDecimal newVer = new BigDecimal("0.1");
			eDataRealm.setVersion(currentgVer.add(newVer).toString());
		} else 
			eDataRealm.setVersion("1.0");
		
		createModel(semiModels);
		eDataRealm.setContext(context);
		eDataRealm.setAttribute(attribute);
		eDataRealm.setDescriptor(descriptor);

		return eDataRealm;
	} 
	
	public DFSSemimasterWrapperExportModel createXMLSemimaster(String databaseName, ObservableList<DFSDefineTableModel> DFSDefineTableData, 
			ObservableList<DFSDatatagExportModel> dfsdatatags, ObservableList<DFSVariableItemModel> SemiMappingInitData) {
		
		this.SemiMappingInitData = SemiMappingInitData;
		this.DFSDefineTableData = DFSDefineTableData;
		eDataRealm = new DFSSemimasterWrapperExportModel();
		
		eDataRealm.setVersion("");
		createModel(databaseName , dfsdatatags);
		eDataRealm.setContext(context);
		eDataRealm.setAttribute(attribute);
		eDataRealm.setDescriptor(descriptor);
		eDataRealm.setDatatag(dfsSemiDatatags);
		return eDataRealm;
	}
	
	public void createModel(ObservableList<DFSSemimasterWrapperExportModel> semiModels) {	
		
		int loop = 0;
		LinkedHashMap<String, DFSItemModel> hashContextData = new LinkedHashMap<>();
		LinkedHashMap<String, DFSItemModel> hashAtrributeData = new LinkedHashMap<>();
		LinkedHashMap<String, DFSItemModel> hashDescriptorData = new LinkedHashMap<>();
		
		for(DFSSemimasterWrapperExportModel tempModel : semiModels) {

			for(DFSItemModel tempItem : tempModel.getContext().getDFSItemList())
				hashContextData.put(tempItem.getName(),tempItem );
			
			for(DFSItemModel tempItem : tempModel.getAttribute().getDFSItemList()) {
				hashAtrributeData.put(tempItem.getName(),tempItem );
			}
			for(DFSItemModel tempItem : tempModel.getDescriptor().getDFSItemList())
				hashDescriptorData.put(tempItem.getName(),tempItem );
			
			if(loop == 0) {
				eDataRealm.setDatatag(tempModel.getDatatag());
				loop++;
			}
			else 
				eDataRealm.getDatatag().addAll(tempModel.getDatatag());
		}
		
		context.setDFSItemList(setMergeItems(hashContextData));
		attribute.setDFSItemList(setMergeItems(hashAtrributeData));			
		descriptor.setDFSItemList(setMergeItems(hashDescriptorData));	
		
	}
	
public ObservableList<DFSItemModel> setMergeItems(LinkedHashMap<String, DFSItemModel> hashData) {
		
		ObservableList<DFSItemModel> items = FXCollections.observableArrayList();
		Iterator<String> itr = hashData.keySet().iterator();
		int seq=0;
		
		while(itr.hasNext())
		{
			DFSItemModel item = new DFSItemModel();
			String key = itr.next().toString();
			String name = hashData.get(key).getName();
			String alias = hashData.get(key).getAlias();
			item.setSeq(seq);
			item.setName(name);
			item.setAlias(alias);
			item.setVariable_type(hashData.get(key).getVariable_type());
			items.add(item);
			seq++;	
		}
		
		return items;
		
	}
	
	public void createModel(String databaseName, ObservableList<DFSDatatagExportModel> dfsdatatags) {	
		
		DFSVariableModel dfsVariable = new DFSVariableModel();
		LinkedHashMap<String, DFSVariableModel> hashContextData = new LinkedHashMap<>();
		LinkedHashMap<String, DFSVariableModel> hashAtrributeData = new LinkedHashMap<>();
		LinkedHashMap<String, DFSVariableModel> hashDescriptorData = new LinkedHashMap<>();
		
		for(int i=0; i<dfsdatatags.size(); i++) 
		{
						
			LinkedHashMap<String, DFSVariableModel> hashDatatagData = new LinkedHashMap<>();
			LinkedHashMap<String, DFSVariableModel> hashTempContextData = new LinkedHashMap<>();
			LinkedHashMap<String, DFSVariableModel> hashTempAtrributeData = new LinkedHashMap<>();
			LinkedHashMap<String, DFSVariableModel> hashTempDescriptorData = new LinkedHashMap<>();
			
			int j=0;
			
			for(int s=0; s<dfsdatatags.get(i).getDFSMethod().size(); s++)
			{
				if (s == 0)
					j = 1;
				if (s == 1)
					j = 0;
				if (s == 2)
					j =2;
				
				for(int k=0; k<dfsdatatags.get(i).getDFSMethod().get(j).getDFSVariables().getDFSVariableList().size(); k++)
				{	
					String groupName = dfsdatatags.get(i).getDFSMethod().get(j).getDFSVariables().getDFSVariableList().get(k).getVariable_group();
					String roleName = dfsdatatags.get(i).getDFSMethod().get(j).getDFSVariables().getDFSVariableList().get(k).getRole();
					
					switch (groupName) {
					case "CONTEXT":
						dfsVariable = dfsdatatags.get(i).getDFSMethod().get(j).getDFSVariables().getDFSVariableList().get(k);
						hashTempContextData.put(dfsVariable.getdfs_variable_name(), dfsVariable);
						break;
						
					case "ATTRIBUTE":
						dfsVariable = dfsdatatags.get(i).getDFSMethod().get(j).getDFSVariables().getDFSVariableList().get(k);
						hashTempAtrributeData.put(dfsVariable.getdfs_variable_name(), dfsVariable);
						if(roleName.equals("DESCRIPTOR"))
						{
							dfsVariable = dfsdatatags.get(i).getDFSMethod().get(j).getDFSVariables().getDFSVariableList().get(k);
							hashTempDescriptorData.put(dfsVariable.getdfs_variable_name(), dfsVariable);
						}
						break;
							
					default:
						break;
					}	
				}
				hashContextData.putAll(hashTempContextData);
				hashAtrributeData.putAll(hashTempAtrributeData);
				hashDescriptorData.putAll(hashTempDescriptorData);
				
				hashDatatagData.putAll(hashTempContextData);
				hashDatatagData.putAll(hashTempAtrributeData);
			}
			
			DFSSemiDatatagExportModel tempSemiDatatag = new DFSSemiDatatagExportModel();
			DFSDefineTableModel tempDefineTable = new DFSDefineTableModel();
			String datatagName = dfsdatatags.get(i).getData_tag_name();
			
			for(int m=0; m<DFSDefineTableData.size(); m++)
				if(datatagName.equals(DFSDefineTableData.get(m).getData_tag_name()))
					tempDefineTable = DFSDefineTableData.get(m);
			
			String enabled =  DefineAtrribute.ENABLED.get(0);
			String datatag_alias = tempDefineTable.getAlias_name();
			String type = tempDefineTable.getType();
			String level = tempDefineTable.getLevel();
			String datasource = databaseName;
			String dfs_query_by = DefineAtrribute.DFS_QUERY_BY.get(0);
			String sort_by_attributekey = DefineAtrribute.SORT_BY_ATTRIBUTEKEY.get(1);
			String desc = DefineAtrribute.DESC.get(0);
			
			tempSemiDatatag.setEnabled(enabled);
			tempSemiDatatag.setName(datatagName);
			tempSemiDatatag.setAlias(datatag_alias);
			tempSemiDatatag.setType(type);
			tempSemiDatatag.setLevel(level);
			tempSemiDatatag.setDatasource(datasource);
			tempSemiDatatag.setDfs_query_by(dfs_query_by);
			tempSemiDatatag.setSort_by_attributekey(sort_by_attributekey);
			tempSemiDatatag.setDesc(desc);
			
			tempSemiDatatag.setItems(setDatatagItems(hashDatatagData));	
			
			dfsSemiDatatags.add(tempSemiDatatag);

		}
		context.setDFSItemList(setItems(hashContextData));
		attribute.setDFSItemList(setItems(hashAtrributeData));			
		descriptor.setDFSItemList(setItems(hashDescriptorData));	
	}
	
	public ObservableList<DFSItemModel> setItems(LinkedHashMap<String, DFSVariableModel> hashData) {
		
		ObservableList<DFSItemModel> items = FXCollections.observableArrayList();
		Iterator<String> itr = hashData.keySet().iterator();
		int seq=0;
		
		while(itr.hasNext())
		{
			DFSItemModel item = new DFSItemModel();
			String key = itr.next().toString();
			String name = hashData.get(key).getdfs_variable_name();
			String alias = mappingAliasName(name);	
			item.setSeq(seq);
			item.setName(name);
			item.setAlias(alias);
			item.setVariable_type(hashData.get(key).getVariable_type());
			items.add(item);
			seq++;	
		}
		
		return items;
		
	}
	
	public ObservableList<DFSItemModel> setDatatagItems(LinkedHashMap<String, DFSVariableModel> hashData) {
		
		ObservableList<DFSItemModel> items = FXCollections.observableArrayList();
		Iterator<String> itr = hashData.keySet().iterator();
		int seq=0;
		
		while(itr.hasNext())
		{
			DFSItemModel item = new DFSItemModel();
			String key = itr.next().toString();
			String name = hashData.get(key).getdfs_variable_name();
			String alias = mappingAliasName(name);
			String variable_group = hashData.get(key).getVariable_group();
			boolean notOptional = mappingOptional(name);
			String role = hashData.get(key).getRole();
			String description = DefineAtrribute.DESCRIPTION.get(0);

			item.setSeq(seq);
			item.setName(name);
			item.setAlias(alias);
			item.setVariable_group(variable_group);
			if(notOptional==true)
				item.setOptional("N");
			else
				item.setOptional("Y");
			item.setRole(role);
			item.setDescription(description);
			items.add(item);
			seq++;	
		}
		
		return items;
		
	}
	
	public String mappingAliasName(String name) {
		for(int i=0; i<SemiMappingInitData.size(); i++)
			if(SemiMappingInitData.get(i).getName().equals(name))
				return SemiMappingInitData.get(i).getAlias();
		return null;
	}
	
	public boolean mappingOptional(String name) {
		for(int i=0; i<SemiMappingInitData.size(); i++)
			if(SemiMappingInitData.get(i).getName().equals(name))
				return SemiMappingInitData.get(i).getNotOptional();
		return true;
	}
	
	
}
