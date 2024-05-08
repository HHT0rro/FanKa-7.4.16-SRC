package e;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.i0;
import com.airbnb.lottie.model.content.PolystarShape;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import f.a;
import java.util.List;

/* compiled from: PolystarContent.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class m implements l, a.b, j {

    /* renamed from: b, reason: collision with root package name */
    public final String f48793b;

    /* renamed from: c, reason: collision with root package name */
    public final LottieDrawable f48794c;

    /* renamed from: d, reason: collision with root package name */
    public final PolystarShape.Type f48795d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f48796e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f48797f;

    /* renamed from: g, reason: collision with root package name */
    public final f.a<?, Float> f48798g;

    /* renamed from: h, reason: collision with root package name */
    public final f.a<?, PointF> f48799h;

    /* renamed from: i, reason: collision with root package name */
    public final f.a<?, Float> f48800i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    public final f.a<?, Float> f48801j;

    /* renamed from: k, reason: collision with root package name */
    public final f.a<?, Float> f48802k;

    /* renamed from: l, reason: collision with root package name */
    @Nullable
    public final f.a<?, Float> f48803l;

    /* renamed from: m, reason: collision with root package name */
    public final f.a<?, Float> f48804m;

    /* renamed from: o, reason: collision with root package name */
    public boolean f48806o;

    /* renamed from: a, reason: collision with root package name */
    public final Path f48792a = new Path();

    /* renamed from: n, reason: collision with root package name */
    public final b f48805n = new b();

    /* compiled from: PolystarContent.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f48807a;

        static {
            int[] iArr = new int[PolystarShape.Type.values().length];
            f48807a = iArr;
            try {
                iArr[PolystarShape.Type.STAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f48807a[PolystarShape.Type.POLYGON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public m(LottieDrawable lottieDrawable, BaseLayer baseLayer, PolystarShape polystarShape) {
        this.f48794c = lottieDrawable;
        this.f48793b = polystarShape.c();
        PolystarShape.Type i10 = polystarShape.i();
        this.f48795d = i10;
        this.f48796e = polystarShape.j();
        this.f48797f = polystarShape.k();
        f.a<Float, Float> a10 = polystarShape.f().a();
        this.f48798g = a10;
        f.a<PointF, PointF> a11 = polystarShape.g().a();
        this.f48799h = a11;
        f.a<Float, Float> a12 = polystarShape.h().a();
        this.f48800i = a12;
        f.a<Float, Float> a13 = polystarShape.d().a();
        this.f48802k = a13;
        f.a<Float, Float> a14 = polystarShape.e().a();
        this.f48804m = a14;
        PolystarShape.Type type = PolystarShape.Type.STAR;
        if (i10 == type) {
            this.f48801j = polystarShape.a().a();
            this.f48803l = polystarShape.b().a();
        } else {
            this.f48801j = null;
            this.f48803l = null;
        }
        baseLayer.i(a10);
        baseLayer.i(a11);
        baseLayer.i(a12);
        baseLayer.i(a13);
        baseLayer.i(a14);
        if (i10 == type) {
            baseLayer.i(this.f48801j);
            baseLayer.i(this.f48803l);
        }
        a10.a(this);
        a11.a(this);
        a12.a(this);
        a13.a(this);
        a14.a(this);
        if (i10 == type) {
            this.f48801j.a(this);
            this.f48803l.a(this);
        }
    }

    @Override // h.d
    public <T> void a(T t2, @Nullable o.c<T> cVar) {
        f.a<?, Float> aVar;
        f.a<?, Float> aVar2;
        if (t2 == i0.f1934w) {
            this.f48798g.n(cVar);
            return;
        }
        if (t2 == i0.f1935x) {
            this.f48800i.n(cVar);
            return;
        }
        if (t2 == i0.f1925n) {
            this.f48799h.n(cVar);
            return;
        }
        if (t2 == i0.f1936y && (aVar2 = this.f48801j) != null) {
            aVar2.n(cVar);
            return;
        }
        if (t2 == i0.f1937z) {
            this.f48802k.n(cVar);
            return;
        }
        if (t2 == i0.A && (aVar = this.f48803l) != null) {
            aVar.n(cVar);
        } else if (t2 == i0.B) {
            this.f48804m.n(cVar);
        }
    }

    public final void c() {
        double d10;
        double d11;
        double d12;
        int i10;
        int floor = (int) Math.floor(this.f48798g.h().floatValue());
        double radians = Math.toRadians((this.f48800i == null ? ShadowDrawableWrapper.COS_45 : r2.h().floatValue()) - 90.0d);
        double d13 = floor;
        float floatValue = this.f48804m.h().floatValue() / 100.0f;
        float floatValue2 = this.f48802k.h().floatValue();
        double d14 = floatValue2;
        float cos = (float) (Math.cos(radians) * d14);
        float sin = (float) (Math.sin(radians) * d14);
        this.f48792a.moveTo(cos, sin);
        double d15 = (float) (6.283185307179586d / d13);
        double d16 = radians + d15;
        double ceil = Math.ceil(d13);
        int i11 = 0;
        while (i11 < ceil) {
            float cos2 = (float) (Math.cos(d16) * d14);
            double d17 = ceil;
            float sin2 = (float) (d14 * Math.sin(d16));
            if (floatValue != 0.0f) {
                d11 = d14;
                i10 = i11;
                d10 = d16;
                double atan2 = (float) (Math.atan2(sin, cos) - 1.5707963267948966d);
                float cos3 = (float) Math.cos(atan2);
                float sin3 = (float) Math.sin(atan2);
                d12 = d15;
                double atan22 = (float) (Math.atan2(sin2, cos2) - 1.5707963267948966d);
                float f10 = floatValue2 * floatValue * 0.25f;
                this.f48792a.cubicTo(cos - (cos3 * f10), sin - (sin3 * f10), cos2 + (((float) Math.cos(atan22)) * f10), sin2 + (f10 * ((float) Math.sin(atan22))), cos2, sin2);
            } else {
                d10 = d16;
                d11 = d14;
                d12 = d15;
                i10 = i11;
                this.f48792a.lineTo(cos2, sin2);
            }
            d16 = d10 + d12;
            i11 = i10 + 1;
            sin = sin2;
            cos = cos2;
            ceil = d17;
            d14 = d11;
            d15 = d12;
        }
        PointF h10 = this.f48799h.h();
        this.f48792a.offset(h10.x, h10.y);
        this.f48792a.close();
    }

    @Override // f.a.b
    public void e() {
        j();
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void f(List<Content> list, List<Content> list2) {
        for (int i10 = 0; i10 < list.size(); i10++) {
            Content content = list.get(i10);
            if (content instanceof t) {
                t tVar = (t) content;
                if (tVar.j() == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                    this.f48805n.a(tVar);
                    tVar.a(this);
                }
            }
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.f48793b;
    }

    @Override // e.l
    public Path getPath() {
        if (this.f48806o) {
            return this.f48792a;
        }
        this.f48792a.reset();
        if (this.f48796e) {
            this.f48806o = true;
            return this.f48792a;
        }
        int i10 = a.f48807a[this.f48795d.ordinal()];
        if (i10 == 1) {
            i();
        } else if (i10 == 2) {
            c();
        }
        this.f48792a.close();
        this.f48805n.b(this.f48792a);
        this.f48806o = true;
        return this.f48792a;
    }

    @Override // h.d
    public void h(h.c cVar, int i10, List<h.c> list, h.c cVar2) {
        n.g.k(cVar, i10, list, cVar2, this);
    }

    public final void i() {
        double d10;
        int i10;
        double d11;
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        double d12;
        float f16;
        float f17;
        float f18;
        float floatValue = this.f48798g.h().floatValue();
        double radians = Math.toRadians((this.f48800i == null ? ShadowDrawableWrapper.COS_45 : r2.h().floatValue()) - 90.0d);
        double d13 = floatValue;
        float f19 = (float) (6.283185307179586d / d13);
        if (this.f48797f) {
            f19 *= -1.0f;
        }
        float f20 = f19 / 2.0f;
        float f21 = floatValue - ((int) floatValue);
        int i11 = (f21 > 0.0f ? 1 : (f21 == 0.0f ? 0 : -1));
        if (i11 != 0) {
            radians += (1.0f - f21) * f20;
        }
        float floatValue2 = this.f48802k.h().floatValue();
        float floatValue3 = this.f48801j.h().floatValue();
        f.a<?, Float> aVar = this.f48803l;
        float floatValue4 = aVar != null ? aVar.h().floatValue() / 100.0f : 0.0f;
        f.a<?, Float> aVar2 = this.f48804m;
        float floatValue5 = aVar2 != null ? aVar2.h().floatValue() / 100.0f : 0.0f;
        if (i11 != 0) {
            f12 = ((floatValue2 - floatValue3) * f21) + floatValue3;
            i10 = i11;
            double d14 = f12;
            d10 = d13;
            f10 = (float) (d14 * Math.cos(radians));
            f11 = (float) (d14 * Math.sin(radians));
            this.f48792a.moveTo(f10, f11);
            d11 = radians + ((f19 * f21) / 2.0f);
        } else {
            d10 = d13;
            i10 = i11;
            double d15 = floatValue2;
            float cos = (float) (Math.cos(radians) * d15);
            float sin = (float) (d15 * Math.sin(radians));
            this.f48792a.moveTo(cos, sin);
            d11 = radians + f20;
            f10 = cos;
            f11 = sin;
            f12 = 0.0f;
        }
        double ceil = Math.ceil(d10) * 2.0d;
        int i12 = 0;
        boolean z10 = false;
        while (true) {
            double d16 = i12;
            if (d16 < ceil) {
                float f22 = z10 ? floatValue2 : floatValue3;
                if (f12 == 0.0f || d16 != ceil - 2.0d) {
                    f13 = f19;
                    f14 = f20;
                } else {
                    f13 = f19;
                    f14 = (f19 * f21) / 2.0f;
                }
                if (f12 == 0.0f || d16 != ceil - 1.0d) {
                    f15 = f20;
                    d12 = d16;
                    f16 = f22;
                } else {
                    f15 = f20;
                    d12 = d16;
                    f16 = f12;
                }
                double d17 = f16;
                double d18 = ceil;
                float cos2 = (float) (d17 * Math.cos(d11));
                float sin2 = (float) (d17 * Math.sin(d11));
                if (floatValue4 == 0.0f && floatValue5 == 0.0f) {
                    this.f48792a.lineTo(cos2, sin2);
                    f17 = floatValue4;
                    f18 = f12;
                } else {
                    f17 = floatValue4;
                    f18 = f12;
                    double atan2 = (float) (Math.atan2(f11, f10) - 1.5707963267948966d);
                    float cos3 = (float) Math.cos(atan2);
                    float sin3 = (float) Math.sin(atan2);
                    double atan22 = (float) (Math.atan2(sin2, cos2) - 1.5707963267948966d);
                    float cos4 = (float) Math.cos(atan22);
                    float sin4 = (float) Math.sin(atan22);
                    float f23 = z10 ? f17 : floatValue5;
                    float f24 = z10 ? floatValue5 : f17;
                    float f25 = (z10 ? floatValue3 : floatValue2) * f23 * 0.47829f;
                    float f26 = cos3 * f25;
                    float f27 = f25 * sin3;
                    float f28 = (z10 ? floatValue2 : floatValue3) * f24 * 0.47829f;
                    float f29 = cos4 * f28;
                    float f30 = f28 * sin4;
                    if (i10 != 0) {
                        if (i12 == 0) {
                            f26 *= f21;
                            f27 *= f21;
                        } else if (d12 == d18 - 1.0d) {
                            f29 *= f21;
                            f30 *= f21;
                        }
                    }
                    this.f48792a.cubicTo(f10 - f26, f11 - f27, cos2 + f29, sin2 + f30, cos2, sin2);
                }
                d11 += f14;
                z10 = !z10;
                i12++;
                f10 = cos2;
                f11 = sin2;
                floatValue4 = f17;
                f12 = f18;
                f20 = f15;
                f19 = f13;
                ceil = d18;
            } else {
                PointF h10 = this.f48799h.h();
                this.f48792a.offset(h10.x, h10.y);
                this.f48792a.close();
                return;
            }
        }
    }

    public final void j() {
        this.f48806o = false;
        this.f48794c.invalidateSelf();
    }
}
