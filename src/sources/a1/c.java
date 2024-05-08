package a1;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.annotation.ColorInt;
import ce.n;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.load.resource.bitmap.TransformationUtils;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CircleCropWithBorderTransformation.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class c extends BitmapTransformation {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f679c = new a(null);

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final byte[] f680d;

    /* renamed from: a, reason: collision with root package name */
    public final int f681a;

    /* renamed from: b, reason: collision with root package name */
    public final int f682b;

    /* compiled from: CircleCropWithBorderTransformation.kt */
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
        byte[] bytes = "com.cupidapp.live.base.imageloader.glide.CircleCropWithBorderTransformation.1".getBytes(CHARSET);
        s.h(bytes, "this as java.lang.String).getBytes(charset)");
        f680d = bytes;
    }

    public c(int i10, @ColorInt int i11) {
        this.f681a = i10;
        this.f682b = i11;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (cVar.f681a == this.f681a && cVar.f682b == this.f682b) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return Util.hashCode(this.f682b, Util.hashCode(1351099259, Util.hashCode(this.f681a)));
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    @NotNull
    public Bitmap transform(@NotNull BitmapPool pool, @NotNull Bitmap toTransform, int i10, int i11) {
        s.i(pool, "pool");
        s.i(toTransform, "toTransform");
        Bitmap bitmap = TransformationUtils.circleCrop(pool, toTransform, i10, i11);
        bitmap.setDensity(toTransform.getDensity());
        Paint paint = new Paint(1);
        paint.setColor(this.f682b);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.f681a);
        new Canvas(bitmap).drawCircle(i10 / 2.0f, i11 / 2.0f, (n.b(i10, i11) / 2.0f) - (this.f681a / 2.0f), paint);
        s.h(bitmap, "bitmap");
        return bitmap;
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@NotNull MessageDigest messageDigest) {
        s.i(messageDigest, "messageDigest");
        messageDigest.update(f680d);
        messageDigest.update(ByteBuffer.allocate(16).putInt(this.f681a).putInt(this.f682b).array());
    }
}
