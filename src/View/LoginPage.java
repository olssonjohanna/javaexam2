package View;

import Controller.Controller;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.sound.midi.Track;

public class LoginPage {
    private Controller controller;

    public void start(Stage primaryStage) throws Exception{

        controller = new Controller();
        Label labelTL = new Label("Teacher Login");
        labelTL.setLayoutX(100);
        labelTL.setLayoutY(100);

        TextField teacherLogin = new TextField();
        teacherLogin.setLayoutX(200);
        teacherLogin.setLayoutY(100);

        Label labelTP = new Label("Teacher Password");
        labelTP.setLayoutX(100);
        labelTP.setLayoutY(130);

        TextField teacherPassword = new TextField();
        teacherPassword.setLayoutX(200);
        teacherPassword.setLayoutY(130);

        Label labelSL = new Label("Student Login");
        labelSL.setLayoutX(100);
        labelSL.setLayoutY(200);

        TextField studentLogin = new TextField();
        studentLogin.setLayoutX(200);
        studentLogin.setLayoutY(200);

        Label labelSP = new Label("Student Password");
        labelSP.setLayoutX(100);
        labelSP.setLayoutY(230);

        TextField studentPassword = new TextField();
        studentPassword.setLayoutX(200);
        studentPassword.setLayoutY(230);

        Label labelA = new Label("Admin Login");
        labelA.setLayoutX(100);
        labelA.setLayoutY(300);

        TextField adminLogin = new TextField();
        adminLogin.setLayoutX(200);
        adminLogin.setLayoutY(300);

        Label labelAP = new Label("Admin Password");
        labelAP.setLayoutX(100);
        labelAP.setLayoutY(330);

        TextField adminPassword = new TextField();
        adminPassword.setLayoutX(200);
        adminPassword.setLayoutY(330);

        EventHandler handlerTeacher = new EventHandler() {
            @Override
            public void handle(Event event) {
                String email = teacherLogin.getText();
                String password = teacherPassword.getText();
                boolean resultOfLogin = controller.tryLoginTeacher(email,password);

                if(resultOfLogin == true) {
                    Stage teacherStage = new Stage();
                    TeacherView sv = new TeacherView(email);
                    primaryStage.close();
                    try {
                        sv.start(teacherStage);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                else{
                    Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                    alert2.setTitle("Error");
                    alert2.setHeaderText("Wrong login or password");
                    alert2.showAndWait();
                }
            }
        };

        EventHandler handlerStudent = new EventHandler() {
            @Override
            public void handle(Event event) {
                String email = studentLogin.getText();
                String password = studentPassword.getText();
                boolean resultOfLogin = controller.tryLoginStudent(email,password);

                if(resultOfLogin == true){
                    Stage studentStage = new Stage();
                    StudentView sv = new StudentView(email);
                    primaryStage.close();
                    try {
                        sv.start(studentStage);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                else{
                    Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                    alert2.setTitle("Error");
                    alert2.setHeaderText("Wrong login or password");
                    alert2.showAndWait();
                }
            }
        };

        EventHandler handlerAdmin = new EventHandler() {
            public void handle(Event handle){
                String email = adminLogin.getText();
                String passowrd = adminPassword.getText();

                boolean resultOfLogin = controller.tryLoginAdmin(email,passowrd);
                if (resultOfLogin == true){
                    Stage adminStage = new Stage();
                    AdminView av = new AdminView(email);
                    primaryStage.close();
                    try {
                        av.start(adminStage);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                else {
                    Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                    alert2.setTitle("Error");
                    alert2.setHeaderText("Wrong password or login");
                    alert2.showAndWait();
                }
            }

        };

        Button buttonT = new Button("Login Teacher");
        buttonT.setLayoutX(150);
        buttonT.setLayoutY(160);
        buttonT.setOnMouseClicked(handlerTeacher);

        Button buttonS = new Button("Login Student");
        buttonS.setLayoutX(150);
        buttonS.setLayoutY(260);
        buttonS.setOnMouseClicked(handlerStudent);

        Button buttonA = new Button("Login Admin");
        buttonA.setLayoutX(150);
        buttonA.setLayoutY(360);
        buttonA.setOnMouseClicked(handlerAdmin);

        Group group = new Group(labelTL, teacherLogin, labelTP, teacherPassword, labelSL, studentLogin, labelSP, studentPassword, labelA, adminLogin, labelAP, adminPassword, buttonT, buttonS, buttonA);
        Scene scene = new Scene(group,500,500);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
