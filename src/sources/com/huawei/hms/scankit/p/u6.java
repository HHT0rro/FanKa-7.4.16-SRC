package com.huawei.hms.scankit.p;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: ResultPoint.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class u6 implements Parcelable {
    public static final Parcelable.Creator<u6> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private final float f31592a;

    /* renamed from: b, reason: collision with root package name */
    private final float f31593b;

    /* renamed from: c, reason: collision with root package name */
    private int f31594c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f31595d;

    /* compiled from: ResultPoint.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class a implements Parcelable.Creator<u6> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public u6 createFromParcel(Parcel parcel) {
            return new u6(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public u6[] newArray(int i10) {
            return new u6[i10];
        }
    }

    public u6(float f10, float f11, int i10) {
        this.f31595d = false;
        this.f31592a = f10;
        this.f31593b = f11;
        this.f31594c = i10;
    }

    private static int[] a(float f10, float f11, float f12) {
        int i10;
        int i11;
        int i12;
        if (f10 < f11 || f10 < f12) {
            if (f12 >= f10 && f12 >= f11) {
                i10 = 1;
                if (f10 > f11) {
                    i11 = 0;
                    i12 = 2;
                } else {
                    i11 = 2;
                }
            } else if (f10 > f10) {
                i10 = 2;
                i11 = 0;
                i12 = 1;
            } else {
                i10 = 2;
                i11 = 1;
            }
            i12 = 0;
        } else if (f11 > f12) {
            i10 = 0;
            i11 = 2;
            i12 = 1;
        } else {
            i10 = 0;
            i11 = 1;
            i12 = 2;
        }
        return new int[]{i10, i11, i12};
    }

    public int a() {
        return this.f31594c;
    }

    public final float b() {
        return this.f31592a;
    }

    public final float c() {
        return this.f31593b;
    }

    public boolean d() {
        return this.f31595d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof u6)) {
            return false;
        }
        u6 u6Var = (u6) obj;
        return ((double) Math.abs(this.f31592a - u6Var.f31592a)) < 1.0E-4d && ((double) Math.abs(this.f31593b - u6Var.f31593b)) < 1.0E-4d;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.f31592a) * 31) + Float.floatToIntBits(this.f31593b);
    }

    public final String toString() {
        return "(" + this.f31592a + ',' + this.f31593b + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeFloat(this.f31592a);
        parcel.writeFloat(this.f31593b);
    }

    public static void a(u6[] u6VarArr) {
        float a10 = a(u6VarArr[0], u6VarArr[1]);
        float a11 = a(u6VarArr[1], u6VarArr[2]);
        float a12 = a(u6VarArr[0], u6VarArr[2]);
        int[] a13 = a(a11, a10, a12);
        int i10 = a13[0];
        int i11 = a13[1];
        int i12 = a13[2];
        u6 u6Var = u6VarArr[i10];
        u6 u6Var2 = u6VarArr[i11];
        u6 u6Var3 = u6VarArr[i12];
        float[] fArr = {a11, a12, a10};
        if (r3.f31455j % 2 == 0 && fArr[i11] / fArr[i10] < 1.1d) {
            u6Var = u6VarArr[i10];
            u6Var2 = u6VarArr[i11];
            u6Var3 = u6VarArr[i12];
        }
        if (a(u6Var2, u6Var, u6Var3) < 0.0f) {
            u6 u6Var4 = u6Var3;
            u6Var3 = u6Var2;
            u6Var2 = u6Var4;
        }
        u6VarArr[0] = u6Var2;
        u6VarArr[1] = u6Var;
        u6VarArr[2] = u6Var3;
    }

    public u6(float f10, float f11) {
        this.f31594c = 0;
        this.f31595d = false;
        this.f31592a = f10;
        this.f31593b = f11;
    }

    public u6(float f10, float f11, boolean z10) {
        this.f31594c = 0;
        this.f31592a = f10;
        this.f31593b = f11;
        this.f31595d = z10;
    }

    public u6(Parcel parcel) {
        this.f31594c = 0;
        this.f31595d = false;
        this.f31592a = parcel.readFloat();
        this.f31593b = parcel.readFloat();
    }

    public static float a(u6 u6Var, u6 u6Var2) {
        return s4.a(u6Var.f31592a, u6Var.f31593b, u6Var2.f31592a, u6Var2.f31593b);
    }

    private static float a(u6 u6Var, u6 u6Var2, u6 u6Var3) {
        float f10 = u6Var2.f31592a;
        float f11 = u6Var2.f31593b;
        return ((u6Var3.f31592a - f10) * (u6Var.f31593b - f11)) - ((u6Var3.f31593b - f11) * (u6Var.f31592a - f10));
    }
}
