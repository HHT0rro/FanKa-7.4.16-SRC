package j;

import android.graphics.PointF;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.layer.BaseLayer;
import i.m;

/* compiled from: CircleShape.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class b implements ContentModel {

    /* renamed from: a, reason: collision with root package name */
    public final String f50182a;

    /* renamed from: b, reason: collision with root package name */
    public final m<PointF, PointF> f50183b;

    /* renamed from: c, reason: collision with root package name */
    public final i.f f50184c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f50185d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f50186e;

    public b(String str, m<PointF, PointF> mVar, i.f fVar, boolean z10, boolean z11) {
        this.f50182a = str;
        this.f50183b = mVar;
        this.f50184c = fVar;
        this.f50185d = z10;
        this.f50186e = z11;
    }

    public String a() {
        return this.f50182a;
    }

    public m<PointF, PointF> b() {
        return this.f50183b;
    }

    public i.f c() {
        return this.f50184c;
    }

    public boolean d() {
        return this.f50186e;
    }

    public boolean e() {
        return this.f50185d;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content toContent(LottieDrawable lottieDrawable, LottieComposition lottieComposition, BaseLayer baseLayer) {
        return new e.e(lottieDrawable, baseLayer, this);
    }
}
