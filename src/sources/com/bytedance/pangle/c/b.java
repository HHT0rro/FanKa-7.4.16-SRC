package com.bytedance.pangle.c;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    public static String f10638b = "request_finish";

    /* renamed from: c, reason: collision with root package name */
    public static String f10639c = "download_start";

    /* renamed from: d, reason: collision with root package name */
    public static String f10640d = "download_finish";

    /* renamed from: e, reason: collision with root package name */
    public static String f10641e = "install_start";

    /* renamed from: f, reason: collision with root package name */
    public static String f10642f = "install_finish";

    /* renamed from: g, reason: collision with root package name */
    public static String f10643g = "load_start";

    /* renamed from: h, reason: collision with root package name */
    public static String f10644h = "load_finish";

    /* renamed from: i, reason: collision with root package name */
    public static String f10645i = "rm_entry_finish";

    /* renamed from: j, reason: collision with root package name */
    private static volatile b f10646j;

    /* renamed from: a, reason: collision with root package name */
    public final List<com.bytedance.pangle.c.a> f10647a = new ArrayList();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class a {
        public static int A = 32007;
        public static int B = 32008;
        public static int C = 32999;
        public static int D = 40000;
        public static int E = 41000;
        public static int F = 42000;

        /* renamed from: a, reason: collision with root package name */
        public static int f10648a = 1;

        /* renamed from: b, reason: collision with root package name */
        public static int f10649b = 2;

        /* renamed from: c, reason: collision with root package name */
        public static int f10650c = -1;

        /* renamed from: d, reason: collision with root package name */
        public static int f10651d = -2;

        /* renamed from: e, reason: collision with root package name */
        public static int f10652e = 12000;

        /* renamed from: f, reason: collision with root package name */
        public static int f10653f = 12001;

        /* renamed from: g, reason: collision with root package name */
        public static int f10654g = 12002;

        /* renamed from: h, reason: collision with root package name */
        public static int f10655h = 12003;

        /* renamed from: i, reason: collision with root package name */
        public static int f10656i = 12004;

        /* renamed from: j, reason: collision with root package name */
        public static int f10657j = 20000;

        /* renamed from: k, reason: collision with root package name */
        public static int f10658k = 21000;

        /* renamed from: l, reason: collision with root package name */
        public static int f10659l = 21001;

        /* renamed from: m, reason: collision with root package name */
        public static int f10660m = 21002;

        /* renamed from: n, reason: collision with root package name */
        public static int f10661n = 22000;

        /* renamed from: o, reason: collision with root package name */
        public static int f10662o = 22001;

        /* renamed from: p, reason: collision with root package name */
        public static int f10663p = 22002;

        /* renamed from: q, reason: collision with root package name */
        public static int f10664q = 22999;

        /* renamed from: r, reason: collision with root package name */
        public static int f10665r = 30000;

        /* renamed from: s, reason: collision with root package name */
        public static int f10666s = 31000;

        /* renamed from: t, reason: collision with root package name */
        public static int f10667t = 32000;

        /* renamed from: u, reason: collision with root package name */
        public static int f10668u = 32001;

        /* renamed from: v, reason: collision with root package name */
        public static int f10669v = 32002;

        /* renamed from: w, reason: collision with root package name */
        public static int f10670w = 32003;

        /* renamed from: x, reason: collision with root package name */
        public static int f10671x = 32004;

        /* renamed from: y, reason: collision with root package name */
        public static int f10672y = 32005;

        /* renamed from: z, reason: collision with root package name */
        public static int f10673z = 32006;
    }

    private b() {
    }

    public static b a() {
        if (f10646j == null) {
            synchronized (b.class) {
                f10646j = new b();
            }
        }
        return f10646j;
    }

    public final void a(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        synchronized (this.f10647a) {
            Iterator<com.bytedance.pangle.c.a> iterator2 = this.f10647a.iterator2();
            while (iterator2.hasNext()) {
                try {
                    iterator2.next().a(str, jSONObject, jSONObject2, jSONObject3);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }
}
