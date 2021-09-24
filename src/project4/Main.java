package project4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This is the main class to run the program.
 * It also creates our main scene and stage that will hold our gui obkects.
 */
public class Main extends Application
{
    /**
     * This method wil execute at the start of the run.
     * It will setup our GUI.
     * @param primaryStage This is our stage that is being passed in from the GUI.
     * @throws Exception Checks to see if everything is created properly
     */
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("project4.fxml"));
        primaryStage.setTitle("Order Sandwich");
        primaryStage.setScene(new Scene(root, 1080, 720));
        primaryStage.show();
    }

    /**
     * Our main run method.
     * @param args Our arguments.
     */
    public static void main(String[] args)
    {
        launch(args);
    }
}
