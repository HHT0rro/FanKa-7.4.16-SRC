package f;

import android.graphics.Matrix;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.i0;
import com.airbnb.lottie.model.layer.BaseLayer;
import f.a;
import java.util.Collections;

/* compiled from: TransformKeyframeAnimation.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    public final Matrix f49071a = new Matrix();

    /* renamed from: b, reason: collision with root package name */
    public final Matrix f49072b;

    /* renamed from: c, reason: collision with root package name */
    public final Matrix f49073c;

    /* renamed from: d, reason: collision with root package name */
    public final Matrix f49074d;

    /* renamed from: e, reason: collision with root package name */
    public final float[] f49075e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public a<PointF, PointF> f49076f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public a<?, PointF> f49077g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public a<o.d, o.d> f49078h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    public a<Float, Float> f49079i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    public a<Integer, Integer> f49080j;

    /* renamed from: k, reason: collision with root package name */
    @Nullable
    public d f49081k;

    /* renamed from: l, reason: collision with root package name */
    @Nullable
    public d f49082l;

    /* renamed from: m, reason: collision with root package name */
    @Nullable
    public a<?, Float> f49083m;

    /* renamed from: n, reason: collision with root package name */
    @Nullable
    public a<?, Float> f49084n;

    public p(i.l lVar) {
        this.f49076f = lVar.b() == null ? null : lVar.b().a();
        this.f49077g = lVar.e() == null ? null : lVar.e().a();
        this.f49078h = lVar.g() == null ? null : lVar.g().a();
        this.f49079i = lVar.f() == null ? null : lVar.f().a();
        d dVar = lVar.h() == null ? null : (d) lVar.h().a();
        this.f49081k = dVar;
        if (dVar != null) {
            this.f49072b = new Matrix();
            this.f49073c = new Matrix();
            this.f49074d = new Matrix();
            this.f49075e = new float[9];
        } else {
            this.f49072b = null;
            this.f49073c = null;
            this.f49074d = null;
            this.f49075e = null;
        }
        this.f49082l = lVar.i() == null ? null : (d) lVar.i().a();
        if (lVar.d() != null) {
            this.f49080j = lVar.d().a();
        }
        if (lVar.j() != null) {
            this.f49083m = lVar.j().a();
        } else {
            this.f49083m = null;
        }
        if (lVar.c() != null) {
            this.f49084n = lVar.c().a();
        } else {
            this.f49084n = null;
        }
    }

    public void a(BaseLayer baseLayer) {
        baseLayer.i(this.f49080j);
        baseLayer.i(this.f49083m);
        baseLayer.i(this.f49084n);
        baseLayer.i(this.f49076f);
        baseLayer.i(this.f49077g);
        baseLayer.i(this.f49078h);
        baseLayer.i(this.f49079i);
        baseLayer.i(this.f49081k);
        baseLayer.i(this.f49082l);
    }

    public void b(a.b bVar) {
        a<Integer, Integer> aVar = this.f49080j;
        if (aVar != null) {
            aVar.a(bVar);
        }
        a<?, Float> aVar2 = this.f49083m;
        if (aVar2 != null) {
            aVar2.a(bVar);
        }
        a<?, Float> aVar3 = this.f49084n;
        if (aVar3 != null) {
            aVar3.a(bVar);
        }
        a<PointF, PointF> aVar4 = this.f49076f;
        if (aVar4 != null) {
            aVar4.a(bVar);
        }
        a<?, PointF> aVar5 = this.f49077g;
        if (aVar5 != null) {
            aVar5.a(bVar);
        }
        a<o.d, o.d> aVar6 = this.f49078h;
        if (aVar6 != null) {
            aVar6.a(bVar);
        }
        a<Float, Float> aVar7 = this.f49079i;
        if (aVar7 != null) {
            aVar7.a(bVar);
        }
        d dVar = this.f49081k;
        if (dVar != null) {
            dVar.a(bVar);
        }
        d dVar2 = this.f49082l;
        if (dVar2 != null) {
            dVar2.a(bVar);
        }
    }

    public <T> boolean c(T t2, @Nullable o.c<T> cVar) {
        if (t2 == i0.f1917f) {
            a<PointF, PointF> aVar = this.f49076f;
            if (aVar == null) {
                this.f49076f = new q(cVar, new PointF());
                return true;
            }
            aVar.n(cVar);
            return true;
        }
        if (t2 == i0.f1918g) {
            a<?, PointF> aVar2 = this.f49077g;
            if (aVar2 == null) {
                this.f49077g = new q(cVar, new PointF());
                return true;
            }
            aVar2.n(cVar);
            return true;
        }
        if (t2 == i0.f1919h) {
            a<?, PointF> aVar3 = this.f49077g;
            if (aVar3 instanceof n) {
                ((n) aVar3).r(cVar);
                return true;
            }
        }
        if (t2 == i0.f1920i) {
            a<?, PointF> aVar4 = this.f49077g;
            if (aVar4 instanceof n) {
                ((n) aVar4).s(cVar);
                return true;
            }
        }
        if (t2 == i0.f1926o) {
            a<o.d, o.d> aVar5 = this.f49078h;
            if (aVar5 == null) {
                this.f49078h = new q(cVar, new o.d());
                return true;
            }
            aVar5.n(cVar);
            return true;
        }
        if (t2 == i0.f1927p) {
            a<Float, Float> aVar6 = this.f49079i;
            if (aVar6 == null) {
                this.f49079i = new q(cVar, Float.valueOf(0.0f));
                return true;
            }
            aVar6.n(cVar);
            return true;
        }
        if (t2 == i0.f1914c) {
            a<Integer, Integer> aVar7 = this.f49080j;
            if (aVar7 == null) {
                this.f49080j = new q(cVar, 100);
                return true;
            }
            aVar7.n(cVar);
            return true;
        }
        if (t2 == i0.C) {
            a<?, Float> aVar8 = this.f49083m;
            if (aVar8 == null) {
                this.f49083m = new q(cVar, Float.valueOf(100.0f));
                return true;
            }
            aVar8.n(cVar);
            return true;
        }
        if (t2 == i0.D) {
            a<?, Float> aVar9 = this.f49084n;
            if (aVar9 == null) {
                this.f49084n = new q(cVar, Float.valueOf(100.0f));
                return true;
            }
            aVar9.n(cVar);
            return true;
        }
        if (t2 == i0.f1928q) {
            if (this.f49081k == null) {
                this.f49081k = new d(Collections.singletonList(new o.a(Float.valueOf(0.0f))));
            }
            this.f49081k.n(cVar);
            return true;
        }
        if (t2 != i0.f1929r) {
            return false;
        }
        if (this.f49082l == null) {
            this.f49082l = new d(Collections.singletonList(new o.a(Float.valueOf(0.0f))));
        }
        this.f49082l.n(cVar);
        return true;
    }

    public final void d() {
        for (int i10 = 0; i10 < 9; i10++) {
            this.f49075e[i10] = 0.0f;
        }
    }

    @Nullable
    public a<?, Float> e() {
        return this.f49084n;
    }

    public Matrix f() {
        PointF h10;
        float p10;
        PointF h11;
        this.f49071a.reset();
        a<?, PointF> aVar = this.f49077g;
        if (aVar != null && (h11 = aVar.h()) != null) {
            float f10 = h11.x;
            if (f10 != 0.0f || h11.y != 0.0f) {
                this.f49071a.preTranslate(f10, h11.y);
            }
        }
        a<Float, Float> aVar2 = this.f49079i;
        if (aVar2 != null) {
            if (aVar2 instanceof q) {
                p10 = aVar2.h().floatValue();
            } else {
                p10 = ((d) aVar2).p();
            }
            if (p10 != 0.0f) {
                this.f49071a.preRotate(p10);
            }
        }
        if (this.f49081k != null) {
            float cos = this.f49082l == null ? 0.0f : (float) Math.cos(Math.toRadians((-r3.p()) + 90.0f));
            float sin = this.f49082l == null ? 1.0f : (float) Math.sin(Math.toRadians((-r5.p()) + 90.0f));
            float tan = (float) Math.tan(Math.toRadians(r0.p()));
            d();
            float[] fArr = this.f49075e;
            fArr[0] = cos;
            fArr[1] = sin;
            float f11 = -sin;
            fArr[3] = f11;
            fArr[4] = cos;
            fArr[8] = 1.0f;
            this.f49072b.setValues(fArr);
            d();
            float[] fArr2 = this.f49075e;
            fArr2[0] = 1.0f;
            fArr2[3] = tan;
            fArr2[4] = 1.0f;
            fArr2[8] = 1.0f;
            this.f49073c.setValues(fArr2);
            d();
            float[] fArr3 = this.f49075e;
            fArr3[0] = cos;
            fArr3[1] = f11;
            fArr3[3] = sin;
            fArr3[4] = cos;
            fArr3[8] = 1.0f;
            this.f49074d.setValues(fArr3);
            this.f49073c.preConcat(this.f49072b);
            this.f49074d.preConcat(this.f49073c);
            this.f49071a.preConcat(this.f49074d);
        }
        a<o.d, o.d> aVar3 = this.f49078h;
        if (aVar3 != null) {
            o.d h12 = aVar3.h();
            if (h12.b() != 1.0f || h12.c() != 1.0f) {
                this.f49071a.preScale(h12.b(), h12.c());
            }
        }
        a<PointF, PointF> aVar4 = this.f49076f;
        if (aVar4 != null && (((h10 = aVar4.h()) != null && h10.x != 0.0f) || h10.y != 0.0f)) {
            this.f49071a.preTranslate(-h10.x, -h10.y);
        }
        return this.f49071a;
    }

    public Matrix g(float f10) {
        a<?, PointF> aVar = this.f49077g;
        PointF h10 = aVar == null ? null : aVar.h();
        a<o.d, o.d> aVar2 = this.f49078h;
        o.d h11 = aVar2 == null ? null : aVar2.h();
        this.f49071a.reset();
        if (h10 != null) {
            this.f49071a.preTranslate(h10.x * f10, h10.y * f10);
        }
        if (h11 != null) {
            double d10 = f10;
            this.f49071a.preScale((float) Math.pow(h11.b(), d10), (float) Math.pow(h11.c(), d10));
        }
        a<Float, Float> aVar3 = this.f49079i;
        if (aVar3 != null) {
            float floatValue = aVar3.h().floatValue();
            a<PointF, PointF> aVar4 = this.f49076f;
            PointF h12 = aVar4 != null ? aVar4.h() : null;
            this.f49071a.preRotate(floatValue * f10, h12 == null ? 0.0f : h12.x, h12 != null ? h12.y : 0.0f);
        }
        return this.f49071a;
    }

    @Nullable
    public a<?, Integer> h() {
        return this.f49080j;
    }

    @Nullable
    public a<?, Float> i() {
        return this.f49083m;
    }

    public void j(float f10) {
        a<Integer, Integer> aVar = this.f49080j;
        if (aVar != null) {
            aVar.m(f10);
        }
        a<?, Float> aVar2 = this.f49083m;
        if (aVar2 != null) {
            aVar2.m(f10);
        }
        a<?, Float> aVar3 = this.f49084n;
        if (aVar3 != null) {
            aVar3.m(f10);
        }
        a<PointF, PointF> aVar4 = this.f49076f;
        if (aVar4 != null) {
            aVar4.m(f10);
        }
        a<?, PointF> aVar5 = this.f49077g;
        if (aVar5 != null) {
            aVar5.m(f10);
        }
        a<o.d, o.d> aVar6 = this.f49078h;
        if (aVar6 != null) {
            aVar6.m(f10);
        }
        a<Float, Float> aVar7 = this.f49079i;
        if (aVar7 != null) {
            aVar7.m(f10);
        }
        d dVar = this.f49081k;
        if (dVar != null) {
            dVar.m(f10);
        }
        d dVar2 = this.f49082l;
        if (dVar2 != null) {
            dVar2.m(f10);
        }
    }
}
