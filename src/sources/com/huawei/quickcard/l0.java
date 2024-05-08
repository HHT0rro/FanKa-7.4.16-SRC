package com.huawei.quickcard;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.huawei.flexiblelayout.css.adapter.value.integrate.align.CSSAlignValue;
import com.huawei.quickcard.utils.ViewUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class l0 extends LinearSnapHelper {

    /* renamed from: g, reason: collision with root package name */
    private static final boolean f34092g = false;

    /* renamed from: h, reason: collision with root package name */
    private static final float f34093h = 40.0f;

    /* renamed from: a, reason: collision with root package name */
    private b f34094a = b.START;

    /* renamed from: b, reason: collision with root package name */
    private OrientationHelper f34095b;

    /* renamed from: c, reason: collision with root package name */
    private OrientationHelper f34096c;

    /* renamed from: d, reason: collision with root package name */
    private RecyclerView f34097d;

    /* renamed from: e, reason: collision with root package name */
    private int f34098e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f34099f;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class a extends LinearSmoothScroller {
        public a(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
            return l0.f34093h / displayMetrics.densityDpi;
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
        public void onTargetFound(View view, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
            if (l0.this.f34097d == null || l0.this.f34097d.getLayoutManager() == null) {
                return;
            }
            l0 l0Var = l0.this;
            int[] calculateDistanceToFinalSnap = l0Var.calculateDistanceToFinalSnap(l0Var.f34097d.getLayoutManager(), view);
            int i10 = calculateDistanceToFinalSnap[0];
            int i11 = calculateDistanceToFinalSnap[1];
            int calculateTimeForDeceleration = calculateTimeForDeceleration(Math.max(Math.abs(i10), Math.abs(i11)));
            if (calculateTimeForDeceleration > 0) {
                action.update(i10, i11, calculateTimeForDeceleration, this.mDecelerateInterpolator);
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public enum b {
        START,
        CENTER,
        END
    }

    private int b(OrientationHelper orientationHelper) {
        return orientationHelper.getStartAfterPadding();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean c(RecyclerView.LayoutManager layoutManager) {
        PointF computeScrollVectorForPosition;
        int itemCount = layoutManager.getItemCount();
        if (!(layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) || (computeScrollVectorForPosition = ((RecyclerView.SmoothScroller.ScrollVectorProvider) layoutManager).computeScrollVectorForPosition(itemCount - 1)) == null) {
            return false;
        }
        return computeScrollVectorForPosition.x < 0.0f || computeScrollVectorForPosition.y < 0.0f;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public void attachToRecyclerView(@Nullable RecyclerView recyclerView) throws IllegalStateException {
        if (recyclerView != null) {
            recyclerView.setOnFlingListener(null);
            this.f34097d = recyclerView;
        } else {
            this.f34097d = null;
        }
        super.attachToRecyclerView(recyclerView);
    }

    @Override // androidx.recyclerview.widget.LinearSnapHelper, androidx.recyclerview.widget.SnapHelper
    @NonNull
    public int[] calculateDistanceToFinalSnap(@NonNull RecyclerView.LayoutManager layoutManager, @NonNull View view) {
        if (this.f34094a == b.CENTER) {
            return super.calculateDistanceToFinalSnap(layoutManager, view);
        }
        int[] iArr = new int[2];
        boolean a10 = a();
        OrientationHelper b4 = b(layoutManager);
        boolean z10 = true;
        if (layoutManager.canScrollVertically()) {
            iArr[1] = a(view, b4, this.f34094a == b.START);
        } else if (layoutManager.canScrollHorizontally()) {
            if ((!a10 || this.f34094a != b.END) && (a10 || this.f34094a != b.START)) {
                z10 = false;
            }
            iArr[0] = a(view, b4, z10);
        }
        return iArr;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    @Nullable
    public RecyclerView.SmoothScroller createScroller(RecyclerView.LayoutManager layoutManager) {
        RecyclerView recyclerView;
        if (!(layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) || (recyclerView = this.f34097d) == null) {
            return null;
        }
        return new a(recyclerView.getContext());
    }

    @Override // androidx.recyclerview.widget.LinearSnapHelper, androidx.recyclerview.widget.SnapHelper
    @Nullable
    public View findSnapView(@NonNull RecyclerView.LayoutManager layoutManager) {
        return a(layoutManager, this.f34094a, true);
    }

    @Override // androidx.recyclerview.widget.LinearSnapHelper, androidx.recyclerview.widget.SnapHelper
    public int findTargetSnapPosition(RecyclerView.LayoutManager layoutManager, int i10, int i11) {
        if (!this.f34099f) {
            return super.findTargetSnapPosition(layoutManager, i10, i11);
        }
        int itemCount = layoutManager.getItemCount();
        if (itemCount == 0 || b(layoutManager) == null) {
            return -1;
        }
        int i12 = Integer.MIN_VALUE;
        int i13 = Integer.MAX_VALUE;
        int childCount = layoutManager.getChildCount();
        View view = null;
        View view2 = null;
        int i14 = 0;
        while (true) {
            if (i14 >= childCount) {
                break;
            }
            View childAt = layoutManager.getChildAt(i14);
            if (childAt != null) {
                int[] calculateDistanceToFinalSnap = calculateDistanceToFinalSnap(layoutManager, childAt);
                int i15 = calculateDistanceToFinalSnap[0] != 0 ? calculateDistanceToFinalSnap[0] : calculateDistanceToFinalSnap[1];
                if (i15 <= 0 && i15 > i12) {
                    i12 = i15;
                    view2 = childAt;
                }
                if (i15 >= 0 && i15 < i13) {
                    i13 = i15;
                    view = childAt;
                }
            }
            i14++;
        }
        boolean a10 = a(layoutManager, i10, i11);
        if (a10 && view != null) {
            return layoutManager.getPosition(view);
        }
        if (!a10 && view2 != null) {
            return layoutManager.getPosition(view2);
        }
        if (a10) {
            view = view2;
        }
        if (view == null) {
            return -1;
        }
        int position = layoutManager.getPosition(view) + (c(layoutManager) == a10 ? -1 : 1);
        if (position < 0 || position >= itemCount) {
            return -1;
        }
        return position;
    }

    private int b(OrientationHelper orientationHelper, View view) {
        return orientationHelper.getDecoratedStart(view);
    }

    public void a(boolean z10) {
        this.f34099f = z10;
    }

    private OrientationHelper b(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager.canScrollHorizontally()) {
            OrientationHelper orientationHelper = this.f34096c;
            if (orientationHelper == null || orientationHelper.getLayoutManager() != layoutManager) {
                this.f34096c = OrientationHelper.createHorizontalHelper(layoutManager);
            }
            return this.f34096c;
        }
        if (!layoutManager.canScrollVertically()) {
            return null;
        }
        OrientationHelper orientationHelper2 = this.f34095b;
        if (orientationHelper2 == null || orientationHelper2.getLayoutManager() != layoutManager) {
            this.f34095b = OrientationHelper.createVerticalHelper(layoutManager);
        }
        return this.f34095b;
    }

    public void a(String str) {
        if (str == null) {
            this.f34094a = b.START;
        } else if (str.equals(CSSAlignValue.AlignKey.CENTER)) {
            this.f34094a = b.CENTER;
        } else if (!str.equals("end")) {
            this.f34094a = b.START;
        } else {
            this.f34094a = b.END;
        }
        a(Boolean.TRUE, Boolean.FALSE);
    }

    public void a(Context context, CardContext cardContext, float f10) {
        this.f34098e = ViewUtils.dip2IntPx(ViewUtils.getConfigDensity(context, cardContext), f10);
    }

    public void a(Boolean bool, Boolean bool2) {
        RecyclerView.LayoutManager layoutManager;
        View a10;
        RecyclerView recyclerView = this.f34097d;
        if (recyclerView == null || recyclerView.getLayoutManager() == null || (a10 = a((layoutManager = this.f34097d.getLayoutManager()), this.f34094a, bool2.booleanValue())) == null) {
            return;
        }
        int[] calculateDistanceToFinalSnap = calculateDistanceToFinalSnap(layoutManager, a10);
        if (bool.booleanValue()) {
            this.f34097d.smoothScrollBy(calculateDistanceToFinalSnap[0], calculateDistanceToFinalSnap[1]);
        } else {
            this.f34097d.scrollBy(calculateDistanceToFinalSnap[0], calculateDistanceToFinalSnap[1]);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0050, code lost:
    
        if (r4 != false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0056, code lost:
    
        if (r4 == false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0062, code lost:
    
        if (r10 == com.huawei.quickcard.l0.b.f34103c) goto L55;
     */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.view.View a(@androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView.LayoutManager r9, com.huawei.quickcard.l0.b r10, boolean r11) {
        /*
            r8 = this;
            int r0 = r9.getChildCount()
            r1 = 0
            if (r0 != 0) goto L8
            return r1
        L8:
            if (r11 == 0) goto L11
            boolean r11 = r8.a(r9)
            if (r11 == 0) goto L11
            return r1
        L11:
            androidx.recyclerview.widget.OrientationHelper r11 = r8.b(r9)
            if (r11 != 0) goto L18
            return r1
        L18:
            boolean r0 = r9.canScrollHorizontally()
            r2 = 2147483647(0x7fffffff, float:NaN)
            boolean r3 = r9.getClipToPadding()
            if (r3 == 0) goto L31
            int r3 = r8.b(r11)
            int r4 = r11.getTotalSpace()
            int r4 = r4 / 2
            int r3 = r3 + r4
            goto L37
        L31:
            int r3 = r11.getEnd()
            int r3 = r3 / 2
        L37:
            boolean r4 = r8.a()
            r5 = 1
            r6 = 0
            if (r0 == 0) goto L59
            com.huawei.quickcard.l0$b r0 = com.huawei.quickcard.l0.b.START
            if (r10 != r0) goto L45
            if (r4 == 0) goto L4b
        L45:
            com.huawei.quickcard.l0$b r7 = com.huawei.quickcard.l0.b.END
            if (r10 != r7) goto L4d
            if (r4 == 0) goto L4d
        L4b:
            r7 = 1
            goto L4e
        L4d:
            r7 = 0
        L4e:
            if (r10 != r0) goto L52
            if (r4 != 0) goto L66
        L52:
            com.huawei.quickcard.l0$b r0 = com.huawei.quickcard.l0.b.END
            if (r10 != r0) goto L65
            if (r4 != 0) goto L65
            goto L66
        L59:
            com.huawei.quickcard.l0$b r0 = com.huawei.quickcard.l0.b.START
            if (r10 != r0) goto L5f
            r7 = 1
            goto L60
        L5f:
            r7 = 0
        L60:
            com.huawei.quickcard.l0$b r0 = com.huawei.quickcard.l0.b.END
            if (r10 != r0) goto L65
            goto L66
        L65:
            r5 = 0
        L66:
            int r10 = r9.getChildCount()
            if (r6 >= r10) goto La2
            android.view.View r10 = r9.getChildAt(r6)
            if (r7 == 0) goto L7b
            int r0 = r8.b(r11, r10)
            int r0 = java.lang.Math.abs(r0)
            goto L9b
        L7b:
            if (r5 == 0) goto L8b
            int r0 = r8.a(r11, r10)
            int r4 = r11.getEnd()
            int r0 = r0 - r4
            int r0 = java.lang.Math.abs(r0)
            goto L9b
        L8b:
            int r0 = r8.b(r11, r10)
            int r4 = r11.getDecoratedMeasurement(r10)
            int r4 = r4 / 2
            int r0 = r0 + r4
            int r0 = r0 - r3
            int r0 = java.lang.Math.abs(r0)
        L9b:
            if (r0 >= r2) goto L9f
            r1 = r10
            r2 = r0
        L9f:
            int r6 = r6 + 1
            goto L66
        La2:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.quickcard.l0.a(androidx.recyclerview.widget.RecyclerView$LayoutManager, com.huawei.quickcard.l0$b, boolean):android.view.View");
    }

    private int a(OrientationHelper orientationHelper) {
        return orientationHelper.getEndAfterPadding();
    }

    private int a(OrientationHelper orientationHelper, View view) {
        return orientationHelper.getDecoratedEnd(view);
    }

    private boolean a(RecyclerView.LayoutManager layoutManager) {
        boolean reverseLayout;
        int findFirstCompletelyVisibleItemPosition;
        int findLastCompletelyVisibleItemPosition;
        if (layoutManager instanceof StaggeredGridLayoutManager) {
            StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
            reverseLayout = staggeredGridLayoutManager.getReverseLayout();
            findFirstCompletelyVisibleItemPosition = staggeredGridLayoutManager.findFirstCompletelyVisibleItemPositions(null)[0];
            findLastCompletelyVisibleItemPosition = staggeredGridLayoutManager.findLastCompletelyVisibleItemPositions(null)[0];
        } else {
            if (!(layoutManager instanceof LinearLayoutManager)) {
                return false;
            }
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            reverseLayout = linearLayoutManager.getReverseLayout();
            findFirstCompletelyVisibleItemPosition = linearLayoutManager.findFirstCompletelyVisibleItemPosition();
            findLastCompletelyVisibleItemPosition = linearLayoutManager.findLastCompletelyVisibleItemPosition();
        }
        return ((reverseLayout || this.f34094a != b.START) && !(reverseLayout && this.f34094a == b.END)) ? this.f34094a == b.CENTER ? findFirstCompletelyVisibleItemPosition == 0 || findLastCompletelyVisibleItemPosition == layoutManager.getItemCount() - 1 : findFirstCompletelyVisibleItemPosition == 0 : findLastCompletelyVisibleItemPosition == layoutManager.getItemCount() - 1;
    }

    private int a(View view, @NonNull OrientationHelper orientationHelper, boolean z10) {
        int a10;
        int end;
        if (z10) {
            a10 = b(orientationHelper, view);
            if (a10 >= b(orientationHelper) / 2) {
                end = b(orientationHelper);
                a10 -= end;
            }
        } else {
            int a11 = a(orientationHelper, view);
            if (a11 >= orientationHelper.getEnd() - ((orientationHelper.getEnd() - a(orientationHelper)) / 2)) {
                a10 = a(orientationHelper, view);
                end = orientationHelper.getEnd();
                a10 -= end;
            } else {
                a10 = a11 - a(orientationHelper);
            }
        }
        return a10 + (z10 ? this.f34098e : -this.f34098e);
    }

    private boolean a() {
        RecyclerView recyclerView = this.f34097d;
        return recyclerView != null && recyclerView.getLayoutDirection() == 1;
    }

    private static boolean a(RecyclerView.LayoutManager layoutManager, int i10, int i11) {
        return layoutManager.canScrollHorizontally() ? i10 > 0 : i11 > 0;
    }
}
