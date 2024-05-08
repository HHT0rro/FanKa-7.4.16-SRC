package e;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.i0;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import f.a;
import java.util.List;

/* compiled from: EllipseContent.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class e implements l, a.b, j {

    /* renamed from: b, reason: collision with root package name */
    public final String f48735b;

    /* renamed from: c, reason: collision with root package name */
    public final LottieDrawable f48736c;

    /* renamed from: d, reason: collision with root package name */
    public final f.a<?, PointF> f48737d;

    /* renamed from: e, reason: collision with root package name */
    public final f.a<?, PointF> f48738e;

    /* renamed from: f, reason: collision with root package name */
    public final j.b f48739f;

    /* renamed from: h, reason: collision with root package name */
    public boolean f48741h;

    /* renamed from: a, reason: collision with root package name */
    public final Path f48734a = new Path();

    /* renamed from: g, reason: collision with root package name */
    public final b f48740g = new b();

    public e(LottieDrawable lottieDrawable, BaseLayer baseLayer, j.b bVar) {
        this.f48735b = bVar.a();
        this.f48736c = lottieDrawable;
        f.a<PointF, PointF> a10 = bVar.c().a();
        this.f48737d = a10;
        f.a<PointF, PointF> a11 = bVar.b().a();
        this.f48738e = a11;
        this.f48739f = bVar;
        baseLayer.i(a10);
        baseLayer.i(a11);
        a10.a(this);
        a11.a(this);
    }

    @Override // h.d
    public <T> void a(T t2, @Nullable o.c<T> cVar) {
        if (t2 == i0.f1922k) {
            this.f48737d.n(cVar);
        } else if (t2 == i0.f1925n) {
            this.f48738e.n(cVar);
        }
    }

    public final void c() {
        this.f48741h = false;
        this.f48736c.invalidateSelf();
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
                    this.f48740g.a(tVar);
                    tVar.a(this);
                }
            }
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.f48735b;
    }

    @Override // e.l
    public Path getPath() {
        if (this.f48741h) {
            return this.f48734a;
        }
        this.f48734a.reset();
        if (this.f48739f.d()) {
            this.f48741h = true;
            return this.f48734a;
        }
        PointF h10 = this.f48737d.h();
        float f10 = h10.x / 2.0f;
        float f11 = h10.y / 2.0f;
        float f12 = f10 * 0.55228f;
        float f13 = 0.55228f * f11;
        this.f48734a.reset();
        if (this.f48739f.e()) {
            float f14 = -f11;
            this.f48734a.moveTo(0.0f, f14);
            float f15 = 0.0f - f12;
            float f16 = -f10;
            float f17 = 0.0f - f13;
            this.f48734a.cubicTo(f15, f14, f16, f17, f16, 0.0f);
            float f18 = f13 + 0.0f;
            this.f48734a.cubicTo(f16, f18, f15, f11, 0.0f, f11);
            float f19 = f12 + 0.0f;
            this.f48734a.cubicTo(f19, f11, f10, f18, f10, 0.0f);
            this.f48734a.cubicTo(f10, f17, f19, f14, 0.0f, f14);
        } else {
            float f20 = -f11;
            this.f48734a.moveTo(0.0f, f20);
            float f21 = f12 + 0.0f;
            float f22 = 0.0f - f13;
            this.f48734a.cubicTo(f21, f20, f10, f22, f10, 0.0f);
            float f23 = f13 + 0.0f;
            this.f48734a.cubicTo(f10, f23, f21, f11, 0.0f, f11);
            float f24 = 0.0f - f12;
            float f25 = -f10;
            this.f48734a.cubicTo(f24, f11, f25, f23, f25, 0.0f);
            this.f48734a.cubicTo(f25, f22, f24, f20, 0.0f, f20);
        }
        PointF h11 = this.f48738e.h();
        this.f48734a.offset(h11.x, h11.y);
        this.f48734a.close();
        this.f48740g.b(this.f48734a);
        this.f48741h = true;
        return this.f48734a;
    }

    @Override // h.d
    public void h(h.c cVar, int i10, List<h.c> list, h.c cVar2) {
        n.g.k(cVar, i10, list, cVar2, this);
    }
}
