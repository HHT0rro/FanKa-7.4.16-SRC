package com.alimm.tanx.ui.image;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.alimm.tanx.core.image.IImageLoader;
import com.alimm.tanx.core.image.util.GifConfig;
import com.alimm.tanx.core.image.util.ImageConfig;
import com.alimm.tanx.core.ut.impl.TanxMonitorUt;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.ui.image.glide.BitmapTypeRequest;
import com.alimm.tanx.ui.image.glide.DrawableRequestBuilder;
import com.alimm.tanx.ui.image.glide.DrawableTypeRequest;
import com.alimm.tanx.ui.image.glide.Glide;
import com.alimm.tanx.ui.image.glide.RequestManager;
import com.alimm.tanx.ui.image.glide.load.engine.DiskCacheStrategy;
import com.alimm.tanx.ui.image.glide.load.resource.drawable.GlideDrawable;
import com.alimm.tanx.ui.image.glide.request.animation.GlideAnimation;
import com.alimm.tanx.ui.image.glide.request.target.SimpleTarget;
import com.huawei.quickcard.base.Attributes;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class GlideSourceCodeImageLoader implements IImageLoader {
    public static final String TAG = "GlideSourceCodeImageLoader";

    private DrawableTypeRequest getDrawableTypeRequest(ImageConfig imageConfig, RequestManager requestManager) {
        if (!TextUtils.isEmpty(imageConfig.getUrl())) {
            return requestManager.load(imageConfig.getUrl());
        }
        if (imageConfig.getResId() > 0) {
            return requestManager.load(Integer.valueOf(imageConfig.getResId()));
        }
        return null;
    }

    private SimpleTarget<GlideDrawable> getGifSimpleTarget(final ImageView imageView, final ImageConfig.GifCallback gifCallback) {
        return new SimpleTarget<GlideDrawable>() { // from class: com.alimm.tanx.ui.image.GlideSourceCodeImageLoader.2
            @Override // com.alimm.tanx.ui.image.glide.request.target.BaseTarget, com.alimm.tanx.ui.image.glide.request.target.Target
            public void onLoadFailed(Exception exc, Drawable drawable) {
                ImageConfig.GifCallback gifCallback2 = gifCallback;
                if (gifCallback2 != null) {
                    gifCallback2.onFailure(LogUtils.getStackTraceMessage(exc));
                    TanxMonitorUt.sendImageMonitor(2, -1, "gif", false);
                }
            }

            @Override // com.alimm.tanx.ui.image.glide.request.target.Target
            public /* bridge */ /* synthetic */ void onResourceReady(Object obj, GlideAnimation glideAnimation) {
                onResourceReady((GlideDrawable) obj, (GlideAnimation<? super GlideDrawable>) glideAnimation);
            }

            public void onResourceReady(GlideDrawable glideDrawable, GlideAnimation<? super GlideDrawable> glideAnimation) {
                if (gifCallback != null) {
                    if (glideDrawable.isAnimated()) {
                        glideDrawable.setLoopCount(-1);
                        glideDrawable.start();
                    }
                    imageView.setBackground(glideDrawable);
                    gifCallback.onSuccess();
                    TanxMonitorUt.sendImageMonitor(2, 1, "gif", false);
                }
            }
        };
    }

    @Override // com.alimm.tanx.core.image.ILoader
    public void load(ImageConfig imageConfig, final ImageConfig.ImageBitmapCallback imageBitmapCallback) {
        LogUtils.d(TAG, "load()");
        TanxMonitorUt.sendImageMonitor(2, 1, Attributes.Component.IMAGE, true);
        DrawableTypeRequest drawableTypeRequest = getDrawableTypeRequest(imageConfig, Glide.with(imageConfig.getContext()));
        if (drawableTypeRequest == null) {
            return;
        }
        drawableTypeRequest.asBitmap().into((BitmapTypeRequest) new SimpleTarget<Bitmap>() { // from class: com.alimm.tanx.ui.image.GlideSourceCodeImageLoader.1
            @Override // com.alimm.tanx.ui.image.glide.request.target.BaseTarget, com.alimm.tanx.ui.image.glide.request.target.Target
            public void onLoadFailed(Exception exc, Drawable drawable) {
                if (imageBitmapCallback != null) {
                    TanxMonitorUt.sendImageMonitor(2, -1, Attributes.Component.IMAGE, false);
                    imageBitmapCallback.onFailure(LogUtils.getStackTraceMessage(exc));
                }
            }

            @Override // com.alimm.tanx.ui.image.glide.request.target.Target
            public /* bridge */ /* synthetic */ void onResourceReady(Object obj, GlideAnimation glideAnimation) {
                onResourceReady((Bitmap) obj, (GlideAnimation<? super Bitmap>) glideAnimation);
            }

            public void onResourceReady(Bitmap bitmap, GlideAnimation<? super Bitmap> glideAnimation) {
                if (imageBitmapCallback != null) {
                    TanxMonitorUt.sendImageMonitor(2, 1, Attributes.Component.IMAGE, false);
                    imageBitmapCallback.onSuccess(bitmap);
                }
            }
        });
    }

    @Override // com.alimm.tanx.core.image.ILoader
    public void loadGif(GifConfig gifConfig, ImageConfig.GifCallback gifCallback) {
        String str;
        LogUtils.d(TAG, "loadGif()");
        TanxMonitorUt.sendImageMonitor(2, 1, "gif", true);
        if (gifConfig == null || gifConfig.getGifView() == null) {
            str = "imageView对象为空";
        } else if (!TextUtils.isEmpty(gifConfig.getGifUrl())) {
            Glide.with(gifConfig.getGifView().getContext()).load(gifConfig.getGifUrl()).diskCacheStrategy(DiskCacheStrategy.RESULT).into((DrawableRequestBuilder<String>) getGifSimpleTarget(gifConfig.getGifView(), gifCallback));
            return;
        } else {
            if (gifConfig.getGifRes() != -1) {
                Glide.with(gifConfig.getGifView().getContext()).load(Integer.valueOf(gifConfig.getGifRes())).diskCacheStrategy(DiskCacheStrategy.RESULT).into((DrawableRequestBuilder<Integer>) getGifSimpleTarget(gifConfig.getGifView(), gifCallback));
                return;
            }
            str = "";
        }
        if (gifCallback != null) {
            gifCallback.onFailure(str);
        }
    }
}
