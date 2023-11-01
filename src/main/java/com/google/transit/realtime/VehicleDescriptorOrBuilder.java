// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: main/resources/gtfs-realtime.proto

package com.google.transit.realtime;

public interface VehicleDescriptorOrBuilder extends
    // @@protoc_insertion_point(interface_extends:transit_realtime.VehicleDescriptor)
    com.google.protobuf.GeneratedMessageV3.
        ExtendableMessageOrBuilder<VehicleDescriptor> {

  /**
   * <pre>
   * Internal system identification of the vehicle. Should be unique per
   * vehicle, and can be used for tracking the vehicle as it proceeds through
   * the system.
   * </pre>
   *
   * <code>optional string id = 1;</code>
   * @return Whether the id field is set.
   */
  boolean hasId();
  /**
   * <pre>
   * Internal system identification of the vehicle. Should be unique per
   * vehicle, and can be used for tracking the vehicle as it proceeds through
   * the system.
   * </pre>
   *
   * <code>optional string id = 1;</code>
   * @return The id.
   */
  java.lang.String getId();
  /**
   * <pre>
   * Internal system identification of the vehicle. Should be unique per
   * vehicle, and can be used for tracking the vehicle as it proceeds through
   * the system.
   * </pre>
   *
   * <code>optional string id = 1;</code>
   * @return The bytes for id.
   */
  com.google.protobuf.ByteString
      getIdBytes();

  /**
   * <pre>
   * User visible label, i.e., something that must be shown to the passenger to
   * help identify the correct vehicle.
   * </pre>
   *
   * <code>optional string label = 2;</code>
   * @return Whether the label field is set.
   */
  boolean hasLabel();
  /**
   * <pre>
   * User visible label, i.e., something that must be shown to the passenger to
   * help identify the correct vehicle.
   * </pre>
   *
   * <code>optional string label = 2;</code>
   * @return The label.
   */
  java.lang.String getLabel();
  /**
   * <pre>
   * User visible label, i.e., something that must be shown to the passenger to
   * help identify the correct vehicle.
   * </pre>
   *
   * <code>optional string label = 2;</code>
   * @return The bytes for label.
   */
  com.google.protobuf.ByteString
      getLabelBytes();

  /**
   * <pre>
   * The license plate of the vehicle.
   * </pre>
   *
   * <code>optional string license_plate = 3;</code>
   * @return Whether the licensePlate field is set.
   */
  boolean hasLicensePlate();
  /**
   * <pre>
   * The license plate of the vehicle.
   * </pre>
   *
   * <code>optional string license_plate = 3;</code>
   * @return The licensePlate.
   */
  java.lang.String getLicensePlate();
  /**
   * <pre>
   * The license plate of the vehicle.
   * </pre>
   *
   * <code>optional string license_plate = 3;</code>
   * @return The bytes for licensePlate.
   */
  com.google.protobuf.ByteString
      getLicensePlateBytes();

  /**
   * <code>optional .transit_realtime.VehicleDescriptor.WheelchairAccessible wheelchair_accessible = 4 [default = NO_VALUE];</code>
   * @return Whether the wheelchairAccessible field is set.
   */
  boolean hasWheelchairAccessible();
  /**
   * <code>optional .transit_realtime.VehicleDescriptor.WheelchairAccessible wheelchair_accessible = 4 [default = NO_VALUE];</code>
   * @return The wheelchairAccessible.
   */
  com.google.transit.realtime.VehicleDescriptor.WheelchairAccessible getWheelchairAccessible();
}