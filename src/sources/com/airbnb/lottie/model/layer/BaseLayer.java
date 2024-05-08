package com.airbnb.lottie.model.layer;

import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import androidx.annotation.CallSuper;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.model.content.ShapeData;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.model.layer.Layer;
import e.d;
import f.a;
import f.h;
import f.p;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import k.b;
import k.c;
import k.e;
import k.f;
import m.j;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class BaseLayer implements d, a.b, h.d {

    @Nullable
    public Paint A;
    public float B;

    @Nullable
    public BlurMaskFilter C;

    /* renamed from: a, reason: collision with root package name */
    public final Path f2008a = new Path();

    /* renamed from: b, reason: collision with root package name */
    public final Matrix f2009b = new Matrix();

    /* renamed from: c, reason: collision with root package name */
    public final Matrix f2010c = new Matrix();

    /* renamed from: d, reason: collision with root package name */
    public final Paint f2011d = new d.a(1);

    /* renamed from: e, reason: collision with root package name */
    public final Paint f2012e = new d.a(1, PorterDuff.Mode.DST_IN);

    /* renamed from: f, reason: collision with root package name */
    public final Paint f2013f = new d.a(1, PorterDuff.Mode.DST_OUT);

    /* renamed from: g, reason: collision with root package name */
    public final Paint f2014g;

    /* renamed from: h, reason: collision with root package name */
    public final Paint f2015h;

    /* renamed from: i, reason: collision with root package name */
    public final RectF f2016i;

    /* renamed from: j, reason: collision with root package name */
    public final RectF f2017j;

    /* renamed from: k, reason: collision with root package name */
    public final RectF f2018k;

    /* renamed from: l, reason: collision with root package name */
    public final RectF f2019l;

    /* renamed from: m, reason: collision with root package name */
    public final RectF f2020m;

    /* renamed from: n, reason: collision with root package name */
    public final String f2021n;

    /* renamed from: o, reason: collision with root package name */
    public final Matrix f2022o;

    /* renamed from: p, reason: collision with root package name */
    public final LottieDrawable f2023p;

    /* renamed from: q, reason: collision with root package name */
    public final Layer f2024q;

    /* renamed from: r, reason: collision with root package name */
    @Nullable
    public h f2025r;

    /* renamed from: s, reason: collision with root package name */
    @Nullable
    public f.d f2026s;

    /* renamed from: t, reason: collision with root package name */
    @Nullable
    public BaseLayer f2027t;

    /* renamed from: u, reason: collision with root package name */
    @Nullable
    public BaseLayer f2028u;

    /* renamed from: v, reason: collision with root package name */
    public List<BaseLayer> f2029v;

    /* renamed from: w, reason: collision with root package name */
    public final List<f.a<?, ?>> f2030w;

    /* renamed from: x, reason: collision with root package name */
    public final p f2031x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f2032y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f2033z;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f2034a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f2035b;

        static {
            int[] iArr = new int[Mask.MaskMode.values().length];
            f2035b = iArr;
            try {
                iArr[Mask.MaskMode.MASK_MODE_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2035b[Mask.MaskMode.MASK_MODE_SUBTRACT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2035b[Mask.MaskMode.MASK_MODE_INTERSECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2035b[Mask.MaskMode.MASK_MODE_ADD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[Layer.LayerType.values().length];
            f2034a = iArr2;
            try {
                iArr2[Layer.LayerType.SHAPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f2034a[Layer.LayerType.PRE_COMP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f2034a[Layer.LayerType.SOLID.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f2034a[Layer.LayerType.IMAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f2034a[Layer.LayerType.NULL.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f2034a[Layer.LayerType.TEXT.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f2034a[Layer.LayerType.UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    public BaseLayer(LottieDrawable lottieDrawable, Layer layer) {
        d.a aVar = new d.a(1);
        this.f2014g = aVar;
        this.f2015h = new d.a(PorterDuff.Mode.CLEAR);
        this.f2016i = new RectF();
        this.f2017j = new RectF();
        this.f2018k = new RectF();
        this.f2019l = new RectF();
        this.f2020m = new RectF();
        this.f2022o = new Matrix();
        this.f2030w = new ArrayList();
        this.f2032y = true;
        this.B = 0.0f;
        this.f2023p = lottieDrawable;
        this.f2024q = layer;
        this.f2021n = layer.i() + "#draw";
        if (layer.h() == Layer.MatteType.INVERT) {
            aVar.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            aVar.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        p a10 = layer.w().a();
        this.f2031x = a10;
        a10.b(this);
        if (layer.g() != null && !layer.g().isEmpty()) {
            h hVar = new h(layer.g());
            this.f2025r = hVar;
            Iterator<f.a<ShapeData, Path>> iterator2 = hVar.a().iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().a(this);
            }
            for (f.a<Integer, Integer> aVar2 : this.f2025r.c()) {
                i(aVar2);
                aVar2.a(this);
            }
        }
        N();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E() {
        M(this.f2026s.p() == 1.0f);
    }

    @Nullable
    public static BaseLayer u(com.airbnb.lottie.model.layer.a aVar, Layer layer, LottieDrawable lottieDrawable, LottieComposition lottieComposition) {
        switch (a.f2034a[layer.f().ordinal()]) {
            case 1:
                return new k.d(lottieDrawable, layer, aVar, lottieComposition);
            case 2:
                return new com.airbnb.lottie.model.layer.a(lottieDrawable, layer, lottieComposition.o(layer.m()), lottieComposition);
            case 3:
                return new e(lottieDrawable, layer);
            case 4:
                return new b(lottieDrawable, layer);
            case 5:
                return new c(lottieDrawable, layer);
            case 6:
                return new f(lottieDrawable, layer);
            default:
                n.d.c("Unknown layer type " + ((Object) layer.f()));
                return null;
        }
    }

    public boolean A() {
        return this.f2027t != null;
    }

    public final void B(RectF rectF, Matrix matrix) {
        this.f2018k.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (z()) {
            int size = this.f2025r.b().size();
            for (int i10 = 0; i10 < size; i10++) {
                Mask mask = this.f2025r.b().get(i10);
                Path h10 = this.f2025r.a().get(i10).h();
                if (h10 != null) {
                    this.f2008a.set(h10);
                    this.f2008a.transform(matrix);
                    int i11 = a.f2035b[mask.a().ordinal()];
                    if (i11 == 1 || i11 == 2) {
                        return;
                    }
                    if ((i11 == 3 || i11 == 4) && mask.d()) {
                        return;
                    }
                    this.f2008a.computeBounds(this.f2020m, false);
                    if (i10 == 0) {
                        this.f2018k.set(this.f2020m);
                    } else {
                        RectF rectF2 = this.f2018k;
                        rectF2.set(Math.min(rectF2.left, this.f2020m.left), Math.min(this.f2018k.top, this.f2020m.top), Math.max(this.f2018k.right, this.f2020m.right), Math.max(this.f2018k.bottom, this.f2020m.bottom));
                    }
                }
            }
            if (rectF.intersect(this.f2018k)) {
                return;
            }
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    public final void C(RectF rectF, Matrix matrix) {
        if (A() && this.f2024q.h() != Layer.MatteType.INVERT) {
            this.f2019l.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.f2027t.b(this.f2019l, matrix, true);
            if (rectF.intersect(this.f2019l)) {
                return;
            }
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    public final void D() {
        this.f2023p.invalidateSelf();
    }

    public final void F(float f10) {
        this.f2023p.J().n().a(this.f2024q.i(), f10);
    }

    public void G(f.a<?, ?> aVar) {
        this.f2030w.remove(aVar);
    }

    public void H(h.c cVar, int i10, List<h.c> list, h.c cVar2) {
    }

    public void I(@Nullable BaseLayer baseLayer) {
        this.f2027t = baseLayer;
    }

    public void J(boolean z10) {
        if (z10 && this.A == null) {
            this.A = new d.a();
        }
        this.f2033z = z10;
    }

    public void K(@Nullable BaseLayer baseLayer) {
        this.f2028u = baseLayer;
    }

    public void L(@FloatRange(from = 0.0d, to = 1.0d) float f10) {
        this.f2031x.j(f10);
        if (this.f2025r != null) {
            for (int i10 = 0; i10 < this.f2025r.a().size(); i10++) {
                this.f2025r.a().get(i10).m(f10);
            }
        }
        f.d dVar = this.f2026s;
        if (dVar != null) {
            dVar.m(f10);
        }
        BaseLayer baseLayer = this.f2027t;
        if (baseLayer != null) {
            baseLayer.L(f10);
        }
        for (int i11 = 0; i11 < this.f2030w.size(); i11++) {
            this.f2030w.get(i11).m(f10);
        }
    }

    public final void M(boolean z10) {
        if (z10 != this.f2032y) {
            this.f2032y = z10;
            D();
        }
    }

    public final void N() {
        if (!this.f2024q.e().isEmpty()) {
            f.d dVar = new f.d(this.f2024q.e());
            this.f2026s = dVar;
            dVar.l();
            this.f2026s.a(new a.b() { // from class: k.a
                @Override // f.a.b
                public final void e() {
                    BaseLayer.this.E();
                }
            });
            M(this.f2026s.h().floatValue() == 1.0f);
            i(this.f2026s);
            return;
        }
        M(true);
    }

    @Override // h.d
    @CallSuper
    public <T> void a(T t2, @Nullable o.c<T> cVar) {
        this.f2031x.c(t2, cVar);
    }

    @Override // e.d
    @CallSuper
    public void b(RectF rectF, Matrix matrix, boolean z10) {
        this.f2016i.set(0.0f, 0.0f, 0.0f, 0.0f);
        r();
        this.f2022o.set(matrix);
        if (z10) {
            List<BaseLayer> list = this.f2029v;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f2022o.preConcat(this.f2029v.get(size).f2031x.f());
                }
            } else {
                BaseLayer baseLayer = this.f2028u;
                if (baseLayer != null) {
                    this.f2022o.preConcat(baseLayer.f2031x.f());
                }
            }
        }
        this.f2022o.preConcat(this.f2031x.f());
    }

    @Override // e.d
    public void d(Canvas canvas, Matrix matrix, int i10) {
        Paint paint;
        Integer h10;
        com.airbnb.lottie.c.a(this.f2021n);
        if (this.f2032y && !this.f2024q.x()) {
            r();
            com.airbnb.lottie.c.a("Layer#parentMatrix");
            this.f2009b.reset();
            this.f2009b.set(matrix);
            for (int size = this.f2029v.size() - 1; size >= 0; size--) {
                this.f2009b.preConcat(this.f2029v.get(size).f2031x.f());
            }
            com.airbnb.lottie.c.b("Layer#parentMatrix");
            int i11 = 100;
            f.a<?, Integer> h11 = this.f2031x.h();
            if (h11 != null && (h10 = h11.h()) != null) {
                i11 = h10.intValue();
            }
            int i12 = (int) ((((i10 / 255.0f) * i11) / 100.0f) * 255.0f);
            if (!A() && !z()) {
                this.f2009b.preConcat(this.f2031x.f());
                com.airbnb.lottie.c.a("Layer#drawLayer");
                t(canvas, this.f2009b, i12);
                com.airbnb.lottie.c.b("Layer#drawLayer");
                F(com.airbnb.lottie.c.b(this.f2021n));
                return;
            }
            com.airbnb.lottie.c.a("Layer#computeBounds");
            b(this.f2016i, this.f2009b, false);
            C(this.f2016i, matrix);
            this.f2009b.preConcat(this.f2031x.f());
            B(this.f2016i, this.f2009b);
            this.f2017j.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
            canvas.getMatrix(this.f2010c);
            if (!this.f2010c.isIdentity()) {
                Matrix matrix2 = this.f2010c;
                matrix2.invert(matrix2);
                this.f2010c.mapRect(this.f2017j);
            }
            if (!this.f2016i.intersect(this.f2017j)) {
                this.f2016i.set(0.0f, 0.0f, 0.0f, 0.0f);
            }
            com.airbnb.lottie.c.b("Layer#computeBounds");
            if (this.f2016i.width() >= 1.0f && this.f2016i.height() >= 1.0f) {
                com.airbnb.lottie.c.a("Layer#saveLayer");
                this.f2011d.setAlpha(255);
                n.h.m(canvas, this.f2016i, this.f2011d);
                com.airbnb.lottie.c.b("Layer#saveLayer");
                s(canvas);
                com.airbnb.lottie.c.a("Layer#drawLayer");
                t(canvas, this.f2009b, i12);
                com.airbnb.lottie.c.b("Layer#drawLayer");
                if (z()) {
                    o(canvas, this.f2009b);
                }
                if (A()) {
                    com.airbnb.lottie.c.a("Layer#drawMatte");
                    com.airbnb.lottie.c.a("Layer#saveLayer");
                    n.h.n(canvas, this.f2016i, this.f2014g, 19);
                    com.airbnb.lottie.c.b("Layer#saveLayer");
                    s(canvas);
                    this.f2027t.d(canvas, matrix, i12);
                    com.airbnb.lottie.c.a("Layer#restoreLayer");
                    canvas.restore();
                    com.airbnb.lottie.c.b("Layer#restoreLayer");
                    com.airbnb.lottie.c.b("Layer#drawMatte");
                }
                com.airbnb.lottie.c.a("Layer#restoreLayer");
                canvas.restore();
                com.airbnb.lottie.c.b("Layer#restoreLayer");
            }
            if (this.f2033z && (paint = this.A) != null) {
                paint.setStyle(Paint.Style.STROKE);
                this.A.setColor(-251901);
                this.A.setStrokeWidth(4.0f);
                canvas.drawRect(this.f2016i, this.A);
                this.A.setStyle(Paint.Style.FILL);
                this.A.setColor(1357638635);
                canvas.drawRect(this.f2016i, this.A);
            }
            F(com.airbnb.lottie.c.b(this.f2021n));
            return;
        }
        com.airbnb.lottie.c.b(this.f2021n);
    }

    @Override // f.a.b
    public void e() {
        D();
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void f(List<Content> list, List<Content> list2) {
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.f2024q.i();
    }

    @Override // h.d
    public void h(h.c cVar, int i10, List<h.c> list, h.c cVar2) {
        BaseLayer baseLayer = this.f2027t;
        if (baseLayer != null) {
            h.c a10 = cVar2.a(baseLayer.getName());
            if (cVar.c(this.f2027t.getName(), i10)) {
                list.add(a10.i(this.f2027t));
            }
            if (cVar.h(getName(), i10)) {
                this.f2027t.H(cVar, cVar.e(this.f2027t.getName(), i10) + i10, list, a10);
            }
        }
        if (cVar.g(getName(), i10)) {
            if (!"__container".equals(getName())) {
                cVar2 = cVar2.a(getName());
                if (cVar.c(getName(), i10)) {
                    list.add(cVar2.i(this));
                }
            }
            if (cVar.h(getName(), i10)) {
                H(cVar, i10 + cVar.e(getName(), i10), list, cVar2);
            }
        }
    }

    public void i(@Nullable f.a<?, ?> aVar) {
        if (aVar == null) {
            return;
        }
        this.f2030w.add(aVar);
    }

    public final void j(Canvas canvas, Matrix matrix, f.a<ShapeData, Path> aVar, f.a<Integer, Integer> aVar2) {
        this.f2008a.set(aVar.h());
        this.f2008a.transform(matrix);
        this.f2011d.setAlpha((int) (aVar2.h().intValue() * 2.55f));
        canvas.drawPath(this.f2008a, this.f2011d);
    }

    public final void k(Canvas canvas, Matrix matrix, f.a<ShapeData, Path> aVar, f.a<Integer, Integer> aVar2) {
        n.h.m(canvas, this.f2016i, this.f2012e);
        this.f2008a.set(aVar.h());
        this.f2008a.transform(matrix);
        this.f2011d.setAlpha((int) (aVar2.h().intValue() * 2.55f));
        canvas.drawPath(this.f2008a, this.f2011d);
        canvas.restore();
    }

    public final void l(Canvas canvas, Matrix matrix, f.a<ShapeData, Path> aVar, f.a<Integer, Integer> aVar2) {
        n.h.m(canvas, this.f2016i, this.f2011d);
        canvas.drawRect(this.f2016i, this.f2011d);
        this.f2008a.set(aVar.h());
        this.f2008a.transform(matrix);
        this.f2011d.setAlpha((int) (aVar2.h().intValue() * 2.55f));
        canvas.drawPath(this.f2008a, this.f2013f);
        canvas.restore();
    }

    public final void m(Canvas canvas, Matrix matrix, f.a<ShapeData, Path> aVar, f.a<Integer, Integer> aVar2) {
        n.h.m(canvas, this.f2016i, this.f2012e);
        canvas.drawRect(this.f2016i, this.f2011d);
        this.f2013f.setAlpha((int) (aVar2.h().intValue() * 2.55f));
        this.f2008a.set(aVar.h());
        this.f2008a.transform(matrix);
        canvas.drawPath(this.f2008a, this.f2013f);
        canvas.restore();
    }

    public final void n(Canvas canvas, Matrix matrix, f.a<ShapeData, Path> aVar, f.a<Integer, Integer> aVar2) {
        n.h.m(canvas, this.f2016i, this.f2013f);
        canvas.drawRect(this.f2016i, this.f2011d);
        this.f2013f.setAlpha((int) (aVar2.h().intValue() * 2.55f));
        this.f2008a.set(aVar.h());
        this.f2008a.transform(matrix);
        canvas.drawPath(this.f2008a, this.f2013f);
        canvas.restore();
    }

    public final void o(Canvas canvas, Matrix matrix) {
        com.airbnb.lottie.c.a("Layer#saveLayer");
        n.h.n(canvas, this.f2016i, this.f2012e, 19);
        if (Build.VERSION.SDK_INT < 28) {
            s(canvas);
        }
        com.airbnb.lottie.c.b("Layer#saveLayer");
        for (int i10 = 0; i10 < this.f2025r.b().size(); i10++) {
            Mask mask = this.f2025r.b().get(i10);
            f.a<ShapeData, Path> aVar = this.f2025r.a().get(i10);
            f.a<Integer, Integer> aVar2 = this.f2025r.c().get(i10);
            int i11 = a.f2035b[mask.a().ordinal()];
            if (i11 != 1) {
                if (i11 == 2) {
                    if (i10 == 0) {
                        this.f2011d.setColor(-16777216);
                        this.f2011d.setAlpha(255);
                        canvas.drawRect(this.f2016i, this.f2011d);
                    }
                    if (mask.d()) {
                        n(canvas, matrix, aVar, aVar2);
                    } else {
                        p(canvas, matrix, aVar);
                    }
                } else if (i11 != 3) {
                    if (i11 == 4) {
                        if (mask.d()) {
                            l(canvas, matrix, aVar, aVar2);
                        } else {
                            j(canvas, matrix, aVar, aVar2);
                        }
                    }
                } else if (mask.d()) {
                    m(canvas, matrix, aVar, aVar2);
                } else {
                    k(canvas, matrix, aVar, aVar2);
                }
            } else if (q()) {
                this.f2011d.setAlpha(255);
                canvas.drawRect(this.f2016i, this.f2011d);
            }
        }
        com.airbnb.lottie.c.a("Layer#restoreLayer");
        canvas.restore();
        com.airbnb.lottie.c.b("Layer#restoreLayer");
    }

    public final void p(Canvas canvas, Matrix matrix, f.a<ShapeData, Path> aVar) {
        this.f2008a.set(aVar.h());
        this.f2008a.transform(matrix);
        canvas.drawPath(this.f2008a, this.f2013f);
    }

    public final boolean q() {
        if (this.f2025r.a().isEmpty()) {
            return false;
        }
        for (int i10 = 0; i10 < this.f2025r.b().size(); i10++) {
            if (this.f2025r.b().get(i10).a() != Mask.MaskMode.MASK_MODE_NONE) {
                return false;
            }
        }
        return true;
    }

    public final void r() {
        if (this.f2029v != null) {
            return;
        }
        if (this.f2028u == null) {
            this.f2029v = Collections.emptyList();
            return;
        }
        this.f2029v = new ArrayList();
        for (BaseLayer baseLayer = this.f2028u; baseLayer != null; baseLayer = baseLayer.f2028u) {
            this.f2029v.add(baseLayer);
        }
    }

    public final void s(Canvas canvas) {
        com.airbnb.lottie.c.a("Layer#clearLayer");
        RectF rectF = this.f2016i;
        canvas.drawRect(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f, this.f2015h);
        com.airbnb.lottie.c.b("Layer#clearLayer");
    }

    public abstract void t(Canvas canvas, Matrix matrix, int i10);

    @Nullable
    public j.a v() {
        return this.f2024q.a();
    }

    public BlurMaskFilter w(float f10) {
        if (this.B == f10) {
            return this.C;
        }
        BlurMaskFilter blurMaskFilter = new BlurMaskFilter(f10 / 2.0f, BlurMaskFilter.Blur.NORMAL);
        this.C = blurMaskFilter;
        this.B = f10;
        return blurMaskFilter;
    }

    @Nullable
    public j x() {
        return this.f2024q.c();
    }

    public Layer y() {
        return this.f2024q;
    }

    public boolean z() {
        h hVar = this.f2025r;
        return (hVar == null || hVar.a().isEmpty()) ? false : true;
    }
}
