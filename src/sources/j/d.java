package j;

import android.graphics.Path;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.layer.BaseLayer;

/* compiled from: GradientFill.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class d implements ContentModel {

    /* renamed from: a, reason: collision with root package name */
    public final GradientType f50189a;

    /* renamed from: b, reason: collision with root package name */
    public final Path.FillType f50190b;

    /* renamed from: c, reason: collision with root package name */
    public final i.c f50191c;

    /* renamed from: d, reason: collision with root package name */
    public final i.d f50192d;

    /* renamed from: e, reason: collision with root package name */
    public final i.f f50193e;

    /* renamed from: f, reason: collision with root package name */
    public final i.f f50194f;

    /* renamed from: g, reason: collision with root package name */
    public final String f50195g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public final i.b f50196h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    public final i.b f50197i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f50198j;

    public d(String str, GradientType gradientType, Path.FillType fillType, i.c cVar, i.d dVar, i.f fVar, i.f fVar2, i.b bVar, i.b bVar2, boolean z10) {
        this.f50189a = gradientType;
        this.f50190b = fillType;
        this.f50191c = cVar;
        this.f50192d = dVar;
        this.f50193e = fVar;
        this.f50194f = fVar2;
        this.f50195g = str;
        this.f50196h = bVar;
        this.f50197i = bVar2;
        this.f50198j = z10;
    }

    public i.f a() {
        return this.f50194f;
    }

    public Path.FillType b() {
        return this.f50190b;
    }

    public i.c c() {
        return this.f50191c;
    }

    public GradientType d() {
        return this.f50189a;
    }

    public String e() {
        return this.f50195g;
    }

    public i.d f() {
        return this.f50192d;
    }

    public i.f g() {
        return this.f50193e;
    }

    public boolean h() {
        return this.f50198j;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content toContent(LottieDrawable lottieDrawable, LottieComposition lottieComposition, BaseLayer baseLayer) {
        return new e.g(lottieDrawable, lottieComposition, baseLayer, this);
    }
}
