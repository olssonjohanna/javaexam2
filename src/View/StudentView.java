package View;

import Controller.Controller;
import Model.Course;
import Model.Student;
import Model.Teacher;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class StudentView {
    private Controller controller;

    public void start(Stage primaryStage) throws Exception{

        EventHandler handlerMyCourses = new EventHandler() {
            @Override
            public void handle(Event event) {
                Array<Course> myCourses = Student.getCourses;

                Scene courseScene = new Scene(new Group(new Label("ALL COURSES")),200,100);
                Stage courseStage = new Stage();

                courseStage.setScene(myCourses);
                courseStage.show();
            }
        };

        EventHandler handlerAllCourses = new EventHandler() {
            @Override
            public void handle(Event event) {
                ArrayList<Course> allCourses = Course.getAllCourses;

                Scene courseScene = new Scene(new Group(new Label("ALL COURSES")),200,100);
                Stage courseStage = new Stage();

                courseStage.setScene(allCourses);
                courseStage.show();

            }
        };

        EventHandler handlerRegistre = new EventHandler() {
            public void handle(Event handle){
                //denna funktionen ska ta en course från course via ID och lägga till i listan över Student arraylist
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



