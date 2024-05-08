package e;

import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.i0;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.android.internal.logging.nano.MetricsProto;
import f.a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: GradientFillContent.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class g implements d, a.b, j {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    public final String f48755a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f48756b;

    /* renamed from: c, reason: collision with root package name */
    public final BaseLayer f48757c;

    /* renamed from: d, reason: collision with root package name */
    public final LongSparseArray<LinearGradient> f48758d = new LongSparseArray<>();

    /* renamed from: e, reason: collision with root package name */
    public final LongSparseArray<RadialGradient> f48759e = new LongSparseArray<>();

    /* renamed from: f, reason: collision with root package name */
    public final Path f48760f;

    /* renamed from: g, reason: collision with root package name */
    public final Paint f48761g;

    /* renamed from: h, reason: collision with root package name */
    public final RectF f48762h;

    /* renamed from: i, reason: collision with root package name */
    public final List<l> f48763i;

    /* renamed from: j, reason: collision with root package name */
    public final GradientType f48764j;

    /* renamed from: k, reason: collision with root package name */
    public final f.a<j.c, j.c> f48765k;

    /* renamed from: l, reason: collision with root package name */
    public final f.a<Integer, Integer> f48766l;

    /* renamed from: m, reason: collision with root package name */
    public final f.a<PointF, PointF> f48767m;

    /* renamed from: n, reason: collision with root package name */
    public final f.a<PointF, PointF> f48768n;

    /* renamed from: o, reason: collision with root package name */
    @Nullable
    public f.a<ColorFilter, ColorFilter> f48769o;

    /* renamed from: p, reason: collision with root package name */
    @Nullable
    public f.q f48770p;

    /* renamed from: q, reason: collision with root package name */
    public final LottieDrawable f48771q;

    /* renamed from: r, reason: collision with root package name */
    public final int f48772r;

    /* renamed from: s, reason: collision with root package name */
    @Nullable
    public f.a<Float, Float> f48773s;

    /* renamed from: t, reason: collision with root package name */
    public float f48774t;

    /* renamed from: u, reason: collision with root package name */
    @Nullable
    public f.c f48775u;

    public g(LottieDrawable lottieDrawable, LottieComposition lottieComposition, BaseLayer baseLayer, j.d dVar) {
        Path path = new Path();
        this.f48760f = path;
        this.f48761g = new d.a(1);
        this.f48762h = new RectF();
        this.f48763i = new ArrayList();
        this.f48774t = 0.0f;
        this.f48757c = baseLayer;
        this.f48755a = dVar.e();
        this.f48756b = dVar.h();
        this.f48771q = lottieDrawable;
        this.f48764j = dVar.d();
        path.setFillType(dVar.b());
        this.f48772r = (int) (lottieComposition.d() / 32.0f);
        f.a<j.c, j.c> a10 = dVar.c().a();
        this.f48765k = a10;
        a10.a(this);
        baseLayer.i(a10);
        f.a<Integer, Integer> a11 = dVar.f().a();
        this.f48766l = a11;
        a11.a(this);
        baseLayer.i(a11);
        f.a<PointF, PointF> a12 = dVar.g().a();
        this.f48767m = a12;
        a12.a(this);
        baseLayer.i(a12);
        f.a<PointF, PointF> a13 = dVar.a().a();
        this.f48768n = a13;
        a13.a(this);
        baseLayer.i(a13);
        if (baseLayer.v() != null) {
            f.a<Float, Float> a14 = baseLayer.v().a().a();
            this.f48773s = a14;
            a14.a(this);
            baseLayer.i(this.f48773s);
        }
        if (baseLayer.x() != null) {
            this.f48775u = new f.c(this, baseLayer, baseLayer.x());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h.d
    public <T> void a(T t2, @Nullable o.c<T> cVar) {
        f.c cVar2;
        f.c cVar3;
        f.c cVar4;
        f.c cVar5;
        f.c cVar6;
        if (t2 == i0.f1915d) {
            this.f48766l.n(cVar);
            return;
        }
        if (t2 == i0.K) {
            f.a<ColorFilter, ColorFilter> aVar = this.f48769o;
            if (aVar != null) {
                this.f48757c.G(aVar);
            }
            if (cVar == null) {
                this.f48769o = null;
                return;
            }
            f.q qVar = new f.q(cVar);
            this.f48769o = qVar;
            qVar.a(this);
            this.f48757c.i(this.f48769o);
            return;
        }
        if (t2 == i0.L) {
            f.q qVar2 = this.f48770p;
            if (qVar2 != null) {
                this.f48757c.G(qVar2);
            }
            if (cVar == null) {
                this.f48770p = null;
                return;
            }
            this.f48758d.clear();
            this.f48759e.clear();
            f.q qVar3 = new f.q(cVar);
            this.f48770p = qVar3;
            qVar3.a(this);
            this.f48757c.i(this.f48770p);
            return;
        }
        if (t2 == i0.f1921j) {
            f.a<Float, Float> aVar2 = this.f48773s;
            if (aVar2 != null) {
                aVar2.n(cVar);
                return;
            }
            f.q qVar4 = new f.q(cVar);
            this.f48773s = qVar4;
            qVar4.a(this);
            this.f48757c.i(this.f48773s);
            return;
        }
        if (t2 == i0.f1916e && (cVar6 = this.f48775u) != null) {
            cVar6.b(cVar);
            return;
        }
        if (t2 == i0.G && (cVar5 = this.f48775u) != null) {
            cVar5.f(cVar);
            return;
        }
        if (t2 == i0.H && (cVar4 = this.f48775u) != null) {
            cVar4.c(cVar);
            return;
        }
        if (t2 == i0.I && (cVar3 = this.f48775u) != null) {
            cVar3.d(cVar);
        } else {
            if (t2 != i0.J || (cVar2 = this.f48775u) == null) {
                return;
            }
            cVar2.g(cVar);
        }
    }

    @Override // e.d
    public void b(RectF rectF, Matrix matrix, boolean z10) {
        this.f48760f.reset();
        for (int i10 = 0; i10 < this.f48763i.size(); i10++) {
            this.f48760f.addPath(this.f48763i.get(i10).getPath(), matrix);
        }
        this.f48760f.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    public final int[] c(int[] iArr) {
        f.q qVar = this.f48770p;
        if (qVar != null) {
            Integer[] numArr = (Integer[]) qVar.h();
            int i10 = 0;
            if (iArr.length == numArr.length) {
                while (i10 < iArr.length) {
                    iArr[i10] = numArr[i10].intValue();
                    i10++;
                }
            } else {
                iArr = new int[numArr.length];
                while (i10 < numArr.length) {
                    iArr[i10] = numArr[i10].intValue();
                    i10++;
                }
            }
        }
        return iArr;
    }

    @Override // e.d
    public void d(Canvas canvas, Matrix matrix, int i10) {
        Shader k10;
        if (this.f48756b) {
            return;
        }
        com.airbnb.lottie.c.a("GradientFillContent#draw");
        this.f48760f.reset();
        for (int i11 = 0; i11 < this.f48763i.size(); i11++) {
            this.f48760f.addPath(this.f48763i.get(i11).getPath(), matrix);
        }
        this.f48760f.computeBounds(this.f48762h, false);
        if (this.f48764j == GradientType.LINEAR) {
            k10 = j();
        } else {
            k10 = k();
        }
        k10.setLocalMatrix(matrix);
        this.f48761g.setShader(k10);
        f.a<ColorFilter, ColorFilter> aVar = this.f48769o;
        if (aVar != null) {
            this.f48761g.setColorFilter(aVar.h());
        }
        f.a<Float, Float> aVar2 = this.f48773s;
        if (aVar2 != null) {
            float floatValue = aVar2.h().floatValue();
            if (floatValue == 0.0f) {
                this.f48761g.setMaskFilter(null);
            } else if (floatValue != this.f48774t) {
                this.f48761g.setMaskFilter(new BlurMaskFilter(floatValue, BlurMaskFilter.Blur.NORMAL));
            }
            this.f48774t = floatValue;
        }
        f.c cVar = this.f48775u;
        if (cVar != null) {
            cVar.a(this.f48761g);
        }
        this.f48761g.setAlpha(n.g.c((int) ((((i10 / 255.0f) * this.f48766l.h().intValue()) / 100.0f) * 255.0f), 0, 255));
        canvas.drawPath(this.f48760f, this.f48761g);
        com.airbnb.lottie.c.b("GradientFillContent#draw");
    }

    @Override // f.a.b
    public void e() {
        this.f48771q.invalidateSelf();
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void f(List<Content> list, List<Content> list2) {
        for (int i10 = 0; i10 < list2.size(); i10++) {
            Content content = list2.get(i10);
            if (content instanceof l) {
                this.f48763i.add((l) content);
            }
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.f48755a;
    }

    @Override // h.d
    public void h(h.c cVar, int i10, List<h.c> list, h.c cVar2) {
        n.g.k(cVar, i10, list, cVar2, this);
    }

    public final int i() {
        int round = Math.round(this.f48767m.f() * this.f48772r);
        int round2 = Math.round(this.f48768n.f() * this.f48772r);
        int round3 = Math.round(this.f48765k.f() * this.f48772r);
        int i10 = round != 0 ? MetricsProto.MetricsEvent.DIALOG_SUPPORT_PHONE * round : 17;
        if (round2 != 0) {
            i10 = i10 * 31 * round2;
        }
        return round3 != 0 ? i10 * 31 * round3 : i10;
    }

    public final LinearGradient j() {
        long i10 = i();
        LinearGradient linearGradient = this.f48758d.get(i10);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF h10 = this.f48767m.h();
        PointF h11 = this.f48768n.h();
        j.c h12 = this.f48765k.h();
        LinearGradient linearGradient2 = new LinearGradient(h10.x, h10.y, h11.x, h11.y, c(h12.c()), h12.d(), Shader.TileMode.CLAMP);
        this.f48758d.put(i10, linearGradient2);
        return linearGradient2;
    }

    public final RadialGradient k() {
        long i10 = i();
        RadialGradient radialGradient = this.f48759e.get(i10);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF h10 = this.f48767m.h();
        PointF h11 = this.f48768n.h();
        j.c h12 = this.f48765k.h();
        int[] c4 = c(h12.c());
        float[] d10 = h12.d();
        float f10 = h10.x;
        float f11 = h10.y;
        float hypot = (float) Math.hypot(h11.x - f10, h11.y - f11);
        RadialGradient radialGradient2 = new RadialGradient(f10, f11, hypot <= 0.0f ? 0.001f : hypot, c4, d10, Shader.TileMode.CLAMP);
        this.f48759e.put(i10, radialGradient2);
        return radialGradient2;
    }
}
