package com.alimm.tanx.ui.image.glide.load.resource.gif;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import com.alimm.tanx.ui.image.glide.gifdecoder.GifDecoder;
import com.alimm.tanx.ui.image.glide.gifdecoder.GifHeader;
import com.alimm.tanx.ui.image.glide.load.Transformation;
import com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool;
import com.alimm.tanx.ui.image.glide.load.resource.drawable.GlideDrawable;
import com.alimm.tanx.ui.image.glide.load.resource.gif.GifFrameLoader;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class GifDrawable extends GlideDrawable implements GifFrameLoader.FrameCallback {
    public boolean applyGravity;
    public final GifDecoder decoder;
    public final Rect destRect;
    public final GifFrameLoader frameLoader;
    public boolean isRecycled;
    public boolean isRunning;
    public boolean isStarted;
    public boolean isVisible;
    public int loopCount;
    public int maxLoopCount;
    public final Paint paint;
    public final GifState state;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class GifState extends Drawable.ConstantState {
        public static final int GRAVITY = 119;
        public BitmapPool bitmapPool;
        public GifDecoder.BitmapProvider bitmapProvider;
        public Context context;
        public byte[] data;
        public Bitmap firstFrame;
        public Transformation<Bitmap> frameTransformation;
        public GifHeader gifHeader;
        public int targetHeight;
        public int targetWidth;

        public GifState(GifHeader gifHeader, byte[] bArr, Context context, Transformation<Bitmap> transformation, int i10, int i11, GifDecoder.BitmapProvider bitmapProvider, BitmapPool bitmapPool, Bitmap bitmap) {
            Objects.requireNonNull(bitmap, "The first frame of the GIF must not be null");
            this.gifHeader = gifHeader;
            this.data = bArr;
            this.bitmapPool = bitmapPool;
            this.firstFrame = bitmap;
            this.context = context.getApplicationContext();
            this.frameTransformation = transformation;
            this.targetWidth = i10;
            this.targetHeight = i11;
            this.bitmapProvider = bitmapProvider;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return newDrawable();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new GifDrawable(this);
        }

        public GifState(GifState gifState) {
            if (gifState != null) {
                this.gifHeader = gifState.gifHeader;
                this.data = gifState.data;
                this.context = gifState.context;
                this.frameTransformation = gifState.frameTransformation;
                this.targetWidth = gifState.targetWidth;
                this.targetHeight = gifState.targetHeight;
                this.bitmapProvider = gifState.bitmapProvider;
                this.bitmapPool = gifState.bitmapPool;
                this.firstFrame = gifState.firstFrame;
            }
        }
    }

    public GifDrawable(Context context, GifDecoder.BitmapProvider bitmapProvider, BitmapPool bitmapPool, Transformation<Bitmap> transformation, int i10, int i11, GifHeader gifHeader, byte[] bArr, Bitmap bitmap) {
        this(new GifState(gifHeader, bArr, context, transformation, i10, i11, bitmapProvider, bitmapPool, bitmap));
    }

    private void reset() {
        this.frameLoader.clear();
        invalidateSelf();
    }

    private void resetLoopCount() {
        this.loopCount = 0;
    }

    private void startRunning() {
        if (this.decoder.getFrameCount() == 1) {
            invalidateSelf();
        } else {
            if (this.isRunning) {
                return;
            }
            this.isRunning = true;
            this.frameLoader.start();
            invalidateSelf();
        }
    }

    private void stopRunning() {
        this.isRunning = false;
        this.frameLoader.stop();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.isRecycled) {
            return;
        }
        if (this.applyGravity) {
            Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), this.destRect);
            this.applyGravity = false;
        }
        Bitmap currentFrame = this.frameLoader.getCurrentFrame();
        if (currentFrame == null) {
            currentFrame = this.state.firstFrame;
        }
        canvas.drawBitmap(currentFrame, (Rect) null, this.destRect, this.paint);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.state;
    }

    public byte[] getData() {
        return this.state.data;
    }

    public GifDecoder getDecoder() {
        return this.decoder;
    }

    public Bitmap getFirstFrame() {
        return this.state.firstFrame;
    }

    public int getFrameCount() {
        return this.decoder.getFrameCount();
    }

    public Transformation<Bitmap> getFrameTransformation() {
        return this.state.frameTransformation;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.state.firstFrame.getHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.state.firstFrame.getWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.resource.drawable.GlideDrawable
    public boolean isAnimated() {
        return true;
    }

    public boolean isRecycled() {
        return this.isRecycled;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.isRunning;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.applyGravity = true;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.resource.gif.GifFrameLoader.FrameCallback
    public void onFrameReady(int i10) {
        if (getCallback() == null) {
            stop();
            reset();
            return;
        }
        invalidateSelf();
        if (i10 == this.decoder.getFrameCount() - 1) {
            this.loopCount++;
        }
        int i11 = this.maxLoopCount;
        if (i11 == -1 || this.loopCount < i11) {
            return;
        }
        stop();
    }

    public void recycle() {
        this.isRecycled = true;
        GifState gifState = this.state;
        gifState.bitmapPool.put(gifState.firstFrame);
        this.frameLoader.clear();
        this.frameLoader.stop();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.paint.setAlpha(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.paint.setColorFilter(colorFilter);
    }

    public void setFrameTransformation(Transformation<Bitmap> transformation, Bitmap bitmap) {
        Objects.requireNonNull(bitmap, "The first frame of the GIF must not be null");
        Objects.requireNonNull(transformation, "The frame transformation must not be null");
        GifState gifState = this.state;
        gifState.frameTransformation = transformation;
        gifState.firstFrame = bitmap;
        this.frameLoader.setFrameTransformation(transformation);
    }

    public void setIsRunning(boolean z10) {
        this.isRunning = z10;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.resource.drawable.GlideDrawable
    public void setLoopCount(int i10) {
        if (i10 <= 0 && i10 != -1 && i10 != 0) {
            throw new IllegalArgumentException("Loop count must be greater than 0, or equal to GlideDrawable.LOOP_FOREVER, or equal to GlideDrawable.LOOP_INTRINSIC");
        }
        if (i10 == 0) {
            int totalIterationCount = this.decoder.getTotalIterationCount();
            this.maxLoopCount = totalIterationCount != 0 ? totalIterationCount : -1;
        } else {
            this.maxLoopCount = i10;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z10, boolean z11) {
        this.isVisible = z10;
        if (!z10) {
            stopRunning();
        } else if (this.isStarted) {
            startRunning();
        }
        return super.setVisible(z10, z11);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.isStarted = true;
        resetLoopCount();
        if (this.isVisible) {
            startRunning();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.isStarted = false;
        stopRunning();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public GifDrawable(com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable r12, android.graphics.Bitmap r13, com.alimm.tanx.ui.image.glide.load.Transformation<android.graphics.Bitmap> r14) {
        /*
            r11 = this;
            com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable$GifState r10 = new com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable$GifState
            com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable$GifState r12 = r12.state
            com.alimm.tanx.ui.image.glide.gifdecoder.GifHeader r1 = r12.gifHeader
            byte[] r2 = r12.data
            android.content.Context r3 = r12.context
            int r5 = r12.targetWidth
            int r6 = r12.targetHeight
            com.alimm.tanx.ui.image.glide.gifdecoder.GifDecoder$BitmapProvider r7 = r12.bitmapProvider
            com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool r8 = r12.bitmapPool
            r0 = r10
            r4 = r14
            r9 = r13
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            r11.<init>(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable.<init>(com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable, android.graphics.Bitmap, com.alimm.tanx.ui.image.glide.load.Transformation):void");
    }

    public GifDrawable(GifState gifState) {
        this.destRect = new Rect();
        this.isVisible = true;
        this.maxLoopCount = -1;
        Objects.requireNonNull(gifState, "GifState must not be null");
        this.state = gifState;
        GifDecoder gifDecoder = new GifDecoder(gifState.bitmapProvider);
        this.decoder = gifDecoder;
        this.paint = new Paint();
        gifDecoder.setData(gifState.gifHeader, gifState.data);
        GifFrameLoader gifFrameLoader = new GifFrameLoader(gifState.context, this, gifDecoder, gifState.targetWidth, gifState.targetHeight);
        this.frameLoader = gifFrameLoader;
        gifFrameLoader.setFrameTransformation(gifState.frameTransformation);
    }

    public GifDrawable(GifDecoder gifDecoder, GifFrameLoader gifFrameLoader, Bitmap bitmap, BitmapPool bitmapPool, Paint paint) {
        this.destRect = new Rect();
        this.isVisible = true;
        this.maxLoopCount = -1;
        this.decoder = gifDecoder;
        this.frameLoader = gifFrameLoader;
        GifState gifState = new GifState(null);
        this.state = gifState;
        this.paint = paint;
        gifState.bitmapPool = bitmapPool;
        gifState.firstFrame = bitmap;
    }
}
