package com.huawei.quickcard.views.image;

import androidx.annotation.NonNull;
import com.huawei.quickcard.base.annotation.DoNotShrink;
import com.huawei.quickcard.views.image.extension.FitMode;
import com.huawei.quickcard.views.image.extension.IAppResProvider;
import com.huawei.quickcard.views.image.extension.IImageLoader;
import com.huawei.quickcard.views.image.extension.IImageViewFactory;
import com.huawei.quickcard.views.image.view.BaseImageView;
import com.huawei.quickcard.views.image.view.FlexImageView;

@DoNotShrink
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ImageConfig {

    /* renamed from: a, reason: collision with root package name */
    private static final FitMode f34517a = FitMode.COVER;

    /* renamed from: b, reason: collision with root package name */
    private static IImageViewFactory<? extends FlexImageView> f34518b = null;

    /* renamed from: c, reason: collision with root package name */
    private static IImageLoader f34519c = null;

    /* renamed from: d, reason: collision with root package name */
    private static IAppResProvider f34520d = null;

    public static IAppResProvider getAppResProvider() {
        return f34520d;
    }

    @NonNull
    public static FitMode getFitMode() {
        return f34517a;
    }

    public static IImageViewFactory<? extends BaseImageView> getImageFactory() {
        return f34518b;
    }

    public static IImageLoader getImageLoader() {
        return f34519c;
    }

    public static void setAppResProvider(IAppResProvider iAppResProvider) {
        f34520d = iAppResProvider;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setImageFactory(IImageViewFactory<? extends BaseImageView> iImageViewFactory) {
        f34518b = iImageViewFactory;
    }

    public static void setImageLoader(IImageLoader iImageLoader) {
        f34519c = iImageLoader;
    }
}
