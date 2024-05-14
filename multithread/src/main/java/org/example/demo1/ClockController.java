package org.example.demo1;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ClockController {

  public Label TimeLabel;
  public TextField timeTextField;
  public Label Error;
  private MultiThread clockThread1;

  public void initialize() {
    clockThread1 = new MultiThread(TimeLabel, 0);
    clockThread1.start();
  }

  @FXML
  private void onSetTimeButtonClicked() {
    int offset;
    try {
      offset = Integer.parseInt(timeTextField.getText());
    } catch (NumberFormatException e) {
      Error.setText("Invalid!");
      return;
    }
    try {
      FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Clock1.fxml"));
      Parent root = fxmlLoader.load();
      Clock2Controller clock2Controller = fxmlLoader.getController();
      clock2Controller.setOffset(offset);
      clock2Controller.initialize();

      Stage stage = new Stage();
      stage.setTitle("Clock2");
      stage.getIcons().add(new Image(getClass().getResourceAsStream("OIP.jpg")));
      stage.setScene(new Scene(root));
      stage.show();
    } catch (IOException e) {
      Error.setText("Error!");
    }


  }
}