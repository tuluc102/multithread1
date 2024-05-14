package org.example.demo1;

import javafx.scene.control.Label;

public class Clock2Controller {
  private MultiThread clockThread2;
  public Label TimeLabel;
  private int offset;

  public void setOffset(int offset) {
    this.offset = offset;
  }
  public void initialize() {
    clockThread2 = new MultiThread(TimeLabel, offset);
    clockThread2.start();
  }
}
