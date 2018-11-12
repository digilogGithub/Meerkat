package com.digilog.meerkat.attribute;

public interface SQLStatements {

	String dbConn="select 'DB Connection Success.' result from dual";
	String dbConnTest="select 'DB Connection Test Successful.' result from dual";
	String tableSerach="select * from user_objects where object_type='TABLE'";
	String selectTableNameList="select object_name \"TABLE NAME\" from user_objects where object_type='TABLE' and regexp_like(object_name, '";
	String selectTablePreviewData="select * from ";
	String selectTableInfo="select a.table_name, a.column_name, a.num_distinct, a.num_nulls, b.num_rows, TRUNC(a.num_nulls/b.num_rows,4) null_ratio "
			+ "from user_tab_cols a, user_tables b where a.table_name='";
	String selectTableData="select * from (select ";
	String createDFSGManagerTable="";
}
