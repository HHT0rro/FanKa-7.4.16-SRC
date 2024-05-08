package com.huawei.quickcard.image.loader;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.huawei.quickcard.base.annotation.DoNotShrink;
import com.huawei.quickcard.base.log.CardLogUtils;
import com.huawei.quickcard.views.image.ImageUtils;
import com.huawei.quickcard.views.image.extension.IAppResProvider;
import com.huawei.quickcard.views.image.extension.IImageLoader;
import com.huawei.quickcard.views.image.extension.ImageOptions;

@DoNotShrink
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class GlideImageLoader implements IImageLoader {

    /* renamed from: a, reason: collision with root package name */
    private static final String f34051a = "IImageLoader";

    @Override // com.huawei.quickcard.views.image.extension.IImageLoader
    public void asyncLoad(@NonNull Context context, @NonNull String str, @NonNull ImageOptions imageOptions) {
        ImageView targetView = imageOptions.getTargetView();
        if (targetView == null) {
            CardLogUtils.w(f34051a, "cannot load image because image view is not exist");
        } else if (TextUtils.isEmpty(str)) {
            loadImageWithoutUrl(context, imageOptions, targetView);
        } else {
            loadImageWithUrl(context, str, imageOptions, targetView);
        }
    }

    public void loadAppResource(@NonNull Context context, @NonNull String str, @NonNull ImageOptions imageOptions, @NonNull ImageView imageView) {
        GlideLoadUtils.applyFitMode(imageOptions, imageView);
        IAppResProvider appResProvider = GlideLoadUtils.getAppResProvider();
        if (str.startsWith(ImageUtils.RAW)) {
            GlideLoadUtils.loadImageId(context, appResProvider.getResRawId(context, str.substring(10)), imageOptions, imageView, true);
            return;
        }
        if (str.startsWith(ImageUtils.DRAWABLE)) {
            GlideLoadUtils.loadImageId(context, appResProvider.getResDrawableId(context, str.substring(15)), imageOptions, imageView, false);
            return;
        }
        if (str.startsWith(ImageUtils.MIPMAP)) {
            GlideLoadUtils.loadImageId(context, appResProvider.getResMipMapId(context, str.substring(13)), imageOptions, imageView, false);
            return;
        }
        if (str.startsWith(ImageUtils.ASSETS)) {
            GlideLoadUtils.loadAppPath(context, appResProvider.getAssetsImagePath(context, str.substring(13)), imageOptions, imageView);
            return;
        }
        CardLogUtils.w(f34051a, "image resource " + str + " is not supported");
    }

    public void loadImageWithUrl(@NonNull Context context, @NonNull String str, @NonNull ImageOptions imageOptions, @NonNull ImageView imageView) {
        if (!ImageUtils.isBase64Img(str) && !ImageUtils.isNetImage(str)) {
            if (ImageUtils.isAppImage(str)) {
                loadAppResource(context, str, imageOptions, imageView);
                return;
            } else {
                loadOtherResource(context, str, imageOptions, imageView);
                return;
            }
        }
        loadResourceDirectly(context, str, imageOptions, imageView);
    }

    public void loadImageWithoutUrl(@NonNull Context context, @NonNull ImageOptions imageOptions, @NonNull ImageView imageView) {
        GlideLoadUtils.loadNetWorkUrl(context, "", imageOptions, imageView);
    }

    public void loadOtherResource(@NonNull Context context, @NonNull String str, @NonNull ImageOptions imageOptions, @NonNull ImageView imageView) {
        loadImageWithoutUrl(context, imageOptions, imageView);
    }

    public void loadResourceDirectly(@NonNull Context context, @NonNull String str, @NonNull ImageOptions imageOptions, @NonNull ImageView imageView) {
        GlideLoadUtils.loadNetWorkUrl(context, str, imageOptions, imageView);
    }
}
