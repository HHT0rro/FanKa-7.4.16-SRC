package com.huawei.flexiblelayout;

import com.huawei.flexiblelayout.services.imageloader.ImageLoader;
import com.huawei.flexiblelayout.services.imageloader.ImageLoaderService;

/* compiled from: ImageLoaderServiceImpl.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class n1 implements ImageLoaderService {

    /* renamed from: a, reason: collision with root package name */
    private ImageLoader f28276a;

    @Override // com.huawei.flexiblelayout.services.imageloader.ImageLoaderService
    public ImageLoader getImageLoader() {
        return this.f28276a;
    }

    @Override // com.huawei.flexiblelayout.services.imageloader.ImageLoaderService
    public void registerImageLoader(ImageLoader imageLoader) {
        this.f28276a = imageLoader;
    }
}
