package com.wangmai.common.bean;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class AppConfigRespBean {
    public Appconfig appConfig;
    public BundlesBean ckeckBundles;
    public long currentTimeStamp;
    public NbrBean nbr;
    public String realmName;
    public String trackHost;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class NbrBean {
        public int code;
        public String msg;

        public int getCode() {
            return this.code;
        }

        public String getMsg() {
            return this.msg;
        }

        public void setCode(int i10) {
            this.code = i10;
        }

        public void setMsg(String str) {
            this.msg = str;
        }

        public String toString() {
            return "NbrBean{code=" + this.code + ", msg='" + this.msg + "'}";
        }
    }

    public Appconfig getAppConfig() {
        return this.appConfig;
    }

    public BundlesBean getCkeckBundles() {
        return this.ckeckBundles;
    }

    public long getCurrentTimeStamp() {
        return this.currentTimeStamp;
    }

    public NbrBean getNbr() {
        return this.nbr;
    }

    public String getRealmName() {
        return this.realmName;
    }

    public String getTrackHost() {
        return this.trackHost;
    }

    public void setAppConfig(Appconfig appconfig) {
        this.appConfig = appconfig;
    }

    public void setCkeckBundles(BundlesBean bundlesBean) {
        this.ckeckBundles = bundlesBean;
    }

    public void setCurrentTimeStamp(long j10) {
        this.currentTimeStamp = j10;
    }

    public void setNbr(NbrBean nbrBean) {
        this.nbr = nbrBean;
    }

    public void setRealmName(String str) {
        this.realmName = str;
    }

    public void setTrackHost(String str) {
        this.trackHost = str;
    }

    public String toString() {
        return "GetHeadData{nbr=" + ((Object) this.nbr) + ", appConfig=" + ((Object) this.appConfig) + ", ckeckBundles=" + ((Object) this.ckeckBundles) + ", currentTimeStamp=" + this.currentTimeStamp + ", realmName='" + this.realmName + "', trackHost='" + this.trackHost + "'}";
    }
}
