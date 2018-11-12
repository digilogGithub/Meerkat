package com.digilog.meerkat.util;


import java.util.Iterator;

import com.digilog.meerkat.model.dfsGenerator.crawler.DFSVariableModel;

import javafx.collections.ObservableList;

public class DFGVarableCheckNotOpt {
	
	boolean allDone;
	
	public boolean checkNotOptController(ObservableList<DFSVariableModel> l_variables) {
		
		allDone = true;
		Iterator<DFSVariableModel> itr = l_variables.iterator();
		
		while(itr.hasNext()) {
			DFSVariableModel temp = itr.next();
			if(temp.getContentBoolean() == true && temp.getColumn_name() == null)
				allDone = false;
		}
		return allDone;
	}
	
}
