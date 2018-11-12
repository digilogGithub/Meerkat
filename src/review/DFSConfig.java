package review;

public class DFSConfig {
//	grep role  QMSDBCrawler.xml | awk -F"\"" '{print  $9"="$10}' | sort -u
//	 variable_group==CONTEXT
//	 variable_group==ATTRIBUTE
//	 variable_group==PARAMETER
//
//	DIGILOGui-MacBook-Pro:eDL_Config (1) digilog$ grep role  QMSDBCrawler.xml | awk -F"\"" '{print  $11$12}' | sort -u
//	role=KEY
//	role=DESCRIPTOR
//	role=PARAMETER
//
//
//
//	======  CONTEXT  ========== 
//	------  CONTEXT & KEY 
//
//	grep CONTEXT  QMSDBCrawler.xml | awk -F"\"" '{print $1$2" "$9$10" "$11$12}' | sort -u | awk '{print $2" "$3" "$4}' | grep -i role=key
//
//	name=LOT variable_group=CONTEXT role=KEY
//	name=WAFER variable_group=CONTEXT role=KEY
//
//	------  CONTEXT & DESCRIPTOR 
//	no result
//
//	------  CONTEXT & PARAMETER 
//	no result
//
//
//	====== ATTRIBUTE =========
//	------  ATTRIBUTE & KEY 
//	grep ATTRIBUTE  QMSDBCrawler.xml | awk -F"\"" '{print $1$2" "$9$10" "$11$12}' | sort -u | awk '{print $2" "$3" "$4}' | grep -i role=key
//
//	name=RECIPE variable_group=ATTRIBUTE role=KEY
//	name=RECIPE_STEP variable_group=ATTRIBUTE role=KEY
//	name=TRACETIME variable_group=ATTRIBUTE role=KEY
//	name=Xaxis variable_group=ATTRIBUTE role=KEY
//	name=Yaxis variable_group=ATTRIBUTE role=KEY
//
//	------  ATTRIBUTE & DESCRIPTOR
//	grep ATTRIBUTE  QMSDBCrawler.xml | awk -F"\"" '{print $1$2" "$9$10" "$11$12}' | sort -u | awk '{print $2" "$3" "$4}' | grep -i DESCRIPTOR
//
//	name=PROCESS variable_group=ATTRIBUTE role=DESCRIPTOR
//	name=STEP variable_group=ATTRIBUTE role=DESCRIPTOR
//
//
//	------  ATTRIBUTE & PARAMETER  --------
//	grep ATTRIBUTE  QMSDBCrawler.xml | awk -F"\"" '{print $1$2" "$9$10" "$11$12}' | sort -u | awk '{print $2" "$3" "$4}' | grep -i PARAMETER
//
//	name=DEVICE variable_group=ATTRIBUTE role=PARAMETER
//	name=EQUIPMENT variable_group=ATTRIBUTE role=PARAMETER
//	name=RECIPE variable_group=ATTRIBUTE role=PARAMETER
//	name=TIMESTAMP variable_group=ATTRIBUTE role=PARAMETER
//
//	name=REPAIRED variable_group=ATTRIBUTE role=PARAMETER
//	name=LOWYIELD variable_group=ATTRIBUTE role=PARAMETER
//	name=MASK variable_group=ATTRIBUTE role=PARAMETER
//	name=OPERATOR variable_group=ATTRIBUTE role=PARAMETER
//
//
//
//	======  PARAMETER  ============
//
//	------  PARAMETER & KEY 
//	no result
//
//
//	------  PARAMETER & DESCRIPTOR
//	no result
//
//
//	------  PARAMETER & PARAMETER 
//	grep PARAMETER QMSDBCrawler.xml | awk -F"\"" '{print $1$2" "$9$10" "$11$12}' | sort -u | awk '{print $2" "$3" "$4}' | grep -i variable_group=PARAMETER
//
//	name=BIN variable_group=PARAMETER role=PARAMETER
//	name=PARAMETER_NAME variable_group=PARAMETER role=PARAMETER
//	name=SENSOR1 variable_group=PARAMETER role=PARAMETER
//	name=SENSOR10 variable_group=PARAMETER role=PARAMETER
//	name=SENSOR2 variable_group=PARAMETER role=PARAMETER
//	name=SENSOR3 variable_group=PARAMETER role=PARAMETER
//	name=SENSOR4 variable_group=PARAMETER role=PARAMETER
//	name=SENSOR5 variable_group=PARAMETER role=PARAMETER
//	name=SENSOR6 variable_group=PARAMETER role=PARAMETER
//	name=SENSOR7 variable_group=PARAMETER role=PARAMETER
//	name=SENSOR8 variable_group=PARAMETER role=PARAMETER
//	name=SENSOR9 variable_group=PARAMETER role=PARAMETER
//	name=VARIABLE_TYPE variable_group=PARAMETER role=PARAMETER

}
