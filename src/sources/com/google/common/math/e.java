package com.google.common.math;

import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.google.common.base.o;

/* compiled from: LinearTransformation.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class e {

    /* compiled from: LinearTransformation.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final double f26695a;

        /* renamed from: b, reason: collision with root package name */
        public final double f26696b;

        public e a(double d10) {
            o.d(!Double.isNaN(d10));
            if (com.google.common.math.c.c(d10)) {
                return new d(d10, this.f26696b - (this.f26695a * d10));
            }
            return new C0239e(this.f26695a);
        }

        public b(double d10, double d11) {
            this.f26695a = d10;
            this.f26696b = d11;
        }
    }

    /* compiled from: LinearTransformation.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class c extends e {

        /* renamed from: a, reason: collision with root package name */
        public static final c f26697a = new c();

        public String toString() {
            return "NaN";
        }
    }

    /* compiled from: LinearTransformation.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class d extends e {

        /* renamed from: a, reason: collision with root package name */
        public final double f26698a;

        /* renamed from: b, reason: collision with root package name */
        public final double f26699b;

        /* renamed from: c, reason: collision with root package name */
        public e f26700c = null;

        public d(double d10, double d11) {
            this.f26698a = d10;
            this.f26699b = d11;
        }

        public String toString() {
            return String.format("y = %g * x + %g", Double.valueOf(this.f26698a), Double.valueOf(this.f26699b));
        }
    }

    /* compiled from: LinearTransformation.java */
    /* renamed from: com.google.common.math.e$e, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class C0239e extends e {

        /* renamed from: a, reason: collision with root package name */
        public final double f26701a;

        /* renamed from: b, reason: collision with root package name */
        public e f26702b = null;

        public C0239e(double d10) {
            this.f26701a = d10;
        }

        public String toString() {
            return String.format("x = %g", Double.valueOf(this.f26701a));
        }
    }

    public static e a() {
        return c.f26697a;
    }

    public static e b(double d10) {
        o.d(com.google.common.math.c.c(d10));
        return new d(ShadowDrawableWrapper.COS_45, d10);
    }

    public static b c(double d10, double d11) {
        o.d(com.google.common.math.c.c(d10) && com.google.common.math.c.c(d11));
        return new b(d10, d11);
    }

    public static e d(double d10) {
        o.d(com.google.common.math.c.c(d10));
        return new C0239e(d10);
    }
}
