package com.baidu.mobads.sdk.internal.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.mobads.sdk.internal.widget.ViewPager2;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Locale;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ScrollEventAdapter extends RecyclerView.OnScrollListener {

    /* renamed from: a, reason: collision with root package name */
    private static final int f10342a = 0;

    /* renamed from: b, reason: collision with root package name */
    private static final int f10343b = 1;

    /* renamed from: c, reason: collision with root package name */
    private static final int f10344c = 2;

    /* renamed from: d, reason: collision with root package name */
    private static final int f10345d = 3;

    /* renamed from: e, reason: collision with root package name */
    private static final int f10346e = 4;

    /* renamed from: f, reason: collision with root package name */
    private static final int f10347f = -1;

    /* renamed from: g, reason: collision with root package name */
    private ViewPager2.OnPageChangeCallback f10348g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    private final ViewPager2 f10349h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    private final RecyclerView f10350i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    private final LinearLayoutManager f10351j;

    /* renamed from: k, reason: collision with root package name */
    private int f10352k;

    /* renamed from: l, reason: collision with root package name */
    private int f10353l;

    /* renamed from: m, reason: collision with root package name */
    private ScrollEventValues f10354m;

    /* renamed from: n, reason: collision with root package name */
    private int f10355n;

    /* renamed from: o, reason: collision with root package name */
    private int f10356o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f10357p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f10358q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f10359r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f10360s;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public @interface AdapterState {
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class ScrollEventValues {

        /* renamed from: a, reason: collision with root package name */
        public int f10361a;

        /* renamed from: b, reason: collision with root package name */
        public float f10362b;

        /* renamed from: c, reason: collision with root package name */
        public int f10363c;

        public void a() {
            this.f10361a = -1;
            this.f10362b = 0.0f;
            this.f10363c = 0;
        }
    }

    public ScrollEventAdapter(@NonNull ViewPager2 viewPager2) {
        this.f10349h = viewPager2;
        RecyclerView recyclerView = viewPager2.f10373j;
        this.f10350i = recyclerView;
        this.f10351j = (LinearLayoutManager) recyclerView.getLayoutManager();
        this.f10354m = new ScrollEventValues();
        i();
    }

    private void a(boolean z10) {
        this.f10360s = z10;
        this.f10352k = z10 ? 4 : 1;
        int i10 = this.f10356o;
        if (i10 != -1) {
            this.f10355n = i10;
            this.f10356o = -1;
        } else if (this.f10355n == -1) {
            this.f10355n = l();
        }
        a(1);
    }

    private void i() {
        this.f10352k = 0;
        this.f10353l = 0;
        this.f10354m.a();
        this.f10355n = -1;
        this.f10356o = -1;
        this.f10357p = false;
        this.f10358q = false;
        this.f10360s = false;
        this.f10359r = false;
    }

    private void j() {
        int top;
        ScrollEventValues scrollEventValues = this.f10354m;
        int findFirstVisibleItemPosition = this.f10351j.findFirstVisibleItemPosition();
        scrollEventValues.f10361a = findFirstVisibleItemPosition;
        if (findFirstVisibleItemPosition == -1) {
            scrollEventValues.a();
            return;
        }
        View findViewByPosition = this.f10351j.findViewByPosition(findFirstVisibleItemPosition);
        if (findViewByPosition == null) {
            scrollEventValues.a();
            return;
        }
        int leftDecorationWidth = this.f10351j.getLeftDecorationWidth(findViewByPosition);
        int rightDecorationWidth = this.f10351j.getRightDecorationWidth(findViewByPosition);
        int topDecorationHeight = this.f10351j.getTopDecorationHeight(findViewByPosition);
        int bottomDecorationHeight = this.f10351j.getBottomDecorationHeight(findViewByPosition);
        ViewGroup.LayoutParams layoutParams = findViewByPosition.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            leftDecorationWidth += marginLayoutParams.leftMargin;
            rightDecorationWidth += marginLayoutParams.rightMargin;
            topDecorationHeight += marginLayoutParams.topMargin;
            bottomDecorationHeight += marginLayoutParams.bottomMargin;
        }
        int height = findViewByPosition.getHeight() + topDecorationHeight + bottomDecorationHeight;
        int width = findViewByPosition.getWidth() + leftDecorationWidth + rightDecorationWidth;
        if (this.f10351j.getOrientation() == 0) {
            top = (findViewByPosition.getLeft() - leftDecorationWidth) - this.f10350i.getPaddingLeft();
            if (this.f10349h.c()) {
                top = -top;
            }
            height = width;
        } else {
            top = (findViewByPosition.getTop() - topDecorationHeight) - this.f10350i.getPaddingTop();
        }
        int i10 = -top;
        scrollEventValues.f10363c = i10;
        if (i10 < 0) {
            if (new AnimateLayoutChangeDetector(this.f10351j).a()) {
                throw new IllegalStateException("Page(s) contain a ViewGroup with a LayoutTransition (or animateLayoutChanges=\"true\"), which interferes with the scrolling animation. Make sure to call getLayoutTransition().setAnimateParentHierarchy(false) on all ViewGroups with a LayoutTransition before an animation is started.");
            }
            throw new IllegalStateException(String.format(Locale.US, "Page can only be offset by a positive amount, not by %d", Integer.valueOf(scrollEventValues.f10363c)));
        }
        scrollEventValues.f10362b = height == 0 ? 0.0f : i10 / height;
    }

    private boolean k() {
        int i10 = this.f10352k;
        return i10 == 1 || i10 == 4;
    }

    private int l() {
        return this.f10351j.findFirstVisibleItemPosition();
    }

    public void b() {
        this.f10352k = 4;
        a(true);
    }

    public void c() {
        if (!f() || this.f10360s) {
            this.f10360s = false;
            j();
            ScrollEventValues scrollEventValues = this.f10354m;
            if (scrollEventValues.f10363c == 0) {
                int i10 = scrollEventValues.f10361a;
                if (i10 != this.f10355n) {
                    b(i10);
                }
                a(0);
                i();
                return;
            }
            a(2);
        }
    }

    public int d() {
        return this.f10353l;
    }

    public boolean e() {
        return this.f10353l == 0;
    }

    public boolean f() {
        return this.f10353l == 1;
    }

    public boolean g() {
        return this.f10360s;
    }

    public double h() {
        j();
        ScrollEventValues scrollEventValues = this.f10354m;
        return scrollEventValues.f10361a + scrollEventValues.f10362b;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i10) {
        boolean z10 = true;
        if ((this.f10352k != 1 || this.f10353l != 1) && i10 == 1) {
            a(false);
            return;
        }
        if (k() && i10 == 2) {
            if (this.f10358q) {
                a(2);
                this.f10357p = true;
                return;
            }
            return;
        }
        if (k() && i10 == 0) {
            j();
            if (!this.f10358q) {
                int i11 = this.f10354m.f10361a;
                if (i11 != -1) {
                    a(i11, 0.0f, 0);
                }
            } else {
                ScrollEventValues scrollEventValues = this.f10354m;
                if (scrollEventValues.f10363c == 0) {
                    int i12 = this.f10355n;
                    int i13 = scrollEventValues.f10361a;
                    if (i12 != i13) {
                        b(i13);
                    }
                } else {
                    z10 = false;
                }
            }
            if (z10) {
                a(0);
                i();
            }
        }
        if (this.f10352k == 2 && i10 == 0 && this.f10359r) {
            j();
            ScrollEventValues scrollEventValues2 = this.f10354m;
            if (scrollEventValues2.f10363c == 0) {
                int i14 = this.f10356o;
                int i15 = scrollEventValues2.f10361a;
                if (i14 != i15) {
                    if (i15 == -1) {
                        i15 = 0;
                    }
                    b(i15);
                }
                a(0);
                i();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x001d, code lost:
    
        if ((r5 < 0) == r3.f10349h.c()) goto L14;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0039  */
    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onScrolled(@androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView r4, int r5, int r6) {
        /*
            r3 = this;
            r4 = 1
            r3.f10358q = r4
            r3.j()
            boolean r0 = r3.f10357p
            r1 = -1
            r2 = 0
            if (r0 == 0) goto L3d
            r3.f10357p = r2
            if (r6 > 0) goto L22
            if (r6 != 0) goto L20
            if (r5 >= 0) goto L16
            r5 = 1
            goto L17
        L16:
            r5 = 0
        L17:
            com.baidu.mobads.sdk.internal.widget.ViewPager2 r6 = r3.f10349h
            boolean r6 = r6.c()
            if (r5 != r6) goto L20
            goto L22
        L20:
            r5 = 0
            goto L23
        L22:
            r5 = 1
        L23:
            if (r5 == 0) goto L2f
            com.baidu.mobads.sdk.internal.widget.ScrollEventAdapter$ScrollEventValues r5 = r3.f10354m
            int r6 = r5.f10363c
            if (r6 == 0) goto L2f
            int r5 = r5.f10361a
            int r5 = r5 + r4
            goto L33
        L2f:
            com.baidu.mobads.sdk.internal.widget.ScrollEventAdapter$ScrollEventValues r5 = r3.f10354m
            int r5 = r5.f10361a
        L33:
            r3.f10356o = r5
            int r6 = r3.f10355n
            if (r6 == r5) goto L4b
            r3.b(r5)
            goto L4b
        L3d:
            int r5 = r3.f10352k
            if (r5 != 0) goto L4b
            com.baidu.mobads.sdk.internal.widget.ScrollEventAdapter$ScrollEventValues r5 = r3.f10354m
            int r5 = r5.f10361a
            if (r5 != r1) goto L48
            r5 = 0
        L48:
            r3.b(r5)
        L4b:
            com.baidu.mobads.sdk.internal.widget.ScrollEventAdapter$ScrollEventValues r5 = r3.f10354m
            int r6 = r5.f10361a
            if (r6 != r1) goto L52
            r6 = 0
        L52:
            float r0 = r5.f10362b
            int r5 = r5.f10363c
            r3.a(r6, r0, r5)
            com.baidu.mobads.sdk.internal.widget.ScrollEventAdapter$ScrollEventValues r5 = r3.f10354m
            int r6 = r5.f10361a
            int r0 = r3.f10356o
            if (r6 == r0) goto L63
            if (r0 != r1) goto L71
        L63:
            int r5 = r5.f10363c
            if (r5 != 0) goto L71
            int r5 = r3.f10353l
            if (r5 == r4) goto L71
            r3.a(r2)
            r3.i()
        L71:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.sdk.internal.widget.ScrollEventAdapter.onScrolled(androidx.recyclerview.widget.RecyclerView, int, int):void");
    }

    private void b(int i10) {
        ViewPager2.OnPageChangeCallback onPageChangeCallback = this.f10348g;
        if (onPageChangeCallback != null) {
            onPageChangeCallback.onPageSelected(i10);
        }
    }

    public void a() {
        this.f10359r = true;
    }

    public void a(int i10, boolean z10) {
        this.f10352k = z10 ? 2 : 3;
        this.f10360s = false;
        boolean z11 = this.f10356o != i10;
        this.f10356o = i10;
        a(2);
        if (z11) {
            b(i10);
        }
    }

    public void a(ViewPager2.OnPageChangeCallback onPageChangeCallback) {
        this.f10348g = onPageChangeCallback;
    }

    private void a(int i10) {
        if ((this.f10352k == 3 && this.f10353l == 0) || this.f10353l == i10) {
            return;
        }
        this.f10353l = i10;
        ViewPager2.OnPageChangeCallback onPageChangeCallback = this.f10348g;
        if (onPageChangeCallback != null) {
            onPageChangeCallback.onPageScrollStateChanged(i10);
        }
    }

    private void a(int i10, float f10, int i11) {
        ViewPager2.OnPageChangeCallback onPageChangeCallback = this.f10348g;
        if (onPageChangeCallback != null) {
            onPageChangeCallback.onPageScrolled(i10, f10, i11);
        }
    }
}
