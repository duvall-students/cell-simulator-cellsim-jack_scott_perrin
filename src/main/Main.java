package main;
import controller.AutomataController;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application
{

	@Override
	public void start(Stage primaryStage)
	{
			

			AutomataController rpsCellController = new AutomataController();

			//primaryStage = rpsCellController.getStage();

			//primaryStage.show();
	}
	
	public static void main(String args[]){ 	
		  launch(args);
	}
}

