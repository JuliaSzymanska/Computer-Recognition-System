package tech.szymanskazdrzalik.fuzzy;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    public static Stage stage;
    private static Scene scene;

    public static void main(String[] args) throws IOException {
//        AccidentDAO accidentDao = new ResourcesAccidentDao();
//        var x = accidentDao.getAll("Data/" + PropertiesLoader.getJsonName());
//        int y = 0;
        launch();
    }

    private static Parent loadFXML(String fxml) throws IOException {
//        ResourceBundle resourceBundle = ResourceBundle.getBundle("Lang", Locale.getDefault());
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/" + fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    public void reload(String fxmlFileName) throws IOException {
        stage.getScene().setRoot(loadFXML(fxmlFileName));
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        scene = new Scene(loadFXML("main"));
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
}
