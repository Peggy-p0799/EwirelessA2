package com.example.a2_integration;

/** This class is compiled from the protobuf file and is used to write data from the sensors and
 *  trajectory from the PDR to the trajectory data structure. This data is then serialised to
 *  bytes using commands within this class, written to a local .bin file in the phone's local
 *  directory and then uploaded to the cloud API.
 *  Author: Thomas Harley
 */

public final class Traj {
  private Traj() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface TrajectoryOrBuilder extends
      // @@protoc_insertion_point(interface_extends:Trajectory)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>optional string android_version = 1;</code>
     */
    String getAndroidVersion();
    /**
     * <code>optional string android_version = 1;</code>
     */
    com.google.protobuf.ByteString
        getAndroidVersionBytes();

    /**
     * <code>repeated .Motion_Sample imu_data = 2;</code>
     */
    java.util.List<Motion_Sample>
        getImuDataList();
    /**
     * <code>repeated .Motion_Sample imu_data = 2;</code>
     */
    Motion_Sample getImuData(int index);
    /**
     * <code>repeated .Motion_Sample imu_data = 2;</code>
     */
    int getImuDataCount();
    /**
     * <code>repeated .Motion_Sample imu_data = 2;</code>
     */
    java.util.List<? extends Motion_SampleOrBuilder>
        getImuDataOrBuilderList();
    /**
     * <code>repeated .Motion_Sample imu_data = 2;</code>
     */
    Motion_SampleOrBuilder getImuDataOrBuilder(
        int index);

    /**
     * <code>repeated .Pdr_Sample pdr_data = 3;</code>
     */
    java.util.List<Pdr_Sample>
        getPdrDataList();
    /**
     * <code>repeated .Pdr_Sample pdr_data = 3;</code>
     */
    Pdr_Sample getPdrData(int index);
    /**
     * <code>repeated .Pdr_Sample pdr_data = 3;</code>
     */
    int getPdrDataCount();
    /**
     * <code>repeated .Pdr_Sample pdr_data = 3;</code>
     */
    java.util.List<? extends Pdr_SampleOrBuilder>
        getPdrDataOrBuilderList();
    /**
     * <code>repeated .Pdr_Sample pdr_data = 3;</code>
     */
    Pdr_SampleOrBuilder getPdrDataOrBuilder(
        int index);

    /**
     * <code>repeated .Position_Sample position_data = 4;</code>
     */
    java.util.List<Position_Sample>
        getPositionDataList();
    /**
     * <code>repeated .Position_Sample position_data = 4;</code>
     */
    Position_Sample getPositionData(int index);
    /**
     * <code>repeated .Position_Sample position_data = 4;</code>
     */
    int getPositionDataCount();
    /**
     * <code>repeated .Position_Sample position_data = 4;</code>
     */
    java.util.List<? extends Position_SampleOrBuilder>
        getPositionDataOrBuilderList();
    /**
     * <code>repeated .Position_Sample position_data = 4;</code>
     */
    Position_SampleOrBuilder getPositionDataOrBuilder(
        int index);

    /**
     * <code>repeated .Pressure_Sample pressure_data = 5;</code>
     */
    java.util.List<Pressure_Sample>
        getPressureDataList();
    /**
     * <code>repeated .Pressure_Sample pressure_data = 5;</code>
     */
    Pressure_Sample getPressureData(int index);
    /**
     * <code>repeated .Pressure_Sample pressure_data = 5;</code>
     */
    int getPressureDataCount();
    /**
     * <code>repeated .Pressure_Sample pressure_data = 5;</code>
     */
    java.util.List<? extends Pressure_SampleOrBuilder>
        getPressureDataOrBuilderList();
    /**
     * <code>repeated .Pressure_Sample pressure_data = 5;</code>
     */
    Pressure_SampleOrBuilder getPressureDataOrBuilder(
        int index);

    /**
     * <code>repeated .Light_Sample light_data = 6;</code>
     */
    java.util.List<Light_Sample>
        getLightDataList();
    /**
     * <code>repeated .Light_Sample light_data = 6;</code>
     */
    Light_Sample getLightData(int index);
    /**
     * <code>repeated .Light_Sample light_data = 6;</code>
     */
    int getLightDataCount();
    /**
     * <code>repeated .Light_Sample light_data = 6;</code>
     */
    java.util.List<? extends Light_SampleOrBuilder>
        getLightDataOrBuilderList();
    /**
     * <code>repeated .Light_Sample light_data = 6;</code>
     */
    Light_SampleOrBuilder getLightDataOrBuilder(
        int index);

    /**
     * <code>repeated .GNSS_Sample gnss_data = 7;</code>
     */
    java.util.List<GNSS_Sample>
        getGnssDataList();
    /**
     * <code>repeated .GNSS_Sample gnss_data = 7;</code>
     */
    GNSS_Sample getGnssData(int index);
    /**
     * <code>repeated .GNSS_Sample gnss_data = 7;</code>
     */
    int getGnssDataCount();
    /**
     * <code>repeated .GNSS_Sample gnss_data = 7;</code>
     */
    java.util.List<? extends GNSS_SampleOrBuilder>
        getGnssDataOrBuilderList();
    /**
     * <code>repeated .GNSS_Sample gnss_data = 7;</code>
     */
    GNSS_SampleOrBuilder getGnssDataOrBuilder(
        int index);

    /**
     * <code>repeated .WiFi_Sample wifi_data = 8;</code>
     */
    java.util.List<WiFi_Sample>
        getWifiDataList();
    /**
     * <code>repeated .WiFi_Sample wifi_data = 8;</code>
     */
    WiFi_Sample getWifiData(int index);
    /**
     * <code>repeated .WiFi_Sample wifi_data = 8;</code>
     */
    int getWifiDataCount();
    /**
     * <code>repeated .WiFi_Sample wifi_data = 8;</code>
     */
    java.util.List<? extends WiFi_SampleOrBuilder>
        getWifiDataOrBuilderList();
    /**
     * <code>repeated .WiFi_Sample wifi_data = 8;</code>
     */
    WiFi_SampleOrBuilder getWifiDataOrBuilder(
        int index);

    /**
     * <code>repeated .AP_Data aps_data = 9;</code>
     */
    java.util.List<AP_Data>
        getApsDataList();
    /**
     * <code>repeated .AP_Data aps_data = 9;</code>
     */
    AP_Data getApsData(int index);
    /**
     * <code>repeated .AP_Data aps_data = 9;</code>
     */
    int getApsDataCount();
    /**
     * <code>repeated .AP_Data aps_data = 9;</code>
     */
    java.util.List<? extends AP_DataOrBuilder>
        getApsDataOrBuilderList();
    /**
     * <code>repeated .AP_Data aps_data = 9;</code>
     */
    AP_DataOrBuilder getApsDataOrBuilder(
        int index);

    /**
     * <pre>
     * UNIX timestamp (in milliseconds) recorded from the start of this
     * trajectory data collection event. All future
     * timestamps in sub classes are to be RELATIVE timestamps
     * (in milliseconds) to this start time.
     * E.g.
     * start_timestamp = 1674819807315 (UTC 27 Jan 2023 in the morning)
     * relative_timestamp = 3000 (3s)
     * </pre>
     *
     * <code>optional int64 start_timestamp = 10;</code>
     */
    long getStartTimestamp();

    /**
     * <code>optional string data_identifier = 11;</code>
     */
    String getDataIdentifier();
    /**
     * <code>optional string data_identifier = 11;</code>
     */
    com.google.protobuf.ByteString
        getDataIdentifierBytes();

    /**
     * <code>optional .Sensor_Info accelerometer_info = 12;</code>
     */
    boolean hasAccelerometerInfo();
    /**
     * <code>optional .Sensor_Info accelerometer_info = 12;</code>
     */
    Sensor_Info getAccelerometerInfo();
    /**
     * <code>optional .Sensor_Info accelerometer_info = 12;</code>
     */
    Sensor_InfoOrBuilder getAccelerometerInfoOrBuilder();

    /**
     * <code>optional .Sensor_Info gyroscope_info = 13;</code>
     */
    boolean hasGyroscopeInfo();
    /**
     * <code>optional .Sensor_Info gyroscope_info = 13;</code>
     */
    Sensor_Info getGyroscopeInfo();
    /**
     * <code>optional .Sensor_Info gyroscope_info = 13;</code>
     */
    Sensor_InfoOrBuilder getGyroscopeInfoOrBuilder();

    /**
     * <code>optional .Sensor_Info rotation_vector_info = 14;</code>
     */
    boolean hasRotationVectorInfo();
    /**
     * <code>optional .Sensor_Info rotation_vector_info = 14;</code>
     */
    Sensor_Info getRotationVectorInfo();
    /**
     * <code>optional .Sensor_Info rotation_vector_info = 14;</code>
     */
    Sensor_InfoOrBuilder getRotationVectorInfoOrBuilder();

    /**
     * <code>optional .Sensor_Info magnetometer_info = 15;</code>
     */
    boolean hasMagnetometerInfo();
    /**
     * <code>optional .Sensor_Info magnetometer_info = 15;</code>
     */
    Sensor_Info getMagnetometerInfo();
    /**
     * <code>optional .Sensor_Info magnetometer_info = 15;</code>
     */
    Sensor_InfoOrBuilder getMagnetometerInfoOrBuilder();

    /**
     * <code>optional .Sensor_Info barometer_info = 16;</code>
     */
    boolean hasBarometerInfo();
    /**
     * <code>optional .Sensor_Info barometer_info = 16;</code>
     */
    Sensor_Info getBarometerInfo();
    /**
     * <code>optional .Sensor_Info barometer_info = 16;</code>
     */
    Sensor_InfoOrBuilder getBarometerInfoOrBuilder();

    /**
     * <code>optional .Sensor_Info light_sensor_info = 17;</code>
     */
    boolean hasLightSensorInfo();
    /**
     * <code>optional .Sensor_Info light_sensor_info = 17;</code>
     */
    Sensor_Info getLightSensorInfo();
    /**
     * <code>optional .Sensor_Info light_sensor_info = 17;</code>
     */
    Sensor_InfoOrBuilder getLightSensorInfoOrBuilder();
  }
  /**
   * Protobuf type {@code Trajectory}
   */
  public  static final class Trajectory extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:Trajectory)
      TrajectoryOrBuilder {
    // Use Trajectory.newBuilder() to construct.
    private Trajectory(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private Trajectory() {
      androidVersion_ = "";
      imuData_ = java.util.Collections.emptyList();
      pdrData_ = java.util.Collections.emptyList();
      positionData_ = java.util.Collections.emptyList();
      pressureData_ = java.util.Collections.emptyList();
      lightData_ = java.util.Collections.emptyList();
      gnssData_ = java.util.Collections.emptyList();
      wifiData_ = java.util.Collections.emptyList();
      apsData_ = java.util.Collections.emptyList();
      startTimestamp_ = 0L;
      dataIdentifier_ = "";
    }

    @Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
    }
    private Trajectory(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      int mutable_bitField0_ = 0;
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!input.skipField(tag)) {
                done = true;
              }
              break;
            }
            case 10: {
              String s = input.readStringRequireUtf8();

              androidVersion_ = s;
              break;
            }
            case 18: {
              if (!((mutable_bitField0_ & 0x00000002) == 0x00000002)) {
                imuData_ = new java.util.ArrayList<Motion_Sample>();
                mutable_bitField0_ |= 0x00000002;
              }
              imuData_.add(
                  input.readMessage(Motion_Sample.parser(), extensionRegistry));
              break;
            }
            case 26: {
              if (!((mutable_bitField0_ & 0x00000004) == 0x00000004)) {
                pdrData_ = new java.util.ArrayList<Pdr_Sample>();
                mutable_bitField0_ |= 0x00000004;
              }
              pdrData_.add(
                  input.readMessage(Pdr_Sample.parser(), extensionRegistry));
              break;
            }
            case 34: {
              if (!((mutable_bitField0_ & 0x00000008) == 0x00000008)) {
                positionData_ = new java.util.ArrayList<Position_Sample>();
                mutable_bitField0_ |= 0x00000008;
              }
              positionData_.add(
                  input.readMessage(Position_Sample.parser(), extensionRegistry));
              break;
            }
            case 42: {
              if (!((mutable_bitField0_ & 0x00000010) == 0x00000010)) {
                pressureData_ = new java.util.ArrayList<Pressure_Sample>();
                mutable_bitField0_ |= 0x00000010;
              }
              pressureData_.add(
                  input.readMessage(Pressure_Sample.parser(), extensionRegistry));
              break;
            }
            case 50: {
              if (!((mutable_bitField0_ & 0x00000020) == 0x00000020)) {
                lightData_ = new java.util.ArrayList<Light_Sample>();
                mutable_bitField0_ |= 0x00000020;
              }
              lightData_.add(
                  input.readMessage(Light_Sample.parser(), extensionRegistry));
              break;
            }
            case 58: {
              if (!((mutable_bitField0_ & 0x00000040) == 0x00000040)) {
                gnssData_ = new java.util.ArrayList<GNSS_Sample>();
                mutable_bitField0_ |= 0x00000040;
              }
              gnssData_.add(
                  input.readMessage(GNSS_Sample.parser(), extensionRegistry));
              break;
            }
            case 66: {
              if (!((mutable_bitField0_ & 0x00000080) == 0x00000080)) {
                wifiData_ = new java.util.ArrayList<WiFi_Sample>();
                mutable_bitField0_ |= 0x00000080;
              }
              wifiData_.add(
                  input.readMessage(WiFi_Sample.parser(), extensionRegistry));
              break;
            }
            case 74: {
              if (!((mutable_bitField0_ & 0x00000100) == 0x00000100)) {
                apsData_ = new java.util.ArrayList<AP_Data>();
                mutable_bitField0_ |= 0x00000100;
              }
              apsData_.add(
                  input.readMessage(AP_Data.parser(), extensionRegistry));
              break;
            }
            case 80: {

              startTimestamp_ = input.readInt64();
              break;
            }
            case 90: {
              String s = input.readStringRequireUtf8();

              dataIdentifier_ = s;
              break;
            }
            case 98: {
              Sensor_Info.Builder subBuilder = null;
              if (accelerometerInfo_ != null) {
                subBuilder = accelerometerInfo_.toBuilder();
              }
              accelerometerInfo_ = input.readMessage(Sensor_Info.parser(), extensionRegistry);
              if (subBuilder != null) {
                subBuilder.mergeFrom(accelerometerInfo_);
                accelerometerInfo_ = subBuilder.buildPartial();
              }

              break;
            }
            case 106: {
              Sensor_Info.Builder subBuilder = null;
              if (gyroscopeInfo_ != null) {
                subBuilder = gyroscopeInfo_.toBuilder();
              }
              gyroscopeInfo_ = input.readMessage(Sensor_Info.parser(), extensionRegistry);
              if (subBuilder != null) {
                subBuilder.mergeFrom(gyroscopeInfo_);
                gyroscopeInfo_ = subBuilder.buildPartial();
              }

              break;
            }
            case 114: {
              Sensor_Info.Builder subBuilder = null;
              if (rotationVectorInfo_ != null) {
                subBuilder = rotationVectorInfo_.toBuilder();
              }
              rotationVectorInfo_ = input.readMessage(Sensor_Info.parser(), extensionRegistry);
              if (subBuilder != null) {
                subBuilder.mergeFrom(rotationVectorInfo_);
                rotationVectorInfo_ = subBuilder.buildPartial();
              }

              break;
            }
            case 122: {
              Sensor_Info.Builder subBuilder = null;
              if (magnetometerInfo_ != null) {
                subBuilder = magnetometerInfo_.toBuilder();
              }
              magnetometerInfo_ = input.readMessage(Sensor_Info.parser(), extensionRegistry);
              if (subBuilder != null) {
                subBuilder.mergeFrom(magnetometerInfo_);
                magnetometerInfo_ = subBuilder.buildPartial();
              }

              break;
            }
            case 130: {
              Sensor_Info.Builder subBuilder = null;
              if (barometerInfo_ != null) {
                subBuilder = barometerInfo_.toBuilder();
              }
              barometerInfo_ = input.readMessage(Sensor_Info.parser(), extensionRegistry);
              if (subBuilder != null) {
                subBuilder.mergeFrom(barometerInfo_);
                barometerInfo_ = subBuilder.buildPartial();
              }

              break;
            }
            case 138: {
              Sensor_Info.Builder subBuilder = null;
              if (lightSensorInfo_ != null) {
                subBuilder = lightSensorInfo_.toBuilder();
              }
              lightSensorInfo_ = input.readMessage(Sensor_Info.parser(), extensionRegistry);
              if (subBuilder != null) {
                subBuilder.mergeFrom(lightSensorInfo_);
                lightSensorInfo_ = subBuilder.buildPartial();
              }

              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        if (((mutable_bitField0_ & 0x00000002) == 0x00000002)) {
          imuData_ = java.util.Collections.unmodifiableList(imuData_);
        }
        if (((mutable_bitField0_ & 0x00000004) == 0x00000004)) {
          pdrData_ = java.util.Collections.unmodifiableList(pdrData_);
        }
        if (((mutable_bitField0_ & 0x00000008) == 0x00000008)) {
          positionData_ = java.util.Collections.unmodifiableList(positionData_);
        }
        if (((mutable_bitField0_ & 0x00000010) == 0x00000010)) {
          pressureData_ = java.util.Collections.unmodifiableList(pressureData_);
        }
        if (((mutable_bitField0_ & 0x00000020) == 0x00000020)) {
          lightData_ = java.util.Collections.unmodifiableList(lightData_);
        }
        if (((mutable_bitField0_ & 0x00000040) == 0x00000040)) {
          gnssData_ = java.util.Collections.unmodifiableList(gnssData_);
        }
        if (((mutable_bitField0_ & 0x00000080) == 0x00000080)) {
          wifiData_ = java.util.Collections.unmodifiableList(wifiData_);
        }
        if (((mutable_bitField0_ & 0x00000100) == 0x00000100)) {
          apsData_ = java.util.Collections.unmodifiableList(apsData_);
        }
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return Traj.internal_static_Trajectory_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return Traj.internal_static_Trajectory_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              Trajectory.class, Builder.class);
    }

    private int bitField0_;
    public static final int ANDROID_VERSION_FIELD_NUMBER = 1;
    private volatile Object androidVersion_;
    /**
     * <code>optional string android_version = 1;</code>
     */
    public String getAndroidVersion() {
      Object ref = androidVersion_;
      if (ref instanceof String) {
        return (String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        androidVersion_ = s;
        return s;
      }
    }
    /**
     * <code>optional string android_version = 1;</code>
     */
    public com.google.protobuf.ByteString
        getAndroidVersionBytes() {
      Object ref = androidVersion_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        androidVersion_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int IMU_DATA_FIELD_NUMBER = 2;
    private java.util.List<Motion_Sample> imuData_;
    /**
     * <code>repeated .Motion_Sample imu_data = 2;</code>
     */
    public java.util.List<Motion_Sample> getImuDataList() {
      return imuData_;
    }
    /**
     * <code>repeated .Motion_Sample imu_data = 2;</code>
     */
    public java.util.List<? extends Motion_SampleOrBuilder>
        getImuDataOrBuilderList() {
      return imuData_;
    }
    /**
     * <code>repeated .Motion_Sample imu_data = 2;</code>
     */
    public int getImuDataCount() {
      return imuData_.size();
    }
    /**
     * <code>repeated .Motion_Sample imu_data = 2;</code>
     */
    public Motion_Sample getImuData(int index) {
      return imuData_.get(index);
    }
    /**
     * <code>repeated .Motion_Sample imu_data = 2;</code>
     */
    public Motion_SampleOrBuilder getImuDataOrBuilder(
        int index) {
      return imuData_.get(index);
    }

    public static final int PDR_DATA_FIELD_NUMBER = 3;
    private java.util.List<Pdr_Sample> pdrData_;
    /**
     * <code>repeated .Pdr_Sample pdr_data = 3;</code>
     */
    public java.util.List<Pdr_Sample> getPdrDataList() {
      return pdrData_;
    }
    /**
     * <code>repeated .Pdr_Sample pdr_data = 3;</code>
     */
    public java.util.List<? extends Pdr_SampleOrBuilder>
        getPdrDataOrBuilderList() {
      return pdrData_;
    }
    /**
     * <code>repeated .Pdr_Sample pdr_data = 3;</code>
     */
    public int getPdrDataCount() {
      return pdrData_.size();
    }
    /**
     * <code>repeated .Pdr_Sample pdr_data = 3;</code>
     */
    public Pdr_Sample getPdrData(int index) {
      return pdrData_.get(index);
    }
    /**
     * <code>repeated .Pdr_Sample pdr_data = 3;</code>
     */
    public Pdr_SampleOrBuilder getPdrDataOrBuilder(
        int index) {
      return pdrData_.get(index);
    }

    public static final int POSITION_DATA_FIELD_NUMBER = 4;
    private java.util.List<Position_Sample> positionData_;
    /**
     * <code>repeated .Position_Sample position_data = 4;</code>
     */
    public java.util.List<Position_Sample> getPositionDataList() {
      return positionData_;
    }
    /**
     * <code>repeated .Position_Sample position_data = 4;</code>
     */
    public java.util.List<? extends Position_SampleOrBuilder>
        getPositionDataOrBuilderList() {
      return positionData_;
    }
    /**
     * <code>repeated .Position_Sample position_data = 4;</code>
     */
    public int getPositionDataCount() {
      return positionData_.size();
    }
    /**
     * <code>repeated .Position_Sample position_data = 4;</code>
     */
    public Position_Sample getPositionData(int index) {
      return positionData_.get(index);
    }
    /**
     * <code>repeated .Position_Sample position_data = 4;</code>
     */
    public Position_SampleOrBuilder getPositionDataOrBuilder(
        int index) {
      return positionData_.get(index);
    }

    public static final int PRESSURE_DATA_FIELD_NUMBER = 5;
    private java.util.List<Pressure_Sample> pressureData_;
    /**
     * <code>repeated .Pressure_Sample pressure_data = 5;</code>
     */
    public java.util.List<Pressure_Sample> getPressureDataList() {
      return pressureData_;
    }
    /**
     * <code>repeated .Pressure_Sample pressure_data = 5;</code>
     */
    public java.util.List<? extends Pressure_SampleOrBuilder>
        getPressureDataOrBuilderList() {
      return pressureData_;
    }
    /**
     * <code>repeated .Pressure_Sample pressure_data = 5;</code>
     */
    public int getPressureDataCount() {
      return pressureData_.size();
    }
    /**
     * <code>repeated .Pressure_Sample pressure_data = 5;</code>
     */
    public Pressure_Sample getPressureData(int index) {
      return pressureData_.get(index);
    }
    /**
     * <code>repeated .Pressure_Sample pressure_data = 5;</code>
     */
    public Pressure_SampleOrBuilder getPressureDataOrBuilder(
        int index) {
      return pressureData_.get(index);
    }

    public static final int LIGHT_DATA_FIELD_NUMBER = 6;
    private java.util.List<Light_Sample> lightData_;
    /**
     * <code>repeated .Light_Sample light_data = 6;</code>
     */
    public java.util.List<Light_Sample> getLightDataList() {
      return lightData_;
    }
    /**
     * <code>repeated .Light_Sample light_data = 6;</code>
     */
    public java.util.List<? extends Light_SampleOrBuilder>
        getLightDataOrBuilderList() {
      return lightData_;
    }
    /**
     * <code>repeated .Light_Sample light_data = 6;</code>
     */
    public int getLightDataCount() {
      return lightData_.size();
    }
    /**
     * <code>repeated .Light_Sample light_data = 6;</code>
     */
    public Light_Sample getLightData(int index) {
      return lightData_.get(index);
    }
    /**
     * <code>repeated .Light_Sample light_data = 6;</code>
     */
    public Light_SampleOrBuilder getLightDataOrBuilder(
        int index) {
      return lightData_.get(index);
    }

    public static final int GNSS_DATA_FIELD_NUMBER = 7;
    private java.util.List<GNSS_Sample> gnssData_;
    /**
     * <code>repeated .GNSS_Sample gnss_data = 7;</code>
     */
    public java.util.List<GNSS_Sample> getGnssDataList() {
      return gnssData_;
    }
    /**
     * <code>repeated .GNSS_Sample gnss_data = 7;</code>
     */
    public java.util.List<? extends GNSS_SampleOrBuilder>
        getGnssDataOrBuilderList() {
      return gnssData_;
    }
    /**
     * <code>repeated .GNSS_Sample gnss_data = 7;</code>
     */
    public int getGnssDataCount() {
      return gnssData_.size();
    }
    /**
     * <code>repeated .GNSS_Sample gnss_data = 7;</code>
     */
    public GNSS_Sample getGnssData(int index) {
      return gnssData_.get(index);
    }
    /**
     * <code>repeated .GNSS_Sample gnss_data = 7;</code>
     */
    public GNSS_SampleOrBuilder getGnssDataOrBuilder(
        int index) {
      return gnssData_.get(index);
    }

    public static final int WIFI_DATA_FIELD_NUMBER = 8;
    private java.util.List<WiFi_Sample> wifiData_;
    /**
     * <code>repeated .WiFi_Sample wifi_data = 8;</code>
     */
    public java.util.List<WiFi_Sample> getWifiDataList() {
      return wifiData_;
    }
    /**
     * <code>repeated .WiFi_Sample wifi_data = 8;</code>
     */
    public java.util.List<? extends WiFi_SampleOrBuilder>
        getWifiDataOrBuilderList() {
      return wifiData_;
    }
    /**
     * <code>repeated .WiFi_Sample wifi_data = 8;</code>
     */
    public int getWifiDataCount() {
      return wifiData_.size();
    }
    /**
     * <code>repeated .WiFi_Sample wifi_data = 8;</code>
     */
    public WiFi_Sample getWifiData(int index) {
      return wifiData_.get(index);
    }
    /**
     * <code>repeated .WiFi_Sample wifi_data = 8;</code>
     */
    public WiFi_SampleOrBuilder getWifiDataOrBuilder(
        int index) {
      return wifiData_.get(index);
    }

    public static final int APS_DATA_FIELD_NUMBER = 9;
    private java.util.List<AP_Data> apsData_;
    /**
     * <code>repeated .AP_Data aps_data = 9;</code>
     */
    public java.util.List<AP_Data> getApsDataList() {
      return apsData_;
    }
    /**
     * <code>repeated .AP_Data aps_data = 9;</code>
     */
    public java.util.List<? extends AP_DataOrBuilder>
        getApsDataOrBuilderList() {
      return apsData_;
    }
    /**
     * <code>repeated .AP_Data aps_data = 9;</code>
     */
    public int getApsDataCount() {
      return apsData_.size();
    }
    /**
     * <code>repeated .AP_Data aps_data = 9;</code>
     */
    public AP_Data getApsData(int index) {
      return apsData_.get(index);
    }
    /**
     * <code>repeated .AP_Data aps_data = 9;</code>
     */
    public AP_DataOrBuilder getApsDataOrBuilder(
        int index) {
      return apsData_.get(index);
    }

    public static final int START_TIMESTAMP_FIELD_NUMBER = 10;
    private long startTimestamp_;
    /**
     * <pre>
     * UNIX timestamp (in milliseconds) recorded from the start of this
     * trajectory data collection event. All future
     * timestamps in sub classes are to be RELATIVE timestamps
     * (in milliseconds) to this start time.
     * E.g.
     * start_timestamp = 1674819807315 (UTC 27 Jan 2023 in the morning)
     * relative_timestamp = 3000 (3s)
     * </pre>
     *
     * <code>optional int64 start_timestamp = 10;</code>
     */
    public long getStartTimestamp() {
      return startTimestamp_;
    }

    public static final int DATA_IDENTIFIER_FIELD_NUMBER = 11;
    private volatile Object dataIdentifier_;
    /**
     * <code>optional string data_identifier = 11;</code>
     */
    public String getDataIdentifier() {
      Object ref = dataIdentifier_;
      if (ref instanceof String) {
        return (String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        dataIdentifier_ = s;
        return s;
      }
    }
    /**
     * <code>optional string data_identifier = 11;</code>
     */
    public com.google.protobuf.ByteString
        getDataIdentifierBytes() {
      Object ref = dataIdentifier_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        dataIdentifier_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int ACCELEROMETER_INFO_FIELD_NUMBER = 12;
    private Sensor_Info accelerometerInfo_;
    /**
     * <code>optional .Sensor_Info accelerometer_info = 12;</code>
     */
    public boolean hasAccelerometerInfo() {
      return accelerometerInfo_ != null;
    }
    /**
     * <code>optional .Sensor_Info accelerometer_info = 12;</code>
     */
    public Sensor_Info getAccelerometerInfo() {
      return accelerometerInfo_ == null ? Sensor_Info.getDefaultInstance() : accelerometerInfo_;
    }
    /**
     * <code>optional .Sensor_Info accelerometer_info = 12;</code>
     */
    public Sensor_InfoOrBuilder getAccelerometerInfoOrBuilder() {
      return getAccelerometerInfo();
    }

    public static final int GYROSCOPE_INFO_FIELD_NUMBER = 13;
    private Sensor_Info gyroscopeInfo_;
    /**
     * <code>optional .Sensor_Info gyroscope_info = 13;</code>
     */
    public boolean hasGyroscopeInfo() {
      return gyroscopeInfo_ != null;
    }
    /**
     * <code>optional .Sensor_Info gyroscope_info = 13;</code>
     */
    public Sensor_Info getGyroscopeInfo() {
      return gyroscopeInfo_ == null ? Sensor_Info.getDefaultInstance() : gyroscopeInfo_;
    }
    /**
     * <code>optional .Sensor_Info gyroscope_info = 13;</code>
     */
    public Sensor_InfoOrBuilder getGyroscopeInfoOrBuilder() {
      return getGyroscopeInfo();
    }

    public static final int ROTATION_VECTOR_INFO_FIELD_NUMBER = 14;
    private Sensor_Info rotationVectorInfo_;
    /**
     * <code>optional .Sensor_Info rotation_vector_info = 14;</code>
     */
    public boolean hasRotationVectorInfo() {
      return rotationVectorInfo_ != null;
    }
    /**
     * <code>optional .Sensor_Info rotation_vector_info = 14;</code>
     */
    public Sensor_Info getRotationVectorInfo() {
      return rotationVectorInfo_ == null ? Sensor_Info.getDefaultInstance() : rotationVectorInfo_;
    }
    /**
     * <code>optional .Sensor_Info rotation_vector_info = 14;</code>
     */
    public Sensor_InfoOrBuilder getRotationVectorInfoOrBuilder() {
      return getRotationVectorInfo();
    }

    public static final int MAGNETOMETER_INFO_FIELD_NUMBER = 15;
    private Sensor_Info magnetometerInfo_;
    /**
     * <code>optional .Sensor_Info magnetometer_info = 15;</code>
     */
    public boolean hasMagnetometerInfo() {
      return magnetometerInfo_ != null;
    }
    /**
     * <code>optional .Sensor_Info magnetometer_info = 15;</code>
     */
    public Sensor_Info getMagnetometerInfo() {
      return magnetometerInfo_ == null ? Sensor_Info.getDefaultInstance() : magnetometerInfo_;
    }
    /**
     * <code>optional .Sensor_Info magnetometer_info = 15;</code>
     */
    public Sensor_InfoOrBuilder getMagnetometerInfoOrBuilder() {
      return getMagnetometerInfo();
    }

    public static final int BAROMETER_INFO_FIELD_NUMBER = 16;
    private Sensor_Info barometerInfo_;
    /**
     * <code>optional .Sensor_Info barometer_info = 16;</code>
     */
    public boolean hasBarometerInfo() {
      return barometerInfo_ != null;
    }
    /**
     * <code>optional .Sensor_Info barometer_info = 16;</code>
     */
    public Sensor_Info getBarometerInfo() {
      return barometerInfo_ == null ? Sensor_Info.getDefaultInstance() : barometerInfo_;
    }
    /**
     * <code>optional .Sensor_Info barometer_info = 16;</code>
     */
    public Sensor_InfoOrBuilder getBarometerInfoOrBuilder() {
      return getBarometerInfo();
    }

    public static final int LIGHT_SENSOR_INFO_FIELD_NUMBER = 17;
    private Sensor_Info lightSensorInfo_;
    /**
     * <code>optional .Sensor_Info light_sensor_info = 17;</code>
     */
    public boolean hasLightSensorInfo() {
      return lightSensorInfo_ != null;
    }
    /**
     * <code>optional .Sensor_Info light_sensor_info = 17;</code>
     */
    public Sensor_Info getLightSensorInfo() {
      return lightSensorInfo_ == null ? Sensor_Info.getDefaultInstance() : lightSensorInfo_;
    }
    /**
     * <code>optional .Sensor_Info light_sensor_info = 17;</code>
     */
    public Sensor_InfoOrBuilder getLightSensorInfoOrBuilder() {
      return getLightSensorInfo();
    }

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (!getAndroidVersionBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 1, androidVersion_);
      }
      for (int i = 0; i < imuData_.size(); i++) {
        output.writeMessage(2, imuData_.get(i));
      }
      for (int i = 0; i < pdrData_.size(); i++) {
        output.writeMessage(3, pdrData_.get(i));
      }
      for (int i = 0; i < positionData_.size(); i++) {
        output.writeMessage(4, positionData_.get(i));
      }
      for (int i = 0; i < pressureData_.size(); i++) {
        output.writeMessage(5, pressureData_.get(i));
      }
      for (int i = 0; i < lightData_.size(); i++) {
        output.writeMessage(6, lightData_.get(i));
      }
      for (int i = 0; i < gnssData_.size(); i++) {
        output.writeMessage(7, gnssData_.get(i));
      }
      for (int i = 0; i < wifiData_.size(); i++) {
        output.writeMessage(8, wifiData_.get(i));
      }
      for (int i = 0; i < apsData_.size(); i++) {
        output.writeMessage(9, apsData_.get(i));
      }
      if (startTimestamp_ != 0L) {
        output.writeInt64(10, startTimestamp_);
      }
      if (!getDataIdentifierBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 11, dataIdentifier_);
      }
      if (accelerometerInfo_ != null) {
        output.writeMessage(12, getAccelerometerInfo());
      }
      if (gyroscopeInfo_ != null) {
        output.writeMessage(13, getGyroscopeInfo());
      }
      if (rotationVectorInfo_ != null) {
        output.writeMessage(14, getRotationVectorInfo());
      }
      if (magnetometerInfo_ != null) {
        output.writeMessage(15, getMagnetometerInfo());
      }
      if (barometerInfo_ != null) {
        output.writeMessage(16, getBarometerInfo());
      }
      if (lightSensorInfo_ != null) {
        output.writeMessage(17, getLightSensorInfo());
      }
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (!getAndroidVersionBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, androidVersion_);
      }
      for (int i = 0; i < imuData_.size(); i++) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(2, imuData_.get(i));
      }
      for (int i = 0; i < pdrData_.size(); i++) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(3, pdrData_.get(i));
      }
      for (int i = 0; i < positionData_.size(); i++) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(4, positionData_.get(i));
      }
      for (int i = 0; i < pressureData_.size(); i++) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(5, pressureData_.get(i));
      }
      for (int i = 0; i < lightData_.size(); i++) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(6, lightData_.get(i));
      }
      for (int i = 0; i < gnssData_.size(); i++) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(7, gnssData_.get(i));
      }
      for (int i = 0; i < wifiData_.size(); i++) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(8, wifiData_.get(i));
      }
      for (int i = 0; i < apsData_.size(); i++) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(9, apsData_.get(i));
      }
      if (startTimestamp_ != 0L) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt64Size(10, startTimestamp_);
      }
      if (!getDataIdentifierBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(11, dataIdentifier_);
      }
      if (accelerometerInfo_ != null) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(12, getAccelerometerInfo());
      }
      if (gyroscopeInfo_ != null) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(13, getGyroscopeInfo());
      }
      if (rotationVectorInfo_ != null) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(14, getRotationVectorInfo());
      }
      if (magnetometerInfo_ != null) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(15, getMagnetometerInfo());
      }
      if (barometerInfo_ != null) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(16, getBarometerInfo());
      }
      if (lightSensorInfo_ != null) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(17, getLightSensorInfo());
      }
      memoizedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @Override
    public boolean equals(final Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof Trajectory)) {
        return super.equals(obj);
      }
      Trajectory other = (Trajectory) obj;

      boolean result = true;
      result = result && getAndroidVersion()
          .equals(other.getAndroidVersion());
      result = result && getImuDataList()
          .equals(other.getImuDataList());
      result = result && getPdrDataList()
          .equals(other.getPdrDataList());
      result = result && getPositionDataList()
          .equals(other.getPositionDataList());
      result = result && getPressureDataList()
          .equals(other.getPressureDataList());
      result = result && getLightDataList()
          .equals(other.getLightDataList());
      result = result && getGnssDataList()
          .equals(other.getGnssDataList());
      result = result && getWifiDataList()
          .equals(other.getWifiDataList());
      result = result && getApsDataList()
          .equals(other.getApsDataList());
      result = result && (getStartTimestamp()
          == other.getStartTimestamp());
      result = result && getDataIdentifier()
          .equals(other.getDataIdentifier());
      result = result && (hasAccelerometerInfo() == other.hasAccelerometerInfo());
      if (hasAccelerometerInfo()) {
        result = result && getAccelerometerInfo()
            .equals(other.getAccelerometerInfo());
      }
      result = result && (hasGyroscopeInfo() == other.hasGyroscopeInfo());
      if (hasGyroscopeInfo()) {
        result = result && getGyroscopeInfo()
            .equals(other.getGyroscopeInfo());
      }
      result = result && (hasRotationVectorInfo() == other.hasRotationVectorInfo());
      if (hasRotationVectorInfo()) {
        result = result && getRotationVectorInfo()
            .equals(other.getRotationVectorInfo());
      }
      result = result && (hasMagnetometerInfo() == other.hasMagnetometerInfo());
      if (hasMagnetometerInfo()) {
        result = result && getMagnetometerInfo()
            .equals(other.getMagnetometerInfo());
      }
      result = result && (hasBarometerInfo() == other.hasBarometerInfo());
      if (hasBarometerInfo()) {
        result = result && getBarometerInfo()
            .equals(other.getBarometerInfo());
      }
      result = result && (hasLightSensorInfo() == other.hasLightSensorInfo());
      if (hasLightSensorInfo()) {
        result = result && getLightSensorInfo()
            .equals(other.getLightSensorInfo());
      }
      return result;
    }

    @Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptorForType().hashCode();
      hash = (37 * hash) + ANDROID_VERSION_FIELD_NUMBER;
      hash = (53 * hash) + getAndroidVersion().hashCode();
      if (getImuDataCount() > 0) {
        hash = (37 * hash) + IMU_DATA_FIELD_NUMBER;
        hash = (53 * hash) + getImuDataList().hashCode();
      }
      if (getPdrDataCount() > 0) {
        hash = (37 * hash) + PDR_DATA_FIELD_NUMBER;
        hash = (53 * hash) + getPdrDataList().hashCode();
      }
      if (getPositionDataCount() > 0) {
        hash = (37 * hash) + POSITION_DATA_FIELD_NUMBER;
        hash = (53 * hash) + getPositionDataList().hashCode();
      }
      if (getPressureDataCount() > 0) {
        hash = (37 * hash) + PRESSURE_DATA_FIELD_NUMBER;
        hash = (53 * hash) + getPressureDataList().hashCode();
      }
      if (getLightDataCount() > 0) {
        hash = (37 * hash) + LIGHT_DATA_FIELD_NUMBER;
        hash = (53 * hash) + getLightDataList().hashCode();
      }
      if (getGnssDataCount() > 0) {
        hash = (37 * hash) + GNSS_DATA_FIELD_NUMBER;
        hash = (53 * hash) + getGnssDataList().hashCode();
      }
      if (getWifiDataCount() > 0) {
        hash = (37 * hash) + WIFI_DATA_FIELD_NUMBER;
        hash = (53 * hash) + getWifiDataList().hashCode();
      }
      if (getApsDataCount() > 0) {
        hash = (37 * hash) + APS_DATA_FIELD_NUMBER;
        hash = (53 * hash) + getApsDataList().hashCode();
      }
      hash = (37 * hash) + START_TIMESTAMP_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          getStartTimestamp());
      hash = (37 * hash) + DATA_IDENTIFIER_FIELD_NUMBER;
      hash = (53 * hash) + getDataIdentifier().hashCode();
      if (hasAccelerometerInfo()) {
        hash = (37 * hash) + ACCELEROMETER_INFO_FIELD_NUMBER;
        hash = (53 * hash) + getAccelerometerInfo().hashCode();
      }
      if (hasGyroscopeInfo()) {
        hash = (37 * hash) + GYROSCOPE_INFO_FIELD_NUMBER;
        hash = (53 * hash) + getGyroscopeInfo().hashCode();
      }
      if (hasRotationVectorInfo()) {
        hash = (37 * hash) + ROTATION_VECTOR_INFO_FIELD_NUMBER;
        hash = (53 * hash) + getRotationVectorInfo().hashCode();
      }
      if (hasMagnetometerInfo()) {
        hash = (37 * hash) + MAGNETOMETER_INFO_FIELD_NUMBER;
        hash = (53 * hash) + getMagnetometerInfo().hashCode();
      }
      if (hasBarometerInfo()) {
        hash = (37 * hash) + BAROMETER_INFO_FIELD_NUMBER;
        hash = (53 * hash) + getBarometerInfo().hashCode();
      }
      if (hasLightSensorInfo()) {
        hash = (37 * hash) + LIGHT_SENSOR_INFO_FIELD_NUMBER;
        hash = (53 * hash) + getLightSensorInfo().hashCode();
      }
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static Trajectory parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Trajectory parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Trajectory parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Trajectory parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Trajectory parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static Trajectory parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static Trajectory parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static Trajectory parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static Trajectory parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static Trajectory parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(Trajectory prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code Trajectory}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:Trajectory)
        TrajectoryOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return Traj.internal_static_Trajectory_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return Traj.internal_static_Trajectory_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                Trajectory.class, Builder.class);
      }

      // Construct using Traj.Trajectory.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
          getImuDataFieldBuilder();
          getPdrDataFieldBuilder();
          getPositionDataFieldBuilder();
          getPressureDataFieldBuilder();
          getLightDataFieldBuilder();
          getGnssDataFieldBuilder();
          getWifiDataFieldBuilder();
          getApsDataFieldBuilder();
        }
      }
      public Builder clear() {
        super.clear();
        androidVersion_ = "";

        if (imuDataBuilder_ == null) {
          imuData_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000002);
        } else {
          imuDataBuilder_.clear();
        }
        if (pdrDataBuilder_ == null) {
          pdrData_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000004);
        } else {
          pdrDataBuilder_.clear();
        }
        if (positionDataBuilder_ == null) {
          positionData_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000008);
        } else {
          positionDataBuilder_.clear();
        }
        if (pressureDataBuilder_ == null) {
          pressureData_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000010);
        } else {
          pressureDataBuilder_.clear();
        }
        if (lightDataBuilder_ == null) {
          lightData_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000020);
        } else {
          lightDataBuilder_.clear();
        }
        if (gnssDataBuilder_ == null) {
          gnssData_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000040);
        } else {
          gnssDataBuilder_.clear();
        }
        if (wifiDataBuilder_ == null) {
          wifiData_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000080);
        } else {
          wifiDataBuilder_.clear();
        }
        if (apsDataBuilder_ == null) {
          apsData_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000100);
        } else {
          apsDataBuilder_.clear();
        }
        startTimestamp_ = 0L;

        dataIdentifier_ = "";

        if (accelerometerInfoBuilder_ == null) {
          accelerometerInfo_ = null;
        } else {
          accelerometerInfo_ = null;
          accelerometerInfoBuilder_ = null;
        }
        if (gyroscopeInfoBuilder_ == null) {
          gyroscopeInfo_ = null;
        } else {
          gyroscopeInfo_ = null;
          gyroscopeInfoBuilder_ = null;
        }
        if (rotationVectorInfoBuilder_ == null) {
          rotationVectorInfo_ = null;
        } else {
          rotationVectorInfo_ = null;
          rotationVectorInfoBuilder_ = null;
        }
        if (magnetometerInfoBuilder_ == null) {
          magnetometerInfo_ = null;
        } else {
          magnetometerInfo_ = null;
          magnetometerInfoBuilder_ = null;
        }
        if (barometerInfoBuilder_ == null) {
          barometerInfo_ = null;
        } else {
          barometerInfo_ = null;
          barometerInfoBuilder_ = null;
        }
        if (lightSensorInfoBuilder_ == null) {
          lightSensorInfo_ = null;
        } else {
          lightSensorInfo_ = null;
          lightSensorInfoBuilder_ = null;
        }
        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return Traj.internal_static_Trajectory_descriptor;
      }

      public Trajectory getDefaultInstanceForType() {
        return Trajectory.getDefaultInstance();
      }

      public Trajectory build() {
        Trajectory result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public Trajectory buildPartial() {
        Trajectory result = new Trajectory(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        result.androidVersion_ = androidVersion_;
        if (imuDataBuilder_ == null) {
          if (((bitField0_ & 0x00000002) == 0x00000002)) {
            imuData_ = java.util.Collections.unmodifiableList(imuData_);
            bitField0_ = (bitField0_ & ~0x00000002);
          }
          result.imuData_ = imuData_;
        } else {
          result.imuData_ = imuDataBuilder_.build();
        }
        if (pdrDataBuilder_ == null) {
          if (((bitField0_ & 0x00000004) == 0x00000004)) {
            pdrData_ = java.util.Collections.unmodifiableList(pdrData_);
            bitField0_ = (bitField0_ & ~0x00000004);
          }
          result.pdrData_ = pdrData_;
        } else {
          result.pdrData_ = pdrDataBuilder_.build();
        }
        if (positionDataBuilder_ == null) {
          if (((bitField0_ & 0x00000008) == 0x00000008)) {
            positionData_ = java.util.Collections.unmodifiableList(positionData_);
            bitField0_ = (bitField0_ & ~0x00000008);
          }
          result.positionData_ = positionData_;
        } else {
          result.positionData_ = positionDataBuilder_.build();
        }
        if (pressureDataBuilder_ == null) {
          if (((bitField0_ & 0x00000010) == 0x00000010)) {
            pressureData_ = java.util.Collections.unmodifiableList(pressureData_);
            bitField0_ = (bitField0_ & ~0x00000010);
          }
          result.pressureData_ = pressureData_;
        } else {
          result.pressureData_ = pressureDataBuilder_.build();
        }
        if (lightDataBuilder_ == null) {
          if (((bitField0_ & 0x00000020) == 0x00000020)) {
            lightData_ = java.util.Collections.unmodifiableList(lightData_);
            bitField0_ = (bitField0_ & ~0x00000020);
          }
          result.lightData_ = lightData_;
        } else {
          result.lightData_ = lightDataBuilder_.build();
        }
        if (gnssDataBuilder_ == null) {
          if (((bitField0_ & 0x00000040) == 0x00000040)) {
            gnssData_ = java.util.Collections.unmodifiableList(gnssData_);
            bitField0_ = (bitField0_ & ~0x00000040);
          }
          result.gnssData_ = gnssData_;
        } else {
          result.gnssData_ = gnssDataBuilder_.build();
        }
        if (wifiDataBuilder_ == null) {
          if (((bitField0_ & 0x00000080) == 0x00000080)) {
            wifiData_ = java.util.Collections.unmodifiableList(wifiData_);
            bitField0_ = (bitField0_ & ~0x00000080);
          }
          result.wifiData_ = wifiData_;
        } else {
          result.wifiData_ = wifiDataBuilder_.build();
        }
        if (apsDataBuilder_ == null) {
          if (((bitField0_ & 0x00000100) == 0x00000100)) {
            apsData_ = java.util.Collections.unmodifiableList(apsData_);
            bitField0_ = (bitField0_ & ~0x00000100);
          }
          result.apsData_ = apsData_;
        } else {
          result.apsData_ = apsDataBuilder_.build();
        }
        result.startTimestamp_ = startTimestamp_;
        result.dataIdentifier_ = dataIdentifier_;
        if (accelerometerInfoBuilder_ == null) {
          result.accelerometerInfo_ = accelerometerInfo_;
        } else {
          result.accelerometerInfo_ = accelerometerInfoBuilder_.build();
        }
        if (gyroscopeInfoBuilder_ == null) {
          result.gyroscopeInfo_ = gyroscopeInfo_;
        } else {
          result.gyroscopeInfo_ = gyroscopeInfoBuilder_.build();
        }
        if (rotationVectorInfoBuilder_ == null) {
          result.rotationVectorInfo_ = rotationVectorInfo_;
        } else {
          result.rotationVectorInfo_ = rotationVectorInfoBuilder_.build();
        }
        if (magnetometerInfoBuilder_ == null) {
          result.magnetometerInfo_ = magnetometerInfo_;
        } else {
          result.magnetometerInfo_ = magnetometerInfoBuilder_.build();
        }
        if (barometerInfoBuilder_ == null) {
          result.barometerInfo_ = barometerInfo_;
        } else {
          result.barometerInfo_ = barometerInfoBuilder_.build();
        }
        if (lightSensorInfoBuilder_ == null) {
          result.lightSensorInfo_ = lightSensorInfo_;
        } else {
          result.lightSensorInfo_ = lightSensorInfoBuilder_.build();
        }
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      public Builder clone() {
        return (Builder) super.clone();
      }
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.setField(field, value);
      }
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof Trajectory) {
          return mergeFrom((Trajectory)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(Trajectory other) {
        if (other == Trajectory.getDefaultInstance()) return this;
        if (!other.getAndroidVersion().isEmpty()) {
          androidVersion_ = other.androidVersion_;
          onChanged();
        }
        if (imuDataBuilder_ == null) {
          if (!other.imuData_.isEmpty()) {
            if (imuData_.isEmpty()) {
              imuData_ = other.imuData_;
              bitField0_ = (bitField0_ & ~0x00000002);
            } else {
              ensureImuDataIsMutable();
              imuData_.addAll(other.imuData_);
            }
            onChanged();
          }
        } else {
          if (!other.imuData_.isEmpty()) {
            if (imuDataBuilder_.isEmpty()) {
              imuDataBuilder_.dispose();
              imuDataBuilder_ = null;
              imuData_ = other.imuData_;
              bitField0_ = (bitField0_ & ~0x00000002);
              imuDataBuilder_ = 
                com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                   getImuDataFieldBuilder() : null;
            } else {
              imuDataBuilder_.addAllMessages(other.imuData_);
            }
          }
        }
        if (pdrDataBuilder_ == null) {
          if (!other.pdrData_.isEmpty()) {
            if (pdrData_.isEmpty()) {
              pdrData_ = other.pdrData_;
              bitField0_ = (bitField0_ & ~0x00000004);
            } else {
              ensurePdrDataIsMutable();
              pdrData_.addAll(other.pdrData_);
            }
            onChanged();
          }
        } else {
          if (!other.pdrData_.isEmpty()) {
            if (pdrDataBuilder_.isEmpty()) {
              pdrDataBuilder_.dispose();
              pdrDataBuilder_ = null;
              pdrData_ = other.pdrData_;
              bitField0_ = (bitField0_ & ~0x00000004);
              pdrDataBuilder_ = 
                com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                   getPdrDataFieldBuilder() : null;
            } else {
              pdrDataBuilder_.addAllMessages(other.pdrData_);
            }
          }
        }
        if (positionDataBuilder_ == null) {
          if (!other.positionData_.isEmpty()) {
            if (positionData_.isEmpty()) {
              positionData_ = other.positionData_;
              bitField0_ = (bitField0_ & ~0x00000008);
            } else {
              ensurePositionDataIsMutable();
              positionData_.addAll(other.positionData_);
            }
            onChanged();
          }
        } else {
          if (!other.positionData_.isEmpty()) {
            if (positionDataBuilder_.isEmpty()) {
              positionDataBuilder_.dispose();
              positionDataBuilder_ = null;
              positionData_ = other.positionData_;
              bitField0_ = (bitField0_ & ~0x00000008);
              positionDataBuilder_ = 
                com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                   getPositionDataFieldBuilder() : null;
            } else {
              positionDataBuilder_.addAllMessages(other.positionData_);
            }
          }
        }
        if (pressureDataBuilder_ == null) {
          if (!other.pressureData_.isEmpty()) {
            if (pressureData_.isEmpty()) {
              pressureData_ = other.pressureData_;
              bitField0_ = (bitField0_ & ~0x00000010);
            } else {
              ensurePressureDataIsMutable();
              pressureData_.addAll(other.pressureData_);
            }
            onChanged();
          }
        } else {
          if (!other.pressureData_.isEmpty()) {
            if (pressureDataBuilder_.isEmpty()) {
              pressureDataBuilder_.dispose();
              pressureDataBuilder_ = null;
              pressureData_ = other.pressureData_;
              bitField0_ = (bitField0_ & ~0x00000010);
              pressureDataBuilder_ = 
                com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                   getPressureDataFieldBuilder() : null;
            } else {
              pressureDataBuilder_.addAllMessages(other.pressureData_);
            }
          }
        }
        if (lightDataBuilder_ == null) {
          if (!other.lightData_.isEmpty()) {
            if (lightData_.isEmpty()) {
              lightData_ = other.lightData_;
              bitField0_ = (bitField0_ & ~0x00000020);
            } else {
              ensureLightDataIsMutable();
              lightData_.addAll(other.lightData_);
            }
            onChanged();
          }
        } else {
          if (!other.lightData_.isEmpty()) {
            if (lightDataBuilder_.isEmpty()) {
              lightDataBuilder_.dispose();
              lightDataBuilder_ = null;
              lightData_ = other.lightData_;
              bitField0_ = (bitField0_ & ~0x00000020);
              lightDataBuilder_ = 
                com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                   getLightDataFieldBuilder() : null;
            } else {
              lightDataBuilder_.addAllMessages(other.lightData_);
            }
          }
        }
        if (gnssDataBuilder_ == null) {
          if (!other.gnssData_.isEmpty()) {
            if (gnssData_.isEmpty()) {
              gnssData_ = other.gnssData_;
              bitField0_ = (bitField0_ & ~0x00000040);
            } else {
              ensureGnssDataIsMutable();
              gnssData_.addAll(other.gnssData_);
            }
            onChanged();
          }
        } else {
          if (!other.gnssData_.isEmpty()) {
            if (gnssDataBuilder_.isEmpty()) {
              gnssDataBuilder_.dispose();
              gnssDataBuilder_ = null;
              gnssData_ = other.gnssData_;
              bitField0_ = (bitField0_ & ~0x00000040);
              gnssDataBuilder_ = 
                com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                   getGnssDataFieldBuilder() : null;
            } else {
              gnssDataBuilder_.addAllMessages(other.gnssData_);
            }
          }
        }
        if (wifiDataBuilder_ == null) {
          if (!other.wifiData_.isEmpty()) {
            if (wifiData_.isEmpty()) {
              wifiData_ = other.wifiData_;
              bitField0_ = (bitField0_ & ~0x00000080);
            } else {
              ensureWifiDataIsMutable();
              wifiData_.addAll(other.wifiData_);
            }
            onChanged();
          }
        } else {
          if (!other.wifiData_.isEmpty()) {
            if (wifiDataBuilder_.isEmpty()) {
              wifiDataBuilder_.dispose();
              wifiDataBuilder_ = null;
              wifiData_ = other.wifiData_;
              bitField0_ = (bitField0_ & ~0x00000080);
              wifiDataBuilder_ = 
                com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                   getWifiDataFieldBuilder() : null;
            } else {
              wifiDataBuilder_.addAllMessages(other.wifiData_);
            }
          }
        }
        if (apsDataBuilder_ == null) {
          if (!other.apsData_.isEmpty()) {
            if (apsData_.isEmpty()) {
              apsData_ = other.apsData_;
              bitField0_ = (bitField0_ & ~0x00000100);
            } else {
              ensureApsDataIsMutable();
              apsData_.addAll(other.apsData_);
            }
            onChanged();
          }
        } else {
          if (!other.apsData_.isEmpty()) {
            if (apsDataBuilder_.isEmpty()) {
              apsDataBuilder_.dispose();
              apsDataBuilder_ = null;
              apsData_ = other.apsData_;
              bitField0_ = (bitField0_ & ~0x00000100);
              apsDataBuilder_ = 
                com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                   getApsDataFieldBuilder() : null;
            } else {
              apsDataBuilder_.addAllMessages(other.apsData_);
            }
          }
        }
        if (other.getStartTimestamp() != 0L) {
          setStartTimestamp(other.getStartTimestamp());
        }
        if (!other.getDataIdentifier().isEmpty()) {
          dataIdentifier_ = other.dataIdentifier_;
          onChanged();
        }
        if (other.hasAccelerometerInfo()) {
          mergeAccelerometerInfo(other.getAccelerometerInfo());
        }
        if (other.hasGyroscopeInfo()) {
          mergeGyroscopeInfo(other.getGyroscopeInfo());
        }
        if (other.hasRotationVectorInfo()) {
          mergeRotationVectorInfo(other.getRotationVectorInfo());
        }
        if (other.hasMagnetometerInfo()) {
          mergeMagnetometerInfo(other.getMagnetometerInfo());
        }
        if (other.hasBarometerInfo()) {
          mergeBarometerInfo(other.getBarometerInfo());
        }
        if (other.hasLightSensorInfo()) {
          mergeLightSensorInfo(other.getLightSensorInfo());
        }
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        Trajectory parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (Trajectory) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private Object androidVersion_ = "";
      /**
       * <code>optional string android_version = 1;</code>
       */
      public String getAndroidVersion() {
        Object ref = androidVersion_;
        if (!(ref instanceof String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          String s = bs.toStringUtf8();
          androidVersion_ = s;
          return s;
        } else {
          return (String) ref;
        }
      }
      /**
       * <code>optional string android_version = 1;</code>
       */
      public com.google.protobuf.ByteString
          getAndroidVersionBytes() {
        Object ref = androidVersion_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (String) ref);
          androidVersion_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string android_version = 1;</code>
       */
      public Builder setAndroidVersion(
          String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        androidVersion_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string android_version = 1;</code>
       */
      public Builder clearAndroidVersion() {
        
        androidVersion_ = getDefaultInstance().getAndroidVersion();
        onChanged();
        return this;
      }
      /**
       * <code>optional string android_version = 1;</code>
       */
      public Builder setAndroidVersionBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        androidVersion_ = value;
        onChanged();
        return this;
      }

      private java.util.List<Motion_Sample> imuData_ =
        java.util.Collections.emptyList();
      private void ensureImuDataIsMutable() {
        if (!((bitField0_ & 0x00000002) == 0x00000002)) {
          imuData_ = new java.util.ArrayList<Motion_Sample>(imuData_);
          bitField0_ |= 0x00000002;
         }
      }

      private com.google.protobuf.RepeatedFieldBuilderV3<
          Motion_Sample, Motion_Sample.Builder, Motion_SampleOrBuilder> imuDataBuilder_;

      /**
       * <code>repeated .Motion_Sample imu_data = 2;</code>
       */
      public java.util.List<Motion_Sample> getImuDataList() {
        if (imuDataBuilder_ == null) {
          return java.util.Collections.unmodifiableList(imuData_);
        } else {
          return imuDataBuilder_.getMessageList();
        }
      }
      /**
       * <code>repeated .Motion_Sample imu_data = 2;</code>
       */
      public int getImuDataCount() {
        if (imuDataBuilder_ == null) {
          return imuData_.size();
        } else {
          return imuDataBuilder_.getCount();
        }
      }
      /**
       * <code>repeated .Motion_Sample imu_data = 2;</code>
       */
      public Motion_Sample getImuData(int index) {
        if (imuDataBuilder_ == null) {
          return imuData_.get(index);
        } else {
          return imuDataBuilder_.getMessage(index);
        }
      }
      /**
       * <code>repeated .Motion_Sample imu_data = 2;</code>
       */
      public Builder setImuData(
          int index, Motion_Sample value) {
        if (imuDataBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureImuDataIsMutable();
          imuData_.set(index, value);
          onChanged();
        } else {
          imuDataBuilder_.setMessage(index, value);
        }
        return this;
      }
      /**
       * <code>repeated .Motion_Sample imu_data = 2;</code>
       */
      public Builder setImuData(
          int index, Motion_Sample.Builder builderForValue) {
        if (imuDataBuilder_ == null) {
          ensureImuDataIsMutable();
          imuData_.set(index, builderForValue.build());
          onChanged();
        } else {
          imuDataBuilder_.setMessage(index, builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .Motion_Sample imu_data = 2;</code>
       */
      public Builder addImuData(Motion_Sample value) {
        if (imuDataBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureImuDataIsMutable();
          imuData_.add(value);
          onChanged();
        } else {
          imuDataBuilder_.addMessage(value);
        }
        return this;
      }
      /**
       * <code>repeated .Motion_Sample imu_data = 2;</code>
       */
      public Builder addImuData(
          int index, Motion_Sample value) {
        if (imuDataBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureImuDataIsMutable();
          imuData_.add(index, value);
          onChanged();
        } else {
          imuDataBuilder_.addMessage(index, value);
        }
        return this;
      }
      /**
       * <code>repeated .Motion_Sample imu_data = 2;</code>
       */
      public Builder addImuData(
          Motion_Sample.Builder builderForValue) {
        if (imuDataBuilder_ == null) {
          ensureImuDataIsMutable();
          imuData_.add(builderForValue.build());
          onChanged();
        } else {
          imuDataBuilder_.addMessage(builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .Motion_Sample imu_data = 2;</code>
       */
      public Builder addImuData(
          int index, Motion_Sample.Builder builderForValue) {
        if (imuDataBuilder_ == null) {
          ensureImuDataIsMutable();
          imuData_.add(index, builderForValue.build());
          onChanged();
        } else {
          imuDataBuilder_.addMessage(index, builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .Motion_Sample imu_data = 2;</code>
       */
      public Builder addAllImuData(
          Iterable<? extends Motion_Sample> values) {
        if (imuDataBuilder_ == null) {
          ensureImuDataIsMutable();
          com.google.protobuf.AbstractMessageLite.Builder.addAll(
              values, imuData_);
          onChanged();
        } else {
          imuDataBuilder_.addAllMessages(values);
        }
        return this;
      }
      /**
       * <code>repeated .Motion_Sample imu_data = 2;</code>
       */
      public Builder clearImuData() {
        if (imuDataBuilder_ == null) {
          imuData_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000002);
          onChanged();
        } else {
          imuDataBuilder_.clear();
        }
        return this;
      }
      /**
       * <code>repeated .Motion_Sample imu_data = 2;</code>
       */
      public Builder removeImuData(int index) {
        if (imuDataBuilder_ == null) {
          ensureImuDataIsMutable();
          imuData_.remove(index);
          onChanged();
        } else {
          imuDataBuilder_.remove(index);
        }
        return this;
      }
      /**
       * <code>repeated .Motion_Sample imu_data = 2;</code>
       */
      public Motion_Sample.Builder getImuDataBuilder(
          int index) {
        return getImuDataFieldBuilder().getBuilder(index);
      }
      /**
       * <code>repeated .Motion_Sample imu_data = 2;</code>
       */
      public Motion_SampleOrBuilder getImuDataOrBuilder(
          int index) {
        if (imuDataBuilder_ == null) {
          return imuData_.get(index);  } else {
          return imuDataBuilder_.getMessageOrBuilder(index);
        }
      }
      /**
       * <code>repeated .Motion_Sample imu_data = 2;</code>
       */
      public java.util.List<? extends Motion_SampleOrBuilder>
           getImuDataOrBuilderList() {
        if (imuDataBuilder_ != null) {
          return imuDataBuilder_.getMessageOrBuilderList();
        } else {
          return java.util.Collections.unmodifiableList(imuData_);
        }
      }
      /**
       * <code>repeated .Motion_Sample imu_data = 2;</code>
       */
      public Motion_Sample.Builder addImuDataBuilder() {
        return getImuDataFieldBuilder().addBuilder(
            Motion_Sample.getDefaultInstance());
      }
      /**
       * <code>repeated .Motion_Sample imu_data = 2;</code>
       */
      public Motion_Sample.Builder addImuDataBuilder(
          int index) {
        return getImuDataFieldBuilder().addBuilder(
            index, Motion_Sample.getDefaultInstance());
      }
      /**
       * <code>repeated .Motion_Sample imu_data = 2;</code>
       */
      public java.util.List<Motion_Sample.Builder>
           getImuDataBuilderList() {
        return getImuDataFieldBuilder().getBuilderList();
      }
      private com.google.protobuf.RepeatedFieldBuilderV3<
          Motion_Sample, Motion_Sample.Builder, Motion_SampleOrBuilder>
          getImuDataFieldBuilder() {
        if (imuDataBuilder_ == null) {
          imuDataBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
              Motion_Sample, Motion_Sample.Builder, Motion_SampleOrBuilder>(
                  imuData_,
                  ((bitField0_ & 0x00000002) == 0x00000002),
                  getParentForChildren(),
                  isClean());
          imuData_ = null;
        }
        return imuDataBuilder_;
      }

      private java.util.List<Pdr_Sample> pdrData_ =
        java.util.Collections.emptyList();
      private void ensurePdrDataIsMutable() {
        if (!((bitField0_ & 0x00000004) == 0x00000004)) {
          pdrData_ = new java.util.ArrayList<Pdr_Sample>(pdrData_);
          bitField0_ |= 0x00000004;
         }
      }

      private com.google.protobuf.RepeatedFieldBuilderV3<
          Pdr_Sample, Pdr_Sample.Builder, Pdr_SampleOrBuilder> pdrDataBuilder_;

      /**
       * <code>repeated .Pdr_Sample pdr_data = 3;</code>
       */
      public java.util.List<Pdr_Sample> getPdrDataList() {
        if (pdrDataBuilder_ == null) {
          return java.util.Collections.unmodifiableList(pdrData_);
        } else {
          return pdrDataBuilder_.getMessageList();
        }
      }
      /**
       * <code>repeated .Pdr_Sample pdr_data = 3;</code>
       */
      public int getPdrDataCount() {
        if (pdrDataBuilder_ == null) {
          return pdrData_.size();
        } else {
          return pdrDataBuilder_.getCount();
        }
      }
      /**
       * <code>repeated .Pdr_Sample pdr_data = 3;</code>
       */
      public Pdr_Sample getPdrData(int index) {
        if (pdrDataBuilder_ == null) {
          return pdrData_.get(index);
        } else {
          return pdrDataBuilder_.getMessage(index);
        }
      }
      /**
       * <code>repeated .Pdr_Sample pdr_data = 3;</code>
       */
      public Builder setPdrData(
          int index, Pdr_Sample value) {
        if (pdrDataBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensurePdrDataIsMutable();
          pdrData_.set(index, value);
          onChanged();
        } else {
          pdrDataBuilder_.setMessage(index, value);
        }
        return this;
      }
      /**
       * <code>repeated .Pdr_Sample pdr_data = 3;</code>
       */
      public Builder setPdrData(
          int index, Pdr_Sample.Builder builderForValue) {
        if (pdrDataBuilder_ == null) {
          ensurePdrDataIsMutable();
          pdrData_.set(index, builderForValue.build());
          onChanged();
        } else {
          pdrDataBuilder_.setMessage(index, builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .Pdr_Sample pdr_data = 3;</code>
       */
      public Builder addPdrData(Pdr_Sample value) {
        if (pdrDataBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensurePdrDataIsMutable();
          pdrData_.add(value);
          onChanged();
        } else {
          pdrDataBuilder_.addMessage(value);
        }
        return this;
      }
      /**
       * <code>repeated .Pdr_Sample pdr_data = 3;</code>
       */
      public Builder addPdrData(
          int index, Pdr_Sample value) {
        if (pdrDataBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensurePdrDataIsMutable();
          pdrData_.add(index, value);
          onChanged();
        } else {
          pdrDataBuilder_.addMessage(index, value);
        }
        return this;
      }
      /**
       * <code>repeated .Pdr_Sample pdr_data = 3;</code>
       */
      public Builder addPdrData(
          Pdr_Sample.Builder builderForValue) {
        if (pdrDataBuilder_ == null) {
          ensurePdrDataIsMutable();
          pdrData_.add(builderForValue.build());
          onChanged();
        } else {
          pdrDataBuilder_.addMessage(builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .Pdr_Sample pdr_data = 3;</code>
       */
      public Builder addPdrData(
          int index, Pdr_Sample.Builder builderForValue) {
        if (pdrDataBuilder_ == null) {
          ensurePdrDataIsMutable();
          pdrData_.add(index, builderForValue.build());
          onChanged();
        } else {
          pdrDataBuilder_.addMessage(index, builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .Pdr_Sample pdr_data = 3;</code>
       */
      public Builder addAllPdrData(
          Iterable<? extends Pdr_Sample> values) {
        if (pdrDataBuilder_ == null) {
          ensurePdrDataIsMutable();
          com.google.protobuf.AbstractMessageLite.Builder.addAll(
              values, pdrData_);
          onChanged();
        } else {
          pdrDataBuilder_.addAllMessages(values);
        }
        return this;
      }
      /**
       * <code>repeated .Pdr_Sample pdr_data = 3;</code>
       */
      public Builder clearPdrData() {
        if (pdrDataBuilder_ == null) {
          pdrData_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000004);
          onChanged();
        } else {
          pdrDataBuilder_.clear();
        }
        return this;
      }
      /**
       * <code>repeated .Pdr_Sample pdr_data = 3;</code>
       */
      public Builder removePdrData(int index) {
        if (pdrDataBuilder_ == null) {
          ensurePdrDataIsMutable();
          pdrData_.remove(index);
          onChanged();
        } else {
          pdrDataBuilder_.remove(index);
        }
        return this;
      }
      /**
       * <code>repeated .Pdr_Sample pdr_data = 3;</code>
       */
      public Pdr_Sample.Builder getPdrDataBuilder(
          int index) {
        return getPdrDataFieldBuilder().getBuilder(index);
      }
      /**
       * <code>repeated .Pdr_Sample pdr_data = 3;</code>
       */
      public Pdr_SampleOrBuilder getPdrDataOrBuilder(
          int index) {
        if (pdrDataBuilder_ == null) {
          return pdrData_.get(index);  } else {
          return pdrDataBuilder_.getMessageOrBuilder(index);
        }
      }
      /**
       * <code>repeated .Pdr_Sample pdr_data = 3;</code>
       */
      public java.util.List<? extends Pdr_SampleOrBuilder>
           getPdrDataOrBuilderList() {
        if (pdrDataBuilder_ != null) {
          return pdrDataBuilder_.getMessageOrBuilderList();
        } else {
          return java.util.Collections.unmodifiableList(pdrData_);
        }
      }
      /**
       * <code>repeated .Pdr_Sample pdr_data = 3;</code>
       */
      public Pdr_Sample.Builder addPdrDataBuilder() {
        return getPdrDataFieldBuilder().addBuilder(
            Pdr_Sample.getDefaultInstance());
      }
      /**
       * <code>repeated .Pdr_Sample pdr_data = 3;</code>
       */
      public Pdr_Sample.Builder addPdrDataBuilder(
          int index) {
        return getPdrDataFieldBuilder().addBuilder(
            index, Pdr_Sample.getDefaultInstance());
      }
      /**
       * <code>repeated .Pdr_Sample pdr_data = 3;</code>
       */
      public java.util.List<Pdr_Sample.Builder>
           getPdrDataBuilderList() {
        return getPdrDataFieldBuilder().getBuilderList();
      }
      private com.google.protobuf.RepeatedFieldBuilderV3<
          Pdr_Sample, Pdr_Sample.Builder, Pdr_SampleOrBuilder>
          getPdrDataFieldBuilder() {
        if (pdrDataBuilder_ == null) {
          pdrDataBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
              Pdr_Sample, Pdr_Sample.Builder, Pdr_SampleOrBuilder>(
                  pdrData_,
                  ((bitField0_ & 0x00000004) == 0x00000004),
                  getParentForChildren(),
                  isClean());
          pdrData_ = null;
        }
        return pdrDataBuilder_;
      }

      private java.util.List<Position_Sample> positionData_ =
        java.util.Collections.emptyList();
      private void ensurePositionDataIsMutable() {
        if (!((bitField0_ & 0x00000008) == 0x00000008)) {
          positionData_ = new java.util.ArrayList<Position_Sample>(positionData_);
          bitField0_ |= 0x00000008;
         }
      }

      private com.google.protobuf.RepeatedFieldBuilderV3<
          Position_Sample, Position_Sample.Builder, Position_SampleOrBuilder> positionDataBuilder_;

      /**
       * <code>repeated .Position_Sample position_data = 4;</code>
       */
      public java.util.List<Position_Sample> getPositionDataList() {
        if (positionDataBuilder_ == null) {
          return java.util.Collections.unmodifiableList(positionData_);
        } else {
          return positionDataBuilder_.getMessageList();
        }
      }
      /**
       * <code>repeated .Position_Sample position_data = 4;</code>
       */
      public int getPositionDataCount() {
        if (positionDataBuilder_ == null) {
          return positionData_.size();
        } else {
          return positionDataBuilder_.getCount();
        }
      }
      /**
       * <code>repeated .Position_Sample position_data = 4;</code>
       */
      public Position_Sample getPositionData(int index) {
        if (positionDataBuilder_ == null) {
          return positionData_.get(index);
        } else {
          return positionDataBuilder_.getMessage(index);
        }
      }
      /**
       * <code>repeated .Position_Sample position_data = 4;</code>
       */
      public Builder setPositionData(
          int index, Position_Sample value) {
        if (positionDataBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensurePositionDataIsMutable();
          positionData_.set(index, value);
          onChanged();
        } else {
          positionDataBuilder_.setMessage(index, value);
        }
        return this;
      }
      /**
       * <code>repeated .Position_Sample position_data = 4;</code>
       */
      public Builder setPositionData(
          int index, Position_Sample.Builder builderForValue) {
        if (positionDataBuilder_ == null) {
          ensurePositionDataIsMutable();
          positionData_.set(index, builderForValue.build());
          onChanged();
        } else {
          positionDataBuilder_.setMessage(index, builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .Position_Sample position_data = 4;</code>
       */
      public Builder addPositionData(Position_Sample value) {
        if (positionDataBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensurePositionDataIsMutable();
          positionData_.add(value);
          onChanged();
        } else {
          positionDataBuilder_.addMessage(value);
        }
        return this;
      }
      /**
       * <code>repeated .Position_Sample position_data = 4;</code>
       */
      public Builder addPositionData(
          int index, Position_Sample value) {
        if (positionDataBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensurePositionDataIsMutable();
          positionData_.add(index, value);
          onChanged();
        } else {
          positionDataBuilder_.addMessage(index, value);
        }
        return this;
      }
      /**
       * <code>repeated .Position_Sample position_data = 4;</code>
       */
      public Builder addPositionData(
          Position_Sample.Builder builderForValue) {
        if (positionDataBuilder_ == null) {
          ensurePositionDataIsMutable();
          positionData_.add(builderForValue.build());
          onChanged();
        } else {
          positionDataBuilder_.addMessage(builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .Position_Sample position_data = 4;</code>
       */
      public Builder addPositionData(
          int index, Position_Sample.Builder builderForValue) {
        if (positionDataBuilder_ == null) {
          ensurePositionDataIsMutable();
          positionData_.add(index, builderForValue.build());
          onChanged();
        } else {
          positionDataBuilder_.addMessage(index, builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .Position_Sample position_data = 4;</code>
       */
      public Builder addAllPositionData(
          Iterable<? extends Position_Sample> values) {
        if (positionDataBuilder_ == null) {
          ensurePositionDataIsMutable();
          com.google.protobuf.AbstractMessageLite.Builder.addAll(
              values, positionData_);
          onChanged();
        } else {
          positionDataBuilder_.addAllMessages(values);
        }
        return this;
      }
      /**
       * <code>repeated .Position_Sample position_data = 4;</code>
       */
      public Builder clearPositionData() {
        if (positionDataBuilder_ == null) {
          positionData_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000008);
          onChanged();
        } else {
          positionDataBuilder_.clear();
        }
        return this;
      }
      /**
       * <code>repeated .Position_Sample position_data = 4;</code>
       */
      public Builder removePositionData(int index) {
        if (positionDataBuilder_ == null) {
          ensurePositionDataIsMutable();
          positionData_.remove(index);
          onChanged();
        } else {
          positionDataBuilder_.remove(index);
        }
        return this;
      }
      /**
       * <code>repeated .Position_Sample position_data = 4;</code>
       */
      public Position_Sample.Builder getPositionDataBuilder(
          int index) {
        return getPositionDataFieldBuilder().getBuilder(index);
      }
      /**
       * <code>repeated .Position_Sample position_data = 4;</code>
       */
      public Position_SampleOrBuilder getPositionDataOrBuilder(
          int index) {
        if (positionDataBuilder_ == null) {
          return positionData_.get(index);  } else {
          return positionDataBuilder_.getMessageOrBuilder(index);
        }
      }
      /**
       * <code>repeated .Position_Sample position_data = 4;</code>
       */
      public java.util.List<? extends Position_SampleOrBuilder>
           getPositionDataOrBuilderList() {
        if (positionDataBuilder_ != null) {
          return positionDataBuilder_.getMessageOrBuilderList();
        } else {
          return java.util.Collections.unmodifiableList(positionData_);
        }
      }
      /**
       * <code>repeated .Position_Sample position_data = 4;</code>
       */
      public Position_Sample.Builder addPositionDataBuilder() {
        return getPositionDataFieldBuilder().addBuilder(
            Position_Sample.getDefaultInstance());
      }
      /**
       * <code>repeated .Position_Sample position_data = 4;</code>
       */
      public Position_Sample.Builder addPositionDataBuilder(
          int index) {
        return getPositionDataFieldBuilder().addBuilder(
            index, Position_Sample.getDefaultInstance());
      }
      /**
       * <code>repeated .Position_Sample position_data = 4;</code>
       */
      public java.util.List<Position_Sample.Builder>
           getPositionDataBuilderList() {
        return getPositionDataFieldBuilder().getBuilderList();
      }
      private com.google.protobuf.RepeatedFieldBuilderV3<
          Position_Sample, Position_Sample.Builder, Position_SampleOrBuilder>
          getPositionDataFieldBuilder() {
        if (positionDataBuilder_ == null) {
          positionDataBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
              Position_Sample, Position_Sample.Builder, Position_SampleOrBuilder>(
                  positionData_,
                  ((bitField0_ & 0x00000008) == 0x00000008),
                  getParentForChildren(),
                  isClean());
          positionData_ = null;
        }
        return positionDataBuilder_;
      }

      private java.util.List<Pressure_Sample> pressureData_ =
        java.util.Collections.emptyList();
      private void ensurePressureDataIsMutable() {
        if (!((bitField0_ & 0x00000010) == 0x00000010)) {
          pressureData_ = new java.util.ArrayList<Pressure_Sample>(pressureData_);
          bitField0_ |= 0x00000010;
         }
      }

      private com.google.protobuf.RepeatedFieldBuilderV3<
          Pressure_Sample, Pressure_Sample.Builder, Pressure_SampleOrBuilder> pressureDataBuilder_;

      /**
       * <code>repeated .Pressure_Sample pressure_data = 5;</code>
       */
      public java.util.List<Pressure_Sample> getPressureDataList() {
        if (pressureDataBuilder_ == null) {
          return java.util.Collections.unmodifiableList(pressureData_);
        } else {
          return pressureDataBuilder_.getMessageList();
        }
      }
      /**
       * <code>repeated .Pressure_Sample pressure_data = 5;</code>
       */
      public int getPressureDataCount() {
        if (pressureDataBuilder_ == null) {
          return pressureData_.size();
        } else {
          return pressureDataBuilder_.getCount();
        }
      }
      /**
       * <code>repeated .Pressure_Sample pressure_data = 5;</code>
       */
      public Pressure_Sample getPressureData(int index) {
        if (pressureDataBuilder_ == null) {
          return pressureData_.get(index);
        } else {
          return pressureDataBuilder_.getMessage(index);
        }
      }
      /**
       * <code>repeated .Pressure_Sample pressure_data = 5;</code>
       */
      public Builder setPressureData(
          int index, Pressure_Sample value) {
        if (pressureDataBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensurePressureDataIsMutable();
          pressureData_.set(index, value);
          onChanged();
        } else {
          pressureDataBuilder_.setMessage(index, value);
        }
        return this;
      }
      /**
       * <code>repeated .Pressure_Sample pressure_data = 5;</code>
       */
      public Builder setPressureData(
          int index, Pressure_Sample.Builder builderForValue) {
        if (pressureDataBuilder_ == null) {
          ensurePressureDataIsMutable();
          pressureData_.set(index, builderForValue.build());
          onChanged();
        } else {
          pressureDataBuilder_.setMessage(index, builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .Pressure_Sample pressure_data = 5;</code>
       */
      public Builder addPressureData(Pressure_Sample value) {
        if (pressureDataBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensurePressureDataIsMutable();
          pressureData_.add(value);
          onChanged();
        } else {
          pressureDataBuilder_.addMessage(value);
        }
        return this;
      }
      /**
       * <code>repeated .Pressure_Sample pressure_data = 5;</code>
       */
      public Builder addPressureData(
          int index, Pressure_Sample value) {
        if (pressureDataBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensurePressureDataIsMutable();
          pressureData_.add(index, value);
          onChanged();
        } else {
          pressureDataBuilder_.addMessage(index, value);
        }
        return this;
      }
      /**
       * <code>repeated .Pressure_Sample pressure_data = 5;</code>
       */
      public Builder addPressureData(
          Pressure_Sample.Builder builderForValue) {
        if (pressureDataBuilder_ == null) {
          ensurePressureDataIsMutable();
          pressureData_.add(builderForValue.build());
          onChanged();
        } else {
          pressureDataBuilder_.addMessage(builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .Pressure_Sample pressure_data = 5;</code>
       */
      public Builder addPressureData(
          int index, Pressure_Sample.Builder builderForValue) {
        if (pressureDataBuilder_ == null) {
          ensurePressureDataIsMutable();
          pressureData_.add(index, builderForValue.build());
          onChanged();
        } else {
          pressureDataBuilder_.addMessage(index, builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .Pressure_Sample pressure_data = 5;</code>
       */
      public Builder addAllPressureData(
          Iterable<? extends Pressure_Sample> values) {
        if (pressureDataBuilder_ == null) {
          ensurePressureDataIsMutable();
          com.google.protobuf.AbstractMessageLite.Builder.addAll(
              values, pressureData_);
          onChanged();
        } else {
          pressureDataBuilder_.addAllMessages(values);
        }
        return this;
      }
      /**
       * <code>repeated .Pressure_Sample pressure_data = 5;</code>
       */
      public Builder clearPressureData() {
        if (pressureDataBuilder_ == null) {
          pressureData_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000010);
          onChanged();
        } else {
          pressureDataBuilder_.clear();
        }
        return this;
      }
      /**
       * <code>repeated .Pressure_Sample pressure_data = 5;</code>
       */
      public Builder removePressureData(int index) {
        if (pressureDataBuilder_ == null) {
          ensurePressureDataIsMutable();
          pressureData_.remove(index);
          onChanged();
        } else {
          pressureDataBuilder_.remove(index);
        }
        return this;
      }
      /**
       * <code>repeated .Pressure_Sample pressure_data = 5;</code>
       */
      public Pressure_Sample.Builder getPressureDataBuilder(
          int index) {
        return getPressureDataFieldBuilder().getBuilder(index);
      }
      /**
       * <code>repeated .Pressure_Sample pressure_data = 5;</code>
       */
      public Pressure_SampleOrBuilder getPressureDataOrBuilder(
          int index) {
        if (pressureDataBuilder_ == null) {
          return pressureData_.get(index);  } else {
          return pressureDataBuilder_.getMessageOrBuilder(index);
        }
      }
      /**
       * <code>repeated .Pressure_Sample pressure_data = 5;</code>
       */
      public java.util.List<? extends Pressure_SampleOrBuilder>
           getPressureDataOrBuilderList() {
        if (pressureDataBuilder_ != null) {
          return pressureDataBuilder_.getMessageOrBuilderList();
        } else {
          return java.util.Collections.unmodifiableList(pressureData_);
        }
      }
      /**
       * <code>repeated .Pressure_Sample pressure_data = 5;</code>
       */
      public Pressure_Sample.Builder addPressureDataBuilder() {
        return getPressureDataFieldBuilder().addBuilder(
            Pressure_Sample.getDefaultInstance());
      }
      /**
       * <code>repeated .Pressure_Sample pressure_data = 5;</code>
       */
      public Pressure_Sample.Builder addPressureDataBuilder(
          int index) {
        return getPressureDataFieldBuilder().addBuilder(
            index, Pressure_Sample.getDefaultInstance());
      }
      /**
       * <code>repeated .Pressure_Sample pressure_data = 5;</code>
       */
      public java.util.List<Pressure_Sample.Builder>
           getPressureDataBuilderList() {
        return getPressureDataFieldBuilder().getBuilderList();
      }
      private com.google.protobuf.RepeatedFieldBuilderV3<
          Pressure_Sample, Pressure_Sample.Builder, Pressure_SampleOrBuilder>
          getPressureDataFieldBuilder() {
        if (pressureDataBuilder_ == null) {
          pressureDataBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
              Pressure_Sample, Pressure_Sample.Builder, Pressure_SampleOrBuilder>(
                  pressureData_,
                  ((bitField0_ & 0x00000010) == 0x00000010),
                  getParentForChildren(),
                  isClean());
          pressureData_ = null;
        }
        return pressureDataBuilder_;
      }

      private java.util.List<Light_Sample> lightData_ =
        java.util.Collections.emptyList();
      private void ensureLightDataIsMutable() {
        if (!((bitField0_ & 0x00000020) == 0x00000020)) {
          lightData_ = new java.util.ArrayList<Light_Sample>(lightData_);
          bitField0_ |= 0x00000020;
         }
      }

      private com.google.protobuf.RepeatedFieldBuilderV3<
          Light_Sample, Light_Sample.Builder, Light_SampleOrBuilder> lightDataBuilder_;

      /**
       * <code>repeated .Light_Sample light_data = 6;</code>
       */
      public java.util.List<Light_Sample> getLightDataList() {
        if (lightDataBuilder_ == null) {
          return java.util.Collections.unmodifiableList(lightData_);
        } else {
          return lightDataBuilder_.getMessageList();
        }
      }
      /**
       * <code>repeated .Light_Sample light_data = 6;</code>
       */
      public int getLightDataCount() {
        if (lightDataBuilder_ == null) {
          return lightData_.size();
        } else {
          return lightDataBuilder_.getCount();
        }
      }
      /**
       * <code>repeated .Light_Sample light_data = 6;</code>
       */
      public Light_Sample getLightData(int index) {
        if (lightDataBuilder_ == null) {
          return lightData_.get(index);
        } else {
          return lightDataBuilder_.getMessage(index);
        }
      }
      /**
       * <code>repeated .Light_Sample light_data = 6;</code>
       */
      public Builder setLightData(
          int index, Light_Sample value) {
        if (lightDataBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureLightDataIsMutable();
          lightData_.set(index, value);
          onChanged();
        } else {
          lightDataBuilder_.setMessage(index, value);
        }
        return this;
      }
      /**
       * <code>repeated .Light_Sample light_data = 6;</code>
       */
      public Builder setLightData(
          int index, Light_Sample.Builder builderForValue) {
        if (lightDataBuilder_ == null) {
          ensureLightDataIsMutable();
          lightData_.set(index, builderForValue.build());
          onChanged();
        } else {
          lightDataBuilder_.setMessage(index, builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .Light_Sample light_data = 6;</code>
       */
      public Builder addLightData(Light_Sample value) {
        if (lightDataBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureLightDataIsMutable();
          lightData_.add(value);
          onChanged();
        } else {
          lightDataBuilder_.addMessage(value);
        }
        return this;
      }
      /**
       * <code>repeated .Light_Sample light_data = 6;</code>
       */
      public Builder addLightData(
          int index, Light_Sample value) {
        if (lightDataBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureLightDataIsMutable();
          lightData_.add(index, value);
          onChanged();
        } else {
          lightDataBuilder_.addMessage(index, value);
        }
        return this;
      }
      /**
       * <code>repeated .Light_Sample light_data = 6;</code>
       */
      public Builder addLightData(
          Light_Sample.Builder builderForValue) {
        if (lightDataBuilder_ == null) {
          ensureLightDataIsMutable();
          lightData_.add(builderForValue.build());
          onChanged();
        } else {
          lightDataBuilder_.addMessage(builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .Light_Sample light_data = 6;</code>
       */
      public Builder addLightData(
          int index, Light_Sample.Builder builderForValue) {
        if (lightDataBuilder_ == null) {
          ensureLightDataIsMutable();
          lightData_.add(index, builderForValue.build());
          onChanged();
        } else {
          lightDataBuilder_.addMessage(index, builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .Light_Sample light_data = 6;</code>
       */
      public Builder addAllLightData(
          Iterable<? extends Light_Sample> values) {
        if (lightDataBuilder_ == null) {
          ensureLightDataIsMutable();
          com.google.protobuf.AbstractMessageLite.Builder.addAll(
              values, lightData_);
          onChanged();
        } else {
          lightDataBuilder_.addAllMessages(values);
        }
        return this;
      }
      /**
       * <code>repeated .Light_Sample light_data = 6;</code>
       */
      public Builder clearLightData() {
        if (lightDataBuilder_ == null) {
          lightData_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000020);
          onChanged();
        } else {
          lightDataBuilder_.clear();
        }
        return this;
      }
      /**
       * <code>repeated .Light_Sample light_data = 6;</code>
       */
      public Builder removeLightData(int index) {
        if (lightDataBuilder_ == null) {
          ensureLightDataIsMutable();
          lightData_.remove(index);
          onChanged();
        } else {
          lightDataBuilder_.remove(index);
        }
        return this;
      }
      /**
       * <code>repeated .Light_Sample light_data = 6;</code>
       */
      public Light_Sample.Builder getLightDataBuilder(
          int index) {
        return getLightDataFieldBuilder().getBuilder(index);
      }
      /**
       * <code>repeated .Light_Sample light_data = 6;</code>
       */
      public Light_SampleOrBuilder getLightDataOrBuilder(
          int index) {
        if (lightDataBuilder_ == null) {
          return lightData_.get(index);  } else {
          return lightDataBuilder_.getMessageOrBuilder(index);
        }
      }
      /**
       * <code>repeated .Light_Sample light_data = 6;</code>
       */
      public java.util.List<? extends Light_SampleOrBuilder>
           getLightDataOrBuilderList() {
        if (lightDataBuilder_ != null) {
          return lightDataBuilder_.getMessageOrBuilderList();
        } else {
          return java.util.Collections.unmodifiableList(lightData_);
        }
      }
      /**
       * <code>repeated .Light_Sample light_data = 6;</code>
       */
      public Light_Sample.Builder addLightDataBuilder() {
        return getLightDataFieldBuilder().addBuilder(
            Light_Sample.getDefaultInstance());
      }
      /**
       * <code>repeated .Light_Sample light_data = 6;</code>
       */
      public Light_Sample.Builder addLightDataBuilder(
          int index) {
        return getLightDataFieldBuilder().addBuilder(
            index, Light_Sample.getDefaultInstance());
      }
      /**
       * <code>repeated .Light_Sample light_data = 6;</code>
       */
      public java.util.List<Light_Sample.Builder>
           getLightDataBuilderList() {
        return getLightDataFieldBuilder().getBuilderList();
      }
      private com.google.protobuf.RepeatedFieldBuilderV3<
          Light_Sample, Light_Sample.Builder, Light_SampleOrBuilder>
          getLightDataFieldBuilder() {
        if (lightDataBuilder_ == null) {
          lightDataBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
              Light_Sample, Light_Sample.Builder, Light_SampleOrBuilder>(
                  lightData_,
                  ((bitField0_ & 0x00000020) == 0x00000020),
                  getParentForChildren(),
                  isClean());
          lightData_ = null;
        }
        return lightDataBuilder_;
      }

      private java.util.List<GNSS_Sample> gnssData_ =
        java.util.Collections.emptyList();
      private void ensureGnssDataIsMutable() {
        if (!((bitField0_ & 0x00000040) == 0x00000040)) {
          gnssData_ = new java.util.ArrayList<GNSS_Sample>(gnssData_);
          bitField0_ |= 0x00000040;
         }
      }

      private com.google.protobuf.RepeatedFieldBuilderV3<
          GNSS_Sample, GNSS_Sample.Builder, GNSS_SampleOrBuilder> gnssDataBuilder_;

      /**
       * <code>repeated .GNSS_Sample gnss_data = 7;</code>
       */
      public java.util.List<GNSS_Sample> getGnssDataList() {
        if (gnssDataBuilder_ == null) {
          return java.util.Collections.unmodifiableList(gnssData_);
        } else {
          return gnssDataBuilder_.getMessageList();
        }
      }
      /**
       * <code>repeated .GNSS_Sample gnss_data = 7;</code>
       */
      public int getGnssDataCount() {
        if (gnssDataBuilder_ == null) {
          return gnssData_.size();
        } else {
          return gnssDataBuilder_.getCount();
        }
      }
      /**
       * <code>repeated .GNSS_Sample gnss_data = 7;</code>
       */
      public GNSS_Sample getGnssData(int index) {
        if (gnssDataBuilder_ == null) {
          return gnssData_.get(index);
        } else {
          return gnssDataBuilder_.getMessage(index);
        }
      }
      /**
       * <code>repeated .GNSS_Sample gnss_data = 7;</code>
       */
      public Builder setGnssData(
          int index, GNSS_Sample value) {
        if (gnssDataBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureGnssDataIsMutable();
          gnssData_.set(index, value);
          onChanged();
        } else {
          gnssDataBuilder_.setMessage(index, value);
        }
        return this;
      }
      /**
       * <code>repeated .GNSS_Sample gnss_data = 7;</code>
       */
      public Builder setGnssData(
          int index, GNSS_Sample.Builder builderForValue) {
        if (gnssDataBuilder_ == null) {
          ensureGnssDataIsMutable();
          gnssData_.set(index, builderForValue.build());
          onChanged();
        } else {
          gnssDataBuilder_.setMessage(index, builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .GNSS_Sample gnss_data = 7;</code>
       */
      public Builder addGnssData(GNSS_Sample value) {
        if (gnssDataBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureGnssDataIsMutable();
          gnssData_.add(value);
          onChanged();
        } else {
          gnssDataBuilder_.addMessage(value);
        }
        return this;
      }
      /**
       * <code>repeated .GNSS_Sample gnss_data = 7;</code>
       */
      public Builder addGnssData(
          int index, GNSS_Sample value) {
        if (gnssDataBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureGnssDataIsMutable();
          gnssData_.add(index, value);
          onChanged();
        } else {
          gnssDataBuilder_.addMessage(index, value);
        }
        return this;
      }
      /**
       * <code>repeated .GNSS_Sample gnss_data = 7;</code>
       */
      public Builder addGnssData(
          GNSS_Sample.Builder builderForValue) {
        if (gnssDataBuilder_ == null) {
          ensureGnssDataIsMutable();
          gnssData_.add(builderForValue.build());
          onChanged();
        } else {
          gnssDataBuilder_.addMessage(builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .GNSS_Sample gnss_data = 7;</code>
       */
      public Builder addGnssData(
          int index, GNSS_Sample.Builder builderForValue) {
        if (gnssDataBuilder_ == null) {
          ensureGnssDataIsMutable();
          gnssData_.add(index, builderForValue.build());
          onChanged();
        } else {
          gnssDataBuilder_.addMessage(index, builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .GNSS_Sample gnss_data = 7;</code>
       */
      public Builder addAllGnssData(
          Iterable<? extends GNSS_Sample> values) {
        if (gnssDataBuilder_ == null) {
          ensureGnssDataIsMutable();
          com.google.protobuf.AbstractMessageLite.Builder.addAll(
              values, gnssData_);
          onChanged();
        } else {
          gnssDataBuilder_.addAllMessages(values);
        }
        return this;
      }
      /**
       * <code>repeated .GNSS_Sample gnss_data = 7;</code>
       */
      public Builder clearGnssData() {
        if (gnssDataBuilder_ == null) {
          gnssData_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000040);
          onChanged();
        } else {
          gnssDataBuilder_.clear();
        }
        return this;
      }
      /**
       * <code>repeated .GNSS_Sample gnss_data = 7;</code>
       */
      public Builder removeGnssData(int index) {
        if (gnssDataBuilder_ == null) {
          ensureGnssDataIsMutable();
          gnssData_.remove(index);
          onChanged();
        } else {
          gnssDataBuilder_.remove(index);
        }
        return this;
      }
      /**
       * <code>repeated .GNSS_Sample gnss_data = 7;</code>
       */
      public GNSS_Sample.Builder getGnssDataBuilder(
          int index) {
        return getGnssDataFieldBuilder().getBuilder(index);
      }
      /**
       * <code>repeated .GNSS_Sample gnss_data = 7;</code>
       */
      public GNSS_SampleOrBuilder getGnssDataOrBuilder(
          int index) {
        if (gnssDataBuilder_ == null) {
          return gnssData_.get(index);  } else {
          return gnssDataBuilder_.getMessageOrBuilder(index);
        }
      }
      /**
       * <code>repeated .GNSS_Sample gnss_data = 7;</code>
       */
      public java.util.List<? extends GNSS_SampleOrBuilder>
           getGnssDataOrBuilderList() {
        if (gnssDataBuilder_ != null) {
          return gnssDataBuilder_.getMessageOrBuilderList();
        } else {
          return java.util.Collections.unmodifiableList(gnssData_);
        }
      }
      /**
       * <code>repeated .GNSS_Sample gnss_data = 7;</code>
       */
      public GNSS_Sample.Builder addGnssDataBuilder() {
        return getGnssDataFieldBuilder().addBuilder(
            GNSS_Sample.getDefaultInstance());
      }
      /**
       * <code>repeated .GNSS_Sample gnss_data = 7;</code>
       */
      public GNSS_Sample.Builder addGnssDataBuilder(
          int index) {
        return getGnssDataFieldBuilder().addBuilder(
            index, GNSS_Sample.getDefaultInstance());
      }
      /**
       * <code>repeated .GNSS_Sample gnss_data = 7;</code>
       */
      public java.util.List<GNSS_Sample.Builder>
           getGnssDataBuilderList() {
        return getGnssDataFieldBuilder().getBuilderList();
      }
      private com.google.protobuf.RepeatedFieldBuilderV3<
          GNSS_Sample, GNSS_Sample.Builder, GNSS_SampleOrBuilder>
          getGnssDataFieldBuilder() {
        if (gnssDataBuilder_ == null) {
          gnssDataBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
              GNSS_Sample, GNSS_Sample.Builder, GNSS_SampleOrBuilder>(
                  gnssData_,
                  ((bitField0_ & 0x00000040) == 0x00000040),
                  getParentForChildren(),
                  isClean());
          gnssData_ = null;
        }
        return gnssDataBuilder_;
      }

      private java.util.List<WiFi_Sample> wifiData_ =
        java.util.Collections.emptyList();
      private void ensureWifiDataIsMutable() {
        if (!((bitField0_ & 0x00000080) == 0x00000080)) {
          wifiData_ = new java.util.ArrayList<WiFi_Sample>(wifiData_);
          bitField0_ |= 0x00000080;
         }
      }

      private com.google.protobuf.RepeatedFieldBuilderV3<
          WiFi_Sample, WiFi_Sample.Builder, WiFi_SampleOrBuilder> wifiDataBuilder_;

      /**
       * <code>repeated .WiFi_Sample wifi_data = 8;</code>
       */
      public java.util.List<WiFi_Sample> getWifiDataList() {
        if (wifiDataBuilder_ == null) {
          return java.util.Collections.unmodifiableList(wifiData_);
        } else {
          return wifiDataBuilder_.getMessageList();
        }
      }
      /**
       * <code>repeated .WiFi_Sample wifi_data = 8;</code>
       */
      public int getWifiDataCount() {
        if (wifiDataBuilder_ == null) {
          return wifiData_.size();
        } else {
          return wifiDataBuilder_.getCount();
        }
      }
      /**
       * <code>repeated .WiFi_Sample wifi_data = 8;</code>
       */
      public WiFi_Sample getWifiData(int index) {
        if (wifiDataBuilder_ == null) {
          return wifiData_.get(index);
        } else {
          return wifiDataBuilder_.getMessage(index);
        }
      }
      /**
       * <code>repeated .WiFi_Sample wifi_data = 8;</code>
       */
      public Builder setWifiData(
          int index, WiFi_Sample value) {
        if (wifiDataBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureWifiDataIsMutable();
          wifiData_.set(index, value);
          onChanged();
        } else {
          wifiDataBuilder_.setMessage(index, value);
        }
        return this;
      }
      /**
       * <code>repeated .WiFi_Sample wifi_data = 8;</code>
       */
      public Builder setWifiData(
          int index, WiFi_Sample.Builder builderForValue) {
        if (wifiDataBuilder_ == null) {
          ensureWifiDataIsMutable();
          wifiData_.set(index, builderForValue.build());
          onChanged();
        } else {
          wifiDataBuilder_.setMessage(index, builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .WiFi_Sample wifi_data = 8;</code>
       */
      public Builder addWifiData(WiFi_Sample value) {
        if (wifiDataBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureWifiDataIsMutable();
          wifiData_.add(value);
          onChanged();
        } else {
          wifiDataBuilder_.addMessage(value);
        }
        return this;
      }
      /**
       * <code>repeated .WiFi_Sample wifi_data = 8;</code>
       */
      public Builder addWifiData(
          int index, WiFi_Sample value) {
        if (wifiDataBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureWifiDataIsMutable();
          wifiData_.add(index, value);
          onChanged();
        } else {
          wifiDataBuilder_.addMessage(index, value);
        }
        return this;
      }
      /**
       * <code>repeated .WiFi_Sample wifi_data = 8;</code>
       */
      public Builder addWifiData(
          WiFi_Sample.Builder builderForValue) {
        if (wifiDataBuilder_ == null) {
          ensureWifiDataIsMutable();
          wifiData_.add(builderForValue.build());
          onChanged();
        } else {
          wifiDataBuilder_.addMessage(builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .WiFi_Sample wifi_data = 8;</code>
       */
      public Builder addWifiData(
          int index, WiFi_Sample.Builder builderForValue) {
        if (wifiDataBuilder_ == null) {
          ensureWifiDataIsMutable();
          wifiData_.add(index, builderForValue.build());
          onChanged();
        } else {
          wifiDataBuilder_.addMessage(index, builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .WiFi_Sample wifi_data = 8;</code>
       */
      public Builder addAllWifiData(
          Iterable<? extends WiFi_Sample> values) {
        if (wifiDataBuilder_ == null) {
          ensureWifiDataIsMutable();
          com.google.protobuf.AbstractMessageLite.Builder.addAll(
              values, wifiData_);
          onChanged();
        } else {
          wifiDataBuilder_.addAllMessages(values);
        }
        return this;
      }
      /**
       * <code>repeated .WiFi_Sample wifi_data = 8;</code>
       */
      public Builder clearWifiData() {
        if (wifiDataBuilder_ == null) {
          wifiData_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000080);
          onChanged();
        } else {
          wifiDataBuilder_.clear();
        }
        return this;
      }
      /**
       * <code>repeated .WiFi_Sample wifi_data = 8;</code>
       */
      public Builder removeWifiData(int index) {
        if (wifiDataBuilder_ == null) {
          ensureWifiDataIsMutable();
          wifiData_.remove(index);
          onChanged();
        } else {
          wifiDataBuilder_.remove(index);
        }
        return this;
      }
      /**
       * <code>repeated .WiFi_Sample wifi_data = 8;</code>
       */
      public WiFi_Sample.Builder getWifiDataBuilder(
          int index) {
        return getWifiDataFieldBuilder().getBuilder(index);
      }
      /**
       * <code>repeated .WiFi_Sample wifi_data = 8;</code>
       */
      public WiFi_SampleOrBuilder getWifiDataOrBuilder(
          int index) {
        if (wifiDataBuilder_ == null) {
          return wifiData_.get(index);  } else {
          return wifiDataBuilder_.getMessageOrBuilder(index);
        }
      }
      /**
       * <code>repeated .WiFi_Sample wifi_data = 8;</code>
       */
      public java.util.List<? extends WiFi_SampleOrBuilder>
           getWifiDataOrBuilderList() {
        if (wifiDataBuilder_ != null) {
          return wifiDataBuilder_.getMessageOrBuilderList();
        } else {
          return java.util.Collections.unmodifiableList(wifiData_);
        }
      }
      /**
       * <code>repeated .WiFi_Sample wifi_data = 8;</code>
       */
      public WiFi_Sample.Builder addWifiDataBuilder() {
        return getWifiDataFieldBuilder().addBuilder(
            WiFi_Sample.getDefaultInstance());
      }
      /**
       * <code>repeated .WiFi_Sample wifi_data = 8;</code>
       */
      public WiFi_Sample.Builder addWifiDataBuilder(
          int index) {
        return getWifiDataFieldBuilder().addBuilder(
            index, WiFi_Sample.getDefaultInstance());
      }
      /**
       * <code>repeated .WiFi_Sample wifi_data = 8;</code>
       */
      public java.util.List<WiFi_Sample.Builder>
           getWifiDataBuilderList() {
        return getWifiDataFieldBuilder().getBuilderList();
      }
      private com.google.protobuf.RepeatedFieldBuilderV3<
          WiFi_Sample, WiFi_Sample.Builder, WiFi_SampleOrBuilder>
          getWifiDataFieldBuilder() {
        if (wifiDataBuilder_ == null) {
          wifiDataBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
              WiFi_Sample, WiFi_Sample.Builder, WiFi_SampleOrBuilder>(
                  wifiData_,
                  ((bitField0_ & 0x00000080) == 0x00000080),
                  getParentForChildren(),
                  isClean());
          wifiData_ = null;
        }
        return wifiDataBuilder_;
      }

      private java.util.List<AP_Data> apsData_ =
        java.util.Collections.emptyList();
      private void ensureApsDataIsMutable() {
        if (!((bitField0_ & 0x00000100) == 0x00000100)) {
          apsData_ = new java.util.ArrayList<AP_Data>(apsData_);
          bitField0_ |= 0x00000100;
         }
      }

      private com.google.protobuf.RepeatedFieldBuilderV3<
          AP_Data, AP_Data.Builder, AP_DataOrBuilder> apsDataBuilder_;

      /**
       * <code>repeated .AP_Data aps_data = 9;</code>
       */
      public java.util.List<AP_Data> getApsDataList() {
        if (apsDataBuilder_ == null) {
          return java.util.Collections.unmodifiableList(apsData_);
        } else {
          return apsDataBuilder_.getMessageList();
        }
      }
      /**
       * <code>repeated .AP_Data aps_data = 9;</code>
       */
      public int getApsDataCount() {
        if (apsDataBuilder_ == null) {
          return apsData_.size();
        } else {
          return apsDataBuilder_.getCount();
        }
      }
      /**
       * <code>repeated .AP_Data aps_data = 9;</code>
       */
      public AP_Data getApsData(int index) {
        if (apsDataBuilder_ == null) {
          return apsData_.get(index);
        } else {
          return apsDataBuilder_.getMessage(index);
        }
      }
      /**
       * <code>repeated .AP_Data aps_data = 9;</code>
       */
      public Builder setApsData(
          int index, AP_Data value) {
        if (apsDataBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureApsDataIsMutable();
          apsData_.set(index, value);
          onChanged();
        } else {
          apsDataBuilder_.setMessage(index, value);
        }
        return this;
      }
      /**
       * <code>repeated .AP_Data aps_data = 9;</code>
       */
      public Builder setApsData(
          int index, AP_Data.Builder builderForValue) {
        if (apsDataBuilder_ == null) {
          ensureApsDataIsMutable();
          apsData_.set(index, builderForValue.build());
          onChanged();
        } else {
          apsDataBuilder_.setMessage(index, builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .AP_Data aps_data = 9;</code>
       */
      public Builder addApsData(AP_Data value) {
        if (apsDataBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureApsDataIsMutable();
          apsData_.add(value);
          onChanged();
        } else {
          apsDataBuilder_.addMessage(value);
        }
        return this;
      }
      /**
       * <code>repeated .AP_Data aps_data = 9;</code>
       */
      public Builder addApsData(
          int index, AP_Data value) {
        if (apsDataBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureApsDataIsMutable();
          apsData_.add(index, value);
          onChanged();
        } else {
          apsDataBuilder_.addMessage(index, value);
        }
        return this;
      }
      /**
       * <code>repeated .AP_Data aps_data = 9;</code>
       */
      public Builder addApsData(
          AP_Data.Builder builderForValue) {
        if (apsDataBuilder_ == null) {
          ensureApsDataIsMutable();
          apsData_.add(builderForValue.build());
          onChanged();
        } else {
          apsDataBuilder_.addMessage(builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .AP_Data aps_data = 9;</code>
       */
      public Builder addApsData(
          int index, AP_Data.Builder builderForValue) {
        if (apsDataBuilder_ == null) {
          ensureApsDataIsMutable();
          apsData_.add(index, builderForValue.build());
          onChanged();
        } else {
          apsDataBuilder_.addMessage(index, builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .AP_Data aps_data = 9;</code>
       */
      public Builder addAllApsData(
          Iterable<? extends AP_Data> values) {
        if (apsDataBuilder_ == null) {
          ensureApsDataIsMutable();
          com.google.protobuf.AbstractMessageLite.Builder.addAll(
              values, apsData_);
          onChanged();
        } else {
          apsDataBuilder_.addAllMessages(values);
        }
        return this;
      }
      /**
       * <code>repeated .AP_Data aps_data = 9;</code>
       */
      public Builder clearApsData() {
        if (apsDataBuilder_ == null) {
          apsData_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000100);
          onChanged();
        } else {
          apsDataBuilder_.clear();
        }
        return this;
      }
      /**
       * <code>repeated .AP_Data aps_data = 9;</code>
       */
      public Builder removeApsData(int index) {
        if (apsDataBuilder_ == null) {
          ensureApsDataIsMutable();
          apsData_.remove(index);
          onChanged();
        } else {
          apsDataBuilder_.remove(index);
        }
        return this;
      }
      /**
       * <code>repeated .AP_Data aps_data = 9;</code>
       */
      public AP_Data.Builder getApsDataBuilder(
          int index) {
        return getApsDataFieldBuilder().getBuilder(index);
      }
      /**
       * <code>repeated .AP_Data aps_data = 9;</code>
       */
      public AP_DataOrBuilder getApsDataOrBuilder(
          int index) {
        if (apsDataBuilder_ == null) {
          return apsData_.get(index);  } else {
          return apsDataBuilder_.getMessageOrBuilder(index);
        }
      }
      /**
       * <code>repeated .AP_Data aps_data = 9;</code>
       */
      public java.util.List<? extends AP_DataOrBuilder>
           getApsDataOrBuilderList() {
        if (apsDataBuilder_ != null) {
          return apsDataBuilder_.getMessageOrBuilderList();
        } else {
          return java.util.Collections.unmodifiableList(apsData_);
        }
      }
      /**
       * <code>repeated .AP_Data aps_data = 9;</code>
       */
      public AP_Data.Builder addApsDataBuilder() {
        return getApsDataFieldBuilder().addBuilder(
            AP_Data.getDefaultInstance());
      }
      /**
       * <code>repeated .AP_Data aps_data = 9;</code>
       */
      public AP_Data.Builder addApsDataBuilder(
          int index) {
        return getApsDataFieldBuilder().addBuilder(
            index, AP_Data.getDefaultInstance());
      }
      /**
       * <code>repeated .AP_Data aps_data = 9;</code>
       */
      public java.util.List<AP_Data.Builder>
           getApsDataBuilderList() {
        return getApsDataFieldBuilder().getBuilderList();
      }
      private com.google.protobuf.RepeatedFieldBuilderV3<
          AP_Data, AP_Data.Builder, AP_DataOrBuilder>
          getApsDataFieldBuilder() {
        if (apsDataBuilder_ == null) {
          apsDataBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
              AP_Data, AP_Data.Builder, AP_DataOrBuilder>(
                  apsData_,
                  ((bitField0_ & 0x00000100) == 0x00000100),
                  getParentForChildren(),
                  isClean());
          apsData_ = null;
        }
        return apsDataBuilder_;
      }

      private long startTimestamp_ ;
      /**
       * <pre>
       * UNIX timestamp (in milliseconds) recorded from the start of this
       * trajectory data collection event. All future
       * timestamps in sub classes are to be RELATIVE timestamps
       * (in milliseconds) to this start time.
       * E.g.
       * start_timestamp = 1674819807315 (UTC 27 Jan 2023 in the morning)
       * relative_timestamp = 3000 (3s)
       * </pre>
       *
       * <code>optional int64 start_timestamp = 10;</code>
       */
      public long getStartTimestamp() {
        return startTimestamp_;
      }
      /**
       * <pre>
       * UNIX timestamp (in milliseconds) recorded from the start of this
       * trajectory data collection event. All future
       * timestamps in sub classes are to be RELATIVE timestamps
       * (in milliseconds) to this start time.
       * E.g.
       * start_timestamp = 1674819807315 (UTC 27 Jan 2023 in the morning)
       * relative_timestamp = 3000 (3s)
       * </pre>
       *
       * <code>optional int64 start_timestamp = 10;</code>
       */
      public Builder setStartTimestamp(long value) {
        
        startTimestamp_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       * UNIX timestamp (in milliseconds) recorded from the start of this
       * trajectory data collection event. All future
       * timestamps in sub classes are to be RELATIVE timestamps
       * (in milliseconds) to this start time.
       * E.g.
       * start_timestamp = 1674819807315 (UTC 27 Jan 2023 in the morning)
       * relative_timestamp = 3000 (3s)
       * </pre>
       *
       * <code>optional int64 start_timestamp = 10;</code>
       */
      public Builder clearStartTimestamp() {
        
        startTimestamp_ = 0L;
        onChanged();
        return this;
      }

      private Object dataIdentifier_ = "";
      /**
       * <code>optional string data_identifier = 11;</code>
       */
      public String getDataIdentifier() {
        Object ref = dataIdentifier_;
        if (!(ref instanceof String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          String s = bs.toStringUtf8();
          dataIdentifier_ = s;
          return s;
        } else {
          return (String) ref;
        }
      }
      /**
       * <code>optional string data_identifier = 11;</code>
       */
      public com.google.protobuf.ByteString
          getDataIdentifierBytes() {
        Object ref = dataIdentifier_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (String) ref);
          dataIdentifier_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string data_identifier = 11;</code>
       */
      public Builder setDataIdentifier(
          String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        dataIdentifier_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string data_identifier = 11;</code>
       */
      public Builder clearDataIdentifier() {
        
        dataIdentifier_ = getDefaultInstance().getDataIdentifier();
        onChanged();
        return this;
      }
      /**
       * <code>optional string data_identifier = 11;</code>
       */
      public Builder setDataIdentifierBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        dataIdentifier_ = value;
        onChanged();
        return this;
      }

      private Sensor_Info accelerometerInfo_ = null;
      private com.google.protobuf.SingleFieldBuilderV3<
          Sensor_Info, Sensor_Info.Builder, Sensor_InfoOrBuilder> accelerometerInfoBuilder_;
      /**
       * <code>optional .Sensor_Info accelerometer_info = 12;</code>
       */
      public boolean hasAccelerometerInfo() {
        return accelerometerInfoBuilder_ != null || accelerometerInfo_ != null;
      }
      /**
       * <code>optional .Sensor_Info accelerometer_info = 12;</code>
       */
      public Sensor_Info getAccelerometerInfo() {
        if (accelerometerInfoBuilder_ == null) {
          return accelerometerInfo_ == null ? Sensor_Info.getDefaultInstance() : accelerometerInfo_;
        } else {
          return accelerometerInfoBuilder_.getMessage();
        }
      }
      /**
       * <code>optional .Sensor_Info accelerometer_info = 12;</code>
       */
      public Builder setAccelerometerInfo(Sensor_Info value) {
        if (accelerometerInfoBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          accelerometerInfo_ = value;
          onChanged();
        } else {
          accelerometerInfoBuilder_.setMessage(value);
        }

        return this;
      }
      /**
       * <code>optional .Sensor_Info accelerometer_info = 12;</code>
       */
      public Builder setAccelerometerInfo(
          Sensor_Info.Builder builderForValue) {
        if (accelerometerInfoBuilder_ == null) {
          accelerometerInfo_ = builderForValue.build();
          onChanged();
        } else {
          accelerometerInfoBuilder_.setMessage(builderForValue.build());
        }

        return this;
      }
      /**
       * <code>optional .Sensor_Info accelerometer_info = 12;</code>
       */
      public Builder mergeAccelerometerInfo(Sensor_Info value) {
        if (accelerometerInfoBuilder_ == null) {
          if (accelerometerInfo_ != null) {
            accelerometerInfo_ =
              Sensor_Info.newBuilder(accelerometerInfo_).mergeFrom(value).buildPartial();
          } else {
            accelerometerInfo_ = value;
          }
          onChanged();
        } else {
          accelerometerInfoBuilder_.mergeFrom(value);
        }

        return this;
      }
      /**
       * <code>optional .Sensor_Info accelerometer_info = 12;</code>
       */
      public Builder clearAccelerometerInfo() {
        if (accelerometerInfoBuilder_ == null) {
          accelerometerInfo_ = null;
          onChanged();
        } else {
          accelerometerInfo_ = null;
          accelerometerInfoBuilder_ = null;
        }

        return this;
      }
      /**
       * <code>optional .Sensor_Info accelerometer_info = 12;</code>
       */
      public Sensor_Info.Builder getAccelerometerInfoBuilder() {
        
        onChanged();
        return getAccelerometerInfoFieldBuilder().getBuilder();
      }
      /**
       * <code>optional .Sensor_Info accelerometer_info = 12;</code>
       */
      public Sensor_InfoOrBuilder getAccelerometerInfoOrBuilder() {
        if (accelerometerInfoBuilder_ != null) {
          return accelerometerInfoBuilder_.getMessageOrBuilder();
        } else {
          return accelerometerInfo_ == null ?
              Sensor_Info.getDefaultInstance() : accelerometerInfo_;
        }
      }
      /**
       * <code>optional .Sensor_Info accelerometer_info = 12;</code>
       */
      private com.google.protobuf.SingleFieldBuilderV3<
          Sensor_Info, Sensor_Info.Builder, Sensor_InfoOrBuilder>
          getAccelerometerInfoFieldBuilder() {
        if (accelerometerInfoBuilder_ == null) {
          accelerometerInfoBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
              Sensor_Info, Sensor_Info.Builder, Sensor_InfoOrBuilder>(
                  getAccelerometerInfo(),
                  getParentForChildren(),
                  isClean());
          accelerometerInfo_ = null;
        }
        return accelerometerInfoBuilder_;
      }

      private Sensor_Info gyroscopeInfo_ = null;
      private com.google.protobuf.SingleFieldBuilderV3<
          Sensor_Info, Sensor_Info.Builder, Sensor_InfoOrBuilder> gyroscopeInfoBuilder_;
      /**
       * <code>optional .Sensor_Info gyroscope_info = 13;</code>
       */
      public boolean hasGyroscopeInfo() {
        return gyroscopeInfoBuilder_ != null || gyroscopeInfo_ != null;
      }
      /**
       * <code>optional .Sensor_Info gyroscope_info = 13;</code>
       */
      public Sensor_Info getGyroscopeInfo() {
        if (gyroscopeInfoBuilder_ == null) {
          return gyroscopeInfo_ == null ? Sensor_Info.getDefaultInstance() : gyroscopeInfo_;
        } else {
          return gyroscopeInfoBuilder_.getMessage();
        }
      }
      /**
       * <code>optional .Sensor_Info gyroscope_info = 13;</code>
       */
      public Builder setGyroscopeInfo(Sensor_Info value) {
        if (gyroscopeInfoBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          gyroscopeInfo_ = value;
          onChanged();
        } else {
          gyroscopeInfoBuilder_.setMessage(value);
        }

        return this;
      }
      /**
       * <code>optional .Sensor_Info gyroscope_info = 13;</code>
       */
      public Builder setGyroscopeInfo(
          Sensor_Info.Builder builderForValue) {
        if (gyroscopeInfoBuilder_ == null) {
          gyroscopeInfo_ = builderForValue.build();
          onChanged();
        } else {
          gyroscopeInfoBuilder_.setMessage(builderForValue.build());
        }

        return this;
      }
      /**
       * <code>optional .Sensor_Info gyroscope_info = 13;</code>
       */
      public Builder mergeGyroscopeInfo(Sensor_Info value) {
        if (gyroscopeInfoBuilder_ == null) {
          if (gyroscopeInfo_ != null) {
            gyroscopeInfo_ =
              Sensor_Info.newBuilder(gyroscopeInfo_).mergeFrom(value).buildPartial();
          } else {
            gyroscopeInfo_ = value;
          }
          onChanged();
        } else {
          gyroscopeInfoBuilder_.mergeFrom(value);
        }

        return this;
      }
      /**
       * <code>optional .Sensor_Info gyroscope_info = 13;</code>
       */
      public Builder clearGyroscopeInfo() {
        if (gyroscopeInfoBuilder_ == null) {
          gyroscopeInfo_ = null;
          onChanged();
        } else {
          gyroscopeInfo_ = null;
          gyroscopeInfoBuilder_ = null;
        }

        return this;
      }
      /**
       * <code>optional .Sensor_Info gyroscope_info = 13;</code>
       */
      public Sensor_Info.Builder getGyroscopeInfoBuilder() {
        
        onChanged();
        return getGyroscopeInfoFieldBuilder().getBuilder();
      }
      /**
       * <code>optional .Sensor_Info gyroscope_info = 13;</code>
       */
      public Sensor_InfoOrBuilder getGyroscopeInfoOrBuilder() {
        if (gyroscopeInfoBuilder_ != null) {
          return gyroscopeInfoBuilder_.getMessageOrBuilder();
        } else {
          return gyroscopeInfo_ == null ?
              Sensor_Info.getDefaultInstance() : gyroscopeInfo_;
        }
      }
      /**
       * <code>optional .Sensor_Info gyroscope_info = 13;</code>
       */
      private com.google.protobuf.SingleFieldBuilderV3<
          Sensor_Info, Sensor_Info.Builder, Sensor_InfoOrBuilder>
          getGyroscopeInfoFieldBuilder() {
        if (gyroscopeInfoBuilder_ == null) {
          gyroscopeInfoBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
              Sensor_Info, Sensor_Info.Builder, Sensor_InfoOrBuilder>(
                  getGyroscopeInfo(),
                  getParentForChildren(),
                  isClean());
          gyroscopeInfo_ = null;
        }
        return gyroscopeInfoBuilder_;
      }

      private Sensor_Info rotationVectorInfo_ = null;
      private com.google.protobuf.SingleFieldBuilderV3<
          Sensor_Info, Sensor_Info.Builder, Sensor_InfoOrBuilder> rotationVectorInfoBuilder_;
      /**
       * <code>optional .Sensor_Info rotation_vector_info = 14;</code>
       */
      public boolean hasRotationVectorInfo() {
        return rotationVectorInfoBuilder_ != null || rotationVectorInfo_ != null;
      }
      /**
       * <code>optional .Sensor_Info rotation_vector_info = 14;</code>
       */
      public Sensor_Info getRotationVectorInfo() {
        if (rotationVectorInfoBuilder_ == null) {
          return rotationVectorInfo_ == null ? Sensor_Info.getDefaultInstance() : rotationVectorInfo_;
        } else {
          return rotationVectorInfoBuilder_.getMessage();
        }
      }
      /**
       * <code>optional .Sensor_Info rotation_vector_info = 14;</code>
       */
      public Builder setRotationVectorInfo(Sensor_Info value) {
        if (rotationVectorInfoBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          rotationVectorInfo_ = value;
          onChanged();
        } else {
          rotationVectorInfoBuilder_.setMessage(value);
        }

        return this;
      }
      /**
       * <code>optional .Sensor_Info rotation_vector_info = 14;</code>
       */
      public Builder setRotationVectorInfo(
          Sensor_Info.Builder builderForValue) {
        if (rotationVectorInfoBuilder_ == null) {
          rotationVectorInfo_ = builderForValue.build();
          onChanged();
        } else {
          rotationVectorInfoBuilder_.setMessage(builderForValue.build());
        }

        return this;
      }
      /**
       * <code>optional .Sensor_Info rotation_vector_info = 14;</code>
       */
      public Builder mergeRotationVectorInfo(Sensor_Info value) {
        if (rotationVectorInfoBuilder_ == null) {
          if (rotationVectorInfo_ != null) {
            rotationVectorInfo_ =
              Sensor_Info.newBuilder(rotationVectorInfo_).mergeFrom(value).buildPartial();
          } else {
            rotationVectorInfo_ = value;
          }
          onChanged();
        } else {
          rotationVectorInfoBuilder_.mergeFrom(value);
        }

        return this;
      }
      /**
       * <code>optional .Sensor_Info rotation_vector_info = 14;</code>
       */
      public Builder clearRotationVectorInfo() {
        if (rotationVectorInfoBuilder_ == null) {
          rotationVectorInfo_ = null;
          onChanged();
        } else {
          rotationVectorInfo_ = null;
          rotationVectorInfoBuilder_ = null;
        }

        return this;
      }
      /**
       * <code>optional .Sensor_Info rotation_vector_info = 14;</code>
       */
      public Sensor_Info.Builder getRotationVectorInfoBuilder() {
        
        onChanged();
        return getRotationVectorInfoFieldBuilder().getBuilder();
      }
      /**
       * <code>optional .Sensor_Info rotation_vector_info = 14;</code>
       */
      public Sensor_InfoOrBuilder getRotationVectorInfoOrBuilder() {
        if (rotationVectorInfoBuilder_ != null) {
          return rotationVectorInfoBuilder_.getMessageOrBuilder();
        } else {
          return rotationVectorInfo_ == null ?
              Sensor_Info.getDefaultInstance() : rotationVectorInfo_;
        }
      }
      /**
       * <code>optional .Sensor_Info rotation_vector_info = 14;</code>
       */
      private com.google.protobuf.SingleFieldBuilderV3<
          Sensor_Info, Sensor_Info.Builder, Sensor_InfoOrBuilder>
          getRotationVectorInfoFieldBuilder() {
        if (rotationVectorInfoBuilder_ == null) {
          rotationVectorInfoBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
              Sensor_Info, Sensor_Info.Builder, Sensor_InfoOrBuilder>(
                  getRotationVectorInfo(),
                  getParentForChildren(),
                  isClean());
          rotationVectorInfo_ = null;
        }
        return rotationVectorInfoBuilder_;
      }

      private Sensor_Info magnetometerInfo_ = null;
      private com.google.protobuf.SingleFieldBuilderV3<
          Sensor_Info, Sensor_Info.Builder, Sensor_InfoOrBuilder> magnetometerInfoBuilder_;
      /**
       * <code>optional .Sensor_Info magnetometer_info = 15;</code>
       */
      public boolean hasMagnetometerInfo() {
        return magnetometerInfoBuilder_ != null || magnetometerInfo_ != null;
      }
      /**
       * <code>optional .Sensor_Info magnetometer_info = 15;</code>
       */
      public Sensor_Info getMagnetometerInfo() {
        if (magnetometerInfoBuilder_ == null) {
          return magnetometerInfo_ == null ? Sensor_Info.getDefaultInstance() : magnetometerInfo_;
        } else {
          return magnetometerInfoBuilder_.getMessage();
        }
      }
      /**
       * <code>optional .Sensor_Info magnetometer_info = 15;</code>
       */
      public Builder setMagnetometerInfo(Sensor_Info value) {
        if (magnetometerInfoBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          magnetometerInfo_ = value;
          onChanged();
        } else {
          magnetometerInfoBuilder_.setMessage(value);
        }

        return this;
      }
      /**
       * <code>optional .Sensor_Info magnetometer_info = 15;</code>
       */
      public Builder setMagnetometerInfo(
          Sensor_Info.Builder builderForValue) {
        if (magnetometerInfoBuilder_ == null) {
          magnetometerInfo_ = builderForValue.build();
          onChanged();
        } else {
          magnetometerInfoBuilder_.setMessage(builderForValue.build());
        }

        return this;
      }
      /**
       * <code>optional .Sensor_Info magnetometer_info = 15;</code>
       */
      public Builder mergeMagnetometerInfo(Sensor_Info value) {
        if (magnetometerInfoBuilder_ == null) {
          if (magnetometerInfo_ != null) {
            magnetometerInfo_ =
              Sensor_Info.newBuilder(magnetometerInfo_).mergeFrom(value).buildPartial();
          } else {
            magnetometerInfo_ = value;
          }
          onChanged();
        } else {
          magnetometerInfoBuilder_.mergeFrom(value);
        }

        return this;
      }
      /**
       * <code>optional .Sensor_Info magnetometer_info = 15;</code>
       */
      public Builder clearMagnetometerInfo() {
        if (magnetometerInfoBuilder_ == null) {
          magnetometerInfo_ = null;
          onChanged();
        } else {
          magnetometerInfo_ = null;
          magnetometerInfoBuilder_ = null;
        }

        return this;
      }
      /**
       * <code>optional .Sensor_Info magnetometer_info = 15;</code>
       */
      public Sensor_Info.Builder getMagnetometerInfoBuilder() {
        
        onChanged();
        return getMagnetometerInfoFieldBuilder().getBuilder();
      }
      /**
       * <code>optional .Sensor_Info magnetometer_info = 15;</code>
       */
      public Sensor_InfoOrBuilder getMagnetometerInfoOrBuilder() {
        if (magnetometerInfoBuilder_ != null) {
          return magnetometerInfoBuilder_.getMessageOrBuilder();
        } else {
          return magnetometerInfo_ == null ?
              Sensor_Info.getDefaultInstance() : magnetometerInfo_;
        }
      }
      /**
       * <code>optional .Sensor_Info magnetometer_info = 15;</code>
       */
      private com.google.protobuf.SingleFieldBuilderV3<
          Sensor_Info, Sensor_Info.Builder, Sensor_InfoOrBuilder>
          getMagnetometerInfoFieldBuilder() {
        if (magnetometerInfoBuilder_ == null) {
          magnetometerInfoBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
              Sensor_Info, Sensor_Info.Builder, Sensor_InfoOrBuilder>(
                  getMagnetometerInfo(),
                  getParentForChildren(),
                  isClean());
          magnetometerInfo_ = null;
        }
        return magnetometerInfoBuilder_;
      }

      private Sensor_Info barometerInfo_ = null;
      private com.google.protobuf.SingleFieldBuilderV3<
          Sensor_Info, Sensor_Info.Builder, Sensor_InfoOrBuilder> barometerInfoBuilder_;
      /**
       * <code>optional .Sensor_Info barometer_info = 16;</code>
       */
      public boolean hasBarometerInfo() {
        return barometerInfoBuilder_ != null || barometerInfo_ != null;
      }
      /**
       * <code>optional .Sensor_Info barometer_info = 16;</code>
       */
      public Sensor_Info getBarometerInfo() {
        if (barometerInfoBuilder_ == null) {
          return barometerInfo_ == null ? Sensor_Info.getDefaultInstance() : barometerInfo_;
        } else {
          return barometerInfoBuilder_.getMessage();
        }
      }
      /**
       * <code>optional .Sensor_Info barometer_info = 16;</code>
       */
      public Builder setBarometerInfo(Sensor_Info value) {
        if (barometerInfoBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          barometerInfo_ = value;
          onChanged();
        } else {
          barometerInfoBuilder_.setMessage(value);
        }

        return this;
      }
      /**
       * <code>optional .Sensor_Info barometer_info = 16;</code>
       */
      public Builder setBarometerInfo(
          Sensor_Info.Builder builderForValue) {
        if (barometerInfoBuilder_ == null) {
          barometerInfo_ = builderForValue.build();
          onChanged();
        } else {
          barometerInfoBuilder_.setMessage(builderForValue.build());
        }

        return this;
      }
      /**
       * <code>optional .Sensor_Info barometer_info = 16;</code>
       */
      public Builder mergeBarometerInfo(Sensor_Info value) {
        if (barometerInfoBuilder_ == null) {
          if (barometerInfo_ != null) {
            barometerInfo_ =
              Sensor_Info.newBuilder(barometerInfo_).mergeFrom(value).buildPartial();
          } else {
            barometerInfo_ = value;
          }
          onChanged();
        } else {
          barometerInfoBuilder_.mergeFrom(value);
        }

        return this;
      }
      /**
       * <code>optional .Sensor_Info barometer_info = 16;</code>
       */
      public Builder clearBarometerInfo() {
        if (barometerInfoBuilder_ == null) {
          barometerInfo_ = null;
          onChanged();
        } else {
          barometerInfo_ = null;
          barometerInfoBuilder_ = null;
        }

        return this;
      }
      /**
       * <code>optional .Sensor_Info barometer_info = 16;</code>
       */
      public Sensor_Info.Builder getBarometerInfoBuilder() {
        
        onChanged();
        return getBarometerInfoFieldBuilder().getBuilder();
      }
      /**
       * <code>optional .Sensor_Info barometer_info = 16;</code>
       */
      public Sensor_InfoOrBuilder getBarometerInfoOrBuilder() {
        if (barometerInfoBuilder_ != null) {
          return barometerInfoBuilder_.getMessageOrBuilder();
        } else {
          return barometerInfo_ == null ?
              Sensor_Info.getDefaultInstance() : barometerInfo_;
        }
      }
      /**
       * <code>optional .Sensor_Info barometer_info = 16;</code>
       */
      private com.google.protobuf.SingleFieldBuilderV3<
          Sensor_Info, Sensor_Info.Builder, Sensor_InfoOrBuilder>
          getBarometerInfoFieldBuilder() {
        if (barometerInfoBuilder_ == null) {
          barometerInfoBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
              Sensor_Info, Sensor_Info.Builder, Sensor_InfoOrBuilder>(
                  getBarometerInfo(),
                  getParentForChildren(),
                  isClean());
          barometerInfo_ = null;
        }
        return barometerInfoBuilder_;
      }

      private Sensor_Info lightSensorInfo_ = null;
      private com.google.protobuf.SingleFieldBuilderV3<
          Sensor_Info, Sensor_Info.Builder, Sensor_InfoOrBuilder> lightSensorInfoBuilder_;
      /**
       * <code>optional .Sensor_Info light_sensor_info = 17;</code>
       */
      public boolean hasLightSensorInfo() {
        return lightSensorInfoBuilder_ != null || lightSensorInfo_ != null;
      }
      /**
       * <code>optional .Sensor_Info light_sensor_info = 17;</code>
       */
      public Sensor_Info getLightSensorInfo() {
        if (lightSensorInfoBuilder_ == null) {
          return lightSensorInfo_ == null ? Sensor_Info.getDefaultInstance() : lightSensorInfo_;
        } else {
          return lightSensorInfoBuilder_.getMessage();
        }
      }
      /**
       * <code>optional .Sensor_Info light_sensor_info = 17;</code>
       */
      public Builder setLightSensorInfo(Sensor_Info value) {
        if (lightSensorInfoBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          lightSensorInfo_ = value;
          onChanged();
        } else {
          lightSensorInfoBuilder_.setMessage(value);
        }

        return this;
      }
      /**
       * <code>optional .Sensor_Info light_sensor_info = 17;</code>
       */
      public Builder setLightSensorInfo(
          Sensor_Info.Builder builderForValue) {
        if (lightSensorInfoBuilder_ == null) {
          lightSensorInfo_ = builderForValue.build();
          onChanged();
        } else {
          lightSensorInfoBuilder_.setMessage(builderForValue.build());
        }

        return this;
      }
      /**
       * <code>optional .Sensor_Info light_sensor_info = 17;</code>
       */
      public Builder mergeLightSensorInfo(Sensor_Info value) {
        if (lightSensorInfoBuilder_ == null) {
          if (lightSensorInfo_ != null) {
            lightSensorInfo_ =
              Sensor_Info.newBuilder(lightSensorInfo_).mergeFrom(value).buildPartial();
          } else {
            lightSensorInfo_ = value;
          }
          onChanged();
        } else {
          lightSensorInfoBuilder_.mergeFrom(value);
        }

        return this;
      }
      /**
       * <code>optional .Sensor_Info light_sensor_info = 17;</code>
       */
      public Builder clearLightSensorInfo() {
        if (lightSensorInfoBuilder_ == null) {
          lightSensorInfo_ = null;
          onChanged();
        } else {
          lightSensorInfo_ = null;
          lightSensorInfoBuilder_ = null;
        }

        return this;
      }
      /**
       * <code>optional .Sensor_Info light_sensor_info = 17;</code>
       */
      public Sensor_Info.Builder getLightSensorInfoBuilder() {
        
        onChanged();
        return getLightSensorInfoFieldBuilder().getBuilder();
      }
      /**
       * <code>optional .Sensor_Info light_sensor_info = 17;</code>
       */
      public Sensor_InfoOrBuilder getLightSensorInfoOrBuilder() {
        if (lightSensorInfoBuilder_ != null) {
          return lightSensorInfoBuilder_.getMessageOrBuilder();
        } else {
          return lightSensorInfo_ == null ?
              Sensor_Info.getDefaultInstance() : lightSensorInfo_;
        }
      }
      /**
       * <code>optional .Sensor_Info light_sensor_info = 17;</code>
       */
      private com.google.protobuf.SingleFieldBuilderV3<
          Sensor_Info, Sensor_Info.Builder, Sensor_InfoOrBuilder>
          getLightSensorInfoFieldBuilder() {
        if (lightSensorInfoBuilder_ == null) {
          lightSensorInfoBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
              Sensor_Info, Sensor_Info.Builder, Sensor_InfoOrBuilder>(
                  getLightSensorInfo(),
                  getParentForChildren(),
                  isClean());
          lightSensorInfo_ = null;
        }
        return lightSensorInfoBuilder_;
      }
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }


      // @@protoc_insertion_point(builder_scope:Trajectory)
    }

    // @@protoc_insertion_point(class_scope:Trajectory)
    private static final Trajectory DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new Trajectory();
    }

    public static Trajectory getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<Trajectory>
        PARSER = new com.google.protobuf.AbstractParser<Trajectory>() {
      public Trajectory parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new Trajectory(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<Trajectory> parser() {
      return PARSER;
    }

    @Override
    public com.google.protobuf.Parser<Trajectory> getParserForType() {
      return PARSER;
    }

    public Trajectory getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  public interface Pdr_SampleOrBuilder extends
      // @@protoc_insertion_point(interface_extends:Pdr_Sample)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <pre>
     * milliseconds from the start_timestamp
     * </pre>
     *
     * <code>optional int64 relative_timestamp = 1;</code>
     */
    long getRelativeTimestamp();

    /**
     * <pre>
     * Both in metres. You should implement an algorithm to estimate
     * these values. The values are always relative to your start point
     * so the first entry should always be x = 0.0, y = 0.0
     * </pre>
     *
     * <code>optional float x = 2;</code>
     */
    float getX();

    /**
     * <code>optional float y = 3;</code>
     */
    float getY();
  }
  /**
   * Protobuf type {@code Pdr_Sample}
   */
  public  static final class Pdr_Sample extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:Pdr_Sample)
      Pdr_SampleOrBuilder {
    // Use Pdr_Sample.newBuilder() to construct.
    private Pdr_Sample(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private Pdr_Sample() {
      relativeTimestamp_ = 0L;
      x_ = 0F;
      y_ = 0F;
    }

    @Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
    }
    private Pdr_Sample(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      int mutable_bitField0_ = 0;
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!input.skipField(tag)) {
                done = true;
              }
              break;
            }
            case 8: {

              relativeTimestamp_ = input.readInt64();
              break;
            }
            case 21: {

              x_ = input.readFloat();
              break;
            }
            case 29: {

              y_ = input.readFloat();
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return Traj.internal_static_Pdr_Sample_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return Traj.internal_static_Pdr_Sample_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              Pdr_Sample.class, Builder.class);
    }

    public static final int RELATIVE_TIMESTAMP_FIELD_NUMBER = 1;
    private long relativeTimestamp_;
    /**
     * <pre>
     * milliseconds from the start_timestamp
     * </pre>
     *
     * <code>optional int64 relative_timestamp = 1;</code>
     */
    public long getRelativeTimestamp() {
      return relativeTimestamp_;
    }

    public static final int X_FIELD_NUMBER = 2;
    private float x_;
    /**
     * <pre>
     * Both in metres. You should implement an algorithm to estimate
     * these values. The values are always relative to your start point
     * so the first entry should always be x = 0.0, y = 0.0
     * </pre>
     *
     * <code>optional float x = 2;</code>
     */
    public float getX() {
      return x_;
    }

    public static final int Y_FIELD_NUMBER = 3;
    private float y_;
    /**
     * <code>optional float y = 3;</code>
     */
    public float getY() {
      return y_;
    }

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (relativeTimestamp_ != 0L) {
        output.writeInt64(1, relativeTimestamp_);
      }
      if (x_ != 0F) {
        output.writeFloat(2, x_);
      }
      if (y_ != 0F) {
        output.writeFloat(3, y_);
      }
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (relativeTimestamp_ != 0L) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt64Size(1, relativeTimestamp_);
      }
      if (x_ != 0F) {
        size += com.google.protobuf.CodedOutputStream
          .computeFloatSize(2, x_);
      }
      if (y_ != 0F) {
        size += com.google.protobuf.CodedOutputStream
          .computeFloatSize(3, y_);
      }
      memoizedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @Override
    public boolean equals(final Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof Pdr_Sample)) {
        return super.equals(obj);
      }
      Pdr_Sample other = (Pdr_Sample) obj;

      boolean result = true;
      result = result && (getRelativeTimestamp()
          == other.getRelativeTimestamp());
      result = result && (
          Float.floatToIntBits(getX())
          == Float.floatToIntBits(
              other.getX()));
      result = result && (
          Float.floatToIntBits(getY())
          == Float.floatToIntBits(
              other.getY()));
      return result;
    }

    @Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptorForType().hashCode();
      hash = (37 * hash) + RELATIVE_TIMESTAMP_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          getRelativeTimestamp());
      hash = (37 * hash) + X_FIELD_NUMBER;
      hash = (53 * hash) + Float.floatToIntBits(
          getX());
      hash = (37 * hash) + Y_FIELD_NUMBER;
      hash = (53 * hash) + Float.floatToIntBits(
          getY());
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static Pdr_Sample parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Pdr_Sample parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Pdr_Sample parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Pdr_Sample parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Pdr_Sample parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static Pdr_Sample parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static Pdr_Sample parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static Pdr_Sample parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static Pdr_Sample parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static Pdr_Sample parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(Pdr_Sample prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code Pdr_Sample}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:Pdr_Sample)
        Pdr_SampleOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return Traj.internal_static_Pdr_Sample_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return Traj.internal_static_Pdr_Sample_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                Pdr_Sample.class, Builder.class);
      }

      // Construct using Traj.Pdr_Sample.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      public Builder clear() {
        super.clear();
        relativeTimestamp_ = 0L;

        x_ = 0F;

        y_ = 0F;

        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return Traj.internal_static_Pdr_Sample_descriptor;
      }

      public Pdr_Sample getDefaultInstanceForType() {
        return Pdr_Sample.getDefaultInstance();
      }

      public Pdr_Sample build() {
        Pdr_Sample result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public Pdr_Sample buildPartial() {
        Pdr_Sample result = new Pdr_Sample(this);
        result.relativeTimestamp_ = relativeTimestamp_;
        result.x_ = x_;
        result.y_ = y_;
        onBuilt();
        return result;
      }

      public Builder clone() {
        return (Builder) super.clone();
      }
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.setField(field, value);
      }
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof Pdr_Sample) {
          return mergeFrom((Pdr_Sample)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(Pdr_Sample other) {
        if (other == Pdr_Sample.getDefaultInstance()) return this;
        if (other.getRelativeTimestamp() != 0L) {
          setRelativeTimestamp(other.getRelativeTimestamp());
        }
        if (other.getX() != 0F) {
          setX(other.getX());
        }
        if (other.getY() != 0F) {
          setY(other.getY());
        }
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        Pdr_Sample parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (Pdr_Sample) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private long relativeTimestamp_ ;
      /**
       * <pre>
       * milliseconds from the start_timestamp
       * </pre>
       *
       * <code>optional int64 relative_timestamp = 1;</code>
       */
      public long getRelativeTimestamp() {
        return relativeTimestamp_;
      }
      /**
       * <pre>
       * milliseconds from the start_timestamp
       * </pre>
       *
       * <code>optional int64 relative_timestamp = 1;</code>
       */
      public Builder setRelativeTimestamp(long value) {
        
        relativeTimestamp_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       * milliseconds from the start_timestamp
       * </pre>
       *
       * <code>optional int64 relative_timestamp = 1;</code>
       */
      public Builder clearRelativeTimestamp() {
        
        relativeTimestamp_ = 0L;
        onChanged();
        return this;
      }

      private float x_ ;
      /**
       * <pre>
       * Both in metres. You should implement an algorithm to estimate
       * these values. The values are always relative to your start point
       * so the first entry should always be x = 0.0, y = 0.0
       * </pre>
       *
       * <code>optional float x = 2;</code>
       */
      public float getX() {
        return x_;
      }
      /**
       * <pre>
       * Both in metres. You should implement an algorithm to estimate
       * these values. The values are always relative to your start point
       * so the first entry should always be x = 0.0, y = 0.0
       * </pre>
       *
       * <code>optional float x = 2;</code>
       */
      public Builder setX(float value) {
        
        x_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       * Both in metres. You should implement an algorithm to estimate
       * these values. The values are always relative to your start point
       * so the first entry should always be x = 0.0, y = 0.0
       * </pre>
       *
       * <code>optional float x = 2;</code>
       */
      public Builder clearX() {
        
        x_ = 0F;
        onChanged();
        return this;
      }

      private float y_ ;
      /**
       * <code>optional float y = 3;</code>
       */
      public float getY() {
        return y_;
      }
      /**
       * <code>optional float y = 3;</code>
       */
      public Builder setY(float value) {
        
        y_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional float y = 3;</code>
       */
      public Builder clearY() {
        
        y_ = 0F;
        onChanged();
        return this;
      }
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }


      // @@protoc_insertion_point(builder_scope:Pdr_Sample)
    }

    // @@protoc_insertion_point(class_scope:Pdr_Sample)
    private static final Pdr_Sample DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new Pdr_Sample();
    }

    public static Pdr_Sample getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<Pdr_Sample>
        PARSER = new com.google.protobuf.AbstractParser<Pdr_Sample>() {
      public Pdr_Sample parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new Pdr_Sample(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<Pdr_Sample> parser() {
      return PARSER;
    }

    @Override
    public com.google.protobuf.Parser<Pdr_Sample> getParserForType() {
      return PARSER;
    }

    public Pdr_Sample getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  public interface Motion_SampleOrBuilder extends
      // @@protoc_insertion_point(interface_extends:Motion_Sample)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <pre>
     * milliseconds
     * </pre>
     *
     * <code>optional int64 relative_timestamp = 1;</code>
     */
    long getRelativeTimestamp();

    /**
     * <pre>
     * m/s^2
     * </pre>
     *
     * <code>optional float acc_x = 2;</code>
     */
    float getAccX();

    /**
     * <code>optional float acc_y = 3;</code>
     */
    float getAccY();

    /**
     * <code>optional float acc_z = 4;</code>
     */
    float getAccZ();

    /**
     * <pre>
     * radians/s
     * </pre>
     *
     * <code>optional float gyr_x = 5;</code>
     */
    float getGyrX();

    /**
     * <code>optional float gyr_y = 6;</code>
     */
    float getGyrY();

    /**
     * <code>optional float gyr_z = 7;</code>
     */
    float getGyrZ();

    /**
     * <pre>
     * unitless, 4 components should sum to ~1
     * </pre>
     *
     * <code>optional float rotation_vector_x = 8;</code>
     */
    float getRotationVectorX();

    /**
     * <code>optional float rotation_vector_y = 9;</code>
     */
    float getRotationVectorY();

    /**
     * <code>optional float rotation_vector_z = 10;</code>
     */
    float getRotationVectorZ();

    /**
     * <code>optional float rotation_vector_w = 11;</code>
     */
    float getRotationVectorW();

    /**
     * <pre>
     * Integer
     * </pre>
     *
     * <code>optional int32 step_count = 12;</code>
     */
    int getStepCount();
  }
  /**
   * Protobuf type {@code Motion_Sample}
   */
  public  static final class Motion_Sample extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:Motion_Sample)
      Motion_SampleOrBuilder {
    // Use Motion_Sample.newBuilder() to construct.
    private Motion_Sample(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private Motion_Sample() {
      relativeTimestamp_ = 0L;
      accX_ = 0F;
      accY_ = 0F;
      accZ_ = 0F;
      gyrX_ = 0F;
      gyrY_ = 0F;
      gyrZ_ = 0F;
      rotationVectorX_ = 0F;
      rotationVectorY_ = 0F;
      rotationVectorZ_ = 0F;
      rotationVectorW_ = 0F;
      stepCount_ = 0;
    }

    @Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
    }
    private Motion_Sample(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      int mutable_bitField0_ = 0;
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!input.skipField(tag)) {
                done = true;
              }
              break;
            }
            case 8: {

              relativeTimestamp_ = input.readInt64();
              break;
            }
            case 21: {

              accX_ = input.readFloat();
              break;
            }
            case 29: {

              accY_ = input.readFloat();
              break;
            }
            case 37: {

              accZ_ = input.readFloat();
              break;
            }
            case 45: {

              gyrX_ = input.readFloat();
              break;
            }
            case 53: {

              gyrY_ = input.readFloat();
              break;
            }
            case 61: {

              gyrZ_ = input.readFloat();
              break;
            }
            case 69: {

              rotationVectorX_ = input.readFloat();
              break;
            }
            case 77: {

              rotationVectorY_ = input.readFloat();
              break;
            }
            case 85: {

              rotationVectorZ_ = input.readFloat();
              break;
            }
            case 93: {

              rotationVectorW_ = input.readFloat();
              break;
            }
            case 96: {

              stepCount_ = input.readInt32();
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return Traj.internal_static_Motion_Sample_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return Traj.internal_static_Motion_Sample_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              Motion_Sample.class, Builder.class);
    }

    public static final int RELATIVE_TIMESTAMP_FIELD_NUMBER = 1;
    private long relativeTimestamp_;
    /**
     * <pre>
     * milliseconds
     * </pre>
     *
     * <code>optional int64 relative_timestamp = 1;</code>
     */
    public long getRelativeTimestamp() {
      return relativeTimestamp_;
    }

    public static final int ACC_X_FIELD_NUMBER = 2;
    private float accX_;
    /**
     * <pre>
     * m/s^2
     * </pre>
     *
     * <code>optional float acc_x = 2;</code>
     */
    public float getAccX() {
      return accX_;
    }

    public static final int ACC_Y_FIELD_NUMBER = 3;
    private float accY_;
    /**
     * <code>optional float acc_y = 3;</code>
     */
    public float getAccY() {
      return accY_;
    }

    public static final int ACC_Z_FIELD_NUMBER = 4;
    private float accZ_;
    /**
     * <code>optional float acc_z = 4;</code>
     */
    public float getAccZ() {
      return accZ_;
    }

    public static final int GYR_X_FIELD_NUMBER = 5;
    private float gyrX_;
    /**
     * <pre>
     * radians/s
     * </pre>
     *
     * <code>optional float gyr_x = 5;</code>
     */
    public float getGyrX() {
      return gyrX_;
    }

    public static final int GYR_Y_FIELD_NUMBER = 6;
    private float gyrY_;
    /**
     * <code>optional float gyr_y = 6;</code>
     */
    public float getGyrY() {
      return gyrY_;
    }

    public static final int GYR_Z_FIELD_NUMBER = 7;
    private float gyrZ_;
    /**
     * <code>optional float gyr_z = 7;</code>
     */
    public float getGyrZ() {
      return gyrZ_;
    }

    public static final int ROTATION_VECTOR_X_FIELD_NUMBER = 8;
    private float rotationVectorX_;
    /**
     * <pre>
     * unitless, 4 components should sum to ~1
     * </pre>
     *
     * <code>optional float rotation_vector_x = 8;</code>
     */
    public float getRotationVectorX() {
      return rotationVectorX_;
    }

    public static final int ROTATION_VECTOR_Y_FIELD_NUMBER = 9;
    private float rotationVectorY_;
    /**
     * <code>optional float rotation_vector_y = 9;</code>
     */
    public float getRotationVectorY() {
      return rotationVectorY_;
    }

    public static final int ROTATION_VECTOR_Z_FIELD_NUMBER = 10;
    private float rotationVectorZ_;
    /**
     * <code>optional float rotation_vector_z = 10;</code>
     */
    public float getRotationVectorZ() {
      return rotationVectorZ_;
    }

    public static final int ROTATION_VECTOR_W_FIELD_NUMBER = 11;
    private float rotationVectorW_;
    /**
     * <code>optional float rotation_vector_w = 11;</code>
     */
    public float getRotationVectorW() {
      return rotationVectorW_;
    }

    public static final int STEP_COUNT_FIELD_NUMBER = 12;
    private int stepCount_;
    /**
     * <pre>
     * Integer
     * </pre>
     *
     * <code>optional int32 step_count = 12;</code>
     */
    public int getStepCount() {
      return stepCount_;
    }

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (relativeTimestamp_ != 0L) {
        output.writeInt64(1, relativeTimestamp_);
      }
      if (accX_ != 0F) {
        output.writeFloat(2, accX_);
      }
      if (accY_ != 0F) {
        output.writeFloat(3, accY_);
      }
      if (accZ_ != 0F) {
        output.writeFloat(4, accZ_);
      }
      if (gyrX_ != 0F) {
        output.writeFloat(5, gyrX_);
      }
      if (gyrY_ != 0F) {
        output.writeFloat(6, gyrY_);
      }
      if (gyrZ_ != 0F) {
        output.writeFloat(7, gyrZ_);
      }
      if (rotationVectorX_ != 0F) {
        output.writeFloat(8, rotationVectorX_);
      }
      if (rotationVectorY_ != 0F) {
        output.writeFloat(9, rotationVectorY_);
      }
      if (rotationVectorZ_ != 0F) {
        output.writeFloat(10, rotationVectorZ_);
      }
      if (rotationVectorW_ != 0F) {
        output.writeFloat(11, rotationVectorW_);
      }
      if (stepCount_ != 0) {
        output.writeInt32(12, stepCount_);
      }
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (relativeTimestamp_ != 0L) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt64Size(1, relativeTimestamp_);
      }
      if (accX_ != 0F) {
        size += com.google.protobuf.CodedOutputStream
          .computeFloatSize(2, accX_);
      }
      if (accY_ != 0F) {
        size += com.google.protobuf.CodedOutputStream
          .computeFloatSize(3, accY_);
      }
      if (accZ_ != 0F) {
        size += com.google.protobuf.CodedOutputStream
          .computeFloatSize(4, accZ_);
      }
      if (gyrX_ != 0F) {
        size += com.google.protobuf.CodedOutputStream
          .computeFloatSize(5, gyrX_);
      }
      if (gyrY_ != 0F) {
        size += com.google.protobuf.CodedOutputStream
          .computeFloatSize(6, gyrY_);
      }
      if (gyrZ_ != 0F) {
        size += com.google.protobuf.CodedOutputStream
          .computeFloatSize(7, gyrZ_);
      }
      if (rotationVectorX_ != 0F) {
        size += com.google.protobuf.CodedOutputStream
          .computeFloatSize(8, rotationVectorX_);
      }
      if (rotationVectorY_ != 0F) {
        size += com.google.protobuf.CodedOutputStream
          .computeFloatSize(9, rotationVectorY_);
      }
      if (rotationVectorZ_ != 0F) {
        size += com.google.protobuf.CodedOutputStream
          .computeFloatSize(10, rotationVectorZ_);
      }
      if (rotationVectorW_ != 0F) {
        size += com.google.protobuf.CodedOutputStream
          .computeFloatSize(11, rotationVectorW_);
      }
      if (stepCount_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(12, stepCount_);
      }
      memoizedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @Override
    public boolean equals(final Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof Motion_Sample)) {
        return super.equals(obj);
      }
      Motion_Sample other = (Motion_Sample) obj;

      boolean result = true;
      result = result && (getRelativeTimestamp()
          == other.getRelativeTimestamp());
      result = result && (
          Float.floatToIntBits(getAccX())
          == Float.floatToIntBits(
              other.getAccX()));
      result = result && (
          Float.floatToIntBits(getAccY())
          == Float.floatToIntBits(
              other.getAccY()));
      result = result && (
          Float.floatToIntBits(getAccZ())
          == Float.floatToIntBits(
              other.getAccZ()));
      result = result && (
          Float.floatToIntBits(getGyrX())
          == Float.floatToIntBits(
              other.getGyrX()));
      result = result && (
          Float.floatToIntBits(getGyrY())
          == Float.floatToIntBits(
              other.getGyrY()));
      result = result && (
          Float.floatToIntBits(getGyrZ())
          == Float.floatToIntBits(
              other.getGyrZ()));
      result = result && (
          Float.floatToIntBits(getRotationVectorX())
          == Float.floatToIntBits(
              other.getRotationVectorX()));
      result = result && (
          Float.floatToIntBits(getRotationVectorY())
          == Float.floatToIntBits(
              other.getRotationVectorY()));
      result = result && (
          Float.floatToIntBits(getRotationVectorZ())
          == Float.floatToIntBits(
              other.getRotationVectorZ()));
      result = result && (
          Float.floatToIntBits(getRotationVectorW())
          == Float.floatToIntBits(
              other.getRotationVectorW()));
      result = result && (getStepCount()
          == other.getStepCount());
      return result;
    }

    @Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptorForType().hashCode();
      hash = (37 * hash) + RELATIVE_TIMESTAMP_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          getRelativeTimestamp());
      hash = (37 * hash) + ACC_X_FIELD_NUMBER;
      hash = (53 * hash) + Float.floatToIntBits(
          getAccX());
      hash = (37 * hash) + ACC_Y_FIELD_NUMBER;
      hash = (53 * hash) + Float.floatToIntBits(
          getAccY());
      hash = (37 * hash) + ACC_Z_FIELD_NUMBER;
      hash = (53 * hash) + Float.floatToIntBits(
          getAccZ());
      hash = (37 * hash) + GYR_X_FIELD_NUMBER;
      hash = (53 * hash) + Float.floatToIntBits(
          getGyrX());
      hash = (37 * hash) + GYR_Y_FIELD_NUMBER;
      hash = (53 * hash) + Float.floatToIntBits(
          getGyrY());
      hash = (37 * hash) + GYR_Z_FIELD_NUMBER;
      hash = (53 * hash) + Float.floatToIntBits(
          getGyrZ());
      hash = (37 * hash) + ROTATION_VECTOR_X_FIELD_NUMBER;
      hash = (53 * hash) + Float.floatToIntBits(
          getRotationVectorX());
      hash = (37 * hash) + ROTATION_VECTOR_Y_FIELD_NUMBER;
      hash = (53 * hash) + Float.floatToIntBits(
          getRotationVectorY());
      hash = (37 * hash) + ROTATION_VECTOR_Z_FIELD_NUMBER;
      hash = (53 * hash) + Float.floatToIntBits(
          getRotationVectorZ());
      hash = (37 * hash) + ROTATION_VECTOR_W_FIELD_NUMBER;
      hash = (53 * hash) + Float.floatToIntBits(
          getRotationVectorW());
      hash = (37 * hash) + STEP_COUNT_FIELD_NUMBER;
      hash = (53 * hash) + getStepCount();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static Motion_Sample parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Motion_Sample parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Motion_Sample parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Motion_Sample parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Motion_Sample parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static Motion_Sample parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static Motion_Sample parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static Motion_Sample parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static Motion_Sample parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static Motion_Sample parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(Motion_Sample prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code Motion_Sample}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:Motion_Sample)
        Motion_SampleOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return Traj.internal_static_Motion_Sample_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return Traj.internal_static_Motion_Sample_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                Motion_Sample.class, Builder.class);
      }

      // Construct using Traj.Motion_Sample.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      public Builder clear() {
        super.clear();
        relativeTimestamp_ = 0L;

        accX_ = 0F;

        accY_ = 0F;

        accZ_ = 0F;

        gyrX_ = 0F;

        gyrY_ = 0F;

        gyrZ_ = 0F;

        rotationVectorX_ = 0F;

        rotationVectorY_ = 0F;

        rotationVectorZ_ = 0F;

        rotationVectorW_ = 0F;

        stepCount_ = 0;

        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return Traj.internal_static_Motion_Sample_descriptor;
      }

      public Motion_Sample getDefaultInstanceForType() {
        return Motion_Sample.getDefaultInstance();
      }

      public Motion_Sample build() {
        Motion_Sample result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public Motion_Sample buildPartial() {
        Motion_Sample result = new Motion_Sample(this);
        result.relativeTimestamp_ = relativeTimestamp_;
        result.accX_ = accX_;
        result.accY_ = accY_;
        result.accZ_ = accZ_;
        result.gyrX_ = gyrX_;
        result.gyrY_ = gyrY_;
        result.gyrZ_ = gyrZ_;
        result.rotationVectorX_ = rotationVectorX_;
        result.rotationVectorY_ = rotationVectorY_;
        result.rotationVectorZ_ = rotationVectorZ_;
        result.rotationVectorW_ = rotationVectorW_;
        result.stepCount_ = stepCount_;
        onBuilt();
        return result;
      }

      public Builder clone() {
        return (Builder) super.clone();
      }
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.setField(field, value);
      }
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof Motion_Sample) {
          return mergeFrom((Motion_Sample)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(Motion_Sample other) {
        if (other == Motion_Sample.getDefaultInstance()) return this;
        if (other.getRelativeTimestamp() != 0L) {
          setRelativeTimestamp(other.getRelativeTimestamp());
        }
        if (other.getAccX() != 0F) {
          setAccX(other.getAccX());
        }
        if (other.getAccY() != 0F) {
          setAccY(other.getAccY());
        }
        if (other.getAccZ() != 0F) {
          setAccZ(other.getAccZ());
        }
        if (other.getGyrX() != 0F) {
          setGyrX(other.getGyrX());
        }
        if (other.getGyrY() != 0F) {
          setGyrY(other.getGyrY());
        }
        if (other.getGyrZ() != 0F) {
          setGyrZ(other.getGyrZ());
        }
        if (other.getRotationVectorX() != 0F) {
          setRotationVectorX(other.getRotationVectorX());
        }
        if (other.getRotationVectorY() != 0F) {
          setRotationVectorY(other.getRotationVectorY());
        }
        if (other.getRotationVectorZ() != 0F) {
          setRotationVectorZ(other.getRotationVectorZ());
        }
        if (other.getRotationVectorW() != 0F) {
          setRotationVectorW(other.getRotationVectorW());
        }
        if (other.getStepCount() != 0) {
          setStepCount(other.getStepCount());
        }
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        Motion_Sample parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (Motion_Sample) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private long relativeTimestamp_ ;
      /**
       * <pre>
       * milliseconds
       * </pre>
       *
       * <code>optional int64 relative_timestamp = 1;</code>
       */
      public long getRelativeTimestamp() {
        return relativeTimestamp_;
      }
      /**
       * <pre>
       * milliseconds
       * </pre>
       *
       * <code>optional int64 relative_timestamp = 1;</code>
       */
      public Builder setRelativeTimestamp(long value) {
        
        relativeTimestamp_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       * milliseconds
       * </pre>
       *
       * <code>optional int64 relative_timestamp = 1;</code>
       */
      public Builder clearRelativeTimestamp() {
        
        relativeTimestamp_ = 0L;
        onChanged();
        return this;
      }

      private float accX_ ;
      /**
       * <pre>
       * m/s^2
       * </pre>
       *
       * <code>optional float acc_x = 2;</code>
       */
      public float getAccX() {
        return accX_;
      }
      /**
       * <pre>
       * m/s^2
       * </pre>
       *
       * <code>optional float acc_x = 2;</code>
       */
      public Builder setAccX(float value) {
        
        accX_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       * m/s^2
       * </pre>
       *
       * <code>optional float acc_x = 2;</code>
       */
      public Builder clearAccX() {
        
        accX_ = 0F;
        onChanged();
        return this;
      }

      private float accY_ ;
      /**
       * <code>optional float acc_y = 3;</code>
       */
      public float getAccY() {
        return accY_;
      }
      /**
       * <code>optional float acc_y = 3;</code>
       */
      public Builder setAccY(float value) {
        
        accY_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional float acc_y = 3;</code>
       */
      public Builder clearAccY() {
        
        accY_ = 0F;
        onChanged();
        return this;
      }

      private float accZ_ ;
      /**
       * <code>optional float acc_z = 4;</code>
       */
      public float getAccZ() {
        return accZ_;
      }
      /**
       * <code>optional float acc_z = 4;</code>
       */
      public Builder setAccZ(float value) {
        
        accZ_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional float acc_z = 4;</code>
       */
      public Builder clearAccZ() {
        
        accZ_ = 0F;
        onChanged();
        return this;
      }

      private float gyrX_ ;
      /**
       * <pre>
       * radians/s
       * </pre>
       *
       * <code>optional float gyr_x = 5;</code>
       */
      public float getGyrX() {
        return gyrX_;
      }
      /**
       * <pre>
       * radians/s
       * </pre>
       *
       * <code>optional float gyr_x = 5;</code>
       */
      public Builder setGyrX(float value) {
        
        gyrX_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       * radians/s
       * </pre>
       *
       * <code>optional float gyr_x = 5;</code>
       */
      public Builder clearGyrX() {
        
        gyrX_ = 0F;
        onChanged();
        return this;
      }

      private float gyrY_ ;
      /**
       * <code>optional float gyr_y = 6;</code>
       */
      public float getGyrY() {
        return gyrY_;
      }
      /**
       * <code>optional float gyr_y = 6;</code>
       */
      public Builder setGyrY(float value) {
        
        gyrY_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional float gyr_y = 6;</code>
       */
      public Builder clearGyrY() {
        
        gyrY_ = 0F;
        onChanged();
        return this;
      }

      private float gyrZ_ ;
      /**
       * <code>optional float gyr_z = 7;</code>
       */
      public float getGyrZ() {
        return gyrZ_;
      }
      /**
       * <code>optional float gyr_z = 7;</code>
       */
      public Builder setGyrZ(float value) {
        
        gyrZ_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional float gyr_z = 7;</code>
       */
      public Builder clearGyrZ() {
        
        gyrZ_ = 0F;
        onChanged();
        return this;
      }

      private float rotationVectorX_ ;
      /**
       * <pre>
       * unitless, 4 components should sum to ~1
       * </pre>
       *
       * <code>optional float rotation_vector_x = 8;</code>
       */
      public float getRotationVectorX() {
        return rotationVectorX_;
      }
      /**
       * <pre>
       * unitless, 4 components should sum to ~1
       * </pre>
       *
       * <code>optional float rotation_vector_x = 8;</code>
       */
      public Builder setRotationVectorX(float value) {
        
        rotationVectorX_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       * unitless, 4 components should sum to ~1
       * </pre>
       *
       * <code>optional float rotation_vector_x = 8;</code>
       */
      public Builder clearRotationVectorX() {
        
        rotationVectorX_ = 0F;
        onChanged();
        return this;
      }

      private float rotationVectorY_ ;
      /**
       * <code>optional float rotation_vector_y = 9;</code>
       */
      public float getRotationVectorY() {
        return rotationVectorY_;
      }
      /**
       * <code>optional float rotation_vector_y = 9;</code>
       */
      public Builder setRotationVectorY(float value) {
        
        rotationVectorY_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional float rotation_vector_y = 9;</code>
       */
      public Builder clearRotationVectorY() {
        
        rotationVectorY_ = 0F;
        onChanged();
        return this;
      }

      private float rotationVectorZ_ ;
      /**
       * <code>optional float rotation_vector_z = 10;</code>
       */
      public float getRotationVectorZ() {
        return rotationVectorZ_;
      }
      /**
       * <code>optional float rotation_vector_z = 10;</code>
       */
      public Builder setRotationVectorZ(float value) {
        
        rotationVectorZ_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional float rotation_vector_z = 10;</code>
       */
      public Builder clearRotationVectorZ() {
        
        rotationVectorZ_ = 0F;
        onChanged();
        return this;
      }

      private float rotationVectorW_ ;
      /**
       * <code>optional float rotation_vector_w = 11;</code>
       */
      public float getRotationVectorW() {
        return rotationVectorW_;
      }
      /**
       * <code>optional float rotation_vector_w = 11;</code>
       */
      public Builder setRotationVectorW(float value) {
        
        rotationVectorW_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional float rotation_vector_w = 11;</code>
       */
      public Builder clearRotationVectorW() {
        
        rotationVectorW_ = 0F;
        onChanged();
        return this;
      }

      private int stepCount_ ;
      /**
       * <pre>
       * Integer
       * </pre>
       *
       * <code>optional int32 step_count = 12;</code>
       */
      public int getStepCount() {
        return stepCount_;
      }
      /**
       * <pre>
       * Integer
       * </pre>
       *
       * <code>optional int32 step_count = 12;</code>
       */
      public Builder setStepCount(int value) {
        
        stepCount_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       * Integer
       * </pre>
       *
       * <code>optional int32 step_count = 12;</code>
       */
      public Builder clearStepCount() {
        
        stepCount_ = 0;
        onChanged();
        return this;
      }
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }


      // @@protoc_insertion_point(builder_scope:Motion_Sample)
    }

    // @@protoc_insertion_point(class_scope:Motion_Sample)
    private static final Motion_Sample DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new Motion_Sample();
    }

    public static Motion_Sample getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<Motion_Sample>
        PARSER = new com.google.protobuf.AbstractParser<Motion_Sample>() {
      public Motion_Sample parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new Motion_Sample(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<Motion_Sample> parser() {
      return PARSER;
    }

    @Override
    public com.google.protobuf.Parser<Motion_Sample> getParserForType() {
      return PARSER;
    }

    public Motion_Sample getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  public interface Position_SampleOrBuilder extends
      // @@protoc_insertion_point(interface_extends:Position_Sample)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>optional int64 relative_timestamp = 1;</code>
     */
    long getRelativeTimestamp();

    /**
     * <pre>
     * uT
     * </pre>
     *
     * <code>optional float mag_x = 2;</code>
     */
    float getMagX();

    /**
     * <code>optional float mag_y = 3;</code>
     */
    float getMagY();

    /**
     * <code>optional float mag_z = 4;</code>
     */
    float getMagZ();
  }
  /**
   * Protobuf type {@code Position_Sample}
   */
  public  static final class Position_Sample extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:Position_Sample)
      Position_SampleOrBuilder {
    // Use Position_Sample.newBuilder() to construct.
    private Position_Sample(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private Position_Sample() {
      relativeTimestamp_ = 0L;
      magX_ = 0F;
      magY_ = 0F;
      magZ_ = 0F;
    }

    @Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
    }
    private Position_Sample(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      int mutable_bitField0_ = 0;
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!input.skipField(tag)) {
                done = true;
              }
              break;
            }
            case 8: {

              relativeTimestamp_ = input.readInt64();
              break;
            }
            case 21: {

              magX_ = input.readFloat();
              break;
            }
            case 29: {

              magY_ = input.readFloat();
              break;
            }
            case 37: {

              magZ_ = input.readFloat();
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return Traj.internal_static_Position_Sample_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return Traj.internal_static_Position_Sample_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              Position_Sample.class, Builder.class);
    }

    public static final int RELATIVE_TIMESTAMP_FIELD_NUMBER = 1;
    private long relativeTimestamp_;
    /**
     * <code>optional int64 relative_timestamp = 1;</code>
     */
    public long getRelativeTimestamp() {
      return relativeTimestamp_;
    }

    public static final int MAG_X_FIELD_NUMBER = 2;
    private float magX_;
    /**
     * <pre>
     * uT
     * </pre>
     *
     * <code>optional float mag_x = 2;</code>
     */
    public float getMagX() {
      return magX_;
    }

    public static final int MAG_Y_FIELD_NUMBER = 3;
    private float magY_;
    /**
     * <code>optional float mag_y = 3;</code>
     */
    public float getMagY() {
      return magY_;
    }

    public static final int MAG_Z_FIELD_NUMBER = 4;
    private float magZ_;
    /**
     * <code>optional float mag_z = 4;</code>
     */
    public float getMagZ() {
      return magZ_;
    }

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (relativeTimestamp_ != 0L) {
        output.writeInt64(1, relativeTimestamp_);
      }
      if (magX_ != 0F) {
        output.writeFloat(2, magX_);
      }
      if (magY_ != 0F) {
        output.writeFloat(3, magY_);
      }
      if (magZ_ != 0F) {
        output.writeFloat(4, magZ_);
      }
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (relativeTimestamp_ != 0L) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt64Size(1, relativeTimestamp_);
      }
      if (magX_ != 0F) {
        size += com.google.protobuf.CodedOutputStream
          .computeFloatSize(2, magX_);
      }
      if (magY_ != 0F) {
        size += com.google.protobuf.CodedOutputStream
          .computeFloatSize(3, magY_);
      }
      if (magZ_ != 0F) {
        size += com.google.protobuf.CodedOutputStream
          .computeFloatSize(4, magZ_);
      }
      memoizedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @Override
    public boolean equals(final Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof Position_Sample)) {
        return super.equals(obj);
      }
      Position_Sample other = (Position_Sample) obj;

      boolean result = true;
      result = result && (getRelativeTimestamp()
          == other.getRelativeTimestamp());
      result = result && (
          Float.floatToIntBits(getMagX())
          == Float.floatToIntBits(
              other.getMagX()));
      result = result && (
          Float.floatToIntBits(getMagY())
          == Float.floatToIntBits(
              other.getMagY()));
      result = result && (
          Float.floatToIntBits(getMagZ())
          == Float.floatToIntBits(
              other.getMagZ()));
      return result;
    }

    @Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptorForType().hashCode();
      hash = (37 * hash) + RELATIVE_TIMESTAMP_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          getRelativeTimestamp());
      hash = (37 * hash) + MAG_X_FIELD_NUMBER;
      hash = (53 * hash) + Float.floatToIntBits(
          getMagX());
      hash = (37 * hash) + MAG_Y_FIELD_NUMBER;
      hash = (53 * hash) + Float.floatToIntBits(
          getMagY());
      hash = (37 * hash) + MAG_Z_FIELD_NUMBER;
      hash = (53 * hash) + Float.floatToIntBits(
          getMagZ());
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static Position_Sample parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Position_Sample parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Position_Sample parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Position_Sample parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Position_Sample parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static Position_Sample parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static Position_Sample parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static Position_Sample parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static Position_Sample parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static Position_Sample parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(Position_Sample prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code Position_Sample}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:Position_Sample)
        Position_SampleOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return Traj.internal_static_Position_Sample_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return Traj.internal_static_Position_Sample_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                Position_Sample.class, Builder.class);
      }

      // Construct using Traj.Position_Sample.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      public Builder clear() {
        super.clear();
        relativeTimestamp_ = 0L;

        magX_ = 0F;

        magY_ = 0F;

        magZ_ = 0F;

        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return Traj.internal_static_Position_Sample_descriptor;
      }

      public Position_Sample getDefaultInstanceForType() {
        return Position_Sample.getDefaultInstance();
      }

      public Position_Sample build() {
        Position_Sample result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public Position_Sample buildPartial() {
        Position_Sample result = new Position_Sample(this);
        result.relativeTimestamp_ = relativeTimestamp_;
        result.magX_ = magX_;
        result.magY_ = magY_;
        result.magZ_ = magZ_;
        onBuilt();
        return result;
      }

      public Builder clone() {
        return (Builder) super.clone();
      }
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.setField(field, value);
      }
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof Position_Sample) {
          return mergeFrom((Position_Sample)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(Position_Sample other) {
        if (other == Position_Sample.getDefaultInstance()) return this;
        if (other.getRelativeTimestamp() != 0L) {
          setRelativeTimestamp(other.getRelativeTimestamp());
        }
        if (other.getMagX() != 0F) {
          setMagX(other.getMagX());
        }
        if (other.getMagY() != 0F) {
          setMagY(other.getMagY());
        }
        if (other.getMagZ() != 0F) {
          setMagZ(other.getMagZ());
        }
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        Position_Sample parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (Position_Sample) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private long relativeTimestamp_ ;
      /**
       * <code>optional int64 relative_timestamp = 1;</code>
       */
      public long getRelativeTimestamp() {
        return relativeTimestamp_;
      }
      /**
       * <code>optional int64 relative_timestamp = 1;</code>
       */
      public Builder setRelativeTimestamp(long value) {
        
        relativeTimestamp_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional int64 relative_timestamp = 1;</code>
       */
      public Builder clearRelativeTimestamp() {
        
        relativeTimestamp_ = 0L;
        onChanged();
        return this;
      }

      private float magX_ ;
      /**
       * <pre>
       * uT
       * </pre>
       *
       * <code>optional float mag_x = 2;</code>
       */
      public float getMagX() {
        return magX_;
      }
      /**
       * <pre>
       * uT
       * </pre>
       *
       * <code>optional float mag_x = 2;</code>
       */
      public Builder setMagX(float value) {
        
        magX_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       * uT
       * </pre>
       *
       * <code>optional float mag_x = 2;</code>
       */
      public Builder clearMagX() {
        
        magX_ = 0F;
        onChanged();
        return this;
      }

      private float magY_ ;
      /**
       * <code>optional float mag_y = 3;</code>
       */
      public float getMagY() {
        return magY_;
      }
      /**
       * <code>optional float mag_y = 3;</code>
       */
      public Builder setMagY(float value) {
        
        magY_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional float mag_y = 3;</code>
       */
      public Builder clearMagY() {
        
        magY_ = 0F;
        onChanged();
        return this;
      }

      private float magZ_ ;
      /**
       * <code>optional float mag_z = 4;</code>
       */
      public float getMagZ() {
        return magZ_;
      }
      /**
       * <code>optional float mag_z = 4;</code>
       */
      public Builder setMagZ(float value) {
        
        magZ_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional float mag_z = 4;</code>
       */
      public Builder clearMagZ() {
        
        magZ_ = 0F;
        onChanged();
        return this;
      }
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }


      // @@protoc_insertion_point(builder_scope:Position_Sample)
    }

    // @@protoc_insertion_point(class_scope:Position_Sample)
    private static final Position_Sample DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new Position_Sample();
    }

    public static Position_Sample getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<Position_Sample>
        PARSER = new com.google.protobuf.AbstractParser<Position_Sample>() {
      public Position_Sample parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new Position_Sample(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<Position_Sample> parser() {
      return PARSER;
    }

    @Override
    public com.google.protobuf.Parser<Position_Sample> getParserForType() {
      return PARSER;
    }

    public Position_Sample getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  public interface Pressure_SampleOrBuilder extends
      // @@protoc_insertion_point(interface_extends:Pressure_Sample)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>optional int64 relative_timestamp = 1;</code>
     */
    long getRelativeTimestamp();

    /**
     * <pre>
     * mbar
     * </pre>
     *
     * <code>optional float pressure = 2;</code>
     */
    float getPressure();
  }
  /**
   * Protobuf type {@code Pressure_Sample}
   */
  public  static final class Pressure_Sample extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:Pressure_Sample)
      Pressure_SampleOrBuilder {
    // Use Pressure_Sample.newBuilder() to construct.
    private Pressure_Sample(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private Pressure_Sample() {
      relativeTimestamp_ = 0L;
      pressure_ = 0F;
    }

    @Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
    }
    private Pressure_Sample(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      int mutable_bitField0_ = 0;
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!input.skipField(tag)) {
                done = true;
              }
              break;
            }
            case 8: {

              relativeTimestamp_ = input.readInt64();
              break;
            }
            case 21: {

              pressure_ = input.readFloat();
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return Traj.internal_static_Pressure_Sample_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return Traj.internal_static_Pressure_Sample_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              Pressure_Sample.class, Builder.class);
    }

    public static final int RELATIVE_TIMESTAMP_FIELD_NUMBER = 1;
    private long relativeTimestamp_;
    /**
     * <code>optional int64 relative_timestamp = 1;</code>
     */
    public long getRelativeTimestamp() {
      return relativeTimestamp_;
    }

    public static final int PRESSURE_FIELD_NUMBER = 2;
    private float pressure_;
    /**
     * <pre>
     * mbar
     * </pre>
     *
     * <code>optional float pressure = 2;</code>
     */
    public float getPressure() {
      return pressure_;
    }

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (relativeTimestamp_ != 0L) {
        output.writeInt64(1, relativeTimestamp_);
      }
      if (pressure_ != 0F) {
        output.writeFloat(2, pressure_);
      }
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (relativeTimestamp_ != 0L) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt64Size(1, relativeTimestamp_);
      }
      if (pressure_ != 0F) {
        size += com.google.protobuf.CodedOutputStream
          .computeFloatSize(2, pressure_);
      }
      memoizedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @Override
    public boolean equals(final Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof Pressure_Sample)) {
        return super.equals(obj);
      }
      Pressure_Sample other = (Pressure_Sample) obj;

      boolean result = true;
      result = result && (getRelativeTimestamp()
          == other.getRelativeTimestamp());
      result = result && (
          Float.floatToIntBits(getPressure())
          == Float.floatToIntBits(
              other.getPressure()));
      return result;
    }

    @Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptorForType().hashCode();
      hash = (37 * hash) + RELATIVE_TIMESTAMP_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          getRelativeTimestamp());
      hash = (37 * hash) + PRESSURE_FIELD_NUMBER;
      hash = (53 * hash) + Float.floatToIntBits(
          getPressure());
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static Pressure_Sample parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Pressure_Sample parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Pressure_Sample parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Pressure_Sample parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Pressure_Sample parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static Pressure_Sample parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static Pressure_Sample parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static Pressure_Sample parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static Pressure_Sample parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static Pressure_Sample parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(Pressure_Sample prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code Pressure_Sample}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:Pressure_Sample)
        Pressure_SampleOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return Traj.internal_static_Pressure_Sample_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return Traj.internal_static_Pressure_Sample_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                Pressure_Sample.class, Builder.class);
      }

      // Construct using Traj.Pressure_Sample.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      public Builder clear() {
        super.clear();
        relativeTimestamp_ = 0L;

        pressure_ = 0F;

        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return Traj.internal_static_Pressure_Sample_descriptor;
      }

      public Pressure_Sample getDefaultInstanceForType() {
        return Pressure_Sample.getDefaultInstance();
      }

      public Pressure_Sample build() {
        Pressure_Sample result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public Pressure_Sample buildPartial() {
        Pressure_Sample result = new Pressure_Sample(this);
        result.relativeTimestamp_ = relativeTimestamp_;
        result.pressure_ = pressure_;
        onBuilt();
        return result;
      }

      public Builder clone() {
        return (Builder) super.clone();
      }
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.setField(field, value);
      }
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof Pressure_Sample) {
          return mergeFrom((Pressure_Sample)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(Pressure_Sample other) {
        if (other == Pressure_Sample.getDefaultInstance()) return this;
        if (other.getRelativeTimestamp() != 0L) {
          setRelativeTimestamp(other.getRelativeTimestamp());
        }
        if (other.getPressure() != 0F) {
          setPressure(other.getPressure());
        }
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        Pressure_Sample parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (Pressure_Sample) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private long relativeTimestamp_ ;
      /**
       * <code>optional int64 relative_timestamp = 1;</code>
       */
      public long getRelativeTimestamp() {
        return relativeTimestamp_;
      }
      /**
       * <code>optional int64 relative_timestamp = 1;</code>
       */
      public Builder setRelativeTimestamp(long value) {
        
        relativeTimestamp_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional int64 relative_timestamp = 1;</code>
       */
      public Builder clearRelativeTimestamp() {
        
        relativeTimestamp_ = 0L;
        onChanged();
        return this;
      }

      private float pressure_ ;
      /**
       * <pre>
       * mbar
       * </pre>
       *
       * <code>optional float pressure = 2;</code>
       */
      public float getPressure() {
        return pressure_;
      }
      /**
       * <pre>
       * mbar
       * </pre>
       *
       * <code>optional float pressure = 2;</code>
       */
      public Builder setPressure(float value) {
        
        pressure_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       * mbar
       * </pre>
       *
       * <code>optional float pressure = 2;</code>
       */
      public Builder clearPressure() {
        
        pressure_ = 0F;
        onChanged();
        return this;
      }
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }


      // @@protoc_insertion_point(builder_scope:Pressure_Sample)
    }

    // @@protoc_insertion_point(class_scope:Pressure_Sample)
    private static final Pressure_Sample DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new Pressure_Sample();
    }

    public static Pressure_Sample getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<Pressure_Sample>
        PARSER = new com.google.protobuf.AbstractParser<Pressure_Sample>() {
      public Pressure_Sample parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new Pressure_Sample(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<Pressure_Sample> parser() {
      return PARSER;
    }

    @Override
    public com.google.protobuf.Parser<Pressure_Sample> getParserForType() {
      return PARSER;
    }

    public Pressure_Sample getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  public interface Light_SampleOrBuilder extends
      // @@protoc_insertion_point(interface_extends:Light_Sample)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>optional int64 relative_timestamp = 1;</code>
     */
    long getRelativeTimestamp();

    /**
     * <pre>
     * lux
     * </pre>
     *
     * <code>optional float light = 2;</code>
     */
    float getLight();
  }
  /**
   * Protobuf type {@code Light_Sample}
   */
  public  static final class Light_Sample extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:Light_Sample)
      Light_SampleOrBuilder {
    // Use Light_Sample.newBuilder() to construct.
    private Light_Sample(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private Light_Sample() {
      relativeTimestamp_ = 0L;
      light_ = 0F;
    }

    @Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
    }
    private Light_Sample(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      int mutable_bitField0_ = 0;
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!input.skipField(tag)) {
                done = true;
              }
              break;
            }
            case 8: {

              relativeTimestamp_ = input.readInt64();
              break;
            }
            case 21: {

              light_ = input.readFloat();
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return Traj.internal_static_Light_Sample_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return Traj.internal_static_Light_Sample_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              Light_Sample.class, Builder.class);
    }

    public static final int RELATIVE_TIMESTAMP_FIELD_NUMBER = 1;
    private long relativeTimestamp_;
    /**
     * <code>optional int64 relative_timestamp = 1;</code>
     */
    public long getRelativeTimestamp() {
      return relativeTimestamp_;
    }

    public static final int LIGHT_FIELD_NUMBER = 2;
    private float light_;
    /**
     * <pre>
     * lux
     * </pre>
     *
     * <code>optional float light = 2;</code>
     */
    public float getLight() {
      return light_;
    }

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (relativeTimestamp_ != 0L) {
        output.writeInt64(1, relativeTimestamp_);
      }
      if (light_ != 0F) {
        output.writeFloat(2, light_);
      }
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (relativeTimestamp_ != 0L) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt64Size(1, relativeTimestamp_);
      }
      if (light_ != 0F) {
        size += com.google.protobuf.CodedOutputStream
          .computeFloatSize(2, light_);
      }
      memoizedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @Override
    public boolean equals(final Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof Light_Sample)) {
        return super.equals(obj);
      }
      Light_Sample other = (Light_Sample) obj;

      boolean result = true;
      result = result && (getRelativeTimestamp()
          == other.getRelativeTimestamp());
      result = result && (
          Float.floatToIntBits(getLight())
          == Float.floatToIntBits(
              other.getLight()));
      return result;
    }

    @Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptorForType().hashCode();
      hash = (37 * hash) + RELATIVE_TIMESTAMP_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          getRelativeTimestamp());
      hash = (37 * hash) + LIGHT_FIELD_NUMBER;
      hash = (53 * hash) + Float.floatToIntBits(
          getLight());
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static Light_Sample parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Light_Sample parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Light_Sample parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Light_Sample parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Light_Sample parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static Light_Sample parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static Light_Sample parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static Light_Sample parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static Light_Sample parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static Light_Sample parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(Light_Sample prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code Light_Sample}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:Light_Sample)
        Light_SampleOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return Traj.internal_static_Light_Sample_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return Traj.internal_static_Light_Sample_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                Light_Sample.class, Builder.class);
      }

      // Construct using Traj.Light_Sample.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      public Builder clear() {
        super.clear();
        relativeTimestamp_ = 0L;

        light_ = 0F;

        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return Traj.internal_static_Light_Sample_descriptor;
      }

      public Light_Sample getDefaultInstanceForType() {
        return Light_Sample.getDefaultInstance();
      }

      public Light_Sample build() {
        Light_Sample result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public Light_Sample buildPartial() {
        Light_Sample result = new Light_Sample(this);
        result.relativeTimestamp_ = relativeTimestamp_;
        result.light_ = light_;
        onBuilt();
        return result;
      }

      public Builder clone() {
        return (Builder) super.clone();
      }
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.setField(field, value);
      }
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof Light_Sample) {
          return mergeFrom((Light_Sample)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(Light_Sample other) {
        if (other == Light_Sample.getDefaultInstance()) return this;
        if (other.getRelativeTimestamp() != 0L) {
          setRelativeTimestamp(other.getRelativeTimestamp());
        }
        if (other.getLight() != 0F) {
          setLight(other.getLight());
        }
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        Light_Sample parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (Light_Sample) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private long relativeTimestamp_ ;
      /**
       * <code>optional int64 relative_timestamp = 1;</code>
       */
      public long getRelativeTimestamp() {
        return relativeTimestamp_;
      }
      /**
       * <code>optional int64 relative_timestamp = 1;</code>
       */
      public Builder setRelativeTimestamp(long value) {
        
        relativeTimestamp_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional int64 relative_timestamp = 1;</code>
       */
      public Builder clearRelativeTimestamp() {
        
        relativeTimestamp_ = 0L;
        onChanged();
        return this;
      }

      private float light_ ;
      /**
       * <pre>
       * lux
       * </pre>
       *
       * <code>optional float light = 2;</code>
       */
      public float getLight() {
        return light_;
      }
      /**
       * <pre>
       * lux
       * </pre>
       *
       * <code>optional float light = 2;</code>
       */
      public Builder setLight(float value) {
        
        light_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       * lux
       * </pre>
       *
       * <code>optional float light = 2;</code>
       */
      public Builder clearLight() {
        
        light_ = 0F;
        onChanged();
        return this;
      }
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }


      // @@protoc_insertion_point(builder_scope:Light_Sample)
    }

    // @@protoc_insertion_point(class_scope:Light_Sample)
    private static final Light_Sample DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new Light_Sample();
    }

    public static Light_Sample getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<Light_Sample>
        PARSER = new com.google.protobuf.AbstractParser<Light_Sample>() {
      public Light_Sample parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new Light_Sample(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<Light_Sample> parser() {
      return PARSER;
    }

    @Override
    public com.google.protobuf.Parser<Light_Sample> getParserForType() {
      return PARSER;
    }

    public Light_Sample getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  public interface GNSS_SampleOrBuilder extends
      // @@protoc_insertion_point(interface_extends:GNSS_Sample)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>optional int64 relative_timestamp = 1;</code>
     */
    long getRelativeTimestamp();

    /**
     * <pre>
     * degrees (minimum 6 significant figures)
     * latitude between -90 and 90
     * </pre>
     *
     * <code>optional float latitude = 2;</code>
     */
    float getLatitude();

    /**
     * <pre>
     * longitude between -180 and 180
     * </pre>
     *
     * <code>optional float longitude = 3;</code>
     */
    float getLongitude();

    /**
     * <pre>
     *metres
     * </pre>
     *
     * <code>optional float altitude = 4;</code>
     */
    float getAltitude();

    /**
     * <pre>
     * metres
     * </pre>
     *
     * <code>optional float accuracy = 5;</code>
     */
    float getAccuracy();

    /**
     * <pre>
     * m/s
     * </pre>
     *
     * <code>optional float speed = 6;</code>
     */
    float getSpeed();

    /**
     * <pre>
     * e.g 'gps' or 'network'
     * </pre>
     *
     * <code>optional string provider = 7;</code>
     */
    String getProvider();
    /**
     * <pre>
     * e.g 'gps' or 'network'
     * </pre>
     *
     * <code>optional string provider = 7;</code>
     */
    com.google.protobuf.ByteString
        getProviderBytes();
  }
  /**
   * Protobuf type {@code GNSS_Sample}
   */
  public  static final class GNSS_Sample extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:GNSS_Sample)
      GNSS_SampleOrBuilder {
    // Use GNSS_Sample.newBuilder() to construct.
    private GNSS_Sample(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private GNSS_Sample() {
      relativeTimestamp_ = 0L;
      latitude_ = 0F;
      longitude_ = 0F;
      altitude_ = 0F;
      accuracy_ = 0F;
      speed_ = 0F;
      provider_ = "";
    }

    @Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
    }
    private GNSS_Sample(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      int mutable_bitField0_ = 0;
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!input.skipField(tag)) {
                done = true;
              }
              break;
            }
            case 8: {

              relativeTimestamp_ = input.readInt64();
              break;
            }
            case 21: {

              latitude_ = input.readFloat();
              break;
            }
            case 29: {

              longitude_ = input.readFloat();
              break;
            }
            case 37: {

              altitude_ = input.readFloat();
              break;
            }
            case 45: {

              accuracy_ = input.readFloat();
              break;
            }
            case 53: {

              speed_ = input.readFloat();
              break;
            }
            case 58: {
              String s = input.readStringRequireUtf8();

              provider_ = s;
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return Traj.internal_static_GNSS_Sample_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return Traj.internal_static_GNSS_Sample_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              GNSS_Sample.class, Builder.class);
    }

    public static final int RELATIVE_TIMESTAMP_FIELD_NUMBER = 1;
    private long relativeTimestamp_;
    /**
     * <code>optional int64 relative_timestamp = 1;</code>
     */
    public long getRelativeTimestamp() {
      return relativeTimestamp_;
    }

    public static final int LATITUDE_FIELD_NUMBER = 2;
    private float latitude_;
    /**
     * <pre>
     * degrees (minimum 6 significant figures)
     * latitude between -90 and 90
     * </pre>
     *
     * <code>optional float latitude = 2;</code>
     */
    public float getLatitude() {
      return latitude_;
    }

    public static final int LONGITUDE_FIELD_NUMBER = 3;
    private float longitude_;
    /**
     * <pre>
     * longitude between -180 and 180
     * </pre>
     *
     * <code>optional float longitude = 3;</code>
     */
    public float getLongitude() {
      return longitude_;
    }

    public static final int ALTITUDE_FIELD_NUMBER = 4;
    private float altitude_;
    /**
     * <pre>
     *metres
     * </pre>
     *
     * <code>optional float altitude = 4;</code>
     */
    public float getAltitude() {
      return altitude_;
    }

    public static final int ACCURACY_FIELD_NUMBER = 5;
    private float accuracy_;
    /**
     * <pre>
     * metres
     * </pre>
     *
     * <code>optional float accuracy = 5;</code>
     */
    public float getAccuracy() {
      return accuracy_;
    }

    public static final int SPEED_FIELD_NUMBER = 6;
    private float speed_;
    /**
     * <pre>
     * m/s
     * </pre>
     *
     * <code>optional float speed = 6;</code>
     */
    public float getSpeed() {
      return speed_;
    }

    public static final int PROVIDER_FIELD_NUMBER = 7;
    private volatile Object provider_;
    /**
     * <pre>
     * e.g 'gps' or 'network'
     * </pre>
     *
     * <code>optional string provider = 7;</code>
     */
    public String getProvider() {
      Object ref = provider_;
      if (ref instanceof String) {
        return (String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        provider_ = s;
        return s;
      }
    }
    /**
     * <pre>
     * e.g 'gps' or 'network'
     * </pre>
     *
     * <code>optional string provider = 7;</code>
     */
    public com.google.protobuf.ByteString
        getProviderBytes() {
      Object ref = provider_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        provider_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (relativeTimestamp_ != 0L) {
        output.writeInt64(1, relativeTimestamp_);
      }
      if (latitude_ != 0F) {
        output.writeFloat(2, latitude_);
      }
      if (longitude_ != 0F) {
        output.writeFloat(3, longitude_);
      }
      if (altitude_ != 0F) {
        output.writeFloat(4, altitude_);
      }
      if (accuracy_ != 0F) {
        output.writeFloat(5, accuracy_);
      }
      if (speed_ != 0F) {
        output.writeFloat(6, speed_);
      }
      if (!getProviderBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 7, provider_);
      }
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (relativeTimestamp_ != 0L) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt64Size(1, relativeTimestamp_);
      }
      if (latitude_ != 0F) {
        size += com.google.protobuf.CodedOutputStream
          .computeFloatSize(2, latitude_);
      }
      if (longitude_ != 0F) {
        size += com.google.protobuf.CodedOutputStream
          .computeFloatSize(3, longitude_);
      }
      if (altitude_ != 0F) {
        size += com.google.protobuf.CodedOutputStream
          .computeFloatSize(4, altitude_);
      }
      if (accuracy_ != 0F) {
        size += com.google.protobuf.CodedOutputStream
          .computeFloatSize(5, accuracy_);
      }
      if (speed_ != 0F) {
        size += com.google.protobuf.CodedOutputStream
          .computeFloatSize(6, speed_);
      }
      if (!getProviderBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(7, provider_);
      }
      memoizedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @Override
    public boolean equals(final Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof GNSS_Sample)) {
        return super.equals(obj);
      }
      GNSS_Sample other = (GNSS_Sample) obj;

      boolean result = true;
      result = result && (getRelativeTimestamp()
          == other.getRelativeTimestamp());
      result = result && (
          Float.floatToIntBits(getLatitude())
          == Float.floatToIntBits(
              other.getLatitude()));
      result = result && (
          Float.floatToIntBits(getLongitude())
          == Float.floatToIntBits(
              other.getLongitude()));
      result = result && (
          Float.floatToIntBits(getAltitude())
          == Float.floatToIntBits(
              other.getAltitude()));
      result = result && (
          Float.floatToIntBits(getAccuracy())
          == Float.floatToIntBits(
              other.getAccuracy()));
      result = result && (
          Float.floatToIntBits(getSpeed())
          == Float.floatToIntBits(
              other.getSpeed()));
      result = result && getProvider()
          .equals(other.getProvider());
      return result;
    }

    @Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptorForType().hashCode();
      hash = (37 * hash) + RELATIVE_TIMESTAMP_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          getRelativeTimestamp());
      hash = (37 * hash) + LATITUDE_FIELD_NUMBER;
      hash = (53 * hash) + Float.floatToIntBits(
          getLatitude());
      hash = (37 * hash) + LONGITUDE_FIELD_NUMBER;
      hash = (53 * hash) + Float.floatToIntBits(
          getLongitude());
      hash = (37 * hash) + ALTITUDE_FIELD_NUMBER;
      hash = (53 * hash) + Float.floatToIntBits(
          getAltitude());
      hash = (37 * hash) + ACCURACY_FIELD_NUMBER;
      hash = (53 * hash) + Float.floatToIntBits(
          getAccuracy());
      hash = (37 * hash) + SPEED_FIELD_NUMBER;
      hash = (53 * hash) + Float.floatToIntBits(
          getSpeed());
      hash = (37 * hash) + PROVIDER_FIELD_NUMBER;
      hash = (53 * hash) + getProvider().hashCode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static GNSS_Sample parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static GNSS_Sample parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static GNSS_Sample parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static GNSS_Sample parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static GNSS_Sample parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static GNSS_Sample parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static GNSS_Sample parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static GNSS_Sample parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static GNSS_Sample parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static GNSS_Sample parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(GNSS_Sample prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code GNSS_Sample}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:GNSS_Sample)
        GNSS_SampleOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return Traj.internal_static_GNSS_Sample_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return Traj.internal_static_GNSS_Sample_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                GNSS_Sample.class, Builder.class);
      }

      // Construct using Traj.GNSS_Sample.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      public Builder clear() {
        super.clear();
        relativeTimestamp_ = 0L;

        latitude_ = 0F;

        longitude_ = 0F;

        altitude_ = 0F;

        accuracy_ = 0F;

        speed_ = 0F;

        provider_ = "";

        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return Traj.internal_static_GNSS_Sample_descriptor;
      }

      public GNSS_Sample getDefaultInstanceForType() {
        return GNSS_Sample.getDefaultInstance();
      }

      public GNSS_Sample build() {
        GNSS_Sample result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public GNSS_Sample buildPartial() {
        GNSS_Sample result = new GNSS_Sample(this);
        result.relativeTimestamp_ = relativeTimestamp_;
        result.latitude_ = latitude_;
        result.longitude_ = longitude_;
        result.altitude_ = altitude_;
        result.accuracy_ = accuracy_;
        result.speed_ = speed_;
        result.provider_ = provider_;
        onBuilt();
        return result;
      }

      public Builder clone() {
        return (Builder) super.clone();
      }
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.setField(field, value);
      }
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof GNSS_Sample) {
          return mergeFrom((GNSS_Sample)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(GNSS_Sample other) {
        if (other == GNSS_Sample.getDefaultInstance()) return this;
        if (other.getRelativeTimestamp() != 0L) {
          setRelativeTimestamp(other.getRelativeTimestamp());
        }
        if (other.getLatitude() != 0F) {
          setLatitude(other.getLatitude());
        }
        if (other.getLongitude() != 0F) {
          setLongitude(other.getLongitude());
        }
        if (other.getAltitude() != 0F) {
          setAltitude(other.getAltitude());
        }
        if (other.getAccuracy() != 0F) {
          setAccuracy(other.getAccuracy());
        }
        if (other.getSpeed() != 0F) {
          setSpeed(other.getSpeed());
        }
        if (!other.getProvider().isEmpty()) {
          provider_ = other.provider_;
          onChanged();
        }
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        GNSS_Sample parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (GNSS_Sample) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private long relativeTimestamp_ ;
      /**
       * <code>optional int64 relative_timestamp = 1;</code>
       */
      public long getRelativeTimestamp() {
        return relativeTimestamp_;
      }
      /**
       * <code>optional int64 relative_timestamp = 1;</code>
       */
      public Builder setRelativeTimestamp(long value) {
        
        relativeTimestamp_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional int64 relative_timestamp = 1;</code>
       */
      public Builder clearRelativeTimestamp() {
        
        relativeTimestamp_ = 0L;
        onChanged();
        return this;
      }

      private float latitude_ ;
      /**
       * <pre>
       * degrees (minimum 6 significant figures)
       * latitude between -90 and 90
       * </pre>
       *
       * <code>optional float latitude = 2;</code>
       */
      public float getLatitude() {
        return latitude_;
      }
      /**
       * <pre>
       * degrees (minimum 6 significant figures)
       * latitude between -90 and 90
       * </pre>
       *
       * <code>optional float latitude = 2;</code>
       */
      public Builder setLatitude(float value) {
        
        latitude_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       * degrees (minimum 6 significant figures)
       * latitude between -90 and 90
       * </pre>
       *
       * <code>optional float latitude = 2;</code>
       */
      public Builder clearLatitude() {
        
        latitude_ = 0F;
        onChanged();
        return this;
      }

      private float longitude_ ;
      /**
       * <pre>
       * longitude between -180 and 180
       * </pre>
       *
       * <code>optional float longitude = 3;</code>
       */
      public float getLongitude() {
        return longitude_;
      }
      /**
       * <pre>
       * longitude between -180 and 180
       * </pre>
       *
       * <code>optional float longitude = 3;</code>
       */
      public Builder setLongitude(float value) {
        
        longitude_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       * longitude between -180 and 180
       * </pre>
       *
       * <code>optional float longitude = 3;</code>
       */
      public Builder clearLongitude() {
        
        longitude_ = 0F;
        onChanged();
        return this;
      }

      private float altitude_ ;
      /**
       * <pre>
       *metres
       * </pre>
       *
       * <code>optional float altitude = 4;</code>
       */
      public float getAltitude() {
        return altitude_;
      }
      /**
       * <pre>
       *metres
       * </pre>
       *
       * <code>optional float altitude = 4;</code>
       */
      public Builder setAltitude(float value) {
        
        altitude_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       *metres
       * </pre>
       *
       * <code>optional float altitude = 4;</code>
       */
      public Builder clearAltitude() {
        
        altitude_ = 0F;
        onChanged();
        return this;
      }

      private float accuracy_ ;
      /**
       * <pre>
       * metres
       * </pre>
       *
       * <code>optional float accuracy = 5;</code>
       */
      public float getAccuracy() {
        return accuracy_;
      }
      /**
       * <pre>
       * metres
       * </pre>
       *
       * <code>optional float accuracy = 5;</code>
       */
      public Builder setAccuracy(float value) {
        
        accuracy_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       * metres
       * </pre>
       *
       * <code>optional float accuracy = 5;</code>
       */
      public Builder clearAccuracy() {
        
        accuracy_ = 0F;
        onChanged();
        return this;
      }

      private float speed_ ;
      /**
       * <pre>
       * m/s
       * </pre>
       *
       * <code>optional float speed = 6;</code>
       */
      public float getSpeed() {
        return speed_;
      }
      /**
       * <pre>
       * m/s
       * </pre>
       *
       * <code>optional float speed = 6;</code>
       */
      public Builder setSpeed(float value) {
        
        speed_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       * m/s
       * </pre>
       *
       * <code>optional float speed = 6;</code>
       */
      public Builder clearSpeed() {
        
        speed_ = 0F;
        onChanged();
        return this;
      }

      private Object provider_ = "";
      /**
       * <pre>
       * e.g 'gps' or 'network'
       * </pre>
       *
       * <code>optional string provider = 7;</code>
       */
      public String getProvider() {
        Object ref = provider_;
        if (!(ref instanceof String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          String s = bs.toStringUtf8();
          provider_ = s;
          return s;
        } else {
          return (String) ref;
        }
      }
      /**
       * <pre>
       * e.g 'gps' or 'network'
       * </pre>
       *
       * <code>optional string provider = 7;</code>
       */
      public com.google.protobuf.ByteString
          getProviderBytes() {
        Object ref = provider_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (String) ref);
          provider_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <pre>
       * e.g 'gps' or 'network'
       * </pre>
       *
       * <code>optional string provider = 7;</code>
       */
      public Builder setProvider(
          String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        provider_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       * e.g 'gps' or 'network'
       * </pre>
       *
       * <code>optional string provider = 7;</code>
       */
      public Builder clearProvider() {
        
        provider_ = getDefaultInstance().getProvider();
        onChanged();
        return this;
      }
      /**
       * <pre>
       * e.g 'gps' or 'network'
       * </pre>
       *
       * <code>optional string provider = 7;</code>
       */
      public Builder setProviderBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        provider_ = value;
        onChanged();
        return this;
      }
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }


      // @@protoc_insertion_point(builder_scope:GNSS_Sample)
    }

    // @@protoc_insertion_point(class_scope:GNSS_Sample)
    private static final GNSS_Sample DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new GNSS_Sample();
    }

    public static GNSS_Sample getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<GNSS_Sample>
        PARSER = new com.google.protobuf.AbstractParser<GNSS_Sample>() {
      public GNSS_Sample parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new GNSS_Sample(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<GNSS_Sample> parser() {
      return PARSER;
    }

    @Override
    public com.google.protobuf.Parser<GNSS_Sample> getParserForType() {
      return PARSER;
    }

    public GNSS_Sample getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  public interface WiFi_SampleOrBuilder extends
      // @@protoc_insertion_point(interface_extends:WiFi_Sample)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>optional int64 relative_timestamp = 1;</code>
     */
    long getRelativeTimestamp();

    /**
     * <code>repeated .Mac_Scan mac_scans = 2;</code>
     */
    java.util.List<Mac_Scan>
        getMacScansList();
    /**
     * <code>repeated .Mac_Scan mac_scans = 2;</code>
     */
    Mac_Scan getMacScans(int index);
    /**
     * <code>repeated .Mac_Scan mac_scans = 2;</code>
     */
    int getMacScansCount();
    /**
     * <code>repeated .Mac_Scan mac_scans = 2;</code>
     */
    java.util.List<? extends Mac_ScanOrBuilder>
        getMacScansOrBuilderList();
    /**
     * <code>repeated .Mac_Scan mac_scans = 2;</code>
     */
    Mac_ScanOrBuilder getMacScansOrBuilder(
        int index);
  }
  /**
   * Protobuf type {@code WiFi_Sample}
   */
  public  static final class WiFi_Sample extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:WiFi_Sample)
      WiFi_SampleOrBuilder {
    // Use WiFi_Sample.newBuilder() to construct.
    private WiFi_Sample(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private WiFi_Sample() {
      relativeTimestamp_ = 0L;
      macScans_ = java.util.Collections.emptyList();
    }

    @Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
    }
    private WiFi_Sample(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      int mutable_bitField0_ = 0;
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!input.skipField(tag)) {
                done = true;
              }
              break;
            }
            case 8: {

              relativeTimestamp_ = input.readInt64();
              break;
            }
            case 18: {
              if (!((mutable_bitField0_ & 0x00000002) == 0x00000002)) {
                macScans_ = new java.util.ArrayList<Mac_Scan>();
                mutable_bitField0_ |= 0x00000002;
              }
              macScans_.add(
                  input.readMessage(Mac_Scan.parser(), extensionRegistry));
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        if (((mutable_bitField0_ & 0x00000002) == 0x00000002)) {
          macScans_ = java.util.Collections.unmodifiableList(macScans_);
        }
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return Traj.internal_static_WiFi_Sample_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return Traj.internal_static_WiFi_Sample_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              WiFi_Sample.class, Builder.class);
    }

    private int bitField0_;
    public static final int RELATIVE_TIMESTAMP_FIELD_NUMBER = 1;
    private long relativeTimestamp_;
    /**
     * <code>optional int64 relative_timestamp = 1;</code>
     */
    public long getRelativeTimestamp() {
      return relativeTimestamp_;
    }

    public static final int MAC_SCANS_FIELD_NUMBER = 2;
    private java.util.List<Mac_Scan> macScans_;
    /**
     * <code>repeated .Mac_Scan mac_scans = 2;</code>
     */
    public java.util.List<Mac_Scan> getMacScansList() {
      return macScans_;
    }
    /**
     * <code>repeated .Mac_Scan mac_scans = 2;</code>
     */
    public java.util.List<? extends Mac_ScanOrBuilder>
        getMacScansOrBuilderList() {
      return macScans_;
    }
    /**
     * <code>repeated .Mac_Scan mac_scans = 2;</code>
     */
    public int getMacScansCount() {
      return macScans_.size();
    }
    /**
     * <code>repeated .Mac_Scan mac_scans = 2;</code>
     */
    public Mac_Scan getMacScans(int index) {
      return macScans_.get(index);
    }
    /**
     * <code>repeated .Mac_Scan mac_scans = 2;</code>
     */
    public Mac_ScanOrBuilder getMacScansOrBuilder(
        int index) {
      return macScans_.get(index);
    }

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (relativeTimestamp_ != 0L) {
        output.writeInt64(1, relativeTimestamp_);
      }
      for (int i = 0; i < macScans_.size(); i++) {
        output.writeMessage(2, macScans_.get(i));
      }
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (relativeTimestamp_ != 0L) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt64Size(1, relativeTimestamp_);
      }
      for (int i = 0; i < macScans_.size(); i++) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(2, macScans_.get(i));
      }
      memoizedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @Override
    public boolean equals(final Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof WiFi_Sample)) {
        return super.equals(obj);
      }
      WiFi_Sample other = (WiFi_Sample) obj;

      boolean result = true;
      result = result && (getRelativeTimestamp()
          == other.getRelativeTimestamp());
      result = result && getMacScansList()
          .equals(other.getMacScansList());
      return result;
    }

    @Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptorForType().hashCode();
      hash = (37 * hash) + RELATIVE_TIMESTAMP_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          getRelativeTimestamp());
      if (getMacScansCount() > 0) {
        hash = (37 * hash) + MAC_SCANS_FIELD_NUMBER;
        hash = (53 * hash) + getMacScansList().hashCode();
      }
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static WiFi_Sample parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static WiFi_Sample parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static WiFi_Sample parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static WiFi_Sample parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static WiFi_Sample parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static WiFi_Sample parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static WiFi_Sample parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static WiFi_Sample parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static WiFi_Sample parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static WiFi_Sample parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(WiFi_Sample prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code WiFi_Sample}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:WiFi_Sample)
        WiFi_SampleOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return Traj.internal_static_WiFi_Sample_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return Traj.internal_static_WiFi_Sample_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                WiFi_Sample.class, Builder.class);
      }

      // Construct using Traj.WiFi_Sample.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
          getMacScansFieldBuilder();
        }
      }
      public Builder clear() {
        super.clear();
        relativeTimestamp_ = 0L;

        if (macScansBuilder_ == null) {
          macScans_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000002);
        } else {
          macScansBuilder_.clear();
        }
        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return Traj.internal_static_WiFi_Sample_descriptor;
      }

      public WiFi_Sample getDefaultInstanceForType() {
        return WiFi_Sample.getDefaultInstance();
      }

      public WiFi_Sample build() {
        WiFi_Sample result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public WiFi_Sample buildPartial() {
        WiFi_Sample result = new WiFi_Sample(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        result.relativeTimestamp_ = relativeTimestamp_;
        if (macScansBuilder_ == null) {
          if (((bitField0_ & 0x00000002) == 0x00000002)) {
            macScans_ = java.util.Collections.unmodifiableList(macScans_);
            bitField0_ = (bitField0_ & ~0x00000002);
          }
          result.macScans_ = macScans_;
        } else {
          result.macScans_ = macScansBuilder_.build();
        }
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      public Builder clone() {
        return (Builder) super.clone();
      }
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.setField(field, value);
      }
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof WiFi_Sample) {
          return mergeFrom((WiFi_Sample)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(WiFi_Sample other) {
        if (other == WiFi_Sample.getDefaultInstance()) return this;
        if (other.getRelativeTimestamp() != 0L) {
          setRelativeTimestamp(other.getRelativeTimestamp());
        }
        if (macScansBuilder_ == null) {
          if (!other.macScans_.isEmpty()) {
            if (macScans_.isEmpty()) {
              macScans_ = other.macScans_;
              bitField0_ = (bitField0_ & ~0x00000002);
            } else {
              ensureMacScansIsMutable();
              macScans_.addAll(other.macScans_);
            }
            onChanged();
          }
        } else {
          if (!other.macScans_.isEmpty()) {
            if (macScansBuilder_.isEmpty()) {
              macScansBuilder_.dispose();
              macScansBuilder_ = null;
              macScans_ = other.macScans_;
              bitField0_ = (bitField0_ & ~0x00000002);
              macScansBuilder_ = 
                com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                   getMacScansFieldBuilder() : null;
            } else {
              macScansBuilder_.addAllMessages(other.macScans_);
            }
          }
        }
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        WiFi_Sample parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (WiFi_Sample) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private long relativeTimestamp_ ;
      /**
       * <code>optional int64 relative_timestamp = 1;</code>
       */
      public long getRelativeTimestamp() {
        return relativeTimestamp_;
      }
      /**
       * <code>optional int64 relative_timestamp = 1;</code>
       */
      public Builder setRelativeTimestamp(long value) {
        
        relativeTimestamp_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional int64 relative_timestamp = 1;</code>
       */
      public Builder clearRelativeTimestamp() {
        
        relativeTimestamp_ = 0L;
        onChanged();
        return this;
      }

      private java.util.List<Mac_Scan> macScans_ =
        java.util.Collections.emptyList();
      private void ensureMacScansIsMutable() {
        if (!((bitField0_ & 0x00000002) == 0x00000002)) {
          macScans_ = new java.util.ArrayList<Mac_Scan>(macScans_);
          bitField0_ |= 0x00000002;
         }
      }

      private com.google.protobuf.RepeatedFieldBuilderV3<
          Mac_Scan, Mac_Scan.Builder, Mac_ScanOrBuilder> macScansBuilder_;

      /**
       * <code>repeated .Mac_Scan mac_scans = 2;</code>
       */
      public java.util.List<Mac_Scan> getMacScansList() {
        if (macScansBuilder_ == null) {
          return java.util.Collections.unmodifiableList(macScans_);
        } else {
          return macScansBuilder_.getMessageList();
        }
      }
      /**
       * <code>repeated .Mac_Scan mac_scans = 2;</code>
       */
      public int getMacScansCount() {
        if (macScansBuilder_ == null) {
          return macScans_.size();
        } else {
          return macScansBuilder_.getCount();
        }
      }
      /**
       * <code>repeated .Mac_Scan mac_scans = 2;</code>
       */
      public Mac_Scan getMacScans(int index) {
        if (macScansBuilder_ == null) {
          return macScans_.get(index);
        } else {
          return macScansBuilder_.getMessage(index);
        }
      }
      /**
       * <code>repeated .Mac_Scan mac_scans = 2;</code>
       */
      public Builder setMacScans(
          int index, Mac_Scan value) {
        if (macScansBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureMacScansIsMutable();
          macScans_.set(index, value);
          onChanged();
        } else {
          macScansBuilder_.setMessage(index, value);
        }
        return this;
      }
      /**
       * <code>repeated .Mac_Scan mac_scans = 2;</code>
       */
      public Builder setMacScans(
          int index, Mac_Scan.Builder builderForValue) {
        if (macScansBuilder_ == null) {
          ensureMacScansIsMutable();
          macScans_.set(index, builderForValue.build());
          onChanged();
        } else {
          macScansBuilder_.setMessage(index, builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .Mac_Scan mac_scans = 2;</code>
       */
      public Builder addMacScans(Mac_Scan value) {
        if (macScansBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureMacScansIsMutable();
          macScans_.add(value);
          onChanged();
        } else {
          macScansBuilder_.addMessage(value);
        }
        return this;
      }
      /**
       * <code>repeated .Mac_Scan mac_scans = 2;</code>
       */
      public Builder addMacScans(
          int index, Mac_Scan value) {
        if (macScansBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureMacScansIsMutable();
          macScans_.add(index, value);
          onChanged();
        } else {
          macScansBuilder_.addMessage(index, value);
        }
        return this;
      }
      /**
       * <code>repeated .Mac_Scan mac_scans = 2;</code>
       */
      public Builder addMacScans(
          Mac_Scan.Builder builderForValue) {
        if (macScansBuilder_ == null) {
          ensureMacScansIsMutable();
          macScans_.add(builderForValue.build());
          onChanged();
        } else {
          macScansBuilder_.addMessage(builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .Mac_Scan mac_scans = 2;</code>
       */
      public Builder addMacScans(
          int index, Mac_Scan.Builder builderForValue) {
        if (macScansBuilder_ == null) {
          ensureMacScansIsMutable();
          macScans_.add(index, builderForValue.build());
          onChanged();
        } else {
          macScansBuilder_.addMessage(index, builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .Mac_Scan mac_scans = 2;</code>
       */
      public Builder addAllMacScans(
          Iterable<? extends Mac_Scan> values) {
        if (macScansBuilder_ == null) {
          ensureMacScansIsMutable();
          com.google.protobuf.AbstractMessageLite.Builder.addAll(
              values, macScans_);
          onChanged();
        } else {
          macScansBuilder_.addAllMessages(values);
        }
        return this;
      }
      /**
       * <code>repeated .Mac_Scan mac_scans = 2;</code>
       */
      public Builder clearMacScans() {
        if (macScansBuilder_ == null) {
          macScans_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000002);
          onChanged();
        } else {
          macScansBuilder_.clear();
        }
        return this;
      }
      /**
       * <code>repeated .Mac_Scan mac_scans = 2;</code>
       */
      public Builder removeMacScans(int index) {
        if (macScansBuilder_ == null) {
          ensureMacScansIsMutable();
          macScans_.remove(index);
          onChanged();
        } else {
          macScansBuilder_.remove(index);
        }
        return this;
      }
      /**
       * <code>repeated .Mac_Scan mac_scans = 2;</code>
       */
      public Mac_Scan.Builder getMacScansBuilder(
          int index) {
        return getMacScansFieldBuilder().getBuilder(index);
      }
      /**
       * <code>repeated .Mac_Scan mac_scans = 2;</code>
       */
      public Mac_ScanOrBuilder getMacScansOrBuilder(
          int index) {
        if (macScansBuilder_ == null) {
          return macScans_.get(index);  } else {
          return macScansBuilder_.getMessageOrBuilder(index);
        }
      }
      /**
       * <code>repeated .Mac_Scan mac_scans = 2;</code>
       */
      public java.util.List<? extends Mac_ScanOrBuilder>
           getMacScansOrBuilderList() {
        if (macScansBuilder_ != null) {
          return macScansBuilder_.getMessageOrBuilderList();
        } else {
          return java.util.Collections.unmodifiableList(macScans_);
        }
      }
      /**
       * <code>repeated .Mac_Scan mac_scans = 2;</code>
       */
      public Mac_Scan.Builder addMacScansBuilder() {
        return getMacScansFieldBuilder().addBuilder(
            Mac_Scan.getDefaultInstance());
      }
      /**
       * <code>repeated .Mac_Scan mac_scans = 2;</code>
       */
      public Mac_Scan.Builder addMacScansBuilder(
          int index) {
        return getMacScansFieldBuilder().addBuilder(
            index, Mac_Scan.getDefaultInstance());
      }
      /**
       * <code>repeated .Mac_Scan mac_scans = 2;</code>
       */
      public java.util.List<Mac_Scan.Builder>
           getMacScansBuilderList() {
        return getMacScansFieldBuilder().getBuilderList();
      }
      private com.google.protobuf.RepeatedFieldBuilderV3<
          Mac_Scan, Mac_Scan.Builder, Mac_ScanOrBuilder>
          getMacScansFieldBuilder() {
        if (macScansBuilder_ == null) {
          macScansBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
              Mac_Scan, Mac_Scan.Builder, Mac_ScanOrBuilder>(
                  macScans_,
                  ((bitField0_ & 0x00000002) == 0x00000002),
                  getParentForChildren(),
                  isClean());
          macScans_ = null;
        }
        return macScansBuilder_;
      }
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }


      // @@protoc_insertion_point(builder_scope:WiFi_Sample)
    }

    // @@protoc_insertion_point(class_scope:WiFi_Sample)
    private static final WiFi_Sample DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new WiFi_Sample();
    }

    public static WiFi_Sample getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<WiFi_Sample>
        PARSER = new com.google.protobuf.AbstractParser<WiFi_Sample>() {
      public WiFi_Sample parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new WiFi_Sample(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<WiFi_Sample> parser() {
      return PARSER;
    }

    @Override
    public com.google.protobuf.Parser<WiFi_Sample> getParserForType() {
      return PARSER;
    }

    public WiFi_Sample getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  public interface Mac_ScanOrBuilder extends
      // @@protoc_insertion_point(interface_extends:Mac_Scan)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>optional int64 relative_timestamp = 1;</code>
     */
    long getRelativeTimestamp();

    /**
     * <pre>
     * Integer encoding of the hex mac address
     * e.g. 207394925843984
     * </pre>
     *
     * <code>optional int64 mac = 2;</code>
     */
    long getMac();

    /**
     * <pre>
     * rssi integer in dBm.
     * typically between -120 and -10
     * </pre>
     *
     * <code>optional int32 rssi = 3;</code>
     */
    int getRssi();
  }
  /**
   * Protobuf type {@code Mac_Scan}
   */
  public  static final class Mac_Scan extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:Mac_Scan)
      Mac_ScanOrBuilder {
    // Use Mac_Scan.newBuilder() to construct.
    private Mac_Scan(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private Mac_Scan() {
      relativeTimestamp_ = 0L;
      mac_ = 0L;
      rssi_ = 0;
    }

    @Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
    }
    private Mac_Scan(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      int mutable_bitField0_ = 0;
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!input.skipField(tag)) {
                done = true;
              }
              break;
            }
            case 8: {

              relativeTimestamp_ = input.readInt64();
              break;
            }
            case 16: {

              mac_ = input.readInt64();
              break;
            }
            case 24: {

              rssi_ = input.readInt32();
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return Traj.internal_static_Mac_Scan_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return Traj.internal_static_Mac_Scan_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              Mac_Scan.class, Builder.class);
    }

    public static final int RELATIVE_TIMESTAMP_FIELD_NUMBER = 1;
    private long relativeTimestamp_;
    /**
     * <code>optional int64 relative_timestamp = 1;</code>
     */
    public long getRelativeTimestamp() {
      return relativeTimestamp_;
    }

    public static final int MAC_FIELD_NUMBER = 2;
    private long mac_;
    /**
     * <pre>
     * Integer encoding of the hex mac address
     * e.g. 207394925843984
     * </pre>
     *
     * <code>optional int64 mac = 2;</code>
     */
    public long getMac() {
      return mac_;
    }

    public static final int RSSI_FIELD_NUMBER = 3;
    private int rssi_;
    /**
     * <pre>
     * rssi integer in dBm.
     * typically between -120 and -10
     * </pre>
     *
     * <code>optional int32 rssi = 3;</code>
     */
    public int getRssi() {
      return rssi_;
    }

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (relativeTimestamp_ != 0L) {
        output.writeInt64(1, relativeTimestamp_);
      }
      if (mac_ != 0L) {
        output.writeInt64(2, mac_);
      }
      if (rssi_ != 0) {
        output.writeInt32(3, rssi_);
      }
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (relativeTimestamp_ != 0L) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt64Size(1, relativeTimestamp_);
      }
      if (mac_ != 0L) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt64Size(2, mac_);
      }
      if (rssi_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(3, rssi_);
      }
      memoizedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @Override
    public boolean equals(final Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof Mac_Scan)) {
        return super.equals(obj);
      }
      Mac_Scan other = (Mac_Scan) obj;

      boolean result = true;
      result = result && (getRelativeTimestamp()
          == other.getRelativeTimestamp());
      result = result && (getMac()
          == other.getMac());
      result = result && (getRssi()
          == other.getRssi());
      return result;
    }

    @Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptorForType().hashCode();
      hash = (37 * hash) + RELATIVE_TIMESTAMP_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          getRelativeTimestamp());
      hash = (37 * hash) + MAC_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          getMac());
      hash = (37 * hash) + RSSI_FIELD_NUMBER;
      hash = (53 * hash) + getRssi();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static Mac_Scan parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Mac_Scan parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Mac_Scan parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Mac_Scan parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Mac_Scan parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static Mac_Scan parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static Mac_Scan parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static Mac_Scan parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static Mac_Scan parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static Mac_Scan parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(Mac_Scan prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code Mac_Scan}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:Mac_Scan)
        Mac_ScanOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return Traj.internal_static_Mac_Scan_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return Traj.internal_static_Mac_Scan_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                Mac_Scan.class, Builder.class);
      }

      // Construct using Traj.Mac_Scan.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      public Builder clear() {
        super.clear();
        relativeTimestamp_ = 0L;

        mac_ = 0L;

        rssi_ = 0;

        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return Traj.internal_static_Mac_Scan_descriptor;
      }

      public Mac_Scan getDefaultInstanceForType() {
        return Mac_Scan.getDefaultInstance();
      }

      public Mac_Scan build() {
        Mac_Scan result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public Mac_Scan buildPartial() {
        Mac_Scan result = new Mac_Scan(this);
        result.relativeTimestamp_ = relativeTimestamp_;
        result.mac_ = mac_;
        result.rssi_ = rssi_;
        onBuilt();
        return result;
      }

      public Builder clone() {
        return (Builder) super.clone();
      }
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.setField(field, value);
      }
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof Mac_Scan) {
          return mergeFrom((Mac_Scan)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(Mac_Scan other) {
        if (other == Mac_Scan.getDefaultInstance()) return this;
        if (other.getRelativeTimestamp() != 0L) {
          setRelativeTimestamp(other.getRelativeTimestamp());
        }
        if (other.getMac() != 0L) {
          setMac(other.getMac());
        }
        if (other.getRssi() != 0) {
          setRssi(other.getRssi());
        }
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        Mac_Scan parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (Mac_Scan) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private long relativeTimestamp_ ;
      /**
       * <code>optional int64 relative_timestamp = 1;</code>
       */
      public long getRelativeTimestamp() {
        return relativeTimestamp_;
      }
      /**
       * <code>optional int64 relative_timestamp = 1;</code>
       */
      public Builder setRelativeTimestamp(long value) {
        
        relativeTimestamp_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional int64 relative_timestamp = 1;</code>
       */
      public Builder clearRelativeTimestamp() {
        
        relativeTimestamp_ = 0L;
        onChanged();
        return this;
      }

      private long mac_ ;
      /**
       * <pre>
       * Integer encoding of the hex mac address
       * e.g. 207394925843984
       * </pre>
       *
       * <code>optional int64 mac = 2;</code>
       */
      public long getMac() {
        return mac_;
      }
      /**
       * <pre>
       * Integer encoding of the hex mac address
       * e.g. 207394925843984
       * </pre>
       *
       * <code>optional int64 mac = 2;</code>
       */
      public Builder setMac(long value) {
        
        mac_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       * Integer encoding of the hex mac address
       * e.g. 207394925843984
       * </pre>
       *
       * <code>optional int64 mac = 2;</code>
       */
      public Builder clearMac() {
        
        mac_ = 0L;
        onChanged();
        return this;
      }

      private int rssi_ ;
      /**
       * <pre>
       * rssi integer in dBm.
       * typically between -120 and -10
       * </pre>
       *
       * <code>optional int32 rssi = 3;</code>
       */
      public int getRssi() {
        return rssi_;
      }
      /**
       * <pre>
       * rssi integer in dBm.
       * typically between -120 and -10
       * </pre>
       *
       * <code>optional int32 rssi = 3;</code>
       */
      public Builder setRssi(int value) {
        
        rssi_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       * rssi integer in dBm.
       * typically between -120 and -10
       * </pre>
       *
       * <code>optional int32 rssi = 3;</code>
       */
      public Builder clearRssi() {
        
        rssi_ = 0;
        onChanged();
        return this;
      }
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }


      // @@protoc_insertion_point(builder_scope:Mac_Scan)
    }

    // @@protoc_insertion_point(class_scope:Mac_Scan)
    private static final Mac_Scan DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new Mac_Scan();
    }

    public static Mac_Scan getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<Mac_Scan>
        PARSER = new com.google.protobuf.AbstractParser<Mac_Scan>() {
      public Mac_Scan parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new Mac_Scan(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<Mac_Scan> parser() {
      return PARSER;
    }

    @Override
    public com.google.protobuf.Parser<Mac_Scan> getParserForType() {
      return PARSER;
    }

    public Mac_Scan getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  public interface AP_DataOrBuilder extends
      // @@protoc_insertion_point(interface_extends:AP_Data)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <pre>
     * Integer encoding of the hex mac address
     * e.g. 207394925843984
     * </pre>
     *
     * <code>optional int64 mac = 1;</code>
     */
    long getMac();

    /**
     * <pre>
     * E.g. 'Eduroam' or 'Starbucks_free_wifi'
     * </pre>
     *
     * <code>optional string ssid = 2;</code>
     */
    String getSsid();
    /**
     * <pre>
     * E.g. 'Eduroam' or 'Starbucks_free_wifi'
     * </pre>
     *
     * <code>optional string ssid = 2;</code>
     */
    com.google.protobuf.ByteString
        getSsidBytes();

    /**
     * <pre>
     * Typically 2.4GHz or 5GHz
     * </pre>
     *
     * <code>optional int64 frequency = 3;</code>
     */
    long getFrequency();
  }
  /**
   * Protobuf type {@code AP_Data}
   */
  public  static final class AP_Data extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:AP_Data)
      AP_DataOrBuilder {
    // Use AP_Data.newBuilder() to construct.
    private AP_Data(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private AP_Data() {
      mac_ = 0L;
      ssid_ = "";
      frequency_ = 0L;
    }

    @Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
    }
    private AP_Data(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      int mutable_bitField0_ = 0;
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!input.skipField(tag)) {
                done = true;
              }
              break;
            }
            case 8: {

              mac_ = input.readInt64();
              break;
            }
            case 18: {
              String s = input.readStringRequireUtf8();

              ssid_ = s;
              break;
            }
            case 24: {

              frequency_ = input.readInt64();
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return Traj.internal_static_AP_Data_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return Traj.internal_static_AP_Data_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              AP_Data.class, Builder.class);
    }

    public static final int MAC_FIELD_NUMBER = 1;
    private long mac_;
    /**
     * <pre>
     * Integer encoding of the hex mac address
     * e.g. 207394925843984
     * </pre>
     *
     * <code>optional int64 mac = 1;</code>
     */
    public long getMac() {
      return mac_;
    }

    public static final int SSID_FIELD_NUMBER = 2;
    private volatile Object ssid_;
    /**
     * <pre>
     * E.g. 'Eduroam' or 'Starbucks_free_wifi'
     * </pre>
     *
     * <code>optional string ssid = 2;</code>
     */
    public String getSsid() {
      Object ref = ssid_;
      if (ref instanceof String) {
        return (String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        ssid_ = s;
        return s;
      }
    }
    /**
     * <pre>
     * E.g. 'Eduroam' or 'Starbucks_free_wifi'
     * </pre>
     *
     * <code>optional string ssid = 2;</code>
     */
    public com.google.protobuf.ByteString
        getSsidBytes() {
      Object ref = ssid_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        ssid_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int FREQUENCY_FIELD_NUMBER = 3;
    private long frequency_;
    /**
     * <pre>
     * Typically 2.4GHz or 5GHz
     * </pre>
     *
     * <code>optional int64 frequency = 3;</code>
     */
    public long getFrequency() {
      return frequency_;
    }

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (mac_ != 0L) {
        output.writeInt64(1, mac_);
      }
      if (!getSsidBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, ssid_);
      }
      if (frequency_ != 0L) {
        output.writeInt64(3, frequency_);
      }
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (mac_ != 0L) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt64Size(1, mac_);
      }
      if (!getSsidBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, ssid_);
      }
      if (frequency_ != 0L) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt64Size(3, frequency_);
      }
      memoizedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @Override
    public boolean equals(final Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof AP_Data)) {
        return super.equals(obj);
      }
      AP_Data other = (AP_Data) obj;

      boolean result = true;
      result = result && (getMac()
          == other.getMac());
      result = result && getSsid()
          .equals(other.getSsid());
      result = result && (getFrequency()
          == other.getFrequency());
      return result;
    }

    @Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptorForType().hashCode();
      hash = (37 * hash) + MAC_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          getMac());
      hash = (37 * hash) + SSID_FIELD_NUMBER;
      hash = (53 * hash) + getSsid().hashCode();
      hash = (37 * hash) + FREQUENCY_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          getFrequency());
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static AP_Data parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static AP_Data parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static AP_Data parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static AP_Data parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static AP_Data parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static AP_Data parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static AP_Data parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static AP_Data parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static AP_Data parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static AP_Data parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(AP_Data prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code AP_Data}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:AP_Data)
        AP_DataOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return Traj.internal_static_AP_Data_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return Traj.internal_static_AP_Data_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                AP_Data.class, Builder.class);
      }

      // Construct using Traj.AP_Data.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      public Builder clear() {
        super.clear();
        mac_ = 0L;

        ssid_ = "";

        frequency_ = 0L;

        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return Traj.internal_static_AP_Data_descriptor;
      }

      public AP_Data getDefaultInstanceForType() {
        return AP_Data.getDefaultInstance();
      }

      public AP_Data build() {
        AP_Data result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public AP_Data buildPartial() {
        AP_Data result = new AP_Data(this);
        result.mac_ = mac_;
        result.ssid_ = ssid_;
        result.frequency_ = frequency_;
        onBuilt();
        return result;
      }

      public Builder clone() {
        return (Builder) super.clone();
      }
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.setField(field, value);
      }
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof AP_Data) {
          return mergeFrom((AP_Data)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(AP_Data other) {
        if (other == AP_Data.getDefaultInstance()) return this;
        if (other.getMac() != 0L) {
          setMac(other.getMac());
        }
        if (!other.getSsid().isEmpty()) {
          ssid_ = other.ssid_;
          onChanged();
        }
        if (other.getFrequency() != 0L) {
          setFrequency(other.getFrequency());
        }
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        AP_Data parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (AP_Data) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private long mac_ ;
      /**
       * <pre>
       * Integer encoding of the hex mac address
       * e.g. 207394925843984
       * </pre>
       *
       * <code>optional int64 mac = 1;</code>
       */
      public long getMac() {
        return mac_;
      }
      /**
       * <pre>
       * Integer encoding of the hex mac address
       * e.g. 207394925843984
       * </pre>
       *
       * <code>optional int64 mac = 1;</code>
       */
      public Builder setMac(long value) {
        
        mac_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       * Integer encoding of the hex mac address
       * e.g. 207394925843984
       * </pre>
       *
       * <code>optional int64 mac = 1;</code>
       */
      public Builder clearMac() {
        
        mac_ = 0L;
        onChanged();
        return this;
      }

      private Object ssid_ = "";
      /**
       * <pre>
       * E.g. 'Eduroam' or 'Starbucks_free_wifi'
       * </pre>
       *
       * <code>optional string ssid = 2;</code>
       */
      public String getSsid() {
        Object ref = ssid_;
        if (!(ref instanceof String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          String s = bs.toStringUtf8();
          ssid_ = s;
          return s;
        } else {
          return (String) ref;
        }
      }
      /**
       * <pre>
       * E.g. 'Eduroam' or 'Starbucks_free_wifi'
       * </pre>
       *
       * <code>optional string ssid = 2;</code>
       */
      public com.google.protobuf.ByteString
          getSsidBytes() {
        Object ref = ssid_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (String) ref);
          ssid_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <pre>
       * E.g. 'Eduroam' or 'Starbucks_free_wifi'
       * </pre>
       *
       * <code>optional string ssid = 2;</code>
       */
      public Builder setSsid(
          String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        ssid_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       * E.g. 'Eduroam' or 'Starbucks_free_wifi'
       * </pre>
       *
       * <code>optional string ssid = 2;</code>
       */
      public Builder clearSsid() {
        
        ssid_ = getDefaultInstance().getSsid();
        onChanged();
        return this;
      }
      /**
       * <pre>
       * E.g. 'Eduroam' or 'Starbucks_free_wifi'
       * </pre>
       *
       * <code>optional string ssid = 2;</code>
       */
      public Builder setSsidBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        ssid_ = value;
        onChanged();
        return this;
      }

      private long frequency_ ;
      /**
       * <pre>
       * Typically 2.4GHz or 5GHz
       * </pre>
       *
       * <code>optional int64 frequency = 3;</code>
       */
      public long getFrequency() {
        return frequency_;
      }
      /**
       * <pre>
       * Typically 2.4GHz or 5GHz
       * </pre>
       *
       * <code>optional int64 frequency = 3;</code>
       */
      public Builder setFrequency(long value) {
        
        frequency_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       * Typically 2.4GHz or 5GHz
       * </pre>
       *
       * <code>optional int64 frequency = 3;</code>
       */
      public Builder clearFrequency() {
        
        frequency_ = 0L;
        onChanged();
        return this;
      }
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }


      // @@protoc_insertion_point(builder_scope:AP_Data)
    }

    // @@protoc_insertion_point(class_scope:AP_Data)
    private static final AP_Data DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new AP_Data();
    }

    public static AP_Data getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<AP_Data>
        PARSER = new com.google.protobuf.AbstractParser<AP_Data>() {
      public AP_Data parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new AP_Data(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<AP_Data> parser() {
      return PARSER;
    }

    @Override
    public com.google.protobuf.Parser<AP_Data> getParserForType() {
      return PARSER;
    }

    public AP_Data getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  public interface Sensor_InfoOrBuilder extends
      // @@protoc_insertion_point(interface_extends:Sensor_Info)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>optional string name = 1;</code>
     */
    String getName();
    /**
     * <code>optional string name = 1;</code>
     */
    com.google.protobuf.ByteString
        getNameBytes();

    /**
     * <code>optional string vendor = 2;</code>
     */
    String getVendor();
    /**
     * <code>optional string vendor = 2;</code>
     */
    com.google.protobuf.ByteString
        getVendorBytes();

    /**
     * <code>optional float resolution = 3;</code>
     */
    float getResolution();

    /**
     * <code>optional float power = 4;</code>
     */
    float getPower();

    /**
     * <code>optional int32 version = 5;</code>
     */
    int getVersion();

    /**
     * <code>optional int32 type = 6;</code>
     */
    int getType();
  }
  /**
   * Protobuf type {@code Sensor_Info}
   */
  public  static final class Sensor_Info extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:Sensor_Info)
      Sensor_InfoOrBuilder {
    // Use Sensor_Info.newBuilder() to construct.
    private Sensor_Info(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private Sensor_Info() {
      name_ = "";
      vendor_ = "";
      resolution_ = 0F;
      power_ = 0F;
      version_ = 0;
      type_ = 0;
    }

    @Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
    }
    private Sensor_Info(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      int mutable_bitField0_ = 0;
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!input.skipField(tag)) {
                done = true;
              }
              break;
            }
            case 10: {
              String s = input.readStringRequireUtf8();

              name_ = s;
              break;
            }
            case 18: {
              String s = input.readStringRequireUtf8();

              vendor_ = s;
              break;
            }
            case 29: {

              resolution_ = input.readFloat();
              break;
            }
            case 37: {

              power_ = input.readFloat();
              break;
            }
            case 40: {

              version_ = input.readInt32();
              break;
            }
            case 48: {

              type_ = input.readInt32();
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return Traj.internal_static_Sensor_Info_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return Traj.internal_static_Sensor_Info_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              Sensor_Info.class, Builder.class);
    }

    public static final int NAME_FIELD_NUMBER = 1;
    private volatile Object name_;
    /**
     * <code>optional string name = 1;</code>
     */
    public String getName() {
      Object ref = name_;
      if (ref instanceof String) {
        return (String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        name_ = s;
        return s;
      }
    }
    /**
     * <code>optional string name = 1;</code>
     */
    public com.google.protobuf.ByteString
        getNameBytes() {
      Object ref = name_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        name_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int VENDOR_FIELD_NUMBER = 2;
    private volatile Object vendor_;
    /**
     * <code>optional string vendor = 2;</code>
     */
    public String getVendor() {
      Object ref = vendor_;
      if (ref instanceof String) {
        return (String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        vendor_ = s;
        return s;
      }
    }
    /**
     * <code>optional string vendor = 2;</code>
     */
    public com.google.protobuf.ByteString
        getVendorBytes() {
      Object ref = vendor_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        vendor_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int RESOLUTION_FIELD_NUMBER = 3;
    private float resolution_;
    /**
     * <code>optional float resolution = 3;</code>
     */
    public float getResolution() {
      return resolution_;
    }

    public static final int POWER_FIELD_NUMBER = 4;
    private float power_;
    /**
     * <code>optional float power = 4;</code>
     */
    public float getPower() {
      return power_;
    }

    public static final int VERSION_FIELD_NUMBER = 5;
    private int version_;
    /**
     * <code>optional int32 version = 5;</code>
     */
    public int getVersion() {
      return version_;
    }

    public static final int TYPE_FIELD_NUMBER = 6;
    private int type_;
    /**
     * <code>optional int32 type = 6;</code>
     */
    public int getType() {
      return type_;
    }

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (!getNameBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 1, name_);
      }
      if (!getVendorBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, vendor_);
      }
      if (resolution_ != 0F) {
        output.writeFloat(3, resolution_);
      }
      if (power_ != 0F) {
        output.writeFloat(4, power_);
      }
      if (version_ != 0) {
        output.writeInt32(5, version_);
      }
      if (type_ != 0) {
        output.writeInt32(6, type_);
      }
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (!getNameBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, name_);
      }
      if (!getVendorBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, vendor_);
      }
      if (resolution_ != 0F) {
        size += com.google.protobuf.CodedOutputStream
          .computeFloatSize(3, resolution_);
      }
      if (power_ != 0F) {
        size += com.google.protobuf.CodedOutputStream
          .computeFloatSize(4, power_);
      }
      if (version_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(5, version_);
      }
      if (type_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(6, type_);
      }
      memoizedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @Override
    public boolean equals(final Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof Sensor_Info)) {
        return super.equals(obj);
      }
      Sensor_Info other = (Sensor_Info) obj;

      boolean result = true;
      result = result && getName()
          .equals(other.getName());
      result = result && getVendor()
          .equals(other.getVendor());
      result = result && (
          Float.floatToIntBits(getResolution())
          == Float.floatToIntBits(
              other.getResolution()));
      result = result && (
          Float.floatToIntBits(getPower())
          == Float.floatToIntBits(
              other.getPower()));
      result = result && (getVersion()
          == other.getVersion());
      result = result && (getType()
          == other.getType());
      return result;
    }

    @Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptorForType().hashCode();
      hash = (37 * hash) + NAME_FIELD_NUMBER;
      hash = (53 * hash) + getName().hashCode();
      hash = (37 * hash) + VENDOR_FIELD_NUMBER;
      hash = (53 * hash) + getVendor().hashCode();
      hash = (37 * hash) + RESOLUTION_FIELD_NUMBER;
      hash = (53 * hash) + Float.floatToIntBits(
          getResolution());
      hash = (37 * hash) + POWER_FIELD_NUMBER;
      hash = (53 * hash) + Float.floatToIntBits(
          getPower());
      hash = (37 * hash) + VERSION_FIELD_NUMBER;
      hash = (53 * hash) + getVersion();
      hash = (37 * hash) + TYPE_FIELD_NUMBER;
      hash = (53 * hash) + getType();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static Sensor_Info parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Sensor_Info parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Sensor_Info parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Sensor_Info parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Sensor_Info parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static Sensor_Info parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static Sensor_Info parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static Sensor_Info parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static Sensor_Info parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static Sensor_Info parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(Sensor_Info prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code Sensor_Info}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:Sensor_Info)
        Sensor_InfoOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return Traj.internal_static_Sensor_Info_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return Traj.internal_static_Sensor_Info_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                Sensor_Info.class, Builder.class);
      }

      // Construct using Traj.Sensor_Info.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      public Builder clear() {
        super.clear();
        name_ = "";

        vendor_ = "";

        resolution_ = 0F;

        power_ = 0F;

        version_ = 0;

        type_ = 0;

        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return Traj.internal_static_Sensor_Info_descriptor;
      }

      public Sensor_Info getDefaultInstanceForType() {
        return Sensor_Info.getDefaultInstance();
      }

      public Sensor_Info build() {
        Sensor_Info result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public Sensor_Info buildPartial() {
        Sensor_Info result = new Sensor_Info(this);
        result.name_ = name_;
        result.vendor_ = vendor_;
        result.resolution_ = resolution_;
        result.power_ = power_;
        result.version_ = version_;
        result.type_ = type_;
        onBuilt();
        return result;
      }

      public Builder clone() {
        return (Builder) super.clone();
      }
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.setField(field, value);
      }
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof Sensor_Info) {
          return mergeFrom((Sensor_Info)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(Sensor_Info other) {
        if (other == Sensor_Info.getDefaultInstance()) return this;
        if (!other.getName().isEmpty()) {
          name_ = other.name_;
          onChanged();
        }
        if (!other.getVendor().isEmpty()) {
          vendor_ = other.vendor_;
          onChanged();
        }
        if (other.getResolution() != 0F) {
          setResolution(other.getResolution());
        }
        if (other.getPower() != 0F) {
          setPower(other.getPower());
        }
        if (other.getVersion() != 0) {
          setVersion(other.getVersion());
        }
        if (other.getType() != 0) {
          setType(other.getType());
        }
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        Sensor_Info parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (Sensor_Info) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private Object name_ = "";
      /**
       * <code>optional string name = 1;</code>
       */
      public String getName() {
        Object ref = name_;
        if (!(ref instanceof String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          String s = bs.toStringUtf8();
          name_ = s;
          return s;
        } else {
          return (String) ref;
        }
      }
      /**
       * <code>optional string name = 1;</code>
       */
      public com.google.protobuf.ByteString
          getNameBytes() {
        Object ref = name_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (String) ref);
          name_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string name = 1;</code>
       */
      public Builder setName(
          String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        name_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string name = 1;</code>
       */
      public Builder clearName() {
        
        name_ = getDefaultInstance().getName();
        onChanged();
        return this;
      }
      /**
       * <code>optional string name = 1;</code>
       */
      public Builder setNameBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        name_ = value;
        onChanged();
        return this;
      }

      private Object vendor_ = "";
      /**
       * <code>optional string vendor = 2;</code>
       */
      public String getVendor() {
        Object ref = vendor_;
        if (!(ref instanceof String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          String s = bs.toStringUtf8();
          vendor_ = s;
          return s;
        } else {
          return (String) ref;
        }
      }
      /**
       * <code>optional string vendor = 2;</code>
       */
      public com.google.protobuf.ByteString
          getVendorBytes() {
        Object ref = vendor_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (String) ref);
          vendor_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string vendor = 2;</code>
       */
      public Builder setVendor(
          String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        vendor_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string vendor = 2;</code>
       */
      public Builder clearVendor() {
        
        vendor_ = getDefaultInstance().getVendor();
        onChanged();
        return this;
      }
      /**
       * <code>optional string vendor = 2;</code>
       */
      public Builder setVendorBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        vendor_ = value;
        onChanged();
        return this;
      }

      private float resolution_ ;
      /**
       * <code>optional float resolution = 3;</code>
       */
      public float getResolution() {
        return resolution_;
      }
      /**
       * <code>optional float resolution = 3;</code>
       */
      public Builder setResolution(float value) {
        
        resolution_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional float resolution = 3;</code>
       */
      public Builder clearResolution() {
        
        resolution_ = 0F;
        onChanged();
        return this;
      }

      private float power_ ;
      /**
       * <code>optional float power = 4;</code>
       */
      public float getPower() {
        return power_;
      }
      /**
       * <code>optional float power = 4;</code>
       */
      public Builder setPower(float value) {
        
        power_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional float power = 4;</code>
       */
      public Builder clearPower() {
        
        power_ = 0F;
        onChanged();
        return this;
      }

      private int version_ ;
      /**
       * <code>optional int32 version = 5;</code>
       */
      public int getVersion() {
        return version_;
      }
      /**
       * <code>optional int32 version = 5;</code>
       */
      public Builder setVersion(int value) {
        
        version_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional int32 version = 5;</code>
       */
      public Builder clearVersion() {
        
        version_ = 0;
        onChanged();
        return this;
      }

      private int type_ ;
      /**
       * <code>optional int32 type = 6;</code>
       */
      public int getType() {
        return type_;
      }
      /**
       * <code>optional int32 type = 6;</code>
       */
      public Builder setType(int value) {
        
        type_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional int32 type = 6;</code>
       */
      public Builder clearType() {
        
        type_ = 0;
        onChanged();
        return this;
      }
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }


      // @@protoc_insertion_point(builder_scope:Sensor_Info)
    }

    // @@protoc_insertion_point(class_scope:Sensor_Info)
    private static final Sensor_Info DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new Sensor_Info();
    }

    public static Sensor_Info getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<Sensor_Info>
        PARSER = new com.google.protobuf.AbstractParser<Sensor_Info>() {
      public Sensor_Info parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new Sensor_Info(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<Sensor_Info> parser() {
      return PARSER;
    }

    @Override
    public com.google.protobuf.Parser<Sensor_Info> getParserForType() {
      return PARSER;
    }

    public Sensor_Info getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Trajectory_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Trajectory_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Pdr_Sample_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Pdr_Sample_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Motion_Sample_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Motion_Sample_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Position_Sample_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Position_Sample_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Pressure_Sample_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Pressure_Sample_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Light_Sample_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Light_Sample_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_GNSS_Sample_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_GNSS_Sample_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_WiFi_Sample_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_WiFi_Sample_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Mac_Scan_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Mac_Scan_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_AP_Data_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_AP_Data_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Sensor_Info_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Sensor_Info_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\ntraj.proto\"\337\004\n\nTrajectory\022\027\n\017android_v" +
      "ersion\030\001 \001(\t\022 \n\010imu_data\030\002 \003(\0132\016.Motion_" +
      "Sample\022\035\n\010pdr_data\030\003 \003(\0132\013.Pdr_Sample\022\'\n" +
      "\rposition_data\030\004 \003(\0132\020.Position_Sample\022\'" +
      "\n\rpressure_data\030\005 \003(\0132\020.Pressure_Sample\022" +
      "!\n\nlight_data\030\006 \003(\0132\r.Light_Sample\022\037\n\tgn" +
      "ss_data\030\007 \003(\0132\014.GNSS_Sample\022\037\n\twifi_data" +
      "\030\010 \003(\0132\014.WiFi_Sample\022\032\n\010aps_data\030\t \003(\0132\010" +
      ".AP_Data\022\027\n\017start_timestamp\030\n \001(\003\022\027\n\017dat" +
      "a_identifier\030\013 \001(\t\022(\n\022accelerometer_info",
      "\030\014 \001(\0132\014.Sensor_Info\022$\n\016gyroscope_info\030\r" +
      " \001(\0132\014.Sensor_Info\022*\n\024rotation_vector_in" +
      "fo\030\016 \001(\0132\014.Sensor_Info\022\'\n\021magnetometer_i" +
      "nfo\030\017 \001(\0132\014.Sensor_Info\022$\n\016barometer_inf" +
      "o\030\020 \001(\0132\014.Sensor_Info\022\'\n\021light_sensor_in" +
      "fo\030\021 \001(\0132\014.Sensor_Info\">\n\nPdr_Sample\022\032\n\022" +
      "relative_timestamp\030\001 \001(\003\022\t\n\001x\030\002 \001(\002\022\t\n\001y" +
      "\030\003 \001(\002\"\205\002\n\rMotion_Sample\022\032\n\022relative_tim" +
      "estamp\030\001 \001(\003\022\r\n\005acc_x\030\002 \001(\002\022\r\n\005acc_y\030\003 \001" +
      "(\002\022\r\n\005acc_z\030\004 \001(\002\022\r\n\005gyr_x\030\005 \001(\002\022\r\n\005gyr_",
      "y\030\006 \001(\002\022\r\n\005gyr_z\030\007 \001(\002\022\031\n\021rotation_vecto" +
      "r_x\030\010 \001(\002\022\031\n\021rotation_vector_y\030\t \001(\002\022\031\n\021" +
      "rotation_vector_z\030\n \001(\002\022\031\n\021rotation_vect" +
      "or_w\030\013 \001(\002\022\022\n\nstep_count\030\014 \001(\005\"Z\n\017Positi" +
      "on_Sample\022\032\n\022relative_timestamp\030\001 \001(\003\022\r\n" +
      "\005mag_x\030\002 \001(\002\022\r\n\005mag_y\030\003 \001(\002\022\r\n\005mag_z\030\004 \001" +
      "(\002\"?\n\017Pressure_Sample\022\032\n\022relative_timest" +
      "amp\030\001 \001(\003\022\020\n\010pressure\030\002 \001(\002\"9\n\014Light_Sam" +
      "ple\022\032\n\022relative_timestamp\030\001 \001(\003\022\r\n\005light" +
      "\030\002 \001(\002\"\223\001\n\013GNSS_Sample\022\032\n\022relative_times",
      "tamp\030\001 \001(\003\022\020\n\010latitude\030\002 \001(\002\022\021\n\tlongitud" +
      "e\030\003 \001(\002\022\020\n\010altitude\030\004 \001(\002\022\020\n\010accuracy\030\005 " +
      "\001(\002\022\r\n\005speed\030\006 \001(\002\022\020\n\010provider\030\007 \001(\t\"G\n\013" +
      "WiFi_Sample\022\032\n\022relative_timestamp\030\001 \001(\003\022" +
      "\034\n\tmac_scans\030\002 \003(\0132\t.Mac_Scan\"A\n\010Mac_Sca" +
      "n\022\032\n\022relative_timestamp\030\001 \001(\003\022\013\n\003mac\030\002 \001" +
      "(\003\022\014\n\004rssi\030\003 \001(\005\"7\n\007AP_Data\022\013\n\003mac\030\001 \001(\003" +
      "\022\014\n\004ssid\030\002 \001(\t\022\021\n\tfrequency\030\003 \001(\003\"m\n\013Sen" +
      "sor_Info\022\014\n\004name\030\001 \001(\t\022\016\n\006vendor\030\002 \001(\t\022\022" +
      "\n\nresolution\030\003 \001(\002\022\r\n\005power\030\004 \001(\002\022\017\n\007ver",
      "sion\030\005 \001(\005\022\014\n\004type\030\006 \001(\005b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_Trajectory_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Trajectory_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Trajectory_descriptor,
        new String[] { "AndroidVersion", "ImuData", "PdrData", "PositionData", "PressureData", "LightData", "GnssData", "WifiData", "ApsData", "StartTimestamp", "DataIdentifier", "AccelerometerInfo", "GyroscopeInfo", "RotationVectorInfo", "MagnetometerInfo", "BarometerInfo", "LightSensorInfo", });
    internal_static_Pdr_Sample_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_Pdr_Sample_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Pdr_Sample_descriptor,
        new String[] { "RelativeTimestamp", "X", "Y", });
    internal_static_Motion_Sample_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_Motion_Sample_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Motion_Sample_descriptor,
        new String[] { "RelativeTimestamp", "AccX", "AccY", "AccZ", "GyrX", "GyrY", "GyrZ", "RotationVectorX", "RotationVectorY", "RotationVectorZ", "RotationVectorW", "StepCount", });
    internal_static_Position_Sample_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_Position_Sample_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Position_Sample_descriptor,
        new String[] { "RelativeTimestamp", "MagX", "MagY", "MagZ", });
    internal_static_Pressure_Sample_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_Pressure_Sample_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Pressure_Sample_descriptor,
        new String[] { "RelativeTimestamp", "Pressure", });
    internal_static_Light_Sample_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_Light_Sample_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Light_Sample_descriptor,
        new String[] { "RelativeTimestamp", "Light", });
    internal_static_GNSS_Sample_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_GNSS_Sample_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_GNSS_Sample_descriptor,
        new String[] { "RelativeTimestamp", "Latitude", "Longitude", "Altitude", "Accuracy", "Speed", "Provider", });
    internal_static_WiFi_Sample_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_WiFi_Sample_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_WiFi_Sample_descriptor,
        new String[] { "RelativeTimestamp", "MacScans", });
    internal_static_Mac_Scan_descriptor =
      getDescriptor().getMessageTypes().get(8);
    internal_static_Mac_Scan_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Mac_Scan_descriptor,
        new String[] { "RelativeTimestamp", "Mac", "Rssi", });
    internal_static_AP_Data_descriptor =
      getDescriptor().getMessageTypes().get(9);
    internal_static_AP_Data_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_AP_Data_descriptor,
        new String[] { "Mac", "Ssid", "Frequency", });
    internal_static_Sensor_Info_descriptor =
      getDescriptor().getMessageTypes().get(10);
    internal_static_Sensor_Info_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Sensor_Info_descriptor,
        new String[] { "Name", "Vendor", "Resolution", "Power", "Version", "Type", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
