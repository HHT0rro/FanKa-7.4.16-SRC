package com.tencent.bugly;

import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class BuglyStrategy {

    /* renamed from: c, reason: collision with root package name */
    private String f39004c;

    /* renamed from: d, reason: collision with root package name */
    private String f39005d;

    /* renamed from: e, reason: collision with root package name */
    private String f39006e;

    /* renamed from: f, reason: collision with root package name */
    private long f39007f;

    /* renamed from: g, reason: collision with root package name */
    private String f39008g;

    /* renamed from: h, reason: collision with root package name */
    private String f39009h;

    /* renamed from: i, reason: collision with root package name */
    private String f39010i;

    /* renamed from: t, reason: collision with root package name */
    private a f39021t;

    /* renamed from: j, reason: collision with root package name */
    private boolean f39011j = true;

    /* renamed from: k, reason: collision with root package name */
    private boolean f39012k = true;

    /* renamed from: l, reason: collision with root package name */
    private boolean f39013l = false;

    /* renamed from: m, reason: collision with root package name */
    private boolean f39014m = true;

    /* renamed from: n, reason: collision with root package name */
    private Class<?> f39015n = null;

    /* renamed from: o, reason: collision with root package name */
    private boolean f39016o = true;

    /* renamed from: p, reason: collision with root package name */
    private boolean f39017p = true;

    /* renamed from: q, reason: collision with root package name */
    private boolean f39018q = true;

    /* renamed from: r, reason: collision with root package name */
    private boolean f39019r = true;

    /* renamed from: s, reason: collision with root package name */
    private boolean f39020s = false;

    /* renamed from: a, reason: collision with root package name */
    public int f39002a = 31;

    /* renamed from: b, reason: collision with root package name */
    public boolean f39003b = false;

    /* renamed from: u, reason: collision with root package name */
    private boolean f39022u = true;

    /* compiled from: BUGLY */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a {
        public static final int CRASHTYPE_ANR = 4;
        public static final int CRASHTYPE_BLOCK = 7;
        public static final int CRASHTYPE_COCOS2DX_JS = 5;
        public static final int CRASHTYPE_COCOS2DX_LUA = 6;
        public static final int CRASHTYPE_JAVA_CATCH = 1;
        public static final int CRASHTYPE_JAVA_CRASH = 0;
        public static final int CRASHTYPE_NATIVE = 2;
        public static final int CRASHTYPE_U3D = 3;
        public static final int MAX_USERDATA_KEY_LENGTH = 100;
        public static final int MAX_USERDATA_VALUE_LENGTH = 100000;

        public synchronized Map<String, String> onCrashHandleStart(int i10, String str, String str2, String str3) {
            return null;
        }

        public synchronized byte[] onCrashHandleStart2GetExtraDatas(int i10, String str, String str2, String str3) {
            return null;
        }
    }

    public synchronized String getAppChannel() {
        String str = this.f39005d;
        if (str != null) {
            return str;
        }
        return com.tencent.bugly.crashreport.common.info.a.b().f39104l;
    }

    public synchronized String getAppPackageName() {
        String str = this.f39006e;
        if (str != null) {
            return str;
        }
        return com.tencent.bugly.crashreport.common.info.a.b().f39095c;
    }

    public synchronized long getAppReportDelay() {
        return this.f39007f;
    }

    public synchronized String getAppVersion() {
        String str = this.f39004c;
        if (str != null) {
            return str;
        }
        return com.tencent.bugly.crashreport.common.info.a.b().f39102j;
    }

    public synchronized int getCallBackType() {
        return this.f39002a;
    }

    public synchronized boolean getCloseErrorCallback() {
        return this.f39003b;
    }

    public synchronized a getCrashHandleCallback() {
        return this.f39021t;
    }

    public synchronized String getDeviceID() {
        return this.f39009h;
    }

    public synchronized String getDeviceModel() {
        return this.f39010i;
    }

    public synchronized String getLibBuglySOFilePath() {
        return this.f39008g;
    }

    public synchronized Class<?> getUserInfoActivity() {
        return this.f39015n;
    }

    public synchronized boolean isBuglyLogUpload() {
        return this.f39016o;
    }

    public synchronized boolean isEnableANRCrashMonitor() {
        return this.f39012k;
    }

    public synchronized boolean isEnableCatchAnrTrace() {
        return this.f39013l;
    }

    public synchronized boolean isEnableNativeCrashMonitor() {
        return this.f39011j;
    }

    public synchronized boolean isEnableUserInfo() {
        return this.f39014m;
    }

    public boolean isMerged() {
        return this.f39022u;
    }

    public boolean isReplaceOldChannel() {
        return this.f39017p;
    }

    public synchronized boolean isUploadProcess() {
        return this.f39018q;
    }

    public synchronized boolean isUploadSpotCrash() {
        return this.f39019r;
    }

    public synchronized boolean recordUserInfoOnceADay() {
        return this.f39020s;
    }

    public synchronized BuglyStrategy setAppChannel(String str) {
        this.f39005d = str;
        return this;
    }

    public synchronized BuglyStrategy setAppPackageName(String str) {
        this.f39006e = str;
        return this;
    }

    public synchronized BuglyStrategy setAppReportDelay(long j10) {
        this.f39007f = j10;
        return this;
    }

    public synchronized BuglyStrategy setAppVersion(String str) {
        this.f39004c = str;
        return this;
    }

    public synchronized BuglyStrategy setBuglyLogUpload(boolean z10) {
        this.f39016o = z10;
        return this;
    }

    public synchronized void setCallBackType(int i10) {
        this.f39002a = i10;
    }

    public synchronized void setCloseErrorCallback(boolean z10) {
        this.f39003b = z10;
    }

    public synchronized BuglyStrategy setCrashHandleCallback(a aVar) {
        this.f39021t = aVar;
        return this;
    }

    public synchronized BuglyStrategy setDeviceID(String str) {
        this.f39009h = str;
        return this;
    }

    public synchronized BuglyStrategy setDeviceModel(String str) {
        this.f39010i = str;
        return this;
    }

    public synchronized BuglyStrategy setEnableANRCrashMonitor(boolean z10) {
        this.f39012k = z10;
        return this;
    }

    public void setEnableCatchAnrTrace(boolean z10) {
        this.f39013l = z10;
    }

    public synchronized BuglyStrategy setEnableNativeCrashMonitor(boolean z10) {
        this.f39011j = z10;
        return this;
    }

    public synchronized BuglyStrategy setEnableUserInfo(boolean z10) {
        this.f39014m = z10;
        return this;
    }

    public synchronized BuglyStrategy setLibBuglySOFilePath(String str) {
        this.f39008g = str;
        return this;
    }

    public void setMerged(boolean z10) {
        this.f39022u = z10;
    }

    public synchronized BuglyStrategy setRecordUserInfoOnceADay(boolean z10) {
        this.f39020s = z10;
        return this;
    }

    public void setReplaceOldChannel(boolean z10) {
        this.f39017p = z10;
    }

    public synchronized BuglyStrategy setUploadProcess(boolean z10) {
        this.f39018q = z10;
        return this;
    }

    public synchronized void setUploadSpotCrash(boolean z10) {
        this.f39019r = z10;
    }

    public synchronized BuglyStrategy setUserInfoActivity(Class<?> cls) {
        this.f39015n = cls;
        return this;
    }
}
