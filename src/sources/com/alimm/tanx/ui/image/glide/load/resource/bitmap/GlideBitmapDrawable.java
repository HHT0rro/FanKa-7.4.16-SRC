package com.alimm.tanx.ui.image.glide.load.resource.bitmap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import com.alimm.tanx.ui.image.glide.load.resource.drawable.GlideDrawable;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class GlideBitmapDrawable extends GlideDrawable {
    public boolean applyGravity;
    public final Rect destRect;
    public int height;
    public boolean mutated;
    public BitmapState state;
    public int width;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class BitmapState extends Drawable.ConstantState {
        public static final Paint DEFAULT_PAINT = new Paint(6);
        public static final int DEFAULT_PAINT_FLAGS = 6;
        public static final int GRAVITY = 119;
        public final Bitmap bitmap;
        public Paint paint;
        public int targetDensity;

        public BitmapState(Bitmap bitmap) {
            this.paint = DEFAULT_PAINT;
            this.bitmap = bitmap;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        public void mutatePaint() {
            if (DEFAULT_PAINT == this.paint) {
                this.paint = new Paint(6);
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new GlideBitmapDrawable((Resources) null, this);
        }

        public void setAlpha(int i10) {
            mutatePaint();
            this.paint.setAlpha(i10);
        }

        public void setColorFilter(ColorFilter colorFilter) {
            mutatePaint();
            this.paint.setColorFilter(colorFilter);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new GlideBitmapDrawable(resources, this);
        }

        public BitmapState(BitmapState bitmapState) {
            this(bitmapState.bitmap);
            this.targetDensity = bitmapState.targetDensity;
        }
    }

    public GlideBitmapDrawable(Resources resources, Bitmap bitmap) {
        this(resources, new BitmapState(bitmap));
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.applyGravity) {
            Gravity.apply(119, this.width, this.height, getBounds(), this.destRect);
            this.applyGravity = false;
        }
        BitmapState bitmapState = this.state;
        canvas.drawBitmap(bitmapState.bitmap, (Rect) null, this.destRect, bitmapState.paint);
    }

    public Bitmap getBitmap() {
        return this.state.bitmap;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.state;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.height;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.width;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Bitmap bitmap = this.state.bitmap;
        return (bitmap == null || bitmap.hasAlpha() || this.state.paint.getAlpha() < 255) ? -3 : -1;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.resource.drawable.GlideDrawable
    public boolean isAnimated() {
        return false;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.mutated && super.mutate() == this) {
            this.state = new BitmapState(this.state);
            this.mutated = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.applyGravity = true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        if (this.state.paint.getAlpha() != i10) {
            this.state.setAlpha(i10);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.state.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // com.alimm.tanx.ui.image.glide.load.resource.drawable.GlideDrawable
    public void setLoopCount(int i10) {
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
    }

    public GlideBitmapDrawable(Resources resources, BitmapState bitmapState) {
        int i10;
        this.destRect = new Rect();
        Objects.requireNonNull(bitmapState, "BitmapState must not be null");
        this.state = bitmapState;
        if (resources != null) {
            i10 = resources.getDisplayMetrics().densityDpi;
            i10 = i10 == 0 ? 160 : i10;
            bitmapState.targetDensity = i10;
        } else {
            i10 = bitmapState.targetDensity;
        }
        this.width = bitmapState.bitmap.getScaledWidth(i10);
        this.height = bitmapState.bitmap.getScaledHeight(i10);
    }
}
