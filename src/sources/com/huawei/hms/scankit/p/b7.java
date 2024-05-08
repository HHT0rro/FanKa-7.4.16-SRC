package com.huawei.hms.scankit.p;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;

/* compiled from: State.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
final class b7 {

    /* renamed from: e, reason: collision with root package name */
    public static final b7 f30758e = new b7(i7.f31127b, 0, 0, 0);

    /* renamed from: a, reason: collision with root package name */
    private final int f30759a;

    /* renamed from: b, reason: collision with root package name */
    private final i7 f30760b;

    /* renamed from: c, reason: collision with root package name */
    private final int f30761c;

    /* renamed from: d, reason: collision with root package name */
    private final int f30762d;

    private b7(i7 i7Var, int i10, int i11, int i12) {
        this.f30760b = i7Var;
        this.f30759a = i10;
        this.f30761c = i11;
        this.f30762d = i12;
    }

    public int a() {
        return this.f30761c;
    }

    public int b() {
        return this.f30762d;
    }

    public int c() {
        return this.f30759a;
    }

    public String toString() {
        try {
            String[] strArr = c4.f30798b;
            if (w7.a(strArr, this.f30759a)) {
                return String.format(Locale.ENGLISH, "%s bits=%d bytes=%d", strArr[this.f30759a], Integer.valueOf(this.f30762d), Integer.valueOf(this.f30761c));
            }
            throw new ArrayIndexOutOfBoundsException();
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw e2;
        }
    }

    public b7 a(int i10, int i11) {
        int i12 = this.f30762d;
        i7 i7Var = this.f30760b;
        int i13 = this.f30759a;
        if (i10 != i13) {
            int i14 = c4.f30799c[i13][i10];
            int i15 = 65535 & i14;
            int i16 = i14 >> 16;
            i7Var = i7Var.a(i15, i16);
            i12 += i16;
        }
        int i17 = i10 == 2 ? 4 : 5;
        return new b7(i7Var.a(i11, i17), i10, 0, i12 + i17);
    }

    public b7 b(int i10, int i11) {
        i7 i7Var = this.f30760b;
        int i12 = this.f30759a;
        int i13 = i12 == 2 ? 4 : 5;
        if (i12 >= 0) {
            int[][] iArr = c4.f30801e;
            if (i12 < iArr.length && i10 > 0 && i10 < iArr[i12].length) {
                i7Var = i7Var.a(iArr[i12][i10], i13);
            }
        }
        return new b7(i7Var.a(i11, 5), this.f30759a, 0, this.f30762d + i13 + 5);
    }

    public b7 a(int i10) {
        i7 i7Var = this.f30760b;
        int i11 = this.f30759a;
        int i12 = this.f30762d;
        if (i11 == 4 || i11 == 2) {
            int i13 = c4.f30799c[i11][0];
            int i14 = 65535 & i13;
            int i15 = i13 >> 16;
            i7Var = i7Var.a(i14, i15);
            i12 += i15;
            i11 = 0;
        }
        int i16 = this.f30761c;
        b7 b7Var = new b7(i7Var, i11, i16 + 1, i12 + ((i16 == 0 || i16 == 31) ? 18 : i16 == 62 ? 9 : 8));
        return b7Var.f30761c == 2078 ? b7Var.b(i10 + 1) : b7Var;
    }

    public b7 b(int i10) {
        int i11 = this.f30761c;
        return i11 == 0 ? this : new b7(this.f30760b.b(i10 - i11, i11), this.f30759a, 0, this.f30762d);
    }

    public boolean a(b7 b7Var) {
        int i10;
        int i11 = this.f30762d + (c4.f30799c[this.f30759a][b7Var.f30759a] >> 16);
        int i12 = b7Var.f30761c;
        if (i12 > 0 && ((i10 = this.f30761c) == 0 || i10 > i12)) {
            i11 += 10;
        }
        return i11 <= b7Var.f30762d;
    }

    public r a(byte[] bArr) {
        LinkedList linkedList = new LinkedList();
        for (i7 i7Var = b(bArr.length).f30760b; i7Var != null; i7Var = i7Var.a()) {
            linkedList.addFirst(i7Var);
        }
        r rVar = new r();
        Iterator<E> iterator2 = linkedList.iterator2();
        while (iterator2.hasNext()) {
            ((i7) iterator2.next()).a(rVar, bArr);
        }
        return rVar;
    }
}
