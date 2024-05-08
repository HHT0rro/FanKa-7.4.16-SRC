package e;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.i0;
import com.airbnb.lottie.model.layer.BaseLayer;
import f.a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: FillContent.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class f implements d, a.b, j {

    /* renamed from: a, reason: collision with root package name */
    public final Path f48742a;

    /* renamed from: b, reason: collision with root package name */
    public final Paint f48743b;

    /* renamed from: c, reason: collision with root package name */
    public final BaseLayer f48744c;

    /* renamed from: d, reason: collision with root package name */
    public final String f48745d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f48746e;

    /* renamed from: f, reason: collision with root package name */
    public final List<l> f48747f;

    /* renamed from: g, reason: collision with root package name */
    public final f.a<Integer, Integer> f48748g;

    /* renamed from: h, reason: collision with root package name */
    public final f.a<Integer, Integer> f48749h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    public f.a<ColorFilter, ColorFilter> f48750i;

    /* renamed from: j, reason: collision with root package name */
    public final LottieDrawable f48751j;

    /* renamed from: k, reason: collision with root package name */
    @Nullable
    public f.a<Float, Float> f48752k;

    /* renamed from: l, reason: collision with root package name */
    public float f48753l;

    /* renamed from: m, reason: collision with root package name */
    @Nullable
    public f.c f48754m;

    public f(LottieDrawable lottieDrawable, BaseLayer baseLayer, j.h hVar) {
        Path path = new Path();
        this.f48742a = path;
        this.f48743b = new d.a(1);
        this.f48747f = new ArrayList();
        this.f48744c = baseLayer;
        this.f48745d = hVar.c();
        this.f48746e = hVar.e();
        this.f48751j = lottieDrawable;
        if (baseLayer.v() != null) {
            f.a<Float, Float> a10 = baseLayer.v().a().a();
            this.f48752k = a10;
            a10.a(this);
            baseLayer.i(this.f48752k);
        }
        if (baseLayer.x() != null) {
            this.f48754m = new f.c(this, baseLayer, baseLayer.x());
        }
        if (hVar.a() != null && hVar.d() != null) {
            path.setFillType(hVar.b());
            f.a<Integer, Integer> a11 = hVar.a().a();
            this.f48748g = a11;
            a11.a(this);
            baseLayer.i(a11);
            f.a<Integer, Integer> a12 = hVar.d().a();
            this.f48749h = a12;
            a12.a(this);
            baseLayer.i(a12);
            return;
        }
        this.f48748g = null;
        this.f48749h = null;
    }

    @Override // h.d
    public <T> void a(T t2, @Nullable o.c<T> cVar) {
        f.c cVar2;
        f.c cVar3;
        f.c cVar4;
        f.c cVar5;
        f.c cVar6;
        if (t2 == i0.f1912a) {
            this.f48748g.n(cVar);
            return;
        }
        if (t2 == i0.f1915d) {
            this.f48749h.n(cVar);
            return;
        }
        if (t2 == i0.K) {
            f.a<ColorFilter, ColorFilter> aVar = this.f48750i;
            if (aVar != null) {
                this.f48744c.G(aVar);
            }
            if (cVar == null) {
                this.f48750i = null;
                return;
            }
            f.q qVar = new f.q(cVar);
            this.f48750i = qVar;
            qVar.a(this);
            this.f48744c.i(this.f48750i);
            return;
        }
        if (t2 == i0.f1921j) {
            f.a<Float, Float> aVar2 = this.f48752k;
            if (aVar2 != null) {
                aVar2.n(cVar);
                return;
            }
            f.q qVar2 = new f.q(cVar);
            this.f48752k = qVar2;
            qVar2.a(this);
            this.f48744c.i(this.f48752k);
            return;
        }
        if (t2 == i0.f1916e && (cVar6 = this.f48754m) != null) {
            cVar6.b(cVar);
            return;
        }
        if (t2 == i0.G && (cVar5 = this.f48754m) != null) {
            cVar5.f(cVar);
            return;
        }
        if (t2 == i0.H && (cVar4 = this.f48754m) != null) {
            cVar4.c(cVar);
            return;
        }
        if (t2 == i0.I && (cVar3 = this.f48754m) != null) {
            cVar3.d(cVar);
        } else {
            if (t2 != i0.J || (cVar2 = this.f48754m) == null) {
                return;
            }
            cVar2.g(cVar);
        }
    }

    @Override // e.d
    public void b(RectF rectF, Matrix matrix, boolean z10) {
        this.f48742a.reset();
        for (int i10 = 0; i10 < this.f48747f.size(); i10++) {
            this.f48742a.addPath(this.f48747f.get(i10).getPath(), matrix);
        }
        this.f48742a.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // e.d
    public void d(Canvas canvas, Matrix matrix, int i10) {
        if (this.f48746e) {
            return;
        }
        com.airbnb.lottie.c.a("FillContent#draw");
        this.f48743b.setColor((n.g.c((int) ((((i10 / 255.0f) * this.f48749h.h().intValue()) / 100.0f) * 255.0f), 0, 255) << 24) | (((f.b) this.f48748g).p() & 16777215));
        f.a<ColorFilter, ColorFilter> aVar = this.f48750i;
        if (aVar != null) {
            this.f48743b.setColorFilter(aVar.h());
        }
        f.a<Float, Float> aVar2 = this.f48752k;
        if (aVar2 != null) {
            float floatValue = aVar2.h().floatValue();
            if (floatValue == 0.0f) {
                this.f48743b.setMaskFilter(null);
            } else if (floatValue != this.f48753l) {
                this.f48743b.setMaskFilter(this.f48744c.w(floatValue));
            }
            this.f48753l = floatValue;
        }
        f.c cVar = this.f48754m;
        if (cVar != null) {
            cVar.a(this.f48743b);
        }
        this.f48742a.reset();
        for (int i11 = 0; i11 < this.f48747f.size(); i11++) {
            this.f48742a.addPath(this.f48747f.get(i11).getPath(), matrix);
        }
        canvas.drawPath(this.f48742a, this.f48743b);
        com.airbnb.lottie.c.b("FillContent#draw");
    }

    @Override // f.a.b
    public void e() {
        this.f48751j.invalidateSelf();
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void f(List<Content> list, List<Content> list2) {
        for (int i10 = 0; i10 < list2.size(); i10++) {
            Content content = list2.get(i10);
            if (content instanceof l) {
                this.f48747f.add((l) content);
            }
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.f48745d;
    }

    @Override // h.d
    public void h(h.c cVar, int i10, List<h.c> list, h.c cVar2) {
        n.g.k(cVar, i10, list, cVar2, this);
    }
}
