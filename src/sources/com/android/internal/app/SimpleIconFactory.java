package com.android.internal.app;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableWrapper;
import android.os.UserHandle;
import android.util.AttributeSet;
import android.util.Pools;
import android.util.TypedValue;
import java.util.Optional;
import java.util.function.Consumer;
import org.xmlpull.v1.XmlPullParser;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
@Deprecated
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class SimpleIconFactory {
    private static final int AMBIENT_SHADOW_ALPHA = 7;
    private static final float BLUR_FACTOR = 0.03125f;
    private static final float CIRCLE_AREA_BY_RECT = 0.7853982f;
    private static final int DEFAULT_WRAPPER_BACKGROUND = -1;
    private static final int KEY_SHADOW_ALPHA = 10;
    private static final float KEY_SHADOW_DISTANCE = 0.020833334f;
    private static final float LINEAR_SCALE_SLOPE = 0.040449437f;
    private static final float MAX_CIRCLE_AREA_FACTOR = 0.6597222f;
    private static final float MAX_SQUARE_AREA_FACTOR = 0.6510417f;
    private static final int MIN_VISIBLE_ALPHA = 40;
    private static final float SCALE_NOT_INITIALIZED = 0.0f;
    private static final Pools.SynchronizedPool<SimpleIconFactory> sPool = new Pools.SynchronizedPool<>(Runtime.getRuntime().availableProcessors());
    private static boolean sPoolEnabled = true;
    private final Rect mAdaptiveIconBounds;
    private float mAdaptiveIconScale;
    private int mBadgeBitmapSize;
    private final Bitmap mBitmap;
    private final Rect mBounds;
    private Canvas mCanvas;
    private Context mContext;
    private BlurMaskFilter mDefaultBlurMaskFilter;
    private int mFillResIconDpi;
    private int mIconBitmapSize;
    private final float[] mLeftBorder;
    private final int mMaxSize;
    private final byte[] mPixels;
    private PackageManager mPm;
    private final float[] mRightBorder;
    private final Canvas mScaleCheckCanvas;
    private int mWrapperBackgroundColor;
    private Drawable mWrapperIcon;
    private final Rect mOldBounds = new Rect();
    private Paint mBlurPaint = new Paint(3);
    private Paint mDrawPaint = new Paint(3);

    @Deprecated
    public static SimpleIconFactory obtain(Context ctx) {
        SimpleIconFactory instance = sPoolEnabled ? (SimpleIconFactory) sPool.acquire() : null;
        if (instance == null) {
            ActivityManager am = (ActivityManager) ctx.getSystemService("activity");
            int iconDpi = am == null ? 0 : am.getLauncherLargeIconDensity();
            int iconSize = getIconSizeFromContext(ctx);
            int badgeSize = getBadgeSizeFromContext(ctx);
            SimpleIconFactory instance2 = new SimpleIconFactory(ctx, iconDpi, iconSize, badgeSize);
            instance2.setWrapperBackgroundColor(-1);
            return instance2;
        }
        return instance;
    }

    public static void setPoolEnabled(boolean poolEnabled) {
        sPoolEnabled = poolEnabled;
    }

    private static int getAttrDimFromContext(Context ctx, int attrId, String errorMsg) {
        Resources res = ctx.getResources();
        TypedValue outVal = new TypedValue();
        if (!ctx.getTheme().resolveAttribute(attrId, outVal, true)) {
            throw new IllegalStateException(errorMsg);
        }
        return res.getDimensionPixelSize(outVal.resourceId);
    }

    private static int getIconSizeFromContext(Context ctx) {
        return getAttrDimFromContext(ctx, 17956967, "Expected theme to define iconfactoryIconSize.");
    }

    private static int getBadgeSizeFromContext(Context ctx) {
        return getAttrDimFromContext(ctx, 17956966, "Expected theme to define iconfactoryBadgeSize.");
    }

    @Deprecated
    public void recycle() {
        setWrapperBackgroundColor(-1);
        sPool.release(this);
    }

    @Deprecated
    private SimpleIconFactory(Context context, int fillResIconDpi, int iconBitmapSize, int badgeBitmapSize) {
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext;
        this.mPm = applicationContext.getPackageManager();
        this.mIconBitmapSize = iconBitmapSize;
        this.mBadgeBitmapSize = badgeBitmapSize;
        this.mFillResIconDpi = fillResIconDpi;
        Canvas canvas = new Canvas();
        this.mCanvas = canvas;
        canvas.setDrawFilter(new PaintFlagsDrawFilter(4, 2));
        int i10 = iconBitmapSize * 2;
        this.mMaxSize = i10;
        Bitmap createBitmap = Bitmap.createBitmap(i10, i10, Bitmap.Config.ALPHA_8);
        this.mBitmap = createBitmap;
        this.mScaleCheckCanvas = new Canvas(createBitmap);
        this.mPixels = new byte[i10 * i10];
        this.mLeftBorder = new float[i10];
        this.mRightBorder = new float[i10];
        this.mBounds = new Rect();
        this.mAdaptiveIconBounds = new Rect();
        this.mAdaptiveIconScale = 0.0f;
        this.mDefaultBlurMaskFilter = new BlurMaskFilter(iconBitmapSize * BLUR_FACTOR, BlurMaskFilter.Blur.NORMAL);
    }

    @Deprecated
    void setWrapperBackgroundColor(int color) {
        this.mWrapperBackgroundColor = Color.alpha(color) < 255 ? -1 : color;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public Bitmap createUserBadgedIconBitmap(Drawable icon, UserHandle user) {
        float[] scale = new float[1];
        if (icon == null) {
            icon = getFullResDefaultActivityIcon(this.mFillResIconDpi);
        }
        Drawable icon2 = normalizeAndWrapToAdaptiveIcon(icon, null, scale);
        Bitmap bitmap = createIconBitmap(icon2, scale[0]);
        if (icon2 instanceof AdaptiveIconDrawable) {
            this.mCanvas.setBitmap(bitmap);
            recreateIcon(Bitmap.createBitmap(bitmap), this.mCanvas);
            this.mCanvas.setBitmap(null);
        }
        if (user != null) {
            BitmapDrawable drawable = new FixedSizeBitmapDrawable(bitmap);
            Drawable badged = this.mPm.getUserBadgedIcon(drawable, user);
            if (badged instanceof BitmapDrawable) {
                Bitmap result = ((BitmapDrawable) badged).getBitmap();
                return result;
            }
            Bitmap result2 = createIconBitmap(badged, 1.0f);
            return result2;
        }
        return bitmap;
    }

    @Deprecated
    public Bitmap createAppBadgedIconBitmap(Drawable icon, Bitmap renderedAppIcon) {
        if (icon == null) {
            icon = getFullResDefaultActivityIcon(this.mFillResIconDpi);
        }
        int w3 = icon.getIntrinsicWidth();
        int h10 = icon.getIntrinsicHeight();
        float scale = 1.0f;
        if (h10 > w3 && w3 > 0) {
            scale = h10 / w3;
        } else if (w3 > h10 && h10 > 0) {
            scale = w3 / h10;
        }
        Drawable icon2 = new BitmapDrawable(this.mContext.getResources(), maskBitmapToCircle(createIconBitmapNoInsetOrMask(icon, scale)));
        Bitmap bitmap = createIconBitmap(icon2, getScale(icon2, null));
        this.mCanvas.setBitmap(bitmap);
        recreateIcon(Bitmap.createBitmap(bitmap), this.mCanvas);
        if (renderedAppIcon != null) {
            int i10 = this.mBadgeBitmapSize;
            Bitmap renderedAppIcon2 = Bitmap.createScaledBitmap(renderedAppIcon, i10, i10, false);
            Canvas canvas = this.mCanvas;
            int i11 = this.mIconBitmapSize;
            int i12 = this.mBadgeBitmapSize;
            canvas.drawBitmap(renderedAppIcon2, i11 - i12, i11 - i12, (Paint) null);
        }
        this.mCanvas.setBitmap(null);
        return bitmap;
    }

    private Bitmap maskBitmapToCircle(Bitmap bitmap) {
        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);
        Paint paint = new Paint(7);
        int size = bitmap.getWidth();
        int offset = Math.max((int) Math.ceil(size * BLUR_FACTOR), 1);
        paint.setColor(-1);
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawCircle(bitmap.getWidth() / 2.0f, bitmap.getHeight() / 2.0f, (bitmap.getWidth() / 2.0f) - offset, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return output;
    }

    private static Drawable getFullResDefaultActivityIcon(int iconDpi) {
        return Resources.getSystem().getDrawableForDensity(17629184, iconDpi);
    }

    private Bitmap createIconBitmap(Drawable icon, float scale) {
        return createIconBitmap(icon, scale, this.mIconBitmapSize, true, false);
    }

    private Bitmap createIconBitmapNoInsetOrMask(Drawable icon, float scale) {
        return createIconBitmap(icon, scale, this.mIconBitmapSize, false, true);
    }

    private Bitmap createIconBitmap(Drawable icon, float scale, int size, boolean insetAdiForShadow, boolean ignoreAdiMask) {
        Bitmap bitmap = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888);
        this.mCanvas.setBitmap(bitmap);
        this.mOldBounds.set(icon.getBounds());
        if (icon instanceof AdaptiveIconDrawable) {
            AdaptiveIconDrawable adi = (AdaptiveIconDrawable) icon;
            int offset = Math.round((size * (1.0f - scale)) / 2.0f);
            if (insetAdiForShadow) {
                offset = Math.max((int) Math.ceil(size * BLUR_FACTOR), offset);
            }
            Rect bounds = new Rect(offset, offset, size - offset, size - offset);
            if (ignoreAdiMask) {
                int cX = bounds.width() / 2;
                int cY = bounds.height() / 2;
                float portScale = 1.0f / ((AdaptiveIconDrawable.getExtraInsetFraction() * 2.0f) + 1.0f);
                int insetWidth = (int) (bounds.width() / (portScale * 2.0f));
                int insetHeight = (int) (bounds.height() / (2.0f * portScale));
                final Rect childRect = new Rect(cX - insetWidth, cY - insetHeight, cX + insetWidth, cY + insetHeight);
                Optional.ofNullable(adi.getBackground()).ifPresent(new Consumer() { // from class: com.android.internal.app.SimpleIconFactory$$ExternalSyntheticLambda0
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        SimpleIconFactory.this.lambda$createIconBitmap$0(childRect, (Drawable) obj);
                    }
                });
                Optional.ofNullable(adi.getForeground()).ifPresent(new Consumer() { // from class: com.android.internal.app.SimpleIconFactory$$ExternalSyntheticLambda1
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        SimpleIconFactory.this.lambda$createIconBitmap$1(childRect, (Drawable) obj);
                    }
                });
            } else {
                adi.setBounds(bounds);
                adi.draw(this.mCanvas);
            }
        } else {
            if (icon instanceof BitmapDrawable) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) icon;
                Bitmap b4 = bitmapDrawable.getBitmap();
                if (bitmap != null && b4.getDensity() == 0) {
                    bitmapDrawable.setTargetDensity(this.mContext.getResources().getDisplayMetrics());
                }
            }
            int width = size;
            int height = size;
            int intrinsicWidth = icon.getIntrinsicWidth();
            int intrinsicHeight = icon.getIntrinsicHeight();
            if (intrinsicWidth > 0 && intrinsicHeight > 0) {
                float ratio = intrinsicWidth / intrinsicHeight;
                if (intrinsicWidth > intrinsicHeight) {
                    height = (int) (width / ratio);
                } else if (intrinsicHeight > intrinsicWidth) {
                    width = (int) (height * ratio);
                }
            }
            int left = (size - width) / 2;
            int top = (size - height) / 2;
            icon.setBounds(left, top, left + width, top + height);
            this.mCanvas.save();
            this.mCanvas.scale(scale, scale, size / 2, size / 2);
            icon.draw(this.mCanvas);
            this.mCanvas.restore();
        }
        icon.setBounds(this.mOldBounds);
        this.mCanvas.setBitmap(null);
        return bitmap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createIconBitmap$0(Rect childRect, Drawable drawable) {
        drawable.setBounds(childRect);
        drawable.draw(this.mCanvas);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createIconBitmap$1(Rect childRect, Drawable drawable) {
        drawable.setBounds(childRect);
        drawable.draw(this.mCanvas);
    }

    private Drawable normalizeAndWrapToAdaptiveIcon(Drawable icon, RectF outIconBounds, float[] outScale) {
        if (this.mWrapperIcon == null) {
            this.mWrapperIcon = this.mContext.getDrawable(17302940).mutate();
        }
        AdaptiveIconDrawable dr = (AdaptiveIconDrawable) this.mWrapperIcon;
        dr.setBounds(0, 0, 1, 1);
        float scale = getScale(icon, outIconBounds);
        if (!(icon instanceof AdaptiveIconDrawable)) {
            FixedScaleDrawable fsd = (FixedScaleDrawable) dr.getForeground();
            fsd.setDrawable(icon);
            fsd.setScale(scale);
            icon = dr;
            scale = getScale(icon, outIconBounds);
            ((ColorDrawable) dr.getBackground()).setColor(this.mWrapperBackgroundColor);
        }
        outScale[0] = scale;
        return icon;
    }

    /* JADX WARN: Code restructure failed: missing block: B:85:0x0042, code lost:
    
        if (r3 <= r22.mMaxSize) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0045, code lost:
    
        r6 = r3;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00d3 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00ed A[Catch: all -> 0x01a2, TryCatch #0 {, blocks: (B:4:0x0007, B:6:0x000c, B:9:0x0014, B:10:0x0019, B:14:0x001d, B:18:0x002a, B:21:0x0056, B:26:0x008a, B:33:0x009c, B:36:0x00a5, B:41:0x00b9, B:43:0x00c4, B:52:0x00dd, B:54:0x00ed, B:58:0x00ff, B:59:0x00f8, B:62:0x0102, B:65:0x0122, B:67:0x0134, B:68:0x0168, B:70:0x0171, B:71:0x017e, B:73:0x0186, B:75:0x018d, B:80:0x0117, B:82:0x0030, B:84:0x0040, B:90:0x004c, B:95:0x0053, B:96:0x0047), top: B:3:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0134 A[Catch: all -> 0x01a2, TryCatch #0 {, blocks: (B:4:0x0007, B:6:0x000c, B:9:0x0014, B:10:0x0019, B:14:0x001d, B:18:0x002a, B:21:0x0056, B:26:0x008a, B:33:0x009c, B:36:0x00a5, B:41:0x00b9, B:43:0x00c4, B:52:0x00dd, B:54:0x00ed, B:58:0x00ff, B:59:0x00f8, B:62:0x0102, B:65:0x0122, B:67:0x0134, B:68:0x0168, B:70:0x0171, B:71:0x017e, B:73:0x0186, B:75:0x018d, B:80:0x0117, B:82:0x0030, B:84:0x0040, B:90:0x004c, B:95:0x0053, B:96:0x0047), top: B:3:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0171 A[Catch: all -> 0x01a2, TryCatch #0 {, blocks: (B:4:0x0007, B:6:0x000c, B:9:0x0014, B:10:0x0019, B:14:0x001d, B:18:0x002a, B:21:0x0056, B:26:0x008a, B:33:0x009c, B:36:0x00a5, B:41:0x00b9, B:43:0x00c4, B:52:0x00dd, B:54:0x00ed, B:58:0x00ff, B:59:0x00f8, B:62:0x0102, B:65:0x0122, B:67:0x0134, B:68:0x0168, B:70:0x0171, B:71:0x017e, B:73:0x0186, B:75:0x018d, B:80:0x0117, B:82:0x0030, B:84:0x0040, B:90:0x004c, B:95:0x0053, B:96:0x0047), top: B:3:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0117 A[Catch: all -> 0x01a2, TryCatch #0 {, blocks: (B:4:0x0007, B:6:0x000c, B:9:0x0014, B:10:0x0019, B:14:0x001d, B:18:0x002a, B:21:0x0056, B:26:0x008a, B:33:0x009c, B:36:0x00a5, B:41:0x00b9, B:43:0x00c4, B:52:0x00dd, B:54:0x00ed, B:58:0x00ff, B:59:0x00f8, B:62:0x0102, B:65:0x0122, B:67:0x0134, B:68:0x0168, B:70:0x0171, B:71:0x017e, B:73:0x0186, B:75:0x018d, B:80:0x0117, B:82:0x0030, B:84:0x0040, B:90:0x004c, B:95:0x0053, B:96:0x0047), top: B:3:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0198 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private synchronized float getScale(android.graphics.drawable.Drawable r23, android.graphics.RectF r24) {
        /*
            Method dump skipped, instructions count: 421
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.internal.app.SimpleIconFactory.getScale(android.graphics.drawable.Drawable, android.graphics.RectF):float");
    }

    private static void convertToConvexArray(float[] xCoordinates, int direction, int topY, int bottomY) {
        int start;
        int total = xCoordinates.length;
        float[] angles = new float[total - 1];
        int last = -1;
        float lastAngle = Float.MAX_VALUE;
        for (int i10 = topY + 1; i10 <= bottomY; i10++) {
            if (xCoordinates[i10] > -1.0f) {
                if (lastAngle == Float.MAX_VALUE) {
                    start = topY;
                } else {
                    float currentAngle = (xCoordinates[i10] - xCoordinates[last]) / (i10 - last);
                    int start2 = last;
                    if ((currentAngle - lastAngle) * direction >= 0.0f) {
                        start = start2;
                    } else {
                        start = start2;
                        while (start > topY) {
                            start--;
                            float currentAngle2 = (xCoordinates[i10] - xCoordinates[start]) / (i10 - start);
                            if ((currentAngle2 - angles[start]) * direction >= 0.0f) {
                                break;
                            }
                        }
                    }
                }
                float lastAngle2 = (xCoordinates[i10] - xCoordinates[start]) / (i10 - start);
                for (int j10 = start; j10 < i10; j10++) {
                    angles[j10] = lastAngle2;
                    xCoordinates[j10] = xCoordinates[start] + ((j10 - start) * lastAngle2);
                }
                last = i10;
                lastAngle = lastAngle2;
            }
        }
    }

    private synchronized void recreateIcon(Bitmap icon, Canvas out) {
        recreateIcon(icon, this.mDefaultBlurMaskFilter, 7, 10, out);
    }

    private synchronized void recreateIcon(Bitmap icon, BlurMaskFilter blurMaskFilter, int ambientAlpha, int keyAlpha, Canvas out) {
        int[] offset = new int[2];
        this.mBlurPaint.setMaskFilter(blurMaskFilter);
        Bitmap shadow = icon.extractAlpha(this.mBlurPaint, offset);
        this.mDrawPaint.setAlpha(ambientAlpha);
        out.drawBitmap(shadow, offset[0], offset[1], this.mDrawPaint);
        this.mDrawPaint.setAlpha(keyAlpha);
        out.drawBitmap(shadow, offset[0], offset[1] + (this.mIconBitmapSize * KEY_SHADOW_DISTANCE), this.mDrawPaint);
        this.mDrawPaint.setAlpha(255);
        out.drawBitmap(icon, 0.0f, 0.0f, this.mDrawPaint);
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class FixedScaleDrawable extends DrawableWrapper {
        private static final float LEGACY_ICON_SCALE = 0.46669f;
        private float mScaleX;
        private float mScaleY;

        public FixedScaleDrawable() {
            super(new ColorDrawable());
            this.mScaleX = LEGACY_ICON_SCALE;
            this.mScaleY = LEGACY_ICON_SCALE;
        }

        @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            int saveCount = canvas.save();
            canvas.scale(this.mScaleX, this.mScaleY, getBounds().exactCenterX(), getBounds().exactCenterY());
            super.draw(canvas);
            canvas.restoreToCount(saveCount);
        }

        @Override // android.graphics.drawable.Drawable
        public void inflate(Resources r10, XmlPullParser parser, AttributeSet attrs) {
        }

        @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
        public void inflate(Resources r10, XmlPullParser parser, AttributeSet attrs, Resources.Theme theme) {
        }

        public void setScale(float scale) {
            float h10 = getIntrinsicHeight();
            float w3 = getIntrinsicWidth();
            float f10 = scale * LEGACY_ICON_SCALE;
            this.mScaleX = f10;
            float f11 = LEGACY_ICON_SCALE * scale;
            this.mScaleY = f11;
            if (h10 > w3 && w3 > 0.0f) {
                this.mScaleX = f10 * (w3 / h10);
            } else if (w3 > h10 && h10 > 0.0f) {
                this.mScaleY = f11 * (h10 / w3);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    private static class FixedSizeBitmapDrawable extends BitmapDrawable {
        FixedSizeBitmapDrawable(Bitmap bitmap) {
            super((Resources) null, bitmap);
        }

        @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
        public int getIntrinsicHeight() {
            return getBitmap().getWidth();
        }

        @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
        public int getIntrinsicWidth() {
            return getBitmap().getWidth();
        }
    }
}
