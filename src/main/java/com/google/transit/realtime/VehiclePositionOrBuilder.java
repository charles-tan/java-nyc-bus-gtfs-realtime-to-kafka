// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: main/resources/gtfs-realtime.proto

package com.google.transit.realtime;

public interface VehiclePositionOrBuilder extends
    // @@protoc_insertion_point(interface_extends:transit_realtime.VehiclePosition)
    com.google.protobuf.GeneratedMessageV3.
        ExtendableMessageOrBuilder<VehiclePosition> {

  /**
   * <pre>
   * The Trip that this vehicle is serving.
   * Can be empty or partial if the vehicle can not be identified with a given
   * trip instance.
   * </pre>
   *
   * <code>optional .transit_realtime.TripDescriptor trip = 1;</code>
   * @return Whether the trip field is set.
   */
  boolean hasTrip();
  /**
   * <pre>
   * The Trip that this vehicle is serving.
   * Can be empty or partial if the vehicle can not be identified with a given
   * trip instance.
   * </pre>
   *
   * <code>optional .transit_realtime.TripDescriptor trip = 1;</code>
   * @return The trip.
   */
  com.google.transit.realtime.TripDescriptor getTrip();
  /**
   * <pre>
   * The Trip that this vehicle is serving.
   * Can be empty or partial if the vehicle can not be identified with a given
   * trip instance.
   * </pre>
   *
   * <code>optional .transit_realtime.TripDescriptor trip = 1;</code>
   */
  com.google.transit.realtime.TripDescriptorOrBuilder getTripOrBuilder();

  /**
   * <pre>
   * Additional information on the vehicle that is serving this trip.
   * </pre>
   *
   * <code>optional .transit_realtime.VehicleDescriptor vehicle = 8;</code>
   * @return Whether the vehicle field is set.
   */
  boolean hasVehicle();
  /**
   * <pre>
   * Additional information on the vehicle that is serving this trip.
   * </pre>
   *
   * <code>optional .transit_realtime.VehicleDescriptor vehicle = 8;</code>
   * @return The vehicle.
   */
  com.google.transit.realtime.VehicleDescriptor getVehicle();
  /**
   * <pre>
   * Additional information on the vehicle that is serving this trip.
   * </pre>
   *
   * <code>optional .transit_realtime.VehicleDescriptor vehicle = 8;</code>
   */
  com.google.transit.realtime.VehicleDescriptorOrBuilder getVehicleOrBuilder();

  /**
   * <pre>
   * Current position of this vehicle.
   * </pre>
   *
   * <code>optional .transit_realtime.Position position = 2;</code>
   * @return Whether the position field is set.
   */
  boolean hasPosition();
  /**
   * <pre>
   * Current position of this vehicle.
   * </pre>
   *
   * <code>optional .transit_realtime.Position position = 2;</code>
   * @return The position.
   */
  com.google.transit.realtime.Position getPosition();
  /**
   * <pre>
   * Current position of this vehicle.
   * </pre>
   *
   * <code>optional .transit_realtime.Position position = 2;</code>
   */
  com.google.transit.realtime.PositionOrBuilder getPositionOrBuilder();

  /**
   * <pre>
   * The stop sequence index of the current stop. The meaning of
   * current_stop_sequence (i.e., the stop that it refers to) is determined by
   * current_status.
   * If current_status is missing IN_TRANSIT_TO is assumed.
   * </pre>
   *
   * <code>optional uint32 current_stop_sequence = 3;</code>
   * @return Whether the currentStopSequence field is set.
   */
  boolean hasCurrentStopSequence();
  /**
   * <pre>
   * The stop sequence index of the current stop. The meaning of
   * current_stop_sequence (i.e., the stop that it refers to) is determined by
   * current_status.
   * If current_status is missing IN_TRANSIT_TO is assumed.
   * </pre>
   *
   * <code>optional uint32 current_stop_sequence = 3;</code>
   * @return The currentStopSequence.
   */
  int getCurrentStopSequence();

  /**
   * <pre>
   * Identifies the current stop. The value must be the same as in stops.txt in
   * the corresponding GTFS feed.
   * </pre>
   *
   * <code>optional string stop_id = 7;</code>
   * @return Whether the stopId field is set.
   */
  boolean hasStopId();
  /**
   * <pre>
   * Identifies the current stop. The value must be the same as in stops.txt in
   * the corresponding GTFS feed.
   * </pre>
   *
   * <code>optional string stop_id = 7;</code>
   * @return The stopId.
   */
  java.lang.String getStopId();
  /**
   * <pre>
   * Identifies the current stop. The value must be the same as in stops.txt in
   * the corresponding GTFS feed.
   * </pre>
   *
   * <code>optional string stop_id = 7;</code>
   * @return The bytes for stopId.
   */
  com.google.protobuf.ByteString
      getStopIdBytes();

  /**
   * <pre>
   * The exact status of the vehicle with respect to the current stop.
   * Ignored if current_stop_sequence is missing.
   * </pre>
   *
   * <code>optional .transit_realtime.VehiclePosition.VehicleStopStatus current_status = 4 [default = IN_TRANSIT_TO];</code>
   * @return Whether the currentStatus field is set.
   */
  boolean hasCurrentStatus();
  /**
   * <pre>
   * The exact status of the vehicle with respect to the current stop.
   * Ignored if current_stop_sequence is missing.
   * </pre>
   *
   * <code>optional .transit_realtime.VehiclePosition.VehicleStopStatus current_status = 4 [default = IN_TRANSIT_TO];</code>
   * @return The currentStatus.
   */
  com.google.transit.realtime.VehiclePosition.VehicleStopStatus getCurrentStatus();

  /**
   * <pre>
   * Moment at which the vehicle's position was measured. In POSIX time
   * (i.e., number of seconds since January 1st 1970 00:00:00 UTC).
   * </pre>
   *
   * <code>optional uint64 timestamp = 5;</code>
   * @return Whether the timestamp field is set.
   */
  boolean hasTimestamp();
  /**
   * <pre>
   * Moment at which the vehicle's position was measured. In POSIX time
   * (i.e., number of seconds since January 1st 1970 00:00:00 UTC).
   * </pre>
   *
   * <code>optional uint64 timestamp = 5;</code>
   * @return The timestamp.
   */
  long getTimestamp();

  /**
   * <code>optional .transit_realtime.VehiclePosition.CongestionLevel congestion_level = 6;</code>
   * @return Whether the congestionLevel field is set.
   */
  boolean hasCongestionLevel();
  /**
   * <code>optional .transit_realtime.VehiclePosition.CongestionLevel congestion_level = 6;</code>
   * @return The congestionLevel.
   */
  com.google.transit.realtime.VehiclePosition.CongestionLevel getCongestionLevel();

  /**
   * <pre>
   * If multi_carriage_status is populated with per-carriage OccupancyStatus,
   * then this field should describe the entire vehicle with all carriages accepting passengers considered.
   * </pre>
   *
   * <code>optional .transit_realtime.VehiclePosition.OccupancyStatus occupancy_status = 9;</code>
   * @return Whether the occupancyStatus field is set.
   */
  boolean hasOccupancyStatus();
  /**
   * <pre>
   * If multi_carriage_status is populated with per-carriage OccupancyStatus,
   * then this field should describe the entire vehicle with all carriages accepting passengers considered.
   * </pre>
   *
   * <code>optional .transit_realtime.VehiclePosition.OccupancyStatus occupancy_status = 9;</code>
   * @return The occupancyStatus.
   */
  com.google.transit.realtime.VehiclePosition.OccupancyStatus getOccupancyStatus();

  /**
   * <pre>
   * A percentage value indicating the degree of passenger occupancy in the vehicle.
   * The values are represented as an integer without decimals. 0 means 0% and 100 means 100%.
   * The value 100 should represent the total maximum occupancy the vehicle was designed for,
   * including both seated and standing capacity, and current operating regulations allow.
   * The value may exceed 100 if there are more passengers than the maximum designed capacity.
   * The precision of occupancy_percentage should be low enough that individual passengers cannot be tracked boarding or alighting the vehicle.
   * If multi_carriage_status is populated with per-carriage occupancy_percentage, 
   * then this field should describe the entire vehicle with all carriages accepting passengers considered.
   * This field is still experimental, and subject to change. It may be formally adopted in the future.
   * </pre>
   *
   * <code>optional uint32 occupancy_percentage = 10;</code>
   * @return Whether the occupancyPercentage field is set.
   */
  boolean hasOccupancyPercentage();
  /**
   * <pre>
   * A percentage value indicating the degree of passenger occupancy in the vehicle.
   * The values are represented as an integer without decimals. 0 means 0% and 100 means 100%.
   * The value 100 should represent the total maximum occupancy the vehicle was designed for,
   * including both seated and standing capacity, and current operating regulations allow.
   * The value may exceed 100 if there are more passengers than the maximum designed capacity.
   * The precision of occupancy_percentage should be low enough that individual passengers cannot be tracked boarding or alighting the vehicle.
   * If multi_carriage_status is populated with per-carriage occupancy_percentage, 
   * then this field should describe the entire vehicle with all carriages accepting passengers considered.
   * This field is still experimental, and subject to change. It may be formally adopted in the future.
   * </pre>
   *
   * <code>optional uint32 occupancy_percentage = 10;</code>
   * @return The occupancyPercentage.
   */
  int getOccupancyPercentage();

  /**
   * <pre>
   * Details of the multiple carriages of this given vehicle.
   * The first occurrence represents the first carriage of the vehicle, 
   * given the current direction of travel. 
   * The number of occurrences of the multi_carriage_details 
   * field represents the number of carriages of the vehicle.
   * It also includes non boardable carriages, 
   * like engines, maintenance carriages, etc… as they provide valuable 
   * information to passengers about where to stand on a platform.
   * This message/field is still experimental, and subject to change. It may be formally adopted in the future.
   * </pre>
   *
   * <code>repeated .transit_realtime.VehiclePosition.CarriageDetails multi_carriage_details = 11;</code>
   */
  java.util.List<com.google.transit.realtime.VehiclePosition.CarriageDetails> 
      getMultiCarriageDetailsList();
  /**
   * <pre>
   * Details of the multiple carriages of this given vehicle.
   * The first occurrence represents the first carriage of the vehicle, 
   * given the current direction of travel. 
   * The number of occurrences of the multi_carriage_details 
   * field represents the number of carriages of the vehicle.
   * It also includes non boardable carriages, 
   * like engines, maintenance carriages, etc… as they provide valuable 
   * information to passengers about where to stand on a platform.
   * This message/field is still experimental, and subject to change. It may be formally adopted in the future.
   * </pre>
   *
   * <code>repeated .transit_realtime.VehiclePosition.CarriageDetails multi_carriage_details = 11;</code>
   */
  com.google.transit.realtime.VehiclePosition.CarriageDetails getMultiCarriageDetails(int index);
  /**
   * <pre>
   * Details of the multiple carriages of this given vehicle.
   * The first occurrence represents the first carriage of the vehicle, 
   * given the current direction of travel. 
   * The number of occurrences of the multi_carriage_details 
   * field represents the number of carriages of the vehicle.
   * It also includes non boardable carriages, 
   * like engines, maintenance carriages, etc… as they provide valuable 
   * information to passengers about where to stand on a platform.
   * This message/field is still experimental, and subject to change. It may be formally adopted in the future.
   * </pre>
   *
   * <code>repeated .transit_realtime.VehiclePosition.CarriageDetails multi_carriage_details = 11;</code>
   */
  int getMultiCarriageDetailsCount();
  /**
   * <pre>
   * Details of the multiple carriages of this given vehicle.
   * The first occurrence represents the first carriage of the vehicle, 
   * given the current direction of travel. 
   * The number of occurrences of the multi_carriage_details 
   * field represents the number of carriages of the vehicle.
   * It also includes non boardable carriages, 
   * like engines, maintenance carriages, etc… as they provide valuable 
   * information to passengers about where to stand on a platform.
   * This message/field is still experimental, and subject to change. It may be formally adopted in the future.
   * </pre>
   *
   * <code>repeated .transit_realtime.VehiclePosition.CarriageDetails multi_carriage_details = 11;</code>
   */
  java.util.List<? extends com.google.transit.realtime.VehiclePosition.CarriageDetailsOrBuilder> 
      getMultiCarriageDetailsOrBuilderList();
  /**
   * <pre>
   * Details of the multiple carriages of this given vehicle.
   * The first occurrence represents the first carriage of the vehicle, 
   * given the current direction of travel. 
   * The number of occurrences of the multi_carriage_details 
   * field represents the number of carriages of the vehicle.
   * It also includes non boardable carriages, 
   * like engines, maintenance carriages, etc… as they provide valuable 
   * information to passengers about where to stand on a platform.
   * This message/field is still experimental, and subject to change. It may be formally adopted in the future.
   * </pre>
   *
   * <code>repeated .transit_realtime.VehiclePosition.CarriageDetails multi_carriage_details = 11;</code>
   */
  com.google.transit.realtime.VehiclePosition.CarriageDetailsOrBuilder getMultiCarriageDetailsOrBuilder(
      int index);
}
