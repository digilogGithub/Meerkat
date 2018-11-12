package com.digilog.meerkat.util;

import javafx.collections.ObservableList;

public class SearchIndex {	
	public int getIdx(ObservableList<String> list, String name){	
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).equals(name))
				return i;
		}
		return -1;
	}
}
