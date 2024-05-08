package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Process;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.xiaomi.push.hv;
import com.xiaomi.push.l7;
import java.lang.Thread;
import org.apache.commons.io.IOUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class g1 implements Thread.UncaughtExceptionHandler {

    /* renamed from: d, reason: collision with root package name */
    public static final Object f46997d = new Object();

    /* renamed from: e, reason: collision with root package name */
    public static final String[] f46998e = {"com.xiaomi.channel.commonutils", "com.xiaomi.common.logger", "com.xiaomi.measite.smack", "com.xiaomi.metoknlp", "com.xiaomi.mipush.sdk", "com.xiaomi.network", "com.xiaomi.push", "com.xiaomi.slim", "com.xiaomi.smack", "com.xiaomi.stats", "com.xiaomi.tinyData", "com.xiaomi.xmpush.thrift", "com.xiaomi.clientreport"};

    /* renamed from: a, reason: collision with root package name */
    public Context f46999a;

    /* renamed from: b, reason: collision with root package name */
    public SharedPreferences f47000b;

    /* renamed from: c, reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f47001c;

    public g1(Context context) {
        this(context, Thread.getDefaultUncaughtExceptionHandler());
    }

    public g1(Context context, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f46999a = context;
        this.f47001c = uncaughtExceptionHandler;
    }

    public final String c(Throwable th) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < Math.min(3, stackTrace.length); i10++) {
            sb2.append(stackTrace[i10].toString() + IOUtils.LINE_SEPARATOR_WINDOWS);
        }
        String sb3 = sb2.toString();
        return TextUtils.isEmpty(sb3) ? "" : com.xiaomi.push.p0.b(sb3);
    }

    public final void d() {
        com.xiaomi.push.n.c(this.f46999a).g(new h1(this));
    }

    public final void f(Throwable th) {
        String i10 = i(th);
        if (TextUtils.isEmpty(i10)) {
            return;
        }
        String c4 = c(th);
        if (TextUtils.isEmpty(c4)) {
            return;
        }
        e1.a(this.f46999a).e(i10, c4);
        if (g()) {
            d();
        }
    }

    public final boolean g() {
        this.f47000b = this.f46999a.getSharedPreferences("mipush_extra", 4);
        if (com.xiaomi.push.j0.s(this.f46999a)) {
            if (kc.j.d(this.f46999a).i(hv.Crash4GUploadSwitch.a(), true)) {
                return ((float) Math.abs((System.currentTimeMillis() / 1000) - this.f47000b.getLong("last_crash_upload_time_stamp", 0L))) >= ((float) Math.max(SdkConfigData.DEFAULT_REQUEST_INTERVAL, kc.j.d(this.f46999a).a(hv.Crash4GUploadFrequency.a(), SdkConfigData.DEFAULT_REQUEST_INTERVAL))) * 0.9f;
            }
            return false;
        }
        if (com.xiaomi.push.j0.r(this.f46999a)) {
            return Math.abs((System.currentTimeMillis() / 1000) - this.f47000b.getLong("last_crash_upload_time_stamp", 0L)) >= ((long) Math.max(60, kc.j.d(this.f46999a).a(hv.CrashWIFIUploadFrequency.a(), AMapException.CODE_AMAP_CLIENT_ERRORCODE_MISSSING)));
        }
        return true;
    }

    public final boolean h(boolean z10, String str) {
        for (String str2 : f46998e) {
            if (str.contains(str2)) {
                return true;
            }
        }
        return z10;
    }

    public final String i(Throwable th) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        StringBuilder sb2 = new StringBuilder(th.toString());
        sb2.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        boolean z10 = false;
        for (StackTraceElement stackTraceElement : stackTrace) {
            String stackTraceElement2 = stackTraceElement.toString();
            z10 = h(z10, stackTraceElement2);
            sb2.append(stackTraceElement2);
            sb2.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        }
        return z10 ? sb2.toString() : "";
    }

    public final void j() {
        SharedPreferences sharedPreferences = this.f46999a.getSharedPreferences("mipush_extra", 4);
        this.f47000b = sharedPreferences;
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putLong("last_crash_upload_time_stamp", System.currentTimeMillis() / 1000);
        l7.a(edit);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        f(th);
        Object obj = f46997d;
        synchronized (obj) {
            try {
                obj.wait(com.huawei.openalliance.ad.ipc.c.Code);
            } catch (InterruptedException e2) {
                fc.c.k(e2);
            }
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f47001c;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        } else {
            Process.killProcess(Process.myPid());
            System.exit(1);
        }
    }
}
