package com.wangmai.common.utils;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.wangmai.adIdUtils.utils.IdUtils;
import com.wangmai.common.runnable.HasReturnRunnable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class PrivateInfoHelper {
    public static final String KEY_ANDROID_ID = "KEY_ANDROID_ID";
    public static final String KEY_IMEI = "KEY_IMEI";
    public static final String KEY_IMSI = "KEY_IMSI";
    public static final String KEY_LATITUDE = "KEY_LATITUDE";
    public static final String KEY_LONGITUDE = "KEY_LONGITUDE";
    public static final String KEY_MAC = "KEY_MAC";
    public static final String KEY_MCC = "KEY_MCC";
    public static final String KEY_MEID = "KEY_MEID";
    public static final String KEY_MNC = "KEY_MNC";
    public static final String KEY_OAID = "KEY_OAID";
    public static final String KEY_OPERATOR = "KEY_OPERATOR";
    public static final String KEY_OPERATOR_TYPE = "KEY_OPERATOR_TYPE";
    public static final String KEY_PRIVATE_INFO = "KEY_PRIVATE_INFO";
    public static final String TAG = "PrivateInfoHelper";

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class BeanInfo {
        public long operator = 0;
        public long operatorType = 0;
        public long mnc = 0;
        public long mcc = 0;
        public long gps = 0;
        public long oaid = -1;
        public long androidId = 0;
        public long mac = 0;
        public long imsi = 0;
        public long imei = 0;
        public long meid = 0;
        public long appList = 0;

        public long getAndroidId() {
            return this.androidId;
        }

        public long getAppList() {
            return this.appList;
        }

        public long getGps() {
            return this.gps;
        }

        public long getImei() {
            return this.imei;
        }

        public long getImsi() {
            return this.imsi;
        }

        public long getMac() {
            return this.mac;
        }

        public long getMcc() {
            return this.mcc;
        }

        public long getMeid() {
            return this.meid;
        }

        public long getMnc() {
            return this.mnc;
        }

        public long getOaid() {
            return this.oaid;
        }

        public long getOperator() {
            return this.operator;
        }

        public long getOperatorType() {
            return this.operatorType;
        }

        public BeanInfo setAndroidId(long j10) {
            this.androidId = j10;
            return this;
        }

        public BeanInfo setAppList(long j10) {
            this.appList = j10;
            return this;
        }

        public BeanInfo setGps(long j10) {
            this.gps = j10;
            return this;
        }

        public BeanInfo setImei(long j10) {
            this.imei = j10;
            return this;
        }

        public BeanInfo setImsi(long j10) {
            this.imsi = j10;
            return this;
        }

        public BeanInfo setMac(long j10) {
            this.mac = j10;
            return this;
        }

        public BeanInfo setMcc(long j10) {
            this.mcc = j10;
            return this;
        }

        public BeanInfo setMeid(long j10) {
            this.meid = j10;
            return this;
        }

        public BeanInfo setMnc(long j10) {
            this.mnc = j10;
            return this;
        }

        public BeanInfo setOaid(long j10) {
            this.oaid = j10;
            return this;
        }

        public BeanInfo setOperator(long j10) {
            this.operator = j10;
            return this;
        }

        public BeanInfo setOperatorType(long j10) {
            this.operatorType = j10;
            return this;
        }

        public String toString() {
            return "BeanInfo{operator=" + this.operator + ", operatorType=" + this.operatorType + ", mnc=" + this.mnc + ", mcc=" + this.mcc + ", gps=" + this.gps + ", oaid=" + this.oaid + ", imei=" + this.imei + ", androidId=" + this.androidId + ", mac=" + this.mac + ", imsi=" + this.imsi + ", appList=" + this.appList + ", meid=" + this.meid + '}';
        }
    }

    public static String getAndroidId(final Context context) {
        if (ConstantInfo.isCanUsePhoneState()) {
            try {
                System.currentTimeMillis();
                BeanInfo privateInfo = getPrivateInfo(context);
                return CacheInfoUtil.getInfo(context.getApplicationContext(), TAG, KEY_ANDROID_ID, privateInfo != null ? privateInfo.getAndroidId() : 0L, new HasReturnRunnable<String>() { // from class: com.wangmai.common.utils.PrivateInfoHelper.10
                    @Override // com.wangmai.common.runnable.HasReturnRunnable
                    public String run() {
                        return Utils.getAndroidId(context);
                    }
                });
            } catch (Throwable th) {
                DebugLog.W(TAG, "getAndroidId error:" + th.toString());
            }
        } else {
            DebugLog.W(TAG, "getAndroidId error:canUsePhoneState is false");
        }
        return "";
    }

    public static long getAppList(Context context) {
        BeanInfo privateInfo = getPrivateInfo(context);
        if (privateInfo != null) {
            return privateInfo.getAppList();
        }
        return 0L;
    }

    public static int getConnectType(Context context) {
        if (ConstantInfo.isCanUseNetworkState()) {
            return Utils.getConnectType(context);
        }
        DebugLog.W(TAG, "getConnectType error: canUseNetworkState is false");
        return 0;
    }

    public static String getIMEI(final Context context) {
        String str;
        str = "";
        if (ConstantInfo.isCanUsePhoneState()) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                BeanInfo privateInfo = getPrivateInfo(context);
                str = CacheInfoUtil.getInfo(context.getApplicationContext(), TAG, KEY_IMEI, privateInfo != null ? privateInfo.getImei() : 0L, new HasReturnRunnable<String>() { // from class: com.wangmai.common.utils.PrivateInfoHelper.9
                    @Override // com.wangmai.common.runnable.HasReturnRunnable
                    public String run() {
                        String imei = IdUtils.getIMEI(context);
                        return (!TextUtils.isEmpty(imei) || TextUtils.isEmpty(ConstantInfo.getDevImei())) ? imei : ConstantInfo.getDevImei();
                    }
                });
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                if (currentTimeMillis2 > 10) {
                    DebugLog.W(TAG, "获取IMEI耗时：" + currentTimeMillis2 + " ms");
                }
            } catch (Throwable th) {
                DebugLog.W(TAG, "getIMEI error:" + th.toString());
            }
        } else {
            str = TextUtils.isEmpty(ConstantInfo.getDevImei()) ? "" : ConstantInfo.getDevImei();
            DebugLog.W(TAG, "getIMEI error:canUsePhoneState is false：" + str);
        }
        return str;
    }

    public static String getIMSI(final Context context) {
        if (ConstantInfo.isCanUsePhoneState()) {
            try {
                BeanInfo privateInfo = getPrivateInfo(context);
                return CacheInfoUtil.getInfo(context.getApplicationContext(), TAG, KEY_IMSI, privateInfo != null ? privateInfo.getImsi() : 0L, new HasReturnRunnable<String>() { // from class: com.wangmai.common.utils.PrivateInfoHelper.11
                    @Override // com.wangmai.common.runnable.HasReturnRunnable
                    public String run() {
                        return Utils.getIMSI(context);
                    }
                });
            } catch (Throwable unused) {
            }
        } else {
            DebugLog.W(TAG, "getIMSI error:canUsePhoneState is false");
        }
        return "";
    }

    public static String getLatitude(final Context context) {
        if (ConstantInfo.isCanUseLocation()) {
            try {
                System.currentTimeMillis();
                BeanInfo privateInfo = getPrivateInfo(context);
                return CacheInfoUtil.getInfo(context.getApplicationContext(), TAG, KEY_LATITUDE, privateInfo != null ? privateInfo.getGps() : 0L, new HasReturnRunnable<String>() { // from class: com.wangmai.common.utils.PrivateInfoHelper.6
                    @Override // com.wangmai.common.runnable.HasReturnRunnable
                    public String run() {
                        double latitude = new LocationUtils().getLatitude(context.getApplicationContext());
                        if (latitude <= ShadowDrawableWrapper.COS_45 && ConstantInfo.getDevWMLocation() != null) {
                            latitude = ConstantInfo.getDevWMLocation().getLatitude();
                        }
                        return String.valueOf(latitude);
                    }
                });
            } catch (Throwable th) {
                DebugLog.W(TAG, "getLatitude error:" + th.toString());
                return "";
            }
        }
        String valueOf = ConstantInfo.getDevWMLocation() != null ? String.valueOf(ConstantInfo.getDevWMLocation().getLatitude()) : "";
        DebugLog.W(TAG, "getLatitude error:canUseLocation is false：" + valueOf);
        return valueOf;
    }

    public static int getLocationAccuracy(final Context context) {
        if (ConstantInfo.isCanUseLocation()) {
            try {
                System.currentTimeMillis();
                BeanInfo privateInfo = getPrivateInfo(context);
                return Double.valueOf(CacheInfoUtil.getInfo(context.getApplicationContext(), TAG, KEY_LONGITUDE, privateInfo != null ? privateInfo.getGps() : 0L, new HasReturnRunnable<String>() { // from class: com.wangmai.common.utils.PrivateInfoHelper.8
                    @Override // com.wangmai.common.runnable.HasReturnRunnable
                    public String run() {
                        float accuracy = new LocationUtils().getAccuracy(context.getApplicationContext());
                        if (accuracy <= 0.0f && ConstantInfo.getDevWMLocation() != null) {
                            accuracy = ConstantInfo.getDevWMLocation().getAccuracy();
                        }
                        return String.valueOf(accuracy);
                    }
                })).intValue();
            } catch (Throwable th) {
                DebugLog.W(TAG, "getLocationAccuracy error：" + th.toString());
                return 0;
            }
        }
        int accuracy = ConstantInfo.getDevWMLocation() != null ? (int) ConstantInfo.getDevWMLocation().getAccuracy() : 0;
        DebugLog.W(TAG, "getLocationAccuracy error:canUseLocation is false:" + accuracy);
        return accuracy;
    }

    public static String getLongitude(final Context context) {
        if (ConstantInfo.isCanUseLocation()) {
            try {
                System.currentTimeMillis();
                BeanInfo privateInfo = getPrivateInfo(context);
                return CacheInfoUtil.getInfo(context.getApplicationContext(), TAG, KEY_LONGITUDE, privateInfo != null ? privateInfo.getGps() : 0L, new HasReturnRunnable<String>() { // from class: com.wangmai.common.utils.PrivateInfoHelper.7
                    @Override // com.wangmai.common.runnable.HasReturnRunnable
                    public String run() {
                        double longitude = new LocationUtils().getLongitude(context.getApplicationContext());
                        if (longitude <= ShadowDrawableWrapper.COS_45 && ConstantInfo.getDevWMLocation() != null) {
                            longitude = ConstantInfo.getDevWMLocation().getLongitude();
                        }
                        return String.valueOf(longitude);
                    }
                });
            } catch (Throwable th) {
                DebugLog.W(TAG, "getLongitude error：" + th.toString());
                return "";
            }
        }
        String valueOf = ConstantInfo.getDevWMLocation() != null ? String.valueOf(ConstantInfo.getDevWMLocation().getLongitude()) : "";
        DebugLog.W(TAG, "getLongitude error:canUseLocation is false：" + valueOf);
        return valueOf;
    }

    public static String getMCC(final Context context) {
        if (ConstantInfo.isCanUseNetworkState()) {
            try {
                BeanInfo privateInfo = getPrivateInfo(context);
                return CacheInfoUtil.getInfo(context.getApplicationContext(), TAG, KEY_MCC, privateInfo != null ? privateInfo.getMcc() : 0L, new HasReturnRunnable<String>() { // from class: com.wangmai.common.utils.PrivateInfoHelper.5
                    @Override // com.wangmai.common.runnable.HasReturnRunnable
                    public String run() {
                        return Utils.getMcc(context.getApplicationContext());
                    }
                });
            } catch (Throwable th) {
                DebugLog.W(TAG, "getMCC error:" + th.toString());
            }
        } else {
            DebugLog.W(TAG, "getMCC error:canUseNetworkState is false");
        }
        return "";
    }

    public static String getMEID(final Context context) {
        if (ConstantInfo.isCanUsePhoneState()) {
            try {
                BeanInfo privateInfo = getPrivateInfo(context);
                return CacheInfoUtil.getInfo(context.getApplicationContext(), TAG, KEY_MEID, privateInfo != null ? privateInfo.getMeid() : 0L, new HasReturnRunnable<String>() { // from class: com.wangmai.common.utils.PrivateInfoHelper.12
                    @Override // com.wangmai.common.runnable.HasReturnRunnable
                    public String run() {
                        return Utils.getMEID(context.getApplicationContext());
                    }
                });
            } catch (Throwable th) {
                DebugLog.W(TAG, "getMEID error:" + th.toString());
            }
        } else {
            DebugLog.W(TAG, "getMEID error:canUsePhoneState is false");
        }
        return "";
    }

    public static String getMNC(final Context context) {
        if (ConstantInfo.isCanUseNetworkState()) {
            try {
                BeanInfo privateInfo = getPrivateInfo(context);
                return CacheInfoUtil.getInfo(context.getApplicationContext(), TAG, KEY_MNC, privateInfo != null ? privateInfo.getMnc() : 0L, new HasReturnRunnable<String>() { // from class: com.wangmai.common.utils.PrivateInfoHelper.4
                    @Override // com.wangmai.common.runnable.HasReturnRunnable
                    public String run() {
                        return Utils.getMnc(context.getApplicationContext());
                    }
                });
            } catch (Throwable th) {
                DebugLog.W(TAG, "getMNC error:" + th.toString());
            }
        } else {
            DebugLog.W(TAG, "getMNC error:canUseNetworkState is false");
        }
        return "";
    }

    public static String getMac(final Context context) {
        if (ConstantInfo.isCanUseWifiState()) {
            try {
                BeanInfo privateInfo = getPrivateInfo(context);
                return CacheInfoUtil.getInfo(context.getApplicationContext(), TAG, KEY_MAC, privateInfo != null ? privateInfo.getMac() : 0L, new HasReturnRunnable<String>() { // from class: com.wangmai.common.utils.PrivateInfoHelper.13
                    @Override // com.wangmai.common.runnable.HasReturnRunnable
                    public String run() {
                        String macAddress = Utils.getMacAddress(context.getApplicationContext());
                        return (!TextUtils.isEmpty(macAddress) || TextUtils.isEmpty(ConstantInfo.getDevMacAddress())) ? macAddress : ConstantInfo.getDevMacAddress();
                    }
                });
            } catch (Throwable th) {
                DebugLog.W(TAG, "getMac error:" + th.toString());
                return "";
            }
        }
        String devMacAddress = TextUtils.isEmpty(ConstantInfo.getDevMacAddress()) ? "" : ConstantInfo.getDevMacAddress();
        DebugLog.W(TAG, "getMac error:canUseWifiState is false:" + devMacAddress);
        return devMacAddress;
    }

    public static String getOaid(final Context context) {
        if (ConstantInfo.isCanUseOaid()) {
            try {
                System.currentTimeMillis();
                BeanInfo privateInfo = getPrivateInfo(context);
                return CacheInfoUtil.getInfo(context.getApplicationContext(), TAG, KEY_OAID, privateInfo != null ? privateInfo.getOaid() : -1L, new HasReturnRunnable<String>() { // from class: com.wangmai.common.utils.PrivateInfoHelper.1
                    @Override // com.wangmai.common.runnable.HasReturnRunnable
                    public String run() {
                        String oaid = IdUtils.getOaid(context.getApplicationContext());
                        return (!TextUtils.isEmpty(oaid) || TextUtils.isEmpty(ConstantInfo.getDevOaid())) ? oaid : ConstantInfo.getDevOaid();
                    }
                });
            } catch (Throwable th) {
                DebugLog.W(TAG, "getOaid error:" + th.toString());
                return "";
            }
        }
        String devOaid = TextUtils.isEmpty(ConstantInfo.getDevOaid()) ? "" : ConstantInfo.getDevOaid();
        DebugLog.W(TAG, "getOaid error:isCanUseOaid is false!" + devOaid);
        return devOaid;
    }

    public static String getOperator(final Context context) {
        try {
            BeanInfo privateInfo = getPrivateInfo(context);
            return CacheInfoUtil.getInfo(context.getApplicationContext(), TAG, KEY_OPERATOR, privateInfo != null ? privateInfo.getOperator() : 0L, new HasReturnRunnable<String>() { // from class: com.wangmai.common.utils.PrivateInfoHelper.2
                @Override // com.wangmai.common.runnable.HasReturnRunnable
                public String run() {
                    return Utils.getOperator(context.getApplicationContext());
                }
            });
        } catch (Throwable th) {
            DebugLog.W(TAG, "getOperator error:" + th.toString());
            return "";
        }
    }

    public static int getOperatorType(final Context context) {
        try {
            BeanInfo privateInfo = getPrivateInfo(context);
            return Integer.parseInt(CacheInfoUtil.getInfo(context.getApplicationContext(), TAG, KEY_OPERATOR_TYPE, privateInfo != null ? privateInfo.getOperatorType() : 0L, new HasReturnRunnable<String>() { // from class: com.wangmai.common.utils.PrivateInfoHelper.3
                @Override // com.wangmai.common.runnable.HasReturnRunnable
                public String run() {
                    return String.valueOf(Utils.getOperatorType(context.getApplicationContext()));
                }
            }));
        } catch (Throwable th) {
            DebugLog.W(TAG, "getOperatorType error:" + th.toString());
            return 0;
        }
    }

    public static BeanInfo getPrivateInfo(Context context) {
        String preferencesString = SharedPreferencesHelper.getInstance(context).getPreferencesString(KEY_PRIVATE_INFO);
        if (TextUtils.isEmpty(preferencesString)) {
            return null;
        }
        return (BeanInfo) GsonUtils.getInstance().fromJson(preferencesString, BeanInfo.class);
    }

    public static void putPrivateInfo(Context context, BeanInfo beanInfo) {
        SharedPreferencesHelper.getInstance(context).savePreferencesString(KEY_PRIVATE_INFO, GsonUtils.getInstance().toJson(beanInfo));
    }
}
