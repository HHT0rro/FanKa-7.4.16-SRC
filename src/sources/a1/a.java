package a1;

import a1.k;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.renderscript.RSRuntimeException;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.util.Util;
import com.cupidapp.live.AppApplication;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BlurTransformation.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class a extends BitmapTransformation {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final C0009a f666c = new C0009a(null);

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final byte[] f667d;

    /* renamed from: a, reason: collision with root package name */
    public final float f668a;

    /* renamed from: b, reason: collision with root package name */
    public final int f669b;

    /* compiled from: BlurTransformation.kt */
    @kotlin.d
    /* renamed from: a1.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class C0009a {
        public C0009a() {
        }

        public /* synthetic */ C0009a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Charset CHARSET = Key.CHARSET;
        s.h(CHARSET, "CHARSET");
        byte[] bytes = "com.cupidapp.live.base.imageloader.glide.BlurTransformation.1".getBytes(CHARSET);
        s.h(bytes, "this as java.lang.String).getBytes(charset)");
        f667d = bytes;
    }

    public a(float f10, int i10) {
        this.f668a = f10;
        this.f669b = i10;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if ((aVar.f668a == this.f668a) && aVar.f669b == this.f669b) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return Util.hashCode(this.f669b, Util.hashCode(1679540144, Util.hashCode(this.f668a)));
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    @NotNull
    public Bitmap transform(@NotNull BitmapPool pool, @NotNull Bitmap toTransform, int i10, int i11) {
        s.i(pool, "pool");
        s.i(toTransform, "toTransform");
        Bitmap bitmap = pool.get(toTransform.getWidth() / this.f669b, toTransform.getHeight() / this.f669b, Bitmap.Config.ARGB_8888);
        s.h(bitmap, "pool.get(scaleWidth, sca… Bitmap.Config.ARGB_8888)");
        bitmap.setDensity(toTransform.getDensity());
        Canvas canvas = new Canvas(bitmap);
        float f10 = 1;
        int i12 = this.f669b;
        canvas.scale(f10 / i12, f10 / i12);
        Paint paint = new Paint();
        paint.setFlags(2);
        canvas.drawBitmap(toTransform, 0.0f, 0.0f, paint);
        try {
            k.a aVar = k.f694a;
            Context applicationContext = AppApplication.f11612d.h().getApplicationContext();
            s.h(applicationContext, "AppApplication.shareInstance.applicationContext");
            return aVar.a(applicationContext, bitmap, this.f668a);
        } catch (RSRuntimeException unused) {
            Bitmap a10 = d.a(bitmap, (int) this.f668a, true);
            s.h(a10, "{\n            FastBlur.b….toInt(), true)\n        }");
            return a10;
        }
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@NotNull MessageDigest messageDigest) {
        s.i(messageDigest, "messageDigest");
        messageDigest.update(f667d);
        messageDigest.update(ByteBuffer.allocate(16).putFloat(this.f668a).putInt(this.f669b).array());
    }
}
