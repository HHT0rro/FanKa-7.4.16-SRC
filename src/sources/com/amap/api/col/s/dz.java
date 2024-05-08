package com.amap.api.col.s;

import android.text.TextUtils;
import com.amap.api.col.s.dt;
import com.huawei.appgallery.agd.common.constant.SymbolValues;
import com.inno.innosdk.pb.InnoMain;
import java.net.Proxy;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Request.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class dz {

    /* renamed from: d, reason: collision with root package name */
    private String f7830d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f7831e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f7832f;

    /* renamed from: o, reason: collision with root package name */
    public dt.a f7838o;

    /* renamed from: l, reason: collision with root package name */
    public int f7835l = 20000;

    /* renamed from: m, reason: collision with root package name */
    public int f7836m = 20000;

    /* renamed from: n, reason: collision with root package name */
    public Proxy f7837n = null;

    /* renamed from: a, reason: collision with root package name */
    private boolean f7827a = false;

    /* renamed from: b, reason: collision with root package name */
    private int f7828b = 20000;

    /* renamed from: c, reason: collision with root package name */
    private boolean f7829c = true;

    /* renamed from: g, reason: collision with root package name */
    private a f7833g = a.NORMAL;

    /* renamed from: h, reason: collision with root package name */
    private b f7834h = b.FIRST_NONDEGRADE;

    /* compiled from: Request.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public enum a {
        NORMAL(0),
        INTERRUPT_IO(1),
        NEVER(2),
        FIX(3),
        SINGLE(4);


        /* renamed from: f, reason: collision with root package name */
        private int f7845f;

        a(int i10) {
            this.f7845f = i10;
        }
    }

    /* compiled from: Request.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public enum b {
        FIRST_NONDEGRADE(0),
        NEVER_GRADE(1),
        DEGRADE_BYERROR(2),
        DEGRADE_ONLY(3),
        FIX_NONDEGRADE(4),
        FIX_DEGRADE_BYERROR(5),
        FIX_DEGRADE_ONLY(6);


        /* renamed from: h, reason: collision with root package name */
        private int f7854h;

        b(int i10) {
            this.f7854h = i10;
        }

        public final int a() {
            return this.f7854h;
        }

        public final boolean b() {
            int i10 = this.f7854h;
            return i10 == FIRST_NONDEGRADE.f7854h || i10 == NEVER_GRADE.f7854h || i10 == FIX_NONDEGRADE.f7854h;
        }

        public final boolean c() {
            int i10 = this.f7854h;
            return i10 == DEGRADE_BYERROR.f7854h || i10 == DEGRADE_ONLY.f7854h || i10 == FIX_DEGRADE_BYERROR.f7854h || i10 == FIX_DEGRADE_ONLY.f7854h;
        }

        public final boolean d() {
            int i10 = this.f7854h;
            return i10 == DEGRADE_BYERROR.f7854h || i10 == FIX_DEGRADE_BYERROR.f7854h;
        }

        public final boolean e() {
            return this.f7854h == NEVER_GRADE.f7854h;
        }
    }

    /* compiled from: Request.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public enum c {
        HTTP(0),
        HTTPS(1);


        /* renamed from: c, reason: collision with root package name */
        private int f7858c;

        c(int i10) {
            this.f7858c = i10;
        }
    }

    private String a(String str) {
        byte[] h10 = h();
        if (h10 == null || h10.length == 0) {
            return str;
        }
        Map<String, String> f10 = f();
        HashMap<String, String> hashMap = dt.f7745e;
        if (hashMap != null) {
            if (f10 != null) {
                f10.putAll(hashMap);
            } else {
                f10 = hashMap;
            }
        }
        if (f10 == null) {
            return str;
        }
        String a10 = dw.a(f10);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(SymbolValues.QUESTION_EN_SYMBOL);
        stringBuffer.append(a10);
        return stringBuffer.toString();
    }

    public abstract String b();

    public final void b(int i10) {
        this.f7836m = i10;
    }

    public boolean b_() {
        return this.f7829c;
    }

    public final void c(int i10) {
        this.f7828b = i10;
    }

    public String d() {
        return "";
    }

    public final void d(String str) {
        this.f7830d = str;
    }

    public abstract Map<String, String> f();

    public abstract Map<String, String> g();

    public byte[] h() {
        return null;
    }

    public String i() {
        return "";
    }

    public final String k() {
        return a(b());
    }

    public final String l() {
        return a(a());
    }

    public final int m() {
        return this.f7835l;
    }

    public final Proxy n() {
        return this.f7837n;
    }

    public final a o() {
        return this.f7833g;
    }

    public final boolean p() {
        return this.f7827a;
    }

    public final void q() {
        this.f7827a = true;
    }

    public final boolean r() {
        return this.f7832f;
    }

    public final dt.a s() {
        return this.f7838o;
    }

    public final b t() {
        return this.f7834h;
    }

    public final int u() {
        return this.f7828b;
    }

    public final void v() {
        this.f7829c = false;
    }

    public final String w() {
        return this.f7830d;
    }

    public final boolean x() {
        return this.f7831e;
    }

    public final String y() {
        String str;
        try {
            str = d();
        } catch (Throwable th) {
            th = th;
            str = "";
        }
        try {
            if (TextUtils.isEmpty(str)) {
                if (this.f7827a) {
                    str = b(((du) this).j());
                } else {
                    str = a(g());
                }
            }
        } catch (Throwable th2) {
            th = th2;
            dc.a(th, "ht", "pnfr");
            return str;
        }
        return str;
    }

    private static String b(String str) {
        String str2;
        String str3 = "";
        try {
            if (!TextUtils.isEmpty(str)) {
                String[] split = str.split("&");
                if (split.length > 1) {
                    int length = split.length;
                    int i10 = 0;
                    String str4 = "";
                    while (true) {
                        if (i10 >= length) {
                            str2 = "";
                            break;
                        }
                        str2 = split[i10];
                        if (str2.contains("sdkversion")) {
                            str4 = str2;
                        }
                        if (str2.contains(InnoMain.INNO_KEY_PRODUCT)) {
                            break;
                        }
                        i10++;
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        String[] split2 = str2.split("=");
                        if (split2.length > 1) {
                            str3 = split2[1].trim();
                            if (!TextUtils.isEmpty(str4) && TextUtils.isEmpty(cr.a(str3))) {
                                String[] split3 = str4.split("=");
                                if (split3.length > 1) {
                                    cr.a(str3, split3[1].trim());
                                }
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            dc.a(th, "ht", "pnfp");
        }
        return str3;
    }

    public String a() {
        return b();
    }

    public final void a(int i10) {
        this.f7835l = i10;
    }

    public final void a(a aVar) {
        this.f7833g = aVar;
    }

    public final void a(c cVar) {
        this.f7832f = cVar == c.HTTPS;
    }

    public final void a(b bVar) {
        this.f7834h = bVar;
    }

    private static String a(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        try {
            if (map.containsKey("platinfo")) {
                return b(map.get("platinfo"));
            }
            return null;
        } catch (Throwable th) {
            dc.a(th, "ht", "pnfh");
            return null;
        }
    }
}
