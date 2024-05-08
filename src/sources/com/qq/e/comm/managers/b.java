package com.qq.e.comm.managers;

import android.content.Context;
import android.text.TextUtils;
import com.qq.e.ads.dfa.GDTAppDialogClickListener;
import com.qq.e.comm.managers.devtool.DevTools;
import com.qq.e.comm.managers.plugin.PM;
import com.qq.e.comm.util.GDTLogger;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class b implements IGDTAdManager {

    /* renamed from: g, reason: collision with root package name */
    public static final ExecutorService f38267g = Executors.newSingleThreadExecutor();

    /* renamed from: a, reason: collision with root package name */
    private volatile Boolean f38268a;

    /* renamed from: b, reason: collision with root package name */
    private volatile boolean f38269b;

    /* renamed from: c, reason: collision with root package name */
    private volatile Context f38270c;

    /* renamed from: d, reason: collision with root package name */
    private volatile PM f38271d;

    /* renamed from: e, reason: collision with root package name */
    private volatile DevTools f38272e;

    /* renamed from: f, reason: collision with root package name */
    private volatile String f38273f;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private static b f38274a = new b(null);
    }

    private b() {
        this.f38268a = Boolean.FALSE;
        this.f38269b = false;
    }

    public /* synthetic */ b(com.qq.e.comm.managers.a aVar) {
        this();
    }

    public static b b() {
        return a.f38274a;
    }

    public String a() {
        return this.f38273f;
    }

    public synchronized boolean a(Context context, String str) {
        if (this.f38268a.booleanValue()) {
            return true;
        }
        if (context == null || TextUtils.isEmpty(str)) {
            GDTLogger.e("GDTADManager初始化错误，context和appId不能为空");
            return false;
        }
        try {
            this.f38273f = str;
            this.f38270c = context.getApplicationContext();
            this.f38271d = new PM(this.f38270c, null);
            f38267g.submit(new com.qq.e.comm.managers.a(this));
            this.f38268a = Boolean.TRUE;
            return true;
        } catch (Throwable th) {
            GDTLogger.e("GDTADManager初始化错误", th);
            return false;
        }
    }

    public PM c() {
        return this.f38271d;
    }

    public boolean d() {
        if (this.f38268a != null && this.f38268a.booleanValue()) {
            return true;
        }
        GDTLogger.e("SDK 尚未初始化，请在 Application 中调用 GDTAdSdk.init() 初始化");
        return false;
    }

    @Override // com.qq.e.comm.managers.IGDTAdManager
    public String getBuyerId(Map<String, Object> map) {
        if (!d()) {
            return "";
        }
        try {
            return this.f38271d.getPOFactory().getBuyerId(map);
        } catch (Exception e2) {
            GDTLogger.e("SDK 初始化异常", e2);
            return "";
        }
    }

    @Override // com.qq.e.comm.managers.IGDTAdManager
    public DevTools getDevTools() {
        if (this.f38272e == null) {
            this.f38272e = new DevTools();
        }
        return this.f38272e;
    }

    @Override // com.qq.e.comm.managers.IGDTAdManager
    public String getSDKInfo(String str) {
        if (!d()) {
            return "";
        }
        try {
            return this.f38271d.getPOFactory().getSDKInfo(str);
        } catch (Exception e2) {
            GDTLogger.e("SDK 初始化异常", e2);
            return "";
        }
    }

    @Override // com.qq.e.comm.managers.IGDTAdManager
    public int showOpenOrInstallAppDialog(GDTAppDialogClickListener gDTAppDialogClickListener) {
        if (!this.f38269b) {
            return 0;
        }
        try {
            return this.f38271d.getPOFactory().showOpenOrInstallAppDialog(gDTAppDialogClickListener);
        } catch (Exception e2) {
            GDTLogger.e("SDK 初始化异常", e2);
            return 0;
        }
    }
}
