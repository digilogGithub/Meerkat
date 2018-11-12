package review;

class review {
	/* get tableview info	
	// get column name
	tableView.getColumns().get(4).getText();
	// get column data
	tableView.getSelectionModel().getSelectedItem().get(3);
	// get column index
	tableView.getFocusModel().getFocusedCell().getColumn();
	// get row index count
	tableView.getSelectionModel().getSelectedIndex();
	//
	*/
	
	
	/*
	 * mouse event
	 * tableView.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
						@Override
						public void handle(MouseEvent mouseEvent) {
							selectedPreviewTableIndex = tableView.getFocusModel().getFocusedCell().getColumn();
							if (selectedPreviewTableIndex >= 0 && selectedVairableTableIndex >= 0) {
								System.out.println("variable view column : "
										+ DFSVariableTable.getSelectionModel().getSelectedItem().getContent1());
								System.out.println("table view column : "
										+ tableView.getColumns().get(selectedPreviewTableIndex).getText());
							}
						}
					});
	 */
	
	
	/*
	  ObservableMap<String,String> observableMap = FXCollections.observableMap(map);
        observableMap.addListener(new MapChangeListener() {
            @Override
            public void onChanged(MapChangeListener.Change change) {
                System.out.println("Detected a change! ");
            }
        });
        
            ObservableMap<String, String> observableMap = FXCollections.observableMap(map);
        observableMap.addListener(new MapChangeListener<Object, Object>() {
            @Override
            public void onChanged(MapChangeListener.Change<?, ?> change) {
                System.out.println("Detected a change! ");
            }
        });
 
        // Changes to the observableMap WILL be reported.
        observableMap.put("key 1","value 1");
        System.out.println("Size: "+observableMap.size());
        observableMap.put("key 2","value 1");
        System.out.println("Size: "+observableMap.size());
        observableMap.put("key 1","value 2");
        System.out.println("Size: "+observableMap.size());
        
	    boolean check = observableMap.containsKey("key 3")
	    
	    
	    
	    // table data remove
	    public void tableViewRefreshAll(TableView<TableModel> tableView) {
		for (int i = 0; i < tableView.getItems().size(); i++) {
			tableView.getItems().clear();
		}
		tableView.refresh();
	*/
	
	// tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
	
//	Tab studentAdmission = new Tab();
//    studentAdmission.setContent((Parent)new FXMLLoader(getClass().getResource("Customer_View.fxml")).load());
//
//   Label l = new Label("Student Admission");
//   l.setRotate(90);
//   StackPane stp = new StackPane(new Group(l));
//   studentAdmission.setGraphic(stp);
//   mainTab.getTabs().add(studentAdmission);
}
