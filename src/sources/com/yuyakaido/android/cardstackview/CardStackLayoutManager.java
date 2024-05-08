package com.yuyakaido.android.cardstackview;

import android.content.Context;
import android.graphics.PointF;
import android.os.Handler;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.yuyakaido.android.cardstackview.internal.CardStackSmoothScroller;
import com.yuyakaido.android.cardstackview.internal.CardStackState;
import java.util.List;
import nc.c;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class CardStackLayoutManager extends RecyclerView.LayoutManager implements RecyclerView.SmoothScroller.ScrollVectorProvider {

    /* renamed from: a, reason: collision with root package name */
    public final Context f48543a;

    /* renamed from: b, reason: collision with root package name */
    public mc.a f48544b;

    /* renamed from: c, reason: collision with root package name */
    public nc.b f48545c;

    /* renamed from: d, reason: collision with root package name */
    public CardStackState f48546d;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Direction f48547b;

        public a(Direction direction) {
            this.f48547b = direction;
        }

        @Override // java.lang.Runnable
        public void run() {
            CardStackLayoutManager.this.f48544b.c(this.f48547b);
            if (CardStackLayoutManager.this.g() != null) {
                CardStackLayoutManager.this.f48544b.d(CardStackLayoutManager.this.g(), CardStackLayoutManager.this.f48546d.f48565f);
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f48549a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f48550b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f48551c;

        static {
            int[] iArr = new int[Direction.values().length];
            f48551c = iArr;
            try {
                iArr[Direction.Left.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f48551c[Direction.Right.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f48551c[Direction.Top.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f48551c[Direction.Bottom.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[StackFrom.values().length];
            f48550b = iArr2;
            try {
                iArr2[StackFrom.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f48550b[StackFrom.Top.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f48550b[StackFrom.TopAndLeft.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f48550b[StackFrom.TopAndRight.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f48550b[StackFrom.Bottom.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f48550b[StackFrom.BottomAndLeft.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f48550b[StackFrom.BottomAndRight.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f48550b[StackFrom.Left.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f48550b[StackFrom.Right.ordinal()] = 9;
            } catch (NoSuchFieldError unused13) {
            }
            int[] iArr3 = new int[CardStackState.Status.values().length];
            f48549a = iArr3;
            try {
                iArr3[CardStackState.Status.Idle.ordinal()] = 1;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f48549a[CardStackState.Status.Dragging.ordinal()] = 2;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f48549a[CardStackState.Status.RewindAnimating.ordinal()] = 3;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f48549a[CardStackState.Status.AutomaticSwipeAnimating.ordinal()] = 4;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f48549a[CardStackState.Status.AutomaticSwipeAnimated.ordinal()] = 5;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f48549a[CardStackState.Status.ManualSwipeAnimating.ordinal()] = 6;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f48549a[CardStackState.Status.ManualSwipeAnimated.ordinal()] = 7;
            } catch (NoSuchFieldError unused20) {
            }
        }
    }

    public CardStackLayoutManager(Context context) {
        this(context, mc.a.E0);
    }

    public final void A(int i10) {
        if (this.f48546d.f48565f < i10) {
            z(i10);
        } else {
            B(i10);
        }
    }

    public final void B(int i10) {
        if (g() != null) {
            this.f48544b.b(g(), this.f48546d.f48565f);
        }
        CardStackState cardStackState = this.f48546d;
        cardStackState.f48567h = 0.0f;
        cardStackState.f48566g = i10;
        cardStackState.f48565f--;
        CardStackSmoothScroller cardStackSmoothScroller = new CardStackSmoothScroller(CardStackSmoothScroller.ScrollType.AutomaticRewind, this);
        cardStackSmoothScroller.setTargetPosition(this.f48546d.f48565f);
        startSmoothScroll(cardStackSmoothScroller);
    }

    public final void C(RecyclerView.Recycler recycler) {
        this.f48546d.f48561b = getWidth();
        this.f48546d.f48562c = getHeight();
        if (this.f48546d.d()) {
            removeAndRecycleView(g(), recycler);
            Direction b4 = this.f48546d.b();
            CardStackState cardStackState = this.f48546d;
            cardStackState.e(cardStackState.f48560a.toAnimatedStatus());
            CardStackState cardStackState2 = this.f48546d;
            int i10 = cardStackState2.f48565f + 1;
            cardStackState2.f48565f = i10;
            cardStackState2.f48563d = 0;
            cardStackState2.f48564e = 0;
            if (i10 == cardStackState2.f48566g) {
                cardStackState2.f48566g = -1;
            }
            new Handler().post(new a(b4));
        }
        detachAndScrapAttachedViews(recycler);
        int paddingTop = getPaddingTop();
        int paddingLeft = getPaddingLeft();
        int width = getWidth() - getPaddingLeft();
        int height = getHeight() - getPaddingBottom();
        for (int i11 = this.f48546d.f48565f; i11 < this.f48546d.f48565f + this.f48545c.f52198b && i11 < getItemCount(); i11++) {
            View viewForPosition = recycler.getViewForPosition(i11);
            addView(viewForPosition, 0);
            measureChildWithMargins(viewForPosition, 0, 0);
            layoutDecoratedWithMargins(viewForPosition, paddingLeft, paddingTop, width, height);
            k(viewForPosition);
            j(viewForPosition);
            i(viewForPosition);
            h(viewForPosition);
            int i12 = this.f48546d.f48565f;
            if (i11 == i12) {
                H(viewForPosition);
                j(viewForPosition);
                F(viewForPosition);
                D(viewForPosition);
            } else {
                int i13 = i11 - i12;
                I(viewForPosition, i13);
                G(viewForPosition, i13);
                i(viewForPosition);
                h(viewForPosition);
            }
        }
        if (this.f48546d.f48560a.isDragging()) {
            this.f48544b.a(this.f48546d.b(), this.f48546d.c());
        }
    }

    public final void D(View view) {
        View findViewById = view.findViewById(R$id.left_overlay);
        if (findViewById != null) {
            findViewById.setAlpha(0.0f);
        }
        View findViewById2 = view.findViewById(R$id.right_overlay);
        if (findViewById2 != null) {
            findViewById2.setAlpha(0.0f);
        }
        View findViewById3 = view.findViewById(R$id.top_overlay);
        if (findViewById3 != null) {
            findViewById3.setAlpha(0.0f);
        }
        View findViewById4 = view.findViewById(R$id.bottom_overlay);
        if (findViewById4 != null) {
            findViewById4.setAlpha(0.0f);
        }
        Direction b4 = this.f48546d.b();
        float interpolation = this.f48545c.f52209m.getInterpolation(this.f48546d.c());
        int i10 = b.f48551c[b4.ordinal()];
        if (i10 == 1) {
            if (findViewById != null) {
                findViewById.setAlpha(interpolation);
            }
        } else if (i10 == 2) {
            if (findViewById2 != null) {
                findViewById2.setAlpha(interpolation);
            }
        } else if (i10 == 3) {
            if (findViewById3 != null) {
                findViewById3.setAlpha(interpolation);
            }
        } else if (i10 == 4 && findViewById4 != null) {
            findViewById4.setAlpha(interpolation);
        }
    }

    public void E(float f10, float f11) {
        View findViewByPosition;
        if (f() >= getItemCount() || (findViewByPosition = findViewByPosition(f())) == null) {
            return;
        }
        float height = getHeight() / 2.0f;
        this.f48546d.f48567h = (-((f11 - height) - findViewByPosition.getTop())) / height;
    }

    public final void F(View view) {
        view.setRotation(((this.f48546d.f48563d * this.f48545c.f52202f) / getWidth()) * this.f48546d.f48567h);
    }

    public final void G(View view, int i10) {
        int i11 = i10 - 1;
        float f10 = this.f48545c.f52200d;
        float f11 = 1.0f - (i10 * (1.0f - f10));
        float c4 = f11 + (((1.0f - (i11 * (1.0f - f10))) - f11) * this.f48546d.c());
        switch (b.f48550b[this.f48545c.f52197a.ordinal()]) {
            case 1:
                view.setScaleX(c4);
                view.setScaleY(c4);
                return;
            case 2:
                view.setScaleX(c4);
                return;
            case 3:
                view.setScaleX(c4);
                return;
            case 4:
                view.setScaleX(c4);
                return;
            case 5:
                view.setScaleX(c4);
                return;
            case 6:
                view.setScaleX(c4);
                return;
            case 7:
                view.setScaleX(c4);
                return;
            case 8:
                view.setScaleY(c4);
                return;
            case 9:
                view.setScaleY(c4);
                return;
            default:
                return;
        }
    }

    public final void H(View view) {
        view.setTranslationX(this.f48546d.f48563d);
        view.setTranslationY(this.f48546d.f48564e);
    }

    public final void I(View view, int i10) {
        int i11 = i10 - 1;
        float a10 = i10 * c.a(this.f48543a, this.f48545c.f52199c);
        float c4 = a10 - ((a10 - (i11 * r1)) * this.f48546d.c());
        switch (b.f48550b[this.f48545c.f52197a.ordinal()]) {
            case 2:
                view.setTranslationY(-c4);
                return;
            case 3:
                float f10 = -c4;
                view.setTranslationY(f10);
                view.setTranslationX(f10);
                return;
            case 4:
                view.setTranslationY(-c4);
                view.setTranslationX(c4);
                return;
            case 5:
                view.setTranslationY(c4);
                return;
            case 6:
                view.setTranslationY(c4);
                view.setTranslationX(-c4);
                return;
            case 7:
                view.setTranslationY(c4);
                view.setTranslationX(c4);
                return;
            case 8:
                view.setTranslationX(-c4);
                return;
            case 9:
                view.setTranslationX(c4);
                return;
            default:
                return;
        }
    }

    @NonNull
    public mc.a c() {
        return this.f48544b;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        return this.f48545c.f52206j.canSwipe() && this.f48545c.f52204h;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return this.f48545c.f52206j.canSwipe() && this.f48545c.f52205i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public PointF computeScrollVectorForPosition(int i10) {
        return null;
    }

    @NonNull
    public nc.b d() {
        return this.f48545c;
    }

    @NonNull
    public CardStackState e() {
        return this.f48546d;
    }

    public int f() {
        return this.f48546d.f48565f;
    }

    public View g() {
        return findViewByPosition(this.f48546d.f48565f);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-1, -1);
    }

    public final void h(View view) {
        View findViewById = view.findViewById(R$id.left_overlay);
        if (findViewById != null) {
            findViewById.setAlpha(0.0f);
        }
        View findViewById2 = view.findViewById(R$id.right_overlay);
        if (findViewById2 != null) {
            findViewById2.setAlpha(0.0f);
        }
        View findViewById3 = view.findViewById(R$id.top_overlay);
        if (findViewById3 != null) {
            findViewById3.setAlpha(0.0f);
        }
        View findViewById4 = view.findViewById(R$id.bottom_overlay);
        if (findViewById4 != null) {
            findViewById4.setAlpha(0.0f);
        }
    }

    public final void i(View view) {
        view.setRotation(0.0f);
    }

    public final void j(View view) {
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
    }

    public final void k(View view) {
        view.setTranslationX(0.0f);
        view.setTranslationY(0.0f);
    }

    public void l(boolean z10) {
        this.f48545c.f52204h = z10;
    }

    public void m(boolean z10) {
        this.f48545c.f52205i = z10;
    }

    public void n(@NonNull List<Direction> list) {
        this.f48545c.f52203g = list;
    }

    public void o(@FloatRange(from = -360.0d, to = 360.0d) float f10) {
        if (f10 >= -360.0f && 360.0f >= f10) {
            this.f48545c.f52202f = f10;
            return;
        }
        throw new IllegalArgumentException("MaxDegree must be -360.0f to 360.0f");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        C(recycler);
        if (!state.didStructureChange() || g() == null) {
            return;
        }
        this.f48544b.d(g(), this.f48546d.f48565f);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onScrollStateChanged(int i10) {
        if (i10 != 0) {
            if (i10 == 1 && this.f48545c.f52206j.canSwipeManually()) {
                this.f48546d.e(CardStackState.Status.Dragging);
                return;
            }
            return;
        }
        CardStackState cardStackState = this.f48546d;
        int i11 = cardStackState.f48566g;
        if (i11 == -1) {
            cardStackState.e(CardStackState.Status.Idle);
            this.f48546d.f48566g = -1;
            return;
        }
        int i12 = cardStackState.f48565f;
        if (i12 == i11) {
            cardStackState.e(CardStackState.Status.Idle);
            this.f48546d.f48566g = -1;
        } else if (i12 < i11) {
            z(i11);
        } else {
            B(i11);
        }
    }

    public void p(@NonNull Interpolator interpolator) {
        this.f48545c.f52209m = interpolator;
    }

    public void q(@NonNull mc.b bVar) {
        this.f48545c.f52208l = bVar;
    }

    public void r(@FloatRange(from = 0.0d) float f10) {
        if (f10 >= 0.0f) {
            this.f48545c.f52200d = f10;
            return;
        }
        throw new IllegalArgumentException("ScaleInterval must be greater than or equal 0.0f.");
    }

    public void s(@NonNull StackFrom stackFrom) {
        this.f48545c.f52197a = stackFrom;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i10, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.f48546d.f48565f == getItemCount()) {
            return 0;
        }
        int i11 = b.f48549a[this.f48546d.f48560a.ordinal()];
        if (i11 != 1) {
            if (i11 != 2) {
                if (i11 == 3) {
                    this.f48546d.f48563d -= i10;
                    C(recycler);
                    return i10;
                }
                if (i11 != 4) {
                    if (i11 == 6 && this.f48545c.f52206j.canSwipeManually()) {
                        this.f48546d.f48563d -= i10;
                        C(recycler);
                        return i10;
                    }
                } else if (this.f48545c.f52206j.canSwipeAutomatically()) {
                    this.f48546d.f48563d -= i10;
                    C(recycler);
                    return i10;
                }
            } else if (this.f48545c.f52206j.canSwipeManually()) {
                this.f48546d.f48563d -= i10;
                C(recycler);
                return i10;
            }
        } else if (this.f48545c.f52206j.canSwipeManually()) {
            this.f48546d.f48563d -= i10;
            C(recycler);
            return i10;
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i10) {
        if (this.f48545c.f52206j.canSwipeAutomatically() && this.f48546d.a(i10, getItemCount())) {
            this.f48546d.f48565f = i10;
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i10, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.f48546d.f48565f == getItemCount()) {
            return 0;
        }
        int i11 = b.f48549a[this.f48546d.f48560a.ordinal()];
        if (i11 != 1) {
            if (i11 != 2) {
                if (i11 == 3) {
                    this.f48546d.f48564e -= i10;
                    C(recycler);
                    return i10;
                }
                if (i11 != 4) {
                    if (i11 == 6 && this.f48545c.f52206j.canSwipeManually()) {
                        this.f48546d.f48564e -= i10;
                        C(recycler);
                        return i10;
                    }
                } else if (this.f48545c.f52206j.canSwipeAutomatically()) {
                    this.f48546d.f48564e -= i10;
                    C(recycler);
                    return i10;
                }
            } else if (this.f48545c.f52206j.canSwipeManually()) {
                this.f48546d.f48564e -= i10;
                C(recycler);
                return i10;
            }
        } else if (this.f48545c.f52206j.canSwipeManually()) {
            this.f48546d.f48564e -= i10;
            C(recycler);
            return i10;
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i10) {
        if (this.f48545c.f52206j.canSwipeAutomatically() && this.f48546d.a(i10, getItemCount())) {
            A(i10);
        }
    }

    public void t(@NonNull mc.c cVar) {
        this.f48545c.f52207k = cVar;
    }

    public void u(@FloatRange(from = 0.0d, to = 1.0d) float f10) {
        if (f10 >= 0.0f && 1.0f >= f10) {
            this.f48545c.f52201e = f10;
            return;
        }
        throw new IllegalArgumentException("SwipeThreshold must be 0.0f to 1.0f.");
    }

    public void v(SwipeableMethod swipeableMethod) {
        this.f48545c.f52206j = swipeableMethod;
    }

    public void w(int i10) {
        this.f48546d.f48565f = i10;
    }

    public void x(@FloatRange(from = 0.0d) float f10) {
        if (f10 >= 0.0f) {
            this.f48545c.f52199c = f10;
            return;
        }
        throw new IllegalArgumentException("TranslationInterval must be greater than or equal 0.0f");
    }

    public void y(@IntRange(from = 1) int i10) {
        if (i10 >= 1) {
            this.f48545c.f52198b = i10;
            return;
        }
        throw new IllegalArgumentException("VisibleCount must be greater than 0.");
    }

    public final void z(int i10) {
        CardStackState cardStackState = this.f48546d;
        cardStackState.f48567h = 0.0f;
        cardStackState.f48566g = i10;
        CardStackSmoothScroller cardStackSmoothScroller = new CardStackSmoothScroller(CardStackSmoothScroller.ScrollType.AutomaticSwipe, this);
        cardStackSmoothScroller.setTargetPosition(this.f48546d.f48565f);
        startSmoothScroll(cardStackSmoothScroller);
    }

    public CardStackLayoutManager(Context context, mc.a aVar) {
        this.f48544b = mc.a.E0;
        this.f48545c = new nc.b();
        this.f48546d = new CardStackState();
        this.f48543a = context;
        this.f48544b = aVar;
    }
}
