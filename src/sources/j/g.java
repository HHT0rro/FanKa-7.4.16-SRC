package j;

import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.layer.BaseLayer;
import e.p;
import i.m;

/* compiled from: RoundedCorners.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class g implements ContentModel {

    /* renamed from: a, reason: collision with root package name */
    public final String f50209a;

    /* renamed from: b, reason: collision with root package name */
    public final m<Float, Float> f50210b;

    public g(String str, m<Float, Float> mVar) {
        this.f50209a = str;
        this.f50210b = mVar;
    }

    public m<Float, Float> a() {
        return this.f50210b;
    }

    public String b() {
        return this.f50209a;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    @Nullable
    public Content toContent(LottieDrawable lottieDrawable, LottieComposition lottieComposition, BaseLayer baseLayer) {
        return new p(lottieDrawable, baseLayer, this);
    }
}
