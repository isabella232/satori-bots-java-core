package com.satori.bots.framework;

import com.google.gson.JsonArray;

/** Represents chunk of data received from RTM */
public interface RtmSubscriptionData {

  /** @return Parsed chunk of messages received from RTM */
  JsonArray getMessages();

  /** @return The ID of the subscription from which the data has been received */
  String getSubscriptionId();

  /**
   * @return The pointer to the first message in the stream after the last message
   * received in this chunk
   */
  String getNextPointer();

  /** @return The pointer to the first message received in this chunk */
  String getCurrentPointer();
}
