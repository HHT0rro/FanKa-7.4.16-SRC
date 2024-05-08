package com.qq.e.ads.nativ.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.qq.e.comm.util.GDTLogger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class NativeAdContainer extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private ViewStatusListener f38214a;

    /* renamed from: b, reason: collision with root package name */
    private ViewStatus f38215b;

    /* renamed from: com.qq.e.ads.nativ.widget.NativeAdContainer$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f38216a;

        static {
            int[] iArr = new int[ViewStatus.values().length];
            f38216a = iArr;
            try {
                iArr[1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f38216a[2] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public enum ViewStatus {
        INIT,
        ATTACHED,
        DETACHED
    }

    public NativeAdContainer(Context context) {
        super(context);
        this.f38215b = ViewStatus.INIT;
    }

    public NativeAdContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f38215b = ViewStatus.INIT;
    }

    public NativeAdContainer(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f38215b = ViewStatus.INIT;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        ViewStatusListener viewStatusListener = this.f38214a;
        if (viewStatusListener != null) {
            viewStatusListener.onDispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        GDTLogger.d("NativeAdContainer onAttachedToWindow");
        this.f38215b = ViewStatus.ATTACHED;
        ViewStatusListener viewStatusListener = this.f38214a;
        if (viewStatusListener != null) {
            viewStatusListener.onAttachToWindow();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        GDTLogger.d("NativeAdContainer onDetachedFromWindow");
        this.f38215b = ViewStatus.DETACHED;
        ViewStatusListener viewStatusListener = this.f38214a;
        if (viewStatusListener != null) {
            viewStatusListener.onDetachFromWindow();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        GDTLogger.d("onWindowFocusChanged: hasWindowFocus: " + z10);
        ViewStatusListener viewStatusListener = this.f38214a;
        if (viewStatusListener != null) {
            viewStatusListener.onWindowFocusChanged(z10);
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i10) {
        super.onWindowVisibilityChanged(i10);
        GDTLogger.d("onWindowVisibilityChanged: visibility: " + i10);
        ViewStatusListener viewStatusListener = this.f38214a;
        if (viewStatusListener != null) {
            viewStatusListener.onWindowVisibilityChanged(i10);
        }
    }

    public void setViewStatusListener(ViewStatusListener viewStatusListener) {
        this.f38214a = viewStatusListener;
        if (viewStatusListener != null) {
            int ordinal = this.f38215b.ordinal();
            if (ordinal == 1) {
                this.f38214a.onAttachToWindow();
            } else {
                if (ordinal != 2) {
                    return;
                }
                this.f38214a.onDetachFromWindow();
            }
        }
    }
}
