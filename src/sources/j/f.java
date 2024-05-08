package j;

import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.layer.BaseLayer;
import e.o;
import i.l;

/* compiled from: Repeater.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class f implements ContentModel {

    /* renamed from: a, reason: collision with root package name */
    public final String f50204a;

    /* renamed from: b, reason: collision with root package name */
    public final i.b f50205b;

    /* renamed from: c, reason: collision with root package name */
    public final i.b f50206c;

    /* renamed from: d, reason: collision with root package name */
    public final l f50207d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f50208e;

    public f(String str, i.b bVar, i.b bVar2, l lVar, boolean z10) {
        this.f50204a = str;
        this.f50205b = bVar;
        this.f50206c = bVar2;
        this.f50207d = lVar;
        this.f50208e = z10;
    }

    public i.b a() {
        return this.f50205b;
    }

    public String b() {
        return this.f50204a;
    }

    public i.b c() {
        return this.f50206c;
    }

    public l d() {
        return this.f50207d;
    }

    public boolean e() {
        return this.f50208e;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    @Nullable
    public Content toContent(LottieDrawable lottieDrawable, LottieComposition lottieComposition, BaseLayer baseLayer) {
        return new o(lottieDrawable, baseLayer, this);
    }
}
