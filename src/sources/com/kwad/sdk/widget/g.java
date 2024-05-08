package com.kwad.sdk.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bp;
import com.kwad.sdk.utils.k;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class g {
    private final bp aCO;
    private final i aST;
    private boolean aSV;
    private boolean aSW;
    private ViewTreeObserver.OnScrollChangedListener aSY;
    private final View mView;
    private final int mf;
    private float aSU = 0.1f;
    private boolean aSX = true;

    public g(View view, i iVar) {
        this.mView = view;
        this.aST = iVar;
        this.aCO = new bp(view);
        this.mf = k.getScreenHeight(view.getContext());
    }

    private void GK() {
        if (this.aSY == null) {
            this.aSY = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.kwad.sdk.widget.g.1
                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public final void onScrollChanged() {
                    if (g.this.NU()) {
                        g.this.ao();
                    }
                }
            };
            ViewTreeObserver viewTreeObserver = this.mView.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnScrollChangedListener(this.aSY);
            }
        }
    }

    private void GL() {
        if (this.aSY == null) {
            return;
        }
        try {
            ViewTreeObserver viewTreeObserver = this.mView.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.removeOnScrollChangedListener(this.aSY);
            }
            this.aSY = null;
        } catch (Exception e2) {
            com.kwad.sdk.core.e.c.printStackTrace(e2);
        }
    }

    private void NT() {
        if (NU()) {
            ao();
        } else {
            GL();
            GK();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean NU() {
        if (this.aCO.Nr() && Math.abs(this.aCO.aQY.height() - this.mView.getHeight()) <= this.mView.getHeight() * (1.0f - this.aSU) && this.mView.getHeight() > 0 && this.mView.getWidth() > 0) {
            Rect rect = this.aCO.aQY;
            if (rect.bottom > 0 && rect.top < this.mf) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ao() {
        try {
            GL();
            i iVar = this.aST;
            if (iVar != null) {
                iVar.A(this.mView);
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private void oD() {
        if (this.aSX) {
            NT();
        }
    }

    public final void NS() {
        if (this.aSW) {
            oD();
        }
    }

    public final void ce(boolean z10) {
        this.aSX = z10;
    }

    public final float getVisiblePercent() {
        return this.aSU;
    }

    public final void onAttachedToWindow() {
        GK();
    }

    public final void onDetachedFromWindow() {
        GL();
        this.aSV = false;
    }

    public final void setVisiblePercent(float f10) {
        this.aSU = f10;
    }

    public final void b(int i10, int i11, int i12, int i13) {
        this.aSW = false;
        if (this.aSV || (i12 | i13) != 0 || (i10 | i11) == 0) {
            return;
        }
        this.aSW = true;
        this.aSV = true;
    }
}
