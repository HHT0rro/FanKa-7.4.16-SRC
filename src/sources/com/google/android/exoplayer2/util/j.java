package com.google.android.exoplayer2.util;

import java.util.NoSuchElementException;

/* compiled from: IntArrayQueue.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public int f22985a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f22986b = -1;

    /* renamed from: c, reason: collision with root package name */
    public int f22987c = 0;

    /* renamed from: d, reason: collision with root package name */
    public int[] f22988d = new int[16];

    /* renamed from: e, reason: collision with root package name */
    public int f22989e;

    public j() {
        this.f22989e = r0.length - 1;
    }

    public void a(int i10) {
        if (this.f22987c == this.f22988d.length) {
            c();
        }
        int i11 = (this.f22986b + 1) & this.f22989e;
        this.f22986b = i11;
        this.f22988d[i11] = i10;
        this.f22987c++;
    }

    public void b() {
        this.f22985a = 0;
        this.f22986b = -1;
        this.f22987c = 0;
    }

    public final void c() {
        int[] iArr = this.f22988d;
        int length = iArr.length << 1;
        if (length >= 0) {
            int[] iArr2 = new int[length];
            int length2 = iArr.length;
            int i10 = this.f22985a;
            int i11 = length2 - i10;
            System.arraycopy((Object) iArr, i10, (Object) iArr2, 0, i11);
            System.arraycopy((Object) this.f22988d, 0, (Object) iArr2, i11, i10);
            this.f22985a = 0;
            this.f22986b = this.f22987c - 1;
            this.f22988d = iArr2;
            this.f22989e = iArr2.length - 1;
            return;
        }
        throw new IllegalStateException();
    }

    public boolean d() {
        return this.f22987c == 0;
    }

    public int e() {
        int i10 = this.f22987c;
        if (i10 != 0) {
            int[] iArr = this.f22988d;
            int i11 = this.f22985a;
            int i12 = iArr[i11];
            this.f22985a = (i11 + 1) & this.f22989e;
            this.f22987c = i10 - 1;
            return i12;
        }
        throw new NoSuchElementException();
    }
}
