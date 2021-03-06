package com.client.controllers;

import com.client.ClientMain;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.util.HashMap;

public class AppController {
    public static Scene mainScene;
    private static HashMap<String, Parent> sceneMap = new HashMap<>();

    protected static LoginController loginController;
    protected static HomeController homeController;
    protected static ScheduleController scheduleController;

    static {
        // Stworzenie sceny logowania
        AppController.loginController = prepareScene("login", "fxml/login.fxml");
        Scene scene = new Scene(AppController.sceneMap.get("login"));
        AppController.initScene(scene);

        // Importowanie dodatkowych scen
            // home.fxml zawiera w sobie podsceny np. homeEmp i sa one ładowane w poniższej linii
        AppController.homeController = prepareScene("home", "fxml/home.fxml");
        AppController.scheduleController = prepareScene("schedule", "fxml/schedule.fxml");
    }

    // Przetwarza scene z pliku fxml oraz zwraca controller danej sceny
    private static <T> @Nullable T prepareScene(String name, String dir) {
        FXMLLoader loader = new FXMLLoader(ClientMain.class.getResource(dir));
        try {
            Parent root = loader.load();
            AppController.addScene(name, root);
            return loader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Ustala glowna scene, uzywana tylko przy starcie programu
    private static void initScene(Scene scene) {
        AppController.mainScene = scene;
    }

    // Dodanie sceny do mapy scen
    private static void addScene(String name, Parent p) {
        sceneMap.put(name, p);
    }

    // Zmienia dotychczas uzywana scene
    protected static void activateScene(String name) {
        mainScene.setRoot(sceneMap.get(name));
    }
}
