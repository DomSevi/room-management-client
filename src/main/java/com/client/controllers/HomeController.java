package com.client.controllers;

import com.client.ClientMain;
import com.client.CurrentSession;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.GridPane;
import javafx.scene.text.TextAlignment;

public class HomeController {

    public void setLoggedInUser() {
        loggedInAs.setText("Zalogowano jako:\n" + CurrentSession.getUser());
        loggedInAs.setTextAlignment(TextAlignment.CENTER);
    }

    @FXML   // Ustawienie potrzebnych rzeczy na starcie
    protected void initialize() {
        // Ustawienie strony
        setPage('h');
    }

    @FXML
    private GridPane homeHome;
    @FXML
    private GridPane homeRooms;
    @FXML
    private GridPane homeEmp;
    public static SubRoomsController homeRoomsController;
    public static SubHomeController homeHomeController;
    public static SubEmpController homeEmpController;

    private void setPage(char c ) {
        if(c == 'h') {
            homeHome.setVisible(true);
            homeRooms.setVisible(false);
            homeEmp.setVisible(false);
        }
        else if(c == 'r'){
            homeHome.setVisible(false);
            homeRooms.setVisible(true);
            homeEmp.setVisible(false);
        }
        else if(c == 'e') {
            homeHome.setVisible(false);
            homeRooms.setVisible(false);
            homeEmp.setVisible(true);
        }
    }

    @FXML
    protected void fullscreen() {
        if(!ClientMain.mainStage.isFullScreen()) {
            ClientMain.mainStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
            ClientMain.mainStage.setFullScreen(true);
        }
        else
            ClientMain.mainStage.setFullScreen(false);
    }


    @FXML // Obsluga przyskow gornych zmieniajacych podstrone strony home
    Button homeButton;
    @FXML
    protected void home() {
        if(!homeHome.isVisible()){
            homeHomeController.clear();
            setPage('h');
        }
    }
    @FXML
    Button roomsButton;
    @FXML
    protected void rooms() {
        if(!homeRooms.isVisible()){
            homeRoomsController.clear();
            setPage('r');
        }
    }
    @FXML
    Button empButton;
    @FXML
    protected void emp() {
        if(!homeEmp.isVisible()){
            homeEmpController.clear();
            setPage('e');
        }
    }

    @FXML
    Label loggedInAs;
    @FXML
    Button logoutButton;
    @FXML   // Wylogowanie
    protected void logout(){
        // ### wyczyscic wszystko
        homeHomeController.clear();
        homeRoomsController.clear();
        homeEmpController.clear();
        AppController.activateScene("login");
    }

}
