package com.baidu.mobads.sdk.internal.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.mobads.sdk.internal.concrete.ViewCompatDelegate;
import com.google.android.material.badge.BadgeDrawable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class ViewPager2 extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    public static final int f10364a = 0;

    /* renamed from: b, reason: collision with root package name */
    public static final int f10365b = 1;

    /* renamed from: c, reason: collision with root package name */
    public static final int f10366c = 0;

    /* renamed from: d, reason: collision with root package name */
    public static final int f10367d = 1;

    /* renamed from: e, reason: collision with root package name */
    public static final int f10368e = 2;

    /* renamed from: f, reason: collision with root package name */
    public static final int f10369f = -1;

    /* renamed from: g, reason: collision with root package name */
    public static boolean f10370g = true;
    private boolean A;
    private int B;

    /* renamed from: h, reason: collision with root package name */
    public int f10371h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f10372i;

    /* renamed from: j, reason: collision with root package name */
    public RecyclerView f10373j;

    /* renamed from: k, reason: collision with root package name */
    public ScrollEventAdapter f10374k;

    /* renamed from: l, reason: collision with root package name */
    public AccessibilityProvider f10375l;

    /* renamed from: m, reason: collision with root package name */
    private final Rect f10376m;

    /* renamed from: n, reason: collision with root package name */
    private final Rect f10377n;

    /* renamed from: o, reason: collision with root package name */
    private final int[] f10378o;

    /* renamed from: p, reason: collision with root package name */
    private CompositeOnPageChangeCallback f10379p;

    /* renamed from: q, reason: collision with root package name */
    private RecyclerView.AdapterDataObserver f10380q;

    /* renamed from: r, reason: collision with root package name */
    private LinearLayoutManager f10381r;

    /* renamed from: s, reason: collision with root package name */
    private int f10382s;

    /* renamed from: t, reason: collision with root package name */
    private Parcelable f10383t;

    /* renamed from: u, reason: collision with root package name */
    private PagerSnapHelper f10384u;

    /* renamed from: v, reason: collision with root package name */
    private CompositeOnPageChangeCallback f10385v;

    /* renamed from: w, reason: collision with root package name */
    private FakeDrag f10386w;

    /* renamed from: x, reason: collision with root package name */
    private PageTransformerAdapter f10387x;

    /* renamed from: y, reason: collision with root package name */
    private RecyclerView.ItemAnimator f10388y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f10389z;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public abstract class AccessibilityProvider {
        private AccessibilityProvider() {
        }

        public void a(@NonNull AccessibilityEvent accessibilityEvent) {
        }

        public void a(AccessibilityNodeInfo accessibilityNodeInfo) {
        }

        public void a(@Nullable RecyclerView.Adapter<?> adapter) {
        }

        public void a(@NonNull CompositeOnPageChangeCallback compositeOnPageChangeCallback, @NonNull RecyclerView recyclerView) {
        }

        public boolean a() {
            return false;
        }

        public boolean a(int i10, Bundle bundle) {
            return false;
        }

        public String b() {
            throw new IllegalStateException("Not implemented.");
        }

        public void b(@Nullable RecyclerView.Adapter<?> adapter) {
        }

        public void c() {
        }

        public void d() {
        }

        public void e() {
        }

        public void f() {
        }

        public void g() {
        }

        public boolean handlesLmPerformAccessibilityAction(int i10) {
            return false;
        }

        public boolean handlesRvGetAccessibilityClassName() {
            return false;
        }

        public void onLmInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        }

        public boolean onLmPerformAccessibilityAction(int i10) {
            throw new IllegalStateException("Not implemented.");
        }

        public CharSequence onRvGetAccessibilityClassName() {
            throw new IllegalStateException("Not implemented.");
        }

        public boolean b(int i10, Bundle bundle) {
            throw new IllegalStateException("Not implemented.");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public class BasicAccessibilityProvider extends AccessibilityProvider {
        public BasicAccessibilityProvider() {
            super();
        }

        @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.AccessibilityProvider
        public boolean handlesLmPerformAccessibilityAction(int i10) {
            return (i10 == 8192 || i10 == 4096) && !ViewPager2.this.isUserInputEnabled();
        }

        @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.AccessibilityProvider
        public boolean handlesRvGetAccessibilityClassName() {
            return true;
        }

        @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.AccessibilityProvider
        public void onLmInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            if (ViewPager2.this.isUserInputEnabled()) {
                return;
            }
            accessibilityNodeInfoCompat.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
            accessibilityNodeInfoCompat.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
            accessibilityNodeInfoCompat.setScrollable(false);
        }

        @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.AccessibilityProvider
        public boolean onLmPerformAccessibilityAction(int i10) {
            if (handlesLmPerformAccessibilityAction(i10)) {
                return false;
            }
            throw new IllegalStateException();
        }

        @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.AccessibilityProvider
        public CharSequence onRvGetAccessibilityClassName() {
            if (handlesRvGetAccessibilityClassName()) {
                return "androidx.viewpager.widget.ViewPager";
            }
            throw new IllegalStateException();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static abstract class DataSetChangeObserver extends RecyclerView.AdapterDataObserver {
        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public abstract void onChanged();

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeChanged(int i10, int i11) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeInserted(int i10, int i11) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeMoved(int i10, int i11, int i12) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeRemoved(int i10, int i11) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeChanged(int i10, int i11, @Nullable Object obj) {
            onChanged();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public class LinearLayoutManagerImpl extends LinearLayoutManager {
        public LinearLayoutManagerImpl(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        public int getExtraLayoutSpace(RecyclerView.State state) {
            int offscreenPageLimit = ViewPager2.this.getOffscreenPageLimit();
            if (offscreenPageLimit == -1) {
                return super.getExtraLayoutSpace(state);
            }
            return ViewPager2.this.b() * offscreenPageLimit;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public void onInitializeAccessibilityNodeInfo(@NonNull RecyclerView.Recycler recycler, @NonNull RecyclerView.State state, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(recycler, state, accessibilityNodeInfoCompat);
            ViewPager2.this.f10375l.onLmInitializeAccessibilityNodeInfo(accessibilityNodeInfoCompat);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean performAccessibilityAction(@NonNull RecyclerView.Recycler recycler, @NonNull RecyclerView.State state, int i10, @Nullable Bundle bundle) {
            if (ViewPager2.this.f10375l.handlesLmPerformAccessibilityAction(i10)) {
                return ViewPager2.this.f10375l.onLmPerformAccessibilityAction(i10);
            }
            return super.performAccessibilityAction(recycler, state, i10, bundle);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean requestChildRectangleOnScreen(@NonNull RecyclerView recyclerView, @NonNull View view, @NonNull Rect rect, boolean z10, boolean z11) {
            return false;
        }
    }

    @IntRange(from = 1)
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public @interface OffscreenPageLimit {
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface OnOverScrollListener {
        void onOverScrollEnd();

        void onOverScrollStart();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static abstract class OnPageChangeCallback {
        public void onPageScrollStateChanged(int i10) {
        }

        public void onPageScrolled(int i10, float f10, @Px int i11) {
        }

        public void onPageSelected(int i10) {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public @interface Orientation {
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface PageTransformer {
        void transformPage(@NonNull View view, float f10);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public class PagerSnapHelperImpl extends PagerSnapHelper {
        public PagerSnapHelperImpl() {
        }

        @Override // com.baidu.mobads.sdk.internal.widget.PagerSnapHelper, androidx.recyclerview.widget.SnapHelper
        @Nullable
        public View findSnapView(RecyclerView.LayoutManager layoutManager) {
            if (ViewPager2.this.isFakeDragging()) {
                return null;
            }
            return super.findSnapView(layoutManager);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public class RecyclerViewImpl extends RecyclerView {
        public RecyclerViewImpl(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, androidx.core.view.NestedScrollingChild2
        public boolean dispatchNestedScroll(int i10, int i11, int i12, int i13, int[] iArr, int i14) {
            ViewPager2.this.f10378o[1] = ViewPager2.this.f10378o[0];
            if (1 == ViewPager2.this.getOrientation()) {
                ViewPager2.this.f10378o[0] = i13;
            } else {
                ViewPager2.this.f10378o[0] = i12;
            }
            return super.dispatchNestedScroll(i10, i11, i12, i13, iArr, i14);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
        @RequiresApi(23)
        public CharSequence getAccessibilityClassName() {
            if (ViewPager2.this.f10375l.handlesRvGetAccessibilityClassName()) {
                return ViewPager2.this.f10375l.onRvGetAccessibilityClassName();
            }
            return super.getAccessibilityClassName();
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setFromIndex(ViewPager2.this.f10371h);
            accessibilityEvent.setToIndex(ViewPager2.this.f10371h);
            ViewPager2.this.f10375l.a(accessibilityEvent);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            return ViewPager2.this.isUserInputEnabled() && super.onInterceptTouchEvent(motionEvent);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return ViewPager2.this.isUserInputEnabled() && super.onTouchEvent(motionEvent);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public @interface ScrollState {
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class SmoothScrollToPosition implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final int f10408a;

        /* renamed from: b, reason: collision with root package name */
        private final RecyclerView f10409b;

        public SmoothScrollToPosition(int i10, RecyclerView recyclerView) {
            this.f10408a = i10;
            this.f10409b = recyclerView;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f10409b.smoothScrollToPosition(this.f10408a);
        }
    }

    public ViewPager2(@NonNull Context context) {
        super(context);
        this.f10376m = new Rect();
        this.f10377n = new Rect();
        this.f10378o = new int[2];
        this.f10379p = new CompositeOnPageChangeCallback(3);
        this.f10372i = false;
        this.f10380q = new DataSetChangeObserver() { // from class: com.baidu.mobads.sdk.internal.widget.ViewPager2.1
            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                ViewPager2 viewPager2 = ViewPager2.this;
                viewPager2.f10372i = true;
                viewPager2.f10374k.a();
            }
        };
        this.f10382s = -1;
        this.f10388y = null;
        this.f10389z = false;
        this.A = true;
        this.B = -1;
        a(context, (AttributeSet) null);
    }

    private void b(@Nullable RecyclerView.Adapter<?> adapter) {
        if (adapter != null) {
            adapter.unregisterAdapterDataObserver(this.f10380q);
        }
    }

    private RecyclerView.OnChildAttachStateChangeListener e() {
        return new RecyclerView.OnChildAttachStateChangeListener() { // from class: com.baidu.mobads.sdk.internal.widget.ViewPager2.4
            @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
            public void onChildViewAttachedToWindow(@NonNull View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                if (layoutParams.width != -1 || layoutParams.height != -1) {
                    throw new IllegalStateException("Pages must fill the whole ViewPager2 (use match_parent)");
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
            public void onChildViewDetachedFromWindow(@NonNull View view) {
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void f() {
        RecyclerView.Adapter adapter;
        if (this.f10382s == -1 || (adapter = getAdapter()) == 0) {
            return;
        }
        Parcelable parcelable = this.f10383t;
        if (parcelable != null) {
            if (adapter instanceof StatefulAdapter) {
                ((StatefulAdapter) adapter).restoreState(parcelable);
            }
            this.f10383t = null;
        }
        int max = Math.max(0, Math.min(this.f10382s, adapter.getItemCount() - 1));
        this.f10371h = max;
        this.f10382s = -1;
        this.f10373j.scrollToPosition(max);
        this.f10375l.c();
    }

    public void addItemDecoration(@NonNull RecyclerView.ItemDecoration itemDecoration) {
        this.f10373j.addItemDecoration(itemDecoration);
    }

    public boolean beginFakeDrag() {
        return this.f10386w.b();
    }

    public boolean c() {
        return this.f10381r.getLayoutDirection() == 1;
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i10) {
        return this.f10373j.canScrollHorizontally(i10);
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i10) {
        return this.f10373j.canScrollVertically(i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        View findSnapView = this.f10384u.findSnapView(this.f10381r);
        if (findSnapView == null) {
            return;
        }
        int[] calculateDistanceToFinalSnap = this.f10384u.calculateDistanceToFinalSnap(this.f10381r, findSnapView);
        if (calculateDistanceToFinalSnap[0] == 0 && calculateDistanceToFinalSnap[1] == 0) {
            return;
        }
        this.f10373j.smoothScrollBy(calculateDistanceToFinalSnap[0], calculateDistanceToFinalSnap[1]);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        Parcelable parcelable = sparseArray.get(getId());
        if (parcelable instanceof SavedState) {
            int i10 = ((SavedState) parcelable).f10405a;
            sparseArray.put(this.f10373j.getId(), sparseArray.get(i10));
            sparseArray.remove(i10);
        }
        super.dispatchRestoreInstanceState(sparseArray);
        f();
    }

    public boolean endFakeDrag() {
        return this.f10386w.c();
    }

    public boolean fakeDragBy(@Px float f10) {
        return this.f10386w.a(f10);
    }

    @Override // android.view.ViewGroup, android.view.View
    @RequiresApi(23)
    public CharSequence getAccessibilityClassName() {
        if (this.f10375l.a()) {
            return this.f10375l.b();
        }
        return super.getAccessibilityClassName();
    }

    @Nullable
    public RecyclerView.Adapter getAdapter() {
        return this.f10373j.getAdapter();
    }

    public int getCurrentItem() {
        return this.f10371h;
    }

    @NonNull
    public RecyclerView.ItemDecoration getItemDecorationAt(int i10) {
        return this.f10373j.getItemDecorationAt(i10);
    }

    public int getItemDecorationCount() {
        return this.f10373j.getItemDecorationCount();
    }

    public int getOffscreenPageLimit() {
        return this.B;
    }

    public int getOrientation() {
        return this.f10381r.getOrientation();
    }

    public int getOverScrolledDirection() {
        int[] iArr = this.f10378o;
        if (iArr[0] == 0) {
            return iArr[1];
        }
        return iArr[0];
    }

    public int getScrollState() {
        return this.f10374k.d();
    }

    public void invalidateItemDecorations() {
        this.f10373j.invalidateItemDecorations();
    }

    public boolean isFakeDragging() {
        return this.f10386w.a();
    }

    public boolean isUserInputEnabled() {
        return this.A;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        this.f10375l.a(accessibilityNodeInfo);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int measuredWidth = this.f10373j.getMeasuredWidth();
        int measuredHeight = this.f10373j.getMeasuredHeight();
        this.f10376m.left = getPaddingLeft();
        this.f10376m.right = (i12 - i10) - getPaddingRight();
        this.f10376m.top = getPaddingTop();
        this.f10376m.bottom = (i13 - i11) - getPaddingBottom();
        Gravity.apply(BadgeDrawable.TOP_START, measuredWidth, measuredHeight, this.f10376m, this.f10377n);
        RecyclerView recyclerView = this.f10373j;
        Rect rect = this.f10377n;
        recyclerView.layout(rect.left, rect.top, rect.right, rect.bottom);
        if (this.f10372i) {
            a();
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        measureChild(this.f10373j, i10, i11);
        int measuredWidth = this.f10373j.getMeasuredWidth();
        int measuredHeight = this.f10373j.getMeasuredHeight();
        int measuredState = this.f10373j.getMeasuredState();
        int paddingLeft = measuredWidth + getPaddingLeft() + getPaddingRight();
        int paddingTop = measuredHeight + getPaddingTop() + getPaddingBottom();
        setMeasuredDimension(ViewGroup.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i10, measuredState), ViewGroup.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i11, measuredState << 16));
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f10382s = savedState.f10406b;
        this.f10383t = savedState.f10407c;
    }

    @Override // android.view.View
    @Nullable
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f10405a = this.f10373j.getId();
        int i10 = this.f10382s;
        if (i10 == -1) {
            i10 = this.f10371h;
        }
        savedState.f10406b = i10;
        Parcelable parcelable = this.f10383t;
        if (parcelable != null) {
            savedState.f10407c = parcelable;
        } else {
            Object adapter = this.f10373j.getAdapter();
            if (adapter instanceof StatefulAdapter) {
                savedState.f10407c = ((StatefulAdapter) adapter).saveState();
            }
        }
        return savedState;
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        throw new IllegalStateException(getClass().getSimpleName() + " does not support direct child views");
    }

    @Override // android.view.View
    @RequiresApi(16)
    public boolean performAccessibilityAction(int i10, Bundle bundle) {
        if (this.f10375l.a(i10, bundle)) {
            return this.f10375l.b(i10, bundle);
        }
        return super.performAccessibilityAction(i10, bundle);
    }

    public void registerOnPageChangeCallback(@NonNull OnPageChangeCallback onPageChangeCallback) {
        this.f10379p.a(onPageChangeCallback);
    }

    public void removeItemDecoration(@NonNull RecyclerView.ItemDecoration itemDecoration) {
        this.f10373j.removeItemDecoration(itemDecoration);
    }

    public void removeItemDecorationAt(int i10) {
        this.f10373j.removeItemDecorationAt(i10);
    }

    public void requestTransform() {
        if (this.f10387x.a() == null) {
            return;
        }
        double h10 = this.f10374k.h();
        int i10 = (int) h10;
        float f10 = (float) (h10 - i10);
        this.f10387x.onPageScrolled(i10, f10, Math.round(b() * f10));
    }

    public void setAdapter(@Nullable RecyclerView.Adapter adapter) {
        RecyclerView.Adapter adapter2 = this.f10373j.getAdapter();
        this.f10375l.b(adapter2);
        b(adapter2);
        this.f10373j.setAdapter(adapter);
        this.f10371h = 0;
        f();
        this.f10375l.a((RecyclerView.Adapter<?>) adapter);
        a((RecyclerView.Adapter<?>) adapter);
    }

    public void setCurrentItem(int i10) {
        setCurrentItem(i10, true);
    }

    @Override // android.view.View
    @RequiresApi(17)
    public void setLayoutDirection(int i10) {
        super.setLayoutDirection(i10);
        this.f10375l.g();
    }

    public void setOffscreenPageLimit(int i10) {
        if (i10 < 1 && i10 != -1) {
            throw new IllegalArgumentException("Offscreen page limit must be OFFSCREEN_PAGE_LIMIT_DEFAULT or a number > 0");
        }
        this.B = i10;
        this.f10373j.requestLayout();
    }

    public void setOnOverScrollListener(final OnOverScrollListener onOverScrollListener) {
        if (onOverScrollListener == null) {
            return;
        }
        registerOnPageChangeCallback(new OnPageChangeCallback() { // from class: com.baidu.mobads.sdk.internal.widget.ViewPager2.5

            /* renamed from: a, reason: collision with root package name */
            public boolean f10394a = false;

            /* renamed from: b, reason: collision with root package name */
            public boolean f10395b = false;

            /* renamed from: c, reason: collision with root package name */
            public boolean f10396c = false;

            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
            public void onPageScrollStateChanged(int i10) {
                if (i10 != 0) {
                    if (i10 == 1) {
                        this.f10396c = true;
                        return;
                    } else {
                        if (i10 != 2) {
                            return;
                        }
                        this.f10394a = false;
                        this.f10395b = false;
                        return;
                    }
                }
                RecyclerView.Adapter adapter = ViewPager2.this.getAdapter();
                if (adapter == null || adapter.getItemCount() <= 0 || !this.f10396c) {
                    return;
                }
                if (1 == ViewPager2.this.getOrientation()) {
                    if (!ViewPager2.this.canScrollVertically(-1) && ViewPager2.this.getOverScrolledDirection() < 0) {
                        onOverScrollListener.onOverScrollStart();
                    } else if (!ViewPager2.this.canScrollVertically(1) && ViewPager2.this.getOverScrolledDirection() > 0) {
                        onOverScrollListener.onOverScrollEnd();
                    }
                } else if (ViewPager2.this.getOrientation() == 0) {
                    if (!ViewPager2.this.canScrollHorizontally(-1) && ViewPager2.this.getOverScrolledDirection() < 0) {
                        onOverScrollListener.onOverScrollStart();
                    } else if (!ViewPager2.this.canScrollHorizontally(1) && ViewPager2.this.getOverScrolledDirection() > 0) {
                        onOverScrollListener.onOverScrollEnd();
                    }
                }
                this.f10396c = false;
            }
        });
    }

    public void setOrientation(int i10) {
        this.f10381r.setOrientation(i10);
        this.f10375l.d();
    }

    public void setPageTransformer(@Nullable PageTransformer pageTransformer) {
        if (pageTransformer != null) {
            if (!this.f10389z) {
                this.f10388y = this.f10373j.getItemAnimator();
                this.f10389z = true;
            }
            this.f10373j.setItemAnimator(null);
        } else if (this.f10389z) {
            this.f10373j.setItemAnimator(this.f10388y);
            this.f10388y = null;
            this.f10389z = false;
        }
        if (pageTransformer == this.f10387x.a()) {
            return;
        }
        this.f10387x.a(pageTransformer);
        requestTransform();
    }

    public void setUserInputEnabled(boolean z10) {
        this.A = z10;
        this.f10375l.f();
    }

    public void unregisterOnPageChangeCallback(@NonNull OnPageChangeCallback onPageChangeCallback) {
        this.f10379p.b(onPageChangeCallback);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class SavedState extends View.BaseSavedState {

        /* renamed from: d, reason: collision with root package name */
        public static final Parcelable.Creator<SavedState> f10404d = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.baidu.mobads.sdk.internal.widget.ViewPager2.SavedState.1
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return Build.VERSION.SDK_INT >= 24 ? new SavedState(parcel, classLoader) : new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return createFromParcel(parcel, (ClassLoader) null);
            }
        };

        /* renamed from: a, reason: collision with root package name */
        public int f10405a;

        /* renamed from: b, reason: collision with root package name */
        public int f10406b;

        /* renamed from: c, reason: collision with root package name */
        public Parcelable f10407c;

        @RequiresApi(24)
        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            a(parcel, classLoader);
        }

        private void a(Parcel parcel, ClassLoader classLoader) {
            this.f10405a = parcel.readInt();
            this.f10406b = parcel.readInt();
            this.f10407c = parcel.readParcelable(classLoader);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f10405a);
            parcel.writeInt(this.f10406b);
            parcel.writeParcelable(this.f10407c, i10);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            a(parcel, null);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    private void a(Context context, AttributeSet attributeSet) {
        this.f10375l = new BasicAccessibilityProvider();
        RecyclerViewImpl recyclerViewImpl = new RecyclerViewImpl(context);
        this.f10373j = recyclerViewImpl;
        recyclerViewImpl.setId(ViewCompatDelegate.generateViewId());
        this.f10373j.setDescendantFocusability(131072);
        LinearLayoutManagerImpl linearLayoutManagerImpl = new LinearLayoutManagerImpl(context);
        this.f10381r = linearLayoutManagerImpl;
        this.f10373j.setLayoutManager(linearLayoutManagerImpl);
        this.f10373j.setScrollingTouchSlop(1);
        setOrientation(0);
        this.f10373j.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f10373j.addOnChildAttachStateChangeListener(e());
        ScrollEventAdapter scrollEventAdapter = new ScrollEventAdapter(this);
        this.f10374k = scrollEventAdapter;
        this.f10386w = new FakeDrag(this, scrollEventAdapter, this.f10373j);
        PagerSnapHelperImpl pagerSnapHelperImpl = new PagerSnapHelperImpl();
        this.f10384u = pagerSnapHelperImpl;
        pagerSnapHelperImpl.attachToRecyclerView(this.f10373j);
        this.f10373j.addOnScrollListener(this.f10374k);
        CompositeOnPageChangeCallback compositeOnPageChangeCallback = new CompositeOnPageChangeCallback(3);
        this.f10385v = compositeOnPageChangeCallback;
        this.f10374k.a(compositeOnPageChangeCallback);
        OnPageChangeCallback onPageChangeCallback = new OnPageChangeCallback() { // from class: com.baidu.mobads.sdk.internal.widget.ViewPager2.2
            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
            public void onPageScrollStateChanged(int i10) {
                if (i10 == 0) {
                    ViewPager2.this.a();
                }
            }

            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i10) {
                ViewPager2 viewPager2 = ViewPager2.this;
                if (viewPager2.f10371h != i10) {
                    viewPager2.f10371h = i10;
                    viewPager2.f10375l.e();
                }
            }
        };
        OnPageChangeCallback onPageChangeCallback2 = new OnPageChangeCallback() { // from class: com.baidu.mobads.sdk.internal.widget.ViewPager2.3
            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i10) {
                ViewPager2.this.clearFocus();
                if (ViewPager2.this.hasFocus()) {
                    ViewPager2.this.f10373j.requestFocus(2);
                }
            }
        };
        this.f10385v.a(onPageChangeCallback);
        this.f10385v.a(onPageChangeCallback2);
        this.f10375l.a(this.f10385v, this.f10373j);
        this.f10385v.a(this.f10379p);
        PageTransformerAdapter pageTransformerAdapter = new PageTransformerAdapter(this.f10381r);
        this.f10387x = pageTransformerAdapter;
        this.f10385v.a(pageTransformerAdapter);
        RecyclerView recyclerView = this.f10373j;
        attachViewToParent(recyclerView, 0, recyclerView.getLayoutParams());
    }

    public void addItemDecoration(@NonNull RecyclerView.ItemDecoration itemDecoration, int i10) {
        this.f10373j.addItemDecoration(itemDecoration, i10);
    }

    public int b() {
        int height;
        int paddingBottom;
        RecyclerView recyclerView = this.f10373j;
        if (getOrientation() == 0) {
            height = recyclerView.getWidth() - recyclerView.getPaddingLeft();
            paddingBottom = recyclerView.getPaddingRight();
        } else {
            height = recyclerView.getHeight() - recyclerView.getPaddingTop();
            paddingBottom = recyclerView.getPaddingBottom();
        }
        return height - paddingBottom;
    }

    public void setCurrentItem(int i10, boolean z10) {
        if (!isFakeDragging()) {
            a(i10, z10);
            return;
        }
        throw new IllegalStateException("Cannot change current item when ViewPager2 is fake dragging");
    }

    public ViewPager2(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f10376m = new Rect();
        this.f10377n = new Rect();
        this.f10378o = new int[2];
        this.f10379p = new CompositeOnPageChangeCallback(3);
        this.f10372i = false;
        this.f10380q = new DataSetChangeObserver() { // from class: com.baidu.mobads.sdk.internal.widget.ViewPager2.1
            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                ViewPager2 viewPager2 = ViewPager2.this;
                viewPager2.f10372i = true;
                viewPager2.f10374k.a();
            }
        };
        this.f10382s = -1;
        this.f10388y = null;
        this.f10389z = false;
        this.A = true;
        this.B = -1;
        a(context, attributeSet);
    }

    public ViewPager2(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f10376m = new Rect();
        this.f10377n = new Rect();
        this.f10378o = new int[2];
        this.f10379p = new CompositeOnPageChangeCallback(3);
        this.f10372i = false;
        this.f10380q = new DataSetChangeObserver() { // from class: com.baidu.mobads.sdk.internal.widget.ViewPager2.1
            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                ViewPager2 viewPager2 = ViewPager2.this;
                viewPager2.f10372i = true;
                viewPager2.f10374k.a();
            }
        };
        this.f10382s = -1;
        this.f10388y = null;
        this.f10389z = false;
        this.A = true;
        this.B = -1;
        a(context, attributeSet);
    }

    private void a(@Nullable RecyclerView.Adapter<?> adapter) {
        if (adapter != null) {
            adapter.registerAdapterDataObserver(this.f10380q);
        }
    }

    void a() {
        PagerSnapHelper pagerSnapHelper = this.f10384u;
        if (pagerSnapHelper != null) {
            View findSnapView = pagerSnapHelper.findSnapView(this.f10381r);
            if (findSnapView == null) {
                return;
            }
            int position = this.f10381r.getPosition(findSnapView);
            if (position != this.f10371h && getScrollState() == 0) {
                this.f10385v.onPageSelected(position);
            }
            this.f10372i = false;
            return;
        }
        throw new IllegalStateException("Design assumption violated.");
    }

    public void a(int i10, boolean z10) {
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter == null) {
            if (this.f10382s != -1) {
                this.f10382s = Math.max(i10, 0);
                return;
            }
            return;
        }
        if (adapter.getItemCount() <= 0) {
            return;
        }
        int min = Math.min(Math.max(i10, 0), adapter.getItemCount() - 1);
        if (min == this.f10371h && this.f10374k.e()) {
            return;
        }
        int i11 = this.f10371h;
        if (min == i11 && z10) {
            return;
        }
        double d10 = i11;
        this.f10371h = min;
        this.f10375l.e();
        if (!this.f10374k.e()) {
            d10 = this.f10374k.h();
        }
        this.f10374k.a(min, z10);
        if (!z10) {
            this.f10373j.scrollToPosition(min);
            return;
        }
        double d11 = min;
        if (Math.abs(d11 - d10) > 3.0d) {
            this.f10373j.scrollToPosition(d11 > d10 ? min - 3 : min + 3);
            RecyclerView recyclerView = this.f10373j;
            recyclerView.post(new SmoothScrollToPosition(min, recyclerView));
            return;
        }
        this.f10373j.smoothScrollToPosition(min);
    }

    @RequiresApi(21)
    public ViewPager2(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.f10376m = new Rect();
        this.f10377n = new Rect();
        this.f10378o = new int[2];
        this.f10379p = new CompositeOnPageChangeCallback(3);
        this.f10372i = false;
        this.f10380q = new DataSetChangeObserver() { // from class: com.baidu.mobads.sdk.internal.widget.ViewPager2.1
            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                ViewPager2 viewPager2 = ViewPager2.this;
                viewPager2.f10372i = true;
                viewPager2.f10374k.a();
            }
        };
        this.f10382s = -1;
        this.f10388y = null;
        this.f10389z = false;
        this.A = true;
        this.B = -1;
        a(context, attributeSet);
    }
}
