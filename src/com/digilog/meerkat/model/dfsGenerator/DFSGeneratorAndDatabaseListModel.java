package com.digilog.meerkat.model.dfsGenerator;

import com.digilog.meerkat.view.DFSGenerator.DFSGeneratorMainViewController;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

public class DFSGeneratorAndDatabaseListModel {

	private SimpleBooleanProperty export;
	private SimpleBooleanProperty imported;
	private SimpleStringProperty databaseSource;
	private DFSDatabaseConnectionModel dfsDatabaseConnectionModel;
	private DFSGeneratorMainViewController dfsGeneratorMainController;
	

	public DFSGeneratorAndDatabaseListModel() {
		export = new SimpleBooleanProperty();
		databaseSource = new SimpleStringProperty();
		dfsDatabaseConnectionModel = new DFSDatabaseConnectionModel();
		dfsGeneratorMainController = new DFSGeneratorMainViewController();
	}
	
	public DFSGeneratorAndDatabaseListModel(boolean imported, boolean export, DFSDatabaseConnectionModel dfsDatabaseConnectionModel
			, DFSGeneratorMainViewController dfsGeneratorMainController
			) {		
		this.imported = new SimpleBooleanProperty(imported);
		this.export = new SimpleBooleanProperty(export);
		this.databaseSource = new SimpleStringProperty(dfsDatabaseConnectionModel.getDatasourceName());
		this.dfsDatabaseConnectionModel = dfsDatabaseConnectionModel;
		this.dfsGeneratorMainController = dfsGeneratorMainController;
	}

	public boolean isImported() {
		return imported.get();
	}

	public void setImported(boolean imported) {
		this.imported.set(imported);
	}
	
	public SimpleBooleanProperty importedProperty() {
		return imported;
	}
	
	public boolean isExport() {
		return export.get();
	}

	public void setExport(boolean export) {
		this.export.set(export);
	}
	
	public SimpleBooleanProperty exportProperty() {
		return export;
	}
	
	public String getDatabaseSource() {
		return databaseSource.get();
	}

	public void setDatabaseSource(String databaseSource) {
		this.databaseSource.set(databaseSource);
	}

	public SimpleStringProperty databaseSourceProperty() {
		return databaseSource;
	}
	
	public DFSDatabaseConnectionModel getDfsDatabaseConnectionModel() {
		return dfsDatabaseConnectionModel;
	}

	public void setDfsDatabaseConnectionModel(DFSDatabaseConnectionModel dfsDatabaseConnectionModel) {
		this.dfsDatabaseConnectionModel = dfsDatabaseConnectionModel;
	}

	public DFSGeneratorMainViewController getDfsGeneratorMainController() {
		return dfsGeneratorMainController;
	}
	
	public void setDfsGeneratorMainController(DFSGeneratorMainViewController dfsGeneratorMainController) {
		this.dfsGeneratorMainController = dfsGeneratorMainController;
	}
}
