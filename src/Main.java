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

//hur fasen kallar jag på View LogiPage så att den startas? Det funkar om man lägger allt i LoginPage på Main.
//men är ju snyggare om vi bara kan kalla på LoginPage härifrån så Main inte blir så stor, utan bara startar allt.