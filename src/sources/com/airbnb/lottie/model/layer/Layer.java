package com.airbnb.lottie.model.layer;

import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.content.Mask;
import i.b;
import i.j;
import i.k;
import i.l;
import java.util.List;
import java.util.Locale;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class Layer {

    /* renamed from: a, reason: collision with root package name */
    public final List<ContentModel> f2036a;

    /* renamed from: b, reason: collision with root package name */
    public final LottieComposition f2037b;

    /* renamed from: c, reason: collision with root package name */
    public final String f2038c;

    /* renamed from: d, reason: collision with root package name */
    public final long f2039d;

    /* renamed from: e, reason: collision with root package name */
    public final LayerType f2040e;

    /* renamed from: f, reason: collision with root package name */
    public final long f2041f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public final String f2042g;

    /* renamed from: h, reason: collision with root package name */
    public final List<Mask> f2043h;

    /* renamed from: i, reason: collision with root package name */
    public final l f2044i;

    /* renamed from: j, reason: collision with root package name */
    public final int f2045j;

    /* renamed from: k, reason: collision with root package name */
    public final int f2046k;

    /* renamed from: l, reason: collision with root package name */
    public final int f2047l;

    /* renamed from: m, reason: collision with root package name */
    public final float f2048m;

    /* renamed from: n, reason: collision with root package name */
    public final float f2049n;

    /* renamed from: o, reason: collision with root package name */
    public final float f2050o;

    /* renamed from: p, reason: collision with root package name */
    public final float f2051p;

    /* renamed from: q, reason: collision with root package name */
    @Nullable
    public final j f2052q;

    /* renamed from: r, reason: collision with root package name */
    @Nullable
    public final k f2053r;

    /* renamed from: s, reason: collision with root package name */
    @Nullable
    public final b f2054s;

    /* renamed from: t, reason: collision with root package name */
    public final List<o.a<Float>> f2055t;

    /* renamed from: u, reason: collision with root package name */
    public final MatteType f2056u;

    /* renamed from: v, reason: collision with root package name */
    public final boolean f2057v;

    /* renamed from: w, reason: collision with root package name */
    @Nullable
    public final j.a f2058w;

    /* renamed from: x, reason: collision with root package name */
    @Nullable
    public final m.j f2059x;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public enum LayerType {
        PRE_COMP,
        SOLID,
        IMAGE,
        NULL,
        SHAPE,
        TEXT,
        UNKNOWN
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public enum MatteType {
        NONE,
        ADD,
        INVERT,
        LUMA,
        LUMA_INVERTED,
        UNKNOWN
    }

    public Layer(List<ContentModel> list, LottieComposition lottieComposition, String str, long j10, LayerType layerType, long j11, @Nullable String str2, List<Mask> list2, l lVar, int i10, int i11, int i12, float f10, float f11, float f12, float f13, @Nullable j jVar, @Nullable k kVar, List<o.a<Float>> list3, MatteType matteType, @Nullable b bVar, boolean z10, @Nullable j.a aVar, @Nullable m.j jVar2) {
        this.f2036a = list;
        this.f2037b = lottieComposition;
        this.f2038c = str;
        this.f2039d = j10;
        this.f2040e = layerType;
        this.f2041f = j11;
        this.f2042g = str2;
        this.f2043h = list2;
        this.f2044i = lVar;
        this.f2045j = i10;
        this.f2046k = i11;
        this.f2047l = i12;
        this.f2048m = f10;
        this.f2049n = f11;
        this.f2050o = f12;
        this.f2051p = f13;
        this.f2052q = jVar;
        this.f2053r = kVar;
        this.f2055t = list3;
        this.f2056u = matteType;
        this.f2054s = bVar;
        this.f2057v = z10;
        this.f2058w = aVar;
        this.f2059x = jVar2;
    }

    @Nullable
    public j.a a() {
        return this.f2058w;
    }

    public LottieComposition b() {
        return this.f2037b;
    }

    @Nullable
    public m.j c() {
        return this.f2059x;
    }

    public long d() {
        return this.f2039d;
    }

    public List<o.a<Float>> e() {
        return this.f2055t;
    }

    public LayerType f() {
        return this.f2040e;
    }

    public List<Mask> g() {
        return this.f2043h;
    }

    public MatteType h() {
        return this.f2056u;
    }

    public String i() {
        return this.f2038c;
    }

    public long j() {
        return this.f2041f;
    }

    public float k() {
        return this.f2051p;
    }

    public float l() {
        return this.f2050o;
    }

    @Nullable
    public String m() {
        return this.f2042g;
    }

    public List<ContentModel> n() {
        return this.f2036a;
    }

    public int o() {
        return this.f2047l;
    }

    public int p() {
        return this.f2046k;
    }

    public int q() {
        return this.f2045j;
    }

    public float r() {
        return this.f2049n / this.f2037b.e();
    }

    @Nullable
    public j s() {
        return this.f2052q;
    }

    @Nullable
    public k t() {
        return this.f2053r;
    }

    public String toString() {
        return y("");
    }

    @Nullable
    public b u() {
        return this.f2054s;
    }

    public float v() {
        return this.f2048m;
    }

    public l w() {
        return this.f2044i;
    }

    public boolean x() {
        return this.f2057v;
    }

    public String y(String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(i());
        sb2.append("\n");
        Layer t2 = this.f2037b.t(j());
        if (t2 != null) {
            sb2.append("\t\tParents: ");
            sb2.append(t2.i());
            Layer t10 = this.f2037b.t(t2.j());
            while (t10 != null) {
                sb2.append("->");
                sb2.append(t10.i());
                t10 = this.f2037b.t(t10.j());
            }
            sb2.append(str);
            sb2.append("\n");
        }
        if (!g().isEmpty()) {
            sb2.append(str);
            sb2.append("\tMasks: ");
            sb2.append(g().size());
            sb2.append("\n");
        }
        if (q() != 0 && p() != 0) {
            sb2.append(str);
            sb2.append("\tBackground: ");
            sb2.append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(q()), Integer.valueOf(p()), Integer.valueOf(o())));
        }
        if (!this.f2036a.isEmpty()) {
            sb2.append(str);
            sb2.append("\tShapes:\n");
            for (ContentModel contentModel : this.f2036a) {
                sb2.append(str);
                sb2.append("\t\t");
                sb2.append((Object) contentModel);
                sb2.append("\n");
            }
        }
        return sb2.toString();
    }
}
