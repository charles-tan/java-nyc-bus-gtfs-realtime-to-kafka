// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: main/resources/gtfs-realtime.proto

package com.google.transit.realtime;

public interface FeedMessageOrBuilder extends
    // @@protoc_insertion_point(interface_extends:transit_realtime.FeedMessage)
    com.google.protobuf.GeneratedMessageV3.
        ExtendableMessageOrBuilder<FeedMessage> {

  /**
   * <pre>
   * Metadata about this feed and feed message.
   * </pre>
   *
   * <code>required .transit_realtime.FeedHeader header = 1;</code>
   * @return Whether the header field is set.
   */
  boolean hasHeader();
  /**
   * <pre>
   * Metadata about this feed and feed message.
   * </pre>
   *
   * <code>required .transit_realtime.FeedHeader header = 1;</code>
   * @return The header.
   */
  com.google.transit.realtime.FeedHeader getHeader();
  /**
   * <pre>
   * Metadata about this feed and feed message.
   * </pre>
   *
   * <code>required .transit_realtime.FeedHeader header = 1;</code>
   */
  com.google.transit.realtime.FeedHeaderOrBuilder getHeaderOrBuilder();

  /**
   * <pre>
   * Contents of the feed.
   * </pre>
   *
   * <code>repeated .transit_realtime.FeedEntity entity = 2;</code>
   */
  java.util.List<com.google.transit.realtime.FeedEntity> 
      getEntityList();
  /**
   * <pre>
   * Contents of the feed.
   * </pre>
   *
   * <code>repeated .transit_realtime.FeedEntity entity = 2;</code>
   */
  com.google.transit.realtime.FeedEntity getEntity(int index);
  /**
   * <pre>
   * Contents of the feed.
   * </pre>
   *
   * <code>repeated .transit_realtime.FeedEntity entity = 2;</code>
   */
  int getEntityCount();
  /**
   * <pre>
   * Contents of the feed.
   * </pre>
   *
   * <code>repeated .transit_realtime.FeedEntity entity = 2;</code>
   */
  java.util.List<? extends com.google.transit.realtime.FeedEntityOrBuilder> 
      getEntityOrBuilderList();
  /**
   * <pre>
   * Contents of the feed.
   * </pre>
   *
   * <code>repeated .transit_realtime.FeedEntity entity = 2;</code>
   */
  com.google.transit.realtime.FeedEntityOrBuilder getEntityOrBuilder(
      int index);
}
