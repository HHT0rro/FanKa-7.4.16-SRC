package j;

import android.graphics.PointF;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.layer.BaseLayer;
import e.n;
import i.m;

/* compiled from: RectangleShape.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class e implements ContentModel {

    /* renamed from: a, reason: collision with root package name */
    public final String f50199a;

    /* renamed from: b, reason: collision with root package name */
    public final m<PointF, PointF> f50200b;

    /* renamed from: c, reason: collision with root package name */
    public final m<PointF, PointF> f50201c;

    /* renamed from: d, reason: collision with root package name */
    public final i.b f50202d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f50203e;

    public e(String str, m<PointF, PointF> mVar, m<PointF, PointF> mVar2, i.b bVar, boolean z10) {
        this.f50199a = str;
        this.f50200b = mVar;
        this.f50201c = mVar2;
        this.f50202d = bVar;
        this.f50203e = z10;
    }

    public i.b a() {
        return this.f50202d;
    }

    public String b() {
        return this.f50199a;
    }

    public m<PointF, PointF> c() {
        return this.f50200b;
    }

    public m<PointF, PointF> d() {
        return this.f50201c;
    }

    public boolean e() {
        return this.f50203e;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content toContent(LottieDrawable lottieDrawable, LottieComposition lottieComposition, BaseLayer baseLayer) {
        return new n(lottieDrawable, baseLayer, this);
    }

    public String toString() {
        return "RectangleShape{position=" + ((Object) this.f50200b) + ", size=" + ((Object) this.f50201c) + '}';
    }
}
