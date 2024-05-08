package com.xiaomi.push;

import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class v4 implements Cloneable {

    /* renamed from: i, reason: collision with root package name */
    public static final String f48437i = i.f47503b;

    /* renamed from: j, reason: collision with root package name */
    public static String f48438j;

    /* renamed from: b, reason: collision with root package name */
    public String f48439b;

    /* renamed from: c, reason: collision with root package name */
    public String f48440c;

    /* renamed from: d, reason: collision with root package name */
    public int f48441d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f48442e = u4.f48382s;

    /* renamed from: f, reason: collision with root package name */
    public boolean f48443f = true;

    /* renamed from: g, reason: collision with root package name */
    public String f48444g;

    /* renamed from: h, reason: collision with root package name */
    public y4 f48445h;

    public v4(Map<String, Integer> map, int i10, String str, y4 y4Var) {
        e(map, i10, str, y4Var);
    }

    public static final String c() {
        String str = f48438j;
        return str != null ? str : e.c() ? "sandbox.xmpush.xiaomi.com" : e.d() ? f48437i : "app.chat.xiaomi.net";
    }

    public static final void d(String str) {
        f48438j = str;
    }

    public int a() {
        return this.f48441d;
    }

    public final void e(Map<String, Integer> map, int i10, String str, y4 y4Var) {
        this.f48441d = i10;
        this.f48439b = str;
        this.f48445h = y4Var;
    }

    public void g(boolean z10) {
        this.f48442e = z10;
    }

    public boolean h() {
        return this.f48442e;
    }

    public byte[] i() {
        throw null;
    }

    public String j() {
        return this.f48444g;
    }

    public void k(String str) {
        this.f48444g = str;
    }

    public String l() {
        if (this.f48440c == null) {
            this.f48440c = c();
        }
        return this.f48440c;
    }

    public void m(String str) {
        this.f48440c = str;
    }
}
