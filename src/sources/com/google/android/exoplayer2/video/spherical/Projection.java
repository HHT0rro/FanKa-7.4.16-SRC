package com.google.android.exoplayer2.video.spherical;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class Projection {

    /* renamed from: a, reason: collision with root package name */
    public final a f23072a;

    /* renamed from: b, reason: collision with root package name */
    public final a f23073b;

    /* renamed from: c, reason: collision with root package name */
    public final int f23074c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f23075d;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class SubMesh {

        /* renamed from: a, reason: collision with root package name */
        public final int f23076a;

        /* renamed from: b, reason: collision with root package name */
        public final int f23077b;

        /* renamed from: c, reason: collision with root package name */
        public final float[] f23078c;

        /* renamed from: d, reason: collision with root package name */
        public final float[] f23079d;

        public SubMesh(int i10, float[] fArr, float[] fArr2, int i11) {
            this.f23076a = i10;
            com.google.android.exoplayer2.util.a.a(((long) fArr.length) * 2 == ((long) fArr2.length) * 3);
            this.f23078c = fArr;
            this.f23079d = fArr2;
            this.f23077b = i11;
        }

        public int a() {
            return this.f23078c.length / 3;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final SubMesh[] f23080a;

        public a(SubMesh... subMeshArr) {
            this.f23080a = subMeshArr;
        }

        public SubMesh a(int i10) {
            return this.f23080a[i10];
        }

        public int b() {
            return this.f23080a.length;
        }
    }

    public Projection(a aVar, int i10) {
        this(aVar, aVar, i10);
    }

    public static Projection a(float f10, int i10, int i11, float f11, float f12, int i12) {
        int i13;
        float f13;
        int i14;
        int i15;
        int i16;
        float[] fArr;
        int i17 = i10;
        int i18 = i11;
        com.google.android.exoplayer2.util.a.a(f10 > 0.0f);
        com.google.android.exoplayer2.util.a.a(i17 >= 1);
        com.google.android.exoplayer2.util.a.a(i18 >= 1);
        com.google.android.exoplayer2.util.a.a(f11 > 0.0f && f11 <= 180.0f);
        com.google.android.exoplayer2.util.a.a(f12 > 0.0f && f12 <= 360.0f);
        float radians = (float) Math.toRadians(f11);
        float radians2 = (float) Math.toRadians(f12);
        float f14 = radians / i17;
        float f15 = radians2 / i18;
        int i19 = i18 + 1;
        int i20 = ((i19 * 2) + 2) * i17;
        float[] fArr2 = new float[i20 * 3];
        float[] fArr3 = new float[i20 * 2];
        int i21 = 0;
        int i22 = 0;
        int i23 = 0;
        while (i21 < i17) {
            float f16 = radians / 2.0f;
            float f17 = (i21 * f14) - f16;
            int i24 = i21 + 1;
            float f18 = (i24 * f14) - f16;
            int i25 = 0;
            while (i25 < i19) {
                float f19 = f17;
                int i26 = i24;
                int i27 = 0;
                while (i27 < 2) {
                    if (i27 == 0) {
                        f13 = f19;
                        i13 = i19;
                    } else {
                        i13 = i19;
                        f13 = f18;
                    }
                    float f20 = i25 * f15;
                    float f21 = f15;
                    int i28 = i22 + 1;
                    int i29 = i25;
                    double d10 = f10;
                    float f22 = f14;
                    int i30 = i27;
                    double d11 = (f20 + 3.1415927f) - (radians2 / 2.0f);
                    double d12 = f13;
                    float[] fArr4 = fArr3;
                    float f23 = f18;
                    fArr2[i22] = -((float) (Math.sin(d11) * d10 * Math.cos(d12)));
                    int i31 = i28 + 1;
                    int i32 = i21;
                    fArr2[i28] = (float) (d10 * Math.sin(d12));
                    int i33 = i31 + 1;
                    fArr2[i31] = (float) (d10 * Math.cos(d11) * Math.cos(d12));
                    int i34 = i23 + 1;
                    fArr4[i23] = f20 / radians2;
                    int i35 = i34 + 1;
                    fArr4[i34] = ((i32 + i30) * f22) / radians;
                    if (i29 == 0 && i30 == 0) {
                        i14 = i11;
                        i15 = i29;
                        i16 = i30;
                    } else {
                        i14 = i11;
                        i15 = i29;
                        i16 = i30;
                        if (i15 != i14 || i16 != 1) {
                            fArr = fArr4;
                            i23 = i35;
                            i22 = i33;
                            i27 = i16 + 1;
                            i18 = i14;
                            i25 = i15;
                            fArr3 = fArr;
                            i21 = i32;
                            i19 = i13;
                            f15 = f21;
                            f14 = f22;
                            f18 = f23;
                        }
                    }
                    System.arraycopy((Object) fArr2, i33 - 3, (Object) fArr2, i33, 3);
                    i33 += 3;
                    fArr = fArr4;
                    System.arraycopy((Object) fArr, i35 - 2, (Object) fArr, i35, 2);
                    i35 += 2;
                    i23 = i35;
                    i22 = i33;
                    i27 = i16 + 1;
                    i18 = i14;
                    i25 = i15;
                    fArr3 = fArr;
                    i21 = i32;
                    i19 = i13;
                    f15 = f21;
                    f14 = f22;
                    f18 = f23;
                }
                float f24 = f14;
                int i36 = i25;
                int i37 = i18;
                int i38 = i36 + 1;
                f17 = f19;
                i24 = i26;
                i19 = i19;
                f15 = f15;
                f14 = f24;
                f18 = f18;
                i18 = i37;
                i25 = i38;
            }
            i17 = i10;
            i21 = i24;
        }
        return new Projection(new a(new SubMesh(0, fArr2, fArr3, 1)), i12);
    }

    public static Projection b(int i10) {
        return a(50.0f, 36, 72, 180.0f, 360.0f, i10);
    }

    public Projection(a aVar, a aVar2, int i10) {
        this.f23072a = aVar;
        this.f23073b = aVar2;
        this.f23074c = i10;
        this.f23075d = aVar == aVar2;
    }
}
