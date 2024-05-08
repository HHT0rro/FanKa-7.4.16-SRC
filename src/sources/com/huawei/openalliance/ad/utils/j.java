package com.huawei.openalliance.ad.utils;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.huawei.hms.ads.ea;
import com.huawei.hms.ads.gl;
import java.util.Locale;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class j {
    private static final String B = "ro.product.locale.region";
    private static final String C = "ro.product.locale";
    public static final String Code = "ro.hw.country";
    private static final String D = "la";
    private static final String F = "eu";
    public static final String I = "CN";
    private static final String L = "uk";
    private static final String S = "UNKNOWN";
    public static final String V = "msc.sys.country";
    private static final String Z = "CountryCodeBean";

    /* renamed from: a, reason: collision with root package name */
    private static final String f32597a = "gb";

    /* renamed from: b, reason: collision with root package name */
    private static final String f32598b = "cn";

    /* renamed from: c, reason: collision with root package name */
    private static final int f32599c = 2;

    /* renamed from: d, reason: collision with root package name */
    private String f32600d;

    public j(Context context) {
        this.f32600d = "UNKNOWN";
        Code(context);
        this.f32600d = this.f32600d.toUpperCase(Locale.ENGLISH);
    }

    private void B(Context context) {
        int lastIndexOf;
        String Code2 = ay.Code("ro.product.locale.region");
        this.f32600d = Code2;
        if (TextUtils.isEmpty(Code2)) {
            String Code3 = ay.Code("ro.product.locale");
            if (!TextUtils.isEmpty(Code3) && (lastIndexOf = Code3.lastIndexOf("-")) != -1) {
                this.f32600d = Code3.substring(lastIndexOf + 1);
            }
        }
        if (f32598b.equalsIgnoreCase(this.f32600d)) {
            return;
        }
        this.f32600d = "UNKNOWN";
    }

    private void Code(Context context) {
        if (context == null) {
            return;
        }
        try {
            V(context);
            if (V()) {
                gl.V(Z, "get issue_country code from VENDOR_COUNTRY");
                return;
            }
            I(context);
            if (V()) {
                gl.V(Z, "get issue_country code from SIM_COUNTRY");
                return;
            }
            if (l.B(context)) {
                gl.V(Z, "pad skip locale get issue_country code from grs ip");
                return;
            }
            Z(context);
            if (V()) {
                gl.V(Z, "get issue_country code from LOCALE_INFO");
            }
        } catch (Throwable unused) {
            gl.I(Z, "get CountryCode error");
        }
    }

    private void Code(Context context, boolean z10) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getApplicationContext().getSystemService("phone");
        if (telephonyManager != null) {
            this.f32600d = (!z10 || telephonyManager.getPhoneType() == 2) ? telephonyManager.getSimCountryIso() : telephonyManager.getNetworkCountryIso();
        }
        I();
    }

    private void I() {
        String str = this.f32600d;
        if (str == null || str.length() != 2) {
            this.f32600d = "UNKNOWN";
        }
    }

    private void I(Context context) {
        Code(context, false);
    }

    private void V(Context context) {
        String str;
        this.f32600d = ay.Code(ea.Z(context) ? V : Code);
        if (F.equalsIgnoreCase(this.f32600d) || D.equalsIgnoreCase(this.f32600d)) {
            str = "UNKNOWN";
        } else {
            if (!L.equalsIgnoreCase(this.f32600d)) {
                I();
                return;
            }
            str = f32597a;
        }
        this.f32600d = str;
    }

    private boolean V() {
        return !"UNKNOWN".equals(this.f32600d);
    }

    private void Z() {
        String country = Locale.getDefault().getCountry();
        this.f32600d = country;
        if (TextUtils.isEmpty(country)) {
            this.f32600d = "UNKNOWN";
        }
    }

    private void Z(Context context) {
        if (Build.VERSION.SDK_INT >= 28) {
            Z();
        } else {
            B(context);
        }
    }

    public String Code() {
        if (gl.Code()) {
            gl.Code(Z, "countryCode: %s", this.f32600d);
        }
        return this.f32600d;
    }
}
