package com.cupidapp.live.base.recyclerview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.viewpager2.widget.ViewPager2;
import com.cupidapp.live.base.utils.i;
import com.cupidapp.live.base.view.BaseLayout;
import com.huawei.flexiblelayout.card.FLPNode;
import he.j;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLoopScrollLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public abstract class FKLoopScrollLayout extends BaseLayout {

    /* renamed from: d, reason: collision with root package name */
    public float f12042d;

    /* renamed from: e, reason: collision with root package name */
    public float f12043e;

    /* renamed from: f, reason: collision with root package name */
    public ViewPager2 f12044f;

    /* renamed from: g, reason: collision with root package name */
    public final long f12045g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public i f12046h;

    /* renamed from: i, reason: collision with root package name */
    public int f12047i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    public Integer f12048j;

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f12049k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLoopScrollLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f12049k = new LinkedHashMap();
        this.f12045g = 360000000L;
    }

    public static final boolean l(View view, FKLoopScrollLayout this$0, View view2, MotionEvent motionEvent) {
        s.i(this$0, "this$0");
        view.performClick();
        int action = motionEvent.getAction();
        if (action != 1) {
            if (action == 2) {
                this$0.p();
                return false;
            }
            if (action != 3) {
                return false;
            }
        }
        this$0.o();
        return false;
    }

    @NotNull
    public abstract FKBaseRecyclerViewAdapter getAdapter();

    public abstract long getPagerLife();

    @NotNull
    public final ViewPager2 getViewPager() {
        ViewPager2 viewPager2 = this.f12044f;
        if (viewPager2 != null) {
            return viewPager2;
        }
        s.A(FLPNode.KEY_VIEW_PAGER);
        return null;
    }

    public abstract void j();

    public final void k() {
        j();
        setVisibility(8);
        getViewPager().setAdapter(getAdapter());
        getViewPager().registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.cupidapp.live.base.recyclerview.FKLoopScrollLayout$initView$1
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageScrollStateChanged(int i10) {
                int i11;
                int i12;
                if (i10 == 0) {
                    i11 = FKLoopScrollLayout.this.f12047i;
                    if (i11 == 0) {
                        FKLoopScrollLayout.this.getViewPager().setCurrentItem(FKLoopScrollLayout.this.getAdapter().n() - 2, false);
                        return;
                    }
                    i12 = FKLoopScrollLayout.this.f12047i;
                    if (i12 == FKLoopScrollLayout.this.getAdapter().n() - 1) {
                        FKLoopScrollLayout.this.getViewPager().setCurrentItem(1, false);
                    }
                }
            }

            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i10) {
                Integer num;
                int i11;
                int i12;
                FKLoopScrollLayout.this.f12047i = i10;
                num = FKLoopScrollLayout.this.f12048j;
                i11 = FKLoopScrollLayout.this.f12047i;
                if (num != null && num.intValue() == i11) {
                    return;
                }
                FKLoopScrollLayout.this.m(i10);
                FKLoopScrollLayout fKLoopScrollLayout = FKLoopScrollLayout.this;
                i12 = fKLoopScrollLayout.f12047i;
                fKLoopScrollLayout.f12048j = Integer.valueOf(i12);
            }
        });
        final View childAt = getViewPager().getChildAt(0);
        childAt.setOnTouchListener(new View.OnTouchListener() { // from class: com.cupidapp.live.base.recyclerview.c
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean l10;
                l10 = FKLoopScrollLayout.l(View.this, this, view, motionEvent);
                return l10;
            }
        });
    }

    public abstract void m(int i10);

    public final void o() {
        p();
        if (getAdapter().j().size() <= 1) {
            return;
        }
        i iVar = new i();
        this.f12046h = iVar;
        iVar.e(this.f12045g, getPagerLife(), (r16 & 4) != 0 ? null : null, (r16 & 8) != 0 ? null : new Function1<Long, p>() { // from class: com.cupidapp.live.base.recyclerview.FKLoopScrollLayout$startPageTurning$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Long l10) {
                invoke(l10.longValue());
                return p.f51048a;
            }

            public final void invoke(long j10) {
                if (FKLoopScrollLayout.this.isShown()) {
                    ViewPager2 viewPager = FKLoopScrollLayout.this.getViewPager();
                    viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                }
            }
        });
    }

    @Override // com.cupidapp.live.base.view.BaseLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        p();
    }

    @j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull StartOrStopScrollEvent event) {
        s.i(event, "event");
        if (event.getStop()) {
            p();
        } else {
            o();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(@Nullable MotionEvent motionEvent) {
        Integer valueOf = motionEvent != null ? Integer.valueOf(motionEvent.getAction()) : null;
        if (valueOf != null && valueOf.intValue() == 0) {
            this.f12042d = motionEvent.getX();
            this.f12043e = motionEvent.getY();
        } else if (valueOf != null && valueOf.intValue() == 2) {
            if (Math.abs(motionEvent.getX() - this.f12042d) > Math.abs(motionEvent.getY() - this.f12043e)) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public final void p() {
        i iVar = this.f12046h;
        if (iVar != null) {
            iVar.g();
        }
        this.f12046h = null;
    }

    public final void setViewPager(@NotNull ViewPager2 viewPager2) {
        s.i(viewPager2, "<set-?>");
        this.f12044f = viewPager2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLoopScrollLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f12049k = new LinkedHashMap();
        this.f12045g = 360000000L;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLoopScrollLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f12049k = new LinkedHashMap();
        this.f12045g = 360000000L;
    }
}
