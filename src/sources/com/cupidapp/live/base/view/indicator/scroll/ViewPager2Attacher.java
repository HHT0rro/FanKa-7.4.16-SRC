package com.cupidapp.live.base.view.indicator.scroll;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ViewPager2Attacher.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ViewPager2Attacher extends a<ViewPager2> {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public RecyclerView.AdapterDataObserver f12823a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public RecyclerView.Adapter<?> f12824b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public ViewPager2.OnPageChangeCallback f12825c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public ViewPager2 f12826d;

    @Override // com.cupidapp.live.base.view.indicator.scroll.ScrollingPagerIndicator.a
    public void a() {
        ViewPager2 viewPager2;
        RecyclerView.Adapter<?> adapter;
        RecyclerView.AdapterDataObserver adapterDataObserver = this.f12823a;
        if (adapterDataObserver != null && (adapter = this.f12824b) != null) {
            adapter.unregisterAdapterDataObserver(adapterDataObserver);
        }
        ViewPager2.OnPageChangeCallback onPageChangeCallback = this.f12825c;
        if (onPageChangeCallback == null || (viewPager2 = this.f12826d) == null) {
            return;
        }
        viewPager2.unregisterOnPageChangeCallback(onPageChangeCallback);
    }

    @Override // com.cupidapp.live.base.view.indicator.scroll.ScrollingPagerIndicator.a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void b(@NotNull final ScrollingPagerIndicator indicator, @NotNull ViewPager2 pager) {
        s.i(indicator, "indicator");
        s.i(pager, "pager");
        RecyclerView.Adapter<?> adapter = pager.getAdapter();
        this.f12824b = adapter;
        if (adapter != null) {
            this.f12826d = pager;
            f(indicator);
            RecyclerView.AdapterDataObserver adapterDataObserver = new RecyclerView.AdapterDataObserver() { // from class: com.cupidapp.live.base.view.indicator.scroll.ViewPager2Attacher$attachToPager$2
                @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
                public void onChanged() {
                    ScrollingPagerIndicator.this.q();
                }
            };
            this.f12823a = adapterDataObserver;
            RecyclerView.Adapter<?> adapter2 = this.f12824b;
            if (adapter2 != null) {
                s.f(adapterDataObserver);
                adapter2.registerAdapterDataObserver(adapterDataObserver);
            }
            ViewPager2.OnPageChangeCallback onPageChangeCallback = new ViewPager2.OnPageChangeCallback() { // from class: com.cupidapp.live.base.view.indicator.scroll.ViewPager2Attacher$attachToPager$3

                /* renamed from: a, reason: collision with root package name */
                public boolean f12828a = true;

                @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
                public void onPageScrollStateChanged(int i10) {
                    this.f12828a = i10 == 0;
                }

                @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
                public void onPageScrolled(int i10, float f10, int i11) {
                    ViewPager2Attacher.this.c(indicator, i10, f10);
                }

                @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
                public void onPageSelected(int i10) {
                    if (this.f12828a) {
                        ViewPager2Attacher.this.f(indicator);
                    }
                }
            };
            this.f12825c = onPageChangeCallback;
            s.g(onPageChangeCallback, "null cannot be cast to non-null type androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback");
            pager.registerOnPageChangeCallback(onPageChangeCallback);
            return;
        }
        throw new IllegalStateException("需要先设置adapter再调用attachToPager() method".toString());
    }

    public final void f(ScrollingPagerIndicator scrollingPagerIndicator) {
        RecyclerView.Adapter<?> adapter = this.f12824b;
        scrollingPagerIndicator.setDotCount(adapter != null ? adapter.getItemCount() : 0);
        ViewPager2 viewPager2 = this.f12826d;
        scrollingPagerIndicator.setCurrentPosition(viewPager2 != null ? viewPager2.getCurrentItem() : 0);
    }
}
