package com.cupidapp.live.liveshow.beauty.databeauty.opengl;

import java.nio.FloatBuffer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class Drawable2d {

    /* renamed from: i, reason: collision with root package name */
    public static final float[] f14843i;

    /* renamed from: j, reason: collision with root package name */
    public static final float[] f14844j;

    /* renamed from: k, reason: collision with root package name */
    public static final FloatBuffer f14845k;

    /* renamed from: l, reason: collision with root package name */
    public static final FloatBuffer f14846l;

    /* renamed from: m, reason: collision with root package name */
    public static final float[] f14847m;

    /* renamed from: n, reason: collision with root package name */
    public static final float[] f14848n;

    /* renamed from: o, reason: collision with root package name */
    public static final float[] f14849o;

    /* renamed from: p, reason: collision with root package name */
    public static final FloatBuffer f14850p;

    /* renamed from: q, reason: collision with root package name */
    public static final FloatBuffer f14851q;

    /* renamed from: r, reason: collision with root package name */
    public static final FloatBuffer f14852r;

    /* renamed from: s, reason: collision with root package name */
    public static final float[] f14853s;

    /* renamed from: t, reason: collision with root package name */
    public static final float[] f14854t;

    /* renamed from: u, reason: collision with root package name */
    public static final float[] f14855u;

    /* renamed from: v, reason: collision with root package name */
    public static final FloatBuffer f14856v;

    /* renamed from: w, reason: collision with root package name */
    public static final FloatBuffer f14857w;

    /* renamed from: x, reason: collision with root package name */
    public static final FloatBuffer f14858x;

    /* renamed from: a, reason: collision with root package name */
    public FloatBuffer f14859a;

    /* renamed from: b, reason: collision with root package name */
    public FloatBuffer f14860b;

    /* renamed from: c, reason: collision with root package name */
    public FloatBuffer f14861c;

    /* renamed from: d, reason: collision with root package name */
    public int f14862d;

    /* renamed from: e, reason: collision with root package name */
    public int f14863e;

    /* renamed from: f, reason: collision with root package name */
    public int f14864f;

    /* renamed from: g, reason: collision with root package name */
    public int f14865g;

    /* renamed from: h, reason: collision with root package name */
    public Prefab f14866h;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum Prefab {
        TRIANGLE,
        RECTANGLE,
        FULL_RECTANGLE
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14867a;

        static {
            int[] iArr = new int[Prefab.values().length];
            f14867a = iArr;
            try {
                iArr[Prefab.TRIANGLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14867a[Prefab.RECTANGLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f14867a[Prefab.FULL_RECTANGLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static {
        float[] fArr = {0.0f, 0.57735026f, -0.5f, -0.28867513f, 0.5f, -0.28867513f};
        f14843i = fArr;
        float[] fArr2 = {0.5f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
        f14844j = fArr2;
        f14845k = o2.a.c(fArr);
        f14846l = o2.a.c(fArr2);
        float[] fArr3 = {-0.5f, -0.5f, 0.5f, -0.5f, -0.5f, 0.5f, 0.5f, 0.5f};
        f14847m = fArr3;
        float[] fArr4 = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
        f14848n = fArr4;
        float[] fArr5 = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
        f14849o = fArr5;
        f14850p = o2.a.c(fArr3);
        f14851q = o2.a.c(fArr4);
        f14852r = o2.a.c(fArr5);
        float[] fArr6 = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
        f14853s = fArr6;
        float[] fArr7 = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
        f14854t = fArr7;
        float[] fArr8 = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
        f14855u = fArr8;
        f14856v = o2.a.c(fArr6);
        f14857w = o2.a.c(fArr7);
        f14858x = o2.a.c(fArr8);
    }

    public Drawable2d(Prefab prefab) {
        int i10 = a.f14867a[prefab.ordinal()];
        if (i10 == 1) {
            this.f14859a = f14845k;
            FloatBuffer floatBuffer = f14846l;
            this.f14860b = floatBuffer;
            this.f14861c = floatBuffer;
            this.f14863e = 2;
            this.f14864f = 2 * 4;
            this.f14862d = f14843i.length / 2;
        } else if (i10 == 2) {
            this.f14859a = f14850p;
            this.f14860b = f14851q;
            this.f14861c = f14852r;
            this.f14863e = 2;
            this.f14864f = 2 * 4;
            this.f14862d = f14847m.length / 2;
        } else if (i10 == 3) {
            this.f14859a = f14856v;
            this.f14860b = f14857w;
            this.f14861c = f14858x;
            this.f14863e = 2;
            this.f14864f = 2 * 4;
            this.f14862d = f14853s.length / 2;
        } else {
            throw new RuntimeException("Unknown shape " + ((Object) prefab));
        }
        this.f14865g = 8;
        this.f14866h = prefab;
    }

    public FloatBuffer a() {
        return this.f14861c;
    }

    public FloatBuffer b() {
        return this.f14860b;
    }

    public FloatBuffer c() {
        return this.f14859a;
    }

    public int d() {
        return this.f14862d;
    }

    public String toString() {
        if (this.f14866h == null) {
            return "[Drawable2d: ...]";
        }
        return "[Drawable2d: " + ((Object) this.f14866h) + "]";
    }
}
