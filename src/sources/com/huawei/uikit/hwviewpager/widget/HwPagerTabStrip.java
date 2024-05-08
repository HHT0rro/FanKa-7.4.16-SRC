package com.huawei.uikit.hwviewpager.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class HwPagerTabStrip extends HwPagerTitleStrip {
    public static final int A = 16;
    public static final int B = 32;
    public static final int C = 64;
    public static final int D = 1;
    public static final int E = 32;

    /* renamed from: w, reason: collision with root package name */
    public static final String f35302w = "HwPagerTabStrip";

    /* renamed from: x, reason: collision with root package name */
    public static final int f35303x = 24;

    /* renamed from: y, reason: collision with root package name */
    public static final int f35304y = 3;

    /* renamed from: z, reason: collision with root package name */
    public static final int f35305z = 6;
    public int F;
    public int G;
    public int H;
    public int I;
    public int J;
    public int K;
    public final Paint L;
    public final Rect M;
    public int N;
    public boolean O;
    public boolean P;
    public int Q;
    public boolean R;
    public float S;
    public float T;
    public int U;

    public HwPagerTabStrip(@NonNull Context context) {
        this(context, null);
    }

    private void a(float f10, float f11) {
        if (!(this.f35314i.getPageScrollDirection() == 0)) {
            if (f11 < this.f35316k.getTop() - this.K) {
                HwViewPager hwViewPager = this.f35314i;
                hwViewPager.setCurrentItem(hwViewPager.getCurrentItem() - 1);
                return;
            } else {
                if (f11 > this.f35316k.getBottom() + this.K) {
                    HwViewPager hwViewPager2 = this.f35314i;
                    hwViewPager2.setCurrentItem(hwViewPager2.getCurrentItem() + 1);
                    return;
                }
                return;
            }
        }
        boolean isRtlLayout = this.f35314i.isRtlLayout();
        if (f10 < this.f35316k.getLeft() - this.K) {
            HwViewPager hwViewPager3 = this.f35314i;
            hwViewPager3.setCurrentItem(isRtlLayout ? hwViewPager3.getCurrentItem() + 1 : hwViewPager3.getCurrentItem() - 1);
        } else if (f10 > this.f35316k.getRight() + this.K) {
            HwViewPager hwViewPager4 = this.f35314i;
            hwViewPager4.setCurrentItem(isRtlLayout ? hwViewPager4.getCurrentItem() - 1 : hwViewPager4.getCurrentItem() + 1);
        }
    }

    private void b() {
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        setTextSpacing(getTextSpacing());
    }

    public boolean getDrawFullUnderline() {
        return this.O;
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerTitleStrip
    public int getMinHeight() {
        return Math.max(super.getMinHeight(), this.J);
    }

    @ColorInt
    public int getTabIndicatorColor() {
        return this.F;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        boolean z10;
        boolean z11;
        if (canvas == null) {
            return;
        }
        super.onDraw(canvas);
        HwViewPager hwViewPager = this.f35314i;
        if (hwViewPager != null) {
            boolean z12 = hwViewPager.getPageScrollDirection() == 0;
            z10 = this.f35314i.isRtlLayout();
            z11 = z12;
        } else {
            z10 = false;
            z11 = true;
        }
        int height = getHeight();
        int bottom = z11 ? height : this.f35316k.getBottom() + this.G;
        int left = this.f35316k.getLeft() - this.K;
        int right = this.f35316k.getRight() + this.K;
        int i10 = bottom - this.G;
        this.L.setColor((this.N << 24) | (this.F & 16777215));
        canvas.drawRect(left, i10, right, bottom, this.L);
        if (this.O) {
            this.L.setColor((this.F & 16777215) | (-16777216));
            a(canvas, z11, z10, height);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 0 && this.R) {
            return false;
        }
        float x10 = motionEvent.getX();
        float y10 = motionEvent.getY();
        if (action == 0) {
            this.S = x10;
            this.T = y10;
            this.R = false;
        } else if (action != 1) {
            if (action == 2 && (Math.abs(x10 - this.S) > this.U || Math.abs(y10 - this.T) > this.U)) {
                this.R = true;
            }
        } else if (this.f35314i != null) {
            a(x10, y10);
        }
        return true;
    }

    @Override // android.view.View
    public void setBackgroundColor(@ColorInt int i10) {
        super.setBackgroundColor(i10);
        if (this.P) {
            return;
        }
        this.O = (i10 & (-16777216)) == 0;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.P) {
            return;
        }
        this.O = drawable == null;
    }

    @Override // android.view.View
    public void setBackgroundResource(@DrawableRes int i10) {
        super.setBackgroundResource(i10);
        if (this.P) {
            return;
        }
        this.O = i10 == 0;
    }

    public void setDrawFullUnderline(boolean z10) {
        this.O = z10;
        this.P = true;
        invalidate();
    }

    @Override // android.view.View
    public void setPadding(int i10, int i11, int i12, int i13) {
        int i14 = this.H;
        if (i13 < i14) {
            i13 = i14;
        }
        super.setPadding(i10, i11, i12, i13);
    }

    public void setTabIndicatorColor(@ColorInt int i10) {
        this.F = i10;
        this.L.setColor(i10);
        invalidate();
    }

    public void setTabIndicatorColorResource(@ColorRes int i10) {
        setTabIndicatorColor(ContextCompat.getColor(getContext(), i10));
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerTitleStrip
    public void setTextSpacing(int i10) {
        int i11 = this.I;
        if (i10 < i11) {
            i10 = i11;
        }
        super.setTextSpacing(i10);
    }

    public HwPagerTabStrip(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Paint paint = new Paint();
        this.L = paint;
        this.M = new Rect();
        this.N = 255;
        this.O = false;
        this.P = false;
        int i10 = this.f35327v;
        this.F = i10;
        paint.setColor(i10);
        float f10 = context.getResources().getDisplayMetrics().density;
        this.G = (int) ((3.0f * f10) + 0.5f);
        this.H = (int) ((6.0f * f10) + 0.5f);
        this.I = (int) (64.0f * f10);
        this.K = (int) ((16.0f * f10) + 0.5f);
        this.Q = (int) ((1.0f * f10) + 0.5f);
        this.J = (int) ((f10 * 32.0f) + 0.5f);
        this.U = ViewConfiguration.get(context).getScaledTouchSlop();
        b();
        setWillNotDraw(false);
        this.f35315j.setFocusable(true);
        this.f35315j.setOnClickListener(new b(this));
        this.f35317l.setFocusable(true);
        this.f35317l.setOnClickListener(new c(this));
        if (getBackground() == null) {
            this.O = true;
        }
    }

    private void a(Canvas canvas, boolean z10, boolean z11, int i10) {
        if (z10) {
            canvas.drawRect(getPaddingLeft(), i10 - this.Q, getWidth() - getPaddingRight(), i10, this.L);
        } else if (z11) {
            canvas.drawRect(getPaddingLeft(), getPaddingTop(), getPaddingLeft() + this.Q, i10, this.L);
        } else {
            canvas.drawRect((getWidth() - getPaddingRight()) - this.Q, getPaddingTop(), getWidth() - getPaddingRight(), i10, this.L);
        }
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerTitleStrip
    public void a(int i10, float f10, boolean z10) {
        Rect rect = this.M;
        int height = getHeight();
        int left = this.f35316k.getLeft() - this.K;
        int right = this.f35316k.getRight() + this.K;
        int i11 = height - this.G;
        rect.set(left, i11, right, height);
        super.a(i10, f10, z10);
        this.N = (int) (Math.abs(f10 - 0.5f) * 2.0f * 255.0f);
        rect.union(this.f35316k.getLeft() - this.K, i11, this.f35316k.getRight() + this.K, height);
        invalidate(rect);
    }
}
