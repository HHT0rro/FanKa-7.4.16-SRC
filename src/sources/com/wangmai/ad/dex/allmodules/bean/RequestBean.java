package com.wangmai.ad.dex.allmodules.bean;

import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class RequestBean {
    private String apptoken;
    private DataBean data;
    private String sign;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public static class DataBean {
        private AdslotBean adslot;
        private AppBean app;
        private DeviceBean device;
        private GpsBean gps;
        private String installed_app;
        private NetworkBean network;
        private SdkBean sdk;

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
        public static class AdslotBean {
            private String adslot_id;
            private AdslotSizeBean adslot_size;
            private String gameId;
            private int secure;
            private int support_deeplink;

            /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
            /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
            public static class AdslotSizeBean {
                private int height;
                private int width;

                public int getHeight() {
                    return this.height;
                }

                public int getWidth() {
                    return this.width;
                }

                public void setHeight(int i10) {
                    this.height = i10;
                }

                public void setWidth(int i10) {
                    this.width = i10;
                }
            }

            public String getAdslot_id() {
                return this.adslot_id;
            }

            public AdslotSizeBean getAdslot_size() {
                return this.adslot_size;
            }

            public String getGameId() {
                return this.gameId;
            }

            public int getSecure() {
                return this.secure;
            }

            public int getSupport_deeplink() {
                return this.support_deeplink;
            }

            public void setAdslot_id(String str) {
                this.adslot_id = str;
            }

            public void setAdslot_size(AdslotSizeBean adslotSizeBean) {
                this.adslot_size = adslotSizeBean;
            }

            public void setGameId(String str) {
                this.gameId = str;
            }

            public AdslotBean setSecure(int i10) {
                this.secure = i10;
                return this;
            }

            public void setSupport_deeplink(int i10) {
                this.support_deeplink = i10;
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
        public static class AppBean {
            private String app_name;
            private AppVersionBean app_version;
            private String pkg_name;

            /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
            /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
            public static class AppVersionBean {
                private int major;
                private int micro;
                private int minor;

                public int getMajor() {
                    return this.major;
                }

                public int getMicro() {
                    return this.micro;
                }

                public int getMinor() {
                    return this.minor;
                }

                public void setMajor(int i10) {
                    this.major = i10;
                }

                public void setMicro(int i10) {
                    this.micro = i10;
                }

                public void setMinor(int i10) {
                    this.minor = i10;
                }
            }

            public String getApp_name() {
                return this.app_name;
            }

            public AppVersionBean getApp_version() {
                return this.app_version;
            }

            public String getPkg_name() {
                return this.pkg_name;
            }

            public void setApp_name(String str) {
                this.app_name = str;
            }

            public void setApp_version(AppVersionBean appVersionBean) {
                this.app_version = appVersionBean;
            }

            public void setPkg_name(String str) {
                this.pkg_name = str;
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
        public static class DeviceBean {
            private float battery_level;
            private int battery_state;
            private String board;
            private String boot_mark;
            private String bootloader_version;
            private boolean charging;
            private String country_code;
            private int cpu_cores;
            private int cpu_frequency;
            private String cpu_type;
            private boolean device_gyroscope;
            private String device_sensors;
            private int device_type;
            private String display;
            private String driver_name;
            private String fingerprint;
            private int free_memory;
            private String hardware;
            private boolean is_emulator;
            private boolean is_rooted;
            private boolean is_screen_black;
            private boolean is_screen_locked;
            private String language;
            private String manufacturer;
            private int max_cpu_frequency;
            private int min_cpu_frequency;
            private String model;
            private String motherboard_model;
            private int orientation;
            private int os_api_version;
            private int os_type;
            private OsVersionBean os_version;
            private int ppi;
            private int pxratio;
            private String rom_version;
            private ScreenSizeBean screen_size;
            private boolean supports_phone_calls;
            private int totalRam;
            private int totalRom;
            private UdidBean udid;
            private String update_mark;
            private String user_agent;
            private String vendor;
            private String ver_code_of_AG;
            private String ver_code_of_hms;

            /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
            /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
            public static class OsVersionBean {
                private int major;
                private int micro;
                private int minor;

                public int getMajor() {
                    return this.major;
                }

                public int getMicro() {
                    return this.micro;
                }

                public int getMinor() {
                    return this.minor;
                }

                public void setMajor(int i10) {
                    this.major = i10;
                }

                public void setMicro(int i10) {
                    this.micro = i10;
                }

                public void setMinor(int i10) {
                    this.minor = i10;
                }
            }

            /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
            /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
            public static class ScreenSizeBean {
                private int height;
                private int width;

                public int getHeight() {
                    return this.height;
                }

                public int getWidth() {
                    return this.width;
                }

                public void setHeight(int i10) {
                    this.height = i10;
                }

                public void setWidth(int i10) {
                    this.width = i10;
                }
            }

            /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
            /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
            public static class UdidBean {
                private String android_id;
                private String ctzid;
                private String idfa;
                private String imei;
                private String imsi;
                private String mac;
                private String oaid;

                public String getAndroid_id() {
                    return this.android_id;
                }

                public String getCtzid() {
                    return this.ctzid;
                }

                public String getIdfa() {
                    return this.idfa;
                }

                public String getImei() {
                    return this.imei;
                }

                public String getImsi() {
                    return this.imsi;
                }

                public String getMac() {
                    return this.mac;
                }

                public String getOaid() {
                    return this.oaid;
                }

                public void setAndroid_id(String str) {
                    this.android_id = str;
                }

                public void setCtzid(String str) {
                    this.ctzid = str;
                }

                public void setIdfa(String str) {
                    this.idfa = str;
                }

                public void setImei(String str) {
                    this.imei = str;
                }

                public void setImsi(String str) {
                    this.imsi = str;
                }

                public void setMac(String str) {
                    this.mac = str;
                }

                public void setOaid(String str) {
                    this.oaid = str;
                }
            }

            public float getBattery_level() {
                return this.battery_level;
            }

            public int getBattery_state() {
                return this.battery_state;
            }

            public String getBoard() {
                return this.board;
            }

            public String getBoot_mark() {
                return this.boot_mark;
            }

            public String getBootloader_version() {
                return this.bootloader_version;
            }

            public String getCountry_code() {
                return this.country_code;
            }

            public int getCpu_cores() {
                return this.cpu_cores;
            }

            public int getCpu_frequency() {
                return this.cpu_frequency;
            }

            public String getCpu_type() {
                return this.cpu_type;
            }

            public String getDevice_sensors() {
                return this.device_sensors;
            }

            public int getDevice_type() {
                return this.device_type;
            }

            public String getDisplay() {
                return this.display;
            }

            public String getDriver_name() {
                return this.driver_name;
            }

            public String getFingerprint() {
                return this.fingerprint;
            }

            public int getFree_memory() {
                return this.free_memory;
            }

            public String getHardware() {
                return this.hardware;
            }

            public String getLanguage() {
                return this.language;
            }

            public String getManufacturer() {
                return this.manufacturer;
            }

            public int getMax_cpu_frequency() {
                return this.max_cpu_frequency;
            }

            public int getMin_cpu_frequency() {
                return this.min_cpu_frequency;
            }

            public String getModel() {
                return this.model;
            }

            public String getMotherboard_model() {
                return this.motherboard_model;
            }

            public int getOrientation() {
                return this.orientation;
            }

            public int getOs_api_version() {
                return this.os_api_version;
            }

            public int getOs_type() {
                return this.os_type;
            }

            public OsVersionBean getOs_version() {
                return this.os_version;
            }

            public int getPpi() {
                return this.ppi;
            }

            public int getPxratio() {
                return this.pxratio;
            }

            public String getRom_version() {
                return this.rom_version;
            }

            public ScreenSizeBean getScreen_size() {
                return this.screen_size;
            }

            public int getTotalRam() {
                return this.totalRam;
            }

            public int getTotalRom() {
                return this.totalRom;
            }

            public UdidBean getUdid() {
                return this.udid;
            }

            public String getUpdate_mark() {
                return this.update_mark;
            }

            public String getUser_agent() {
                return this.user_agent;
            }

            public String getVendor() {
                return this.vendor;
            }

            public String getVer_code_of_AG() {
                return this.ver_code_of_AG;
            }

            public String getVer_code_of_hms() {
                return this.ver_code_of_hms;
            }

            public boolean isCharging() {
                return this.charging;
            }

            public boolean isDevice_gyroscope() {
                return this.device_gyroscope;
            }

            public boolean isIs_emulator() {
                return this.is_emulator;
            }

            public boolean isIs_rooted() {
                return this.is_rooted;
            }

            public boolean isIs_screen_black() {
                return this.is_screen_black;
            }

            public boolean isIs_screen_locked() {
                return this.is_screen_locked;
            }

            public boolean isSupports_phone_calls() {
                return this.supports_phone_calls;
            }

            public void setBattery_level(float f10) {
                this.battery_level = f10;
            }

            public void setBattery_state(int i10) {
                this.battery_state = i10;
            }

            public void setBoard(String str) {
                this.board = str;
            }

            public DeviceBean setBoot_mark(String str) {
                this.boot_mark = str;
                return this;
            }

            public void setBootloader_version(String str) {
                this.bootloader_version = str;
            }

            public void setCharging(boolean z10) {
                this.charging = z10;
            }

            public void setCountry_code(String str) {
                this.country_code = str;
            }

            public void setCpu_cores(int i10) {
                this.cpu_cores = i10;
            }

            public void setCpu_frequency(int i10) {
                this.cpu_frequency = i10;
            }

            public void setCpu_type(String str) {
                this.cpu_type = str;
            }

            public void setDevice_gyroscope(boolean z10) {
                this.device_gyroscope = z10;
            }

            public void setDevice_sensors(String str) {
                this.device_sensors = str;
            }

            public void setDevice_type(int i10) {
                this.device_type = i10;
            }

            public void setDisplay(String str) {
                this.display = str;
            }

            public void setDriver_name(String str) {
                this.driver_name = str;
            }

            public void setFingerprint(String str) {
                this.fingerprint = str;
            }

            public void setFree_memory(int i10) {
                this.free_memory = i10;
            }

            public void setHardware(String str) {
                this.hardware = str;
            }

            public void setIs_emulator(boolean z10) {
                this.is_emulator = z10;
            }

            public void setIs_rooted(boolean z10) {
                this.is_rooted = z10;
            }

            public void setIs_screen_black(boolean z10) {
                this.is_screen_black = z10;
            }

            public void setIs_screen_locked(boolean z10) {
                this.is_screen_locked = z10;
            }

            public DeviceBean setLanguage(String str) {
                this.language = str;
                return this;
            }

            public void setManufacturer(String str) {
                this.manufacturer = str;
            }

            public void setMax_cpu_frequency(int i10) {
                this.max_cpu_frequency = i10;
            }

            public void setMin_cpu_frequency(int i10) {
                this.min_cpu_frequency = i10;
            }

            public void setModel(String str) {
                this.model = str;
            }

            public void setMotherboard_model(String str) {
                this.motherboard_model = str;
            }

            public void setOrientation(int i10) {
                this.orientation = i10;
            }

            public void setOs_api_version(int i10) {
                this.os_api_version = i10;
            }

            public void setOs_type(int i10) {
                this.os_type = i10;
            }

            public void setOs_version(OsVersionBean osVersionBean) {
                this.os_version = osVersionBean;
            }

            public void setPpi(int i10) {
                this.ppi = i10;
            }

            public void setPxratio(int i10) {
                this.pxratio = i10;
            }

            public DeviceBean setRom_version(String str) {
                this.rom_version = str;
                return this;
            }

            public void setScreen_size(ScreenSizeBean screenSizeBean) {
                this.screen_size = screenSizeBean;
            }

            public void setSupports_phone_calls(boolean z10) {
                this.supports_phone_calls = z10;
            }

            public void setTotalRam(int i10) {
                this.totalRam = i10;
            }

            public void setTotalRom(int i10) {
                this.totalRom = i10;
            }

            public void setUdid(UdidBean udidBean) {
                this.udid = udidBean;
            }

            public DeviceBean setUpdate_mark(String str) {
                this.update_mark = str;
                return this;
            }

            public void setUser_agent(String str) {
                this.user_agent = str;
            }

            public void setVendor(String str) {
                this.vendor = str;
            }

            public DeviceBean setVer_code_of_AG(String str) {
                this.ver_code_of_AG = str;
                return this;
            }

            public DeviceBean setVer_code_of_hms(String str) {
                this.ver_code_of_hms = str;
                return this;
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
        public static class GpsBean {
            private int accuracy_radius;
            private int coordinate_type;
            private String latitude;
            private String longitude;
            private String timestamp;

            public int getAccuracy_radius() {
                return this.accuracy_radius;
            }

            public int getCoordinate_type() {
                return this.coordinate_type;
            }

            public String getLatitude() {
                return this.latitude;
            }

            public String getLongitude() {
                return this.longitude;
            }

            public String getTimestamp() {
                return this.timestamp;
            }

            public void setAccuracy_radius(int i10) {
                this.accuracy_radius = i10;
            }

            public void setCoordinate_type(int i10) {
                this.coordinate_type = i10;
            }

            public void setLatitude(String str) {
                this.latitude = str;
            }

            public void setLongitude(String str) {
                this.longitude = str;
            }

            public void setTimestamp(String str) {
                this.timestamp = str;
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
        public static class NetworkBean {
            private int connection_type;
            private String imsi;
            private String operator;
            private int operator_type;

            public int getConnection_type() {
                return this.connection_type;
            }

            public String getImsi() {
                return this.imsi;
            }

            public String getOperator() {
                return this.operator;
            }

            public int getOperator_type() {
                return this.operator_type;
            }

            public void setConnection_type(int i10) {
                this.connection_type = i10;
            }

            public void setImsi(String str) {
                this.imsi = str;
            }

            public void setOperator(String str) {
                this.operator = str;
            }

            public void setOperator_type(int i10) {
                this.operator_type = i10;
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
        public static class SdkBean {
            private List<AdCache> adCacheList;
            private int personal_recommend;

            /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
            /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
            public static class AdCache {
                private int cacheTime;
                private String crid;
                private long expireTime;
                private int thirdSlotIdKey;

                public int getCacheTime() {
                    return this.cacheTime;
                }

                public String getCrid() {
                    return this.crid;
                }

                public long getExpireTime() {
                    return this.expireTime;
                }

                public int getThirdSlotIdKey() {
                    return this.thirdSlotIdKey;
                }

                public void setCacheTime(int i10) {
                    this.cacheTime = i10;
                }

                public void setCrid(String str) {
                    this.crid = str;
                }

                public void setExpireTime(long j10) {
                    this.expireTime = j10;
                }

                public void setThirdSlotIdKey(int i10) {
                    this.thirdSlotIdKey = i10;
                }
            }

            public List<AdCache> getAdCacheList() {
                return this.adCacheList;
            }

            public int getPersonal_recommend() {
                return this.personal_recommend;
            }

            public void setAdCacheList(List<AdCache> list) {
                this.adCacheList = list;
            }

            public void setPersonal_recommend(int i10) {
                this.personal_recommend = i10;
            }
        }

        public AdslotBean getAdslot() {
            return this.adslot;
        }

        public AppBean getApp() {
            return this.app;
        }

        public DeviceBean getDevice() {
            return this.device;
        }

        public GpsBean getGps() {
            return this.gps;
        }

        public String getInstalled_app() {
            return this.installed_app;
        }

        public NetworkBean getNetwork() {
            return this.network;
        }

        public SdkBean getSdk() {
            return this.sdk;
        }

        public void setAdslot(AdslotBean adslotBean) {
            this.adslot = adslotBean;
        }

        public void setApp(AppBean appBean) {
            this.app = appBean;
        }

        public void setDevice(DeviceBean deviceBean) {
            this.device = deviceBean;
        }

        public void setGps(GpsBean gpsBean) {
            this.gps = gpsBean;
        }

        public void setInstalled_app(String str) {
            this.installed_app = str;
        }

        public void setNetwork(NetworkBean networkBean) {
            this.network = networkBean;
        }

        public void setSdk(SdkBean sdkBean) {
            this.sdk = sdkBean;
        }
    }

    public String getApptoken() {
        return this.apptoken;
    }

    public DataBean getData() {
        return this.data;
    }

    public String getSign() {
        return this.sign;
    }

    public void setApptoken(String str) {
        this.apptoken = str;
    }

    public void setData(DataBean dataBean) {
        this.data = dataBean;
    }

    public void setSign(String str) {
        this.sign = str;
    }
}
