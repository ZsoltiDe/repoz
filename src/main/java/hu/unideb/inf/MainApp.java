package hu.unideb.inf;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import hu.unideb.inf.controller.ErrorController;
import hu.unideb.inf.controller.FXMLStudentsSceneController;
import hu.unideb.inf.model.Model;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.h2.tools.Server;

public class MainApp extends Application {
    Stage stage1=new Stage();
    Stage primaryStage;
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/FXMLStudentsScene.fxml"));
        primaryStage=stage;
        Scene scene = new Scene(loader.load());
        stage.setTitle("Students Register");
        stage.setScene(scene);
        stage.show();
        ((FXMLStudentsSceneController)(loader.getController())).setModel(new Model());
        ((FXMLStudentsSceneController)(loader.getController())).setMain(this);
        ((FXMLStudentsSceneController)(loader.getController())).setStage(stage);

    }
    public void ErrorDialog() throws Exception {
        FXMLLoader loader1 = new FXMLLoader();
        loader1.setLocation(MainApp.class.getResource("/errordialog/FXMLErrorData"));
        Stage stage1= new Stage();
        stage1.initModality(Modality.WINDOW_MODAL);
        stage1.initOwner(primaryStage);
        ErrorController errorController=loader1.getController();
        errorController.setStage(stage1);
        Scene scene = (Scene)loader1.load();
       stage1.initModality(Modality.WINDOW_MODAL);
        stage1.initOwner(primaryStage);
        stage1.setTitle("Error");
        stage1.setScene(scene);
        stage1.showAndWait();

    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            startDatabase();
        } catch (SQLException ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        launch(args);
       // stopDatabase();
    }

    private static Server s = new Server();
    
    private static void startDatabase() throws SQLException {
        s.runTool("-tcp", "-web", "-ifNotExists");
    }

    public static void stopDatabase()  {
        s.shutdown();
    }
    
}
