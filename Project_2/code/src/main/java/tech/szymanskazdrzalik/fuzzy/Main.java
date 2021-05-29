package tech.szymanskazdrzalik.fuzzy;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tech.szymanskazdrzalik.fuzzy.dao.AccidentDAO;
import tech.szymanskazdrzalik.fuzzy.dao.ResourcesAccidentDao;
import tech.szymanskazdrzalik.fuzzy.utils.PropertiesLoader;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class Main extends Application {
    private static Scene scene;
    public static Stage stage;

    public static void main(String[] args) throws IOException {
//        AccidentDAO accidentDao = new ResourcesAccidentDao();
//        var x = accidentDao.getAll("Data/" + PropertiesLoader.getJsonName());
//        int y = 0;
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        scene = new Scene(loadFXML("main"));
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    private static Parent loadFXML(String fxml) throws IOException {
//        ResourceBundle resourceBundle = ResourceBundle.getBundle("Lang", Locale.getDefault());
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/" + fxml + ".fxml"));
        return fxmlLoader.load();
    }
}
