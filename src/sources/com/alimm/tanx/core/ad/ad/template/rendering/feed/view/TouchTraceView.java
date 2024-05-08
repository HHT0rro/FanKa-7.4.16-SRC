package com.alimm.tanx.core.ad.ad.template.rendering.feed.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.alimm.tanx.core.utils.LogUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class TouchTraceView extends View {
    public float tanxc_byte;
    public float tanxc_case;
    public float tanxc_char;
    public Context tanxc_do;
    public int tanxc_else;
    public float tanxc_for;
    public final boolean tanxc_goto;
    public InteractionCallBack tanxc_if;
    public final Paint tanxc_int;
    public final int tanxc_long;
    public final Path tanxc_new;
    public final int tanxc_this;
    public float tanxc_try;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface InteractionCallBack {
        void onInteractionEnd(int i10, int i11, int i12);

        void onInteractionStart();
    }

    public TouchTraceView(Context context, AttributeSet attributeSet, InteractionCallBack interactionCallBack) {
        super(context, attributeSet);
        this.tanxc_else = 3;
        this.tanxc_goto = false;
        this.tanxc_long = 55;
        this.tanxc_this = 120;
        this.tanxc_for = 0.56f;
        this.tanxc_do = context;
        this.tanxc_new = new Path();
        Paint paint = new Paint();
        this.tanxc_int = paint;
        paint.setColor(-1);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(10.0f);
        this.tanxc_if = interactionCallBack;
    }

    private int tanxc_do(float f10, float f11, float f12, float f13) {
        float f14 = f10 - f11;
        float f15 = f12 - f13;
        return (int) Math.sqrt((f14 * f14) + (f15 * f15));
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        LogUtils.d("TouchTraceView", "onDraw");
        canvas.drawPath(this.tanxc_new, this.tanxc_int);
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, View.MeasureSpec.makeMeasureSpec((int) (View.MeasureSpec.getSize(i10) * this.tanxc_for), 1073741824));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        float x10 = motionEvent.getX();
        float y10 = motionEvent.getY();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            LogUtils.d("TouchTraceView", "ACTION_DOWN");
            this.tanxc_case = x10;
            this.tanxc_char = y10;
            this.tanxc_new.moveTo(x10, y10);
            InteractionCallBack interactionCallBack = this.tanxc_if;
            if (interactionCallBack != null) {
                interactionCallBack.onInteractionStart();
            }
        } else {
            if (actionMasked == 1) {
                LogUtils.d("TouchTraceView", "ACTION_UP");
                LogUtils.d("touch--->", "x: " + (x10 - this.tanxc_case) + " y:" + (y10 - this.tanxc_char));
                this.tanxc_new.reset();
                requestLayout();
                InteractionCallBack interactionCallBack2 = this.tanxc_if;
                float f10 = this.tanxc_case;
                float f11 = this.tanxc_char;
                interactionCallBack2.onInteractionEnd((int) (x10 - f10), (int) (y10 - f11), tanxc_do(x10, f10, y10, f11));
                return true;
            }
            if (actionMasked != 2) {
                LogUtils.d("TouchTraceView", "default");
                this.tanxc_new.reset();
            } else {
                LogUtils.d("TouchTraceView", "ACTION_MOVE");
                this.tanxc_new.quadTo(this.tanxc_try, this.tanxc_byte, x10, y10);
            }
        }
        invalidate();
        this.tanxc_try = x10;
        this.tanxc_byte = y10;
        return true;
    }

    @Override // android.view.View
    public void onVisibilityAggregated(boolean z10) {
        Path path;
        super.onVisibilityAggregated(z10);
        LogUtils.d("TouchTraceView", "onVisibilityAggregated:" + z10);
        if (z10 || (path = this.tanxc_new) == null) {
            return;
        }
        path.reset();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z10) {
        Path path;
        super.onWindowFocusChanged(z10);
        if (!z10 && (path = this.tanxc_new) != null) {
            path.reset();
        }
        LogUtils.d("TouchTraceView", "onWindowFocusChanged:" + z10);
    }

    public void tanxc_do(float f10) {
        this.tanxc_for = f10;
    }
}
