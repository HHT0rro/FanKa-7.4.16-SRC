package com.tencent.turingface.sdk.mfa;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class CvowV {

    /* renamed from: a, reason: collision with root package name */
    public static final spXPg f45539a = new spXPg();

    /* renamed from: b, reason: collision with root package name */
    public BfUKf f45540b;

    /* renamed from: c, reason: collision with root package name */
    public n6fHX f45541c;

    /* renamed from: d, reason: collision with root package name */
    public ITuringDeviceInfoProvider f45542d;

    /* renamed from: e, reason: collision with root package name */
    public Context f45543e;

    /* renamed from: f, reason: collision with root package name */
    public int f45544f = 0;

    /* renamed from: g, reason: collision with root package name */
    public String f45545g = "";

    /* renamed from: h, reason: collision with root package name */
    public boolean f45546h = true;

    /* renamed from: i, reason: collision with root package name */
    public String f45547i = "";

    /* renamed from: j, reason: collision with root package name */
    public String f45548j = "";

    /* renamed from: k, reason: collision with root package name */
    public String f45549k = "";

    /* renamed from: l, reason: collision with root package name */
    public String f45550l = "";

    /* renamed from: m, reason: collision with root package name */
    public String f45551m = "";

    /* renamed from: n, reason: collision with root package name */
    public Map<Integer, String> f45552n = new HashMap();

    /* renamed from: o, reason: collision with root package name */
    public String f45553o = "";

    /* renamed from: p, reason: collision with root package name */
    public boolean f45554p = true;

    /* renamed from: q, reason: collision with root package name */
    public boolean f45555q = false;

    /* renamed from: r, reason: collision with root package name */
    public boolean f45556r = true;

    /* renamed from: s, reason: collision with root package name */
    public boolean f45557s = true;

    /* renamed from: t, reason: collision with root package name */
    public boolean f45558t = true;

    /* renamed from: u, reason: collision with root package name */
    public long f45559u = 5000;

    /* renamed from: v, reason: collision with root package name */
    public int f45560v = 3;

    /* renamed from: w, reason: collision with root package name */
    public long f45561w = 5000;

    /* renamed from: x, reason: collision with root package name */
    public boolean f45562x = false;

    /* renamed from: y, reason: collision with root package name */
    public Set<Integer> f45563y;

    /* renamed from: z, reason: collision with root package name */
    public String f45564z;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class spXPg implements com.tencent.turingface.sdk.mfa.spXPg {
        @Override // com.tencent.turingface.sdk.mfa.spXPg
        public final boolean a() {
            return false;
        }
    }

    public final void a() {
        if (TextUtils.isEmpty(this.f45547i)) {
            this.f45547i = "https://tdid.m.qq.com?mc=2";
        }
        if (this.f45540b == null) {
            this.f45540b = new kB0t4(this.f45547i);
        } else {
            this.f45562x = true;
        }
    }

    public final String b() {
        return TextUtils.isEmpty(this.f45553o) ? "" : this.f45553o;
    }
}
