package View;

import Controller.Controller;
import Model.Course;
import Model.ManageStudent;
import Model.ManageTeacher;
import Model.Teacher;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;

public class TeacherView {
    private String currentEmail = "nothing";
    private Controller controller;

    public void start(Stage primaryStage) throws Exception{

        EventHandler handlerMyCourses = new EventHandler() {
            @Override
            public void handle(Event event) {
                ArrayList<Course> showThis = ManageTeacher.getCourses(currentEmail);

                Scene courseScene = new Scene(new Group(new Label(showThis.toString())),200,100);
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

                Label label1 = new Label("Course name: ");
                label1.setLayoutX(150);
                label1.setLayoutY(160);

                TextField courseName= new TextField();
                courseName.setLayoutX(200);
                courseName.setLayoutY(130);

                Label label = new Label("Course ID: ");
                label.setLayoutX(150);
                label.setLayoutY(260);

                TextField courseID = new TextField();
                courseID.setLayoutX(200);
                courseID.setLayoutY(130);

                EventHandler handlerAddCourse = new EventHandler() {
                    @Override
                    public void handle(Event event) {
                        String coursename= courseName.getText();
                        int courseid = Integer.parseInt(courseID.getText());
                        boolean result = ManageStudent.addCourse(currentEmail, coursename, courseid);

                        if (result == true) {
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Information");
                            alert.setHeaderText("Course added");
                            alert.showAndWait();
                        }
                        else {
                            Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                            alert2.setTitle("Error");
                            alert2.setHeaderText("Something went wrong");
                            alert2.showAndWait();
                        }
                    }
                };

                Button buttonT = new Button("Add Course");
                buttonT.setLayoutX(150);
                buttonT.setLayoutY(360);
                buttonT.setOnMouseClicked(handlerAddCourse);

                Scene courseScene = new Scene(new Group(new Label()),200,100);
                Stage courseStage = new Stage();

                courseStage.setScene(courseScene);
                courseStage.show();

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

