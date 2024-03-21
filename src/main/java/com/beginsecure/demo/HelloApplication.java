

/*
package com.beginsecure.demo;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import packWork.*;
import java.io.IOException;


/*
//Main class which extends from Application Class
public class HelloApplication extends Application {
    //This is our PrimaryStage (It contains everything)
    private Stage primaryStage;
    //This is the BorderPane of RootLayout
    private BorderPane rootLayout;
    @Override
    public void start(Stage primaryStage) {
        //1) Declare a primary stage (Everything will be on this stage)
        this.primaryStage = primaryStage;
        //Optional: Set a title for primary stage
        this.primaryStage.setTitle("SW Test Academy - Sample JavaFX App");
        //2) Initialize RootLayout
        HelloController ceva = new HelloController();
        ceva.initialize();
        initRootLayout();
        //3) Display the EmployeeOperations View
        showEmployeeView();
    }
    //Initializes the root layout.
    public void initRootLayout() {
        try {
            //First, load root layout from RootLayout.fxml
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(HelloApplication.class.getResource("Sample.fxml"));
            //Second, show the scene containing the root layout.
            Scene scene = new Scene(FXMLLoader.load(), 320, 240);
            primaryStage.setTitle("Hello!");
            primaryStage.setScene(scene);
            primaryStage.show();

            HranaController controller = loader.getController();
            //controller.setMain(this);
            //Third, show the primary stage
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //Shows the employee operations view inside the root layout.
    public void showEmployeeView() {
        try {
            //First, load EmployeeView from EmployeeView.fxml
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(HelloApplication.class.getResource("view/EmployeeView.fxml"));
            AnchorPane employeeOperationsView = (AnchorPane) loader.load();
            // Set Employee Operations view into the center of root layout.
            rootLayout.setCenter(employeeOperationsView);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String args) {
        launch(args);
    }
}

 */

/*
public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Sample.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        HelloController ceva = new HelloController();
        ceva.initialize();
    }

    public static void main(String[] args) {
        launch();
    }
}
*/
package com.beginsecure.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

//Main class which extends from Application Class
public class HelloApplication extends Application {

    //This is our PrimaryStage (It contains everything)
    private Stage primaryStage;

    //This is the BorderPane of RootLayout
    private BorderPane rootLayout;

    @Override
    public void start(Stage primaryStage) {
        //1) Declare a primary stage (Everything will be on this stage)
        this.primaryStage = primaryStage;

        //Optional: Set a title for primary stage
        this.primaryStage.setTitle("SW Test Academy - Sample JavaFX App");

        //2) Initialize RootLayout
        initRootLayout();

        //3) Display the EmployeeOperations View
        showEmployeeView();
    }

    //Initializes the root layout.
    public void initRootLayout() {
        try {
            //First, load root layout from RootLayout.fxml
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(HelloApplication.class.getResource("RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            //Second, show the scene containing the root layout.
            Scene scene = new Scene(rootLayout); //We are sending rootLayout to the Scene.
            primaryStage.setScene(scene); //Set the scene in primary stage.

            /*//Give the controller access to the main.
            RootLayoutController controller = loader.getController();
            controller.setMain(this);*/

            //Third, show the primary stage
            primaryStage.show(); //Display the primary stage
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Shows the employee operations view inside the root layout.
    public void showEmployeeView() {
        try {
            //First, load EmployeeView from EmployeeView.fxml
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(HelloApplication.class.getResource("Sample.fxml"));
            TabPane employeeOperationsView = (TabPane) loader.load();

            // Set Employee Operations view into the center of root layout.
            rootLayout.setCenter(employeeOperationsView);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args) {
        launch(args);
    }
}