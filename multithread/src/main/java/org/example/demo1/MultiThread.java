package org.example.demo1;

import javafx.application.Platform;
import javafx.scene.control.Label;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MultiThread extends Thread {
  private final Label timeLabel;
  private int timeOffset;

  public MultiThread(Label timeLabel, int timeOffset) {
    this.timeLabel = timeLabel;
    this.timeOffset = timeOffset;
  }

  @Override
  public void run() {
    try {
      while (!Thread.interrupted()) {
        updateTime();
        Thread.sleep(1000);
      }
    } catch (InterruptedException e) {
    }
  }

  private void updateTime() {
    SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    Date currentTime = new Date();
    currentTime.setTime(currentTime.getTime() + timeOffset * 3600 * 1000);
    String formattedTime = dateFormat.format(currentTime);
    Platform.runLater(() -> timeLabel.setText(formattedTime));
  }
}
