package com.example.javaoop;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class LoginController implements Initializable {
    @FXML
    private ImageView loginLogo_1;
    @FXML
    private ImageView loginLogo_2;

    public LoginController() {
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        File loginFile = new File("images/loginLogo.png");
        Image loginImage = new Image(loginFile.toURI().toString());
        this.loginLogo_1.setImage(loginImage);
        this.loginLogo_2.setImage(loginImage);
    }
}