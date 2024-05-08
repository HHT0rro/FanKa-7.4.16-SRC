package e;

import android.graphics.Path;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import f.a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ShapeContent.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class q implements l, a.b {

    /* renamed from: b, reason: collision with root package name */
    public final String f48834b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f48835c;

    /* renamed from: d, reason: collision with root package name */
    public final LottieDrawable f48836d;

    /* renamed from: e, reason: collision with root package name */
    public final f.m f48837e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f48838f;

    /* renamed from: a, reason: collision with root package name */
    public final Path f48833a = new Path();

    /* renamed from: g, reason: collision with root package name */
    public final b f48839g = new b();

    public q(LottieDrawable lottieDrawable, BaseLayer baseLayer, j.j jVar) {
        this.f48834b = jVar.a();
        this.f48835c = jVar.c();
        this.f48836d = lottieDrawable;
        f.m a10 = jVar.b().a();
        this.f48837e = a10;
        baseLayer.i(a10);
        a10.a(this);
    }

    public final void a() {
        this.f48838f = false;
        this.f48836d.invalidateSelf();
    }

    @Override // f.a.b
    public void e() {
        a();
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void f(List<Content> list, List<Content> list2) {
        ArrayList arrayList = null;
        for (int i10 = 0; i10 < list.size(); i10++) {
            Content content = list.get(i10);
            if (content instanceof t) {
                t tVar = (t) content;
                if (tVar.j() == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                    this.f48839g.a(tVar);
                    tVar.a(this);
                }
            }
            if (content instanceof r) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add((r) content);
            }
        }
        this.f48837e.q(arrayList);
    }

    @Override // e.l
    public Path getPath() {
        if (this.f48838f) {
            return this.f48833a;
        }
        this.f48833a.reset();
        if (this.f48835c) {
            this.f48838f = true;
            return this.f48833a;
        }
        Path h10 = this.f48837e.h();
        if (h10 == null) {
            return this.f48833a;
        }
        this.f48833a.set(h10);
        this.f48833a.setFillType(Path.FillType.EVEN_ODD);
        this.f48839g.b(this.f48833a);
        this.f48838f = true;
        return this.f48833a;
    }
}
