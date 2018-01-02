import Model.Admin;
import View.LoginPage;
import com.oracle.tools.packager.Log;
import javafx.stage.Stage;

public class Main extends javafx.application.Application {
    @Override
    public void start(Stage primaryStage) throws Exception {


        LoginPage loginpage = new LoginPage();
        loginpage.start(primaryStage);

    }
}

