package com.bytedance.pangle.f.a;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
final class a {

    /* renamed from: a, reason: collision with root package name */
    public int f10748a;

    /* renamed from: b, reason: collision with root package name */
    public b f10749b;

    /* renamed from: c, reason: collision with root package name */
    public int[] f10750c;

    /* renamed from: i, reason: collision with root package name */
    private boolean f10756i;

    /* renamed from: k, reason: collision with root package name */
    private f f10758k;

    /* renamed from: j, reason: collision with root package name */
    private boolean f10757j = false;

    /* renamed from: l, reason: collision with root package name */
    private final c f10759l = new c();

    /* renamed from: d, reason: collision with root package name */
    public int f10751d = 0;

    /* renamed from: e, reason: collision with root package name */
    public int f10752e = 1;

    /* renamed from: f, reason: collision with root package name */
    public int f10753f = 2;

    /* renamed from: g, reason: collision with root package name */
    public int f10754g = 3;

    /* renamed from: h, reason: collision with root package name */
    public int f10755h = 4;

    public a() {
        c();
    }

    private int e(int i10) {
        if (this.f10748a == 2) {
            int i11 = i10 * 5;
            if (i11 < this.f10750c.length) {
                return i11;
            }
            throw new IndexOutOfBoundsException("Invalid attribute index (" + i10 + ").");
        }
        throw new IndexOutOfBoundsException("Current event is not START_TAG.");
    }

    public final void a() {
        if (this.f10757j) {
            this.f10757j = false;
            b bVar = this.f10749b;
            InputStream inputStream = bVar.f10762a;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused) {
                }
                bVar.a((InputStream) null);
            }
            this.f10758k = null;
            this.f10749b = null;
            c cVar = this.f10759l;
            cVar.f10765b = 0;
            cVar.f10766c = 0;
            c();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:106:0x0221, code lost:
    
        throw new java.io.IOException("Invalid chunk type (" + r1 + ").");
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0108, code lost:
    
        throw new java.io.IOException("Invalid resource ids size (" + r1 + ").");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int b() {
        /*
            Method dump skipped, instructions count: 562
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.f.a.a.b():int");
    }

    public final int c(int i10) {
        return this.f10750c[e(i10) + 4];
    }

    public final String d(int i10) {
        int e2 = e(i10);
        int[] iArr = this.f10750c;
        if (iArr[e2 + 3] != 3) {
            return "";
        }
        return this.f10758k.a(iArr[e2 + 2]);
    }

    private void c() {
        this.f10750c = null;
        this.f10748a = -1;
    }

    public final String a(int i10) {
        int i11 = this.f10750c[e(i10) + 1];
        return i11 == -1 ? "" : this.f10758k.a(i11);
    }

    public final int b(int i10) {
        return this.f10750c[e(i10) + 3];
    }
}
