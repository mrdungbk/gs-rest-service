package com.management.devices.common.enums;

/**
 * 
 * @author dungnv
 *
 */
public enum Status {

  /** success */
  STATUS_SUCCESS(0, "Success"),
  /** fail */
  STATUS_FAIL(1, "Fail");
  private int value;
  /** result */
  private String result;

  private Status(int value, String result) {
    this.value = value;
    this.result = result;
  }

  public int getValue() {
    return this.value;
  }

  public String getResult() {
    return this.result;
  }

  /**
   * Compare value with value define in enum
   * 
   * @param value : value want to compare
   * @return boolean (true : equal, false : not equal)
   */
  public boolean eq(int value) {
    return (this.value == value);
  }
}
