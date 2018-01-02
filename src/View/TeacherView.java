package View;

import Controller.Controller;
import Model.Teacher;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class TeacherView {

    private Controller controller;

    public void start(Stage primaryStage) throws Exception{

        EventHandler handlerMyCourses = new EventHandler() {
            @Override
            public void handle(Event event) {
               // Array<Course> myCourses = Teacher.getCourses;

                Scene courseScene = new Scene(new Group(new Label("ALL COURSES")),200,100);
                Stage courseStage = new Stage();

                courseStage.setScene(courseScene);
                courseStage.show();
            }
        };

        EventHandler handlerAllCourses = new EventHandler() {
            @Override
            public void handle(Event event) {
              //  ArrayList<Course> allCourses = Course.getAllCourses;

                Scene courseScene = new Scene(new Group(new Label("ALL COURSES")),200,100);
                Stage courseStage = new Stage();

                courseStage.setScene(courseScene);
                courseStage.show();

                }
        };

        EventHandler handlerRegistre = new EventHandler() {
            public void handle(Event handle){
                //denna funktionen ska ta en course från course via ID och lägga till i listan över Teacher arraylist
            }
        };

        Button buttonT = new Button("My courses");
        buttonT.setLayoutX(150);
        buttonT.setLayoutY(160);
        buttonT.setOnMouseClicked(handlerMyCourses);

        Button buttonS = new Button("All courses");
        buttonS.setLayoutX(150);
        buttonS.setLayoutY(260);
        buttonS.setOnMouseClicked(handlerAllCourses);

        Button buttonA = new Button("Registre new course");
        buttonA.setLayoutX(150);
        buttonA.setLayoutY(360);
        buttonA.setOnMouseClicked(handlerRegistre);

        Group group = new Group(buttonT, buttonS, buttonA);
        Scene scene = new Scene(group,500,500);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

