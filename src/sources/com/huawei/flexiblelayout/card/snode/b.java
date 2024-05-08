package com.huawei.flexiblelayout.card.snode;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.core.text.TextUtilsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.flexiblelayout.log.Log;
import java.util.Locale;

/* compiled from: HorizontalSnapHelper.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class b extends LinearSnapHelper {

    /* renamed from: n, reason: collision with root package name */
    private static final String f27903n = "HorizontalSnapHelper";

    /* renamed from: o, reason: collision with root package name */
    public static final int f27904o = -1;

    /* renamed from: p, reason: collision with root package name */
    public static final float f27905p = -1.0f;

    /* renamed from: a, reason: collision with root package name */
    private int f27906a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f27907b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f27908c;

    /* renamed from: d, reason: collision with root package name */
    private int f27909d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f27910e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f27911f;

    /* renamed from: g, reason: collision with root package name */
    private float f27912g;

    /* renamed from: h, reason: collision with root package name */
    private int f27913h;

    /* renamed from: i, reason: collision with root package name */
    private float f27914i;

    /* renamed from: j, reason: collision with root package name */
    private OrientationHelper f27915j;

    /* renamed from: k, reason: collision with root package name */
    private c f27916k;

    /* renamed from: l, reason: collision with root package name */
    private RecyclerView f27917l;

    /* renamed from: m, reason: collision with root package name */
    private RecyclerView.OnScrollListener f27918m;

    /* compiled from: HorizontalSnapHelper.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class a extends RecyclerView.OnScrollListener {
        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i10) {
            super.onScrollStateChanged(recyclerView, i10);
            b.this.e(i10);
        }
    }

    /* compiled from: HorizontalSnapHelper.java */
    /* renamed from: com.huawei.flexiblelayout.card.snode.b$b, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class C0266b extends LinearSmoothScroller {
        public C0266b(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
            return b.this.f27912g / displayMetrics.densityDpi;
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
        public void onTargetFound(View view, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
            if (b.this.f27917l == null || b.this.f27917l.getLayoutManager() == null) {
                return;
            }
            b bVar = b.this;
            int[] calculateDistanceToFinalSnap = bVar.calculateDistanceToFinalSnap(bVar.f27917l.getLayoutManager(), view);
            int i10 = calculateDistanceToFinalSnap[0];
            int i11 = calculateDistanceToFinalSnap[1];
            int calculateTimeForDeceleration = calculateTimeForDeceleration(Math.max(Math.abs(i10), Math.abs(i11)));
            if (calculateTimeForDeceleration > 0) {
                action.update(i10, i11, calculateTimeForDeceleration, this.mDecelerateInterpolator);
            }
        }
    }

    /* compiled from: HorizontalSnapHelper.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface c {
        void a(int i10);
    }

    public b(int i10) {
        this(i10, false, null);
    }

    private void h() {
        View a10;
        int childAdapterPosition;
        RecyclerView.LayoutManager layoutManager = this.f27917l.getLayoutManager();
        if (layoutManager == null || (a10 = a(layoutManager, false)) == null || (childAdapterPosition = this.f27917l.getChildAdapterPosition(a10)) == -1) {
            return;
        }
        this.f27916k.a(childAdapterPosition);
    }

    private int i() {
        if (this.f27914i != -1.0f) {
            if (this.f27915j != null) {
                return (int) (this.f27917l.getWidth() * this.f27914i);
            }
            return Integer.MAX_VALUE;
        }
        int i10 = this.f27913h;
        if (i10 != -1) {
            return i10;
        }
        return Integer.MAX_VALUE;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public void attachToRecyclerView(@Nullable RecyclerView recyclerView) throws IllegalStateException {
        RecyclerView recyclerView2 = this.f27917l;
        if (recyclerView2 != null) {
            recyclerView2.removeOnScrollListener(this.f27918m);
        }
        if (recyclerView != null) {
            recyclerView.setOnFlingListener(null);
            int i10 = this.f27906a;
            if (i10 == 8388611 || i10 == 8388613) {
                this.f27907b = TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
            }
            recyclerView.addOnScrollListener(this.f27918m);
            this.f27917l = recyclerView;
        } else {
            this.f27917l = null;
        }
        super.attachToRecyclerView(recyclerView);
    }

    public int c() {
        return this.f27913h;
    }

    @Override // androidx.recyclerview.widget.LinearSnapHelper, androidx.recyclerview.widget.SnapHelper
    @NonNull
    public int[] calculateDistanceToFinalSnap(@NonNull RecyclerView.LayoutManager layoutManager, @NonNull View view) {
        if (this.f27906a == 17) {
            return super.calculateDistanceToFinalSnap(layoutManager, view);
        }
        int[] iArr = new int[2];
        if (!(layoutManager instanceof LinearLayoutManager)) {
            return iArr;
        }
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        if (linearLayoutManager.canScrollHorizontally()) {
            boolean z10 = this.f27907b;
            if ((z10 && this.f27906a == 8388613) || (!z10 && this.f27906a == 8388611)) {
                iArr[0] = b(view, a((RecyclerView.LayoutManager) linearLayoutManager));
            } else {
                iArr[0] = a(view, a((RecyclerView.LayoutManager) linearLayoutManager));
            }
        } else {
            Log.w(f27903n, "calculateDistanceToFinalSnap, canScrollVertically");
        }
        return iArr;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    @NonNull
    public int[] calculateScrollDistance(int i10, int i11) {
        if (this.f27917l != null && this.f27915j != null && (this.f27913h != -1 || this.f27914i != -1.0f)) {
            Scroller scroller = new Scroller(this.f27917l.getContext(), new DecelerateInterpolator());
            int i12 = i();
            int i13 = -i12;
            scroller.fling(0, 0, i10, i11, i13, i12, i13, i12);
            return new int[]{scroller.getFinalX(), scroller.getFinalY()};
        }
        return super.calculateScrollDistance(i10, i11);
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    @Nullable
    public RecyclerView.SmoothScroller createScroller(RecyclerView.LayoutManager layoutManager) {
        RecyclerView recyclerView;
        if (!(layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) || (recyclerView = this.f27917l) == null) {
            return null;
        }
        return new C0266b(recyclerView.getContext());
    }

    public boolean d(int i10) {
        if (i10 == -1) {
            return false;
        }
        return a(i10, true);
    }

    public float e() {
        return this.f27912g;
    }

    public boolean f() {
        return this.f27908c;
    }

    @Override // androidx.recyclerview.widget.LinearSnapHelper, androidx.recyclerview.widget.SnapHelper
    @Nullable
    public View findSnapView(@NonNull RecyclerView.LayoutManager layoutManager) {
        return a(layoutManager, true);
    }

    public boolean g() {
        return this.f27911f;
    }

    public b(int i10, boolean z10, @Nullable c cVar) {
        this.f27910e = false;
        this.f27911f = false;
        this.f27912g = 100.0f;
        this.f27913h = -1;
        this.f27914i = -1.0f;
        this.f27918m = new a();
        if (i10 != 8388611 && i10 != 8388613 && i10 != 17) {
            throw new IllegalArgumentException("Invalid gravity value. Use START | END | CENTER constants");
        }
        this.f27908c = z10;
        this.f27906a = i10;
        this.f27916k = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i10) {
        c cVar;
        if (i10 == 0 && (cVar = this.f27916k) != null && this.f27910e) {
            int i11 = this.f27909d;
            if (i11 != -1) {
                cVar.a(i11);
            } else {
                h();
            }
        }
        this.f27910e = i10 != 0;
    }

    public int b() {
        return this.f27906a;
    }

    public void c(@Px int i10) {
        this.f27913h = i10;
        this.f27914i = -1.0f;
    }

    public float d() {
        return this.f27914i;
    }

    @Nullable
    public View a(@NonNull RecyclerView.LayoutManager layoutManager, boolean z10) {
        View a10;
        int i10 = this.f27906a;
        if (i10 != 17) {
            if (i10 != 8388611) {
                if (i10 == 8388613) {
                    a10 = a(layoutManager, a(layoutManager), 8388613, z10);
                }
                a10 = null;
            } else {
                a10 = a(layoutManager, a(layoutManager), 8388611, z10);
            }
        } else if (layoutManager.canScrollHorizontally()) {
            a10 = a(layoutManager, a(layoutManager), 17, z10);
        } else {
            Log.w(f27903n, "findSnapView, canScrollVertically");
            a10 = null;
        }
        if (a10 != null) {
            this.f27909d = this.f27917l.getChildAdapterPosition(a10);
        } else {
            this.f27909d = -1;
        }
        return a10;
    }

    public void b(int i10) {
        a(i10, Boolean.TRUE);
    }

    public void b(float f10) {
        this.f27912g = f10;
    }

    public void b(boolean z10) {
        this.f27911f = z10;
    }

    private int b(View view, @NonNull OrientationHelper orientationHelper) {
        int decoratedStart;
        int startAfterPadding;
        if (!this.f27911f) {
            decoratedStart = orientationHelper.getDecoratedStart(view);
            if (decoratedStart < orientationHelper.getStartAfterPadding() / 2) {
                return decoratedStart;
            }
            startAfterPadding = orientationHelper.getStartAfterPadding();
        } else {
            decoratedStart = orientationHelper.getDecoratedStart(view);
            startAfterPadding = orientationHelper.getStartAfterPadding();
        }
        return decoratedStart - startAfterPadding;
    }

    public void a(@Nullable c cVar) {
        this.f27916k = cVar;
    }

    public void a(int i10, Boolean bool) {
        if (this.f27906a != i10) {
            this.f27906a = i10;
            a(bool, Boolean.FALSE);
        }
    }

    public void a(Boolean bool, Boolean bool2) {
        RecyclerView.LayoutManager layoutManager;
        View a10;
        RecyclerView recyclerView = this.f27917l;
        if (recyclerView == null || recyclerView.getLayoutManager() == null || (a10 = a((layoutManager = this.f27917l.getLayoutManager()), bool2.booleanValue())) == null) {
            return;
        }
        int[] calculateDistanceToFinalSnap = calculateDistanceToFinalSnap(layoutManager, a10);
        if (bool.booleanValue()) {
            this.f27917l.smoothScrollBy(calculateDistanceToFinalSnap[0], calculateDistanceToFinalSnap[1]);
        } else {
            this.f27917l.scrollBy(calculateDistanceToFinalSnap[0], calculateDistanceToFinalSnap[1]);
        }
    }

    public boolean a(int i10) {
        if (i10 == -1) {
            return false;
        }
        return a(i10, false);
    }

    public void a(boolean z10) {
        this.f27908c = z10;
    }

    public void a(float f10) {
        this.f27913h = -1;
        this.f27914i = f10;
    }

    public int a() {
        View findSnapView;
        RecyclerView recyclerView = this.f27917l;
        if (recyclerView == null || recyclerView.getLayoutManager() == null || (findSnapView = findSnapView(this.f27917l.getLayoutManager())) == null) {
            return -1;
        }
        return this.f27917l.getChildAdapterPosition(findSnapView);
    }

    private boolean a(int i10, boolean z10) {
        if (this.f27917l.getLayoutManager() != null) {
            if (z10) {
                RecyclerView.SmoothScroller createScroller = createScroller(this.f27917l.getLayoutManager());
                if (createScroller != null) {
                    createScroller.setTargetPosition(i10);
                    this.f27917l.getLayoutManager().startSmoothScroll(createScroller);
                    return true;
                }
            } else {
                RecyclerView.ViewHolder findViewHolderForAdapterPosition = this.f27917l.findViewHolderForAdapterPosition(i10);
                if (findViewHolderForAdapterPosition != null) {
                    int[] calculateDistanceToFinalSnap = calculateDistanceToFinalSnap(this.f27917l.getLayoutManager(), findViewHolderForAdapterPosition.itemView);
                    this.f27917l.scrollBy(calculateDistanceToFinalSnap[0], calculateDistanceToFinalSnap[1]);
                    return true;
                }
            }
        }
        return false;
    }

    private int a(View view, @NonNull OrientationHelper orientationHelper) {
        int decoratedEnd;
        int endAfterPadding;
        if (!this.f27911f) {
            int decoratedEnd2 = orientationHelper.getDecoratedEnd(view);
            if (decoratedEnd2 >= orientationHelper.getEnd() - ((orientationHelper.getEnd() - orientationHelper.getEndAfterPadding()) / 2)) {
                decoratedEnd = orientationHelper.getDecoratedEnd(view);
                endAfterPadding = orientationHelper.getEnd();
            } else {
                return decoratedEnd2 - orientationHelper.getEndAfterPadding();
            }
        } else {
            decoratedEnd = orientationHelper.getDecoratedEnd(view);
            endAfterPadding = orientationHelper.getEndAfterPadding();
        }
        return decoratedEnd - endAfterPadding;
    }

    @Nullable
    private View a(@NonNull RecyclerView.LayoutManager layoutManager, @NonNull OrientationHelper orientationHelper, int i10, boolean z10) {
        int end;
        int abs;
        View view = null;
        if (layoutManager.getChildCount() != 0 && (layoutManager instanceof LinearLayoutManager)) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            if (z10 && a(linearLayoutManager) && !this.f27908c) {
                return null;
            }
            int i11 = Integer.MAX_VALUE;
            if (layoutManager.getClipToPadding()) {
                end = orientationHelper.getStartAfterPadding() + (orientationHelper.getTotalSpace() / 2);
            } else {
                end = orientationHelper.getEnd() / 2;
            }
            boolean z11 = true;
            boolean z12 = (i10 == 8388611 && !this.f27907b) || (i10 == 8388613 && this.f27907b);
            if ((i10 != 8388611 || !this.f27907b) && (i10 != 8388613 || this.f27907b)) {
                z11 = false;
            }
            for (int i12 = 0; i12 < linearLayoutManager.getChildCount(); i12++) {
                View childAt = linearLayoutManager.getChildAt(i12);
                if (z12) {
                    if (!this.f27911f) {
                        abs = Math.abs(orientationHelper.getDecoratedStart(childAt));
                    } else {
                        abs = Math.abs(orientationHelper.getStartAfterPadding() - orientationHelper.getDecoratedStart(childAt));
                    }
                } else if (z11) {
                    if (!this.f27911f) {
                        abs = Math.abs(orientationHelper.getDecoratedEnd(childAt) - orientationHelper.getEnd());
                    } else {
                        abs = Math.abs(orientationHelper.getEndAfterPadding() - orientationHelper.getDecoratedEnd(childAt));
                    }
                } else {
                    abs = Math.abs((orientationHelper.getDecoratedStart(childAt) + (orientationHelper.getDecoratedMeasurement(childAt) / 2)) - end);
                }
                if (abs < i11) {
                    view = childAt;
                    i11 = abs;
                }
            }
        }
        return view;
    }

    private boolean a(LinearLayoutManager linearLayoutManager) {
        return ((linearLayoutManager.getReverseLayout() || this.f27906a != 8388611) && !(linearLayoutManager.getReverseLayout() && this.f27906a == 8388613)) ? this.f27906a == 17 ? linearLayoutManager.findFirstCompletelyVisibleItemPosition() == 0 || linearLayoutManager.findLastCompletelyVisibleItemPosition() == linearLayoutManager.getItemCount() - 1 : linearLayoutManager.findFirstCompletelyVisibleItemPosition() == 0 : linearLayoutManager.findLastCompletelyVisibleItemPosition() == linearLayoutManager.getItemCount() - 1;
    }

    private OrientationHelper a(RecyclerView.LayoutManager layoutManager) {
        OrientationHelper orientationHelper = this.f27915j;
        if (orientationHelper == null || orientationHelper.getLayoutManager() != layoutManager) {
            this.f27915j = OrientationHelper.createHorizontalHelper(layoutManager);
        }
        return this.f27915j;
    }
}
