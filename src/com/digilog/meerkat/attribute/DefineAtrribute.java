package com.digilog.meerkat.attribute;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public interface DefineAtrribute {
	// DATABASE_GRUOP
	ObservableList<String> DATABASE_GROUP = FXCollections.observableArrayList("Oracle", "PostgreSQL", "MySQL","MariaDB" );
	ObservableList<String> eDL_DATABASE_GROUP = FXCollections.observableArrayList("Oracle", "PostgreSQL","MySQL","MariaDB" );
	ObservableList<String> GENERATOR_GROUP = FXCollections.observableArrayList("ALL");
	
	// DFSMappingDefineValue Reset
	ObservableList<String> RUN_GROUP = FXCollections.observableArrayList("Get Parameters", "Reset ALL", "Reset SemiMaster", "Reset Parameters","Auto Mapping");
	
	// semimaster
	ObservableList<String> ENABLED = FXCollections.observableArrayList("Y","N");
	ObservableList<String> DFS_QUERY_BY = FXCollections.observableArrayList("ALL_CONTEXT");
	ObservableList<String> SORT_BY_ATTRIBUTEKEY = FXCollections.observableArrayList("Y","N");
	ObservableList<String> DESC = FXCollections.observableArrayList("");
	ObservableList<String> OPTIONAL = FXCollections.observableArrayList("Y","N");
	ObservableList<String> DESCRIPTION = FXCollections.observableArrayList("");
	ObservableList<String> SEMI_VARIABLE_GROUP_TYPE = FXCollections.observableArrayList("CONTEXT", "ATTRIBUTE");
	
	// DFSMappingDefineValue 
	ObservableList<String> TABLE_FORMAT = FXCollections.observableArrayList("UNPIVOT", "PIVOT");
	ObservableList<String> INTERNAL_LIST = FXCollections.observableArrayList("NEXTATTRIBUTE_LIST", "DEFAULT_LIST","PARAMETER_LIST");
	ObservableList<String> DFS_METHOD = FXCollections.observableArrayList("NEXTATTRIBUTE", "CONTEXTLIST", "METADATA");
	ObservableList<String> TYPE = FXCollections.observableArrayList("PROCESS", "TRACKING", "SORT", "METROLOGY", "DEFECT", "ETEST", "RECIPE");
	ObservableList<String> LVEL_TYPE = FXCollections.observableArrayList("LOT", "WAFER", "MAP", "TRACE");
	ObservableList<String> VARIABLE_TYPE = FXCollections.observableArrayList("CAT", "CONT","TIME");
	ObservableList<String> VARIABLE_GROUP_TYPE = FXCollections.observableArrayList("CONTEXT", "ATTRIBUTE", "PARAMETER");
	ObservableList<String> ROLE_TYPE = FXCollections.observableArrayList("KEY", "DESCRIPTOR", "PARAMETER");
	ObservableList<String> PIVOT_TYPE = FXCollections.observableArrayList("TRUE", "FALSE");
	ObservableList<String> GROUPBY_TYPE = FXCollections.observableArrayList("TRUE", "FALSE");
	ObservableList<String> TIME_FORMAT = FXCollections.observableArrayList("TOTIME_JAVAFORMAT", "TOTIME","TIMETOCHAR","NUMBERTOCHAR");
	ObservableList<String> UNPIVOT_VARIABLE_NAME = FXCollections.observableArrayList("PARAMETER_NAME", "VARIABLE_TYPE","PARAMETER_VALUE");

	// Message Dialog
	String M_INFO = "INFO";
	String M_WARNING = "WARNING";
	String M_ERROR = "ERROR";
	String M_CONFIRM = "CONFIRM";
	
	// DFS Mapping Default List
//	ObservableList<String> NEXTATRRIBUTE_DEFAULT_LIST = FXCollections.observableArrayList("PROCESS","STEP","TIMESTAMP");
	
	//DFS Default SemiSet 
	ObservableList<String> TRACKING_WAFER = FXCollections.observableArrayList("LOT", "WAFER","PROCESS","STEP","EQUIPMENT","TIMESTAMP");
	ObservableList<String> PROCESS_WAFER = FXCollections.observableArrayList("LOT", "WAFER","PROCESS","STEP","EQUIPMENT","TIMESTAMP");
	ObservableList<String> PROCESS_TRACE = FXCollections.observableArrayList("LOT", "WAFER","PROCESS","STEP","EQUIPMENT","RECIPE","RECIPE_STEP","TRACETIME");
	ObservableList<String> METROLOGY_WAFER = FXCollections.observableArrayList("LOT", "WAFER","PROCESS","STEP","EQUIPMENT","TIMESTAMP");
	ObservableList<String> SORT_WAFER = FXCollections.observableArrayList("LOT", "WAFER","PROCESS","STEP","EQUIPMENT","TIMESTAMP");
	ObservableList<String> SORT_MAP = FXCollections.observableArrayList("LOT", "WAFER","PROCESS","STEP","TIMESTAMP","Xaxis","Yaxis");
	ObservableList<String> ETEST_WAFER = FXCollections.observableArrayList("LOT", "WAFER","PROCESS","STEP","EQUIPMENT","TIMESTAMP");
	ObservableList<String> ETEST_MAP = FXCollections.observableArrayList("LOT", "WAFER","PROCESS","STEP","TIMESTAMP","Xaxis","Yaxis");
	
	//DFS Default Sort List
	ObservableList<String> DEFAULT_SORT_LIST = FXCollections.observableArrayList("LOT", "WAFER","PROCESS","STEP"
			,"DEVICE","EQUIPMENT","CHAMBER","RECIPE","RECIPE_STEP","Xaxis","Yaxis","DEFECT_X","DEFECT_Y"
			,"TIMESTAMP","TRACETIME","WAFER_SITE","OPERATOR","MASK","LOWYIELD","REPAIRED");	
	
	//EXPORT XML
	String TEMPLATE_DBINFO_XML_PATH = "resources/templateXML/templateDBINFO.xml";
	String TEMPLATE_eDATAREALM_CONFIG_WINDOWS_XML_PATH = "resources/templateXML/templateEDataRealmConfigForWindows.xml";
	String TEMP_PG_DEFAULT_PATH = "C:\\Program Files\\PostgreSQL\\9.6\\bin";
	String TEMPLATE_LOG_XML_PATH = "resources/templateXML/templateLog4j2.xml";
	String TEMP_eDL_LOG_PATH = "C:\\ProgramData\\BISTel\\eDataRealm\\logs\\edatarealm.log";
	ObservableList<String> LOG4J2_LEVEL =  FXCollections.observableArrayList("fatal", "error","warn","info","debug","trace");
	
}