package j;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.layer.BaseLayer;
import e.q;

/* compiled from: ShapePath.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class j implements ContentModel {

    /* renamed from: a, reason: collision with root package name */
    public final String f50220a;

    /* renamed from: b, reason: collision with root package name */
    public final int f50221b;

    /* renamed from: c, reason: collision with root package name */
    public final i.h f50222c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f50223d;

    public j(String str, int i10, i.h hVar, boolean z10) {
        this.f50220a = str;
        this.f50221b = i10;
        this.f50222c = hVar;
        this.f50223d = z10;
    }

    public String a() {
        return this.f50220a;
    }

    public i.h b() {
        return this.f50222c;
    }

    public boolean c() {
        return this.f50223d;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content toContent(LottieDrawable lottieDrawable, LottieComposition lottieComposition, BaseLayer baseLayer) {
        return new q(lottieDrawable, baseLayer, this);
    }

    public String toString() {
        return "ShapePath{name=" + this.f50220a + ", index=" + this.f50221b + '}';
    }
}
