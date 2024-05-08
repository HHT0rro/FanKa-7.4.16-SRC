package k6;

import android.text.Layout;
import androidx.annotation.Nullable;

/* compiled from: TtmlStyle.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public String f50711a;

    /* renamed from: b, reason: collision with root package name */
    public int f50712b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f50713c;

    /* renamed from: d, reason: collision with root package name */
    public int f50714d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f50715e;

    /* renamed from: k, reason: collision with root package name */
    public float f50721k;

    /* renamed from: l, reason: collision with root package name */
    @Nullable
    public String f50722l;

    /* renamed from: o, reason: collision with root package name */
    @Nullable
    public Layout.Alignment f50725o;

    /* renamed from: p, reason: collision with root package name */
    @Nullable
    public Layout.Alignment f50726p;

    /* renamed from: r, reason: collision with root package name */
    @Nullable
    public b f50728r;

    /* renamed from: f, reason: collision with root package name */
    public int f50716f = -1;

    /* renamed from: g, reason: collision with root package name */
    public int f50717g = -1;

    /* renamed from: h, reason: collision with root package name */
    public int f50718h = -1;

    /* renamed from: i, reason: collision with root package name */
    public int f50719i = -1;

    /* renamed from: j, reason: collision with root package name */
    public int f50720j = -1;

    /* renamed from: m, reason: collision with root package name */
    public int f50723m = -1;

    /* renamed from: n, reason: collision with root package name */
    public int f50724n = -1;

    /* renamed from: q, reason: collision with root package name */
    public int f50727q = -1;

    /* renamed from: s, reason: collision with root package name */
    public float f50729s = Float.MAX_VALUE;

    public g A(@Nullable String str) {
        this.f50722l = str;
        return this;
    }

    public g B(boolean z10) {
        this.f50719i = z10 ? 1 : 0;
        return this;
    }

    public g C(boolean z10) {
        this.f50716f = z10 ? 1 : 0;
        return this;
    }

    public g D(@Nullable Layout.Alignment alignment) {
        this.f50726p = alignment;
        return this;
    }

    public g E(int i10) {
        this.f50724n = i10;
        return this;
    }

    public g F(int i10) {
        this.f50723m = i10;
        return this;
    }

    public g G(float f10) {
        this.f50729s = f10;
        return this;
    }

    public g H(@Nullable Layout.Alignment alignment) {
        this.f50725o = alignment;
        return this;
    }

    public g I(boolean z10) {
        this.f50727q = z10 ? 1 : 0;
        return this;
    }

    public g J(@Nullable b bVar) {
        this.f50728r = bVar;
        return this;
    }

    public g K(boolean z10) {
        this.f50717g = z10 ? 1 : 0;
        return this;
    }

    public g a(@Nullable g gVar) {
        return r(gVar, true);
    }

    public int b() {
        if (this.f50715e) {
            return this.f50714d;
        }
        throw new IllegalStateException("Background color has not been defined.");
    }

    public int c() {
        if (this.f50713c) {
            return this.f50712b;
        }
        throw new IllegalStateException("Font color has not been defined.");
    }

    @Nullable
    public String d() {
        return this.f50711a;
    }

    public float e() {
        return this.f50721k;
    }

    public int f() {
        return this.f50720j;
    }

    @Nullable
    public String g() {
        return this.f50722l;
    }

    @Nullable
    public Layout.Alignment h() {
        return this.f50726p;
    }

    public int i() {
        return this.f50724n;
    }

    public int j() {
        return this.f50723m;
    }

    public float k() {
        return this.f50729s;
    }

    public int l() {
        int i10 = this.f50718h;
        if (i10 == -1 && this.f50719i == -1) {
            return -1;
        }
        return (i10 == 1 ? 1 : 0) | (this.f50719i == 1 ? 2 : 0);
    }

    @Nullable
    public Layout.Alignment m() {
        return this.f50725o;
    }

    public boolean n() {
        return this.f50727q == 1;
    }

    @Nullable
    public b o() {
        return this.f50728r;
    }

    public boolean p() {
        return this.f50715e;
    }

    public boolean q() {
        return this.f50713c;
    }

    public final g r(@Nullable g gVar, boolean z10) {
        int i10;
        Layout.Alignment alignment;
        Layout.Alignment alignment2;
        String str;
        if (gVar != null) {
            if (!this.f50713c && gVar.f50713c) {
                w(gVar.f50712b);
            }
            if (this.f50718h == -1) {
                this.f50718h = gVar.f50718h;
            }
            if (this.f50719i == -1) {
                this.f50719i = gVar.f50719i;
            }
            if (this.f50711a == null && (str = gVar.f50711a) != null) {
                this.f50711a = str;
            }
            if (this.f50716f == -1) {
                this.f50716f = gVar.f50716f;
            }
            if (this.f50717g == -1) {
                this.f50717g = gVar.f50717g;
            }
            if (this.f50724n == -1) {
                this.f50724n = gVar.f50724n;
            }
            if (this.f50725o == null && (alignment2 = gVar.f50725o) != null) {
                this.f50725o = alignment2;
            }
            if (this.f50726p == null && (alignment = gVar.f50726p) != null) {
                this.f50726p = alignment;
            }
            if (this.f50727q == -1) {
                this.f50727q = gVar.f50727q;
            }
            if (this.f50720j == -1) {
                this.f50720j = gVar.f50720j;
                this.f50721k = gVar.f50721k;
            }
            if (this.f50728r == null) {
                this.f50728r = gVar.f50728r;
            }
            if (this.f50729s == Float.MAX_VALUE) {
                this.f50729s = gVar.f50729s;
            }
            if (z10 && !this.f50715e && gVar.f50715e) {
                u(gVar.f50714d);
            }
            if (z10 && this.f50723m == -1 && (i10 = gVar.f50723m) != -1) {
                this.f50723m = i10;
            }
        }
        return this;
    }

    public boolean s() {
        return this.f50716f == 1;
    }

    public boolean t() {
        return this.f50717g == 1;
    }

    public g u(int i10) {
        this.f50714d = i10;
        this.f50715e = true;
        return this;
    }

    public g v(boolean z10) {
        this.f50718h = z10 ? 1 : 0;
        return this;
    }

    public g w(int i10) {
        this.f50712b = i10;
        this.f50713c = true;
        return this;
    }

    public g x(@Nullable String str) {
        this.f50711a = str;
        return this;
    }

    public g y(float f10) {
        this.f50721k = f10;
        return this;
    }

    public g z(int i10) {
        this.f50720j = i10;
        return this;
    }
}
