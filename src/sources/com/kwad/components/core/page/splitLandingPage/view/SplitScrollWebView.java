package com.kwad.components.core.page.splitLandingPage.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.MotionEventCompat;
import com.kwad.components.core.s.d;
import com.kwad.sdk.core.webview.KsAdWebView;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class SplitScrollWebView extends KsAdWebView {
    private int PS;
    private boolean Qp;
    private a Qq;
    private float Qr;
    private boolean Qs;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface a {
        void d(float f10);

        boolean pY();
    }

    public SplitScrollWebView(Context context) {
        super(context);
        this.Qp = false;
        pS();
    }

    private void pS() {
        this.PS = 0;
    }

    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        int screenHeight;
        if (this.PS != 0) {
            int statusBarHeight = d.rc() ? com.kwad.sdk.d.a.a.getStatusBarHeight(getContext()) : 0;
            if (getContext() instanceof Activity) {
                screenHeight = com.kwad.sdk.d.a.a.e((Activity) getContext());
            } else {
                screenHeight = com.kwad.sdk.d.a.a.getScreenHeight(getContext());
            }
            i11 = View.MeasureSpec.makeMeasureSpec((screenHeight - statusBarHeight) - this.PS, 1073741824);
        }
        super.onMeasure(i10, i11);
    }

    @Override // com.kwad.sdk.core.webview.KsAdWebView, android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        if (this.Qp) {
            return super.onTouchEvent(obtain);
        }
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        float y10 = motionEvent.getY();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    float f10 = this.Qr;
                    float f11 = f10 - y10;
                    a aVar = this.Qq;
                    if (aVar != null && y10 <= f10) {
                        this.Qs = true;
                        aVar.d(f11);
                    }
                    return super.onTouchEvent(obtain);
                }
                if (actionMasked != 3) {
                    return false;
                }
            }
            a aVar2 = this.Qq;
            if (aVar2 == null) {
                return false;
            }
            if ((this.Qr - y10 < 0.0f && !this.Qs) || !aVar2.pY()) {
                return false;
            }
            this.Qp = true;
            return false;
        }
        this.Qr = y10;
        this.Qs = false;
        return super.onTouchEvent(motionEvent);
    }

    public void setDisableAnimation(boolean z10) {
        this.Qp = z10;
    }

    public void setSplitScrollWebViewListener(a aVar) {
        this.Qq = aVar;
    }

    public SplitScrollWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Qp = false;
        pS();
    }

    public SplitScrollWebView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.Qp = false;
        pS();
    }
}
