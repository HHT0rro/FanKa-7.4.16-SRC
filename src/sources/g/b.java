package g;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import androidx.annotation.Nullable;
import com.airbnb.lottie.e0;
import java.io.IOException;
import java.util.Map;
import n.d;
import n.h;
import org.apache.commons.io.IOUtils;

/* compiled from: ImageAssetManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class b {

    /* renamed from: e, reason: collision with root package name */
    public static final Object f49355e = new Object();

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public final Context f49356a;

    /* renamed from: b, reason: collision with root package name */
    public final String f49357b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public com.airbnb.lottie.b f49358c;

    /* renamed from: d, reason: collision with root package name */
    public final Map<String, e0> f49359d;

    public b(Drawable.Callback callback, String str, com.airbnb.lottie.b bVar, Map<String, e0> map) {
        if (!TextUtils.isEmpty(str) && str.charAt(str.length() - 1) != '/') {
            this.f49357b = str + IOUtils.DIR_SEPARATOR_UNIX;
        } else {
            this.f49357b = str;
        }
        this.f49359d = map;
        d(bVar);
        if (!(callback instanceof View)) {
            this.f49356a = null;
        } else {
            this.f49356a = ((View) callback).getContext().getApplicationContext();
        }
    }

    @Nullable
    public Bitmap a(String str) {
        e0 e0Var = this.f49359d.get(str);
        if (e0Var == null) {
            return null;
        }
        Bitmap a10 = e0Var.a();
        if (a10 != null) {
            return a10;
        }
        com.airbnb.lottie.b bVar = this.f49358c;
        if (bVar != null) {
            Bitmap a11 = bVar.a(e0Var);
            if (a11 != null) {
                c(str, a11);
            }
            return a11;
        }
        Context context = this.f49356a;
        if (context == null) {
            return null;
        }
        String b4 = e0Var.b();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = true;
        options.inDensity = 160;
        if (b4.startsWith("data:") && b4.indexOf("base64,") > 0) {
            try {
                byte[] decode = Base64.decode(b4.substring(b4.indexOf(44) + 1), 0);
                return c(str, BitmapFactory.decodeByteArray(decode, 0, decode.length, options));
            } catch (IllegalArgumentException e2) {
                d.d("data URL did not have correct base64 format.", e2);
                return null;
            }
        }
        try {
            if (!TextUtils.isEmpty(this.f49357b)) {
                try {
                    Bitmap decodeStream = BitmapFactory.decodeStream(context.getAssets().open(this.f49357b + b4), null, options);
                    if (decodeStream == null) {
                        d.c("Decoded image `" + str + "` is null.");
                        return null;
                    }
                    return c(str, h.l(decodeStream, e0Var.e(), e0Var.c()));
                } catch (IllegalArgumentException e10) {
                    d.d("Unable to decode image `" + str + "`.", e10);
                    return null;
                }
            }
            throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
        } catch (IOException e11) {
            d.d("Unable to open asset.", e11);
            return null;
        }
    }

    public boolean b(Context context) {
        return (context == null && this.f49356a == null) || this.f49356a.equals(context);
    }

    public final Bitmap c(String str, @Nullable Bitmap bitmap) {
        synchronized (f49355e) {
            this.f49359d.get(str).f(bitmap);
        }
        return bitmap;
    }

    public void d(@Nullable com.airbnb.lottie.b bVar) {
        this.f49358c = bVar;
    }

    @Nullable
    public Bitmap e(String str, @Nullable Bitmap bitmap) {
        if (bitmap == null) {
            e0 e0Var = this.f49359d.get(str);
            Bitmap a10 = e0Var.a();
            e0Var.f(null);
            return a10;
        }
        Bitmap a11 = this.f49359d.get(str).a();
        c(str, bitmap);
        return a11;
    }
}
