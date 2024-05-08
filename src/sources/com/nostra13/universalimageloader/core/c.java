package com.nostra13.universalimageloader.core;

import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;

/* compiled from: DisplayImageOptions.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final int f37760a;

    /* renamed from: b, reason: collision with root package name */
    public final int f37761b;

    /* renamed from: c, reason: collision with root package name */
    public final int f37762c;

    /* renamed from: d, reason: collision with root package name */
    public final Drawable f37763d;

    /* renamed from: e, reason: collision with root package name */
    public final Drawable f37764e;

    /* renamed from: f, reason: collision with root package name */
    public final Drawable f37765f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f37766g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f37767h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f37768i;

    /* renamed from: j, reason: collision with root package name */
    public final ImageScaleType f37769j;

    /* renamed from: k, reason: collision with root package name */
    public final BitmapFactory.Options f37770k;

    /* renamed from: l, reason: collision with root package name */
    public final int f37771l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f37772m;

    /* renamed from: n, reason: collision with root package name */
    public final Object f37773n;

    /* renamed from: o, reason: collision with root package name */
    public final ob.a f37774o;

    /* renamed from: p, reason: collision with root package name */
    public final ob.a f37775p;

    /* renamed from: q, reason: collision with root package name */
    public final lb.a f37776q;

    /* renamed from: r, reason: collision with root package name */
    public final Handler f37777r;

    /* renamed from: s, reason: collision with root package name */
    public final boolean f37778s;

    /* compiled from: DisplayImageOptions.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f37779a = 0;

        /* renamed from: b, reason: collision with root package name */
        public int f37780b = 0;

        /* renamed from: c, reason: collision with root package name */
        public int f37781c = 0;

        /* renamed from: d, reason: collision with root package name */
        public Drawable f37782d = null;

        /* renamed from: e, reason: collision with root package name */
        public Drawable f37783e = null;

        /* renamed from: f, reason: collision with root package name */
        public Drawable f37784f = null;

        /* renamed from: g, reason: collision with root package name */
        public boolean f37785g = false;

        /* renamed from: h, reason: collision with root package name */
        public boolean f37786h = false;

        /* renamed from: i, reason: collision with root package name */
        public boolean f37787i = false;

        /* renamed from: j, reason: collision with root package name */
        public ImageScaleType f37788j = ImageScaleType.IN_SAMPLE_POWER_OF_2;

        /* renamed from: k, reason: collision with root package name */
        public BitmapFactory.Options f37789k = new BitmapFactory.Options();

        /* renamed from: l, reason: collision with root package name */
        public int f37790l = 0;

        /* renamed from: m, reason: collision with root package name */
        public boolean f37791m = false;

        /* renamed from: n, reason: collision with root package name */
        public Object f37792n = null;

        /* renamed from: o, reason: collision with root package name */
        public ob.a f37793o = null;

        /* renamed from: p, reason: collision with root package name */
        public ob.a f37794p = null;

        /* renamed from: q, reason: collision with root package name */
        public lb.a f37795q = com.nostra13.universalimageloader.core.a.a();

        /* renamed from: r, reason: collision with root package name */
        public Handler f37796r = null;

        /* renamed from: s, reason: collision with root package name */
        public boolean f37797s = false;

        public b() {
            BitmapFactory.Options options = this.f37789k;
            options.inPurgeable = true;
            options.inInputShareable = true;
        }

        public c t() {
            return new c(this);
        }

        public b u(boolean z10) {
            this.f37786h = z10;
            return this;
        }

        public b v(boolean z10) {
            this.f37787i = z10;
            return this;
        }

        public b w(c cVar) {
            this.f37779a = cVar.f37760a;
            this.f37780b = cVar.f37761b;
            this.f37781c = cVar.f37762c;
            this.f37782d = cVar.f37763d;
            this.f37783e = cVar.f37764e;
            this.f37784f = cVar.f37765f;
            this.f37785g = cVar.f37766g;
            this.f37786h = cVar.f37767h;
            this.f37787i = cVar.f37768i;
            this.f37788j = cVar.f37769j;
            this.f37789k = cVar.f37770k;
            this.f37790l = cVar.f37771l;
            this.f37791m = cVar.f37772m;
            this.f37792n = cVar.f37773n;
            this.f37793o = cVar.f37774o;
            this.f37794p = cVar.f37775p;
            this.f37795q = cVar.f37776q;
            this.f37796r = cVar.f37777r;
            this.f37797s = cVar.f37778s;
            return this;
        }

        public b x(ImageScaleType imageScaleType) {
            this.f37788j = imageScaleType;
            return this;
        }

        public b y(boolean z10) {
            this.f37797s = z10;
            return this;
        }
    }

    public static c t() {
        return new b().t();
    }

    public Drawable A(Resources resources) {
        int i10 = this.f37762c;
        return i10 != 0 ? resources.getDrawable(i10) : this.f37765f;
    }

    public Drawable B(Resources resources) {
        int i10 = this.f37760a;
        return i10 != 0 ? resources.getDrawable(i10) : this.f37763d;
    }

    public ImageScaleType C() {
        return this.f37769j;
    }

    public ob.a D() {
        return this.f37775p;
    }

    public ob.a E() {
        return this.f37774o;
    }

    public boolean F() {
        return this.f37767h;
    }

    public boolean G() {
        return this.f37768i;
    }

    public boolean H() {
        return this.f37772m;
    }

    public boolean I() {
        return this.f37766g;
    }

    public boolean J() {
        return this.f37778s;
    }

    public boolean K() {
        return this.f37771l > 0;
    }

    public boolean L() {
        return this.f37775p != null;
    }

    public boolean M() {
        return this.f37774o != null;
    }

    public boolean N() {
        return (this.f37764e == null && this.f37761b == 0) ? false : true;
    }

    public boolean O() {
        return (this.f37765f == null && this.f37762c == 0) ? false : true;
    }

    public boolean P() {
        return (this.f37763d == null && this.f37760a == 0) ? false : true;
    }

    public BitmapFactory.Options u() {
        return this.f37770k;
    }

    public int v() {
        return this.f37771l;
    }

    public lb.a w() {
        return this.f37776q;
    }

    public Object x() {
        return this.f37773n;
    }

    public Handler y() {
        return this.f37777r;
    }

    public Drawable z(Resources resources) {
        int i10 = this.f37761b;
        return i10 != 0 ? resources.getDrawable(i10) : this.f37764e;
    }

    public c(b bVar) {
        this.f37760a = bVar.f37779a;
        this.f37761b = bVar.f37780b;
        this.f37762c = bVar.f37781c;
        this.f37763d = bVar.f37782d;
        this.f37764e = bVar.f37783e;
        this.f37765f = bVar.f37784f;
        this.f37766g = bVar.f37785g;
        this.f37767h = bVar.f37786h;
        this.f37768i = bVar.f37787i;
        this.f37769j = bVar.f37788j;
        this.f37770k = bVar.f37789k;
        this.f37771l = bVar.f37790l;
        this.f37772m = bVar.f37791m;
        this.f37773n = bVar.f37792n;
        this.f37774o = bVar.f37793o;
        this.f37775p = bVar.f37794p;
        this.f37776q = bVar.f37795q;
        this.f37777r = bVar.f37796r;
        this.f37778s = bVar.f37797s;
    }
}
