package com.huawei.hms.mlsdk.common;

import a9.a;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import com.huawei.hms.ml.common.utils.SmartLog;
import com.huawei.openalliance.ad.constant.u;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import z8.c;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class AgConnectInfo {
    private String apiKey;
    private String appMLKitGrsPolicy;
    private String applicationId;
    private String certFingerprint;
    private List<String> haCollectorUrls;
    private List<String> mlServiceUrls;
    private String packageName;
    private String projectId;
    private String region;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static final class AgConnectKey {
        public static final String ANALYTICS_COLLECTOR_URL = "service/analytics/collector_url";
        public static final String API_KEY = "client/api_key";
        public static final String APPLICATION_ID = "client/app_id";
        public static final String APP_MLKIT_GRS_POLICY = "processing_location_policy/mlkit";
        public static final String ML_SERVICE_URL = "service/ml/mlservice_url";
        public static final String PACKAGE_NAME = "client/package_name";
        public static final String PROJECT_ID = "client/project_id";
        public static final String REGION = "region";

        private AgConnectKey() {
        }
    }

    public AgConnectInfo(Context context) {
        this.mlServiceUrls = new ArrayList();
        this.haCollectorUrls = new ArrayList();
        context = context == null ? c.c().b() : context;
        if (context != null) {
            a b4 = a.b(context);
            SmartLog.i("AgConnectInfo", "AGConnectServicesConfig: " + ((Object) b4) + "context: " + ((Object) context));
            this.region = b4.getString(AgConnectKey.REGION);
            SmartLog.i("AgConnectInfo", "AGConnectServicesConfig: " + ((Object) b4) + "region: " + this.region);
            String string = b4.getString(AgConnectKey.PACKAGE_NAME);
            this.packageName = string;
            if (string == null) {
                this.packageName = context.getPackageName();
            } else {
                SmartLog.i("AgConnectInfo", "AGConnectServicesConfig: " + ((Object) b4) + "packageName: " + this.packageName);
            }
            String string2 = b4.getString(AgConnectKey.APPLICATION_ID);
            this.applicationId = string2;
            if (string2 == null) {
                this.applicationId = this.packageName;
            } else {
                SmartLog.i("AgConnectInfo", "AGConnectServicesConfig: " + ((Object) b4) + "packageName: " + this.packageName);
            }
            String string3 = b4.getString(AgConnectKey.API_KEY);
            this.apiKey = string3;
            if (string3 != null) {
                SmartLog.i("AgConnectInfo", "AGConnectServicesConfig: " + ((Object) b4) + "apiKey: apiKey is secret");
            }
            String rawSignature = getRawSignature(context);
            this.certFingerprint = rawSignature;
            if (rawSignature != null) {
                SmartLog.i("AgConnectInfo", "AGConnectServicesConfig: " + ((Object) b4) + "certFingerprint: certFingerprint is secret");
            }
            String string4 = b4.getString(AgConnectKey.ML_SERVICE_URL);
            if (string4 != null) {
                for (String str : string4.split(",")) {
                    String lowerCase = str.trim().toLowerCase(Locale.ENGLISH);
                    if (!lowerCase.startsWith("http://") && !lowerCase.startsWith("https://")) {
                        lowerCase = "https://" + lowerCase;
                    }
                    if (!lowerCase.endsWith("/")) {
                        lowerCase = lowerCase + "/";
                    }
                    this.mlServiceUrls.add(lowerCase);
                }
            }
            String string5 = b4.getString(AgConnectKey.ANALYTICS_COLLECTOR_URL);
            if (string5 != null) {
                for (String str2 : string5.split(",")) {
                    String lowerCase2 = str2.trim().toLowerCase(Locale.ENGLISH);
                    if (!lowerCase2.startsWith("http://") && !lowerCase2.startsWith("https://")) {
                        lowerCase2 = "https://" + lowerCase2;
                    }
                    this.haCollectorUrls.add(lowerCase2);
                }
            }
            this.projectId = b4.getString(AgConnectKey.PROJECT_ID);
            SmartLog.i("AgConnectInfo", "AGConnectServicesConfig: " + ((Object) b4) + "project_id: " + this.projectId);
            this.appMLKitGrsPolicy = b4.getString(AgConnectKey.APP_MLKIT_GRS_POLICY);
            SmartLog.i("AgConnectInfo", "AGConnectServicesConfig: " + ((Object) b4) + "processing_location_policy/mlkit: " + this.appMLKitGrsPolicy);
            return;
        }
        throw new IllegalStateException("Context not found.");
    }

    private String getRawSignature(Context context) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
        } catch (PackageManager.NameNotFoundException unused) {
        }
        if (packageInfo == null) {
            return "";
        }
        Signature signature = null;
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr != null && signatureArr.length > 0) {
            signature = signatureArr[0];
            SmartLog.i("AgConnectInfo", "signature is not null ");
        } else {
            SmartLog.i("AgConnectInfo", "signature is null ");
        }
        if (signature != null) {
            return getSignatureString(signature, "SHA256");
        }
        return "";
    }

    private final String getSignatureString(Signature signature, String str) {
        try {
            byte[] byteArray = signature.toByteArray();
            StringBuffer stringBuffer = new StringBuffer();
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            messageDigest.reset();
            messageDigest.update(byteArray);
            byte[] digest = messageDigest.digest();
            for (int i10 = 0; i10 < digest.length; i10++) {
                if (Integer.toHexString(digest[i10] & 255).length() == 1) {
                    stringBuffer.append("0");
                    stringBuffer.append(Integer.toHexString(digest[i10] & 255));
                } else {
                    stringBuffer.append(Integer.toHexString(digest[i10] & 255));
                }
                if (i10 != digest.length - 1) {
                    stringBuffer.append(u.bD);
                }
            }
            return stringBuffer.toString().toUpperCase(Locale.ENGLISH);
        } catch (Throwable unused) {
            return null;
        }
    }

    public String getApiKey() {
        return this.apiKey;
    }

    public String getAppMLKitGrsPolicy() {
        return this.appMLKitGrsPolicy;
    }

    public String getApplicationId() {
        return this.applicationId;
    }

    public String getCertFingerprint() {
        return this.certFingerprint;
    }

    public List<String> getHaCollectorUrls() {
        return this.haCollectorUrls;
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

    public AgConnectInfo() {
        this(null);
    }
}
