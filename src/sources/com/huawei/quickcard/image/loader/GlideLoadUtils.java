package com.huawei.quickcard.image.loader;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.huawei.quickcard.base.annotation.DoNotShrink;
import com.huawei.quickcard.image.b;
import com.huawei.quickcard.image.c;
import com.huawei.quickcard.image.listener.DrawableListener;
import com.huawei.quickcard.utils.StrUtils;
import com.huawei.quickcard.views.image.ImageConfig;
import com.huawei.quickcard.views.image.ImageUtils;
import com.huawei.quickcard.views.image.extension.ClipRect;
import com.huawei.quickcard.views.image.extension.IAppResProvider;
import com.huawei.quickcard.views.image.extension.ImageOptions;

@DoNotShrink
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class GlideLoadUtils {
    @NonNull
    private static String a(@Nullable String str) {
        String null2Empty = StrUtils.null2Empty(str);
        return (null2Empty.indexOf("../") == -1 && null2Empty.indexOf("./") == -1 && null2Empty.indexOf("..") == -1) ? null2Empty : "";
    }

    public static RequestOptions applyClipRect(@NonNull ImageOptions imageOptions, @NonNull RequestOptions requestOptions) {
        ClipRect clipRect = imageOptions.getClipRect();
        return (clipRect == null || clipRect.isEmpty()) ? requestOptions : requestOptions.transform(new c(clipRect));
    }

    public static RequestOptions applyEnableCache(@NonNull ImageOptions imageOptions, @NonNull RequestOptions requestOptions) {
        if (imageOptions.isEnableCache()) {
            return requestOptions.diskCacheStrategy(DiskCacheStrategy.AUTOMATIC);
        }
        return requestOptions.diskCacheStrategy(DiskCacheStrategy.NONE).skipMemoryCache(true);
    }

    public static void applyFitMode(@NonNull ImageOptions imageOptions, @NonNull ImageView imageView) {
        imageView.setScaleType(ImageUtils.glideScaleType(imageOptions.getFitMode(), imageView.getScaleType()));
    }

    @Deprecated
    public static RequestOptions applyPlaceHolder(@NonNull ImageOptions imageOptions, @NonNull RequestOptions requestOptions) {
        return applyPlaceHolder(null, imageOptions, requestOptions);
    }

    @Deprecated
    public static RequestOptions applySize(@NonNull ImageOptions imageOptions, @NonNull RequestOptions requestOptions) {
        int width = imageOptions.getWidth();
        int height = imageOptions.getHeight();
        return (width <= 0 || height <= 0) ? requestOptions : requestOptions.diskCacheStrategy(DiskCacheStrategy.RESOURCE).override(width, height);
    }

    public static RequestOptions applyTransform(@NonNull ImageOptions imageOptions, @NonNull RequestOptions requestOptions) {
        return applyClipRect(imageOptions, requestOptions);
    }

    @Deprecated
    public static RequestOptions createGlideOptions(@NonNull ImageOptions imageOptions) {
        return createGlideOptions(null, imageOptions);
    }

    @NonNull
    public static IAppResProvider getAppResProvider() {
        IAppResProvider appResProvider = ImageConfig.getAppResProvider();
        if (appResProvider != null) {
            return appResProvider;
        }
        b bVar = new b();
        ImageConfig.setAppResProvider(bVar);
        return bVar;
    }

    public static void loadAppPath(@NonNull Context context, @Nullable String str, @NonNull ImageOptions imageOptions, @NonNull ImageView imageView) {
        RequestOptions createGlideOptions = createGlideOptions(context, imageOptions);
        applyFitMode(imageOptions, imageView);
        Context applicationContext = context.getApplicationContext();
        Glide.with(applicationContext).load(a(str)).apply((BaseRequestOptions<?>) createGlideOptions).into(imageView);
    }

    public static void loadImageId(@NonNull Context context, int i10, @NonNull ImageOptions imageOptions, @NonNull ImageView imageView, boolean z10) {
        applyFitMode(imageOptions, imageView);
        RequestOptions createGlideOptions = createGlideOptions(context, imageOptions);
        Context applicationContext = context.getApplicationContext();
        if (i10 == 0) {
            Glide.with(applicationContext).load("").apply((BaseRequestOptions<?>) createGlideOptions).into(imageView);
        } else if (z10) {
            Glide.with(applicationContext).load(Integer.valueOf(i10)).apply((BaseRequestOptions<?>) createGlideOptions).into(imageView);
        } else {
            Glide.with(applicationContext).load("").error(i10).into(imageView);
        }
    }

    @Deprecated
    public static void loadIntoImageView(@Nullable Context context, @NonNull RequestOptions requestOptions, @NonNull String str, @NonNull ImageView imageView) {
        Context applicationContext;
        if (context == null) {
            applicationContext = imageView.getContext().getApplicationContext();
        } else {
            applicationContext = context.getApplicationContext();
        }
        Glide.with(applicationContext).load(str).apply((BaseRequestOptions<?>) requestOptions).listener(new DrawableListener(str)).into(imageView);
    }

    public static void loadNetWorkUrl(@NonNull Context context, @Nullable String str, @NonNull ImageOptions imageOptions, @NonNull ImageView imageView) {
        RequestOptions createGlideOptions = createGlideOptions(context, imageOptions);
        applyFitMode(imageOptions, imageView);
        Context applicationContext = context.getApplicationContext();
        Glide.with(applicationContext).load(StrUtils.null2Empty(str)).apply((BaseRequestOptions<?>) createGlideOptions).into(imageView);
    }

    public static RequestOptions applyPlaceHolder(@Nullable Context context, @NonNull ImageOptions imageOptions, @NonNull RequestOptions requestOptions) {
        String str;
        Pair<String, Drawable> placeHolder = imageOptions.getPlaceHolder();
        if (placeHolder == null) {
            return requestOptions;
        }
        if (context != null && (str = placeHolder.first) != null && str.startsWith(ImageUtils.DRAWABLE)) {
            int resDrawableId = getAppResProvider().getResDrawableId(context, placeHolder.first.substring(15));
            if (resDrawableId != 0) {
                return requestOptions.placeholder(resDrawableId);
            }
        }
        return requestOptions.placeholder(placeHolder.second);
    }

    public static RequestOptions createGlideOptions(@Nullable Context context, @NonNull ImageOptions imageOptions) {
        return applyTransform(imageOptions, applyEnableCache(imageOptions, applyPlaceHolder(context, imageOptions, new RequestOptions())));
    }
}
