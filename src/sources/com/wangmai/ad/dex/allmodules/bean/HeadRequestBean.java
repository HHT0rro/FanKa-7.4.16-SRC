package com.wangmai.ad.dex.allmodules.bean;

import com.wangmai.common.bean.ScreenSize;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class HeadRequestBean {
    private String apptoken;
    private DataBean data;
    private String sign;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public static class DataBean {
        private AdslotBean adslot;
        private App app;
        private Device device;
        private Gpss gps;
        private String installedApp;
        private Networks network;

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
        public static class AdslotBean {
            private String adslotId;
            private AdslotSizeBean adslotSize;
            private int gameId;
            private int secure;
            private int supportDeeplink;

            public String getAdslotId() {
                return this.adslotId;
            }

            public AdslotSizeBean getAdslotSize() {
                return this.adslotSize;
            }

            public int getGameId() {
                return this.gameId;
            }

            public int getSecure() {
                return this.secure;
            }

            public int getSupportDeeplink() {
                return this.supportDeeplink;
            }

            public void setAdslotId(String str) {
                this.adslotId = str;
            }

            public void setAdslotSize(AdslotSizeBean adslotSizeBean) {
                this.adslotSize = adslotSizeBean;
            }

            public void setGameId(int i10) {
                this.gameId = i10;
            }

            public void setSecure(int i10) {
                this.secure = i10;
            }

            public void setSupportDeeplink(int i10) {
                this.supportDeeplink = i10;
            }
        }

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

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
        public static class App {
            private String appName;
            private String appVersion;
            private String pkgName;

            public String getAppName() {
                return this.appName;
            }

            public String getAppVersion() {
                return this.appVersion;
            }

            public String getPkgName() {
                return this.pkgName;
            }

            public void setAppName(String str) {
                this.appName = str;
            }

            public void setAppVersion(String str) {
                this.appVersion = str;
            }

            public void setPkgName(String str) {
                this.pkgName = str;
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
        public static class Device {
            private String androidId;
            private String boot_mark;
            private int checkInstalledFlag;
            private String ctzid;
            private String density;
            private int deviceType;
            private String dpi;
            private String fingerprint;
            private String imei;
            private String language;
            private String mac;
            private String meid;
            private String model;
            private String oaid;
            private int orientation;
            private int osType;
            private String osVersion;
            private int ppi;
            private float pxratio;
            private String resolution;
            private ScreenSize screenSize;
            private String timezone;

            /* renamed from: ua, reason: collision with root package name */
            private String f46809ua;
            private String update_mark;
            private String vendor;
            private String xdpi;
            private String ydpi;

            public String getAndroidId() {
                return this.androidId;
            }

            public String getBoot_mark() {
                return this.boot_mark;
            }

            public int getCheckInstalledFlag() {
                return this.checkInstalledFlag;
            }

            public String getCtzid() {
                return this.ctzid;
            }

            public String getDensity() {
                return this.density;
            }

            public int getDeviceType() {
                return this.deviceType;
            }

            public String getDpi() {
                return this.dpi;
            }

            public String getFingerprint() {
                return this.fingerprint;
            }

            public String getImei() {
                return this.imei;
            }

            public String getLanguage() {
                return this.language;
            }

            public String getMac() {
                return this.mac;
            }

            public String getMeid() {
                return this.meid;
            }

            public String getModel() {
                return this.model;
            }

            public String getOaid() {
                return this.oaid;
            }

            public int getOrientation() {
                return this.orientation;
            }

            public int getOsType() {
                return this.osType;
            }

            public String getOsVersion() {
                return this.osVersion;
            }

            public int getPpi() {
                return this.ppi;
            }

            public float getPxratio() {
                return this.pxratio;
            }

            public String getResolution() {
                return this.resolution;
            }

            public ScreenSize getScreenSize() {
                return this.screenSize;
            }

            public String getTimezone() {
                return this.timezone;
            }

            public String getUa() {
                return this.f46809ua;
            }

            public String getUpdate_mark() {
                return this.update_mark;
            }

            public String getVendor() {
                return this.vendor;
            }

            public String getXdpi() {
                return this.xdpi;
            }

            public String getYdpi() {
                return this.ydpi;
            }

            public void setAndroidId(String str) {
                this.androidId = str;
            }

            public void setBoot_mark(String str) {
                this.boot_mark = str;
            }

            public void setCheckInstalledFlag(int i10) {
                this.checkInstalledFlag = i10;
            }

            public void setCtzid(String str) {
                this.ctzid = str;
            }

            public void setDensity(String str) {
                this.density = str;
            }

            public void setDeviceType(int i10) {
                this.deviceType = i10;
            }

            public void setDpi(String str) {
                this.dpi = str;
            }

            public void setFingerprint(String str) {
                this.fingerprint = str;
            }

            public void setImei(String str) {
                this.imei = str;
            }

            public void setLanguage(String str) {
                this.language = str;
            }

            public void setMac(String str) {
                this.mac = str;
            }

            public void setMeid(String str) {
                this.meid = str;
            }

            public void setModel(String str) {
                this.model = str;
            }

            public void setOaid(String str) {
                this.oaid = str;
            }

            public void setOrientation(int i10) {
                this.orientation = i10;
            }

            public void setOsType(int i10) {
                this.osType = i10;
            }

            public void setOsVersion(String str) {
                this.osVersion = str;
            }

            public void setPpi(int i10) {
                this.ppi = i10;
            }

            public void setPxratio(float f10) {
                this.pxratio = f10;
            }

            public void setResolution(String str) {
                this.resolution = str;
            }

            public void setScreenSize(ScreenSize screenSize) {
                this.screenSize = screenSize;
            }

            public void setTimezone(String str) {
                this.timezone = str;
            }

            public void setUa(String str) {
                this.f46809ua = str;
            }

            public void setUpdate_mark(String str) {
                this.update_mark = str;
            }

            public void setVendor(String str) {
                this.vendor = str;
            }

            public void setXdpi(String str) {
                this.xdpi = str;
            }

            public void setYdpi(String str) {
                this.ydpi = str;
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
        public static class Gpss {
            private String latitude;
            private String longitude;

            public String getLatitude() {
                return this.latitude;
            }

            public String getLongitude() {
                return this.longitude;
            }

            public void setLatitude(String str) {
                this.latitude = str;
            }

            public void setLongitude(String str) {
                this.longitude = str;
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
        public static class Networks {
            private int connectionType;
            private String imsi;
            private String mcc;
            private String mnc;
            private String operator;
            private int operatorType;

            public int getConnectionType() {
                return this.connectionType;
            }

            public String getImsi() {
                return this.imsi;
            }

            public String getMcc() {
                return this.mcc;
            }

            public String getMnc() {
                return this.mnc;
            }

            public String getOperator() {
                return this.operator;
            }

            public int getOperatorType() {
                return this.operatorType;
            }

            public void setConnectionType(int i10) {
                this.connectionType = i10;
            }

            public void setImsi(String str) {
                this.imsi = str;
            }

            public void setMcc(String str) {
                this.mcc = str;
            }

            public void setMnc(String str) {
                this.mnc = str;
            }

            public void setOperator(String str) {
                this.operator = str;
            }

            public void setOperatorType(int i10) {
                this.operatorType = i10;
            }
        }

        public AdslotBean getAdslot() {
            return this.adslot;
        }

        public App getApp() {
            return this.app;
        }

        public Device getDevice() {
            return this.device;
        }

        public Gpss getGps() {
            return this.gps;
        }

        public String getInstalledApp() {
            return this.installedApp;
        }

        public Networks getNetwork() {
            return this.network;
        }

        public void setAdslot(AdslotBean adslotBean) {
            this.adslot = adslotBean;
        }

        public void setApp(App app) {
            this.app = app;
        }

        public void setDevice(Device device) {
            this.device = device;
        }

        public void setGps(Gpss gpss) {
            this.gps = gpss;
        }

        public void setInstalledApp(String str) {
            this.installedApp = str;
        }

        public void setNetwork(Networks networks) {
            this.network = networks;
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
