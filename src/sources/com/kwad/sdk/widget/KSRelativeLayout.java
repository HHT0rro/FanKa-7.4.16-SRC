package com.kwad.sdk.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ac;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class KSRelativeLayout extends RelativeLayout implements i {
    private final AtomicBoolean UJ;
    private final ac.a aCH;
    private i aSA;
    private g aSz;
    private float mRatio;
    private h mViewRCHelper;

    public KSRelativeLayout(@NonNull Context context) {
        super(context);
        this.UJ = new AtomicBoolean(true);
        this.mRatio = 0.0f;
        this.aCH = new ac.a();
        init(context, null);
    }

    private void init(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        if (attributeSet != null) {
            int i10 = R.attr.ksad_ratio;
            int[] iArr = {i10};
            Arrays.sort(iArr);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
            this.mRatio = obtainStyledAttributes.getFloat(Arrays.binarySearch(iArr, i10), 0.0f);
            obtainStyledAttributes.recycle();
        }
        g gVar = new g(this, this);
        this.aSz = gVar;
        gVar.ce(true);
        h hVar = new h();
        this.mViewRCHelper = hVar;
        hVar.initAttrs(context, attributeSet);
    }

    private void tl() {
        if (this.UJ.getAndSet(false)) {
            ac();
        }
    }

    private void tm() {
        if (this.UJ.getAndSet(true)) {
            return;
        }
        ad();
    }

    @Override // com.kwad.sdk.widget.i
    @CallSuper
    public final void A(View view) {
        i iVar = this.aSA;
        if (iVar != null) {
            iVar.A(view);
        }
    }

    @CallSuper
    public void ac() {
        this.aSz.onAttachedToWindow();
    }

    @CallSuper
    public void ad() {
        this.aSz.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        this.mViewRCHelper.beforeDispatchDraw(canvas);
        try {
            super.dispatchDraw(canvas);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
        this.mViewRCHelper.afterDispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.aCH.z(getWidth(), getHeight());
            this.aCH.f(motionEvent.getX(), motionEvent.getY());
        } else if (action == 1) {
            this.aCH.g(motionEvent.getX(), motionEvent.getY());
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        this.mViewRCHelper.beforeDraw(canvas);
        super.draw(canvas);
        this.mViewRCHelper.afterDraw(canvas);
    }

    @MainThread
    public ac.a getTouchCoords() {
        return this.aCH;
    }

    public float getVisiblePercent() {
        return this.aSz.getVisiblePercent();
    }

    @Override // android.view.ViewGroup, android.view.View
    @Deprecated
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        tl();
    }

    @Override // android.view.ViewGroup, android.view.View
    @Deprecated
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        tm();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        tl();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        if (this.mRatio != 0.0f) {
            i11 = View.MeasureSpec.makeMeasureSpec((int) (View.MeasureSpec.getSize(i10) * this.mRatio), 1073741824);
        }
        super.onMeasure(i10, i11);
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        this.aSz.b(i10, i11, i12, i13);
        super.onSizeChanged(i10, i11, i12, i13);
        this.aSz.NS();
        this.mViewRCHelper.onSizeChanged(i10, i11);
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        tm();
    }

    public void setRadius(float f10) {
        this.mViewRCHelper.setRadius(f10);
        postInvalidate();
    }

    public void setRatio(float f10) {
        this.mRatio = f10;
    }

    public void setViewVisibleListener(i iVar) {
        this.aSA = iVar;
    }

    public void setVisiblePercent(float f10) {
        this.aSz.setVisiblePercent(f10);
    }

    public KSRelativeLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.UJ = new AtomicBoolean(true);
        this.mRatio = 0.0f;
        this.aCH = new ac.a();
        init(context, attributeSet);
    }

    public KSRelativeLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.UJ = new AtomicBoolean(true);
        this.mRatio = 0.0f;
        this.aCH = new ac.a();
        init(context, attributeSet);
    }
}
