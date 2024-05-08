package com.kwad.components.core.page.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import com.kwad.sdk.n.l;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class TextProgressBar extends ProgressBar {
    private boolean QA;
    private boolean QB;
    private boolean QC;
    private int QD;
    private int QE;
    private Drawable QF;
    private int QG;
    private Rect QH;
    private int[] QI;
    private int QJ;
    private int QK;
    private boolean QL;

    @Nullable
    private String Qx;
    private LinearGradient Qy;
    private Matrix Qz;
    private Paint mPaint;
    private RectF mRectF;

    public TextProgressBar(Context context) {
        this(context, null);
    }

    private void qc() {
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mPaint.setColor(-1);
        this.mPaint.setTextSize(com.kwad.sdk.d.a.a.a(getContext(), 12.0f));
        this.QG = com.kwad.sdk.d.a.a.a(getContext(), 2.0f);
        this.mRectF = new RectF();
        this.QJ = -1;
        this.QK = -117146;
    }

    private void setProgressText(int i10) {
        this.Qx = String.valueOf((int) (((i10 * 1.0f) / getMax()) * 100.0f)) + "%";
    }

    public final void e(String str, int i10) {
        this.Qx = str;
        this.QA = true;
        setProgress(i10);
        invalidate();
    }

    @Override // android.widget.ProgressBar, android.view.View
    public synchronized void onDraw(Canvas canvas) {
        int width;
        if (this.QB) {
            canvas.save();
            canvas.rotate(90.0f);
            canvas.translate(0.0f, -getWidth());
            super.onDraw(canvas);
            canvas.restore();
        } else {
            super.onDraw(canvas);
        }
        if (!TextUtils.isEmpty(this.Qx)) {
            Paint paint = this.mPaint;
            String str = this.Qx;
            paint.getTextBounds(str, 0, str.length(), this.QH);
        }
        int height = (getHeight() / 2) - this.QH.centerY();
        Drawable drawable = this.QF;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = this.QF.getIntrinsicHeight();
            int width2 = (((getWidth() - this.QH.width()) - intrinsicWidth) - this.QG) / 2;
            int i10 = intrinsicWidth + width2;
            this.QF.setBounds(width2, (getHeight() - intrinsicHeight) / 2, i10, (getHeight() + intrinsicHeight) / 2);
            this.QF.draw(canvas);
            width = i10 + this.QG;
        } else {
            width = (getWidth() / 2) - this.QH.centerX();
        }
        if (this.QI != null) {
            float progress = ((getProgress() * 1.0f) / getMax()) * getWidth();
            float f10 = width;
            if (progress >= f10) {
                if (this.Qy == null) {
                    this.Qy = new LinearGradient(f10, 0.0f, width + this.QH.width(), 0.0f, this.QI, (float[]) null, Shader.TileMode.CLAMP);
                    Matrix matrix = new Matrix();
                    this.Qz = matrix;
                    this.Qy.setLocalMatrix(matrix);
                }
                this.mPaint.setShader(this.Qy);
                this.Qz.setScale(((progress - f10) * 1.0f) / this.QH.width(), 1.0f, f10, 0.0f);
                this.Qy.setLocalMatrix(this.Qz);
            } else {
                this.mPaint.setShader(null);
            }
            canvas.drawText(this.Qx, f10, height, this.mPaint);
            return;
        }
        if (!isIndeterminate() && !this.QL) {
            this.mPaint.setColor(this.QJ);
            String str2 = this.Qx;
            if (str2 != null) {
                canvas.drawText(str2, width, height, this.mPaint);
            }
            return;
        }
        float width3 = (getWidth() * getProgress()) / getMax();
        int save = canvas.save();
        this.mRectF.set(width3, 0.0f, getWidth(), getHeight());
        canvas.clipRect(this.mRectF);
        this.mPaint.setColor(this.QK);
        String str3 = this.Qx;
        if (str3 != null) {
            canvas.drawText(str3, width, height, this.mPaint);
        }
        canvas.restoreToCount(save);
        int save2 = canvas.save();
        this.mRectF.set(0.0f, 0.0f, width3, getHeight());
        canvas.clipRect(this.mRectF);
        this.mPaint.setColor(this.QJ);
        String str4 = this.Qx;
        if (str4 != null) {
            canvas.drawText(str4, width, height, this.mPaint);
        }
        canvas.restoreToCount(save2);
    }

    @Override // android.widget.ProgressBar, android.view.View
    public synchronized void onMeasure(int i10, int i11) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null && !TextUtils.isEmpty(this.Qx)) {
            Rect rect = new Rect();
            Paint paint = this.mPaint;
            String str = this.Qx;
            paint.getTextBounds(str, 0, str.length(), rect);
            if (layoutParams.width == -2) {
                int width = rect.width() + this.QD + this.QE;
                layoutParams.width = width;
                i10 = View.MeasureSpec.makeMeasureSpec(width, 1073741824);
            }
            if (layoutParams.height == -2) {
                int height = rect.height();
                layoutParams.height = height;
                i11 = View.MeasureSpec.makeMeasureSpec(height, 1073741824);
            }
        }
        if (this.QB) {
            super.onMeasure(i11, i10);
            setMeasuredDimension(getMeasuredHeight(), getMeasuredWidth());
        } else {
            super.onMeasure(i10, i11);
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        if (this.QB) {
            super.onSizeChanged(i11, i10, i12, i13);
        } else {
            super.onSizeChanged(i10, i11, i12, i13);
        }
    }

    public void setDrawableLeft(Drawable drawable) {
        this.QF = drawable;
    }

    public void setDrawablePadding(int i10) {
        this.QG = i10;
    }

    public void setHasProgress(boolean z10) {
        this.QC = z10;
    }

    @Override // android.view.View
    public void setPadding(int i10, int i11, int i12, int i13) {
        this.QD = i10;
        this.QE = i12;
    }

    @Override // android.widget.ProgressBar
    public void setProgress(int i10) {
        if (this.QC) {
            super.setProgress(i10);
        } else {
            super.setProgress(0);
        }
    }

    public void setTextColor(int i10) {
        this.QL = false;
        this.QJ = i10;
        postInvalidate();
    }

    public void setTextDimen(float f10) {
        this.mPaint.setTextSize(f10);
    }

    public void setTextDimenSp(int i10) {
        this.mPaint.setTextSize(TypedValue.applyDimension(2, i10, getResources().getDisplayMetrics()));
    }

    public void setVertical(boolean z10) {
        this.QB = z10;
    }

    public TextProgressBar(Context context, AttributeSet attributeSet) {
        super(l.wrapContextIfNeed(context), attributeSet);
        this.QB = false;
        this.QC = true;
        this.QH = new Rect();
        qc();
    }

    public final void setTextColor(@ColorInt int i10, @ColorInt int i11) {
        this.QL = true;
        this.QJ = i10;
        this.QK = i11;
        postInvalidate();
    }
}
