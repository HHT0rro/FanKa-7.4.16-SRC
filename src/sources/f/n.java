package f;

import android.graphics.PointF;
import androidx.annotation.Nullable;
import java.util.Collections;

/* compiled from: SplitDimensionPathKeyframeAnimation.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class n extends a<PointF, PointF> {

    /* renamed from: i, reason: collision with root package name */
    public final PointF f49061i;

    /* renamed from: j, reason: collision with root package name */
    public final PointF f49062j;

    /* renamed from: k, reason: collision with root package name */
    public final a<Float, Float> f49063k;

    /* renamed from: l, reason: collision with root package name */
    public final a<Float, Float> f49064l;

    /* renamed from: m, reason: collision with root package name */
    @Nullable
    public o.c<Float> f49065m;

    /* renamed from: n, reason: collision with root package name */
    @Nullable
    public o.c<Float> f49066n;

    public n(a<Float, Float> aVar, a<Float, Float> aVar2) {
        super(Collections.emptyList());
        this.f49061i = new PointF();
        this.f49062j = new PointF();
        this.f49063k = aVar;
        this.f49064l = aVar2;
        m(f());
    }

    @Override // f.a
    public void m(float f10) {
        this.f49063k.m(f10);
        this.f49064l.m(f10);
        this.f49061i.set(this.f49063k.h().floatValue(), this.f49064l.h().floatValue());
        for (int i10 = 0; i10 < this.f49023a.size(); i10++) {
            this.f49023a.get(i10).e();
        }
    }

    @Override // f.a
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public PointF h() {
        return i(null, 0.0f);
    }

    @Override // f.a
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public PointF i(o.a<PointF> aVar, float f10) {
        Float f11;
        o.a<Float> b4;
        o.a<Float> b10;
        Float f12 = null;
        if (this.f49065m == null || (b10 = this.f49063k.b()) == null) {
            f11 = null;
        } else {
            float d10 = this.f49063k.d();
            Float f13 = b10.f52217h;
            o.c<Float> cVar = this.f49065m;
            float f14 = b10.f52216g;
            f11 = cVar.b(f14, f13 == null ? f14 : f13.floatValue(), b10.f52211b, b10.f52212c, f10, f10, d10);
        }
        if (this.f49066n != null && (b4 = this.f49064l.b()) != null) {
            float d11 = this.f49064l.d();
            Float f15 = b4.f52217h;
            o.c<Float> cVar2 = this.f49066n;
            float f16 = b4.f52216g;
            f12 = cVar2.b(f16, f15 == null ? f16 : f15.floatValue(), b4.f52211b, b4.f52212c, f10, f10, d11);
        }
        if (f11 == null) {
            this.f49062j.set(this.f49061i.x, 0.0f);
        } else {
            this.f49062j.set(f11.floatValue(), 0.0f);
        }
        if (f12 == null) {
            PointF pointF = this.f49062j;
            pointF.set(pointF.x, this.f49061i.y);
        } else {
            PointF pointF2 = this.f49062j;
            pointF2.set(pointF2.x, f12.floatValue());
        }
        return this.f49062j;
    }

    public void r(@Nullable o.c<Float> cVar) {
        o.c<Float> cVar2 = this.f49065m;
        if (cVar2 != null) {
            cVar2.c(null);
        }
        this.f49065m = cVar;
        if (cVar != null) {
            cVar.c(this);
        }
    }

    public void s(@Nullable o.c<Float> cVar) {
        o.c<Float> cVar2 = this.f49066n;
        if (cVar2 != null) {
            cVar2.c(null);
        }
        this.f49066n = cVar;
        if (cVar != null) {
            cVar.c(this);
        }
    }
}
