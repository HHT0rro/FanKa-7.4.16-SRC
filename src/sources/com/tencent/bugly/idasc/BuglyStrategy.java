package com.tencent.bugly.idasc;

import com.tencent.bugly.idasc.proguard.aa;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class BuglyStrategy {

    /* renamed from: c, reason: collision with root package name */
    private String f39335c;

    /* renamed from: d, reason: collision with root package name */
    private String f39336d;

    /* renamed from: e, reason: collision with root package name */
    private String f39337e;

    /* renamed from: f, reason: collision with root package name */
    private long f39338f;

    /* renamed from: g, reason: collision with root package name */
    private String f39339g;

    /* renamed from: h, reason: collision with root package name */
    private String f39340h;

    /* renamed from: i, reason: collision with root package name */
    private String f39341i;

    /* renamed from: u, reason: collision with root package name */
    private a f39353u;

    /* renamed from: j, reason: collision with root package name */
    private boolean f39342j = true;

    /* renamed from: k, reason: collision with root package name */
    private boolean f39343k = true;

    /* renamed from: l, reason: collision with root package name */
    private boolean f39344l = true;

    /* renamed from: m, reason: collision with root package name */
    private boolean f39345m = false;

    /* renamed from: n, reason: collision with root package name */
    private boolean f39346n = true;

    /* renamed from: o, reason: collision with root package name */
    private Class<?> f39347o = null;

    /* renamed from: p, reason: collision with root package name */
    private boolean f39348p = true;

    /* renamed from: q, reason: collision with root package name */
    private boolean f39349q = true;

    /* renamed from: r, reason: collision with root package name */
    private boolean f39350r = true;

    /* renamed from: s, reason: collision with root package name */
    private boolean f39351s = true;

    /* renamed from: t, reason: collision with root package name */
    private boolean f39352t = false;

    /* renamed from: a, reason: collision with root package name */
    public int f39333a = 31;

    /* renamed from: b, reason: collision with root package name */
    public boolean f39334b = false;

    /* renamed from: v, reason: collision with root package name */
    private boolean f39354v = false;

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
        String str = this.f39336d;
        if (str != null) {
            return str;
        }
        return aa.b().f39489s;
    }

    public synchronized String getAppPackageName() {
        String str = this.f39337e;
        if (str != null) {
            return str;
        }
        return aa.b().f39473c;
    }

    public synchronized long getAppReportDelay() {
        return this.f39338f;
    }

    public synchronized String getAppVersion() {
        String str = this.f39335c;
        if (str != null) {
            return str;
        }
        return aa.b().f39485o;
    }

    public synchronized int getCallBackType() {
        return this.f39333a;
    }

    public synchronized boolean getCloseErrorCallback() {
        return this.f39334b;
    }

    public synchronized a getCrashHandleCallback() {
        return this.f39353u;
    }

    public synchronized String getDeviceID() {
        return this.f39340h;
    }

    public synchronized String getDeviceModel() {
        return this.f39341i;
    }

    public synchronized String getLibBuglySOFilePath() {
        return this.f39339g;
    }

    public synchronized Class<?> getUserInfoActivity() {
        return this.f39347o;
    }

    public synchronized boolean isBuglyLogUpload() {
        return this.f39348p;
    }

    public synchronized boolean isEnableANRCrashMonitor() {
        return this.f39343k;
    }

    public synchronized boolean isEnableCatchAnrTrace() {
        return this.f39344l;
    }

    public synchronized boolean isEnableNativeCrashMonitor() {
        return this.f39342j;
    }

    public boolean isEnableRecordAnrMainStack() {
        return this.f39345m;
    }

    public synchronized boolean isEnableUserInfo() {
        return this.f39346n;
    }

    public boolean isMerged() {
        return this.f39354v;
    }

    public boolean isReplaceOldChannel() {
        return this.f39349q;
    }

    public synchronized boolean isUploadProcess() {
        return this.f39350r;
    }

    public synchronized boolean isUploadSpotCrash() {
        return this.f39351s;
    }

    public synchronized boolean recordUserInfoOnceADay() {
        return this.f39352t;
    }

    public synchronized BuglyStrategy setAppChannel(String str) {
        this.f39336d = str;
        return this;
    }

    public synchronized BuglyStrategy setAppPackageName(String str) {
        this.f39337e = str;
        return this;
    }

    public synchronized BuglyStrategy setAppReportDelay(long j10) {
        this.f39338f = j10;
        return this;
    }

    public synchronized BuglyStrategy setAppVersion(String str) {
        this.f39335c = str;
        return this;
    }

    public synchronized BuglyStrategy setBuglyLogUpload(boolean z10) {
        this.f39348p = z10;
        return this;
    }

    public synchronized void setCallBackType(int i10) {
        this.f39333a = i10;
    }

    public synchronized void setCloseErrorCallback(boolean z10) {
        this.f39334b = z10;
    }

    public synchronized BuglyStrategy setCrashHandleCallback(a aVar) {
        this.f39353u = aVar;
        return this;
    }

    public synchronized BuglyStrategy setDeviceID(String str) {
        this.f39340h = str;
        return this;
    }

    public synchronized BuglyStrategy setDeviceModel(String str) {
        this.f39341i = str;
        return this;
    }

    public synchronized BuglyStrategy setEnableANRCrashMonitor(boolean z10) {
        this.f39343k = z10;
        return this;
    }

    public void setEnableCatchAnrTrace(boolean z10) {
        this.f39344l = z10;
    }

    public synchronized BuglyStrategy setEnableNativeCrashMonitor(boolean z10) {
        this.f39342j = z10;
        return this;
    }

    public void setEnableRecordAnrMainStack(boolean z10) {
        this.f39345m = z10;
    }

    public synchronized BuglyStrategy setEnableUserInfo(boolean z10) {
        this.f39346n = z10;
        return this;
    }

    public synchronized BuglyStrategy setLibBuglySOFilePath(String str) {
        this.f39339g = str;
        return this;
    }

    @Deprecated
    public void setMerged(boolean z10) {
        this.f39354v = z10;
    }

    public synchronized BuglyStrategy setRecordUserInfoOnceADay(boolean z10) {
        this.f39352t = z10;
        return this;
    }

    public void setReplaceOldChannel(boolean z10) {
        this.f39349q = z10;
    }

    public synchronized BuglyStrategy setUploadProcess(boolean z10) {
        this.f39350r = z10;
        return this;
    }

    public synchronized void setUploadSpotCrash(boolean z10) {
        this.f39351s = z10;
    }

    public synchronized BuglyStrategy setUserInfoActivity(Class<?> cls) {
        this.f39347o = cls;
        return this;
    }
}
