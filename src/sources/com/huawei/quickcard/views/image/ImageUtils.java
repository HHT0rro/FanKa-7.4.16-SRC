package com.huawei.quickcard.views.image;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.core.util.Pair;
import com.huawei.quickcard.base.annotation.DoNotShrink;
import com.huawei.quickcard.views.image.extension.FitMode;
import com.huawei.quickcard.views.image.extension.ImageOptions;
import com.huawei.quickcard.views.image.view.IImageHost;

@DoNotShrink
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ImageUtils {
    public static final String ASSETS = "res://assets/";
    public static final String ASSETS_PREFIX = "file:///android_asset/";
    public static final String DRAWABLE = "res://drawable/";
    public static final String MIPMAP = "res://mipmap/";
    public static final String RAW = "res://raw/";

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f34521a;

        static {
            int[] iArr = new int[FitMode.values().length];
            f34521a = iArr;
            try {
                iArr[FitMode.COVER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f34521a[FitMode.CONTAIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f34521a[FitMode.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f34521a[FitMode.FILL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f34521a[FitMode.SCALE_DOWN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static IImageHost castViewToImageHost(View view) {
        if (view instanceof IImageHost) {
            return (IImageHost) view;
        }
        return null;
    }

    @NonNull
    public static ImageView.ScaleType glideScaleType(FitMode fitMode, ImageView.ScaleType scaleType) {
        if (fitMode == null) {
            return scaleType;
        }
        int i10 = a.f34521a[fitMode.ordinal()];
        if (i10 == 1) {
            return ImageView.ScaleType.CENTER_CROP;
        }
        if (i10 == 2) {
            return ImageView.ScaleType.FIT_CENTER;
        }
        if (i10 == 3) {
            return ImageView.ScaleType.CENTER_INSIDE;
        }
        if (i10 != 4) {
            return i10 != 5 ? scaleType : ImageView.ScaleType.CENTER;
        }
        return ImageView.ScaleType.FIT_XY;
    }

    public static boolean isAppImage(@NonNull String str) {
        return str.startsWith("res://");
    }

    public static boolean isAssetsImage(@NonNull String str) {
        return str.startsWith("file:///android_asset/");
    }

    public static boolean isBase64Img(@NonNull String str) {
        return str.startsWith("data:image/");
    }

    public static boolean isNetImage(@NonNull String str) {
        return str.startsWith("http://") || str.startsWith("https://");
    }

    public static void loadDrawable(@NonNull ImageOptions imageOptions, @NonNull ImageView imageView) {
        Pair<String, Drawable> placeHolder = imageOptions.getPlaceHolder();
        if (placeHolder != null) {
            imageView.setImageDrawable(placeHolder.second);
        }
    }
}
