package com.nirvana.tools.crash;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.ValueCallback;
import com.kuaishou.weapon.p0.d;
import com.nirvana.tools.core.BaseDelegate;
import com.uc.crashsdk.export.CrashApi;
import com.uc.crashsdk.export.ICrashClient;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class CrashUcSdk extends BaseDelegate {
    private static final int DEFAULT_INIT_TIME = 5000;
    private static final String LINE_SEP = "\n";
    private static final String LOG_TYPE = "CrashShield";
    private Context mContext;
    private Map<String, Object> mCustomInfo;
    private OnCrashCallbackProxy onCrashCallbackProxy;
    private SingleThreadExecutor singleThreadExecutor;
    private String mAppPackageName = null;
    private String mAppVersion = null;
    private SdkInfo mUploadCrashSdk = null;
    public int initDelayTime = -1;
    private StackAnalyzer mStackAnalyzer = new StackAnalyzer();
    private boolean isAppRegister = false;
    private String initTime = "";
    private boolean isInitFinished = false;
    private volatile boolean isFeatureEnable = true;
    private boolean isUcInitReadied = false;
    private List<SdkInfo> mPendingSdk = new ArrayList();
    private OnCrashCallback mInnerCrashCallback = new OnCrashCallback() { // from class: com.nirvana.tools.crash.CrashUcSdk.1
        @Override // com.nirvana.tools.crash.OnCrashCallback
        public void onCrashOccurred(String str, String str2, String str3, String str4, boolean z10, String str5) {
            if (CrashUcSdk.this.onCrashCallbackProxy != null) {
                CrashUcSdk.this.onCrashCallbackProxy.onCrashOccurred(str, str2, str3, str4, z10, str5);
            }
        }

        @Override // com.nirvana.tools.crash.OnCrashCallback
        public void onCrashUploadFailed(String str, String str2, String str3) {
            if (CrashUcSdk.this.onCrashCallbackProxy != null) {
                CrashUcSdk.this.onCrashCallbackProxy.onCrashUploadFailed(str, str2, str3);
            }
        }
    };

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class CrashCallback implements ICrashClient {
        private OnCrashCallback mCrashCallback;

        public CrashCallback(OnCrashCallback onCrashCallback) {
            this.mCrashCallback = onCrashCallback;
        }

        public void onAddCrashStats(String str, int i10, int i11) {
        }

        public File onBeforeUploadLog(File file) {
            if (file != null) {
                String absolutePath = file.getAbsolutePath();
                if (!absolutePath.endsWith(d.f36024b)) {
                    String str = absolutePath + d.f36024b;
                    if (FileUtils.gzipCompress(file, str)) {
                        File file2 = new File(str);
                        FileUtils.deleteFile(file);
                        return file2;
                    }
                }
            }
            return file;
        }

        public void onClientProcessLogGenerated(String str, File file, String str2) {
        }

        public void onCrashRestarting(boolean z10) {
        }

        public String onGetCallbackInfo(String str, boolean z10) {
            return null;
        }

        public void onLogGenerated(File file, String str) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkModifySymbolFile(String str, SdkInfo sdkInfo, String str2) {
        String name = FileUtils.getName(str);
        if (TextUtils.isEmpty(name)) {
            return;
        }
        String readStringFromFile = FileUtils.readStringFromFile(new File(str));
        Matcher matcher = Pattern.compile("(Application Information: 'version: )([a-zA-Z0-9.]*)(/)").matcher(readStringFromFile);
        if (matcher.find()) {
            readStringFromFile = readStringFromFile.replace(matcher.group(), "Application Information: 'version: " + sdkInfo.getSdkVersion() + "/");
        }
        String[] split = name.split("_");
        if (split == null || split.length < 2) {
            return;
        }
        String str3 = split[0];
        String str4 = split[1];
        if (readStringFromFile.contains(name)) {
            readStringFromFile = readStringFromFile.replace(name, name.replace(str3, sdkInfo.getAppId()).replace(str4, sdkInfo.getSdkVersion()));
        }
        if (!TextUtils.isEmpty(str2)) {
            readStringFromFile = new StringBuilder(readStringFromFile).insert(readStringFromFile.indexOf("Log Type:"), "wk_appVersion: " + this.mAppVersion + "\nwk_crashid: " + str2 + "\n").toString();
        }
        FileUtils.writeFile(str, readStringFromFile);
        if (name.contains(sdkInfo.getAppId()) && str4.equals(sdkInfo.getSdkVersion())) {
            return;
        }
        FileUtils.renameFile(str, str.replace(str3, sdkInfo.getAppId()).replace(str4, sdkInfo.getSdkVersion()));
    }

    private void doRegisterUc(Context context, SdkInfo sdkInfo) {
        if (this.isFeatureEnable) {
            this.mStackAnalyzer.initAddSdkConfig(sdkInfo);
            if (CrashApi.getInstance() == null) {
                initUcSdk(context, sdkInfo);
            } else {
                this.isAppRegister = true;
            }
            this.isInitFinished = true;
            CrashApi.getInstance().registerCallback(1, new ValueCallback<Bundle>() { // from class: com.nirvana.tools.crash.CrashUcSdk.3
                @Override // android.webkit.ValueCallback
                public void onReceiveValue(Bundle bundle) {
                    if (bundle == null) {
                        return;
                    }
                    String string = bundle.getString("filePathName");
                    String string2 = bundle.getString("logType");
                    if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2)) {
                        return;
                    }
                    File file = new File(string);
                    if (file.exists()) {
                        if ("exception".equals(string2)) {
                            if (CrashUcSdk.this.mUploadCrashSdk != null) {
                                CrashUcSdk crashUcSdk = CrashUcSdk.this;
                                crashUcSdk.checkModifySymbolFile(string, crashUcSdk.mUploadCrashSdk, null);
                                CrashUcSdk.this.mUploadCrashSdk = null;
                                return;
                            }
                            return;
                        }
                        if (CrashSdk.CRASH_TYPE_JAVA.equals(string2)) {
                            String readStringFromFile = FileUtils.readStringFromFile(file);
                            String javaStackTracingFromLog = UcLogProcessor.getJavaStackTracingFromLog(readStringFromFile);
                            SdkInfo checkJavaCrashInSdk = CrashUcSdk.this.mStackAnalyzer.checkJavaCrashInSdk(javaStackTracingFromLog);
                            if (TextUtils.isEmpty(javaStackTracingFromLog) || checkJavaCrashInSdk == null) {
                                if (CrashUcSdk.this.isAppRegister) {
                                    return;
                                }
                                FileUtils.deleteFile(file);
                                return;
                            } else {
                                if (CrashUcSdk.this.onCrashCallbackProxy != null) {
                                    String uuid = UUID.randomUUID().toString();
                                    CrashUcSdk.this.checkModifySymbolFile(string, checkJavaCrashInSdk, uuid);
                                    CrashUcSdk.this.onCrashCallbackProxy.onCrashOccurred(null, checkJavaCrashInSdk.getSdkName(), readStringFromFile, uuid, false, CrashSdk.CRASH_TYPE_JAVA);
                                    return;
                                }
                                return;
                            }
                        }
                        if (!CrashSdk.CRASH_TYPE_JNI.equals(string2)) {
                            if (CrashUcSdk.this.isAppRegister) {
                                return;
                            }
                            FileUtils.deleteFile(file);
                            return;
                        }
                        String readStringFromFile2 = FileUtils.readStringFromFile(file);
                        String nativeStackTracingFromLog = UcLogProcessor.getNativeStackTracingFromLog(readStringFromFile2);
                        SdkInfo checkNativeCrashInSdk = CrashUcSdk.this.mStackAnalyzer.checkNativeCrashInSdk(nativeStackTracingFromLog);
                        if (TextUtils.isEmpty(nativeStackTracingFromLog) || checkNativeCrashInSdk == null) {
                            if (CrashUcSdk.this.isAppRegister) {
                                return;
                            }
                            FileUtils.deleteFile(file);
                        } else if (CrashUcSdk.this.onCrashCallbackProxy != null) {
                            String uuid2 = UUID.randomUUID().toString();
                            CrashUcSdk.this.checkModifySymbolFile(string, checkNativeCrashInSdk, uuid2);
                            CrashUcSdk.this.onCrashCallbackProxy.onCrashOccurred(null, checkNativeCrashInSdk.getSdkName(), readStringFromFile2, uuid2, false, CrashSdk.CRASH_TYPE_JNI);
                        }
                    }
                }
            });
        }
    }

    private void initUcSdk(Context context, SdkInfo sdkInfo) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("mDebug", true);
        bundle.putBoolean("mZipLog", false);
        bundle.putBoolean("mEncryptLog", false);
        bundle.putBoolean("mSyncUploadLogs", true);
        bundle.putBoolean("mCallJavaDefaultHandler", true);
        bundle.putBoolean("mCallNativeDefaultHandler", true);
        bundle.putBoolean("mAddLogcat", true);
        bundle.putBoolean("mAddThreadsDump", true);
        bundle.putInt("mMaxUploadCustomLogCountPerDay", 10000);
        bundle.putInt("mMaxCustomLogCountPerTypePerDay", 10000);
        CrashApi.createInstanceEx(context, sdkInfo.getAppId(), true, bundle, new CrashCallback(this.mInnerCrashCallback));
        CrashApi.getInstance().updateCustomInfo(bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void lazyRegisterUc() {
        this.isUcInitReadied = true;
        Iterator<SdkInfo> iterator2 = this.mPendingSdk.iterator2();
        while (iterator2.hasNext()) {
            doRegisterUc(this.mContext, iterator2.next());
        }
    }

    public void generateCustomLogUploadItrace(final SdkInfo sdkInfo, final Thread thread, final Throwable th, final Map<String, String> map) {
        final String format = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        final String str = sdkInfo.getAppId() + "_" + sdkInfo.getSdkVersion() + "__" + Build.MODEL + "_" + Build.VERSION.RELEASE + "__" + format + "_fg_java.log";
        if (this.singleThreadExecutor == null) {
            this.singleThreadExecutor = new SingleThreadExecutor("crashUpload");
        }
        final String str2 = (map == null || map.isEmpty()) ? "" : map.get("wk_crashid");
        this.singleThreadExecutor.execute(new Runnable() { // from class: com.nirvana.tools.crash.CrashUcSdk.5
            @Override // java.lang.Runnable
            public void run() {
                String writeSelfJavaLog = FileUtils.writeSelfJavaLog(CrashUcSdk.this.mContext, sdkInfo, thread, th, format, CrashUcSdk.this.initTime, str, map);
                String str3 = writeSelfJavaLog + d.f36024b;
                if (FileUtils.gzipCompress(new File(writeSelfJavaLog), str3)) {
                    FileUtils.deleteFile(new File(writeSelfJavaLog));
                }
                HashMap hashMap = new HashMap();
                hashMap.put(str, new File(str3));
                try {
                    if (CrashUploadUtils.post(BuildConfig.UC_SERVER_UPLOAD_URL, new HashMap(), hashMap) || CrashUcSdk.this.onCrashCallbackProxy == null) {
                        return;
                    }
                    CrashUcSdk.this.onCrashCallbackProxy.onCrashUploadFailed(sdkInfo.getSdkName(), Log.getStackTraceString(th), str2);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    if (CrashUcSdk.this.onCrashCallbackProxy != null) {
                        CrashUcSdk.this.onCrashCallbackProxy.onCrashUploadFailed(sdkInfo.getSdkName(), Log.getStackTraceString(th), str2);
                    }
                }
            }
        });
    }

    @Override // com.nirvana.tools.core.BaseDelegate
    public String getSubClassName() {
        return "com.uc.crashsdk.export.CrashApi";
    }

    public void init(Context context) {
        this.initTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        this.mAppPackageName = context.getPackageName();
        this.mAppVersion = CrashUploadUtils.getVersion(context);
        this.mContext = context;
        if (this.initDelayTime < 0) {
            this.initDelayTime = 5000;
        }
        if (BaseDelegate.sComponentClassExist.booleanValue()) {
            int i10 = this.initDelayTime;
            if (i10 > 0) {
                new Timer().schedule(new TimerTask() { // from class: com.nirvana.tools.crash.CrashUcSdk.2
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        CrashUcSdk.this.lazyRegisterUc();
                    }
                }, this.initDelayTime);
            } else if (i10 == 0) {
                lazyRegisterUc();
            }
        }
    }

    public void initAddSdkConfig(SdkInfo sdkInfo) {
        this.mStackAnalyzer.initAddSdkConfig(sdkInfo);
    }

    public boolean isUcUsable() {
        return BaseDelegate.sComponentClassExist.booleanValue() && this.isInitFinished && this.isFeatureEnable;
    }

    public synchronized void registerUc(SdkInfo sdkInfo) {
        if (this.isUcInitReadied) {
            doRegisterUc(this.mContext, sdkInfo);
        } else {
            this.mPendingSdk.add(sdkInfo);
        }
    }

    public void setCrashCallback(OnCrashCallbackProxy onCrashCallbackProxy) {
        this.onCrashCallbackProxy = onCrashCallbackProxy;
    }

    public void setFeatureEnable(boolean z10) {
        this.isFeatureEnable = z10;
    }

    public void setUcCrashDelayTime(int i10) {
        this.initDelayTime = i10;
    }

    public void updateConfig(Map<String, Object> map) {
        Map<String, Object> map2;
        this.mCustomInfo = map;
        if (!isUcUsable() || (map2 = this.mCustomInfo) == null) {
            return;
        }
        for (Map.Entry<String, Object> entry : map2.entrySet()) {
            if (entry.getKey() != null && entry.getValue() != null) {
                CrashApi.getInstance().addHeaderInfo(entry.getKey(), entry.getValue().toString());
            }
        }
    }

    public boolean uploadException(SdkInfo sdkInfo, final Thread thread, final Throwable th, final Map<String, String> map) {
        if (!isUcUsable()) {
            generateCustomLogUploadItrace(sdkInfo, thread, th, map);
            return true;
        }
        this.mUploadCrashSdk = sdkInfo;
        if (this.singleThreadExecutor == null) {
            this.singleThreadExecutor = new SingleThreadExecutor("crashUpload");
        }
        this.singleThreadExecutor.execute(new Runnable() { // from class: com.nirvana.tools.crash.CrashUcSdk.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    CustomLogInfoBuilder stack = new CustomLogInfoBuilder(CrashUcSdk.LOG_TYPE).uploadNow(true).put("processName", CrashUcSdk.this.mAppPackageName).put("threadName", thread.getName()).put("wk_appVersion", CrashUcSdk.this.mAppVersion).stack(th);
                    Map map2 = map;
                    if (map2 != null && map2.size() > 0) {
                        for (Map.Entry entry : map.entrySet()) {
                            stack.put((String) entry.getKey(), (String) entry.getValue());
                        }
                    }
                    CrashApi.getInstance().generateCustomLog(stack.build());
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });
        return true;
    }
}
