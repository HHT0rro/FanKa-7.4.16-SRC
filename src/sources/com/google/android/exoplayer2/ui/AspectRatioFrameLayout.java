package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class AspectRatioFrameLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    public final c f22352b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public b f22353c;

    /* renamed from: d, reason: collision with root package name */
    public float f22354d;

    /* renamed from: e, reason: collision with root package name */
    public int f22355e;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface b {
        void a(float f10, float f11, boolean z10);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public final class c implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public float f22356b;

        /* renamed from: c, reason: collision with root package name */
        public float f22357c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f22358d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f22359e;

        public c() {
        }

        public void a(float f10, float f11, boolean z10) {
            this.f22356b = f10;
            this.f22357c = f11;
            this.f22358d = z10;
            if (this.f22359e) {
                return;
            }
            this.f22359e = true;
            AspectRatioFrameLayout.this.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f22359e = false;
            if (AspectRatioFrameLayout.this.f22353c == null) {
                return;
            }
            AspectRatioFrameLayout.this.f22353c.a(this.f22356b, this.f22357c, this.f22358d);
        }
    }

    public AspectRatioFrameLayout(Context context) {
        this(context, null);
    }

    public int getResizeMode() {
        return this.f22355e;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        float f10;
        float f11;
        super.onMeasure(i10, i11);
        if (this.f22354d <= 0.0f) {
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float f12 = measuredWidth;
        float f13 = measuredHeight;
        float f14 = f12 / f13;
        float f15 = (this.f22354d / f14) - 1.0f;
        if (Math.abs(f15) <= 0.01f) {
            this.f22352b.a(this.f22354d, f14, false);
            return;
        }
        int i12 = this.f22355e;
        if (i12 != 0) {
            if (i12 != 1) {
                if (i12 == 2) {
                    f10 = this.f22354d;
                } else if (i12 == 4) {
                    if (f15 > 0.0f) {
                        f10 = this.f22354d;
                    } else {
                        f11 = this.f22354d;
                    }
                }
                measuredWidth = (int) (f13 * f10);
            } else {
                f11 = this.f22354d;
            }
            measuredHeight = (int) (f12 / f11);
        } else if (f15 > 0.0f) {
            f11 = this.f22354d;
            measuredHeight = (int) (f12 / f11);
        } else {
            f10 = this.f22354d;
            measuredWidth = (int) (f13 * f10);
        }
        this.f22352b.a(this.f22354d, f14, true);
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
    }

    public void setAspectRatio(float f10) {
        if (this.f22354d != f10) {
            this.f22354d = f10;
            requestLayout();
        }
    }

    public void setAspectRatioListener(@Nullable b bVar) {
        this.f22353c = bVar;
    }

    public void setResizeMode(int i10) {
        if (this.f22355e != i10) {
            this.f22355e = i10;
            requestLayout();
        }
    }

    public AspectRatioFrameLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f22355e = 0;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.AspectRatioFrameLayout, 0, 0);
            try {
                this.f22355e = obtainStyledAttributes.getInt(R$styleable.AspectRatioFrameLayout_resize_mode, 0);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        this.f22352b = new c();
    }
}
