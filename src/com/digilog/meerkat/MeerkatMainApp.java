package com.digilog.meerkat;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MeerkatMainApp extends Application {

	public static Stage primaryStage;
	// private BorderPane rootLayout;
	private GridPane rootGeneralConfigView;

	@Override
	public void start(Stage primaryStage) {
		MeerkatMainApp.primaryStage = primaryStage;
		MeerkatMainApp.primaryStage.setTitle("Meerkat");
		MeerkatMainApp.primaryStage.getIcons().add(new Image("file:resources/images/meerkat.png"));

		initRootLayout();
	}

	private void initRootLayout() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MeerkatMainApp.class.getResource("view/RootGeneralConfigView.fxml"));
			rootGeneralConfigView = (GridPane) loader.load();

			// RootLayoutController rootLayoutController=loader.getController();
			// rootLayoutController.showGeneralConfiguration();
			// rootLayoutController.showDFSGenerator();

			// rootViewController testCtl = loader.getController();
			// testCtl.showGeneralConfiguration();


			Scene scene = new Scene(rootGeneralConfigView, 1500, 800);

			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
