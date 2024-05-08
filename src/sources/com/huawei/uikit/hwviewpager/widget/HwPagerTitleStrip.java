package com.huawei.uikit.hwviewpager.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.method.SingleLineTransformationMethod;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.TextViewCompat;
import com.huawei.uikit.hwviewpager.widget.HwViewPager;
import java.lang.ref.WeakReference;
import java.util.Locale;

@HwViewPager.DecorView
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class HwPagerTitleStrip extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    public static final String f35306a = "HwPagerTitleStrip";

    /* renamed from: b, reason: collision with root package name */
    public static final float f35307b = 0.5f;

    /* renamed from: c, reason: collision with root package name */
    public static final float f35308c = 0.8f;

    /* renamed from: d, reason: collision with root package name */
    public static final int f35309d = 2;

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f35310e = {16842804, 16842901, 16842904, 16842927};

    /* renamed from: f, reason: collision with root package name */
    public static final int[] f35311f = {16843660};

    /* renamed from: g, reason: collision with root package name */
    public static final float f35312g = 0.6f;

    /* renamed from: h, reason: collision with root package name */
    public static final int f35313h = 16;

    /* renamed from: i, reason: collision with root package name */
    public HwViewPager f35314i;

    /* renamed from: j, reason: collision with root package name */
    public TextView f35315j;

    /* renamed from: k, reason: collision with root package name */
    public TextView f35316k;

    /* renamed from: l, reason: collision with root package name */
    public TextView f35317l;

    /* renamed from: m, reason: collision with root package name */
    public int f35318m;

    /* renamed from: n, reason: collision with root package name */
    public float f35319n;

    /* renamed from: o, reason: collision with root package name */
    public int f35320o;

    /* renamed from: p, reason: collision with root package name */
    public int f35321p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f35322q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f35323r;

    /* renamed from: s, reason: collision with root package name */
    public final a f35324s;

    /* renamed from: t, reason: collision with root package name */
    public WeakReference<HwPagerAdapter> f35325t;

    /* renamed from: u, reason: collision with root package name */
    public int f35326u;

    /* renamed from: v, reason: collision with root package name */
    public int f35327v;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class a extends DataSetObserver implements HwViewPager.OnPageChangeListener, HwViewPager.OnAdapterChangeListener {

        /* renamed from: a, reason: collision with root package name */
        public int f35328a;

        public a() {
        }

        @Override // com.huawei.uikit.hwviewpager.widget.HwViewPager.OnAdapterChangeListener
        public void onAdapterChanged(@NonNull HwViewPager hwViewPager, HwPagerAdapter hwPagerAdapter, HwPagerAdapter hwPagerAdapter2) {
            HwPagerTitleStrip.this.a(hwPagerAdapter, hwPagerAdapter2);
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            HwPagerTitleStrip hwPagerTitleStrip = HwPagerTitleStrip.this;
            hwPagerTitleStrip.a(hwPagerTitleStrip.f35314i.getCurrentItem(), HwPagerTitleStrip.this.f35314i.getAdapter());
            HwPagerTitleStrip hwPagerTitleStrip2 = HwPagerTitleStrip.this;
            float f10 = hwPagerTitleStrip2.f35319n;
            if (f10 < 0.0f) {
                f10 = 0.0f;
            }
            hwPagerTitleStrip2.a(hwPagerTitleStrip2.f35314i.getCurrentItem(), f10, true);
        }

        @Override // com.huawei.uikit.hwviewpager.widget.HwViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i10) {
            this.f35328a = i10;
        }

        @Override // com.huawei.uikit.hwviewpager.widget.HwViewPager.OnPageChangeListener
        public void onPageScrolled(int i10, float f10, int i11) {
            if (f10 > 0.5f) {
                i10++;
            }
            HwPagerTitleStrip.this.a(i10, f10, false);
        }

        @Override // com.huawei.uikit.hwviewpager.widget.HwViewPager.OnPageChangeListener
        public void onPageSelected(int i10) {
            if (this.f35328a == 0) {
                HwPagerTitleStrip hwPagerTitleStrip = HwPagerTitleStrip.this;
                hwPagerTitleStrip.a(hwPagerTitleStrip.f35314i.getCurrentItem(), HwPagerTitleStrip.this.f35314i.getAdapter());
                HwPagerTitleStrip hwPagerTitleStrip2 = HwPagerTitleStrip.this;
                float f10 = hwPagerTitleStrip2.f35319n;
                if (f10 < 0.0f) {
                    f10 = 0.0f;
                }
                hwPagerTitleStrip2.a(hwPagerTitleStrip2.f35314i.getCurrentItem(), f10, true);
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class b extends SingleLineTransformationMethod {

        /* renamed from: a, reason: collision with root package name */
        public Locale f35330a;

        public b(Context context) {
            this.f35330a = context.getResources().getConfiguration().locale;
        }

        @Override // android.text.method.ReplacementTransformationMethod, android.text.method.TransformationMethod
        public CharSequence getTransformation(CharSequence charSequence, View view) {
            CharSequence transformation = super.getTransformation(charSequence, view);
            if (transformation != null) {
                return transformation.toString().toUpperCase(this.f35330a);
            }
            return null;
        }
    }

    public HwPagerTitleStrip(@NonNull Context context) {
        this(context, null);
    }

    private float a(float f10) {
        float f11 = f10 + 0.5f;
        return f11 > 1.0f ? f11 - 1.0f : f11;
    }

    private float a(float f10, boolean z10) {
        if (z10) {
            f10 = -f10;
        }
        float f11 = f10 + 0.5f;
        return z10 ? f11 < 0.0f ? f11 + 1.0f : f11 : f11 > 1.0f ? f11 - 1.0f : f11;
    }

    private void a(int i10) {
        setTextSize(0, i10);
    }

    private void b(float f10, int i10, int i11) {
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int measuredHeight = this.f35315j.getMeasuredHeight();
        int measuredHeight2 = this.f35316k.getMeasuredHeight();
        int measuredHeight3 = this.f35317l.getMeasuredHeight();
        int i12 = measuredHeight2 / 2;
        float a10 = a(f10);
        boolean isRtlLayout = this.f35314i.isRtlLayout();
        int i13 = ((i11 - (paddingBottom + i12)) - ((int) (((i11 - (paddingTop + i12)) - r9) * a10))) - i12;
        int i14 = measuredHeight2 + i13;
        int max = Math.max(Math.max(this.f35315j.getMeasuredWidth(), this.f35316k.getMeasuredWidth()), this.f35317l.getMeasuredWidth());
        int i15 = this.f35321p & 7;
        if (i15 == 1) {
            paddingLeft = (((i10 - paddingLeft) - paddingRight) - max) / 2;
        } else if (i15 == 5) {
            paddingLeft = isRtlLayout ? paddingRight : (i10 - paddingRight) - max;
        } else if (isRtlLayout) {
            paddingLeft = (i10 - max) - paddingLeft;
        }
        TextView textView = this.f35316k;
        textView.layout(paddingLeft, i13, textView.getMeasuredWidth() + paddingLeft, i14);
        int min = Math.min(paddingTop, (i13 - this.f35320o) - measuredHeight);
        TextView textView2 = this.f35315j;
        textView2.layout(paddingLeft, min, textView2.getMeasuredWidth() + paddingLeft, measuredHeight + min);
        int max2 = Math.max((i11 - paddingBottom) - measuredHeight3, i14 + this.f35320o);
        TextView textView3 = this.f35317l;
        textView3.layout(paddingLeft, max2, textView3.getMeasuredWidth() + paddingLeft, measuredHeight3 + max2);
    }

    public static void setSingleLineAllCaps(TextView textView) {
        textView.setTransformationMethod(new b(textView.getContext()));
    }

    public int getMinHeight() {
        Drawable background = getBackground();
        if (background != null) {
            return background.getIntrinsicHeight();
        }
        return 0;
    }

    public int getMinWidth() {
        Drawable background = getBackground();
        if (background != null) {
            return background.getIntrinsicWidth();
        }
        return 0;
    }

    public int getTextSpacing() {
        return this.f35320o;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof HwViewPager) {
            HwViewPager hwViewPager = (HwViewPager) parent;
            HwPagerAdapter adapter = hwViewPager.getAdapter();
            hwViewPager.a(this.f35324s);
            hwViewPager.addOnAdapterChangeListener(this.f35324s);
            this.f35314i = hwViewPager;
            if (hwViewPager.getPageScrollDirection() == 0) {
                setGravity(80);
            } else {
                setGravity(1);
            }
            WeakReference<HwPagerAdapter> weakReference = this.f35325t;
            a(weakReference != null ? weakReference.get() : null, adapter);
            return;
        }
        throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        HwViewPager hwViewPager = this.f35314i;
        if (hwViewPager != null) {
            a(hwViewPager.getAdapter(), (HwPagerAdapter) null);
            this.f35314i.a((HwViewPager.OnPageChangeListener) null);
            this.f35314i.removeOnAdapterChangeListener(this.f35324s);
            this.f35314i = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        if (this.f35314i != null) {
            float f10 = this.f35319n;
            if (f10 < 0.0f) {
                f10 = 0.0f;
            }
            a(this.f35318m, f10, true);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        HwViewPager hwViewPager = this.f35314i;
        boolean z10 = true;
        if (hwViewPager != null && hwViewPager.getPageScrollDirection() != 0) {
            z10 = false;
        }
        if (z10) {
            a(i10, i11);
        } else {
            b(i10, i11);
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.f35322q) {
            return;
        }
        super.requestLayout();
    }

    public void setGravity(int i10) {
        this.f35321p = i10;
        requestLayout();
    }

    public void setNonPrimaryAlpha(@FloatRange(from = 0.0d, to = 1.0d) float f10) {
        int i10 = ((int) (f10 * 255.0f)) & 255;
        this.f35326u = i10;
        int i11 = (i10 << 24) | (this.f35327v & 16777215);
        this.f35315j.setTextColor(i11);
        this.f35317l.setTextColor(i11);
    }

    public void setTextColor(@ColorInt int i10) {
        this.f35327v = i10;
        this.f35316k.setTextColor(i10);
        int i11 = (this.f35326u << 24) | (this.f35327v & 16777215);
        this.f35315j.setTextColor(i11);
        this.f35317l.setTextColor(i11);
    }

    public void setTextSize(int i10, float f10) {
        this.f35315j.setTextSize(i10, f10);
        this.f35316k.setTextSize(i10, f10);
        this.f35317l.setTextSize(i10, f10);
    }

    public void setTextSpacing(int i10) {
        this.f35320o = i10;
        requestLayout();
    }

    public HwPagerTitleStrip(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f35318m = -1;
        this.f35319n = -1.0f;
        this.f35324s = new a();
        TextView textView = new TextView(context);
        this.f35315j = textView;
        addView(textView);
        TextView textView2 = new TextView(context);
        this.f35316k = textView2;
        addView(textView2);
        TextView textView3 = new TextView(context);
        this.f35317l = textView3;
        addView(textView3);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f35310e);
        boolean z10 = false;
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            TextViewCompat.setTextAppearance(this.f35315j, resourceId);
            TextViewCompat.setTextAppearance(this.f35316k, resourceId);
            TextViewCompat.setTextAppearance(this.f35317l, resourceId);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        if (dimensionPixelSize != 0) {
            a(dimensionPixelSize);
        }
        if (obtainStyledAttributes.hasValue(2)) {
            int color = obtainStyledAttributes.getColor(2, 0);
            this.f35315j.setTextColor(color);
            this.f35316k.setTextColor(color);
            this.f35317l.setTextColor(color);
        }
        this.f35321p = obtainStyledAttributes.getInteger(3, 80);
        obtainStyledAttributes.recycle();
        this.f35327v = this.f35316k.getTextColors().getDefaultColor();
        a();
        this.f35315j.setEllipsize(TextUtils.TruncateAt.END);
        this.f35316k.setEllipsize(TextUtils.TruncateAt.END);
        this.f35317l.setEllipsize(TextUtils.TruncateAt.END);
        if (resourceId != 0) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(resourceId, f35311f);
            z10 = obtainStyledAttributes2.getBoolean(0, false);
            obtainStyledAttributes2.recycle();
        }
        if (z10) {
            setSingleLineAllCaps(this.f35315j);
            setSingleLineAllCaps(this.f35316k);
            setSingleLineAllCaps(this.f35317l);
        } else {
            this.f35315j.setSingleLine();
            this.f35316k.setSingleLine();
            this.f35317l.setSingleLine();
        }
        this.f35320o = (int) (context.getResources().getDisplayMetrics().density * 16.0f);
    }

    private void a() {
        setNonPrimaryAlpha(0.6f);
    }

    public void a(int i10, HwPagerAdapter hwPagerAdapter) {
        int count = hwPagerAdapter != null ? hwPagerAdapter.getCount() : 0;
        boolean z10 = true;
        this.f35322q = true;
        CharSequence charSequence = null;
        this.f35315j.setText((i10 < 1 || hwPagerAdapter == null) ? null : hwPagerAdapter.getPageTitle(i10 - 1));
        this.f35316k.setText((hwPagerAdapter == null || i10 >= count) ? null : hwPagerAdapter.getPageTitle(i10));
        int i11 = i10 + 1;
        if (i11 < count && hwPagerAdapter != null) {
            charSequence = hwPagerAdapter.getPageTitle(i11);
        }
        this.f35317l.setText(charSequence);
        HwViewPager hwViewPager = this.f35314i;
        if (hwViewPager != null && hwViewPager.getPageScrollDirection() != 0) {
            z10 = false;
        }
        a(z10);
        this.f35318m = i10;
        if (!this.f35323r) {
            a(i10, this.f35319n, false);
        }
        this.f35322q = false;
    }

    private void a(boolean z10) {
        float f10 = z10 ? 0.8f : 1.0f;
        float f11 = z10 ? 1.0f : 0.8f;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.max(0, (int) (((getWidth() - getPaddingLeft()) - getPaddingRight()) * f10)), Integer.MIN_VALUE);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(Math.max(0, (int) (((getHeight() - getPaddingTop()) - getPaddingBottom()) * f11)), Integer.MIN_VALUE);
        this.f35315j.measure(makeMeasureSpec, makeMeasureSpec2);
        this.f35316k.measure(makeMeasureSpec, makeMeasureSpec2);
        this.f35317l.measure(makeMeasureSpec, makeMeasureSpec2);
    }

    private void b(int i10, int i11) {
        int max;
        if (View.MeasureSpec.getMode(i11) != 1073741824) {
            return;
        }
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i10, paddingRight, -2);
        int size = View.MeasureSpec.getSize(i11);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i11, (int) (size * 0.19999999f), -2);
        this.f35315j.measure(childMeasureSpec, childMeasureSpec2);
        this.f35316k.measure(childMeasureSpec, childMeasureSpec2);
        this.f35317l.measure(childMeasureSpec, childMeasureSpec2);
        if (View.MeasureSpec.getMode(i10) == 1073741824) {
            max = View.MeasureSpec.getSize(i10);
        } else {
            max = Math.max(getMinWidth(), this.f35316k.getMeasuredWidth() + paddingRight);
        }
        this.f35316k.getMeasuredState();
        setMeasuredDimension(View.resolveSize(max, i10), size);
    }

    public void a(HwPagerAdapter hwPagerAdapter, HwPagerAdapter hwPagerAdapter2) {
        if (hwPagerAdapter != null) {
            hwPagerAdapter.unregisterDataSetObserver(this.f35324s);
            this.f35325t = null;
        }
        if (hwPagerAdapter2 != null) {
            hwPagerAdapter2.registerDataSetObserver(this.f35324s);
            this.f35325t = new WeakReference<>(hwPagerAdapter2);
        }
        HwViewPager hwViewPager = this.f35314i;
        if (hwViewPager != null) {
            this.f35318m = -1;
            this.f35319n = -1.0f;
            a(hwViewPager.getCurrentItem(), hwPagerAdapter2);
            requestLayout();
        }
    }

    public void a(int i10, float f10, boolean z10) {
        if (i10 != this.f35318m) {
            a(i10, this.f35314i.getAdapter());
        } else if (!z10 && f10 == this.f35319n) {
            return;
        }
        this.f35323r = true;
        int width = getWidth();
        int height = getHeight();
        if (this.f35314i.getPageScrollDirection() == 0) {
            a(f10, width, height);
        } else {
            b(f10, width, height);
        }
        this.f35319n = f10;
        this.f35323r = false;
    }

    private void a(float f10, int i10, int i11) {
        int min;
        int max;
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int measuredWidth = this.f35315j.getMeasuredWidth();
        int measuredWidth2 = this.f35316k.getMeasuredWidth();
        int measuredWidth3 = this.f35317l.getMeasuredWidth();
        int i12 = measuredWidth2 / 2;
        boolean isRtlLayout = this.f35314i.isRtlLayout();
        int a10 = ((i10 - (paddingRight + i12)) - ((int) (((i10 - (paddingLeft + i12)) - r10) * a(f10, isRtlLayout)))) - i12;
        int i13 = measuredWidth2 + a10;
        int baseline = this.f35315j.getBaseline();
        int baseline2 = this.f35316k.getBaseline();
        int baseline3 = this.f35317l.getBaseline();
        int max2 = Math.max(Math.max(baseline, baseline2), baseline3);
        int i14 = max2 - baseline;
        int i15 = max2 - baseline2;
        int i16 = max2 - baseline3;
        int a11 = a(i14, i15, i16);
        int i17 = this.f35321p & 112;
        if (i17 == 16) {
            paddingTop = (((i11 - paddingTop) - paddingBottom) - a11) / 2;
        } else if (i17 == 80) {
            paddingTop = (i11 - paddingBottom) - a11;
        }
        int i18 = i14 + paddingTop;
        int i19 = i15 + paddingTop;
        int i20 = paddingTop + i16;
        TextView textView = this.f35316k;
        textView.layout(a10, i19, i13, textView.getMeasuredHeight() + i19);
        if (isRtlLayout) {
            min = Math.max((i10 - paddingRight) - measuredWidth, this.f35320o + i13);
        } else {
            min = Math.min(paddingLeft, (a10 - this.f35320o) - measuredWidth);
        }
        TextView textView2 = this.f35315j;
        textView2.layout(min, i18, measuredWidth + min, textView2.getMeasuredHeight() + i18);
        if (isRtlLayout) {
            max = Math.min(paddingLeft, (a10 - this.f35320o) - measuredWidth3);
        } else {
            max = Math.max((i10 - paddingRight) - measuredWidth3, i13 + this.f35320o);
        }
        TextView textView3 = this.f35317l;
        textView3.layout(max, i20, measuredWidth3 + max, textView3.getMeasuredHeight() + i20);
    }

    private int a(int i10, int i11, int i12) {
        int measuredHeight = this.f35315j.getMeasuredHeight() + i10;
        int measuredHeight2 = this.f35316k.getMeasuredHeight() + i11;
        return Math.max(Math.max(measuredHeight, measuredHeight2), this.f35317l.getMeasuredHeight() + i12);
    }

    private void a(int i10, int i11) {
        int max;
        if (View.MeasureSpec.getMode(i10) != 1073741824) {
            return;
        }
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i11, paddingBottom, -2);
        int size = View.MeasureSpec.getSize(i10);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i10, (int) (size * 0.19999999f), -2);
        this.f35315j.measure(childMeasureSpec2, childMeasureSpec);
        this.f35316k.measure(childMeasureSpec2, childMeasureSpec);
        this.f35317l.measure(childMeasureSpec2, childMeasureSpec);
        if (View.MeasureSpec.getMode(i11) == 1073741824) {
            max = View.MeasureSpec.getSize(i11);
        } else {
            max = Math.max(getMinHeight(), this.f35316k.getMeasuredHeight() + paddingBottom);
        }
        setMeasuredDimension(size, View.resolveSizeAndState(max, i11, this.f35316k.getMeasuredState() << 16));
    }
}
