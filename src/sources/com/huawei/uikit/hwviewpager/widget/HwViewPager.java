package com.huawei.uikit.hwviewpager.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.collection.ArrayMap;
import androidx.core.content.ContextCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import androidx.customview.view.AbsSavedState;
import com.huawei.appgallery.agd.agdpro.R$attr;
import com.huawei.appgallery.agd.agdpro.R$color;
import com.huawei.appgallery.agd.agdpro.R$style;
import com.huawei.appgallery.agd.agdpro.R$styleable;
import com.huawei.dynamicanimation.DynamicAnimation;
import com.huawei.dynamicanimation.HWSpringAnimation;
import com.huawei.dynamicanimation.SpringModel;
import com.huawei.dynamicanimation.interpolator.SpringInterpolator;
import com.huawei.dynamicanimation.util.DynamicCurveRate;
import com.huawei.openalliance.ad.constant.u;
import com.huawei.uikit.hwcommon.utils.HwReflectUtil;
import com.huawei.uikit.hwresources.utils.HwWidgetCompat;
import com.huawei.uikit.hwresources.utils.HwWidgetInstantiator;
import com.huawei.uikit.hwunifiedinteract.widget.HwGenericEventDetector;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class HwViewPager extends ViewGroup {
    public static final int A = 0;
    public static final int B = 1;
    public static final int C = 2;
    public static final int D = 1000;
    public static final int E = 4;
    public static final boolean F = false;
    public static final int G = 2;
    public static final int H = -1;
    public static final float I = 1.4f;
    public static final float J = 1.4f;
    public static final float K = 1.0f;
    public static final float L = 0.3f;
    public static final int M = 2;
    public static final int N = 300;
    public static final int O = 255;
    public static final int PAGE_SCROLL_HORIZONTAL = 0;
    public static final int PAGE_SCROLL_VERTICAL = 1;
    public static final int Q = 1;
    public static final int R = 2;
    public static final long S = 700;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    public static final long T = 300;

    /* renamed from: b, reason: collision with root package name */
    public static final String f35332b = "HwViewPager";

    /* renamed from: c, reason: collision with root package name */
    public static final int f35333c = 15;

    /* renamed from: d, reason: collision with root package name */
    public static final int f35334d = 2;

    /* renamed from: e, reason: collision with root package name */
    public static final int f35335e = 1;

    /* renamed from: f, reason: collision with root package name */
    public static final int f35336f = 10;

    /* renamed from: g, reason: collision with root package name */
    public static final int f35337g = 1200;

    /* renamed from: h, reason: collision with root package name */
    public static final float f35338h = 228.0f;

    /* renamed from: i, reason: collision with root package name */
    public static final float f35339i = 30.0f;

    /* renamed from: j, reason: collision with root package name */
    public static final float f35340j = 0.5f;

    /* renamed from: k, reason: collision with root package name */
    public static final float f35341k = 0.6f;

    /* renamed from: l, reason: collision with root package name */
    public static final int f35342l = 100;

    /* renamed from: m, reason: collision with root package name */
    public static final float f35343m = 0.3f;

    /* renamed from: n, reason: collision with root package name */
    public static final float f35344n = 2.0f;

    /* renamed from: o, reason: collision with root package name */
    public static final boolean f35345o = false;

    /* renamed from: p, reason: collision with root package name */
    public static final boolean f35346p = false;

    /* renamed from: q, reason: collision with root package name */
    public static final float f35347q = 0.5f;

    /* renamed from: r, reason: collision with root package name */
    public static final int f35348r = 2;

    /* renamed from: s, reason: collision with root package name */
    public static final int f35349s = 600;

    /* renamed from: t, reason: collision with root package name */
    public static final int f35350t = 25;

    /* renamed from: u, reason: collision with root package name */
    public static final int f35351u = 16;

    /* renamed from: v, reason: collision with root package name */
    public static final int f35352v = 400;

    /* renamed from: w, reason: collision with root package name */
    public static final float f35353w = 1.0E-6f;

    /* renamed from: x, reason: collision with root package name */
    public static final int f35354x = -1;

    /* renamed from: y, reason: collision with root package name */
    public static final int f35355y = 1;

    /* renamed from: z, reason: collision with root package name */
    public static final int f35356z = 2;
    public int Aa;
    public HWSpringAnimation Ab;
    public int Ba;
    public DynamicAnimation.OnAnimationEndListener Bb;
    public boolean Ca;
    public DynamicAnimation.OnAnimationUpdateListener Cb;
    public boolean Da;
    public HwGenericEventDetector Db;
    public boolean Ea;
    public boolean Eb;
    public boolean Fa;
    public boolean Fb;
    public int Ga;
    public int Gb;
    public boolean Ha;
    public ViewGroupOverlay Hb;
    public boolean Ia;
    public Drawable Ib;
    public int Ja;
    public int Jb;
    public int Ka;
    public Interpolator Kb;
    public int La;
    public float Ma;
    public float Na;
    public float Oa;
    public float Pa;
    public float Qa;
    public int Ra;
    public VelocityTracker Sa;
    public int Ta;
    public int Ua;
    public int Va;
    public int Wa;
    public boolean Xa;
    public long Ya;
    public EdgeEffect Za;
    public EdgeEffect _a;

    /* renamed from: aa, reason: collision with root package name */
    public HwPagerAdapter f35357aa;

    /* renamed from: ab, reason: collision with root package name */
    public boolean f35358ab;

    /* renamed from: ba, reason: collision with root package name */
    public int f35359ba;

    /* renamed from: bb, reason: collision with root package name */
    public boolean f35360bb;

    /* renamed from: ca, reason: collision with root package name */
    public int f35361ca;

    /* renamed from: cb, reason: collision with root package name */
    public boolean f35362cb;

    /* renamed from: da, reason: collision with root package name */
    public int f35363da;

    /* renamed from: db, reason: collision with root package name */
    public int f35364db;

    /* renamed from: ea, reason: collision with root package name */
    public int f35365ea;

    /* renamed from: eb, reason: collision with root package name */
    public List<OnPageChangeListener> f35366eb;

    /* renamed from: fa, reason: collision with root package name */
    public final ArrayList<ItemInfo> f35367fa;

    /* renamed from: fb, reason: collision with root package name */
    public OnPageChangeListener f35368fb;

    /* renamed from: ga, reason: collision with root package name */
    public final ItemInfo f35369ga;

    /* renamed from: gb, reason: collision with root package name */
    public OnPageChangeListener f35370gb;

    /* renamed from: ha, reason: collision with root package name */
    public final Rect f35371ha;

    /* renamed from: hb, reason: collision with root package name */
    public List<OnAdapterChangeListener> f35372hb;

    /* renamed from: ia, reason: collision with root package name */
    public final Map<OnPageChangeListener, c> f35373ia;

    /* renamed from: ib, reason: collision with root package name */
    public PageTransformer f35374ib;

    /* renamed from: ja, reason: collision with root package name */
    public final Runnable f35375ja;

    /* renamed from: jb, reason: collision with root package name */
    public int f35376jb;

    /* renamed from: ka, reason: collision with root package name */
    public int f35377ka;

    /* renamed from: kb, reason: collision with root package name */
    public int f35378kb;

    /* renamed from: la, reason: collision with root package name */
    public Parcelable f35379la;

    /* renamed from: lb, reason: collision with root package name */
    public ArrayList<View> f35380lb;

    /* renamed from: ma, reason: collision with root package name */
    public ClassLoader f35381ma;

    /* renamed from: mb, reason: collision with root package name */
    public int f35382mb;

    /* renamed from: na, reason: collision with root package name */
    public Scroller f35383na;

    /* renamed from: nb, reason: collision with root package name */
    public boolean f35384nb;

    /* renamed from: oa, reason: collision with root package name */
    public boolean f35385oa;

    /* renamed from: ob, reason: collision with root package name */
    public boolean f35386ob;

    /* renamed from: pa, reason: collision with root package name */
    public b f35387pa;

    /* renamed from: pb, reason: collision with root package name */
    public boolean f35388pb;

    /* renamed from: qa, reason: collision with root package name */
    public int f35389qa;

    /* renamed from: qb, reason: collision with root package name */
    public boolean f35390qb;

    /* renamed from: ra, reason: collision with root package name */
    public Drawable f35391ra;

    /* renamed from: rb, reason: collision with root package name */
    public float f35392rb;

    /* renamed from: sa, reason: collision with root package name */
    public int f35393sa;

    /* renamed from: sb, reason: collision with root package name */
    public float f35394sb;

    /* renamed from: ta, reason: collision with root package name */
    public int f35395ta;

    /* renamed from: tb, reason: collision with root package name */
    public boolean f35396tb;

    /* renamed from: ua, reason: collision with root package name */
    public int f35397ua;

    /* renamed from: ub, reason: collision with root package name */
    public boolean f35398ub;

    /* renamed from: va, reason: collision with root package name */
    public int f35399va;

    /* renamed from: vb, reason: collision with root package name */
    public boolean f35400vb;

    /* renamed from: wa, reason: collision with root package name */
    public float f35401wa;

    /* renamed from: wb, reason: collision with root package name */
    public int f35402wb;

    /* renamed from: xa, reason: collision with root package name */
    public float f35403xa;

    /* renamed from: xb, reason: collision with root package name */
    public ValueAnimator f35404xb;

    /* renamed from: ya, reason: collision with root package name */
    public float f35405ya;

    /* renamed from: yb, reason: collision with root package name */
    public HwPagerAdapter f35406yb;

    /* renamed from: za, reason: collision with root package name */
    public float f35407za;

    /* renamed from: zb, reason: collision with root package name */
    public boolean f35408zb;

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f35331a = {16842931};
    public static final int P = R$color.hwviewpager_shadow_color;
    public static final d U = new d();
    public static final Comparator<ItemInfo> V = new e();
    public static final Interpolator W = new f();

    @Target({ElementType.TYPE})
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public @interface DecorView {
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class ItemInfo {

        /* renamed from: a, reason: collision with root package name */
        public Object f35409a;

        /* renamed from: b, reason: collision with root package name */
        public int f35410b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f35411c;

        /* renamed from: d, reason: collision with root package name */
        public float f35412d;

        /* renamed from: e, reason: collision with root package name */
        public float f35413e;

        public float getOffset() {
            return this.f35413e;
        }

        public int getPosition() {
            return this.f35410b;
        }

        public float getWidthFactor() {
            return this.f35412d;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface OnAdapterChangeListener {
        void onAdapterChanged(@NonNull HwViewPager hwViewPager, @Nullable HwPagerAdapter hwPagerAdapter, @Nullable HwPagerAdapter hwPagerAdapter2);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface OnPageChangeListener {
        void onPageScrollStateChanged(int i10);

        void onPageScrolled(int i10, float f10, @Px int i11);

        void onPageSelected(int i10);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface PageTransformer {
        void transformPage(@NonNull View view, float f10);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new m();

        /* renamed from: a, reason: collision with root package name */
        public int f35421a;

        /* renamed from: b, reason: collision with root package name */
        public Parcelable f35422b;

        /* renamed from: c, reason: collision with root package name */
        public ClassLoader f35423c;

        public SavedState(@NonNull Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            StringBuilder b4 = e9.a.b("FragmentPager.SavedState{");
            b4.append(Integer.toHexString(System.identityHashCode(this)));
            b4.append(" position=");
            b4.append(this.f35421a);
            b4.append(com.alipay.sdk.util.i.f4738d);
            return b4.toString();
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f35421a);
            parcel.writeParcelable(this.f35422b, i10);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            classLoader = classLoader == null ? SavedState.class.getClassLoader() : classLoader;
            this.f35421a = parcel.readInt();
            this.f35422b = parcel.readParcelable(classLoader);
            this.f35423c = classLoader;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class SimpleOnPageChangeListener implements OnPageChangeListener {
        @Override // com.huawei.uikit.hwviewpager.widget.HwViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i10) {
        }

        @Override // com.huawei.uikit.hwviewpager.widget.HwViewPager.OnPageChangeListener
        public void onPageScrolled(int i10, float f10, int i11) {
        }

        @Override // com.huawei.uikit.hwviewpager.widget.HwViewPager.OnPageChangeListener
        public void onPageSelected(int i10) {
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class a extends AccessibilityDelegateCompat {
        public a() {
        }

        private boolean a() {
            HwPagerAdapter hwPagerAdapter = HwViewPager.this.f35357aa;
            return hwPagerAdapter != null && hwPagerAdapter.getCount() > 1;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(@NonNull View view, @NonNull AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(HwViewPager.class.getName());
            accessibilityEvent.setScrollable(a());
            if (accessibilityEvent.getEventType() == 4096) {
                HwViewPager hwViewPager = HwViewPager.this;
                if (hwViewPager.f35357aa != null) {
                    accessibilityEvent.setItemCount(hwViewPager.getRealCount());
                    accessibilityEvent.setFromIndex(HwViewPager.this.getCurrentItem());
                    accessibilityEvent.setToIndex(HwViewPager.this.getCurrentItem());
                }
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(@NonNull View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setClassName(HwViewPager.class.getName());
            accessibilityNodeInfoCompat.setScrollable(a());
            if ((HwViewPager.this.isPageScrollHorizontal() && HwViewPager.this.canScrollHorizontally(1)) || (!HwViewPager.this.isPageScrollHorizontal() && HwViewPager.this.canScrollVertically(1))) {
                accessibilityNodeInfoCompat.addAction(4096);
            }
            if (!(HwViewPager.this.isPageScrollHorizontal() && HwViewPager.this.canScrollHorizontally(-1)) && (HwViewPager.this.isPageScrollHorizontal() || !HwViewPager.this.canScrollVertically(-1))) {
                return;
            }
            accessibilityNodeInfoCompat.addAction(8192);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View view, int i10, Bundle bundle) {
            if (super.performAccessibilityAction(view, i10, bundle)) {
                return true;
            }
            if (i10 == 4096) {
                if (!(HwViewPager.this.isPageScrollHorizontal() && HwViewPager.this.canScrollHorizontally(1)) && (HwViewPager.this.isPageScrollHorizontal() || !HwViewPager.this.canScrollVertically(1))) {
                    return false;
                }
                HwViewPager.this.Fb = false;
                HwViewPager hwViewPager = HwViewPager.this;
                hwViewPager.setCurrentItem(hwViewPager.getCurrentItem() + 1);
                HwViewPager.this.Fb = true;
                return true;
            }
            if (i10 != 8192) {
                return false;
            }
            if (!(HwViewPager.this.isPageScrollHorizontal() && HwViewPager.this.canScrollHorizontally(-1)) && (HwViewPager.this.isPageScrollHorizontal() || !HwViewPager.this.canScrollVertically(-1))) {
                return false;
            }
            HwViewPager.this.Fb = false;
            HwViewPager hwViewPager2 = HwViewPager.this;
            hwViewPager2.setCurrentItem(hwViewPager2.getCurrentItem() - 1);
            HwViewPager.this.Fb = true;
            return true;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class b extends DataSetObserver {
        public b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            HwViewPager.this.a();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            HwViewPager.this.a();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class c implements OnPageChangeListener {

        /* renamed from: a, reason: collision with root package name */
        public static final int f35426a = -1;

        /* renamed from: b, reason: collision with root package name */
        @NonNull
        public final OnPageChangeListener f35427b;

        /* renamed from: c, reason: collision with root package name */
        public int f35428c;

        /* renamed from: d, reason: collision with root package name */
        public float f35429d;

        /* renamed from: e, reason: collision with root package name */
        public float f35430e;

        public /* synthetic */ c(HwViewPager hwViewPager, OnPageChangeListener onPageChangeListener, e eVar) {
            this(onPageChangeListener);
        }

        private boolean a(float f10, int i10, int i11, int i12) {
            if (!HwViewPager.this.f35386ob) {
                return false;
            }
            if (i11 != i12 - 1) {
                this.f35427b.onPageScrolled(this.f35428c, f10, i10);
            } else {
                OnPageChangeListener onPageChangeListener = this.f35427b;
                int i13 = this.f35428c;
                if (f10 > 0.0f) {
                    f10 = 1.0f - f10;
                }
                onPageChangeListener.onPageScrolled(i13, f10, i10);
            }
            return true;
        }

        @Override // com.huawei.uikit.hwviewpager.widget.HwViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i10) {
            if (HwViewPager.this.f35384nb) {
                return;
            }
            HwPagerAdapter currentAdapter = HwViewPager.this.getCurrentAdapter();
            if (currentAdapter != null) {
                HwViewPager hwViewPager = HwViewPager.this;
                int i11 = hwViewPager.f35359ba;
                int c4 = ((currentAdapter instanceof com.huawei.uikit.hwviewpager.widget.d) && hwViewPager.f35386ob) ? ((com.huawei.uikit.hwviewpager.widget.d) currentAdapter).c(i11) : i11;
                if (HwViewPager.this.f35386ob && i10 != 2 && (i11 <= HwViewPager.this.f35365ea || i11 >= currentAdapter.getCount() - HwViewPager.this.f35363da)) {
                    HwViewPager.this.b(c4, false);
                }
            }
            this.f35427b.onPageScrollStateChanged(i10);
        }

        @Override // com.huawei.uikit.hwviewpager.widget.HwViewPager.OnPageChangeListener
        public void onPageScrolled(int i10, float f10, int i11) {
            int i12;
            if (HwViewPager.this.f35384nb) {
                return;
            }
            HwPagerAdapter currentAdapter = HwViewPager.this.getCurrentAdapter();
            if (currentAdapter != null) {
                if ((currentAdapter instanceof com.huawei.uikit.hwviewpager.widget.d) && HwViewPager.this.f35386ob) {
                    com.huawei.uikit.hwviewpager.widget.d dVar = (com.huawei.uikit.hwviewpager.widget.d) currentAdapter;
                    i12 = dVar.c(i10);
                    dVar.c();
                } else {
                    currentAdapter.getCount();
                    i12 = i10;
                }
                if (HwViewPager.this.f35386ob && f10 == 0.0f && this.f35429d == 0.0f && (i10 <= HwViewPager.this.f35365ea || i10 >= currentAdapter.getCount() - HwViewPager.this.f35363da)) {
                    HwViewPager.this.b(i12, false);
                }
                i10 = i12;
            }
            this.f35429d = f10;
            this.f35428c = i10;
            this.f35427b.onPageScrolled(i10, f10, i11);
        }

        @Override // com.huawei.uikit.hwviewpager.widget.HwViewPager.OnPageChangeListener
        public void onPageSelected(int i10) {
            if (HwViewPager.this.f35384nb) {
                return;
            }
            HwPagerAdapter currentAdapter = HwViewPager.this.getCurrentAdapter();
            if ((currentAdapter instanceof com.huawei.uikit.hwviewpager.widget.d) && HwViewPager.this.f35386ob) {
                i10 = ((com.huawei.uikit.hwviewpager.widget.d) currentAdapter).c(i10);
            }
            float f10 = i10;
            if (this.f35430e != f10) {
                this.f35430e = f10;
                this.f35427b.onPageSelected(i10);
            }
        }

        public c(@NonNull OnPageChangeListener onPageChangeListener) {
            this.f35429d = -1.0f;
            this.f35430e = -1.0f;
            this.f35427b = onPageChangeListener;
            this.f35428c = -1;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class d implements Comparator<View> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(@NonNull View view, @NonNull View view2) {
            if (!((view.getLayoutParams() instanceof LayoutParams) && (view2.getLayoutParams() instanceof LayoutParams))) {
                return 0;
            }
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
            boolean z10 = layoutParams.isDecor;
            if (z10 != layoutParams2.isDecor) {
                return z10 ? 1 : -1;
            }
            return layoutParams.f35416c - layoutParams2.f35416c;
        }
    }

    public HwViewPager(@NonNull Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HwPagerAdapter getCurrentAdapter() {
        return this.f35357aa;
    }

    private float getCurrentAnimationPosition() {
        HWSpringAnimation hWSpringAnimation = this.Ab;
        if (hWSpringAnimation == null || !hWSpringAnimation.isRunning()) {
            return 0.0f;
        }
        return this.Ab.getSpringModel().getPosition();
    }

    private float getEndAnimationPosition() {
        HWSpringAnimation hWSpringAnimation = this.Ab;
        if (hWSpringAnimation == null || !hWSpringAnimation.isRunning()) {
            return 0.0f;
        }
        return this.Ab.getSpringModel().getEndPosition();
    }

    private int getNewAnimationScrollX() {
        if (!isPageScrollHorizontal()) {
            return getScrollX();
        }
        if (this.f35390qb) {
            HWSpringAnimation hWSpringAnimation = this.Ab;
            if (hWSpringAnimation != null && hWSpringAnimation.isRunning()) {
                int currentAnimationPosition = (int) getCurrentAnimationPosition();
                cancelAnimation();
                setScrollingCacheEnabled(false);
                return currentAnimationPosition;
            }
            return getScrollX();
        }
        Scroller scroller = this.f35383na;
        if ((scroller == null || scroller.isFinished()) ? false : true) {
            int currX = this.f35385oa ? this.f35383na.getCurrX() : this.f35383na.getStartX();
            this.f35383na.abortAnimation();
            setScrollingCacheEnabled(false);
            return currX;
        }
        return getScrollX();
    }

    private int getNewAnimationScrollY() {
        if (isPageScrollHorizontal()) {
            return getScrollY();
        }
        if (this.f35390qb) {
            HWSpringAnimation hWSpringAnimation = this.Ab;
            if (hWSpringAnimation != null && hWSpringAnimation.isRunning()) {
                int currentAnimationPosition = (int) getCurrentAnimationPosition();
                cancelAnimation();
                setScrollingCacheEnabled(false);
                return currentAnimationPosition;
            }
            return getScrollY();
        }
        Scroller scroller = this.f35383na;
        if ((scroller == null || scroller.isFinished()) ? false : true) {
            int currY = this.f35385oa ? this.f35383na.getCurrY() : this.f35383na.getStartY();
            this.f35383na.abortAnimation();
            setScrollingCacheEnabled(false);
            return currY;
        }
        return getScrollY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRealCount() {
        HwPagerAdapter hwPagerAdapter = this.f35357aa;
        if ((hwPagerAdapter instanceof com.huawei.uikit.hwviewpager.widget.d) && this.f35386ob) {
            return ((com.huawei.uikit.hwviewpager.widget.d) hwPagerAdapter).c();
        }
        return hwPagerAdapter.getCount();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x006e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void i() {
        /*
            r10 = this;
            int r0 = r10.getScrollY()
            int r1 = r10.getPaddingTop()
            int r2 = r10.getPaddingBottom()
            int r3 = r10.getHeight()
            int r4 = r10.getChildCount()
            r5 = 0
        L15:
            if (r5 >= r4) goto L75
            android.view.View r6 = r10.getChildAt(r5)
            if (r6 != 0) goto L1e
            goto L72
        L1e:
            android.view.ViewGroup$LayoutParams r7 = r6.getLayoutParams()
            boolean r7 = r7 instanceof com.huawei.uikit.hwviewpager.widget.HwViewPager.LayoutParams
            if (r7 != 0) goto L27
            goto L72
        L27:
            android.view.ViewGroup$LayoutParams r7 = r6.getLayoutParams()
            com.huawei.uikit.hwviewpager.widget.HwViewPager$LayoutParams r7 = (com.huawei.uikit.hwviewpager.widget.HwViewPager.LayoutParams) r7
            boolean r8 = r7.isDecor
            if (r8 != 0) goto L32
            goto L72
        L32:
            int r7 = r7.gravity
            r7 = r7 & 112(0x70, float:1.57E-43)
            r8 = 16
            if (r7 == r8) goto L57
            r8 = 48
            if (r7 == r8) goto L51
            r8 = 80
            if (r7 == r8) goto L44
            r7 = r1
            goto L66
        L44:
            int r7 = r3 - r2
            int r8 = r6.getMeasuredHeight()
            int r7 = r7 - r8
            int r8 = r6.getMeasuredHeight()
            int r2 = r2 + r8
            goto L63
        L51:
            int r7 = r6.getHeight()
            int r7 = r7 + r1
            goto L66
        L57:
            int r7 = r6.getMeasuredHeight()
            int r7 = r3 - r7
            int r7 = r7 / 2
            int r7 = java.lang.Math.max(r7, r1)
        L63:
            r9 = r7
            r7 = r1
            r1 = r9
        L66:
            int r1 = r1 + r0
            int r8 = r6.getTop()
            int r1 = r1 - r8
            if (r1 == 0) goto L71
            r6.offsetTopAndBottom(r1)
        L71:
            r1 = r7
        L72:
            int r5 = r5 + 1
            goto L15
        L75:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.uikit.hwviewpager.widget.HwViewPager.i():void");
    }

    @Nullable
    public static HwViewPager instantiate(@NonNull Context context) {
        Object instantiate = HwWidgetInstantiator.instantiate(context, HwWidgetInstantiator.getDeviceClassName(context, HwViewPager.class, HwWidgetInstantiator.getCurrentType(context, 15, 1)), HwViewPager.class);
        if (instantiate instanceof HwViewPager) {
            return (HwViewPager) instantiate;
        }
        return null;
    }

    private void j() {
        this.Ha = false;
        this.Ia = false;
        VelocityTracker velocityTracker = this.Sa;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.Sa = null;
        }
    }

    private void k() {
        HWSpringAnimation hWSpringAnimation = this.Ab;
        if (hWSpringAnimation != null && hWSpringAnimation.isRunning()) {
            q();
            this.Ab.removeEndListener(this.Bb);
            this.Ab.removeUpdateListener(this.Cb);
            this.Ab.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l() {
        this.f35400vb = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m() {
        this.f35400vb = true;
    }

    private void n() {
        if (isPageScrollHorizontal()) {
            this.f35383na.setFinalX(getClientWidth() * (isRtlLayout() ? -this.f35359ba : this.f35359ba));
        } else {
            this.f35383na.setFinalY(getClientHeight() * this.f35359ba);
        }
    }

    private void o() {
        int velocity = (int) this.Ab.getSpringModel().getVelocity();
        if (isPageScrollHorizontal()) {
            this.Ab.reset().setObj(this, DynamicAnimation.SCROLL_X, this.f35394sb, this.f35392rb, getClientWidth() * (isRtlLayout() ? -this.f35359ba : this.f35359ba), velocity);
        } else {
            this.Ab.reset().setObj(this, DynamicAnimation.SCROLL_Y, this.f35394sb, this.f35392rb, getClientHeight() * this.f35359ba, velocity);
        }
    }

    private void p() {
        int i10 = 0;
        while (i10 < getChildCount()) {
            if (!((LayoutParams) getChildAt(i10).getLayoutParams()).isDecor) {
                removeViewAt(i10);
                i10--;
            }
            i10++;
        }
    }

    private void q() {
        int ceil;
        int i10;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        float endAnimationPosition = getEndAnimationPosition() - getCurrentAnimationPosition();
        if (isPageScrollHorizontal()) {
            i10 = ((int) Math.ceil(endAnimationPosition)) + scrollX;
            ceil = scrollY;
        } else {
            ceil = ((int) Math.ceil(endAnimationPosition)) + scrollY;
            i10 = scrollX;
        }
        if (scrollX != i10) {
            scrollTo(i10, ceil);
            pageScrolled(i10);
        } else if (scrollY != ceil) {
            scrollTo(i10, ceil);
            pageScrolled(ceil);
        }
    }

    private void r() {
        this.Ab.addEndListener(this.Bb);
        this.Ab.addUpdateListener(this.Cb);
    }

    private boolean s() {
        this.Ra = -1;
        j();
        this.Za.onRelease();
        this._a.onRelease();
        return this.Za.isFinished() || this._a.isFinished();
    }

    private void setAdapterInner(@Nullable HwPagerAdapter hwPagerAdapter) {
        HwPagerAdapter hwPagerAdapter2 = this.f35357aa;
        if (hwPagerAdapter2 != null) {
            hwPagerAdapter2.a(null);
            this.f35357aa.startUpdate(this);
            for (int i10 = 0; i10 < this.f35367fa.size(); i10++) {
                ItemInfo itemInfo = this.f35367fa.get(i10);
                this.f35357aa.destroyItem(this, itemInfo.f35410b, itemInfo.f35409a);
            }
            this.f35357aa.finishUpdate(this);
            this.f35367fa.clear();
            p();
            this.f35359ba = 0;
            scrollTo(0, 0);
        }
        HwPagerAdapter hwPagerAdapter3 = this.f35357aa;
        this.f35357aa = hwPagerAdapter;
        this.f35361ca = 0;
        if (hwPagerAdapter != null) {
            if (this.f35387pa == null) {
                this.f35387pa = new b();
            }
            this.f35357aa.a(this.f35387pa);
            this.Fa = false;
            boolean z10 = this.f35358ab;
            this.f35358ab = true;
            this.f35361ca = this.f35357aa.getCount();
            if (this.f35377ka >= 0) {
                this.f35357aa.restoreState(this.f35379la, this.f35381ma);
                setCurrentItemInternal(this.f35377ka, false, true);
                this.f35377ka = -1;
                this.f35379la = null;
                this.f35381ma = null;
            } else if (!z10) {
                e();
            } else {
                requestLayout();
            }
        }
        List<OnAdapterChangeListener> list = this.f35372hb;
        if (list == null || list.isEmpty()) {
            return;
        }
        int size = this.f35372hb.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.f35372hb.get(i11).onAdapterChanged(this, hwPagerAdapter3, hwPagerAdapter);
        }
    }

    private void setCurrentItemWithoutNotification(int i10) {
        this.f35384nb = true;
        a(i10, false);
        this.f35384nb = false;
    }

    private void setScrollingCacheEnabled(boolean z10) {
        if (this.Ea != z10) {
            this.Ea = z10;
        }
    }

    private void setSensitivityMode(int i10) {
        if (i10 == 0) {
            this.Qa = 1.4f;
        } else if (i10 == 2) {
            this.Qa = 1.0f;
        } else {
            this.Qa = 1.4f;
        }
    }

    private void setValueFromPlume(@NonNull Context context) {
        Method method = HwReflectUtil.getMethod("getBoolean", new Class[]{Context.class, View.class, String.class, Boolean.TYPE}, "huawei.android.widget.HwPlume");
        if (method == null) {
            return;
        }
        Object invokeMethod = HwReflectUtil.invokeMethod(null, method, new Object[]{context, this, "changePageEnabled", Boolean.TRUE});
        if (invokeMethod instanceof Boolean) {
            setExtendedChangePageEnabled(((Boolean) invokeMethod).booleanValue());
        }
    }

    private void t() {
        if (this.f35378kb != 0) {
            ArrayList<View> arrayList = this.f35380lb;
            if (arrayList == null) {
                this.f35380lb = new ArrayList<>();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                this.f35380lb.add(getChildAt(i10));
            }
            Collections.sort(this.f35380lb, U);
        }
    }

    private void u() {
        this.f35404xb.setDuration(300L);
        this.f35404xb.addUpdateListener(new j(this));
        this.f35404xb.setInterpolator(this.Kb);
        this.f35404xb.start();
    }

    private void v() {
        if (this.Ib == null) {
            return;
        }
        ValueAnimator valueAnimator = this.f35404xb;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f35404xb.cancel();
        }
        this.f35404xb = ValueAnimator.ofFloat(this.f35401wa, this.f35403xa);
        u();
    }

    private void w() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.f35403xa, this.f35401wa);
        this.f35404xb = ofFloat;
        ofFloat.setDuration(300L);
        this.f35404xb.addUpdateListener(new k(this));
        this.f35404xb.setInterpolator(this.Kb);
        this.f35404xb.start();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(@NonNull ArrayList<View> arrayList, int i10, int i11) {
        ItemInfo b4;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i12 = 0; i12 < getChildCount(); i12++) {
                View childAt = getChildAt(i12);
                if (childAt.getVisibility() == 0 && (b4 = b(childAt)) != null && b4.f35410b == this.f35359ba) {
                    childAt.addFocusables(arrayList, i10, i11);
                }
            }
        }
        if ((descendantFocusability != 262144 || size == arrayList.size()) && isFocusable()) {
            if ((i11 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode()) {
                return;
            }
            arrayList.add(this);
        }
    }

    public void addOnAdapterChangeListener(@NonNull OnAdapterChangeListener onAdapterChangeListener) {
        if (this.f35372hb == null) {
            this.f35372hb = new ArrayList();
        }
        this.f35372hb.add(onAdapterChangeListener);
    }

    public void addOnPageChangeListener(@NonNull OnPageChangeListener onPageChangeListener) {
        if (this.f35386ob) {
            c cVar = new c(this, onPageChangeListener, null);
            this.f35373ia.put(onPageChangeListener, cVar);
            onPageChangeListener = cVar;
        }
        if (this.f35366eb == null) {
            this.f35366eb = new ArrayList();
        }
        this.f35366eb.add(onPageChangeListener);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        ItemInfo b4;
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() == 0 && (b4 = b(childAt)) != null && b4.f35410b == this.f35359ba) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(@NonNull View view, int i10, @Nullable ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        if (layoutParams instanceof LayoutParams) {
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            boolean d10 = layoutParams2.isDecor | d(view);
            layoutParams2.isDecor = d10;
            if (!this.Ca) {
                super.addView(view, i10, layoutParams);
            } else {
                if (!d10) {
                    layoutParams2.f35415b = true;
                    addViewInLayout(view, i10, layoutParams);
                    return;
                }
                throw new IllegalStateException("Cannot add pager decor view during layout");
            }
        }
    }

    public boolean arrowScroll(int i10) {
        View findFocus = findFocus();
        if (findFocus != this) {
            if (findFocus != null) {
                boolean z10 = false;
                ViewParent parent = findFocus.getParent();
                while (true) {
                    if (!(parent instanceof ViewGroup)) {
                        break;
                    }
                    if (parent == this) {
                        z10 = true;
                        break;
                    }
                    parent = parent.getParent();
                }
                if (!z10) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(findFocus.getClass().getSimpleName());
                    for (ViewParent parent2 = findFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                        sb2.append(" => ");
                        sb2.append(parent2.getClass().getSimpleName());
                    }
                    e9.a.b("arrowScroll tried to find focus based on non-child current focused view ").append(sb2.toString());
                }
            }
            return b(i10, findFocus);
        }
        findFocus = null;
        return b(i10, findFocus);
    }

    public boolean beginFakeDrag() {
        if (this.Ha) {
            return false;
        }
        this.Xa = true;
        setScrollState(1);
        if (isPageScrollHorizontal()) {
            this.Oa = 0.0f;
            this.Ma = 0.0f;
        } else {
            this.Pa = 0.0f;
            this.Na = 0.0f;
        }
        VelocityTracker velocityTracker = this.Sa;
        if (velocityTracker == null) {
            this.Sa = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, 0.0f, 0.0f, 0);
        this.Sa.addMovement(obtain);
        obtain.recycle();
        this.Ya = uptimeMillis;
        return true;
    }

    public boolean canScroll(@NonNull View view, boolean z10, int i10, int i11, int i12) {
        int i13;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i14 = i11 + scrollX;
                if (i14 >= childAt.getLeft() && i14 < childAt.getRight() && (i13 = i12 + scrollY) >= childAt.getTop() && i13 < childAt.getBottom() && canScroll(childAt, true, i10, i14 - childAt.getLeft(), i13 - childAt.getTop())) {
                    return true;
                }
            }
        }
        if (isPageScrollHorizontal()) {
            if (z10 && view.canScrollHorizontally(-i10)) {
                return true;
            }
        } else if (z10 && view.canScrollVertically(-i10)) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i10) {
        if (this.f35357aa == null) {
            return false;
        }
        int currentItem = getCurrentItem();
        int count = this.f35357aa.getCount();
        if (i10 < 0) {
            if (isRtlLayout()) {
                if (currentItem == count - 1) {
                    return false;
                }
            } else if (currentItem == 0) {
                return false;
            }
        } else {
            if (i10 <= 0) {
                return false;
            }
            if (isRtlLayout()) {
                if (currentItem == 0) {
                    return false;
                }
            } else if (currentItem == count - 1) {
                return false;
            }
        }
        return true;
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i10) {
        if (this.f35357aa == null) {
            return false;
        }
        int clientHeight = getClientHeight();
        int scrollY = getScrollY();
        return i10 < 0 ? scrollY > ((int) (((float) clientHeight) * this.f35405ya)) : i10 > 0 && scrollY < ((int) (((float) clientHeight) * this.f35407za));
    }

    public void cancelAnimation() {
        HWSpringAnimation hWSpringAnimation = this.Ab;
        if (hWSpringAnimation == null || !hWSpringAnimation.isRunning()) {
            return;
        }
        this.Ab.removeEndListener(this.Bb);
        this.Ab.removeUpdateListener(this.Cb);
        this.Ab.cancel();
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public void clearOnPageChangeListeners() {
        if (isRtlLayout()) {
            this.f35373ia.clear();
        }
        List<OnPageChangeListener> list = this.f35366eb;
        if (list != null) {
            list.clear();
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        this.f35385oa = true;
        if (!this.f35383na.isFinished() && this.f35383na.computeScrollOffset()) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.f35383na.getCurrX();
            int currY = this.f35383na.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                scrollTo(currX, currY);
                if (!pageScrolled(currX)) {
                    this.f35383na.abortAnimation();
                    scrollTo(0, currY);
                }
            }
            ViewCompat.postInvalidateOnAnimation(this);
            return;
        }
        if (this.f35390qb) {
            return;
        }
        a(true);
    }

    public HwGenericEventDetector createGenericEventDetector() {
        return new HwGenericEventDetector(getContext());
    }

    public HwGenericEventDetector.OnChangePageListener createOnChangePageListener() {
        return new h(this);
    }

    public HwGenericEventDetector.OnScrollListener createOnScrollListener() {
        return null;
    }

    public int determineTargetPage(int i10, float f10, int i11, int i12) {
        int b4;
        if (isPageScrollHorizontal()) {
            b4 = a(i10, f10, i11, i12);
        } else {
            b4 = b(i10, f10, i11, i12);
        }
        if (this.f35367fa.size() <= 0) {
            return b4;
        }
        return Math.max(this.f35367fa.get(0).f35410b, Math.min(b4, this.f35367fa.get(r4.size() - 1).f35410b));
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || executeKeyEvent(keyEvent);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        ItemInfo b4;
        if (accessibilityEvent == null) {
            return false;
        }
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() == 0 && (b4 = b(childAt)) != null && b4.f35410b == this.f35359ba && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        HwPagerAdapter hwPagerAdapter;
        if (canvas == null) {
            return;
        }
        super.draw(canvas);
        boolean z10 = false;
        int overScrollMode = getOverScrollMode();
        if (overScrollMode != 0 && (overScrollMode != 1 || (hwPagerAdapter = this.f35357aa) == null || hwPagerAdapter.getCount() <= 1)) {
            this.Za.finish();
            this._a.finish();
        } else {
            if (!this.Za.isFinished()) {
                int save = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate(getPaddingTop() + (-height), this.f35405ya * width);
                this.Za.setSize(height, width);
                z10 = false | this.Za.draw(canvas);
                canvas.restoreToCount(save);
            }
            if (!this._a.isFinished()) {
                int save2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate(-getPaddingTop(), (-(this.f35407za + 1.0f)) * width2);
                this._a.setSize(height2, width2);
                z10 |= this._a.draw(canvas);
                canvas.restoreToCount(save2);
            }
        }
        if (z10) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f35391ra;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        drawable.setState(getDrawableState());
    }

    public void endFakeDrag() {
        float yVelocity;
        if (this.Xa) {
            if (this.f35357aa != null && this.Ra != -1) {
                VelocityTracker velocityTracker = this.Sa;
                velocityTracker.computeCurrentVelocity(1000, this.Ua);
                if (isPageScrollHorizontal()) {
                    yVelocity = velocityTracker.getXVelocity(this.Ra);
                } else {
                    yVelocity = velocityTracker.getYVelocity(this.Ra);
                }
                int i10 = (int) yVelocity;
                this.Fa = true;
                if (isPageScrollHorizontal()) {
                    d(i10);
                } else {
                    e(i10);
                }
            }
            j();
            this.Xa = false;
            return;
        }
        throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    }

    public boolean executeKeyEvent(@NonNull KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 21) {
                if (keyEvent.hasModifiers(2)) {
                    return c();
                }
                return arrowScroll(17);
            }
            if (keyCode == 22) {
                if (keyEvent.hasModifiers(2)) {
                    return d();
                }
                return arrowScroll(66);
            }
            if (keyCode == 61) {
                if (keyEvent.hasNoModifiers()) {
                    return arrowScroll(2);
                }
                if (keyEvent.hasModifiers(1)) {
                    return arrowScroll(1);
                }
            }
        }
        return false;
    }

    public void fakeDragBy(float f10) {
        MotionEvent obtain;
        if (this.Xa) {
            if (this.f35357aa == null || this.f35367fa.size() <= 0) {
                return;
            }
            if (isPageScrollHorizontal()) {
                this.Ma += f10;
            } else {
                this.Na += f10;
            }
            float a10 = a((isPageScrollHorizontal() ? getScrollX() : getScrollY()) - f10, isPageScrollHorizontal() ? getClientWidth() : getClientHeight());
            if (isPageScrollHorizontal()) {
                int i10 = (int) a10;
                this.Ma = (a10 - i10) + this.Ma;
                scrollTo(i10, getScrollY());
            } else {
                int i11 = (int) a10;
                this.Na = (a10 - i11) + this.Na;
                scrollTo(getScrollX(), i11);
            }
            pageScrolled((int) a10);
            long uptimeMillis = SystemClock.uptimeMillis();
            if (isPageScrollHorizontal()) {
                obtain = MotionEvent.obtain(this.Ya, uptimeMillis, 2, this.Ma, 0.0f, 0);
            } else {
                obtain = MotionEvent.obtain(this.Ya, uptimeMillis, 2, 0.0f, this.Na, 0);
            }
            this.Sa.addMovement(obtain);
            obtain.recycle();
            return;
        }
        throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    @Nullable
    public HwPagerAdapter getAdapter() {
        HwPagerAdapter hwPagerAdapter = this.f35357aa;
        return hwPagerAdapter instanceof com.huawei.uikit.hwviewpager.widget.d ? ((com.huawei.uikit.hwviewpager.widget.d) hwPagerAdapter).b() : hwPagerAdapter;
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i10, int i11) {
        if (this.f35378kb == 2) {
            i11 = (i10 - 1) - i11;
        }
        if (this.f35380lb.size() == 0) {
            return 0;
        }
        if (i11 < 0) {
            i11 = 0;
        } else if (i11 >= this.f35380lb.size()) {
            i11 = this.f35380lb.size() - 1;
        }
        ViewGroup.LayoutParams layoutParams = this.f35380lb.get(i11).getLayoutParams();
        if (layoutParams instanceof LayoutParams) {
            return ((LayoutParams) layoutParams).f35417d;
        }
        return 0;
    }

    public int getClientHeight() {
        return (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
    }

    public int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    public int getCurrentItem() {
        int i10 = this.f35359ba;
        HwPagerAdapter hwPagerAdapter = this.f35357aa;
        return ((hwPagerAdapter instanceof com.huawei.uikit.hwviewpager.widget.d) && this.f35386ob) ? ((com.huawei.uikit.hwviewpager.widget.d) hwPagerAdapter).c(i10) : i10;
    }

    public float getEndShadowAlpha() {
        return this.f35403xa;
    }

    public float getHwSpringDamping() {
        return this.f35392rb;
    }

    public float getHwSpringStiffness() {
        return this.f35394sb;
    }

    public int getOffscreenPageLimit() {
        return this.Ga;
    }

    public int getPageMargin() {
        return this.f35389qa;
    }

    public int getPageScrollDirection() {
        return this.Gb;
    }

    public float getPageSwitchThreshold() {
        return this.f35390qb ? 0.5f : 0.6f;
    }

    public boolean getReverseDrawingOrder() {
        return this.Da;
    }

    public float getRotaryVelocity() {
        HwGenericEventDetector hwGenericEventDetector = this.Db;
        if (hwGenericEventDetector != null) {
            return hwGenericEventDetector.getVelocity();
        }
        return 0.0f;
    }

    public Scroller getScroller() {
        return this.f35383na;
    }

    public float getSensitivity() {
        HwGenericEventDetector hwGenericEventDetector = this.Db;
        if (hwGenericEventDetector != null) {
            return hwGenericEventDetector.getSensitivity();
        }
        return 1.4f;
    }

    public int getShadowColor() {
        return this.Jb;
    }

    public boolean getShadowEnable() {
        return this.f35408zb;
    }

    public float getStartShadowAlpha() {
        return this.f35401wa;
    }

    public ItemInfo infoForCurrentScrollPosition() {
        float f10;
        int i10;
        boolean z10 = isPageScrollHorizontal() && isRtlLayout();
        float clientWidth = isPageScrollHorizontal() ? getClientWidth() : getClientHeight();
        float f11 = 0.0f;
        if (clientWidth > 0.0f) {
            f10 = (isPageScrollHorizontal() ? getScrollX() : getScrollY()) / clientWidth;
        } else {
            f10 = 0.0f;
        }
        if (z10) {
            f10 = -f10;
        }
        float f12 = clientWidth > 0.0f ? this.f35389qa / clientWidth : 0.0f;
        ItemInfo itemInfo = null;
        float f13 = 0.0f;
        int i11 = -1;
        int i12 = 0;
        boolean z11 = true;
        while (i12 < this.f35367fa.size()) {
            ItemInfo itemInfo2 = this.f35367fa.get(i12);
            if (!z11 && itemInfo2.f35410b != (i10 = i11 + 1)) {
                itemInfo2 = this.f35369ga;
                itemInfo2.f35413e = f11 + f13 + f12;
                itemInfo2.f35410b = i10;
                itemInfo2.f35412d = isPageScrollHorizontal() ? this.f35357aa.getPageWidth(itemInfo2.f35410b) : this.f35357aa.getPageHeight(itemInfo2.f35410b);
                i12--;
            }
            f11 = itemInfo2.f35413e;
            float f14 = itemInfo2.f35412d + f11 + f12;
            if (!z11 && f10 < f11) {
                return itemInfo;
            }
            if (f10 < f14 || i12 == this.f35367fa.size() - 1) {
                return itemInfo2;
            }
            i11 = itemInfo2.f35410b;
            f13 = itemInfo2.f35412d;
            i12++;
            itemInfo = itemInfo2;
            z11 = false;
        }
        return itemInfo;
    }

    public boolean isAutoRtlLayoutEnabled() {
        return this.f35398ub;
    }

    public boolean isDynamicSpringAnimaitionEnabled() {
        return this.f35390qb;
    }

    public boolean isExtendedChangePageEnabled() {
        return this.Eb;
    }

    public boolean isFakeDragging() {
        return this.Xa;
    }

    public boolean isPageScrollHorizontal() {
        return this.Gb == 0;
    }

    public boolean isRtlLayout() {
        if (!this.f35398ub) {
            return false;
        }
        String language = Locale.getDefault().getLanguage();
        return (language.contains("ar") || language.contains("fa") || language.contains("iw")) || (language.contains("ug") || language.contains(u.cF));
    }

    public boolean isSpringInterpolatorEnable() {
        return this.f35396tb;
    }

    public boolean isSupportLoop() {
        return this.f35386ob;
    }

    public boolean isSupportRltLayout() {
        return isRtlLayout();
    }

    public void nextPage() {
        nextPage(true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f35358ab = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.f35375ja);
        Scroller scroller = this.f35383na;
        if (scroller != null && !scroller.isFinished()) {
            this.f35383na.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        float f10;
        float f11;
        super.onDraw(canvas);
        if (this.f35389qa <= 0 || this.f35391ra == null || this.f35367fa.size() <= 0 || this.f35357aa == null) {
            return;
        }
        int scrollX = isPageScrollHorizontal() ? getScrollX() : getScrollY();
        int width = isPageScrollHorizontal() ? getWidth() : getHeight();
        float f12 = width <= 0 ? 0.0f : this.f35389qa / width;
        ItemInfo itemInfo = this.f35367fa.get(0);
        float f13 = itemInfo.f35413e;
        int size = this.f35367fa.size();
        int i10 = itemInfo.f35410b;
        int i11 = this.f35367fa.get(size - 1).f35410b;
        int i12 = i10;
        int i13 = 0;
        while (i12 < i11) {
            ItemInfo itemInfo2 = itemInfo;
            int i14 = i13;
            while (i12 > itemInfo2.f35410b && i14 < size) {
                i14++;
                itemInfo2 = this.f35367fa.get(i14);
            }
            boolean z10 = isPageScrollHorizontal() && isRtlLayout();
            if (i12 == itemInfo2.f35410b) {
                float f14 = z10 ? -(itemInfo2.f35413e + itemInfo2.f35412d) : itemInfo2.f35413e + itemInfo2.f35412d;
                float f15 = width * f14;
                f10 = z10 ? f14 - f12 : f14 + f12;
                f11 = f15;
            } else {
                float pageWidth = isPageScrollHorizontal() ? this.f35357aa.getPageWidth(i12) : this.f35357aa.getPageHeight(i12);
                float f16 = (z10 ? f13 - pageWidth : f13 + pageWidth) * width;
                float f17 = pageWidth + f12;
                f10 = z10 ? f13 - f17 : f17 + f13;
                f11 = f16;
            }
            if (a(canvas, scrollX, width, f11, z10)) {
                return;
            }
            i12++;
            itemInfo = itemInfo2;
            i13 = i14;
            f13 = f10;
        }
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        HwGenericEventDetector hwGenericEventDetector;
        if (this.Eb && (hwGenericEventDetector = this.Db) != null) {
            if (hwGenericEventDetector.onGenericMotionEvent(motionEvent)) {
                return true;
            }
            return super.onGenericMotionEvent(motionEvent);
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        if (action != 3 && action != 1) {
            if (action != 0) {
                if (this.Ha) {
                    return true;
                }
                if (this.Ia) {
                    return false;
                }
            }
            if (action == 0) {
                if (this.f35408zb) {
                    v();
                }
                float x10 = motionEvent.getX();
                this.Oa = x10;
                this.Ma = x10;
                float y10 = motionEvent.getY();
                this.Pa = y10;
                this.Na = y10;
                this.Ra = motionEvent.getPointerId(0);
                this.Ia = false;
                this.f35385oa = true;
                this.f35383na.computeScrollOffset();
                if (this.f35390qb) {
                    float abs = Math.abs(getCurrentAnimationPosition());
                    float abs2 = Math.abs(getEndAnimationPosition());
                    if (this.f35382mb == 2 && Math.abs(abs - abs2) > this.Wa) {
                        this.f35383na.abortAnimation();
                        cancelAnimation();
                        this.Fa = false;
                        e();
                        this.Ha = true;
                        c(true);
                        setScrollState(1);
                    } else {
                        a(false);
                        this.Ha = false;
                    }
                } else {
                    boolean z10 = !isPageScrollHorizontal() ? Math.abs(this.f35383na.getFinalY() - this.f35383na.getCurrY()) <= this.Wa : Math.abs(this.f35383na.getFinalX() - this.f35383na.getCurrX()) <= this.Wa;
                    if (this.f35382mb == 2 && z10) {
                        this.f35383na.abortAnimation();
                        this.Fa = false;
                        e();
                        this.Ha = true;
                        c(true);
                        setScrollState(1);
                    } else {
                        a(false);
                        this.Ha = false;
                    }
                }
            } else if (action == 2) {
                int i10 = this.Ra;
                if (i10 != -1) {
                    if (isPageScrollHorizontal()) {
                        if (!c(motionEvent, i10)) {
                            return false;
                        }
                    } else if (!d(motionEvent, i10)) {
                        return false;
                    }
                }
            } else if (action == 6) {
                c(motionEvent);
            }
            if (this.Sa == null) {
                this.Sa = VelocityTracker.obtain();
            }
            this.Sa.addMovement(motionEvent);
            return this.Ha;
        }
        s();
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00f4  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onLayout(boolean r19, int r20, int r21, int r22, int r23) {
        /*
            Method dump skipped, instructions count: 333
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.uikit.hwviewpager.widget.HwViewPager.onLayout(boolean, int, int, int, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0084, code lost:
    
        if (r10 != (-1)) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x008c, code lost:
    
        if (r3 != (-1)) goto L42;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x008f  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onMeasure(int r14, int r15) {
        /*
            Method dump skipped, instructions count: 262
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.uikit.hwviewpager.widget.HwViewPager.onMeasure(int, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0052, code lost:
    
        r3 = true;
     */
    @androidx.annotation.CallSuper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onPageScrolled(int r5, float r6, int r7) {
        /*
            r4 = this;
            int r0 = r4.f35364db
            if (r0 <= 0) goto L11
            boolean r0 = r4.isPageScrollHorizontal()
            if (r0 == 0) goto Le
            r4.h()
            goto L11
        Le:
            r4.i()
        L11:
            r4.a(r5, r6, r7)
            com.huawei.uikit.hwviewpager.widget.HwViewPager$PageTransformer r5 = r4.f35374ib
            r6 = 1
            if (r5 == 0) goto L5b
            boolean r5 = r4.isPageScrollHorizontal()
            if (r5 == 0) goto L24
            int r5 = r4.getScrollX()
            goto L28
        L24:
            int r5 = r4.getScrollY()
        L28:
            int r7 = r4.getChildCount()
            r0 = 0
            r1 = 0
        L2e:
            if (r1 >= r7) goto L5b
            android.view.View r2 = r4.getChildAt(r1)
            android.view.ViewGroup$LayoutParams r3 = r2.getLayoutParams()
            com.huawei.uikit.hwviewpager.widget.HwViewPager$LayoutParams r3 = (com.huawei.uikit.hwviewpager.widget.HwViewPager.LayoutParams) r3
            boolean r3 = r3.isDecor
            if (r3 == 0) goto L3f
            goto L58
        L3f:
            boolean r3 = r4.isPageScrollHorizontal()
            if (r3 == 0) goto L4c
            int r3 = r4.getClientWidth()
            if (r3 <= 0) goto L54
            goto L52
        L4c:
            int r3 = r4.getClientHeight()
            if (r3 <= 0) goto L54
        L52:
            r3 = 1
            goto L55
        L54:
            r3 = 0
        L55:
            r4.a(r5, r2, r3)
        L58:
            int r1 = r1 + 1
            goto L2e
        L5b:
            r4.f35362cb = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.uikit.hwviewpager.widget.HwViewPager.onPageScrolled(int, float, int):void");
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i10, Rect rect) {
        int i11;
        int i12;
        int childCount = getChildCount();
        int i13 = -1;
        if ((i10 & 2) != 0) {
            i13 = childCount;
            i11 = 0;
            i12 = 1;
        } else {
            i11 = childCount - 1;
            i12 = -1;
        }
        while (i11 != i13) {
            if (a(i10, rect, i11)) {
                return true;
            }
            i11 += i12;
        }
        return false;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof RtlSavedState) {
            RtlSavedState rtlSavedState = (RtlSavedState) parcelable;
            Parcelable parcelable2 = rtlSavedState.f35418a;
            if (!(parcelable2 instanceof SavedState)) {
                super.onRestoreInstanceState(parcelable2);
                return;
            }
            SavedState savedState = (SavedState) parcelable2;
            super.onRestoreInstanceState(savedState.getSuperState());
            HwPagerAdapter hwPagerAdapter = this.f35357aa;
            if (hwPagerAdapter != null) {
                hwPagerAdapter.restoreState(savedState.f35422b, savedState.f35423c);
                setCurrentItemInternal(savedState.f35421a, false, true);
            } else {
                this.f35377ka = savedState.f35421a;
                this.f35379la = savedState.f35422b;
                this.f35381ma = savedState.f35423c;
            }
            if (rtlSavedState.f35420c != isRtlLayout()) {
                this.Fb = false;
                setCurrentItem(rtlSavedState.f35419b, false);
                this.Fb = true;
            }
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f35421a = this.f35359ba;
        HwPagerAdapter hwPagerAdapter = this.f35357aa;
        if (hwPagerAdapter != null) {
            savedState.f35422b = hwPagerAdapter.saveState();
        }
        return new RtlSavedState(savedState, this.f35359ba, isRtlLayout());
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        Drawable drawable = this.Ib;
        if (drawable != null && i11 != i13) {
            drawable.setBounds(0, 0, i10, i11);
        }
        if (isPageScrollHorizontal()) {
            if (i10 != i12) {
                d(i10, i12);
            }
        } else if (i11 != i13) {
            d(i11, i13);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        HwPagerAdapter hwPagerAdapter;
        int i10;
        boolean z10 = false;
        if (motionEvent == null) {
            return false;
        }
        if (this.Xa) {
            return true;
        }
        if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || (hwPagerAdapter = this.f35357aa) == null || hwPagerAdapter.getCount() == 0) {
            return false;
        }
        if (this.Sa == null) {
            this.Sa = VelocityTracker.obtain();
        }
        this.Sa.addMovement(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.f35383na.abortAnimation();
            cancelAnimation();
            this.Fa = false;
            e();
            float x10 = motionEvent.getX();
            this.Oa = x10;
            this.Ma = x10;
            float y10 = motionEvent.getY();
            this.Pa = y10;
            this.Na = y10;
            this.Ra = motionEvent.getPointerId(0);
        } else if (action == 1) {
            if (this.f35408zb && this.f35404xb != null) {
                w();
            }
            z10 = a(motionEvent, false);
        } else if (action == 2) {
            if (!this.Ha) {
                int i11 = this.Ra;
                if (i11 == -1) {
                    z10 = s();
                } else {
                    int findPointerIndex = motionEvent.findPointerIndex(i11);
                    if (findPointerIndex == -1) {
                        z10 = s();
                    } else if (isPageScrollHorizontal()) {
                        a(motionEvent, findPointerIndex);
                    } else {
                        b(motionEvent, findPointerIndex);
                    }
                }
            }
            if (this.Ha && (i10 = this.Ra) != -1) {
                int findPointerIndex2 = motionEvent.findPointerIndex(i10);
                z10 = false | performDrag((isPageScrollHorizontal() ? this.Ma : this.Na) - (isPageScrollHorizontal() ? motionEvent.getX(findPointerIndex2) : motionEvent.getY(findPointerIndex2)));
            }
        } else if (action != 3) {
            if (action == 5) {
                int actionIndex = motionEvent.getActionIndex();
                if (isPageScrollHorizontal()) {
                    this.Ma = motionEvent.getX(actionIndex);
                } else {
                    this.Na = motionEvent.getY(actionIndex);
                }
                this.Ra = motionEvent.getPointerId(actionIndex);
            } else if (action == 6) {
                c(motionEvent);
                if (this.Ra != -1) {
                    if (isPageScrollHorizontal()) {
                        this.Ma = motionEvent.getX(motionEvent.findPointerIndex(this.Ra));
                    } else {
                        this.Na = motionEvent.getY(motionEvent.findPointerIndex(this.Ra));
                    }
                }
            }
        } else if (this.Ha) {
            a(this.f35359ba, true, 0, false);
            z10 = s();
        }
        if (z10) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
        return true;
    }

    public boolean pageScrolled(int i10) {
        if (this.f35367fa.size() == 0) {
            if (this.f35358ab) {
                return false;
            }
            this.f35362cb = false;
            onPageScrolled(0, 0.0f, 0);
            if (this.f35362cb) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        ItemInfo infoForCurrentScrollPosition = infoForCurrentScrollPosition();
        if (infoForCurrentScrollPosition == null) {
            return false;
        }
        int clientWidth = isPageScrollHorizontal() ? getClientWidth() : getClientHeight();
        int i11 = this.f35389qa;
        int i12 = clientWidth + i11;
        float f10 = clientWidth <= 0 ? 0.0f : i11 / clientWidth;
        int i13 = infoForCurrentScrollPosition.f35410b;
        boolean z10 = clientWidth > 0 && infoForCurrentScrollPosition.f35412d + f10 > 0.0f;
        if (isPageScrollHorizontal() && isRtlLayout()) {
            i10 = -i10;
        }
        float f11 = z10 ? ((i10 / clientWidth) - infoForCurrentScrollPosition.f35413e) / (infoForCurrentScrollPosition.f35412d + f10) : 0.0f;
        this.f35362cb = false;
        onPageScrolled(i13, f11, (int) (i12 * f11));
        if (this.f35362cb) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    public boolean performDrag(float f10) {
        if (isPageScrollHorizontal()) {
            return d(f10);
        }
        return e(f10);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0060, code lost:
    
        if (r9 == r10) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0066, code lost:
    
        r8 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void populate(int r19) {
        /*
            Method dump skipped, instructions count: 646
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.uikit.hwviewpager.widget.HwViewPager.populate(int):void");
    }

    public void prePage() {
        prePage(true);
    }

    public void removeOnAdapterChangeListener(@NonNull OnAdapterChangeListener onAdapterChangeListener) {
        List<OnAdapterChangeListener> list = this.f35372hb;
        if (list != null) {
            list.remove(onAdapterChangeListener);
        }
    }

    public void removeOnPageChangeListener(@NonNull OnPageChangeListener onPageChangeListener) {
        if (isRtlLayout()) {
            onPageChangeListener = this.f35373ia.remove(onPageChangeListener);
        }
        List<OnPageChangeListener> list = this.f35366eb;
        if (list != null) {
            list.remove(onPageChangeListener);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.Ca) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public void setAdapter(@Nullable HwPagerAdapter hwPagerAdapter) {
        this.f35406yb = hwPagerAdapter;
        if (hwPagerAdapter != null) {
            boolean z10 = this.f35386ob;
            if (z10) {
                hwPagerAdapter = new com.huawei.uikit.hwviewpager.widget.d(hwPagerAdapter, z10);
            }
            if (hwPagerAdapter instanceof com.huawei.uikit.hwviewpager.widget.d) {
                ((com.huawei.uikit.hwviewpager.widget.d) hwPagerAdapter).a(this.f35388pb);
            }
        }
        setAdapterInner(hwPagerAdapter);
        if (this.f35386ob) {
            a(0, false);
        }
    }

    public void setAutoRtlLayoutEnabled(boolean z10) {
        this.f35398ub = z10;
    }

    public void setCurrentItem(int i10) {
        if (getCurrentItem() != i10) {
            setCurrentItem(i10, true);
        }
    }

    @Keep
    public void setCurrentItemInternal(int i10, boolean z10, boolean z11) {
        setCurrentItemInternal(i10, z10, z11, 0);
    }

    public void setDynamicSpringAnimaitionEnabled(boolean z10) {
        this.f35390qb = z10;
    }

    public void setEndShadowAlpha(float f10) {
        this.f35403xa = f10;
    }

    public void setExtendedChangePageEnabled(boolean z10) {
        this.Eb = z10;
    }

    public void setHwSpringDamping(@FloatRange(from = 1.0d) float f10) {
        this.f35392rb = f10;
    }

    public void setHwSpringStiffness(@FloatRange(from = 1.0d) float f10) {
        this.f35394sb = f10;
    }

    public void setLoopEndCache(int i10) {
        HwPagerAdapter hwPagerAdapter;
        if (!this.f35386ob || (hwPagerAdapter = this.f35357aa) == null || i10 <= 2) {
            return;
        }
        this.f35363da = i10;
        if (hwPagerAdapter instanceof com.huawei.uikit.hwviewpager.widget.d) {
            com.huawei.uikit.hwviewpager.widget.d dVar = (com.huawei.uikit.hwviewpager.widget.d) hwPagerAdapter;
            dVar.a(i10);
            dVar.notifyDataSetChanged();
        }
    }

    public void setOffscreenPageLimit(int i10) {
        if (i10 < this.f35365ea) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Requested offscreen page limit ");
            sb2.append(i10);
            sb2.append(" too small; defaulting to ");
            sb2.append(this.f35365ea);
            i10 = this.f35365ea;
        }
        if (i10 != this.Ga) {
            this.Ga = i10;
            e();
        }
    }

    @Deprecated
    public void setOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        if (this.f35386ob) {
            onPageChangeListener = new c(this, onPageChangeListener, null);
        }
        this.f35368fb = onPageChangeListener;
    }

    public void setPageMargin(int i10) {
        this.f35389qa = i10;
        int width = isPageScrollHorizontal() ? getWidth() : getHeight();
        d(width, width);
        requestLayout();
    }

    public void setPageMarginDrawable(@Nullable Drawable drawable) {
        this.f35391ra = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setPageScrollDirection(int i10) {
        if ((i10 == 1 || i10 == 0) && this.Gb != i10) {
            this.Gb = i10;
            requestLayout();
        }
    }

    public void setPageTransformer(boolean z10, @Nullable PageTransformer pageTransformer) {
        setPageTransformer(z10, pageTransformer, 2);
    }

    public void setReverseDrawingOrder(boolean z10) {
        if (this.f35382mb != 0) {
            return;
        }
        this.Da = z10;
        if (z10) {
            this.f35378kb = 1;
        } else {
            this.f35378kb = 2;
        }
    }

    public void setScrollState(int i10) {
        if (this.f35382mb == i10) {
            return;
        }
        this.f35382mb = i10;
        if (this.f35374ib != null) {
            b(i10 != 0);
        }
        c(i10);
    }

    public void setScroller(Scroller scroller) {
        if (scroller != null) {
            this.f35383na = scroller;
        }
    }

    public void setSensitivity(float f10) {
        HwGenericEventDetector hwGenericEventDetector = this.Db;
        if (hwGenericEventDetector != null) {
            hwGenericEventDetector.setSensitivity(f10);
        }
    }

    public void setShadowColor(int i10) {
        this.Jb = i10;
    }

    public void setShadowEnable(boolean z10) {
        this.f35408zb = z10;
    }

    public void setSpringInterpolatorEnable(boolean z10) {
        this.f35396tb = z10;
        if (z10) {
            isDynamicSpringAnimaitionEnabled();
        }
        if (z10) {
            return;
        }
        this.f35383na = new Scroller(getContext(), W);
    }

    public void setStartShadowAlpha(float f10) {
        this.f35401wa = f10;
    }

    public void setSupportLoop(boolean z10) {
        if (this.f35386ob == z10) {
            return;
        }
        this.f35386ob = z10;
        HwPagerAdapter hwPagerAdapter = this.f35406yb;
        if (hwPagerAdapter != null) {
            setAdapter(hwPagerAdapter);
        }
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f35391ra;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class LayoutParams extends ViewGroup.LayoutParams {

        /* renamed from: a, reason: collision with root package name */
        public float f35414a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f35415b;

        /* renamed from: c, reason: collision with root package name */
        public int f35416c;

        /* renamed from: d, reason: collision with root package name */
        public int f35417d;
        public int gravity;
        public boolean isDecor;

        public LayoutParams() {
            super(-1, -1);
            this.f35414a = 0.0f;
        }

        public LayoutParams(@NonNull Context context, @Nullable AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f35414a = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, HwViewPager.f35331a);
            this.gravity = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    public HwViewPager(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.hwViewPagerStyle);
    }

    private void c(int i10, int i11) {
        if (this.Ib == null) {
            ViewGroupOverlay c4 = c((View) this);
            this.Hb = c4;
            if (c4 == null) {
                return;
            }
            this.Ib = new com.huawei.uikit.hwviewpager.widget.a(this.Jb, this);
            setLayerType(1, null);
            this.Hb.add(this.Ib);
        }
        Drawable drawable = this.Ib;
        if (drawable instanceof com.huawei.uikit.hwviewpager.widget.a) {
            ((com.huawei.uikit.hwviewpager.widget.a) drawable).a(i10, i11);
        }
    }

    public static boolean d(@NonNull View view) {
        return view.getClass().getAnnotation(DecorView.class) != null;
    }

    private void f(int i10, int i11) {
        this.Ab.reset().setObj(this, isPageScrollHorizontal() ? DynamicAnimation.SCROLL_X : DynamicAnimation.SCROLL_Y, this.f35394sb, this.f35392rb, i10, i11);
        r();
        this.f35385oa = false;
        this.Ab.startImmediately();
    }

    private int g(int i10) {
        ItemInfo a10 = a(i10);
        if (a10 == null) {
            return 0;
        }
        return (int) (Math.max(this.f35405ya, Math.min(a10.f35413e, this.f35407za)) * (isPageScrollHorizontal() ? getClientWidth() : getClientHeight()));
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void h() {
        /*
            r10 = this;
            int r0 = r10.getScrollX()
            int r1 = r10.getPaddingLeft()
            int r2 = r10.getPaddingRight()
            int r3 = r10.getWidth()
            int r4 = r10.getChildCount()
            r5 = 0
        L15:
            if (r5 >= r4) goto L72
            android.view.View r6 = r10.getChildAt(r5)
            if (r6 != 0) goto L1e
            goto L6f
        L1e:
            android.view.ViewGroup$LayoutParams r7 = r6.getLayoutParams()
            boolean r7 = r7 instanceof com.huawei.uikit.hwviewpager.widget.HwViewPager.LayoutParams
            if (r7 != 0) goto L27
            goto L6f
        L27:
            android.view.ViewGroup$LayoutParams r7 = r6.getLayoutParams()
            com.huawei.uikit.hwviewpager.widget.HwViewPager$LayoutParams r7 = (com.huawei.uikit.hwviewpager.widget.HwViewPager.LayoutParams) r7
            boolean r8 = r7.isDecor
            if (r8 != 0) goto L32
            goto L6f
        L32:
            int r7 = r7.gravity
            r7 = r7 & 7
            r8 = 1
            if (r7 == r8) goto L54
            r8 = 3
            if (r7 == r8) goto L4e
            r8 = 5
            if (r7 == r8) goto L41
            r7 = r1
            goto L63
        L41:
            int r7 = r3 - r2
            int r8 = r6.getMeasuredWidth()
            int r7 = r7 - r8
            int r8 = r6.getMeasuredWidth()
            int r2 = r2 + r8
            goto L60
        L4e:
            int r7 = r6.getWidth()
            int r7 = r7 + r1
            goto L63
        L54:
            int r7 = r6.getMeasuredWidth()
            int r7 = r3 - r7
            int r7 = r7 / 2
            int r7 = java.lang.Math.max(r7, r1)
        L60:
            r9 = r7
            r7 = r1
            r1 = r9
        L63:
            int r1 = r1 + r0
            int r8 = r6.getLeft()
            int r1 = r1 - r8
            if (r1 == 0) goto L6e
            r6.offsetLeftAndRight(r1)
        L6e:
            r1 = r7
        L6f:
            int r5 = r5 + 1
            goto L15
        L72:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.uikit.hwviewpager.widget.HwViewPager.h():void");
    }

    public void b() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.f35383na = new Scroller(context, W);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f10 = context.getResources().getDisplayMetrics().density;
        this.La = viewConfiguration.getScaledPagingTouchSlop();
        if (this.f35390qb) {
            this.Ta = 1200;
        } else {
            this.Ta = (int) (400.0f * f10);
        }
        this.Ua = viewConfiguration.getScaledMaximumFlingVelocity();
        this.Za = new EdgeEffect(context);
        this._a = new EdgeEffect(context);
        this.Va = (int) (25.0f * f10);
        this.Wa = (int) (2.0f * f10);
        this.Ja = (int) (f10 * 16.0f);
        ViewCompat.setAccessibilityDelegate(this, new a());
        if (ViewCompat.getImportantForAccessibility(this) == 0) {
            ViewCompat.setImportantForAccessibility(this, 1);
        }
        ViewCompat.setOnApplyWindowInsetsListener(this, new i(this));
    }

    public void e() {
        populate(this.f35359ba);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public void nextPage(boolean z10) {
        nextPage(z10, true);
    }

    public void prePage(boolean z10) {
        prePage(z10, false);
    }

    public void setCurrentItemInternal(int i10, boolean z10, boolean z11, int i11) {
        HwPagerAdapter hwPagerAdapter = this.f35357aa;
        if (hwPagerAdapter != null && hwPagerAdapter.getCount() > 0) {
            if (!z11 && this.f35359ba == i10 && this.f35367fa.size() != 0) {
                setScrollingCacheEnabled(false);
                return;
            }
            if (i10 < 0) {
                i10 = 0;
            } else if (i10 >= this.f35357aa.getCount()) {
                i10 = this.f35357aa.getCount() - 1;
            }
            int i12 = this.Ga;
            int i13 = this.f35359ba;
            if (i10 > i13 + i12 || i10 < i13 - i12) {
                for (int i14 = 0; i14 < this.f35367fa.size(); i14++) {
                    this.f35367fa.get(i14).f35411c = true;
                }
            }
            boolean z12 = this.f35359ba != i10;
            if (this.f35358ab) {
                this.f35359ba = i10;
                if (z12) {
                    b(i10);
                }
                requestLayout();
                return;
            }
            populate(i10);
            a(i10, z10, i11, z12);
            return;
        }
        setScrollingCacheEnabled(false);
    }

    public void setPageTransformer(boolean z10, @Nullable PageTransformer pageTransformer, int i10) {
        boolean z11 = pageTransformer != null;
        boolean z12 = z11 != (this.f35374ib != null);
        this.f35374ib = pageTransformer;
        setChildrenDrawingOrderEnabled(z11);
        if (z11) {
            this.f35378kb = z10 ? 2 : 1;
            this.Da = !z10;
            this.f35376jb = i10;
        } else {
            this.f35378kb = 0;
        }
        if (z12) {
            e();
        }
    }

    public HwViewPager(Context context, AttributeSet attributeSet, int i10) {
        super(a(context, i10), attributeSet, i10);
        this.f35363da = 2;
        this.f35365ea = 1;
        this.f35367fa = new ArrayList<>();
        this.f35369ga = new ItemInfo();
        this.f35371ha = new Rect();
        this.f35373ia = new ArrayMap();
        this.f35375ja = new g(this);
        this.f35377ka = -1;
        this.f35379la = null;
        this.f35381ma = null;
        this.f35401wa = 0.0f;
        this.f35403xa = 0.3f;
        this.f35405ya = -3.4028235E38f;
        this.f35407za = Float.MAX_VALUE;
        this.Ga = 2;
        this.Qa = 1.4f;
        this.Ra = -1;
        this.f35358ab = true;
        this.f35360bb = false;
        this.f35382mb = 0;
        this.f35386ob = false;
        this.f35388pb = false;
        this.f35390qb = true;
        this.f35392rb = 30.0f;
        this.f35394sb = 228.0f;
        this.f35396tb = false;
        this.f35398ub = true;
        this.f35400vb = true;
        this.f35408zb = false;
        this.Ab = new HWSpringAnimation(this, DynamicAnimation.SCROLL_X, new SpringModel(this.f35394sb, this.f35392rb));
        this.Bb = new DynamicAnimation.OnAnimationEndListener() { // from class: com.huawei.uikit.hwviewpager.widget.n
            @Override // com.huawei.dynamicanimation.DynamicAnimation.OnAnimationEndListener
            public final void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean z10, float f10, float f11) {
                HwViewPager.this.a(dynamicAnimation, z10, f10, f11);
            }
        };
        this.Cb = new DynamicAnimation.OnAnimationUpdateListener() { // from class: com.huawei.uikit.hwviewpager.widget.o
            @Override // com.huawei.dynamicanimation.DynamicAnimation.OnAnimationUpdateListener
            public final void onAnimationUpdate(DynamicAnimation dynamicAnimation, float f10, float f11) {
                HwViewPager.this.a(dynamicAnimation, f10, f11);
            }
        };
        this.Eb = true;
        this.Fb = true;
        this.Gb = 0;
        this.Kb = PathInterpolatorCompat.create(0.4f, 0.0f, 0.2f, 1.0f);
        a(getContext(), attributeSet, i10);
    }

    private void e(int i10, int i11) {
        if (isPageScrollHorizontal()) {
            int paddingLeft = (i10 - getPaddingLeft()) - getPaddingRight();
            int paddingLeft2 = (i11 - getPaddingLeft()) - getPaddingRight();
            scrollTo((int) ((paddingLeft2 > 0 ? getScrollX() / paddingLeft2 : 0.0f) * paddingLeft), getScrollY());
        } else {
            int paddingTop = (i10 - getPaddingTop()) - getPaddingBottom();
            int paddingTop2 = (i11 - getPaddingTop()) - getPaddingBottom();
            scrollTo(getScrollX(), (int) ((paddingTop2 > 0 ? getScrollY() / paddingTop2 : 0.0f) * paddingTop));
        }
    }

    public void nextPage(boolean z10, boolean z11) {
        int count;
        if (getAdapter() != null && (count = getAdapter().getCount()) >= 2) {
            int currentItem = getCurrentItem();
            if (currentItem != count - 1) {
                setCurrentItem(currentItem + 1, z10);
            } else if (z11) {
                setCurrentItem(0, false);
            }
        }
    }

    public void prePage(boolean z10, boolean z11) {
        int count;
        if (getAdapter() != null && (count = getAdapter().getCount()) >= 2) {
            int currentItem = getCurrentItem();
            if (currentItem > 0) {
                setCurrentItem(currentItem - 1, z10);
            } else if (z11) {
                setCurrentItem(count - 1, false);
            }
        }
    }

    public void setCurrentItem(int i10, boolean z10) {
        if (this.Fb) {
            i10 = a(i10, this.f35357aa);
        }
        this.Fa = false;
        setCurrentItemInternal(i10, z10, false);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class RtlSavedState implements Parcelable {
        public static final Parcelable.ClassLoaderCreator<RtlSavedState> CREATOR = new l();

        /* renamed from: a, reason: collision with root package name */
        public Parcelable f35418a;

        /* renamed from: b, reason: collision with root package name */
        public int f35419b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f35420c;

        public RtlSavedState(Parcelable parcelable, int i10, boolean z10) {
            this.f35418a = parcelable;
            this.f35419b = i10;
            this.f35420c = z10;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            if (parcel == null) {
                return;
            }
            parcel.writeParcelable(this.f35418a, i10);
            parcel.writeInt(this.f35419b);
            parcel.writeByte(this.f35420c ? (byte) 1 : (byte) 0);
        }

        public RtlSavedState(Parcel parcel, ClassLoader classLoader) {
            this.f35418a = parcel.readParcelable(classLoader == null ? RtlSavedState.class.getClassLoader() : classLoader);
            this.f35419b = parcel.readInt();
            this.f35420c = parcel.readByte() != 0;
        }
    }

    private void d(int i10, int i11) {
        HWSpringAnimation hWSpringAnimation;
        if (i11 > 0 && !this.f35367fa.isEmpty()) {
            if (this.f35390qb && (hWSpringAnimation = this.Ab) != null && hWSpringAnimation.isRunning()) {
                o();
                return;
            } else if (!this.f35383na.isFinished()) {
                n();
                return;
            } else {
                e(i10, i11);
                return;
            }
        }
        f(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(DynamicAnimation dynamicAnimation, boolean z10, float f10, float f11) {
        if (!z10) {
            boolean isPageScrollHorizontal = isPageScrollHorizontal();
            if (!(Float.compare((float) (isPageScrollHorizontal ? getScrollX() : getScrollY()), f10) == 0)) {
                scrollTo(isPageScrollHorizontal ? (int) f10 : 0, isPageScrollHorizontal ? 0 : (int) f10);
            }
        }
        if (this.f35382mb != 0) {
            a(false);
        }
    }

    private void g() {
        HwPagerAdapter hwPagerAdapter;
        if (this.f35386ob && (hwPagerAdapter = this.f35357aa) != null) {
            if (hwPagerAdapter instanceof com.huawei.uikit.hwviewpager.widget.d) {
                int count = hwPagerAdapter.getCount() - ((com.huawei.uikit.hwviewpager.widget.d) hwPagerAdapter).a();
                int i10 = this.f35359ba;
                if (i10 > count + 1 || i10 < count) {
                    return;
                }
                postDelayed(new Runnable() { // from class: com.huawei.uikit.hwviewpager.widget.p
                    @Override // java.lang.Runnable
                    public final void run() {
                        HwViewPager.this.m();
                    }
                }, isDynamicSpringAnimaitionEnabled() ? 700L : 300L);
                this.f35400vb = false;
                return;
            }
            return;
        }
        this.f35400vb = true;
    }

    public void setPageMarginDrawable(@DrawableRes int i10) {
        setPageMarginDrawable(ContextCompat.getDrawable(getContext(), i10));
    }

    private void f(int i10) {
        int paddingTop;
        int paddingBottom;
        ItemInfo a10 = a(this.f35359ba);
        float min = a10 != null ? Math.min(a10.f35413e, this.f35407za) : 0.0f;
        if (isPageScrollHorizontal() && isRtlLayout()) {
            min = -min;
        }
        if (isPageScrollHorizontal()) {
            paddingTop = i10 - getPaddingLeft();
            paddingBottom = getPaddingRight();
        } else {
            paddingTop = i10 - getPaddingTop();
            paddingBottom = getPaddingBottom();
        }
        int i11 = (int) (min * (paddingTop - paddingBottom));
        if (!isPageScrollHorizontal() ? i11 == getScrollY() : i11 == getScrollX()) {
            a(false);
            if (isPageScrollHorizontal()) {
                scrollTo(i11, getScrollY());
            } else {
                scrollTo(getScrollX(), i11);
            }
        }
    }

    private void c(int i10) {
        OnPageChangeListener onPageChangeListener = this.f35368fb;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrollStateChanged(i10);
        }
        List<OnPageChangeListener> list = this.f35366eb;
        if (list != null) {
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                OnPageChangeListener onPageChangeListener2 = this.f35366eb.get(i11);
                if (onPageChangeListener2 != null) {
                    onPageChangeListener2.onPageScrollStateChanged(i10);
                }
            }
        }
        OnPageChangeListener onPageChangeListener3 = this.f35370gb;
        if (onPageChangeListener3 != null) {
            onPageChangeListener3.onPageScrollStateChanged(i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(DynamicAnimation dynamicAnimation, float f10, float f11) {
        if (this.f35382mb == 2) {
            pageScrolled((int) f10);
        }
    }

    private boolean d(MotionEvent motionEvent, int i10) {
        int findPointerIndex = motionEvent.findPointerIndex(i10);
        float y10 = motionEvent.getY(findPointerIndex);
        float f10 = y10 - this.Na;
        float abs = Math.abs(f10);
        float x10 = motionEvent.getX(findPointerIndex);
        float abs2 = Math.abs(x10 - this.Oa);
        if (f10 != 0.0f && !b(this.Na, f10) && canScroll(this, false, (int) f10, (int) x10, (int) y10)) {
            this.Ma = x10;
            this.Na = y10;
            this.Ia = true;
            return false;
        }
        int i11 = this.La;
        if (abs > i11 && abs * 0.5f > abs2) {
            this.Ha = true;
            c(true);
            setScrollState(1);
            this.Ma = x10;
            this.Na = f10 > 0.0f ? this.Pa + this.La : this.Pa - this.La;
            setScrollingCacheEnabled(true);
        } else if (abs2 > i11) {
            this.Ia = true;
        }
        if (this.Ha && performDrag(this.Na - y10)) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
        return true;
    }

    private boolean e(float f10) {
        boolean z10;
        boolean z11;
        float a10;
        this.Na -= f10;
        float scrollY = getScrollY();
        float f11 = scrollY + f10;
        int clientHeight = getClientHeight();
        float f12 = clientHeight;
        float f13 = this.f35405ya * f12;
        float f14 = this.f35407za * f12;
        boolean z12 = false;
        if (this.f35367fa.size() <= 0) {
            return false;
        }
        ItemInfo itemInfo = this.f35367fa.get(0);
        ArrayList<ItemInfo> arrayList = this.f35367fa;
        ItemInfo itemInfo2 = arrayList.get(arrayList.size() - 1);
        if (itemInfo.f35410b != 0) {
            f13 = itemInfo.f35413e * f12;
            z10 = false;
        } else {
            z10 = true;
        }
        if (itemInfo2.f35410b != this.f35357aa.getCount() - 1) {
            f14 = itemInfo2.f35413e * f12;
            z11 = false;
        } else {
            z11 = true;
        }
        if (f11 < f13) {
            if (z10) {
                this.Za.onPull(clientHeight > 0 ? Math.abs(f13 - f11) / f12 : 0.0f);
                z12 = true;
            }
            if ((this.f35390qb || this.f35396tb) && z10) {
                a10 = a(clientHeight, f10, f11 - f13);
                f11 = scrollY + a10;
            } else {
                f11 = f13;
            }
        } else if (f11 > f14) {
            if (z11) {
                this._a.onPull(clientHeight > 0 ? Math.abs(f11 - f14) / f12 : 0.0f);
                z12 = true;
            }
            if ((this.f35390qb || this.f35396tb) && z11) {
                a10 = a(clientHeight, f10, f11 - f14);
                f11 = scrollY + a10;
            } else {
                f11 = f14;
            }
        }
        c(f11);
        return z12;
    }

    public static Context a(Context context, int i10) {
        return HwWidgetCompat.wrapContext(context, i10, R$style.Theme_Emui_HwViewPager);
    }

    private void a(@NonNull Context context, AttributeSet attributeSet, int i10) {
        b(context, attributeSet, i10);
        b();
        HwGenericEventDetector createGenericEventDetector = createGenericEventDetector();
        this.Db = createGenericEventDetector;
        if (createGenericEventDetector != null) {
            setSensitivityMode(this.f35402wb);
            this.Db.setSensitivity(this.Qa);
            this.Db.setOnScrollListener(this, createOnScrollListener());
            this.Db.setOnChangePageListener(createOnChangePageListener());
        }
        setValueFromPlume(context);
    }

    private boolean c(MotionEvent motionEvent, int i10) {
        int findPointerIndex = motionEvent.findPointerIndex(i10);
        float x10 = motionEvent.getX(findPointerIndex);
        float f10 = x10 - this.Ma;
        float abs = Math.abs(f10);
        float y10 = motionEvent.getY(findPointerIndex);
        float abs2 = Math.abs(y10 - this.Pa);
        if (f10 != 0.0f && !b(this.Ma, f10) && canScroll(this, false, (int) f10, (int) x10, (int) y10)) {
            this.Ma = x10;
            this.Na = y10;
            this.Ia = true;
            return false;
        }
        int i11 = this.La;
        if (abs > i11 && abs * 0.5f > abs2) {
            this.Ha = true;
            c(true);
            setScrollState(1);
            this.Ma = f10 > 0.0f ? this.Oa + this.La : this.Oa - this.La;
            this.Na = y10;
            setScrollingCacheEnabled(true);
        } else if (abs2 > i11) {
            this.Ia = true;
        }
        if (this.Ha && performDrag(this.Ma - x10)) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
        return true;
    }

    private void f() {
        if (!this.f35386ob) {
            this.f35400vb = true;
            return;
        }
        HwPagerAdapter hwPagerAdapter = this.f35357aa;
        if ((hwPagerAdapter instanceof com.huawei.uikit.hwviewpager.widget.d) && this.f35359ba < ((com.huawei.uikit.hwviewpager.widget.d) hwPagerAdapter).a()) {
            postDelayed(new Runnable() { // from class: com.huawei.uikit.hwviewpager.widget.q
                @Override // java.lang.Runnable
                public final void run() {
                    HwViewPager.this.l();
                }
            }, isDynamicSpringAnimaitionEnabled() ? 700L : 300L);
            this.f35400vb = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(float f10, float f11) {
        return Math.abs(f10 - f11) < 1.0E-6f;
    }

    private void a(int i10, boolean z10, int i11, boolean z11) {
        int g3 = g(i10);
        if (z10) {
            if (isPageScrollHorizontal()) {
                if (isRtlLayout()) {
                    g3 = -g3;
                }
                a(g3, 0, i11);
            } else {
                a(0, g3, i11);
            }
            if (z11) {
                b(i10);
                return;
            }
            return;
        }
        if (z11) {
            b(i10);
        }
        a(false);
        if (isPageScrollHorizontal()) {
            if (isRtlLayout()) {
                g3 = -g3;
            }
            scrollTo(g3, 0);
        } else {
            scrollTo(0, g3);
        }
        pageScrolled(g3);
    }

    private void b(Context context, AttributeSet attributeSet, int i10) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.HwViewPager, i10, 0);
        this.f35386ob = obtainStyledAttributes.getBoolean(R$styleable.HwViewPager_hwViewPagerSupportLoop, false);
        this.f35402wb = obtainStyledAttributes.getInt(R$styleable.HwViewPager_hwSensitivityMode, 1);
        this.Jb = obtainStyledAttributes.getColor(R$styleable.HwViewPager_hwShadowColor, P);
        this.Gb = obtainStyledAttributes.getInt(R$styleable.HwViewPager_android_orientation, 0);
        obtainStyledAttributes.recycle();
    }

    public void b(int i10, int i11) {
        a(i10, i11, 0);
    }

    private void e(int i10) {
        int clientHeight = getClientHeight();
        int scrollY = getScrollY();
        ItemInfo infoForCurrentScrollPosition = infoForCurrentScrollPosition();
        if (infoForCurrentScrollPosition != null) {
            setCurrentItemInternal(determineTargetPage(infoForCurrentScrollPosition.f35410b, clientHeight > 0 && (infoForCurrentScrollPosition.f35412d > 0.0f ? 1 : (infoForCurrentScrollPosition.f35412d == 0.0f ? 0 : -1)) > 0 ? ((scrollY / clientHeight) - infoForCurrentScrollPosition.f35413e) / infoForCurrentScrollPosition.f35412d : 0.0f, i10, (int) (this.Na - this.Pa)), true, true, i10);
        }
    }

    public ItemInfo b(View view) {
        for (int i10 = 0; i10 < this.f35367fa.size(); i10++) {
            ItemInfo itemInfo = this.f35367fa.get(i10);
            if (this.f35357aa.isViewFromObject(view, itemInfo.f35409a)) {
                return itemInfo;
            }
        }
        return null;
    }

    private void b(int i10, int i11, int i12, Rect rect) {
        View childAt = getChildAt(i10);
        if (childAt == null) {
            return;
        }
        int i13 = rect.left;
        int i14 = rect.right;
        int i15 = rect.top;
        if (childAt.getVisibility() == 8 || !(childAt.getLayoutParams() instanceof LayoutParams)) {
            return;
        }
        LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
        ItemInfo b4 = b(childAt);
        if (layoutParams.isDecor || b4 == null) {
            return;
        }
        float f10 = i11;
        int i16 = i15 + ((int) (b4.f35413e * f10));
        if (layoutParams.f35415b) {
            layoutParams.f35415b = false;
            childAt.measure(View.MeasureSpec.makeMeasureSpec((i12 - i13) - i14, 1073741824), View.MeasureSpec.makeMeasureSpec((int) (f10 * layoutParams.f35414a), 1073741824));
        }
        childAt.layout(i13, i16, childAt.getMeasuredWidth() + i13, childAt.getMeasuredHeight() + i16);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0098  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean d(float r18) {
        /*
            Method dump skipped, instructions count: 235
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.uikit.hwviewpager.widget.HwViewPager.d(float):boolean");
    }

    public OnPageChangeListener a(OnPageChangeListener onPageChangeListener) {
        OnPageChangeListener onPageChangeListener2 = this.f35370gb;
        this.f35370gb = onPageChangeListener;
        return onPageChangeListener2;
    }

    public float a(float f10) {
        return (float) Math.sin((f10 - 0.5f) * 0.47123894f);
    }

    private void c(boolean z10) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z10);
        }
    }

    public void a(int i10, int i11, int i12) {
        int abs;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        int newAnimationScrollX = getNewAnimationScrollX();
        int newAnimationScrollY = getNewAnimationScrollY();
        int i13 = i10 - newAnimationScrollX;
        int i14 = i11 - newAnimationScrollY;
        if (i13 == 0 && i14 == 0) {
            a(false);
            e();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = isPageScrollHorizontal() ? getClientWidth() : getClientHeight();
        float f10 = clientWidth / 2;
        float a10 = (a(clientWidth <= 0 ? 0.0f : Math.min(1.0f, (Math.abs(i13) * 1.0f) / clientWidth)) * f10) + f10;
        if (this.f35390qb) {
            if (!isPageScrollHorizontal()) {
                i10 = i11;
            }
            f(i10, -i12);
        } else {
            if (this.f35396tb) {
                a(-i12, new Pair<>(Integer.valueOf(newAnimationScrollX), Integer.valueOf(newAnimationScrollY)), new Pair<>(Integer.valueOf(i13), Integer.valueOf(i14)));
                return;
            }
            int abs2 = Math.abs(i12);
            if (abs2 > 0) {
                abs = Math.round(Math.abs(a10 / abs2) * 1000.0f) * 4;
            } else {
                float pageWidth = clientWidth * (isPageScrollHorizontal() ? this.f35357aa.getPageWidth(this.f35359ba) : this.f35357aa.getPageHeight(this.f35359ba));
                abs = (int) (((Float.compare(((float) this.f35389qa) + pageWidth, 0.0f) != 0 ? Math.abs(i13) / (pageWidth + this.f35389qa) : 0.0f) + 1.0f) * 100.0f);
            }
            int min = Math.min(abs, 600);
            this.f35385oa = false;
            this.f35383na.startScroll(newAnimationScrollX, newAnimationScrollY, i13, i14, min);
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    private void e(@NonNull MotionEvent motionEvent, int i10) {
        if (isPageScrollHorizontal()) {
            this.Ma = motionEvent.getX(i10);
        } else {
            this.Na = motionEvent.getY(i10);
        }
    }

    private void c(float f10) {
        int i10 = (int) f10;
        this.Na = (f10 - i10) + this.Na;
        scrollTo(getScrollX(), i10);
        pageScrolled(i10);
    }

    private void c(@NonNull MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.Ra) {
            int i10 = actionIndex == 0 ? 1 : 0;
            e(motionEvent, i10);
            this.Ra = motionEvent.getPointerId(i10);
            VelocityTracker velocityTracker = this.Sa;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private void b(int i10) {
        OnPageChangeListener onPageChangeListener = this.f35368fb;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageSelected(i10);
        }
        List<OnPageChangeListener> list = this.f35366eb;
        if (list != null) {
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                OnPageChangeListener onPageChangeListener2 = this.f35366eb.get(i11);
                if (onPageChangeListener2 != null) {
                    onPageChangeListener2.onPageSelected(i10);
                }
            }
        }
        OnPageChangeListener onPageChangeListener3 = this.f35370gb;
        if (onPageChangeListener3 != null) {
            onPageChangeListener3.onPageSelected(i10);
        }
    }

    public boolean c() {
        if (this.f35400vb && this.f35357aa != null) {
            int i10 = this.f35359ba;
            if (i10 > 0) {
                this.Fb = false;
                if (isPageScrollHorizontal() && isRtlLayout()) {
                    HwPagerAdapter hwPagerAdapter = this.f35357aa;
                    if (hwPagerAdapter != null && this.f35359ba == hwPagerAdapter.getCount() - 1) {
                        return false;
                    }
                    g();
                    setCurrentItem(this.f35359ba + 1, true);
                } else {
                    f();
                    setCurrentItem(this.f35359ba - 1, true);
                }
                this.Fb = true;
                return true;
            }
            if (i10 == 0 && isPageScrollHorizontal() && isRtlLayout()) {
                HwPagerAdapter hwPagerAdapter2 = this.f35357aa;
                if (hwPagerAdapter2 != null && hwPagerAdapter2.getCount() == 1) {
                    return false;
                }
                setCurrentItem(this.f35359ba + 1, true);
                return true;
            }
        }
        return false;
    }

    private void d(int i10) {
        int clientWidth = getClientWidth();
        int scrollX = isRtlLayout() ? -getScrollX() : getScrollX();
        ItemInfo infoForCurrentScrollPosition = infoForCurrentScrollPosition();
        if (infoForCurrentScrollPosition != null) {
            setCurrentItemInternal(determineTargetPage(infoForCurrentScrollPosition.f35410b, clientWidth > 0 && (infoForCurrentScrollPosition.f35412d > 0.0f ? 1 : (infoForCurrentScrollPosition.f35412d == 0.0f ? 0 : -1)) > 0 ? ((scrollX / clientWidth) - infoForCurrentScrollPosition.f35413e) / infoForCurrentScrollPosition.f35412d : 0.0f, i10, (int) (this.Ma - this.Oa)), true, true, i10);
        }
    }

    private boolean b(float f10, float f11) {
        if (isPageScrollHorizontal()) {
            if (f10 >= this.Ka || f11 <= 0.0f) {
                return f10 > ((float) (getWidth() - this.Ka)) && f11 < 0.0f;
            }
            return true;
        }
        if (f10 >= this.Ka || f11 <= 0.0f) {
            return f10 > ((float) (getHeight() - this.Ka)) && f11 < 0.0f;
        }
        return true;
    }

    private void b(boolean z10) {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            getChildAt(i10).setLayerType(z10 ? this.f35376jb : 0, null);
        }
    }

    @Nullable
    private ViewGroupOverlay c(View view) {
        ViewParent parent = view.getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            return ((ViewGroup) parent).getOverlay();
        }
        return null;
    }

    public boolean d() {
        HwPagerAdapter hwPagerAdapter;
        if (this.f35400vb && (hwPagerAdapter = this.f35357aa) != null) {
            if (this.f35359ba < hwPagerAdapter.getCount() - 1) {
                this.Fb = false;
                if (isPageScrollHorizontal() && isRtlLayout()) {
                    if (this.f35359ba == 0) {
                        return false;
                    }
                    f();
                    setCurrentItem(this.f35359ba - 1, true);
                } else {
                    g();
                    setCurrentItem(this.f35359ba + 1, true);
                }
                this.Fb = true;
                return true;
            }
            if (this.f35359ba == this.f35357aa.getCount() - 1 && isPageScrollHorizontal() && isRtlLayout()) {
                setCurrentItem(this.f35359ba - 1, true);
                return true;
            }
        }
        return false;
    }

    private void b(@NonNull MotionEvent motionEvent, int i10) {
        float x10 = motionEvent.getX(i10);
        float abs = Math.abs(x10 - this.Ma);
        float y10 = motionEvent.getY(i10);
        float abs2 = Math.abs(y10 - this.Na);
        if (abs2 <= this.La || abs2 <= abs) {
            return;
        }
        this.Ha = true;
        c(true);
        this.Ma = x10;
        float f10 = this.Pa;
        this.Na = y10 - f10 > 0.0f ? f10 + this.La : f10 - this.La;
        setScrollState(1);
        setScrollingCacheEnabled(true);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    private void a(int i10, @NonNull Pair<Integer, Integer> pair, @NonNull Pair<Integer, Integer> pair2) {
        SpringInterpolator springInterpolator = new SpringInterpolator(this.f35394sb, this.f35392rb, ((Integer) (isPageScrollHorizontal() ? pair2.first : pair2.second)).intValue(), i10);
        int duration = (int) springInterpolator.getDuration();
        Scroller scroller = new Scroller(getContext(), springInterpolator);
        this.f35383na = scroller;
        this.f35385oa = false;
        scroller.startScroll(((Integer) pair.first).intValue(), ((Integer) pair.second).intValue(), ((Integer) pair2.first).intValue(), ((Integer) pair2.second).intValue(), duration);
        ViewCompat.postInvalidateOnAnimation(this);
    }

    public ItemInfo a(int i10, int i11) {
        ItemInfo itemInfo = new ItemInfo();
        itemInfo.f35410b = i10;
        itemInfo.f35409a = this.f35357aa.instantiateItem(this, i10);
        itemInfo.f35412d = isPageScrollHorizontal() ? this.f35357aa.getPageWidth(i10) : this.f35357aa.getPageHeight(i10);
        if (i11 >= 0 && i11 < this.f35367fa.size()) {
            this.f35367fa.add(i11, itemInfo);
        } else {
            this.f35367fa.add(itemInfo);
        }
        return itemInfo;
    }

    private boolean b(@NonNull MotionEvent motionEvent) {
        boolean z10 = false;
        if (this.Ra == -1) {
            return false;
        }
        VelocityTracker velocityTracker = this.Sa;
        velocityTracker.computeCurrentVelocity(1000, this.Ua);
        int yVelocity = (int) velocityTracker.getYVelocity(this.Ra);
        this.Fa = true;
        int clientHeight = getClientHeight();
        int scrollY = getScrollY();
        ItemInfo infoForCurrentScrollPosition = infoForCurrentScrollPosition();
        if (infoForCurrentScrollPosition == null) {
            return false;
        }
        float f10 = clientHeight <= 0 ? 0.0f : this.f35389qa / clientHeight;
        int i10 = infoForCurrentScrollPosition.f35410b;
        if (clientHeight > 0 && infoForCurrentScrollPosition.f35412d + f10 > 0.0f) {
            z10 = true;
        }
        setCurrentItemInternal(determineTargetPage(i10, z10 ? ((scrollY / clientHeight) - infoForCurrentScrollPosition.f35413e) / (infoForCurrentScrollPosition.f35412d + f10) : 0.0f, yVelocity, (int) (motionEvent.getY(motionEvent.findPointerIndex(this.Ra)) - this.Pa)), true, true, yVelocity);
        return true;
    }

    public void a() {
        int count = this.f35357aa.getCount();
        this.f35361ca = count;
        boolean z10 = this.f35367fa.size() < (this.Ga * 2) + 1 && this.f35367fa.size() < count;
        int i10 = this.f35359ba;
        int i11 = 0;
        boolean z11 = false;
        while (i11 < this.f35367fa.size()) {
            ItemInfo itemInfo = this.f35367fa.get(i11);
            int itemPosition = this.f35357aa.getItemPosition(itemInfo.f35409a);
            if (itemPosition != -1) {
                if (itemPosition == -2) {
                    this.f35367fa.remove(i11);
                    i11--;
                    if (!z11) {
                        this.f35357aa.startUpdate(this);
                        z11 = true;
                    }
                    this.f35357aa.destroyItem(this, itemInfo.f35410b, itemInfo.f35409a);
                    int i12 = this.f35359ba;
                    if (i12 == itemInfo.f35410b) {
                        i10 = Math.max(0, Math.min(i12, count - 1));
                    }
                } else {
                    int i13 = itemInfo.f35410b;
                    if (i13 != itemPosition) {
                        if (i13 == this.f35359ba) {
                            i10 = itemPosition;
                        }
                        itemInfo.f35410b = itemPosition;
                    }
                }
                z10 = true;
            }
            i11++;
        }
        if (z11) {
            this.f35357aa.finishUpdate(this);
        }
        Collections.sort(this.f35367fa, V);
        if (z10) {
            int childCount = getChildCount();
            for (int i14 = 0; i14 < childCount; i14++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i14).getLayoutParams();
                if (!layoutParams.isDecor) {
                    layoutParams.f35414a = 0.0f;
                }
            }
            setCurrentItemInternal(i10, false, true);
            requestLayout();
        }
    }

    private boolean b(boolean z10, float f10, int i10, float f11, boolean z11) {
        if (!z11) {
            return z10;
        }
        this._a.onPull(i10 <= 0 ? 0.0f : Math.abs(f10 - f11) / i10);
        return true;
    }

    private void b(float f10) {
        int i10 = (int) f10;
        this.Ma = (f10 - i10) + this.Ma;
        scrollTo(i10, getScrollY());
        pageScrolled(i10);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0023, code lost:
    
        r4 = 0.39999998f;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int b(int r2, float r3, int r4, int r5) {
        /*
            r1 = this;
            int r5 = java.lang.Math.abs(r5)
            int r0 = r1.Va
            if (r5 <= r0) goto L16
            int r5 = java.lang.Math.abs(r4)
            int r0 = r1.Ta
            if (r5 <= r0) goto L16
            if (r4 <= 0) goto L13
            goto L2d
        L13:
            int r2 = r2 + 1
            goto L2d
        L16:
            boolean r4 = r1.f35390qb
            if (r4 == 0) goto L1f
            int r4 = r1.f35359ba
            if (r2 < r4) goto L23
            goto L27
        L1f:
            int r4 = r1.f35359ba
            if (r2 < r4) goto L27
        L23:
            r4 = 1053609164(0x3ecccccc, float:0.39999998)
            goto L2a
        L27:
            r4 = 1058642330(0x3f19999a, float:0.6)
        L2a:
            float r3 = r3 + r4
            int r3 = (int) r3
            int r2 = r2 + r3
        L2d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.uikit.hwviewpager.widget.HwViewPager.b(int, float, int, int):int");
    }

    private boolean b(int i10, View view) {
        boolean c4;
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, view, i10);
        if (findNextFocus == null || findNextFocus == view) {
            if (i10 == 17 || i10 == 1) {
                c4 = c();
            } else {
                if (i10 == 66 || i10 == 2) {
                    c4 = d();
                }
                c4 = false;
            }
        } else if (i10 == 17) {
            int i11 = a(this.f35371ha, findNextFocus).left;
            int i12 = a(this.f35371ha, view).left;
            if (view != null && i11 >= i12) {
                c4 = c();
            } else {
                c4 = findNextFocus.requestFocus();
            }
        } else {
            if (i10 == 66) {
                int i13 = a(this.f35371ha, findNextFocus).left;
                int i14 = a(this.f35371ha, view).left;
                if (view != null && i13 <= i14) {
                    c4 = d();
                } else {
                    c4 = findNextFocus.requestFocus();
                }
            }
            c4 = false;
        }
        if (c4) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i10));
        }
        return c4;
    }

    private void a(ItemInfo itemInfo, int i10, ItemInfo itemInfo2) {
        int i11;
        int i12;
        float pageHeight;
        int i13;
        int i14;
        float pageHeight2;
        ItemInfo itemInfo3;
        ItemInfo itemInfo4;
        int count = this.f35357aa.getCount();
        int clientWidth = isPageScrollHorizontal() ? getClientWidth() : getClientHeight();
        float f10 = clientWidth > 0 ? this.f35389qa / clientWidth : 0.0f;
        if (itemInfo2 != null) {
            int i15 = itemInfo2.f35410b;
            int i16 = itemInfo.f35410b;
            if (i15 < i16) {
                float f11 = itemInfo2.f35413e + itemInfo2.f35412d + f10;
                int i17 = i15 + 1;
                int i18 = 0;
                while (i17 <= itemInfo.f35410b && i18 < this.f35367fa.size()) {
                    ItemInfo itemInfo5 = this.f35367fa.get(i18);
                    while (true) {
                        itemInfo4 = itemInfo5;
                        if (i17 <= itemInfo4.f35410b || i18 >= this.f35367fa.size() - 1) {
                            break;
                        }
                        i18++;
                        itemInfo5 = this.f35367fa.get(i18);
                    }
                    while (i17 < itemInfo4.f35410b) {
                        f11 += (isPageScrollHorizontal() ? this.f35357aa.getPageWidth(i17) : this.f35357aa.getPageHeight(i17)) + f10;
                        i17++;
                    }
                    itemInfo4.f35413e = f11;
                    f11 += itemInfo4.f35412d + f10;
                    i17++;
                }
            } else if (i15 > i16) {
                int size = this.f35367fa.size() - 1;
                float f12 = itemInfo2.f35413e;
                while (true) {
                    i15--;
                    if (i15 < itemInfo.f35410b || size < 0) {
                        break;
                    }
                    ItemInfo itemInfo6 = this.f35367fa.get(size);
                    while (true) {
                        itemInfo3 = itemInfo6;
                        if (i15 >= itemInfo3.f35410b || size <= 0) {
                            break;
                        }
                        size--;
                        itemInfo6 = this.f35367fa.get(size);
                    }
                    while (i15 > itemInfo3.f35410b) {
                        f12 -= (isPageScrollHorizontal() ? this.f35357aa.getPageWidth(i15) : this.f35357aa.getPageHeight(i15)) + f10;
                        i15--;
                    }
                    f12 -= itemInfo3.f35412d + f10;
                    itemInfo3.f35413e = f12;
                }
            }
        }
        int size2 = this.f35367fa.size();
        float f13 = itemInfo.f35413e;
        int i19 = itemInfo.f35410b;
        int i20 = i19 - 1;
        this.f35405ya = i19 == 0 ? f13 : -3.4028235E38f;
        int i21 = count - 1;
        this.f35407za = i19 == i21 ? (itemInfo.f35412d + f13) - 1.0f : Float.MAX_VALUE;
        int i22 = i10 - 1;
        while (i22 >= 0) {
            ItemInfo itemInfo7 = this.f35367fa.get(i22);
            while (true) {
                i13 = itemInfo7.f35410b;
                if (i20 <= i13) {
                    break;
                }
                if (isPageScrollHorizontal()) {
                    i14 = i20 - 1;
                    pageHeight2 = this.f35357aa.getPageWidth(i20);
                } else {
                    i14 = i20 - 1;
                    pageHeight2 = this.f35357aa.getPageHeight(i20);
                }
                f13 -= pageHeight2 + f10;
                i20 = i14;
            }
            f13 -= itemInfo7.f35412d + f10;
            itemInfo7.f35413e = f13;
            if (i13 == 0) {
                this.f35405ya = f13;
            }
            i22--;
            i20--;
        }
        float f14 = itemInfo.f35413e + itemInfo.f35412d + f10;
        int i23 = itemInfo.f35410b + 1;
        int i24 = i10 + 1;
        while (i24 < size2) {
            ItemInfo itemInfo8 = this.f35367fa.get(i24);
            while (true) {
                i11 = itemInfo8.f35410b;
                if (i23 >= i11) {
                    break;
                }
                if (isPageScrollHorizontal()) {
                    i12 = i23 + 1;
                    pageHeight = this.f35357aa.getPageWidth(i23);
                } else {
                    i12 = i23 + 1;
                    pageHeight = this.f35357aa.getPageHeight(i23);
                }
                f14 += pageHeight + f10;
                i23 = i12;
            }
            if (i11 == i21) {
                this.f35407za = (itemInfo8.f35412d + f14) - 1.0f;
            }
            itemInfo8.f35413e = f14;
            f14 += itemInfo8.f35412d + f10;
            i24++;
            i23++;
        }
        this.f35360bb = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i10, boolean z10) {
        int a10 = a(i10, this.f35357aa);
        this.Fb = false;
        setCurrentItem(a10, z10);
        this.Fb = true;
    }

    public ItemInfo a(View view) {
        while (true) {
            Object parent = view.getParent();
            if (parent != this) {
                if (parent == null || !(parent instanceof View)) {
                    return null;
                }
                view = (View) parent;
            } else {
                return b(view);
            }
        }
    }

    public ItemInfo a(int i10) {
        for (int i11 = 0; i11 < this.f35367fa.size(); i11++) {
            ItemInfo itemInfo = this.f35367fa.get(i11);
            if (itemInfo.f35410b == i10) {
                return itemInfo;
            }
        }
        return null;
    }

    private void a(int i10, int i11, int i12, Rect rect) {
        View childAt = getChildAt(i10);
        if (childAt == null) {
            return;
        }
        int i13 = rect.top;
        int i14 = rect.bottom;
        int i15 = rect.left;
        if (childAt.getVisibility() == 8 || !(childAt.getLayoutParams() instanceof LayoutParams)) {
            return;
        }
        LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
        ItemInfo b4 = b(childAt);
        if (layoutParams.isDecor || b4 == null) {
            return;
        }
        float f10 = i11;
        int i16 = (int) (b4.f35413e * f10);
        int i17 = isRtlLayout() ? i15 - i16 : i15 + i16;
        if (layoutParams.f35415b) {
            layoutParams.f35415b = false;
            childAt.measure(View.MeasureSpec.makeMeasureSpec((int) (f10 * layoutParams.f35414a), 1073741824), View.MeasureSpec.makeMeasureSpec((i12 - i13) - i14, 1073741824));
        }
        childAt.layout(i17, i13, childAt.getMeasuredWidth() + i17, childAt.getMeasuredHeight() + i13);
    }

    private void a(int i10, View view, boolean z10) {
        HwPagerAdapter adapter;
        if (!z10 || (adapter = getAdapter()) == null) {
            return;
        }
        int count = adapter.getCount() - 1;
        if (isSupportLoop() && (!isSupportLoop() || i10 == getClientWidth() * count || i10 == (-(getClientWidth() * count)))) {
            return;
        }
        a(i10, view);
    }

    private void a(int i10, View view) {
        this.f35374ib.transformPage(view, isPageScrollHorizontal() ? (isRtlLayout() ? i10 - view.getLeft() : view.getLeft() - i10) / getClientWidth() : (view.getTop() - i10) / getClientHeight());
    }

    private void a(int i10, float f10, int i11) {
        if (this.f35408zb) {
            c(i10, i11);
        }
        OnPageChangeListener onPageChangeListener = this.f35368fb;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrolled(i10, f10, i11);
        }
        List<OnPageChangeListener> list = this.f35366eb;
        if (list != null) {
            int size = list.size();
            for (int i12 = 0; i12 < size; i12++) {
                OnPageChangeListener onPageChangeListener2 = this.f35366eb.get(i12);
                if (onPageChangeListener2 != null) {
                    onPageChangeListener2.onPageScrolled(i10, f10, i11);
                }
            }
        }
        OnPageChangeListener onPageChangeListener3 = this.f35370gb;
        if (onPageChangeListener3 != null) {
            onPageChangeListener3.onPageScrolled(i10, f10, i11);
        }
    }

    private void a(boolean z10) {
        boolean z11 = this.f35382mb == 2;
        if (z11) {
            setScrollingCacheEnabled(false);
            if (this.f35390qb) {
                k();
            } else if (!this.f35383na.isFinished()) {
                this.f35383na.abortAnimation();
                a(getScrollX(), getScrollY(), this.f35383na.getCurrX(), this.f35383na.getCurrY());
            }
        }
        this.Fa = false;
        for (int i10 = 0; i10 < this.f35367fa.size(); i10++) {
            ItemInfo itemInfo = this.f35367fa.get(i10);
            if (itemInfo.f35411c) {
                itemInfo.f35411c = false;
                z11 = true;
            }
        }
        if (z11) {
            if (z10) {
                ViewCompat.postOnAnimation(this, this.f35375ja);
            } else {
                this.f35375ja.run();
            }
        }
    }

    private void a(int i10, int i11, int i12, int i13) {
        if (i10 == i12 && i11 == i13) {
            return;
        }
        scrollTo(i12, i13);
        if (i12 != i10) {
            pageScrolled(i12);
        }
    }

    private boolean a(MotionEvent motionEvent, boolean z10) {
        return this.Ha ? isPageScrollHorizontal() ? a(motionEvent) ? s() : z10 : b(motionEvent) ? s() : z10 : z10;
    }

    private void a(@NonNull MotionEvent motionEvent, int i10) {
        float x10 = motionEvent.getX(i10);
        float abs = Math.abs(x10 - this.Ma);
        float y10 = motionEvent.getY(i10);
        float abs2 = Math.abs(y10 - this.Na);
        if (abs <= this.La || abs <= abs2) {
            return;
        }
        this.Ha = true;
        c(true);
        float f10 = this.Oa;
        this.Ma = x10 - f10 > 0.0f ? f10 + this.La : f10 - this.La;
        this.Na = y10;
        setScrollState(1);
        setScrollingCacheEnabled(true);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    private boolean a(@NonNull MotionEvent motionEvent) {
        boolean z10 = false;
        if (this.Ra == -1) {
            return false;
        }
        VelocityTracker velocityTracker = this.Sa;
        velocityTracker.computeCurrentVelocity(1000, this.Ua);
        int xVelocity = (int) velocityTracker.getXVelocity(this.Ra);
        this.Fa = true;
        int clientWidth = getClientWidth();
        int scrollX = isRtlLayout() ? -getScrollX() : getScrollX();
        ItemInfo infoForCurrentScrollPosition = infoForCurrentScrollPosition();
        if (infoForCurrentScrollPosition == null) {
            return false;
        }
        float f10 = clientWidth <= 0 ? 0.0f : this.f35389qa / clientWidth;
        int i10 = infoForCurrentScrollPosition.f35410b;
        if (clientWidth > 0 && infoForCurrentScrollPosition.f35412d + f10 > 0.0f) {
            z10 = true;
        }
        setCurrentItemInternal(determineTargetPage(i10, z10 ? ((scrollX / clientWidth) - infoForCurrentScrollPosition.f35413e) / (infoForCurrentScrollPosition.f35412d + f10) : 0.0f, xVelocity, (int) (motionEvent.getX(motionEvent.findPointerIndex(this.Ra)) - this.Oa)), true, true, xVelocity);
        return true;
    }

    private boolean a(boolean z10, float f10, int i10, float f11, boolean z11) {
        if (!z11) {
            return z10;
        }
        this.Za.onPull(i10 <= 0 ? 0.0f : Math.abs(f11 - f10) / i10);
        return true;
    }

    private float a(int i10, float f10, float f11) {
        return new DynamicCurveRate(i10 * 0.5f).getRate(Math.abs(f11)) * f10;
    }

    private int a(int i10, float f10, int i11, int i12) {
        float f11;
        if (Math.abs(i12) > this.Va && Math.abs(i11) > this.Ta) {
            if (isRtlLayout()) {
                if (i11 < 0) {
                    return i10;
                }
            } else if (i11 > 0) {
                return i10;
            }
            return i10 + 1;
        }
        if (this.f35390qb) {
            f11 = 0.5f;
        } else {
            f11 = i10 >= this.f35359ba ? 0.39999998f : 0.6f;
        }
        return i10 + ((int) (f10 + f11));
    }

    private boolean a(Canvas canvas, int i10, int i11, float f10, boolean z10) {
        if (z10) {
            float f11 = f10 - this.f35389qa;
            if (f11 < i10) {
                float f12 = i11;
                this.f35391ra.setBounds(Math.round(f11 + f12), this.f35393sa, Math.round(f12 + f10), this.f35395ta);
                this.f35391ra.draw(canvas);
            }
            return f10 < ((float) (i10 - i11));
        }
        if (this.f35389qa + f10 > i10) {
            if (isPageScrollHorizontal()) {
                this.f35391ra.setBounds(Math.round(f10), this.f35393sa, Math.round(this.f35389qa + f10), this.f35395ta);
            } else {
                this.f35391ra.setBounds(this.f35397ua, Math.round(f10), this.f35399va, Math.round(this.f35389qa + f10));
            }
            this.f35391ra.draw(canvas);
        }
        return f10 > ((float) (i10 + i11));
    }

    private float a(float f10, int i10) {
        float f11;
        float f12;
        float f13;
        float f14;
        if (isRtlLayout()) {
            f11 = -i10;
            f12 = this.f35407za;
        } else {
            f11 = i10;
            f12 = this.f35405ya;
        }
        float f15 = f11 * f12;
        if (isRtlLayout()) {
            f13 = -i10;
            f14 = this.f35405ya;
        } else {
            f13 = i10;
            f14 = this.f35407za;
        }
        float f16 = f13 * f14;
        ItemInfo itemInfo = this.f35367fa.get(0);
        ItemInfo itemInfo2 = this.f35367fa.get(r3.size() - 1);
        if (itemInfo.f35410b != 0) {
            if (isRtlLayout()) {
                f16 = (-itemInfo.f35413e) * i10;
            } else {
                f15 = itemInfo.f35413e * i10;
            }
        }
        if (itemInfo2.f35410b != this.f35357aa.getCount() - 1) {
            if (isRtlLayout()) {
                f15 = (-itemInfo2.f35413e) * i10;
            } else {
                f16 = itemInfo2.f35413e * i10;
            }
        }
        return f10 < f15 ? f15 : f10 > f16 ? f16 : f10;
    }

    private Rect a(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left = viewGroup.getLeft() + rect.left;
            rect.right = viewGroup.getRight() + rect.right;
            rect.top = viewGroup.getTop() + rect.top;
            rect.bottom = viewGroup.getBottom() + rect.bottom;
            parent = viewGroup.getParent();
        }
        return rect;
    }

    private boolean a(int i10, Rect rect, int i11) {
        ItemInfo b4;
        View childAt = getChildAt(i11);
        return childAt.getVisibility() == 0 && (b4 = b(childAt)) != null && b4.f35410b == this.f35359ba && childAt.requestFocus(i10, rect);
    }

    private void a(int i10, boolean z10) {
        int a10 = a(i10, this.f35357aa);
        this.Fb = false;
        setCurrentItem(a10, z10);
        this.Fb = true;
    }

    private int a(int i10, HwPagerAdapter hwPagerAdapter) {
        return ((hwPagerAdapter instanceof com.huawei.uikit.hwviewpager.widget.d) && this.f35386ob) ? ((com.huawei.uikit.hwviewpager.widget.d) hwPagerAdapter).b(i10) : i10;
    }
}
