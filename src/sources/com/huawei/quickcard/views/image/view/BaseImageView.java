package com.huawei.quickcard.views.image.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import com.huawei.quickcard.CardContext;
import com.huawei.quickcard.base.log.CardLogUtils;
import com.huawei.quickcard.exposure.ExposureManager;
import com.huawei.quickcard.exposure.extend.ExtendExposureManager;
import com.huawei.quickcard.exposure.extend.IExtendExposureSupport;
import com.huawei.quickcard.framework.IComponentSupport;
import com.huawei.quickcard.framework.border.Border;
import com.huawei.quickcard.framework.unit.LengthValue;
import com.huawei.quickcard.q;
import com.huawei.quickcard.views.GestureDelegate;
import com.huawei.quickcard.views.image.ImageConfig;
import com.huawei.quickcard.views.image.extension.ClipRect;
import com.huawei.quickcard.views.image.extension.FitMode;
import com.huawei.quickcard.views.image.extension.IImageLoader;
import com.huawei.quickcard.views.image.extension.ImageOptions;
import com.huawei.quickcard.views.image.view.BitmapHolder;
import com.huawei.quickcard.views.image.view.LayoutHolder;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class BaseImageView extends ImageView implements IComponentSupport, IImageHost, BitmapHolder, IExtendExposureSupport {

    /* renamed from: a, reason: collision with root package name */
    private BitmapHolder.OnBitmapAvailable f34541a;

    /* renamed from: b, reason: collision with root package name */
    private ExposureManager f34542b;

    /* renamed from: c, reason: collision with root package name */
    private ExtendExposureManager f34543c;
    public final q cacheBean;
    public boolean isNeedReload;
    public final Rect viewBounds;

    public BaseImageView(Context context) {
        super(context);
        this.viewBounds = new Rect();
        this.cacheBean = new q();
        setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    @NonNull
    private ImageOptions a(@NonNull q qVar) {
        ImageOptions imageOptions = new ImageOptions();
        imageOptions.setUrl(qVar.j());
        imageOptions.setPlaceHolder(getPlaceHolder(qVar.i()));
        imageOptions.setFitMode(c(qVar));
        imageOptions.setEnableCache(qVar.m());
        imageOptions.setNetworkEnhance(qVar.n());
        imageOptions.setWidth(qVar.k());
        imageOptions.setHeight(qVar.f());
        imageOptions.setClipRect(b(qVar));
        imageOptions.setTargetView(this);
        return imageOptions;
    }

    @Nullable
    private ClipRect b(@NonNull q qVar) {
        LengthValue b4 = qVar.b();
        LengthValue c4 = qVar.c();
        if (b4 == null && c4 == null) {
            return null;
        }
        return new ClipRect(b4, c4, b4, c4);
    }

    @NonNull
    private FitMode c(@NonNull q qVar) {
        FitMode e2 = qVar.e();
        return e2 == null ? ImageConfig.getFitMode() : e2;
    }

    public abstract void a(@NonNull Border border);

    public void doLoadImage(ImageOptions imageOptions) {
        IImageLoader imageLoader = ImageConfig.getImageLoader();
        if (imageLoader == null) {
            CardLogUtils.e(IImageHost.TAG, "miss image loader, you should config it");
            return;
        }
        String j10 = this.cacheBean.j();
        CardLogUtils.d(IImageHost.TAG, "start to load image:: " + j10);
        imageLoader.asyncLoad(getContext(), j10, imageOptions);
    }

    @Override // com.huawei.quickcard.views.image.IImageHostView
    public void enableCache(boolean z10) {
        this.cacheBean.b(z10);
        this.isNeedReload = true;
    }

    @Override // com.huawei.quickcard.framework.IComponentFunction
    public /* synthetic */ void focus(Object obj) {
        com.huawei.quickcard.framework.b.a(this, obj);
    }

    @Override // com.huawei.quickcard.views.image.IImageHostView
    public Pair<String, Drawable> getPlaceHolder(String str) {
        return new Pair<>(str, this.cacheBean.a(str));
    }

    @Override // com.huawei.quickcard.framework.IComponentSupport
    public /* synthetic */ ViewParent getViewParent(View view) {
        return com.huawei.quickcard.framework.c.a(this, view);
    }

    @Override // com.huawei.quickcard.views.image.IImageHostView
    public void loadImage() {
        doLoadImage(a(this.cacheBean));
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ExposureManager exposureManager = this.f34542b;
        if (exposureManager != null) {
            exposureManager.onAttachedToWindow(this);
        }
        ExtendExposureManager extendExposureManager = this.f34543c;
        if (extendExposureManager != null) {
            extendExposureManager.onAttachedToWindow(this);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ExposureManager exposureManager = this.f34542b;
        if (exposureManager != null) {
            exposureManager.onDetachedFromWindow(this);
        }
        ExtendExposureManager extendExposureManager = this.f34543c;
        if (extendExposureManager != null) {
            extendExposureManager.onDetachedFromWindow(this);
        }
    }

    @Override // com.huawei.quickcard.views.image.view.IImageHost, com.huawei.quickcard.framework.ui.CommandOptions
    public void onEnd() {
        CardLogUtils.d(IImageHost.TAG, "on render command end");
        if (this.isNeedReload) {
            this.isNeedReload = false;
            loadImage();
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        a();
    }

    @Override // android.view.View
    public void onScreenStateChanged(int i10) {
        ExposureManager exposureManager = this.f34542b;
        if (exposureManager != null) {
            exposureManager.onScreenSateChange(this, i10);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        this.viewBounds.set(0, 0, i10, i11);
        a(this.cacheBean.a());
    }

    @Override // com.huawei.quickcard.views.image.view.IImageHost, com.huawei.quickcard.framework.ui.CommandOptions
    public /* synthetic */ void onStart() {
        c.b(this);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return GestureDelegate.onTouchEvent(this, motionEvent) | super.onTouchEvent(motionEvent);
    }

    @Override // com.huawei.quickcard.framework.IComponentSupport
    public /* synthetic */ void onViewCreated(CardContext cardContext) {
        com.huawei.quickcard.framework.c.b(this, cardContext);
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View view, int i10) {
        ExposureManager exposureManager = this.f34542b;
        if (exposureManager != null) {
            exposureManager.onVisibilityChanged(this, view, i10);
        }
        ExtendExposureManager extendExposureManager = this.f34543c;
        if (extendExposureManager != null) {
            extendExposureManager.onVisibilityChanged(this, i10);
        }
    }

    @Override // com.huawei.quickcard.views.image.IImageHostView
    public void setBorder(@NonNull Border border) {
        this.cacheBean.a(border);
        a(border);
        if (this.isNeedReload) {
            return;
        }
        invalidate();
    }

    @Override // com.huawei.quickcard.views.image.IImageHostView
    public void setClipX(@Nullable LengthValue lengthValue) {
        this.cacheBean.a(lengthValue);
        this.isNeedReload = true;
    }

    @Override // com.huawei.quickcard.views.image.IImageHostView
    public void setClipY(@Nullable LengthValue lengthValue) {
        this.cacheBean.b(lengthValue);
        this.isNeedReload = true;
    }

    @Override // com.huawei.quickcard.exposure.IExposureSupport
    public void setExposureManager(ExposureManager exposureManager) {
        this.f34542b = exposureManager;
    }

    @Override // com.huawei.quickcard.exposure.extend.IExtendExposureSupport
    public void setExtendExposureManager(ExtendExposureManager extendExposureManager) {
        this.f34543c = extendExposureManager;
    }

    @Override // com.huawei.quickcard.views.image.IImageHostView
    public void setFitMode(@NonNull FitMode fitMode) {
        this.cacheBean.a(fitMode);
        this.isNeedReload = true;
    }

    @Override // com.huawei.quickcard.views.image.IImageHostView
    public void setImageHeight(int i10) {
        this.cacheBean.a(i10);
        this.isNeedReload = true;
    }

    @Override // com.huawei.quickcard.views.image.IImageHostView
    public void setImageWidth(int i10) {
        this.cacheBean.b(i10);
        this.isNeedReload = true;
    }

    @Override // com.huawei.quickcard.views.image.IImageHostView
    public void setNetworkEnhance(boolean z10) {
        this.cacheBean.c(z10);
        this.isNeedReload = true;
    }

    @Override // com.huawei.quickcard.views.image.view.BitmapHolder
    public void setOnBitmapAvailable(BitmapHolder.OnBitmapAvailable onBitmapAvailable, LayoutHolder layoutHolder) {
        this.f34541a = onBitmapAvailable;
        if (layoutHolder != null) {
            layoutHolder.setOnLayoutListener(new LayoutHolder.OnLayoutListener() { // from class: com.huawei.quickcard.views.image.view.a
                @Override // com.huawei.quickcard.views.image.view.LayoutHolder.OnLayoutListener
                public final void onLayout() {
                    BaseImageView.this.a();
                }
            });
        } else {
            a();
        }
    }

    @Override // com.huawei.quickcard.views.image.IImageHostView
    public void setPlaceHolder(String str, @Nullable Drawable drawable) {
        this.cacheBean.a(str, drawable);
        this.isNeedReload = true;
    }

    @Override // com.huawei.quickcard.views.image.IImageHostView
    public void setSrc(String str) {
        this.cacheBean.c(str);
        this.isNeedReload = true;
    }

    @Override // com.huawei.quickcard.framework.IComponentSupport
    public /* synthetic */ void setViewParent(ViewParent viewParent) {
        com.huawei.quickcard.framework.c.c(this, viewParent);
    }

    @Nullable
    private Bitmap b() {
        int height;
        int width = getWidth();
        Bitmap bitmap = null;
        if (width <= 0 || (height = getHeight()) <= 0) {
            return null;
        }
        try {
            bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            draw(new Canvas(bitmap));
            return bitmap;
        } catch (Exception e2) {
            CardLogUtils.w(IImageHost.TAG, "capture bitmap failed", e2);
            return bitmap;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        Bitmap b4;
        BitmapHolder.OnBitmapAvailable onBitmapAvailable;
        if (this.f34541a == null || (b4 = b()) == null || (onBitmapAvailable = this.f34541a) == null) {
            return;
        }
        onBitmapAvailable.onAvailable(this, b4);
    }
}
