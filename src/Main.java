import View.LoginPage;
import javafx.stage.Stage;

public class Main extends javafx.application.Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        LoginPage loginpage = new LoginPage();
        loginpage.start(primaryStage);
    }
}
