package com.huawei.hms.mlsdk.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class MLApplicationSetting {
    private final Boolean acceptHa;
    private final String apiKey;
    private final String appId;
    private final String appMLKitGrsPolicy;
    private final String certFingerprint;
    private final Map<String, Object> extProperties;
    private final List<String> haCollectorUrls;
    private final String mlSdkVersion;
    private final List<String> mlServiceUrls;
    private final String packageName;
    private final String projectId;
    private final String region;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class BundleKeyConstants {

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
        public static final class AppInfo {
            public static final String APPID = "appid";
            public static final String APP_NAME = "appName";
            public static final String COUNTRY_CODE = "countryCode";
            public static final String ML_SDK_VERSION = "com.huawei.hms.client.service.name:ml-computer-vision";
            public static final String OPEN_HA = "openHa";
            public static final String PACKAGE_NAME = "packageName";
        }
    }

    private boolean equal(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static MLApplicationSetting fromResource(Context context) {
        AgConnectInfo agConnectInfo = new AgConnectInfo(context);
        String metadata = getMetadata(context, BundleKeyConstants.AppInfo.ML_SDK_VERSION, "");
        if (TextUtils.isEmpty(metadata)) {
            metadata = getKitMetadata(context, BundleKeyConstants.AppInfo.ML_SDK_VERSION, GrsBaseInfo.CountryCodeSource.UNKNOWN);
        }
        return new MLApplicationSetting(agConnectInfo.getApplicationId(), agConnectInfo.getApiKey(), agConnectInfo.getPackageName(), agConnectInfo.getCertFingerprint(), metadata, Settings.Secure.getInt(context.getContentResolver(), "hw_app_analytics_state", 0) == 1 ? Boolean.TRUE : Boolean.FALSE, agConnectInfo.getRegion(), agConnectInfo.getMLServiceUrls(), agConnectInfo.getHaCollectorUrls(), new HashMap(), agConnectInfo.getAppMLKitGrsPolicy(), agConnectInfo.getProjectId());
    }

    private static String getKitMetadata(Context context, String str, String str2) {
        Bundle bundle;
        try {
            PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(context.getApplicationInfo().sourceDir, 128);
            if (packageArchiveInfo != null && (bundle = packageArchiveInfo.applicationInfo.metaData) != null) {
                return bundle.getString(str, str2);
            }
        } catch (UnsupportedOperationException unused) {
        }
        return str2;
    }

    private static String getMetadata(Context context, String str, String str2) {
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle != null) {
                return bundle.getString(str, str2);
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return str2;
    }

    private int hashCode(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof MLApplicationSetting)) {
            return false;
        }
        MLApplicationSetting mLApplicationSetting = (MLApplicationSetting) obj;
        return equal(this.appId, mLApplicationSetting.appId) && equal(this.apiKey, mLApplicationSetting.apiKey);
    }

    public Boolean getAcceptHa() {
        return this.acceptHa;
    }

    public String getApiKey() {
        return this.apiKey;
    }

    public String getAppId() {
        return this.appId;
    }

    public String getAppMLKitGrsPolicy() {
        return this.appMLKitGrsPolicy;
    }

    public String getCertFingerprint() {
        return this.certFingerprint;
    }

    public Map<String, Object> getExtProperties() {
        return this.extProperties;
    }

    public List<String> getHaConnectorUrls() {
        return this.haCollectorUrls;
    }

    public String getMLSdkVersion() {
        return this.mlSdkVersion;
    }

    public List<String> getMLServiceUrls() {
        return this.mlServiceUrls;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getProjectId() {
        return this.projectId;
    }

    public String getRegion() {
        return this.region;
    }

    public String toString() {
        return "appId=" + this.appId + ", packageName=" + this.packageName + ", mlSdkVersion=" + this.mlSdkVersion + ", acceptHa=" + ((Object) this.acceptHa) + ", region=" + this.region + ", mlServiceUrls=" + ((Object) this.mlServiceUrls) + ", haCollectorUrls=" + ((Object) this.haCollectorUrls);
    }

    private MLApplicationSetting(String str, String str2, String str3, String str4, String str5, Boolean bool, String str6, List<String> list, List<String> list2, Map<String, Object> map, String str7, String str8) {
        this.appId = str;
        this.apiKey = str2;
        this.packageName = str3;
        this.certFingerprint = str4;
        this.mlSdkVersion = str5;
        this.acceptHa = bool;
        this.region = str6;
        this.mlServiceUrls = list;
        this.haCollectorUrls = list2;
        this.extProperties = map;
        this.appMLKitGrsPolicy = str7;
        this.projectId = str8;
    }

    public int hashCode() {
        return hashCode(this.appId, this.apiKey);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static final class Factory {
        private Boolean acceptHa;
        private String apiKey;
        private String appId;
        private String appMLKitGrsPolicy;
        private String certFingerprint;
        private Map<String, Object> extProperties;
        private List<String> haCollectorUrls;
        private String mlSdkVersion;
        private List<String> mlServiceUrls;
        private String packageName;
        private String projectId;
        private String region;

        public Factory() {
            this.mlServiceUrls = new ArrayList();
            this.haCollectorUrls = new ArrayList();
            this.extProperties = new HashMap();
        }

        public MLApplicationSetting create() {
            return new MLApplicationSetting(this.appId, this.apiKey, this.packageName, this.certFingerprint, this.mlSdkVersion, this.acceptHa, this.region, this.mlServiceUrls, this.haCollectorUrls, this.extProperties, this.appMLKitGrsPolicy, this.projectId);
        }

        public Factory setAcceptHa(Boolean bool) {
            this.acceptHa = bool;
            return this;
        }

        public Factory setApiKey(String str) {
            this.apiKey = str;
            return this;
        }

        public void setAppMLKitGrsPolicy(String str) {
            this.appMLKitGrsPolicy = str;
        }

        public Factory setApplicationId(String str) {
            this.appId = str;
            return this;
        }

        public Factory setCertFingerprint(String str) {
            this.certFingerprint = str;
            return this;
        }

        public Factory setExtProperties(String str, Object obj) {
            if (this.extProperties == null) {
                this.extProperties = new HashMap();
            }
            this.extProperties.put(str, obj);
            return this;
        }

        public Factory setHaCollectorUrls(List<String> list) {
            if (list == null) {
                list = new ArrayList<>();
            }
            this.haCollectorUrls = list;
            return this;
        }

        public Factory setMLSdkVersion(String str) {
            this.mlSdkVersion = str;
            return this;
        }

        public Factory setMLServiceUrls(List<String> list) {
            if (list == null) {
                list = new ArrayList<>();
            }
            this.mlServiceUrls = list;
            return this;
        }

        public Factory setPackageName(String str) {
            this.packageName = str;
            return this;
        }

        public void setProjectId(String str) {
            this.projectId = str;
        }

        public Factory setRegion(String str) {
            this.region = str;
            return this;
        }

        public Factory(MLApplicationSetting mLApplicationSetting) {
            this.mlServiceUrls = new ArrayList();
            this.haCollectorUrls = new ArrayList();
            this.extProperties = new HashMap();
            this.appId = mLApplicationSetting.appId;
            this.apiKey = mLApplicationSetting.apiKey;
            this.packageName = mLApplicationSetting.packageName;
            this.certFingerprint = mLApplicationSetting.certFingerprint;
            this.region = mLApplicationSetting.region;
            this.mlSdkVersion = mLApplicationSetting.mlSdkVersion;
            this.acceptHa = mLApplicationSetting.acceptHa;
            this.mlServiceUrls = mLApplicationSetting.mlServiceUrls;
            this.haCollectorUrls = mLApplicationSetting.haCollectorUrls;
            this.extProperties = mLApplicationSetting.extProperties;
            this.appMLKitGrsPolicy = mLApplicationSetting.appMLKitGrsPolicy;
            this.projectId = mLApplicationSetting.projectId;
        }
    }
}
