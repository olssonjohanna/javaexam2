package View;

import Controller.Controller;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AdminView {

    private Controller controller;

    public void start(Stage primaryStage) throws Exception{

        EventHandler handlerAllCourses = new EventHandler() {
            @Override
            public void handle(Event event) {
            }
        };

        EventHandler handlerAddCourse = new EventHandler() {
            @Override
            public void handle(Event event) {
            }
        };

        Button buttonS = new Button("All courses");
        buttonS.setLayoutX(150);
        buttonS.setLayoutY(260);
        buttonS.setOnMouseClicked(handlerAllCourses);

        Button buttonA = new Button("Add new course");
        buttonA.setLayoutX(150);
        buttonA.setLayoutY(360);
        buttonA.setOnMouseClicked(handlerAddCourse);

        Group group = new Group(buttonS, buttonA);
        Scene scene = new Scene(group,500,500);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

