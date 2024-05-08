package f;

import android.graphics.Color;
import android.graphics.Paint;
import androidx.annotation.Nullable;
import com.airbnb.lottie.model.layer.BaseLayer;
import f.a;

/* compiled from: DropShadowKeyframeAnimation.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class c implements a.b {

    /* renamed from: a, reason: collision with root package name */
    public final a.b f49037a;

    /* renamed from: b, reason: collision with root package name */
    public final f.a<Integer, Integer> f49038b;

    /* renamed from: c, reason: collision with root package name */
    public final f.a<Float, Float> f49039c;

    /* renamed from: d, reason: collision with root package name */
    public final f.a<Float, Float> f49040d;

    /* renamed from: e, reason: collision with root package name */
    public final f.a<Float, Float> f49041e;

    /* renamed from: f, reason: collision with root package name */
    public final f.a<Float, Float> f49042f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f49043g = true;

    /* compiled from: DropShadowKeyframeAnimation.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class a extends o.c<Float> {

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ o.c f49044d;

        public a(o.c cVar) {
            this.f49044d = cVar;
        }

        @Override // o.c
        @Nullable
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Float a(o.b<Float> bVar) {
            Float f10 = (Float) this.f49044d.a(bVar);
            if (f10 == null) {
                return null;
            }
            return Float.valueOf(f10.floatValue() * 2.55f);
        }
    }

    public c(a.b bVar, BaseLayer baseLayer, m.j jVar) {
        this.f49037a = bVar;
        f.a<Integer, Integer> a10 = jVar.a().a();
        this.f49038b = a10;
        a10.a(this);
        baseLayer.i(a10);
        f.a<Float, Float> a11 = jVar.d().a();
        this.f49039c = a11;
        a11.a(this);
        baseLayer.i(a11);
        f.a<Float, Float> a12 = jVar.b().a();
        this.f49040d = a12;
        a12.a(this);
        baseLayer.i(a12);
        f.a<Float, Float> a13 = jVar.c().a();
        this.f49041e = a13;
        a13.a(this);
        baseLayer.i(a13);
        f.a<Float, Float> a14 = jVar.e().a();
        this.f49042f = a14;
        a14.a(this);
        baseLayer.i(a14);
    }

    public void a(Paint paint) {
        if (this.f49043g) {
            this.f49043g = false;
            double floatValue = this.f49040d.h().floatValue() * 0.017453292519943295d;
            float floatValue2 = this.f49041e.h().floatValue();
            float sin = ((float) Math.sin(floatValue)) * floatValue2;
            float cos = ((float) Math.cos(floatValue + 3.141592653589793d)) * floatValue2;
            int intValue = this.f49038b.h().intValue();
            paint.setShadowLayer(this.f49042f.h().floatValue(), sin, cos, Color.argb(Math.round(this.f49039c.h().floatValue()), Color.red(intValue), Color.green(intValue), Color.blue(intValue)));
        }
    }

    public void b(@Nullable o.c<Integer> cVar) {
        this.f49038b.n(cVar);
    }

    public void c(@Nullable o.c<Float> cVar) {
        this.f49040d.n(cVar);
    }

    public void d(@Nullable o.c<Float> cVar) {
        this.f49041e.n(cVar);
    }

    @Override // f.a.b
    public void e() {
        this.f49043g = true;
        this.f49037a.e();
    }

    public void f(@Nullable o.c<Float> cVar) {
        if (cVar == null) {
            this.f49039c.n(null);
        } else {
            this.f49039c.n(new a(cVar));
        }
    }

    public void g(@Nullable o.c<Float> cVar) {
        this.f49042f.n(cVar);
    }
}
