package com.huawei.quickcard.rating.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.RatingBar;
import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import com.facebook.yoga.YogaNode;
import com.huawei.quickcard.CardContext;
import com.huawei.quickcard.base.log.CardLogUtils;
import com.huawei.quickcard.exposure.ExposureManager;
import com.huawei.quickcard.framework.IComponentSupport;
import com.huawei.quickcard.framework.c;
import com.huawei.quickcard.framework.processor.PropertyCacheBean;
import com.huawei.quickcard.rating.R;
import com.huawei.quickcard.rating.b;
import com.huawei.quickcard.utils.SystemUtils;
import com.huawei.quickcard.utils.ValueUtils;
import com.huawei.quickcard.utils.YogaUtils;
import com.huawei.quickcard.views.GestureDelegate;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class QuickCardRating extends RatingBar implements IComponentSupport {

    /* renamed from: o, reason: collision with root package name */
    private static final String f34203o = "QuickCardRating";

    /* renamed from: a, reason: collision with root package name */
    private LayerDrawable f34204a;

    /* renamed from: b, reason: collision with root package name */
    private Drawable f34205b;

    /* renamed from: c, reason: collision with root package name */
    private Drawable f34206c;

    /* renamed from: d, reason: collision with root package name */
    private Drawable f34207d;

    /* renamed from: e, reason: collision with root package name */
    private Bitmap f34208e;

    /* renamed from: f, reason: collision with root package name */
    private String f34209f;

    /* renamed from: g, reason: collision with root package name */
    private String f34210g;

    /* renamed from: h, reason: collision with root package name */
    private String f34211h;

    /* renamed from: i, reason: collision with root package name */
    private ExposureManager f34212i;

    /* renamed from: j, reason: collision with root package name */
    private int f34213j;

    /* renamed from: k, reason: collision with root package name */
    private int f34214k;

    /* renamed from: l, reason: collision with root package name */
    private float f34215l;

    /* renamed from: m, reason: collision with root package name */
    private float f34216m;

    /* renamed from: n, reason: collision with root package name */
    private int f34217n;

    public QuickCardRating(@NonNull Context context) {
        super(context);
        this.f34209f = null;
        this.f34210g = null;
        this.f34211h = null;
        this.f34213j = -1;
        this.f34214k = -1;
        this.f34215l = 0.5f;
        this.f34216m = 0.0f;
        this.f34217n = 5;
        b();
    }

    private void a() {
        try {
            Resources resources = getResources();
            Drawable drawable = ResourcesCompat.getDrawable(resources, R.drawable.quick_card_rating_star_on, null);
            Drawable drawable2 = ResourcesCompat.getDrawable(resources, R.drawable.quick_card_rating_star_off, null);
            if (drawable2 != null) {
                this.f34205b = new BitmapDrawable(resources, b.a(drawable2));
                this.f34207d = new BitmapDrawable(resources, b.a(drawable2));
            }
            if (drawable != null) {
                this.f34206c = new BitmapDrawable(resources, b.a(drawable));
            }
        } catch (Resources.NotFoundException unused) {
            CardLogUtils.e(f34203o, "initDrawable fail case ");
        }
    }

    private void b() {
        Drawable progressDrawable = getProgressDrawable();
        if (progressDrawable instanceof LayerDrawable) {
            this.f34204a = (LayerDrawable) progressDrawable;
            a();
        }
    }

    @Override // com.huawei.quickcard.framework.IComponentFunction
    public /* synthetic */ void focus(Object obj) {
        com.huawei.quickcard.framework.b.a(this, obj);
    }

    public int getRatingNumStars() {
        return this.f34217n;
    }

    public float getRatingRate() {
        return this.f34216m;
    }

    public float getRatingStepSize() {
        return this.f34215l;
    }

    public String getStarBackground() {
        return this.f34209f;
    }

    public String getStarForeground() {
        return this.f34210g;
    }

    public String getStarSecondary() {
        return this.f34211h;
    }

    @Override // com.huawei.quickcard.framework.IComponentSupport
    public /* synthetic */ ViewParent getViewParent(View view) {
        return c.a(this, view);
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ExposureManager exposureManager = this.f34212i;
        if (exposureManager != null) {
            exposureManager.onAttachedToWindow(this);
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ExposureManager exposureManager = this.f34212i;
        if (exposureManager != null) {
            exposureManager.onDetachedFromWindow(this);
        }
    }

    @Override // android.widget.RatingBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public synchronized void onMeasure(int i10, int i11) {
        int numStars;
        int intrinsicHeight;
        PropertyCacheBean obtainPropertyCacheBeanFromView = ValueUtils.obtainPropertyCacheBeanFromView(this);
        boolean isWidthDefined = obtainPropertyCacheBeanFromView.isWidthDefined();
        boolean isHeightDefined = obtainPropertyCacheBeanFromView.isHeightDefined();
        boolean z10 = this.f34208e != null;
        Drawable drawable = this.f34205b;
        float f10 = 1.0f;
        if (drawable instanceof BitmapDrawable) {
            this.f34208e = ((BitmapDrawable) drawable).getBitmap();
            f10 = ((r3.getWidth() * getNumStars()) * 1.0f) / this.f34208e.getHeight();
        }
        YogaNode yogaNode = YogaUtils.getYogaNode(this);
        if (isWidthDefined) {
            if (!isHeightDefined) {
                int round = yogaNode == null ? getLayoutParams().width : Math.round(yogaNode.q().f19201a);
                setMeasuredDimension(Math.min(round, SystemUtils.getScreenWidth(getContext())), Math.min(Math.round(round / f10), SystemUtils.getScreenHeight(getContext())));
            } else {
                super.onMeasure(i10, i11);
            }
        } else if (isHeightDefined) {
            int round2 = yogaNode == null ? getLayoutParams().height : Math.round(yogaNode.j().f19201a);
            setMeasuredDimension(Math.min(Math.round(round2 * f10), SystemUtils.getScreenWidth(getContext())), Math.min(round2, SystemUtils.getScreenHeight(getContext())));
        } else {
            if (z10) {
                numStars = getNumStars() * this.f34208e.getWidth();
                intrinsicHeight = this.f34208e.getHeight();
            } else {
                numStars = getNumStars() * this.f34205b.getIntrinsicWidth();
                intrinsicHeight = this.f34205b.getIntrinsicHeight();
            }
            setMeasuredDimension(Math.min(numStars, SystemUtils.getScreenWidth(getContext())), Math.min(intrinsicHeight, SystemUtils.getScreenHeight(getContext())));
        }
    }

    @Override // android.view.View
    public void onScreenStateChanged(int i10) {
        ExposureManager exposureManager = this.f34212i;
        if (exposureManager != null) {
            exposureManager.onScreenSateChange(this, i10);
        }
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        this.f34213j = i10;
        this.f34214k = i11;
        a(i10, i11);
    }

    @Override // android.widget.AbsSeekBar, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return GestureDelegate.onTouchEvent(this, motionEvent) | super.onTouchEvent(motionEvent);
    }

    @Override // com.huawei.quickcard.framework.IComponentSupport
    public /* synthetic */ void onViewCreated(CardContext cardContext) {
        c.b(this, cardContext);
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View view, int i10) {
        ExposureManager exposureManager = this.f34212i;
        if (exposureManager != null) {
            exposureManager.onVisibilityChanged(this, view, i10);
        }
    }

    public void saveRatingBackground(String str) {
        this.f34209f = str;
    }

    public void saveRatingForeground(String str) {
        this.f34210g = str;
    }

    public void saveRatingSecondary(String str) {
        this.f34211h = str;
    }

    @Override // com.huawei.quickcard.exposure.IExposureSupport
    public void setExposureManager(ExposureManager exposureManager) {
        this.f34212i = exposureManager;
    }

    @Override // android.widget.RatingBar
    public void setNumStars(int i10) {
        super.setNumStars(i10);
        a(this.f34213j, this.f34214k);
        this.f34217n = i10;
    }

    @Override // android.widget.RatingBar
    public void setRating(float f10) {
        super.setRating(f10);
        this.f34216m = f10;
    }

    public void setRatingBackgroundDrawable(Drawable drawable) {
        this.f34205b = drawable;
        if (drawable instanceof BitmapDrawable) {
            this.f34208e = ((BitmapDrawable) drawable).getBitmap();
        }
    }

    public void setRatingForegroundDrawable(Drawable drawable) {
        this.f34206c = drawable;
        if (drawable instanceof BitmapDrawable) {
            this.f34208e = ((BitmapDrawable) drawable).getBitmap();
        }
    }

    public void setRatingSecondaryDrawable(Drawable drawable) {
        this.f34207d = drawable;
        if (drawable instanceof BitmapDrawable) {
            this.f34208e = ((BitmapDrawable) drawable).getBitmap();
        }
    }

    @Override // android.widget.RatingBar
    public void setStepSize(float f10) {
        super.setStepSize(f10);
        this.f34215l = f10;
    }

    @Override // com.huawei.quickcard.framework.IComponentSupport
    public /* synthetic */ void setViewParent(ViewParent viewParent) {
        c.c(this, viewParent);
    }

    private void a(int i10, int i11) {
        if (this.f34208e == null || this.f34204a == null || i10 <= 0 || i11 <= 0) {
            return;
        }
        float numStars = ((i10 * 1.0f) / getNumStars()) / this.f34208e.getWidth();
        float height = (i11 * 1.0f) / this.f34208e.getHeight();
        this.f34204a.setDrawableByLayerId(16908288, a(this.f34205b, false, numStars, height));
        this.f34204a.setDrawableByLayerId(16908301, a(this.f34206c, true, numStars, height));
        this.f34204a.setDrawableByLayerId(16908303, a(this.f34207d, true, numStars, height));
        this.f34204a.setBounds(0, 0, i10, i11);
        float rating = getRating();
        setRating(0.0f);
        setRating(rating);
    }

    private Drawable a(Drawable drawable, boolean z10, float f10, float f11) {
        if (drawable == null) {
            return new ColorDrawable(0);
        }
        if (drawable instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            Matrix matrix = new Matrix();
            matrix.postScale(f10, f11);
            Bitmap createBitmap = Bitmap.createBitmap((int) (f10 * bitmap.getWidth()), (int) (f11 * bitmap.getHeight()), Bitmap.Config.ARGB_8888);
            new Canvas(createBitmap).drawBitmap(bitmap, matrix, new Paint(1));
            BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), createBitmap);
            bitmapDrawable.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.CLAMP);
            return z10 ? new ClipDrawable(bitmapDrawable, 8388611, 1) : bitmapDrawable;
        }
        CardLogUtils.e(f34203o, "create drawable fail case drawable not a BitmapDrawable");
        return null;
    }
}
