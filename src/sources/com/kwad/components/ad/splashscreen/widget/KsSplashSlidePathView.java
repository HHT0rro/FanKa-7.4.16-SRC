package com.kwad.components.ad.splashscreen.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;
import androidx.annotation.Nullable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class KsSplashSlidePathView extends ImageView {
    private Path GM;
    private Paint GN;
    private float GO;
    private float GP;
    private float GQ;
    private float GR;
    private int GS;
    private a GT;
    private GestureDetector GU;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface a {
        void a(float f10, float f11, float f12, float f13);

        void lu();
    }

    public KsSplashSlidePathView(Context context) {
        super(context);
        this.GS = Color.parseColor("#66ffffff");
        init();
    }

    private void b(MotionEvent motionEvent) {
        if (this.GU.onTouchEvent(motionEvent)) {
            return;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.GM.reset();
            this.GO = motionEvent.getX();
            float y10 = motionEvent.getY();
            this.GP = y10;
            float f10 = this.GO;
            this.GQ = f10;
            this.GR = y10;
            this.GM.moveTo(f10, y10);
            invalidate();
            return;
        }
        if (actionMasked != 1) {
            if (actionMasked != 2) {
                return;
            }
            c(motionEvent.getX(), motionEvent.getY());
            invalidate();
            return;
        }
        this.GM.reset();
        invalidate();
        a aVar = this.GT;
        if (aVar != null) {
            aVar.a(this.GO, this.GP, motionEvent.getX(), motionEvent.getY());
        }
    }

    private void c(float f10, float f11) {
        float abs = Math.abs(f10 - this.GQ);
        float abs2 = Math.abs(f11 - this.GR);
        if (abs >= 3.0f || abs2 >= 3.0f) {
            Path path = this.GM;
            float f12 = this.GQ;
            float f13 = this.GR;
            path.quadTo(f12, f13, (f10 + f12) / 2.0f, (f11 + f13) / 2.0f);
            this.GQ = f10;
            this.GR = f11;
        }
    }

    private void init() {
        this.GM = new Path();
        Paint paint = new Paint();
        this.GN = paint;
        paint.setStrokeCap(Paint.Cap.ROUND);
        this.GN.setStrokeWidth(com.kwad.sdk.d.a.a.a(getContext(), 15.0f));
        this.GN.setStyle(Paint.Style.STROKE);
        this.GN.setColor(this.GS);
        this.GN.setDither(true);
        this.GU = new GestureDetector(new GestureDetector.OnGestureListener() { // from class: com.kwad.components.ad.splashscreen.widget.KsSplashSlidePathView.1
            @Override // android.view.GestureDetector.OnGestureListener
            public final boolean onDown(MotionEvent motionEvent) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f10, float f11) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public final void onLongPress(MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f10, float f11) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public final void onShowPress(MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public final boolean onSingleTapUp(MotionEvent motionEvent) {
                if (KsSplashSlidePathView.this.GT == null) {
                    return false;
                }
                KsSplashSlidePathView.this.GT.lu();
                return true;
            }
        });
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.GM, this.GN);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        b(motionEvent);
        return true;
    }

    public void setOnSlideTouchListener(a aVar) {
        this.GT = aVar;
    }

    public KsSplashSlidePathView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.GS = Color.parseColor("#66ffffff");
        init();
    }
}
