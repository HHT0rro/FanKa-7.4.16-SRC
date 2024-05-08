package e;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.i0;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import f.a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: BaseStrokeContent.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class a implements a.b, j, d {

    /* renamed from: e, reason: collision with root package name */
    public final LottieDrawable f48707e;

    /* renamed from: f, reason: collision with root package name */
    public final BaseLayer f48708f;

    /* renamed from: h, reason: collision with root package name */
    public final float[] f48710h;

    /* renamed from: i, reason: collision with root package name */
    public final Paint f48711i;

    /* renamed from: j, reason: collision with root package name */
    public final f.a<?, Float> f48712j;

    /* renamed from: k, reason: collision with root package name */
    public final f.a<?, Integer> f48713k;

    /* renamed from: l, reason: collision with root package name */
    public final List<f.a<?, Float>> f48714l;

    /* renamed from: m, reason: collision with root package name */
    @Nullable
    public final f.a<?, Float> f48715m;

    /* renamed from: n, reason: collision with root package name */
    @Nullable
    public f.a<ColorFilter, ColorFilter> f48716n;

    /* renamed from: o, reason: collision with root package name */
    @Nullable
    public f.a<Float, Float> f48717o;

    /* renamed from: p, reason: collision with root package name */
    public float f48718p;

    /* renamed from: q, reason: collision with root package name */
    @Nullable
    public f.c f48719q;

    /* renamed from: a, reason: collision with root package name */
    public final PathMeasure f48703a = new PathMeasure();

    /* renamed from: b, reason: collision with root package name */
    public final Path f48704b = new Path();

    /* renamed from: c, reason: collision with root package name */
    public final Path f48705c = new Path();

    /* renamed from: d, reason: collision with root package name */
    public final RectF f48706d = new RectF();

    /* renamed from: g, reason: collision with root package name */
    public final List<b> f48709g = new ArrayList();

    /* compiled from: BaseStrokeContent.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final List<l> f48720a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        public final t f48721b;

        public b(@Nullable t tVar) {
            this.f48720a = new ArrayList();
            this.f48721b = tVar;
        }
    }

    public a(LottieDrawable lottieDrawable, BaseLayer baseLayer, Paint.Cap cap, Paint.Join join, float f10, i.d dVar, i.b bVar, List<i.b> list, i.b bVar2) {
        d.a aVar = new d.a(1);
        this.f48711i = aVar;
        this.f48718p = 0.0f;
        this.f48707e = lottieDrawable;
        this.f48708f = baseLayer;
        aVar.setStyle(Paint.Style.STROKE);
        aVar.setStrokeCap(cap);
        aVar.setStrokeJoin(join);
        aVar.setStrokeMiter(f10);
        this.f48713k = dVar.a();
        this.f48712j = bVar.a();
        if (bVar2 == null) {
            this.f48715m = null;
        } else {
            this.f48715m = bVar2.a();
        }
        this.f48714l = new ArrayList(list.size());
        this.f48710h = new float[list.size()];
        for (int i10 = 0; i10 < list.size(); i10++) {
            this.f48714l.add(list.get(i10).a());
        }
        baseLayer.i(this.f48713k);
        baseLayer.i(this.f48712j);
        for (int i11 = 0; i11 < this.f48714l.size(); i11++) {
            baseLayer.i(this.f48714l.get(i11));
        }
        f.a<?, Float> aVar2 = this.f48715m;
        if (aVar2 != null) {
            baseLayer.i(aVar2);
        }
        this.f48713k.a(this);
        this.f48712j.a(this);
        for (int i12 = 0; i12 < list.size(); i12++) {
            this.f48714l.get(i12).a(this);
        }
        f.a<?, Float> aVar3 = this.f48715m;
        if (aVar3 != null) {
            aVar3.a(this);
        }
        if (baseLayer.v() != null) {
            f.a<Float, Float> a10 = baseLayer.v().a().a();
            this.f48717o = a10;
            a10.a(this);
            baseLayer.i(this.f48717o);
        }
        if (baseLayer.x() != null) {
            this.f48719q = new f.c(this, baseLayer, baseLayer.x());
        }
    }

    @Override // h.d
    @CallSuper
    public <T> void a(T t2, @Nullable o.c<T> cVar) {
        f.c cVar2;
        f.c cVar3;
        f.c cVar4;
        f.c cVar5;
        f.c cVar6;
        if (t2 == i0.f1915d) {
            this.f48713k.n(cVar);
            return;
        }
        if (t2 == i0.f1930s) {
            this.f48712j.n(cVar);
            return;
        }
        if (t2 == i0.K) {
            f.a<ColorFilter, ColorFilter> aVar = this.f48716n;
            if (aVar != null) {
                this.f48708f.G(aVar);
            }
            if (cVar == null) {
                this.f48716n = null;
                return;
            }
            f.q qVar = new f.q(cVar);
            this.f48716n = qVar;
            qVar.a(this);
            this.f48708f.i(this.f48716n);
            return;
        }
        if (t2 == i0.f1921j) {
            f.a<Float, Float> aVar2 = this.f48717o;
            if (aVar2 != null) {
                aVar2.n(cVar);
                return;
            }
            f.q qVar2 = new f.q(cVar);
            this.f48717o = qVar2;
            qVar2.a(this);
            this.f48708f.i(this.f48717o);
            return;
        }
        if (t2 == i0.f1916e && (cVar6 = this.f48719q) != null) {
            cVar6.b(cVar);
            return;
        }
        if (t2 == i0.G && (cVar5 = this.f48719q) != null) {
            cVar5.f(cVar);
            return;
        }
        if (t2 == i0.H && (cVar4 = this.f48719q) != null) {
            cVar4.c(cVar);
            return;
        }
        if (t2 == i0.I && (cVar3 = this.f48719q) != null) {
            cVar3.d(cVar);
        } else {
            if (t2 != i0.J || (cVar2 = this.f48719q) == null) {
                return;
            }
            cVar2.g(cVar);
        }
    }

    @Override // e.d
    public void b(RectF rectF, Matrix matrix, boolean z10) {
        com.airbnb.lottie.c.a("StrokeContent#getBounds");
        this.f48704b.reset();
        for (int i10 = 0; i10 < this.f48709g.size(); i10++) {
            b bVar = this.f48709g.get(i10);
            for (int i11 = 0; i11 < bVar.f48720a.size(); i11++) {
                this.f48704b.addPath(((l) bVar.f48720a.get(i11)).getPath(), matrix);
            }
        }
        this.f48704b.computeBounds(this.f48706d, false);
        float p10 = ((f.d) this.f48712j).p();
        RectF rectF2 = this.f48706d;
        float f10 = p10 / 2.0f;
        rectF2.set(rectF2.left - f10, rectF2.top - f10, rectF2.right + f10, rectF2.bottom + f10);
        rectF.set(this.f48706d);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        com.airbnb.lottie.c.b("StrokeContent#getBounds");
    }

    public final void c(Matrix matrix) {
        com.airbnb.lottie.c.a("StrokeContent#applyDashPattern");
        if (this.f48714l.isEmpty()) {
            com.airbnb.lottie.c.b("StrokeContent#applyDashPattern");
            return;
        }
        float g3 = n.h.g(matrix);
        for (int i10 = 0; i10 < this.f48714l.size(); i10++) {
            this.f48710h[i10] = this.f48714l.get(i10).h().floatValue();
            if (i10 % 2 == 0) {
                float[] fArr = this.f48710h;
                if (fArr[i10] < 1.0f) {
                    fArr[i10] = 1.0f;
                }
            } else {
                float[] fArr2 = this.f48710h;
                if (fArr2[i10] < 0.1f) {
                    fArr2[i10] = 0.1f;
                }
            }
            float[] fArr3 = this.f48710h;
            fArr3[i10] = fArr3[i10] * g3;
        }
        f.a<?, Float> aVar = this.f48715m;
        this.f48711i.setPathEffect(new DashPathEffect(this.f48710h, aVar == null ? 0.0f : g3 * aVar.h().floatValue()));
        com.airbnb.lottie.c.b("StrokeContent#applyDashPattern");
    }

    @Override // e.d
    public void d(Canvas canvas, Matrix matrix, int i10) {
        com.airbnb.lottie.c.a("StrokeContent#draw");
        if (n.h.h(matrix)) {
            com.airbnb.lottie.c.b("StrokeContent#draw");
            return;
        }
        this.f48711i.setAlpha(n.g.c((int) ((((i10 / 255.0f) * ((f.f) this.f48713k).p()) / 100.0f) * 255.0f), 0, 255));
        this.f48711i.setStrokeWidth(((f.d) this.f48712j).p() * n.h.g(matrix));
        if (this.f48711i.getStrokeWidth() <= 0.0f) {
            com.airbnb.lottie.c.b("StrokeContent#draw");
            return;
        }
        c(matrix);
        f.a<ColorFilter, ColorFilter> aVar = this.f48716n;
        if (aVar != null) {
            this.f48711i.setColorFilter(aVar.h());
        }
        f.a<Float, Float> aVar2 = this.f48717o;
        if (aVar2 != null) {
            float floatValue = aVar2.h().floatValue();
            if (floatValue == 0.0f) {
                this.f48711i.setMaskFilter(null);
            } else if (floatValue != this.f48718p) {
                this.f48711i.setMaskFilter(this.f48708f.w(floatValue));
            }
            this.f48718p = floatValue;
        }
        f.c cVar = this.f48719q;
        if (cVar != null) {
            cVar.a(this.f48711i);
        }
        for (int i11 = 0; i11 < this.f48709g.size(); i11++) {
            b bVar = this.f48709g.get(i11);
            if (bVar.f48721b != null) {
                i(canvas, bVar, matrix);
            } else {
                com.airbnb.lottie.c.a("StrokeContent#buildPath");
                this.f48704b.reset();
                for (int size = bVar.f48720a.size() - 1; size >= 0; size--) {
                    this.f48704b.addPath(((l) bVar.f48720a.get(size)).getPath(), matrix);
                }
                com.airbnb.lottie.c.b("StrokeContent#buildPath");
                com.airbnb.lottie.c.a("StrokeContent#drawPath");
                canvas.drawPath(this.f48704b, this.f48711i);
                com.airbnb.lottie.c.b("StrokeContent#drawPath");
            }
        }
        com.airbnb.lottie.c.b("StrokeContent#draw");
    }

    @Override // f.a.b
    public void e() {
        this.f48707e.invalidateSelf();
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void f(List<Content> list, List<Content> list2) {
        t tVar = null;
        for (int size = list.size() - 1; size >= 0; size--) {
            Content content = list.get(size);
            if (content instanceof t) {
                t tVar2 = (t) content;
                if (tVar2.j() == ShapeTrimPath.Type.INDIVIDUALLY) {
                    tVar = tVar2;
                }
            }
        }
        if (tVar != null) {
            tVar.a(this);
        }
        b bVar = null;
        for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
            Content content2 = list2.get(size2);
            if (content2 instanceof t) {
                t tVar3 = (t) content2;
                if (tVar3.j() == ShapeTrimPath.Type.INDIVIDUALLY) {
                    if (bVar != null) {
                        this.f48709g.add(bVar);
                    }
                    bVar = new b(tVar3);
                    tVar3.a(this);
                }
            }
            if (content2 instanceof l) {
                if (bVar == null) {
                    bVar = new b(tVar);
                }
                bVar.f48720a.add((l) content2);
            }
        }
        if (bVar != null) {
            this.f48709g.add(bVar);
        }
    }

    @Override // h.d
    public void h(h.c cVar, int i10, List<h.c> list, h.c cVar2) {
        n.g.k(cVar, i10, list, cVar2, this);
    }

    public final void i(Canvas canvas, b bVar, Matrix matrix) {
        com.airbnb.lottie.c.a("StrokeContent#applyTrimPath");
        if (bVar.f48721b == null) {
            com.airbnb.lottie.c.b("StrokeContent#applyTrimPath");
            return;
        }
        this.f48704b.reset();
        for (int size = bVar.f48720a.size() - 1; size >= 0; size--) {
            this.f48704b.addPath(((l) bVar.f48720a.get(size)).getPath(), matrix);
        }
        float floatValue = bVar.f48721b.i().h().floatValue() / 100.0f;
        float floatValue2 = bVar.f48721b.c().h().floatValue() / 100.0f;
        float floatValue3 = bVar.f48721b.h().h().floatValue() / 360.0f;
        if (floatValue < 0.01f && floatValue2 > 0.99f) {
            canvas.drawPath(this.f48704b, this.f48711i);
            com.airbnb.lottie.c.b("StrokeContent#applyTrimPath");
            return;
        }
        this.f48703a.setPath(this.f48704b, false);
        float length = this.f48703a.getLength();
        while (this.f48703a.nextContour()) {
            length += this.f48703a.getLength();
        }
        float f10 = floatValue3 * length;
        float f11 = (floatValue * length) + f10;
        float min = Math.min((floatValue2 * length) + f10, (f11 + length) - 1.0f);
        float f12 = 0.0f;
        for (int size2 = bVar.f48720a.size() - 1; size2 >= 0; size2--) {
            this.f48705c.set(((l) bVar.f48720a.get(size2)).getPath());
            this.f48705c.transform(matrix);
            this.f48703a.setPath(this.f48705c, false);
            float length2 = this.f48703a.getLength();
            if (min > length) {
                float f13 = min - length;
                if (f13 < f12 + length2 && f12 < f13) {
                    n.h.a(this.f48705c, f11 > length ? (f11 - length) / length2 : 0.0f, Math.min(f13 / length2, 1.0f), 0.0f);
                    canvas.drawPath(this.f48705c, this.f48711i);
                    f12 += length2;
                }
            }
            float f14 = f12 + length2;
            if (f14 >= f11 && f12 <= min) {
                if (f14 <= min && f11 < f12) {
                    canvas.drawPath(this.f48705c, this.f48711i);
                } else {
                    n.h.a(this.f48705c, f11 < f12 ? 0.0f : (f11 - f12) / length2, min > f14 ? 1.0f : (min - f12) / length2, 0.0f);
                    canvas.drawPath(this.f48705c, this.f48711i);
                }
            }
            f12 += length2;
        }
        com.airbnb.lottie.c.b("StrokeContent#applyTrimPath");
    }
}
