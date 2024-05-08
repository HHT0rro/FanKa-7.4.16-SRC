package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.huawei.hms.ads.gl;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class PPSBaseSwipeView extends PPSBaseStyleView {
    public ScanningView F;
    public ImageView S;

    public PPSBaseSwipeView(Context context) {
        super(context);
    }

    public PPSBaseSwipeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PPSBaseSwipeView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap Code(View view) {
        if (view == null) {
            return null;
        }
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        Bitmap drawingCache = view.getDrawingCache();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (measuredWidth <= 0 || measuredHeight <= 0 || drawingCache == null) {
            gl.V(getViewTag(), "captureWidget NULL");
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(drawingCache, 0, 0, measuredWidth, measuredHeight);
        view.destroyDrawingCache();
        return createBitmap;
    }

    public void V() {
        ScanningView scanningView = this.F;
        if (scanningView != null) {
            scanningView.V();
        }
    }

    public String getViewTag() {
        return "PPSSplashSwipeClickView";
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        gl.V(getViewTag(), "w=%s, h=%s, oldw=%s, oldh=%s", Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13));
        this.S.post(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSBaseSwipeView.1
            @Override // java.lang.Runnable
            public void run() {
                gl.V(PPSBaseSwipeView.this.getViewTag(), "POST %s %s", Integer.valueOf(PPSBaseSwipeView.this.S.getHeight()), Integer.valueOf(PPSBaseSwipeView.this.S.getWidth()));
                if (PPSBaseSwipeView.this.F.getSrcBitmap() == null) {
                    PPSBaseSwipeView pPSBaseSwipeView = PPSBaseSwipeView.this;
                    pPSBaseSwipeView.F.setSrcBitmap(pPSBaseSwipeView.Code(pPSBaseSwipeView.S));
                }
                ScanningView scanningView = PPSBaseSwipeView.this.F;
                if (scanningView != null) {
                    scanningView.Code();
                }
            }
        });
    }
}
