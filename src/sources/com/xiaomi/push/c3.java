package com.xiaomi.push;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class c3 extends a3 {

    /* renamed from: d, reason: collision with root package name */
    public boolean f47151d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f47152e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f47153f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f47154g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f47155h;

    public c3(Context context, int i10, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14) {
        super(context, i10);
        this.f47151d = z10;
        this.f47152e = z11;
        this.f47153f = z12;
        this.f47154g = z13;
        this.f47155h = z14;
    }

    private String g() {
        if (!this.f47151d) {
            return "off";
        }
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) this.f47110c.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.heightPixels + "," + displayMetrics.widthPixels;
        } catch (Throwable unused) {
            return "";
        }
    }

    private String i() {
        if (!this.f47152e) {
            return "off";
        }
        try {
            return Build.VERSION.RELEASE;
        } catch (Throwable unused) {
            return "";
        }
    }

    @Override // com.xiaomi.push.n.a
    public int a() {
        return 3;
    }

    @Override // com.xiaomi.push.a3
    public hs b() {
        return hs.DeviceInfoV2;
    }

    @Override // com.xiaomi.push.a3
    public String c() {
        return g() + "|" + i() + "|" + k() + "|" + l() + "|" + m();
    }

    public final String k() {
        if (!this.f47153f) {
            return "off";
        }
        try {
            return String.valueOf(Build.VERSION.SDK_INT);
        } catch (Throwable unused) {
            return "";
        }
    }

    public final String l() {
        if (!this.f47154g) {
            return "off";
        }
        try {
            return Settings.Secure.getString(this.f47110c.getContentResolver(), "android_id");
        } catch (Throwable unused) {
            return "";
        }
    }

    public final String m() {
        if (!this.f47155h) {
            return "off";
        }
        try {
            return ((TelephonyManager) this.f47110c.getSystemService("phone")).getSimOperator();
        } catch (Throwable unused) {
            return "";
        }
    }
}
