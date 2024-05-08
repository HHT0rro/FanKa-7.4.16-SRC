package j;

import android.graphics.Path;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.layer.BaseLayer;

/* compiled from: ShapeFill.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class h implements ContentModel {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f50211a;

    /* renamed from: b, reason: collision with root package name */
    public final Path.FillType f50212b;

    /* renamed from: c, reason: collision with root package name */
    public final String f50213c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public final i.a f50214d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public final i.d f50215e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f50216f;

    public h(String str, boolean z10, Path.FillType fillType, @Nullable i.a aVar, @Nullable i.d dVar, boolean z11) {
        this.f50213c = str;
        this.f50211a = z10;
        this.f50212b = fillType;
        this.f50214d = aVar;
        this.f50215e = dVar;
        this.f50216f = z11;
    }

    @Nullable
    public i.a a() {
        return this.f50214d;
    }

    public Path.FillType b() {
        return this.f50212b;
    }

    public String c() {
        return this.f50213c;
    }

    @Nullable
    public i.d d() {
        return this.f50215e;
    }

    public boolean e() {
        return this.f50216f;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content toContent(LottieDrawable lottieDrawable, LottieComposition lottieComposition, BaseLayer baseLayer) {
        return new e.f(lottieDrawable, baseLayer, this);
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.f50211a + '}';
    }
}
