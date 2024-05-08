package com.danlan.android.cognition;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.danlan.android.cognition.collector.TotalInfoCollector;
import com.danlan.android.cognition.collector.base.BaseDeviceInfoCollector;
import com.danlan.android.cognition.collector.listener.CollectorStateObserver;
import com.danlan.android.cognition.collector.listener.DeviceIdCreateListener;
import com.danlan.android.cognition.collector.listener.DeviceInfoCollectListener;
import com.danlan.android.cognition.collector.listener.DeviceInfoDependency;
import com.danlan.android.cognition.collector.listener.ExtraInfoFroAction;
import com.danlan.android.cognition.collector.receiver.NetBroadcastReceiver;
import com.danlan.android.cognition.collector.util.SafeJSONObject;
import com.danlan.android.cognition.common.AppUtil;
import com.danlan.android.cognition.debuglog.DebugLogCollector;
import com.danlan.android.cognition.network.HttpUtil;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class Cognition implements CollectorStateObserver {
    private static volatile Cognition mInstance;
    private DebugLogCollector debugLogCollector;
    private DeviceIdCreateListener deviceIdCreateListener;
    private boolean isExistDeviceId = true;
    private Context mContext;
    private DeviceInfoDependency mDependency;
    private NetBroadcastReceiver netBroadcastReceiver;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class HttpTask implements Callable<String> {
        private final String api;
        private final Context cxt;
        private final DebugLogCollector debugLogCollector;
        private final String domain;
        private final Map<String, String> headers;
        private int reconnectTime = 5;
        private final JSONObject requestData;
        private final String userAgent;

        public HttpTask(Context context, String str, String str2, JSONObject jSONObject, String str3, Map<String, String> map, DebugLogCollector debugLogCollector) {
            this.requestData = jSONObject;
            this.domain = str;
            this.api = str2;
            this.cxt = context;
            this.userAgent = str3;
            this.headers = map;
            this.debugLogCollector = debugLogCollector;
        }

        @Override // java.util.concurrent.Callable
        public String call() {
            String sendPost;
            try {
                if (this.debugLogCollector != null && DebugLogCollector.isIsDebugLogEnable()) {
                    this.debugLogCollector.setServer_domain(this.domain);
                    this.debugLogCollector.setRequest_api(this.api);
                    this.debugLogCollector.setHttp_request(this.requestData.toString());
                    this.debugLogCollector.setRequest_client_time(String.valueOf(System.currentTimeMillis()));
                }
                sendPost = HttpUtil.sendPost(this.cxt, this.domain, this.api, this.requestData, this.userAgent, this.headers, this.debugLogCollector);
            } catch (Exception e2) {
                Logger.e(e2.getMessage());
                if (this.debugLogCollector != null && DebugLogCollector.isIsDebugLogEnable()) {
                    this.debugLogCollector.setType(StringFog.decrypt("U0ZVVkRQUH5HQk1P"));
                    this.debugLogCollector.setFail_msg(this.debugLogCollector.getFail_msg() + StringFog.decrypt("DEtQV1F3RVJKGQ==") + e2.getMessage());
                }
                if (this.reconnectTime > 0 && Cognition.getDeviceID(this.cxt).equals("")) {
                    this.reconnectTime--;
                    try {
                        try {
                            TimeUnit.MILLISECONDS.sleep(500L);
                        } catch (Throwable th) {
                            call();
                            throw th;
                        }
                    } catch (Exception unused) {
                        e2.printStackTrace();
                        call();
                        if (this.debugLogCollector != null && DebugLogCollector.isIsDebugLogEnable()) {
                            this.debugLogCollector.setReconnectTime(String.valueOf(5 - this.reconnectTime));
                        }
                        return Cognition.getDeviceID(this.cxt);
                    }
                    call();
                    if (this.debugLogCollector != null) {
                        this.debugLogCollector.setReconnectTime(String.valueOf(5 - this.reconnectTime));
                    }
                }
            }
            if (sendPost == null) {
                throw new IOException(StringFog.decrypt("b0wEUURQUU1VA1ZGVVZWT0RHCg=="));
            }
            JSONObject jSONObject = new JSONObject(sendPost);
            try {
                Logger.d(StringFog.decrypt("YkxDTUhXTU5PcGBoelFBUlFMSlBEfg==") + jSONObject.toString(4));
                String string = jSONObject.getString(StringFog.decrypt("QkxARg=="));
                String string2 = jSONObject.getString(StringFog.decrypt("U0ZVVkRQUH5IRw=="));
                if (this.debugLogCollector != null && DebugLogCollector.isIsDebugLogEnable()) {
                    this.debugLogCollector.setHttp_status(string);
                    this.debugLogCollector.setRequest_id(string2);
                }
                if (!string.equals(StringFog.decrypt("ExMU"))) {
                    throw new RuntimeException(StringFog.decrypt("U0ZXU05NV0QBQEtHRANNUgFNS1cBERQRDUBLR0QDTVIB") + string);
                }
                if (this.debugLogCollector != null && DebugLogCollector.isIsDebugLogEnable()) {
                    this.debugLogCollector.setType(StringFog.decrypt("UlZHQERQVw=="));
                }
                JSONArray jSONArray = jSONObject.getJSONArray(StringFog.decrypt("RUJQQg=="));
                if (jSONArray.length() != 0) {
                    String decrypt = Cryptor.decrypt(jSONArray.getJSONObject(0).getString(StringFog.decrypt("fg==")));
                    if (!TextUtils.isEmpty(decrypt)) {
                        JSONObject jSONObject2 = new JSONObject(decrypt);
                        Logger.d(StringFog.decrypt("RUJQQn5HQUJ+SVdMTxk=") + ((Object) jSONObject2));
                        int i10 = jSONObject2.getInt(StringFog.decrypt("QktBQEo="));
                        String string3 = jSONObject2.getString(StringFog.decrypt("RUZSSkJGe0hF"));
                        Logger.d(StringFog.decrypt("elFBUFFMSlJEfgRHRFVNQkR8TUcb") + string3);
                        if (TextUtils.isEmpty(string3)) {
                            throw new RuntimeException(StringFog.decrypt("U0ZXU05NV0QBUFFAAUFRVQFHQVVIQEF+SEcESlIDQUxRV10="));
                        }
                        if (i10 != 0) {
                            return Cognition.getDeviceID(this.cxt);
                        }
                        CacheDataManager.syncDeviceId(this.cxt, string3);
                        return string3;
                    }
                }
                return Cognition.getDeviceID(this.cxt);
            } catch (Exception e10) {
                e10.printStackTrace();
                throw new RuntimeException(e10.getMessage());
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class InnerCollectListener {
        private boolean hasDeviceInfoCollectListener;
        private DeviceInfoCollectListener mDeviceInfoCollectListener;

        public InnerCollectListener() {
        }
    }

    private Cognition(@NonNull Context context, DeviceInfoDependency deviceInfoDependency, DeviceIdCreateListener deviceIdCreateListener) {
        this.mDependency = deviceInfoDependency;
        this.mContext = context;
        this.deviceIdCreateListener = deviceIdCreateListener;
        String packageName = context.getPackageName();
        String currentProcessName = AppUtil.getCurrentProcessName();
        if (TextUtils.isEmpty(currentProcessName) || !currentProcessName.contains(packageName) || currentProcessName.equals(packageName)) {
            NativeLib.loadSo();
            uploadForAction(0, null);
        }
    }

    private Cognition addCollector(BaseDeviceInfoCollector baseDeviceInfoCollector) {
        baseDeviceInfoCollector.bindObserver(this);
        return this;
    }

    private Cognition bindListener(InnerCollectListener innerCollectListener, DeviceInfoCollectListener deviceInfoCollectListener) {
        innerCollectListener.mDeviceInfoCollectListener = deviceInfoCollectListener;
        innerCollectListener.hasDeviceInfoCollectListener = true;
        return this;
    }

    private void checkAllDone(InnerCollectListener innerCollectListener) {
        if (innerCollectListener.hasDeviceInfoCollectListener) {
            innerCollectListener.mDeviceInfoCollectListener.onAllDone(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doCollectDebugLogsError(DebugLogCollector debugLogCollector, int i10, String str) {
        if (debugLogCollector == null || !DebugLogCollector.isIsDebugLogEnable()) {
            return;
        }
        debugLogCollector.setCollect_status(StringFog.decrypt("R0JNTw=="));
        debugLogCollector.setCollect_fail_msg(str);
        debugLogCollector.setType(StringFog.decrypt("QkxIT0RAUH5HQk1P"));
        String doCollectInfo = debugLogCollector.doCollectInfo();
        DeviceIdCreateListener deviceIdCreateListener = this.deviceIdCreateListener;
        if (deviceIdCreateListener != null) {
            deviceIdCreateListener.onInitializeDeviceId(-1, i10, getDeviceID(this.mContext), doCollectInfo);
        }
    }

    private synchronized void doSingleCollectorStopRunning(InnerCollectListener innerCollectListener) {
        checkAllDone(innerCollectListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doUpload(TotalInfoCollector totalInfoCollector, int i10, DebugLogCollector debugLogCollector) {
        int i11;
        Future submit = Executors.newSingleThreadExecutor().submit(makeUploadRequest(this.mContext, getDeviceData(totalInfoCollector), this.mDependency, debugLogCollector));
        try {
            if (this.deviceIdCreateListener != null) {
                String str = (String) submit.get();
                String str2 = "";
                if (str == null || str.equals("")) {
                    i11 = -1;
                    this.isExistDeviceId = false;
                } else {
                    i11 = 200;
                    this.isExistDeviceId = true;
                }
                if (debugLogCollector != null && DebugLogCollector.isIsDebugLogEnable()) {
                    debugLogCollector.setAction(String.valueOf(i10));
                    str2 = debugLogCollector.doCollectInfo();
                }
                this.deviceIdCreateListener.onInitializeDeviceId(i11, i10, (String) submit.get(), str2);
            }
        } catch (InterruptedException | ExecutionException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static DeviceInfoDependency getDependency() {
        if (mInstance != null) {
            return mInstance.mDependency;
        }
        return null;
    }

    private SafeJSONObject getDeviceData(TotalInfoCollector totalInfoCollector) {
        return totalInfoCollector.getDeviceData();
    }

    public static String getDeviceID(Context context) {
        return CacheDataManager.getDeviceId(context);
    }

    private HashMap<String, String> getDeviceJsonInfo(TotalInfoCollector totalInfoCollector) {
        HashMap<String, String> hashMap = new HashMap<>();
        String jsonInfo = totalInfoCollector.getJsonInfo();
        hashMap.put(StringFog.decrypt("RUZSSkJGbU9HTA=="), jsonInfo);
        Logger.d(jsonInfo);
        return hashMap;
    }

    public static Cognition getInstance(Context context) {
        if (mInstance == null) {
            synchronized (Cognition.class) {
                if (mInstance == null) {
                    mInstance = new Cognition(context, null, null);
                }
            }
        }
        return mInstance;
    }

    public static String getSdkVersion() {
        return StringFog.decrypt("EQ0WDRMSChA=");
    }

    public static void init(@NonNull Context context, DeviceInfoDependency deviceInfoDependency) {
        if (mInstance == null) {
            synchronized (Cognition.class) {
                if (mInstance == null) {
                    mInstance = new Cognition(context, deviceInfoDependency, null);
                }
            }
        }
    }

    public static void init(@NonNull Context context, DeviceInfoDependency deviceInfoDependency, DeviceIdCreateListener deviceIdCreateListener) {
        if (mInstance == null) {
            synchronized (Cognition.class) {
                if (mInstance == null) {
                    mInstance = new Cognition(context, deviceInfoDependency, deviceIdCreateListener);
                }
            }
        }
    }

    private static HttpTask makeUploadRequest(Context context, SafeJSONObject safeJSONObject, DeviceInfoDependency deviceInfoDependency, DebugLogCollector debugLogCollector) {
        SafeJSONObject safeJSONObject2 = new SafeJSONObject();
        String str = deviceInfoDependency.setServerDomain().get(StringFog.decrypt("UkZWVURRe0VOTkVKTw=="));
        if (!CacheDataManager.hasCacheData(context)) {
            CacheDataManager.putCacheData(context, safeJSONObject);
        }
        String packageName = context.getPackageName();
        safeJSONObject2.put(StringFog.decrypt("RUJQQg=="), safeJSONObject);
        safeJSONObject2.put(StringFog.decrypt("UkdPfFdGVlJITEo="), getSdkVersion());
        safeJSONObject2.put(StringFog.decrypt("UUJHSEBEQX5PQklG"), packageName);
        safeJSONObject2.put(StringFog.decrypt("QFNUfFdGVlJITEp8T0JJRA=="), AppUtil.getVersionName(context));
        safeJSONObject2.put(StringFog.decrypt("QFNUfFdGVlJITEp8QkxARA=="), AppUtil.getVersionCode(context));
        safeJSONObject2.put(StringFog.decrypt("QFNUfE9CSUQ="), deviceInfoDependency.setUserData().get(StringFog.decrypt("QFNUbUBOQQ==")));
        safeJSONObject2.put(StringFog.decrypt("QktFTU9GSA=="), deviceInfoDependency.setUserData().get(StringFog.decrypt("QktFTU9GSA==")));
        safeJSONObject2.put(StringFog.decrypt("UU9FV0dMVkw="), StringFog.decrypt("QE1AUU5KQA=="));
        if (!CacheDataManager.checkCacheData(context, safeJSONObject)) {
            Logger.d(StringFog.decrypt("ekBMRkJIZ0BCS0FnQFdFfAHGmbDEqqnIpqTNuKfEvqXErKbFtJPAma/EmLDEjrzFmY7DuaXHnKzFm6TLppfLna3EsrLFn5jJj53Bh6bGq7nHuJA="));
            safeJSONObject2.put(StringFog.decrypt("RUZSSkJGe0hF"), "");
        }
        safeJSONObject2.put(StringFog.decrypt("RUZSSkJGe0hF"), CacheDataManager.getDeviceId(context));
        safeJSONObject2.put(StringFog.decrypt("RFVBTVV8UEhMRg=="), System.currentTimeMillis());
        String str2 = null;
        try {
            Logger.t(StringFog.decrypt("ek5FSER2VE1OQkBxRFJRRFJXeQNUU0hOQEcER0BXRce5rcK1pg4JHxs=") + safeJSONObject2.toString(4));
            str2 = Cryptor.encrypt(safeJSONObject2.toString());
            Logger.t(StringFog.decrypt("ek5FSER2VE1OQkBxRFJRRFJXeQNUU0hOQEcER0BXRcSOpcK1pg4JHxs=") + str2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        SafeJSONObject safeJSONObject3 = new SafeJSONObject();
        safeJSONObject3.put(StringFog.decrypt("fg=="), str2);
        return new HttpTask(context, str, deviceInfoDependency.setApi().get(StringFog.decrypt("RUJQQn5WVE1OQkA=")), safeJSONObject3, deviceInfoDependency.setSpecialUserAgent(), deviceInfoDependency.setHeaderData(), debugLogCollector);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x007e, code lost:
    
        if (r1.length() < 5) goto L22;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x009f A[LOOP:0: B:25:0x0099->B:27:0x009f, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void setCollectParam(com.danlan.android.cognition.collector.TotalInfoCollector r4, com.danlan.android.cognition.collector.listener.DeviceInfoDependency r5, int r6, com.danlan.android.cognition.collector.listener.ExtraInfoFroAction r7) {
        /*
            r3 = this;
            java.lang.String r0 = "UkxoTEBHQUU="
            if (r5 == 0) goto Lbd
            java.util.Map r5 = r5.setUserData()
            java.lang.String r1 = "QEBQSk5N"
            java.lang.String r1 = com.danlan.android.cognition.StringFog.decrypt(r1)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r5.put(r1, r6)
            java.lang.String r6 = "TkJtRw=="
            java.lang.String r1 = com.danlan.android.cognition.StringFog.decrypt(r6)
            boolean r1 = r5.containsKey(r1)
            if (r1 == 0) goto L80
            java.lang.String r1 = com.danlan.android.cognition.StringFog.decrypt(r6)
            java.lang.Object r1 = r5.get(r1)
            java.lang.String r1 = (java.lang.String) r1
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L89
            java.lang.String r2 = "b2I="
            java.lang.String r2 = com.danlan.android.cognition.StringFog.decrypt(r2)
            boolean r2 = r1.equalsIgnoreCase(r2)
            if (r2 != 0) goto L80
            java.lang.String r2 = "allX"
            java.lang.String r2 = com.danlan.android.cognition.StringFog.decrypt(r2)
            boolean r2 = r1.equalsIgnoreCase(r2)
            if (r2 != 0) goto L80
            java.lang.String r2 = "ERMUExETFBERExQTERMUERETFBMRExQRERMUExETFBE="
            java.lang.String r2 = com.danlan.android.cognition.StringFog.decrypt(r2)
            boolean r2 = r1.equalsIgnoreCase(r2)
            if (r2 != 0) goto L80
            java.lang.String r2 = "ERMUExETFBEMExQTEQ4UERETCRMRExQMERMUExETFBERExQT"
            java.lang.String r2 = com.danlan.android.cognition.StringFog.decrypt(r2)
            boolean r2 = r1.equalsIgnoreCase(r2)
            if (r2 != 0) goto L80
            java.lang.String r2 = "T1ZITw=="
            java.lang.String r2 = com.danlan.android.cognition.StringFog.decrypt(r2)
            boolean r2 = r1.equalsIgnoreCase(r2)
            if (r2 != 0) goto L80
            java.lang.String r2 = "alB+"
            java.lang.String r2 = com.danlan.android.cognition.StringFog.decrypt(r2)
            boolean r2 = r1.equalsIgnoreCase(r2)
            if (r2 != 0) goto L80
            int r1 = r1.length()
            r2 = 5
            if (r1 >= r2) goto L89
        L80:
            java.lang.String r6 = com.danlan.android.cognition.StringFog.decrypt(r6)
            java.lang.String r1 = ""
            r5.put(r6, r1)
        L89:
            if (r7 == 0) goto Lad
            java.util.HashMap r6 = r7.setExtraInfo()
            if (r6 == 0) goto Lad
            java.util.Set r7 = r6.h()
            java.util.Iterator r7 = r7.iterator2()
        L99:
            boolean r1 = r7.hasNext()
            if (r1 == 0) goto Lad
            java.lang.Object r1 = r7.next()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r2 = r6.get(r1)
            r5.put(r1, r2)
            goto L99
        Lad:
            java.lang.String r6 = com.danlan.android.cognition.StringFog.decrypt(r0)
            boolean r7 = com.danlan.android.cognition.NativeLib.getSoLoadStatus()
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)
            r5.put(r6, r7)
            goto Ld1
        Lbd:
            java.util.HashMap r5 = new java.util.HashMap
            r5.<init>()
            java.lang.String r6 = com.danlan.android.cognition.StringFog.decrypt(r0)
            boolean r7 = com.danlan.android.cognition.NativeLib.getSoLoadStatus()
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)
            r5.put(r6, r7)
        Ld1:
            r4.setMapData(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.danlan.android.cognition.Cognition.setCollectParam(com.danlan.android.cognition.collector.TotalInfoCollector, com.danlan.android.cognition.collector.listener.DeviceInfoDependency, int, com.danlan.android.cognition.collector.listener.ExtraInfoFroAction):void");
    }

    public static void setDebugLogEnable(boolean z10) {
        DebugLogCollector.setIsDebugLogEnable(z10);
    }

    public static void setLogEnable(boolean z10) {
        Logger.setLogEnable(z10);
    }

    private void startCollect(TotalInfoCollector totalInfoCollector, InnerCollectListener innerCollectListener) {
        try {
            if (innerCollectListener.hasDeviceInfoCollectListener) {
                innerCollectListener.mDeviceInfoCollectListener.onStart();
            }
            totalInfoCollector.startCollectAutomatically(innerCollectListener);
        } catch (Exception e2) {
            Logger.e(e2.getMessage());
        }
    }

    @Override // com.danlan.android.cognition.collector.listener.CollectorStateObserver
    public void onCollectionFailure(InnerCollectListener innerCollectListener, BaseDeviceInfoCollector baseDeviceInfoCollector, String str) {
        if (innerCollectListener.hasDeviceInfoCollectListener) {
            innerCollectListener.mDeviceInfoCollectListener.onSingleFailure(baseDeviceInfoCollector, str);
        }
        doSingleCollectorStopRunning(innerCollectListener);
    }

    @Override // com.danlan.android.cognition.collector.listener.CollectorStateObserver
    public void onCollectionSuccess(InnerCollectListener innerCollectListener, BaseDeviceInfoCollector baseDeviceInfoCollector) {
        if (innerCollectListener.hasDeviceInfoCollectListener) {
            innerCollectListener.mDeviceInfoCollectListener.onSingleSuccess(baseDeviceInfoCollector);
        }
        doSingleCollectorStopRunning(innerCollectListener);
    }

    public void uploadForAction(final int i10, ExtraInfoFroAction extraInfoFroAction) {
        if (DebugLogCollector.isIsDebugLogEnable()) {
            DebugLogCollector debugLogCollector = new DebugLogCollector(this.mContext);
            this.debugLogCollector = debugLogCollector;
            debugLogCollector.setAction(String.valueOf(i10));
        }
        try {
            InnerCollectListener innerCollectListener = new InnerCollectListener();
            final TotalInfoCollector totalInfoCollector = new TotalInfoCollector(this.mContext, StringFog.decrypt("VUxQQk1qSkdO"));
            DeviceInfoDependency deviceInfoDependency = this.mDependency;
            if (deviceInfoDependency == null) {
                Logger.e(StringFog.decrypt("RUZURk9HQU9CWgRKUgNKVE1P"));
                doCollectDebugLogsError(this.debugLogCollector, i10, StringFog.decrypt("RUZURk9HQU9CWgRKUgNKVE1P"));
            } else {
                setCollectParam(totalInfoCollector, deviceInfoDependency, i10, extraInfoFroAction);
                addCollector(totalInfoCollector).bindListener(innerCollectListener, new DeviceInfoCollectListener() { // from class: com.danlan.android.cognition.Cognition.1
                    @Override // com.danlan.android.cognition.collector.listener.DeviceInfoCollectListener
                    public void onAllDone(Cognition cognition) {
                        Logger.d(StringFog.decrypt("endLV0BPbU9HTGdMTU9BQlVMVn4ByqOmyLiixo+vwqmxGQ=="));
                        if (Cognition.this.debugLogCollector != null && DebugLogCollector.isIsDebugLogEnable()) {
                            Cognition.this.debugLogCollector.setCollect_status(StringFog.decrypt("UlZH"));
                        }
                        Cognition cognition2 = Cognition.this;
                        cognition2.doUpload(totalInfoCollector, i10, cognition2.debugLogCollector);
                    }

                    @Override // com.danlan.android.cognition.collector.listener.DeviceInfoCollectListener
                    public void onSingleFailure(BaseDeviceInfoCollector baseDeviceInfoCollector, String str) {
                        Logger.d(StringFog.decrypt("endLV0BPbU9HTGdMTU9BQlVMVn4BTEpySE1DT0RlRUhNVlZG"));
                        Cognition cognition = Cognition.this;
                        cognition.doCollectDebugLogsError(cognition.debugLogCollector, i10, str);
                    }

                    @Override // com.danlan.android.cognition.collector.listener.DeviceInfoCollectListener
                    public void onSingleSuccess(BaseDeviceInfoCollector baseDeviceInfoCollector) {
                        Logger.d(StringFog.decrypt("endLV0BPbU9HTGdMTU9BQlVMVn4BTEpySE1DT0RwUUJCRldQGw=="));
                    }

                    @Override // com.danlan.android.cognition.collector.listener.DeviceInfoCollectListener
                    public void onStart() {
                        Logger.d(StringFog.decrypt("endLV0BPbU9HTGdMTU9BQlVMVn4BxpihxISvyqakzbqnGQ=="));
                        if (Cognition.this.debugLogCollector == null || !DebugLogCollector.isIsDebugLogEnable()) {
                            return;
                        }
                        Cognition.this.debugLogCollector.setCollect_status(StringFog.decrypt("UldFUVU="));
                    }
                });
                startCollect(totalInfoCollector, innerCollectListener);
            }
        } catch (Exception e2) {
            Logger.e(e2.getMessage());
            doCollectDebugLogsError(this.debugLogCollector, i10, e2.getMessage());
        }
    }
}
