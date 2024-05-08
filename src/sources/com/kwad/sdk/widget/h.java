package com.kwad.sdk.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.service.ServiceProvider;
import java.util.Arrays;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class h {
    private boolean mClipBackground;

    @NonNull
    private a mCornerConf;
    private Paint mPaint;
    private Path mPath;
    private float mRadius;
    private RectF mRectF;
    public float[] radiusArray;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a {
        private boolean leftTop = true;
        private boolean topRight = true;
        private boolean rightBottom = true;
        private boolean bottomLeft = true;

        public final a cf(boolean z10) {
            this.leftTop = z10;
            return this;
        }

        public final a cg(boolean z10) {
            this.topRight = z10;
            return this;
        }

        public final a ch(boolean z10) {
            this.rightBottom = z10;
            return this;
        }

        public final a ci(boolean z10) {
            this.bottomLeft = z10;
            return this;
        }

        public final boolean isBottomLeft() {
            return this.bottomLeft;
        }

        public final boolean isLeftTop() {
            return this.leftTop;
        }

        public final boolean isRightBottom() {
            return this.rightBottom;
        }

        public final boolean isTopRight() {
            return this.topRight;
        }

        public final void setAllCorner(boolean z10) {
            this.leftTop = z10;
            this.topRight = z10;
            this.rightBottom = z10;
            this.bottomLeft = z10;
        }
    }

    public h() {
        this.radiusArray = new float[8];
        this.mCornerConf = new a();
    }

    private Path getPath() {
        float[] radius;
        try {
            this.mPath.reset();
        } catch (Exception unused) {
        }
        if (this.mRadius == 0.0f) {
            radius = this.radiusArray;
        } else {
            radius = getRadius();
        }
        this.mPath.addRoundRect(this.mRectF, radius, Path.Direction.CW);
        return this.mPath;
    }

    private float[] getRadius() {
        this.radiusArray[0] = this.mCornerConf.isLeftTop() ? this.mRadius : 0.0f;
        this.radiusArray[1] = this.mCornerConf.isLeftTop() ? this.mRadius : 0.0f;
        this.radiusArray[2] = this.mCornerConf.isTopRight() ? this.mRadius : 0.0f;
        this.radiusArray[3] = this.mCornerConf.isTopRight() ? this.mRadius : 0.0f;
        this.radiusArray[4] = this.mCornerConf.isRightBottom() ? this.mRadius : 0.0f;
        this.radiusArray[5] = this.mCornerConf.isRightBottom() ? this.mRadius : 0.0f;
        this.radiusArray[6] = this.mCornerConf.isBottomLeft() ? this.mRadius : 0.0f;
        this.radiusArray[7] = this.mCornerConf.isBottomLeft() ? this.mRadius : 0.0f;
        return this.radiusArray;
    }

    public final void afterDispatchDraw(Canvas canvas) {
        if (Build.VERSION.SDK_INT < 28) {
            canvas.drawPath(getPath(), this.mPaint);
        }
        canvas.restore();
    }

    public final void afterDraw(Canvas canvas) {
        if (this.mClipBackground) {
            if (Build.VERSION.SDK_INT < 28) {
                canvas.drawPath(getPath(), this.mPaint);
            }
            canvas.restore();
        }
    }

    public final void beforeDispatchDraw(Canvas canvas) {
        if (Build.VERSION.SDK_INT >= 28) {
            canvas.save();
            canvas.clipPath(getPath());
        } else {
            canvas.saveLayer(this.mRectF, null, 31);
        }
    }

    public final void beforeDraw(Canvas canvas) {
        if (this.mClipBackground) {
            if (Build.VERSION.SDK_INT < 28) {
                canvas.saveLayer(this.mRectF, null, 31);
            } else {
                canvas.save();
                canvas.clipPath(getPath());
            }
        }
    }

    @NonNull
    public final a getCornerConf() {
        return this.mCornerConf;
    }

    public final void initAttrs(Context context, @Nullable AttributeSet attributeSet) {
        if (attributeSet != null) {
            try {
                int i10 = R.attr.ksad_radius;
                int i11 = R.attr.ksad_clipBackground;
                int[] iArr = {i10, i11};
                Arrays.sort(iArr);
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
                this.mRadius = obtainStyledAttributes.getDimensionPixelOffset(Arrays.binarySearch(iArr, i10), 0);
                this.mClipBackground = obtainStyledAttributes.getBoolean(Arrays.binarySearch(iArr, i11), true);
                obtainStyledAttributes.recycle();
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
                return;
            }
        }
        this.mPath = new Path();
        this.mPaint = new Paint(1);
        this.mRectF = new RectF();
        this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    }

    public final void onSizeChanged(int i10, int i11) {
        this.mRectF.set(0.0f, 0.0f, i10, i11);
    }

    public final void setRadius(float f10) {
        this.mRadius = f10;
    }

    public final void setRadius(float[] fArr) {
        this.radiusArray = fArr;
    }

    public h(a aVar) {
        this.radiusArray = new float[8];
        this.mCornerConf = aVar;
    }
}
