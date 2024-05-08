package com.huawei.quickcard.views.div;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import com.facebook.yoga.YogaNode;
import com.huawei.quickcard.CardContext;
import com.huawei.quickcard.c;
import com.huawei.quickcard.exposure.ExposureManager;
import com.huawei.quickcard.exposure.extend.ExtendExposureManager;
import com.huawei.quickcard.exposure.extend.IExtendExposureSupport;
import com.huawei.quickcard.framework.IComponentSupport;
import com.huawei.quickcard.framework.b;
import com.huawei.quickcard.framework.blur.Blurable;
import com.huawei.quickcard.framework.processor.PropertyCacheBean;
import com.huawei.quickcard.i;
import com.huawei.quickcard.utils.ValueUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class DivLayout extends CardYogaLayout implements IComponentSupport, Blurable, IExtendExposureSupport {

    /* renamed from: d, reason: collision with root package name */
    private ExposureManager f34515d;

    /* renamed from: e, reason: collision with root package name */
    private ExtendExposureManager f34516e;

    public DivLayout(Context context) {
        super(context);
    }

    @Override // com.huawei.quickcard.framework.blur.Blurable
    public void doBlur(@NonNull i iVar) {
        c.a(this, iVar);
    }

    @Override // com.huawei.quickcard.framework.IComponentFunction
    public /* synthetic */ void focus(Object obj) {
        b.a(this, obj);
    }

    @Override // com.huawei.quickcard.framework.IComponentSupport
    public /* bridge */ /* synthetic */ ViewParent getViewParent(@NonNull View view) {
        return com.huawei.quickcard.framework.c.a(this, view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ExposureManager exposureManager = this.f34515d;
        if (exposureManager != null) {
            exposureManager.onAttachedToWindow(this);
        }
        ExtendExposureManager extendExposureManager = this.f34516e;
        if (extendExposureManager != null) {
            extendExposureManager.onAttachedToWindow(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ExposureManager exposureManager = this.f34515d;
        if (exposureManager != null) {
            exposureManager.onDetachedFromWindow(this);
        }
        ExtendExposureManager extendExposureManager = this.f34516e;
        if (extendExposureManager != null) {
            extendExposureManager.onDetachedFromWindow(this);
        }
    }

    @Override // com.huawei.quickcard.views.div.CardYogaLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        if (!(getParent() instanceof CardYogaLayout)) {
            int mode = View.MeasureSpec.getMode(i10);
            int mode2 = View.MeasureSpec.getMode(i11);
            YogaNode yogaNode = getYogaNode();
            PropertyCacheBean obtainPropertyCacheBeanFromView = ValueUtils.obtainPropertyCacheBeanFromView(this);
            if (!obtainPropertyCacheBeanFromView.isHeightDefined() && (mode2 == Integer.MIN_VALUE || mode2 == 0)) {
                yogaNode.F(Float.NaN);
            }
            if (!obtainPropertyCacheBeanFromView.isWidthDefined() && (mode == Integer.MIN_VALUE || mode == 0)) {
                yogaNode.W(Float.NaN);
            }
        }
        super.onMeasure(i10, i11);
    }

    @Override // android.view.View
    public void onScreenStateChanged(int i10) {
        ExposureManager exposureManager = this.f34515d;
        if (exposureManager != null) {
            exposureManager.onScreenSateChange(this, i10);
        }
    }

    @Override // com.huawei.quickcard.framework.IComponentSupport
    public /* synthetic */ void onViewCreated(CardContext cardContext) {
        com.huawei.quickcard.framework.c.b(this, cardContext);
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View view, int i10) {
        ExposureManager exposureManager = this.f34515d;
        if (exposureManager != null) {
            exposureManager.onVisibilityChanged(this, view, i10);
        }
        ExtendExposureManager extendExposureManager = this.f34516e;
        if (extendExposureManager != null) {
            extendExposureManager.onVisibilityChanged(this, i10);
        }
    }

    @Override // com.huawei.quickcard.exposure.IExposureSupport
    public void setExposureManager(ExposureManager exposureManager) {
        this.f34515d = exposureManager;
    }

    @Override // com.huawei.quickcard.exposure.extend.IExtendExposureSupport
    public void setExtendExposureManager(ExtendExposureManager extendExposureManager) {
        this.f34516e = extendExposureManager;
    }

    @Override // com.huawei.quickcard.framework.IComponentSupport
    public /* synthetic */ void setViewParent(ViewParent viewParent) {
        com.huawei.quickcard.framework.c.c(this, viewParent);
    }

    @Override // com.huawei.quickcard.framework.blur.Blurable
    public void unBlur() {
        if (getBackground() instanceof BitmapDrawable) {
            setBackground(null);
        }
    }
}
