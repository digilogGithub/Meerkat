package com.digilog.meerkat.util;

import com.digilog.meerkat.model.dfsGenerator.crawler.DFSVariableModel;

public class DFSVerifyMethod {

	boolean contextList;
	public DFSVerifyMethod() {
		
	}

	public boolean verifyContextList(String dfs_method, DFSVariableModel dfsVariableModel) {	

		contextList = false;
		String variable_group = dfsVariableModel.getVariable_group();
		String role =  dfsVariableModel.getRole();
		
		switch (dfs_method) {
		case "NEXTATTRIBUTE":
//			if (dfsVariableModel.getRole().equals("DESCRIPTOR"))
//			if (dfsVariableModel.getVariable_group().equals(DefineAtrribute.VARIABLE_GROUP_TYPE.get(1)))		
//			if(variable_group.equals(DefineAtrribute.VARIABLE_GROUP_TYPE.get(1)) && !role.equals(DefineAtrribute.ROLE_TYPE.get(0)))
			if(variable_group.equals("ATTRIBUTE") && !role.equals("KEY")) {
				contextList = true;
//				System.out.println("NEXTATTRIBUTE  :  "+ dfsVariableModel.getdfs_variable_name()+"   "+variable_group+"     "+role);
			}
			break;
			
		case "METADATA":
//			System.out.println("METADATA  :  "+ dfsVariableModel.getdfs_variable_name()+"   "+variable_group+"     "+role);
			break;

		default: // CONTEXTLIST
//			if (dfsVariableModel.getRole().equals("KEY") || dfsVariableModel.getRole().equals("DESCRIPTOR"))
//				contextList = true;
//			else if (dfsVariableModel.getVariable_type().equals("TIME"))
//			if (!variable_group.equals(DefineAtrribute.VARIABLE_GROUP_TYPE.get(2)) 
//					&& !(variable_group.equals(DefineAtrribute.VARIABLE_GROUP_TYPE.get(1)) && role.equals(DefineAtrribute.ROLE_TYPE.get(0))))
			if (!variable_group.equals("PARAMETER") 
					&& !(variable_group.equals("ATTRIBUTE") && role.equals("KEY"))){
//				System.out.println("CONTEXTLIST  :  "+ dfsVariableModel.getdfs_variable_name()+"   "+variable_group+"     "+role);
				contextList = true;
			}	
			break;
		}
		
		return contextList;
	}

}
