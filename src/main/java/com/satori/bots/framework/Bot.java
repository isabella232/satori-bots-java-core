package com.satori.bots.framework;

/** This interface identifies the class as a Satori Bot */
public interface Bot {
  /**
   * Invoked when the bot is being launched. Can be used to initialize bot data structures, retrieve
   * state from RTM KV, pre-spawn worker pools, spawn executors for periodic tasks, etc. The bot does
   * not receive any data until this function returns
   *
   * @param botContext Bot context for this bot {@link BotContext}
   */
  void onSetup(BotContext botContext);

  /**
   * Invoked every time data is received on any channel that the bot is subscribed to
   *
   * @param ctx Bot context for this bot {@link BotContext}
   * @param subscriptionData Received data {@link RtmSubscriptionData}
   */
  void onSubscriptionData(BotContext ctx, RtmSubscriptionData subscriptionData);
}
