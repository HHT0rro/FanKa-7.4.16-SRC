package com.google.android.gms.internal.clearcut;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class z3 implements Cloneable {

    /* renamed from: f, reason: collision with root package name */
    public static final a4 f24124f = new a4();

    /* renamed from: b, reason: collision with root package name */
    public boolean f24125b;

    /* renamed from: c, reason: collision with root package name */
    public int[] f24126c;

    /* renamed from: d, reason: collision with root package name */
    public a4[] f24127d;

    /* renamed from: e, reason: collision with root package name */
    public int f24128e;

    public z3() {
        this(10);
    }

    public z3(int i10) {
        this.f24125b = false;
        int i11 = i10 << 2;
        int i12 = 4;
        while (true) {
            if (i12 >= 32) {
                break;
            }
            int i13 = (1 << i12) - 12;
            if (i11 <= i13) {
                i11 = i13;
                break;
            }
            i12++;
        }
        int i14 = i11 / 4;
        this.f24126c = new int[i14];
        this.f24127d = new a4[i14];
        this.f24128e = 0;
    }

    public final boolean a() {
        return this.f24128e == 0;
    }

    public final int c() {
        return this.f24128e;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        int i10 = this.f24128e;
        z3 z3Var = new z3(i10);
        System.arraycopy((Object) this.f24126c, 0, (Object) z3Var.f24126c, 0, i10);
        for (int i11 = 0; i11 < i10; i11++) {
            a4[] a4VarArr = this.f24127d;
            if (a4VarArr[i11] != null) {
                z3Var.f24127d[i11] = (a4) a4VarArr[i11].clone();
            }
        }
        z3Var.f24128e = i10;
        return z3Var;
    }

    public final a4 d(int i10) {
        return this.f24127d[i10];
    }

    public final boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof z3)) {
            return false;
        }
        z3 z3Var = (z3) obj;
        int i10 = this.f24128e;
        if (i10 != z3Var.f24128e) {
            return false;
        }
        int[] iArr = this.f24126c;
        int[] iArr2 = z3Var.f24126c;
        int i11 = 0;
        while (true) {
            if (i11 >= i10) {
                z10 = true;
                break;
            }
            if (iArr[i11] != iArr2[i11]) {
                z10 = false;
                break;
            }
            i11++;
        }
        if (z10) {
            a4[] a4VarArr = this.f24127d;
            a4[] a4VarArr2 = z3Var.f24127d;
            int i12 = this.f24128e;
            int i13 = 0;
            while (true) {
                if (i13 >= i12) {
                    z11 = true;
                    break;
                }
                if (!a4VarArr[i13].equals(a4VarArr2[i13])) {
                    z11 = false;
                    break;
                }
                i13++;
            }
            if (z11) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i10 = 17;
        for (int i11 = 0; i11 < this.f24128e; i11++) {
            i10 = (((i10 * 31) + this.f24126c[i11]) * 31) + this.f24127d[i11].hashCode();
        }
        return i10;
    }
}
