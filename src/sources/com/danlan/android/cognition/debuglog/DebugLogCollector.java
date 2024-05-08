package com.danlan.android.cognition.debuglog;

import android.content.Context;
import android.content.pm.PackageManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import com.danlan.android.cognition.Cognition;
import com.danlan.android.cognition.Logger;
import com.danlan.android.cognition.NativeLib;
import com.danlan.android.cognition.StringFog;
import com.danlan.android.cognition.collector.HardwareCollector;
import com.danlan.android.cognition.collector.listener.DeviceInfoDependency;
import com.danlan.android.cognition.collector.util.NetUtil;
import com.danlan.android.cognition.collector.util.SafeJSONObject;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class DebugLogCollector {
    private static boolean isDebugLogEnable;
    private Context mContext;
    private PackageManager packageManager;
    private String type = "";
    private String action = "";
    private String collect_status = "";
    private String collect_fail_type = "";
    private String collect_fail_msg = "";
    private String http_status = "";
    private String http_code = "";
    private String http_request = "";
    private String http_response = "";
    private String server_domain = "";
    private String request_api = "";
    private String request_id = "";
    private String request_client_time = "";
    private String fail_msg = "";
    private String reconnectTime = "";

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public @interface CollectStatus {
        public static final String START = StringFog.decrypt("UldFUVU=");
        public static final String SUC = StringFog.decrypt("UlZH");
        public static final String FAIL = StringFog.decrypt("R0JNTw==");
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class HttpTaskLog implements Callable<String> {
        private final Context cxt;
        private String requestData;

        public HttpTaskLog(Context context, String str) {
            this.cxt = context;
            this.requestData = str;
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x003d A[Catch: Exception -> 0x00b7, TryCatch #2 {Exception -> 0x00b7, blocks: (B:3:0x0002, B:10:0x002e, B:12:0x003d, B:13:0x005c, B:15:0x0083, B:22:0x00a7, B:24:0x00ab, B:25:0x00b6, B:29:0x002b, B:17:0x0088), top: B:2:0x0002, inners: #3 }] */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0083 A[Catch: Exception -> 0x00b7, TRY_LEAVE, TryCatch #2 {Exception -> 0x00b7, blocks: (B:3:0x0002, B:10:0x002e, B:12:0x003d, B:13:0x005c, B:15:0x0083, B:22:0x00a7, B:24:0x00ab, B:25:0x00b6, B:29:0x002b, B:17:0x0088), top: B:2:0x0002, inners: #3 }] */
        /* JADX WARN: Removed duplicated region for block: B:24:0x00ab A[Catch: Exception -> 0x00b7, TryCatch #2 {Exception -> 0x00b7, blocks: (B:3:0x0002, B:10:0x002e, B:12:0x003d, B:13:0x005c, B:15:0x0083, B:22:0x00a7, B:24:0x00ab, B:25:0x00b6, B:29:0x002b, B:17:0x0088), top: B:2:0x0002, inners: #3 }] */
        /* JADX WARN: Removed duplicated region for block: B:26:0x005a  */
        @Override // java.util.concurrent.Callable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.String call() {
            /*
                r7 = this;
                java.lang.String r0 = ""
                com.danlan.android.cognition.collector.util.SafeJSONObject r4 = new com.danlan.android.cognition.collector.util.SafeJSONObject     // Catch: java.lang.Exception -> Lb7
                r4.<init>()     // Catch: java.lang.Exception -> Lb7
                r1 = 0
                java.lang.String r2 = r7.requestData     // Catch: java.lang.Exception -> L29
                java.lang.String r2 = com.danlan.android.cognition.Cryptor.encrypt(r2)     // Catch: java.lang.Exception -> L29
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L27
                r3.<init>()     // Catch: java.lang.Exception -> L27
                java.lang.String r5 = "ek9LRFIDSUBKRnFTTUxFRXNGVVZEUFB8AVZUT05CQAFFQlBCxIyix7ekCQ4fGQ=="
                java.lang.String r5 = com.danlan.android.cognition.StringFog.decrypt(r5)     // Catch: java.lang.Exception -> L27
                r3.append(r5)     // Catch: java.lang.Exception -> L27
                r3.append(r2)     // Catch: java.lang.Exception -> L27
                java.lang.String r3 = r3.toString()     // Catch: java.lang.Exception -> L27
                com.danlan.android.cognition.Logger.t(r3)     // Catch: java.lang.Exception -> L27
                goto L2e
            L27:
                r3 = move-exception
                goto L2b
            L29:
                r3 = move-exception
                r2 = r1
            L2b:
                r3.printStackTrace()     // Catch: java.lang.Exception -> Lb7
            L2e:
                java.lang.String r3 = "fg=="
                java.lang.String r3 = com.danlan.android.cognition.StringFog.decrypt(r3)     // Catch: java.lang.Exception -> Lb7
                r4.put(r3, r2)     // Catch: java.lang.Exception -> Lb7
                com.danlan.android.cognition.collector.listener.DeviceInfoDependency r2 = com.danlan.android.cognition.Cognition.getDependency()     // Catch: java.lang.Exception -> Lb7
                if (r2 == 0) goto L5a
                com.danlan.android.cognition.collector.listener.DeviceInfoDependency r1 = com.danlan.android.cognition.Cognition.getDependency()     // Catch: java.lang.Exception -> Lb7
                java.util.Objects.requireNonNull(r1)     // Catch: java.lang.Exception -> Lb7
                com.danlan.android.cognition.collector.listener.DeviceInfoDependency r1 = (com.danlan.android.cognition.collector.listener.DeviceInfoDependency) r1     // Catch: java.lang.Exception -> Lb7
                java.lang.String r1 = r1.setSpecialUserAgent()     // Catch: java.lang.Exception -> Lb7
                com.danlan.android.cognition.collector.listener.DeviceInfoDependency r2 = com.danlan.android.cognition.Cognition.getDependency()     // Catch: java.lang.Exception -> Lb7
                java.util.Objects.requireNonNull(r2)     // Catch: java.lang.Exception -> Lb7
                com.danlan.android.cognition.collector.listener.DeviceInfoDependency r2 = (com.danlan.android.cognition.collector.listener.DeviceInfoDependency) r2     // Catch: java.lang.Exception -> Lb7
                java.util.Map r2 = r2.setHeaderData()     // Catch: java.lang.Exception -> Lb7
                r5 = r1
                r6 = r2
                goto L5c
            L5a:
                r5 = r1
                r6 = r5
            L5c:
                android.content.Context r1 = r7.cxt     // Catch: java.lang.Exception -> Lb7
                com.danlan.android.cognition.collector.listener.DeviceInfoDependency r2 = com.danlan.android.cognition.Cognition.getDependency()     // Catch: java.lang.Exception -> Lb7
                java.util.Objects.requireNonNull(r2)     // Catch: java.lang.Exception -> Lb7
                com.danlan.android.cognition.collector.listener.DeviceInfoDependency r2 = (com.danlan.android.cognition.collector.listener.DeviceInfoDependency) r2     // Catch: java.lang.Exception -> Lb7
                java.util.Map r2 = r2.setServerDomain()     // Catch: java.lang.Exception -> Lb7
                java.lang.String r3 = "UkZWVURRe0VOTkVKTw=="
                java.lang.String r3 = com.danlan.android.cognition.StringFog.decrypt(r3)     // Catch: java.lang.Exception -> Lb7
                java.lang.Object r2 = r2.get(r3)     // Catch: java.lang.Exception -> Lb7
                java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Exception -> Lb7
                java.lang.String r3 = "DlNFUFJTS1NVDEhMRlA="
                java.lang.String r3 = com.danlan.android.cognition.StringFog.decrypt(r3)     // Catch: java.lang.Exception -> Lb7
                java.lang.String r1 = com.danlan.android.cognition.network.HttpUtil.sendPost(r1, r2, r3, r4, r5, r6)     // Catch: java.lang.Exception -> Lb7
                if (r1 == 0) goto Lab
                org.json.JSONObject r2 = new org.json.JSONObject     // Catch: java.lang.Exception -> Lb7
                r2.<init>(r1)     // Catch: java.lang.Exception -> Lb7
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> La6
                r1.<init>()     // Catch: java.lang.Exception -> La6
                java.lang.String r3 = "YkxDTUhXTU5PcGBoAU9LRlJ4VkZSU0tPUkZ5"
                java.lang.String r3 = com.danlan.android.cognition.StringFog.decrypt(r3)     // Catch: java.lang.Exception -> La6
                r1.append(r3)     // Catch: java.lang.Exception -> La6
                r3 = 4
                java.lang.String r2 = r2.toString(r3)     // Catch: java.lang.Exception -> La6
                r1.append(r2)     // Catch: java.lang.Exception -> La6
                java.lang.String r1 = r1.toString()     // Catch: java.lang.Exception -> La6
                com.danlan.android.cognition.Logger.d(r1)     // Catch: java.lang.Exception -> La6
                return r0
            La6:
                r1 = move-exception
                r1.printStackTrace()     // Catch: java.lang.Exception -> Lb7
                return r0
            Lab:
                java.io.IOException r1 = new java.io.IOException     // Catch: java.lang.Exception -> Lb7
                java.lang.String r2 = "TUxDUAFtSwFTRldWTVcEU0RXUVFPRkAP"
                java.lang.String r2 = com.danlan.android.cognition.StringFog.decrypt(r2)     // Catch: java.lang.Exception -> Lb7
                r1.<init>(r2)     // Catch: java.lang.Exception -> Lb7
                throw r1     // Catch: java.lang.Exception -> Lb7
            Lb7:
                r1 = move-exception
                java.lang.String r1 = r1.getMessage()
                com.danlan.android.cognition.Logger.e(r1)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.danlan.android.cognition.debuglog.DebugLogCollector.HttpTaskLog.call():java.lang.String");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public @interface Type {
        public static final String SUC = StringFog.decrypt("UlZHQERQVw==");
        public static final String COLLECT_FAIL = StringFog.decrypt("QkxIT0RAUH5HQk1P");
        public static final String REQUEST_FAIL = StringFog.decrypt("U0ZVVkRQUH5HQk1P");
    }

    public DebugLogCollector(Context context) {
        this.mContext = context;
        this.packageManager = context.getPackageManager();
    }

    public static boolean isIsDebugLogEnable() {
        return isDebugLogEnable;
    }

    public static void setIsDebugLogEnable(boolean z10) {
        isDebugLogEnable = z10;
    }

    public String doCollectInfo() {
        String str;
        SafeJSONObject safeJSONObject = new SafeJSONObject();
        Logger.e(StringFog.decrypt("xZuuxauGQERDVkPFtobBnrY="));
        try {
            safeJSONObject.put(StringFog.decrypt("VVpURg=="), this.type);
            safeJSONObject.put(StringFog.decrypt("QEBQSk5N"), this.action);
            if (Cognition.getDependency() != null) {
                String decrypt = StringFog.decrypt("VEpA");
                DeviceInfoDependency dependency = Cognition.getDependency();
                Objects.requireNonNull(dependency);
                safeJSONObject.put(decrypt, dependency.setUserData().get(StringFog.decrypt("VFBBUWhH")));
            }
            safeJSONObject.put(StringFog.decrypt("VFBBUX5CQ0RPVw=="), getUserAgent());
            safeJSONObject.put(StringFog.decrypt("Qk9NRk9Xe0hR"), NetUtil.getIpAddress(this.mContext));
            safeJSONObject.put(StringFog.decrypt("Qk9NRk9Xe1VITkE="), System.currentTimeMillis());
            safeJSONObject.put(StringFog.decrypt("UkdPfFdGVlJITEo="), Cognition.getSdkVersion());
            if (Cognition.getDependency() != null) {
                String decrypt2 = StringFog.decrypt("QFNUfE9CSUQ=");
                DeviceInfoDependency dependency2 = Cognition.getDependency();
                Objects.requireNonNull(dependency2);
                safeJSONObject.put(decrypt2, dependency2.setUserData().get(StringFog.decrypt("QFNUbUBOQQ==")));
            }
            safeJSONObject.put(StringFog.decrypt("QFNUfFdGVlJITEp8T0JJRA=="), getVersionName());
            safeJSONObject.put(StringFog.decrypt("QFNUfFdGVlJITEp8QkxARA=="), getVersionCode());
            safeJSONObject.put(StringFog.decrypt("TlB7VURRV0hOTQ=="), getOSVersion());
            safeJSONObject.put(StringFog.decrypt("Q1FFTUU="), HardwareCollector.getBuildBrand());
            safeJSONObject.put(StringFog.decrypt("TExARk0="), HardwareCollector.getModel());
            safeJSONObject.put(StringFog.decrypt("T0ZQVE5RT35SV0VXVFA="), NetUtil.getNetWorkState(this.mContext));
            if (NativeLib.checkLoadSo()) {
                safeJSONObject.put(StringFog.decrypt("T0ZQVE5RT35VWlRG"), NativeLib.pg(StringFog.decrypt("RlBJDU9GUFZOUU8NVVpURA=="), StringFog.decrypt("VE1PTU5USg==")));
                safeJSONObject.put(StringFog.decrypt("T0ZQVE5RT35OU0FRQFdLUw=="), NativeLib.pg(StringFog.decrypt("RlBJDU5TQVNAV0tRD0JIUUlC"), StringFog.decrypt("VE1PTU5USg==")));
            }
            safeJSONObject.put(StringFog.decrypt("UU9FV0dMVkw="), StringFog.decrypt("QE1AUU5KQA=="));
            SafeJSONObject safeJSONObject2 = new SafeJSONObject();
            safeJSONObject2.put(StringFog.decrypt("QkxIT0RAUH5SV0VXVFA="), this.collect_status);
            safeJSONObject2.put(StringFog.decrypt("QkxIT0RAUH5HQk1PflddUUQ="), this.collect_fail_type);
            safeJSONObject2.put(StringFog.decrypt("QkxIT0RAUH5HQk1Pfk5XRg=="), this.collect_fail_msg);
            safeJSONObject2.put(StringFog.decrypt("SVdQU35QUEBVVlc="), this.http_status);
            safeJSONObject2.put(StringFog.decrypt("SVdQU35RQVJRTEpQRHxHTkVG"), this.http_code);
            if (this.type.equals(StringFog.decrypt("U0ZVVkRQUH5HQk1P")) && (str = this.http_code) != null && str.equals(StringFog.decrypt("FBMU"))) {
                safeJSONObject2.put(StringFog.decrypt("SVdQU35RQVBURldX"), this.http_request);
            }
            safeJSONObject2.put(StringFog.decrypt("SVdQU35RQVJRTEpQRA=="), this.http_response);
            safeJSONObject2.put(StringFog.decrypt("UkZWVURRe0VOTkVKTw=="), this.server_domain);
            safeJSONObject2.put(StringFog.decrypt("U0ZVVkRQUH5AU00="), this.request_api);
            safeJSONObject2.put(StringFog.decrypt("U0ZVVkRQUH5IRw=="), this.request_id);
            safeJSONObject2.put(StringFog.decrypt("U0ZVVkRQUH5CT01GT1d7VUhOQQ=="), this.request_client_time);
            safeJSONObject2.put(StringFog.decrypt("R0JNT35OV0Y="), this.fail_msg);
            safeJSONObject.put(StringFog.decrypt("U0ZHTE9NQUJVd01ORA=="), this.reconnectTime);
            safeJSONObject.put(StringFog.decrypt("RFtQUUA="), safeJSONObject2);
            safeJSONObject.put(StringFog.decrypt("TUxHQk18QERXSkdGaEc="), Cognition.getDeviceID(this.mContext));
            Logger.d(safeJSONObject.toString());
            if (this.type.equals(StringFog.decrypt("QkxIT0RAUH5HQk1P")) || this.type.equals(StringFog.decrypt("U0ZVVkRQUH5HQk1P"))) {
                Executors.newSingleThreadExecutor().submit(new HttpTaskLog(this.mContext, safeJSONObject.toString()));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return safeJSONObject.toString();
    }

    public String getAction() {
        return this.action;
    }

    public String getCollect_fail_msg() {
        return this.collect_fail_msg;
    }

    public String getCollect_fail_type() {
        return this.collect_fail_type;
    }

    public String getCollect_status() {
        return this.collect_status;
    }

    public String getFail_msg() {
        return this.fail_msg;
    }

    public String getHttp_code() {
        return this.http_code;
    }

    public String getHttp_request() {
        return this.http_request;
    }

    public String getHttp_response() {
        return this.http_response;
    }

    public String getHttp_status() {
        return this.http_status;
    }

    public final String getOSVersion() {
        return NativeLib.checkLoadSo() ? NativeLib.pg(StringFog.decrypt("U0wKQVRKSEUPVUFRUkpLTw9RQU9EQldE"), StringFog.decrypt("VE1PTU5USg==")) : StringFog.decrypt("VE1PTU5USg==");
    }

    public String getReconnectTime() {
        return this.reconnectTime;
    }

    public String getRequest_api() {
        return this.request_api;
    }

    public String getRequest_client_time() {
        return this.request_client_time;
    }

    public String getRequest_id() {
        return this.request_id;
    }

    public String getServer_domain() {
        return this.server_domain;
    }

    public String getType() {
        return this.type;
    }

    public final String getUserAgent() {
        String property = System.getProperty(StringFog.decrypt("SVdQUw9CQ0RPVw=="));
        try {
            try {
                return WebSettings.getDefaultUserAgent(this.mContext) + StringFog.decrypt("fnw=") + property;
            } catch (Exception unused) {
                return new WebView(this.mContext).getSettings().getUserAgentString() + StringFog.decrypt("fnw=") + property;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    @Nullable
    public final Integer getVersionCode() {
        try {
            return Integer.valueOf(this.packageManager.getPackageInfo(this.mContext.getPackageName(), 0).versionCode);
        } catch (Exception unused) {
            return null;
        }
    }

    @Nullable
    public final String getVersionName() {
        try {
            return this.packageManager.getPackageInfo(this.mContext.getPackageName(), 0).versionName;
        } catch (Exception unused) {
            return null;
        }
    }

    public void setAction(String str) {
        this.action = str;
    }

    public void setCollect_fail_msg(String str) {
        this.collect_fail_msg = str;
    }

    public void setCollect_fail_type(String str) {
        this.collect_fail_type = str;
    }

    public void setCollect_status(String str) {
        this.collect_status = str;
    }

    public void setFail_msg(String str) {
        this.fail_msg = str;
    }

    public void setHttp_code(String str) {
        this.http_code = str;
    }

    public void setHttp_request(String str) {
        this.http_request = str;
    }

    public void setHttp_response(String str) {
        this.http_response = str;
    }

    public void setHttp_status(String str) {
        this.http_status = str;
    }

    public void setReconnectTime(String str) {
        this.reconnectTime = str;
    }

    public void setRequest_api(String str) {
        this.request_api = str;
    }

    public void setRequest_client_time(String str) {
        this.request_client_time = str;
    }

    public void setRequest_id(String str) {
        this.request_id = str;
    }

    public void setServer_domain(String str) {
        this.server_domain = str;
    }

    public void setType(String str) {
        this.type = str;
    }
}
