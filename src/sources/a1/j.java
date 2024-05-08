package a1;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: GrayTransformation.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class j extends BitmapTransformation {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f692a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final byte[] f693b;

    /* compiled from: GrayTransformation.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Charset CHARSET = Key.CHARSET;
        s.h(CHARSET, "CHARSET");
        byte[] bytes = "com.cupidapp.live.base.imageloader.glide.GrayTransformation.1".getBytes(CHARSET);
        s.h(bytes, "this as java.lang.String).getBytes(charset)");
        f693b = bytes;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(@Nullable Object obj) {
        return obj instanceof j;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return -1786601044;
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    @NotNull
    public Bitmap transform(@NotNull BitmapPool pool, @NotNull Bitmap toTransform, int i10, int i11) {
        s.i(pool, "pool");
        s.i(toTransform, "toTransform");
        Bitmap bitmap = pool.get(toTransform.getWidth(), toTransform.getHeight(), toTransform.getConfig() != null ? toTransform.getConfig() : Bitmap.Config.ARGB_8888);
        s.h(bitmap, "pool.get(toTransform.wid…Transform.height, config)");
        Canvas canvas = new Canvas(bitmap);
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        Paint paint = new Paint();
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(toTransform, 0.0f, 0.0f, paint);
        return bitmap;
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@NotNull MessageDigest messageDigest) {
        s.i(messageDigest, "messageDigest");
        messageDigest.update(f693b);
    }
}
