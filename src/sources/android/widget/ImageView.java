package android.widget;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.ImageDecoder;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.RemotableViewMethod;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewHierarchyEncoder;
import android.view.accessibility.AccessibilityEvent;
import android.view.inspector.InspectionCompanion;
import android.view.inspector.PropertyMapper;
import android.view.inspector.PropertyReader;
import android.widget.RemoteViews;
import com.android.internal.R;
import java.io.IOException;
import system.ext.loader.core.ExtLoader;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
@RemoteViews.RemoteView
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class ImageView extends View {
    private static final String LOG_TAG = "ImageView";
    private static boolean sCompatAdjustViewBounds;
    private static boolean sCompatDone;
    private static boolean sCompatDrawableVisibilityDispatch;
    private static boolean sCompatUseCorrectStreamDensity;
    private boolean mAdjustViewBounds;
    private int mAlpha;
    private int mBaseline;
    private boolean mBaselineAlignBottom;
    private ColorFilter mColorFilter;
    private boolean mCropToPadding;
    private Matrix mDrawMatrix;
    private Drawable mDrawable;
    private BlendMode mDrawableBlendMode;
    private int mDrawableHeight;
    private ColorStateList mDrawableTintList;
    private int mDrawableWidth;
    private boolean mHasAlpha;
    private boolean mHasColorFilter;
    private boolean mHasDrawableBlendMode;
    private boolean mHasDrawableTint;
    private boolean mHasLevelSet;
    private boolean mHasXfermode;
    private boolean mHaveFrame;
    public IImageViewExt mImageViewExt;
    private int mLevel;
    private Matrix mMatrix;
    private int mMaxHeight;
    private int mMaxWidth;
    private boolean mMergeState;
    private BitmapDrawable mRecycleableBitmapDrawable;
    private int mResource;
    private ScaleType mScaleType;
    private int[] mState;
    private final RectF mTempDst;
    private final RectF mTempSrc;
    private Uri mUri;
    private final int mViewAlphaScale;
    private Xfermode mXfermode;
    private static final ScaleType[] sScaleTypeArray = {ScaleType.MATRIX, ScaleType.FIT_XY, ScaleType.FIT_START, ScaleType.FIT_CENTER, ScaleType.FIT_END, ScaleType.CENTER, ScaleType.CENTER_CROP, ScaleType.CENTER_INSIDE};
    private static final Matrix.ScaleToFit[] sS2FArray = {Matrix.ScaleToFit.FILL, Matrix.ScaleToFit.START, Matrix.ScaleToFit.CENTER, Matrix.ScaleToFit.END};

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public final class InspectionCompanion implements android.view.inspector.InspectionCompanion<ImageView> {
        private int mAdjustViewBoundsId;
        private int mBaselineAlignBottomId;
        private int mBaselineId;
        private int mBlendModeId;
        private int mCropToPaddingId;
        private int mMaxHeightId;
        private int mMaxWidthId;
        private boolean mPropertiesMapped = false;
        private int mScaleTypeId;
        private int mSrcId;
        private int mTintId;
        private int mTintModeId;

        @Override // android.view.inspector.InspectionCompanion
        public void mapProperties(PropertyMapper propertyMapper) {
            this.mAdjustViewBoundsId = propertyMapper.mapBoolean("adjustViewBounds", 16843038);
            this.mBaselineId = propertyMapper.mapInt("baseline", 16843548);
            this.mBaselineAlignBottomId = propertyMapper.mapBoolean("baselineAlignBottom", 16843042);
            this.mBlendModeId = propertyMapper.mapObject("blendMode", 9);
            this.mCropToPaddingId = propertyMapper.mapBoolean("cropToPadding", 16843043);
            this.mMaxHeightId = propertyMapper.mapInt("maxHeight", 16843040);
            this.mMaxWidthId = propertyMapper.mapInt("maxWidth", 16843039);
            this.mScaleTypeId = propertyMapper.mapObject("scaleType", 16843037);
            this.mSrcId = propertyMapper.mapObject("src", 16843033);
            this.mTintId = propertyMapper.mapObject("tint", 16843041);
            this.mTintModeId = propertyMapper.mapObject("tintMode", 16843771);
            this.mPropertiesMapped = true;
        }

        @Override // android.view.inspector.InspectionCompanion
        public void readProperties(ImageView node, PropertyReader propertyReader) {
            if (!this.mPropertiesMapped) {
                throw new InspectionCompanion.UninitializedPropertyMapException();
            }
            propertyReader.readBoolean(this.mAdjustViewBoundsId, node.getAdjustViewBounds());
            propertyReader.readInt(this.mBaselineId, node.getBaseline());
            propertyReader.readBoolean(this.mBaselineAlignBottomId, node.getBaselineAlignBottom());
            propertyReader.readObject(this.mBlendModeId, node.getImageTintBlendMode());
            propertyReader.readBoolean(this.mCropToPaddingId, node.getCropToPadding());
            propertyReader.readInt(this.mMaxHeightId, node.getMaxHeight());
            propertyReader.readInt(this.mMaxWidthId, node.getMaxWidth());
            propertyReader.readObject(this.mScaleTypeId, node.getScaleType());
            propertyReader.readObject(this.mSrcId, node.getDrawable());
            propertyReader.readObject(this.mTintId, node.getImageTintList());
            propertyReader.readObject(this.mTintModeId, node.getImageTintMode());
        }
    }

    public ImageView(Context context) {
        super(context);
        this.mResource = 0;
        this.mHaveFrame = false;
        this.mAdjustViewBounds = false;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mColorFilter = null;
        this.mHasColorFilter = false;
        this.mHasXfermode = false;
        this.mAlpha = 255;
        this.mHasAlpha = false;
        this.mViewAlphaScale = 256;
        this.mDrawable = null;
        this.mRecycleableBitmapDrawable = null;
        this.mDrawableTintList = null;
        this.mDrawableBlendMode = null;
        this.mHasDrawableTint = false;
        this.mHasDrawableBlendMode = false;
        this.mState = null;
        this.mMergeState = false;
        this.mHasLevelSet = false;
        this.mLevel = 0;
        this.mDrawMatrix = null;
        this.mTempSrc = new RectF();
        this.mTempDst = new RectF();
        this.mBaseline = -1;
        this.mBaselineAlignBottom = false;
        this.mImageViewExt = (IImageViewExt) ExtLoader.type(IImageViewExt.class).base(this).create();
        initImageView();
    }

    public ImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public ImageView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.mResource = 0;
        this.mHaveFrame = false;
        this.mAdjustViewBounds = false;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mColorFilter = null;
        this.mHasColorFilter = false;
        this.mHasXfermode = false;
        this.mAlpha = 255;
        this.mHasAlpha = false;
        this.mViewAlphaScale = 256;
        this.mDrawable = null;
        this.mRecycleableBitmapDrawable = null;
        this.mDrawableTintList = null;
        this.mDrawableBlendMode = null;
        this.mHasDrawableTint = false;
        this.mHasDrawableBlendMode = false;
        this.mState = null;
        this.mMergeState = false;
        this.mHasLevelSet = false;
        this.mLevel = 0;
        this.mDrawMatrix = null;
        this.mTempSrc = new RectF();
        this.mTempDst = new RectF();
        this.mBaseline = -1;
        this.mBaselineAlignBottom = false;
        this.mImageViewExt = (IImageViewExt) ExtLoader.type(IImageViewExt.class).base(this).create();
        initImageView();
        TypedArray a10 = context.obtainStyledAttributes(attrs, R.styleable.ImageView, defStyleAttr, defStyleRes);
        saveAttributeDataForStyleable(context, R.styleable.ImageView, attrs, a10, defStyleAttr, defStyleRes);
        Drawable d10 = a10.getDrawable(0);
        if (d10 != null) {
            setImageDrawable(d10);
        }
        this.mBaselineAlignBottom = a10.getBoolean(6, false);
        this.mBaseline = a10.getDimensionPixelSize(8, -1);
        setAdjustViewBounds(a10.getBoolean(2, false));
        setMaxWidth(a10.getDimensionPixelSize(3, Integer.MAX_VALUE));
        setMaxHeight(a10.getDimensionPixelSize(4, Integer.MAX_VALUE));
        int index = a10.getInt(1, -1);
        if (index >= 0) {
            setScaleType(sScaleTypeArray[index]);
        }
        if (a10.hasValue(5)) {
            this.mDrawableTintList = a10.getColorStateList(5);
            this.mHasDrawableTint = true;
            this.mDrawableBlendMode = BlendMode.SRC_ATOP;
            this.mHasDrawableBlendMode = true;
        }
        if (a10.hasValue(9)) {
            this.mDrawableBlendMode = Drawable.parseBlendMode(a10.getInt(9, -1), this.mDrawableBlendMode);
            this.mHasDrawableBlendMode = true;
        }
        applyImageTint();
        int alpha = a10.getInt(10, 255);
        if (alpha != 255) {
            setImageAlpha(alpha);
        }
        this.mCropToPadding = a10.getBoolean(7, false);
        a10.recycle();
    }

    private void initImageView() {
        this.mMatrix = new Matrix();
        this.mScaleType = ScaleType.FIT_CENTER;
        if (!sCompatDone) {
            int targetSdkVersion = this.mContext.getApplicationInfo().targetSdkVersion;
            sCompatAdjustViewBounds = targetSdkVersion <= 17;
            sCompatUseCorrectStreamDensity = targetSdkVersion > 23;
            sCompatDrawableVisibilityDispatch = targetSdkVersion < 24;
            sCompatDone = true;
        }
        if (getImportantForAutofill() == 0) {
            setImportantForAutofill(2);
        }
        if (getImportantForContentCapture() == 0) {
            setImportantForContentCapture(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public boolean verifyDrawable(Drawable dr) {
        return this.mDrawable == dr || super.verifyDrawable(dr);
    }

    @Override // android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.mDrawable;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable dr) {
        if (dr == this.mDrawable) {
            if (dr != null) {
                int w3 = dr.getIntrinsicWidth();
                int h10 = dr.getIntrinsicHeight();
                if (w3 != this.mDrawableWidth || h10 != this.mDrawableHeight) {
                    this.mDrawableWidth = w3;
                    this.mDrawableHeight = h10;
                    configureBounds();
                }
            }
            invalidate();
            return;
        }
        super.invalidateDrawable(dr);
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return (getBackground() == null || getBackground().getCurrent() == null) ? false : true;
    }

    @Override // android.view.View
    public void onPopulateAccessibilityEventInternal(AccessibilityEvent event) {
        super.onPopulateAccessibilityEventInternal(event);
        CharSequence contentDescription = getContentDescription();
        if (!TextUtils.isEmpty(contentDescription)) {
            event.getText().add(contentDescription);
        }
    }

    public boolean getAdjustViewBounds() {
        return this.mAdjustViewBounds;
    }

    @RemotableViewMethod
    public void setAdjustViewBounds(boolean adjustViewBounds) {
        this.mAdjustViewBounds = adjustViewBounds;
        if (adjustViewBounds) {
            setScaleType(ScaleType.FIT_CENTER);
        }
    }

    public int getMaxWidth() {
        return this.mMaxWidth;
    }

    @RemotableViewMethod
    public void setMaxWidth(int maxWidth) {
        this.mMaxWidth = maxWidth;
    }

    public int getMaxHeight() {
        return this.mMaxHeight;
    }

    @RemotableViewMethod
    public void setMaxHeight(int maxHeight) {
        this.mMaxHeight = maxHeight;
    }

    public Drawable getDrawable() {
        Drawable drawable = this.mDrawable;
        if (drawable == this.mRecycleableBitmapDrawable) {
            this.mRecycleableBitmapDrawable = null;
        }
        return drawable;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    private class ImageDrawableCallback implements Runnable {
        private final Drawable drawable;
        private final int resource;
        private final Uri uri;

        ImageDrawableCallback(Drawable drawable, Uri uri, int resource) {
            this.drawable = drawable;
            this.uri = uri;
            this.resource = resource;
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageView.this.setImageDrawable(this.drawable);
            ImageView.this.mUri = this.uri;
            ImageView.this.mResource = this.resource;
        }
    }

    @RemotableViewMethod(asyncImpl = "setImageResourceAsync")
    public void setImageResource(int resId) {
        int oldWidth = this.mDrawableWidth;
        int oldHeight = this.mDrawableHeight;
        updateDrawable(null);
        this.mResource = resId;
        this.mUri = null;
        resolveUri();
        if (oldWidth != this.mDrawableWidth || oldHeight != this.mDrawableHeight) {
            requestLayout();
        }
        invalidate();
    }

    public Runnable setImageResourceAsync(int resId) {
        Drawable d10 = null;
        if (resId != 0) {
            try {
                d10 = getContext().getDrawable(resId);
            } catch (Exception e2) {
                Log.w(LOG_TAG, "Unable to find resource: " + resId, e2);
                resId = 0;
            }
        }
        return new ImageDrawableCallback(d10, null, resId);
    }

    @RemotableViewMethod(asyncImpl = "setImageURIAsync")
    public void setImageURI(Uri uri) {
        if (this.mResource == 0) {
            Uri uri2 = this.mUri;
            if (uri2 == uri) {
                return;
            }
            if (uri != null && uri2 != null && uri.equals(uri2)) {
                return;
            }
        }
        updateDrawable(null);
        this.mResource = 0;
        this.mUri = uri;
        int oldWidth = this.mDrawableWidth;
        int oldHeight = this.mDrawableHeight;
        resolveUri();
        if (oldWidth != this.mDrawableWidth || oldHeight != this.mDrawableHeight) {
            requestLayout();
        }
        invalidate();
    }

    public Runnable setImageURIAsync(Uri uri) {
        Uri uri2;
        if (this.mResource == 0 && ((uri2 = this.mUri) == uri || (uri != null && uri2 != null && uri.equals(uri2)))) {
            return null;
        }
        Drawable d10 = uri != null ? getDrawableFromUri(uri) : null;
        if (d10 == null) {
            uri = null;
        }
        return new ImageDrawableCallback(d10, uri, 0);
    }

    public void setImageDrawable(Drawable drawable) {
        if (this.mDrawable != drawable) {
            this.mResource = 0;
            this.mUri = null;
            int oldWidth = this.mDrawableWidth;
            int oldHeight = this.mDrawableHeight;
            updateDrawable(drawable);
            this.mViewExt.adjustImageViewLayerType(oldWidth, oldHeight);
            if (oldWidth != this.mDrawableWidth || oldHeight != this.mDrawableHeight) {
                requestLayout();
            }
            invalidate();
        }
    }

    @RemotableViewMethod(asyncImpl = "setImageIconAsync")
    public void setImageIcon(Icon icon) {
        setImageDrawable(icon == null ? null : icon.loadDrawable(this.mContext));
    }

    public Runnable setImageIconAsync(Icon icon) {
        return new ImageDrawableCallback(icon == null ? null : icon.loadDrawable(this.mContext), null, 0);
    }

    @RemotableViewMethod
    public void setImageTintList(ColorStateList tint) {
        this.mDrawableTintList = tint;
        this.mHasDrawableTint = true;
        applyImageTint();
    }

    public ColorStateList getImageTintList() {
        return this.mDrawableTintList;
    }

    public void setImageTintMode(PorterDuff.Mode tintMode) {
        setImageTintBlendMode(tintMode != null ? BlendMode.fromValue(tintMode.nativeInt) : null);
    }

    @RemotableViewMethod
    public void setImageTintBlendMode(BlendMode blendMode) {
        this.mDrawableBlendMode = blendMode;
        this.mHasDrawableBlendMode = true;
        applyImageTint();
    }

    public PorterDuff.Mode getImageTintMode() {
        BlendMode blendMode = this.mDrawableBlendMode;
        if (blendMode != null) {
            return BlendMode.blendModeToPorterDuffMode(blendMode);
        }
        return null;
    }

    public BlendMode getImageTintBlendMode() {
        return this.mDrawableBlendMode;
    }

    private void applyImageTint() {
        Drawable drawable = this.mDrawable;
        if (drawable != null) {
            if (this.mHasDrawableTint || this.mHasDrawableBlendMode) {
                Drawable mutate = drawable.mutate();
                this.mDrawable = mutate;
                if (this.mHasDrawableTint) {
                    mutate.setTintList(this.mDrawableTintList);
                }
                if (this.mHasDrawableBlendMode) {
                    this.mDrawable.setTintBlendMode(this.mDrawableBlendMode);
                }
                if (this.mDrawable.isStateful()) {
                    this.mDrawable.setState(getDrawableState());
                }
            }
        }
    }

    @RemotableViewMethod
    public void setImageBitmap(Bitmap bm) {
        this.mDrawable = null;
        BitmapDrawable bitmapDrawable = this.mRecycleableBitmapDrawable;
        if (bitmapDrawable == null) {
            this.mRecycleableBitmapDrawable = new BitmapDrawable(this.mContext.getResources(), bm);
        } else {
            bitmapDrawable.setBitmap(bm);
        }
        setImageDrawable(this.mRecycleableBitmapDrawable);
        if (this.mViewExt.checkMutiTouchView()) {
            this.mViewExt.adjustImageViewLayerType(this.mDrawableWidth, this.mDrawableHeight);
        }
    }

    public void setImageState(int[] state, boolean merge) {
        this.mState = state;
        this.mMergeState = merge;
        if (this.mDrawable != null) {
            refreshDrawableState();
            resizeFromDrawable();
        }
    }

    @Override // android.view.View
    public void setSelected(boolean selected) {
        super.setSelected(selected);
        resizeFromDrawable();
    }

    @RemotableViewMethod
    public void setImageLevel(int level) {
        this.mLevel = level;
        this.mHasLevelSet = true;
        Drawable drawable = this.mDrawable;
        if (drawable != null) {
            drawable.setLevel(level);
            resizeFromDrawable();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public enum ScaleType {
        MATRIX(0),
        FIT_XY(1),
        FIT_START(2),
        FIT_CENTER(3),
        FIT_END(4),
        CENTER(5),
        CENTER_CROP(6),
        CENTER_INSIDE(7);

        final int nativeInt;

        ScaleType(int ni) {
            this.nativeInt = ni;
        }
    }

    public void setScaleType(ScaleType scaleType) {
        if (scaleType == null) {
            throw new NullPointerException();
        }
        ScaleType scaleType2 = this.mImageViewExt.modifyScaleType(scaleType);
        if (this.mScaleType != scaleType2) {
            this.mScaleType = scaleType2;
            requestLayout();
            invalidate();
        }
    }

    public ScaleType getScaleType() {
        return this.mScaleType;
    }

    public Matrix getImageMatrix() {
        Matrix matrix = this.mDrawMatrix;
        if (matrix == null) {
            return new Matrix(Matrix.IDENTITY_MATRIX);
        }
        return matrix;
    }

    public void setImageMatrix(Matrix matrix) {
        if (matrix != null && matrix.isIdentity()) {
            matrix = null;
        }
        if ((matrix == null && !this.mMatrix.isIdentity()) || (matrix != null && !this.mMatrix.equals(matrix))) {
            this.mMatrix.set(matrix);
            configureBounds();
            invalidate();
        }
    }

    public boolean getCropToPadding() {
        return this.mCropToPadding;
    }

    public void setCropToPadding(boolean cropToPadding) {
        if (this.mCropToPadding != cropToPadding) {
            this.mCropToPadding = cropToPadding;
            requestLayout();
            invalidate();
        }
    }

    private void resolveUri() {
        if (this.mDrawable != null || getResources() == null) {
            return;
        }
        Drawable d10 = null;
        if (this.mResource != 0) {
            try {
                d10 = this.mContext.getDrawable(this.mResource);
            } catch (Exception e2) {
                Log.w(LOG_TAG, "Unable to find resource: " + this.mResource, e2);
                this.mResource = 0;
            }
        } else {
            Uri uri = this.mUri;
            if (uri != null) {
                d10 = getDrawableFromUri(uri);
                if (d10 == null) {
                    Log.w(LOG_TAG, "resolveUri failed on bad bitmap uri: " + ((Object) this.mUri));
                    this.mUri = null;
                }
            } else {
                return;
            }
        }
        updateDrawable(d10);
    }

    private Drawable getDrawableFromUri(Uri uri) {
        String scheme = uri.getScheme();
        if ("android.resource".equals(scheme)) {
            try {
                ContentResolver.OpenResourceIdResult r10 = this.mContext.getContentResolver().getResourceId(uri);
                return r10.r.getDrawable(r10.id, this.mContext.getTheme());
            } catch (Exception e2) {
                Log.w(LOG_TAG, "Unable to open content: " + ((Object) uri), e2);
            }
        } else if ("content".equals(scheme) || "file".equals(scheme)) {
            try {
                Resources res = sCompatUseCorrectStreamDensity ? getResources() : null;
                ImageDecoder.Source src = ImageDecoder.createSource(this.mContext.getContentResolver(), uri, res);
                return ImageDecoder.decodeDrawable(src, new ImageDecoder.OnHeaderDecodedListener() { // from class: android.widget.ImageView$$ExternalSyntheticLambda0
                    @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
                    public final void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
                        imageDecoder.setAllocator(1);
                    }
                });
            } catch (IOException e10) {
                Log.w(LOG_TAG, "Unable to open content: " + ((Object) uri), e10);
            }
        } else {
            return Drawable.createFromPath(uri.toString());
        }
        return null;
    }

    @Override // android.view.View
    public int[] onCreateDrawableState(int extraSpace) {
        int[] iArr = this.mState;
        if (iArr == null) {
            return super.onCreateDrawableState(extraSpace);
        }
        if (!this.mMergeState) {
            return iArr;
        }
        return mergeDrawableStates(super.onCreateDrawableState(iArr.length + extraSpace), this.mState);
    }

    private void updateDrawable(Drawable d10) {
        BitmapDrawable bitmapDrawable = this.mRecycleableBitmapDrawable;
        if (d10 != bitmapDrawable && bitmapDrawable != null) {
            bitmapDrawable.setBitmap(null);
        }
        boolean sameDrawable = false;
        Drawable drawable = this.mDrawable;
        boolean z10 = false;
        if (drawable != null) {
            sameDrawable = drawable == d10;
            drawable.setCallback(null);
            unscheduleDrawable(this.mDrawable);
            if (!sCompatDrawableVisibilityDispatch && !sameDrawable && isAttachedToWindow()) {
                this.mDrawable.setVisible(false, false);
            }
        }
        this.mDrawable = d10;
        if (d10 != null) {
            d10.setCallback(this);
            d10.setLayoutDirection(getLayoutDirection());
            if (d10.isStateful()) {
                d10.setState(getDrawableState());
            }
            if (!sameDrawable || sCompatDrawableVisibilityDispatch) {
                if (sCompatDrawableVisibilityDispatch) {
                    if (getVisibility() == 0) {
                        z10 = true;
                    }
                } else if (isAttachedToWindow() && getWindowVisibility() == 0 && isShown()) {
                    z10 = true;
                }
                boolean visible = z10;
                d10.setVisible(visible, true);
            }
            boolean visible2 = this.mHasLevelSet;
            if (visible2) {
                d10.setLevel(this.mLevel);
            }
            this.mDrawableWidth = d10.getIntrinsicWidth();
            this.mDrawableHeight = d10.getIntrinsicHeight();
            applyImageTint();
            applyColorFilter();
            applyAlpha();
            applyXfermode();
            configureBounds();
            return;
        }
        this.mDrawableHeight = -1;
        this.mDrawableWidth = -1;
    }

    private void resizeFromDrawable() {
        Drawable d10 = this.mDrawable;
        if (d10 != null) {
            int w3 = d10.getIntrinsicWidth();
            if (w3 < 0) {
                w3 = this.mDrawableWidth;
            }
            int h10 = d10.getIntrinsicHeight();
            if (h10 < 0) {
                h10 = this.mDrawableHeight;
            }
            if (w3 != this.mDrawableWidth || h10 != this.mDrawableHeight) {
                this.mDrawableWidth = w3;
                this.mDrawableHeight = h10;
                requestLayout();
            }
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int layoutDirection) {
        super.onRtlPropertiesChanged(layoutDirection);
        Drawable drawable = this.mDrawable;
        if (drawable != null) {
            drawable.setLayoutDirection(layoutDirection);
        }
    }

    private static Matrix.ScaleToFit scaleTypeToScaleToFit(ScaleType st) {
        return sS2FArray[st.nativeInt - 1];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int h10;
        int w3;
        int widthSize;
        int heightSize;
        boolean done;
        resolveUri();
        float desiredAspect = 0.0f;
        boolean resizeWidth = false;
        boolean resizeHeight = false;
        int widthSpecMode = View.MeasureSpec.getMode(widthMeasureSpec);
        int heightSpecMode = View.MeasureSpec.getMode(heightMeasureSpec);
        if (this.mDrawable == null) {
            this.mDrawableWidth = -1;
            this.mDrawableHeight = -1;
            w3 = 0;
            h10 = 0;
        } else {
            int w10 = this.mDrawableWidth;
            int h11 = this.mDrawableHeight;
            if (w10 <= 0) {
                w10 = 1;
            }
            if (h11 <= 0) {
                h11 = 1;
            }
            if (!this.mAdjustViewBounds) {
                int i10 = h11;
                h10 = w10;
                w3 = i10;
            } else {
                resizeWidth = widthSpecMode != 1073741824;
                resizeHeight = heightSpecMode != 1073741824;
                desiredAspect = w10 / h11;
                int i11 = h11;
                h10 = w10;
                w3 = i11;
            }
        }
        int pleft = this.mPaddingLeft;
        int pright = this.mPaddingRight;
        int ptop = this.mPaddingTop;
        int pbottom = this.mPaddingBottom;
        if (resizeWidth || resizeHeight) {
            widthSize = resolveAdjustedSize(h10 + pleft + pright, this.mMaxWidth, widthMeasureSpec);
            int widthSpecMode2 = this.mMaxHeight;
            heightSize = resolveAdjustedSize(w3 + ptop + pbottom, widthSpecMode2, heightMeasureSpec);
            if (desiredAspect != 0.0f) {
                int heightSpecMode2 = (heightSize - ptop) - pbottom;
                float actualAspect = ((widthSize - pleft) - pright) / heightSpecMode2;
                if (Math.abs(actualAspect - desiredAspect) > 1.0E-7d) {
                    boolean done2 = false;
                    if (resizeWidth) {
                        int newWidth = ((int) (((heightSize - ptop) - pbottom) * desiredAspect)) + pleft + pright;
                        if (resizeHeight || sCompatAdjustViewBounds) {
                            done = false;
                        } else {
                            done = false;
                            widthSize = resolveAdjustedSize(newWidth, this.mMaxWidth, widthMeasureSpec);
                        }
                        if (newWidth > widthSize) {
                            done2 = done;
                        } else {
                            widthSize = newWidth;
                            done2 = true;
                        }
                    }
                    if (!done2 && resizeHeight) {
                        int newHeight = ((int) (((widthSize - pleft) - pright) / desiredAspect)) + ptop + pbottom;
                        if (!resizeWidth && !sCompatAdjustViewBounds) {
                            heightSize = resolveAdjustedSize(newHeight, this.mMaxHeight, heightMeasureSpec);
                        }
                        if (newHeight <= heightSize) {
                            heightSize = newHeight;
                        }
                    }
                }
            }
        } else {
            int w11 = Math.max(h10 + pleft + pright, getSuggestedMinimumWidth());
            int h12 = Math.max(w3 + ptop + pbottom, getSuggestedMinimumHeight());
            widthSize = resolveSizeAndState(w11, widthMeasureSpec, 0);
            heightSize = resolveSizeAndState(h12, heightMeasureSpec, 0);
        }
        setMeasuredDimension(widthSize, heightSize);
    }

    private int resolveAdjustedSize(int desiredSize, int maxSize, int measureSpec) {
        int specMode = View.MeasureSpec.getMode(measureSpec);
        int specSize = View.MeasureSpec.getSize(measureSpec);
        switch (specMode) {
            case Integer.MIN_VALUE:
                int result = Math.min(Math.min(desiredSize, specSize), maxSize);
                return result;
            case 0:
                int result2 = Math.min(desiredSize, maxSize);
                return result2;
            case 1073741824:
                return specSize;
            default:
                return desiredSize;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public boolean setFrame(int l10, int t2, int r10, int b4) {
        boolean changed = super.setFrame(l10, t2, r10, b4);
        this.mHaveFrame = true;
        configureBounds();
        return changed;
    }

    private void configureBounds() {
        float scale;
        float scale2;
        if (this.mDrawable == null || !this.mHaveFrame) {
            return;
        }
        int dwidth = this.mDrawableWidth;
        int dheight = this.mDrawableHeight;
        int vwidth = (getWidth() - this.mPaddingLeft) - this.mPaddingRight;
        int vheight = (getHeight() - this.mPaddingTop) - this.mPaddingBottom;
        boolean fits = (dwidth < 0 || vwidth == dwidth) && (dheight < 0 || vheight == dheight);
        if (dwidth <= 0 || dheight <= 0 || ScaleType.FIT_XY == this.mScaleType) {
            this.mDrawable.setBounds(0, 0, vwidth, vheight);
            this.mDrawMatrix = null;
            return;
        }
        this.mDrawable.setBounds(0, 0, dwidth, dheight);
        if (ScaleType.MATRIX == this.mScaleType) {
            if (this.mMatrix.isIdentity()) {
                this.mDrawMatrix = null;
                return;
            } else {
                this.mDrawMatrix = this.mMatrix;
                return;
            }
        }
        if (fits) {
            this.mDrawMatrix = null;
            return;
        }
        if (ScaleType.CENTER == this.mScaleType) {
            Matrix matrix = this.mMatrix;
            this.mDrawMatrix = matrix;
            matrix.setTranslate(Math.round((vwidth - dwidth) * 0.5f), Math.round((vheight - dheight) * 0.5f));
            return;
        }
        if (ScaleType.CENTER_CROP == this.mScaleType) {
            Matrix matrix2 = this.mMatrix;
            this.mDrawMatrix = matrix2;
            float dx = 0.0f;
            float dy = 0.0f;
            if (dwidth * vheight > vwidth * dheight) {
                scale2 = vheight / dheight;
                dx = (vwidth - (dwidth * scale2)) * 0.5f;
            } else {
                float scale3 = vwidth;
                scale2 = scale3 / dwidth;
                dy = (vheight - (dheight * scale2)) * 0.5f;
            }
            matrix2.setScale(scale2, scale2);
            this.mDrawMatrix.postTranslate(Math.round(dx), Math.round(dy));
            return;
        }
        if (ScaleType.CENTER_INSIDE == this.mScaleType) {
            this.mDrawMatrix = this.mMatrix;
            if (dwidth <= vwidth && dheight <= vheight) {
                scale = 1.0f;
            } else {
                float scale4 = vwidth;
                scale = Math.min(scale4 / dwidth, vheight / dheight);
            }
            float dx2 = Math.round((vwidth - (dwidth * scale)) * 0.5f);
            float dy2 = Math.round((vheight - (dheight * scale)) * 0.5f);
            this.mDrawMatrix.setScale(scale, scale);
            this.mDrawMatrix.postTranslate(dx2, dy2);
            return;
        }
        this.mTempSrc.set(0.0f, 0.0f, dwidth, dheight);
        this.mTempDst.set(0.0f, 0.0f, vwidth, vheight);
        Matrix matrix3 = this.mMatrix;
        this.mDrawMatrix = matrix3;
        matrix3.setRectToRect(this.mTempSrc, this.mTempDst, scaleTypeToScaleToFit(this.mScaleType));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.mDrawable;
        if (drawable != null && drawable.isStateful() && drawable.setState(getDrawableState())) {
            invalidateDrawable(drawable);
        }
    }

    @Override // android.view.View
    public void drawableHotspotChanged(float x10, float y10) {
        super.drawableHotspotChanged(x10, y10);
        Drawable drawable = this.mDrawable;
        if (drawable != null) {
            drawable.setHotspot(x10, y10);
        }
    }

    public void animateTransform(Matrix matrix) {
        Drawable drawable = this.mDrawable;
        if (drawable == null) {
            return;
        }
        if (matrix != null) {
            drawable.setBounds(0, 0, this.mDrawableWidth, this.mDrawableHeight);
            if (this.mDrawMatrix == null) {
                this.mDrawMatrix = new Matrix();
            }
            this.mDrawMatrix.set(matrix);
        } else {
            int vwidth = (getWidth() - this.mPaddingLeft) - this.mPaddingRight;
            int vheight = (getHeight() - this.mPaddingTop) - this.mPaddingBottom;
            this.mDrawable.setBounds(0, 0, vwidth, vheight);
            this.mDrawMatrix = null;
        }
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mDrawable == null || this.mDrawableWidth == 0 || this.mDrawableHeight == 0) {
            return;
        }
        if (this.mDrawMatrix == null && this.mPaddingTop == 0 && this.mPaddingLeft == 0) {
            this.mDrawable.draw(canvas);
            return;
        }
        int saveCount = canvas.getSaveCount();
        canvas.save();
        if (this.mCropToPadding) {
            int scrollX = this.mScrollX;
            int scrollY = this.mScrollY;
            canvas.clipRect(this.mPaddingLeft + scrollX, this.mPaddingTop + scrollY, ((this.mRight + scrollX) - this.mLeft) - this.mPaddingRight, ((this.mBottom + scrollY) - this.mTop) - this.mPaddingBottom);
        }
        canvas.translate(this.mPaddingLeft, this.mPaddingTop);
        Matrix matrix = this.mDrawMatrix;
        if (matrix != null) {
            canvas.concat(matrix);
        }
        this.mDrawable.draw(canvas);
        canvas.restoreToCount(saveCount);
    }

    @Override // android.view.View
    @ViewDebug.ExportedProperty(category = "layout")
    public int getBaseline() {
        if (this.mBaselineAlignBottom) {
            return getMeasuredHeight();
        }
        return this.mBaseline;
    }

    public void setBaseline(int baseline) {
        if (this.mBaseline != baseline) {
            this.mBaseline = baseline;
            requestLayout();
        }
    }

    public void setBaselineAlignBottom(boolean aligned) {
        if (this.mBaselineAlignBottom != aligned) {
            this.mBaselineAlignBottom = aligned;
            requestLayout();
        }
    }

    public boolean getBaselineAlignBottom() {
        return this.mBaselineAlignBottom;
    }

    public final void setColorFilter(int color, PorterDuff.Mode mode) {
        setColorFilter(new PorterDuffColorFilter(color, mode));
    }

    @RemotableViewMethod
    public final void setColorFilter(int color) {
        setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
    }

    public final void clearColorFilter() {
        setColorFilter((ColorFilter) null);
    }

    public final void setXfermode(Xfermode mode) {
        if (this.mXfermode != mode) {
            this.mXfermode = mode;
            this.mHasXfermode = true;
            applyXfermode();
            invalidate();
        }
    }

    public ColorFilter getColorFilter() {
        return this.mColorFilter;
    }

    public void setColorFilter(ColorFilter cf) {
        if (this.mColorFilter != cf) {
            this.mColorFilter = cf;
            this.mHasColorFilter = true;
            applyColorFilter();
            invalidate();
        }
    }

    public int getImageAlpha() {
        return this.mAlpha;
    }

    @RemotableViewMethod
    public void setImageAlpha(int alpha) {
        setAlpha(alpha);
    }

    @RemotableViewMethod
    @Deprecated
    public void setAlpha(int alpha) {
        int alpha2 = alpha & 255;
        if (this.mAlpha != alpha2) {
            this.mAlpha = alpha2;
            this.mHasAlpha = true;
            applyAlpha();
            invalidate();
        }
    }

    private void applyXfermode() {
        Drawable drawable = this.mDrawable;
        if (drawable != null && this.mHasXfermode) {
            Drawable mutate = drawable.mutate();
            this.mDrawable = mutate;
            mutate.setXfermode(this.mXfermode);
        }
    }

    private void applyColorFilter() {
        Drawable drawable = this.mDrawable;
        if (drawable != null && this.mHasColorFilter) {
            Drawable mutate = drawable.mutate();
            this.mDrawable = mutate;
            mutate.setColorFilter(this.mColorFilter);
        }
    }

    private void applyAlpha() {
        Drawable drawable = this.mDrawable;
        if (drawable != null && this.mHasAlpha) {
            Drawable mutate = drawable.mutate();
            this.mDrawable = mutate;
            mutate.setAlpha((this.mAlpha * 256) >> 8);
        }
    }

    @Override // android.view.View
    public boolean isOpaque() {
        Drawable drawable;
        return super.isOpaque() || ((drawable = this.mDrawable) != null && this.mXfermode == null && drawable.getOpacity() == -1 && ((this.mAlpha * 256) >> 8) == 255 && isFilledByImage());
    }

    private boolean isFilledByImage() {
        Drawable drawable = this.mDrawable;
        if (drawable == null) {
            return false;
        }
        Rect bounds = drawable.getBounds();
        Matrix matrix = this.mDrawMatrix;
        if (matrix == null) {
            return bounds.left <= 0 && bounds.top <= 0 && bounds.right >= getWidth() && bounds.bottom >= getHeight();
        }
        if (!matrix.rectStaysRect()) {
            return false;
        }
        RectF boundsSrc = this.mTempSrc;
        RectF boundsDst = this.mTempDst;
        boundsSrc.set(bounds);
        matrix.mapRect(boundsDst, boundsSrc);
        return boundsDst.left <= 0.0f && boundsDst.top <= 0.0f && boundsDst.right >= ((float) getWidth()) && boundsDst.bottom >= ((float) getHeight());
    }

    @Override // android.view.View
    public void onVisibilityAggregated(boolean isVisible) {
        super.onVisibilityAggregated(isVisible);
        Drawable drawable = this.mDrawable;
        if (drawable != null && !sCompatDrawableVisibilityDispatch) {
            drawable.setVisible(isVisible, false);
        }
    }

    @Override // android.view.View
    @RemotableViewMethod
    public void setVisibility(int visibility) {
        super.setVisibility(visibility);
        Drawable drawable = this.mDrawable;
        if (drawable != null && sCompatDrawableVisibilityDispatch) {
            drawable.setVisible(visibility == 0, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable drawable = this.mDrawable;
        if (drawable != null && sCompatDrawableVisibilityDispatch) {
            drawable.setVisible(getVisibility() == 0, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Drawable drawable = this.mDrawable;
        if (drawable != null && sCompatDrawableVisibilityDispatch) {
            drawable.setVisible(false, false);
        }
    }

    @Override // android.view.View
    public CharSequence getAccessibilityClassName() {
        return ImageView.class.getName();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void encodeProperties(ViewHierarchyEncoder stream) {
        super.encodeProperties(stream);
        stream.addProperty("layout:baseline", getBaseline());
    }

    @Override // android.view.View
    public boolean isDefaultFocusHighlightNeeded(Drawable background, Drawable foreground) {
        Drawable drawable = this.mDrawable;
        boolean lackFocusState = (drawable != null && drawable.isStateful() && this.mDrawable.hasFocusStateSpecified()) ? false : true;
        return super.isDefaultFocusHighlightNeeded(background, foreground) && lackFocusState;
    }
}
