package com.satori.bots.framework;

/** Indicates errors in communication with the underlying RTM instance */
public class RtmException extends Exception {
  public RtmException() {}

  public RtmException(String message) {
    super(message);
  }

  public RtmException(String message, Throwable cause) {
    super(message, cause);
  }

  public RtmException(Throwable cause) {
    super(cause);
  }
}
