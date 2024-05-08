package e;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.i0;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import f.a;
import java.util.List;

/* compiled from: RectangleContent.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class n implements a.b, j, l {

    /* renamed from: c, reason: collision with root package name */
    public final String f48810c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f48811d;

    /* renamed from: e, reason: collision with root package name */
    public final LottieDrawable f48812e;

    /* renamed from: f, reason: collision with root package name */
    public final f.a<?, PointF> f48813f;

    /* renamed from: g, reason: collision with root package name */
    public final f.a<?, PointF> f48814g;

    /* renamed from: h, reason: collision with root package name */
    public final f.a<?, Float> f48815h;

    /* renamed from: k, reason: collision with root package name */
    public boolean f48818k;

    /* renamed from: a, reason: collision with root package name */
    public final Path f48808a = new Path();

    /* renamed from: b, reason: collision with root package name */
    public final RectF f48809b = new RectF();

    /* renamed from: i, reason: collision with root package name */
    public final b f48816i = new b();

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    public f.a<Float, Float> f48817j = null;

    public n(LottieDrawable lottieDrawable, BaseLayer baseLayer, j.e eVar) {
        this.f48810c = eVar.b();
        this.f48811d = eVar.e();
        this.f48812e = lottieDrawable;
        f.a<PointF, PointF> a10 = eVar.c().a();
        this.f48813f = a10;
        f.a<PointF, PointF> a11 = eVar.d().a();
        this.f48814g = a11;
        f.a<Float, Float> a12 = eVar.a().a();
        this.f48815h = a12;
        baseLayer.i(a10);
        baseLayer.i(a11);
        baseLayer.i(a12);
        a10.a(this);
        a11.a(this);
        a12.a(this);
    }

    @Override // h.d
    public <T> void a(T t2, @Nullable o.c<T> cVar) {
        if (t2 == i0.f1923l) {
            this.f48814g.n(cVar);
        } else if (t2 == i0.f1925n) {
            this.f48813f.n(cVar);
        } else if (t2 == i0.f1924m) {
            this.f48815h.n(cVar);
        }
    }

    public final void c() {
        this.f48818k = false;
        this.f48812e.invalidateSelf();
    }

    @Override // f.a.b
    public void e() {
        c();
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void f(List<Content> list, List<Content> list2) {
        for (int i10 = 0; i10 < list.size(); i10++) {
            Content content = list.get(i10);
            if (content instanceof t) {
                t tVar = (t) content;
                if (tVar.j() == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                    this.f48816i.a(tVar);
                    tVar.a(this);
                }
            }
            if (content instanceof p) {
                this.f48817j = ((p) content).h();
            }
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.f48810c;
    }

    @Override // e.l
    public Path getPath() {
        f.a<Float, Float> aVar;
        if (this.f48818k) {
            return this.f48808a;
        }
        this.f48808a.reset();
        if (this.f48811d) {
            this.f48818k = true;
            return this.f48808a;
        }
        PointF h10 = this.f48814g.h();
        float f10 = h10.x / 2.0f;
        float f11 = h10.y / 2.0f;
        f.a<?, Float> aVar2 = this.f48815h;
        float p10 = aVar2 == null ? 0.0f : ((f.d) aVar2).p();
        if (p10 == 0.0f && (aVar = this.f48817j) != null) {
            p10 = Math.min(aVar.h().floatValue(), Math.min(f10, f11));
        }
        float min = Math.min(f10, f11);
        if (p10 > min) {
            p10 = min;
        }
        PointF h11 = this.f48813f.h();
        this.f48808a.moveTo(h11.x + f10, (h11.y - f11) + p10);
        this.f48808a.lineTo(h11.x + f10, (h11.y + f11) - p10);
        if (p10 > 0.0f) {
            RectF rectF = this.f48809b;
            float f12 = h11.x;
            float f13 = p10 * 2.0f;
            float f14 = h11.y;
            rectF.set((f12 + f10) - f13, (f14 + f11) - f13, f12 + f10, f14 + f11);
            this.f48808a.arcTo(this.f48809b, 0.0f, 90.0f, false);
        }
        this.f48808a.lineTo((h11.x - f10) + p10, h11.y + f11);
        if (p10 > 0.0f) {
            RectF rectF2 = this.f48809b;
            float f15 = h11.x;
            float f16 = h11.y;
            float f17 = p10 * 2.0f;
            rectF2.set(f15 - f10, (f16 + f11) - f17, (f15 - f10) + f17, f16 + f11);
            this.f48808a.arcTo(this.f48809b, 90.0f, 90.0f, false);
        }
        this.f48808a.lineTo(h11.x - f10, (h11.y - f11) + p10);
        if (p10 > 0.0f) {
            RectF rectF3 = this.f48809b;
            float f18 = h11.x;
            float f19 = h11.y;
            float f20 = p10 * 2.0f;
            rectF3.set(f18 - f10, f19 - f11, (f18 - f10) + f20, (f19 - f11) + f20);
            this.f48808a.arcTo(this.f48809b, 180.0f, 90.0f, false);
        }
        this.f48808a.lineTo((h11.x + f10) - p10, h11.y - f11);
        if (p10 > 0.0f) {
            RectF rectF4 = this.f48809b;
            float f21 = h11.x;
            float f22 = p10 * 2.0f;
            float f23 = h11.y;
            rectF4.set((f21 + f10) - f22, f23 - f11, f21 + f10, (f23 - f11) + f22);
            this.f48808a.arcTo(this.f48809b, 270.0f, 90.0f, false);
        }
        this.f48808a.close();
        this.f48816i.b(this.f48808a);
        this.f48818k = true;
        return this.f48808a;
    }

    @Override // h.d
    public void h(h.c cVar, int i10, List<h.c> list, h.c cVar2) {
        n.g.k(cVar, i10, list, cVar2, this);
    }
}
