package com.kwad.sdk.core.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.utils.bp;
import com.kwad.sdk.utils.k;
import com.kwad.sdk.widget.j;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class AdBasePvFrameLayout extends AdBaseFrameLayout {
    private long aCI;
    private float aCJ;
    private boolean aCK;
    private boolean aCL;
    private ViewTreeObserver.OnScrollChangedListener aCM;
    private ViewTreeObserver aCN;
    private bp aCO;
    private j cD;
    private int mf;

    public AdBasePvFrameLayout(@NonNull Context context) {
        super(context);
        this.aCI = 500L;
        this.aCJ = 0.1f;
        this.aCL = true;
        init();
    }

    private void GH() {
        if (GJ()) {
            GI();
        } else {
            GK();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean GJ() {
        if (!this.aCO.Nr() || Math.abs(this.aCO.aQY.height() - getHeight()) > getHeight() * (1.0f - this.aCJ) || getHeight() <= 0 || getWidth() <= 0) {
            return false;
        }
        Rect rect = this.aCO.aQY;
        return rect.bottom > 0 && rect.top < this.mf;
    }

    private void GK() {
        if (this.aCM == null) {
            this.aCM = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.kwad.sdk.core.view.AdBasePvFrameLayout.1
                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public final void onScrollChanged() {
                    if (AdBasePvFrameLayout.this.GJ()) {
                        AdBasePvFrameLayout.this.GI();
                    }
                }
            };
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            this.aCN = viewTreeObserver;
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnScrollChangedListener(this.aCM);
            }
        }
    }

    private void GL() {
        ViewTreeObserver viewTreeObserver;
        try {
            if (this.aCM != null && (viewTreeObserver = this.aCN) != null && viewTreeObserver.isAlive()) {
                this.aCN.removeOnScrollChangedListener(this.aCM);
            }
            this.aCM = null;
        } catch (Exception e2) {
            com.kwad.sdk.core.e.c.printStackTrace(e2);
        }
    }

    private void init() {
        this.aCO = new bp(this);
        this.mf = k.getScreenHeight(getContext());
        this.aCL = true;
    }

    private void oD() {
        if (this.aCL) {
            GH();
        }
    }

    public final void GI() {
        GL();
        j jVar = this.cD;
        if (jVar != null) {
            jVar.ao();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        GK();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        GL();
        this.aCK = false;
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        boolean z10 = true;
        if (this.aCK || (i12 | i13) != 0 || (i10 | i11) == 0) {
            z10 = false;
        } else {
            this.aCK = true;
        }
        super.onSizeChanged(i10, i11, i12, i13);
        if (z10) {
            oD();
        }
    }

    public void setCheckDefaultImpressionLogThreshold(float f10) {
        this.aCJ = f10;
    }

    public void setVisibleListener(j jVar) {
        this.cD = jVar;
    }

    public AdBasePvFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aCI = 500L;
        this.aCJ = 0.1f;
        this.aCL = true;
        init();
    }

    public AdBasePvFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.aCI = 500L;
        this.aCJ = 0.1f;
        this.aCL = true;
        init();
    }
}
