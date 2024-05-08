package com.kuaishou.weapon.p0;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class s {

    /* renamed from: a, reason: collision with root package name */
    public int f36191a;

    /* renamed from: b, reason: collision with root package name */
    public int f36192b;

    /* renamed from: c, reason: collision with root package name */
    public String f36193c;

    /* renamed from: d, reason: collision with root package name */
    public String f36194d;

    /* renamed from: e, reason: collision with root package name */
    public String f36195e;

    /* renamed from: f, reason: collision with root package name */
    public Context f36196f;

    /* renamed from: g, reason: collision with root package name */
    public ClassLoader f36197g;

    /* renamed from: h, reason: collision with root package name */
    public String f36198h;

    /* renamed from: i, reason: collision with root package name */
    public String f36199i;

    /* renamed from: j, reason: collision with root package name */
    public String f36200j;

    /* renamed from: k, reason: collision with root package name */
    public String f36201k;

    /* renamed from: l, reason: collision with root package name */
    public ActivityInfo[] f36202l;

    /* renamed from: m, reason: collision with root package name */
    public String f36203m;

    /* renamed from: n, reason: collision with root package name */
    public String f36204n;

    /* renamed from: o, reason: collision with root package name */
    public String f36205o;

    /* renamed from: p, reason: collision with root package name */
    public int f36206p;

    /* renamed from: q, reason: collision with root package name */
    public int f36207q;

    /* renamed from: r, reason: collision with root package name */
    public PackageInfo f36208r;

    /* renamed from: s, reason: collision with root package name */
    public long f36209s;

    /* renamed from: t, reason: collision with root package name */
    public int f36210t;

    /* renamed from: u, reason: collision with root package name */
    public int f36211u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f36212v;

    /* renamed from: w, reason: collision with root package name */
    public int f36213w;

    /* renamed from: x, reason: collision with root package name */
    public int f36214x = -1;

    /* renamed from: y, reason: collision with root package name */
    public boolean f36215y;

    public s() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        s sVar = (s) obj;
        String str = this.f36193c;
        if (str == null) {
            if (sVar.f36193c != null) {
                return false;
            }
        } else if (!str.equals(sVar.f36193c)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.f36193c;
        return (str == null ? 0 : str.hashCode()) + 31;
    }

    public s(PackageInfo packageInfo, int i10, String str, String str2, String str3, String str4) {
        this.f36208r = packageInfo;
        this.f36191a = i10;
        this.f36193c = str;
        this.f36194d = str2;
        this.f36199i = str3;
        this.f36200j = str4;
    }
}
