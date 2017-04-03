package com.satori.bots.framework;

/**
 * Provides a convenient way of interacting with RTM from a bot. All the methods operate within the
 * scope of the Project (DevPortal project) that the instance is launched in
 */
public interface RtmProxy {
  /**
   * Publishes a message to the channel.
   * @param channel   Name of the channel to publish to.
   * @param message   Serializable JSON object.
   * @param ack       Acknowledgement mode.
   * @return          If acknowledgement mode is YES, received next position is returned, else null
   */
  String publish(String channel, Object message, Ack ack) throws RtmException, InterruptedException;

  /**
   * Reads the value of the specified key from the key-value store.
   *
   * @param key   Key name.
   * @param <T>   Type of the value to be read.
   * @return      Result of the read request.
   */
  <T> T read(String key, Class<T> clazz) throws RtmException, InterruptedException;

  /**
   * Reads the value of the specified key from the key-value store, from the specified position
   *
   * @param key   Key name.
   * @param next  A next-position received in a previous message from RTM
   * @param <T>   Type of the value to be read.
   * @return      Result of the read request.
   */
  <T> T read(String key, String next, Class<T> clazz) throws RtmException, InterruptedException;

  /**
   * Writes the value for the specified key to the key-value store.
   *
   * @param key   Key name.
   * @param value Serializable JSON object.
   * @param ack   Acknowledgement mode.
   * @return      Result of the write request, depending upon the acknowledgement mode, as above.
   */
  String write(String key, Object value, Ack ack) throws RtmException, InterruptedException;
}
