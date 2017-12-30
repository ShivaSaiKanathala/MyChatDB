package application;
	
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;

import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application implements EventHandler {
	@Override
	public void start(Stage primaryStage) {
		
			
			try {
			
				FXMLLoader firstLoader = new FXMLLoader(getClass().getResource("MyView.fxml"));
				MyViewController first1 = new MyViewController();
				firstLoader.setController(first1);
				Parent root1 = firstLoader.load();
					Scene scene1 = new Scene(root1,600,630);
					scene1.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
					primaryStage.setScene(scene1);
					primaryStage.setTitle("user1");
					primaryStage.show();						
					
					} catch(Exception e) {
					
					e.printStackTrace();
				}
	}
	
	
	
	public static void main(String[] args) {
		launch(args);
		
	}



	@Override
	public void handle(Event event) {
		// TODO Auto-generated method stub
		
	}

	

	
}
