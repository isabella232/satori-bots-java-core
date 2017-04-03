package com.satori.bots.framework;

import com.google.gson.JsonElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This interface allows access to the bot's environment
 */
public interface BotContext {
  /**
   * Returns bot and instance specific configuration passed with the instance creation request. The
   * framework does not inspect this value
   *
   * @return JSON representation of the custom configuration
   */
  JsonElement getCustomConfiguration();

  /** @return A {@link RtmProxy} for this bot instance. */
  RtmProxy getRtmProxy();

  /** @return A {@link StatsReporter} for this bot instance */
  StatsReporter getStatsReporter();

  /** @return The instance ID of this bot */
  String getInstanceId();

  /**
   * Using loggers retrieved via getLogger is the preferred method of logging inside the bot
   *
   * @param clazz Class after which to name the logger
   * @return A logger printing into bot's user log
   */
  static Logger getLogger(Class clazz) {
    return LoggerFactory.getLogger(clazz);
  }

  /**
   * Using loggers retrieved via getLogger is the preferred method of logging inside the bot
   *
   * @param name Name for the logger
   * @return A logger printing into bot's user log
   */
  static Logger getLogger(String name) {
    return LoggerFactory.getLogger(name);
  }
}
