package g;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.Nullable;
import h.g;
import java.util.HashMap;
import java.util.Map;
import n.d;

/* compiled from: FontAssetManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class a {

    /* renamed from: d, reason: collision with root package name */
    public final AssetManager f49353d;

    /* renamed from: a, reason: collision with root package name */
    public final g<String> f49350a = new g<>();

    /* renamed from: b, reason: collision with root package name */
    public final Map<g<String>, Typeface> f49351b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final Map<String, Typeface> f49352c = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    public String f49354e = ".ttf";

    public a(Drawable.Callback callback, @Nullable com.airbnb.lottie.a aVar) {
        if (!(callback instanceof View)) {
            d.c("LottieDrawable must be inside of a view for images to work.");
            this.f49353d = null;
        } else {
            this.f49353d = ((View) callback).getContext().getAssets();
        }
    }

    public final Typeface a(h.a aVar) {
        String a10 = aVar.a();
        Typeface typeface = this.f49352c.get(a10);
        if (typeface != null) {
            return typeface;
        }
        aVar.c();
        aVar.b();
        if (aVar.d() != null) {
            return aVar.d();
        }
        Typeface createFromAsset = Typeface.createFromAsset(this.f49353d, "fonts/" + a10 + this.f49354e);
        this.f49352c.put(a10, createFromAsset);
        return createFromAsset;
    }

    public Typeface b(h.a aVar) {
        this.f49350a.b(aVar.a(), aVar.c());
        Typeface typeface = this.f49351b.get(this.f49350a);
        if (typeface != null) {
            return typeface;
        }
        Typeface e2 = e(a(aVar), aVar.c());
        this.f49351b.put(this.f49350a, e2);
        return e2;
    }

    public void c(String str) {
        this.f49354e = str;
    }

    public void d(@Nullable com.airbnb.lottie.a aVar) {
    }

    public final Typeface e(Typeface typeface, String str) {
        boolean contains = str.contains("Italic");
        boolean contains2 = str.contains("Bold");
        int i10 = (contains && contains2) ? 3 : contains ? 2 : contains2 ? 1 : 0;
        return typeface.getStyle() == i10 ? typeface : Typeface.create(typeface, i10);
    }
}
