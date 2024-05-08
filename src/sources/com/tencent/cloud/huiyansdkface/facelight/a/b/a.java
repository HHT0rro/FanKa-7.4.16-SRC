package com.tencent.cloud.huiyansdkface.facelight.a.b;

import android.text.TextUtils;
import com.tencent.cloud.huiyansdkface.facelight.api.WbCloudFaceContant;
import com.tencent.cloud.huiyansdkface.facelight.api.WbCloudFaceVerifySdk;
import java.util.Properties;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class a {
    public String A;
    public String B;
    public String C;
    public String D;
    public String E;
    public String F;
    public String G;
    public String H;
    public String I;
    public boolean J;
    public boolean K;
    public String L;
    public String M;
    public boolean N;
    private boolean Y;

    /* renamed from: a, reason: collision with root package name */
    public boolean f40535a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f40536b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f40537c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f40538d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f40539e;

    /* renamed from: f, reason: collision with root package name */
    public int f40540f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f40541g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f40542h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f40543i;

    /* renamed from: k, reason: collision with root package name */
    public WbCloudFaceVerifySdk.InputData f40545k;

    /* renamed from: n, reason: collision with root package name */
    public boolean f40548n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f40549o;

    /* renamed from: q, reason: collision with root package name */
    public boolean f40551q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f40552r;

    /* renamed from: s, reason: collision with root package name */
    public float f40553s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f40554t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f40555u;

    /* renamed from: v, reason: collision with root package name */
    public String f40556v;

    /* renamed from: x, reason: collision with root package name */
    public boolean f40558x;

    /* renamed from: j, reason: collision with root package name */
    public String f40544j = "-1";

    /* renamed from: l, reason: collision with root package name */
    public String f40546l = WbCloudFaceContant.LANGUAGE_ZH_CN;

    /* renamed from: m, reason: collision with root package name */
    public String f40547m = WbCloudFaceContant.ID_CARD;

    /* renamed from: p, reason: collision with root package name */
    public boolean f40550p = true;

    /* renamed from: w, reason: collision with root package name */
    public int f40557w = 1;

    /* renamed from: y, reason: collision with root package name */
    public String f40559y = WbCloudFaceContant.WHITE;

    /* renamed from: z, reason: collision with root package name */
    public int f40560z = 0;
    private String O = "0";
    private String P = "0";
    private String Q = "1";
    private String R = "0";
    private String S = "";
    private String T = "";
    private String U = "";
    private String V = "";
    private String W = "";
    private String X = "";

    public String A() {
        return this.F;
    }

    public String B() {
        return this.G;
    }

    public String C() {
        return this.H;
    }

    public String D() {
        return this.I;
    }

    public boolean E() {
        return this.K;
    }

    public String F() {
        return this.L;
    }

    public String G() {
        return this.M;
    }

    public String H() {
        return this.f40546l;
    }

    public boolean I() {
        return this.f40555u;
    }

    public String J() {
        return this.f40559y;
    }

    public boolean K() {
        return this.f40558x;
    }

    public String L() {
        return this.O;
    }

    public String M() {
        return this.W;
    }

    public String N() {
        return this.V;
    }

    public boolean O() {
        return this.f40541g;
    }

    public boolean P() {
        return this.f40542h;
    }

    public boolean Q() {
        return this.f40543i;
    }

    public String R() {
        return this.X;
    }

    public boolean S() {
        return this.f40536b;
    }

    public boolean T() {
        return this.f40537c;
    }

    public String U() {
        return this.S;
    }

    public String V() {
        return this.T;
    }

    public String W() {
        if (TextUtils.isEmpty(this.U)) {
            return "";
        }
        return "androidiosappIdh5faceId" + this.U;
    }

    public boolean X() {
        return this.f40539e;
    }

    public int Y() {
        return this.f40540f;
    }

    public Properties Z() {
        Properties properties = new Properties();
        properties.setProperty(WbCloudFaceContant.COLOR_MODE, this.f40559y);
        properties.setProperty("isCheckVideo", String.valueOf(this.f40548n));
        properties.setProperty("isUploadVideo", String.valueOf(this.f40549o));
        properties.setProperty("isPlayVoice", String.valueOf(this.f40555u));
        properties.setProperty("camSwitch", String.valueOf(this.f40558x));
        properties.setProperty("blinkSafetyLevel", String.valueOf(this.f40557w));
        properties.setProperty(WbCloudFaceContant.IS_LANDSCAPE, String.valueOf(this.f40543i));
        return properties;
    }

    public String a() {
        return this.P;
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        this.O = str;
    }

    public String b() {
        return this.Q;
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str) || !WbCloudFaceContant.LANGUAGE_ZH_CN.equals(this.f40546l)) {
            str = "0";
        }
        this.P = str;
    }

    public String c() {
        return this.R;
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "1";
        }
        this.Q = str;
    }

    public void d(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        this.R = str;
    }

    public boolean d() {
        return this.Y;
    }

    public void e(String str) {
        this.V = str;
    }

    public boolean e() {
        return this.f40535a;
    }

    public void f(String str) {
        this.S = str;
    }

    public boolean f() {
        return this.f40538d;
    }

    public void g(String str) {
        this.T = str;
    }

    public boolean g() {
        return this.N;
    }

    public String h() {
        return this.f40544j;
    }

    public void h(String str) {
        this.U = str;
    }

    public WbCloudFaceVerifySdk.InputData i() {
        return this.f40545k;
    }

    public void i(String str) {
        this.Y = "1".equals(str);
    }

    public int j() {
        return this.f40557w;
    }

    public void j(String str) {
        this.W = str;
    }

    public String k() {
        return this.f40547m;
    }

    public void k(String str) {
        this.X = str;
    }

    public boolean l() {
        return this.J;
    }

    public boolean m() {
        return this.f40549o;
    }

    public boolean n() {
        return this.f40550p;
    }

    public boolean o() {
        return this.f40551q;
    }

    public boolean p() {
        return this.f40552r;
    }

    public float q() {
        return this.f40553s;
    }

    public boolean r() {
        return this.f40554t;
    }

    public boolean s() {
        return this.f40548n;
    }

    public String t() {
        return this.f40556v;
    }

    public int u() {
        return this.f40560z;
    }

    public String v() {
        return this.A;
    }

    public String w() {
        return this.B;
    }

    public String x() {
        return this.C;
    }

    public String y() {
        return this.D;
    }

    public String z() {
        return this.E;
    }
}
