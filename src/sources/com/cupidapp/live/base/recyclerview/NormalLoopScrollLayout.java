package com.cupidapp.live.base.recyclerview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.viewpager2.widget.ViewPager2;
import com.cupidapp.live.base.utils.i;
import com.cupidapp.live.base.view.BaseLayout;
import com.huawei.flexiblelayout.card.FLPNode;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: NormalLoopScrollLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public abstract class NormalLoopScrollLayout extends BaseLayout {

    /* renamed from: d, reason: collision with root package name */
    public float f12055d;

    /* renamed from: e, reason: collision with root package name */
    public float f12056e;

    /* renamed from: f, reason: collision with root package name */
    public ViewPager2 f12057f;

    /* renamed from: g, reason: collision with root package name */
    public final long f12058g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public i f12059h;

    /* renamed from: i, reason: collision with root package name */
    public int f12060i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f12061j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f12062k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f12063l;

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f12064m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NormalLoopScrollLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f12064m = new LinkedHashMap();
        this.f12058g = 360000000L;
    }

    public static final boolean p(View view, NormalLoopScrollLayout this$0, View view2, MotionEvent motionEvent) {
        s.i(this$0, "this$0");
        view.performClick();
        int action = motionEvent.getAction();
        if (action != 1) {
            if (action == 2) {
                this$0.r();
                return false;
            }
            if (action != 3) {
                return false;
            }
        }
        this$0.q();
        return false;
    }

    @NotNull
    public abstract FKBaseRecyclerViewAdapter getAdapter();

    public abstract long getPagerLife();

    @NotNull
    public final ViewPager2 getViewPager() {
        ViewPager2 viewPager2 = this.f12057f;
        if (viewPager2 != null) {
            return viewPager2;
        }
        s.A(FLPNode.KEY_VIEW_PAGER);
        return null;
    }

    public abstract void m();

    public final void o() {
        m();
        setVisibility(8);
        getViewPager().setAdapter(getAdapter());
        getViewPager().registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.cupidapp.live.base.recyclerview.NormalLoopScrollLayout$initView$1
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageScrollStateChanged(int i10) {
                NormalLoopScrollLayout.this.f12063l = i10 == 1;
            }

            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageScrolled(int i10, float f10, int i11) {
                boolean z10;
                boolean z11;
                boolean z12;
                boolean z13;
                super.onPageScrolled(i10, f10, i11);
                z10 = NormalLoopScrollLayout.this.f12061j;
                if (z10) {
                    z13 = NormalLoopScrollLayout.this.f12063l;
                    if (z13 && i11 == 0) {
                        NormalLoopScrollLayout.this.getViewPager().setCurrentItem(0, false);
                        return;
                    }
                }
                z11 = NormalLoopScrollLayout.this.f12062k;
                if (z11) {
                    z12 = NormalLoopScrollLayout.this.f12063l;
                    if (z12 && i11 == 0) {
                        NormalLoopScrollLayout.this.getViewPager().setCurrentItem(NormalLoopScrollLayout.this.getAdapter().getItemCount() - 1, false);
                    }
                }
            }

            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i10) {
                NormalLoopScrollLayout.this.f12060i = i10;
                NormalLoopScrollLayout normalLoopScrollLayout = NormalLoopScrollLayout.this;
                normalLoopScrollLayout.f12061j = i10 == normalLoopScrollLayout.getAdapter().getItemCount() - 1;
                NormalLoopScrollLayout.this.f12062k = i10 == 0;
            }
        });
        final View childAt = getViewPager().getChildAt(0);
        childAt.setOnTouchListener(new View.OnTouchListener() { // from class: com.cupidapp.live.base.recyclerview.e
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean p10;
                p10 = NormalLoopScrollLayout.p(View.this, this, view, motionEvent);
                return p10;
            }
        });
    }

    @Override // com.cupidapp.live.base.view.BaseLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        r();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(@Nullable MotionEvent motionEvent) {
        Integer valueOf = motionEvent != null ? Integer.valueOf(motionEvent.getAction()) : null;
        if (valueOf != null && valueOf.intValue() == 0) {
            this.f12055d = motionEvent.getX();
            this.f12056e = motionEvent.getY();
        } else if (valueOf != null && valueOf.intValue() == 2) {
            if (Math.abs(motionEvent.getX() - this.f12055d) > Math.abs(motionEvent.getY() - this.f12056e)) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public final void q() {
        r();
        if (getAdapter().j().size() <= 1) {
            return;
        }
        i iVar = new i();
        this.f12059h = iVar;
        iVar.e(this.f12058g, getPagerLife(), (r16 & 4) != 0 ? null : null, (r16 & 8) != 0 ? null : new Function1<Long, p>() { // from class: com.cupidapp.live.base.recyclerview.NormalLoopScrollLayout$startPageTurning$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Long l10) {
                invoke(l10.longValue());
                return p.f51048a;
            }

            public final void invoke(long j10) {
                if (NormalLoopScrollLayout.this.isShown()) {
                    if (NormalLoopScrollLayout.this.getViewPager().getCurrentItem() == NormalLoopScrollLayout.this.getAdapter().getItemCount() - 1) {
                        NormalLoopScrollLayout.this.getViewPager().setCurrentItem(0, false);
                    } else {
                        ViewPager2 viewPager = NormalLoopScrollLayout.this.getViewPager();
                        viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                    }
                }
            }
        });
    }

    public final void r() {
        i iVar = this.f12059h;
        if (iVar != null) {
            iVar.g();
        }
        this.f12059h = null;
    }

    public final void setViewPager(@NotNull ViewPager2 viewPager2) {
        s.i(viewPager2, "<set-?>");
        this.f12057f = viewPager2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NormalLoopScrollLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f12064m = new LinkedHashMap();
        this.f12058g = 360000000L;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NormalLoopScrollLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f12064m = new LinkedHashMap();
        this.f12058g = 360000000L;
    }
}
