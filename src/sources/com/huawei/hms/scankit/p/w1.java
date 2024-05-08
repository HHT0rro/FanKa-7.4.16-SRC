package com.huawei.hms.scankit.p;

import java.util.List;

/* compiled from: DecoderResult.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class w1 {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f31637a;

    /* renamed from: b, reason: collision with root package name */
    private int f31638b;

    /* renamed from: c, reason: collision with root package name */
    private final String f31639c;

    /* renamed from: d, reason: collision with root package name */
    private final List<byte[]> f31640d;

    /* renamed from: e, reason: collision with root package name */
    private final String f31641e;

    /* renamed from: f, reason: collision with root package name */
    private Integer f31642f;

    /* renamed from: g, reason: collision with root package name */
    private Integer f31643g;

    /* renamed from: h, reason: collision with root package name */
    private Object f31644h;

    /* renamed from: i, reason: collision with root package name */
    private final int f31645i;

    /* renamed from: j, reason: collision with root package name */
    private final int f31646j;

    public w1(byte[] bArr, String str, List<byte[]> list, String str2) {
        this(bArr, str, list, str2, -1, -1);
    }

    public int a() {
        return this.f31638b;
    }

    public void b(Integer num) {
        this.f31642f = num;
    }

    public byte[] c() {
        return this.f31637a;
    }

    public String d() {
        return this.f31639c;
    }

    public w1(byte[] bArr, String str, List<byte[]> list, String str2, int i10, int i11) {
        this.f31637a = bArr;
        this.f31638b = bArr == null ? 0 : bArr.length * 8;
        this.f31639c = str;
        this.f31640d = list;
        this.f31641e = str2;
        this.f31645i = i11;
        this.f31646j = i10;
    }

    public void a(int i10) {
        this.f31638b = i10;
    }

    public Object b() {
        return this.f31644h;
    }

    public void a(Integer num) {
        this.f31643g = num;
    }

    public void a(Object obj) {
        this.f31644h = obj;
    }
}
