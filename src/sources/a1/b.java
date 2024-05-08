package a1;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.annotation.ColorInt;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BorderRoundTransformation.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class b extends BitmapTransformation {

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public static final a f670h = new a(null);

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public static final byte[] f671i;

    /* renamed from: a, reason: collision with root package name */
    public final int f672a;

    /* renamed from: b, reason: collision with root package name */
    public final int f673b;

    /* renamed from: c, reason: collision with root package name */
    public final int f674c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f675d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f676e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f677f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f678g;

    /* compiled from: BorderRoundTransformation.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final float[] a(boolean z10, boolean z11, boolean z12, boolean z13, float f10) {
            float[] fArr = new float[8];
            fArr[0] = z10 ? f10 : 0.0f;
            fArr[1] = z10 ? f10 : 0.0f;
            fArr[2] = z11 ? f10 : 0.0f;
            fArr[3] = z11 ? f10 : 0.0f;
            fArr[4] = z12 ? f10 : 0.0f;
            fArr[5] = z12 ? f10 : 0.0f;
            fArr[6] = z13 ? f10 : 0.0f;
            if (!z13) {
                f10 = 0.0f;
            }
            fArr[7] = f10;
            return fArr;
        }
    }

    static {
        Charset CHARSET = Key.CHARSET;
        s.h(CHARSET, "CHARSET");
        byte[] bytes = "com.cupidapp.live.base.imageloader.glide.BorderRoundTransformation.1".getBytes(CHARSET);
        s.h(bytes, "this as java.lang.String).getBytes(charset)");
        f671i = bytes;
    }

    public b(int i10, int i11, @ColorInt int i12, boolean z10, boolean z11, boolean z12, boolean z13) {
        this.f672a = i10;
        this.f673b = i11;
        this.f674c = i12;
        this.f675d = z10;
        this.f676e = z11;
        this.f677f = z12;
        this.f678g = z13;
    }

    public final int a(boolean z10) {
        return z10 ? 1 : 0;
    }

    public final int b() {
        return (a(this.f675d) * 1000) + (a(this.f676e) * 100) + (a(this.f677f) * 10) + (a(this.f678g) * 1);
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (bVar.f672a == this.f672a && bVar.f673b == this.f673b && bVar.f674c == this.f674c && bVar.f675d == this.f675d && bVar.f676e == this.f676e && bVar.f677f == this.f677f && bVar.f678g == this.f678g) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return Util.hashCode(this.f678g, Util.hashCode(this.f677f, Util.hashCode(this.f676e, Util.hashCode(this.f675d, Util.hashCode(this.f674c, Util.hashCode(this.f673b, Util.hashCode(-1498527183, Util.hashCode(this.f672a))))))));
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    @NotNull
    public Bitmap transform(@NotNull BitmapPool pool, @NotNull Bitmap toTransform, int i10, int i11) {
        s.i(pool, "pool");
        s.i(toTransform, "toTransform");
        int width = toTransform.getWidth();
        int height = toTransform.getHeight();
        Bitmap bitmap = pool.get(width, height, Bitmap.Config.ARGB_8888);
        s.h(bitmap, "pool.get(width, height, Bitmap.Config.ARGB_8888)");
        bitmap.setDensity(toTransform.getDensity());
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint.setShader(new BitmapShader(toTransform, tileMode, tileMode));
        float[] a10 = f670h.a(this.f675d, this.f676e, this.f677f, this.f678g, this.f672a);
        float f10 = this.f673b / 2.0f;
        RectF rectF = new RectF(f10, f10, width - f10, height - f10);
        Path path = new Path();
        path.addRoundRect(rectF, a10, Path.Direction.CW);
        canvas.drawPath(path, paint);
        if (this.f673b > 0) {
            Paint paint2 = new Paint(1);
            paint2.setColor(this.f674c);
            paint2.setStyle(Paint.Style.STROKE);
            paint2.setStrokeWidth(this.f673b);
            canvas.drawPath(path, paint2);
        }
        return bitmap;
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@NotNull MessageDigest messageDigest) {
        s.i(messageDigest, "messageDigest");
        messageDigest.update(f671i);
        messageDigest.update(ByteBuffer.allocate(16).putInt(this.f672a).putInt(this.f673b).putInt(this.f674c).putInt(b()).array());
    }
}
