package com.alibaba.security.common.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import java.math.BigDecimal;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class GifImageView extends ImageView {
    private static final int DEFAULT_DURATION = 1000;
    private int mCounts;
    private final boolean mEndLastFrame;
    private volatile boolean mHasStart;
    private Movie mMovie;
    private int mMovieDuration;
    private long mMoviePauseTime;
    private long mMovieStart;
    private long mOffsetTime;
    private OnPlayListener mOnPlayListener;
    private volatile boolean mPaused;
    public float mPercent;
    private volatile boolean mReverse;
    private float mScale;
    private float mScaleH;
    private float mScaleW;
    private boolean mVisible;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface OnPlayListener {
        void onPlayEnd();

        void onPlayPause(boolean z10);

        void onPlayRestart();

        void onPlayStart();

        void onPlaying(float f10);
    }

    public GifImageView(Context context) {
        this(context, null);
        setLayerType(1, null);
    }

    private void drawMovieFrame(Canvas canvas) {
        canvas.save();
        float f10 = this.mScale;
        canvas.scale(1.0f / f10, 1.0f / f10);
        this.mMovie.draw(canvas, 0.0f, 0.0f);
        canvas.restore();
    }

    private int getCurrentFrameTime() {
        if (this.mMovieDuration == 0) {
            return 0;
        }
        long uptimeMillis = SystemClock.uptimeMillis() - this.mOffsetTime;
        long j10 = this.mMovieStart;
        int i10 = this.mMovieDuration;
        int i11 = (int) ((uptimeMillis - j10) / i10);
        int i12 = this.mCounts;
        if (i12 != -1 && i11 >= i12) {
            this.mHasStart = false;
            OnPlayListener onPlayListener = this.mOnPlayListener;
            if (onPlayListener != null) {
                onPlayListener.onPlayEnd();
            }
            return 0;
        }
        float f10 = (float) ((uptimeMillis - j10) % i10);
        this.mPercent = f10 / i10;
        if (this.mOnPlayListener != null && this.mHasStart) {
            double doubleValue = new BigDecimal(this.mPercent).setScale(2, 4).doubleValue();
            if (doubleValue == 0.99d) {
                doubleValue = 1.0d;
            }
            this.mOnPlayListener.onPlaying((float) doubleValue);
        }
        return (int) f10;
    }

    private void invalidateView() {
        if (this.mVisible) {
            postInvalidateOnAnimation();
        }
    }

    private void reset() {
        this.mReverse = false;
        this.mMovieStart = SystemClock.uptimeMillis();
        this.mPaused = false;
        this.mHasStart = true;
        this.mMoviePauseTime = 0L;
        this.mOffsetTime = 0L;
    }

    public int getDuration() {
        Movie movie = this.mMovie;
        if (movie != null) {
            return movie.duration();
        }
        return 0;
    }

    public boolean isPaused() {
        return this.mPaused;
    }

    public boolean isPlaying() {
        return !this.mPaused && this.mHasStart;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mMovie != null) {
            if (!this.mPaused && this.mHasStart) {
                if (this.mReverse) {
                    this.mMovie.setTime(this.mMovieDuration - getCurrentFrameTime());
                } else {
                    this.mMovie.setTime(getCurrentFrameTime());
                }
                drawMovieFrame(canvas);
                invalidateView();
                return;
            }
            drawMovieFrame(canvas);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i10, int i11) {
        int mode = View.MeasureSpec.getMode(i10);
        int mode2 = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i10);
        int size2 = View.MeasureSpec.getSize(i11);
        Movie movie = this.mMovie;
        if (movie != null) {
            int width = movie.width();
            int height = this.mMovie.height();
            if (mode == 1073741824) {
                this.mScaleW = width / size;
            }
            if (mode2 == 1073741824) {
                this.mScaleH = height / size2;
            }
            this.mScale = Math.max(this.mScaleW, this.mScaleH);
            if (mode != 1073741824) {
                size = width;
            }
            if (mode2 != 1073741824) {
                size2 = height;
            }
            setMeasuredDimension(size, size2);
            return;
        }
        super.onMeasure(i10, i11);
    }

    @Override // android.view.View
    public void onScreenStateChanged(int i10) {
        super.onScreenStateChanged(i10);
        this.mVisible = i10 == 1;
        invalidateView();
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i10) {
        super.onVisibilityChanged(view, i10);
        this.mVisible = i10 == 0;
        invalidateView();
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i10) {
        super.onWindowVisibilityChanged(i10);
        this.mVisible = i10 == 0;
        invalidateView();
    }

    public void pause() {
        if (this.mMovie != null && !this.mPaused && this.mHasStart) {
            this.mPaused = true;
            invalidate();
            this.mMoviePauseTime = SystemClock.uptimeMillis();
            OnPlayListener onPlayListener = this.mOnPlayListener;
            if (onPlayListener != null) {
                onPlayListener.onPlayPause(true);
                return;
            }
            return;
        }
        OnPlayListener onPlayListener2 = this.mOnPlayListener;
        if (onPlayListener2 != null) {
            onPlayListener2.onPlayPause(false);
        }
    }

    public void play(int i10) {
        this.mCounts = i10;
        reset();
        OnPlayListener onPlayListener = this.mOnPlayListener;
        if (onPlayListener != null) {
            onPlayListener.onPlayStart();
        }
        invalidate();
    }

    public void playOver() {
        if (this.mMovie != null) {
            play(-1);
        }
    }

    public void playReverse() {
        if (this.mMovie != null) {
            reset();
            this.mReverse = true;
            OnPlayListener onPlayListener = this.mOnPlayListener;
            if (onPlayListener != null) {
                onPlayListener.onPlayStart();
            }
            invalidate();
        }
    }

    public void setGifResource(int i10, OnPlayListener onPlayListener) {
        Bitmap decodeResource;
        if (onPlayListener != null) {
            this.mOnPlayListener = onPlayListener;
        }
        reset();
        Movie decodeStream = Movie.decodeStream(getResources().openRawResource(i10));
        this.mMovie = decodeStream;
        if (decodeStream == null && (decodeResource = BitmapFactory.decodeResource(getResources(), i10)) != null) {
            setImageBitmap(decodeResource);
        } else {
            this.mMovieDuration = this.mMovie.duration() == 0 ? 1000 : this.mMovie.duration();
            requestLayout();
        }
    }

    public void setPercent(float f10) {
        int i10;
        Movie movie = this.mMovie;
        if (movie == null || (i10 = this.mMovieDuration) <= 0) {
            return;
        }
        this.mPercent = f10;
        movie.setTime((int) (i10 * f10));
        invalidateView();
        OnPlayListener onPlayListener = this.mOnPlayListener;
        if (onPlayListener != null) {
            onPlayListener.onPlaying(f10);
        }
    }

    public GifImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
        setLayerType(1, null);
    }

    public GifImageView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mScaleW = 1.0f;
        this.mScaleH = 1.0f;
        this.mScale = 1.0f;
        this.mCounts = -1;
        this.mReverse = false;
        this.mVisible = true;
        this.mEndLastFrame = false;
        setLayerType(1, null);
    }

    public void play() {
        if (this.mMovie == null) {
            return;
        }
        if (this.mHasStart) {
            if (!this.mPaused || this.mMoviePauseTime <= 0) {
                return;
            }
            this.mPaused = false;
            this.mOffsetTime = (this.mOffsetTime + SystemClock.uptimeMillis()) - this.mMoviePauseTime;
            invalidate();
            OnPlayListener onPlayListener = this.mOnPlayListener;
            if (onPlayListener != null) {
                onPlayListener.onPlayRestart();
                return;
            }
            return;
        }
        play(-1);
    }

    public void setGifResource(int i10) {
        setGifResource(i10, (OnPlayListener) null);
    }

    public void setGifResource(String str, OnPlayListener onPlayListener) {
        Bitmap decodeFile;
        this.mMovie = Movie.decodeFile(str);
        this.mOnPlayListener = onPlayListener;
        reset();
        if (this.mMovie == null && (decodeFile = BitmapFactory.decodeFile(str)) != null) {
            setImageBitmap(decodeFile);
            return;
        }
        this.mMovieDuration = this.mMovie.duration() == 0 ? 1000 : this.mMovie.duration();
        requestLayout();
        OnPlayListener onPlayListener2 = this.mOnPlayListener;
        if (onPlayListener2 != null) {
            onPlayListener2.onPlayStart();
        }
    }
}
