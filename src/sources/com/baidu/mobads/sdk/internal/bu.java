package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.baidu.mobads.sdk.internal.by;
import com.baidu.mobads.sdk.internal.ch;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class bu extends Thread {

    /* renamed from: b, reason: collision with root package name */
    private static final String f9956b = "ApkDownloadThread";

    /* renamed from: c, reason: collision with root package name */
    private static final int f9957c = 900000;

    /* renamed from: h, reason: collision with root package name */
    private static volatile bu f9958h;

    /* renamed from: d, reason: collision with root package name */
    private volatile String f9960d;

    /* renamed from: e, reason: collision with root package name */
    private String f9961e;

    /* renamed from: f, reason: collision with root package name */
    private double f9962f;

    /* renamed from: g, reason: collision with root package name */
    private Handler f9963g;

    /* renamed from: i, reason: collision with root package name */
    private final Context f9964i;

    /* renamed from: k, reason: collision with root package name */
    private final bw f9966k;

    /* renamed from: j, reason: collision with root package name */
    private ch f9965j = null;

    /* renamed from: l, reason: collision with root package name */
    private bs f9967l = bs.a();

    /* renamed from: a, reason: collision with root package name */
    public ch.a f9959a = new bv(this);

    private bu(Context context, bw bwVar, String str, Handler handler) {
        this.f9961e = null;
        this.f9964i = context;
        this.f9966k = bwVar;
        a(bwVar.c());
        this.f9963g = handler;
        this.f9961e = str;
    }

    private boolean b() {
        double d10;
        try {
            try {
                this.f9965j = new ch(this.f9964i, new URL(this.f9960d), this.f9966k, this.f9959a);
            } catch (MalformedURLException unused) {
                this.f9965j = new ch(this.f9964i, this.f9960d, this.f9966k, this.f9959a);
            }
            if (by.f9994q != null) {
                d10 = by.f9994q.f9916b;
            } else if (by.f9993p == null) {
                d10 = 0.0d;
            } else if (by.f9993p.f9916b > ShadowDrawableWrapper.COS_45) {
                d10 = by.f9993p.f9916b;
            } else {
                d10 = by.f9993p.f9916b;
            }
            this.f9967l.a(f9956b, "isNewApkAvailable: local apk version is: " + d10 + ", remote apk version: " + this.f9966k.b());
            if (d10 > ShadowDrawableWrapper.COS_45) {
                if (this.f9966k.b() > ShadowDrawableWrapper.COS_45) {
                    this.f9967l.a(f9956b, "remote not null, local apk version is null, force upgrade");
                    this.f9962f = this.f9966k.b();
                    return true;
                }
                this.f9967l.a(f9956b, "remote is null, local apk version is null, do not upgrade");
                return false;
            }
            if (this.f9966k.b() > ShadowDrawableWrapper.COS_45) {
                if (this.f9966k.b() <= d10) {
                    return false;
                }
                this.f9962f = this.f9966k.b();
                return true;
            }
            this.f9967l.a(f9956b, "remote apk version is: null, local apk version is: " + d10 + ", do not upgrade");
            return false;
        } catch (Exception e2) {
            String str = "parse apk failed, error:" + e2.toString();
            this.f9967l.a(f9956b, str);
            throw new by.a(str);
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            if (b()) {
                try {
                    a();
                    this.f9967l.a(f9956b, "download apk successfully, downloader exit");
                    f9958h = null;
                } catch (IOException e2) {
                    this.f9967l.a(f9956b, "create File or HTTP Get failed, exception: " + e2.getMessage());
                }
                this.f9967l.a(f9956b, "no newer apk, downloader exit");
                f9958h = null;
            }
        } catch (Throwable unused) {
        }
    }

    public static bu a(Context context, bw bwVar, String str, Handler handler) {
        if (f9958h == null) {
            f9958h = new bu(context, bwVar, str, handler);
        }
        return f9958h;
    }

    public void a(String str) {
        this.f9960d = str;
        interrupt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, bw bwVar, String str2) {
        if (str.equals(by.f9988k) || str.equals(by.f9989l)) {
            Message obtainMessage = this.f9963g.obtainMessage();
            Bundle bundle = new Bundle();
            bundle.putParcelable(by.f9990m, bwVar);
            bundle.putString(by.f9991n, str);
            obtainMessage.setData(bundle);
            this.f9963g.sendMessage(obtainMessage);
        }
    }

    private String a() {
        String str = by.f9982e + UUID.randomUUID().toString() + ".jar";
        String str2 = this.f9961e + str;
        File file = new File(str2);
        try {
            file.createNewFile();
            this.f9965j.a(this.f9961e, str);
            return str2;
        } catch (IOException e2) {
            file.delete();
            throw e2;
        }
    }
}
