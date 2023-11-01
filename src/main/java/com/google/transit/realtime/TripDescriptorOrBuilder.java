// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: main/resources/gtfs-realtime.proto

package com.google.transit.realtime;

public interface TripDescriptorOrBuilder extends
    // @@protoc_insertion_point(interface_extends:transit_realtime.TripDescriptor)
    com.google.protobuf.GeneratedMessageV3.
        ExtendableMessageOrBuilder<TripDescriptor> {

  /**
   * <pre>
   * The trip_id from the GTFS feed that this selector refers to.
   * For non frequency-based trips, this field is enough to uniquely identify
   * the trip. For frequency-based trip, start_time and start_date might also be
   * necessary. When schedule_relationship is DUPLICATED within a TripUpdate, the trip_id identifies the trip from
   * static GTFS to be duplicated. When schedule_relationship is DUPLICATED within a VehiclePosition, the trip_id
   * identifies the new duplicate trip and must contain the value for the corresponding TripUpdate.TripProperties.trip_id.
   * </pre>
   *
   * <code>optional string trip_id = 1;</code>
   * @return Whether the tripId field is set.
   */
  boolean hasTripId();
  /**
   * <pre>
   * The trip_id from the GTFS feed that this selector refers to.
   * For non frequency-based trips, this field is enough to uniquely identify
   * the trip. For frequency-based trip, start_time and start_date might also be
   * necessary. When schedule_relationship is DUPLICATED within a TripUpdate, the trip_id identifies the trip from
   * static GTFS to be duplicated. When schedule_relationship is DUPLICATED within a VehiclePosition, the trip_id
   * identifies the new duplicate trip and must contain the value for the corresponding TripUpdate.TripProperties.trip_id.
   * </pre>
   *
   * <code>optional string trip_id = 1;</code>
   * @return The tripId.
   */
  java.lang.String getTripId();
  /**
   * <pre>
   * The trip_id from the GTFS feed that this selector refers to.
   * For non frequency-based trips, this field is enough to uniquely identify
   * the trip. For frequency-based trip, start_time and start_date might also be
   * necessary. When schedule_relationship is DUPLICATED within a TripUpdate, the trip_id identifies the trip from
   * static GTFS to be duplicated. When schedule_relationship is DUPLICATED within a VehiclePosition, the trip_id
   * identifies the new duplicate trip and must contain the value for the corresponding TripUpdate.TripProperties.trip_id.
   * </pre>
   *
   * <code>optional string trip_id = 1;</code>
   * @return The bytes for tripId.
   */
  com.google.protobuf.ByteString
      getTripIdBytes();

  /**
   * <pre>
   * The route_id from the GTFS that this selector refers to.
   * </pre>
   *
   * <code>optional string route_id = 5;</code>
   * @return Whether the routeId field is set.
   */
  boolean hasRouteId();
  /**
   * <pre>
   * The route_id from the GTFS that this selector refers to.
   * </pre>
   *
   * <code>optional string route_id = 5;</code>
   * @return The routeId.
   */
  java.lang.String getRouteId();
  /**
   * <pre>
   * The route_id from the GTFS that this selector refers to.
   * </pre>
   *
   * <code>optional string route_id = 5;</code>
   * @return The bytes for routeId.
   */
  com.google.protobuf.ByteString
      getRouteIdBytes();

  /**
   * <pre>
   * The direction_id from the GTFS feed trips.txt file, indicating the
   * direction of travel for trips this selector refers to.
   * </pre>
   *
   * <code>optional uint32 direction_id = 6;</code>
   * @return Whether the directionId field is set.
   */
  boolean hasDirectionId();
  /**
   * <pre>
   * The direction_id from the GTFS feed trips.txt file, indicating the
   * direction of travel for trips this selector refers to.
   * </pre>
   *
   * <code>optional uint32 direction_id = 6;</code>
   * @return The directionId.
   */
  int getDirectionId();

  /**
   * <pre>
   * The initially scheduled start time of this trip instance.
   * When the trip_id corresponds to a non-frequency-based trip, this field
   * should either be omitted or be equal to the value in the GTFS feed. When
   * the trip_id correponds to a frequency-based trip, the start_time must be
   * specified for trip updates and vehicle positions. If the trip corresponds
   * to exact_times=1 GTFS record, then start_time must be some multiple
   * (including zero) of headway_secs later than frequencies.txt start_time for
   * the corresponding time period. If the trip corresponds to exact_times=0,
   * then its start_time may be arbitrary, and is initially expected to be the
   * first departure of the trip. Once established, the start_time of this
   * frequency-based trip should be considered immutable, even if the first
   * departure time changes -- that time change may instead be reflected in a
   * StopTimeUpdate.
   * Format and semantics of the field is same as that of
   * GTFS/frequencies.txt/start_time, e.g., 11:15:35 or 25:15:35.
   * </pre>
   *
   * <code>optional string start_time = 2;</code>
   * @return Whether the startTime field is set.
   */
  boolean hasStartTime();
  /**
   * <pre>
   * The initially scheduled start time of this trip instance.
   * When the trip_id corresponds to a non-frequency-based trip, this field
   * should either be omitted or be equal to the value in the GTFS feed. When
   * the trip_id correponds to a frequency-based trip, the start_time must be
   * specified for trip updates and vehicle positions. If the trip corresponds
   * to exact_times=1 GTFS record, then start_time must be some multiple
   * (including zero) of headway_secs later than frequencies.txt start_time for
   * the corresponding time period. If the trip corresponds to exact_times=0,
   * then its start_time may be arbitrary, and is initially expected to be the
   * first departure of the trip. Once established, the start_time of this
   * frequency-based trip should be considered immutable, even if the first
   * departure time changes -- that time change may instead be reflected in a
   * StopTimeUpdate.
   * Format and semantics of the field is same as that of
   * GTFS/frequencies.txt/start_time, e.g., 11:15:35 or 25:15:35.
   * </pre>
   *
   * <code>optional string start_time = 2;</code>
   * @return The startTime.
   */
  java.lang.String getStartTime();
  /**
   * <pre>
   * The initially scheduled start time of this trip instance.
   * When the trip_id corresponds to a non-frequency-based trip, this field
   * should either be omitted or be equal to the value in the GTFS feed. When
   * the trip_id correponds to a frequency-based trip, the start_time must be
   * specified for trip updates and vehicle positions. If the trip corresponds
   * to exact_times=1 GTFS record, then start_time must be some multiple
   * (including zero) of headway_secs later than frequencies.txt start_time for
   * the corresponding time period. If the trip corresponds to exact_times=0,
   * then its start_time may be arbitrary, and is initially expected to be the
   * first departure of the trip. Once established, the start_time of this
   * frequency-based trip should be considered immutable, even if the first
   * departure time changes -- that time change may instead be reflected in a
   * StopTimeUpdate.
   * Format and semantics of the field is same as that of
   * GTFS/frequencies.txt/start_time, e.g., 11:15:35 or 25:15:35.
   * </pre>
   *
   * <code>optional string start_time = 2;</code>
   * @return The bytes for startTime.
   */
  com.google.protobuf.ByteString
      getStartTimeBytes();

  /**
   * <pre>
   * The scheduled start date of this trip instance.
   * Must be provided to disambiguate trips that are so late as to collide with
   * a scheduled trip on a next day. For example, for a train that departs 8:00
   * and 20:00 every day, and is 12 hours late, there would be two distinct
   * trips on the same time.
   * This field can be provided but is not mandatory for schedules in which such
   * collisions are impossible - for example, a service running on hourly
   * schedule where a vehicle that is one hour late is not considered to be
   * related to schedule anymore.
   * In YYYYMMDD format.
   * </pre>
   *
   * <code>optional string start_date = 3;</code>
   * @return Whether the startDate field is set.
   */
  boolean hasStartDate();
  /**
   * <pre>
   * The scheduled start date of this trip instance.
   * Must be provided to disambiguate trips that are so late as to collide with
   * a scheduled trip on a next day. For example, for a train that departs 8:00
   * and 20:00 every day, and is 12 hours late, there would be two distinct
   * trips on the same time.
   * This field can be provided but is not mandatory for schedules in which such
   * collisions are impossible - for example, a service running on hourly
   * schedule where a vehicle that is one hour late is not considered to be
   * related to schedule anymore.
   * In YYYYMMDD format.
   * </pre>
   *
   * <code>optional string start_date = 3;</code>
   * @return The startDate.
   */
  java.lang.String getStartDate();
  /**
   * <pre>
   * The scheduled start date of this trip instance.
   * Must be provided to disambiguate trips that are so late as to collide with
   * a scheduled trip on a next day. For example, for a train that departs 8:00
   * and 20:00 every day, and is 12 hours late, there would be two distinct
   * trips on the same time.
   * This field can be provided but is not mandatory for schedules in which such
   * collisions are impossible - for example, a service running on hourly
   * schedule where a vehicle that is one hour late is not considered to be
   * related to schedule anymore.
   * In YYYYMMDD format.
   * </pre>
   *
   * <code>optional string start_date = 3;</code>
   * @return The bytes for startDate.
   */
  com.google.protobuf.ByteString
      getStartDateBytes();

  /**
   * <code>optional .transit_realtime.TripDescriptor.ScheduleRelationship schedule_relationship = 4;</code>
   * @return Whether the scheduleRelationship field is set.
   */
  boolean hasScheduleRelationship();
  /**
   * <code>optional .transit_realtime.TripDescriptor.ScheduleRelationship schedule_relationship = 4;</code>
   * @return The scheduleRelationship.
   */
  com.google.transit.realtime.TripDescriptor.ScheduleRelationship getScheduleRelationship();
}
