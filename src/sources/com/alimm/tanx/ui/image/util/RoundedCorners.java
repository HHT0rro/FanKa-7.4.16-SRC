package com.alimm.tanx.ui.image.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import com.alimm.tanx.ui.image.glide.Glide;
import com.alimm.tanx.ui.image.glide.load.Transformation;
import com.alimm.tanx.ui.image.glide.load.engine.Resource;
import com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool;
import com.alimm.tanx.ui.image.glide.load.resource.bitmap.BitmapResource;
import nd.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class RoundedCorners implements Transformation<Bitmap> {
    public final BitmapPool mBitmapPool;
    public final CornerType mCornerType;
    public final int mDiameter;
    public final int mMargin;
    public final int mRadius;

    /* renamed from: com.alimm.tanx.ui.image.util.RoundedCorners$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$alimm$tanx$ui$image$util$RoundedCorners$CornerType;

        static {
            int[] iArr = new int[CornerType.values().length];
            $SwitchMap$com$alimm$tanx$ui$image$util$RoundedCorners$CornerType = iArr;
            try {
                iArr[CornerType.ALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$alimm$tanx$ui$image$util$RoundedCorners$CornerType[CornerType.TOP_LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$alimm$tanx$ui$image$util$RoundedCorners$CornerType[CornerType.TOP_RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$alimm$tanx$ui$image$util$RoundedCorners$CornerType[CornerType.BOTTOM_LEFT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$alimm$tanx$ui$image$util$RoundedCorners$CornerType[CornerType.BOTTOM_RIGHT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$alimm$tanx$ui$image$util$RoundedCorners$CornerType[CornerType.TOP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$alimm$tanx$ui$image$util$RoundedCorners$CornerType[CornerType.BOTTOM.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$alimm$tanx$ui$image$util$RoundedCorners$CornerType[CornerType.LEFT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$alimm$tanx$ui$image$util$RoundedCorners$CornerType[CornerType.RIGHT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$alimm$tanx$ui$image$util$RoundedCorners$CornerType[CornerType.OTHER_TOP_LEFT.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$alimm$tanx$ui$image$util$RoundedCorners$CornerType[CornerType.OTHER_TOP_RIGHT.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$alimm$tanx$ui$image$util$RoundedCorners$CornerType[CornerType.OTHER_BOTTOM_LEFT.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$alimm$tanx$ui$image$util$RoundedCorners$CornerType[CornerType.OTHER_BOTTOM_RIGHT.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$alimm$tanx$ui$image$util$RoundedCorners$CornerType[CornerType.DIAGONAL_FROM_TOP_LEFT.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$alimm$tanx$ui$image$util$RoundedCorners$CornerType[CornerType.DIAGONAL_FROM_TOP_RIGHT.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public enum CornerType {
        ALL,
        TOP_LEFT,
        TOP_RIGHT,
        BOTTOM_LEFT,
        BOTTOM_RIGHT,
        TOP,
        BOTTOM,
        LEFT,
        RIGHT,
        OTHER_TOP_LEFT,
        OTHER_TOP_RIGHT,
        OTHER_BOTTOM_LEFT,
        OTHER_BOTTOM_RIGHT,
        DIAGONAL_FROM_TOP_LEFT,
        DIAGONAL_FROM_TOP_RIGHT
    }

    public RoundedCorners(Context context, int i10, int i11) {
        this(context, i10, i11, CornerType.ALL);
    }

    private void drawBottomLeftRoundRect(Canvas canvas, Paint paint, float f10, float f11) {
        RectF rectF = new RectF(this.mMargin, f11 - this.mDiameter, r1 + r3, f11);
        float f12 = this.mRadius;
        canvas.drawRoundRect(rectF, f12, f12, paint);
        float f13 = this.mMargin;
        canvas.drawRect(new RectF(f13, f13, r1 + this.mDiameter, f11 - this.mRadius), paint);
        canvas.drawRect(new RectF(this.mRadius + r1, this.mMargin, f10, f11), paint);
    }

    private void drawBottomRightRoundRect(Canvas canvas, Paint paint, float f10, float f11) {
        float f12 = this.mDiameter;
        RectF rectF = new RectF(f10 - f12, f11 - f12, f10, f11);
        float f13 = this.mRadius;
        canvas.drawRoundRect(rectF, f13, f13, paint);
        float f14 = this.mMargin;
        canvas.drawRect(new RectF(f14, f14, f10 - this.mRadius, f11), paint);
        float f15 = this.mRadius;
        canvas.drawRect(new RectF(f10 - f15, this.mMargin, f10, f11 - f15), paint);
    }

    private void drawBottomRoundRect(Canvas canvas, Paint paint, float f10, float f11) {
        RectF rectF = new RectF(this.mMargin, f11 - this.mDiameter, f10, f11);
        float f12 = this.mRadius;
        canvas.drawRoundRect(rectF, f12, f12, paint);
        float f13 = this.mMargin;
        canvas.drawRect(new RectF(f13, f13, f10, f11 - this.mRadius), paint);
    }

    private void drawDiagonalFromTopLeftRoundRect(Canvas canvas, Paint paint, float f10, float f11) {
        int i10 = this.mMargin;
        float f12 = i10;
        float f13 = i10 + this.mDiameter;
        RectF rectF = new RectF(f12, f12, f13, f13);
        float f14 = this.mRadius;
        canvas.drawRoundRect(rectF, f14, f14, paint);
        float f15 = this.mDiameter;
        RectF rectF2 = new RectF(f10 - f15, f11 - f15, f10, f11);
        float f16 = this.mRadius;
        canvas.drawRoundRect(rectF2, f16, f16, paint);
        canvas.drawRect(new RectF(this.mMargin, r1 + this.mRadius, f10 - this.mDiameter, f11), paint);
        canvas.drawRect(new RectF(this.mDiameter + r1, this.mMargin, f10, f11 - this.mRadius), paint);
    }

    private void drawDiagonalFromTopRightRoundRect(Canvas canvas, Paint paint, float f10, float f11) {
        int i10 = this.mDiameter;
        RectF rectF = new RectF(f10 - i10, this.mMargin, f10, r3 + i10);
        float f12 = this.mRadius;
        canvas.drawRoundRect(rectF, f12, f12, paint);
        RectF rectF2 = new RectF(this.mMargin, f11 - this.mDiameter, r1 + r3, f11);
        float f13 = this.mRadius;
        canvas.drawRoundRect(rectF2, f13, f13, paint);
        float f14 = this.mMargin;
        float f15 = this.mRadius;
        canvas.drawRect(new RectF(f14, f14, f10 - f15, f11 - f15), paint);
        float f16 = this.mMargin + this.mRadius;
        canvas.drawRect(new RectF(f16, f16, f10, f11), paint);
    }

    private void drawLeftRoundRect(Canvas canvas, Paint paint, float f10, float f11) {
        float f12 = this.mMargin;
        RectF rectF = new RectF(f12, f12, r1 + this.mDiameter, f11);
        float f13 = this.mRadius;
        canvas.drawRoundRect(rectF, f13, f13, paint);
        canvas.drawRect(new RectF(this.mRadius + r1, this.mMargin, f10, f11), paint);
    }

    private void drawOtherBottomLeftRoundRect(Canvas canvas, Paint paint, float f10, float f11) {
        float f12 = this.mMargin;
        RectF rectF = new RectF(f12, f12, f10, r1 + this.mDiameter);
        float f13 = this.mRadius;
        canvas.drawRoundRect(rectF, f13, f13, paint);
        RectF rectF2 = new RectF(f10 - this.mDiameter, this.mMargin, f10, f11);
        float f14 = this.mRadius;
        canvas.drawRoundRect(rectF2, f14, f14, paint);
        canvas.drawRect(new RectF(this.mMargin, r1 + r3, f10 - this.mRadius, f11), paint);
    }

    private void drawOtherBottomRightRoundRect(Canvas canvas, Paint paint, float f10, float f11) {
        float f12 = this.mMargin;
        RectF rectF = new RectF(f12, f12, f10, r1 + this.mDiameter);
        float f13 = this.mRadius;
        canvas.drawRoundRect(rectF, f13, f13, paint);
        float f14 = this.mMargin;
        RectF rectF2 = new RectF(f14, f14, r1 + this.mDiameter, f11);
        float f15 = this.mRadius;
        canvas.drawRoundRect(rectF2, f15, f15, paint);
        float f16 = this.mMargin + this.mRadius;
        canvas.drawRect(new RectF(f16, f16, f10, f11), paint);
    }

    private void drawOtherTopLeftRoundRect(Canvas canvas, Paint paint, float f10, float f11) {
        RectF rectF = new RectF(this.mMargin, f11 - this.mDiameter, f10, f11);
        float f12 = this.mRadius;
        canvas.drawRoundRect(rectF, f12, f12, paint);
        RectF rectF2 = new RectF(f10 - this.mDiameter, this.mMargin, f10, f11);
        float f13 = this.mRadius;
        canvas.drawRoundRect(rectF2, f13, f13, paint);
        float f14 = this.mMargin;
        float f15 = this.mRadius;
        canvas.drawRect(new RectF(f14, f14, f10 - f15, f11 - f15), paint);
    }

    private void drawOtherTopRightRoundRect(Canvas canvas, Paint paint, float f10, float f11) {
        float f12 = this.mMargin;
        RectF rectF = new RectF(f12, f12, r1 + this.mDiameter, f11);
        float f13 = this.mRadius;
        canvas.drawRoundRect(rectF, f13, f13, paint);
        RectF rectF2 = new RectF(this.mMargin, f11 - this.mDiameter, f10, f11);
        float f14 = this.mRadius;
        canvas.drawRoundRect(rectF2, f14, f14, paint);
        canvas.drawRect(new RectF(r1 + r2, this.mMargin, f10, f11 - this.mRadius), paint);
    }

    private void drawRightRoundRect(Canvas canvas, Paint paint, float f10, float f11) {
        RectF rectF = new RectF(f10 - this.mDiameter, this.mMargin, f10, f11);
        float f12 = this.mRadius;
        canvas.drawRoundRect(rectF, f12, f12, paint);
        float f13 = this.mMargin;
        canvas.drawRect(new RectF(f13, f13, f10 - this.mRadius, f11), paint);
    }

    private void drawRoundRect(Canvas canvas, Paint paint, float f10, float f11) {
        float f12 = this.mMargin;
        float f13 = f10 - f12;
        float f14 = f11 - f12;
        switch (this.mCornerType) {
            case ALL:
                float f15 = this.mMargin;
                RectF rectF = new RectF(f15, f15, f13, f14);
                float f16 = this.mRadius;
                canvas.drawRoundRect(rectF, f16, f16, paint);
                return;
            case TOP_LEFT:
                drawTopLeftRoundRect(canvas, paint, f13, f14);
                return;
            case TOP_RIGHT:
                drawTopRightRoundRect(canvas, paint, f13, f14);
                return;
            case BOTTOM_LEFT:
                drawBottomLeftRoundRect(canvas, paint, f13, f14);
                return;
            case BOTTOM_RIGHT:
                drawBottomRightRoundRect(canvas, paint, f13, f14);
                return;
            case TOP:
                drawTopRoundRect(canvas, paint, f13, f14);
                return;
            case BOTTOM:
                drawBottomRoundRect(canvas, paint, f13, f14);
                return;
            case LEFT:
                drawLeftRoundRect(canvas, paint, f13, f14);
                return;
            case RIGHT:
                drawRightRoundRect(canvas, paint, f13, f14);
                return;
            case OTHER_TOP_LEFT:
                drawOtherTopLeftRoundRect(canvas, paint, f13, f14);
                return;
            case OTHER_TOP_RIGHT:
                drawOtherTopRightRoundRect(canvas, paint, f13, f14);
                return;
            case OTHER_BOTTOM_LEFT:
                drawOtherBottomLeftRoundRect(canvas, paint, f13, f14);
                return;
            case OTHER_BOTTOM_RIGHT:
                drawOtherBottomRightRoundRect(canvas, paint, f13, f14);
                return;
            case DIAGONAL_FROM_TOP_LEFT:
                drawDiagonalFromTopLeftRoundRect(canvas, paint, f13, f14);
                return;
            case DIAGONAL_FROM_TOP_RIGHT:
                drawDiagonalFromTopRightRoundRect(canvas, paint, f13, f14);
                return;
            default:
                float f17 = this.mMargin;
                RectF rectF2 = new RectF(f17, f17, f13, f14);
                float f18 = this.mRadius;
                canvas.drawRoundRect(rectF2, f18, f18, paint);
                return;
        }
    }

    private void drawTopLeftRoundRect(Canvas canvas, Paint paint, float f10, float f11) {
        int i10 = this.mMargin;
        float f12 = i10;
        float f13 = i10 + this.mDiameter;
        RectF rectF = new RectF(f12, f12, f13, f13);
        float f14 = this.mRadius;
        canvas.drawRoundRect(rectF, f14, f14, paint);
        int i11 = this.mMargin;
        float f15 = i11;
        float f16 = i11 + this.mRadius;
        canvas.drawRect(new RectF(f15, f16, f16, f11), paint);
        canvas.drawRect(new RectF(this.mRadius + r1, this.mMargin, f10, f11), paint);
    }

    private void drawTopRightRoundRect(Canvas canvas, Paint paint, float f10, float f11) {
        int i10 = this.mDiameter;
        RectF rectF = new RectF(f10 - i10, this.mMargin, f10, r3 + i10);
        float f12 = this.mRadius;
        canvas.drawRoundRect(rectF, f12, f12, paint);
        float f13 = this.mMargin;
        canvas.drawRect(new RectF(f13, f13, f10 - this.mRadius, f11), paint);
        canvas.drawRect(new RectF(f10 - this.mRadius, this.mMargin + r1, f10, f11), paint);
    }

    private void drawTopRoundRect(Canvas canvas, Paint paint, float f10, float f11) {
        float f12 = this.mMargin;
        RectF rectF = new RectF(f12, f12, f10, r1 + this.mDiameter);
        float f13 = this.mRadius;
        canvas.drawRoundRect(rectF, f13, f13, paint);
        canvas.drawRect(new RectF(this.mMargin, r1 + this.mRadius, f10, f11), paint);
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Transformation
    public String getId() {
        StringBuilder a10 = a.a("RoundedTransformation(radius=");
        a10.append(this.mRadius);
        a10.append(", margin=");
        a10.append(this.mMargin);
        a10.append(", diameter=");
        a10.append(this.mDiameter);
        a10.append(", cornerType=");
        a10.append(this.mCornerType.name());
        a10.append(")");
        return a10.toString();
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Transformation
    public Resource<Bitmap> transform(Resource<Bitmap> resource, int i10, int i11) {
        Bitmap bitmap = resource.get();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap bitmap2 = this.mBitmapPool.get(width, height, Bitmap.Config.ARGB_8888);
        if (bitmap2 == null) {
            bitmap2 = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(bitmap2);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint.setShader(new BitmapShader(bitmap, tileMode, tileMode));
        drawRoundRect(canvas, paint, width, height);
        return BitmapResource.obtain(bitmap2, this.mBitmapPool);
    }

    public RoundedCorners(BitmapPool bitmapPool, int i10, int i11) {
        this(bitmapPool, i10, i11, CornerType.ALL);
    }

    public RoundedCorners(Context context, int i10, int i11, CornerType cornerType) {
        this(Glide.get(context).getBitmapPool(), i10, i11, cornerType);
    }

    public RoundedCorners(BitmapPool bitmapPool, int i10, int i11, CornerType cornerType) {
        this.mBitmapPool = bitmapPool;
        this.mRadius = i10;
        this.mDiameter = i10 * 2;
        this.mMargin = i11;
        this.mCornerType = cornerType;
    }
}
