package j;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.layer.BaseLayer;
import java.util.Arrays;
import java.util.List;

/* compiled from: ShapeGroup.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class i implements ContentModel {

    /* renamed from: a, reason: collision with root package name */
    public final String f50217a;

    /* renamed from: b, reason: collision with root package name */
    public final List<ContentModel> f50218b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f50219c;

    public i(String str, List<ContentModel> list, boolean z10) {
        this.f50217a = str;
        this.f50218b = list;
        this.f50219c = z10;
    }

    public List<ContentModel> a() {
        return this.f50218b;
    }

    public String b() {
        return this.f50217a;
    }

    public boolean c() {
        return this.f50219c;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content toContent(LottieDrawable lottieDrawable, LottieComposition lottieComposition, BaseLayer baseLayer) {
        return new e.c(lottieDrawable, baseLayer, this, lottieComposition);
    }

    public String toString() {
        return "ShapeGroup{name='" + this.f50217a + "' Shapes: " + Arrays.toString(this.f50218b.toArray()) + '}';
    }
}
