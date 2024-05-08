package e;

import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import f.a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TrimPathContent.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class t implements Content, a.b {

    /* renamed from: a, reason: collision with root package name */
    public final String f48845a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f48846b;

    /* renamed from: c, reason: collision with root package name */
    public final List<a.b> f48847c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public final ShapeTrimPath.Type f48848d;

    /* renamed from: e, reason: collision with root package name */
    public final f.a<?, Float> f48849e;

    /* renamed from: f, reason: collision with root package name */
    public final f.a<?, Float> f48850f;

    /* renamed from: g, reason: collision with root package name */
    public final f.a<?, Float> f48851g;

    public t(BaseLayer baseLayer, ShapeTrimPath shapeTrimPath) {
        this.f48845a = shapeTrimPath.b();
        this.f48846b = shapeTrimPath.f();
        this.f48848d = shapeTrimPath.e();
        f.a<Float, Float> a10 = shapeTrimPath.d().a();
        this.f48849e = a10;
        f.a<Float, Float> a11 = shapeTrimPath.a().a();
        this.f48850f = a11;
        f.a<Float, Float> a12 = shapeTrimPath.c().a();
        this.f48851g = a12;
        baseLayer.i(a10);
        baseLayer.i(a11);
        baseLayer.i(a12);
        a10.a(this);
        a11.a(this);
        a12.a(this);
    }

    public void a(a.b bVar) {
        this.f48847c.add(bVar);
    }

    public f.a<?, Float> c() {
        return this.f48850f;
    }

    @Override // f.a.b
    public void e() {
        for (int i10 = 0; i10 < this.f48847c.size(); i10++) {
            this.f48847c.get(i10).e();
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void f(List<Content> list, List<Content> list2) {
    }

    public f.a<?, Float> h() {
        return this.f48851g;
    }

    public f.a<?, Float> i() {
        return this.f48849e;
    }

    public ShapeTrimPath.Type j() {
        return this.f48848d;
    }

    public boolean k() {
        return this.f48846b;
    }
}
