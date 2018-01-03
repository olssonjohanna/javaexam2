package View;

import Controller.Controller;
import Model.*;
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

public class AdminView {

    public AdminView(String currentEmail) {
        this.currentEmail = currentEmail;
    }

    private String currentEmail;
    private Controller controller;

    public void start(Stage adminStage) throws Exception {

        EventHandler handlerAllCourses = new EventHandler() {
            @Override
            public void handle(Event event) {
                ArrayList<Course> showThis = ManageCourse.getAllCoursesOnString();

                if (showThis == null || (showThis.size() == 0)) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information");
                    alert.setHeaderText("No courses found");
                    alert.showAndWait();
                }

                try {
                    adminStage.close();
                    Stage courseStage = new Stage();
                    Scene courseScene = new Scene(new Group(new Label(showThis.toString())), 500, 500);
                    courseStage.setScene(courseScene);
                    courseStage.show();

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        };

        EventHandler handlerRegistre = new EventHandler() {
            @Override
            public void handle(Event event) {
                Label label1 = new Label("Course name: ");
                label1.setLayoutX(150);
                label1.setLayoutY(160);

                TextField courseName = new TextField();
                courseName.setLayoutX(250);
                courseName.setLayoutY(160);

                Label label = new Label("Course ID: ");
                label.setLayoutX(150);
                label.setLayoutY(260);

                TextField courseID = new TextField();
                courseID.setLayoutX(250);
                courseID.setLayoutY(260);

                EventHandler handlerAddCourse = new EventHandler() {
                    @Override
                    public void handle(Event event) {
                        String coursename = courseName.getText();
                        int courseid = Integer.parseInt(courseID.getText());

                        boolean result = ManageAdmin.adminAddCourse(coursename, courseid);

                        if (result == true) {
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Information");
                            alert.setHeaderText("Course added");
                            alert.showAndWait();
                        } else {
                            Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                            alert2.setTitle("Error");
                            alert2.setHeaderText("Something went wrong");
                            alert2.showAndWait();
                        }
                    }
                };

                Button buttonA = new Button("Add Course");
                buttonA.setLayoutX(150);
                buttonA.setLayoutY(360);
                buttonA.setOnMouseClicked(handlerAddCourse);

                Group group = new Group(label,label1,courseName, courseID,buttonA);
                Stage stage = new Stage();
                Scene scene = new Scene(group,500,500);

                stage.setScene(scene);
                stage.show();


            }
        };

        Button buttonS = new Button("All courses");
        buttonS.setLayoutX(150);
        buttonS.setLayoutY(160);
        buttonS.setOnMouseClicked(handlerAllCourses);

        Button buttonA = new Button("Add new course");
        buttonA.setLayoutX(150);
        buttonA.setLayoutY(260);
        buttonA.setOnMouseClicked(handlerRegistre);

        Group group = new Group(buttonS, buttonA);
        Scene scene = new Scene(group, 500, 500);

        adminStage.setScene(scene);
        adminStage.show();
    }
}