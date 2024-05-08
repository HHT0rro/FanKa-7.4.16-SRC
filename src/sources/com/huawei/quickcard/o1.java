package com.huawei.quickcard;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class o1 {

    /* renamed from: a, reason: collision with root package name */
    public final float f34141a;

    /* renamed from: b, reason: collision with root package name */
    public final n1 f34142b;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f34143a;

        static {
            int[] iArr = new int[n1.values().length];
            f34143a = iArr;
            try {
                iArr[n1.DP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f34143a[n1.PX.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f34143a[n1.PERCENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public o1(float f10, n1 n1Var) {
        this.f34141a = f10;
        this.f34142b = n1Var;
    }

    public static o1 a(String str) {
        if (str == null) {
            return null;
        }
        if (str.endsWith("%")) {
            return new o1(Float.parseFloat(str.substring(0, str.length() - 1)), n1.PERCENT);
        }
        if (str.endsWith("px")) {
            return new o1(Float.parseFloat(str), n1.PX);
        }
        return new o1(Float.parseFloat(str), n1.DP);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof o1)) {
            return false;
        }
        o1 o1Var = (o1) obj;
        return this.f34142b == o1Var.f34142b && Float.compare(this.f34141a, o1Var.f34141a) == 0;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.f34141a) + this.f34142b.a();
    }

    public String toString() {
        int i10 = a.f34143a[this.f34142b.ordinal()];
        if (i10 == 1 || i10 == 2) {
            return Float.toString(this.f34141a);
        }
        if (i10 == 3) {
            return this.f34141a + "%";
        }
        throw new IllegalStateException();
    }
}
