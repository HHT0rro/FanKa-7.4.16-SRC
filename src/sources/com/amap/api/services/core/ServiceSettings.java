package com.amap.api.services.core;

import android.content.Context;
import com.amap.api.col.s.ax;
import com.amap.api.col.s.by;
import com.amap.api.col.s.cc;
import com.amap.api.col.s.cf;
import com.amap.api.col.s.m;
import com.amap.api.col.s.n;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class ServiceSettings {
    public static final String CHINESE = "zh-CN";
    public static final String ENGLISH = "en";
    public static final int HTTP = 1;
    public static final int HTTPS = 2;

    /* renamed from: c, reason: collision with root package name */
    private static ServiceSettings f8481c;

    /* renamed from: a, reason: collision with root package name */
    private String f8482a = "zh-CN";

    /* renamed from: b, reason: collision with root package name */
    private int f8483b = 1;

    /* renamed from: d, reason: collision with root package name */
    private int f8484d = 20000;

    /* renamed from: e, reason: collision with root package name */
    private int f8485e = 20000;

    private ServiceSettings() {
    }

    public static ServiceSettings getInstance() {
        if (f8481c == null) {
            f8481c = new ServiceSettings();
        }
        return f8481c;
    }

    public static synchronized void updatePrivacyAgree(Context context, boolean z10) {
        synchronized (ServiceSettings.class) {
            cf.a(context, z10, m.a(false));
        }
    }

    public static synchronized void updatePrivacyShow(Context context, boolean z10, boolean z11) {
        synchronized (ServiceSettings.class) {
            cf.a(context, z10, z11, m.a(false));
        }
    }

    public void destroyInnerAsynThreadPool() {
        try {
            ax.b();
        } catch (Throwable th) {
            n.a(th, "ServiceSettings", "destroyInnerAsynThreadPool");
        }
    }

    public int getConnectionTimeOut() {
        return this.f8484d;
    }

    public String getLanguage() {
        return this.f8482a;
    }

    public int getProtocol() {
        return this.f8483b;
    }

    public int getSoTimeOut() {
        return this.f8485e;
    }

    public void setApiKey(String str) {
        by.a(str);
    }

    public void setConnectionTimeOut(int i10) {
        if (i10 < 5000) {
            this.f8484d = 5000;
        } else if (i10 > 30000) {
            this.f8484d = 30000;
        } else {
            this.f8484d = i10;
        }
    }

    public void setLanguage(String str) {
        this.f8482a = str;
    }

    public void setProtocol(int i10) {
        this.f8483b = i10;
        cc.a().a(this.f8483b == 2);
    }

    public void setSoTimeOut(int i10) {
        if (i10 < 5000) {
            this.f8485e = 5000;
        } else if (i10 > 30000) {
            this.f8485e = 30000;
        } else {
            this.f8485e = i10;
        }
    }
}
