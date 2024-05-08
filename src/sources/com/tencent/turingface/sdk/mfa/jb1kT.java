package com.tencent.turingface.sdk.mfa;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class jb1kT extends CvowV {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class spXPg {

        /* renamed from: a, reason: collision with root package name */
        public Context f45810a;

        /* renamed from: k, reason: collision with root package name */
        public n6fHX f45820k;

        /* renamed from: l, reason: collision with root package name */
        public ITuringDeviceInfoProvider f45821l;

        /* renamed from: o, reason: collision with root package name */
        public long f45824o;

        /* renamed from: p, reason: collision with root package name */
        public Set<Integer> f45825p;

        /* renamed from: q, reason: collision with root package name */
        public String f45826q;

        /* renamed from: b, reason: collision with root package name */
        public int f45811b = 0;

        /* renamed from: c, reason: collision with root package name */
        public Map<Integer, String> f45812c = new HashMap();

        /* renamed from: d, reason: collision with root package name */
        public boolean f45813d = true;

        /* renamed from: e, reason: collision with root package name */
        public String f45814e = "";

        /* renamed from: f, reason: collision with root package name */
        public String f45815f = "";

        /* renamed from: g, reason: collision with root package name */
        public boolean f45816g = true;

        /* renamed from: h, reason: collision with root package name */
        public String f45817h = "turingfd.cert";

        /* renamed from: i, reason: collision with root package name */
        public boolean f45818i = true;

        /* renamed from: j, reason: collision with root package name */
        public boolean f45819j = true;

        /* renamed from: m, reason: collision with root package name */
        public String f45822m = "";

        /* renamed from: n, reason: collision with root package name */
        public ITuringNetwork f45823n = null;

        public spXPg(Context context, n6fHX n6fhx) {
            this.f45810a = context.getApplicationContext();
            this.f45820k = n6fhx;
        }

        public static /* synthetic */ long C(spXPg spxpg) {
            spxpg.getClass();
            return 60000L;
        }

        public static /* synthetic */ int E(spXPg spxpg) {
            spxpg.getClass();
            return 3;
        }

        public static /* synthetic */ String a(spXPg spxpg) {
            spxpg.getClass();
            return "";
        }

        public static /* synthetic */ String b(spXPg spxpg) {
            spxpg.getClass();
            return "";
        }

        public static /* synthetic */ int c(spXPg spxpg) {
            spxpg.getClass();
            return 0;
        }

        public static /* synthetic */ String d(spXPg spxpg) {
            spxpg.getClass();
            return "";
        }

        public static /* synthetic */ String g(spXPg spxpg) {
            spxpg.getClass();
            return "";
        }

        public static /* synthetic */ boolean o(spXPg spxpg) {
            spxpg.getClass();
            return false;
        }

        public static /* synthetic */ int r(spXPg spxpg) {
            spxpg.getClass();
            return 5000;
        }

        public static /* synthetic */ boolean s(spXPg spxpg) {
            spxpg.getClass();
            return true;
        }

        public static /* synthetic */ ITuringPkgProvider u(spXPg spxpg) {
            spxpg.getClass();
            return null;
        }

        public static /* synthetic */ ITuringIoTFeatureMap v(spXPg spxpg) {
            spxpg.getClass();
            return null;
        }

        public static /* synthetic */ boolean w(spXPg spxpg) {
            spxpg.getClass();
            return false;
        }

        public static /* synthetic */ boolean x(spXPg spxpg) {
            spxpg.getClass();
            return false;
        }
    }

    public jb1kT(spXPg spxpg) {
        this.f45543e = spxpg.f45810a;
        spXPg.g(spxpg);
        this.f45545g = "";
        spXPg.r(spxpg);
        this.f45559u = 5000;
        spXPg.C(spxpg);
        spXPg.E(spxpg);
        this.f45560v = 3;
        spXPg.a(spxpg);
        this.f45550l = "";
        spXPg.b(spxpg);
        this.f45549k = "";
        spXPg.c(spxpg);
        spXPg.d(spxpg);
        this.f45551m = "";
        this.f45552n = spxpg.f45812c;
        this.f45544f = spxpg.f45811b;
        this.f45546h = spxpg.f45813d;
        this.f45553o = spxpg.f45814e;
        this.f45548j = spxpg.f45815f;
        this.f45556r = spxpg.f45816g;
        String unused = spxpg.f45817h;
        this.f45554p = spxpg.f45818i;
        spXPg.o(spxpg);
        this.f45555q = false;
        this.f45558t = spxpg.f45819j;
        this.f45541c = spxpg.f45820k;
        spXPg.s(spxpg);
        this.f45557s = true;
        this.f45542d = spxpg.f45821l;
        spXPg.u(spxpg);
        spXPg.v(spxpg);
        spXPg.w(spxpg);
        spXPg.x(spxpg);
        this.f45547i = spxpg.f45822m;
        this.f45540b = spxpg.f45823n;
        this.f45561w = spxpg.f45824o;
        this.f45563y = spxpg.f45825p;
        this.f45564z = spxpg.f45826q;
        a();
    }
}
