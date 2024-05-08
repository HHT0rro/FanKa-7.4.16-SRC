package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: AutoTCommonParam.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private Context f7069a;

    public a(Context context) {
        this.f7069a = context.getApplicationContext();
    }

    private static String b() {
        return "ANDA0605000";
    }

    private static String c() {
        return "";
    }

    private String d() {
        return ca.a(this.f7069a);
    }

    private static String e() {
        return "9.7.0";
    }

    private static String f() {
        return "";
    }

    private static String g() {
        return ca.k();
    }

    private static String h() {
        return "";
    }

    private static String i() {
        return "";
    }

    private static String j() {
        return "";
    }

    private static String k() {
        return "";
    }

    private static String l() {
        return "";
    }

    private static String m() {
        return "";
    }

    private static String n() {
        return "";
    }

    private static String o() {
        return "ANDH070308";
    }

    private static String p() {
        return "android";
    }

    private static String q() {
        return "";
    }

    private static String r() {
        return "";
    }

    public final String a() {
        StringBuilder sb2 = new StringBuilder("");
        sb2.append("personal_switch=false");
        sb2.append("&autodiv=");
        sb2.append(b());
        String c4 = c();
        if (!TextUtils.isEmpty(c4)) {
            sb2.append("&tid=");
            sb2.append(c4);
        }
        String d10 = d();
        if (!TextUtils.isEmpty(d10)) {
            sb2.append("&adiu=");
            sb2.append(d10);
        }
        String e2 = e();
        if (!TextUtils.isEmpty(e2)) {
            sb2.append("&app_version=");
            sb2.append(e2);
        }
        String f10 = f();
        if (!TextUtils.isEmpty(f10)) {
            sb2.append("&cifa=");
            sb2.append(f10);
        }
        String g3 = g();
        if (!TextUtils.isEmpty(g3)) {
            sb2.append("&deviceid=");
            sb2.append(g3);
        }
        String h10 = h();
        if (!TextUtils.isEmpty(h10)) {
            sb2.append("&did=");
            sb2.append(h10);
        }
        String i10 = i();
        if (!TextUtils.isEmpty(i10)) {
            sb2.append("&didv=");
            sb2.append(i10);
        }
        String j10 = j();
        if (!TextUtils.isEmpty(j10)) {
            sb2.append("&dic=");
            sb2.append(j10);
        }
        String k10 = k();
        if (!TextUtils.isEmpty(k10)) {
            sb2.append("&dip=");
            sb2.append(k10);
        }
        String l10 = l();
        if (!TextUtils.isEmpty(l10)) {
            sb2.append("&diu=");
            sb2.append(l10);
        }
        String m10 = m();
        if (!TextUtils.isEmpty(m10)) {
            sb2.append("&diu2=");
            sb2.append(m10);
        }
        String n10 = n();
        if (!TextUtils.isEmpty(n10)) {
            sb2.append("&diu3=");
            sb2.append(n10);
        }
        String o10 = o();
        if (!TextUtils.isEmpty(o10)) {
            sb2.append("&div=");
            sb2.append(o10);
        }
        String p10 = p();
        if (!TextUtils.isEmpty(p10)) {
            sb2.append("&os=");
            sb2.append(p10);
        }
        String q10 = q();
        if (!TextUtils.isEmpty(q10)) {
            sb2.append("&stepid=");
            sb2.append(q10);
        }
        String r10 = r();
        if (!TextUtils.isEmpty(r10)) {
            sb2.append("&session=");
            sb2.append(r10);
        }
        return sb2.toString();
    }
}
