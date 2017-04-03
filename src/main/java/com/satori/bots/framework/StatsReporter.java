package com.satori.bots.framework;

/**
 * Allows reporting user-specific metrics to the bot metric channel
 * Every function sends the following message to the metric channel:
 * {"name": aspect,
 *  "type": "c" | "g" | "t" | "e",
 *  "tags": { // identification tags (appended automatically):
 *             "botInstanceId": instanceId,
 *             "botInstanceName": instanceName,
 *             "botInstanceShardIndex": shardNumber,
 *             // user supplied tags
 *             // ..
 *          },
 *   "value": value | delta
 *   }
 *
 * Tags should have the "key:value" form. For tags without the value part the value of "1" is assumed
 */
public interface StatsReporter {
  /**
   * Represents a statsd counter-type metric
   *
   * @param aspect Metric name
   * @param delta Increment for this counter
   * @param tags User-specific tags
   */
  void count(String aspect, long delta, String... tags);

  /**
   * Represents a statsd gauge-type metric
   *
   * @param aspect Metric name
   * @param value Current value of the gauge
   * @param tags User-specific tags
   */
  void gauge(String aspect, double value, String... tags);

  /**
   * Represents a statsd timing-type metric
   *
   * @param aspect Metric name
   * @param value Value for this datapoint
   * @param tags User-specific tags
   */
  void timing(String aspect, long value, String... tags);

  /**
   * Represents a statsd event
   *
   * @param title The event title
   * @param text The body of the event
   * @param alertType The type of event---"info", "warning" or "error"
   * @param tags Instance-specific tags
   */
  void event(String title, String text, AlertTypeEnum alertType, String... tags);

  /**
   * Represents a statsd event using default alert type as "info"
   *
   * @param title The event title
   * @param text The body of the event
   * @param tags Instance-specific tags
   */
  void event(String title, String text, String... tags); /* default alert_type = "info" */

  enum AlertTypeEnum {
    info,
    warning,
    error;
  }
}
