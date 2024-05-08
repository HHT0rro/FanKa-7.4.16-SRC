package com.huawei.hms.scankit.p;

import java.nio.charset.StandardCharsets;

/* compiled from: EncoderContext.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
final class y2 {

    /* renamed from: a, reason: collision with root package name */
    private final String f31748a;

    /* renamed from: b, reason: collision with root package name */
    private e7 f31749b;

    /* renamed from: c, reason: collision with root package name */
    private l2 f31750c;

    /* renamed from: d, reason: collision with root package name */
    private l2 f31751d;

    /* renamed from: e, reason: collision with root package name */
    private final StringBuilder f31752e;

    /* renamed from: f, reason: collision with root package name */
    public int f31753f;

    /* renamed from: g, reason: collision with root package name */
    private int f31754g;

    /* renamed from: h, reason: collision with root package name */
    private d7 f31755h;

    /* renamed from: i, reason: collision with root package name */
    private int f31756i;

    public y2(String str) {
        byte[] bytes = str.getBytes(StandardCharsets.ISO_8859_1);
        StringBuilder sb2 = new StringBuilder(bytes.length);
        int length = bytes.length;
        for (int i10 = 0; i10 < length; i10++) {
            char c4 = (char) (bytes[i10] & 255);
            if (c4 == '?' && str.charAt(i10) != '?') {
                try {
                    throw new IllegalArgumentException("Message contains characters outside ISO-8859-1 encoding.");
                } catch (Exception e2) {
                    throw e2;
                }
            }
            sb2.append(c4);
        }
        this.f31748a = sb2.toString();
        this.f31749b = e7.FORCE_NONE;
        this.f31752e = new StringBuilder(str.length());
        this.f31754g = -1;
    }

    private int h() {
        return this.f31748a.length() - this.f31756i;
    }

    public void a(e7 e7Var) {
        this.f31749b = e7Var;
    }

    public StringBuilder b() {
        return this.f31752e;
    }

    public char c() {
        return this.f31748a.charAt(this.f31753f);
    }

    public String d() {
        return this.f31748a;
    }

    public int e() {
        return this.f31754g;
    }

    public int f() {
        return h() - this.f31753f;
    }

    public d7 g() {
        return this.f31755h;
    }

    public boolean i() {
        return this.f31753f < h();
    }

    public void j() {
        this.f31754g = -1;
    }

    public void k() {
        this.f31755h = null;
    }

    public void l() {
        c(a());
    }

    public void a(l2 l2Var, l2 l2Var2) {
        this.f31750c = l2Var;
        this.f31751d = l2Var2;
    }

    public void b(int i10) {
        this.f31754g = i10;
    }

    public void c(int i10) {
        d7 d7Var = this.f31755h;
        if (d7Var == null || i10 > d7Var.a()) {
            this.f31755h = d7.a(i10, this.f31749b, this.f31750c, this.f31751d, true);
        }
    }

    public void a(int i10) {
        this.f31756i = i10;
    }

    public void a(String str) {
        this.f31752e.append(str);
    }

    public void a(char c4) {
        this.f31752e.append(c4);
    }

    public int a() {
        return this.f31752e.length();
    }
}
