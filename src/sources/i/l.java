package i;

import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.layer.BaseLayer;
import f.p;

/* compiled from: AnimatableTransform.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class l implements ContentModel {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public final e f49663a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public final m<PointF, PointF> f49664b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public final g f49665c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public final b f49666d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public final d f49667e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public final b f49668f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public final b f49669g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public final b f49670h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    public final b f49671i;

    public l() {
        this(null, null, null, null, null, null, null, null, null);
    }

    public p a() {
        return new p(this);
    }

    @Nullable
    public e b() {
        return this.f49663a;
    }

    @Nullable
    public b c() {
        return this.f49671i;
    }

    @Nullable
    public d d() {
        return this.f49667e;
    }

    @Nullable
    public m<PointF, PointF> e() {
        return this.f49664b;
    }

    @Nullable
    public b f() {
        return this.f49666d;
    }

    @Nullable
    public g g() {
        return this.f49665c;
    }

    @Nullable
    public b h() {
        return this.f49668f;
    }

    @Nullable
    public b i() {
        return this.f49669g;
    }

    @Nullable
    public b j() {
        return this.f49670h;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    @Nullable
    public Content toContent(LottieDrawable lottieDrawable, LottieComposition lottieComposition, BaseLayer baseLayer) {
        return null;
    }

    public l(@Nullable e eVar, @Nullable m<PointF, PointF> mVar, @Nullable g gVar, @Nullable b bVar, @Nullable d dVar, @Nullable b bVar2, @Nullable b bVar3, @Nullable b bVar4, @Nullable b bVar5) {
        this.f49663a = eVar;
        this.f49664b = mVar;
        this.f49665c = gVar;
        this.f49666d = bVar;
        this.f49667e = dVar;
        this.f49670h = bVar2;
        this.f49671i = bVar3;
        this.f49668f = bVar4;
        this.f49669g = bVar5;
    }
}
