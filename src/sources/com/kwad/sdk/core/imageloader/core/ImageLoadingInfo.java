package com.kwad.sdk.core.imageloader.core;

import com.kwad.sdk.core.imageloader.core.assist.ImageSize;
import com.kwad.sdk.core.imageloader.core.imageaware.ImageAware;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingProgressListener;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class ImageLoadingInfo {
    public final ImageAware imageAware;
    public final ImageLoadingListener listener;
    public final ReentrantLock loadFromUriLock;
    public final String memoryCacheKey;
    public final DisplayImageOptions options;
    public final ImageLoadingProgressListener progressListener;
    public final ImageSize targetSize;
    public final String uri;

    public ImageLoadingInfo(String str, ImageAware imageAware, ImageSize imageSize, String str2, DisplayImageOptions displayImageOptions, ImageLoadingListener imageLoadingListener, ImageLoadingProgressListener imageLoadingProgressListener, ReentrantLock reentrantLock) {
        this.uri = str;
        this.imageAware = imageAware;
        this.targetSize = imageSize;
        this.options = displayImageOptions;
        this.listener = imageLoadingListener;
        this.progressListener = imageLoadingProgressListener;
        this.loadFromUriLock = reentrantLock;
        this.memoryCacheKey = str2;
    }
}
