package com.huawei.qcardsupport;

import android.content.Context;
import androidx.annotation.NonNull;
import com.huawei.flexiblelayout.FLEngine;
import com.huawei.flexiblelayout.log.Log;
import com.huawei.flexiblelayout.services.imageloader.ImageLoader;
import com.huawei.flexiblelayout.services.imageloader.ImageLoaderService;
import com.huawei.quickcard.views.image.extension.IImageLoader;
import com.huawei.quickcard.views.image.extension.ImageOptions;

/* compiled from: QuickImageLoader.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class d implements IImageLoader {

    /* renamed from: b, reason: collision with root package name */
    private static final String f33125b = "QuickImageLoader";

    /* renamed from: a, reason: collision with root package name */
    private ImageLoader f33126a;

    @Override // com.huawei.quickcard.views.image.extension.IImageLoader
    public void asyncLoad(@NonNull Context context, @NonNull String str, @NonNull ImageOptions imageOptions) {
        if (this.f33126a == null) {
            this.f33126a = ((ImageLoaderService) FLEngine.getInstance(context).getService(ImageLoaderService.class)).getImageLoader();
        }
        if (this.f33126a == null) {
            Log.e(f33125b, "Not registered ImageLoader.");
        } else {
            this.f33126a.load(imageOptions.getTargetView(), (com.huawei.flexiblelayout.services.imageloader.ImageOptions) new e(imageOptions));
        }
    }
}
