package com.client.controllers;

import javafx.fxml.FXML;

public class HomeWelcomeController {
    @FXML
    protected void initialize() {
        // Ustawia swoj controller w statycznym polu rodzica
        HomeController.homeWelcomeController = this;
    }

    public void clear() {

    }
}
